package com.live.evo.catchup.LargeEpg;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f5629c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f5630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f5632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f5633g;

    protected a(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f5627a = 604800000;
        this.f5628b = 604800000;
        this.f5629c = 18000000;
        this.f5630d = 1800000;
        this.f5631e = getClass().getSimpleName();
        this.f5632f = "";
        this.f5633g = 0;
    }

    protected a(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f5627a = 604800000;
        this.f5628b = 604800000;
        this.f5629c = 18000000;
        this.f5630d = 1800000;
        this.f5631e = getClass().getSimpleName();
        this.f5632f = "";
        this.f5633g = 0;
        setFocusable(true);
        requestFocus();
        setWillNotDraw(false);
    }
}
