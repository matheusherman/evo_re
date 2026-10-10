package x1.f1.lb.streaming.server;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0006\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u00122\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0096\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0007J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010,\u001a\n **\u0004\u0018\u00010)0)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010+¨\u0006-"}, d2 = {"Lx1/f1/lb/streaming/server/g;", "Ljava/io/InputStream;", "inputStream", "<init>", "(Ljava/io/InputStream;)V", "", "read", "()I", "Lr8/z;", "close", "()V", "readlimit", "mark", "(I)V", "available", "", "b", "([B)I", "", "markSupported", "()Z", "", "n", "skip", "(J)J", "reset", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "off", "len", "([BII)I", "hashCode", "", "toString", "()Ljava/lang/String;", "a", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class g extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final InputStream inputStream;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger;

    @Override // java.io.InputStream
    public int read() {
        return this.inputStream.read();
    }

    public g(InputStream inputStream) {
        kotlin.jvm.internal.m.f(inputStream, "inputStream");
        this.inputStream = inputStream;
        this.logger = q6.c.d(g.class);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("InputStreamWrapper[{}] close", Integer.valueOf(this.inputStream.hashCode()), new Exception());
        }
        this.inputStream.close();
    }

    public boolean equals(Object other) {
        return this.inputStream.equals(other);
    }

    public int hashCode() {
        return this.inputStream.hashCode();
    }

    @Override // java.io.InputStream
    public void mark(int readlimit) {
        this.inputStream.mark(readlimit);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] b10) {
        return this.inputStream.read(b10);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.inputStream.reset();
    }

    @Override // java.io.InputStream
    public long skip(long n10) {
        return this.inputStream.skip(n10);
    }

    public String toString() {
        return this.inputStream.toString();
    }

    @Override // java.io.InputStream
    public int read(byte[] b10, int off, int len) {
        return this.inputStream.read(b10, off, len);
    }
}
