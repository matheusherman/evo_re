package z7;

import android.os.SystemProperties;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lz7/o;", "", "<init>", "()V", "", "key", "dft", "a", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "tvclib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f23121a = new o();

    public final String a(String key, String dft) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String string;
        int i10 = SystemProperties.PROP_NAME_MAX;
        Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class, String.class);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(null, key, dft);
        if (objInvoke == null || (string = objInvoke.toString()) == null) {
            return "";
        }
        int length = string.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            boolean z11 = kotlin.jvm.internal.m.h(string.charAt(!z10 ? i11 : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                }
                length--;
            } else if (z11) {
                i11++;
            } else {
                z10 = true;
            }
        }
        String string2 = string.subSequence(i11, length + 1).toString();
        return string2 == null ? "" : string2;
    }

    private o() {
    }
}
