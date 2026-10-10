package t6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f18925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f18926c;

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f18924a);
        if (this.f18924a > 0) {
            byteBuffer.put(this.f18925b);
        }
    }

    public int b() {
        return this.f18924a + 4;
    }

    public void c(Map<String, String> map) {
        this.f18926c = map;
        if (map == null || map.isEmpty()) {
            this.f18924a = 0;
            return;
        }
        byte[] bytes = com.google.common.base.h.b(" , ").d(" = ").e(map).getBytes(StandardCharsets.UTF_8);
        this.f18924a = bytes.length;
        this.f18925b = bytes;
    }
}
