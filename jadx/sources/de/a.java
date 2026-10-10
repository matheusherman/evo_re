package de;

import fc.d0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient le.a f9770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient d0 f9771b;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f9770a.b() == aVar.f9770a.b() && re.a.a(this.f9770a.a(), aVar.f9770a.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return le.c.a(this.f9770a.b());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return wd.b.a(this.f9770a, this.f9771b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f9770a.b() + (re.a.l(this.f9770a.a()) * 37);
    }

    public a(pc.b bVar) {
        a(bVar);
    }

    private void a(pc.b bVar) {
        this.f9771b = bVar.m();
        this.f9770a = (le.a) wd.a.b(bVar);
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
