package m3;

import android.content.Intent;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f15599a = Pattern.compile(",");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Set<h3.a> f15600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Set<h3.a> f15601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<h3.a> f15602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Set<h3.a> f15603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Set<h3.a> f15604f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Set<h3.a> f15605g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Set<h3.a> f15606h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<String, Set<h3.a>> f15607i;

    static {
        EnumSet enumSetOf = EnumSet.of(h3.a.QR_CODE);
        f15603e = enumSetOf;
        EnumSet enumSetOf2 = EnumSet.of(h3.a.DATA_MATRIX);
        f15604f = enumSetOf2;
        EnumSet enumSetOf3 = EnumSet.of(h3.a.AZTEC);
        f15605g = enumSetOf3;
        EnumSet enumSetOf4 = EnumSet.of(h3.a.PDF_417);
        f15606h = enumSetOf4;
        EnumSet enumSetOf5 = EnumSet.of(h3.a.UPC_A, h3.a.UPC_E, h3.a.EAN_13, h3.a.EAN_8, h3.a.RSS_14, h3.a.RSS_EXPANDED);
        f15600b = enumSetOf5;
        EnumSet enumSetOf6 = EnumSet.of(h3.a.CODE_39, h3.a.CODE_93, h3.a.CODE_128, h3.a.ITF, h3.a.CODABAR);
        f15601c = enumSetOf6;
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) enumSetOf5);
        f15602d = enumSetCopyOf;
        enumSetCopyOf.addAll(enumSetOf6);
        HashMap map = new HashMap();
        f15607i = map;
        map.put("ONE_D_MODE", enumSetCopyOf);
        map.put("PRODUCT_MODE", enumSetOf5);
        map.put("QR_CODE_MODE", enumSetOf);
        map.put("DATA_MATRIX_MODE", enumSetOf2);
        map.put("AZTEC_MODE", enumSetOf3);
        map.put("PDF417_MODE", enumSetOf4);
    }

    public static Set<h3.a> a(Intent intent) {
        String stringExtra = intent.getStringExtra("SCAN_FORMATS");
        return b(stringExtra != null ? Arrays.asList(f15599a.split(stringExtra)) : null, intent.getStringExtra("SCAN_MODE"));
    }

    private static Set<h3.a> b(Iterable<String> iterable, String str) {
        if (iterable != null) {
            EnumSet enumSetNoneOf = EnumSet.noneOf(h3.a.class);
            try {
                Iterator<String> it = iterable.iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.add(h3.a.valueOf(it.next()));
                }
                return enumSetNoneOf;
            } catch (IllegalArgumentException unused) {
            }
        }
        if (str != null) {
            return f15607i.get(str);
        }
        return null;
    }
}
