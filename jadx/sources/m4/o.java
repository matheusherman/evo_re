package m4;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager f15650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private OrientationEventListener f15651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n f15652d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends OrientationEventListener {
        a(Context context, int i10) {
            super(context, i10);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i10) {
            int rotation;
            WindowManager windowManager = o.this.f15650b;
            n nVar = o.this.f15652d;
            if (o.this.f15650b == null || nVar == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == o.this.f15649a) {
                return;
            }
            o.this.f15649a = rotation;
            nVar.a(rotation);
        }
    }

    public void f() {
        OrientationEventListener orientationEventListener = this.f15651c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f15651c = null;
        this.f15650b = null;
        this.f15652d = null;
    }

    public void e(Context context, n nVar) {
        f();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f15652d = nVar;
        this.f15650b = (WindowManager) origApplicationContext.getSystemService("window");
        a aVar = new a(origApplicationContext, 3);
        this.f15651c = aVar;
        aVar.enable();
        this.f15649a = this.f15650b.getDefaultDisplay().getRotation();
    }
}
