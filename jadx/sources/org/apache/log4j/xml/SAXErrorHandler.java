package org.apache.log4j.xml;

import org.apache.log4j.helpers.LogLog;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SAXErrorHandler implements ErrorHandler {
    private static void emitMessage(String str, SAXParseException sAXParseException) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(sAXParseException.getLineNumber());
        stringBuffer.append(" and column ");
        stringBuffer.append(sAXParseException.getColumnNumber());
        LogLog.warn(stringBuffer.toString());
        LogLog.warn(sAXParseException.getMessage(), sAXParseException.getException());
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        emitMessage("Continuable parsing error ", sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) {
        emitMessage("Fatal parsing error ", sAXParseException);
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        emitMessage("Parsing warning ", sAXParseException);
    }
}
