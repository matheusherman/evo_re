package com.taobao.sophix;

import android.content.Context;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static d f8435e = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f8437b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f8436a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f8438c = h0.a((Context) j.f8458b, "happ_crash_num", 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f8439d = Thread.getDefaultUncaughtExceptionHandler();

    public static void a(boolean z10) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (z10 == f8435e.f8437b) {
            return;
        }
        f8435e.f8437b = z10;
        if (z10) {
            Thread.setDefaultUncaughtExceptionHandler(f8435e);
            s.a("CrashHandler", "set", "crash number", String.valueOf(f8435e.f8438c));
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        String string = Configurator.NULL;
        String string2 = defaultUncaughtExceptionHandler == null ? Configurator.NULL : defaultUncaughtExceptionHandler.toString();
        d dVar = f8435e;
        String string3 = dVar == null ? Configurator.NULL : dVar.toString();
        d dVar2 = f8435e;
        s.a("CrashHandler", "handlers", "current", string2, "sophix", string3, "origin", (dVar2 == null || (uncaughtExceptionHandler = dVar2.f8439d) == null) ? Configurator.NULL : uncaughtExceptionHandler.toString());
        d dVar3 = f8435e;
        if (defaultUncaughtExceptionHandler == dVar3) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = dVar3.f8439d;
            if (uncaughtExceptionHandler2 != null) {
                string = uncaughtExceptionHandler2.toString();
            }
            s.a("handler", "recove", string);
            Thread.setDefaultUncaughtExceptionHandler(f8435e.f8439d);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        s.e("CrashHandler", "crash happend", new Object[0]);
        if (f8435e.f8437b) {
            if (!(th instanceof OutOfMemoryError)) {
                this.f8436a = true;
                this.f8438c++;
                h0.b((Context) j.f8458b, "happ_crash_num", this.f8438c);
                s.e("CrashHandler", "crash is found", "crashNum", Integer.valueOf(this.f8438c));
            }
            a(false);
        }
        this.f8439d.uncaughtException(thread, th);
    }

    public static boolean b() {
        return f8435e.f8437b;
    }

    private d() {
    }

    public static boolean a() {
        return f8435e.f8436a;
    }
}
