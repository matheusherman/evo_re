package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.Closeable;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001SB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010!\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\rH\u0087\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020#H\u0016¢\u0006\u0004\b)\u0010%J\u000f\u0010*\u001a\u00020&H\u0016¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020\rH\u0016¢\u0006\u0004\b+\u0010\u001cJ\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020&2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\r2\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010@\u001a\u0002092\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b@\u0010AJ\u001f\u0010B\u001a\u0002092\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u000209H\u0016¢\u0006\u0004\bD\u0010;J\u0017\u0010F\u001a\u0002092\u0006\u0010E\u001a\u00020\rH\u0016¢\u0006\u0004\bF\u0010=J\u000f\u0010G\u001a\u00020&H\u0016¢\u0006\u0004\bG\u0010(J\u000f\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bI\u0010JJ\u0017\u0010K\u001a\u00020H2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020\u000f2\u0006\u00106\u001a\u00020HH\u0016¢\u0006\u0004\bM\u0010NJ'\u0010O\u001a\u00020&2\u0006\u00106\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020&H\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010O\u001a\u00020&2\u0006\u00106\u001a\u00020QH\u0016¢\u0006\u0004\bO\u0010RJ\r\u0010S\u001a\u00020\u000f¢\u0006\u0004\bS\u0010\u0006J\u0017\u0010T\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\bT\u0010\u0011J\u0017\u0010V\u001a\u00020\u00002\u0006\u0010U\u001a\u00020,H\u0016¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u000209H\u0016¢\u0006\u0004\bY\u0010ZJ'\u0010]\u001a\u00020\u00002\u0006\u0010X\u001a\u0002092\u0006\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020&H\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010`\u001a\u00020\u00002\u0006\u0010_\u001a\u00020&H\u0016¢\u0006\u0004\b`\u0010aJ\u001f\u0010b\u001a\u00020\u00002\u0006\u0010X\u001a\u0002092\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bb\u0010cJ/\u0010d\u001a\u00020\u00002\u0006\u0010X\u001a\u0002092\u0006\u0010[\u001a\u00020&2\u0006\u0010\\\u001a\u00020&2\u0006\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010g\u001a\u00020\u00002\u0006\u0010f\u001a\u00020HH\u0016¢\u0006\u0004\bg\u0010hJ'\u0010i\u001a\u00020\u00002\u0006\u0010f\u001a\u00020H2\u0006\u0010\u0018\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020&H\u0016¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020&2\u0006\u0010f\u001a\u00020QH\u0016¢\u0006\u0004\bk\u0010RJ\u0017\u0010m\u001a\u00020\r2\u0006\u0010f\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010p\u001a\u00020\u00002\u0006\u0010o\u001a\u00020&H\u0016¢\u0006\u0004\bp\u0010aJ\u0017\u0010q\u001a\u00020\u00002\u0006\u0010*\u001a\u00020&H\u0016¢\u0006\u0004\bq\u0010aJ\u0017\u0010s\u001a\u00020\u00002\u0006\u0010r\u001a\u00020&H\u0016¢\u0006\u0004\bs\u0010aJ\u0017\u0010t\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\rH\u0016¢\u0006\u0004\bv\u0010uJ\u0017\u0010y\u001a\u00020x2\u0006\u0010w\u001a\u00020&H\u0000¢\u0006\u0004\by\u0010zJ\u001f\u0010{\u001a\u00020\u000f2\u0006\u0010f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b{\u0010|J\u001f\u0010}\u001a\u00020\r2\u0006\u00106\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b}\u0010~J+\u0010\u0081\u0001\u001a\u00020\r2\u0006\u0010o\u001a\u00020\u001d2\u0006\u0010\u007f\u001a\u00020\r2\u0007\u0010\u0080\u0001\u001a\u00020\rH\u0016¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001b\u0010\u0084\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020,H\u0016¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J#\u0010\u0086\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020,2\u0006\u0010\u007f\u001a\u00020\rH\u0016¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\u0011\u0010\u0088\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u0088\u0001\u0010\u0006J\u0011\u0010\u0089\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0089\u0001\u0010\fJ\u0011\u0010\u008a\u0001\u001a\u00020\u000fH\u0016¢\u0006\u0005\b\u008a\u0001\u0010\u0006J\u0013\u0010\u008c\u0001\u001a\u00030\u008b\u0001H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008d\u0001J\u001f\u0010\u0090\u0001\u001a\u00020\n2\n\u0010\u008f\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0096\u0002¢\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0011\u0010\u0092\u0001\u001a\u00020&H\u0016¢\u0006\u0005\b\u0092\u0001\u0010(J\u0011\u0010\u0093\u0001\u001a\u000209H\u0016¢\u0006\u0005\b\u0093\u0001\u0010;J\u000e\u0010r\u001a\u00020\u0000¢\u0006\u0005\br\u0010\u0094\u0001J\u0012\u0010\u0095\u0001\u001a\u00020\u0000H\u0016¢\u0006\u0006\b\u0095\u0001\u0010\u0094\u0001J\u000f\u0010\u0096\u0001\u001a\u00020,¢\u0006\u0005\b\u0096\u0001\u0010.J\u0018\u0010\u0097\u0001\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020&¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010\u009a\u0001\u001a\u0004\u0018\u00010x8\u0000@\u0000X\u0081\u000e¢\u0006\u0007\n\u0005\bS\u0010\u0099\u0001R/\u0010\u009d\u0001\u001a\u00020\r2\u0007\u0010\u009b\u0001\u001a\u00020\r8G@@X\u0086\u000e¢\u0006\u0015\n\u0005\bo\u0010\u009c\u0001\u001a\u0005\b\u009d\u0001\u0010\u001c\"\u0005\b\u009e\u0001\u0010\u0011R\u0017\u0010 \u0001\u001a\u00020\u00008VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010\u0094\u0001¨\u0006¡\u0001"}, d2 = {"Ltb/d;", "Ltb/f;", "Ltb/e;", "", "Ljava/nio/channels/ByteChannel;", "<init>", "()V", "Ljava/io/OutputStream;", "o", "()Ljava/io/OutputStream;", "", "L", "()Z", "", "byteCount", "Lr8/z;", "d0", "(J)V", "h", "(J)Z", "Ljava/io/InputStream;", "h0", "()Ljava/io/InputStream;", "out", "offset", "j", "(Ltb/d;JJ)Ltb/d;", "d", "()J", "", "readByte", "()B", "pos", "k", "(J)B", "", "readShort", "()S", "", "readInt", "()I", "t", "s", "g0", "Ltb/g;", "p", "()Ltb/g;", ExifInterface.LONGITUDE_EAST, "(J)Ltb/g;", "Ltb/q;", "options", "X", "(Ltb/q;)I", "Ltb/x;", "sink", "I", "(Ltb/x;)J", "", "v", "()Ljava/lang/String;", "x", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "U", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "u", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "Y", "limit", "O", "y", "", "K", "()[B", "a0", "(J)[B", "q", "([B)V", "read", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "a", "skip", "byteString", "G", "(Ltb/g;)Ltb/d;", TypedValues.Custom.S_STRING, "m0", "(Ljava/lang/String;)Ltb/d;", "beginIndex", "endIndex", "n0", "(Ljava/lang/String;II)Ltb/d;", "codePoint", "o0", "(I)Ltb/d;", "l0", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ltb/d;", "k0", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Ltb/d;", "source", "R", "([B)Ltb/d;", "Z", "([BII)Ltb/d;", "write", "Ltb/z;", "H", "(Ltb/z;)J", "b", "b0", "j0", "i", "i0", "c0", "(J)Ltb/d;", "e0", "minimumCapacity", "Ltb/u;", "F", "(I)Ltb/u;", "N", "(Ltb/d;J)V", "D", "(Ltb/d;J)J", "fromIndex", "toIndex", "l", "(BJJ)J", "targetBytes", "m", "(Ltb/g;)J", "n", "(Ltb/g;J)J", "flush", "isOpen", "close", "Ltb/a0;", "g", "()Ltb/a0;", "", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ltb/d;", "c", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "C", "(I)Ltb/g;", "Ltb/u;", "head", "<set-?>", "J", "size", "z", "e", "buffer", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class d implements f, e, Cloneable, ByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public u head;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long size;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001b¨\u0006\u001f"}, d2 = {"Ltb/d$a;", "Ljava/io/Closeable;", "<init>", "()V", "Lr8/z;", "close", "Ltb/d;", "a", "Ltb/d;", "buffer", "Ltb/u;", "b", "Ltb/u;", "getSegment$okio", "()Ltb/u;", "(Ltb/u;)V", "segment", "", "c", "J", "offset", "", "d", "[B", "data", "", "e", "I", "start", "f", "end", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public d buffer;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private u segment;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        public byte[] data;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public long offset = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int start = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        public int end = -1;

        public final void a(u uVar) {
            this.segment = uVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer == null) {
                throw new IllegalStateException("not attached to a buffer");
            }
            this.buffer = null;
            a(null);
            this.offset = -1L;
            this.data = null;
            this.start = -1;
            this.end = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"tb/d$b", "Ljava/io/InputStream;", "", "read", "()I", "", "sink", "offset", "byteCount", "([BII)I", "available", "Lr8/z;", "close", "()V", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class b extends InputStream {
        @Override // java.io.InputStream
        public int read() {
            if (d.this.getSize() > 0) {
                return d.this.readByte() & 255;
            }
            return -1;
        }

        b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(d.this.getSize(), Integer.MAX_VALUE);
        }

        public String toString() {
            return d.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] sink, int offset, int byteCount) {
            kotlin.jvm.internal.m.f(sink, "sink");
            return d.this.read(sink, offset, byteCount);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"tb/d$c", "Ljava/io/OutputStream;", "", "b", "Lr8/z;", "write", "(I)V", "", "data", "offset", "byteCount", "([BII)V", "flush", "()V", "close", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class c extends OutputStream {
        @Override // java.io.OutputStream
        public void write(int b10) {
            d.this.writeByte(b10);
        }

        c() {
        }

        public String toString() {
            return d.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(byte[] data, int offset, int byteCount) {
            kotlin.jvm.internal.m.f(data, "data");
            d.this.write(data, offset, byteCount);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }
    }

    public final u F(int minimumCapacity) {
        if (minimumCapacity < 1 || minimumCapacity > 8192) {
            throw new IllegalArgumentException("unexpected capacity");
        }
        u uVar = this.head;
        if (uVar != null) {
            kotlin.jvm.internal.m.c(uVar);
            u uVar2 = uVar.prev;
            kotlin.jvm.internal.m.c(uVar2);
            return (uVar2.limit + minimumCapacity > 8192 || !uVar2.owner) ? uVar2.c(v.c()) : uVar2;
        }
        u uVarC = v.c();
        this.head = uVarC;
        uVarC.prev = uVarC;
        uVarC.next = uVarC;
        return uVarC;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public d writeByte(int b10) {
        u uVarF = F(1);
        byte[] bArr = uVarF.data;
        int i10 = uVarF.limit;
        uVarF.limit = i10 + 1;
        bArr[i10] = (byte) b10;
        z(getSize() + 1);
        return this;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public d writeInt(int i10) {
        u uVarF = F(4);
        byte[] bArr = uVarF.data;
        int i11 = uVarF.limit;
        bArr[i11] = (byte) ((i10 >>> 24) & 255);
        bArr[i11 + 1] = (byte) ((i10 >>> 16) & 255);
        bArr[i11 + 2] = (byte) ((i10 >>> 8) & 255);
        bArr[i11 + 3] = (byte) (i10 & 255);
        uVarF.limit = i11 + 4;
        z(getSize() + 4);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public d writeShort(int s10) {
        u uVarF = F(2);
        byte[] bArr = uVarF.data;
        int i10 = uVarF.limit;
        bArr[i10] = (byte) ((s10 >>> 8) & 255);
        bArr[i10 + 1] = (byte) (s10 & 255);
        uVarF.limit = i10 + 2;
        z(getSize() + 2);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        kotlin.jvm.internal.m.f(sink, "sink");
        u uVar = this.head;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(sink.remaining(), uVar.limit - uVar.pos);
        sink.put(uVar.data, uVar.pos, iMin);
        int i10 = uVar.pos + iMin;
        uVar.pos = i10;
        this.size -= (long) iMin;
        if (i10 == uVar.limit) {
            this.head = uVar.b();
            v.b(uVar);
        }
        return iMin;
    }

    public final g C(int byteCount) {
        if (byteCount == 0) {
            return g.f19051d;
        }
        tb.b.b(getSize(), 0L, byteCount);
        u uVar = this.head;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < byteCount) {
            kotlin.jvm.internal.m.c(uVar);
            int i13 = uVar.limit;
            int i14 = uVar.pos;
            if (i13 == i14) {
                throw new AssertionError("s.limit == s.pos");
            }
            i11 += i13 - i14;
            i12++;
            uVar = uVar.next;
        }
        byte[][] bArr = new byte[i12][];
        int[] iArr = new int[i12 * 2];
        u uVar2 = this.head;
        int i15 = 0;
        while (i10 < byteCount) {
            kotlin.jvm.internal.m.c(uVar2);
            bArr[i15] = uVar2.data;
            i10 += uVar2.limit - uVar2.pos;
            iArr[i15] = Math.min(i10, byteCount);
            iArr[i15 + i12] = uVar2.pos;
            uVar2.shared = true;
            i15++;
            uVar2 = uVar2.next;
        }
        return new w(bArr, iArr);
    }

    @Override // tb.z
    public long D(d sink, long byteCount) {
        kotlin.jvm.internal.m.f(sink, "sink");
        if (byteCount < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (getSize() == 0) {
            return -1L;
        }
        if (byteCount > getSize()) {
            byteCount = getSize();
        }
        sink.N(this, byteCount);
        return byteCount;
    }

    @Override // tb.f
    public g E(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        if (byteCount < 4096) {
            return new g(a0(byteCount));
        }
        g gVarC = C((int) byteCount);
        skip(byteCount);
        return gVarC;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public d Q(g byteString) {
        kotlin.jvm.internal.m.f(byteString, "byteString");
        byteString.B(this, 0, byteString.x());
        return this;
    }

    @Override // tb.e
    public long H(z source) {
        kotlin.jvm.internal.m.f(source, "source");
        long j10 = 0;
        while (true) {
            long jD = source.D(this, 8192L);
            if (jD == -1) {
                return j10;
            }
            j10 += jD;
        }
    }

    @Override // tb.f
    public long I(x sink) {
        kotlin.jvm.internal.m.f(sink, "sink");
        long size = getSize();
        if (size > 0) {
            sink.N(this, size);
        }
        return size;
    }

    @Override // tb.f
    public boolean L() {
        return this.size == 0;
    }

    @Override // tb.x
    public void N(d source, long byteCount) {
        u uVar;
        kotlin.jvm.internal.m.f(source, "source");
        if (source == this) {
            throw new IllegalArgumentException("source == this");
        }
        tb.b.b(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            u uVar2 = source.head;
            kotlin.jvm.internal.m.c(uVar2);
            int i10 = uVar2.limit;
            u uVar3 = source.head;
            kotlin.jvm.internal.m.c(uVar3);
            if (byteCount < i10 - uVar3.pos) {
                u uVar4 = this.head;
                if (uVar4 != null) {
                    kotlin.jvm.internal.m.c(uVar4);
                    uVar = uVar4.prev;
                } else {
                    uVar = null;
                }
                if (uVar != null && uVar.owner) {
                    if ((((long) uVar.limit) + byteCount) - ((long) (uVar.shared ? 0 : uVar.pos)) <= 8192) {
                        u uVar5 = source.head;
                        kotlin.jvm.internal.m.c(uVar5);
                        uVar5.f(uVar, (int) byteCount);
                        source.z(source.getSize() - byteCount);
                        z(getSize() + byteCount);
                        return;
                    }
                }
                u uVar6 = source.head;
                kotlin.jvm.internal.m.c(uVar6);
                source.head = uVar6.e((int) byteCount);
            }
            u uVar7 = source.head;
            kotlin.jvm.internal.m.c(uVar7);
            long j10 = uVar7.limit - uVar7.pos;
            source.head = uVar7.b();
            u uVar8 = this.head;
            if (uVar8 == null) {
                this.head = uVar7;
                uVar7.prev = uVar7;
                uVar7.next = uVar7;
            } else {
                kotlin.jvm.internal.m.c(uVar8);
                u uVar9 = uVar8.prev;
                kotlin.jvm.internal.m.c(uVar9);
                uVar9.c(uVar7).a();
            }
            source.z(source.getSize() - j10);
            z(getSize() + j10);
            byteCount -= j10;
        }
    }

    @Override // tb.f
    public String O(long limit) throws EOFException {
        if (limit < 0) {
            throw new IllegalArgumentException(("limit < 0: " + limit).toString());
        }
        long j10 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (limit != LocationRequestCompat.PASSIVE_INTERVAL) {
            j10 = limit + 1;
        }
        long j11 = j10;
        long jL = l((byte) 10, 0L, j11);
        if (jL != -1) {
            return ub.a.b(this, jL);
        }
        if (j11 < getSize() && k(j11 - 1) == 13 && k(j11) == 10) {
            return ub.a.b(this, j11);
        }
        d dVar = new d();
        j(dVar, 0L, Math.min(32, getSize()));
        throw new EOFException("\\n not found: limit=" + Math.min(getSize(), limit) + " content=" + dVar.p().o() + (char) 8230);
    }

    @Override // tb.e
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source) {
        kotlin.jvm.internal.m.f(source, "source");
        return write(source, 0, source.length);
    }

    @Override // tb.f
    public String U(Charset charset) {
        kotlin.jvm.internal.m.f(charset, "charset");
        return u(this.size, charset);
    }

    @Override // tb.f
    public int X(q options) throws EOFException {
        kotlin.jvm.internal.m.f(options, "options");
        int iD = ub.a.d(this, options, false, 2, null);
        if (iD == -1) {
            return -1;
        }
        skip(options.getByteStrings()[iD].x());
        return iD;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public d write(byte[] source, int offset, int byteCount) {
        kotlin.jvm.internal.m.f(source, "source");
        long j10 = byteCount;
        tb.b.b(source.length, offset, j10);
        int i10 = byteCount + offset;
        while (offset < i10) {
            u uVarF = F(1);
            int iMin = Math.min(i10 - offset, 8192 - uVarF.limit);
            int i11 = offset + iMin;
            kotlin.collections.j.e(source, uVarF.data, uVarF.limit, offset, i11);
            uVarF.limit += iMin;
            offset = i11;
        }
        z(getSize() + j10);
        return this;
    }

    @Override // tb.f
    public byte[] a0(long byteCount) throws EOFException {
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (getSize() < byteCount) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) byteCount];
        q(bArr);
        return bArr;
    }

    @Override // tb.e
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public d f0(long v10) {
        boolean z10;
        if (v10 == 0) {
            return writeByte(48);
        }
        int i10 = 1;
        if (v10 < 0) {
            v10 = -v10;
            if (v10 < 0) {
                return T("-9223372036854775808");
            }
            z10 = true;
        } else {
            z10 = false;
        }
        if (v10 < 100000000) {
            if (v10 < 10000) {
                if (v10 >= 100) {
                    i10 = v10 < 1000 ? 3 : 4;
                } else if (v10 >= 10) {
                    i10 = 2;
                }
            } else if (v10 < 1000000) {
                i10 = v10 < 100000 ? 5 : 6;
            } else {
                i10 = v10 < 10000000 ? 7 : 8;
            }
        } else if (v10 < 1000000000000L) {
            if (v10 < 10000000000L) {
                i10 = v10 < 1000000000 ? 9 : 10;
            } else {
                i10 = v10 < 100000000000L ? 11 : 12;
            }
        } else if (v10 < 1000000000000000L) {
            if (v10 < 10000000000000L) {
                i10 = 13;
            } else {
                i10 = v10 < 100000000000000L ? 14 : 15;
            }
        } else if (v10 < 100000000000000000L) {
            i10 = v10 < 10000000000000000L ? 16 : 17;
        } else {
            i10 = v10 < 1000000000000000000L ? 18 : 19;
        }
        if (z10) {
            i10++;
        }
        u uVarF = F(i10);
        byte[] bArr = uVarF.data;
        int i11 = uVarF.limit + i10;
        while (v10 != 0) {
            long j10 = 10;
            i11--;
            bArr[i11] = ub.a.a()[(int) (v10 % j10)];
            v10 /= j10;
        }
        if (z10) {
            bArr[i11 - 1] = 45;
        }
        uVarF.limit += i10;
        z(getSize() + ((long) i10));
        return this;
    }

    @Override // tb.f
    public void d0(long byteCount) throws EOFException {
        if (this.size < byteCount) {
            throw new EOFException();
        }
    }

    @Override // tb.e
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public d W(long v10) {
        if (v10 == 0) {
            return writeByte(48);
        }
        long j10 = (v10 >>> 1) | v10;
        long j11 = j10 | (j10 >>> 2);
        long j12 = j11 | (j11 >>> 4);
        long j13 = j12 | (j12 >>> 8);
        long j14 = j13 | (j13 >>> 16);
        long j15 = j14 | (j14 >>> 32);
        long j16 = j15 - ((j15 >>> 1) & 6148914691236517205L);
        long j17 = ((j16 >>> 2) & 3689348814741910323L) + (j16 & 3689348814741910323L);
        long j18 = ((j17 >>> 4) + j17) & 1085102592571150095L;
        long j19 = j18 + (j18 >>> 8);
        long j20 = j19 + (j19 >>> 16);
        int i10 = (int) ((((j20 & 63) + ((j20 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        u uVarF = F(i10);
        byte[] bArr = uVarF.data;
        int i11 = uVarF.limit;
        for (int i12 = (i11 + i10) - 1; i12 >= i11; i12--) {
            bArr[i12] = ub.a.a()[(int) (15 & v10)];
            v10 >>>= 4;
        }
        uVarF.limit += i10;
        z(getSize() + ((long) i10));
        return this;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof d)) {
            return false;
        }
        d dVar = (d) other;
        if (getSize() != dVar.getSize()) {
            return false;
        }
        if (getSize() == 0) {
            return true;
        }
        u uVar = this.head;
        kotlin.jvm.internal.m.c(uVar);
        u uVar2 = dVar.head;
        kotlin.jvm.internal.m.c(uVar2);
        int i10 = uVar.pos;
        int i11 = uVar2.pos;
        long j10 = 0;
        while (j10 < getSize()) {
            long jMin = Math.min(uVar.limit - i10, uVar2.limit - i11);
            long j11 = 0;
            while (j11 < jMin) {
                int i12 = i10 + 1;
                int i13 = i11 + 1;
                if (uVar.data[i10] != uVar2.data[i11]) {
                    return false;
                }
                j11++;
                i10 = i12;
                i11 = i13;
            }
            if (i10 == uVar.limit) {
                uVar = uVar.next;
                kotlin.jvm.internal.m.c(uVar);
                i10 = uVar.pos;
            }
            if (i11 == uVar2.limit) {
                uVar2 = uVar2.next;
                kotlin.jvm.internal.m.c(uVar2);
                i11 = uVar2.pos;
            }
            j10 += jMin;
        }
        return true;
    }

    @Override // tb.z
    public a0 g() {
        return a0.f19021e;
    }

    @Override // tb.f
    public boolean h(long byteCount) {
        return this.size >= byteCount;
    }

    @Override // tb.f
    public InputStream h0() {
        return new b();
    }

    public int hashCode() {
        u uVar = this.head;
        if (uVar == null) {
            return 0;
        }
        int i10 = 1;
        do {
            int i11 = uVar.limit;
            for (int i12 = uVar.pos; i12 < i11; i12++) {
                i10 = (i10 * 31) + uVar.data[i12];
            }
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
        } while (uVar != this.head);
        return i10;
    }

    public final d i() {
        d dVar = new d();
        if (getSize() == 0) {
            return dVar;
        }
        u uVar = this.head;
        kotlin.jvm.internal.m.c(uVar);
        u uVarD = uVar.d();
        dVar.head = uVarD;
        uVarD.prev = uVarD;
        uVarD.next = uVarD;
        for (u uVar2 = uVar.next; uVar2 != uVar; uVar2 = uVar2.next) {
            u uVar3 = uVarD.prev;
            kotlin.jvm.internal.m.c(uVar3);
            kotlin.jvm.internal.m.c(uVar2);
            uVar3.c(uVar2.d());
        }
        dVar.z(getSize());
        return dVar;
    }

    public final d j(d out, long offset, long byteCount) {
        kotlin.jvm.internal.m.f(out, "out");
        long j10 = offset;
        tb.b.b(getSize(), j10, byteCount);
        if (byteCount != 0) {
            out.z(out.getSize() + byteCount);
            u uVar = this.head;
            while (true) {
                kotlin.jvm.internal.m.c(uVar);
                int i10 = uVar.limit;
                int i11 = uVar.pos;
                if (j10 < i10 - i11) {
                    break;
                }
                j10 -= (long) (i10 - i11);
                uVar = uVar.next;
            }
            u uVar2 = uVar;
            long j11 = byteCount;
            while (j11 > 0) {
                kotlin.jvm.internal.m.c(uVar2);
                u uVarD = uVar2.d();
                int i12 = uVarD.pos + ((int) j10);
                uVarD.pos = i12;
                uVarD.limit = Math.min(i12 + ((int) j11), uVarD.limit);
                u uVar3 = out.head;
                if (uVar3 == null) {
                    uVarD.prev = uVarD;
                    uVarD.next = uVarD;
                    out.head = uVarD;
                } else {
                    kotlin.jvm.internal.m.c(uVar3);
                    u uVar4 = uVar3.prev;
                    kotlin.jvm.internal.m.c(uVar4);
                    uVar4.c(uVarD);
                }
                j11 -= (long) (uVarD.limit - uVarD.pos);
                uVar2 = uVar2.next;
                j10 = 0;
            }
        }
        return this;
    }

    public d k0(String string, int beginIndex, int endIndex, Charset charset) {
        kotlin.jvm.internal.m.f(string, "string");
        kotlin.jvm.internal.m.f(charset, "charset");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        if (kotlin.jvm.internal.m.a(charset, ua.d.UTF_8)) {
            return n0(string, beginIndex, endIndex);
        }
        String strSubstring = string.substring(beginIndex, endIndex);
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes = strSubstring.getBytes(charset);
        kotlin.jvm.internal.m.e(bytes, "this as java.lang.String).getBytes(charset)");
        return write(bytes, 0, bytes.length);
    }

    public long l(byte b10, long fromIndex, long toIndex) {
        u uVar;
        int i10;
        long size = 0;
        if (0 > fromIndex || fromIndex > toIndex) {
            throw new IllegalArgumentException(("size=" + getSize() + " fromIndex=" + fromIndex + " toIndex=" + toIndex).toString());
        }
        if (toIndex > getSize()) {
            toIndex = getSize();
        }
        if (fromIndex == toIndex || (uVar = this.head) == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                uVar = uVar.prev;
                kotlin.jvm.internal.m.c(uVar);
                size -= (long) (uVar.limit - uVar.pos);
            }
            while (size < toIndex) {
                byte[] bArr = uVar.data;
                int iMin = (int) Math.min(uVar.limit, (((long) uVar.pos) + toIndex) - size);
                i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
                while (i10 < iMin) {
                    if (bArr[i10] != b10) {
                        i10++;
                    }
                }
                size += (long) (uVar.limit - uVar.pos);
                uVar = uVar.next;
                kotlin.jvm.internal.m.c(uVar);
                fromIndex = size;
            }
            return -1L;
        }
        while (true) {
            long j10 = ((long) (uVar.limit - uVar.pos)) + size;
            if (j10 > fromIndex) {
                break;
            }
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
            size = j10;
        }
        while (size < toIndex) {
            byte[] bArr2 = uVar.data;
            int iMin2 = (int) Math.min(uVar.limit, (((long) uVar.pos) + toIndex) - size);
            i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
            while (i10 < iMin2) {
                if (bArr2[i10] != b10) {
                    i10++;
                }
            }
            size += (long) (uVar.limit - uVar.pos);
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
            fromIndex = size;
        }
        return -1L;
        return ((long) (i10 - uVar.pos)) + size;
    }

    public d l0(String string, Charset charset) {
        kotlin.jvm.internal.m.f(string, "string");
        kotlin.jvm.internal.m.f(charset, "charset");
        return k0(string, 0, string.length(), charset);
    }

    public long m(g targetBytes) {
        kotlin.jvm.internal.m.f(targetBytes, "targetBytes");
        return n(targetBytes, 0L);
    }

    @Override // tb.e
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public d T(String string) {
        kotlin.jvm.internal.m.f(string, "string");
        return n0(string, 0, string.length());
    }

    public long n(g targetBytes, long fromIndex) {
        int i10;
        int i11;
        kotlin.jvm.internal.m.f(targetBytes, "targetBytes");
        long size = 0;
        if (fromIndex < 0) {
            throw new IllegalArgumentException(("fromIndex < 0: " + fromIndex).toString());
        }
        u uVar = this.head;
        if (uVar == null) {
            return -1L;
        }
        if (getSize() - fromIndex < fromIndex) {
            size = getSize();
            while (size > fromIndex) {
                uVar = uVar.prev;
                kotlin.jvm.internal.m.c(uVar);
                size -= (long) (uVar.limit - uVar.pos);
            }
            if (targetBytes.x() == 2) {
                byte bJ = targetBytes.j(0);
                byte bJ2 = targetBytes.j(1);
                while (size < getSize()) {
                    byte[] bArr = uVar.data;
                    i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
                    int i12 = uVar.limit;
                    while (true) {
                        if (i10 >= i12) {
                            size += (long) (uVar.limit - uVar.pos);
                            uVar = uVar.next;
                            kotlin.jvm.internal.m.c(uVar);
                            fromIndex = size;
                        } else {
                            byte b10 = bArr[i10];
                            if (b10 == bJ || b10 == bJ2) {
                                i11 = uVar.pos;
                            } else {
                                i10++;
                            }
                        }
                    }
                }
            } else {
                byte[] bArrP = targetBytes.p();
                while (size < getSize()) {
                    byte[] bArr2 = uVar.data;
                    i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
                    int i13 = uVar.limit;
                    while (true) {
                        if (i10 < i13) {
                            byte b11 = bArr2[i10];
                            int length = bArrP.length;
                            int i14 = 0;
                            while (true) {
                                if (i14 >= length) {
                                    i10++;
                                } else if (b11 == bArrP[i14]) {
                                    i11 = uVar.pos;
                                } else {
                                    i14++;
                                }
                            }
                        } else {
                            size += (long) (uVar.limit - uVar.pos);
                            uVar = uVar.next;
                            kotlin.jvm.internal.m.c(uVar);
                            fromIndex = size;
                        }
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j10 = ((long) (uVar.limit - uVar.pos)) + size;
            if (j10 > fromIndex) {
                break;
            }
            uVar = uVar.next;
            kotlin.jvm.internal.m.c(uVar);
            size = j10;
        }
        if (targetBytes.x() == 2) {
            byte bJ3 = targetBytes.j(0);
            byte bJ4 = targetBytes.j(1);
            while (size < getSize()) {
                byte[] bArr3 = uVar.data;
                i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
                int i15 = uVar.limit;
                while (true) {
                    if (i10 >= i15) {
                        size += (long) (uVar.limit - uVar.pos);
                        uVar = uVar.next;
                        kotlin.jvm.internal.m.c(uVar);
                        fromIndex = size;
                    } else {
                        byte b12 = bArr3[i10];
                        if (b12 == bJ3 || b12 == bJ4) {
                            i11 = uVar.pos;
                        } else {
                            i10++;
                        }
                    }
                }
            }
        } else {
            byte[] bArrP2 = targetBytes.p();
            while (size < getSize()) {
                byte[] bArr4 = uVar.data;
                i10 = (int) ((((long) uVar.pos) + fromIndex) - size);
                int i16 = uVar.limit;
                while (true) {
                    if (i10 < i16) {
                        byte b13 = bArr4[i10];
                        int length2 = bArrP2.length;
                        int i17 = 0;
                        while (true) {
                            if (i17 >= length2) {
                                i10++;
                            } else if (b13 == bArrP2[i17]) {
                                i11 = uVar.pos;
                            } else {
                                i17++;
                            }
                        }
                    } else {
                        size += (long) (uVar.limit - uVar.pos);
                        uVar = uVar.next;
                        kotlin.jvm.internal.m.c(uVar);
                        fromIndex = size;
                    }
                }
            }
        }
        return -1L;
        return ((long) (i10 - i11)) + size;
    }

    public d n0(String string, int beginIndex, int endIndex) {
        char cCharAt;
        kotlin.jvm.internal.m.f(string, "string");
        if (beginIndex < 0) {
            throw new IllegalArgumentException(("beginIndex < 0: " + beginIndex).toString());
        }
        if (endIndex < beginIndex) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + endIndex + " < " + beginIndex).toString());
        }
        if (endIndex > string.length()) {
            throw new IllegalArgumentException(("endIndex > string.length: " + endIndex + " > " + string.length()).toString());
        }
        while (beginIndex < endIndex) {
            char cCharAt2 = string.charAt(beginIndex);
            if (cCharAt2 < 128) {
                u uVarF = F(1);
                byte[] bArr = uVarF.data;
                int i10 = uVarF.limit - beginIndex;
                int iMin = Math.min(endIndex, 8192 - i10);
                int i11 = beginIndex + 1;
                bArr[beginIndex + i10] = (byte) cCharAt2;
                while (true) {
                    beginIndex = i11;
                    if (beginIndex >= iMin || (cCharAt = string.charAt(beginIndex)) >= 128) {
                        break;
                    }
                    i11 = beginIndex + 1;
                    bArr[beginIndex + i10] = (byte) cCharAt;
                }
                int i12 = uVarF.limit;
                int i13 = (i10 + beginIndex) - i12;
                uVarF.limit = i12 + i13;
                z(getSize() + ((long) i13));
            } else {
                if (cCharAt2 < 2048) {
                    u uVarF2 = F(2);
                    byte[] bArr2 = uVarF2.data;
                    int i14 = uVarF2.limit;
                    bArr2[i14] = (byte) ((cCharAt2 >> 6) | RsaOaep.DerParser.PRIVATE);
                    bArr2[i14 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    uVarF2.limit = i14 + 2;
                    z(getSize() + 2);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    u uVarF3 = F(3);
                    byte[] bArr3 = uVarF3.data;
                    int i15 = uVarF3.limit;
                    bArr3[i15] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    uVarF3.limit = i15 + 3;
                    z(getSize() + 3);
                } else {
                    int i16 = beginIndex + 1;
                    char cCharAt3 = i16 < endIndex ? string.charAt(i16) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || cCharAt3 >= 57344) {
                        writeByte(63);
                        beginIndex = i16;
                    } else {
                        int i17 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        u uVarF4 = F(4);
                        byte[] bArr4 = uVarF4.data;
                        int i18 = uVarF4.limit;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        uVarF4.limit = i18 + 4;
                        z(getSize() + 4);
                        beginIndex += 2;
                    }
                }
                beginIndex++;
            }
        }
        return this;
    }

    public OutputStream o() {
        return new c();
    }

    public d o0(int codePoint) {
        if (codePoint < 128) {
            writeByte(codePoint);
            return this;
        }
        if (codePoint < 2048) {
            u uVarF = F(2);
            byte[] bArr = uVarF.data;
            int i10 = uVarF.limit;
            bArr[i10] = (byte) ((codePoint >> 6) | RsaOaep.DerParser.PRIVATE);
            bArr[i10 + 1] = (byte) ((codePoint & 63) | 128);
            uVarF.limit = i10 + 2;
            z(getSize() + 2);
            return this;
        }
        if (55296 <= codePoint && codePoint < 57344) {
            writeByte(63);
            return this;
        }
        if (codePoint < 65536) {
            u uVarF2 = F(3);
            byte[] bArr2 = uVarF2.data;
            int i11 = uVarF2.limit;
            bArr2[i11] = (byte) ((codePoint >> 12) | 224);
            bArr2[i11 + 1] = (byte) (((codePoint >> 6) & 63) | 128);
            bArr2[i11 + 2] = (byte) ((codePoint & 63) | 128);
            uVarF2.limit = i11 + 3;
            z(getSize() + 3);
            return this;
        }
        if (codePoint > 1114111) {
            throw new IllegalArgumentException("Unexpected code point: 0x" + tb.b.i(codePoint));
        }
        u uVarF3 = F(4);
        byte[] bArr3 = uVarF3.data;
        int i12 = uVarF3.limit;
        bArr3[i12] = (byte) ((codePoint >> 18) | 240);
        bArr3[i12 + 1] = (byte) (((codePoint >> 12) & 63) | 128);
        bArr3[i12 + 2] = (byte) (((codePoint >> 6) & 63) | 128);
        bArr3[i12 + 3] = (byte) ((codePoint & 63) | 128);
        uVarF3.limit = i12 + 4;
        z(getSize() + 4);
        return this;
    }

    public void q(byte[] sink) throws EOFException {
        kotlin.jvm.internal.m.f(sink, "sink");
        int i10 = 0;
        while (i10 < sink.length) {
            int i11 = read(sink, i10, sink.length - i10);
            if (i11 == -1) {
                throw new EOFException();
            }
            i10 += i11;
        }
    }

    /* JADX INFO: renamed from: size, reason: from getter */
    public final long getSize() {
        return this.size;
    }

    @Override // tb.f
    public void skip(long byteCount) throws EOFException {
        while (byteCount > 0) {
            u uVar = this.head;
            if (uVar == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(byteCount, uVar.limit - uVar.pos);
            long j10 = iMin;
            z(getSize() - j10);
            byteCount -= j10;
            int i10 = uVar.pos + iMin;
            uVar.pos = i10;
            if (i10 == uVar.limit) {
                this.head = uVar.b();
                v.b(uVar);
            }
        }
    }

    public String u(long byteCount, Charset charset) throws EOFException {
        kotlin.jvm.internal.m.f(charset, "charset");
        if (byteCount < 0 || byteCount > 2147483647L) {
            throw new IllegalArgumentException(("byteCount: " + byteCount).toString());
        }
        if (this.size < byteCount) {
            throw new EOFException();
        }
        if (byteCount == 0) {
            return "";
        }
        u uVar = this.head;
        kotlin.jvm.internal.m.c(uVar);
        int i10 = uVar.pos;
        if (((long) i10) + byteCount > uVar.limit) {
            return new String(a0(byteCount), charset);
        }
        int i11 = (int) byteCount;
        String str = new String(uVar.data, i10, i11, charset);
        int i12 = uVar.pos + i11;
        uVar.pos = i12;
        this.size -= byteCount;
        if (i12 == uVar.limit) {
            this.head = uVar.b();
            v.b(uVar);
        }
        return str;
    }

    public String v() {
        return u(this.size, ua.d.UTF_8);
    }

    public String x(long byteCount) throws EOFException {
        return u(byteCount, ua.d.UTF_8);
    }

    public final void z(long j10) {
        this.size = j10;
    }

    public final g A() {
        if (getSize() <= 2147483647L) {
            return C((int) getSize());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + getSize()).toString());
    }

    @Override // tb.f
    public byte[] K() {
        return a0(getSize());
    }

    public final void a() throws EOFException {
        skip(getSize());
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return i();
    }

    public final long d() {
        long size = getSize();
        if (size == 0) {
            return 0L;
        }
        u uVar = this.head;
        kotlin.jvm.internal.m.c(uVar);
        u uVar2 = uVar.prev;
        kotlin.jvm.internal.m.c(uVar2);
        int i10 = uVar2.limit;
        if (i10 < 8192 && uVar2.owner) {
            return size - ((long) (i10 - uVar2.pos));
        }
        return size;
    }

    @Override // tb.f
    public long g0() throws EOFException {
        int i10;
        if (getSize() != 0) {
            int i11 = 0;
            long j10 = 0;
            boolean z10 = false;
            do {
                u uVar = this.head;
                kotlin.jvm.internal.m.c(uVar);
                byte[] bArr = uVar.data;
                int i12 = uVar.pos;
                int i13 = uVar.limit;
                while (i12 < i13) {
                    byte b10 = bArr[i12];
                    if (b10 >= 48 && b10 <= 57) {
                        i10 = b10 - 48;
                    } else if (b10 >= 97 && b10 <= 102) {
                        i10 = b10 - 87;
                    } else if (b10 >= 65 && b10 <= 70) {
                        i10 = b10 - 55;
                    } else {
                        if (i11 != 0) {
                            z10 = true;
                            break;
                        }
                        throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + tb.b.h(b10));
                    }
                    if (((-1152921504606846976L) & j10) == 0) {
                        j10 = (j10 << 4) | ((long) i10);
                        i12++;
                        i11++;
                    } else {
                        throw new NumberFormatException("Number too large: " + new d().W(j10).writeByte(b10).v());
                    }
                }
                if (i12 == i13) {
                    this.head = uVar.b();
                    v.b(uVar);
                } else {
                    uVar.pos = i12;
                }
                if (z10) {
                    break;
                }
            } while (this.head != null);
            z(getSize() - ((long) i11));
            return j10;
        }
        throw new EOFException();
    }

    public final byte k(long pos) {
        tb.b.b(getSize(), pos, 1L);
        u uVar = this.head;
        if (uVar != null) {
            if (getSize() - pos < pos) {
                long size = getSize();
                while (size > pos) {
                    uVar = uVar.prev;
                    kotlin.jvm.internal.m.c(uVar);
                    size -= (long) (uVar.limit - uVar.pos);
                }
                kotlin.jvm.internal.m.c(uVar);
                return uVar.data[(int) ((((long) uVar.pos) + pos) - size)];
            }
            long j10 = 0;
            while (true) {
                long j11 = ((long) (uVar.limit - uVar.pos)) + j10;
                if (j11 <= pos) {
                    uVar = uVar.next;
                    kotlin.jvm.internal.m.c(uVar);
                    j10 = j11;
                } else {
                    kotlin.jvm.internal.m.c(uVar);
                    return uVar.data[(int) ((((long) uVar.pos) + pos) - j10)];
                }
            }
        } else {
            kotlin.jvm.internal.m.c(null);
            throw null;
        }
    }

    public g p() {
        return E(getSize());
    }

    @Override // tb.f
    public byte readByte() {
        if (getSize() != 0) {
            u uVar = this.head;
            kotlin.jvm.internal.m.c(uVar);
            int i10 = uVar.pos;
            int i11 = uVar.limit;
            int i12 = i10 + 1;
            byte b10 = uVar.data[i10];
            z(getSize() - 1);
            if (i12 == i11) {
                this.head = uVar.b();
                v.b(uVar);
                return b10;
            }
            uVar.pos = i12;
            return b10;
        }
        throw new EOFException();
    }

    @Override // tb.f
    public int readInt() throws EOFException {
        if (getSize() >= 4) {
            u uVar = this.head;
            kotlin.jvm.internal.m.c(uVar);
            int i10 = uVar.pos;
            int i11 = uVar.limit;
            if (i11 - i10 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = uVar.data;
            int i12 = i10 + 3;
            int i13 = ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 2] & 255) << 8);
            int i14 = i10 + 4;
            int i15 = (bArr[i12] & 255) | i13;
            z(getSize() - 4);
            if (i14 == i11) {
                this.head = uVar.b();
                v.b(uVar);
                return i15;
            }
            uVar.pos = i14;
            return i15;
        }
        throw new EOFException();
    }

    @Override // tb.f
    public short readShort() throws EOFException {
        if (getSize() >= 2) {
            u uVar = this.head;
            kotlin.jvm.internal.m.c(uVar);
            int i10 = uVar.pos;
            int i11 = uVar.limit;
            if (i11 - i10 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = uVar.data;
            int i12 = i10 + 1;
            int i13 = (bArr[i10] & 255) << 8;
            int i14 = i10 + 2;
            int i15 = (bArr[i12] & 255) | i13;
            z(getSize() - 2);
            if (i14 == i11) {
                this.head = uVar.b();
                v.b(uVar);
            } else {
                uVar.pos = i14;
            }
            return (short) i15;
        }
        throw new EOFException();
    }

    public int s() {
        return tb.b.f(readInt());
    }

    public short t() {
        return tb.b.g(readShort());
    }

    public String toString() {
        return A().toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        kotlin.jvm.internal.m.f(source, "source");
        int iRemaining = source.remaining();
        int i10 = iRemaining;
        while (i10 > 0) {
            u uVarF = F(1);
            int iMin = Math.min(i10, 8192 - uVarF.limit);
            source.get(uVarF.data, uVarF.limit, iMin);
            i10 -= iMin;
            uVarF.limit += iMin;
        }
        this.size += (long) iRemaining;
        return iRemaining;
    }

    public int y() throws EOFException {
        int i10;
        int i11;
        int i12;
        if (getSize() != 0) {
            byte bK = k(0L);
            if ((bK & 128) == 0) {
                i10 = bK & 127;
                i11 = 1;
                i12 = 0;
            } else if ((bK & 224) == 192) {
                i10 = bK & 31;
                i11 = 2;
                i12 = 128;
            } else if ((bK & 240) == 224) {
                i10 = bK & 15;
                i11 = 3;
                i12 = 2048;
            } else if ((bK & 248) == 240) {
                i10 = bK & 7;
                i11 = 4;
                i12 = 65536;
            } else {
                skip(1L);
                return 65533;
            }
            long j10 = i11;
            if (getSize() >= j10) {
                for (int i13 = 1; i13 < i11; i13++) {
                    long j11 = i13;
                    byte bK2 = k(j11);
                    if ((bK2 & 192) == 128) {
                        i10 = (i10 << 6) | (bK2 & 63);
                    } else {
                        skip(j11);
                        return 65533;
                    }
                }
                skip(j10);
                if (i10 > 1114111) {
                    return 65533;
                }
                if ((55296 <= i10 && i10 < 57344) || i10 < i12) {
                    return 65533;
                }
                return i10;
            }
            throw new EOFException("size < " + i11 + ": " + getSize() + " (to read code point prefixed 0x" + tb.b.h(bK) + ')');
        }
        throw new EOFException();
    }

    @Override // tb.f
    public String Y() {
        return O(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public int read(byte[] sink, int offset, int byteCount) {
        kotlin.jvm.internal.m.f(sink, "sink");
        tb.b.b(sink.length, offset, byteCount);
        u uVar = this.head;
        if (uVar == null) {
            return -1;
        }
        int iMin = Math.min(byteCount, uVar.limit - uVar.pos);
        byte[] bArr = uVar.data;
        int i10 = uVar.pos;
        kotlin.collections.j.e(bArr, sink, offset, i10, i10 + iMin);
        uVar.pos += iMin;
        z(getSize() - ((long) iMin));
        if (uVar.pos == uVar.limit) {
            this.head = uVar.b();
            v.b(uVar);
        }
        return iMin;
    }

    @Override // tb.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // tb.f, tb.e
    public d e() {
        return this;
    }

    @Override // tb.e, tb.x, java.io.Flushable
    public void flush() {
    }
}
