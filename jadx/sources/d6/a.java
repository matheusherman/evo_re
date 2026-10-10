package d6;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f9642d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f9644b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0171a f9645c;

    /* JADX INFO: renamed from: d6.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0171a {
    }

    public static a a(Context context) {
        if (f9642d == null) {
            f9642d = new a(context);
        }
        return f9642d;
    }

    public void b(InterfaceC0171a interfaceC0171a) {
        this.f9645c = interfaceC0171a;
    }

    private a(Context context) {
        this.f9643a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public void c() {
    }
}
