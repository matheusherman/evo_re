package t6;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private short f18964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private i f18965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f18967f;

    public String a() {
        return this.f18967f;
    }

    public int b() {
        return this.f18966e;
    }

    public i c() {
        return this.f18965d;
    }

    public String d() {
        return this.f18963b;
    }

    public short e() {
        return this.f18964c;
    }

    public void f(ByteBuffer byteBuffer) {
        int i10 = byteBuffer.getInt();
        this.f18962a = i10;
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            byteBuffer.get(bArr);
            this.f18963b = new String(bArr);
        }
        short s10 = byteBuffer.getShort();
        this.f18964c = s10;
        if (s10 > 0) {
            i iVar = new i();
            this.f18965d = iVar;
            iVar.d(byteBuffer);
        }
        int i11 = byteBuffer.getInt();
        this.f18966e = i11;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            byteBuffer.get(bArr2);
            this.f18967f = new String(bArr2);
        }
    }
}
