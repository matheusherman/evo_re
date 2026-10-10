package z5;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);

    private final int[] f580a;
    private final int f581b;

    public int f() {
        return this.f581b;
    }

    b(int[] iArr, int i10) {
        this.f580a = iArr;
        this.f581b = i10;
    }

    public int i(c cVar) {
        char c10;
        int iE = cVar.e();
        int[] iArr = this.f580a;
        if (iE <= 9) {
            c10 = 0;
        } else if (iE <= 26) {
            c10 = 1;
        } else {
            c10 = 2;
        }
        return iArr[c10];
    }
}
