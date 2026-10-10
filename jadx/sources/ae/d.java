package ae;

import java.io.IOException;
import java.security.PublicKey;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d implements PublicKey {
    private static final long serialVersionUID = 1;
    private ke.g params;

    public oe.a a() {
        return this.params.a();
    }

    public int b() {
        return this.params.b();
    }

    public int c() {
        return this.params.c();
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.params.b() == dVar.b() && this.params.c() == dVar.c() && this.params.a().equals(dVar.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new rc.b(new rc.a(fd.g.f10289m), new fd.f(this.params.b(), this.params.c(), this.params.a())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return ((this.params.b() + (this.params.c() * 37)) * 37) + this.params.a().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.params.b() + "\n") + " error correction capability: " + this.params.c() + "\n") + " generator matrix           : " + this.params.a();
    }

    public d(ke.g gVar) {
        this.params = gVar;
    }
}
