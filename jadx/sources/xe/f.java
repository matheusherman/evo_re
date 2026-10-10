package xe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f extends Handler implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f22233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f22234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f22235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f22236d;

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarB = this.f22233a.b();
                if (jVarB == null) {
                    synchronized (this) {
                        jVarB = this.f22233a.b();
                        if (jVarB == null) {
                            this.f22236d = false;
                            return;
                        }
                    }
                }
                this.f22235c.g(jVarB);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f22234b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f22236d = true;
        } catch (Throwable th) {
            this.f22236d = false;
            throw th;
        }
    }

    public f(c cVar, Looper looper, int i10) {
        super(looper);
        this.f22235c = cVar;
        this.f22234b = i10;
        this.f22233a = new k();
    }

    @Override // xe.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            try {
                this.f22233a.a(jVarA);
                if (!this.f22236d) {
                    this.f22236d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new e("Could not send handler message");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
