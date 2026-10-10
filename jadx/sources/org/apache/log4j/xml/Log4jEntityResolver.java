package org.apache.log4j.xml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.apache.log4j.helpers.LogLog;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class Log4jEntityResolver implements EntityResolver {
    private static final String PUBLIC_ID = "-//APACHE//DTD LOG4J 1.2//EN";

    @Override // org.xml.sax.EntityResolver
    public InputSource resolveEntity(String str, String str2) {
        if (!str2.endsWith("log4j.dtd") && !PUBLIC_ID.equals(str)) {
            return null;
        }
        Class<?> cls = getClass();
        InputStream resourceAsStream = cls.getResourceAsStream("/org/apache/log4j/xml/log4j.dtd");
        if (resourceAsStream == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find [log4j.dtd] using [");
            stringBuffer.append(cls.getClassLoader());
            stringBuffer.append("] class loader, parsed without DTD.");
            LogLog.warn(stringBuffer.toString());
            resourceAsStream = new ByteArrayInputStream(new byte[0]);
        }
        return new InputSource(resourceAsStream);
    }
}
