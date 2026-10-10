package n4;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f15864i = "a";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final Collection<String> f15865j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f15866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Camera f15869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f15870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f15871f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler.Callback f15872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Camera.AutoFocusCallback f15873h;

    /* JADX INFO: renamed from: n4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class C0308a implements Handler.Callback {
        C0308a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != a.this.f15871f) {
                return false;
            }
            a.this.h();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements Camera.AutoFocusCallback {
        b() {
        }

        public static /* synthetic */ void a(b bVar) {
            a.this.f15867b = false;
            a.this.f();
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z10, Camera camera) {
            a.this.f15870e.post(new Runnable() { // from class: n4.b
                @Override // java.lang.Runnable
                public final void run() {
                    a.b.a(this.f15876a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (!this.f15866a && !this.f15870e.hasMessages(this.f15871f)) {
            Handler handler = this.f15870e;
            handler.sendMessageDelayed(handler.obtainMessage(this.f15871f), 2000L);
        }
    }

    public void i() {
        this.f15866a = false;
        h();
    }

    public void j() {
        this.f15866a = true;
        this.f15867b = false;
        g();
        if (this.f15868c) {
            try {
                this.f15869d.cancelAutoFocus();
            } catch (RuntimeException e10) {
                Log.w(f15864i, "Unexpected exception while cancelling focusing", e10);
            }
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        f15865j = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    private void g() {
        this.f15870e.removeMessages(this.f15871f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (!this.f15868c || this.f15866a || this.f15867b) {
            return;
        }
        try {
            this.f15869d.autoFocus(this.f15873h);
            this.f15867b = true;
        } catch (RuntimeException e10) {
            Log.w(f15864i, "Unexpected exception while focusing", e10);
            f();
        }
    }

    public a(Camera camera, i iVar) {
        C0308a c0308a = new C0308a();
        this.f15872g = c0308a;
        this.f15873h = new b();
        this.f15870e = new Handler(c0308a);
        this.f15869d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        boolean z10 = iVar.c() && f15865j.contains(focusMode);
        this.f15868c = z10;
        Log.i(f15864i, "Current focus mode '" + focusMode + "'; use auto focus? " + z10);
        i();
    }
}
