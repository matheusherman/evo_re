package kotlin.reflect.jvm.internal.impl.load.java.components;

import i9.k;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import r8.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ k<Object>[] f13181h = {c0.g(new w(c0.b(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ka.i f13182g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> {
        a() {
            super(0);
        }

        @Override // c9.a
        public final Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> invoke() {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVarA = d.f13172a.a(h.this.b());
            Map<ba.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> mapF = gVarA != null ? n0.f(v.a(c.f13167a.c(), gVarA)) : null;
            return mapF == null ? n0.i() : mapF;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(u9.a annotation, kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10) {
        super(c10, annotation, kotlin.reflect.jvm.internal.impl.builtins.k.a.L);
        m.f(annotation, "annotation");
        m.f(c10, "c");
        this.f13182g = c10.e().c(new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) ka.m.a(this.f13182g, this, f13181h[0]);
    }
}
