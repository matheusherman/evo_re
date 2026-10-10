package xd;

import com.taobao.sophix.PatchStatus;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class l implements w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, l> f22103c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f22104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22105b;

    static {
        HashMap map = new HashMap();
        map.put(b("SHA-256", 32, 16, 67), new l(16777217, "WOTSP_SHA2-256_W16"));
        map.put(b("SHA-512", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED), new l(33554434, "WOTSP_SHA2-512_W16"));
        map.put(b("SHAKE128", 32, 16, 67), new l(50331651, "WOTSP_SHAKE128_W16"));
        map.put(b("SHAKE256", 64, 16, PatchStatus.CODE_LOAD_LIB_UNDEFINED), new l(67108868, "WOTSP_SHAKE256_W16"));
        f22103c = Collections.unmodifiableMap(map);
    }

    private static String b(String str, int i10, int i11, int i12) {
        if (str == null) {
            throw new NullPointerException("algorithmName == null");
        }
        return str + "-" + i10 + "-" + i11 + "-" + i12;
    }

    protected static l c(String str, int i10, int i11, int i12) {
        if (str != null) {
            return f22103c.get(b(str, i10, i11, i12));
        }
        throw new NullPointerException("algorithmName == null");
    }

    @Override // xd.w
    public int a() {
        return this.f22104a;
    }

    public String toString() {
        return this.f22105b;
    }

    private l(int i10, String str) {
        this.f22104a = i10;
        this.f22105b = str;
    }
}
