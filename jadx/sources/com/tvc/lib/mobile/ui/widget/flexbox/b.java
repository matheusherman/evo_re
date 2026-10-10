package com.tvc.lib.mobile.ui.widget.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f9453e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f9454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f9455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f9456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f9457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f9458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f9459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f9460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f9461m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f9463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f9464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f9465q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f9466r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f9449a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f9450b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f9451c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f9452d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    List<Integer> f9462n = new ArrayList();

    public int a() {
        return this.f9455g;
    }

    public int b() {
        return this.f9456h;
    }

    public int c() {
        return this.f9456h - this.f9457i;
    }

    b() {
    }

    void d(View view, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f9449a = Math.min(this.f9449a, (view.getLeft() - flexItem.q()) - i10);
        this.f9450b = Math.min(this.f9450b, (view.getTop() - flexItem.s()) - i11);
        this.f9451c = Math.max(this.f9451c, view.getRight() + flexItem.x() + i12);
        this.f9452d = Math.max(this.f9452d, view.getBottom() + flexItem.o() + i13);
    }
}
