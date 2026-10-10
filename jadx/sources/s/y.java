package s;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class y {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final boolean f18214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f18215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final File f18216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile y f18217j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile int f18218k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f18221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private int f18222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private boolean f18223e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f18224f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f18219a = f();

    private synchronized boolean d() {
        try {
            boolean z10 = true;
            int i10 = this.f18222d + 1;
            this.f18222d = i10;
            if (i10 >= 50) {
                this.f18222d = 0;
                int length = f18216i.list().length;
                long jC = c();
                if (length >= jC) {
                    z10 = false;
                }
                this.f18223e = z10;
                if (!z10 && Log.isLoggable("Downsampler", 5)) {
                    Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18223e;
    }

    public boolean e(int i10, int i11, boolean z10, boolean z11) {
        if (!z10) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.f18219a) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!f18215h) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z11) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i12 = this.f18221c;
        if (i10 < i12) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i11 < i12) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f18214g = i10 < 29;
        f18215h = i10 >= 26;
        f18216i = new File("/proc/self/fd");
        f18218k = -1;
    }

    private boolean a() {
        return f18214g && !this.f18224f.get();
    }

    public static y b() {
        if (f18217j == null) {
            synchronized (y.class) {
                try {
                    if (f18217j == null) {
                        f18217j = new y();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18217j;
    }

    private int c() {
        return f18218k != -1 ? f18218k : this.f18220b;
    }

    private static boolean g() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        Iterator it = Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play").iterator();
        while (it.hasNext()) {
            if (Build.MODEL.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    private static boolean h() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    @VisibleForTesting
    y() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f18220b = 20000;
            this.f18221c = 0;
        } else {
            this.f18220b = 700;
            this.f18221c = 128;
        }
    }

    private static boolean f() {
        if (!g() && !h()) {
            return true;
        }
        return false;
    }

    @TargetApi(26)
    boolean i(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean zE = e(i10, i11, z10, z11);
        if (zE) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zE;
    }
}
