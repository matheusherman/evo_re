package k1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.b;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class n<A extends com.google.android.gms.common.api.a.b, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Feature[] f12046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f12048c;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<A extends com.google.android.gms.common.api.a.b, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private l f12049a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Feature[] f12051c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f12050b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12052d = 0;

        @NonNull
        public n<A, ResultT> a() {
            m1.g.b(this.f12049a != null, "execute parameter required");
            return new p0(this, this.f12051c, this.f12050b, this.f12052d);
        }

        @NonNull
        public a<A, ResultT> b(@NonNull l<A, e2.h<ResultT>> lVar) {
            this.f12049a = lVar;
            return this;
        }

        @NonNull
        public a<A, ResultT> c(boolean z10) {
            this.f12050b = z10;
            return this;
        }

        @NonNull
        public a<A, ResultT> d(@NonNull Feature... featureArr) {
            this.f12051c = featureArr;
            return this;
        }

        /* synthetic */ a(q0 q0Var) {
        }
    }

    protected abstract void b(@NonNull A a10, @NonNull e2.h<ResultT> hVar);

    @NonNull
    public static <A extends com.google.android.gms.common.api.a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    public boolean c() {
        return this.f12047b;
    }

    public final int d() {
        return this.f12048c;
    }

    @Nullable
    public final Feature[] e() {
        return this.f12046a;
    }

    protected n(@Nullable Feature[] featureArr, boolean z10, int i10) {
        this.f12046a = featureArr;
        boolean z11 = false;
        if (featureArr != null && z10) {
            z11 = true;
        }
        this.f12047b = z11;
        this.f12048c = i10;
    }
}
