package org.apache.log4j.helpers;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Level;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class UtilLoggingLevel extends Level {
    public static final int UNKNOWN_INT = 10000;
    private static final long serialVersionUID = 909301162611820211L;
    public static final int SEVERE_INT = 22000;
    public static final UtilLoggingLevel SEVERE = new UtilLoggingLevel(SEVERE_INT, "SEVERE", 0);
    public static final int WARNING_INT = 21000;
    public static final UtilLoggingLevel WARNING = new UtilLoggingLevel(WARNING_INT, "WARNING", 4);
    public static final UtilLoggingLevel INFO = new UtilLoggingLevel(20000, "INFO", 5);
    public static final int CONFIG_INT = 14000;
    public static final UtilLoggingLevel CONFIG = new UtilLoggingLevel(CONFIG_INT, "CONFIG", 6);
    public static final int FINE_INT = 13000;
    public static final UtilLoggingLevel FINE = new UtilLoggingLevel(FINE_INT, "FINE", 7);
    public static final int FINER_INT = 12000;
    public static final UtilLoggingLevel FINER = new UtilLoggingLevel(FINER_INT, "FINER", 8);
    public static final int FINEST_INT = 11000;
    public static final UtilLoggingLevel FINEST = new UtilLoggingLevel(FINEST_INT, "FINEST", 9);

    public static UtilLoggingLevel toLevel(int i10, UtilLoggingLevel utilLoggingLevel) {
        if (i10 == 11000) {
            return FINEST;
        }
        if (i10 == 12000) {
            return FINER;
        }
        if (i10 == 13000) {
            return FINE;
        }
        if (i10 == 14000) {
            return CONFIG;
        }
        if (i10 == 20000) {
            return INFO;
        }
        if (i10 != 21000) {
            return i10 != 22000 ? utilLoggingLevel : SEVERE;
        }
        return WARNING;
    }

    public static List getAllPossibleLevels() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FINE);
        arrayList.add(FINER);
        arrayList.add(FINEST);
        arrayList.add(INFO);
        arrayList.add(CONFIG);
        arrayList.add(WARNING);
        arrayList.add(SEVERE);
        return arrayList;
    }

    protected UtilLoggingLevel(int i10, String str, int i11) {
        super(i10, str, i11);
    }

    public static Level toLevel(int i10) {
        return toLevel(i10, FINEST);
    }

    public static Level toLevel(String str) {
        return toLevel(str, Level.DEBUG);
    }

    public static Level toLevel(String str, Level level) {
        if (str != null) {
            String upperCase = str.toUpperCase();
            if (upperCase.equals("SEVERE")) {
                return SEVERE;
            }
            if (upperCase.equals("WARNING")) {
                return WARNING;
            }
            if (upperCase.equals("INFO")) {
                return INFO;
            }
            if (upperCase.equals("CONFI")) {
                return CONFIG;
            }
            if (upperCase.equals("FINE")) {
                return FINE;
            }
            if (upperCase.equals("FINER")) {
                return FINER;
            }
            if (upperCase.equals("FINEST")) {
                return FINEST;
            }
        }
        return level;
    }
}
