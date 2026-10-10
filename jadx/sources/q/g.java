package q;

import androidx.annotation.NonNull;
import j.i;
import java.io.InputStream;
import java.net.URL;
import p.h;
import p.o;
import p.p;
import p.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class g implements o<URL, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<h, InputStream> f17614a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a implements p<URL, InputStream> {
        @Override // p.p
        @NonNull
        public o<URL, InputStream> c(s sVar) {
            return new g(sVar.d(h.class, InputStream.class));
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull URL url) {
        return true;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(@NonNull URL url, int i10, int i11, @NonNull i iVar) {
        return this.f17614a.b(new h(url), i10, i11, iVar);
    }

    public g(o<h, InputStream> oVar) {
        this.f17614a = oVar;
    }
}
