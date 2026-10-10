package ae;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import oe.h;
import oe.i;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient ke.b f284a;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof a)) {
            a aVar = (a) obj;
            if (e() == aVar.e() && d() == aVar.d() && a().equals(aVar.a()) && b().equals(aVar.b()) && f().equals(aVar.f()) && c().equals(aVar.c())) {
                return true;
            }
        }
        return false;
    }

    public oe.b a() {
        return this.f284a.b();
    }

    public i b() {
        return this.f284a.c();
    }

    public oe.a c() {
        return this.f284a.d();
    }

    public int d() {
        return this.f284a.e();
    }

    public int e() {
        return this.f284a.f();
    }

    public h f() {
        return this.f284a.g();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new pc.b(new rc.a(fd.g.f10290n), new fd.c(e(), d(), a(), b(), f(), cd.a.a(this.f284a.a()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((this.f284a.e() * 37) + this.f284a.f()) * 37) + this.f284a.b().hashCode()) * 37) + this.f284a.c().hashCode()) * 37) + this.f284a.g().hashCode()) * 37) + this.f284a.d().hashCode();
    }

    public a(ke.b bVar) {
        this.f284a = bVar;
    }

    private void g(pc.b bVar) {
        this.f284a = (ke.b) wd.a.b(bVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        g(pc.b.n((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
