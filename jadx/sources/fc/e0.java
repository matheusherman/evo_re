package fc;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f10140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[][] f10142c;

    f a(int i10) throws IOException {
        i(false);
        int iM = o.m(this.f10140a, i10);
        int iK = o.k(this.f10140a, this.f10141b, iM == 3 || iM == 4 || iM == 16 || iM == 17 || iM == 8);
        if (iK < 0) {
            if ((i10 & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            e0 e0Var = new e0(new q2(this.f10140a, this.f10141b), this.f10141b, this.f10142c);
            int i11 = i10 & RsaOaep.DerParser.PRIVATE;
            if (i11 != 0) {
                return 64 == i11 ? new r0(iM, e0Var) : new c1(i11, iM, e0Var);
            }
            return e0Var.e(iM);
        }
        o2 o2Var = new o2(this.f10140a, iK, this.f10141b);
        if ((i10 & 224) == 0) {
            return f(iM, o2Var);
        }
        e0 e0Var2 = new e0(o2Var, o2Var.a(), this.f10142c);
        int i12 = i10 & RsaOaep.DerParser.PRIVATE;
        if (i12 == 0) {
            return e0Var2.d(iM);
        }
        boolean z10 = (i10 & 32) != 0;
        return 64 == i12 ? (c2) e0Var2.b(i12, iM, z10) : new n2(i12, iM, z10, e0Var2);
    }

    f d(int i10) throws i {
        if (i10 == 3) {
            return new t0(this);
        }
        if (i10 == 4) {
            return new w0(this);
        }
        if (i10 == 8) {
            return new j1(this);
        }
        if (i10 == 16) {
            return new j2(this);
        }
        if (i10 == 17) {
            return new l2(this);
        }
        throw new i("unknown DL object encountered: 0x" + Integer.toHexString(i10));
    }

    f e(int i10) throws i {
        if (i10 == 3) {
            return new t0(this);
        }
        if (i10 == 4) {
            return new w0(this);
        }
        if (i10 == 8) {
            return new j1(this);
        }
        if (i10 == 16) {
            return new y0(this);
        }
        if (i10 == 17) {
            return new a1(this);
        }
        throw new i("unknown BER object encountered: 0x" + Integer.toHexString(i10));
    }

    f f(int i10, o2 o2Var) throws i {
        if (i10 == 3) {
            return new e2(o2Var);
        }
        if (i10 == 4) {
            return new r1(o2Var);
        }
        if (i10 == 8) {
            throw new i("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i10 == 16) {
            throw new i("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i10 == 17) {
            throw new i("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return o.d(i10, o2Var, this.f10142c);
        } catch (IllegalArgumentException e10) {
            throw new i("corrupted stream detected", e10);
        }
    }

    private void i(boolean z10) {
        InputStream inputStream = this.f10140a;
        if (inputStream instanceof q2) {
            ((q2) inputStream).d(z10);
        }
    }

    z b(int i10, int i11, boolean z10) {
        return !z10 ? h0.A(i10, i11, ((o2) this.f10140a).f()) : h0.y(i10, i11, h());
    }

    public f g() throws IOException {
        int i10 = this.f10140a.read();
        if (i10 < 0) {
            return null;
        }
        return a(i10);
    }

    g h() throws IOException {
        int i10 = this.f10140a.read();
        if (i10 < 0) {
            return new g(0);
        }
        g gVar = new g();
        do {
            f fVarA = a(i10);
            gVar.a(fVarA instanceof p2 ? ((p2) fVarA).i() : fVarA.f());
            i10 = this.f10140a.read();
        } while (i10 >= 0);
        return gVar;
    }

    e0(InputStream inputStream, int i10, byte[][] bArr) {
        this.f10140a = inputStream;
        this.f10141b = i10;
        this.f10142c = bArr;
    }

    z c(int i10, int i11) {
        return h0.z(i10, i11, h());
    }
}
