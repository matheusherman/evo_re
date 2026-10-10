package fc;

import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v0 extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v[] f10244e;

    public v0(byte[] bArr) {
        this(bArr, 1000);
    }

    static byte[] B(v[] vVarArr) {
        int length = vVarArr.length;
        if (length == 0) {
            return v.f10241c;
        }
        if (length == 1) {
            return vVarArr[0].f10242a;
        }
        int length2 = 0;
        for (v vVar : vVarArr) {
            length2 += vVar.f10242a.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (v vVar2 : vVarArr) {
            byte[] bArr2 = vVar2.f10242a;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    public v0(byte[] bArr, int i10) {
        this(bArr, null, i10);
    }

    @Override // fc.z
    boolean o() {
        return this.f10244e != null || this.f10242a.length > this.f10243d;
    }

    private v0(byte[] bArr, v[] vVarArr, int i10) {
        super(bArr);
        this.f10244e = vVarArr;
        this.f10243d = i10;
    }

    @Override // fc.z
    void n(x xVar, boolean z10) throws IOException {
        if (!o()) {
            byte[] bArr = this.f10242a;
            q1.B(xVar, z10, bArr, 0, bArr.length);
            return;
        }
        xVar.s(z10, 36);
        xVar.i(128);
        v[] vVarArr = this.f10244e;
        if (vVarArr != null) {
            xVar.v(vVarArr);
        } else {
            int i10 = 0;
            while (true) {
                byte[] bArr2 = this.f10242a;
                if (i10 >= bArr2.length) {
                    break;
                }
                int iMin = Math.min(bArr2.length - i10, this.f10243d);
                q1.B(xVar, true, this.f10242a, i10, iMin);
                i10 += iMin;
            }
        }
        xVar.i(0);
        xVar.i(0);
    }

    @Override // fc.z
    int s(boolean z10) {
        int iS;
        if (!o()) {
            return q1.C(z10, this.f10242a.length);
        }
        if (z10) {
            iS = 4;
        } else {
            iS = 3;
        }
        if (this.f10244e != null) {
            int i10 = 0;
            while (true) {
                v[] vVarArr = this.f10244e;
                if (i10 < vVarArr.length) {
                    iS += vVarArr[i10].s(true);
                    i10++;
                } else {
                    return iS;
                }
            }
        } else {
            int length = this.f10242a.length;
            int i11 = this.f10243d;
            int i12 = length / i11;
            int iC = iS + (q1.C(true, i11) * i12);
            int length2 = this.f10242a.length - (i12 * this.f10243d);
            if (length2 > 0) {
                return iC + q1.C(true, length2);
            }
            return iC;
        }
    }

    public v0(v[] vVarArr) {
        this(vVarArr, 1000);
    }

    public v0(v[] vVarArr, int i10) {
        this(B(vVarArr), vVarArr, i10);
    }
}
