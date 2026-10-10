package com.live.evo.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.Button;
import com.live.evo.R$color;
import com.live.evo.util.x1;
import com.live.evo.util.z0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@SuppressLint({"AppCompatCustomView"})
public class BaseButton extends Button {
    public BaseButton(Context context) {
        super(context);
        setAllCaps(false);
        com.live.evo.util.t.d(this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (z10) {
            z0.d(this);
            setTextColor(x1.e(R$color.color_text_focus));
        } else {
            z0.g(this);
            setTextColor(x1.e(R$color.item_normal_color));
        }
    }

    public BaseButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setAllCaps(false);
        com.live.evo.util.t.d(this);
    }

    public BaseButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        setAllCaps(false);
        com.live.evo.util.t.d(this);
    }
}
