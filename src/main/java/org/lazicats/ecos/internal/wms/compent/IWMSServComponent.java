
package org.lazicats.ecos.internal.wms.compent;

import java.util.List;

import org.lazicats.ecos.internal.wms.consts.OrderType;
import org.lazicats.ecos.internal.wms.model.*;

/**
 * WMS接口（对内）
 * @author 肖锋 2
 *
 */
public interface IWMSServComponent {
	/**
	 * 添加单位信息
	 * @param trader
	 * @return
	 */
	public Message addTrader(Trader trader);
	
	/**
	 * 修改单位信息
	 * @param trader
	 * @return
	 */
	public Message updateTrader(Trader trader);
	
	/**
	 * 删除单位信息
	 * @param traderN 单位编号
	 * @return
	 */
	public Message delTrader(Trader trader);
	
	/**
	 * 添加商品
	 * @param commondity
	 * @return
	 */
	public Message addCommodity(Commodity commondity);
	
	/**
	 * 修改商品
	 * @param commondity
	 * @return
	 */
	public Message updateCommodity(Commodity commondity);
	
	/**
	 * 删除商品
	 * @param commodity
	 * @return
	 */
	public Message delCommodity(Commodity commodity);
	
	/**
	 * 添加SKU
	 * @param sku
	 * @return
	 */
	public Message addSKU(SKU sku);
	
	/**
	 *修改SKU
	 * @param sku
	 * @return
	 */
	public Message updateSKU(SKU sku);
	
	/**
	 * 删除SKU
	 * @param sku
	 * @return
	 */
	public Message delSKU(SKU sku);
	
	/**
	 * 添加分类
	 * @param calssify
	 * @return
	 */
	public Message addClassify(Classify calssify);
	
	/**
	 * 修改分类
	 * @param classify
	 * @return
	 */
	public Message updateClassify(Classify classify);
	
	/**
	 * 删除分类
	 * @param classify
	 * @return
	 */
	public Message delClassify(Classify classify);
	
	/**
	 * 预入库
	 * @param order
	 * @return
	 */
	public Message preStackIn(PreStackInOrder order);
	
	/**
	 * 预出库
	 * @param order
	 * @return
	 */
	public Message preStackOut(List<PreStackOutOrder> orders);
	
	/**
	 * 取消预出库单（对应取消订单）
	 * @param orderN
	 * @return
	 */
	public Message cancelPreStackOut(String orderN);
	
	/**
	 * 重做预出库单（对应取消订单商品）
	 * @param order
	 * @return
	 */
	public Message redoPreStackOut(List<PreStackOutOrder> orders);
	
	/**
	 * 确认收货
	 * @param orderN 订单号
	 * @param orderType 订单类型(1、销售出库 2、采购退货 5、调拨出库 10、销售换货)
	 * @param consignor 货主
	 * @return 
	 */
	Message confirmReceive(String orderN, OrderType orderType,
			String consignor);
}
