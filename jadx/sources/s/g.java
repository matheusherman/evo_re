package s;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class g implements j.m<Bitmap> {
    protected abstract Bitmap c(@NonNull m.d dVar, @NonNull Bitmap bitmap, int i10, int i11);

    @Override // j.m
    @NonNull
    public final l.v<Bitmap> b(@NonNull Context context, @NonNull l.v<Bitmap> vVar, int i10, int i11) {
        if (e0.l.u(i10, i11)) {
            m.d dVarF = com.bumptech.glide.c.c(context).f();
            Bitmap bitmap = vVar.get();
            if (i10 == Integer.MIN_VALUE) {
                i10 = bitmap.getWidth();
            }
            if (i11 == Integer.MIN_VALUE) {
                i11 = bitmap.getHeight();
            }
            Bitmap bitmapC = c(dVarF, bitmap, i10, i11);
            if (bitmap.equals(bitmapC)) {
                return vVar;
            }
            return f.c(bitmapC, dVarF);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + i10 + " or height: " + i11 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }
}
