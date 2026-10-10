package p;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class e<Model, Data> implements o<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Data> f17152a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<Data> {
        Class<Data> a();

        Data b(String str);

        void close(Data data);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f17154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f17155c;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17154b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f17154b.close(this.f17155c);
            } catch (IOException unused) {
            }
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super Data> aVar) {
            try {
                Data dataB = this.f17154b.b(this.f17153a);
                this.f17155c = dataB;
                aVar.e(dataB);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        b(String str, a<Data> aVar) {
            this.f17153a = str;
            this.f17154b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class c<Model> implements p<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<InputStream> f17156a = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements a<InputStream> {
            a() {
            }

            @Override // p.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // p.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public InputStream b(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // p.e.a
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void close(InputStream inputStream) throws IOException {
                inputStream.close();
            }
        }

        @Override // p.p
        @NonNull
        public o<Model, InputStream> c(@NonNull s sVar) {
            return new e(this.f17156a);
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    public o.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull j.i iVar) {
        return new o.a<>(new d0.d(model), new b(model.toString(), this.f17152a));
    }

    public e(a<Data> aVar) {
        this.f17152a = aVar;
    }

    @Override // p.o
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }
}
