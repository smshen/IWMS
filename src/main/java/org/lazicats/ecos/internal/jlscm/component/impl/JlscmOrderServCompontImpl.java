package org.lazicats.ecos.internal.jlscm.component.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.JsonUtils;
import org.lazicats.ecos.internal.jlscm.common.CommonJlscmConstant;
import org.lazicats.ecos.internal.jlscm.common.JlscmOrderConstant;
import org.lazicats.ecos.internal.jlscm.component.IJlscmOrderServComponet;
import org.lazicats.ecos.internal.jlscm.model.EsOrder;
import org.lazicats.ecos.internal.jlscm.model.JlRefundList;
import org.lazicats.ecos.internal.jlscm.model.RefundEsOrder;
import org.lazicats.ecos.internal.utils.HttpClientUtils;
import org.lazicats.ecos.internal.utils.HttpRequestProxy;
import org.springframework.stereotype.Service;

/**
 * @FileName JlscmOrderImpl.java
 * @PackageName org.lazicats.ecos.internal.jlscm.compent.impl
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午6:50:23
 * 
 */
@Service
public class JlscmOrderServCompontImpl extends HttpClientUtils implements IJlscmOrderServComponet {
	
	private Logger logger = Logger.getLogger(IJlscmOrderServComponet.class);
	@Resource
    private HttpRequestProxy httpRequestProxy;
	@Override
	public String pushJlscmOrder(EsOrder esOrder) throws Exception {
	    if(esOrder.getOrderId().length()<16){
	      return null;
	    }
	    
	    if(esOrder.getReceiver_Zip() == null || esOrder.getReceiver_Zip().isEmpty()){
	      return null;
	    }
		// TODO Auto-generated method stub
		logger.info("推送订单封装参数--begin");
		Map<String,Object> map=JlscmOrderConstant.getOrderTradeParms(esOrder);
		logger.info("推送订单封装参数--end");
		if(logger.isInfoEnabled()){
		  //logger.info("htpp请求开始"+CommonJlscmConstant.clientUrl+JsonUtils.toJson(map));
		}
		String content=null;
		try{   
		   String url= HttpClientUtils.urlParamSet(CommonJlscmConstant.clientUrl+"?", map);
		   content= HttpClientUtils.httpPost(CommonJlscmConstant.clientUrl, map);//HttpClientUtils.httpGet(url);
				   
		   System.out.println(content);
		   if(StringUtils.isEmpty(content)){
			   logger.error("请求pushJlscmOrder失败:请求服务开启");
			   content="{'JL_State':0,'OrdeId':'','error:请求服务开启'}";
		   }else if(content.indexOf("error")==0){
			   logger.error("请求pushJlscmOrder失败"+content);
			   content="{'JL_State':0,'OrdeId':'','error:"+content+"'}";
		   }else{
			   logger.info("htpp请求成功");
		   }
		}catch(Exception e){
			e.printStackTrace();
			logger.error("请求pushJlscmOrder失败"+e.getMessage(),e);
			content="{'JL_State':0,'OrdeId':''}";
		}
		logger.info("金力返回结果成功："+content);
		return content;
	}
    
	@Override
	public String cancelJlscmOrder(JlRefundList jlRefundList) throws Exception {
		if(jlRefundList ==null || StringUtils.isEmpty(jlRefundList.getOrderNo())){
			logger.error("取消订单cancelJlscmOrder:orderNO参数不能为空");
			throw new Exception("取消订单cancelJlscmOrder:orderNO参数不能为空");
		}
		// TODO Auto-generated method stub
		logger.info("取消订单封装参数--begin");
		Map<String,Object> map=JlscmOrderConstant.getCancelOrderParms(jlRefundList);
		logger.info("取消订单封装参数--end");
		String content=null;
		try{
		   String url= HttpClientUtils.urlParamPac(CommonJlscmConstant.clientUrl+"?", map);
		   content= HttpClientUtils.httpPost(CommonJlscmConstant.clientUrl, map);//HttpClientUtils.httpGet(url);
		   if(StringUtils.isEmpty(content)){
			   logger.error("请求cancelJlscmOrder失败:请求服务开启");
			   content="{'JL_State':0,'OrdeId':'','error:请求服务开启'}";
		   }else if(content.indexOf("error")==0){
			   logger.error("请求cancelJlscmOrder失败"+content);
			   content="{'JL_State':0,'OrdeId':'','error:"+content+"'}";
			}else{
			   logger.info("htpp请求成功");
			}  
		}catch(Exception e){
			e.printStackTrace();
			logger.error("请求cancelJlscmOrder失败"+e.getMessage(),e);
			content="{'JL_State':0,'OrdeId':''}";
		}
		logger.info("金力返回结果成功："+content);
		return content;
	}

	@Override
	public String refundJlscmOrder(RefundEsOrder refundEsOrder)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("退货单封装参数--begin");
		Map<String,Object> map=JlscmOrderConstant.getRefundOrderParms(refundEsOrder);
		logger.info("退货单封装参数--end");
		String content= null;
		try{
			String url= HttpClientUtils.urlParamPac(CommonJlscmConstant.clientUrl+"?", map);
			logger.info("url="+url);
			content=HttpClientUtils.httpPost(CommonJlscmConstant.clientUrl, map);// HttpClientUtils.httpGet(url);
			if(StringUtils.isEmpty(content)){
				   logger.error("请求refundJlscmOrder失败:请求服务开启");
				   content="{'JL_State':0,'OrdeId':'','error:请求服务开启'}";
			 }else if(content.indexOf("error")==0){
				   logger.error("请求refundJlscmOrder失败"+content);
				   content="{'JL_State':0,'OrdeId':'','error:"+content+"'}";
			 }else{
				   logger.info("htpp请求成功");
			 }
		}catch(Exception e){
			e.printStackTrace();
			logger.error("请求refundJlscmOrder失败"+e.getMessage(),e);
			content="{'JL_State':0,'OrdeId':''}";
		}
	    logger.info("金力返回结果成功："+content);
		return content;
	}

}
