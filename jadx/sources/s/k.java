package s;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class k extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f18166b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(j.f.f11519a);

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18166b);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        return obj instanceof k;
    }

    @Override // s.g
    protected Bitmap c(@NonNull m.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return h0.b(dVar, bitmap, i10, i11);
    }

    @Override // j.f
    public int hashCode() {
        return -599754482;
    }
}
