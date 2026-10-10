package org.apache.log4j.lf5;

import org.apache.log4j.lf5.viewer.LogBrokerMonitor;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class AppenderFinalizer {
    protected LogBrokerMonitor _defaultMonitor;

    protected void finalize() {
        System.out.println("Disposing of the default LogBrokerMonitor instance");
        this._defaultMonitor.dispose();
    }

    public AppenderFinalizer(LogBrokerMonitor logBrokerMonitor) {
        this._defaultMonitor = logBrokerMonitor;
    }
}
