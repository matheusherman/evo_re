package n;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import e0.k;
import e0.l;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0.h<j.f, String> f15840a = new e0.h<>(1000);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<b> f15841b = f0.a.d(10, new a());

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements f0.a.d<b> {
        a() {
        }

        @Override // f0.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements f0.a.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MessageDigest f15843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f0.c f15844b = f0.c.a();

        @Override // f0.a.f
        @NonNull
        public f0.c a() {
            return this.f15844b;
        }

        b(MessageDigest messageDigest) {
            this.f15843a = messageDigest;
        }
    }

    private String a(j.f fVar) {
        b bVar = (b) k.d(this.f15841b.acquire());
        try {
            fVar.a(bVar.f15843a);
            return l.x(bVar.f15843a.digest());
        } finally {
            this.f15841b.release(bVar);
        }
    }

    public String b(j.f fVar) {
        String strG;
        synchronized (this.f15840a) {
            strG = this.f15840a.g(fVar);
        }
        if (strG == null) {
            strG = a(fVar);
        }
        synchronized (this.f15840a) {
            this.f15840a.k(fVar, strG);
        }
        return strG;
    }
}
