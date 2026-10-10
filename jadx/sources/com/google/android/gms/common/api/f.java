package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.stub.StubApp;
import java.util.Collections;
import java.util.Set;
import k1.e0;
import k1.o0;
import k1.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class f<O extends com.google.android.gms.common.api.a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f2167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.android.gms.common.api.a f2168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.gms.common.api.a.d f2169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k1.b f2170e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Looper f2171f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f2172g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final g f2173h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final k1.m f2174i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    protected final k1.e f2175j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public static final a f2176c = new C0044a().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final k1.m f2177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final Looper f2178b;

        /* JADX INFO: renamed from: com.google.android.gms.common.api.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static class C0044a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private k1.m f2179a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Looper f2180b;

            /* JADX WARN: Multi-variable type inference failed */
            @NonNull
            public a a() {
                if (this.f2179a == null) {
                    this.f2179a = new k1.a();
                }
                if (this.f2180b == null) {
                    this.f2180b = Looper.getMainLooper();
                }
                return new a(this.f2179a, null, this.f2180b, 0 == true ? 1 : 0);
            }
        }

        private a(k1.m mVar, Account account, Looper looper) {
            this.f2177a = mVar;
            this.f2178b = looper;
        }

        /* synthetic */ a(k1.m mVar, Account account, Looper looper, n nVar) {
            this(mVar, null, looper);
        }
    }

    private f(@NonNull Context context, @Nullable Activity activity, com.google.android.gms.common.api.a aVar, com.google.android.gms.common.api.a.d dVar, a aVar2) {
        m1.g.l(context, "Null context is not permitted.");
        m1.g.l(aVar, "Api must not be null.");
        m1.g.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) m1.g.l(StubApp.getOrigApplicationContext(context.getApplicationContext()), "The provided context did not have an application context.");
        this.f2166a = context2;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : d(context);
        this.f2167b = attributionTag;
        this.f2168c = aVar;
        this.f2169d = dVar;
        this.f2171f = aVar2.f2178b;
        k1.b bVarA = k1.b.a(aVar, dVar, attributionTag);
        this.f2170e = bVarA;
        this.f2173h = new e0(this);
        k1.e eVarT = k1.e.t(context2);
        this.f2175j = eVarT;
        this.f2172g = eVarT.k();
        this.f2174i = aVar2.f2177a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            k1.q.u(activity, eVarT, bVarA);
        }
        eVarT.D(this);
    }

    @NonNull
    @ResultIgnorabilityUnspecified
    public <TResult, A extends com.google.android.gms.common.api.a.b> e2.g<TResult> c(@NonNull k1.n<A, TResult> nVar) {
        return j(2, nVar);
    }

    @Nullable
    protected String d(@NonNull Context context) {
        return null;
    }

    private final e2.g j(int i10, @NonNull k1.n nVar) {
        e2.h hVar = new e2.h();
        this.f2175j.z(this, i10, nVar, hVar, this.f2174i);
        return hVar.a();
    }

    @NonNull
    protected m1.c.a b() {
        Account accountW;
        GoogleSignInAccount googleSignInAccountR;
        GoogleSignInAccount googleSignInAccountR2;
        m1.c.a aVar = new m1.c.a();
        com.google.android.gms.common.api.a.d dVar = this.f2169d;
        if (!(dVar instanceof com.google.android.gms.common.api.a.d.b) || (googleSignInAccountR2 = ((com.google.android.gms.common.api.a.d.b) dVar).r()) == null) {
            com.google.android.gms.common.api.a.d dVar2 = this.f2169d;
            accountW = dVar2 instanceof com.google.android.gms.common.api.a.d.InterfaceC0043a ? ((com.google.android.gms.common.api.a.d.InterfaceC0043a) dVar2).w() : null;
        } else {
            accountW = googleSignInAccountR2.w();
        }
        aVar.d(accountW);
        com.google.android.gms.common.api.a.d dVar3 = this.f2169d;
        Set<Scope> setK0 = (!(dVar3 instanceof com.google.android.gms.common.api.a.d.b) || (googleSignInAccountR = ((com.google.android.gms.common.api.a.d.b) dVar3).r()) == null) ? Collections.EMPTY_SET : googleSignInAccountR.k0();
        aVar.c(setK0);
        aVar.e(this.f2166a.getClass().getName());
        aVar.b(this.f2166a.getPackageName());
        return aVar;
    }

    @NonNull
    public final k1.b<O> e() {
        return this.f2170e;
    }

    @Nullable
    protected String f() {
        return this.f2167b;
    }

    public final int g() {
        return this.f2172g;
    }

    public final o0 i(Context context, Handler handler) {
        return new o0(context, handler, b().a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @WorkerThread
    public final com.google.android.gms.common.api.a.f h(Looper looper, z zVar) {
        m1.c cVarA = b().a();
        com.google.android.gms.common.api.a.f fVarA = ((com.google.android.gms.common.api.a.AbstractC0042a) m1.g.k(this.f2168c.a())).a(this.f2166a, looper, cVarA, this.f2169d, zVar, zVar);
        String strF = f();
        if (strF != null && (fVarA instanceof com.google.android.gms.common.internal.b)) {
            ((com.google.android.gms.common.internal.b) fVarA).N(strF);
        }
        if (strF != null && (fVarA instanceof k1.j)) {
            ((k1.j) fVarA).o(strF);
        }
        return fVarA;
    }

    public f(@NonNull Context context, @NonNull com.google.android.gms.common.api.a<O> aVar, @NonNull O o10, @NonNull a aVar2) {
        this(context, null, aVar, o10, aVar2);
    }
}
