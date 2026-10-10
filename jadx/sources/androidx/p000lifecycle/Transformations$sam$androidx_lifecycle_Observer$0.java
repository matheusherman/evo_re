package androidx.p000lifecycle;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.m;
import r8.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
final class Transformations$sam$androidx_lifecycle_Observer$0 implements Observer, h {
    private final /* synthetic */ l function;

    Transformations$sam$androidx_lifecycle_Observer$0(l function) {
        m.f(function, "function");
        this.function = function;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof Observer) && (obj instanceof h)) {
            return m.a(getFunctionDelegate(), ((h) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.h
    public final c<?> getFunctionDelegate() {
        return this.function;
    }

    @Override // androidx.p000lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        this.function.invoke(obj);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
