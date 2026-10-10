package n;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f15828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15829d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        static final int f15830i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f15831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ActivityManager f15832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c f15833c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f15835e;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        float f15834d = 2.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f15836f = 0.4f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f15837g = 0.33f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f15838h = 4194304;

        static {
            f15830i = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public i a() {
            return new i(this);
        }

        public a(Context context) {
            this.f15835e = f15830i;
            this.f15831a = context;
            this.f15832b = (ActivityManager) context.getSystemService("activity");
            this.f15833c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.e(this.f15832b)) {
                this.f15835e = 0.0f;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DisplayMetrics f15839a;

        @Override // n.i.c
        public int a() {
            return this.f15839a.heightPixels;
        }

        @Override // n.i.c
        public int b() {
            return this.f15839a.widthPixels;
        }

        b(DisplayMetrics displayMetrics) {
            this.f15839a = displayMetrics;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface c {
        int a();

        int b();
    }

    private String f(int i10) {
        return Formatter.formatFileSize(this.f15828c, i10);
    }

    public int a() {
        return this.f15829d;
    }

    public int b() {
        return this.f15826a;
    }

    public int d() {
        return this.f15827b;
    }

    i(a aVar) {
        int i10;
        boolean z10;
        this.f15828c = aVar.f15831a;
        if (e(aVar.f15832b)) {
            i10 = aVar.f15838h / 2;
        } else {
            i10 = aVar.f15838h;
        }
        this.f15829d = i10;
        int iC = c(aVar.f15832b, aVar.f15836f, aVar.f15837g);
        float fB = aVar.f15833c.b() * aVar.f15833c.a() * 4;
        int iRound = Math.round(aVar.f15835e * fB);
        int iRound2 = Math.round(fB * aVar.f15834d);
        int i11 = iC - i10;
        int i12 = iRound2 + iRound;
        if (i12 <= i11) {
            this.f15827b = iRound2;
            this.f15826a = iRound;
        } else {
            float f10 = i11;
            float f11 = aVar.f15835e;
            float f12 = aVar.f15834d;
            float f13 = f10 / (f11 + f12);
            this.f15827b = Math.round(f12 * f13);
            this.f15826a = Math.round(f13 * aVar.f15835e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Calculation complete, Calculated memory cache size: ");
            sb2.append(f(this.f15827b));
            sb2.append(", pool size: ");
            sb2.append(f(this.f15826a));
            sb2.append(", byte array size: ");
            sb2.append(f(i10));
            sb2.append(", memory class limited? ");
            if (i12 > iC) {
                z10 = true;
            } else {
                z10 = false;
            }
            sb2.append(z10);
            sb2.append(", max size: ");
            sb2.append(f(iC));
            sb2.append(", memoryClass: ");
            sb2.append(aVar.f15832b.getMemoryClass());
            sb2.append(", isLowMemoryDevice: ");
            sb2.append(e(aVar.f15832b));
            Log.d("MemorySizeCalculator", sb2.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (e(activityManager)) {
            f10 = f11;
        }
        return Math.round(memoryClass * f10);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
