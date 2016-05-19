package org.lazicats.ecos.internal.jlscm.component;

import org.lazicats.ecos.internal.jlscm.model.EsOrder;
import org.lazicats.ecos.internal.jlscm.model.JlRefundList;
import org.lazicats.ecos.internal.jlscm.model.RefundEsOrder;

/**
 * @FileName IJlscmOrder.java
 * @PackageName org.lazicats.ecos.internal.jlscm.compent
 * @功能 
 *
 * @author MingJun_Guo
 * @创建日期：2014-1-8下午6:50:01
 * 
 */
public interface IJlscmOrderServComponet {
	
	/**
	 * 推送订单到金力
	 * @param esOrder
	 * @return json:数据JL_State[0失败 1成功]
	 * @throws Exception
	 */
	public String pushJlscmOrder(EsOrder esOrder)throws Exception;
	
	
	/**
	 * 退款单到金力
	 * @param refundEsOrder
	 * @return json:数据JL_State[0失败 1成功]
	 * @throws Exception
	 */
	public String refundJlscmOrder(RefundEsOrder refundEsOrder)throws Exception;

	String cancelJlscmOrder(JlRefundList jlRefundList) throws Exception;

}
