package org.lazicats.ecos.internal.payment.controllor;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lazicats.ecos.internal.common.CommonPayInfo;
import org.lazicats.ecos.internal.payment.common.Upoppay.UpopPayUtils;
import org.lazicats.ecos.internal.payment.component.PaymenComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/payNotify/test")
public class MyOffsetController{
	
	
	
	@RequestMapping(value = "/setup", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String toPayComplete_alipay(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return String.valueOf(UpopPayUtils.verify("1429952299319164551"));
	}

	@RequestMapping(value = "/offset", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String offset(String orderNo, String tradeNo,
			String amount, String time,String mop) throws Exception {

		String format = "yyyy-MM-dd HH:mm:ss"+"wjat";
		SimpleDateFormat saveFormat = new SimpleDateFormat(format);
		paymenComponent.payInform(
				orderNo,// orderNo
				mop,// mode of payment
				tradeNo,// trade No
				(time==null?saveFormat.format(new Date()):time),// payment time
				amount);// payment amount

		return "success";

	}

	@Resource
	private PaymenComponent paymenComponent;

}
