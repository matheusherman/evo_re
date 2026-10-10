package r4;

import com.koushikdutta.async.l;
import com.koushikdutta.async.n;
import com.koushikdutta.async.t;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends g {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f17829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected CRC32 f17830j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements t.j<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f17832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n f17833c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ t f17834d;

        /* JADX INFO: renamed from: r4.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class C0341a implements t.j<byte[]> {

            /* JADX INFO: renamed from: r4.f$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            class C0342a implements t.j<byte[]> {
                C0342a() {
                }

                @Override // com.koushikdutta.async.t.j
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(byte[] bArr) {
                    a aVar = a.this;
                    if (aVar.f17832b) {
                        f.this.f17830j.update(bArr, 0, bArr.length);
                    }
                    a.this.e();
                }
            }

            C0341a() {
            }

            @Override // com.koushikdutta.async.t.j
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                a aVar = a.this;
                if (aVar.f17832b) {
                    f.this.f17830j.update(bArr, 0, 2);
                }
                a.this.f17834d.b(f.y(bArr, 0, ByteOrder.LITTLE_ENDIAN) & 65535, new C0342a());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class b implements o4.b {
            b() {
            }

            @Override // o4.b
            public void i(n nVar, l lVar) {
                if (a.this.f17832b) {
                    while (lVar.C() > 0) {
                        ByteBuffer byteBufferB = lVar.B();
                        f.this.f17830j.update(byteBufferB.array(), byteBufferB.arrayOffset() + byteBufferB.position(), byteBufferB.remaining());
                        l.y(byteBufferB);
                    }
                }
                lVar.z();
                a.this.d();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        class c implements t.j<byte[]> {
            c() {
            }

            @Override // com.koushikdutta.async.t.j
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(byte[] bArr) {
                if (((short) f.this.f17830j.getValue()) != f.y(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                    f.this.w(new IOException("CRC mismatch"));
                    return;
                }
                f.this.f17830j.reset();
                a aVar = a.this;
                f fVar = f.this;
                fVar.f17829i = false;
                fVar.x(aVar.f17833c);
            }
        }

        a(n nVar, t tVar) {
            this.f17833c = nVar;
            this.f17834d = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            if (this.f17832b) {
                this.f17834d.b(2, new c());
                return;
            }
            f fVar = f.this;
            fVar.f17829i = false;
            fVar.x(this.f17833c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            t tVar = new t(this.f17833c);
            b bVar = new b();
            int i10 = this.f17831a;
            if ((i10 & 8) != 0) {
                tVar.c((byte) 0, bVar);
            } else if ((i10 & 16) != 0) {
                tVar.c((byte) 0, bVar);
            } else {
                d();
            }
        }

        @Override // com.koushikdutta.async.t.j
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            short sY = f.y(bArr, 0, ByteOrder.LITTLE_ENDIAN);
            if (sY != -29921) {
                f.this.w(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", Short.valueOf(sY))));
                this.f17833c.e(new o4.b.a());
                return;
            }
            byte b10 = bArr[3];
            this.f17831a = b10;
            boolean z10 = (b10 & 2) != 0;
            this.f17832b = z10;
            if (z10) {
                f.this.f17830j.update(bArr, 0, bArr.length);
            }
            if ((this.f17831a & 4) != 0) {
                this.f17834d.b(2, new C0341a());
            } else {
                e();
            }
        }
    }

    public f() {
        super(new Inflater(true));
        this.f17829i = true;
        this.f17830j = new CRC32();
    }

    static short y(byte[] bArr, int i10, ByteOrder byteOrder) {
        int i11;
        byte b10;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i11 = bArr[i10] << 8;
            b10 = bArr[i10 + 1];
        } else {
            i11 = bArr[i10 + 1] << 8;
            b10 = bArr[i10];
        }
        return (short) ((b10 & 255) | i11);
    }

    @Override // r4.g, com.koushikdutta.async.q, o4.b
    public void i(n nVar, l lVar) {
        if (!this.f17829i) {
            super.i(nVar, lVar);
        } else {
            t tVar = new t(nVar);
            tVar.b(10, new a(nVar, tVar));
        }
    }
}
