package m1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class f {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f15485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f15486b;

        @NonNull
        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f15486b.getClass().getSimpleName());
            sb2.append('{');
            int size = this.f15485a.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) this.f15485a.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }

        /* synthetic */ a(Object obj, e0 e0Var) {
            g.k(obj);
            this.f15486b = obj;
            this.f15485a = new ArrayList();
        }

        @NonNull
        public a a(@NonNull String str, @Nullable Object obj) {
            g.k(str);
            this.f15485a.add(str + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean a(@Nullable Object obj, @Nullable Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @NonNull
    public static a c(@NonNull Object obj) {
        return new a(obj, null);
    }

    public static int b(@NonNull Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
