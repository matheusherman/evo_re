package a4;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f105b;

    List<b> a() {
        return this.f104a;
    }

    int b() {
        return this.f105b;
    }

    boolean c(List<b> list) {
        return this.f104a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f104a.equals(((c) obj).f104a);
        }
        return false;
    }

    public int hashCode() {
        return this.f104a.hashCode();
    }

    public String toString() {
        return "{ " + this.f104a + " }";
    }

    c(List<b> list, int i10) {
        this.f104a = new ArrayList(list);
        this.f105b = i10;
    }
}
