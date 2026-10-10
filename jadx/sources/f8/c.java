package f8;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g8.h;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f10069a = e8.a.d(new Callable() { // from class: f8.b
        @Override // java.util.concurrent.Callable
        public final Object call() {
            return c.a.f10070a;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final h f10070a = c.c(Looper.getMainLooper(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static h c(Looper looper, boolean z10) {
        int i10 = Build.VERSION.SDK_INT;
        if (z10 && i10 < 22) {
            Message messageObtain = Message.obtain();
            try {
                messageObtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z10 = false;
            }
            messageObtain.recycle();
        }
        return new d(new Handler(looper), z10);
    }

    public static h d() {
        return e8.a.e(f10069a);
    }
}
