package bb;

import androidx.core.app.NotificationCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {
    public static String a(int i10) {
        ArrayList arrayList = new ArrayList();
        if ((i10 & 4096) != 0) {
            arrayList.add("density");
        } else if ((1073741824 & i10) != 0) {
            arrayList.add("fontScale");
        } else if ((i10 & 16) != 0) {
            arrayList.add("keyboard");
        } else if ((i10 & 32) != 0) {
            arrayList.add("keyboardHidden");
        } else if ((i10 & 8192) != 0) {
            arrayList.add("direction");
        } else if ((i10 & 4) != 0) {
            arrayList.add("locale");
        } else if ((i10 & 1) != 0) {
            arrayList.add("mcc");
        } else if ((i10 & 2) != 0) {
            arrayList.add("mnc");
        } else if ((i10 & 64) != 0) {
            arrayList.add(NotificationCompat.CATEGORY_NAVIGATION);
        } else if ((i10 & 128) != 0) {
            arrayList.add("orientation");
        } else if ((i10 & 256) != 0) {
            arrayList.add("screenLayout");
        } else if ((i10 & 1024) != 0) {
            arrayList.add("screenSize");
        } else if ((i10 & 2048) != 0) {
            arrayList.add("smallestScreenSize");
        } else if ((i10 & 8) != 0) {
            arrayList.add("touchscreen");
        } else if ((i10 & 512) != 0) {
            arrayList.add("uiMode");
        }
        return fb.g.c(arrayList, "|");
    }

    public static String b(int i10) {
        if (i10 == 0) {
            return "auto";
        }
        if (i10 == 1) {
            return "internalOnly";
        }
        if (i10 == 2) {
            return "preferExternal";
        }
        return "installLocation:" + Integer.toHexString(i10);
    }

    public static String c(int i10) {
        if (i10 == 0) {
            return "standard";
        }
        if (i10 == 1) {
            return "singleTop";
        }
        if (i10 == 2) {
            return "singleTask";
        }
        if (i10 == 3) {
            return "singleInstance";
        }
        return "LaunchMode:" + Integer.toHexString(i10);
    }

    public static String d(int i10) {
        ArrayList arrayList = new ArrayList(3);
        if ((i10 & 16) != 0) {
            i10 ^= 16;
            arrayList.add("system");
        }
        if ((i10 & 32) != 0) {
            i10 ^= 32;
            arrayList.add("development");
        }
        if (i10 == 0) {
            arrayList.add("normal");
        } else if (i10 == 1) {
            arrayList.add("dangerous");
        } else if (i10 == 2) {
            arrayList.add("signature");
        } else if (i10 != 3) {
            arrayList.add("ProtectionLevel:" + Integer.toHexString(i10));
        } else {
            arrayList.add("signatureOrSystem");
        }
        return fb.g.c(arrayList, "|");
    }

    public static String f(int i10) {
        int i11 = i10 & 240;
        int i12 = i10 & 15;
        ArrayList arrayList = new ArrayList(2);
        if (i11 != 0) {
            if (i11 == 16) {
                arrayList.add("adjustResize");
            } else if (i11 == 32) {
                arrayList.add("adjustPan");
            } else if (i11 != 48) {
                arrayList.add("WindowInputModeAdjust:" + Integer.toHexString(i11));
            } else {
                arrayList.add("adjustNothing");
            }
        }
        if (i12 != 0) {
            if (i12 == 1) {
                arrayList.add("stateUnchanged");
            } else if (i12 == 2) {
                arrayList.add("stateHidden");
            } else if (i12 == 3) {
                arrayList.add("stateAlwaysHidden");
            } else if (i12 == 4) {
                arrayList.add("stateVisible");
            } else if (i12 != 5) {
                arrayList.add("WindowInputModeState:" + Integer.toHexString(i12));
            } else {
                arrayList.add("stateAlwaysVisible");
            }
        }
        return fb.g.c(arrayList, "|");
    }

    public static String e(int i10) {
        switch (i10) {
            case -1:
                return "unspecified";
            case 0:
                return "landscape";
            case 1:
                return "portrait";
            case 2:
                return "user";
            case 3:
                return "behind";
            case 4:
                return "sensor";
            case 5:
                return "nosensor";
            case 6:
                return "sensorLandscape";
            case 7:
                return "sensorPortrait";
            case 8:
                return "reverseLandscape";
            case 9:
                return "reversePortrait";
            case 10:
                return "fullSensor";
            case 11:
                return "userLandscape";
            case 12:
                return "userPortrait";
            case 13:
                return "fullUser";
            case 14:
                return "locked";
            default:
                return "ScreenOrientation:" + Integer.toHexString(i10);
        }
    }
}
