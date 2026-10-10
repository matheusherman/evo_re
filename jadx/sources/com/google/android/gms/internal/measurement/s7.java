package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class s7<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f3030h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile e8 f3031i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static i8 f3032j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f3033k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b8 f3034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f3035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f3036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile int f3037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile T f3038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f3039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f3040g;

    /* synthetic */ s7(b8 b8Var, String str, Object obj, boolean z10, d8 d8Var) {
        this(b8Var, str, obj, true);
    }

    static /* synthetic */ boolean n() {
        return true;
    }

    abstract T h(Object obj);

    static {
        new AtomicReference();
        f3032j = new i8(new h8() { // from class: com.google.android.gms.internal.measurement.x7
            @Override // com.google.android.gms.internal.measurement.h8
            public final boolean b() {
                return s7.n();
            }
        });
        f3033k = new AtomicInteger();
    }

    private s7(b8 b8Var, String str, T t10, boolean z10) {
        this.f3037d = -1;
        String str2 = b8Var.f2553a;
        if (str2 == null && b8Var.f2554b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        if (str2 != null && b8Var.f2554b != null) {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
        this.f3034a = b8Var;
        this.f3035b = str;
        this.f3036c = t10;
        this.f3039f = z10;
        this.f3040g = false;
    }

    static /* synthetic */ s7 a(b8 b8Var, String str, Boolean bool, boolean z10) {
        return new a8(b8Var, str, bool, true);
    }

    static /* synthetic */ s7 b(b8 b8Var, String str, Double d10, boolean z10) {
        return new z7(b8Var, str, d10, true);
    }

    static /* synthetic */ s7 c(b8 b8Var, String str, Long l10, boolean z10) {
        return new w7(b8Var, str, l10, true);
    }

    static /* synthetic */ s7 d(b8 b8Var, String str, String str2, boolean z10) {
        return new c8(b8Var, str, str2, true);
    }

    private final T g(e8 e8Var) {
        com.google.common.base.f<Context, Boolean> fVar;
        String str;
        b8 b8Var = this.f3034a;
        if (!b8Var.f2557e && ((fVar = b8Var.f2561i) == null || fVar.apply(e8Var.a()).booleanValue())) {
            k7 k7VarA = k7.a(e8Var.a());
            b8 b8Var2 = this.f3034a;
            String strI = b8Var2.f2557e ? null : i(b8Var2.f2555c);
            if (strI != null && (str = (String) k7VarA.i(strI)) != null) {
                return h(str);
            }
        }
        return null;
    }

    private final String i(String str) {
        if (str != null && str.isEmpty()) {
            return this.f3035b;
        }
        return str + this.f3035b;
    }

    private final T j(e8 e8Var) {
        j7 j7VarB;
        Object objI;
        if (this.f3034a.f2554b == null) {
            j7VarB = g8.b(e8Var.a(), (String) com.google.common.base.m.i(this.f3034a.f2553a), new Runnable() { // from class: com.google.android.gms.internal.measurement.v7
                @Override // java.lang.Runnable
                public final void run() {
                    s7.m();
                }
            });
        } else if (r7.b(e8Var.a(), this.f3034a.f2554b)) {
            j7VarB = this.f3034a.f2560h ? c7.a(e8Var.a().getContentResolver(), t7.a(t7.b(e8Var.a(), (String) com.google.common.base.m.i(this.f3034a.f2554b.getLastPathSegment()))), new Runnable() { // from class: com.google.android.gms.internal.measurement.v7
                @Override // java.lang.Runnable
                public final void run() {
                    s7.m();
                }
            }) : c7.a(e8Var.a().getContentResolver(), this.f3034a.f2554b, new Runnable() { // from class: com.google.android.gms.internal.measurement.v7
                @Override // java.lang.Runnable
                public final void run() {
                    s7.m();
                }
            });
        } else {
            j7VarB = null;
        }
        if (j7VarB == null || (objI = j7VarB.i(k())) == null) {
            return null;
        }
        return h(objI);
    }

    public static void l(final Context context) {
        if (f3031i != null || context == null) {
            return;
        }
        Object obj = f3030h;
        synchronized (obj) {
            try {
                if (f3031i == null) {
                    synchronized (obj) {
                        try {
                            e8 e8Var = f3031i;
                            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                            if (origApplicationContext != null) {
                                context = origApplicationContext;
                            }
                            if (e8Var == null || e8Var.a() != context) {
                                if (e8Var != null) {
                                    c7.d();
                                    g8.c();
                                    k7.c();
                                }
                                f3031i = new d7(context, com.google.common.base.r.a(new com.google.common.base.q() { // from class: com.google.android.gms.internal.measurement.u7
                                    @Override // com.google.common.base.q
                                    public final Object get() {
                                        return p7.a.a(context);
                                    }
                                }));
                                f3033k.incrementAndGet();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void m() {
        f3033k.incrementAndGet();
    }

    private final T o() {
        return (T) this.f3036c;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0088 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:8:0x001c, B:10:0x0020, B:12:0x0029, B:14:0x002f, B:16:0x0045, B:22:0x0061, B:24:0x006c, B:37:0x008c, B:40:0x0094, B:41:0x0099, B:42:0x009d, B:27:0x0073, B:36:0x0088, B:30:0x007a, B:33:0x0081, B:43:0x00a1), top: B:49:0x001c }] */
    public final T f() {
        T tJ;
        if (!this.f3039f) {
            com.google.common.base.m.o(f3032j.a(this.f3035b), "Attempt to access PhenotypeFlag not via codegen. All new PhenotypeFlags must be accessed through codegen APIs. If you believe you are seeing this error by mistake, you can add your flag to the exemption list located at //java/com/google/android/libraries/phenotype/client/lockdown/flags.textproto. Send the addition CL to ph-reviews@. See go/phenotype-android-codegen for information about generated code. See go/ph-lockdown for more information about this error.");
        }
        int i10 = f3033k.get();
        if (this.f3037d < i10) {
            synchronized (this) {
                try {
                    if (this.f3037d < i10) {
                        e8 e8Var = f3031i;
                        com.google.common.base.l lVarA = com.google.common.base.l.a();
                        String strA = null;
                        if (e8Var != null && e8Var.b() != null) {
                            lVarA = (com.google.common.base.l) ((com.google.common.base.q) com.google.common.base.m.i(e8Var.b())).get();
                            if (lVarA.c()) {
                                q7 q7Var = (q7) lVarA.b();
                                b8 b8Var = this.f3034a;
                                strA = q7Var.a(b8Var.f2554b, b8Var.f2553a, b8Var.f2556d, this.f3035b);
                            }
                        }
                        com.google.common.base.m.o(e8Var != null, "Must call PhenotypeFlagInitializer.maybeInit() first");
                        if (this.f3034a.f2558f) {
                            tJ = g(e8Var);
                            if (tJ == null && (tJ = j(e8Var)) == null) {
                                tJ = o();
                            }
                        } else {
                            tJ = j(e8Var);
                            if (tJ == null && (tJ = g(e8Var)) == null) {
                                tJ = o();
                            }
                        }
                        if (lVarA.c()) {
                            tJ = strA == null ? o() : h(strA);
                        }
                        this.f3038e = tJ;
                        this.f3037d = i10;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3038e;
    }

    public final String k() {
        return i(this.f3034a.f2556d);
    }
}
