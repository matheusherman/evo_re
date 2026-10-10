package ie;

import fc.d0;
import fc.u;
import fd.l;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import xd.s;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 7682140473044521395L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient u f11350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient s f11351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient d0 f11352c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f11350a.t(aVar.f11350a) && re.a.a(this.f11351b.c(), aVar.f11351b.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return wd.b.a(this.f11351b, this.f11352c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f11350a.hashCode() + (re.a.l(this.f11351b.c()) * 37);
    }

    public a(pc.b bVar) {
        a(bVar);
    }

    private void a(pc.b bVar) {
        this.f11352c = bVar.m();
        this.f11350a = l.n(bVar.o().o()).q().m();
        this.f11351b = (s) wd.a.b(bVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(pc.b.n((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
