package com.taobao.sophix;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f8415j = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static AtomicInteger f8416k = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f8419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f8423g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8424h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8425i;

    public b0(int i10) {
        this.f8421e = -9999L;
        this.f8422f = -9999;
        this.f8423g = -9999L;
        this.f8424h = -9999;
        this.f8425i = -9999;
        this.f8417a = f8415j + "-" + f8416k.incrementAndGet();
        this.f8418b = i10;
    }

    public void b() {
        this.f8419c = null;
        this.f8421e = -9999L;
        this.f8425i = -9999;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder("path");
        sb2.append("=");
        sb2.append(this.f8418b);
        if (this.f8421e != -9999) {
            sb2.append(",");
            sb2.append("cost");
            sb2.append("=");
            sb2.append(this.f8421e);
        }
        if (this.f8423g != -9999) {
            sb2.append(",");
            sb2.append("dex");
            sb2.append("=");
            sb2.append(this.f8423g);
        }
        if (this.f8422f != -9999) {
            sb2.append(",");
            sb2.append("genre");
            sb2.append("=");
            sb2.append(this.f8422f);
        }
        if (this.f8424h != -9999) {
            sb2.append(",");
            sb2.append("load");
            sb2.append("=");
            sb2.append(this.f8424h);
        }
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("PatchStat{");
        sb2.append("id='");
        sb2.append(this.f8417a);
        sb2.append('\'');
        sb2.append(", path=");
        sb2.append(this.f8418b);
        sb2.append(", status='");
        sb2.append(this.f8419c);
        sb2.append('\'');
        sb2.append(", version='");
        sb2.append(this.f8420d);
        sb2.append('\'');
        if (this.f8421e != -9999) {
            sb2.append(", cost=");
            sb2.append(this.f8421e);
        }
        if (this.f8422f != -9999) {
            sb2.append(", genre=");
            sb2.append(this.f8422f);
        }
        if (this.f8423g != -9999) {
            sb2.append(", dex=");
            sb2.append(this.f8423g);
        }
        if (this.f8424h != -9999) {
            sb2.append(", load=");
            sb2.append(this.f8424h);
        }
        if (this.f8425i != -9999) {
            sb2.append(", errorCode=");
            sb2.append(this.f8425i);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public b0(b0 b0Var) {
        this.f8421e = -9999L;
        this.f8422f = -9999;
        this.f8423g = -9999L;
        this.f8424h = -9999;
        this.f8425i = -9999;
        this.f8417a = b0Var.f8417a;
        this.f8418b = b0Var.f8418b;
        this.f8419c = b0Var.f8419c;
        this.f8420d = b0Var.f8420d;
        this.f8421e = b0Var.f8421e;
        this.f8422f = b0Var.f8422f;
        this.f8423g = b0Var.f8423g;
        this.f8424h = b0Var.f8424h;
        this.f8425i = b0Var.f8425i;
    }
}
