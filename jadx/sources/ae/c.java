package ae;

import java.io.IOException;
import java.security.PrivateKey;
import oe.h;
import oe.i;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c implements PrivateKey {
    private static final long serialVersionUID = 1;
    private ke.f params;

    public oe.b a() {
        return this.params.a();
    }

    public i b() {
        return this.params.b();
    }

    public int c() {
        return this.params.c();
    }

    public int d() {
        return this.params.d();
    }

    public h e() {
        return this.params.e();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return d() == cVar.d() && c() == cVar.c() && a().equals(cVar.a()) && b().equals(cVar.b()) && g().equals(cVar.g()) && e().equals(cVar.e()) && f().equals(cVar.f());
    }

    public h f() {
        return this.params.f();
    }

    public oe.a g() {
        return this.params.g();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new pc.b(new rc.a(fd.g.f10289m), new fd.e(this.params.d(), this.params.c(), this.params.a(), this.params.b(), this.params.e(), this.params.f(), this.params.g())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return (((((((((((this.params.c() * 37) + this.params.d()) * 37) + this.params.a().hashCode()) * 37) + this.params.b().hashCode()) * 37) + this.params.e().hashCode()) * 37) + this.params.f().hashCode()) * 37) + this.params.g().hashCode();
    }

    public c(ke.f fVar) {
        this.params = fVar;
    }
}
