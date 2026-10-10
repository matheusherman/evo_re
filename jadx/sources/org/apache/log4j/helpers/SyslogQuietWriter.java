package org.apache.log4j.helpers;

import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SyslogQuietWriter extends QuietWriter {
    int level;
    int syslogFacility;

    public void setLevel(int i10) {
        this.level = i10;
    }

    public void setSyslogFacility(int i10) {
        this.syslogFacility = i10;
    }

    @Override // org.apache.log4j.helpers.QuietWriter, java.io.Writer
    public void write(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<");
        stringBuffer.append(this.syslogFacility | this.level);
        stringBuffer.append(">");
        stringBuffer.append(str);
        super.write(stringBuffer.toString());
    }

    public SyslogQuietWriter(Writer writer, int i10, ErrorHandler errorHandler) {
        super(writer, errorHandler);
        this.syslogFacility = i10;
    }
}
