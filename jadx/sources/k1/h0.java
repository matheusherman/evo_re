package k1;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class h0 implements e2.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f12028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f12030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f12032e;

    @Override // e2.c
    @WorkerThread
    public final void a(@NonNull e2.g gVar) {
        z zVarS;
        int version;
        int i10;
        int i11;
        int i12;
        int iJ;
        long j10;
        long jCurrentTimeMillis;
        int iElapsedRealtime;
        if (this.f12028a.d()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = m1.h.b().a();
            if ((rootTelemetryConfigurationA == null || rootTelemetryConfigurationA.P()) && (zVarS = this.f12028a.s(this.f12030c)) != null && (zVarS.w() instanceof com.google.android.gms.common.internal.b)) {
                com.google.android.gms.common.internal.b bVar = (com.google.android.gms.common.internal.b) zVarS.w();
                boolean zS = this.f12031d > 0;
                int iX = bVar.x();
                if (rootTelemetryConfigurationA != null) {
                    zS &= rootTelemetryConfigurationA.S();
                    int iJ2 = rootTelemetryConfigurationA.J();
                    int iM = rootTelemetryConfigurationA.M();
                    version = rootTelemetryConfigurationA.getVersion();
                    if (bVar.H() && !bVar.d()) {
                        ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(zVarS, bVar, this.f12029b);
                        if (connectionTelemetryConfigurationC == null) {
                            return;
                        }
                        boolean z10 = connectionTelemetryConfigurationC.V() && this.f12031d > 0;
                        iM = connectionTelemetryConfigurationC.J();
                        zS = z10;
                    }
                    i10 = iJ2;
                    i11 = iM;
                } else {
                    version = 0;
                    i10 = 5000;
                    i11 = 100;
                }
                e eVar = this.f12028a;
                if (gVar.k()) {
                    i12 = 0;
                    iJ = 0;
                } else {
                    if (gVar.i()) {
                        i12 = 100;
                    } else {
                        Exception excG = gVar.g();
                        if (excG instanceof com.google.android.gms.common.api.b) {
                            Status statusA = ((com.google.android.gms.common.api.b) excG).a();
                            int iM2 = statusA.M();
                            ConnectionResult connectionResultJ = statusA.J();
                            if (connectionResultJ == null) {
                                i12 = iM2;
                            } else {
                                iJ = connectionResultJ.J();
                                i12 = iM2;
                            }
                        } else {
                            i12 = 101;
                        }
                    }
                    iJ = -1;
                }
                if (zS) {
                    long j11 = this.f12031d;
                    long j12 = this.f12032e;
                    j10 = j11;
                    jCurrentTimeMillis = System.currentTimeMillis();
                    iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j12);
                } else {
                    j10 = 0;
                    jCurrentTimeMillis = 0;
                    iElapsedRealtime = -1;
                }
                eVar.A(new MethodInvocation(this.f12029b, i12, iJ, j10, jCurrentTimeMillis, null, null, iX, iElapsedRealtime), version, i10, i11);
            }
        }
    }

    @VisibleForTesting
    h0(e eVar, int i10, b bVar, long j10, long j11, @Nullable String str, @Nullable String str2) {
        this.f12028a = eVar;
        this.f12029b = i10;
        this.f12030c = bVar;
        this.f12031d = j10;
        this.f12032e = j11;
    }

    @Nullable
    static h0 b(e eVar, int i10, b bVar) {
        boolean zS;
        long jCurrentTimeMillis;
        if (eVar.d()) {
            RootTelemetryConfiguration rootTelemetryConfigurationA = m1.h.b().a();
            if (rootTelemetryConfigurationA != null) {
                if (rootTelemetryConfigurationA.P()) {
                    zS = rootTelemetryConfigurationA.S();
                    z zVarS = eVar.s(bVar);
                    if (zVarS != null) {
                        if (zVarS.w() instanceof com.google.android.gms.common.internal.b) {
                            com.google.android.gms.common.internal.b bVar2 = (com.google.android.gms.common.internal.b) zVarS.w();
                            if (bVar2.H() && !bVar2.d()) {
                                ConnectionTelemetryConfiguration connectionTelemetryConfigurationC = c(zVarS, bVar2, i10);
                                if (connectionTelemetryConfigurationC != null) {
                                    zVarS.H();
                                    zS = connectionTelemetryConfigurationC.V();
                                } else {
                                    return null;
                                }
                            }
                        } else {
                            return null;
                        }
                    }
                } else {
                    return null;
                }
            } else {
                zS = true;
            }
            long jElapsedRealtime = 0;
            if (zS) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                jCurrentTimeMillis = 0;
            }
            if (zS) {
                jElapsedRealtime = SystemClock.elapsedRealtime();
            }
            return new h0(eVar, i10, bVar, jCurrentTimeMillis, jElapsedRealtime, null, null);
        }
        return null;
    }

    @Nullable
    private static ConnectionTelemetryConfiguration c(z zVar, com.google.android.gms.common.internal.b bVar, int i10) {
        int[] iArrM;
        int[] iArrP;
        ConnectionTelemetryConfiguration connectionTelemetryConfigurationF = bVar.F();
        if (connectionTelemetryConfigurationF == null || !connectionTelemetryConfigurationF.S() || ((iArrM = connectionTelemetryConfigurationF.M()) != null ? !com.google.android.gms.common.util.b.a(iArrM, i10) : !((iArrP = connectionTelemetryConfigurationF.P()) == null || !com.google.android.gms.common.util.b.a(iArrP, i10))) || zVar.t() >= connectionTelemetryConfigurationF.J()) {
            return null;
        }
        return connectionTelemetryConfigurationF;
    }
}
