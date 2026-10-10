package com.tvc.lib.mobile.ui.widget.sloading;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.tvc.lib.R$styleable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SLoadingView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f9509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a f9510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9511c;

    public SLoadingView(Context context) {
        this(context, null);
    }

    public SLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void a() {
        b bVar = this.f9509a;
        if (bVar != null) {
            bVar.start();
        }
    }

    private void b() {
        b bVar = this.f9509a;
        if (bVar != null) {
            bVar.stop();
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        try {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SLoadingView);
            int i10 = typedArrayObtainStyledAttributes.getInt(R$styleable.SLoadingView_s_type, 0);
            int color = typedArrayObtainStyledAttributes.getColor(R$styleable.SLoadingView_s_color, ViewCompat.MEASURED_STATE_MASK);
            this.f9511c = typedArrayObtainStyledAttributes.getColor(R$styleable.SLoadingView_s_color_extra, -7829368);
            typedArrayObtainStyledAttributes.recycle();
            setLoadingBuilder(c.values()[i10]);
            setColorFilter(color);
            setColorExtra(this.f9511c);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void setColorExtra(int i10) {
        this.f9510b.s(i10);
    }

    public void setShowTextView(String str) {
        this.f9510b.u(str);
    }

    public void setTextVisiable(boolean z10) {
        this.f9510b.v(z10);
    }

    public SLoadingView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0 && getVisibility() == 0) {
            a();
        } else {
            b();
        }
    }

    public void setLoadingBuilder(@NonNull c cVar) {
        this.f9510b = cVar.f();
        b bVar = new b(this.f9510b);
        this.f9509a = bVar;
        bVar.a(getContext(), this.f9511c);
        setImageDrawable(this.f9509a);
    }
}
