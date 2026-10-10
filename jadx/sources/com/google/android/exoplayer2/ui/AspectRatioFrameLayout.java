package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f1669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f1670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1671c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f1672a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f1673b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f1674c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f1675d;

        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1675d = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }

        /* synthetic */ c(AspectRatioFrameLayout aspectRatioFrameLayout, a aVar) {
            this();
        }

        public void a(float f10, float f11, boolean z10) {
            this.f1672a = f10;
            this.f1673b = f11;
            this.f1674c = z10;
            if (this.f1675d) {
                return;
            }
            this.f1675d = true;
            AspectRatioFrameLayout.this.post(this);
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public AspectRatioFrameLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1671c = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f1671c = typedArrayObtainStyledAttributes.getInt(R$styleable.AspectRatioFrameLayout_resize_mode, 0);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        }
        this.f1669a = new c(this, null);
    }

    public int getResizeMode() {
        return this.f1671c;
    }

    public void setAspectRatio(float f10) {
        if (this.f1670b != f10) {
            this.f1670b = f10;
            requestLayout();
        }
    }

    public void setResizeMode(int i10) {
        if (this.f1671c != i10) {
            this.f1671c = i10;
            requestLayout();
        }
    }

    static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f1670b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        float f14 = f12 / f13;
        float f15 = (this.f1670b / f14) - 1.0f;
        if (Math.abs(f15) <= 0.01f) {
            this.f1669a.a(this.f1670b, f14, false);
            return;
        }
        int i12 = this.f1671c;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 != 2) {
                    if (i12 == 4) {
                        if (f15 > 0.0f) {
                            f10 = this.f1670b;
                        } else {
                            f11 = this.f1670b;
                        }
                    }
                } else {
                    f10 = this.f1670b;
                }
                measuredWidth = (int) (f13 * f10);
            } else {
                f11 = this.f1670b;
            }
            measuredHeight = (int) (f12 / f11);
        } else if (f15 > 0.0f) {
            f11 = this.f1670b;
            measuredHeight = (int) (f12 / f11);
        } else {
            f10 = this.f1670b;
            measuredWidth = (int) (f13 * f10);
        }
        this.f1669a.a(this.f1670b, f14, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY));
    }

    public void setAspectRatioListener(@Nullable b bVar) {
    }
}
