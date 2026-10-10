package m4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import h3.s;
import java.io.ByteArrayOutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f15656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f15658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Rect f15659d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15660e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f15661f;

    public Bitmap b(Rect rect, int i10) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f15656a.d(), this.f15656a.c());
        } else if (c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f15656a.b(), this.f15657b, this.f15656a.d(), this.f15656a.c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i10;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f15658c == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f15658c);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public h3.n a() {
        m mVarA = this.f15656a.h(this.f15658c).a(this.f15659d, this.f15660e);
        return new h3.n(mVarA.b(), mVarA.d(), mVarA.c(), 0, 0, mVarA.d(), mVarA.c(), false);
    }

    public boolean c() {
        return this.f15658c % 180 != 0;
    }

    public void d(Rect rect) {
        this.f15659d = rect;
    }

    public void e(boolean z10) {
        this.f15661f = z10;
    }

    public q(byte[] bArr, int i10, int i11, int i12, int i13) {
        this.f15656a = new m(bArr, i10, i11);
        this.f15658c = i13;
        this.f15657b = i12;
        if (i10 * i11 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i10 + "x" + i11 + " > " + bArr.length);
    }

    public s f(s sVar) {
        float fC = (sVar.c() * this.f15660e) + this.f15659d.left;
        float fD = (sVar.d() * this.f15660e) + this.f15659d.top;
        if (this.f15661f) {
            fC = this.f15656a.d() - fC;
        }
        return new s(fC, fD);
    }
}
