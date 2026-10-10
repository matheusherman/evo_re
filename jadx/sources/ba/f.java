package ba;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f implements Comparable<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f939b;

    private static /* synthetic */ void a(int i10) {
        String str = (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) ? 2 : 3];
        if (i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i10 == 1) {
            objArr[1] = "asString";
        } else if (i10 == 2) {
            objArr[1] = "getIdentifier";
        } else if (i10 == 3 || i10 == 4) {
            objArr[1] = "asStringStripSpecialMarkers";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        }
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "special";
                break;
            case 8:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i10 != 1 && i10 != 2 && i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f939b == fVar.f939b && this.f938a.equals(fVar.f938a);
    }

    private f(String str, boolean z10) {
        if (str == null) {
            a(0);
        }
        this.f938a = str;
        this.f939b = z10;
    }

    public static f k(String str) {
        if (str == null) {
            a(8);
        }
        return str.startsWith("<") ? o(str) : l(str);
    }

    public static f l(String str) {
        if (str == null) {
            a(5);
        }
        return new f(str, false);
    }

    public static boolean n(String str) {
        if (str == null) {
            a(6);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '.' || cCharAt == '/' || cCharAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public static f o(String str) {
        if (str == null) {
            a(7);
        }
        if (str.startsWith("<")) {
            return new f(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public String f() {
        String str = this.f938a;
        if (str == null) {
            a(1);
        }
        return str;
    }

    public int hashCode() {
        return (this.f938a.hashCode() * 31) + (this.f939b ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compareTo(f fVar) {
        return this.f938a.compareTo(fVar.f938a);
    }

    public String j() {
        if (this.f939b) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String strF = f();
        if (strF == null) {
            a(2);
        }
        return strF;
    }

    public boolean m() {
        return this.f939b;
    }

    public String toString() {
        return this.f938a;
    }
}
