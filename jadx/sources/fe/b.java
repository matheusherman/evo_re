package fe;

import fc.u;
import fd.g;
import fd.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PublicKey;
import wd.d;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements PublicKey, Key {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient u f10349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ud.c f10350b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f10349a.t(bVar.f10349a) && re.a.a(this.f10350b.b(), bVar.f10350b.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f10350b.a() != null ? d.a(this.f10350b) : new rc.b(new rc.a(g.f10294r, new j(new rc.a(this.f10349a))), this.f10350b.b())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return this.f10349a.hashCode() + (re.a.l(this.f10350b.b()) * 37);
    }

    public b(rc.b bVar) {
        a(bVar);
    }

    private void a(rc.b bVar) {
        this.f10349a = j.m(bVar.m().o()).n().m();
        this.f10350b = (ud.c) wd.c.a(bVar);
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
