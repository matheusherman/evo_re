package m3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f15610a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f15614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15615f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f15612c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BroadcastReceiver f15611b = new b(this, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f15613d = new Handler();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    final class b extends BroadcastReceiver {
        private b() {
        }

        /* synthetic */ b(h hVar, a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z10 = intent.getIntExtra("plugged", -1) <= 0;
                h.this.f15613d.post(new Runnable() { // from class: m3.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.f(z10);
                    }
                });
            }
        }
    }

    private void e() {
        this.f15613d.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(boolean z10) {
        this.f15615f = z10;
        if (this.f15612c) {
            c();
        }
    }

    private void g() {
        if (this.f15612c) {
            return;
        }
        this.f15610a.registerReceiver(this.f15611b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f15612c = true;
    }

    private void i() {
        if (this.f15612c) {
            this.f15610a.unregisterReceiver(this.f15611b);
            this.f15612c = false;
        }
    }

    public h(Context context, Runnable runnable) {
        this.f15610a = context;
        this.f15614e = runnable;
    }

    public void c() {
        e();
        if (this.f15615f) {
            this.f15613d.postDelayed(this.f15614e, 300000L);
        }
    }

    public void d() {
        e();
        i();
    }

    public void h() {
        g();
        c();
    }
}
