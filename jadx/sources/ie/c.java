package ie;

import fc.d0;
import fc.u;
import fd.k;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import xd.y;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c implements PrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient y f11355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient u f11356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient d0 f11357c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f11356b.t(cVar.f11356b) && re.a.a(this.f11355a.c(), cVar.f11355a.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return wd.b.a(this.f11355a, this.f11357c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f11356b.hashCode() + (re.a.l(this.f11355a.c()) * 37);
    }

    public c(pc.b bVar) {
        a(bVar);
    }

    private void a(pc.b bVar) {
        this.f11357c = bVar.m();
        this.f11356b = k.n(bVar.o().o()).o().m();
        this.f11355a = (y) wd.a.b(bVar);
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
