package org.apache.log4j.helpers;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class FormattingInfo {
    int min = -1;
    int max = Integer.MAX_VALUE;
    boolean leftAlign = false;

    void reset() {
        this.min = -1;
        this.max = Integer.MAX_VALUE;
        this.leftAlign = false;
    }

    void dump() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("min=");
        stringBuffer.append(this.min);
        stringBuffer.append(", max=");
        stringBuffer.append(this.max);
        stringBuffer.append(", leftAlign=");
        stringBuffer.append(this.leftAlign);
        LogLog.debug(stringBuffer.toString());
    }
}
