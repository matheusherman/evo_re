package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class SystemPropertyUtil {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SystemPropertyUtil.class);

    public static String get(String str) {
        return get(str, null);
    }

    public static String get(final String str, String str2) {
        ObjectUtil.checkNonEmpty(str, "key");
        try {
            str = System.getSecurityManager() == null ? System.getProperty(str) : (String) AccessController.doPrivileged(new PrivilegedAction<String>() { // from class: io.netty.util.internal.SystemPropertyUtil.1
                @Override // java.security.PrivilegedAction
                public String run() {
                    return System.getProperty(str);
                }
            });
        } catch (SecurityException e10) {
            logger.warn("Unable to retrieve a system property '{}'; default values will be used.", str, e10);
            str = null;
        }
        return str == null ? str2 : str;
    }

    private SystemPropertyUtil() {
    }

    public static boolean contains(String str) {
        if (get(str) != null) {
            return true;
        }
        return false;
    }

    public static boolean getBoolean(String str, boolean z10) {
        String str2 = get(str);
        if (str2 != null) {
            String lowerCase = str2.trim().toLowerCase();
            if (!lowerCase.isEmpty()) {
                if ("true".equals(lowerCase) || "yes".equals(lowerCase) || "1".equals(lowerCase)) {
                    return true;
                }
                if ("false".equals(lowerCase) || "no".equals(lowerCase) || "0".equals(lowerCase)) {
                    return false;
                }
                logger.warn("Unable to parse the boolean system property '{}':{} - using the default value: {}", str, lowerCase, Boolean.valueOf(z10));
                return z10;
            }
        }
        return z10;
    }

    public static int getInt(String str, int i10) {
        String str2 = get(str);
        if (str2 == null) {
            return i10;
        }
        String strTrim = str2.trim();
        try {
            return Integer.parseInt(strTrim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the integer system property '{}':{} - using the default value: {}", str, strTrim, Integer.valueOf(i10));
            return i10;
        }
    }

    public static long getLong(String str, long j10) {
        String str2 = get(str);
        if (str2 == null) {
            return j10;
        }
        String strTrim = str2.trim();
        try {
            return Long.parseLong(strTrim);
        } catch (Exception unused) {
            logger.warn("Unable to parse the long integer system property '{}':{} - using the default value: {}", str, strTrim, Long.valueOf(j10));
            return j10;
        }
    }
}
