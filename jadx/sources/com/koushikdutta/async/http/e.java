package com.koushikdutta.async.http;

import java.util.Hashtable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f5086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected a f5088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Hashtable<String, Object> f5089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f5090f;

    public e(a aVar, String str, int i10) {
        this.f5087c = 300000;
        this.f5089e = new Hashtable<>();
        this.f5090f = Integer.MAX_VALUE;
        this.f5088d = aVar;
        this.f5085a = str;
        this.f5086b = i10;
    }

    public e(a aVar) {
        this(aVar, "http", 80);
    }
}
