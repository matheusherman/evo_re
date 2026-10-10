package s4;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class m extends com.koushikdutta.async.q {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f18325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f18326h = 2;

    protected void z() {
        throw null;
    }

    public void A(String str) {
        this.f18325g = ("\r\n--" + str).getBytes();
    }

    @Override // com.koushikdutta.async.q, o4.b
    public void i(com.koushikdutta.async.n nVar, com.koushikdutta.async.l lVar) {
        if (this.f18326h > 0) {
            ByteBuffer byteBufferR = com.koushikdutta.async.l.r(this.f18325g.length);
            byteBufferR.put(this.f18325g, 0, this.f18326h);
            byteBufferR.flip();
            lVar.c(byteBufferR);
            this.f18326h = 0;
        }
        int iA = lVar.A();
        byte[] bArr = new byte[iA];
        lVar.h(bArr);
        int i10 = 0;
        int i11 = 0;
        while (i10 < iA) {
            int i12 = this.f18326h;
            if (i12 >= 0) {
                byte b10 = bArr[i10];
                byte[] bArr2 = this.f18325g;
                if (b10 == bArr2[i12]) {
                    int i13 = i12 + 1;
                    this.f18326h = i13;
                    if (i13 == bArr2.length) {
                        this.f18326h = -1;
                    }
                } else if (i12 > 0) {
                    i10 -= i12;
                    this.f18326h = 0;
                }
            } else if (i12 == -1) {
                byte b11 = bArr[i10];
                if (b11 == 13) {
                    this.f18326h = -4;
                    int length = (i10 - i11) - this.f18325g.length;
                    if (i11 != 0 || length != 0) {
                        ByteBuffer byteBufferPut = com.koushikdutta.async.l.r(length).put(bArr, i11, length);
                        byteBufferPut.flip();
                        com.koushikdutta.async.l lVar2 = new com.koushikdutta.async.l();
                        lVar2.a(byteBufferPut);
                        super.i(this, lVar2);
                    }
                    z();
                } else {
                    if (b11 != 45) {
                        w(new o("Invalid multipart/form-data. Expected \r or -"));
                        return;
                    }
                    this.f18326h = -2;
                }
            } else if (i12 == -2) {
                if (bArr[i10] != 45) {
                    w(new o("Invalid multipart/form-data. Expected -"));
                    return;
                }
                this.f18326h = -3;
            } else if (i12 == -3) {
                if (bArr[i10] != 13) {
                    w(new o("Invalid multipart/form-data. Expected \r"));
                    return;
                }
                this.f18326h = -4;
                int i14 = i10 - i11;
                ByteBuffer byteBufferPut2 = com.koushikdutta.async.l.r((i14 - this.f18325g.length) - 2).put(bArr, i11, (i14 - this.f18325g.length) - 2);
                byteBufferPut2.flip();
                com.koushikdutta.async.l lVar3 = new com.koushikdutta.async.l();
                lVar3.a(byteBufferPut2);
                super.i(this, lVar3);
                y();
            } else if (i12 != -4) {
                w(new o("Invalid multipart/form-data. Unknown state?"));
            } else if (bArr[i10] == 10) {
                i11 = i10 + 1;
                this.f18326h = 0;
            } else {
                w(new o("Invalid multipart/form-data. Expected \n"));
            }
            i10++;
        }
        if (i11 < iA) {
            int iMax = (iA - i11) - Math.max(this.f18326h, 0);
            ByteBuffer byteBufferPut3 = com.koushikdutta.async.l.r(iMax).put(bArr, i11, iMax);
            byteBufferPut3.flip();
            com.koushikdutta.async.l lVar4 = new com.koushikdutta.async.l();
            lVar4.a(byteBufferPut3);
            super.i(this, lVar4);
        }
    }

    protected void y() {
    }
}
