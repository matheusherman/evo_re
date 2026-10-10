package ee;

import fc.o1;
import fd.g;
import fd.h;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f9935b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f9936b2;
    private me.a[] layers;
    private int[] vi;

    public a(je.a aVar) {
        this(aVar.c(), aVar.a(), aVar.d(), aVar.b(), aVar.f(), aVar.e());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean zEquals = ne.a.j(this.A1inv, aVar.c()) && ne.a.j(this.A2inv, aVar.d()) && ne.a.i(this.f9935b1, aVar.a()) && ne.a.i(this.f9936b2, aVar.b()) && Arrays.equals(this.vi, aVar.f());
        if (this.layers.length != aVar.e().length) {
            return false;
        }
        for (int length = this.layers.length - 1; length >= 0; length--) {
            zEquals &= this.layers[length].equals(aVar.e()[length]);
        }
        return zEquals;
    }

    public a(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, me.a[] aVarArr) {
        this.A1inv = sArr;
        this.f9935b1 = sArr2;
        this.A2inv = sArr3;
        this.f9936b2 = sArr4;
        this.vi = iArr;
        this.layers = aVarArr;
    }

    public short[] a() {
        return this.f9935b1;
    }

    public short[] b() {
        return this.f9936b2;
    }

    public short[][] c() {
        return this.A1inv;
    }

    public short[][] d() {
        return this.A2inv;
    }

    public me.a[] e() {
        return this.layers;
    }

    public int[] f() {
        return this.vi;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new pc.b(new rc.a(g.f10277a, o1.f10200b), new h(this.A1inv, this.f9935b1, this.A2inv, this.f9936b2, this.vi, this.layers)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        int length = (((((((((this.layers.length * 37) + re.a.q(this.A1inv)) * 37) + re.a.p(this.f9935b1)) * 37) + re.a.q(this.A2inv)) * 37) + re.a.p(this.f9936b2)) * 37) + re.a.o(this.vi);
        for (int length2 = this.layers.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.layers[length2].hashCode();
        }
        return length;
    }
}
