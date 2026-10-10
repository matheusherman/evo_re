package y2;

import android.content.Context;
import m2.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class h {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<T> {
        String a(T t10);
    }

    public static m2.c<?> c(final String str, final a<Context> aVar) {
        return m2.c.m(f.class).b(r.h(Context.class)).e(new m2.h() { // from class: y2.g
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return f.a(str, aVar.a((Context) eVar.a(Context.class)));
            }
        }).c();
    }

    public static m2.c<?> b(String str, String str2) {
        return m2.c.l(f.a(str, str2), f.class);
    }
}
