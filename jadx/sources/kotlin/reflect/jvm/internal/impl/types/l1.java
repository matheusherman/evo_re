package kotlin.reflect.jvm.internal.impl.types;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class l1 implements k1 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k1)) {
            return false;
        }
        k1 k1Var = (k1) obj;
        return b() == k1Var.b() && a() == k1Var.a() && getType().equals(k1Var.getType());
    }

    public int hashCode() {
        int iHashCode;
        int iHashCode2 = a().hashCode();
        if (s1.w(getType())) {
            return (iHashCode2 * 31) + 19;
        }
        int i10 = iHashCode2 * 31;
        if (b()) {
            iHashCode = 17;
        } else {
            iHashCode = getType().hashCode();
        }
        return i10 + iHashCode;
    }

    public String toString() {
        if (b()) {
            return "*";
        }
        if (a() == w1.INVARIANT) {
            return getType().toString();
        }
        return a() + " " + getType();
    }
}
