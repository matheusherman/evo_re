package fd;

import fc.c0;
import fc.q1;
import fc.s;
import fc.u;
import fc.u1;
import fc.v;
import fc.z;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fc.p f10303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u f10304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[][] f10305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f10306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[][] f10307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f10308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f10309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private me.a[] f10310h;

    private h(c0 c0Var) {
        int i10 = 0;
        if (c0Var.A(0) instanceof fc.p) {
            this.f10303a = fc.p.z(c0Var.A(0));
        } else {
            this.f10304b = u.C(c0Var.A(0));
        }
        c0 c0Var2 = (c0) c0Var.A(1);
        this.f10305c = new byte[c0Var2.size()][];
        for (int i11 = 0; i11 < c0Var2.size(); i11++) {
            this.f10305c[i11] = ((v) c0Var2.A(i11)).A();
        }
        this.f10306d = ((v) ((c0) c0Var.A(2)).A(0)).A();
        c0 c0Var3 = (c0) c0Var.A(3);
        this.f10307e = new byte[c0Var3.size()][];
        for (int i12 = 0; i12 < c0Var3.size(); i12++) {
            this.f10307e[i12] = ((v) c0Var3.A(i12)).A();
        }
        this.f10308f = ((v) ((c0) c0Var.A(4)).A(0)).A();
        this.f10309g = ((v) ((c0) c0Var.A(5)).A(0)).A();
        c0 c0Var4 = (c0) c0Var.A(6);
        byte[][][][] bArr = new byte[c0Var4.size()][][][];
        byte[][][][] bArr2 = new byte[c0Var4.size()][][][];
        byte[][][] bArr3 = new byte[c0Var4.size()][][];
        byte[][] bArr4 = new byte[c0Var4.size()][];
        int i13 = 0;
        while (i13 < c0Var4.size()) {
            c0 c0Var5 = (c0) c0Var4.A(i13);
            c0 c0Var6 = (c0) c0Var5.A(i10);
            bArr[i13] = new byte[c0Var6.size()][][];
            for (int i14 = 0; i14 < c0Var6.size(); i14++) {
                c0 c0Var7 = (c0) c0Var6.A(i14);
                bArr[i13][i14] = new byte[c0Var7.size()][];
                for (int i15 = 0; i15 < c0Var7.size(); i15++) {
                    bArr[i13][i14][i15] = ((v) c0Var7.A(i15)).A();
                }
            }
            c0 c0Var8 = (c0) c0Var5.A(1);
            bArr2[i13] = new byte[c0Var8.size()][][];
            for (int i16 = 0; i16 < c0Var8.size(); i16++) {
                c0 c0Var9 = (c0) c0Var8.A(i16);
                bArr2[i13][i16] = new byte[c0Var9.size()][];
                for (int i17 = 0; i17 < c0Var9.size(); i17++) {
                    bArr2[i13][i16][i17] = ((v) c0Var9.A(i17)).A();
                }
            }
            c0 c0Var10 = (c0) c0Var5.A(2);
            bArr3[i13] = new byte[c0Var10.size()][];
            for (int i18 = 0; i18 < c0Var10.size(); i18++) {
                bArr3[i13][i18] = ((v) c0Var10.A(i18)).A();
            }
            bArr4[i13] = ((v) c0Var5.A(3)).A();
            i13++;
            i10 = 0;
        }
        int length = this.f10309g.length - 1;
        this.f10310h = new me.a[length];
        int i19 = 0;
        while (i19 < length) {
            byte[] bArr5 = this.f10309g;
            int i20 = i19 + 1;
            this.f10310h[i19] = new me.a(bArr5[i19], bArr5[i20], ne.a.f(bArr[i19]), ne.a.f(bArr2[i19]), ne.a.d(bArr3[i19]), ne.a.b(bArr4[i19]));
            i19 = i20;
        }
    }

    public h(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, me.a[] aVarArr) {
        this.f10303a = new fc.p(1L);
        this.f10305c = ne.a.c(sArr);
        this.f10306d = ne.a.a(sArr2);
        this.f10307e = ne.a.c(sArr3);
        this.f10308f = ne.a.a(sArr4);
        this.f10309g = ne.a.h(iArr);
        this.f10310h = aVarArr;
    }

    public static h o(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(c0.z(obj));
        }
        return null;
    }

    @Override // fc.s, fc.f
    public z f() {
        fc.g gVar = new fc.g();
        fc.f fVar = this.f10303a;
        if (fVar == null) {
            fVar = this.f10304b;
        }
        gVar.a(fVar);
        fc.g gVar2 = new fc.g();
        for (int i10 = 0; i10 < this.f10305c.length; i10++) {
            gVar2.a(new q1(this.f10305c[i10]));
        }
        gVar.a(new u1(gVar2));
        fc.g gVar3 = new fc.g();
        gVar3.a(new q1(this.f10306d));
        gVar.a(new u1(gVar3));
        fc.g gVar4 = new fc.g();
        for (int i11 = 0; i11 < this.f10307e.length; i11++) {
            gVar4.a(new q1(this.f10307e[i11]));
        }
        gVar.a(new u1(gVar4));
        fc.g gVar5 = new fc.g();
        gVar5.a(new q1(this.f10308f));
        gVar.a(new u1(gVar5));
        fc.g gVar6 = new fc.g();
        gVar6.a(new q1(this.f10309g));
        gVar.a(new u1(gVar6));
        fc.g gVar7 = new fc.g();
        for (int i12 = 0; i12 < this.f10310h.length; i12++) {
            fc.g gVar8 = new fc.g();
            byte[][][] bArrE = ne.a.e(this.f10310h[i12].a());
            fc.g gVar9 = new fc.g();
            for (int i13 = 0; i13 < bArrE.length; i13++) {
                fc.g gVar10 = new fc.g();
                for (int i14 = 0; i14 < bArrE[i13].length; i14++) {
                    gVar10.a(new q1(bArrE[i13][i14]));
                }
                gVar9.a(new u1(gVar10));
            }
            gVar8.a(new u1(gVar9));
            byte[][][] bArrE2 = ne.a.e(this.f10310h[i12].b());
            fc.g gVar11 = new fc.g();
            for (int i15 = 0; i15 < bArrE2.length; i15++) {
                fc.g gVar12 = new fc.g();
                for (int i16 = 0; i16 < bArrE2[i15].length; i16++) {
                    gVar12.a(new q1(bArrE2[i15][i16]));
                }
                gVar11.a(new u1(gVar12));
            }
            gVar8.a(new u1(gVar11));
            byte[][] bArrC = ne.a.c(this.f10310h[i12].d());
            fc.g gVar13 = new fc.g();
            for (byte[] bArr : bArrC) {
                gVar13.a(new q1(bArr));
            }
            gVar8.a(new u1(gVar13));
            gVar8.a(new q1(ne.a.a(this.f10310h[i12].c())));
            gVar7.a(new u1(gVar8));
        }
        gVar.a(new u1(gVar7));
        return new u1(gVar);
    }

    public short[] m() {
        return ne.a.b(this.f10306d);
    }

    public short[] n() {
        return ne.a.b(this.f10308f);
    }

    public short[][] q() {
        return ne.a.d(this.f10305c);
    }

    public short[][] r() {
        return ne.a.d(this.f10307e);
    }

    public me.a[] s() {
        return this.f10310h;
    }

    public int[] t() {
        return ne.a.g(this.f10309g);
    }
}
