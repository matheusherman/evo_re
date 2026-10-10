package org.apache.log4j.lf5;

import org.apache.log4j.spi.ThrowableInformation;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Log4JLogRecord extends LogRecord {
    @Override // org.apache.log4j.lf5.LogRecord
    public boolean isSevereLevel() {
        return LogLevel.ERROR.equals(getLevel()) || LogLevel.FATAL.equals(getLevel());
    }

    public void setThrownStackTrace(ThrowableInformation throwableInformation) {
        String[] throwableStrRep = throwableInformation.getThrowableStrRep();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : throwableStrRep) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append("\n");
            stringBuffer.append(stringBuffer2.toString());
        }
        this._thrownStackTrace = stringBuffer.toString();
    }
}
