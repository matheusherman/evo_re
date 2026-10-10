package x;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import j.i;
import java.io.ByteArrayOutputStream;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements e<Bitmap, byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bitmap.CompressFormat f20521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20522b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(@NonNull Bitmap.CompressFormat compressFormat, int i10) {
        this.f20521a = compressFormat;
        this.f20522b = i10;
    }

    @Override // x.e
    @Nullable
    public v<byte[]> a(@NonNull v<Bitmap> vVar, @NonNull i iVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        vVar.get().compress(this.f20521a, this.f20522b, byteArrayOutputStream);
        vVar.recycle();
        return new t.b(byteArrayOutputStream.toByteArray());
    }
}
