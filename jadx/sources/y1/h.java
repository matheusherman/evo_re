package y1;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class h {
    @Nullable
    public static Object a(Class cls, String str, g... gVarArr) {
        return b(cls, "isIsolated", null, false, gVarArr);
    }

    @Nullable
    private static Object b(Class cls, String str, @Nullable Object obj, boolean z10, g... gVarArr) {
        int length = gVarArr.length;
        Class<?>[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        Object obj2 = null;
        if (gVarArr.length <= 0) {
            return cls.getDeclaredMethod(str, clsArr).invoke(null, objArr);
        }
        g gVar = gVarArr[0];
        obj2.getClass();
        throw null;
    }
}
