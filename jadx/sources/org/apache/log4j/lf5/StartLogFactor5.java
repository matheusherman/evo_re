package org.apache.log4j.lf5;

import org.apache.log4j.lf5.viewer.LogBrokerMonitor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class StartLogFactor5 {
    public static final void main(String[] strArr) {
        LogBrokerMonitor logBrokerMonitor = new LogBrokerMonitor(LogLevel.getLog4JLevels());
        logBrokerMonitor.setFrameSize(LF5Appender.getDefaultMonitorWidth(), LF5Appender.getDefaultMonitorHeight());
        logBrokerMonitor.setFontSize(12);
        logBrokerMonitor.show();
    }
}
