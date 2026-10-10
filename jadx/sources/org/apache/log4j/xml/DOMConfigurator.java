package org.apache.log4j.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Properties;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class DOMConfigurator implements Configurator {
    static final String ADDITIVITY_ATTR = "additivity";
    static final String APPENDER_REF_TAG = "appender-ref";
    static final String APPENDER_TAG = "appender";
    static final String CATEGORY = "category";
    static final String CATEGORY_FACTORY_TAG = "categoryFactory";
    static final String CLASS_ATTR = "class";
    static final String CONFIGURATION_TAG = "log4j:configuration";
    static final String CONFIG_DEBUG_ATTR = "configDebug";
    static final String EMPTY_STR = "";
    static final String ERROR_HANDLER_TAG = "errorHandler";
    static final String FILTER_TAG = "filter";
    static final String INTERNAL_DEBUG_ATTR = "debug";
    static final String LAYOUT_TAG = "layout";
    static final String LEVEL_TAG = "level";
    static final String LOGGER = "logger";
    static final String LOGGER_FACTORY_TAG = "loggerFactory";
    static final String LOGGER_REF = "logger-ref";
    static final String NAME_ATTR = "name";
    static final String OLD_CONFIGURATION_TAG = "configuration";
    static final Class[] ONE_STRING_PARAM;
    static final String PARAM_TAG = "param";
    static final String PRIORITY_TAG = "priority";
    static final String REF_ATTR = "ref";
    static final String RENDERED_CLASS_ATTR = "renderedClass";
    static final String RENDERER_TAG = "renderer";
    static final String RENDERING_CLASS_ATTR = "renderingClass";
    private static final String RESET_ATTR = "reset";
    static final String ROOT_REF = "root-ref";
    static final String ROOT_TAG = "root";
    static final String THRESHOLD_ATTR = "threshold";
    private static final String THROWABLE_RENDERER_TAG = "throwableRenderer";
    static final String VALUE_ATTR = "value";
    static /* synthetic */ Class class$java$lang$String = null;
    static /* synthetic */ Class class$org$apache$log4j$spi$ErrorHandler = null;
    static /* synthetic */ Class class$org$apache$log4j$spi$Filter = null;
    static /* synthetic */ Class class$org$apache$log4j$spi$LoggerFactory = null;
    static final String dbfKey = "javax.xml.parsers.DocumentBuilderFactory";
    Properties props;
    LoggerRepository repository;
    protected LoggerFactory catFactory = null;
    Hashtable appenderBag = new Hashtable();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private interface ParseAction {
        Document parse(DocumentBuilder documentBuilder);
    }

    public static void configure(Element element) throws Throwable {
        new DOMConfigurator().doConfigure(element, LogManager.getLoggerRepository());
    }

    public static void configureAndWatch(String str) {
        configureAndWatch(str, FileWatchdog.DEFAULT_DELAY);
    }

    public void doConfigure(final String str, LoggerRepository loggerRepository) {
        doConfigure(new ParseAction() { // from class: org.apache.log4j.xml.DOMConfigurator.1
            @Override // org.apache.log4j.xml.DOMConfigurator.ParseAction
            public Document parse(DocumentBuilder documentBuilder) {
                return documentBuilder.parse(new File(str));
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("file [");
                stringBuffer.append(str);
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
        }, loggerRepository);
    }

    protected void setParameter(Element element, PropertySetter propertySetter) {
        propertySetter.setProperty(subst(element.getAttribute(NAME_ATTR)), subst(OptionConverter.convertSpecialChars(element.getAttribute(VALUE_ATTR))));
    }

    protected String subst(String str) {
        return subst(str, this.props);
    }

    static {
        Class clsClass$ = class$java$lang$String;
        if (clsClass$ == null) {
            clsClass$ = class$("java.lang.String");
            class$java$lang$String = clsClass$;
        }
        ONE_STRING_PARAM = new Class[]{clsClass$};
    }

    public static void configureAndWatch(String str, long j10) {
        XMLWatchdog xMLWatchdog = new XMLWatchdog(str);
        xMLWatchdog.setDelay(j10);
        xMLWatchdog.start();
    }

    public static Object parseElement(Element element, Properties properties, Class cls) {
        Object objInstantiateByClassName = OptionConverter.instantiateByClassName(subst(element.getAttribute(CLASS_ATTR), properties), cls, null);
        if (objInstantiateByClassName == null) {
            return null;
        }
        PropertySetter propertySetter = new PropertySetter(objInstantiateByClassName);
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() == 1) {
                Element element2 = (Element) nodeItem;
                if (element2.getTagName().equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter, properties);
                } else {
                    parseUnrecognizedElement(objInstantiateByClassName, element2, properties);
                }
            }
        }
        return objInstantiateByClassName;
    }

    private static void parseUnrecognizedElement(Object obj, Element element, Properties properties) {
        if (obj instanceof UnrecognizedElementHandler ? ((UnrecognizedElementHandler) obj).parseUnrecognizedElement(element, properties) : false) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unrecognized element ");
        stringBuffer.append(element.getNodeName());
        LogLog.warn(stringBuffer.toString());
    }

    public static String subst(String str, Properties properties) {
        try {
            return OptionConverter.substVars(str, properties);
        } catch (IllegalArgumentException e10) {
            LogLog.warn("Could not perform variable substitution.", e10);
            return str;
        }
    }

    protected Appender findAppenderByName(Document document, String str) throws Throwable {
        Element element;
        Appender appender = (Appender) this.appenderBag.get(str);
        if (appender != null) {
            return appender;
        }
        NodeList elementsByTagName = document.getElementsByTagName(APPENDER_TAG);
        int i10 = 0;
        while (true) {
            if (i10 >= elementsByTagName.getLength()) {
                element = null;
                break;
            }
            Node nodeItem = elementsByTagName.item(i10);
            if (str.equals(nodeItem.getAttributes().getNamedItem(NAME_ATTR).getNodeValue())) {
                element = (Element) nodeItem;
                break;
            }
            i10++;
        }
        if (element != null) {
            Appender appender2 = parseAppender(element);
            if (appender2 != null) {
                this.appenderBag.put(str, appender2);
            }
            return appender2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("No appender named [");
        stringBuffer.append(str);
        stringBuffer.append("] could be found.");
        LogLog.error(stringBuffer.toString());
        return null;
    }

    protected Appender findAppenderByReference(Element element) {
        return findAppenderByName(element.getOwnerDocument(), subst(element.getAttribute(REF_ATTR)));
    }

    protected Appender parseAppender(Element element) throws Throwable {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Class name: [");
        stringBuffer.append(strSubst);
        stringBuffer.append(']');
        LogLog.debug(stringBuffer.toString());
        try {
            Object objNewInstance = Loader.loadClass(strSubst).newInstance();
            Appender appender = (Appender) objNewInstance;
            PropertySetter propertySetter = new PropertySetter(appender);
            appender.setName(subst(element.getAttribute(NAME_ATTR)));
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i10 = 0; i10 < length; i10++) {
                Node nodeItem = childNodes.item(i10);
                if (nodeItem.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else if (element2.getTagName().equals(LAYOUT_TAG)) {
                        appender.setLayout(parseLayout(element2));
                    } else if (element2.getTagName().equals(FILTER_TAG)) {
                        parseFilters(element2, appender);
                    } else if (element2.getTagName().equals(ERROR_HANDLER_TAG)) {
                        parseErrorHandler(element2, appender);
                    } else if (element2.getTagName().equals(APPENDER_REF_TAG)) {
                        String strSubst2 = subst(element2.getAttribute(REF_ATTR));
                        if (appender instanceof AppenderAttachable) {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Attaching appender named [");
                            stringBuffer2.append(strSubst2);
                            stringBuffer2.append("] to appender named [");
                            stringBuffer2.append(appender.getName());
                            stringBuffer2.append("].");
                            LogLog.debug(stringBuffer2.toString());
                            ((AppenderAttachable) appender).addAppender(findAppenderByReference(element2));
                        } else {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Requesting attachment of appender named [");
                            stringBuffer3.append(strSubst2);
                            stringBuffer3.append("] to appender named [");
                            stringBuffer3.append(appender.getName());
                            stringBuffer3.append("] which does not implement org.apache.log4j.spi.AppenderAttachable.");
                            LogLog.error(stringBuffer3.toString());
                        }
                    } else {
                        parseUnrecognizedElement(objNewInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return appender;
        } catch (Exception e10) {
            if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create an Appender. Reported error follows.", e10);
            return null;
        }
    }

    protected void parseCategory(Element element) {
        Logger logger;
        String strSubst = subst(element.getAttribute(NAME_ATTR));
        String strSubst2 = subst(element.getAttribute(CLASS_ATTR));
        if ("".equals(strSubst2)) {
            LogLog.debug("Retreiving an instance of org.apache.log4j.Logger.");
            LoggerFactory loggerFactory = this.catFactory;
            logger = loggerFactory == null ? this.repository.getLogger(strSubst) : this.repository.getLogger(strSubst, loggerFactory);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Desired logger sub-class: [");
            stringBuffer.append(strSubst2);
            stringBuffer.append(']');
            LogLog.debug(stringBuffer.toString());
            try {
                logger = (Logger) Loader.loadClass(strSubst2).getMethod("getLogger", ONE_STRING_PARAM).invoke(null, strSubst);
            } catch (InvocationTargetException e10) {
                if ((e10.getTargetException() instanceof InterruptedException) || (e10.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not retrieve category [");
                stringBuffer2.append(strSubst);
                stringBuffer2.append("]. Reported error follows.");
                LogLog.error(stringBuffer2.toString(), e10);
                return;
            } catch (Exception e11) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Could not retrieve category [");
                stringBuffer3.append(strSubst);
                stringBuffer3.append("]. Reported error follows.");
                LogLog.error(stringBuffer3.toString(), e11);
                return;
            }
        }
        synchronized (logger) {
            boolean z10 = OptionConverter.toBoolean(subst(element.getAttribute(ADDITIVITY_ATTR)), true);
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Setting [");
            stringBuffer4.append(logger.getName());
            stringBuffer4.append("] additivity to [");
            stringBuffer4.append(z10);
            stringBuffer4.append("].");
            LogLog.debug(stringBuffer4.toString());
            logger.setAdditivity(z10);
            parseChildrenOfLoggerElement(element, logger, false);
        }
    }

    protected void parseCategoryFactory(Element element) throws Throwable {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        if ("".equals(strSubst)) {
            LogLog.error("Category Factory tag class attribute not found.");
            LogLog.debug("No Category Factory configured.");
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Desired category factory: [");
        stringBuffer.append(strSubst);
        stringBuffer.append(']');
        LogLog.debug(stringBuffer.toString());
        Class clsClass$ = class$org$apache$log4j$spi$LoggerFactory;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.spi.LoggerFactory");
            class$org$apache$log4j$spi$LoggerFactory = clsClass$;
        }
        Object objInstantiateByClassName = OptionConverter.instantiateByClassName(strSubst, clsClass$, null);
        if (objInstantiateByClassName instanceof LoggerFactory) {
            this.catFactory = (LoggerFactory) objInstantiateByClassName;
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Category Factory class ");
            stringBuffer2.append(strSubst);
            stringBuffer2.append(" does not implement org.apache.log4j.LoggerFactory");
            LogLog.error(stringBuffer2.toString());
        }
        PropertySetter propertySetter = new PropertySetter(objInstantiateByClassName);
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() == 1) {
                Element element2 = (Element) nodeItem;
                if (element2.getTagName().equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter);
                } else {
                    quietParseUnrecognizedElement(objInstantiateByClassName, element2, this.props);
                }
            }
        }
    }

    protected void parseChildrenOfLoggerElement(Element element, Logger logger, boolean z10) {
        PropertySetter propertySetter = new PropertySetter(logger);
        logger.removeAllAppenders();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() == 1) {
                Element element2 = (Element) nodeItem;
                String tagName = element2.getTagName();
                if (tagName.equals(APPENDER_REF_TAG)) {
                    Appender appenderFindAppenderByReference = findAppenderByReference(element2);
                    String strSubst = subst(element2.getAttribute(REF_ATTR));
                    if (appenderFindAppenderByReference != null) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Adding appender named [");
                        stringBuffer.append(strSubst);
                        stringBuffer.append("] to category [");
                        stringBuffer.append(logger.getName());
                        stringBuffer.append("].");
                        LogLog.debug(stringBuffer.toString());
                    } else {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Appender named [");
                        stringBuffer2.append(strSubst);
                        stringBuffer2.append("] not found.");
                        LogLog.debug(stringBuffer2.toString());
                    }
                    logger.addAppender(appenderFindAppenderByReference);
                } else if (tagName.equals(LEVEL_TAG)) {
                    parseLevel(element2, logger, z10);
                } else if (tagName.equals(PRIORITY_TAG)) {
                    parseLevel(element2, logger, z10);
                } else if (tagName.equals(PARAM_TAG)) {
                    setParameter(element2, propertySetter);
                } else {
                    quietParseUnrecognizedElement(logger, element2, this.props);
                }
            }
        }
        propertySetter.activate();
    }

    protected void parseErrorHandler(Element element, Appender appender) throws Throwable {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        Class clsClass$ = class$org$apache$log4j$spi$ErrorHandler;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.spi.ErrorHandler");
            class$org$apache$log4j$spi$ErrorHandler = clsClass$;
        }
        ErrorHandler errorHandler = (ErrorHandler) OptionConverter.instantiateByClassName(strSubst, clsClass$, null);
        if (errorHandler != null) {
            errorHandler.setAppender(appender);
            PropertySetter propertySetter = new PropertySetter(errorHandler);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i10 = 0; i10 < length; i10++) {
                Node nodeItem = childNodes.item(i10);
                if (nodeItem.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem;
                    String tagName = element2.getTagName();
                    if (tagName.equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else if (tagName.equals(APPENDER_REF_TAG)) {
                        errorHandler.setBackupAppender(findAppenderByReference(element2));
                    } else if (tagName.equals(LOGGER_REF)) {
                        String attribute = element2.getAttribute(REF_ATTR);
                        LoggerFactory loggerFactory = this.catFactory;
                        errorHandler.setLogger(loggerFactory == null ? this.repository.getLogger(attribute) : this.repository.getLogger(attribute, loggerFactory));
                    } else if (tagName.equals(ROOT_REF)) {
                        errorHandler.setLogger(this.repository.getRootLogger());
                    } else {
                        quietParseUnrecognizedElement(errorHandler, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            appender.setErrorHandler(errorHandler);
        }
    }

    protected void parseFilters(Element element, Appender appender) throws Throwable {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        Class clsClass$ = class$org$apache$log4j$spi$Filter;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.spi.Filter");
            class$org$apache$log4j$spi$Filter = clsClass$;
        }
        Filter filter = (Filter) OptionConverter.instantiateByClassName(strSubst, clsClass$, null);
        if (filter != null) {
            PropertySetter propertySetter = new PropertySetter(filter);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i10 = 0; i10 < length; i10++) {
                Node nodeItem = childNodes.item(i10);
                if (nodeItem.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        quietParseUnrecognizedElement(filter, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Adding filter of type [");
            stringBuffer.append(filter.getClass());
            stringBuffer.append("] to appender named [");
            stringBuffer.append(appender.getName());
            stringBuffer.append("].");
            LogLog.debug(stringBuffer.toString());
            appender.addFilter(filter);
        }
    }

    protected Layout parseLayout(Element element) {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing layout of class: \"");
        stringBuffer.append(strSubst);
        stringBuffer.append("\"");
        LogLog.debug(stringBuffer.toString());
        try {
            Object objNewInstance = Loader.loadClass(strSubst).newInstance();
            Layout layout = (Layout) objNewInstance;
            PropertySetter propertySetter = new PropertySetter(layout);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i10 = 0; i10 < length; i10++) {
                Node nodeItem = childNodes.item(i10);
                if (nodeItem.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        parseUnrecognizedElement(objNewInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return layout;
        } catch (Exception e10) {
            if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create the Layout. Reported error follows.", e10);
            return null;
        }
    }

    protected void parseRenderer(Element element) throws Throwable {
        String strSubst = subst(element.getAttribute(RENDERING_CLASS_ATTR));
        String strSubst2 = subst(element.getAttribute(RENDERED_CLASS_ATTR));
        LoggerRepository loggerRepository = this.repository;
        if (loggerRepository instanceof RendererSupport) {
            RendererMap.addRenderer((RendererSupport) loggerRepository, strSubst2, strSubst);
        }
    }

    protected void parseRoot(Element element) {
        Logger rootLogger = this.repository.getRootLogger();
        synchronized (rootLogger) {
            parseChildrenOfLoggerElement(element, rootLogger, true);
        }
    }

    protected ThrowableRenderer parseThrowableRenderer(Element element) {
        String strSubst = subst(element.getAttribute(CLASS_ATTR));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing throwableRenderer of class: \"");
        stringBuffer.append(strSubst);
        stringBuffer.append("\"");
        LogLog.debug(stringBuffer.toString());
        try {
            Object objNewInstance = Loader.loadClass(strSubst).newInstance();
            ThrowableRenderer throwableRenderer = (ThrowableRenderer) objNewInstance;
            PropertySetter propertySetter = new PropertySetter(throwableRenderer);
            NodeList childNodes = element.getChildNodes();
            int length = childNodes.getLength();
            for (int i10 = 0; i10 < length; i10++) {
                Node nodeItem = childNodes.item(i10);
                if (nodeItem.getNodeType() == 1) {
                    Element element2 = (Element) nodeItem;
                    if (element2.getTagName().equals(PARAM_TAG)) {
                        setParameter(element2, propertySetter);
                    } else {
                        parseUnrecognizedElement(objNewInstance, element2, this.props);
                    }
                }
            }
            propertySetter.activate();
            return throwableRenderer;
        } catch (Exception e10) {
            if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Could not create the ThrowableRenderer. Reported error follows.", e10);
            return null;
        }
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static void configure(String str) {
        new DOMConfigurator().doConfigure(str, LogManager.getLoggerRepository());
    }

    private static void quietParseUnrecognizedElement(Object obj, Element element, Properties properties) {
        try {
            parseUnrecognizedElement(obj, element, properties);
        } catch (Exception e10) {
            if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.error("Error in extension content: ", e10);
        }
    }

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(final URL url, LoggerRepository loggerRepository) throws Throwable {
        doConfigure(new ParseAction() { // from class: org.apache.log4j.xml.DOMConfigurator.2
            @Override // org.apache.log4j.xml.DOMConfigurator.ParseAction
            public Document parse(DocumentBuilder documentBuilder) throws IOException {
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
                try {
                    InputSource inputSource = new InputSource(inputStream);
                    inputSource.setSystemId(url.toString());
                    return documentBuilder.parse(inputSource);
                } finally {
                    inputStream.close();
                }
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("url [");
                stringBuffer.append(url.toString());
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
        }, loggerRepository);
    }

    protected void parse(Element element) throws Throwable {
        ThrowableRenderer throwableRenderer;
        String tagName = element.getTagName();
        if (!tagName.equals(CONFIGURATION_TAG)) {
            if (tagName.equals(OLD_CONFIGURATION_TAG)) {
                LogLog.warn("The <configuration> element has been deprecated.");
                LogLog.warn("Use the <log4j:configuration> element instead.");
            } else {
                LogLog.error("DOM element is - not a <log4j:configuration> element.");
                return;
            }
        }
        String strSubst = subst(element.getAttribute(INTERNAL_DEBUG_ATTR));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("debug attribute= \"");
        stringBuffer.append(strSubst);
        stringBuffer.append("\".");
        LogLog.debug(stringBuffer.toString());
        if (!strSubst.equals("") && !strSubst.equals(Configurator.NULL)) {
            LogLog.setInternalDebugging(OptionConverter.toBoolean(strSubst, true));
        } else {
            LogLog.debug("Ignoring debug attribute.");
        }
        String strSubst2 = subst(element.getAttribute(RESET_ATTR));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("reset attribute= \"");
        stringBuffer2.append(strSubst2);
        stringBuffer2.append("\".");
        LogLog.debug(stringBuffer2.toString());
        if (!"".equals(strSubst2) && OptionConverter.toBoolean(strSubst2, false)) {
            this.repository.resetConfiguration();
        }
        String strSubst3 = subst(element.getAttribute(CONFIG_DEBUG_ATTR));
        if (!strSubst3.equals("") && !strSubst3.equals(Configurator.NULL)) {
            LogLog.warn("The \"configDebug\" attribute is deprecated.");
            LogLog.warn("Use the \"debug\" attribute instead.");
            LogLog.setInternalDebugging(OptionConverter.toBoolean(strSubst3, true));
        }
        String strSubst4 = subst(element.getAttribute(THRESHOLD_ATTR));
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Threshold =\"");
        stringBuffer3.append(strSubst4);
        stringBuffer3.append("\".");
        LogLog.debug(stringBuffer3.toString());
        if (!"".equals(strSubst4) && !Configurator.NULL.equals(strSubst4)) {
            this.repository.setThreshold(strSubst4);
        }
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Node nodeItem = childNodes.item(i10);
            if (nodeItem.getNodeType() == 1) {
                Element element2 = (Element) nodeItem;
                String tagName2 = element2.getTagName();
                if (tagName2.equals(CATEGORY_FACTORY_TAG) || tagName2.equals(LOGGER_FACTORY_TAG)) {
                    parseCategoryFactory(element2);
                }
            }
        }
        for (int i11 = 0; i11 < length; i11++) {
            Node nodeItem2 = childNodes.item(i11);
            if (nodeItem2.getNodeType() == 1) {
                Element element3 = (Element) nodeItem2;
                String tagName3 = element3.getTagName();
                if (!tagName3.equals(CATEGORY) && !tagName3.equals(LOGGER)) {
                    if (tagName3.equals(ROOT_TAG)) {
                        parseRoot(element3);
                    } else if (tagName3.equals(RENDERER_TAG)) {
                        parseRenderer(element3);
                    } else if (tagName3.equals(THROWABLE_RENDERER_TAG)) {
                        if ((this.repository instanceof ThrowableRendererSupport) && (throwableRenderer = parseThrowableRenderer(element3)) != null) {
                            ((ThrowableRendererSupport) this.repository).setThrowableRenderer(throwableRenderer);
                        }
                    } else if (!tagName3.equals(APPENDER_TAG) && !tagName3.equals(CATEGORY_FACTORY_TAG) && !tagName3.equals(LOGGER_FACTORY_TAG)) {
                        quietParseUnrecognizedElement(this.repository, element3, this.props);
                    }
                } else {
                    parseCategory(element3);
                }
            }
        }
    }

    protected void parseLevel(Element element, Logger logger, boolean z10) {
        String name = logger.getName();
        if (z10) {
            name = ROOT_TAG;
        }
        String strSubst = subst(element.getAttribute(VALUE_ATTR));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Level value for ");
        stringBuffer.append(name);
        stringBuffer.append(" is  [");
        stringBuffer.append(strSubst);
        stringBuffer.append("].");
        LogLog.debug(stringBuffer.toString());
        if (!Configurator.INHERITED.equalsIgnoreCase(strSubst) && !Configurator.NULL.equalsIgnoreCase(strSubst)) {
            String strSubst2 = subst(element.getAttribute(CLASS_ATTR));
            if ("".equals(strSubst2)) {
                logger.setLevel(OptionConverter.toLevel(strSubst, Level.DEBUG));
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Desired Level sub-class: [");
                stringBuffer2.append(strSubst2);
                stringBuffer2.append(']');
                LogLog.debug(stringBuffer2.toString());
                try {
                    logger.setLevel((Level) Loader.loadClass(strSubst2).getMethod("toLevel", ONE_STRING_PARAM).invoke(null, strSubst));
                } catch (Exception e10) {
                    if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                        Thread.currentThread().interrupt();
                    }
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Could not create level [");
                    stringBuffer3.append(strSubst);
                    stringBuffer3.append("]. Reported error follows.");
                    LogLog.error(stringBuffer3.toString(), e10);
                    return;
                }
            }
        } else if (z10) {
            LogLog.error("Root level cannot be inherited. Ignoring directive.");
        } else {
            logger.setLevel(null);
        }
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(name);
        stringBuffer4.append(" level set to ");
        stringBuffer4.append(logger.getLevel());
        LogLog.debug(stringBuffer4.toString());
    }

    public static void configure(URL url) throws Throwable {
        new DOMConfigurator().doConfigure(url, LogManager.getLoggerRepository());
    }

    public static void setParameter(Element element, PropertySetter propertySetter, Properties properties) {
        propertySetter.setProperty(subst(element.getAttribute(NAME_ATTR), properties), subst(OptionConverter.convertSpecialChars(element.getAttribute(VALUE_ATTR)), properties));
    }

    @Override // org.apache.log4j.spi.Configurator
    public void doConfigure(final InputStream inputStream, LoggerRepository loggerRepository) throws Throwable {
        doConfigure(new ParseAction() { // from class: org.apache.log4j.xml.DOMConfigurator.3
            @Override // org.apache.log4j.xml.DOMConfigurator.ParseAction
            public Document parse(DocumentBuilder documentBuilder) {
                InputSource inputSource = new InputSource(inputStream);
                inputSource.setSystemId("dummy://log4j.dtd");
                return documentBuilder.parse(inputSource);
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("input stream [");
                stringBuffer.append(inputStream.toString());
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
        }, loggerRepository);
    }

    public void doConfigure(final Reader reader, LoggerRepository loggerRepository) throws Throwable {
        doConfigure(new ParseAction() { // from class: org.apache.log4j.xml.DOMConfigurator.4
            @Override // org.apache.log4j.xml.DOMConfigurator.ParseAction
            public Document parse(DocumentBuilder documentBuilder) {
                InputSource inputSource = new InputSource(reader);
                inputSource.setSystemId("dummy://log4j.dtd");
                return documentBuilder.parse(inputSource);
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("reader [");
                stringBuffer.append(reader.toString());
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
        }, loggerRepository);
    }

    protected void doConfigure(final InputSource inputSource, LoggerRepository loggerRepository) throws Throwable {
        if (inputSource.getSystemId() == null) {
            inputSource.setSystemId("dummy://log4j.dtd");
        }
        doConfigure(new ParseAction() { // from class: org.apache.log4j.xml.DOMConfigurator.5
            @Override // org.apache.log4j.xml.DOMConfigurator.ParseAction
            public Document parse(DocumentBuilder documentBuilder) {
                return documentBuilder.parse(inputSource);
            }

            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("input source [");
                stringBuffer.append(inputSource.toString());
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
        }, loggerRepository);
    }

    private final void doConfigure(ParseAction parseAction, LoggerRepository loggerRepository) throws Throwable {
        this.repository = loggerRepository;
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("System property is :");
            stringBuffer.append(OptionConverter.getSystemProperty(dbfKey, null));
            LogLog.debug(stringBuffer.toString());
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            LogLog.debug("Standard DocumentBuilderFactory search succeded.");
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("DocumentBuilderFactory is: ");
            stringBuffer2.append(documentBuilderFactoryNewInstance.getClass().getName());
            LogLog.debug(stringBuffer2.toString());
            try {
                documentBuilderFactoryNewInstance.setValidating(true);
                DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
                documentBuilderNewDocumentBuilder.setErrorHandler(new SAXErrorHandler());
                documentBuilderNewDocumentBuilder.setEntityResolver(new Log4jEntityResolver());
                parse(parseAction.parse(documentBuilderNewDocumentBuilder).getDocumentElement());
            } catch (Exception e10) {
                if ((e10 instanceof InterruptedException) || (e10 instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Could not parse ");
                stringBuffer3.append(parseAction.toString());
                stringBuffer3.append(".");
                LogLog.error(stringBuffer3.toString(), e10);
            }
        } catch (FactoryConfigurationError e11) {
            LogLog.debug("Could not instantiate a DocumentBuilderFactory.", e11.getException());
            throw e11;
        }
    }

    public void doConfigure(Element element, LoggerRepository loggerRepository) throws Throwable {
        this.repository = loggerRepository;
        parse(element);
    }
}
