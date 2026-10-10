package fe;

import fc.d0;
import fc.q1;
import fc.u;
import fd.g;
import fd.j;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PrivateKey;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements PrivateKey, Key {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient u f10346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ud.b f10347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient d0 f10348c;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f10346a.t(aVar.f10346a) && re.a.a(this.f10347b.b(), aVar.f10347b.b())) {
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
            return (this.f10347b.a() != null ? wd.b.a(this.f10347b, this.f10348c) : new pc.b(new rc.a(g.f10294r, new j(new rc.a(this.f10346a))), new q1(this.f10347b.b()), this.f10348c)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f10346a.hashCode() + (re.a.l(this.f10347b.b()) * 37);
    }

    public a(pc.b bVar) {
        a(bVar);
    }

    private void a(pc.b bVar) {
        this.f10348c = bVar.m();
        this.f10346a = j.m(bVar.o().o()).n().m();
        this.f10347b = (ud.b) wd.a.b(bVar);
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
