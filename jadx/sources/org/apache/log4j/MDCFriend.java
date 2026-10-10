package org.apache.log4j;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.apache.log4j.helpers.ThreadLocalMap;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MDCFriend {
    public static void fixForJava9() {
        MDC mdc = MDC.mdc;
        if (mdc.tlm == null) {
            mdc.tlm = new ThreadLocalMap();
            mdc.java1 = false;
            setRemoveMethod(mdc);
        }
    }

    private static void setRemoveMethod(MDC mdc) {
        try {
            Method method = ThreadLocal.class.getMethod("remove", null);
            Field declaredField = MDC.class.getDeclaredField("removeMethod");
            declaredField.setAccessible(true);
            declaredField.set(mdc, method);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | NoSuchMethodException | SecurityException unused) {
        }
    }
}
