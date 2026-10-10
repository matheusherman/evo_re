package org.apache.log4j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.DefaultRepositorySelector;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.NOPLoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.RootLogger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogManager {
    public static final String CONFIGURATOR_CLASS_KEY = "log4j.configuratorClass";
    public static final String DEFAULT_CONFIGURATION_FILE = "log4j.properties";
    public static final String DEFAULT_CONFIGURATION_KEY = "log4j.configuration";
    public static final String DEFAULT_INIT_OVERRIDE_KEY = "log4j.defaultInitOverride";
    static final String DEFAULT_XML_CONFIGURATION_FILE = "log4j.xml";
    private static Object guard;
    private static RepositorySelector repositorySelector = new DefaultRepositorySelector(new Hierarchy(new RootLogger(Level.DEBUG)));

    public static Logger getLogger(String str) {
        return getLoggerRepository().getLogger(str);
    }

    static {
        URL resource;
        String systemProperty = OptionConverter.getSystemProperty(DEFAULT_INIT_OVERRIDE_KEY, null);
        if (systemProperty != null && !"false".equalsIgnoreCase(systemProperty)) {
            LogLog.debug("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
            return;
        }
        String systemProperty2 = OptionConverter.getSystemProperty(DEFAULT_CONFIGURATION_KEY, null);
        String systemProperty3 = OptionConverter.getSystemProperty(CONFIGURATOR_CLASS_KEY, null);
        if (systemProperty2 == null) {
            resource = Loader.getResource(DEFAULT_XML_CONFIGURATION_FILE);
            if (resource == null) {
                resource = Loader.getResource(DEFAULT_CONFIGURATION_FILE);
            }
        } else {
            try {
                resource = new URL(systemProperty2);
            } catch (MalformedURLException unused) {
                resource = Loader.getResource(systemProperty2);
            }
        }
        if (resource == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find resource: [");
            stringBuffer.append(systemProperty2);
            stringBuffer.append("].");
            LogLog.debug(stringBuffer.toString());
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Using URL [");
        stringBuffer2.append(resource);
        stringBuffer2.append("] for automatic log4j configuration.");
        LogLog.debug(stringBuffer2.toString());
        try {
            OptionConverter.selectAndConfigure(resource, systemProperty3, getLoggerRepository());
        } catch (NoClassDefFoundError e10) {
            LogLog.warn("Error during default initialization", e10);
        }
    }

    public static Logger getLogger(Class cls) {
        return getLoggerRepository().getLogger(cls.getName());
    }

    public static LoggerRepository getLoggerRepository() {
        if (repositorySelector == null) {
            repositorySelector = new DefaultRepositorySelector(new NOPLoggerRepository());
            guard = null;
            IllegalStateException illegalStateException = new IllegalStateException("Class invariant violation");
            if (isLikelySafeScenario(illegalStateException)) {
                LogLog.debug("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            } else {
                LogLog.error("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            }
        }
        return repositorySelector.getLoggerRepository();
    }

    private static boolean isLikelySafeScenario(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1;
    }

    public static void setRepositorySelector(RepositorySelector repositorySelector2, Object obj) {
        Object obj2 = guard;
        if (obj2 != null && obj2 != obj) {
            throw new IllegalArgumentException("Attempted to reset the LoggerFactory without possessing the guard.");
        }
        if (repositorySelector2 == null) {
            throw new IllegalArgumentException("RepositorySelector must be non-null.");
        }
        guard = obj;
        repositorySelector = repositorySelector2;
    }

    public static Logger exists(String str) {
        return getLoggerRepository().exists(str);
    }

    public static Enumeration getCurrentLoggers() {
        return getLoggerRepository().getCurrentLoggers();
    }

    public static Logger getLogger(String str, LoggerFactory loggerFactory) {
        return getLoggerRepository().getLogger(str, loggerFactory);
    }

    public static Logger getRootLogger() {
        return getLoggerRepository().getRootLogger();
    }

    public static void resetConfiguration() {
        getLoggerRepository().resetConfiguration();
    }

    public static void shutdown() {
        getLoggerRepository().shutdown();
    }
}
