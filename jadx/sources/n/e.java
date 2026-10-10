package n;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f15819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f15820c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g.b f15822e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f15821d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f15818a = new j();

    private synchronized g.b d() {
        try {
            if (this.f15822e == null) {
                this.f15822e = g.b.v(this.f15819b, 1, 1, this.f15820c);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f15822e;
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    @Override // n.a
    public void a(j.f fVar, a.b bVar) {
        String strB = this.f15818a.b(fVar);
        this.f15821d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                g.b bVarD = d();
                if (bVarD.t(strB) == null) {
                    g.b.c cVarQ = bVarD.q(strB);
                    if (cVarQ == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + strB);
                    }
                    try {
                        if (bVar.a(cVarQ.f(0))) {
                            cVarQ.e();
                        }
                        cVarQ.b();
                    } catch (Throwable th) {
                        cVarQ.b();
                        throw th;
                    }
                }
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            this.f15821d.b(strB);
        } catch (Throwable th2) {
            this.f15821d.b(strB);
            throw th2;
        }
    }

    @Override // n.a
    public File b(j.f fVar) {
        String strB = this.f15818a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            g.b.e eVarT = d().t(strB);
            if (eVarT != null) {
                return eVarT.a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    @Deprecated
    protected e(File file, long j10) {
        this.f15819b = file;
        this.f15820c = j10;
    }
}
