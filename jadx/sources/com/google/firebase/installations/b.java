package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import e2.g;
import e2.h;
import e2.j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import m2.x;
import q2.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b implements s2.d {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f4761m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ThreadFactory f4762n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j2.e f4763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v2.c f4764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u2.c f4765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f4766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<u2.b> f4767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s2.f f4768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f4769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ExecutorService f4770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f4771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @GuardedBy("this")
    private String f4772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("FirebaseInstallations.this")
    private Set<t2.a> f4773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("lock")
    private final List<e> f4774l;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f4775a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        @SuppressLint({"ThreadPoolCreation"})
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f4775a.getAndIncrement())));
        }

        a() {
        }
    }

    @SuppressLint({"ThreadPoolCreation"})
    b(final j2.e eVar, @NonNull r2.b<i> bVar, @NonNull ExecutorService executorService, @NonNull Executor executor) {
        this(executorService, executor, eVar, new v2.c(eVar.j(), bVar), new u2.c(eVar), f.c(), new x(new r2.b() { // from class: s2.a
            @Override // r2.b
            public final Object get() {
                return com.google.firebase.installations.b.c(eVar);
            }
        }), new s2.f());
    }

    private synchronized String k() {
        return this.f4772j;
    }

    private synchronized void y(String str) {
        this.f4772j = str;
    }

    private synchronized void z(u2.d dVar, u2.d dVar2) {
        if (this.f4773k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator<t2.a> it = this.f4773k.iterator();
            while (it.hasNext()) {
                it.next().a(dVar2.d());
            }
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.installations.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class C0053b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f4777b;

        static {
            int[] iArr = new int[v2.f.b.values().length];
            f4777b = iArr;
            try {
                iArr[v2.f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4777b[v2.f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4777b[v2.f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[v2.d.b.values().length];
            f4776a = iArr2;
            try {
                iArr2[v2.d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4776a[v2.d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static /* synthetic */ u2.b c(j2.e eVar) {
        return new u2.b(eVar);
    }

    private g<String> d() {
        h hVar = new h();
        e(new d(hVar));
        return hVar.a();
    }

    private void e(e eVar) {
        synchronized (this.f4769g) {
            this.f4774l.add(eVar);
        }
    }

    private u2.d h(@NonNull u2.d dVar) throws c {
        v2.f fVarE = this.f4764b.e(i(), dVar.d(), r(), dVar.f());
        int i10 = C0053b.f4777b[fVarE.b().ordinal()];
        if (i10 == 1) {
            return dVar.o(fVarE.c(), fVarE.d(), this.f4766d.b());
        }
        if (i10 == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i10 != 3) {
            throw new c("Firebase Installations Service is unavailable. Please try again later.", c.a.UNAVAILABLE);
        }
        y(null);
        return dVar.r();
    }

    private u2.b m() {
        return this.f4767e.get();
    }

    @NonNull
    public static b o(@NonNull j2.e eVar) {
        m1.g.b(eVar != null, "Null is not a valid value of FirebaseApp.");
        return (b) eVar.i(s2.d.class);
    }

    private u2.d p() {
        u2.d dVarD;
        synchronized (f4761m) {
            try {
                com.google.firebase.installations.a aVarA = com.google.firebase.installations.a.a(this.f4763a.j(), "generatefid.lock");
                try {
                    dVarD = this.f4765c.d();
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVarD;
    }

    private u2.d q() {
        u2.d dVarD;
        synchronized (f4761m) {
            try {
                com.google.firebase.installations.a aVarA = com.google.firebase.installations.a.a(this.f4763a.j(), "generatefid.lock");
                try {
                    dVarD = this.f4765c.d();
                    if (dVarD.j()) {
                        dVarD = this.f4765c.b(dVarD.t(u(dVarD)));
                    }
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVarD;
    }

    private void s(u2.d dVar) {
        synchronized (f4761m) {
            try {
                com.google.firebase.installations.a aVarA = com.google.firebase.installations.a.a(this.f4763a.j(), "generatefid.lock");
                try {
                    this.f4765c.b(dVar);
                    if (aVarA != null) {
                        aVarA.b();
                    }
                } catch (Throwable th) {
                    if (aVarA != null) {
                        aVarA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private String u(u2.d dVar) {
        if ((!this.f4763a.l().equals("CHIME_ANDROID_SDK") && !this.f4763a.t()) || !dVar.m()) {
            return this.f4768f.a();
        }
        String strF = m().f();
        return TextUtils.isEmpty(strF) ? this.f4768f.a() : strF;
    }

    private void w(Exception exc) {
        synchronized (this.f4769g) {
            try {
                Iterator<e> it = this.f4774l.iterator();
                while (it.hasNext()) {
                    if (it.next().b(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void x(u2.d dVar) {
        synchronized (this.f4769g) {
            try {
                Iterator<e> it = this.f4774l.iterator();
                while (it.hasNext()) {
                    if (it.next().a(dVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    String i() {
        return this.f4763a.m().b();
    }

    @VisibleForTesting
    String j() {
        return this.f4763a.m().c();
    }

    @Nullable
    String r() {
        return this.f4763a.m().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z10) {
        u2.d dVarV;
        u2.d dVarP = p();
        try {
            if (!dVarP.i() && !dVarP.l()) {
                if (!z10 && !this.f4766d.f(dVarP)) {
                    return;
                }
                dVarV = h(dVarP);
            } else {
                dVarV = v(dVarP);
            }
            s(dVarV);
            z(dVarP, dVarV);
            if (dVarV.k()) {
                y(dVarV.d());
            }
            if (dVarV.i()) {
                w(new c(c.a.BAD_CONFIG));
            } else if (dVarV.j()) {
                w(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                x(dVarV);
            }
        } catch (c e10) {
            w(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(final boolean z10) {
        u2.d dVarQ = q();
        if (z10) {
            dVarQ = dVarQ.p();
        }
        x(dVarQ);
        this.f4771i.execute(new Runnable() { // from class: s2.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f18256a.f(z10);
            }
        });
    }

    @NonNull
    public static b n() {
        return o(j2.e.k());
    }

    private void t() {
        m1.g.f(j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        m1.g.f(r(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        m1.g.f(i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        m1.g.b(f.h(j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        m1.g.b(f.g(i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private u2.d v(u2.d dVar) throws c {
        String strI;
        if (dVar.d() != null && dVar.d().length() == 11) {
            strI = m().i();
        } else {
            strI = null;
        }
        v2.d dVarD = this.f4764b.d(i(), dVar.d(), r(), j(), strI);
        int i10 = C0053b.f4776a[dVarD.e().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                return dVar.q("BAD CONFIG");
            }
            throw new c("Firebase Installations Service is unavailable. Please try again later.", c.a.UNAVAILABLE);
        }
        return dVar.s(dVarD.c(), dVarD.d(), this.f4766d.b(), dVarD.b().c(), dVarD.b().d());
    }

    @NonNull
    public g<String> l() {
        t();
        String strK = k();
        if (strK != null) {
            return j.d(strK);
        }
        g<String> gVarD = d();
        this.f4770h.execute(new Runnable() { // from class: s2.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f18255a.g(false);
            }
        });
        return gVarD;
    }

    @SuppressLint({"ThreadPoolCreation"})
    b(ExecutorService executorService, Executor executor, j2.e eVar, v2.c cVar, u2.c cVar2, f fVar, x<u2.b> xVar, s2.f fVar2) {
        this.f4769g = new Object();
        this.f4773k = new HashSet();
        this.f4774l = new ArrayList();
        this.f4763a = eVar;
        this.f4764b = cVar;
        this.f4765c = cVar2;
        this.f4766d = fVar;
        this.f4767e = xVar;
        this.f4768f = fVar2;
        this.f4770h = executorService;
        this.f4771i = executor;
    }
}
