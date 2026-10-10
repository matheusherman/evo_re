package r;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import s.n;
import s.t;
import s.y;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(api = 28)
public final class j implements ImageDecoder.OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f17772a = y.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j.b f17775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n f17776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j.j f17778g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements ImageDecoder.OnPartialImageListener {
        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
            return false;
        }

        a() {
        }
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        if (this.f17772a.e(this.f17773b, this.f17774c, this.f17777f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f17775d == j.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size size = imageInfo.getSize();
        int width = this.f17773b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.f17774c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.f17776e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        j.j jVar = this.f17778g;
        if (jVar != null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((jVar == j.j.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i10 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }

    public j(int i10, int i11, @NonNull j.i iVar) {
        boolean z10;
        this.f17773b = i10;
        this.f17774c = i11;
        this.f17775d = (j.b) iVar.c(t.f18196f);
        this.f17776e = (n) iVar.c(n.f18191h);
        j.h<Boolean> hVar = t.f18200j;
        if (iVar.c(hVar) != null && ((Boolean) iVar.c(hVar)).booleanValue()) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f17777f = z10;
        this.f17778g = (j.j) iVar.c(t.f18197g);
    }
}
