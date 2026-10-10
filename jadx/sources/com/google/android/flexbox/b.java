package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f2052e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f2053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f2054g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f2055h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f2056i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    float f2057j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    float f2058k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f2059l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f2060m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f2062o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f2063p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    boolean f2064q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    boolean f2065r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f2048a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f2049b = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2050c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2051d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    List<Integer> f2061n = new ArrayList();

    public int a() {
        return this.f2054g;
    }

    public int b() {
        return this.f2055h;
    }

    public int c() {
        return this.f2055h - this.f2056i;
    }

    b() {
    }

    void d(View view, int i10, int i11, int i12, int i13) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f2048a = Math.min(this.f2048a, (view.getLeft() - flexItem.q()) - i10);
        this.f2049b = Math.min(this.f2049b, (view.getTop() - flexItem.s()) - i11);
        this.f2050c = Math.max(this.f2050c, view.getRight() + flexItem.x() + i12);
        this.f2051d = Math.max(this.f2051d, view.getBottom() + flexItem.o() + i13);
    }
}
