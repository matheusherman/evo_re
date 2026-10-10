package t6;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18935b;

    public String a() {
        return this.f18935b;
    }

    public void b(ByteBuffer byteBuffer) {
        int i10 = byteBuffer.getInt();
        this.f18934a = i10;
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            byteBuffer.get(bArr);
            this.f18935b = new String(bArr, StandardCharsets.UTF_8);
        }
    }
}
