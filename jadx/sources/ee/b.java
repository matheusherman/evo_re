package ee;

import fc.o1;
import fd.g;
import fd.i;
import java.security.PublicKey;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b implements PublicKey {
    private static final long serialVersionUID = 1;
    private short[][] coeffquadratic;
    private short[] coeffscalar;
    private short[][] coeffsingular;
    private int docLength;
    private me.b rainbowParams;

    public b(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.docLength = i10;
        this.coeffquadratic = sArr;
        this.coeffsingular = sArr2;
        this.coeffscalar = sArr3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b)) {
            b bVar = (b) obj;
            if (this.docLength == bVar.d() && ne.a.j(this.coeffquadratic, bVar.a()) && ne.a.j(this.coeffsingular, bVar.c()) && ne.a.i(this.coeffscalar, bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public b(je.b bVar) {
        this(bVar.d(), bVar.a(), bVar.c(), bVar.b());
    }

    public short[][] a() {
        return this.coeffquadratic;
    }

    public short[] b() {
        return re.a.e(this.coeffscalar);
    }

    public short[][] c() {
        short[][] sArr = new short[this.coeffsingular.length][];
        int i10 = 0;
        while (true) {
            short[][] sArr2 = this.coeffsingular;
            if (i10 == sArr2.length) {
                return sArr;
            }
            sArr[i10] = re.a.e(sArr2[i10]);
            i10++;
        }
    }

    public int d() {
        return this.docLength;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return he.a.a(new rc.a(g.f10277a, o1.f10200b), new i(this.docLength, this.coeffquadratic, this.coeffsingular, this.coeffscalar));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.docLength * 37) + re.a.q(this.coeffquadratic)) * 37) + re.a.q(this.coeffsingular)) * 37) + re.a.p(this.coeffscalar);
    }
}
