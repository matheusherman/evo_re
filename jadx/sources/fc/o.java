package fc;

import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class o extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f10196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[][] f10197c;

    public o(InputStream inputStream, int i10) {
        this(inputStream, i10, false);
    }

    static z d(int i10, o2 o2Var, byte[][] bArr) throws IOException {
        switch (i10) {
            case 1:
                return e.x(i(o2Var, bArr));
            case 2:
                return p.x(o2Var.f());
            case 3:
                return c.x(o2Var.f());
            case 4:
                return v.x(o2Var.f());
            case 5:
                return q.x(o2Var.f());
            case 6:
                return u.y(i(o2Var, bArr), true);
            case 7:
                return t.x(o2Var.f());
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 17:
            case 29:
            default:
                throw new IOException("unknown tag " + i10 + " encountered");
            case 10:
                return h.x(i(o2Var, bArr), true);
            case 12:
                return k0.x(o2Var.f());
            case 13:
                return b0.x(o2Var.f(), false);
            case 18:
                return r.x(o2Var.f());
            case 19:
                return a0.x(o2Var.f());
            case 20:
                return f0.x(o2Var.f());
            case 21:
                return o0.x(o2Var.f());
            case 22:
                return n.x(o2Var.f());
            case 23:
                return j0.x(o2Var.f());
            case 24:
                return l.x(o2Var.f());
            case 25:
                return m.x(o2Var.f());
            case 26:
                return p0.x(o2Var.f());
            case 27:
                return k.x(o2Var.f());
            case 28:
                return l0.x(o2Var.f());
            case 30:
                return b.y(f(o2Var));
        }
    }

    public o(InputStream inputStream, int i10, boolean z10) {
        this(inputStream, i10, z10, new byte[11][]);
    }

    static int m(InputStream inputStream, int i10) throws IOException {
        int i11 = i10 & 31;
        if (i11 != 31) {
            return i11;
        }
        int i12 = inputStream.read();
        if (i12 < 31) {
            if (i12 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        int i13 = i12 & 127;
        if (i13 == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((i12 & 128) != 0) {
            if ((i13 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            int i14 = i13 << 7;
            int i15 = inputStream.read();
            if (i15 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            i13 = i14 | (i15 & 127);
            i12 = i15;
        }
        return i13;
    }

    protected z c(int i10, int i11, int i12) throws IOException {
        o2 o2Var = new o2(this, i12, this.f10195a);
        if ((i10 & 224) == 0) {
            return d(i11, o2Var, this.f10197c);
        }
        int i13 = i10 & RsaOaep.DerParser.PRIVATE;
        if (i13 != 0) {
            return n(i13, i11, (i10 & 32) != 0, o2Var);
        }
        if (i11 == 3) {
            return a(p(o2Var));
        }
        if (i11 == 4) {
            return b(p(o2Var));
        }
        if (i11 == 8) {
            return g2.a(p(o2Var)).D();
        }
        if (i11 == 16) {
            if (o2Var.c() < 1) {
                return g2.f10156a;
            }
            return this.f10196b ? new s2(o2Var.f()) : g2.a(p(o2Var));
        }
        if (i11 == 17) {
            return g2.b(p(o2Var));
        }
        throw new IOException("unknown tag " + i11 + " encountered");
    }

    protected int j() {
        return k(this, this.f10195a, false);
    }

    z n(int i10, int i11, boolean z10, o2 o2Var) {
        return !z10 ? h0.A(i10, i11, o2Var.f()) : h0.y(i10, i11, p(o2Var));
    }

    private o(InputStream inputStream, int i10, boolean z10, byte[][] bArr) {
        super(inputStream);
        this.f10195a = i10;
        this.f10196b = z10;
        this.f10197c = bArr;
    }

    private static char[] f(o2 o2Var) throws IOException {
        int iC = o2Var.c();
        if ((iC & 1) == 0) {
            int i10 = iC / 2;
            char[] cArr = new char[i10];
            byte[] bArr = new byte[8];
            int i11 = 0;
            int i12 = 0;
            while (iC >= 8) {
                if (te.a.d(o2Var, bArr, 0, 8) == 8) {
                    cArr[i12] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
                    cArr[i12 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
                    cArr[i12 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
                    cArr[i12 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
                    i12 += 4;
                    iC -= 8;
                } else {
                    throw new EOFException("EOF encountered in middle of BMPString");
                }
            }
            if (iC > 0) {
                if (te.a.d(o2Var, bArr, 0, iC) == iC) {
                    do {
                        int i13 = i11 + 1;
                        int i14 = bArr[i11] << 8;
                        i11 += 2;
                        cArr[i12] = (char) ((bArr[i13] & 255) | i14);
                        i12++;
                    } while (i11 < iC);
                } else {
                    throw new EOFException("EOF encountered in middle of BMPString");
                }
            }
            if (o2Var.c() == 0 && i10 == i12) {
                return cArr;
            }
            throw new IllegalStateException();
        }
        throw new IOException("malformed BMPString encoding encountered");
    }

    private static byte[] i(o2 o2Var, byte[][] bArr) throws IOException {
        int iC = o2Var.c();
        if (iC >= bArr.length) {
            return o2Var.f();
        }
        byte[] bArr2 = bArr[iC];
        if (bArr2 == null) {
            bArr2 = new byte[iC];
            bArr[iC] = bArr2;
        }
        o2Var.d(bArr2);
        return bArr2;
    }

    static int k(InputStream inputStream, int i10, boolean z10) throws IOException {
        int i11 = inputStream.read();
        if ((i11 >>> 7) == 0) {
            return i11;
        }
        if (128 == i11) {
            return -1;
        }
        if (i11 >= 0) {
            if (255 != i11) {
                int i12 = i11 & 127;
                int i13 = 0;
                int i14 = 0;
                do {
                    int i15 = inputStream.read();
                    if (i15 >= 0) {
                        if ((i13 >>> 23) == 0) {
                            i13 = (i13 << 8) + i15;
                            i14++;
                        } else {
                            throw new IOException("long form definite-length more than 31 bits");
                        }
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                } while (i14 < i12);
                if (i13 >= i10 && !z10) {
                    throw new IOException("corrupted stream - out of bounds length found: " + i13 + " >= " + i10);
                }
                return i13;
            }
            throw new IOException("invalid long form definite-length 0xFF");
        }
        throw new EOFException("EOF found when length expected");
    }

    c a(g gVar) throws i {
        int iF = gVar.f();
        c[] cVarArr = new c[iF];
        for (int i10 = 0; i10 != iF; i10++) {
            f fVarD = gVar.d(i10);
            if (fVarD instanceof c) {
                cVarArr[i10] = (c) fVarD;
            } else {
                throw new i("unknown object encountered in constructed BIT STRING: " + fVarD.getClass());
            }
        }
        return new s0(cVarArr);
    }

    v b(g gVar) throws i {
        int iF = gVar.f();
        v[] vVarArr = new v[iF];
        for (int i10 = 0; i10 != iF; i10++) {
            f fVarD = gVar.d(i10);
            if (fVarD instanceof v) {
                vVarArr[i10] = (v) fVarD;
            } else {
                throw new i("unknown object encountered in constructed OCTET STRING: " + fVarD.getClass());
            }
        }
        return new v0(vVarArr);
    }

    public z l() {
        int i10 = read();
        if (i10 <= 0) {
            if (i10 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iM = m(this, i10);
        int iJ = j();
        if (iJ >= 0) {
            try {
                return c(i10, iM, iJ);
            } catch (IllegalArgumentException e10) {
                throw new i("corrupted stream detected", e10);
            }
        }
        if ((i10 & 32) != 0) {
            e0 e0Var = new e0(new q2(this, this.f10195a), this.f10195a, this.f10197c);
            int i11 = i10 & RsaOaep.DerParser.PRIVATE;
            if (i11 != 0) {
                return e0Var.c(i11, iM);
            }
            if (iM != 3) {
                if (iM != 4) {
                    if (iM != 8) {
                        if (iM != 16) {
                            if (iM == 17) {
                                return a1.a(e0Var);
                            }
                            throw new IOException("unknown BER object encountered");
                        }
                        return y0.a(e0Var);
                    }
                    return j1.a(e0Var);
                }
                return w0.a(e0Var);
            }
            return t0.a(e0Var);
        }
        throw new IOException("indefinite-length primitive encoding encountered");
    }

    g o() {
        z zVarL = l();
        if (zVarL == null) {
            return new g(0);
        }
        g gVar = new g();
        do {
            gVar.a(zVarL);
            zVarL = l();
        } while (zVarL != null);
        return gVar;
    }

    g p(o2 o2Var) {
        int iC = o2Var.c();
        if (iC < 1) {
            return new g(0);
        }
        return new o(o2Var, iC, this.f10196b, this.f10197c).o();
    }

    public o(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public o(byte[] bArr, boolean z10) {
        this(new ByteArrayInputStream(bArr), bArr.length, z10);
    }
}
