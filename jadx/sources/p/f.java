package p;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f<DataT> implements o<Integer, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<DataT> f17159b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements p<Integer, AssetFileDescriptor>, e<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17160a;

        @Override // p.f.e
        public Class<AssetFileDescriptor> a() {
            return AssetFileDescriptor.class;
        }

        @Override // p.p
        @NonNull
        public o<Integer, AssetFileDescriptor> c(@NonNull s sVar) {
            return new f(this.f17160a, this);
        }

        a(Context context) {
            this.f17160a = context;
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void close(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor b(@Nullable Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResourceFd(i10);
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements p<Integer, Drawable>, e<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17161a;

        @Override // p.f.e
        public Class<Drawable> a() {
            return Drawable.class;
        }

        @Override // p.p
        @NonNull
        public o<Integer, Drawable> c(@NonNull s sVar) {
            return new f(this.f17161a, this);
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable b(@Nullable Resources.Theme theme, Resources resources, int i10) {
            return u.h.a(this.f17161a, i10, theme);
        }

        b(Context context) {
            this.f17161a = context;
        }

        @Override // p.p
        public void d() {
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void close(Drawable drawable) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class c implements p<Integer, InputStream>, e<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17162a;

        @Override // p.f.e
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // p.p
        @NonNull
        public o<Integer, InputStream> c(@NonNull s sVar) {
            return new f(this.f17162a, this);
        }

        c(Context context) {
            this.f17162a = context;
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void close(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // p.f.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream b(@Nullable Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResource(i10);
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Resources.Theme f17163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Resources f17164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final e<DataT> f17165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f17166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private DataT f17167e;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.f17165c.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            DataT datat = this.f17167e;
            if (datat != null) {
                try {
                    this.f17165c.close(datat);
                } catch (IOException unused) {
                }
            }
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [DataT, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super DataT> aVar) {
            try {
                DataT datatB = this.f17165c.b(this.f17163a, this.f17164b, this.f17166d);
                this.f17167e = datatB;
                aVar.e(datatB);
            } catch (Resources.NotFoundException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        d(@Nullable Resources.Theme theme, Resources resources, e<DataT> eVar, int i10) {
            this.f17163a = theme;
            this.f17164b = resources;
            this.f17165c = eVar;
            this.f17166d = i10;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private interface e<DataT> {
        Class<DataT> a();

        DataT b(@Nullable Resources.Theme theme, Resources resources, int i10);

        void close(DataT datat);
    }

    @Override // p.o
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Integer num) {
        return true;
    }

    public static p<Integer, AssetFileDescriptor> c(Context context) {
        return new a(context);
    }

    public static p<Integer, Drawable> e(Context context) {
        return new b(context);
    }

    public static p<Integer, InputStream> g(Context context) {
        return new c(context);
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(@NonNull Integer num, int i10, int i11, @NonNull j.i iVar) {
        Resources.Theme theme = (Resources.Theme) iVar.c(u.k.f19308b);
        return new o.a<>(new d0.d(num), new d(theme, theme != null ? theme.getResources() : this.f17158a.getResources(), this.f17159b, num.intValue()));
    }

    f(Context context, e<DataT> eVar) {
        this.f17158a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f17159b = eVar;
    }
}
