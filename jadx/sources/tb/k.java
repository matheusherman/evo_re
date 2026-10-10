package tb;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0007J'\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001d\u0010\u0007R\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001fR\u0014\u0010\u0002\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010$R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Ltb/k;", "Ltb/z;", "source", "<init>", "(Ltb/z;)V", "Lr8/z;", "b", "()V", "c", "Ltb/d;", "buffer", "", "offset", "byteCount", "d", "(Ltb/d;JJ)V", "", "name", "", "expected", "actual", "a", "(Ljava/lang/String;II)V", "sink", "D", "(Ltb/d;J)J", "Ltb/a0;", "g", "()Ltb/a0;", "close", "", "B", "section", "Ltb/t;", "Ltb/t;", "Ljava/util/zip/Inflater;", "Ljava/util/zip/Inflater;", "inflater", "Ltb/l;", "Ltb/l;", "inflaterSource", "Ljava/util/zip/CRC32;", "e", "Ljava/util/zip/CRC32;", "crc", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class k implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private byte section;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final buffer source;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Inflater inflater;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final l inflaterSource;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CRC32 crc;

    public k(z source) {
        kotlin.jvm.internal.m.f(source, "source");
        buffer bufferVar = new buffer(source);
        this.source = bufferVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new l(bufferVar, inflater);
        this.crc = new CRC32();
    }

    private final void a(String name, int expected, int actual) throws IOException {
        if (actual == expected) {
            return;
        }
        String str = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{name, Integer.valueOf(actual), Integer.valueOf(expected)}, 3));
        kotlin.jvm.internal.m.e(str, "format(this, *args)");
        throw new IOException(str);
    }

    private final void b() throws IOException {
        this.source.d0(10L);
        byte bK = this.source.bufferField.k(3L);
        boolean z10 = ((bK >> 1) & 1) == 1;
        if (z10) {
            d(this.source.bufferField, 0L, 10L);
        }
        a("ID1ID2", 8075, this.source.readShort());
        this.source.skip(8L);
        if (((bK >> 2) & 1) == 1) {
            this.source.d0(2L);
            if (z10) {
                d(this.source.bufferField, 0L, 2L);
            }
            long jT = this.source.bufferField.t() & 65535;
            this.source.d0(jT);
            if (z10) {
                d(this.source.bufferField, 0L, jT);
            }
            this.source.skip(jT);
        }
        if (((bK >> 3) & 1) == 1) {
            long jA = this.source.a((byte) 0);
            if (jA == -1) {
                throw new EOFException();
            }
            if (z10) {
                d(this.source.bufferField, 0L, jA + 1);
            }
            this.source.skip(jA + 1);
        }
        if (((bK >> 4) & 1) == 1) {
            long jA2 = this.source.a((byte) 0);
            if (jA2 == -1) {
                throw new EOFException();
            }
            if (z10) {
                d(this.source.bufferField, 0L, jA2 + 1);
            }
            this.source.skip(jA2 + 1);
        }
        if (z10) {
            a("FHCRC", this.source.d(), (short) this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void c() throws IOException {
        a("CRC", this.source.c(), (int) this.crc.getValue());
        a("ISIZE", this.source.c(), (int) this.inflater.getBytesWritten());
    }

    private final void d(d buffer, long offset, long byteCount) {
        u uVar = buffer.head;
        kotlin.jvm.internal.m.c(uVar);
        while (true) {
            int i10 = uVar.limit;
            int i11 = uVar.pos;
            if (offset < i10 - i11) {
                break;
            }
            offset -= (long) (i10 - i11);
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
        }
        while (byteCount > 0) {
            int i12 = (int) (((long) uVar.pos) + offset);
            int iMin = (int) Math.min(uVar.limit - i12, byteCount);
            this.crc.update(uVar.data, i12, iMin);
            byteCount -= (long) iMin;
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
            offset = 0;
        }
    }

    @Override // tb.z
    public long D(d sink, long byteCount) throws IOException {
        k kVar;
        kotlin.jvm.internal.m.f(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        if (this.section == 0) {
            b();
            this.section = (byte) 1;
        }
        if (this.section == 1) {
            long size = sink.getSize();
            long jD = this.inflaterSource.D(sink, byteCount);
            if (jD != -1) {
                d(sink, size, jD);
                return jD;
            }
            kVar = this;
            kVar.section = (byte) 2;
        } else {
            kVar = this;
        }
        if (kVar.section == 2) {
            c();
            kVar.section = (byte) 3;
            if (!kVar.source.L()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }

    @Override // tb.z
    /* JADX INFO: renamed from: g */
    public a0 getTimeout() {
        return this.source.getTimeout();
    }
}
