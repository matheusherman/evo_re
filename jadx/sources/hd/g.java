package hd;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class g extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f10991c;

    public g(f fVar, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(true, fVar);
        byte[] bArr6 = new byte[bArr.length + bArr2.length + bArr3.length + bArr4.length + bArr5.length];
        this.f10991c = bArr6;
        System.arraycopy(bArr, 0, bArr6, 0, bArr.length);
        int length = bArr.length;
        System.arraycopy(bArr2, 0, bArr6, length, bArr2.length);
        int length2 = length + bArr2.length;
        System.arraycopy(bArr3, 0, bArr6, length2, bArr3.length);
        int length3 = length2 + bArr3.length;
        System.arraycopy(bArr4, 0, bArr6, length3, bArr4.length);
        System.arraycopy(bArr5, 0, bArr6, length3 + bArr4.length, bArr5.length);
    }

    public byte[] b() {
        return re.a.i(this.f10991c, (a().b() * 2) + 40, this.f10991c.length - 32);
    }

    public byte[] c() {
        return re.a.i(this.f10991c, 32, 40);
    }

    public byte[] d() {
        return re.a.i(this.f10991c, 0, 32);
    }

    public byte[] e() {
        return re.a.i(this.f10991c, 40, (a().b() * 2) + 40);
    }

    public byte[] f() {
        byte[] bArr = this.f10991c;
        return re.a.i(bArr, bArr.length - 32, bArr.length);
    }

    public byte[] getEncoded() {
        return re.a.d(this.f10991c);
    }

    public byte[] g() {
        d dVarA = a().a();
        byte[] bArr = new byte[dVarA.d()];
        dVarA.c(this.f10991c);
        return bArr;
    }
}
