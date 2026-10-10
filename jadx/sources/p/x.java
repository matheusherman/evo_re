package p;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class x<Model> implements o<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x<?> f17237a = new x<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a<Model> implements p<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<?> f17238a = new a<>();

        public static <T> a<T> a() {
            return (a<T>) f17238a;
        }

        @Deprecated
        public a() {
        }

        @Override // p.p
        @NonNull
        public o<Model, Model> c(s sVar) {
            return x.c();
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Model f17239a;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f17239a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super Model> aVar) {
            aVar.e(this.f17239a);
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        b(Model model) {
            this.f17239a = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    @Override // p.o
    public boolean a(@NonNull Model model) {
        return true;
    }

    public static <T> x<T> c() {
        return (x<T>) f17237a;
    }

    @Override // p.o
    public o.a<Model> b(@NonNull Model model, int i10, int i11, @NonNull j.i iVar) {
        return new o.a<>(new d0.d(model), new b(model));
    }

    @Deprecated
    public x() {
    }
}
