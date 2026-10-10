package fc;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class d0 extends z implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final m0 f10127c = new a(d0.class, 17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final f[] f10128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f10129b;

    protected d0() {
        this.f10128a = g.f10150d;
        this.f10129b = true;
    }

    private static void A(f[] fVarArr) {
        int i10;
        int length = fVarArr.length;
        if (length < 2) {
            return;
        }
        f fVar = fVarArr[0];
        f fVar2 = fVarArr[1];
        byte[] bArrX = x(fVar);
        byte[] bArrX2 = x(fVar2);
        if (z(bArrX2, bArrX)) {
            fVar2 = fVar;
            fVar = fVar2;
            bArrX2 = bArrX;
            bArrX = bArrX2;
        }
        for (int i11 = 2; i11 < length; i11++) {
            f fVar3 = fVarArr[i11];
            byte[] bArrX3 = x(fVar3);
            if (z(bArrX2, bArrX3)) {
                fVarArr[i11 - 2] = fVar;
                fVar = fVar2;
                bArrX = bArrX2;
                fVar2 = fVar3;
                bArrX2 = bArrX3;
            } else if (z(bArrX, bArrX3)) {
                fVarArr[i11 - 2] = fVar;
                fVar = fVar3;
                bArrX = bArrX3;
            } else {
                int i12 = i11 - 1;
                while (true) {
                    i10 = i12 - 1;
                    if (i10 <= 0) {
                        break;
                    }
                    f fVar4 = fVarArr[i12 - 2];
                    if (z(x(fVar4), bArrX3)) {
                        break;
                    }
                    fVarArr[i10] = fVar4;
                    i12 = i10;
                }
                fVarArr[i10] = fVar3;
            }
        }
        fVarArr[length - 2] = fVar;
        fVarArr[length - 1] = fVar2;
    }

    private static boolean z(byte[] bArr, byte[] bArr2) {
        int i10 = bArr[0] & (-33);
        int i11 = bArr2[0] & (-33);
        if (i10 != i11) {
            return i10 < i11;
        }
        int iMin = Math.min(bArr.length, bArr2.length) - 1;
        for (int i12 = 1; i12 < iMin; i12++) {
            byte b10 = bArr[i12];
            byte b11 = bArr2[i12];
            if (b10 != b11) {
                return (b10 & 255) < (b11 & 255);
            }
        }
        return (bArr[iMin] & 255) <= (bArr2[iMin] & 255);
    }

    @Override // fc.z
    boolean o() {
        return true;
    }

    static class a extends m0 {
        a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // fc.m0
        z c(c0 c0Var) {
            return c0Var.H();
        }
    }

    protected d0(g gVar, boolean z10) {
        f[] fVarArrG;
        if (gVar == null) {
            throw new NullPointerException("'elementVector' cannot be null");
        }
        if (!z10 || gVar.f() < 2) {
            fVarArrG = gVar.g();
        } else {
            fVarArrG = gVar.c();
            A(fVarArrG);
        }
        this.f10128a = fVarArrG;
        this.f10129b = z10 || fVarArrG.length < 2;
    }

    public static d0 y(h0 h0Var, boolean z10) {
        return (d0) f10127c.e(h0Var, z10);
    }

    public f[] B() {
        return g.b(this.f10128a);
    }

    @Override // fc.z, fc.s
    public int hashCode() {
        int length = this.f10128a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode += this.f10128a[length].f().hashCode();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<f> iterator() {
        return new re.a.C0346a(B());
    }

    @Override // fc.z
    boolean m(z zVar) {
        if (!(zVar instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) zVar;
        int size = size();
        if (d0Var.size() != size) {
            return false;
        }
        v1 v1Var = (v1) v();
        v1 v1Var2 = (v1) d0Var.v();
        for (int i10 = 0; i10 < size; i10++) {
            z zVarF = v1Var.f10128a[i10].f();
            z zVarF2 = v1Var2.f10128a[i10].f();
            if (zVarF != zVarF2 && !zVarF.m(zVarF2)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        return this.f10128a.length;
    }

    @Override // fc.z
    z v() {
        f[] fVarArr;
        if (this.f10129b) {
            fVarArr = this.f10128a;
        } else {
            fVarArr = (f[]) this.f10128a.clone();
            A(fVarArr);
        }
        return new v1(true, fVarArr);
    }

    @Override // fc.z
    z w() {
        return new k2(this.f10129b, this.f10128a);
    }

    d0(boolean z10, f[] fVarArr) {
        this.f10128a = fVarArr;
        this.f10129b = z10 || fVarArr.length < 2;
    }

    private static byte[] x(f fVar) {
        try {
            return fVar.f().k("DER");
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return "[]";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f10128a[i10]);
            i10++;
            if (i10 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }
}
