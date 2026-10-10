package android.os;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class SystemProperties {
    public static final int PROP_NAME_MAX = 31;
    public static final int PROP_VALUE_MAX = 91;
    private static final ArrayList<Runnable> sChangeCallbacks = new ArrayList<>();

    public static String get(String str) {
        if (str.length() <= 31) {
            return native_get(str);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    private static native void native_add_change_callback();

    private static native String native_get(String str);

    private static native String native_get(String str, String str2);

    private static native boolean native_get_boolean(String str, boolean z10);

    private static native int native_get_int(String str, int i10);

    private static native long native_get_long(String str, long j10);

    private static native void native_set(String str, String str2);

    public static void addChangeCallback(Runnable runnable) {
        ArrayList<Runnable> arrayList = sChangeCallbacks;
        synchronized (arrayList) {
            try {
                if (arrayList.size() == 0) {
                    native_add_change_callback();
                }
                arrayList.add(runnable);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static void callChangeCallbacks() {
        ArrayList<Runnable> arrayList = sChangeCallbacks;
        synchronized (arrayList) {
            try {
                if (arrayList.size() == 0) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList(arrayList);
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    ((Runnable) arrayList2.get(i10)).run();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean getBoolean(String str, boolean z10) {
        if (str.length() <= 31) {
            return native_get_boolean(str, z10);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static int getInt(String str, int i10) {
        if (str.length() <= 31) {
            return native_get_int(str, i10);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static long getLong(String str, long j10) {
        if (str.length() <= 31) {
            return native_get_long(str, j10);
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static void set(String str, String str2) {
        if (str.length() <= 31) {
            if (str2 != null && str2.length() > 91) {
                throw new IllegalArgumentException("val.length > 91");
            }
            native_set(str, str2);
            return;
        }
        throw new IllegalArgumentException("key.length > 31");
    }

    public static String get(String str, String str2) {
        if (str.length() <= 31) {
            return native_get(str, str2);
        }
        throw new IllegalArgumentException("key.length > 31");
    }
}
