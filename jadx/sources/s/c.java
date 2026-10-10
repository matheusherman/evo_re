package s;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class c implements j.l<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j.h<Integer> f18136b = j.h.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j.h<Bitmap.CompressFormat> f18137c = j.h.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final m.b f18138a;

    private Bitmap.CompressFormat d(Bitmap bitmap, j.i iVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.c(f18137c);
        if (compressFormat != null) {
            return compressFormat;
        }
        return bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // j.l
    @NonNull
    public j.c b(@NonNull j.i iVar) {
        return j.c.TRANSFORMED;
    }

    @Override // j.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull l.v<Bitmap> vVar, @NonNull File file, @NonNull j.i iVar) {
        boolean z10;
        Bitmap bitmap = vVar.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, iVar);
        f0.b.d("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = e0.g.b();
            int iIntValue = ((Integer) iVar.c(f18136b)).intValue();
            OutputStream cVar = null;
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        cVar = this.f18138a != null ? new com.bumptech.glide.load.data.c(fileOutputStream, this.f18138a) : fileOutputStream;
                        bitmap.compress(compressFormatD, iIntValue, cVar);
                        cVar.close();
                        try {
                            cVar.close();
                        } catch (IOException unused) {
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        e = e10;
                        cVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z10 = false;
                    } catch (Throwable th) {
                        th = th;
                        cVar = fileOutputStream;
                        if (cVar != null) {
                            try {
                                cVar.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e11) {
                e = e11;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + e0.l.h(bitmap) + " in " + e0.g.a(jB) + ", options format: " + iVar.c(f18137c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            f0.b.e();
            return z10;
        } catch (Throwable th3) {
            f0.b.e();
            throw th3;
        }
    }

    public c(@NonNull m.b bVar) {
        this.f18138a = bVar;
    }
}
