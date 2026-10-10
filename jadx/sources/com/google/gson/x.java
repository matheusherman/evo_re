package com.google.gson;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class x<T> {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends x<T> {
        a() {
        }

        @Override // com.google.gson.x
        public void d(g3.c cVar, T t10) throws IOException {
            if (t10 == null) {
                cVar.q();
            } else {
                x.this.d(cVar, t10);
            }
        }

        @Override // com.google.gson.x
        public T b(g3.a aVar) throws IOException {
            if (aVar.B() == g3.b.NULL) {
                aVar.x();
                return null;
            }
            return (T) x.this.b(aVar);
        }
    }

    public abstract T b(g3.a aVar);

    public abstract void d(g3.c cVar, T t10);

    public final x<T> a() {
        return new a();
    }

    public final k c(T t10) {
        try {
            b3.g gVar = new b3.g();
            d(gVar, t10);
            return gVar.P();
        } catch (IOException e10) {
            throw new l(e10);
        }
    }
}
