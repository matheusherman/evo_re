package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.reflect.jvm.internal.impl.descriptors.h0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class k extends g<r8.z> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f13902b = new a(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final k a(String message) {
            kotlin.jvm.internal.m.f(message, "message");
            return new b(message);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends k {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f13903c;

        public b(String message) {
            kotlin.jvm.internal.m.f(message, "message");
            this.f13903c = message;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public la.h a(h0 module) {
            kotlin.jvm.internal.m.f(module, "module");
            return la.k.d(la.j.J1, this.f13903c);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
        public String toString() {
            return this.f13903c;
        }
    }

    public k() {
        super(r8.z.f17874a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public r8.z b() {
        throw new UnsupportedOperationException();
    }
}
