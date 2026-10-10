package da;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a implements Comparable<a> {
    public abstract b f();

    public abstract boolean i();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a other) {
        m.f(other, "other");
        int iCompareTo = f().compareTo(other.f());
        if (iCompareTo == 0 && !i() && other.i()) {
            return 1;
        }
        return iCompareTo;
    }
}
