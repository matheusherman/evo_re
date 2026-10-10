package r;

import androidx.annotation.NonNull;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k<T> implements v<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f17780a;

    @Override // l.v
    public final int getSize() {
        return 1;
    }

    @Override // l.v
    @NonNull
    public Class<T> b() {
        return (Class<T>) this.f17780a.getClass();
    }

    @Override // l.v
    @NonNull
    public final T get() {
        return this.f17780a;
    }

    public k(@NonNull T t10) {
        this.f17780a = (T) e0.k.d(t10);
    }

    @Override // l.v
    public void recycle() {
    }
}
