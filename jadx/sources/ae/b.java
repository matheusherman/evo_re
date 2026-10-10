package ae;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient ke.c f285a;

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.f285a.c() == bVar.b() && this.f285a.d() == bVar.c() && this.f285a.b().equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public oe.a a() {
        return this.f285a.b();
    }

    public int b() {
        return this.f285a.c();
    }

    public int c() {
        return this.f285a.d();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new rc.b(new rc.a(fd.g.f10290n), new fd.d(this.f285a.c(), this.f285a.d(), this.f285a.b(), cd.a.a(this.f285a.a()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.f285a.c() + (this.f285a.d() * 37)) * 37) + this.f285a.b().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f285a.c() + "\n") + " error correction capability: " + this.f285a.d() + "\n") + " generator matrix           : " + this.f285a.b().toString();
    }

    public b(ke.c cVar) {
        this.f285a = cVar;
    }

    private void d(rc.b bVar) {
        this.f285a = (ke.c) wd.c.a(bVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        d(rc.b.n((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }
}
