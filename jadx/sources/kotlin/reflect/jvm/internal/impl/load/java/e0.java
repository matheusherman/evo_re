package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e0<T> implements d0<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<ba.c, T> f13196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ka.f f13197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ka.h<ba.c, T> f13198d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends kotlin.jvm.internal.o implements c9.l<ba.c, T> {
        final /* synthetic */ e0<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0<T> e0Var) {
            super(1);
            this.this$0 = e0Var;
        }

        @Override // c9.l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final T invoke(ba.c it) {
            kotlin.jvm.internal.m.e(it, "it");
            return (T) ba.e.a(it, this.this$0.b());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(Map<ba.c, ? extends T> states) {
        kotlin.jvm.internal.m.f(states, "states");
        this.f13196b = states;
        ka.f fVar = new ka.f("Java nullability annotation states");
        this.f13197c = fVar;
        ka.h<ba.c, T> hVarI = fVar.i(new a(this));
        kotlin.jvm.internal.m.e(hVarI, "storageManager.createMem…cificFqname(states)\n    }");
        this.f13198d = hVarI;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.d0
    public T a(ba.c fqName) {
        kotlin.jvm.internal.m.f(fqName, "fqName");
        return this.f13198d.invoke(fqName);
    }

    public final Map<ba.c, T> b() {
        return this.f13196b;
    }
}
