package com.wxl.export.lifter.event.http;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wxl.export.lifter.common.event.httpevent.HttpGetEvent;
import com.wxl.export.lifter.enty.down.BaseHttpDown;
import com.wxl.export.lifter.enty.down.TodayHistoryThingDown;

/**
 * com.wxl.export.lifter.event.http
 * Sintn
 * Created by Sintn on 16/3/8 下午5:13.
 */
public class GetTodayHistoryEvent extends HttpGetEvent {
    private BaseHttpDown<TodayHistoryThingDown> result;

    public BaseHttpDown<TodayHistoryThingDown> getResult() {
        return result;
    }

    public void setResult(BaseHttpDown<TodayHistoryThingDown> result) {
        this.result = result;
    }

    public GetTodayHistoryEvent(int nEventCode) {
        super(nEventCode);
    }

    @Override
    public void run(Context context, Object... params) throws Exception {
        super.run(context, params);
        result = JSON.parseObject(strHttpResult, new TypeReference<BaseHttpDown<TodayHistoryThingDown>>(){});
//        result = (BaseHttpDown<TodayHistoryThingDown>) JsonCommonUtils.jsonToObject(strHttpResult, BaseHttpDown.class);
    }
}
