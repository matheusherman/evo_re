package org.apache.log4j.pattern;

import java.util.Set;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.MDCKeySetExtractor;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class PropertiesPatternConverter extends LoggingEventPatternConverter {
    private final String option;

    private PropertiesPatternConverter(String[] strArr) {
        String string;
        if (strArr == null || strArr.length <= 0) {
            string = "Properties";
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Property{");
            stringBuffer.append(strArr[0]);
            stringBuffer.append("}");
            string = stringBuffer.toString();
        }
        super(string, "property");
        if (strArr == null || strArr.length <= 0) {
            this.option = null;
        } else {
            this.option = strArr[0];
        }
    }

    public static PropertiesPatternConverter newInstance(String[] strArr) {
        return new PropertiesPatternConverter(strArr);
    }

    @Override // org.apache.log4j.pattern.LoggingEventPatternConverter
    public void format(LoggingEvent loggingEvent, StringBuffer stringBuffer) throws Throwable {
        String str = this.option;
        if (str != null) {
            Object mdc = loggingEvent.getMDC(str);
            if (mdc != null) {
                stringBuffer.append(mdc);
                return;
            }
            return;
        }
        stringBuffer.append("{");
        try {
            Set propertyKeySet = MDCKeySetExtractor.INSTANCE.getPropertyKeySet(loggingEvent);
            if (propertyKeySet != null) {
                for (Object obj : propertyKeySet) {
                    Object mdc2 = loggingEvent.getMDC(obj.toString());
                    stringBuffer.append("{");
                    stringBuffer.append(obj);
                    stringBuffer.append(",");
                    stringBuffer.append(mdc2);
                    stringBuffer.append("}");
                }
            }
        } catch (Exception e10) {
            LogLog.error("Unexpected exception while extracting MDC keys", e10);
        }
        stringBuffer.append("}");
    }
}
