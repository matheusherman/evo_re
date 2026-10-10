package u;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(28)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f19301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m.b f19302b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements v<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDrawable f19303a;

        @Override // l.v
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f19303a;
        }

        @Override // l.v
        @NonNull
        public Class<Drawable> b() {
            return Drawable.class;
        }

        @Override // l.v
        public int getSize() {
            return this.f19303a.getIntrinsicWidth() * this.f19303a.getIntrinsicHeight() * e0.l.i(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // l.v
        public void recycle() {
            this.f19303a.stop();
            this.f19303a.clearAnimationCallbacks();
        }

        a(AnimatedImageDrawable animatedImageDrawable) {
            this.f19303a = animatedImageDrawable;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements j.k<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f19304a;

        @Override // j.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull j.i iVar) {
            return this.f19304a.d(byteBuffer);
        }

        b(g gVar) {
            this.f19304a = gVar;
        }

        @Override // j.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v<Drawable> b(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull j.i iVar) {
            return this.f19304a.b(ImageDecoder.createSource(byteBuffer), i10, i11, iVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c implements j.k<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final g f19305a;

        @Override // j.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(@NonNull InputStream inputStream, @NonNull j.i iVar) {
            return this.f19305a.c(inputStream);
        }

        c(g gVar) {
            this.f19305a = gVar;
        }

        @Override // j.k
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public v<Drawable> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull j.i iVar) {
            return this.f19305a.b(ImageDecoder.createSource(e0.a.b(inputStream)), i10, i11, iVar);
        }
    }

    public static j.k<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, m.b bVar) {
        return new b(new g(list, bVar));
    }

    private boolean e(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    public static j.k<InputStream, Drawable> f(List<ImageHeaderParser> list, m.b bVar) {
        return new c(new g(list, bVar));
    }

    v<Drawable> b(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull j.i iVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new r.j(i10, i11, iVar));
        if (u.a.a(drawableDecodeDrawable)) {
            return new a(u.b.a(drawableDecodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    boolean c(InputStream inputStream) {
        return e(com.bumptech.glide.load.a.f(this.f19301a, inputStream, this.f19302b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(com.bumptech.glide.load.a.g(this.f19301a, byteBuffer));
    }

    private g(List<ImageHeaderParser> list, m.b bVar) {
        this.f19301a = list;
        this.f19302b = bVar;
    }
}
