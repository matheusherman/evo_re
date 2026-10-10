package f0;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f9941a;

        b() {
            super(null);
        }

        @Override // f0.c
        public void b(boolean z10) {
            this.f9941a = z10;
        }

        @Override // f0.c
        public void c() {
            if (this.f9941a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    abstract void b(boolean z10);

    public abstract void c();

    private c() {
    }

    @NonNull
    public static c a() {
        return new b();
    }
}
