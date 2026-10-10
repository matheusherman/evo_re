package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w3 f2571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private v6 f2572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f2573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f2574d;

    public c0() {
        this(new w3());
    }

    private c0(w3 w3Var) {
        this.f2571a = w3Var;
        this.f2572b = w3Var.f3178b.d();
        this.f2573c = new d();
        this.f2574d = new b();
        w3Var.b("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c0.f(this.f2522a);
            }
        });
        w3Var.b("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.d2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c0.b(this.f2601a);
            }
        });
    }

    public static /* synthetic */ n b(c0 c0Var) {
        return new v9(c0Var.f2573c);
    }

    public static /* synthetic */ n f(c0 c0Var) {
        return new qg(c0Var.f2574d);
    }

    public final d a() {
        return this.f2573c;
    }

    public final void c(i6 i6Var) throws d1 {
        n nVar;
        try {
            this.f2572b = this.f2571a.f3178b.d();
            if (this.f2571a.a(this.f2572b, (j6[]) i6Var.M().toArray(new j6[0])) instanceof l) {
                throw new IllegalStateException("Program loading failed");
            }
            for (h6 h6Var : i6Var.K().M()) {
                List<j6> listM = h6Var.M();
                String strL = h6Var.L();
                Iterator<j6> it = listM.iterator();
                while (it.hasNext()) {
                    s sVarA = this.f2571a.a(this.f2572b, it.next());
                    if (!(sVarA instanceof r)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    v6 v6Var = this.f2572b;
                    if (v6Var.g(strL)) {
                        s sVarC = v6Var.c(strL);
                        if (!(sVarC instanceof n)) {
                            throw new IllegalStateException("Invalid function name: " + strL);
                        }
                        nVar = (n) sVarC;
                    } else {
                        nVar = null;
                    }
                    if (nVar == null) {
                        throw new IllegalStateException("Rule function is undefined: " + strL);
                    }
                    nVar.a(this.f2572b, Collections.singletonList(sVarA));
                }
            }
        } catch (Throwable th) {
            throw new d1(th);
        }
    }

    public final void d(String str, Callable<? extends n> callable) {
        this.f2571a.b(str, callable);
    }

    public final boolean e(e eVar) throws d1 {
        try {
            this.f2573c.b(eVar);
            this.f2571a.f3179c.h("runtime.counter", new k(Double.valueOf(0.0d)));
            this.f2574d.b(this.f2572b.d(), this.f2573c);
            return h() || g();
        } catch (Throwable th) {
            throw new d1(th);
        }
    }

    public final boolean g() {
        return !this.f2573c.f().isEmpty();
    }

    public final boolean h() {
        return !this.f2573c.d().equals(this.f2573c.a());
    }
}
