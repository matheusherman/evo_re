package com.live.evo.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d1 f7217a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        h3.a f7218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Context f7219b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bundle f7221d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f7222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f7223f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f7224g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int[] f7225h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Uri f7226i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f7228k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Bitmap f7229l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f7230m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private Bitmap f7231n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private int f7232o;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private o3.a f7220c = o3.a.TEXT;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f7227j = false;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f7233p = 4;

        private void b() {
            if (this.f7219b == null) {
                throw new IllegalArgumentException("context no found...");
            }
            o3.a aVar = this.f7220c;
            if (aVar == null) {
                throw new IllegalArgumentException("parsedResultType no found...");
            }
            o3.a aVar2 = o3.a.ADDRESSBOOK;
            if (aVar != aVar2 && aVar != o3.a.GEO && this.f7222e == null) {
                throw new IllegalArgumentException("parsedResultType not ParsedResultType.ADDRESSBOOK and ParsedResultType.GEO, contents no found...");
            }
            if ((aVar == aVar2 || aVar == o3.a.GEO) && this.f7221d == null && this.f7226i == null) {
                throw new IllegalArgumentException("parsedResultType yes ParsedResultType.ADDRESSBOOK or ParsedResultType.GEO, bundle and addressBookUri no found...");
            }
        }

        Uri c() {
            return this.f7226i;
        }

        h3.a d() {
            return this.f7218a;
        }

        Bundle e() {
            return this.f7221d;
        }

        int f() {
            return this.f7224g;
        }

        int[] g() {
            return this.f7225h;
        }

        String h() {
            return this.f7222e;
        }

        String i() {
            return this.f7223f;
        }

        Bitmap j() {
            return this.f7229l;
        }

        int k() {
            return this.f7230m;
        }

        int l() {
            return this.f7233p;
        }

        o3.a m() {
            return this.f7220c;
        }

        Bitmap n() {
            return this.f7231n;
        }

        int o() {
            return this.f7232o;
        }

        int p() {
            return this.f7228k;
        }

        boolean q() {
            return this.f7227j;
        }

        a r(h3.a aVar) {
            this.f7218a = aVar;
            return this;
        }

        public a s(int i10) {
            this.f7224g = i10;
            return this;
        }

        public a t(String str) {
            this.f7222e = str;
            return this;
        }

        a u(String str) {
            this.f7223f = str;
            return this;
        }

        public a v(Bitmap bitmap, int i10) {
            this.f7229l = bitmap;
            this.f7230m = i10;
            return this;
        }

        public a w(int i10) {
            this.f7233p = i10;
            return this;
        }

        public a x(o3.a aVar) {
            this.f7220c = aVar;
            return this;
        }

        public a y(int i10) {
            this.f7228k = i10;
            return this;
        }

        public a(Context context) {
            this.f7219b = context;
        }

        public e1 a() {
            b();
            return new e1(new d1(this, StubApp.getOrigApplicationContext(this.f7219b.getApplicationContext())), null);
        }
    }

    /* synthetic */ e1(d1 d1Var, f1 f1Var) {
        this(d1Var);
    }

    private e1(d1 d1Var) {
        this.f7217a = d1Var;
    }

    public Bitmap a() {
        try {
            return this.f7217a.b();
        } catch (h3.v e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
