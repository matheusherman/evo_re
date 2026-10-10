package l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f15162b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).recycle();
            return true;
        }

        a() {
        }
    }

    synchronized void a(v<?> vVar, boolean z10) {
        try {
            if (this.f15161a || z10) {
                this.f15162b.obtainMessage(1, vVar).sendToTarget();
            } else {
                this.f15161a = true;
                vVar.recycle();
                this.f15161a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    y() {
    }
}
