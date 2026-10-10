package t6;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f18920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18923e;

    public String a() {
        return this.f18923e;
    }

    public int b() {
        return this.f18921c;
    }

    public String c() {
        return this.f18920b;
    }

    public void d(ByteBuffer byteBuffer) {
        int i10 = byteBuffer.getInt();
        this.f18919a = i10;
        if (i10 > 0) {
            byte[] bArr = new byte[i10];
            byteBuffer.get(bArr);
            this.f18920b = new String(bArr);
        }
        this.f18921c = byteBuffer.getInt();
        int i11 = byteBuffer.getInt();
        this.f18922d = i11;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            byteBuffer.get(bArr2);
            this.f18923e = new String(bArr2);
        }
    }
}
