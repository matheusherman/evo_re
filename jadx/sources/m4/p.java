package m4;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class p implements Comparable<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15655b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            p pVar = (p) obj;
            if (this.f15654a == pVar.f15654a && this.f15655b == pVar.f15655b) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull p pVar) {
        int i10 = this.f15655b * this.f15654a;
        int i11 = pVar.f15655b * pVar.f15654a;
        if (i11 < i10) {
            return 1;
        }
        return i11 > i10 ? -1 : 0;
    }

    public p f() {
        return new p(this.f15655b, this.f15654a);
    }

    public int hashCode() {
        return (this.f15654a * 31) + this.f15655b;
    }

    public p i(p pVar) {
        int i10 = this.f15654a;
        int i11 = pVar.f15655b;
        int i12 = i10 * i11;
        int i13 = pVar.f15654a;
        int i14 = this.f15655b;
        return i12 <= i13 * i14 ? new p(i13, (i14 * i13) / i10) : new p((i10 * i11) / i14, i11);
    }

    public p j(p pVar) {
        int i10 = this.f15654a;
        int i11 = pVar.f15655b;
        int i12 = i10 * i11;
        int i13 = pVar.f15654a;
        int i14 = this.f15655b;
        return i12 >= i13 * i14 ? new p(i13, (i14 * i13) / i10) : new p((i10 * i11) / i14, i11);
    }

    public String toString() {
        return this.f15654a + "x" + this.f15655b;
    }

    public p(int i10, int i11) {
        this.f15654a = i10;
        this.f15655b = i11;
    }
}
