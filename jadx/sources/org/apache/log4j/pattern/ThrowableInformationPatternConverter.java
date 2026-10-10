package org.apache.log4j.pattern;

import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.ThrowableInformation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ThrowableInformationPatternConverter extends LoggingEventPatternConverter {
    private int maxLines;

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public boolean handlesThrowable() {
        return true;
    }

    private ThrowableInformationPatternConverter(String[] strArr) {
        super("Throwable", "throwable");
        this.maxLines = Integer.MAX_VALUE;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        if ("none".equals(strArr[0])) {
            this.maxLines = 0;
        } else if ("short".equals(strArr[0])) {
            this.maxLines = 1;
        } else {
            try {
                this.maxLines = Integer.parseInt(strArr[0]);
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static ThrowableInformationPatternConverter newInstance(String[] strArr) {
        return new ThrowableInformationPatternConverter(strArr);
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        ThrowableInformation throwableInformation;
        if (this.maxLines == 0 || (throwableInformation = loggingEvent.getThrowableInformation()) == null) {
            return;
        }
        String[] throwableStrRep = throwableInformation.getThrowableStrRep();
        int length = throwableStrRep.length;
        int i10 = this.maxLines;
        if (i10 < 0) {
            length += i10;
        } else if (length > i10) {
            length = i10;
        }
        for (int i11 = 0; i11 < length; i11++) {
            stringBuffer.append(throwableStrRep[i11]);
            stringBuffer.append("\n");
        }
    }
}
