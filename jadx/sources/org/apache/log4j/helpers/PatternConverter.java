package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class PatternConverter {
    static String[] SPACES = {" ", "  ", "    ", "        ", "                ", "                                "};
    boolean leftAlign;
    int max;
    int min;
    public PatternConverter next;

    protected PatternConverter() {
        this.min = -1;
        this.max = Integer.MAX_VALUE;
        this.leftAlign = false;
    }

    protected abstract String convert(LoggingEvent loggingEvent);

    public void spacePad(StringBuffer stringBuffer, int i10) {
        while (i10 >= 32) {
            stringBuffer.append(SPACES[5]);
            i10 -= 32;
        }
        for (int i11 = 4; i11 >= 0; i11--) {
            if (((1 << i11) & i10) != 0) {
                stringBuffer.append(SPACES[i11]);
            }
        }
    }

    public void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        String strConvert = convert(loggingEvent);
        if (strConvert == null) {
            int i10 = this.min;
            if (i10 > 0) {
                spacePad(stringBuffer, i10);
                return;
            }
            return;
        }
        int length = strConvert.length();
        int i11 = this.max;
        if (length > i11) {
            stringBuffer.append(strConvert.substring(length - i11));
            return;
        }
        int i12 = this.min;
        if (length < i12) {
            if (this.leftAlign) {
                stringBuffer.append(strConvert);
                spacePad(stringBuffer, this.min - length);
                return;
            } else {
                spacePad(stringBuffer, i12 - length);
                stringBuffer.append(strConvert);
                return;
            }
        }
        stringBuffer.append(strConvert);
    }

    protected PatternConverter(FormattingInfo formattingInfo) {
        this.min = -1;
        this.max = Integer.MAX_VALUE;
        this.leftAlign = false;
        this.min = formattingInfo.min;
        this.max = formattingInfo.max;
        this.leftAlign = formattingInfo.leftAlign;
    }
}
