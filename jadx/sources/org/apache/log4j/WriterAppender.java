package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.QuietWriter;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class WriterAppender extends AppenderSkeleton {
    protected String encoding;
    protected boolean immediateFlush;
    protected QuietWriter qw;

    public WriterAppender() {
        this.immediateFlush = true;
    }

    @Override // org.apache.log4j.Appender
    public synchronized void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        writeFooter();
        reset();
    }

    @Override // org.apache.log4j.Appender
    public boolean requiresLayout() {
        return true;
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.Appender
    public synchronized void setErrorHandler(ErrorHandler errorHandler) {
        try {
            if (errorHandler == null) {
                LogLog.warn("You have tried to set a null error-handler.");
            } else {
                this.errorHandler = errorHandler;
                QuietWriter quietWriter = this.qw;
                if (quietWriter != null) {
                    quietWriter.setErrorHandler(errorHandler);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setWriter(Writer writer) {
        reset();
        this.qw = new QuietWriter(writer, this.errorHandler);
        writeHeader();
    }

    protected boolean checkEntryConditions() {
        if (this.closed) {
            LogLog.warn("Not allowed to write to a closed appender.");
            return false;
        }
        if (this.qw == null) {
            ErrorHandler errorHandler = this.errorHandler;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("No output stream or file set for the appender named [");
            stringBuffer.append(this.name);
            stringBuffer.append("].");
            errorHandler.error(stringBuffer.toString());
            return false;
        }
        if (this.layout != null) {
            return true;
        }
        ErrorHandler errorHandler2 = this.errorHandler;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("No layout set for the appender named [");
        stringBuffer2.append(this.name);
        stringBuffer2.append("].");
        errorHandler2.error(stringBuffer2.toString());
        return false;
    }

    protected void closeWriter() {
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

    public String getEncoding() {
        return this.encoding;
    }

    public boolean getImmediateFlush() {
        return this.immediateFlush;
    }

    public void setEncoding(String str) {
        this.encoding = str;
    }

    public void setImmediateFlush(boolean z10) {
        this.immediateFlush = z10;
    }

    protected boolean shouldFlush(LoggingEvent loggingEvent) {
        return this.immediateFlush;
    }

    protected void subAppend(LoggingEvent loggingEvent) {
        String[] throwableStrRep;
        this.qw.write(this.layout.format(loggingEvent));
        if (this.layout.ignoresThrowable() && (throwableStrRep = loggingEvent.getThrowableStrRep()) != null) {
            for (String str : throwableStrRep) {
                this.qw.write(str);
                this.qw.write(Layout.LINE_SEP);
            }
        }
        if (shouldFlush(loggingEvent)) {
            this.qw.flush();
        }
    }

    protected void writeFooter() {
        String footer;
        QuietWriter quietWriter;
        Layout layout = this.layout;
        if (layout == null || (footer = layout.getFooter()) == null || (quietWriter = this.qw) == null) {
            return;
        }
        quietWriter.write(footer);
        this.qw.flush();
    }

    protected void writeHeader() {
        String header;
        QuietWriter quietWriter;
        Layout layout = this.layout;
        if (layout == null || (header = layout.getHeader()) == null || (quietWriter = this.qw) == null) {
            return;
        }
        quietWriter.write(header);
    }

    public WriterAppender(Layout layout, OutputStream outputStream) {
        this(layout, new OutputStreamWriter(outputStream));
    }

    @Override // org.apache.log4j.AppenderSkeleton
    public void append(LoggingEvent loggingEvent) {
        if (!checkEntryConditions()) {
            return;
        }
        subAppend(loggingEvent);
    }

    protected OutputStreamWriter createWriter(OutputStream outputStream) {
        OutputStreamWriter outputStreamWriter;
        String encoding = getEncoding();
        if (encoding != null) {
            try {
                outputStreamWriter = new OutputStreamWriter(outputStream, encoding);
            } catch (IOException e10) {
                if (e10 instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
                LogLog.warn("Error initializing output writer.");
                LogLog.warn("Unsupported encoding?");
                outputStreamWriter = null;
            }
        } else {
            outputStreamWriter = null;
        }
        if (outputStreamWriter == null) {
            return new OutputStreamWriter(outputStream);
        }
        return outputStreamWriter;
    }

    protected void reset() {
        closeWriter();
        this.qw = null;
    }

    public WriterAppender(Layout layout, Writer writer) {
        this.immediateFlush = true;
        this.layout = layout;
        setWriter(writer);
    }

    @Override // org.apache.log4j.AppenderSkeleton, org.apache.log4j.spi.OptionHandler
    public void activateOptions() {
    }
}
