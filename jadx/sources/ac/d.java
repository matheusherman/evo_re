package ac;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum d {
    JAVA_0_9(1.5f, "0.9"),
    JAVA_1_1(1.1f, "1.1"),
    JAVA_1_2(1.2f, "1.2"),
    JAVA_1_3(1.3f, "1.3"),
    JAVA_1_4(1.4f, "1.4"),
    JAVA_1_5(1.5f, "1.5"),
    JAVA_1_6(1.6f, "1.6"),
    JAVA_1_7(1.7f, "1.7"),
    JAVA_1_8(1.8f, "1.8"),
    JAVA_1_9(1.9f, "1.9"),
    JAVA_RECENT(f(), Float.toString(f()));

    private final String name;
    private final float value;

    static d a(String str) {
        if ("0.9".equals(str)) {
            return JAVA_0_9;
        }
        if ("1.1".equals(str)) {
            return JAVA_1_1;
        }
        if ("1.2".equals(str)) {
            return JAVA_1_2;
        }
        if ("1.3".equals(str)) {
            return JAVA_1_3;
        }
        if ("1.4".equals(str)) {
            return JAVA_1_4;
        }
        if ("1.5".equals(str)) {
            return JAVA_1_5;
        }
        if ("1.6".equals(str)) {
            return JAVA_1_6;
        }
        if ("1.7".equals(str)) {
            return JAVA_1_7;
        }
        if ("1.8".equals(str)) {
            return JAVA_1_8;
        }
        if ("1.9".equals(str)) {
            return JAVA_1_9;
        }
        if (str != null && ((double) i(str)) - 1.0d < 1.0d) {
            int iMax = Math.max(str.indexOf(46), str.indexOf(44));
            if (Float.parseFloat(str.substring(iMax + 1, Math.max(str.length(), str.indexOf(44, iMax)))) > 0.9f) {
                return JAVA_RECENT;
            }
        }
        return null;
    }

    private static float f() {
        float fI = i(System.getProperty("java.version", "2.0"));
        if (fI > 0.0f) {
            return fI;
        }
        return 2.0f;
    }

    private static float i(String str) {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length < 2) {
            return -1.0f;
        }
        try {
            return Float.parseFloat(strArrSplit[0] + '.' + strArrSplit[1]);
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }

    d(float f10, String str) {
        this.value = f10;
        this.name = str;
    }
}
