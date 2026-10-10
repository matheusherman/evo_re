package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class c<T> implements Iterable<T>, d9.a {
    public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract int e();

    public abstract void f(int i10, T t10);

    public abstract T get(int i10);

    @Override // java.lang.Iterable
    public abstract Iterator<T> iterator();

    private c() {
    }
}
