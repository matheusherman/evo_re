package p;

import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class b<Data> implements o<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0331b<Data> f17146a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a implements p<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: p.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0330a implements InterfaceC0331b<ByteBuffer> {
            C0330a() {
            }

            @Override // p.b.InterfaceC0331b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // p.b.InterfaceC0331b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // p.p
        @NonNull
        public o<byte[], ByteBuffer> c(@NonNull s sVar) {
            return new b(new C0330a());
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: renamed from: p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0331b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f17148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0331b<Data> f17149b;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<Data> a() {
            return this.f17149b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super Data> aVar) {
            aVar.e(this.f17149b.b(this.f17148a));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        c(byte[] bArr, InterfaceC0331b<Data> interfaceC0331b) {
            this.f17148a = bArr;
            this.f17149b = interfaceC0331b;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d implements p<byte[], InputStream> {

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class a implements InterfaceC0331b<InputStream> {
            a() {
            }

            @Override // p.b.InterfaceC0331b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // p.b.InterfaceC0331b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // p.p
        @NonNull
        public o<byte[], InputStream> c(@NonNull s sVar) {
            return new b(new a());
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(@NonNull byte[] bArr, int i10, int i11, @NonNull j.i iVar) {
        return new o.a<>(new d0.d(bArr), new c(bArr, this.f17146a));
    }

    public b(InterfaceC0331b<Data> interfaceC0331b) {
        this.f17146a = interfaceC0331b;
    }
}
