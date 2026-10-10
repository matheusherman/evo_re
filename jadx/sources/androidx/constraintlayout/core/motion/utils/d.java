package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final /* synthetic */ class d {
    static {
        String str = TypedValues.MotionScene.NAME;
    }

    public static int b(int i10) {
        if (i10 != 600) {
            return i10 != 601 ? -1 : 1;
        }
        return 2;
    }

    public static int a(String str) {
        str.getClass();
        if (!str.equals(TypedValues.MotionScene.S_DEFAULT_DURATION)) {
            if (!str.equals(TypedValues.MotionScene.S_LAYOUT_DURING_TRANSITION)) {
                return -1;
            }
            return 601;
        }
        return 600;
    }
}
