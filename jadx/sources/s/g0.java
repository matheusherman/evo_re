package s;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class g0 implements j.k<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t f18153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.b f18154b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements t.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d0 f18155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0.d f18156b;

        @Override // s.t.b
        public void a() {
            this.f18155a.b();
        }

        @Override // s.t.b
        public void b(m.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f18156b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                dVar.c(bitmap);
                throw iOExceptionA;
            }
        }

        a(d0 d0Var, e0.d dVar) {
            this.f18155a = d0Var;
            this.f18156b = dVar;
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l.v<Bitmap> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull j.i iVar) {
        d0 d0Var;
        boolean z10;
        if (inputStream instanceof d0) {
            d0Var = (d0) inputStream;
            z10 = false;
        } else {
            d0Var = new d0(inputStream, this.f18154b);
            z10 = true;
        }
        e0.d dVarB = e0.d.b(d0Var);
        try {
            return this.f18153a.e(new e0.i(dVarB), i10, i11, iVar, new a(d0Var, dVarB));
        } finally {
            dVarB.c();
            if (z10) {
                d0Var.c();
            }
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull j.i iVar) {
        return this.f18153a.p(inputStream);
    }

    public g0(t tVar, m.b bVar) {
        this.f18153a = tVar;
        this.f18154b = bVar;
    }
}
