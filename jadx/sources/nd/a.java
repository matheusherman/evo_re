package nd;

import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f16346a = new ByteArrayOutputStream();

    public a e(byte[][] bArr) {
        try {
            for (byte[] bArr2 : bArr) {
                this.f16346a.write(bArr2);
            }
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public static a f() {
        return new a();
    }

    public a a(boolean z10) {
        this.f16346a.write(z10 ? 1 : 0);
        return this;
    }

    public byte[] b() {
        return this.f16346a.toByteArray();
    }

    public a c(re.c cVar) {
        try {
            this.f16346a.write(cVar.getEncoded());
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a d(byte[] bArr) {
        try {
            this.f16346a.write(bArr);
            return this;
        } catch (Exception e10) {
            throw new RuntimeException(e10.getMessage(), e10);
        }
    }

    public a g(int i10, int i11) {
        while (this.f16346a.size() < i11) {
            this.f16346a.write(i10);
        }
        return this;
    }

    public a i(int i10) {
        this.f16346a.write((byte) (i10 >>> 24));
        this.f16346a.write((byte) (i10 >>> 16));
        this.f16346a.write((byte) (i10 >>> 8));
        this.f16346a.write((byte) i10);
        return this;
    }

    public a j(long j10) {
        i((int) (j10 >>> 32));
        i((int) j10);
        return this;
    }

    private a() {
    }

    public a h(int i10) {
        int i11 = i10 & 65535;
        this.f16346a.write((byte) (i11 >>> 8));
        this.f16346a.write((byte) i11);
        return this;
    }
}
