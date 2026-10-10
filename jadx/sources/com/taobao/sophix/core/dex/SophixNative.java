package com.taobao.sophix.core.dex;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class SophixNative {
    public static native void clearPreVerified(Object obj);

    public static native boolean clearResolvedCache(String str, Object obj);

    public static native boolean initHotNative();

    public static native boolean markKeptMethods(String str, String[] strArr);

    public static native boolean removeClassesInBase(String str, String str2, String[] strArr);

    public static native void replaceMethod(Object obj, Object obj2);

    static {
        System.loadLibrary("sophix");
    }
}
