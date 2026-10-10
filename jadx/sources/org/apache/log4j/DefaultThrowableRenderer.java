package org.apache.log4j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.log4j.spi.ThrowableRenderer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class DefaultThrowableRenderer implements ThrowableRenderer {
    public static String[] render(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
        } catch (RuntimeException unused) {
        }
        printWriter.flush();
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
        ArrayList arrayList = new ArrayList();
        try {
            for (String line = lineNumberReader.readLine(); line != null; line = lineNumberReader.readLine()) {
                arrayList.add(line);
            }
        } catch (IOException e10) {
            if (e10 instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            arrayList.add(e10.toString());
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    @Override // org.apache.log4j.spi.ThrowableRenderer
    public String[] doRender(Throwable th) {
        return render(th);
    }
}
