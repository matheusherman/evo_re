package e2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z f9833a = new z();

    @NonNull
    public g<TResult> a() {
        return this.f9833a;
    }

    public void b(@NonNull Exception exc) {
        this.f9833a.l(exc);
    }

    public void c(@Nullable TResult tresult) {
        this.f9833a.m(tresult);
    }

    public boolean d(@NonNull Exception exc) {
        return this.f9833a.n(exc);
    }

    public boolean e(@Nullable TResult tresult) {
        return this.f9833a.o(tresult);
    }
}
