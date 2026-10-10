package org.apache.log4j.lf5.util;

import java.io.InputStream;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ResourceUtils {
    public static InputStream getResourceAsStream(Object obj, Resource resource) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResourceAsStream(resource.getName());
        }
        return ClassLoader.getSystemResourceAsStream(resource.getName());
    }

    public static URL getResourceAsURL(Object obj, Resource resource) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        if (classLoader != null) {
            return classLoader.getResource(resource.getName());
        }
        return ClassLoader.getSystemResource(resource.getName());
    }
}
