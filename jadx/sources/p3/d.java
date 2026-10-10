package p3;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum d {
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

    private static final Map<Integer, d> B = new HashMap();
    private static final Map<String, d> C = new HashMap();
    private final String[] otherEncodingNames;
    private final int[] values;

    d(int i10) {
        this(new int[]{i10}, new String[0]);
    }

    static {
        for (d dVar : values()) {
            if (Charset.isSupported(dVar.name())) {
                for (int i10 : dVar.values) {
                    B.put(Integer.valueOf(i10), dVar);
                }
                C.put(dVar.name(), dVar);
                for (String str : dVar.otherEncodingNames) {
                    C.put(str, dVar);
                }
            }
        }
    }

    d(int i10, String... strArr) {
        this.values = new int[]{i10};
        this.otherEncodingNames = strArr;
    }

    public static d f(Charset charset) {
        return C.get(charset.name());
    }

    public static d i(String str) {
        return C.get(str);
    }

    public static d j(int i10) throws h3.h {
        if (i10 < 0 || i10 >= 900) {
            throw h3.h.a();
        }
        return B.get(Integer.valueOf(i10));
    }

    public int l() {
        return this.values[0];
    }

    public Charset k() {
        return Charset.forName(name());
    }

    d(int[] iArr, String... strArr) {
        this.values = iArr;
        this.otherEncodingNames = strArr;
    }
}
