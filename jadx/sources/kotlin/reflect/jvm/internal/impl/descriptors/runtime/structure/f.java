package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class f implements u9.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13031b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ba.f f13032a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final f a(Object value, ba.f fVar) {
            kotlin.jvm.internal.m.f(value, "value");
            if (d.g(value.getClass())) {
                return new q(fVar, (Enum) value);
            }
            if (value instanceof Annotation) {
                return new g(fVar, (Annotation) value);
            }
            if (value instanceof Object[]) {
                return new j(fVar, (Object[]) value);
            }
            return value instanceof Class ? new m(fVar, (Class) value) : new s(fVar, value);
        }
    }

    public /* synthetic */ f(ba.f fVar, kotlin.jvm.internal.g gVar) {
        this(fVar);
    }

    private f(ba.f fVar) {
        this.f13032a = fVar;
    }

    @Override // u9.b
    public ba.f getName() {
        return this.f13032a;
    }
}
