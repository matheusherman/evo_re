package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class s0 extends c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10220d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c[] f10221e;

    public s0(byte[] bArr, int i10) {
        this(bArr, i10, 1000);
    }

    static byte[] D(c[] cVarArr) {
        int length = cVarArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return cVarArr[0].f10119a;
        }
        int i10 = length - 1;
        int length2 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            byte[] bArr = cVarArr[i11].f10119a;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            length2 += bArr.length - 1;
        }
        byte[] bArr2 = cVarArr[i10].f10119a;
        byte b10 = bArr2[0];
        byte[] bArr3 = new byte[length2 + bArr2.length];
        bArr3[0] = b10;
        int i12 = 1;
        for (c cVar : cVarArr) {
            byte[] bArr4 = cVar.f10119a;
            int length3 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i12, length3);
            i12 += length3;
        }
        return bArr3;
    }

    public s0(byte[] bArr, int i10, int i11) {
        super(bArr, i10);
        this.f10221e = null;
        this.f10220d = i11;
    }

    @Override // fc.z
    boolean o() {
        return this.f10221e != null || this.f10119a.length > this.f10220d;
    }

    public s0(c[] cVarArr) {
        this(cVarArr, 1000);
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        x xVar2;
        if (!o()) {
            byte[] bArr = this.f10119a;
            d2.E(xVar, z10, bArr, 0, bArr.length);
            return;
        }
        xVar.s(z10, 35);
        xVar.i(128);
        c[] cVarArr = this.f10221e;
        if (cVarArr != null) {
            xVar.v(cVarArr);
        } else {
            byte[] bArr2 = this.f10119a;
            if (bArr2.length >= 2) {
                byte b10 = bArr2[0];
                int length = bArr2.length;
                int i10 = length - 1;
                int i11 = this.f10220d - 1;
                while (i10 > i11) {
                    x xVar3 = xVar;
                    d2.D(xVar3, true, (byte) 0, this.f10119a, length - i10, i11);
                    i10 -= i11;
                    xVar = xVar3;
                }
                xVar2 = xVar;
                d2.D(xVar2, true, b10, this.f10119a, length - i10, i10);
            }
            xVar2.i(0);
            xVar2.i(0);
        }
        xVar2 = xVar;
        xVar2.i(0);
        xVar2.i(0);
    }

    @Override // fc.z
    int s(boolean z10) {
        int iS;
        if (!o()) {
            return d2.H(z10, this.f10119a.length);
        }
        if (z10) {
            iS = 4;
        } else {
            iS = 3;
        }
        if (this.f10221e != null) {
            int i10 = 0;
            while (true) {
                c[] cVarArr = this.f10221e;
                if (i10 < cVarArr.length) {
                    iS += cVarArr[i10].s(true);
                    i10++;
                } else {
                    return iS;
                }
            }
        } else {
            byte[] bArr = this.f10119a;
            if (bArr.length < 2) {
                return iS;
            }
            int length = bArr.length - 2;
            int i11 = this.f10220d;
            int i12 = length / (i11 - 1);
            return iS + (d2.H(true, i11) * i12) + d2.H(true, this.f10119a.length - (i12 * (this.f10220d - 1)));
        }
    }

    public s0(c[] cVarArr, int i10) {
        super(D(cVarArr), false);
        this.f10221e = cVarArr;
        this.f10220d = i10;
    }
}
