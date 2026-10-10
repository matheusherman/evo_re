package kotlin.reflect.jvm.internal;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class m implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c9.p f14518a;

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return n.t(this.f14518a, obj, obj2);
    }

    public m(c9.p pVar) {
        this.f14518a = pVar;
    }
}
