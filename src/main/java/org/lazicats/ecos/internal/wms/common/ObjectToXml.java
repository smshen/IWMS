package org.lazicats.ecos.internal.wms.common;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lazicats.ecos.internal.wms.consts.OrderType;
import org.lazicats.ecos.internal.wms.dao.SerialNumberDao;
import org.lazicats.ecos.internal.wms.model.Classify;
import org.lazicats.ecos.internal.wms.model.Commodity;
import org.lazicats.ecos.internal.wms.model.PreStackInDetails;
import org.lazicats.ecos.internal.wms.model.PreStackInOrder;
import org.lazicats.ecos.internal.wms.model.PreStackOutDetails;
import org.lazicats.ecos.internal.wms.model.PreStackOutOrder;
import org.lazicats.ecos.internal.wms.model.SKU;
import org.lazicats.ecos.internal.wms.model.Trader;
import org.springframework.stereotype.Component;

@Component
public class ObjectToXml {
	/**
	 * 获取取消订单的xml数据
	 * 
	 * @param orderN
	 *            订单标号
	 * @return
	 */
	
	private Logger logger = Logger.getLogger(ObjectToXml.class);
	@Resource
	private SerialNumberDao serialNumberDao;
	public synchronized String getCancelOrderXml(String orderN) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_DELSO\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row ");
		sb.append(" EDIS_DELSO_SEQID=" + "\""+ serialNumberDao.findSerialNumberByName("EDIS_DELSO_SEQID")+ "\"");
		sb.append(" EDIS_DOCID=" + "\"" + orderN + "\"");
		sb.append(" EDIS_DOCTYPE=" + "\"" + "1" + "\"");
		sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");
		sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

	public synchronized String getCancelOrderComXml(List<PreStackOutOrder> orders) throws Exception{
		return this.getPreStackOutXml(orders);
	}

	/**
	 * 获取入库的xml数据
	 * 
	 * @param order
	 * @return
	 */
	public synchronized String getPreStackInXml (PreStackInOrder order) throws Exception

	{   
	  
		StringBuffer sb = new StringBuffer();
		if (order != null && order.getDetails() != null
				&& order.getDetails().size() > 0) {
			sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			sb.append("<datapacket wsid=\"EDIS_FETCH\" errcode=\"\" errmsg=\"\">");
			sb.append("<rowdata>");

			for (int i = 0; i < order.getDetails().size(); i++) {
				PreStackInDetails details = order.getDetails().get(i);
				sb.append(" <row");
				sb.append(" EDIS_FETCH_SEQID=" + "\""+ serialNumberDao.findSerialNumberByName("EDIS_FETCH_SEQID")+ "\"");// 编号
				sb.append(" EDIS_FETCHID=" + "\"" + order.getNumber() + "\"");// 入库单编号
				sb.append(" EDIS_RGCOMPANYID=" + "\"" + order.getSourceNumber()+ "\"");// 来源单号
				sb.append(" EDIS_RGTYPE=" + "\"" + order.getType() + "\"");// 单据类型  // 1、采购进货 // 2、销售退货 // 5、调拨入库 // 10、销售换货															
				sb.append(" EDIS_DEALMODEL=" + "\"" + order.getDealModel()+ "\"");// 经销模式1、 购销 2、代销
				sb.append(" EDIS_WARID="+"\""+order.getStockNumber()+"\"");//仓库编号
				if(null==order.getOrderDate()){
					sb.append(" EDIS_CREDATE="+ "\""+""+ "\"");// 单据制作日期
				}else{
					sb.append(" EDIS_CREDATE="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "\"");// 单据制作日期
				}
				sb.append(" EDIS_CREMANID=" + "\"" + order.getCreatedByNumber()+ "\"");// 制作人ID (工号)
				if (("").equals(order.getCreatedByName())||null==order.getCreatedByName()) {
					order.setCreatedByName("系统处理");
				}
				
				sb.append(" EDIS_CREMANNAME=" + "\"" + order.getCreatedByName()+ "\"");// 制作人
				if(null==order.getArrivalDate()){
					sb.append(" EDIS_ANTICIPATE="+ "\""+ ""+ "\"");// 预计到货日期
				}else{
					sb.append(" EDIS_ANTICIPATE="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getArrivalDate()) + "\"");// 预计到货日期
				}
				sb.append(" EDIS_TRANSFLAG=" + "\"" + "0" + "\"");// 运输标志
				sb.append(" EDIS_MEMO=" + "\"" + escapeCharacters(order.getDescription()) + "\"");// 备注
				sb.append(" EDIS_FETCHDTLID=" + "\"" + details.getNumber()+ "\"");// 收货通知细单标识
				sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");// 货主
				sb.append(" EDIS_GOODSID=" + "\""+ details.getCommodityNumber() + "\"");// 商品ID
				sb.append(" EDIS_SKUID=" + "\"" + details.getSkuNumber()+ "\"");// SKUID
				sb.append(" EDIS_LOTNO=" + "\"" + "-" + "\"");// 批号(为空)
				sb.append(" EDIS_PRODDATE=" + "\"" + "2013-09-24 00:00:00"+ "\"");// 生产日期(为空)
				sb.append(" EDIS_INVALIDDATE=" + "\"" +"" + "\"");// 失效日期(为空)
				sb.append(" EDIS_VALIDTO=" + "\"" + "2050-01-01 00:00:00" + "\"");// 有效期至(为空)
				sb.append(" EDIS_ORDERRGQTY=" + "\"" + details.getQuantity()+ "\"");// 订货数量
				sb.append(" EDIS_URGENTFLAG=" + "\"" + details.getUrgentLogo()+ "\"");// 加急标志 0 普通 1 加急 2 紧急
				sb.append(" EDIS_DTLMEMO=" + "\"" + escapeCharacters(details.getDecription())+ "\"");// 细单备注
				sb.append(" EDIS_FETCHSTATUS=" + "\"" + "2" + "\"");// 收货通知总单状态
				sb.append(" EDIS_FETCHDTLSTATUS=" + "\"" + "2" + "\"");// 收货通知细单状态
				sb.append(" EDIS_UNITPRICE=" + "\"" + details.getPrice()+ "\"");// 单价(采购为成本价，两位小数)
				sb.append(" EDIS_TOTAL_LINE=" + "\"" + new java.text.DecimalFormat("0.00").format(details.getQuantity()* details.getPrice()) + "\"");// 金额(两位小数)
				sb.append(" EDIS_BATCHID="+"\""+details.getBatchNumber()+"\"");//批次号
				sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");// 接口数据时间
				/**
				 * 新添加的
				 */
				if(details.getUnPrice()==null){
					sb.append(" EDIS_NOTAXPRICE="+ "\""+ 0.00+ "\"");// 不含税成本价
				}else{
					
					sb.append(" EDIS_NOTAXPRICE="+ "\""+ details.getUnPrice()+ "\"");// 不含税成本价
				}
				sb.append(" />");
			}
			
		}
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

	public synchronized String getPreStackOutXml(List<PreStackOutOrder> orders) throws Exception{
		StringBuffer sb = new StringBuffer();
		if(orders==null || orders.size()<1){
			return sb.toString();
		}
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_SO\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		for(PreStackOutOrder order:orders){
			if (order == null || order.getDetails() == null || order.getDetails().size() <= 0) {
				continue;
			}
			for (int i = 0; i < order.getDetails().size(); i++) {
				PreStackOutDetails details = order.getDetails().get(i);
				sb.append(" <row");
				sb.append(" EDIS_SO_SEQID=" + "\""+ serialNumberDao.findSerialNumberByName("EDIS_SO_SEQID") + "\"");
				sb.append(" EDIS_SOID=" + "\"" + order.getNumber() + "\"");// 订单总单标识// 出货单编号
				sb.append(" EDIS_SOTYPE=" + "\"" + order.getType() + "\"");// 类型   1、销售出库  2、采购退货   5、调拨出库 10、销售换货// 会员名称，供应商名称
				sb.append(" EDIS_SOCOMPANYNAME="+"\""+order.getSourceName()+"\"");//客户名称
				sb.append(" EDIS_SOCOMPANYID="+"\""+order.getSourceNumber()+"\"");//客户  //供应商id	
				sb.append(" EDIS_WARID="+"\""+order.getStockNumber()+"\"");//仓库ID
				sb.append(" EDIS_SOPOSID="+"\""+escapeCharacters(order.getDeliveryAddressN())+"\"");//送货地址ID
			    sb.append(" EDIS_SOPOS="+"\""+escapeCharacters(order.getDeliveryAddressInfo())+"\"");//送货地址			
				sb.append(" EDIS_TRANSITID="+"\""+order.getWaybillNumber()+"\"");//承运商ID
				sb.append(" EDIS_TRANSITNAME="+"\""+order.getWaybillName()+"\"");//承运商名称
				sb.append(" EDIS_SODATE="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrderDate()) + "\"");// 订单日期
				sb.append(" EDIS_DELIVERTYPE=" + "\"" + order.getDeliveryType()+ "\"");// 发货方式 N10 1、 送货 2、 自提
				sb.append(" EDIS_TRANSPORTMODE=" + "\""+ order.getTransportMode() + "\"");// 运输方式
				sb.append(" EDIS_URGENTFLAG=" + "\"" + order.getUrgentFlag()+ "\"");// 加急标志 0 普通 1 加急 2 紧急
				sb.append(" EDIS_UNAIRFLAG=" + "\"" + order.getUnairFlag()+ "\"");// 禁航标志
				sb.append(" EDIS_MEMO=" + "\"" + escapeCharacters(order.getOrderNumber()) + "\"");// 备注
				sb.append(" EDIS_SOSTATUS=" + "\"" + "1" + "\"");// 总单状态
				sb.append(" EDIS_CREMANID=" + "\"" + order.getCreatedByNumber()+ "\"");// 制作人ID
				if (("").equals(order.getCreatedByName())||null==order.getCreatedByName()) {
					order.setCreatedByName("系统处理");
				}
				sb.append(" EDIS_CREMANNAME=" + "\"" + order.getCreatedByName()+ "\"");// 制作人
				sb.append(" EDIS_SOINOUTTYPE=" + "\"" + order.getDeliveryType() + "\"");// 出库类型
				sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");// 货主
				sb.append(" EDIS_SOINFO=" + "\"" +replace(order.getOrderInfo()) + "\"");// 总单信息
				sb.append(" EDIS_SOSOURCE=" + "\"" + order.getSoSource()+ "\"");// 来源 1：淘宝 2：商城
				sb.append(" EDIS_CODFLAG=" + "\"" + order.getCodFlag() + "\"");// 货到付款标志 // 0、不是货到付款 // 1、货到付款
				sb.append(" EDIS_SODTLID=" + "\"" + details.getNumber() + "\"");// 订单细单标识
				sb.append(" EDIS_GOODSID=" + "\""+ details.getCommodityNumber() + "\"");// 商品ID
				sb.append(" EDIS_SKUID=" + "\"" + details.getSkuNumber()+ "\"");// SKUID
				sb.append(" EDIS_BATCHID="+"\""+details.getBatchNumber()+"\"");//批次号
				sb.append(" EDIS_UNITPRICE=" + "\"" + details.getPrice()+ "\"");// 单价
				sb.append(" EDIS_TOTAL_LINE=" + "\"" + new java.text.DecimalFormat("0.00").format(details.getQuantity()* details.getPrice())  + "\"");// 金额
				sb.append(" EDIS_SOQTY=" + "\"" + details.getQuantity() + "\"");// 数量
				sb.append(" EDIS_GOODSUNIT=" + "\"" + details.getUnit() + "\"");// 商品基本单位
				sb.append(" EDIS_SODTLSTATUS=" + "\"" + "1" + "\"");// 细单状态
				if (details.getOrgPrice() == null) {
					details.setOrgPrice(1.0);
				}
				sb.append(" EDIS_ORGPRICE=" + "\"" + details.getOrgPrice()+ "\"");// 原价
				sb.append(" EDIS_DTLMEMO=" + "\"" + escapeCharacters(details.getDescription())+ "\"");// 细单备注
				sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");// 接口数据时间
				
				
				/**
				 * 新添加的
				 */
				
				if(details.getUnCostPrice()==null){
					sb.append(" EDIS_NOTAXPRICE="+ "\""+ 0.00 + "\"");// 不含税成本价
				}else{
				sb.append(" EDIS_NOTAXPRICE="+ "\""+ details.getUnCostPrice() + "\"");// 不含税成本价
				}
				sb.append(" EDIS_PARCELNO="+"\""+order.getParcelno()+"\"");    //包裹号
				sb.append(" EDIS_HASWAITIN="+"\""+details.getIsVirtualStock()+ "\"");  //是否是虚库
				sb.append(" />");
			}
		}
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

  private String escapeCharacters(String str) {
    if(str == null)return str;
    
    return str.replace("&", "&amp;").replace("<", "&lt;");
  }

	public synchronized String getCommodityXml(Commodity commodity) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_GOODS\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row ");
		sb.append(" EDIS_GOODS_SEQID=" + "\""+ serialNumberDao.findSerialNumberByName("EDIS_GOODS_SEQID") + "\"");// 流水号
		sb.append(" EDIS_GOODSID=" + "\"" + commodity.getNumber() + "\"");// 商品ID // ERP商品ID
		sb.append(" EDIS_GOODSCODE=" + "\"" + commodity.getNumber() + "\"");// 商品编号 // 商品编号，唯一				
		sb.append(" EDIS_GOODSNAME=" + "\"" + this.replace(commodity.getName()) + "\"");// 商品名称
		sb.append(" EDIS_GOODSPY=" + "\"" + commodity.getAlphabetical() + "\"");// 商品拼音
		sb.append(" EDIS_GOODSUNIT=" + "\"" + commodity.getUnit() + "\"");// 商品基本单位
		sb.append(" EDIS_PRODAREA=" + "\"" + commodity.getProductionPlace()+ "\"");// 产地
		sb.append(" EDIS_GOODSPROP=" + "\"" + commodity.getClassifyNumber()+ "\"");// 分类(三级) 商品分类
		sb.append(" EDIS_VALIDPERIOD=" + "\"" + commodity.getEffectiveTime()+ "\"");// 有效期（保质期） 单位：月
		sb.append(" EDIS_FACTDOCNO=" + "\"" + commodity.getSupplierName()+ "\"");// 生产厂家
		sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");// 货主
		sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");// 接口数据时间
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

	public synchronized String getSKUXml(SKU sku) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_SKU\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row");
		sb.append(" EDIS_SKU_SEQID=" + "\"" + serialNumberDao.findSerialNumberByName("EDIS_SKU_SEQID")+ "\"");// 流水号
		sb.append(" EDIS_SKUID=" + "\"" + sku.getNumber() + "\"");// SKUID
		sb.append(" EDIS_GOODSID=" + "\"" + sku.getCommodityNumber() + "\"");// 商品ID
		sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");// 货主
		sb.append(" EDIS_SKUNAME=" + "\"" +this.replace(sku.getName())  + "\"");// SKU名称
		sb.append(" EDIS_GOODSTYPE=" + "\"" + sku.getSpec() + "\"");// 规格
		sb.append(" EDIS_COLOR=" + "\"" + sku.getColor() + "\"");// 颜色
		sb.append(" EDIS_MODEL=" + "\"" + sku.getSize() + "\"");// 尺码
		sb.append(" EDIS_BARCODE=" + "\"" + sku.getBarcode() + "\"");// 条码
		sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");// 接口数据时间	
		sb.append(" EDIS_SKUSTATUS="+ "\""+ sku.getProdStatus() + "\"");// sku是否被禁用
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

	public synchronized String getTraderXml(Trader trader) throws Exception{
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_COM\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row");	
		sb.append(" EDIS_COM_SEQID=" + "\"" + serialNumberDao.findSerialNumberByName("EDIS_COM_SEQID")+ "\"");// 流水号
		sb.append(" EDIS_COMPANYID=" + "\"" + trader.getNumber() + "\"");// ERP单位ID(供应商ID、承运商ID)
		sb.append(" EDIS_COMPANYOPCODE=" + "\"" + trader.getNumber() + "\"");// 单位编号
		sb.append(" EDIS_COMPANYPY=" + "\"" + trader.getAlphabetical() + "\"");// 单位拼音
		sb.append(" EDIS_COMPANYNAME=" + "\"" + trader.getName() + "\"");// 单位名称
		sb.append(" EDIS_COMPANYSHORTNAME=" + "\"" + trader.getShortName()+ "\"");// 单位简称
		sb.append(" EDIS_COMPANYTYPE=" + "\"" + trader.getType() + "\"");// 单位类型   2:供应商  5:承运商 4:仓库
		sb.append(" EDIS_TAXNAMBER=" + "\"" + "" + "\"");// 税号
		sb.append(" EDIS_LEGALPERSION=" + "\"" + "" + "\"");// 法人代表
		sb.append(" EDIS_COMPANYZONE=" + "\"" + trader.getZone() + "\"");// 地区
		sb.append(" EDIS_ADDRESS=" + "\"" + trader.getAddress() + "\"");// 地址
		sb.append(" EDIS_POSTCODE=" + "\"" + trader.getPostCode() + "\"");// 邮编
		sb.append(" EDIS_LINKMAN=" + "\"" + trader.getContract() + "\"");// 联系人
		sb.append(" EDIS_LIANTEL=" + "\"" + trader.getTel() + "\"");// 联系电话
		sb.append(" EDIS_MODIE=" + "\"" + trader.getPhone() + "\"");// 手机
		sb.append(" EDIS_FAX=" + "\"" + trader.getFax() + "\"");// 传真
		sb.append(" EDIS_USESTATUS=" + "\"" + trader.getStatus() + "\"");// 使用状态
		sb.append(" EDIS_CONSIGNOR=" + "\"" + "888888" + "\"");// 货主
		sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");// 接口数据时间
		sb.append(" EDIS_MONTHLYACCOUNT=" + "\"" + trader.getMonthlYaccount()+ "\"");// 月结账号
		sb.append(" EDIS_MONTHLYNO=" + "\"" + trader.getMonthLyno() + "\"");// 月结号
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}

	public synchronized String getClassifyXml(Classify classify) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_GROUP\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row");
		sb.append(" EDIS_GROUP_SEQID=" + "\""+ serialNumberDao.findSerialNumberByName("EDIS_GROUP_SEQID")+ "\"");
		sb.append(" EDIS_GROUPID=" + "\"" + classify.getNumber() + "\"");
		sb.append(" EDIS_GROUPNAME=" + "\"" + classify.getName() + "\"");
		/**
		 *前端传过来的是一级的父id是0 wms一级的是-1 所以转换一下
		 */
		String str = classify.getParentNumber();
		if ("0".equals(str)) {
			str = "-1";
		}
		logger.info("父级分类：" + str);
		sb.append(" EDIS_PGROUPID=" + "\"" + str + "\"");
		sb.append(" IMP_STARTTIME="+ "\""+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\"");
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}
	
	/**
	 * 获取收货确认请求xml。
	 * @param orderN
	 * @param orderType
	 * @param consignor
	 * @return
	 * @throws Exception
	 */
	public synchronized String getReceiveConfirmationXml(
			String orderN,OrderType orderType,String consignor) throws Exception {
		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		sb.append("<datapacket wsid=\"EDIS_commitdelivery\" errcode=\"\" errmsg=\"\">");
		sb.append("<rowdata>");
		sb.append("<row ");
		sb.append(" EDIS_SOID=" + "\""+ orderN + "\"");
		sb.append(" EDIS_SOTYPE=" + "\"" + orderType.code() + "\"");
		sb.append(" EDIS_CONSIGNOR=" + "\"" + consignor + "\"");
		sb.append(" />");
		sb.append("</rowdata>");
		sb.append("</datapacket>");
		return sb.toString();
	}
	
	/**
	 * 去掉商品名称和sku名称里面的特殊字符
	 * @param name
	 * @return
	 */
	private  String replace(String name) throws Exception{
		
		if(name.contains("&")){
			name =name.replaceAll("&", "&amp;");
		}
		if(name.contains("<")){
			name =name.replaceAll("<", "&lt;");
		}
		if(name.contains(">")){
			name =name.replaceAll(">", "&gt;");
		}
		if(name.contains("\"")){
			name =name.replaceAll("\"", "&quot;");
		}
		if(name.contains("'")){
			name =name.replaceAll("'", "&apos;");
		}
		
		return name;
		
	}
	
	
	
}
