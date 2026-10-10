package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l.k f1287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m.d f1288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private m.b f1289e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private n.h f1290f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o.a f1291g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private o.a f1292h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private n.a.InterfaceC0306a f1293i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private n.i f1294j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.bumptech.glide.manager.d f1295k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private q.b f1298n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private o.a f1299o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f1300p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private List<a0.h<Object>> f1301q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, m<?, ?>> f1285a = new ArrayMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f.a f1286b = new f.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1296l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.bumptech.glide.c.a f1297m = new a();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements com.bumptech.glide.c.a {
        a() {
        }

        @Override // com.bumptech.glide.c.a
        @NonNull
        public a0.i build() {
            return new a0.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b {
        b() {
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class C0035d {
        private C0035d() {
        }
    }

    @NonNull
    com.bumptech.glide.c a(@NonNull Context context, List<GlideModule> list, AppGlideModule appGlideModule) {
        if (this.f1291g == null) {
            this.f1291g = o.a.h();
        }
        if (this.f1292h == null) {
            this.f1292h = o.a.f();
        }
        if (this.f1299o == null) {
            this.f1299o = o.a.d();
        }
        if (this.f1294j == null) {
            this.f1294j = new n.i.a(context).a();
        }
        if (this.f1295k == null) {
            this.f1295k = new com.bumptech.glide.manager.f();
        }
        if (this.f1288d == null) {
            int iB = this.f1294j.b();
            if (iB > 0) {
                this.f1288d = new m.k(iB);
            } else {
                this.f1288d = new m.e();
            }
        }
        if (this.f1289e == null) {
            this.f1289e = new m.i(this.f1294j.a());
        }
        if (this.f1290f == null) {
            this.f1290f = new n.g(this.f1294j.d());
        }
        if (this.f1293i == null) {
            this.f1293i = new n.f(context);
        }
        if (this.f1287c == null) {
            this.f1287c = new l.k(this.f1290f, this.f1293i, this.f1292h, this.f1291g, o.a.i(), this.f1299o, this.f1300p);
        }
        List<a0.h<Object>> list2 = this.f1301q;
        if (list2 == null) {
            this.f1301q = Collections.EMPTY_LIST;
        } else {
            this.f1301q = Collections.unmodifiableList(list2);
        }
        f fVarB = this.f1286b.b();
        return new com.bumptech.glide.c(context, this.f1287c, this.f1290f, this.f1288d, this.f1289e, new q(this.f1298n, fVarB), this.f1295k, this.f1296l, this.f1297m, this.f1285a, this.f1301q, list, appGlideModule, fVarB);
    }

    void b(@Nullable q.b bVar) {
        this.f1298n = bVar;
    }
}
