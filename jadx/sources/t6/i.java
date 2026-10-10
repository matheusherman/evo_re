package t6;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18940c;

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f18938a);
        byteBuffer.putInt(this.f18939b);
        byteBuffer.putLong(this.f18940c);
    }

    public int b() {
        return 16;
    }

    public long c() {
        return this.f18940c;
    }

    public InetSocketAddress e() {
        StringBuffer stringBuffer = new StringBuffer();
        u6.a.a(stringBuffer, this.f18938a);
        return new InetSocketAddress(stringBuffer.toString(), this.f18939b);
    }

    public void d(ByteBuffer byteBuffer) {
        this.f18938a = byteBuffer.getInt();
        this.f18939b = byteBuffer.getInt();
        this.f18940c = byteBuffer.getLong();
    }
}
