package fc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10239b = 0;

    public boolean a() {
        return this.f10239b != -1;
    }

    public String b() {
        int i10 = this.f10239b;
        if (i10 == -1) {
            return null;
        }
        int iIndexOf = this.f10238a.indexOf(46, i10);
        if (iIndexOf == -1) {
            String strSubstring = this.f10238a.substring(this.f10239b);
            this.f10239b = -1;
            return strSubstring;
        }
        String strSubstring2 = this.f10238a.substring(this.f10239b, iIndexOf);
        this.f10239b = iIndexOf + 1;
        return strSubstring2;
    }

    public u2(String str) {
        this.f10238a = str;
    }
}
