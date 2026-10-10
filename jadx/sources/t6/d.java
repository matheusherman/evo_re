package t6;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f18931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f18933d;

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f18930a);
        if (this.f18930a > 0) {
            byteBuffer.put(this.f18931b);
        }
        byteBuffer.putInt(this.f18932c);
        if (this.f18932c > 0) {
            byteBuffer.put(this.f18933d);
        }
    }

    public int b() {
        return this.f18930a + 8 + this.f18932c;
    }

    public void c(byte[] bArr) {
        this.f18931b = bArr;
    }

    public void d(int i10) {
        this.f18930a = i10;
    }

    public void e(int i10) {
        this.f18932c = i10;
    }

    public void f(byte[] bArr) {
        this.f18933d = bArr;
    }
}
