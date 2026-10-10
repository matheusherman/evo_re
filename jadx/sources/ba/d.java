package ba;

import c9.l;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f f930e = f.o("<root>");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Pattern f931f = Pattern.compile("\\.");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final l<String, f> f932g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient c f934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient d f935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient f f936d;

    d(String str, c cVar) {
        if (str == null) {
            a(0);
        }
        if (cVar == null) {
            a(1);
        }
        this.f933a = str;
        this.f934b = cVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && this.f933a.equals(((d) obj).f933a);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements l<String, f> {
        a() {
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public f invoke(String str) {
            return f.k(str);
        }
    }

    private void d() {
        int iLastIndexOf = this.f933a.lastIndexOf(46);
        if (iLastIndexOf >= 0) {
            this.f936d = f.k(this.f933a.substring(iLastIndexOf + 1));
            this.f935c = new d(this.f933a.substring(0, iLastIndexOf));
        } else {
            this.f936d = f.k(this.f933a);
            this.f935c = c.f927c.j();
        }
    }

    public static d m(f fVar) {
        if (fVar == null) {
            a(16);
        }
        return new d(fVar.f(), c.f927c.j(), fVar);
    }

    public String b() {
        String str = this.f933a;
        if (str == null) {
            a(4);
        }
        return str;
    }

    public d c(f fVar) {
        String strF;
        if (fVar == null) {
            a(9);
        }
        if (e()) {
            strF = fVar.f();
        } else {
            strF = this.f933a + "." + fVar.f();
        }
        return new d(strF, this, fVar);
    }

    public boolean e() {
        return this.f933a.isEmpty();
    }

    public boolean f() {
        return this.f934b != null || b().indexOf(60) < 0;
    }

    public d g() {
        d dVar = this.f935c;
        if (dVar != null) {
            if (dVar == null) {
                a(7);
            }
            return dVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        d dVar2 = this.f935c;
        if (dVar2 == null) {
            a(8);
        }
        return dVar2;
    }

    public int hashCode() {
        return this.f933a.hashCode();
    }

    public f i() {
        f fVar = this.f936d;
        if (fVar != null) {
            if (fVar == null) {
                a(10);
            }
            return fVar;
        }
        if (e()) {
            throw new IllegalStateException("root");
        }
        d();
        f fVar2 = this.f936d;
        if (fVar2 == null) {
            a(11);
        }
        return fVar2;
    }

    public boolean k(f fVar) {
        if (fVar == null) {
            a(15);
        }
        if (e()) {
            return false;
        }
        int iIndexOf = this.f933a.indexOf(46);
        String strF = fVar.f();
        String str = this.f933a;
        if (iIndexOf == -1) {
            iIndexOf = Math.max(str.length(), strF.length());
        }
        return str.regionMatches(0, strF, 0, iIndexOf);
    }

    public c l() {
        c cVar = this.f934b;
        if (cVar != null) {
            if (cVar == null) {
                a(5);
            }
            return cVar;
        }
        c cVar2 = new c(this);
        this.f934b = cVar2;
        return cVar2;
    }

    private static /* synthetic */ void a(int i10) {
        String str;
        int i11;
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 15:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                i11 = 2;
                break;
            case 9:
            case 15:
            case 16:
            default:
                i11 = 3;
                break;
        }
        Object[] objArr = new Object[i11];
        if (i10 != 1) {
            switch (i10) {
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 17:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                    break;
                case 9:
                    objArr[0] = "name";
                    break;
                case 15:
                    objArr[0] = "segment";
                    break;
                case 16:
                    objArr[0] = "shortName";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
        } else {
            objArr[0] = "safe";
        }
        switch (i10) {
            case 4:
                objArr[1] = "asString";
                break;
            case 5:
            case 6:
                objArr[1] = "toSafe";
                break;
            case 7:
            case 8:
                objArr[1] = "parent";
                break;
            case 9:
            case 15:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
                break;
            case 10:
            case 11:
                objArr[1] = "shortName";
                break;
            case 12:
            case 13:
                objArr[1] = "shortNameOrSpecial";
                break;
            case 14:
                objArr[1] = "pathSegments";
                break;
            case 17:
                objArr[1] = "toString";
                break;
        }
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                break;
            case 9:
                objArr[2] = "child";
                break;
            case 15:
                objArr[2] = "startsWith";
                break;
            case 16:
                objArr[2] = "topLevel";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i10) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 17:
                throw new IllegalStateException(str2);
            case 9:
            case 15:
            case 16:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public List<f> h() {
        List<f> listG0;
        if (e()) {
            listG0 = Collections.EMPTY_LIST;
        } else {
            listG0 = kotlin.collections.j.g0(f931f.split(this.f933a), f932g);
        }
        if (listG0 == null) {
            a(14);
        }
        return listG0;
    }

    public f j() {
        if (e()) {
            f fVar = f930e;
            if (fVar == null) {
                a(12);
            }
            return fVar;
        }
        f fVarI = i();
        if (fVarI == null) {
            a(13);
        }
        return fVarI;
    }

    public String toString() {
        String strF;
        if (e()) {
            strF = f930e.f();
        } else {
            strF = this.f933a;
        }
        if (strF == null) {
            a(17);
        }
        return strF;
    }

    public d(String str) {
        if (str == null) {
            a(2);
        }
        this.f933a = str;
    }

    private d(String str, d dVar, f fVar) {
        if (str == null) {
            a(3);
        }
        this.f933a = str;
        this.f935c = dVar;
        this.f936d = fVar;
    }
}
