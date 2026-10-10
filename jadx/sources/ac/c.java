package ac;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f211a = String.valueOf('.');

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f212b = String.valueOf('$');

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, String> f216f;

    static {
        HashMap map = new HashMap();
        f213c = map;
        map.put(Boolean.TYPE, Boolean.class);
        map.put(Byte.TYPE, Byte.class);
        map.put(Character.TYPE, Character.class);
        map.put(Short.TYPE, Short.class);
        map.put(Integer.TYPE, Integer.class);
        map.put(Long.TYPE, Long.class);
        map.put(Double.TYPE, Double.class);
        map.put(Float.TYPE, Float.class);
        Class cls = Void.TYPE;
        map.put(cls, cls);
        f214d = new HashMap();
        for (Class<?> cls2 : map.keySet()) {
            Class<?> cls3 = f213c.get(cls2);
            if (!cls2.equals(cls3)) {
                f214d.put(cls3, cls2);
            }
        }
        HashMap map2 = new HashMap();
        map2.put("int", "I");
        map2.put(TypedValues.Custom.S_BOOLEAN, "Z");
        map2.put(TypedValues.Custom.S_FLOAT, "F");
        map2.put("long", "J");
        map2.put("short", ExifInterface.LATITUDE_SOUTH);
        map2.put("byte", "B");
        map2.put("double", "D");
        map2.put("char", "C");
        map2.put("void", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        HashMap map3 = new HashMap();
        for (Map.Entry entry : map2.entrySet()) {
            map3.put(entry.getValue(), entry.getKey());
        }
        f215e = Collections.unmodifiableMap(map2);
        f216f = Collections.unmodifiableMap(map3);
    }

    public static String a(Class<?> cls) {
        return cls == null ? "" : b(cls.getName());
    }

    public static String b(String str) {
        if (g.f(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                sb2.append("[]");
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
            Map<String, String> map = f216f;
            if (map.containsKey(str)) {
                str = map.get(str);
            }
        }
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            i10 = iLastIndexOf + 1;
        }
        int iIndexOf = str.indexOf(36, i10);
        String strSubstring = str.substring(iLastIndexOf + 1);
        if (iIndexOf != -1) {
            strSubstring = strSubstring.replace('$', '.');
        }
        return strSubstring + ((Object) sb2);
    }
}
