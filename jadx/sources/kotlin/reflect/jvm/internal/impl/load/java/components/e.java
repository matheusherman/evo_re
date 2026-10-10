package kotlin.reflect.jvm.internal.impl.load.java.components;

import i9.k;
import java.util.Map;
import kotlin.collections.n0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.w;
import kotlin.reflect.jvm.internal.impl.resolve.constants.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ k<Object>[] f13176h = {c0.g(new w(c0.b(e.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ka.i f13177g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a extends o implements c9.a<Map<ba.f, ? extends v>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13178a = new a();

        a() {
            super(0);
        }

        @Override // c9.a
        public final Map<ba.f, ? extends v> invoke() {
            return n0.f(r8.v.a(c.f13167a.b(), new v("Deprecated in Java")));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(u9.a aVar, kotlin.reflect.jvm.internal.impl.load.java.lazy.g c10) {
        super(c10, aVar, kotlin.reflect.jvm.internal.impl.builtins.k.a.f12646y);
        m.f(c10, "c");
        this.f13177g = c10.e().c(a.f13178a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.components.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c
    public Map<ba.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a() {
        return (Map) ka.m.a(this.f13177g, this, f13176h[0]);
    }
}
