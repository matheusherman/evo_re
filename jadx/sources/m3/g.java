package m3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15608a = "g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f15609b = Pattern.compile(",");

    public static Map<h3.e, Object> a(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null && !extras.isEmpty()) {
            EnumMap enumMap = new EnumMap(h3.e.class);
            for (h3.e eVar : h3.e.values()) {
                if (eVar != h3.e.CHARACTER_SET && eVar != h3.e.NEED_RESULT_POINT_CALLBACK && eVar != h3.e.POSSIBLE_FORMATS) {
                    String strName = eVar.name();
                    if (extras.containsKey(strName)) {
                        if (eVar.f().equals(Void.class)) {
                            enumMap.put(eVar, Boolean.TRUE);
                        } else {
                            Object obj = extras.get(strName);
                            if (eVar.f().isInstance(obj)) {
                                enumMap.put(eVar, obj);
                            } else {
                                Log.w(f15608a, "Ignoring hint " + eVar + " because it is not assignable from " + obj);
                            }
                        }
                    }
                }
            }
            Log.i(f15608a, "Hints from the Intent: " + enumMap);
            return enumMap;
        }
        return null;
    }
}
