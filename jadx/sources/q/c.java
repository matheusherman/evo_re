package q;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import j.i;
import java.io.InputStream;
import p.o;
import p.p;
import p.s;
import s.k0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c implements o<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17595a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17596a;

        @Override // p.p
        @NonNull
        public o<Uri, InputStream> c(s sVar) {
            return new c(this.f17596a);
        }

        public a(Context context) {
            this.f17596a = context;
        }

        @Override // p.p
        public void d() {
        }
    }

    private boolean e(i iVar) {
        Long l10 = (Long) iVar.c(k0.f18167d);
        return l10 != null && l10.longValue() == -1;
    }

    public c(Context context) {
        this.f17595a = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // p.o
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(@NonNull Uri uri, int i10, int i11, @NonNull i iVar) {
        if (k.b.d(i10, i11) && e(iVar)) {
            return new o.a<>(new d0.d(uri), k.c.f(this.f17595a, uri));
        }
        return null;
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return k.b.c(uri);
    }
}
