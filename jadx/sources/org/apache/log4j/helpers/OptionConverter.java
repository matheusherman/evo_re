package org.apache.log4j.helpers;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class OptionConverter {
    static String DELIM_START = "${";
    static int DELIM_START_LEN = 2;
    static char DELIM_STOP = '}';
    static int DELIM_STOP_LEN = 1;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$apache$log4j$Level;
    static /* synthetic */ Class class$org$apache$log4j$spi$Configurator;

    public static String[] concatanateArrays(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    public static void selectAndConfigure(InputStream inputStream, String str, LoggerRepository loggerRepository) throws Throwable {
        Configurator propertyConfigurator;
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Preferred configurator class: ");
            stringBuffer.append(str);
            LogLog.debug(stringBuffer.toString());
            Class clsClass$ = class$org$apache$log4j$spi$Configurator;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.spi.Configurator");
                class$org$apache$log4j$spi$Configurator = clsClass$;
            }
            propertyConfigurator = (Configurator) instantiateByClassName(str, clsClass$, null);
            if (propertyConfigurator == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not instantiate configurator [");
                stringBuffer2.append(str);
                stringBuffer2.append("].");
                LogLog.error(stringBuffer2.toString());
                return;
            }
        } else {
            propertyConfigurator = new PropertyConfigurator();
        }
        propertyConfigurator.doConfigure(inputStream, loggerRepository);
    }

    public static Object instantiateByClassName(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class<?> clsLoadClass = Loader.loadClass(str);
                if (cls.isAssignableFrom(clsLoadClass)) {
                    return clsLoadClass.newInstance();
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("A \"");
                stringBuffer.append(str);
                stringBuffer.append("\" object is not assignable to a \"");
                stringBuffer.append(cls.getName());
                stringBuffer.append("\" variable.");
                LogLog.error(stringBuffer.toString());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("The class \"");
                stringBuffer2.append(cls.getName());
                stringBuffer2.append("\" was loaded by ");
                LogLog.error(stringBuffer2.toString());
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("[");
                stringBuffer3.append(cls.getClassLoader());
                stringBuffer3.append("] whereas object of type ");
                LogLog.error(stringBuffer3.toString());
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("\"");
                stringBuffer4.append(clsLoadClass.getName());
                stringBuffer4.append("\" was loaded by [");
                stringBuffer4.append(clsLoadClass.getClassLoader());
                stringBuffer4.append("].");
                LogLog.error(stringBuffer4.toString());
                return obj;
            } catch (ClassNotFoundException e10) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Could not instantiate class [");
                stringBuffer5.append(str);
                stringBuffer5.append("].");
                LogLog.error(stringBuffer5.toString(), e10);
            } catch (IllegalAccessException e11) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Could not instantiate class [");
                stringBuffer6.append(str);
                stringBuffer6.append("].");
                LogLog.error(stringBuffer6.toString(), e11);
            } catch (InstantiationException e12) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("Could not instantiate class [");
                stringBuffer7.append(str);
                stringBuffer7.append("].");
                LogLog.error(stringBuffer7.toString(), e12);
            } catch (RuntimeException e13) {
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append("Could not instantiate class [");
                stringBuffer8.append(str);
                stringBuffer8.append("].");
                LogLog.error(stringBuffer8.toString(), e13);
            }
        }
        return obj;
    }

    public static String substVars(String str, Properties properties) {
        StringBuffer stringBuffer = new StringBuffer();
        int i10 = 0;
        while (true) {
            int iIndexOf = str.indexOf(DELIM_START, i10);
            if (iIndexOf == -1) {
                if (i10 == 0) {
                    return str;
                }
                stringBuffer.append(str.substring(i10, str.length()));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i10, iIndexOf));
            int iIndexOf2 = str.indexOf(DELIM_STOP, iIndexOf);
            if (iIndexOf2 == -1) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append('\"');
                stringBuffer2.append(str);
                stringBuffer2.append("\" has no closing brace. Opening brace at position ");
                stringBuffer2.append(iIndexOf);
                stringBuffer2.append('.');
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
            String strSubstring = str.substring(iIndexOf + DELIM_START_LEN, iIndexOf2);
            String systemProperty = getSystemProperty(strSubstring, null);
            if (systemProperty == null && properties != null) {
                systemProperty = properties.getProperty(strSubstring);
            }
            if (systemProperty != null) {
                stringBuffer.append(substVars(systemProperty, properties));
            }
            i10 = iIndexOf2 + DELIM_STOP_LEN;
        }
    }

    public static boolean toBoolean(String str, boolean z10) {
        if (str != null) {
            String strTrim = str.trim();
            if ("true".equalsIgnoreCase(strTrim)) {
                return true;
            }
            if ("false".equalsIgnoreCase(strTrim)) {
                return false;
            }
        }
        return z10;
    }

    public static long toFileSize(String str, long j10) {
        long j11;
        if (str != null) {
            String upperCase = str.trim().toUpperCase();
            int iIndexOf = upperCase.indexOf("KB");
            if (iIndexOf != -1) {
                upperCase = upperCase.substring(0, iIndexOf);
                j11 = 1024;
            } else {
                int iIndexOf2 = upperCase.indexOf("MB");
                if (iIndexOf2 != -1) {
                    upperCase = upperCase.substring(0, iIndexOf2);
                    j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                } else {
                    int iIndexOf3 = upperCase.indexOf("GB");
                    if (iIndexOf3 != -1) {
                        upperCase = upperCase.substring(0, iIndexOf3);
                        j11 = IjkMediaMeta.AV_CH_STEREO_RIGHT;
                    } else {
                        j11 = 1;
                    }
                }
            }
            if (upperCase != null) {
                try {
                    return Long.valueOf(upperCase).longValue() * j11;
                } catch (NumberFormatException e10) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("[");
                    stringBuffer.append(upperCase);
                    stringBuffer.append("] is not in proper int form.");
                    LogLog.error(stringBuffer.toString());
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("[");
                    stringBuffer2.append(str);
                    stringBuffer2.append("] not in expected format.");
                    LogLog.error(stringBuffer2.toString(), e10);
                }
            }
        }
        return j10;
    }

    public static int toInt(String str, int i10) {
        if (str != null) {
            String strTrim = str.trim();
            try {
                return Integer.valueOf(strTrim).intValue();
            } catch (NumberFormatException e10) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(strTrim);
                stringBuffer.append("] is not in proper int form.");
                LogLog.error(stringBuffer.toString());
                e10.printStackTrace();
            }
        }
        return i10;
    }

    public static Level toLevel(String str, Level level) throws Throwable {
        if (str != null) {
            String strTrim = str.trim();
            int iIndexOf = strTrim.indexOf(35);
            if (iIndexOf == -1) {
                if (DateLayout.NULL_DATE_FORMAT.equalsIgnoreCase(strTrim)) {
                    return null;
                }
                return Level.toLevel(strTrim, level);
            }
            String strSubstring = strTrim.substring(iIndexOf + 1);
            String strSubstring2 = strTrim.substring(0, iIndexOf);
            if (DateLayout.NULL_DATE_FORMAT.equalsIgnoreCase(strSubstring2)) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("toLevel:class=[");
            stringBuffer.append(strSubstring);
            stringBuffer.append("]");
            stringBuffer.append(":pri=[");
            stringBuffer.append(strSubstring2);
            stringBuffer.append("]");
            LogLog.debug(stringBuffer.toString());
            try {
                Class clsLoadClass = Loader.loadClass(strSubstring);
                Class<?> clsClass$ = class$java$lang$String;
                if (clsClass$ == null) {
                    clsClass$ = class$("java.lang.String");
                    class$java$lang$String = clsClass$;
                }
                Class<?> clsClass$2 = class$org$apache$log4j$Level;
                if (clsClass$2 == null) {
                    clsClass$2 = class$("org.apache.log4j.Level");
                    class$org$apache$log4j$Level = clsClass$2;
                }
                return (Level) clsLoadClass.getMethod("toLevel", clsClass$, clsClass$2).invoke(null, strSubstring2, level);
            } catch (ClassCastException e10) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("class [");
                stringBuffer2.append(strSubstring);
                stringBuffer2.append("] is not a subclass of org.apache.log4j.Level");
                LogLog.warn(stringBuffer2.toString(), e10);
            } catch (ClassNotFoundException unused) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("custom level class [");
                stringBuffer3.append(strSubstring);
                stringBuffer3.append("] not found.");
                LogLog.warn(stringBuffer3.toString());
            } catch (IllegalAccessException e11) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("class [");
                stringBuffer4.append(strSubstring);
                stringBuffer4.append("] cannot be instantiated due to access restrictions");
                LogLog.warn(stringBuffer4.toString(), e11);
            } catch (NoSuchMethodException e12) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("custom level class [");
                stringBuffer5.append(strSubstring);
                stringBuffer5.append("]");
                stringBuffer5.append(" does not have a class function toLevel(String, Level)");
                LogLog.warn(stringBuffer5.toString(), e12);
            } catch (RuntimeException e13) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("class [");
                stringBuffer6.append(strSubstring);
                stringBuffer6.append("], level [");
                stringBuffer6.append(strSubstring2);
                stringBuffer6.append("] conversion failed.");
                LogLog.warn(stringBuffer6.toString(), e13);
            } catch (InvocationTargetException e14) {
                if ((e14.getTargetException() instanceof InterruptedException) || (e14.getTargetException() instanceof InterruptedIOException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("custom level class [");
                stringBuffer7.append(strSubstring);
                stringBuffer7.append("]");
                stringBuffer7.append(" could not be instantiated");
                LogLog.warn(stringBuffer7.toString(), e14);
            }
        }
        return level;
    }

    private OptionConverter() {
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    public static String convertSpecialChars(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i10 = 0;
        while (i10 < length) {
            int i11 = i10 + 1;
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\\') {
                i10 += 2;
                cCharAt = str.charAt(i11);
                if (cCharAt == 'n') {
                    cCharAt = '\n';
                } else if (cCharAt == 'r') {
                    cCharAt = '\r';
                } else if (cCharAt == 't') {
                    cCharAt = '\t';
                } else if (cCharAt == 'f') {
                    cCharAt = '\f';
                } else if (cCharAt == '\b') {
                    cCharAt = '\b';
                } else if (cCharAt == '\"') {
                    cCharAt = '\"';
                } else if (cCharAt == '\'') {
                    cCharAt = '\'';
                } else if (cCharAt == '\\') {
                    cCharAt = '\\';
                }
            } else {
                i10 = i11;
            }
            stringBuffer.append(cCharAt);
        }
        return stringBuffer.toString();
    }

    public static String findAndSubst(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return substVars(property, properties);
        } catch (IllegalArgumentException e10) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Bad option value [");
            stringBuffer.append(property);
            stringBuffer.append("].");
            LogLog.error(stringBuffer.toString(), e10);
            return property;
        }
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (Throwable unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Was not allowed to read system property \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            LogLog.debug(stringBuffer.toString());
            return str2;
        }
    }

    public static Object instantiateByKey(Properties properties, String str, Class cls, Object obj) {
        String strFindAndSubst = findAndSubst(str, properties);
        if (strFindAndSubst == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find value for key ");
            stringBuffer.append(str);
            LogLog.error(stringBuffer.toString());
            return obj;
        }
        return instantiateByClassName(strFindAndSubst.trim(), cls, obj);
    }

    public static void selectAndConfigure(URL url, String str, LoggerRepository loggerRepository) throws Throwable {
        Configurator propertyConfigurator;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Preferred configurator class: ");
            stringBuffer.append(str);
            LogLog.debug(stringBuffer.toString());
            Class clsClass$ = class$org$apache$log4j$spi$Configurator;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.spi.Configurator");
                class$org$apache$log4j$spi$Configurator = clsClass$;
            }
            propertyConfigurator = (Configurator) instantiateByClassName(str, clsClass$, null);
            if (propertyConfigurator == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not instantiate configurator [");
                stringBuffer2.append(str);
                stringBuffer2.append("].");
                LogLog.error(stringBuffer2.toString());
                return;
            }
        } else {
            propertyConfigurator = new PropertyConfigurator();
        }
        propertyConfigurator.doConfigure(url, loggerRepository);
    }
}
