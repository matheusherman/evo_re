package eb;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a[] f9921a;

    public a a(String str) {
        for (a aVar : this.f9921a) {
            if (aVar.a().equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    public void f(int i10, a aVar) {
        this.f9921a[i10] = aVar;
    }

    public a[] g() {
        return this.f9921a;
    }

    public b(int i10) {
        this.f9921a = new a[i10];
    }

    public boolean b(String str, boolean z10) {
        String strE = e(str);
        if (strE == null) {
            return z10;
        }
        return Boolean.parseBoolean(strE);
    }

    public Integer c(String str) {
        String strE = e(str);
        if (strE == null) {
            return null;
        }
        if (strE.startsWith("0x")) {
            return Integer.valueOf(strE.substring(2), 16);
        }
        return Integer.valueOf(strE);
    }

    public Long d(String str) {
        String strE = e(str);
        if (strE == null) {
            return null;
        }
        if (strE.startsWith("0x")) {
            return Long.valueOf(strE.substring(2), 16);
        }
        return Long.valueOf(strE);
    }

    public String e(String str) {
        a aVarA = a(str);
        if (aVarA == null) {
            return null;
        }
        return aVarA.d();
    }
}
