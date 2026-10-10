package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class a extends View implements SubtitleView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<w> f1860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<y0.a> f1861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f1863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b1.b f1864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f1865f;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1860a = new ArrayList();
        this.f1861b = Collections.EMPTY_LIST;
        this.f1862c = 0;
        this.f1863d = 0.0533f;
        this.f1864e = b1.b.f632g;
        this.f1865f = 0.08f;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<y0.a> list, b1.b bVar, float f10, int i10, float f11) {
        this.f1861b = list;
        this.f1864e = bVar;
        this.f1863d = f10;
        this.f1862c = i10;
        this.f1865f = f11;
        while (this.f1860a.size() < list.size()) {
            this.f1860a.add(new w(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<y0.a> list = this.f1861b;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i10 = paddingBottom - paddingTop;
        float f10 = z.f(this.f1862c, this.f1863d, height, i10);
        if (f10 <= 0.0f) {
            return;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            y0.a aVarB = list.get(i11);
            if (aVarB.f22288p != Integer.MIN_VALUE) {
                aVarB = b(aVarB);
            }
            this.f1860a.get(i11).b(aVarB, this.f1864e, f10, z.f(aVarB.f22286n, aVarB.f22287o, height, i10), this.f1865f, canvas, paddingLeft, paddingTop, width, paddingBottom);
        }
    }

    private static y0.a b(y0.a aVar) {
        y0.a.b bVarI = aVar.a().f(-3.4028235E38f).g(Integer.MIN_VALUE).i(null);
        if (aVar.f22278f == 0) {
            bVarI.d(1.0f - aVar.f22277e, 0);
        } else {
            bVarI.d((-aVar.f22277e) - 1.0f, 1);
        }
        int i10 = aVar.f22279g;
        if (i10 != 0) {
            if (i10 == 2) {
                bVarI.e(0);
            }
        } else {
            bVarI.e(2);
        }
        return bVarI.a();
    }
}
