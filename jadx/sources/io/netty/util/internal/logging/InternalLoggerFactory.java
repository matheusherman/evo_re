package io.netty.util.internal.logging;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class InternalLoggerFactory {
    private static volatile InternalLoggerFactory defaultFactory;

    public static InternalLogger getInstance(Class<?> cls) {
        return getInstance(cls.getName());
    }

    private static InternalLoggerFactory useLog4J2LoggerFactory(String str) {
        try {
            InternalLoggerFactory internalLoggerFactory = Log4J2LoggerFactory.INSTANCE;
            internalLoggerFactory.newInstance(str).debug("Using Log4J2 as the default logging framework");
            return internalLoggerFactory;
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    private static InternalLoggerFactory useLog4JLoggerFactory(String str) {
        try {
            InternalLoggerFactory internalLoggerFactory = Log4JLoggerFactory.INSTANCE;
            internalLoggerFactory.newInstance(str).debug("Using Log4J as the default logging framework");
            return internalLoggerFactory;
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    private static InternalLoggerFactory useSlf4JLoggerFactory(String str) {
        try {
            InternalLoggerFactory instanceWithNopCheck = Slf4JLoggerFactory.getInstanceWithNopCheck();
            instanceWithNopCheck.newInstance(str).debug("Using SLF4J as the default logging framework");
            return instanceWithNopCheck;
        } catch (Exception | LinkageError unused) {
            return null;
        }
    }

    protected abstract InternalLogger newInstance(String str);

    public static InternalLoggerFactory getDefaultFactory() {
        if (defaultFactory == null) {
            defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());
        }
        return defaultFactory;
    }

    public static InternalLogger getInstance(String str) {
        return getDefaultFactory().newInstance(str);
    }

    private static InternalLoggerFactory useJdkLoggerFactory(String str) {
        InternalLoggerFactory internalLoggerFactory = JdkLoggerFactory.INSTANCE;
        internalLoggerFactory.newInstance(str).debug("Using java.util.logging as the default logging framework");
        return internalLoggerFactory;
    }

    private static InternalLoggerFactory newDefaultFactory(String str) {
        InternalLoggerFactory internalLoggerFactoryUseSlf4JLoggerFactory = useSlf4JLoggerFactory(str);
        if (internalLoggerFactoryUseSlf4JLoggerFactory != null) {
            return internalLoggerFactoryUseSlf4JLoggerFactory;
        }
        InternalLoggerFactory internalLoggerFactoryUseLog4J2LoggerFactory = useLog4J2LoggerFactory(str);
        if (internalLoggerFactoryUseLog4J2LoggerFactory != null) {
            return internalLoggerFactoryUseLog4J2LoggerFactory;
        }
        InternalLoggerFactory internalLoggerFactoryUseLog4JLoggerFactory = useLog4JLoggerFactory(str);
        if (internalLoggerFactoryUseLog4JLoggerFactory != null) {
            return internalLoggerFactoryUseLog4JLoggerFactory;
        }
        return useJdkLoggerFactory(str);
    }
}
