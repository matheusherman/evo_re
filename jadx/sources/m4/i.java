package m4;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.google.zxing.client.android.R$id;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f15628k = "i";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n4.g f15629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f15630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f15631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f15632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f15633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Rect f15634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f15635g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f15636h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler.Callback f15637i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final n4.p f15638j = new b();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == R$id.zxing_decode) {
                i.this.g((q) message.obj);
                return true;
            }
            if (i10 != R$id.zxing_preview_failed) {
                return true;
            }
            i.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements n4.p {
        b() {
        }

        @Override // n4.p
        public void a(Exception exc) {
            synchronized (i.this.f15636h) {
                try {
                    if (i.this.f15635g) {
                        i.this.f15631c.obtainMessage(R$id.zxing_preview_failed).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // n4.p
        public void b(q qVar) {
            synchronized (i.this.f15636h) {
                try {
                    if (i.this.f15635g) {
                        i.this.f15631c.obtainMessage(R$id.zxing_decode, qVar).sendToTarget();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f15629a.s(this.f15638j);
    }

    protected h3.j f(q qVar) {
        if (this.f15634f == null) {
            return null;
        }
        return qVar.a();
    }

    public void i(Rect rect) {
        this.f15634f = rect;
    }

    public void j(f fVar) {
        this.f15632d = fVar;
    }

    public i(n4.g gVar, f fVar, Handler handler) {
        r.a();
        this.f15629a = gVar;
        this.f15632d = fVar;
        this.f15633e = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(q qVar) {
        h3.q qVarC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        qVar.d(this.f15634f);
        h3.j jVarF = f(qVar);
        if (jVarF != null) {
            qVarC = this.f15632d.c(jVarF);
        } else {
            qVarC = null;
        }
        if (qVarC != null) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Log.d(f15628k, "Found barcode in " + (jCurrentTimeMillis2 - jCurrentTimeMillis) + " ms");
            if (this.f15633e != null) {
                Message messageObtain = Message.obtain(this.f15633e, R$id.zxing_decode_succeeded, new m4.b(qVarC, qVar));
                messageObtain.setData(new Bundle());
                messageObtain.sendToTarget();
            }
        } else {
            Handler handler = this.f15633e;
            if (handler != null) {
                Message.obtain(handler, R$id.zxing_decode_failed).sendToTarget();
            }
        }
        if (this.f15633e != null) {
            Message.obtain(this.f15633e, R$id.zxing_possible_result_points, m4.b.e(this.f15632d.d(), qVar)).sendToTarget();
        }
        h();
    }

    public void k() {
        r.a();
        HandlerThread handlerThread = new HandlerThread(f15628k);
        this.f15630b = handlerThread;
        handlerThread.start();
        this.f15631c = new Handler(this.f15630b.getLooper(), this.f15637i);
        this.f15635g = true;
        h();
    }

    public void l() {
        r.a();
        synchronized (this.f15636h) {
            this.f15635g = false;
            this.f15631c.removeCallbacksAndMessages(null);
            this.f15630b.quit();
        }
    }
}
