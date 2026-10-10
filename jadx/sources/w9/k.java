package w9;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public enum k implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
    FINAL(0, 0),
    OPEN(1, 1),
    ABSTRACT(2, 2),
    SEALED(3, 3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<k> f20246e = new kotlin.reflect.jvm.internal.impl.protobuf.j.b<k>() { // from class: w9.k.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public k a(int i10) {
            return k.a(i10);
        }
    };
    private final int value;

    public static k a(int i10) {
        if (i10 == 0) {
            return FINAL;
        }
        if (i10 == 1) {
            return OPEN;
        }
        if (i10 == 2) {
            return ABSTRACT;
        }
        if (i10 != 3) {
            return null;
        }
        return SEALED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
    public final int h() {
        return this.value;
    }

    k(int i10, int i11) {
        this.value = i11;
    }
}
