package w9;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public enum j implements kotlin.reflect.jvm.internal.impl.protobuf.j.a {
    DECLARATION(0, 0),
    FAKE_OVERRIDE(1, 1),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static kotlin.reflect.jvm.internal.impl.protobuf.j.b<j> f20240e = new kotlin.reflect.jvm.internal.impl.protobuf.j.b<j>() { // from class: w9.j.a
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(int i10) {
            return j.a(i10);
        }
    };
    private final int value;

    public static j a(int i10) {
        if (i10 == 0) {
            return DECLARATION;
        }
        if (i10 == 1) {
            return FAKE_OVERRIDE;
        }
        if (i10 == 2) {
            return DELEGATION;
        }
        if (i10 != 3) {
            return null;
        }
        return SYNTHESIZED;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
    public final int h() {
        return this.value;
    }

    j(int i10, int i11) {
        this.value = i11;
    }
}
