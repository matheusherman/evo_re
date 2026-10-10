package e0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a<T> implements b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile T f9791a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f9792b;

        a(b bVar) {
            this.f9792b = bVar;
        }

        @Override // e0.f.b
        public T get() {
            if (this.f9791a == null) {
                synchronized (this) {
                    try {
                        if (this.f9791a == null) {
                            this.f9791a = (T) k.d(this.f9792b.get());
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.f9791a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b<T> {
        T get();
    }

    public static <T> b<T> a(b<T> bVar) {
        return new a(bVar);
    }
}
