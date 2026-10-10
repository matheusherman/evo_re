package com.live.evo.widget.sloading.anim;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.live.evo.R$styleable;
import com.live.evo.widget.sloading.SLoadingView;
import com.live.evo.widget.sloading.a;
import com.live.evo.widget.sloading.c;
import s5.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SLoadingTextView extends SLoadingView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7725d;

    public SLoadingTextView(Context context) {
        this(context, null);
    }

    public SLoadingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void init(Context context, AttributeSet attributeSet) {
        super.setLoadingBuilder(c.TEXT);
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SLoadingTextView);
            String string = typedArrayObtainStyledAttributes.getString(0);
            typedArrayObtainStyledAttributes.recycle();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            this.f7725d = string;
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.live.evo.widget.sloading.SLoadingView, android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        setText(this.f7725d);
        super.onAttachedToWindow();
    }

    @Override // com.live.evo.widget.sloading.SLoadingView
    @Deprecated
    public void setLoadingBuilder(@NonNull c cVar) {
        super.setLoadingBuilder(c.TEXT);
    }

    public void setText(String str) {
        this.f7725d = str;
        a aVar = this.f7715b;
        if (aVar instanceof q) {
            ((q) aVar).z(str);
        }
    }

    public SLoadingTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f7725d = "";
        init(context, attributeSet);
    }
}
