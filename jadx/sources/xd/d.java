package xd;

import com.taobao.sophix.PatchStatus;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class d implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, d> f22072c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22074b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67, 20, 2), new d(1, "XMSSMT_SHA2_20/2_256"));
        map.put(b("SHA-256", 32, 16, 67, 20, 4), new d(2, "XMSSMT_SHA2_20/4_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 2), new d(3, "XMSSMT_SHA2_40/2_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 4), new d(4, "XMSSMT_SHA2_40/4_256"));
        map.put(b("SHA-256", 32, 16, 67, 40, 8), new d(5, "XMSSMT_SHA2_40/8_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 3), new d(6, "XMSSMT_SHA2_60/3_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 6), new d(7, "XMSSMT_SHA2_60/6_256"));
        map.put(b("SHA-256", 32, 16, 67, 60, 12), new d(8, "XMSSMT_SHA2_60/12_256"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20, 2), new d(9, "XMSSMT_SHA2_20/2_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20, 4), new d(10, "XMSSMT_SHA2_20/4_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 2), new d(11, "XMSSMT_SHA2_40/2_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 4), new d(12, "XMSSMT_SHA2_40/4_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 8), new d(13, "XMSSMT_SHA2_40/8_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 3), new d(14, "XMSSMT_SHA2_60/3_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 6), new d(15, "XMSSMT_SHA2_60/6_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 12), new d(16, "XMSSMT_SHA2_60/12_512"));
        map.put(b("SHAKE128", 32, 16, 67, 20, 2), new d(17, "XMSSMT_SHAKE_20/2_256"));
        map.put(b("SHAKE128", 32, 16, 67, 20, 4), new d(18, "XMSSMT_SHAKE_20/4_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 2), new d(19, "XMSSMT_SHAKE_40/2_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 4), new d(20, "XMSSMT_SHAKE_40/4_256"));
        map.put(b("SHAKE128", 32, 16, 67, 40, 8), new d(21, "XMSSMT_SHAKE_40/8_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 3), new d(22, "XMSSMT_SHAKE_60/3_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 6), new d(23, "XMSSMT_SHAKE_60/6_256"));
        map.put(b("SHAKE128", 32, 16, 67, 60, 12), new d(24, "XMSSMT_SHAKE_60/12_256"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20, 2), new d(25, "XMSSMT_SHAKE_20/2_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20, 4), new d(26, "XMSSMT_SHAKE_20/4_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 2), new d(27, "XMSSMT_SHAKE_40/2_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 4), new d(28, "XMSSMT_SHAKE_40/4_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 40, 8), new d(29, "XMSSMT_SHAKE_40/8_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 3), new d(30, "XMSSMT_SHAKE_60/3_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 6), new d(31, "XMSSMT_SHAKE_60/6_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 60, 12), new d(32, "XMSSMT_SHAKE_60/12_512"));
        f22072c = Collections.unmodifiableMap(map);
    }

    private static String b(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str == null) {
            throw new NullPointerException("algorithmName == null");
        }
        return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13 + "-" + i14;
    }

    public static d c(String str, int i10, int i11, int i12, int i13, int i14) {
        if (str != null) {
            return f22072c.get(b(str, i10, i11, i12, i13, i14));
        }
        throw new NullPointerException("algorithmName == null");
    }

    @Override // xd.w
    public int a() {
        return this.f22073a;
    }

    public String toString() {
        return this.f22074b;
    }

    private d(int i10, String str) {
        this.f22073a = i10;
        this.f22074b = str;
    }
}
