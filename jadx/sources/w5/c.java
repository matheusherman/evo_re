package w5;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum c {
    Cp437(new int[]{0, 2}, new String[0]),
    ISO8859_1(new int[]{1, 3}, "ISO-8859-1"),
    ISO8859_2(4, "ISO-8859-2"),
    ISO8859_3(5, "ISO-8859-3"),
    ISO8859_4(6, "ISO-8859-4"),
    ISO8859_5(7, "ISO-8859-5"),
    ISO8859_6(8, "ISO-8859-6"),
    ISO8859_7(9, "ISO-8859-7"),
    ISO8859_8(10, "ISO-8859-8"),
    ISO8859_9(11, "ISO-8859-9"),
    ISO8859_10(12, "ISO-8859-10"),
    ISO8859_11(13, "ISO-8859-11"),
    ISO8859_13(15, "ISO-8859-13"),
    ISO8859_14(16, "ISO-8859-14"),
    ISO8859_15(17, "ISO-8859-15"),
    ISO8859_16(18, "ISO-8859-16"),
    SJIS(20, "Shift_JIS"),
    Cp1250(21, "windows-1250"),
    Cp1251(22, "windows-1251"),
    Cp1252(23, "windows-1252"),
    Cp1256(24, "windows-1256"),
    UnicodeBigUnmarked(25, "UTF-16BE", "UnicodeBig"),
    UTF8(26, "UTF-8"),
    ASCII(new int[]{27, 170}, "US-ASCII"),
    Big5(28),
    GB18030(29, "GB2312", "EUC_CN", "GBK"),
    EUC_KR(30, "EUC-KR");

    private static Map B;
    private static Map C;
    private final int[] f569c;
    private final String[] f570d;

    c(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    static {
        B = null;
        C = null;
        B = new HashMap();
        C = new HashMap();
        for (c cVar : values()) {
            for (int i10 : cVar.f569c) {
                B.put(Integer.valueOf(i10), cVar);
            }
            C.put(cVar.name(), cVar);
            for (String str : cVar.f570d) {
                C.put(str, cVar);
            }
        }
    }

    c(int i10, String... strArr) {
        this.f569c = new int[]{i10};
        this.f570d = strArr;
    }

    public static c f(String str) {
        return (c) C.get(str);
    }

    public int i() {
        return this.f569c[0];
    }

    c(int[] iArr, String... strArr) {
        this.f569c = iArr;
        this.f570d = strArr;
    }
}
