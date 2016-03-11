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
public class NoteOrderOutdoneSubTypeConst {
    public int typeIdStart = 3000;
    public List<NoteOrderSubTypeGridItemShow> resource;

    public NoteOrderOutdoneSubTypeConst() {
        init();
    }

    public void init() {
        resource = new ArrayList<NoteOrderSubTypeGridItemShow>();
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_yiban, R.drawable.icon_yiban_normal, R.drawable.icon_yiban_pressed, R.drawable.icon_yiban_selected, true));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_canyin, R.drawable.icon_canyin_normal, R.drawable.icon_canyin_pressed, R.drawable.icon_canyin_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_gouwu, R.drawable.icon_gouwu_normal, R.drawable.icon_gouwu_pressed, R.drawable.icon_gouwu_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_fushi, R.drawable.icon_fushi_normal, R.drawable.icon_fushi_pressed, R.drawable.icon_fushi_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_jiaotong, R.drawable.icon_jiaotong_normal, R.drawable.icon_jiaotong_pressed, R.drawable.icon_jiaotong_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_yule, R.drawable.icon_yule_normal, R.drawable.icon_yule_pressed, R.drawable.icon_yule_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_shejiao, R.drawable.icon_shejiao_normal, R.drawable.icon_shejiao_pressed, R.drawable.icon_shejiao_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_jujia, R.drawable.icon_jujia_normal, R.drawable.icon_jujia_pressed, R.drawable.icon_jujia_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_tongxun, R.drawable.icon_tongxun_normal, R.drawable.icon_tongxun_pressed, R.drawable.icon_tongxun_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_lingshi, R.drawable.icon_lingshi_normal, R.drawable.icon_lingshi_pressed, R.drawable.icon_lingshi_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_meirong, R.drawable.icon_meirong_normal, R.drawable.icon_meirong_pressed, R.drawable.icon_meirong_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_yundong, R.drawable.icon_yundong_normal, R.drawable.icon_yundong_pressed, R.drawable.icon_yundong_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_lvxing, R.drawable.icon_lvxing_normal, R.drawable.icon_lvxing_pressed, R.drawable.icon_lvxing_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_shuma, R.drawable.icon_shuma_normal, R.drawable.icon_shuma_pressed, R.drawable.icon_shuma_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_xuexi, R.drawable.icon_xuexi_normal, R.drawable.icon_xuexi_pressed, R.drawable.icon_xuexi_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_yiliao, R.drawable.icon_yiliao_normal, R.drawable.icon_yiliao_pressed, R.drawable.icon_yiliao_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_shuji, R.drawable.icon_shuji_normal, R.drawable.icon_shuji_pressed, R.drawable.icon_shuji_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_chongwu, R.drawable.icon_chongwu_normal, R.drawable.icon_chongwu_pressed, R.drawable.icon_chongwu_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_caipiao, R.drawable.icon_caipiao_normal, R.drawable.icon_caipiao_pressed, R.drawable.icon_caipiao_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_qiche, R.drawable.icon_qiche_normal, R.drawable.icon_qiche_pressed, R.drawable.icon_qiche_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_bangong, R.drawable.icon_bangong_normal, R.drawable.icon_bangong_pressed, R.drawable.icon_bangong_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_zhufang, R.drawable.icon_zhufang_normal, R.drawable.icon_zhufang_pressed, R.drawable.icon_zhufang_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_weixiu, R.drawable.icon_weixiu_normal, R.drawable.icon_weixiu_pressed, R.drawable.icon_weixiu_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_haizi, R.drawable.icon_haizi_normal, R.drawable.icon_haizi_pressed, R.drawable.icon_haizi_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_zhangbei, R.drawable.icon_zhangbei_normal, R.drawable.icon_zhangbei_pressed, R.drawable.icon_zhangbei_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_liwu, R.drawable.icon_liwu_normal, R.drawable.icon_liwu_pressed, R.drawable.icon_liwu_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_lijin, R.drawable.icon_lijin_normal, R.drawable.icon_lijin_pressed, R.drawable.icon_lijin_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_huanqian, R.drawable.icon_huanqian_normal, R.drawable.icon_huanqian_pressed, R.drawable.icon_huanqian_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_juanzeng, R.drawable.icon_juanzeng_normal, R.drawable.icon_juanzeng_pressed, R.drawable.icon_juanzeng_selected));
        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_licai, R.drawable.icon_licai_normal, R.drawable.icon_licai_pressed, R.drawable.icon_licai_selected));

        typeIdStart++;
        resource.add(new NoteOrderSubTypeGridItemShow(typeIdStart, R.string.textview_hint_of_tianjialeibie, R.drawable.icon_tianjialeibie_normal, R.drawable.icon_tianjia_pressed, R.drawable.icon_tianjialeibie_selected));
    }

    public List<NoteOrderSubTypeGridItemShow> getResource() {
        return resource;
    }

    public void setResource(List<NoteOrderSubTypeGridItemShow> resource) {
        this.resource = resource;
    }
}
