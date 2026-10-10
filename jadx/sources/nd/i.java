package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class i extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f16386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f16387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f16388d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f16389e;

    public i(k kVar, e eVar, byte[] bArr, byte[] bArr2) {
        super(false);
        this.f16386b = kVar;
        this.f16387c = eVar;
        this.f16388d = re.a.d(bArr2);
        this.f16389e = re.a.d(bArr);
    }

    public static i a(Object obj) throws Throwable {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            k kVarE = k.e(dataInputStream.readInt());
            e eVarE = e.e(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[kVarE.d()];
            dataInputStream.readFully(bArr2);
            return new i(kVarE, eVarE, bArr2, bArr);
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
                i iVarA = a(dataInputStream3);
                dataInputStream3.close();
                return iVarA;
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
        i iVar = (i) obj;
        if (this.f16386b.equals(iVar.f16386b) && this.f16387c.equals(iVar.f16387c) && re.a.a(this.f16388d, iVar.f16388d)) {
            return re.a.a(this.f16389e, iVar.f16389e);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f16386b.hashCode() * 31) + this.f16387c.hashCode()) * 31) + re.a.l(this.f16388d)) * 31) + re.a.l(this.f16389e);
    }

    byte[] b() {
        return a.f().i(this.f16386b.f()).i(this.f16387c.f()).d(this.f16388d).d(this.f16389e).b();
    }

    @Override // nd.g, re.c
    public byte[] getEncoded() {
        return b();
    }
}
