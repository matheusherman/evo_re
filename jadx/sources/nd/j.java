package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class j implements re.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f16391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f16392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[][] f16393d;

    public static j a(Object obj) throws Throwable {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            int i10 = dataInputStream.readInt();
            f fVarA = f.a(obj);
            k kVarE = k.e(dataInputStream.readInt());
            int iC = kVarE.c();
            byte[][] bArr = new byte[iC][];
            for (int i11 = 0; i11 < iC; i11++) {
                byte[] bArr2 = new byte[kVarE.d()];
                bArr[i11] = bArr2;
                dataInputStream.readFully(bArr2);
            }
            return new j(i10, fVarA, kVarE, bArr);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(te.a.c((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                j jVarA = a(dataInputStream3);
                dataInputStream3.close();
                return jVarA;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f16390a != jVar.f16390a) {
            return false;
        }
        f fVar = this.f16391b;
        if (fVar == null ? jVar.f16391b != null : !fVar.equals(jVar.f16391b)) {
            return false;
        }
        k kVar = this.f16392c;
        if (kVar == null ? jVar.f16392c == null : kVar.equals(jVar.f16392c)) {
            return Arrays.deepEquals(this.f16393d, jVar.f16393d);
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.f16390a * 31;
        f fVar = this.f16391b;
        int iHashCode = (i10 + (fVar != null ? fVar.hashCode() : 0)) * 31;
        k kVar = this.f16392c;
        return ((iHashCode + (kVar != null ? kVar.hashCode() : 0)) * 31) + Arrays.deepHashCode(this.f16393d);
    }

    public j(int i10, f fVar, k kVar, byte[][] bArr) {
        this.f16390a = i10;
        this.f16391b = fVar;
        this.f16392c = kVar;
        this.f16393d = bArr;
    }

    @Override // re.c
    public byte[] getEncoded() {
        return a.f().i(this.f16390a).d(this.f16391b.getEncoded()).i(this.f16392c.f()).e(this.f16393d).b();
    }
}
