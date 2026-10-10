package s;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a<DataType> implements j.k<DataType, BitmapDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j.k<DataType, Bitmap> f18129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f18130b;

    @Override // j.k
    public boolean a(@NonNull DataType datatype, @NonNull j.i iVar) {
        return this.f18129a.a(datatype, iVar);
    }

    @Override // j.k
    public l.v<BitmapDrawable> b(@NonNull DataType datatype, int i10, int i11, @NonNull j.i iVar) {
        return b0.c(this.f18130b, this.f18129a.b(datatype, i10, i11, iVar));
    }

    public a(@NonNull Resources resources, @NonNull j.k<DataType, Bitmap> kVar) {
        this.f18130b = (Resources) e0.k.d(resources);
        this.f18129a = (j.k) e0.k.d(kVar);
    }
}
