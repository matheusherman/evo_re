package org.apache.log4j.pattern;

import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class ClassNamePatternConverter extends NamePatternConverter {
    private ClassNamePatternConverter(String[] strArr) {
        super("Class Name", "class name", strArr);
    }

    public static ClassNamePatternConverter newInstance(String[] strArr) {
        return new ClassNamePatternConverter(strArr);
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) {
        int length = stringBuffer.length();
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        if (locationInformation == null) {
            stringBuffer.append(LocationInfo.NA);
        } else {
            stringBuffer.append(locationInformation.getClassName());
        }
        abbreviate(length, stringBuffer);
    }
}
