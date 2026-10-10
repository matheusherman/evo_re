package o1;

import android.content.Context;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.TelemetryData;
import e2.g;
import e2.h;
import k1.n;
import m1.k;
import m1.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d extends f implements k {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.g f16437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a.AbstractC0042a f16438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final com.google.android.gms.common.api.a f16439m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f16440n = 0;

    static {
        com.google.android.gms.common.api.a.g gVar = new com.google.android.gms.common.api.a.g();
        f16437k = gVar;
        c cVar = new c();
        f16438l = cVar;
        f16439m = new com.google.android.gms.common.api.a("ClientTelemetry.API", cVar, gVar);
    }

    public d(Context context, l lVar) {
        super(context, f16439m, lVar, f.a.f2176c);
    }

    @Override // m1.k
    public final g<Void> a(final TelemetryData telemetryData) {
        n.a aVarA = n.a();
        aVarA.d(x1.f.f20535a);
        aVarA.c(false);
        aVarA.b(new k1.l() { // from class: o1.b
            /* JADX WARN: Multi-variable type inference failed */
            @Override // k1.l
            public final void accept(Object obj, Object obj2) {
                int i10 = d.f16440n;
                ((a) ((e) obj).B()).X(telemetryData);
                ((h) obj2).c(null);
            }
        });
        return c(aVarA.a());
    }
}
