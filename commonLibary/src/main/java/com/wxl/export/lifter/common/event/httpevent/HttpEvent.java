package com.wxl.export.lifter.common.event.httpevent;


import android.content.Context;
import android.util.Log;

import com.wxl.export.lifter.common.entity.down.ErrorObject;
import com.wxl.export.lifter.common.utils.core.JsonCommonUtils;
import com.wxl.export.lifter.common.event.MobileCashBaseEvent;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

/**
 * @Desc: 网络事件
 * @com.wxl.export.lifter.common.event.httpevent
 * @HuiyuantongVenusShopCash-V3.x
 * @HttpEvent.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-12下午3:47:30
 */

public abstract class HttpEvent extends MobileCashBaseEvent {

    /**
     * 服务器错误返回对象
     */
    protected ErrorObject errorObject;
    /**
     * http网络请求返回实体
     */
    protected HttpResponse httpResponse;
    /**
     * 网络请求是否成功
     */
    protected boolean isNetSuccess;
    /**
     * 请求状态值 status-200
     */
    protected boolean isOk;
    /**
     * status-401 需要重新登录
     */
    protected boolean isUnAuthorized;
    /**
     * status-405
     */
    protected boolean isMethodNotAllowed;
    /**
     * status-500
     */
    protected boolean isInternalServerError;
    /**
     * status-502
     */
    protected boolean isServerIsNotArrabile;
    /**
     * status-404and other
     */
    protected boolean isServerIsNotArrabileNOTKonwnREson;
    /**
     * 请求的结果字符串
     */
    protected String strHttpResult;
    /**
     * 请求Url
     */
    protected String strUrl;

    public HttpEvent(int nEventCode) {
        super(nEventCode);
        setIsAsyncRun(true);
        setIsNotifyAfterRun(true);
    }

    @Override
    public void run(Context context,Object... params) throws Exception {
        findUrl(params);
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public boolean isNetSuccess() {
        return isNetSuccess;
    }

    public boolean isOk() {
        return isOk;
    }

    public boolean isUnAuthorized() {
        return isUnAuthorized;
    }

    public boolean isMethodNotAllowed() {
        return isMethodNotAllowed;
    }

    public boolean isInternalServerError() {
        return isInternalServerError;
    }

    public boolean isServerIsServerNotArrabile() {
        return isServerIsNotArrabile;
    }

    public void setServerIsNotArrabile(boolean isServerIsNotArrabile) {
        this.isServerIsNotArrabile = isServerIsNotArrabile;
    }

    public boolean isServerIsNotArrabileNOTKonwnREson() {
        return isServerIsNotArrabileNOTKonwnREson;
    }

    public void setServerIsNotArrabileNOTKonwnREson(boolean isServerIsNotArrabileNOTKonwnREson) {
        this.isServerIsNotArrabileNOTKonwnREson = isServerIsNotArrabileNOTKonwnREson;
    }

    public String getStrHttpResult() {
        return strHttpResult;
    }

    public String getStrUrl() {
        return strUrl;
    }

    public ErrorObject getErrorObject() {
        return errorObject;
    }

    public void setErrorObject(ErrorObject errorObject) {
        this.errorObject = errorObject;
    }

    @Override
    public void onPreRun() {
        super.onPreRun();
        isNetSuccess = false;
        isOk = false;
        isUnAuthorized = false;
        isMethodNotAllowed = false;
        isInternalServerError = false;
        isServerIsNotArrabile = false;
        isServerIsNotArrabileNOTKonwnREson = false;
        strHttpResult = null;
    }

    /**
     * 事件结束通知回调函数
     *
     * @throws Exception
     */
    protected void verifyResponse() throws Exception {
        if (httpResponse != null) {
            isNetSuccess = true;
            strHttpResult = EntityUtils.toString(httpResponse.getEntity());
            // LOG
			 Log.e("debug", "返回状态" +
			 httpResponse.getStatusLine().getStatusCode());
			 Log.e("debug", "返回值" + strHttpResult);

            switch (httpResponse.getStatusLine().getStatusCode()) {
                case HttpStatus.SC_OK:// 成功
                    isOk = true;
                    break;
                case HttpStatus.SC_UNAUTHORIZED:// 需要重新登录
                    isUnAuthorized = true;
                    break;
                case HttpStatus.SC_METHOD_NOT_ALLOWED:// 方法不被允许
                    isMethodNotAllowed = true;
                    errorObject = (ErrorObject) JsonCommonUtils.jsonToObject(strHttpResult, ErrorObject.class);
                    break;
                case HttpStatus.SC_INTERNAL_SERVER_ERROR:// 服务器内部错误
                    isInternalServerError = true;
                    break;
                case HttpStatus.SC_BAD_GATEWAY:// 服务器BAD_GATEWAY
                    isServerIsNotArrabile = true;
                    break;
                default:
                    isServerIsNotArrabileNOTKonwnREson = true;
                    break;
            }
        }
    }

    /**
     * 从事件参数里面回去URL地址
     *
     * @param params
     */
    protected void findUrl(Object... params) {
        strUrl = (String) params[0];
//		// LOG
		 Log.e("debug", strUrl);
    }

}
