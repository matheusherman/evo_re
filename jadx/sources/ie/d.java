package ie;

import fc.u;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import xd.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements PublicKey {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient z f11358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient u f11359b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            try {
                if (this.f11359b.t(dVar.f11359b) && re.a.a(this.f11358a.getEncoded(), dVar.f11358a.getEncoded())) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return wd.d.a(this.f11358a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        try {
            return this.f11359b.hashCode() + (re.a.l(this.f11358a.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.f11359b.hashCode();
        }
    }

    public d(rc.b bVar) {
        a(bVar);
    }

    private void a(rc.b bVar) {
        z zVar = (z) wd.c.a(bVar);
        this.f11358a = zVar;
        this.f11359b = e.a(zVar.a());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(rc.b.n((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
