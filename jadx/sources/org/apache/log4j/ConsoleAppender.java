package org.apache.log4j;

import java.io.IOException;
import java.io.OutputStream;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ConsoleAppender extends WriterAppender {
    public static final String SYSTEM_ERR = "System.err";
    public static final String SYSTEM_OUT = "System.out";
    private boolean follow;
    protected String target;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class SystemErrStream extends OutputStream {
        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.err.write(bArr);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.err.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            System.err.write(bArr, i10, i11);
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            System.err.write(i10);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class SystemOutStream extends OutputStream {
        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            System.out.write(bArr);
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            System.out.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            System.out.write(bArr, i10, i11);
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            System.out.write(i10);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public ConsoleAppender() {
        this.target = SYSTEM_OUT;
        this.follow = false;
    }

    @Override // org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        if (this.follow) {
            if (this.target.equals(SYSTEM_ERR)) {
                setWriter(createWriter(new SystemErrStream()));
            } else {
                setWriter(createWriter(new SystemOutStream()));
            }
        } else if (this.target.equals(SYSTEM_ERR)) {
            setWriter(createWriter(System.err));
        } else {
            setWriter(createWriter(System.out));
        }
        super.activateOptions();
    }

    @Override // org.apache.log4j.WriterAppender
    protected final void closeWriter() {
        if (this.follow) {
            super.closeWriter();
        }
    }

    public final boolean getFollow() {
        return this.follow;
    }

    public String getTarget() {
        return this.target;
    }

    public final void setFollow(boolean z10) {
        this.follow = z10;
    }

    void targetWarn(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        stringBuffer.append(str);
        stringBuffer.append("] should be System.out or System.err.");
        LogLog.warn(stringBuffer.toString());
        LogLog.warn("Using previously set target, System.out by default.");
    }

    public void setTarget(String str) {
        String strTrim = str.trim();
        if (SYSTEM_OUT.equalsIgnoreCase(strTrim)) {
            this.target = SYSTEM_OUT;
        } else if (SYSTEM_ERR.equalsIgnoreCase(strTrim)) {
            this.target = SYSTEM_ERR;
        } else {
            targetWarn(str);
        }
    }

    public ConsoleAppender(Layout layout) {
        this(layout, SYSTEM_OUT);
    }

    public ConsoleAppender(Layout layout, String str) {
        this.target = SYSTEM_OUT;
        this.follow = false;
        setLayout(layout);
        setTarget(str);
        activateOptions();
    }
}
