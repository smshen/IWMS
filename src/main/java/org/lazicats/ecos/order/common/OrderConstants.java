package org.lazicats.ecos.order.common;

import java.util.Date;

/**
 * @ClassName: OrderConstants 
 * @Description: TODO
 * @author: Stanley review
 * @date 2013-7-15 上午9:14:39
 */
public class OrderConstants {
	
	/***********************************商品库存状态******************************************/
	/**无货状态*/
	public static final String NO_STOCK_STATE="0";
	/**有货状态*/
	public static final String YES_STOCK_STATE="1";
	/***********************************是否需要发票******************************************/
	/**需要发票*/
	public static final String NEED_INVOICE="1";
	/**不需要发票*/
	public static final String NO_NEED_INVOICE="0";
	
	/***********************************支付方式******************************************/
	/**在线支付*/
	public static final String PAYMENT_TYPE_ONLINE = "1";
	/**货到付款*/
	public static final String PAYMENT_TYPE_COD = "2";
	/**到店支付*/
	public static final String PAYMENT_TYPE_CASH = "3";
	/**电子账户*/
	public static final String PAYMENT_TYPE_DIGIT = "4";
	/**混合支付*/
	public static final String PAYMENT_TYPE_BLEND = "5";
	/**代金券支付*/
	public static final String PAYMENT_TYPE_VOUCHER = "6";
	
	/***********************************支付状态******************************************/
	/**待支付*/
	public static final String PAYMENT_STATE_WAITING = "1";
	/**已支付*/
	public static final String PAYMENT_STATE_ALREADY = "2";
	
	/**部分支付*/
	public static final String PAYMENT_STATE_PART = "3";
	
	/**已退款*/
	public static final String PAYMENT_STATE_REFUND = "4";

	/** 解锁状态*/
	public static final String LOCK_STATE_UNLOCK="0";
	/**锁定状态*/
	public static final String LOCK_STATE_LOCK="1";
	
	/***********************************基本状态******************************************/
	/**1待审核*/
	public static final String BASIC_STATE_UNAUDIT="1";
	/**2待复核*/
	public static final String BASIC_STATE_CONFIRM="2";
	/**3已取消*/
	public static final String BASIC_STATE_CANCEL="3";
	/**4已审核*/
	public static final String BASIC_STATE_AUDITED="4";
	/**5已完成*/
	public static final String BASIC_STATE_COMPLETE="5";
	/**6售后中*/
	public static final String BASIC_STATE_AFTERSALE="6";
	/**7已锁定 */
	public static final String BASIC_STATE_LOCK="7";
	
	/**8审核不通过   xyx add */
	public static final String BASIC_STATE_AUDITED_NOPASS="8";
	
	/** 待推送给第三方系统 */
	public static final String BASIC_STATE_PUSH_SUCCESS = "9";
	
	public static final String BASIC_STATE_PUSH_FAILED = "10";
	
	
	/***********************************配送状态******************************************/
	/**1准备*/
	public static final String DELIVERY_STATE_READY="1";
	/**2待发货*/
	public static final String DELIVERY_STATE_WAITING="2";
	/**3部分发货*/
	public static final String DELIVERY_STATE_PART="3";
	/**4已发货*/
	public static final String DELIVERY_STATE_ALREADY="4";
	/**5已签收*/
	public static final String DELIVERY_STATE_SIGNED="5";
	/**6已拒收*/
	public static final String DELIVERY_STATE_REJECT="6";
	/**7部分退货 */
	public static final String DELIVERY_STATE_PART_RETURN="7";
	/**已退货*/
	public static final String DELIVERY_STATE_RETURN="8";
	/**终止发货*/
	public static final String DELIVERY_STATE_END="9";
	
	

	/*************************************删除状态*****************************************/
	/**0未删除状态*/
	public static final Byte DELETE_FLAG_NO=0;
	/**1删除状态*/
	public static final Byte DELETE_FLAG_YES=1;
	
	
	/*************************************活动和商品条目关系类型*****************************************/
	/**组合类型：组合商品*/
	public static final Integer GROUP_TYPE_GROUPPRODUCT=0;
	/**组合类型：组合包活动商品*/
	public static final Integer GROUP_TYPE_COMBINEDBRODUCT=1;
	
	/**类型:赠送商品*/
	public static final Integer GIFT_PRODUCT=0;		//赠送商品
	
	/**类型:普通商品*/
	public static final Integer ITEM_PRODUCT=1;	    //单一商品
	
	/**类型:组合套装商品*/
	public static final Integer GROUP_PRODUCT=2;	//组合套装商品
	
	/**类型:换购商品*/
	public static final Integer EXTCHANG_PRODUCT = 3;  //换购商品
	
	/**类型:组合包活动商品*/
	public static final Integer AGROUP_PRODUCT = 4;  //组合包商品
	
	/**分摊类型:活动分摊*/
	public static final String SHARED_TYPE_ACTIVITY="ACT";//活动分摊
	/**分摊类型:优惠券分摊*/
	public static final String SHARED_TYPE_COUPONS="CUP";//优惠券分摊
	/**未拆单*/
	public static final String SPLIT_FLAG_NO="0";
	/**已拆单**/
	public static final String SPLIT_FLAG_ALREADY="1";
	/**未推送ERP*/
	public static final String ERP_FLAG_NO="0";
	/**已推送ERP**/
	public static final String ERP_FLAG_ALREADY="1";
	
	
	/**售后状态：待审核*/
	public static final String AFTERSALE_STATE_UNAUDIT="1";
	/**售后状态：审核通过*/
	public static final String AFTERSALE_STATE_AUDITED="2";
	/**售后状态：审核不通过*/
	public static final String AFTERSALE_STATE_REJECTED="3";
	/**售后状态：已完成*/
	public static final String AFTERSALE_STATE_COMPLETED="4";
	/** 售后状态：待退款 */
	public static final String AFTERSALE_STATE_WAIT_REFUND = "7";
	/** 售后状态：待寄出 */
	public static final String AFTERSALE_STATE_WAIT_SEND = "8";
	/** 退款审核失败*/
	public static final String AFTERSALE_STATE_REFUND_AUDIT_FAILED = "9";
	
	/**留言审核状态：待审核*/
	public static final String MSG_STATE_UNAUDIT="1";
	/**留言审核状态：待复核*/
	public static final String MSG_STATE_RECHECK="2";
	/**留言审核状态：已审核*/
	public static final String MSG_STATE_ALREADY="3";
	
	/**售后类型：退货*/
	public static final String AFTERSALE_TYPE_RETURN="1";
	/**售后类型：换货*/
	public static final String AFTERSALE_TYPE_REPLACE="2";
	/**售后类型：拒收*/
	public static final String AFTERSALE_TYPE_REJECTED ="3";
	/**售后类型：后台充单退货*/
	public static final String AFTERSALE_TYPE_ORDER_OFFSET = "4";
	/**售后类型：只退款不退货*/
	public static final String AFTERSALE_TYPE_REFUND = "5";
	/**允许拆单*/
	public static final String ALLOW_SPLIT_ORDER="1";
	/***禁止拆单*/
	public static final String FORBID_SPLIT_ORDER="2";
	
	/**0:不分单*/
	public static final int SPLIT_RESULT_FORBIDDEN=0;
	/**1：按仓库分单*/
	public static final int SPLIT_RESULT_BY_WAREHOUSE=1;
	/**2：按虚实库存分单*/
	public static final int SPLIT_RESULT_BY_REALY=2;
	/**3：按仓库和虚实库存分单*/
	public static final int SPLIT_RESULT_BYREALY_WAREHOUSE=3;
	
	public static final String SHENGZHEN_WMS_NO = "ShenZhen01";
	
	
	/** 待支付*/
	public static final String ORDER_STATE_NO_PAY="0";
	/** 等待发货*/
	public static final String ORDER_STATE_NO_DELIVERY="1";
	/** 已发货*/
	public static final String ORDER_STATE_ALREADY_DELIVERY="2";
	/** 退货申请中*/
	public static final String ORDER_STATE_APPLY_RETURN="3";
	/** 售后中*/
	public static final String ORDER_STATE_AFTERSALE="4";
	/** 换货申请中*/
	public static final String ORDER_STATE_APPLY_REPLACE="5";
	/** 已取消*/
	public static final String ORDER_STATE_CANCELED="6";
	/** 已完成**/
	public static final String ORDER_STATE_COMPLETED="7";
	/**待审核**/
	public static final String ORDER_STATE_UNAUDIT="8";
	/**已退款**/
	public static final String ORDER_STATE_ALREADY_REFUND="9";
	
	
//	/**
//	 * 订单配送状态
//	 */
//	private String deliveryState; //0准备 ;1拣货中 ,2 部分发货 ,3 已发货 ,4已收货 ,5 已取消发货,6已终止发货 
//	/**
//	 * 货物拒收状态
//	 */
//	private String rejectGoodsState; //0为未拒收,1拒收
//	/**
//	 * 退货状态
//	 */
//	private String returnGoodsState; //	0,退货申请中",1,部分退货, 2全部退货,3退货失败
//	/**
//	 * 退款状态
//	 */
//	private String refundState;  //	0,退款申请中",1,部分退款, 2全额退款,3退款失败
	
	public static final Integer REFUND_TYPE_RETURN = 1;// 退货退款
	
	public static final Integer REFUND_TYPE_CANCEL = 2;// 取消退款
	
	public static final Integer ORDER_CANCEL_STATE_CREATE = 1; // 新建
	
	public static final Integer ORDER_CANCEL_STATE_WAITREFUND = 2; // 待退款
	
	public static final Integer ORDER_CANCEL_STATE_REFUNDED = 3; // 已退款
	
	public static final Integer ORDER_CANCEL_STATE_AUDIT_REFUND_FAIL = 4; // 退款审核失败
	/**只退款不退货**/
	public static final Integer REFUND_TYPE_REFUND = 3;
	
	//add by chengyuanhuan   2014-1-9 18:10:51
	/*---------------------------------- 订单类型start  1：百货类   2:电器类---------------*/ 
	/** 订单类型 1：百货类 */
	public static final String ORDERTYPE_SERIES="1";
	/** 订单类型 2：电器类*/
	public static final String ORDERTYPE_ELECTRIC="2";
	
	/*---------------------------------- 订单类型end  1：百货类   2:电器类---------------*/ 
	/*---------------------------------- 金力返回状态start  0：失败   1:成功---------------*/ 
	/** 金力返回状态  0：失败  */
	public static final String JL_STATE_FAILE="0";
	/** 金力返回状态   1:成功*/
	public static final String JL_STATE_SUCCESS="1";
	
	/*---------------------------------- 金力返回状态end  0：失败   1:成功---------------*/ 
	
	/*---------------------------------- 广百返回状态start  0：失败   1:成功---------------*/ 
	/** 广百返回状态  0：失败  */
	public static final String GB_STATE_FAILE="0";
	/** 广百返回状态   1:成功*/
	public static final String GB_STATE_SUCCESS="1";
	
	/*---------------------------------- 广百返回状态end  0：失败   1:成功---------------*/ 
	
	
	/*---------------------------------- 是否已生成退款单  0：否   1:是---------------*/ 
	/** 是否已生成退款单  0：否 */
	public static final Integer IS_CREATE_REFUNDLIST_NO=0;
	/** 是否已生成退款单   1:是*/
	public static final Integer IS_CREATE_REFUNDLIST_YES=1;
	
	/*---------------------------------- 是否已生成退款单  0：否   1:是---------------*/ 

	/**
	 * 电子账户-消费
	 */
	public static final Integer DIGIT_TYPE_USE=1;
	/**
	 * 电子账户-充值
	 */
	public static final Integer DIGIT_TYPE_RECHARGE=2;
	/**
	 * 电子账户-退款
	 */
	public static final Integer DIGIT_TYPE_REBAK=3;
	public static final Integer DIGIT_TYPE_REBAK_AFTERSALE=3;
	/**
	 * 电子账户-未知
	 */
	public static final Integer DIGIT_TYPE_UNOW=4;
	
	
	public static final int FLAG_CONSUME = 1;
    public static final int FLAG_REFUND = 2;
    public static final int FLAG_ONLINERCG = 3;
	public static final int FLAG_GBCRCG = 4;
	

	// initiator
	public static final String INITIATOR_IGB = "IGB"; // 广百积分卡
	public static final String INITIATOR_GBH = "GBH"; // 广百荟
	
	// trade flag
	public static final int TRADE_FLAG_CONSUME = 1; 
	public static final int TRADE_FLAG_REFUND = 2;
	public static final int TRADE_FLAG_RECHARGE = 3;
	
	// trade type
	public static final int TRADE_TYPE_ONLINE_RECHARGE = 1;
	public static final int TRADE_TYPE_IGB_RECHARGE = 2;
	public static final int TRADE_TYPE_CONSUME = 3;
	public static final int TRADE_TYPE_CANCEL_REFUND = 4;
	public static final int TRADE_TYPE_AFTERSALE_REFUND = 5;
	
	// channel id
	public static final int CHANNEL_SYSTEM_INIT = 0;
	public static final int CHANNEL_ONLINE = 1;
	public static final int CHANNEL_IGB = 2;
	public static final int CHANNEL_IGB_EXCHANGE = 3;
		
	public static final int TYPE_GBCRCG = 4;
	public static final int TYPE_GBCCSM = 5;
	public static final int TYPE_GBCRFD = 6;
	public static final int TYPE_OBPRFD = 3;
	public static final int TYPE_OBPRCG = 2;
	public static final int TYPE_OBPCSM = 1;
	
	public static final String PREFIX_GBCRCG = "GBCRCG";
	public static final Long PERMANENT_LONG = 253402271999000L;
	public static final Date  PERMANENT_DATE = new Date(PERMANENT_LONG);
	
	
	/*--------------------------- 渠道 ---------------*/ 
	public static final String CHANNEL_GW = "1"; 		// 官网
	public static final String CHANNEL_TMALL = "2"; 	// 天猫（淘宝）
	public static final String CHANNEL_CCB = "3"; 		// 善融（建行）
	public static final String CHANNEL_YGGC = "4"; 		// 阳光公采
	
	/** ORDER TYPE */
	public static final String ORDER_TYPE_DS = "1"; 	// 百货(department store)
	public static final String ORDER_TYPE_APPLIANCE = "2";	// 电器
	public static final String ORDER_TYPE_CBT = "3";		// 跨境(cross-border-trade)
    public static final String ORDER_TYPE_OCSOD_QYLM = "4";
    
    
	
	
}
