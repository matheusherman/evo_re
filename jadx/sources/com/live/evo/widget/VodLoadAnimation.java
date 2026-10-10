package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.live.evo.R$id;
import com.live.evo.R$layout;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@SuppressLint({"NewApi"})
public class VodLoadAnimation extends LinearLayout {
    public VodLoadAnimation(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context);
    }

    private void a(Context context) {
        addView(((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.vod_load_anim, (ViewGroup) null));
        ((AnimationDrawable) ((ImageView) findViewById(R$id.vodloadanim_iv_img)).getDrawable()).start();
    }

    public VodLoadAnimation(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public VodLoadAnimation(Context context) {
        super(context);
        a(context);
    }
}
