package s;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(api = 28)
public final class e implements j.k<ImageDecoder.Source, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m.d f18146a = new m.e();

    public boolean d(@NonNull ImageDecoder.Source source, @NonNull j.i iVar) {
        return true;
    }

    public l.v<Bitmap> c(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull j.i iVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new r.j(i10, i11, iVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + bitmapDecodeBitmap.getWidth() + "x" + bitmapDecodeBitmap.getHeight() + "] for [" + i10 + "x" + i11 + "]");
        }
        return new f(bitmapDecodeBitmap, this.f18146a);
    }

    @Override // j.k
    public /* bridge */ /* synthetic */ boolean a(@NonNull ImageDecoder.Source source, @NonNull j.i iVar) {
        return d(d.a(source), iVar);
    }

    @Override // j.k
    public /* bridge */ /* synthetic */ l.v<Bitmap> b(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull j.i iVar) {
        return c(d.a(source), i10, i11, iVar);
    }
}
