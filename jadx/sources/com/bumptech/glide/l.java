package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import com.bumptech.glide.manager.r;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.manager.x;
import com.stub.StubApp;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class l implements ComponentCallbacks2, com.bumptech.glide.manager.m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final a0.i f1344l = a0.i.s0(Bitmap.class).T();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final a0.i f1345m = a0.i.s0(w.c.class).T();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final a0.i f1346n = a0.i.t0(l.j.f15050c).c0(h.LOW).k0(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final c f1347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f1348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.bumptech.glide.manager.l f1349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final s f1350d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final r f1351e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final x f1352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f1353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.bumptech.glide.manager.c f1354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList<a0.h<Object>> f1355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("this")
    private a0.i f1356j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1357k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar = l.this;
            lVar.f1349c.a(lVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements com.bumptech.glide.manager.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        private final s f1359a;

        b(s sVar) {
            this.f1359a = sVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (l.this) {
                    this.f1359a.e();
                }
            }
        }
    }

    public l(@NonNull c cVar, @NonNull com.bumptech.glide.manager.l lVar, @NonNull r rVar, @NonNull Context context) {
        this(cVar, lVar, rVar, new s(), cVar.g(), context);
    }

    synchronized void A(@NonNull b0.i<?> iVar, @NonNull a0.e eVar) {
        this.f1352f.f(iVar);
        this.f1350d.g(eVar);
    }

    synchronized boolean B(@NonNull b0.i<?> iVar) {
        a0.e eVarL = iVar.l();
        if (eVarL == null) {
            return true;
        }
        if (!this.f1350d.a(eVarL)) {
            return false;
        }
        this.f1352f.m(iVar);
        iVar.i(null);
        return true;
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void d() {
        try {
            this.f1352f.d();
            Iterator<b0.i<?>> it = this.f1352f.e().iterator();
            while (it.hasNext()) {
                o(it.next());
            }
            this.f1352f.c();
            this.f1350d.b();
            this.f1349c.b(this);
            this.f1349c.b(this.f1354h);
            e0.l.w(this.f1353g);
            this.f1347a.s(this);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void h() {
        x();
        this.f1352f.h();
    }

    @Override // com.bumptech.glide.manager.m
    public synchronized void onStart() {
        y();
        this.f1352f.onStart();
    }

    synchronized a0.i q() {
        return this.f1356j;
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f1350d + ", treeNode=" + this.f1351e + "}";
    }

    public synchronized void v() {
        this.f1350d.c();
    }

    public synchronized void w() {
        v();
        Iterator<l> it = this.f1351e.a().iterator();
        while (it.hasNext()) {
            it.next().v();
        }
    }

    public synchronized void x() {
        this.f1350d.d();
    }

    public synchronized void y() {
        this.f1350d.f();
    }

    protected synchronized void z(@NonNull a0.i iVar) {
        this.f1356j = iVar.clone().c();
    }

    @NonNull
    @CheckResult
    public <ResourceType> k<ResourceType> c(@NonNull Class<ResourceType> cls) {
        return new k<>(this.f1347a, this, cls, this.f1348b);
    }

    @NonNull
    @CheckResult
    public k<Bitmap> e() {
        return c(Bitmap.class).a(f1344l);
    }

    @NonNull
    @CheckResult
    public k<Drawable> f() {
        return c(Drawable.class);
    }

    @NonNull
    @CheckResult
    public k<File> m() {
        return c(File.class).a(a0.i.v0(true));
    }

    public void o(@Nullable b0.i<?> iVar) {
        if (iVar == null) {
            return;
        }
        C(iVar);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f1357k) {
            w();
        }
    }

    List<a0.h<Object>> p() {
        return this.f1355i;
    }

    @NonNull
    <T> m<?, T> r(Class<T> cls) {
        return this.f1347a.i().e(cls);
    }

    private void C(@NonNull b0.i<?> iVar) {
        boolean zB = B(iVar);
        a0.e eVarL = iVar.l();
        if (!zB && !this.f1347a.p(iVar) && eVarL != null) {
            iVar.i(null);
            eVarL.clear();
        }
    }

    @NonNull
    @CheckResult
    public k<Drawable> s(@Nullable Bitmap bitmap) {
        return f().G0(bitmap);
    }

    @NonNull
    @CheckResult
    public k<Drawable> t(@Nullable @DrawableRes @RawRes Integer num) {
        return f().H0(num);
    }

    @NonNull
    @CheckResult
    public k<Drawable> u(@Nullable String str) {
        return f().J0(str);
    }

    l(c cVar, com.bumptech.glide.manager.l lVar, r rVar, s sVar, com.bumptech.glide.manager.d dVar, Context context) {
        this.f1352f = new x();
        a aVar = new a();
        this.f1353g = aVar;
        this.f1347a = cVar;
        this.f1349c = lVar;
        this.f1351e = rVar;
        this.f1350d = sVar;
        this.f1348b = context;
        com.bumptech.glide.manager.c cVarA = dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), new b(sVar));
        this.f1354h = cVarA;
        cVar.o(this);
        if (e0.l.r()) {
            e0.l.v(aVar);
        } else {
            lVar.a(this);
        }
        lVar.a(cVarA);
        this.f1355i = new CopyOnWriteArrayList<>(cVar.i().c());
        z(cVar.i().d());
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
