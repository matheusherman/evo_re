package org.apache.log4j;

import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public abstract class LogXF {
    private static final String FQCN;
    protected static final Level TRACE = new Level(5000, "TRACE", 7);
    static /* synthetic */ Class class$org$apache$log4j$LogXF;

    public static void entering(Logger logger, String str, String str2) {
        if (logger.isDebugEnabled()) {
            String str3 = FQCN;
            Level level = Level.DEBUG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" ENTRY");
            logger.callAppenders(new LoggingEvent(str3, logger, level, stringBuffer.toString(), null));
        }
    }

    public static void exiting(Logger logger, String str, String str2) {
        if (logger.isDebugEnabled()) {
            String str3 = FQCN;
            Level level = Level.DEBUG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" RETURN");
            logger.callAppenders(new LoggingEvent(str3, logger, level, stringBuffer.toString(), null));
        }
    }

    protected static Object[] toArray(Object obj) {
        return new Object[]{obj};
    }

    protected static Boolean valueOf(boolean z10) {
        return z10 ? Boolean.TRUE : Boolean.FALSE;
    }

    static {
        Class clsClass$ = class$org$apache$log4j$LogXF;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.LogXF");
            class$org$apache$log4j$LogXF = clsClass$;
        }
        FQCN = clsClass$.getName();
    }

    protected static Object[] toArray(Object obj, Object obj2) {
        return new Object[]{obj, obj2};
    }

    protected LogXF() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static void entering(Logger logger, String str, String str2, String str3) {
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" ENTRY ");
            stringBuffer.append(str3);
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, stringBuffer.toString(), null));
        }
    }

    public static void exiting(Logger logger, String str, String str2, String str3) {
        if (logger.isDebugEnabled()) {
            String str4 = FQCN;
            Level level = Level.DEBUG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" RETURN ");
            stringBuffer.append(str3);
            logger.callAppenders(new LoggingEvent(str4, logger, level, stringBuffer.toString(), null));
        }
    }

    public static void throwing(Logger logger, String str, String str2, Throwable th) {
        if (logger.isDebugEnabled()) {
            String str3 = FQCN;
            Level level = Level.DEBUG;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" THROW");
            logger.callAppenders(new LoggingEvent(str3, logger, level, stringBuffer.toString(), th));
        }
    }

    protected static Object[] toArray(Object obj, Object obj2, Object obj3) {
        return new Object[]{obj, obj2, obj3};
    }

    protected static Character valueOf(char c10) {
        return new Character(c10);
    }

    protected static Object[] toArray(Object obj, Object obj2, Object obj3, Object obj4) {
        return new Object[]{obj, obj2, obj3, obj4};
    }

    protected static Byte valueOf(byte b10) {
        return new Byte(b10);
    }

    public static void exiting(Logger logger, String str, String str2, Object obj) {
        String string;
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" RETURN ");
            String string2 = stringBuffer.toString();
            if (obj == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(string2);
                stringBuffer2.append(Configurator.NULL);
                string = stringBuffer2.toString();
            } else {
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(string2);
                    stringBuffer3.append(obj);
                    string = stringBuffer3.toString();
                } catch (Throwable unused) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(string2);
                    stringBuffer4.append(LocationInfo.NA);
                    string = stringBuffer4.toString();
                }
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, string, null));
        }
    }

    protected static Short valueOf(short s10) {
        return new Short(s10);
    }

    public static void entering(Logger logger, String str, String str2, Object obj) {
        String string;
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" ENTRY ");
            String string2 = stringBuffer.toString();
            if (obj == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(string2);
                stringBuffer2.append(Configurator.NULL);
                string = stringBuffer2.toString();
            } else {
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(string2);
                    stringBuffer3.append(obj);
                    string = stringBuffer3.toString();
                } catch (Throwable unused) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(string2);
                    stringBuffer4.append(LocationInfo.NA);
                    string = stringBuffer4.toString();
                }
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, string, null));
        }
    }

    protected static Integer valueOf(int i10) {
        return new Integer(i10);
    }

    protected static Long valueOf(long j10) {
        return new Long(j10);
    }

    protected static Float valueOf(float f10) {
        return new Float(f10);
    }

    protected static Double valueOf(double d10) {
        return new Double(d10);
    }

    public static void entering(Logger logger, String str, String str2, Object[] objArr) {
        String string;
        if (logger.isDebugEnabled()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(".");
            stringBuffer.append(str2);
            stringBuffer.append(" ENTRY ");
            String string2 = stringBuffer.toString();
            if (objArr != null && objArr.length > 0) {
                String str3 = "{";
                int i10 = 0;
                while (i10 < objArr.length) {
                    try {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(string2);
                        stringBuffer2.append(str3);
                        stringBuffer2.append(objArr[i10]);
                        string2 = stringBuffer2.toString();
                    } catch (Throwable unused) {
                        StringBuffer stringBuffer3 = new StringBuffer();
                        stringBuffer3.append(string2);
                        stringBuffer3.append(str3);
                        stringBuffer3.append(LocationInfo.NA);
                        string2 = stringBuffer3.toString();
                    }
                    i10++;
                    str3 = ",";
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(string2);
                stringBuffer4.append("}");
                string = stringBuffer4.toString();
            } else {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(string2);
                stringBuffer5.append("{}");
                string = stringBuffer5.toString();
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, string, null));
        }
    }
}
