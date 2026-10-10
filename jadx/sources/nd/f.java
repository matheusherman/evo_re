package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class f implements re.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f16370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f16371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f16372c;

    public static f a(Object obj) throws Throwable {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            e eVarE = e.e(dataInputStream.readInt());
            byte[] bArr = new byte[eVarE.c()];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[eVarE.d() * eVarE.c()];
            dataInputStream.readFully(bArr2);
            return new f(eVarE, bArr, bArr2);
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
                f fVarA = a(dataInputStream3);
                dataInputStream3.close();
                return fVarA;
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
        f fVar = (f) obj;
        e eVar = this.f16370a;
        if (eVar == null ? fVar.f16370a != null : !eVar.equals(fVar.f16370a)) {
            return false;
        }
        if (Arrays.equals(this.f16371b, fVar.f16371b)) {
            return Arrays.equals(this.f16372c, fVar.f16372c);
        }
        return false;
    }

    public int hashCode() {
        e eVar = this.f16370a;
        return ((((eVar != null ? eVar.hashCode() : 0) * 31) + Arrays.hashCode(this.f16371b)) * 31) + Arrays.hashCode(this.f16372c);
    }

    public f(e eVar, byte[] bArr, byte[] bArr2) {
        this.f16370a = eVar;
        this.f16371b = bArr;
        this.f16372c = bArr2;
    }

    @Override // re.c
    public byte[] getEncoded() {
        return a.f().i(this.f16370a.f()).d(this.f16371b).d(this.f16372c).b();
    }
}
