package u1;

import android.content.Context;
import android.os.IBinder;
import androidx.annotation.NonNull;
import m1.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f19313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f19314b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a extends Exception {
        public a(@NonNull String str) {
            super(str);
        }

        public a(@NonNull String str, @NonNull Throwable th) {
            super(str, th);
        }
    }

    @NonNull
    protected abstract T a(@NonNull IBinder iBinder);

    @NonNull
    protected final T b(@NonNull Context context) throws a {
        if (this.f19314b == null) {
            g.k(context);
            Context contextC = com.google.android.gms.common.d.c(context);
            if (contextC == null) {
                throw new a("Could not get remote context.");
            }
            try {
                this.f19314b = a((IBinder) contextC.getClassLoader().loadClass(this.f19313a).newInstance());
            } catch (ClassNotFoundException e10) {
                throw new a("Could not load creator class.", e10);
            } catch (IllegalAccessException e11) {
                throw new a("Could not access creator.", e11);
            } catch (InstantiationException e12) {
                throw new a("Could not instantiate creator.", e12);
            }
        }
        return (T) this.f19314b;
    }

    protected c(@NonNull String str) {
        this.f19313a = str;
    }
}
