package org.apache.log4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class PropertyConfigurator implements Configurator {
    static final String ADDITIVITY_PREFIX = "log4j.additivity.";
    static final String APPENDER_PREFIX = "log4j.appender.";
    private static final String APPENDER_REF_TAG = "appender-ref";
    static final String CATEGORY_PREFIX = "log4j.category.";
    static final String FACTORY_PREFIX = "log4j.factory";
    private static final String INTERNAL_ROOT_NAME = "root";
    public static final String LOGGER_FACTORY_KEY = "log4j.loggerFactory";
    static final String LOGGER_PREFIX = "log4j.logger.";
    private static final String LOGGER_REF = "logger-ref";
    static final String RENDERER_PREFIX = "log4j.renderer.";
    private static final String RESET_KEY = "log4j.reset";
    static final String ROOT_CATEGORY_PREFIX = "log4j.rootCategory";
    static final String ROOT_LOGGER_PREFIX = "log4j.rootLogger";
    private static final String ROOT_REF = "root-ref";
    static final String THRESHOLD_PREFIX = "log4j.threshold";
    private static final String THROWABLE_RENDERER_PREFIX = "log4j.throwableRenderer";
    static /* synthetic */ Class class$org$apache$log4j$Appender;
    static /* synthetic */ Class class$org$apache$log4j$Layout;
    static /* synthetic */ Class class$org$apache$log4j$spi$ErrorHandler;
    static /* synthetic */ Class class$org$apache$log4j$spi$Filter;
    static /* synthetic */ Class class$org$apache$log4j$spi$LoggerFactory;
    static /* synthetic */ Class class$org$apache$log4j$spi$ThrowableRenderer;
    private LoggerRepository repository;
    protected Hashtable registry = new Hashtable(11);
    protected LoggerFactory loggerFactory = new DefaultCategoryFactory();

    public static void configure(String str) throws Throwable {
        new PropertyConfigurator().doConfigure(str, LogManager.getLoggerRepository());
    }

    public static void configureAndWatch(String str) {
        configureAndWatch(str, FileWatchdog.DEFAULT_DELAY);
    }

    public void doConfigure(String str, LoggerRepository loggerRepository) throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                    try {
                        fileInputStream2.close();
                    } catch (InterruptedIOException unused) {
                        Thread.currentThread().interrupt();
                    } catch (Throwable unused2) {
                    }
                    doConfigure(properties, loggerRepository);
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream = fileInputStream2;
                    if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                        Thread.currentThread().interrupt();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Could not read configuration file [");
                    stringBuffer.append(str);
                    stringBuffer.append("].");
                    LogLog.error(stringBuffer.toString(), e);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Ignoring configuration file [");
                    stringBuffer2.append(str);
                    stringBuffer2.append("].");
                    LogLog.error(stringBuffer2.toString());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (InterruptedIOException unused3) {
                            Thread.currentThread().interrupt();
                        } catch (Throwable unused4) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (InterruptedIOException unused5) {
                            Thread.currentThread().interrupt();
                        } catch (Throwable unused6) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void configure(URL url) throws Throwable {
        new PropertyConfigurator().doConfigure(url, LogManager.getLoggerRepository());
    }

    public static void configureAndWatch(String str, long j10) {
        PropertyWatchdog propertyWatchdog = new PropertyWatchdog(str);
        propertyWatchdog.setDelay(j10);
        propertyWatchdog.start();
    }

    private void parseErrorHandler(ErrorHandler errorHandler, String str, Properties properties, LoggerRepository loggerRepository) {
        Appender appender;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(ROOT_REF);
        if (OptionConverter.toBoolean(OptionConverter.findAndSubst(stringBuffer.toString(), properties), false)) {
            errorHandler.setLogger(loggerRepository.getRootLogger());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer2.append(LOGGER_REF);
        String strFindAndSubst = OptionConverter.findAndSubst(stringBuffer2.toString(), properties);
        if (strFindAndSubst != null) {
            LoggerFactory loggerFactory = this.loggerFactory;
            errorHandler.setLogger(loggerFactory == null ? loggerRepository.getLogger(strFindAndSubst) : loggerRepository.getLogger(strFindAndSubst, loggerFactory));
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        stringBuffer3.append(APPENDER_REF_TAG);
        String strFindAndSubst2 = OptionConverter.findAndSubst(stringBuffer3.toString(), properties);
        if (strFindAndSubst2 == null || (appender = parseAppender(properties, strFindAndSubst2)) == null) {
            return;
        }
        errorHandler.setBackupAppender(appender);
    }

    protected void configureLoggerFactory(Properties properties) throws Throwable {
        String strFindAndSubst = OptionConverter.findAndSubst(LOGGER_FACTORY_KEY, properties);
        if (strFindAndSubst != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Setting category factory to [");
            stringBuffer.append(strFindAndSubst);
            stringBuffer.append("].");
            LogLog.debug(stringBuffer.toString());
            Class clsClass$ = class$org$apache$log4j$spi$LoggerFactory;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.spi.LoggerFactory");
                class$org$apache$log4j$spi$LoggerFactory = clsClass$;
            }
            LoggerFactory loggerFactory = (LoggerFactory) OptionConverter.instantiateByClassName(strFindAndSubst, clsClass$, this.loggerFactory);
            this.loggerFactory = loggerFactory;
            PropertySetter.setProperties(loggerFactory, properties, "log4j.factory.");
        }
    }

    void configureRootCategory(Properties properties, LoggerRepository loggerRepository) {
        String str = ROOT_LOGGER_PREFIX;
        String strFindAndSubst = OptionConverter.findAndSubst(ROOT_LOGGER_PREFIX, properties);
        if (strFindAndSubst == null) {
            strFindAndSubst = OptionConverter.findAndSubst(ROOT_CATEGORY_PREFIX, properties);
            str = ROOT_CATEGORY_PREFIX;
        }
        String str2 = str;
        String str3 = strFindAndSubst;
        if (str3 == null) {
            LogLog.debug("Could not find root logger information. Is this OK?");
            return;
        }
        Logger rootLogger = loggerRepository.getRootLogger();
        synchronized (rootLogger) {
            parseCategory(properties, rootLogger, str2, INTERNAL_ROOT_NAME, str3);
        }
    }

    void parseAdditivityForLogger(Properties properties, Logger logger, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ADDITIVITY_PREFIX);
        stringBuffer.append(str);
        String strFindAndSubst = OptionConverter.findAndSubst(stringBuffer.toString(), properties);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Handling log4j.additivity.");
        stringBuffer2.append(str);
        stringBuffer2.append("=[");
        stringBuffer2.append(strFindAndSubst);
        stringBuffer2.append("]");
        LogLog.debug(stringBuffer2.toString());
        if (strFindAndSubst == null || strFindAndSubst.equals("")) {
            return;
        }
        boolean z10 = OptionConverter.toBoolean(strFindAndSubst, true);
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Setting additivity for \"");
        stringBuffer3.append(str);
        stringBuffer3.append("\" to ");
        stringBuffer3.append(z10);
        LogLog.debug(stringBuffer3.toString());
        logger.setAdditivity(z10);
    }

    Appender parseAppender(Properties properties, String str) throws Throwable {
        int i10;
        Appender appenderRegistryGet = registryGet(str);
        if (appenderRegistryGet != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Appender \"");
            stringBuffer.append(str);
            stringBuffer.append("\" was already parsed.");
            LogLog.debug(stringBuffer.toString());
            return appenderRegistryGet;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(APPENDER_PREFIX);
        stringBuffer2.append(str);
        String string = stringBuffer2.toString();
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(string);
        stringBuffer3.append(".layout");
        String string2 = stringBuffer3.toString();
        Class clsClass$ = class$org$apache$log4j$Appender;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.Appender");
            class$org$apache$log4j$Appender = clsClass$;
        }
        Appender appender = (Appender) OptionConverter.instantiateByKey(properties, string, clsClass$, null);
        if (appender == null) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not instantiate appender named \"");
            stringBuffer4.append(str);
            stringBuffer4.append("\".");
            LogLog.error(stringBuffer4.toString());
            return null;
        }
        appender.setName(str);
        if (appender instanceof OptionHandler) {
            if (appender.requiresLayout()) {
                Class clsClass$2 = class$org$apache$log4j$Layout;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("org.apache.log4j.Layout");
                    class$org$apache$log4j$Layout = clsClass$2;
                }
                Layout layout = (Layout) OptionConverter.instantiateByKey(properties, string2, clsClass$2, null);
                if (layout != null) {
                    appender.setLayout(layout);
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append("Parsing layout options for \"");
                    stringBuffer5.append(str);
                    stringBuffer5.append("\".");
                    LogLog.debug(stringBuffer5.toString());
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append(string2);
                    stringBuffer6.append(".");
                    PropertySetter.setProperties(layout, properties, stringBuffer6.toString());
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append("End of parsing for \"");
                    stringBuffer7.append(str);
                    stringBuffer7.append("\".");
                    LogLog.debug(stringBuffer7.toString());
                }
            }
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append(string);
            stringBuffer8.append(".errorhandler");
            String string3 = stringBuffer8.toString();
            if (OptionConverter.findAndSubst(string3, properties) != null) {
                Class clsClass$3 = class$org$apache$log4j$spi$ErrorHandler;
                if (clsClass$3 == null) {
                    clsClass$3 = class$("org.apache.log4j.spi.ErrorHandler");
                    class$org$apache$log4j$spi$ErrorHandler = clsClass$3;
                }
                ErrorHandler errorHandler = (ErrorHandler) OptionConverter.instantiateByKey(properties, string3, clsClass$3, null);
                if (errorHandler != null) {
                    appender.setErrorHandler(errorHandler);
                    StringBuffer stringBuffer9 = new StringBuffer();
                    stringBuffer9.append("Parsing errorhandler options for \"");
                    stringBuffer9.append(str);
                    stringBuffer9.append("\".");
                    LogLog.debug(stringBuffer9.toString());
                    parseErrorHandler(errorHandler, string3, properties, this.repository);
                    Properties properties2 = new Properties();
                    StringBuffer stringBuffer10 = new StringBuffer();
                    stringBuffer10.append(string3);
                    stringBuffer10.append(".");
                    stringBuffer10.append(ROOT_REF);
                    String string4 = stringBuffer10.toString();
                    StringBuffer stringBuffer11 = new StringBuffer();
                    stringBuffer11.append(string3);
                    stringBuffer11.append(".");
                    stringBuffer11.append(LOGGER_REF);
                    String string5 = stringBuffer11.toString();
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append(string3);
                    stringBuffer12.append(".");
                    stringBuffer12.append(APPENDER_REF_TAG);
                    String[] strArr = {string4, string5, stringBuffer12.toString()};
                    for (Map.Entry entry : properties.entrySet()) {
                        int i11 = 0;
                        while (true) {
                            i10 = 3;
                            if (i11 >= 3) {
                                break;
                            }
                            if (strArr[i11].equals(entry.getKey())) {
                                i10 = 3;
                                break;
                            }
                            i11++;
                        }
                        if (i11 == i10) {
                            properties2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    StringBuffer stringBuffer13 = new StringBuffer();
                    stringBuffer13.append(string3);
                    stringBuffer13.append(".");
                    PropertySetter.setProperties(errorHandler, properties2, stringBuffer13.toString());
                    StringBuffer stringBuffer14 = new StringBuffer();
                    stringBuffer14.append("End of errorhandler parsing for \"");
                    stringBuffer14.append(str);
                    stringBuffer14.append("\".");
                    LogLog.debug(stringBuffer14.toString());
                }
            }
            StringBuffer stringBuffer15 = new StringBuffer();
            stringBuffer15.append(string);
            stringBuffer15.append(".");
            PropertySetter.setProperties(appender, properties, stringBuffer15.toString());
            StringBuffer stringBuffer16 = new StringBuffer();
            stringBuffer16.append("Parsed \"");
            stringBuffer16.append(str);
            stringBuffer16.append("\" options.");
            LogLog.debug(stringBuffer16.toString());
        }
        parseAppenderFilters(properties, str, appender);
        registryPut(appender);
        return appender;
    }

    void parseAppenderFilters(Properties properties, String str, Appender appender) throws Throwable {
        String strSubstring;
        String strSubstring2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(APPENDER_PREFIX);
        stringBuffer.append(str);
        stringBuffer.append(".filter.");
        String string = stringBuffer.toString();
        int length = string.length();
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationKeys = properties.keys();
        String str2 = "";
        while (enumerationKeys.hasMoreElements()) {
            String str3 = (String) enumerationKeys.nextElement();
            if (str3.startsWith(string)) {
                int iIndexOf = str3.indexOf(46, length);
                if (iIndexOf != -1) {
                    strSubstring2 = str3.substring(0, iIndexOf);
                    strSubstring = str3.substring(iIndexOf + 1);
                } else {
                    strSubstring = str2;
                    strSubstring2 = str3;
                }
                Vector vector = (Vector) hashtable.get(strSubstring2);
                if (vector == null) {
                    vector = new Vector();
                    hashtable.put(strSubstring2, vector);
                }
                if (iIndexOf != -1) {
                    vector.add(new NameValue(strSubstring, OptionConverter.findAndSubst(str3, properties)));
                }
                str2 = strSubstring;
            }
        }
        SortedKeyEnumeration sortedKeyEnumeration = new SortedKeyEnumeration(hashtable);
        while (sortedKeyEnumeration.hasMoreElements()) {
            String str4 = (String) sortedKeyEnumeration.nextElement();
            String property = properties.getProperty(str4);
            if (property != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Filter key: [");
                stringBuffer2.append(str4);
                stringBuffer2.append("] class: [");
                stringBuffer2.append(properties.getProperty(str4));
                stringBuffer2.append("] props: ");
                stringBuffer2.append(hashtable.get(str4));
                LogLog.debug(stringBuffer2.toString());
                Class clsClass$ = class$org$apache$log4j$spi$Filter;
                if (clsClass$ == null) {
                    clsClass$ = class$("org.apache.log4j.spi.Filter");
                    class$org$apache$log4j$spi$Filter = clsClass$;
                }
                Filter filter = (Filter) OptionConverter.instantiateByClassName(property, clsClass$, null);
                if (filter != null) {
                    PropertySetter propertySetter = new PropertySetter(filter);
                    Enumeration enumerationElements = ((Vector) hashtable.get(str4)).elements();
                    while (enumerationElements.hasMoreElements()) {
                        NameValue nameValue = (NameValue) enumerationElements.nextElement();
                        propertySetter.setProperty(nameValue.key, nameValue.value);
                    }
                    propertySetter.activate();
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Adding filter of type [");
                    stringBuffer3.append(filter.getClass());
                    stringBuffer3.append("] to appender named [");
                    stringBuffer3.append(appender.getName());
                    stringBuffer3.append("].");
                    LogLog.debug(stringBuffer3.toString());
                    appender.addFilter(filter);
                }
            } else {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Missing class definition for filter: [");
                stringBuffer4.append(str4);
                stringBuffer4.append("]");
                LogLog.warn(stringBuffer4.toString());
            }
        }
    }

    void parseCategory(Properties properties, Logger logger, String str, String str2, String str3) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing for [");
        stringBuffer.append(str2);
        stringBuffer.append("] with value=[");
        stringBuffer.append(str3);
        stringBuffer.append("].");
        LogLog.debug(stringBuffer.toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ",");
        if (!str3.startsWith(",") && !str3.equals("")) {
            if (!stringTokenizer.hasMoreTokens()) {
                return;
            }
            String strNextToken = stringTokenizer.nextToken();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Level token is [");
            stringBuffer2.append(strNextToken);
            stringBuffer2.append("].");
            LogLog.debug(stringBuffer2.toString());
            if (!Configurator.INHERITED.equalsIgnoreCase(strNextToken) && !Configurator.NULL.equalsIgnoreCase(strNextToken)) {
                logger.setLevel(OptionConverter.toLevel(strNextToken, Level.DEBUG));
            } else if (str2.equals(INTERNAL_ROOT_NAME)) {
                LogLog.warn("The root logger cannot be set to null.");
            } else {
                logger.setLevel(null);
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Category ");
            stringBuffer3.append(str2);
            stringBuffer3.append(" set to ");
            stringBuffer3.append(logger.getLevel());
            LogLog.debug(stringBuffer3.toString());
        }
        logger.removeAllAppenders();
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if (strTrim != null && !strTrim.equals(",")) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Parsing appender named \"");
                stringBuffer4.append(strTrim);
                stringBuffer4.append("\".");
                LogLog.debug(stringBuffer4.toString());
                Appender appender = parseAppender(properties, strTrim);
                if (appender != null) {
                    logger.addAppender(appender);
                }
            }
        }
    }

    Appender registryGet(String str) {
        return (Appender) this.registry.get(str);
    }

    void registryPut(Appender appender) {
        this.registry.put(appender.getName(), appender);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static void configure(InputStream inputStream) throws Throwable {
        new PropertyConfigurator().doConfigure(inputStream, LogManager.getLoggerRepository());
    }

    protected void parseCatsAndRenderers(Properties properties, LoggerRepository loggerRepository) throws Throwable {
        Properties properties2;
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            String strSubstring = null;
            if (!str.startsWith(CATEGORY_PREFIX) && !str.startsWith(LOGGER_PREFIX)) {
                if (str.startsWith(RENDERER_PREFIX)) {
                    String strSubstring2 = str.substring(15);
                    String strFindAndSubst = OptionConverter.findAndSubst(str, properties);
                    if (loggerRepository instanceof RendererSupport) {
                        RendererMap.addRenderer((RendererSupport) loggerRepository, strSubstring2, strFindAndSubst);
                    }
                } else if (str.equals(THROWABLE_RENDERER_PREFIX) && (loggerRepository instanceof ThrowableRendererSupport)) {
                    Class clsClass$ = class$org$apache$log4j$spi$ThrowableRenderer;
                    if (clsClass$ == null) {
                        clsClass$ = class$("org.apache.log4j.spi.ThrowableRenderer");
                        class$org$apache$log4j$spi$ThrowableRenderer = clsClass$;
                    }
                    ThrowableRenderer throwableRenderer = (ThrowableRenderer) OptionConverter.instantiateByKey(properties, THROWABLE_RENDERER_PREFIX, clsClass$, null);
                    if (throwableRenderer == null) {
                        LogLog.error("Could not instantiate throwableRenderer.");
                    } else {
                        new PropertySetter(throwableRenderer).setProperties(properties, "log4j.throwableRenderer.");
                        ((ThrowableRendererSupport) loggerRepository).setThrowableRenderer(throwableRenderer);
                    }
                }
                properties2 = properties;
            } else {
                if (str.startsWith(CATEGORY_PREFIX)) {
                    strSubstring = str.substring(15);
                } else if (str.startsWith(LOGGER_PREFIX)) {
                    strSubstring = str.substring(13);
                }
                String str2 = strSubstring;
                String strFindAndSubst2 = OptionConverter.findAndSubst(str, properties);
                Logger logger = loggerRepository.getLogger(str2, this.loggerFactory);
                synchronized (logger) {
                    properties2 = properties;
                    parseCategory(properties2, logger, str, str2, strFindAndSubst2);
                    parseAdditivityForLogger(properties2, logger, str2);
                }
            }
            properties = properties2;
        }
    }

    public static void configure(Properties properties) throws Throwable {
        new PropertyConfigurator().doConfigure(properties, LogManager.getLoggerRepository());
    }

    public void doConfigure(Properties properties, LoggerRepository loggerRepository) throws Throwable {
        this.repository = loggerRepository;
        String property = properties.getProperty(LogLog.DEBUG_KEY);
        if (property == null && (property = properties.getProperty(LogLog.CONFIG_DEBUG_KEY)) != null) {
            LogLog.warn("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
        }
        if (property != null) {
            LogLog.setInternalDebugging(OptionConverter.toBoolean(property, true));
        }
        String property2 = properties.getProperty(RESET_KEY);
        if (property2 != null && OptionConverter.toBoolean(property2, false)) {
            loggerRepository.resetConfiguration();
        }
        String strFindAndSubst = OptionConverter.findAndSubst(THRESHOLD_PREFIX, properties);
        if (strFindAndSubst != null) {
            loggerRepository.setThreshold(OptionConverter.toLevel(strFindAndSubst, Level.ALL));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hierarchy threshold set to [");
            stringBuffer.append(loggerRepository.getThreshold());
            stringBuffer.append("].");
            LogLog.debug(stringBuffer.toString());
        }
        configureRootCategory(properties, loggerRepository);
        configureLoggerFactory(properties);
        parseCatsAndRenderers(properties, loggerRepository);
        LogLog.debug("Finished configuring.");
        this.registry.clear();
    }

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(InputStream inputStream, LoggerRepository loggerRepository) throws Throwable {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            doConfigure(properties, loggerRepository);
        } catch (IOException e10) {
            if (e10 instanceof InterruptedIOException) {
                Thread.currentThread().interrupt();
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not read configuration file from InputStream [");
            stringBuffer.append(inputStream);
            stringBuffer.append("].");
            LogLog.error(stringBuffer.toString(), e10);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Ignoring configuration InputStream [");
            stringBuffer2.append(inputStream);
            stringBuffer2.append("].");
            LogLog.error(stringBuffer2.toString());
        }
    }

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(URL url, LoggerRepository loggerRepository) throws Throwable {
        Properties properties = new Properties();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Reading configuration from URL ");
        stringBuffer.append(url);
        LogLog.debug(stringBuffer.toString());
        InputStream inputStream = null;
        try {
            try {
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                inputStream = uRLConnectionOpenConnection.getInputStream();
                properties.load(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (InterruptedIOException unused) {
                        Thread.currentThread().interrupt();
                    } catch (IOException | RuntimeException unused2) {
                    }
                }
                doConfigure(properties, loggerRepository);
            } catch (Exception e10) {
                if ((e10 instanceof InterruptedIOException) || (e10 instanceof InterruptedException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not read configuration file from URL [");
                stringBuffer2.append(url);
                stringBuffer2.append("].");
                LogLog.error(stringBuffer2.toString(), e10);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Ignoring configuration file [");
                stringBuffer3.append(url);
                stringBuffer3.append("].");
                LogLog.error(stringBuffer3.toString());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (InterruptedIOException unused3) {
                        Thread.currentThread().interrupt();
                    } catch (IOException | RuntimeException unused4) {
                    }
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException unused5) {
                    Thread.currentThread().interrupt();
                } catch (IOException | RuntimeException unused6) {
                }
            }
            throw th;
        }
    }
}
