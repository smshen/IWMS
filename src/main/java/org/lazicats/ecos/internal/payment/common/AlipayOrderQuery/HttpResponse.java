package org.lazicats.ecos.internal.payment.common.AlipayOrderQuery;

import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.Header;
import org.lazicats.ecos.internal.common.CommonPayInfo;

/**
 * 
 * @FileName HttpResponse.java
 * @PackageName org.lazicats.ecos.internal.payment.common.AlipayOrderQuery
 * @功能 Http返回对象的封装,封装Http返回信息 
 *
 * @author MingJun_Guo
 * @创建日期：2013-12-17下午2:15:59
 *
 */
public class HttpResponse {

    /**
     * 返回中的Header信息
     */
    private Header[] responseHeaders;

    /**
     * String类型的result
     */
    private String   stringResult;

    /**
     * btye类型的result
     */
    private byte[]   byteResult;

    protected Header[] getResponseHeaders() {
        return responseHeaders;
    }

    protected void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    protected byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    protected void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    protected String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, CommonPayInfo.BankPayInfo.get("alipay_input_charset"));
        }
        return null;
    }

    protected void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

}
