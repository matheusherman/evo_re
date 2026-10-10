package fc;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e2 implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o2 f10146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10147b = 0;

    @Override // fc.d
    public InputStream g() {
        return a(false);
    }

    private InputStream a(boolean z10) throws IOException {
        int iC = this.f10146a.c();
        if (iC < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int i10 = this.f10146a.read();
        this.f10147b = i10;
        if (i10 > 0) {
            if (iC < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (i10 > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z10) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f10147b);
            }
        }
        return this.f10146a;
    }

    @Override // fc.d
    public int h() {
        return this.f10147b;
    }

    @Override // fc.p2
    public z i() {
        return c.x(this.f10146a.f());
    }

    e2(o2 o2Var) {
        this.f10146a = o2Var;
    }

    @Override // fc.f
    public z f() {
        try {
            return i();
        } catch (IOException e10) {
            throw new y("IOException converting stream to byte array: " + e10.getMessage(), e10);
        }
    }
}
