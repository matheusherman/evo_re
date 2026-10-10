package x1.f1.lb.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class q0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final q6.b f21442c = q6.c.d(q0.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f21443a = Thread.getDefaultUncaughtExceptionHandler();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f21444b = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface a {
        void a(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Thread thread, Throwable th, boolean z10) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f21443a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void d(a aVar, Throwable th) {
        q6.b bVar = f21442c;
        bVar.error("uncaught error", th);
        if (th == null) {
            aVar.a(false);
            return;
        }
        File file = new File(b1.f21324a.b());
        if (!file.isDirectory() && !file.mkdirs()) {
            bVar.error("create directory failure:{}", file.getAbsolutePath(), th);
        }
        File file2 = new File(file, "crash_" + d1.d() + ".log");
        xe.c.c().o(new nf.y(file2.getAbsolutePath()));
        b(x1.f1.lb.config.b.f20643a.a());
        e(aVar, th, file2);
    }

    private void e(a aVar, Throwable th, File file) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : this.f21444b.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append("=");
            sb2.append(entry.getValue());
            sb2.append("\n");
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        while (true) {
            th = th.getCause();
            if (th == null) {
                printWriter.close();
                sb2.append(stringWriter);
                aVar.a(f(file, sb2.toString()));
                return;
            }
            th.printStackTrace(printWriter);
        }
    }

    public void b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
            if (packageInfo != null) {
                String str = packageInfo.versionName;
                if (str == null) {
                    str = Configurator.NULL;
                }
                String strValueOf = String.valueOf(packageInfo.versionCode);
                this.f21444b.put("versionName", str);
                this.f21444b.put("versionCode", strValueOf);
            }
        } catch (Throwable unused) {
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj = field.get(null);
                this.f21444b.put(field.getName(), obj == null ? Configurator.NULL : obj.toString());
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(@NonNull final Thread thread, @NonNull final Throwable th) {
        d(new a() { // from class: x1.f1.lb.util.p0
            @Override // x1.f1.lb.util.q0.a
            public final void a(boolean z10) {
                this.f21438a.c(thread, th, z10);
            }
        }, th);
    }

    private boolean f(File file, String str) {
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            if (file.isFile()) {
                file.setReadable(true);
                file.setWritable(true);
                file.setExecutable(true);
            }
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }
}
