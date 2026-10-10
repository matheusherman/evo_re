package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class SubtitleView extends FrameLayout implements k0.k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<y0.a> f1835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b1.b f1836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f1839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a f1843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f1844j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface a {
        void a(List<y0.a> list, b1.b bVar, float f10, int i10, float f11);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    public void setFractionalTextSize(float f10) {
        b(f10, false);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1835a = Collections.EMPTY_LIST;
        this.f1836b = b1.b.f632g;
        this.f1837c = 0;
        this.f1838d = 0.0533f;
        this.f1839e = 0.08f;
        this.f1840f = true;
        this.f1841g = true;
        com.google.android.exoplayer2.ui.a aVar = new com.google.android.exoplayer2.ui.a(context);
        this.f1843i = aVar;
        this.f1844j = aVar;
        addView(aVar);
        this.f1842h = 1;
    }

    private void c(int i10, float f10) {
        this.f1837c = i10;
        this.f1838d = f10;
        f();
    }

    private void f() {
        this.f1843i.a(getCuesWithStylingPreferencesApplied(), this.f1836b, this.f1838d, this.f1837c, this.f1839e);
    }

    private List<y0.a> getCuesWithStylingPreferencesApplied() {
        if (this.f1840f && this.f1841g) {
            return this.f1835a;
        }
        ArrayList arrayList = new ArrayList(this.f1835a.size());
        for (int i10 = 0; i10 < this.f1835a.size(); i10++) {
            arrayList.add(a(this.f1835a.get(i10)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (d1.k.f9577a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private b1.b getUserCaptionStyle() {
        if (d1.k.f9577a < 19 || isInEditMode()) {
            return b1.b.f632g;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        return (captioningManager == null || !captioningManager.isEnabled()) ? b1.b.f632g : b1.b.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t10) {
        removeView(this.f1844j);
        View view = this.f1844j;
        if (view instanceof b0) {
            ((b0) view).g();
        }
        this.f1844j = t10;
        this.f1843i = t10;
        addView(t10);
    }

    public void setApplyEmbeddedFontSizes(boolean z10) {
        this.f1841g = z10;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z10) {
        this.f1840f = z10;
        f();
    }

    public void setBottomPaddingFraction(float f10) {
        this.f1839e = f10;
        f();
    }

    public void setCues(@Nullable List<y0.a> list) {
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        this.f1835a = list;
        f();
    }

    public void setStyle(b1.b bVar) {
        this.f1836b = bVar;
        f();
    }

    public void setViewType(int i10) {
        if (this.f1842h == i10) {
            return;
        }
        if (i10 == 1) {
            setView(new com.google.android.exoplayer2.ui.a(getContext()));
        } else {
            if (i10 != 2) {
                throw new IllegalArgumentException();
            }
            setView(new b0(getContext()));
        }
        this.f1842h = i10;
    }

    private y0.a a(y0.a aVar) {
        y0.a.b bVarA = aVar.a();
        if (!this.f1840f) {
            z.c(bVarA);
        } else if (!this.f1841g) {
            z.d(bVarA);
        }
        return bVarA.a();
    }

    public void b(float f10, boolean z10) {
        c(z10 ? 1 : 0, f10);
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }
}
