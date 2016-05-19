package org.lazicats.ecos.order.service.component;

import java.util.List;

import org.lazicats.ecos.order.service.model.OrderDo;
import org.lazicats.ecos.order.service.model.OrderImportedDo;


public interface IOrderComponent {
	public OrderDo getOrderByOrderNo(String orderNo)throws Exception;
	
	public void updateOrder(OrderDo orderDo)throws Exception;
	
	public OrderDo getOrder(String orderNo)throws Exception;
	
	public List<OrderDo> queryOrder(String account,String state,String date)throws Exception;
	
	/**
	 * 获取跨境订单扩展信息
	 */
	public OrderImportedDo getOrderImported(String orderNo) throws Exception;
	
	/**
	 * 更新跨境订单扩展信息
	 */
	public void updateOrderImported(OrderImportedDo importedDo) throws Exception;
	
	/**
	 * 跨境订单更新发货状态
	 */
	public void modifyDeliveryAlreadyState(String orderNo) throws Exception;
	/**
	 * 根据订单号集合获取跨境订单信息
	 * @param orderNos
	 * @return
	 * @throws Exception
	 */
	public List<OrderImportedDo> getOrderImporteds(List<String> orderNos) throws Exception;

	

}
