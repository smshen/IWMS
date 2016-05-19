package org.lazicats.ecos.internal.wms.compent.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.lazicats.ecos.basecomponent.utils.JsonUtils;
import org.lazicats.ecos.commodity.service.model.CommoPropValueDo;
import org.lazicats.ecos.internal.wms.common.Client;
import org.lazicats.ecos.internal.wms.common.ObjectToXml;
import org.lazicats.ecos.internal.wms.compent.IWMSServComponent;
import org.lazicats.ecos.internal.wms.consts.OrderType;
import org.lazicats.ecos.internal.wms.model.Classify;
import org.lazicats.ecos.internal.wms.model.Commodity;
import org.lazicats.ecos.internal.wms.model.Message;
import org.lazicats.ecos.internal.wms.model.PreStackInOrder;
import org.lazicats.ecos.internal.wms.model.PreStackOutOrder;
import org.lazicats.ecos.internal.wms.model.SKU;
import org.lazicats.ecos.internal.wms.model.Trader;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


@Service
public class WmsServComponentImpl implements IWMSServComponent {
	private Logger logger = Logger.getLogger(WmsServComponentImpl.class);
	@Resource
	private ObjectToXml objectToXml;
	@Resource
	private Client client;

	public Message addTrader(Trader trader) {
		logger.info("接收erp输入参数trader:" + trader);
		Message message = new Message();
		try {
			String invokeXml = "";
			if ("001".equals(this.verifyTrader(trader).getCode())) {
				invokeXml = objectToXml.getTraderXml(trader);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyTrader(trader);
			}

		} catch (Exception e) {
			logger.error("调用addTrader出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("addTrader返回结果" + message.getCode() + "\n"
				+ message.getMessage());
		return message;
	}

	public Message updateTrader(Trader trader) {
		logger.info("接收erp输入参数trader:" + trader);
		Message message = new Message();
		try {
			String invokeXml = "";
			if ("001".equals(this.verifyTrader(trader).getCode())) {
				invokeXml = objectToXml.getTraderXml(trader);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyTrader(trader);
			}

		} catch (Exception e) {
			logger.error("调用updateTrader出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("addTrader返回结果" + message.getCode() + "\n"
				+ message.getMessage());
		return message;
	}

	public Message delTrader(Trader trader) {
		logger.info("接收erp输入参数trader:" + trader);
		Message message = new Message();
		try {
			String invokeXml = "";
			if ("001".equals(this.verifyTrader(trader).getCode())) {
				invokeXml = objectToXml.getTraderXml(trader);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyTrader(trader);
			}
			logger.info("addTrader返回结果" + message.getCode() + "\n"
					+ message.getMessage());
		} catch (Exception e) {
			logger.error("调用delTrader出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		return message;
	}

	public Message addCommodity(Commodity commondity) {
		logger.info("接收erp输入参数commondity:" + commondity);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyCommodity(commondity).getCode())) {
				String invokeXml = objectToXml.getCommodityXml(commondity);
				logger.info("commondity转化xml:" + invokeXml);
				message = client.getMessqge(invokeXml);

			} else {
				message = this.verifyCommodity(commondity);
			}

		} catch (Exception e) {
			logger.error("调用addCommodity出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("addCommodity返回结果" + message.getCode() + "\n"
				+ message.getMessage());
		return message;
	}

	public Message updateCommodity(Commodity commondity) {
		logger.info("接收erp输入参数commondity:" + commondity);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyCommodity(commondity).getCode())) {
				String invokeXml = objectToXml.getCommodityXml(commondity);
				logger.info("commondity转化xml:" + invokeXml);
				message = client.getMessqge(invokeXml);

			} else {
				message = this.verifyCommodity(commondity);
			}

		} catch (Exception e) {
			logger.error("调用updateCommodity出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("addCommodity返回结果" + message.getCode() + "\n"
				+ message.getMessage());
		return message;
	}

	public Message delCommodity(Commodity commondity) {
		logger.info("接收erp输入参数commondity:" + commondity);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyCommodity(commondity).getCode())) {
				String invokeXml = objectToXml.getCommodityXml(commondity);
				logger.info("commondity转化xml:" + invokeXml);
				message = client.getMessqge(invokeXml);

			} else {
				message = this.verifyCommodity(commondity);
			}

		} catch (Exception e) {
			logger.error("调用delCommodity出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("addCommodity返回结果" + message.getCode() + "\n"
				+ message.getMessage());
		return message;
	}

	public Message addSKU(SKU sku) {
		logger.info("接收erp输入参数addSKU:" + sku);
		Message message = new Message();
		try {
			if (null != sku) {
				sku = this.changeSku(sku);
				logger.info("sku规格:" + sku.getSpec() + "\n" + "sku颜色:"
						+ sku.getColor() + "\n" + "sku尺寸:" + sku.getSize());
				if (null == sku.getSpec() || "".equals(sku.getSpec())) {
					sku.setSpec("-");
				}
				if (null == sku.getColor() || "".equals(sku.getColor())) {
					sku.setColor("-");
				}
				if (null == sku.getSize() || "".equals(sku.getSize())) {
					sku.setSize("-");
				}
				if ("001".equals(this.verifySKU(sku).getCode())) {
					String invokeXml = objectToXml.getSKUXml(sku);
					logger.info("sku转化xml:" + invokeXml);
					message = client.getMessqge(invokeXml);
				} else {
					message = this.verifySKU(sku);
				}

			} else {
				message.setCode("2");
				message.setMessage("SKU对象为空");
			}
		} catch (Exception e) {
			logger.error("调用addSKU出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("sku返回状态：" + message.getCode() + "\n" + "sku返回信息："
				+ message.getMessage());
		return message;
	}

	// 由于多渠道传来的规格是一个集合，现在转化成sku符合的样子，将多渠道传来json字符串分发到颜色，尺寸，规格等字段
	@SuppressWarnings("unchecked")
	private SKU changeSku(SKU sku) {
		List<CommoPropValueDo> commoPropValueDos = new ArrayList<CommoPropValueDo>();
		if (null != sku && !"".equals(sku.getSpec()) && sku.getSpec() != null) {
			String specJson = sku.getSpec();
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			JsonElement jsonElement = jsonParser.parse(specJson);
			JsonArray jsonArray = jsonElement.getAsJsonArray();
			Iterator it = jsonArray.iterator();
			while (it.hasNext()) {
				jsonElement = (JsonElement) it.next();
				CommoPropValueDo commoPropValueDo = gson.fromJson(jsonElement
						.toString(), CommoPropValueDo.class);
				commoPropValueDos.add(commoPropValueDo);
			}
			// 由于多渠道传来的规格是一个集合，现在转化成sku符合的样子
			StringBuffer sb = new StringBuffer();
			for (CommoPropValueDo commoPropValueDo : commoPropValueDos) {
				if (null != commoPropValueDo.getPropName()
						&& commoPropValueDo.getPropName().contains("颜色")) {
					sku.setColor(commoPropValueDo.getValue());
					sb.append(sku.getColor());
				} else if (null != commoPropValueDo.getPropName()
						&& commoPropValueDo.getPropName().contains("尺寸")) {
					sku.setSize(commoPropValueDo.getValue());
					sb.append(sku.getSize());
				} else {
					sb.append(commoPropValueDo.getPropName() + ":"
							+ commoPropValueDo.getValue() + ";");
				}
			}
			if (sb.length() > 0) {
				logger.info("spec转化后:" + sb);
				sku.setSpec(sb.substring(0, sb.length() - 1));
			} else {
				sku.setSpec("-");
			}

		}
		return sku;
	}

	public Message updateSKU(SKU sku) {
		logger.info("接收erp输入参数addSKU:" + sku);
		Message message = new Message();
		try {
			if (null != sku) {
				sku = this.changeSku(sku);
				logger.info("sku规格:" + sku.getSpec() + "\n" + "sku颜色:"
						+ sku.getColor() + "\n" + "sku尺寸:" + sku.getSize());
				if (null == sku.getSpec() || "".equals(sku.getSpec())) {
					sku.setSpec("-");
				}
				if (null == sku.getColor() || "".equals(sku.getColor())) {
					sku.setColor("-");
				}
				if (null == sku.getSize() || "".equals(sku.getSize())) {
					sku.setSize("-");
				}
				if ("001".equals(this.verifySKU(sku).getCode())) {
					String invokeXml = objectToXml.getSKUXml(sku);
					logger.info("sku转化xml:" + invokeXml);
					message = client.getMessqge(invokeXml);
				} else {
					message = this.verifySKU(sku);
				}

			} else {
				message.setCode("2");
				message.setMessage("SKU对象为空");
			}
		} catch (Exception e) {
			logger.error("调用updateSKU出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("sku返回状态：" + message.getCode() + "\n" + "sku返回信息："
				+ message.getMessage());
		return message;

	}

	public Message delSKU(SKU sku) {
		logger.info("接收erp输入参数addSKU:" + sku);
		Message message = new Message();
		try {
			if (null != sku) {
				sku = this.changeSku(sku);
				logger.info("sku规格:" + sku.getSpec() + "\n" + "sku颜色:"
						+ sku.getColor() + "\n" + "sku尺寸:" + sku.getSize());
				if (null == sku.getSpec() || "".equals(sku.getSpec())) {
					sku.setSpec("-");
				}
				if (null == sku.getColor() || "".equals(sku.getColor())) {
					sku.setColor("-");
				}
				if (null == sku.getSize() || "".equals(sku.getSize())) {
					sku.setSize("-");
				}
				if ("001".equals(this.verifySKU(sku).getCode())) {
					String invokeXml = objectToXml.getSKUXml(sku);
					logger.info("sku转化xml:" + invokeXml);
					message = client.getMessqge(invokeXml);
				} else {
					message = this.verifySKU(sku);
				}

			} else {
				message.setCode("2");
				message.setMessage("SKU对象为空");
			}
		} catch (Exception e) {
			logger.error("调用delSKU出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("sku返回状态：" + message.getCode() + "\n" + "sku返回信息："
				+ message.getMessage());
		return message;

	}

	public Message addClassify(Classify classify) {
		logger.info("接收erp输入参数classify:" + classify);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyClassify(classify).getCode())) {
				String invokeXml = objectToXml.getClassifyXml(classify);
				logger.info("classify转化xml:" + invokeXml);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyClassify(classify);
			}

		} catch (Exception e) {
			logger.error("调用addClassify出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}
		logger.info("classify返回状态：" + message.getCode() + "\n"
				+ "classify返回信息：" + message.getMessage());
		return message;
	}

	public Message updateClassify(Classify classify) {
		logger.info("接收erp输入参数classify:" + classify);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyClassify(classify).getCode())) {
				String invokeXml = objectToXml.getClassifyXml(classify);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyClassify(classify);
			}
		} catch (Exception e) {
			logger.error("调用updateClassify出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}

		return message;
	}

	public Message delClassify(Classify classify) {
		logger.info("接收erp输入参数classify:" + classify);
		Message message = new Message();
		try {
			if ("001".equals(this.verifyClassify(classify).getCode())) {
				String invokeXml = objectToXml.getClassifyXml(classify);
				message = client.getMessqge(invokeXml);
			} else {
				message = this.verifyClassify(classify);
			}
		} catch (Exception e) {
			logger.error("调用delClassify出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
		}

		return message;
	}

	public Message preStackIn(PreStackInOrder order) {
		logger.info("预入库接口开始***************");
		logger.info("预入库接口开始，入库单号：" + order.getNumber());
		Message message = new Message();
		if (null == order.getDetails() || 0 == order.getDetails().size()) {
			message.setCode("002");
			message.setMessage("PreStackInOrder中明细Details为空");
		}
		logger.info("接收erp输入参数PreStackInOrder:" + order);
		String invokeXml;
		try {
			invokeXml = objectToXml.getPreStackInXml(order);
			logger.info("接收erp输入参数PreStackInOrder:" + invokeXml);
			message = client.getMessqge(invokeXml);
		} catch (Exception e) {
			logger.error("调用preStackIn出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
			e.printStackTrace();
		}
		logger.info("PreStackInOrder返回状态：" + message.getCode() + "\n"
				+ "PreStackInOrder返回信息：" + message.getMessage());
		return message;
	}

	public Message preStackOut(List<PreStackOutOrder> orders) {
		logger.info("预出库接口开始***************");
		logger.info("预出库接口开始，出库单信息：" + JsonUtils.toJson(orders));
		Message message = new Message();
		try {
//			if (null == order.getDetails() || 0 == order.getDetails().size()) {
//				message.setCode("002");
//				message.setMessage("PreStackOutOrder中明细Details为空");
//			}
			logger.info("接收erp输入参数PreStackOutOrder:" + orders);
			String invokeXml = objectToXml.getPreStackOutXml(orders);
			logger.info("接收erp输入参数PreStackOutOrder:" + invokeXml);
			message = client.getMessqge(invokeXml);
		} catch (Exception e) {
			logger.error("调用preStackOut出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
			e.printStackTrace();
		}
		logger.info("PreStackOutOrder返回状态：" + message.getCode() + "\n"
				+ "PreStackOutOrder返回信息：" + message.getMessage());
		return message;
	}

	public Message cancelPreStackOut(String orderN) {
		logger.info("接收erp输入参数orderN:" + orderN);
		Message message = new Message();
		try {
			String invokeXml = objectToXml.getCancelOrderXml(orderN);
			logger.info("接收erp输入参数cancelPreStackOut:" + invokeXml);
			message = client.getMessqge(invokeXml);
		} catch (Exception e) {
			logger.error("调用preStackOut出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
			e.printStackTrace();
		}
		logger.info("cancelPreStackOut返回状态：" + message.getCode() + "\n"
				+ "cancelPreStackOut返回信息：" + message.getMessage());
		return message;
	}

	public Message redoPreStackOut(List<PreStackOutOrder> orders) {
		logger.info("接收erp输入参数PreStackOutOrder:" + JsonUtils.toJson(orders));
		Message message = new Message();
		try {
			String invokeXml = objectToXml.getPreStackOutXml(orders);
			logger.info("接收erp输入参数redoPreStackOut:" + invokeXml);
			message = client.getMessqge(invokeXml);
		} catch (Exception e) {
			logger.error("调用redoPreStackOut出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
			e.printStackTrace();
		}
		logger.info("redoPreStackOut返回状态：" + message.getCode() + "\n"
				+ "redoPreStackOut返回信息：" + message.getMessage());
		return message;
	}
	
	
	@Override
	public Message confirmReceive(
			String orderN,OrderType orderType,String consignor){
		
		logger.info("接收收货确认  :" + orderN);
		Message message = new Message();
		
		try {
			String invokeXml = objectToXml.getReceiveConfirmationXml(
					orderN, orderType, consignor);
			logger.info("接收收货确认:" + invokeXml);
			message = client.getMessqge(invokeXml);
		} catch (Exception e) {
			logger.error("调用收货出错" + e);
			message.setCode("005");
			message.setMessage("调用wms异常或者转换xml出错");
			e.printStackTrace();
		}
		
		return message;
	}

	/**
	 * 校验EPR推送WMS：trader 各个字段的长度
	 */
	private Message verifyTrader(Trader trader) {
		Message message = new Message();
		if (null != trader) {
			if (null != trader.getNumber() && trader.getNumber().length() > 50) {
				message.setCode("002");
				message.setMessage("trader编号number长度应<=50");
				return message;
			} else if (null != trader.getName()
					&& trader.getName().length() > 200) {
				message.setCode("002");
				message.setMessage("trader名称name长度应<=50");
				return message;
			} else if (null != trader.getAlphabetical()
					&& trader.getAlphabetical().length() > 50) {
				message.setCode("002");
				message.setMessage("trader单位拼音alphabetical长度应<=50");
				return message;
			} else if (null != trader.getShortName()
					&& trader.getShortName().length() > 50) {
				message.setCode("002");
				message.setMessage("trader单位简称shortName长度应<=50");
				return message;
			} else if (null != trader.getZone()
					&& trader.getZone().length() > 50) {
				message.setCode("002");
				message.setMessage("trader地区zone长度应<=50");
				return message;
			} else if (null != trader.getAddress()
					&& trader.getAddress().length() > 200) {
				message.setCode("002");
				message.setMessage("trader详细地址address长度应<=200");
				return message;
			} else if (null != trader.getPostCode()
					&& trader.getPostCode().length() > 10) {
				message.setCode("002");
				message.setMessage("trader邮政编码postCode长度应<=10");
				return message;
			} else {
				message.setCode("001");
				return message;
			}

		} else {
			logger.info("ERP传入参数trader错误");
			message.setCode("002");
			message.setMessage("trader邮政编码postCode长度应<=10");
			return message;
		}
	}

	/**
	 * 校验EPR推送WMS：SKU 各个字段的长度
	 */
	private Message verifySKU(SKU sku) {
		Message message = new Message();
		if (null != sku) {
			if (null != sku.getNumber() && sku.getNumber().length() > 50) {
				message.setCode("002");
				message.setMessage("SKU编号number长度应<=50");
				return message;

			} else if (null != sku.getName() && sku.getName().length() > 100) {
				message.setCode("002");
				message.setMessage("SKU名字name长度应<=100");
				return message;
			} else if (null != sku.getSpec() && sku.getSpec().length() > 100) {
				message.setCode("002");
				message.setMessage("SKU规格Spec长度应<=100");
				return message;
			} else if (null != sku.getBarcode()
					&& sku.getBarcode().length() > 100) {
				message.setCode("002");
				message.setMessage("SKU条码barcode长度应<=100");
				return message;
			} else if (null != sku.getSize() && sku.getSize().length() > 10) {
				message.setCode("002");
				message.setMessage("SKU尺码Size长度应<=10");
				return message;
			} else if (null != sku.getColor() && sku.getColor().length() > 50) {
				message.setCode("002");
				message.setMessage("SKU颜色Color长度应<=50");
				return message;
			} else {
				message.setCode("001");
				return message;
			}
		} else {
			message.setCode("002");
			message.setMessage("SKU不能为空");
			return message;
		}
	}

	/**
	 * 
	 * 校验EPR推送WMS：commodity各个字段的长度
	 */

	private Message verifyCommodity(Commodity commodity) {
		Message message = new Message();
		if (null != commodity) {
			if (null != commodity.getNumber()
					&& commodity.getNumber().length() > 50) {
				message.setCode("002");
				message.setMessage("commodity编号Number长度应<=50");
				return message;
			} else if (null != commodity.getName()
					&& commodity.getName().length() > 100) {
				message.setCode("002");
				message.setMessage("commodity名称Name长度应<=100");
				return message;
			} else if (null != commodity.getAlphabetical()
					&& commodity.getAlphabetical().length() > 50) {
				message.setCode("002");
				message.setMessage("commodity单位拼音Alphabetical长度应<=50");
				return message;
			} else if (null != commodity.getUnit()
					&& commodity.getUnit().length() > 50) {
				message.setCode("002");
				message.setMessage("commodity单位Unit长度应<=50");
				return message;
			} else if (null != commodity.getProductionPlace()
					&& commodity.getProductionPlace().length() > 100) {
				message.setCode("002");
				message.setMessage("commodity产地ProductionPlace长度应<=100");
				return message;
			} else if (null != commodity.getSupplierName()
					&& commodity.getSupplierName().length() > 100) {
				message.setCode("002");
				message.setMessage("commodity供应商SupplierName长度应<=100");
				return message;
			} else {
				message.setCode("001");
				return message;
			}
		} else {
			message.setCode("002");
			message.setMessage("commodity不能为空");
			return message;
		}

	}

	/**
	 * 校验EPR推送WMS：Classify 各个字段的长度
	 */
	private Message verifyClassify(Classify classify) {
		Message message = new Message();
		if (null != classify) {
			if (null != classify.getName() && classify.getName().length() > 50) {
				message.setCode("002");
				message.setMessage("classify名称Name长度<=50");
				return message;
			} else if (null != classify.getNumber()
					&& classify.getNumber().length() > 100) {
				message.setCode("002");
				message.setMessage("classify编号Number长度<=100");
				return message;
			} else {
				message.setCode("001");
				return message;
			}
		} else {
			message.setCode("002");
			message.setMessage("classify不能为空");
			return message;
		}
	}
}
