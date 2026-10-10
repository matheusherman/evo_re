package org.apache.log4j.helpers;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import org.apache.log4j.spi.ErrorHandler;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CountingQuietWriter extends QuietWriter {
    protected long count;

    public long getCount() {
        return this.count;
    }

    public void setCount(long j10) {
        this.count = j10;
    }

    @Override // org.apache.log4j.helpers.QuietWriter, java.io.Writer
    public void write(String str) {
        try {
            ((FilterWriter) this).out.write(str);
            this.count += (long) str.length();
        } catch (IOException e10) {
            this.errorHandler.error("Write failure.", e10, 1);
        }
    }

    public CountingQuietWriter(Writer writer, ErrorHandler errorHandler) {
        super(writer, errorHandler);
    }
}
