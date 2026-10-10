package v3;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final l[] f19573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static l[] f19574j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f19575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f19580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f19581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f19582h;

    public l(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    static {
        l[] lVarArr = {new l(false, 3, 5, 8, 8, 1), new l(false, 5, 7, 10, 10, 1), new l(true, 5, 7, 16, 6, 1), new l(false, 8, 10, 12, 12, 1), new l(true, 10, 11, 14, 6, 2), new l(false, 12, 12, 14, 14, 1), new l(true, 16, 14, 24, 10, 1), new l(false, 18, 14, 16, 16, 1), new l(false, 22, 18, 18, 18, 1), new l(true, 22, 18, 16, 10, 2), new l(false, 30, 20, 20, 20, 1), new l(true, 32, 24, 16, 14, 2), new l(false, 36, 24, 22, 22, 1), new l(false, 44, 28, 24, 24, 1), new l(true, 49, 28, 22, 14, 2), new l(false, 62, 36, 14, 14, 4), new l(false, 86, 42, 16, 16, 4), new l(false, 114, 48, 18, 18, 4), new l(false, 144, 56, 20, 20, 4), new l(false, 174, 68, 22, 22, 4), new l(false, 204, 84, 24, 24, 4, 102, 42), new l(false, 280, 112, 14, 14, 16, ModuleDescriptor.MODULE_VERSION, 56), new l(false, 368, 144, 16, 16, 16, 92, 36), new l(false, 456, RsaOaep.DerParser.PRIVATE, 18, 18, 16, 114, 48), new l(false, 576, 224, 20, 20, 16, 144, 56), new l(false, 696, 272, 22, 22, 16, 174, 68), new l(false, 816, 336, 24, 24, 16, 136, 56), new l(false, 1050, 408, 18, 18, 36, 175, 68), new l(false, 1304, 496, 20, 20, 36, 163, 62), new d()};
        f19573i = lVarArr;
        f19574j = lVarArr;
    }

    l(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f19575a = z10;
        this.f19576b = i10;
        this.f19577c = i11;
        this.f19578d = i12;
        this.f19579e = i13;
        this.f19580f = i14;
        this.f19581g = i15;
        this.f19582h = i16;
    }

    private int e() {
        int i10 = this.f19580f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 4) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i11;
    }

    private int k() {
        int i10 = this.f19580f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static l l(int i10, m mVar, h3.f fVar, h3.f fVar2, boolean z10) {
        for (l lVar : f19574j) {
            if (!(mVar == m.FORCE_SQUARE && lVar.f19575a) && ((mVar != m.FORCE_RECTANGLE || lVar.f19575a) && ((fVar == null || (lVar.j() >= fVar.b() && lVar.i() >= fVar.a())) && ((fVar2 == null || (lVar.j() <= fVar2.b() && lVar.i() <= fVar2.a())) && i10 <= lVar.f19576b)))) {
                return lVar;
            }
        }
        if (!z10) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i10);
    }

    public final int a() {
        return this.f19576b;
    }

    public int b(int i10) {
        return this.f19581g;
    }

    public final int c() {
        return this.f19577c;
    }

    public final int d(int i10) {
        return this.f19582h;
    }

    public int f() {
        return this.f19576b / this.f19581g;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f19575a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f19578d);
        sb2.append('x');
        sb2.append(this.f19579e);
        sb2.append(", symbol size ");
        sb2.append(j());
        sb2.append('x');
        sb2.append(i());
        sb2.append(", symbol data size ");
        sb2.append(h());
        sb2.append('x');
        sb2.append(g());
        sb2.append(", codewords ");
        sb2.append(this.f19576b);
        sb2.append('+');
        sb2.append(this.f19577c);
        return sb2.toString();
    }

    public final int g() {
        return k() * this.f19579e;
    }

    public final int h() {
        return e() * this.f19578d;
    }

    public final int i() {
        return g() + (k() * 2);
    }

    public final int j() {
        return h() + (e() * 2);
    }
}
