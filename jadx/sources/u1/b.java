package u1;

import android.os.IBinder;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class b<T> extends a.AbstractBinderC0368a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19312a;

    @NonNull
    public static <T> a W(@NonNull T t10) {
        return new b(t10);
    }

    @NonNull
    public static <T> T g(@NonNull a aVar) {
        if (aVar instanceof b) {
            return (T) ((b) aVar).f19312a;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        g.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(iBinderAsBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (NullPointerException e11) {
            throw new IllegalArgumentException("Binder object is null.", e11);
        }
    }

    private b(Object obj) {
        this.f19312a = obj;
    }
}
