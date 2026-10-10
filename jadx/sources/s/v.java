package s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class v implements j.m<Drawable> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j.m<Bitmap> f18211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f18212c;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.f18211b.a(messageDigest);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.f18211b.equals(((v) obj).f18211b);
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return this.f18211b.hashCode();
    }

    public v(j.m<Bitmap> mVar, boolean z10) {
        this.f18211b = mVar;
        this.f18212c = z10;
    }

    private l.v<Drawable> d(Context context, l.v<Bitmap> vVar) {
        return b0.c(context.getResources(), vVar);
    }

    @Override // j.m
    @NonNull
    public l.v<Drawable> b(@NonNull Context context, @NonNull l.v<Drawable> vVar, int i10, int i11) {
        m.d dVarF = com.bumptech.glide.c.c(context).f();
        Drawable drawable = vVar.get();
        l.v<Bitmap> vVarA = u.a(dVarF, drawable, i10, i11);
        if (vVarA == null) {
            if (!this.f18212c) {
                return vVar;
            }
            throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
        }
        l.v<Bitmap> vVarB = this.f18211b.b(context, vVarA, i10, i11);
        if (vVarB.equals(vVarA)) {
            vVarB.recycle();
            return vVar;
        }
        return d(context, vVarB);
    }

    public j.m<BitmapDrawable> c() {
        return this;
    }
}
