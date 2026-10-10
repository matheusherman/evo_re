package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l1 extends l {
    private byte[] C() {
        byte[] bArr = this.f10184a;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!z()) {
            byte[] bArr2 = this.f10184a;
            byte[] bArr3 = new byte[bArr2.length + 4];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(re.h.d("0000Z"), 0, bArr3, this.f10184a.length - 1, 5);
            return bArr3;
        }
        if (!A()) {
            byte[] bArr4 = this.f10184a;
            byte[] bArr5 = new byte[bArr4.length + 2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(re.h.d("00Z"), 0, bArr5, this.f10184a.length - 1, 3);
            return bArr5;
        }
        if (!y()) {
            return this.f10184a;
        }
        int length = this.f10184a.length - 2;
        while (length > 0 && this.f10184a[length] == 48) {
            length--;
        }
        byte[] bArr6 = this.f10184a;
        if (bArr6[length] == 46) {
            byte[] bArr7 = new byte[length + 1];
            System.arraycopy(bArr6, 0, bArr7, 0, length);
            bArr7[length] = 90;
            return bArr7;
        }
        byte[] bArr8 = new byte[length + 2];
        int i10 = length + 1;
        System.arraycopy(bArr6, 0, bArr8, 0, i10);
        bArr8[i10] = 90;
        return bArr8;
    }

    @Override // fc.l, fc.z
    void n(x xVar, boolean z10) {
        xVar.o(z10, 24, C());
    }

    public l1(byte[] bArr) {
        super(bArr);
    }

    @Override // fc.l, fc.z
    int s(boolean z10) {
        return x.g(z10, C().length);
    }

    @Override // fc.l, fc.z
    z v() {
        return this;
    }

    @Override // fc.z
    z w() {
        return this;
    }
}
