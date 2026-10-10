package org.apache.log4j.helpers;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class FileWatchdog extends Thread {
    public static final long DEFAULT_DELAY = 60000;
    protected long delay;
    File file;
    protected String filename;
    boolean interrupted;
    long lastModif;
    boolean warnedAlready;

    protected void checkAndConfigure() {
        try {
            if (this.file.exists()) {
                long jLastModified = this.file.lastModified();
                if (jLastModified > this.lastModif) {
                    this.lastModif = jLastModified;
                    doOnChange();
                    this.warnedAlready = false;
                    return;
                }
                return;
            }
            if (this.warnedAlready) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[");
            stringBuffer.append(this.filename);
            stringBuffer.append("] does not exist.");
            LogLog.debug(stringBuffer.toString());
            this.warnedAlready = true;
        } catch (SecurityException unused) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Was not allowed to read check file existance, file:[");
            stringBuffer2.append(this.filename);
            stringBuffer2.append("].");
            LogLog.warn(stringBuffer2.toString());
            this.interrupted = true;
        }
    }

    protected abstract void doOnChange();

    protected FileWatchdog(String str) {
        super("FileWatchdog");
        this.delay = DEFAULT_DELAY;
        this.lastModif = 0L;
        this.warnedAlready = false;
        this.interrupted = false;
        this.filename = str;
        this.file = new File(str);
        setDaemon(true);
        checkAndConfigure();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.interrupted) {
            try {
                Thread.sleep(this.delay);
            } catch (InterruptedException unused) {
            }
            checkAndConfigure();
        }
    }

    public void setDelay(long j10) {
        this.delay = j10;
    }
}
