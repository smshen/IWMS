package org.lazicats.ecos.internal.payment.common.Unionpay;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.vo.QueryOrderMessage;

/**
 * 
 * @FileName QuickPayQuery.java
 * @PackageName org.lazicats.ecos.internal.payment.common.Unionpay
 * @功能
 * 
 * @author MingJun_Guo
 * @创建日期：2013-12-16下午2:55:55
 * 
 */
public class UnionPayQuery {
	
	private static final Logger log = Logger.getLogger(UnionPayQuery.class);

//	public static void main(String[] aa) {
//		new UnionPayQuery().queryTrans("01", "201104181312393",
//				"20110523194505");
//	}

	/**
	 * 查询交易入口
	 * 
	 * @param transType
	 *            交易类型
	 * @param orderNumber
	 *            商户订单号
	 * @param orderTime
	 *            商户订单时间
	 */
	public static QueryOrderMessage queryTrans(String transType, String orderNumber,
			String orderTime) {
		QueryOrderMessage queryOrderMessage = new QueryOrderMessage();
		//写入订单号
		queryOrderMessage.setOrder(orderNumber);
		String res = query(transType, orderNumber, orderTime);
		if (res != null && !"".equals(res)) {

			String[] arr = UnionPayUtils.getResArr(res);
			
			if (checkSecurity(arr)) {// 验证签名
				merBusiness(arr,queryOrderMessage);// 商户业务逻辑
			} else {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("校验签名失败或异常");
			}
		} else {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("报文格式为空");
			log.debug("报文格式为空");
		}
		return queryOrderMessage;
	}

	/**
	 * 向银联发送查询请求
	 * 
	 * @param transType
	 * @param orderNumber
	 * @param orderTime
	 * @return
	 */
	private static String query(String transType, String orderNumber, String orderTime) {
		String[] valueVo = new String[] {
				CommonPayInfo.BankPayInfo.get("unionPay_version"),// 协议版本
				CommonPayInfo.BankPayInfo.get("unionPay_charset"),// 字符编码
				transType,// 交易类型
				CommonPayInfo.BankPayInfo.get("unionPay_merCode"),// 商户代码
				orderNumber,// 订单号
				orderTime,// 交易时间
				""// 保留域
					// 说明：如果是收单机构保留域需传收单代码如：{acqCode=00215800}，商户直接接入upop不传收单代码
		};
		UnionPayUtils unionPayUtils = new UnionPayUtils();
		return unionPayUtils.doPostQueryCmd(CommonPayInfo.BankPayInfo
				.get("unionQuery_url"), new UnionPayUtils().createBackStr(
				valueVo, UnionPayConf.queryVo));

	}

	/**
	 * 验证签名
	 * 
	 * @param arr
	 * @return
	 */
	private static boolean checkSecurity(String[] arr) {
		// 验证签名
		int checkedRes = new UnionPayUtils().checkSecurity(arr);
		if (checkedRes == 1) {
			return true;
		} else if (checkedRes == 0) {
			log.debug("验证签名失败");
			return false;
		} else if (checkedRes == 2) {
			log.debug("报文格式错误");
			return false;
		}
		return false;
	}

	/**
	 * 商户的业务逻辑
	 * 
	 * @param arr
	 */
	private static void merBusiness(String[] arr,QueryOrderMessage queryOrderMessage) {
		/**
		 * queryResult=0或者2时 respCode为00，其余情况下respCode为非全零的两位错误码
		 * queryResult为空时报文格式错误 queryResult： 0：成功（响应码respCode为00）
		 * 1：失败（响应码respCode非00） 2：处理中（响应码respCode为00） 3：无此交易（响应码respCode非00）
		 */
		// 以下是商户业务处理
		String queryResult = "";
		String queryAmount = "";
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			String[] queryResultArr = arr[i].split("=");
			// 处理商户业务逻辑
			if (queryResultArr.length >= 2 && "queryResult".equals(queryResultArr[0])) {
				queryResult = arr[i].substring(queryResultArr[0].length() + 1);
				x+=1;
			}
			if (queryResultArr.length >= 2 && "settleAmount".equals(queryResultArr[0])) {
				queryAmount = arr[i].substring(queryResultArr[0].length() + 1);
				x+=1;
			}
			if(x==2){
				break;
			}
		}
		if (queryResult != "") {
			queryOrderMessage.setAmount(queryAmount);
			if ("0".equals(queryResult)) {
				queryOrderMessage.setSuccess(true);
				log.debug("银联订单查询结果，交易成功");
			}
			if ("1".equals(queryResult)) {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("交易失败");
				log.debug("银联订单查询结果，交易失败");
			}
			if ("2".equals(queryResult)) {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("交易处理中");
				log.debug("银联订单查询结果，交易处理中");
			}
			if ("3".equals(queryResult)) {
				queryOrderMessage.setSuccess(false);
				queryOrderMessage.setMessage("无此交易");
				log.debug("银联订单查询结果，无此交易");
			}
		} else {
			queryOrderMessage.setSuccess(false);
			queryOrderMessage.setMessage("报文格式错误");
			log.debug("银联订单查询结果，报文格式错误");
		}
	}
}
