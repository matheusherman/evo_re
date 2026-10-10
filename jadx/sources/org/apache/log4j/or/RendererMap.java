package org.apache.log4j.or;

import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.RendererSupport;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class RendererMap {
    static /* synthetic */ Class class$org$apache$log4j$or$ObjectRenderer;
    static ObjectRenderer defaultRenderer = new DefaultRenderer();
    Hashtable map = new Hashtable();

    public ObjectRenderer get(Object obj) {
        if (obj == null) {
            return null;
        }
        return get((Class) obj.getClass());
    }

    public static void addRenderer(RendererSupport rendererSupport, String str, String str2) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Rendering class: [");
        stringBuffer.append(str2);
        stringBuffer.append("], Rendered class: [");
        stringBuffer.append(str);
        stringBuffer.append("].");
        LogLog.debug(stringBuffer.toString());
        Class clsClass$ = class$org$apache$log4j$or$ObjectRenderer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.or.ObjectRenderer");
            class$org$apache$log4j$or$ObjectRenderer = clsClass$;
        }
        ObjectRenderer objectRenderer = (ObjectRenderer) OptionConverter.instantiateByClassName(str2, clsClass$, null);
        if (objectRenderer == null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not instantiate renderer [");
            stringBuffer2.append(str2);
            stringBuffer2.append("].");
            LogLog.error(stringBuffer2.toString());
            return;
        }
        try {
            rendererSupport.setRenderer(Loader.loadClass(str), objectRenderer);
        } catch (ClassNotFoundException e10) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not find class [");
            stringBuffer3.append(str);
            stringBuffer3.append("].");
            LogLog.error(stringBuffer3.toString(), e10);
        }
    }

    public void clear() {
        this.map.clear();
    }

    public String findAndRender(Object obj) {
        if (obj == null) {
            return null;
        }
        return get((Class) obj.getClass()).doRender(obj);
    }

    public ObjectRenderer get(Class cls) {
        while (cls != null) {
            ObjectRenderer objectRenderer = (ObjectRenderer) this.map.get(cls);
            if (objectRenderer != null) {
                return objectRenderer;
            }
            ObjectRenderer objectRendererSearchInterfaces = searchInterfaces(cls);
            if (objectRendererSearchInterfaces != null) {
                return objectRendererSearchInterfaces;
            }
            cls = cls.getSuperclass();
        }
        return defaultRenderer;
    }

    public ObjectRenderer getDefaultRenderer() {
        return defaultRenderer;
    }

    public void put(Class cls, ObjectRenderer objectRenderer) {
        this.map.put(cls, objectRenderer);
    }

    ObjectRenderer searchInterfaces(Class cls) {
        ObjectRenderer objectRenderer = (ObjectRenderer) this.map.get(cls);
        if (objectRenderer != null) {
            return objectRenderer;
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            ObjectRenderer objectRendererSearchInterfaces = searchInterfaces(cls2);
            if (objectRendererSearchInterfaces != null) {
                return objectRendererSearchInterfaces;
            }
        }
        return null;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
