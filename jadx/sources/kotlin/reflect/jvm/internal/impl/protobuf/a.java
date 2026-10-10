package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class a implements q {
    protected int memoizedHashCode = 0;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static abstract class AbstractC0243a<BuilderType extends AbstractC0243a> implements q.a {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.protobuf.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        static final class C0244a extends FilterInputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f13625a;

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f13625a <= 0) {
                    return -1;
                }
                int i10 = super.read();
                if (i10 >= 0) {
                    this.f13625a--;
                }
                return i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j10) throws IOException {
                long jSkip = super.skip(Math.min(j10, this.f13625a));
                if (jSkip >= 0) {
                    this.f13625a = (int) (((long) this.f13625a) - jSkip);
                }
                return jSkip;
            }

            C0244a(InputStream inputStream, int i10) {
                super(inputStream);
                this.f13625a = i10;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f13625a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i10, int i11) throws IOException {
                int i12 = this.f13625a;
                if (i12 <= 0) {
                    return -1;
                }
                int i13 = super.read(bArr, i10, Math.min(i11, i12));
                if (i13 >= 0) {
                    this.f13625a -= i13;
                }
                return i13;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        public abstract BuilderType i(e eVar, g gVar);

        protected static w j(q qVar) {
            return new w(qVar);
        }
    }

    w b() {
        return new w(this);
    }

    public void f(OutputStream outputStream) throws IOException {
        int iE = e();
        f fVarJ = f.J(outputStream, f.u(f.v(iE) + iE));
        fVarJ.o0(iE);
        d(fVarJ);
        fVarJ.I();
    }
}
