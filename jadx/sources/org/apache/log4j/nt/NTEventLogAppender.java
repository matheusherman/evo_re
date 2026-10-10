package org.apache.log4j.nt;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.TTCCLayout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class NTEventLogAppender extends AppenderSkeleton {
    private int _handle;
    private String server;
    private String source;

    static {
        String[] strArr;
        try {
            strArr = new String[]{System.getProperty("os.arch")};
        } catch (SecurityException unused) {
            strArr = new String[]{"amd64", "ia64", "x86"};
        }
        for (String str : strArr) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("NTEventLogAppender.");
                stringBuffer.append(str);
                System.loadLibrary(stringBuffer.toString());
                return;
            } catch (UnsatisfiedLinkError unused2) {
            }
        }
        System.loadLibrary("NTEventLogAppender");
    }

    public NTEventLogAppender() {
        this(null, null, null);
    }

    private native void deregisterEventSource(int i10);

    private native int registerEventSource(String str, String str2);

    private native void reportEvent(int i10, String str, int i11);

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    public NTEventLogAppender(String str) {
        this(null, str, null);
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        String str = this.source;
        if (str != null) {
            try {
                this._handle = registerEventSource(this.server, str);
            } catch (Exception e10) {
                LogLog.error("Could not register event source.", e10);
                this._handle = 0;
            }
        }
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.layout.format(loggingEvent));
        if (this.layout.ignoresThrowable() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                stringBuffer.append(str);
            }
        }
        reportEvent(this._handle, stringBuffer.toString(), loggingEvent.getLevel().toInt());
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void finalize() {
        deregisterEventSource(this._handle);
        this._handle = 0;
    }

    public String getSource() {
        return this.source;
    }

    public NTEventLogAppender(String str, String str2) {
        this(str, str2, null);
    }

    public void setSource(String str) {
        this.source = str.trim();
    }

    public NTEventLogAppender(Layout layout) {
        this(null, null, layout);
    }

    public NTEventLogAppender(String str, Layout layout) {
        this(null, str, layout);
    }

    public NTEventLogAppender(String str, String str2, Layout layout) {
        this._handle = 0;
        this.source = null;
        this.server = null;
        str2 = str2 == null ? "Log4j" : str2;
        if (layout == null) {
            this.layout = new TTCCLayout();
        } else {
            this.layout = layout;
        }
        try {
            this._handle = registerEventSource(str, str2);
        } catch (Exception e10) {
            e10.printStackTrace();
            this._handle = 0;
        }
    }

    @Override // org.apache.log4j.Appender
    public void close() {
    }
}
