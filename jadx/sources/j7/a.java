package j7;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f11645c = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11646a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11647b = 0;

    public synchronized void e(Context context) {
        try {
            if (this.f11646a == null) {
                if (context == null) {
                    return;
                }
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    this.f11646a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                } else {
                    this.f11646a = context;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static a b() {
        return f11645c;
    }

    public String c() {
        return "" + a();
    }

    public Context f() {
        return this.f11646a;
    }

    private a() {
    }

    public long a() {
        return System.currentTimeMillis() + this.f11647b;
    }

    public void d(long j10) {
        this.f11647b = j10 - System.currentTimeMillis();
    }
}
