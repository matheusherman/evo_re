package w;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import e0.k;
import j.m;
import java.security.MessageDigest;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class f implements m<c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<Bitmap> f20019b;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.f20019b.a(messageDigest);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f20019b.equals(((f) obj).f20019b);
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return this.f20019b.hashCode();
    }

    public f(m<Bitmap> mVar) {
        this.f20019b = (m) k.d(mVar);
    }

    @Override // j.m
    @NonNull
    public v<c> b(@NonNull Context context, @NonNull v<c> vVar, int i10, int i11) {
        c cVar = vVar.get();
        v<Bitmap> fVar = new s.f(cVar.e(), com.bumptech.glide.c.c(context).f());
        v<Bitmap> vVarB = this.f20019b.b(context, fVar, i10, i11);
        if (!fVar.equals(vVarB)) {
            fVar.recycle();
        }
        cVar.m(this.f20019b, vVarB.get());
        return vVar;
    }
}
