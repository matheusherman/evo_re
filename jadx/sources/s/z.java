package s;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
interface z {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f18225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f18226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final m.b f18227c;

        private InputStream e() {
            return e0.a.g(e0.a.d(this.f18225a));
        }

        @Override // s.z
        public int a() {
            return com.bumptech.glide.load.a.c(this.f18226b, e0.a.d(this.f18225a), this.f18227c);
        }

        @Override // s.z
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.g(this.f18226b, e0.a.d(this.f18225a));
        }

        a(ByteBuffer byteBuffer, List<ImageHeaderParser> list, m.b bVar) {
            this.f18225a = byteBuffer;
            this.f18226b = list;
            this.f18227c = bVar;
        }

        @Override // s.z
        @Nullable
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(e(), null, options);
        }

        @Override // s.z
        public void c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.k f18228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final m.b f18229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<ImageHeaderParser> f18230c;

        @Override // s.z
        public int a() {
            return com.bumptech.glide.load.a.b(this.f18230c, this.f18228a.a(), this.f18229b);
        }

        @Override // s.z
        @Nullable
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.f18228a.a(), null, options);
        }

        @Override // s.z
        public void c() {
            this.f18228a.c();
        }

        @Override // s.z
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.f(this.f18230c, this.f18228a.a(), this.f18229b);
        }

        b(InputStream inputStream, List<ImageHeaderParser> list, m.b bVar) {
            this.f18229b = (m.b) e0.k.d(bVar);
            this.f18230c = (List) e0.k.d(list);
            this.f18228a = new com.bumptech.glide.load.data.k(inputStream, bVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(21)
    public static final class c implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m.b f18231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f18232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f18233c;

        @Override // s.z
        public int a() {
            return com.bumptech.glide.load.a.a(this.f18232b, this.f18233c, this.f18231a);
        }

        @Override // s.z
        @Nullable
        public Bitmap b(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.f18233c.a().getFileDescriptor(), null, options);
        }

        @Override // s.z
        public ImageHeaderParser.ImageType d() {
            return com.bumptech.glide.load.a.e(this.f18232b, this.f18233c, this.f18231a);
        }

        c(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, m.b bVar) {
            this.f18231a = (m.b) e0.k.d(bVar);
            this.f18232b = (List) e0.k.d(list);
            this.f18233c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // s.z
        public void c() {
        }
    }

    int a();

    @Nullable
    Bitmap b(BitmapFactory.Options options);

    void c();

    ImageHeaderParser.ImageType d();
}
