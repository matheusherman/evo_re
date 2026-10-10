package xc;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f22056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f22057b;

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f22057b != this.f22057b) {
            return false;
        }
        return re.a.a(this.f22056a, cVar.f22056a);
    }

    public int hashCode() {
        return this.f22057b ^ re.a.l(this.f22056a);
    }

    public c(byte[] bArr, int i10) {
        this.f22056a = re.a.d(bArr);
        this.f22057b = i10;
    }
}
