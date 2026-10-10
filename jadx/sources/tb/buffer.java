package tb;

import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: renamed from: tb.t, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020,H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020,2\u0006\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0016¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u000204H\u0016¢\u0006\u0004\b7\u00106J\u000f\u00108\u001a\u00020\u001cH\u0016¢\u0006\u0004\b8\u00109J\u000f\u0010:\u001a\u00020\u001cH\u0016¢\u0006\u0004\b:\u00109J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010<J\u0017\u0010=\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b=\u0010\u0011J\u0017\u0010?\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u0014H\u0016¢\u0006\u0004\b?\u0010@J'\u0010>\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u00142\u0006\u0010A\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010CJ\u000f\u0010E\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u000f\u0010G\u001a\u00020\fH\u0016¢\u0006\u0004\bG\u0010\u000eJ\u000f\u0010H\u001a\u00020\u000fH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020,H\u0016¢\u0006\u0004\bM\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b?\u0010NR\u0014\u0010P\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010OR\u0016\u0010R\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b:\u0010QR\u001b\u0010V\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\bU\u0010I\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Ltb/t;", "Ltb/f;", "Ltb/z;", "source", "<init>", "(Ltb/z;)V", "Ltb/d;", "sink", "", "byteCount", "D", "(Ltb/d;J)J", "", "L", "()Z", "Lr8/z;", "d0", "(J)V", "h", "(J)Z", "", "readByte", "()B", "Ltb/g;", ExifInterface.LONGITUDE_EAST, "(J)Ltb/g;", "Ltb/q;", "options", "", "X", "(Ltb/q;)I", "", "K", "()[B", "a0", "(J)[B", "Ljava/nio/ByteBuffer;", "read", "(Ljava/nio/ByteBuffer;)I", "Ltb/x;", "I", "(Ltb/x;)J", "Ljava/nio/charset/Charset;", "charset", "", "U", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "Y", "()Ljava/lang/String;", "limit", "O", "(J)Ljava/lang/String;", "", "readShort", "()S", "d", "readInt", "()I", "c", "g0", "()J", "skip", "b", "a", "(B)J", "fromIndex", "toIndex", "(BJJ)J", "Ljava/io/InputStream;", "h0", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Ltb/a0;", "g", "()Ltb/a0;", "toString", "Ltb/z;", "Ltb/d;", "bufferField", "Z", "closed", "e", "()Ltb/d;", "getBuffer$annotations", "buffer", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class buffer implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z source;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final d bufferField;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* JADX INFO: renamed from: tb.t$a */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"tb/t$a", "Ljava/io/InputStream;", "", "read", "()I", "", "data", "offset", "byteCount", "([BII)I", "available", "Lr8/z;", "close", "()V", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a extends InputStream {
        @Override // java.io.InputStream
        public int read() throws IOException {
            buffer bufferVar = buffer.this;
            if (bufferVar.closed) {
                throw new IOException("closed");
            }
            if (bufferVar.bufferField.getSize() == 0) {
                buffer bufferVar2 = buffer.this;
                if (bufferVar2.source.D(bufferVar2.bufferField, 8192L) == -1) {
                    return -1;
                }
            }
            return buffer.this.bufferField.readByte() & 255;
        }

        a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            buffer bufferVar = buffer.this;
            if (bufferVar.closed) {
                throw new IOException("closed");
            }
            return (int) Math.min(bufferVar.bufferField.getSize(), Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EOFException {
            buffer.this.close();
        }

        public String toString() {
            return buffer.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] data, int offset, int byteCount) throws IOException {
            kotlin.jvm.internal.m.f(data, "data");
            if (!buffer.this.closed) {
                b.b(data.length, offset, byteCount);
                if (buffer.this.bufferField.getSize() == 0) {
                    buffer bufferVar = buffer.this;
                    if (bufferVar.source.D(bufferVar.bufferField, 8192L) == -1) {
                        return -1;
                    }
                }
                return buffer.this.bufferField.read(data, offset, byteCount);
            }
            throw new IOException("closed");
        }
    }

    public buffer(z source) {
        kotlin.jvm.internal.m.f(source, "source");
        this.source = source;
        this.bufferField = new d();
    }

    @Override // tb.z
    public long D(d sink, long byteCount) {
        kotlin.jvm.internal.m.f(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (this.bufferField.getSize() == 0 && this.source.D(this.bufferField, 8192L) == -1) {
            return -1L;
        }
        return this.bufferField.D(sink, Math.min(byteCount, this.bufferField.getSize()));
    }

    @Override // tb.f
    public long I(x sink) {
        kotlin.jvm.internal.m.f(sink, "sink");
        long j10 = 0;
        while (this.source.D(this.bufferField, 8192L) != -1) {
            long jD = this.bufferField.d();
            if (jD > 0) {
                j10 += jD;
                sink.N(this.bufferField, jD);
            }
        }
        if (this.bufferField.getSize() <= 0) {
            return j10;
        }
        long size = j10 + this.bufferField.getSize();
        d dVar = this.bufferField;
        sink.N(dVar, dVar.getSize());
        return size;
    }

    @Override // tb.f
    public byte[] K() {
        this.bufferField.H(this.source);
        return this.bufferField.K();
    }

    @Override // tb.f
    public boolean L() {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        return this.bufferField.L() && this.source.D(this.bufferField, 8192L) == -1;
    }

    @Override // tb.f
    public String O(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j10 = limit == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : limit + 1;
        long jB = b((byte) 10, 0L, j10);
        if (jB != -1) {
            return ub.a.b(this.bufferField, jB);
        }
        if (j10 < LocationRequestCompat.PASSIVE_INTERVAL && h(j10) && this.bufferField.k(j10 - 1) == 13 && h(1 + j10) && this.bufferField.k(j10) == 10) {
            return ub.a.b(this.bufferField, j10);
        }
        d dVar = new d();
        d dVar2 = this.bufferField;
        dVar2.j(dVar, 0L, Math.min(32, dVar2.getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.getSize(), limit) + " content=" + dVar.p().o() + (char) 8230);
    }

    @Override // tb.f
    public String U(Charset charset) {
        kotlin.jvm.internal.m.f(charset, "charset");
        this.bufferField.H(this.source);
        return this.bufferField.U(charset);
    }

    @Override // tb.f
    public int X(q options) throws EOFException {
        kotlin.jvm.internal.m.f(options, "options");
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        do {
            int iC = ub.a.c(this.bufferField, options, true);
            if (iC != -2) {
                if (iC == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings()[iC].x());
                return iC;
            }
        } while (this.source.D(this.bufferField, 8192L) != -1);
        return -1;
    }

    public long a(byte b10) {
        return b(b10, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public long b(byte b10, long fromIndex, long toIndex) {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        long jMax = fromIndex;
        while (jMax < toIndex) {
            byte b11 = b10;
            long j10 = toIndex;
            long jL = this.bufferField.l(b11, jMax, j10);
            if (jL != -1) {
                return jL;
            }
            long size = this.bufferField.getSize();
            if (size >= j10 || this.source.D(this.bufferField, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b10 = b11;
            toIndex = j10;
        }
        return -1L;
    }

    public int c() throws EOFException {
        d0(4L);
        return this.bufferField.s();
    }

    @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws EOFException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.a();
    }

    public short d() throws EOFException {
        d0(2L);
        return this.bufferField.t();
    }

    @Override // tb.f, tb.e
    /* JADX INFO: renamed from: e, reason: from getter */
    public d getBufferField() {
        return this.bufferField;
    }

    @Override // tb.z
    /* JADX INFO: renamed from: g */
    public a0 getTimeout() {
        return this.source.getTimeout();
    }

    @Override // tb.f
    public long g0() throws EOFException {
        d0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!h(i11)) {
                break;
            }
            byte bK = this.bufferField.k(i10);
            if ((bK < 48 || bK > 57) && ((bK < 97 || bK > 102) && (bK < 65 || bK > 70))) {
                if (i10 != 0) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Expected leading [0-9a-fA-F] character but was 0x");
                String string = Integer.toString(bK, ua.a.a(ua.a.a(16)));
                kotlin.jvm.internal.m.e(string, "toString(this, checkRadix(radix))");
                sb2.append(string);
                throw new NumberFormatException(sb2.toString());
            }
            i10 = i11;
        }
        return this.bufferField.g0();
    }

    @Override // tb.f
    public boolean h(long byteCount) {
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (this.bufferField.getSize() < byteCount) {
            if (this.source.D(this.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // tb.f
    public InputStream h0() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.m.f(sink, "sink");
        if (this.bufferField.getSize() == 0 && this.source.D(this.bufferField, 8192L) == -1) {
            return -1;
        }
        return this.bufferField.read(sink);
    }

    @Override // tb.f
    public byte readByte() throws EOFException {
        d0(1L);
        return this.bufferField.readByte();
    }

    @Override // tb.f
    public int readInt() throws EOFException {
        d0(4L);
        return this.bufferField.readInt();
    }

    @Override // tb.f
    public short readShort() throws EOFException {
        d0(2L);
        return this.bufferField.readShort();
    }

    @Override // tb.f
    public void skip(long byteCount) throws EOFException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        }
        while (byteCount > 0) {
            if (this.bufferField.getSize() == 0 && this.source.D(this.bufferField, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(byteCount, this.bufferField.getSize());
            this.bufferField.skip(jMin);
            byteCount -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // tb.f
    public g E(long byteCount) throws EOFException {
        d0(byteCount);
        return this.bufferField.E(byteCount);
    }

    @Override // tb.f
    public byte[] a0(long byteCount) throws EOFException {
        d0(byteCount);
        return this.bufferField.a0(byteCount);
    }

    @Override // tb.f
    public void d0(long byteCount) throws EOFException {
        if (h(byteCount)) {
        } else {
            throw new EOFException();
        }
    }

    @Override // tb.f
    public String Y() {
        return O(LocationRequestCompat.PASSIVE_INTERVAL);
    }
}
