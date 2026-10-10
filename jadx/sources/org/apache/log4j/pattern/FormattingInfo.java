package org.apache.log4j.pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class FormattingInfo {
    private final boolean leftAlign;
    private final int maxLength;
    private final int minLength;
    private static final char[] SPACES = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    private static final FormattingInfo DEFAULT = new FormattingInfo(false, 0, Integer.MAX_VALUE);

    public static FormattingInfo getDefault() {
        return DEFAULT;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public int getMinLength() {
        return this.minLength;
    }

    public boolean isLeftAligned() {
        return this.leftAlign;
    }

    public FormattingInfo(boolean z10, int i10, int i11) {
        this.leftAlign = z10;
        this.minLength = i10;
        this.maxLength = i11;
    }

    public void format(int i10, StringBuffer stringBuffer) {
        int length = stringBuffer.length() - i10;
        if (length > this.maxLength) {
            stringBuffer.delete(i10, stringBuffer.length() - this.maxLength);
            return;
        }
        int i11 = this.minLength;
        if (length < i11) {
            if (this.leftAlign) {
                stringBuffer.setLength(i10 + this.minLength);
                for (int length2 = stringBuffer.length(); length2 < stringBuffer.length(); length2++) {
                    stringBuffer.setCharAt(length2, ' ');
                }
                return;
            }
            int i12 = i11 - length;
            while (i12 > 8) {
                stringBuffer.insert(i10, SPACES);
                i12 -= 8;
            }
            stringBuffer.insert(i10, SPACES, 0, i12);
        }
    }
}
