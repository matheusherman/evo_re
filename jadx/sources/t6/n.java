package t6;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short f18953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<i> f18954b;

    public List<i> a() {
        return this.f18954b;
    }

    public short b() {
        return this.f18953a;
    }

    public void c(ByteBuffer byteBuffer) {
        short s10 = byteBuffer.getShort();
        this.f18953a = s10;
        if (s10 > 0) {
            this.f18954b = new ArrayList();
            for (int i10 = 0; i10 < this.f18953a; i10++) {
                i iVar = new i();
                iVar.d(byteBuffer);
                this.f18954b.add(iVar);
            }
        }
    }
}
