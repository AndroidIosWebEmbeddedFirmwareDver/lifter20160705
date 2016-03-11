package com.wxl.export.lifter.interfaces;

/**
 * Created by Sintn on 16/3/11.
 */
public interface KeyboardToolInterface {
    public void onNumberkeyCkicked(String s);

    public void onCamerakeyCkicked();

    public void onPointkeyCkicked();

    public void onDeletekeyCkicked();

    public void onSurekeyCkicked();

    public void onClearkeyCkicked();

    public String getInputContent();
}
