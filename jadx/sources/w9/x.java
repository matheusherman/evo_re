package w9;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public enum x implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
    INTERNAL(0, 0),
    PRIVATE(1, 1),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<x> f20397g = new kotlin.reflect.jvm.internal.impl.protobuf.j.b<x>() { // from class: w9.x.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(int i10) {
            return x.a(i10);
        }
    };
    private final int value;

    public static x a(int i10) {
        if (i10 == 0) {
            return INTERNAL;
        }
        if (i10 == 1) {
            return PRIVATE;
        }
        if (i10 == 2) {
            return PROTECTED;
        }
        if (i10 == 3) {
            return PUBLIC;
        }
        if (i10 == 4) {
            return PRIVATE_TO_THIS;
        }
        if (i10 != 5) {
            return null;
        }
        return LOCAL;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
    public final int h() {
        return this.value;
    }

    x(int i10, int i11) {
        this.value = i11;
    }
}
