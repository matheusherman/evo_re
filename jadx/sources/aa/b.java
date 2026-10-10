package aa;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f165a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f166b = r.q0(r.o('k', 'o', 't', 'l', 'i', 'n'), "", null, null, 0, null, null, 62, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f167c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listO = r.o("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int iB = x8.c.b(0, listO.size() - 1, 2);
        if (iB >= 0) {
            int i10 = 0;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                String str = f166b;
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) listO.get(i10));
                int i11 = i10 + 1;
                linkedHashMap.put(sb2.toString(), listO.get(i11));
                linkedHashMap.put(str + '/' + ((String) listO.get(i10)) + "Array", '[' + ((String) listO.get(i11)));
                if (i10 == iB) {
                    break;
                } else {
                    i10 += 2;
                }
            }
        }
        linkedHashMap.put(f166b + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        a(linkedHashMap, "Any", "java/lang/Object");
        a(linkedHashMap, "Nothing", "java/lang/Void");
        a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : r.o("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            a(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : r.o("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            a(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            a(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i12 = 0; i12 < 23; i12++) {
            StringBuilder sb3 = new StringBuilder();
            String str4 = f166b;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i12);
            a(linkedHashMap, "Function" + i12, sb3.toString());
            a(linkedHashMap, "reflect/KFunction" + i12, str4 + "/reflect/KFunction");
        }
        for (String str5 : r.o("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            a(linkedHashMap, str5 + ".Companion", f166b + "/jvm/internal/" + str5 + "CompanionObject");
        }
        f167c = linkedHashMap;
    }

    private static final void a(Map<String, String> map, String str, String str2) {
        map.put(f166b + '/' + str, 'L' + str2 + ';');
    }

    public static final String b(String classId) {
        m.f(classId, "classId");
        String str = f167c.get(classId);
        if (str != null) {
            return str;
        }
        return 'L' + n.D(classId, '.', '$', false, 4, null) + ';';
    }

    private b() {
    }
}
