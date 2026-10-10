package org.apache.log4j.varia;

import org.apache.log4j.RollingFileAppender;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ExternallyRolledFileAppender extends RollingFileAppender {
    public static final String OK = "OK";
    public static final String ROLL_OVER = "RollOver";
    HUP hup;
    int port = 0;

    public int getPort() {
        return this.port;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    @Override // org.apache.log4j.FileAppender, org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        super.activateOptions();
        if (this.port != 0) {
            HUP hup = this.hup;
            if (hup != null) {
                hup.interrupt();
            }
            HUP hup2 = new HUP(this, this.port);
            this.hup = hup2;
            hup2.setDaemon(true);
            this.hup.start();
        }
    }
}
