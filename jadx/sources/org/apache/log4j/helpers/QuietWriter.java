package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class QuietWriter extends FilterWriter {
    protected ErrorHandler errorHandler;

    @Override // java.io.FilterWriter, java.io.Writer, java.io.Flushable
    public void flush() {
        try {
            ((FilterWriter) this).out.flush();
        } catch (Exception e10) {
            this.errorHandler.error("Failed to flush writer,", e10, 2);
        }
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            throw new IllegalArgumentException("Attempted to set null ErrorHandler.");
        }
        this.errorHandler = errorHandler;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            try {
                ((FilterWriter) this).out.write(str);
            } catch (Exception e10) {
                ErrorHandler errorHandler = this.errorHandler;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Failed to write [");
                stringBuffer.append(str);
                stringBuffer.append("].");
                errorHandler.error(stringBuffer.toString(), e10, 1);
            }
        }
    }

    public QuietWriter(Writer writer, ErrorHandler errorHandler) {
        super(writer);
        setErrorHandler(errorHandler);
    }
}
