package org.lazicats.ecos.internal.jlscm.common;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.lazicats.ecos.basecomponent.utils.JsonUtils;
import org.lazicats.ecos.internal.jlscm.model.EsOrder;
import org.lazicats.ecos.internal.jlscm.model.JlRefundList;
import org.lazicats.ecos.internal.jlscm.model.JlscmSign;
import org.lazicats.ecos.internal.jlscm.model.RefundEsOrder;

/**
 * @FileName JlscmOrdertoJson.java
 * @PackageName org.lazicats.ecos.internal.jlscm.common
 * @功能
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午8:30:42
 * 
 */
public class JlscmOrderConstant {

	public static String scmOrderToJson(EsOrder esOrder) {
		return JsonUtils.toJson(esOrder);
	}

	private static Map<String, Object> getMapLoad(Object type) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("Type", type);
		map.put("UserName", CommonJlscmConstant.userName);
		map.put("PassWord", CommonJlscmConstant.passWord);
		return map;
	}

	public static Map<String, Object> getOrderTradeParms(EsOrder esOrder) {
		if (esOrder == null) {
			return null;
		}
		JlscmSign jlscmSign = new JlscmSign(CommonJlscmConstant.parms,
				CommonJlscmConstant.sign);
		Map<String, Object> map = getMapLoad(CommonJlscmConstant.orderTradeType);
		map.put("SIGNXML", JsonUtils.toJson(jlscmSign));
		map.put(CommonJlscmConstant.parms, JsonUtils.toJson(esOrder));
		return map;
	}

	public static Map<String, Object> getCancelOrderParms(JlRefundList jlRefundList) {
		if (StringUtils.isEmpty(jlRefundList.getOrderNo())) {
			return null;
		}

		JlscmSign jlscmSign = new JlscmSign(CommonJlscmConstant.parms,
				CommonJlscmConstant.sign);
		Map map = getMapLoad(CommonJlscmConstant.cancelOrderType);
		map.put("SIGNXML", JsonUtils.toJson(jlscmSign));
		String param = JsonUtils.toJson(jlRefundList);

		String tempParam = ",'OrderId': '" + jlRefundList.getOrderNo()
				+ "','SysTemCon':'1'}";
		if ((param != null) && (param.length() > 1)) {
			param = param.substring(0, param.length() - 1) + tempParam;
		}
		map.put(CommonJlscmConstant.parms, param);
		return map;
	}

	public static Map<String, Object> getRefundOrderParms(
			RefundEsOrder refundEsOrder) {
		if (refundEsOrder == null) {
			return null;
		}
		JlscmSign jlscmSign = new JlscmSign(CommonJlscmConstant.parms,
				CommonJlscmConstant.sign);
		Map<String, Object> map = getMapLoad(CommonJlscmConstant.refundOrderType);
		map.put("SIGNXML", JsonUtils.toJson(jlscmSign));
		map.put(CommonJlscmConstant.parms, JsonUtils.toJson(refundEsOrder));
		return map;
	}

}
