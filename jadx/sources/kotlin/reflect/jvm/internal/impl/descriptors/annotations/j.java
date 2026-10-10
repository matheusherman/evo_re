package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.o0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class j implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.builtins.h f12692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ba.c f12693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> f12694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r8.i f12695d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<o0> {
        a() {
            super(0);
        }

        @Override // c9.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o0 invoke() {
            return j.this.f12692a.o(j.this.d()).p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlin.reflect.jvm.internal.impl.builtins.h builtIns, ba.c fqName, Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> allValueArguments) {
        kotlin.jvm.internal.m.f(builtIns, "builtIns");
        kotlin.jvm.internal.m.f(fqName, "fqName");
        kotlin.jvm.internal.m.f(allValueArguments, "allValueArguments");
        this.f12692a = builtIns;
        this.f12693b = fqName;
        this.f12694c = allValueArguments;
        this.f12695d = r8.j.b(r8.m.PUBLICATION, new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return this.f12694c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public ba.c d() {
        return this.f12693b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public a1 getSource() {
        a1 NO_SOURCE = a1.f12668a;
        kotlin.jvm.internal.m.e(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public g0 getType() {
        Object value = this.f12695d.getValue();
        kotlin.jvm.internal.m.e(value, "<get-type>(...)");
        return (g0) value;
    }
}
