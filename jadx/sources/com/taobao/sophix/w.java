package com.taobao.sophix;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class w extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8505a;

    public w(int i10, String str) {
        super(str);
        this.f8505a = i10;
    }

    public int a() {
        return this.f8505a;
    }

    public w(int i10, Throwable th) {
        super(th);
        this.f8505a = i10;
    }
}
