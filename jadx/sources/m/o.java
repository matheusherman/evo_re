package m;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(19)
public class o implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f15453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f15454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f15455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f15456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f15457h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f15458a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<b, Bitmap> f15459b = new g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f15460c = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f15462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f15463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f15464c;

        @Override // m.m
        public void a() {
            this.f15462a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f15463b = i10;
            this.f15464c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f15463b == bVar.f15463b && e0.l.d(this.f15464c, bVar.f15464c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i10 = this.f15463b * 31;
            Bitmap.Config config = this.f15464c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.h(this.f15463b, this.f15464c);
        }

        public b(c cVar) {
            this.f15462a = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static class c extends m.c<b> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // m.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        c() {
        }

        public b e(int i10, Bitmap.Config config) {
            b bVarB = b();
            bVarB.b(i10, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f15453d = configArr;
        f15454e = configArr;
        f15455f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f15456g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f15457h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f15461a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f15461a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15461a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15461a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15461a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private b g(int i10, Bitmap.Config config) {
        b bVarE = this.f15458a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer numCeilingKey = j(config2).ceilingKey(Integer.valueOf(i10));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i10 * 8) {
                if (numCeilingKey.intValue() == i10 && (config2 != null ? config2.equals(config) : config == null)) {
                    break;
                    break;
                }
                this.f15458a.c(bVarE);
                return this.f15458a.e(numCeilingKey.intValue(), config2);
            }
        }
        return bVarE;
    }

    static String h(int i10, Bitmap.Config config) {
        return "[" + i10 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f15454e;
        }
        int i10 = a.f15461a[config.ordinal()];
        if (i10 == 1) {
            return f15453d;
        }
        if (i10 == 2) {
            return f15455f;
        }
        if (i10 != 3) {
            return i10 != 4 ? new Bitmap.Config[]{config} : f15457h;
        }
        return f15456g;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f15460c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f15460c.put(config, treeMap);
        return treeMap;
    }

    @Override // m.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f15459b.f();
        if (bitmapF != null) {
            f(Integer.valueOf(e0.l.h(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SizeConfigStrategy{groupedMap=");
        sb2.append(this.f15459b);
        sb2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f15460c.entrySet()) {
            sb2.append(entry.getKey());
            sb2.append('[');
            sb2.append(entry.getValue());
            sb2.append("], ");
        }
        if (!this.f15460c.isEmpty()) {
            sb2.replace(sb2.length() - 2, sb2.length(), "");
        }
        sb2.append(")}");
        return sb2.toString();
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num2 = navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + e(bitmap) + ", this: " + this);
    }

    @Override // m.l
    public String a(int i10, int i11, Bitmap.Config config) {
        return h(e0.l.g(i10, i11, config), config);
    }

    @Override // m.l
    public int b(Bitmap bitmap) {
        return e0.l.h(bitmap);
    }

    @Override // m.l
    public void c(Bitmap bitmap) {
        b bVarE = this.f15458a.e(e0.l.h(bitmap), bitmap.getConfig());
        this.f15459b.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num = navigableMapJ.get(Integer.valueOf(bVarE.f15463b));
        Integer numValueOf = Integer.valueOf(bVarE.f15463b);
        int iIntValue = 1;
        if (num != null) {
            iIntValue = 1 + num.intValue();
        }
        navigableMapJ.put(numValueOf, Integer.valueOf(iIntValue));
    }

    @Override // m.l
    @Nullable
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        b bVarG = g(e0.l.g(i10, i11, config), config);
        Bitmap bitmapA = this.f15459b.a(bVarG);
        if (bitmapA != null) {
            f(Integer.valueOf(bVarG.f15463b), bitmapA);
            bitmapA.reconfigure(i10, i11, config);
        }
        return bitmapA;
    }

    @Override // m.l
    public String e(Bitmap bitmap) {
        return h(e0.l.h(bitmap), bitmap.getConfig());
    }
}
