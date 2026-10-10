package s;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(api = 28)
public final class j implements j.k<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f18165a = new e();

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull j.i iVar) {
        return true;
    }

    @Override // j.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public l.v<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull j.i iVar) {
        return this.f18165a.c(ImageDecoder.createSource(byteBuffer), i10, i11, iVar);
    }
}
