package nd;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i f16357c;

    public d(int i10, i iVar) {
        super(false);
        this.f16356b = i10;
        this.f16357c = iVar;
    }

    public static d a(Object obj) throws Throwable {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj instanceof DataInputStream) {
            return new d(((DataInputStream) obj).readInt(), i.a(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return a(te.a.c((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                d dVarA = a(dataInputStream2);
                dataInputStream2.close();
                return dVarA;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public int b() {
        return this.f16356b;
    }

    public i c() {
        return this.f16357c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f16356b != dVar.f16356b) {
            return false;
        }
        return this.f16357c.equals(dVar.f16357c);
    }

    public int hashCode() {
        return (this.f16356b * 31) + this.f16357c.hashCode();
    }

    @Override // nd.g, re.c
    public byte[] getEncoded() {
        return a.f().i(this.f16356b).d(this.f16357c.getEncoded()).b();
    }
}
