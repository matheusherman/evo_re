package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.InputStream;
import s.d0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d0 f1396a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m.b f1397a;

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<InputStream> b(InputStream inputStream) {
            return new k(inputStream, this.f1397a);
        }

        public a(m.b bVar) {
            this.f1397a = bVar;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f1396a.c();
    }

    public void c() {
        this.f1396a.b();
    }

    @Override // com.bumptech.glide.load.data.e
    @NonNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public InputStream a() {
        this.f1396a.reset();
        return this.f1396a;
    }

    public k(InputStream inputStream, m.b bVar) {
        d0 d0Var = new d0(inputStream, bVar);
        this.f1396a = d0Var;
        d0Var.mark(5242880);
    }
}
