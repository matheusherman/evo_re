package kotlin.reflect.jvm.internal.impl.load.kotlin;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public interface q extends kotlin.reflect.jvm.internal.impl.serialization.deserialization.t {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class C0242a extends a {
            public final byte[] b() {
                throw null;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final s f13613a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final byte[] f13614b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(s kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                kotlin.jvm.internal.m.f(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f13613a = kotlinJvmBinaryClass;
                this.f13614b = bArr;
            }

            public /* synthetic */ b(s sVar, byte[] bArr, int i10, kotlin.jvm.internal.g gVar) {
                this(sVar, (i10 & 2) != 0 ? null : bArr);
            }

            public final s b() {
                return this.f13613a;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private a() {
        }

        public final s a() {
            b bVar = this instanceof b ? (b) this : null;
            if (bVar != null) {
                return bVar.b();
            }
            return null;
        }
    }

    a b(ba.b bVar, aa.e eVar);

    a c(u9.g gVar, aa.e eVar);
}
