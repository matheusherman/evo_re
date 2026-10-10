package org.apache.log4j.pattern;

import java.util.ArrayList;
import java.util.Iterator;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class BridgePatternConverter extends org.apache.log4j.helpers.PatternConverter {
    private boolean handlesExceptions;
    private LoggingEventPatternConverter[] patternConverters;
    private FormattingInfo[] patternFields;

    @Override // org.apache.log4j.helpers.PatternConverter
    public void format(StringBuffer stringBuffer, LoggingEvent loggingEvent) {
        for (int i10 = 0; i10 < this.patternConverters.length; i10++) {
            int length = stringBuffer.length();
            this.patternConverters[i10].format(loggingEvent, stringBuffer);
            this.patternFields[i10].format(length, stringBuffer);
        }
    }

    @Override // org.apache.log4j.helpers.PatternConverter
    protected String convert(LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        format(stringBuffer, loggingEvent);
        return stringBuffer.toString();
    }

    public boolean ignoresThrowable() {
        return !this.handlesExceptions;
    }

    public BridgePatternConverter(String str) {
        this.next = null;
        int i10 = 0;
        this.handlesExceptions = false;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        PatternParser.parse(str, arrayList, arrayList2, null, PatternParser.getPatternLayoutRules());
        this.patternConverters = new LoggingEventPatternConverter[arrayList.size()];
        this.patternFields = new FormattingInfo[arrayList.size()];
        Iterator it = arrayList2.iterator();
        for (Object obj : arrayList) {
            if (obj instanceof LoggingEventPatternConverter) {
                LoggingEventPatternConverter loggingEventPatternConverter = (LoggingEventPatternConverter) obj;
                this.patternConverters[i10] = loggingEventPatternConverter;
                this.handlesExceptions = loggingEventPatternConverter.handlesThrowable() | this.handlesExceptions;
            } else {
                this.patternConverters[i10] = new LiteralPatternConverter("");
            }
            if (it.hasNext()) {
                this.patternFields[i10] = (FormattingInfo) it.next();
            } else {
                this.patternFields[i10] = FormattingInfo.getDefault();
            }
            i10++;
        }
    }
}
