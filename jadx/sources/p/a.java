package p;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a<Data> implements o<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f17141c = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f17142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0329a<Data> f17143b;

    /* JADX INFO: renamed from: p.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0329a<Data> {
        com.bumptech.glide.load.data.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b implements p<Uri, AssetFileDescriptor>, InterfaceC0329a<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f17144a;

        @Override // p.a.InterfaceC0329a
        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.h(assetManager, str);
        }

        @Override // p.p
        @NonNull
        public o<Uri, AssetFileDescriptor> c(s sVar) {
            return new a(this.f17144a, this);
        }

        public b(AssetManager assetManager) {
            this.f17144a = assetManager;
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c implements p<Uri, InputStream>, InterfaceC0329a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f17145a;

        @Override // p.a.InterfaceC0329a
        public com.bumptech.glide.load.data.d<InputStream> a(AssetManager assetManager, String str) {
            return new com.bumptech.glide.load.data.m(assetManager, str);
        }

        @Override // p.p
        @NonNull
        public o<Uri, InputStream> c(s sVar) {
            return new a(this.f17145a, this);
        }

        public c(AssetManager assetManager) {
            this.f17145a = assetManager;
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public a(AssetManager assetManager, InterfaceC0329a<Data> interfaceC0329a) {
        this.f17142a = assetManager;
        this.f17143b = interfaceC0329a;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        return new o.a<>(new d0.d(uri), this.f17143b.a(this.f17142a, uri.toString().substring(f17141c)));
    }
}
