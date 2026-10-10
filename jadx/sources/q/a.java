package q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.data.j;
import j.i;
import java.io.InputStream;
import p.h;
import p.n;
import p.o;
import p.p;
import p.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements o<h, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j.h<Integer> f17590b = j.h.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final n<h, h> f17591a;

    /* JADX INFO: renamed from: q.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class C0336a implements p<h, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n<h, h> f17592a = new n<>(500);

        @Override // p.p
        @NonNull
        public o<h, InputStream> c(s sVar) {
            return new a(this.f17592a);
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull h hVar) {
        return true;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<InputStream> b(@NonNull h hVar, int i10, int i11, @NonNull i iVar) {
        n<h, h> nVar = this.f17591a;
        if (nVar != null) {
            h hVarA = nVar.a(hVar, 0, 0);
            if (hVarA == null) {
                this.f17591a.b(hVar, 0, 0, hVar);
            } else {
                hVar = hVarA;
            }
        }
        return new o.a<>(hVar, new j(hVar, ((Integer) iVar.c(f17590b)).intValue()));
    }

    public a(@Nullable n<h, h> nVar) {
        this.f17591a = nVar;
    }
}
