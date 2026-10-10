package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public final /* synthetic */ class g {
    static {
        String str = TypedValues.TransitionType.NAME;
    }

    public static int b(int i10) {
        if (i10 == 509) {
            return 2;
        }
        switch (i10) {
            case 700:
                return 2;
            case 701:
            case 702:
                return 8;
            default:
                switch (i10) {
                    case TypedValues.TransitionType.TYPE_INTERPOLATOR /* 705 */:
                    case TypedValues.TransitionType.TYPE_TRANSITION_FLAGS /* 707 */:
                        return 8;
                    case TypedValues.TransitionType.TYPE_STAGGERED /* 706 */:
                        return 4;
                    default:
                        return -1;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000b  */
    public static int a(String str) {
        str.getClass();
        switch (str) {
            case "transitionFlags":
                return TypedValues.TransitionType.TYPE_TRANSITION_FLAGS;
            case "duration":
                return 700;
            case "motionInterpolator":
                return TypedValues.TransitionType.TYPE_INTERPOLATOR;
            case "autoTransition":
                return TypedValues.TransitionType.TYPE_AUTO_TRANSITION;
            case "to":
                return 702;
            case "from":
                return 701;
            case "pathMotionArc":
                return 509;
            case "staggered":
                return TypedValues.TransitionType.TYPE_STAGGERED;
            default:
                return -1;
        }
    }
}
