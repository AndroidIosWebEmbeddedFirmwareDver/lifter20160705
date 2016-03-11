package com.wxl.export.lifter.enty.down;

import java.util.List;

/**
 * com.wxl.export.lifter.enty.down
 * Sintn
 * Created by Sintn on 16/3/8 下午5:15.
 */
public class BaseHttpDown<E> {

    protected String reCode;
    protected String msg;
    protected List<E> result;

    public String getReCode() {
        return reCode;
    }

    public void setReCode(String reCode) {
        this.reCode = reCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<E> getResult() {
        return result;
    }

    public void setResult(List<E> result) {
        this.result = result;
    }

    public BaseHttpDown() {
    }

    public BaseHttpDown(String reCode, String msg, List<E> result) {
        this.reCode = reCode;
        this.msg = msg;
        this.result = result;
    }
}
