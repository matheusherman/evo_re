package xd;

import com.taobao.sophix.PatchStatus;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class e implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, e> f22075c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22077b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67, 10), new e(1, "XMSS_SHA2_10_256"));
        map.put(b("SHA-256", 32, 16, 67, 16), new e(2, "XMSS_SHA2_16_256"));
        map.put(b("SHA-256", 32, 16, 67, 20), new e(3, "XMSS_SHA2_20_256"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 10), new e(4, "XMSS_SHA2_10_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 16), new e(5, "XMSS_SHA2_16_512"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20), new e(6, "XMSS_SHA2_20_512"));
        map.put(b("SHAKE128", 32, 16, 67, 10), new e(7, "XMSS_SHAKE_10_256"));
        map.put(b("SHAKE128", 32, 16, 67, 16), new e(8, "XMSS_SHAKE_16_256"));
        map.put(b("SHAKE128", 32, 16, 67, 20), new e(9, "XMSS_SHAKE_20_256"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 10), new e(10, "XMSS_SHAKE_10_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 16), new e(11, "XMSS_SHAKE_16_512"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED, 20), new e(12, "XMSS_SHAKE_20_512"));
        f22075c = Collections.unmodifiableMap(map);
    }

    private static String b(String str, int i10, int i11, int i12, int i13) {
        if (str == null) {
            throw new NullPointerException("algorithmName == null");
        }
        return str + "-" + i10 + "-" + i11 + "-" + i12 + "-" + i13;
    }

    public static e c(String str, int i10, int i11, int i12, int i13) {
        if (str != null) {
            return f22075c.get(b(str, i10, i11, i12, i13));
        }
        throw new NullPointerException("algorithmName == null");
    }

    @Override // xd.w
    public int a() {
        return this.f22076a;
    }

    public String toString() {
        return this.f22077b;
    }

    private e(int i10, String str) {
        this.f22076a = i10;
        this.f22077b = str;
    }
}
