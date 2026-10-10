package org.apache.log4j;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RollingFileAppender extends FileAppender {
    protected int maxBackupIndex;
    protected long maxFileSize;
    private long nextRollover;

    public RollingFileAppender() {
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
        this.nextRollover = 0L;
    }

    @Override // org.apache.log4j.FileAppender
    public synchronized void setFile(String str, boolean z10, boolean z11, int i10) {
        super.setFile(str, z10, this.bufferedIO, this.bufferSize);
        if (z10) {
            ((CountingQuietWriter) this.qw).setCount(new File(str).length());
        }
    }

    public int getMaxBackupIndex() {
        return this.maxBackupIndex;
    }

    public long getMaximumFileSize() {
        return this.maxFileSize;
    }

    public void rollOver() {
        QuietWriter quietWriter = this.qw;
        if (quietWriter != null) {
            long count = ((CountingQuietWriter) quietWriter).getCount();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("rolling over count=");
            stringBuffer.append(count);
            LogLog.debug(stringBuffer.toString());
            this.nextRollover = count + this.maxFileSize;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("maxBackupIndex=");
        stringBuffer2.append(this.maxBackupIndex);
        LogLog.debug(stringBuffer2.toString());
        boolean z10 = true;
        if (this.maxBackupIndex > 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append(this.fileName);
            stringBuffer3.append('.');
            stringBuffer3.append(this.maxBackupIndex);
            File file = new File(stringBuffer3.toString());
            boolean zDelete = file.exists() ? file.delete() : true;
            for (int i10 = this.maxBackupIndex - 1; i10 >= 1 && zDelete; i10--) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.fileName);
                stringBuffer4.append(".");
                stringBuffer4.append(i10);
                File file2 = new File(stringBuffer4.toString());
                if (file2.exists()) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(this.fileName);
                    stringBuffer5.append('.');
                    stringBuffer5.append(i10 + 1);
                    File file3 = new File(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Renaming file ");
                    stringBuffer6.append(file2);
                    stringBuffer6.append(" to ");
                    stringBuffer6.append(file3);
                    LogLog.debug(stringBuffer6.toString());
                    zDelete = file2.renameTo(file3);
                }
            }
            if (zDelete) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(this.fileName);
                stringBuffer7.append(".");
                stringBuffer7.append(1);
                File file4 = new File(stringBuffer7.toString());
                closeFile();
                File file5 = new File(this.fileName);
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append("Renaming file ");
                stringBuffer8.append(file5);
                stringBuffer8.append(" to ");
                stringBuffer8.append(file4);
                LogLog.debug(stringBuffer8.toString());
                zDelete = file5.renameTo(file4);
                if (!zDelete) {
                    try {
                        setFile(this.fileName, true, this.bufferedIO, this.bufferSize);
                    } catch (IOException e10) {
                        if (e10 instanceof InterruptedIOException) {
                            Thread.currentThread().interrupt();
                        }
                        StringBuffer stringBuffer9 = new StringBuffer();
                        stringBuffer9.append("setFile(");
                        stringBuffer9.append(this.fileName);
                        stringBuffer9.append(", true) call failed.");
                        LogLog.error(stringBuffer9.toString(), e10);
                    }
                }
            }
            z10 = zDelete;
        }
        if (z10) {
            try {
                setFile(this.fileName, false, this.bufferedIO, this.bufferSize);
                this.nextRollover = 0L;
            } catch (IOException e11) {
                if (e11 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer10 = new StringBuffer();
                stringBuffer10.append("setFile(");
                stringBuffer10.append(this.fileName);
                stringBuffer10.append(", false) call failed.");
                LogLog.error(stringBuffer10.toString(), e11);
            }
        }
    }

    public void setMaxBackupIndex(int i10) {
        this.maxBackupIndex = i10;
    }

    public void setMaxFileSize(String str) {
        this.maxFileSize = OptionConverter.toFileSize(str, this.maxFileSize + 1);
    }

    public void setMaximumFileSize(long j10) {
        this.maxFileSize = j10;
    }

    @Override // org.apache.log4j.FileAppender
    protected void setQWForFiles(Writer writer) {
        this.qw = new CountingQuietWriter(writer, this.errorHandler);
    }

    @Override // org.apache.log4j.WriterAppender
    protected void subAppend(LoggingEvent loggingEvent) {
        QuietWriter quietWriter;
        super.subAppend(loggingEvent);
        if (this.fileName != null && (quietWriter = this.qw) != null) {
            long count = ((CountingQuietWriter) quietWriter).getCount();
            if (count >= this.maxFileSize && count >= this.nextRollover) {
                rollOver();
            }
        }
    }

    public RollingFileAppender(Layout layout, String str, boolean z10) {
        super(layout, str, z10);
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
        this.nextRollover = 0L;
    }

    public RollingFileAppender(Layout layout, String str) {
        super(layout, str);
        this.maxFileSize = 10485760L;
        this.maxBackupIndex = 1;
        this.nextRollover = 0L;
    }
}
