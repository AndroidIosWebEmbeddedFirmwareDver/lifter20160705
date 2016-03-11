package com.wxl.export.lifter.enty.constenty;

import com.wxl.export.lifter.enty.show.NoteOrderSubTypeGridItemShow;
import com.wxl.export.lifter.lifter.R;

import java.util.ArrayList;
import java.util.List;

/**
 * com.wxl.export.lifter.enty.constenty
 * Sintn
 * Created by Sintn on 16/3/10 上午10:17.
 */
public class NoteOrderIncomeSubTypeConst {
    public int typeIdStart = 2000;
    public List<NoteOrderSubTypeGridItemShow> resource;

    public NoteOrderIncomeSubTypeConst() {
        init();
    }

    public void init() {
        resource = new ArrayList<NoteOrderSubTypeGridItemShow>();
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_gongzi, R.drawable.icon_gongzi_normal, R.drawable.icon_gongzi_pressed, R.drawable.icon_gongzi_selected, true));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_jianzhi, R.drawable.icon_jianzhi_normal, R.drawable.icon_jianzhi_pressed, R.drawable.icon_jianzhi_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_licaishouyi, R.drawable.icon_licaishouyi_normal, R.drawable.icon_licaishouyi_pressed, R.drawable.icon_licaishouyi_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_lijinincome, R.drawable.icon_lijinincome_normal, R.drawable.icon_lijinincome_pressed, R.drawable.icon_lijinincome_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_qitaincome, R.drawable.icon_pita_normal, R.drawable.icon_pita_pressed, R.drawable.icon_pita_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_tianjialeibie, R.drawable.icon_tianjiaoutleibie_normal, R.drawable.icon_tianjiaoutleibie_pressed, R.drawable.icon_tianjiaoutleibie_selected));
    }

    public List<NoteOrderSubTypeGridItemShow> getResource() {
        return resource;
    }

    public void setResource(List<NoteOrderSubTypeGridItemShow> resource) {
        this.resource = resource;
    }
}

