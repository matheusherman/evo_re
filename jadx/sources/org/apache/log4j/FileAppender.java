package org.apache.log4j;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class FileAppender extends WriterAppender {
    protected int bufferSize;
    protected boolean bufferedIO;
    protected boolean fileAppend;
    protected String fileName;

    public FileAppender() {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
    }

    public void setFile(String str) {
        this.fileName = str.trim();
    }

    @Override // org.apache.log4j.WriterAppender, org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
        String str = this.fileName;
        if (str == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("File option not set for appender [");
            stringBuffer.append(this.name);
            stringBuffer.append("].");
            LogLog.warn(stringBuffer.toString());
            LogLog.warn("Are you using FileAppender instead of ConsoleAppender?");
            return;
        }
        try {
            setFile(str, this.fileAppend, this.bufferedIO, this.bufferSize);
        } catch (IOException e10) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("setFile(");
            stringBuffer2.append(this.fileName);
            stringBuffer2.append(",");
            stringBuffer2.append(this.fileAppend);
            stringBuffer2.append(") call failed.");
            errorHandler.error(stringBuffer2.toString(), e10, 4);
        }
    }

    protected void closeFile() {
        QuietWriter quietWriter = this.qw;
        if (quietWriter != null) {
            try {
                quietWriter.close();
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not close ");
                stringBuffer.append(this.qw);
                LogLog.error(stringBuffer.toString(), e10);
            }
        }
    }

    public boolean getAppend() {
        return this.fileAppend;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public boolean getBufferedIO() {
        return this.bufferedIO;
    }

    public String getFile() {
        return this.fileName;
    }

    public void setAppend(boolean z10) {
        this.fileAppend = z10;
    }

    public void setBufferSize(int i10) {
        this.bufferSize = i10;
    }

    public void setBufferedIO(boolean z10) {
        this.bufferedIO = z10;
        if (z10) {
            this.immediateFlush = false;
        }
    }

    protected void setQWForFiles(Writer writer) {
        this.qw = new QuietWriter(writer, this.errorHandler);
    }

    @Override // org.apache.log4j.WriterAppender
    protected void reset() {
        closeFile();
        this.fileName = null;
        super.reset();
    }

    public synchronized void setFile(String str, boolean z10, boolean z11, int i10) {
        FileOutputStream fileOutputStream;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("setFile called: ");
            stringBuffer.append(str);
            stringBuffer.append(", ");
            stringBuffer.append(z10);
            LogLog.debug(stringBuffer.toString());
            if (z11) {
                setImmediateFlush(false);
            }
            reset();
            try {
                fileOutputStream = new FileOutputStream(str, z10);
            } catch (FileNotFoundException e10) {
                String parent = new File(str).getParent();
                if (parent != null) {
                    File file = new File(parent);
                    if (!file.exists() && file.mkdirs()) {
                        fileOutputStream = new FileOutputStream(str, z10);
                    } else {
                        throw e10;
                    }
                } else {
                    throw e10;
                }
            }
            Writer writerCreateWriter = createWriter(fileOutputStream);
            if (z11) {
                writerCreateWriter = new BufferedWriter(writerCreateWriter, i10);
            }
            setQWForFiles(writerCreateWriter);
            this.fileName = str;
            this.fileAppend = z10;
            this.bufferedIO = z11;
            this.bufferSize = i10;
            writeHeader();
            LogLog.debug("setFile ended");
        } catch (Throwable th) {
            throw th;
        }
    }

    public FileAppender(Layout layout, String str, boolean z10, boolean z11, int i10) {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
        this.layout = layout;
        setFile(str, z10, z11, i10);
    }

    public FileAppender(Layout layout, String str, boolean z10) {
        this.fileAppend = true;
        this.fileName = null;
        this.bufferedIO = false;
        this.bufferSize = 8192;
        this.layout = layout;
        setFile(str, z10, false, 8192);
    }

    public FileAppender(Layout layout, String str) {
        this(layout, str, true);
    }
}
