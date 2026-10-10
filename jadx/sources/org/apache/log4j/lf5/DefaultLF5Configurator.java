package org.apache.log4j.lf5;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class DefaultLF5Configurator implements Configurator {
    static /* synthetic */ Class class$org$apache$log4j$lf5$DefaultLF5Configurator;

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(InputStream inputStream, LoggerRepository loggerRepository) {
        throw new IllegalStateException("This class should NOT be instantiated!");
    }

    public static void configure() throws Throwable {
        Class clsClass$ = class$org$apache$log4j$lf5$DefaultLF5Configurator;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.lf5.DefaultLF5Configurator");
            class$org$apache$log4j$lf5$DefaultLF5Configurator = clsClass$;
        }
        URL resource = clsClass$.getResource("/org/apache/log4j/lf5/config/defaultconfig.properties");
        if (resource != null) {
            PropertyConfigurator.configure(resource);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Error: Unable to open the resource");
        stringBuffer.append("/org/apache/log4j/lf5/config/defaultconfig.properties");
        throw new IOException(stringBuffer.toString());
    }

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(URL url, LoggerRepository loggerRepository) {
        throw new IllegalStateException("This class should NOT be instantiated!");
    }

    private DefaultLF5Configurator() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
