package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final /* synthetic */ class f {
    static {
        String str = TypedValues.PositionType.NAME;
    }

    public static int b(int i10) {
        if (i10 == 100) {
            return 2;
        }
        if (i10 == 101) {
            return 8;
        }
        switch (i10) {
            case TypedValues.PositionType.TYPE_TRANSITION_EASING /* 501 */:
            case TypedValues.PositionType.TYPE_DRAWPATH /* 502 */:
                return 8;
            case TypedValues.PositionType.TYPE_PERCENT_WIDTH /* 503 */:
            case TypedValues.PositionType.TYPE_PERCENT_HEIGHT /* 504 */:
            case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
            case TypedValues.PositionType.TYPE_PERCENT_X /* 506 */:
            case TypedValues.PositionType.TYPE_PERCENT_Y /* 507 */:
                return 4;
            case TypedValues.PositionType.TYPE_CURVE_FIT /* 508 */:
                return 2;
            default:
                return -1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "transitionEasing":
                return TypedValues.PositionType.TYPE_TRANSITION_EASING;
            case "percentWidth":
                return TypedValues.PositionType.TYPE_PERCENT_WIDTH;
            case "percentHeight":
                return TypedValues.PositionType.TYPE_PERCENT_HEIGHT;
            case "drawPath":
                return TypedValues.PositionType.TYPE_DRAWPATH;
            case "sizePercent":
                return TypedValues.PositionType.TYPE_SIZE_PERCENT;
            case "percentX":
                return TypedValues.PositionType.TYPE_PERCENT_X;
            case "percentY":
                return TypedValues.PositionType.TYPE_PERCENT_Y;
            default:
                return -1;
        }
    }
}
