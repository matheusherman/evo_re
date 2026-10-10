package io.reactivex.rxjava3.internal.util;

import g8.g;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum c {
    COMPLETE;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final h8.c upstream;

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }

        a(h8.c cVar) {
            this.upstream = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f11491e;

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return Objects.equals(this.f11491e, ((b) obj).f11491e);
            }
            return false;
        }

        public int hashCode() {
            return this.f11491e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f11491e + "]";
        }

        b(Throwable th) {
            this.f11491e = th;
        }
    }

    public static <T> boolean a(Object obj, g<? super T> gVar) {
        if (obj == COMPLETE) {
            gVar.b();
            return true;
        }
        if (obj instanceof b) {
            gVar.onError(((b) obj).f11491e);
            return true;
        }
        if (obj instanceof a) {
            gVar.d(((a) obj).upstream);
            return false;
        }
        gVar.a(obj);
        return false;
    }

    public static Object f() {
        return COMPLETE;
    }

    public static Object i(h8.c cVar) {
        return new a(cVar);
    }

    public static Object j(Throwable th) {
        return new b(th);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> Object k(T t10) {
        return t10;
    }
}
