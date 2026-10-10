package ec;

import ac.e;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c<L, R> implements Map.Entry<L, R>, Comparable<c<L, R>>, Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (e.a(getKey(), entry.getKey()) && e.a(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public abstract L f();

    public abstract R i();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c<L, R> cVar) {
        return new bc.a().g(f(), cVar.f()).g(i(), cVar.i()).t();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(f());
        sb2.append(',');
        sb2.append(i());
        sb2.append(')');
        return sb2.toString();
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return f();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return i();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int iHashCode;
        int iHashCode2 = 0;
        if (getKey() == null) {
            iHashCode = 0;
        } else {
            iHashCode = getKey().hashCode();
        }
        if (getValue() != null) {
            iHashCode2 = getValue().hashCode();
        }
        return iHashCode ^ iHashCode2;
    }
}
