package t6;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18929c;

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f18927a);
        byteBuffer.putInt(this.f18928b);
        byteBuffer.putInt(this.f18929c);
    }

    public int b() {
        return 12;
    }

    public String toString() {
        return "Media{mediaHash=" + this.f18927a + ", size=" + this.f18928b + ", completePercentage=" + this.f18929c + '}';
    }
}
