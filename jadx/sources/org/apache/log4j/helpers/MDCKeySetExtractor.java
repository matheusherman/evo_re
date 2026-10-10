package org.apache.log4j.helpers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.Set;
import org.apache.log4j.pattern.LogEvent;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class MDCKeySetExtractor {
    public static final MDCKeySetExtractor INSTANCE = new MDCKeySetExtractor();
    static /* synthetic */ Class class$org$apache$log4j$pattern$LogEvent;
    static /* synthetic */ Class class$org$apache$log4j$spi$LoggingEvent;
    private final Method getKeySetMethod;

    public Set getPropertyKeySet(LoggingEvent loggingEvent) throws Throwable {
        Method method = this.getKeySetMethod;
        if (method != null) {
            return (Set) method.invoke(loggingEvent, null);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(loggingEvent);
        objectOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Class clsClass$ = class$org$apache$log4j$pattern$LogEvent;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.pattern.LogEvent");
            class$org$apache$log4j$pattern$LogEvent = clsClass$;
        }
        String name = clsClass$.getName();
        if (byteArray[6] != 0 && byteArray[7] != name.length()) {
            return null;
        }
        for (int i10 = 0; i10 < name.length(); i10++) {
            byteArray[i10 + 8] = (byte) name.charAt(i10);
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
        Object object = objectInputStream.readObject();
        Set propertyKeySet = object instanceof LogEvent ? ((LogEvent) object).getPropertyKeySet() : null;
        objectInputStream.close();
        return propertyKeySet;
    }

    private MDCKeySetExtractor() throws Throwable {
        Method method = null;
        try {
            Class clsClass$ = class$org$apache$log4j$spi$LoggingEvent;
            if (clsClass$ == null) {
                clsClass$ = class$("org.apache.log4j.spi.LoggingEvent");
                class$org$apache$log4j$spi$LoggingEvent = clsClass$;
            }
            method = clsClass$.getMethod("getPropertyKeySet", null);
        } catch (Exception unused) {
        }
        this.getKeySetMethod = method;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
