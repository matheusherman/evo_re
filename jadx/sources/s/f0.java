package s;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f0 extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f18151c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(j.f.f11519a);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f18152b;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18151c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18152b).array());
    }

    @Override // s.g
    protected Bitmap c(@NonNull m.d dVar, @NonNull Bitmap bitmap, int i10, int i11) {
        return h0.n(dVar, bitmap, this.f18152b);
    }

    @Override // j.f
    public boolean equals(Object obj) {
        return (obj instanceof f0) && this.f18152b == ((f0) obj).f18152b;
    }

    @Override // j.f
    public int hashCode() {
        return e0.l.o(-569625254, e0.l.n(this.f18152b));
    }

    public f0(int i10) {
        boolean z10;
        if (i10 > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        e0.k.a(z10, "roundingRadius must be greater than 0.");
        this.f18152b = i10;
    }
}
