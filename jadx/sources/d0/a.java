package d0;

import android.content.Context;
import androidx.annotation.NonNull;
import e0.l;
import j.f;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f9550c;

    @Override // j.f
    public void a(@NonNull MessageDigest messageDigest) {
        this.f9550c.a(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f9549b).array());
    }

    @Override // j.f
    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f9549b == aVar.f9549b && this.f9550c.equals(aVar.f9550c)) {
                return true;
            }
        }
        return false;
    }

    @Override // j.f
    public int hashCode() {
        return l.p(this.f9550c, this.f9549b);
    }

    private a(int i10, f fVar) {
        this.f9549b = i10;
        this.f9550c = fVar;
    }

    @NonNull
    public static f c(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }
}
