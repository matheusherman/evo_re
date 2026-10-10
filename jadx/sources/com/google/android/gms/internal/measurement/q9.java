package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class q9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile q9 f2963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final q9 f2964c = new q9(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<a, ea.f<?, ?>> f2965a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f2966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f2967b;

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2966a == aVar.f2966a && this.f2967b == aVar.f2967b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f2966a) * 65535) + this.f2967b;
        }

        a(Object obj, int i10) {
            this.f2966a = obj;
            this.f2967b = i10;
        }
    }

    q9() {
        this.f2965a = new HashMap();
    }

    public static q9 a() {
        q9 q9Var = f2963b;
        if (q9Var != null) {
            return q9Var;
        }
        synchronized (q9.class) {
            try {
                q9 q9Var2 = f2963b;
                if (q9Var2 != null) {
                    return q9Var2;
                }
                q9 q9VarB = ca.b(q9.class);
                f2963b = q9VarB;
                return q9VarB;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <ContainingType extends ob> ea.f<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (ea.f) this.f2965a.get(new a(containingtype, i10));
    }

    private q9(boolean z10) {
        this.f2965a = Collections.EMPTY_MAP;
    }
}
