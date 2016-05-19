<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>you need to login to use this page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <body>
    <form action="http://api.gbhui.com/IWMS/payNotify/test/offset" method="post">
    	<p>订单号： <input type="text" name="orderNo"/></p>
    	<p>交易号： <input type="text" name="tradeNo"/></p>
    	<p>支付金额： <input type="text" name="amount"/></p>
    	<p>支付方式：
    	    <select name="mop">
    			<option value="upop" selected>跨境银联</option>
    			<option value="allinpay" selected>跨境通联</option>
    			<option value="alipay" selected>支付宝</option>
    			<option value="unionpay" selected>银联</option>
	    	</select>
	    </p>
    	<input type="submit" value="提交"/>
    </form>
  </body>
</html>
