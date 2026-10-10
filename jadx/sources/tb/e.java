package tb;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH&¢\u0006\u0004\b\t\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u000bH&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bH&¢\u0006\u0004\b\u001b\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bH&¢\u0006\u0004\b\u001d\u0010\u0019J\u0017\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0010H&¢\u0006\u0004\b!\u0010 J\u000f\u0010#\u001a\u00020\"H&¢\u0006\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'\u0082\u0001\u0002%)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006*À\u0006\u0001"}, d2 = {"Ltb/e;", "Ltb/x;", "Ljava/nio/channels/WritableByteChannel;", "Ltb/g;", "byteString", "Q", "(Ltb/g;)Ltb/e;", "", "source", "write", "([B)Ltb/e;", "", "offset", "byteCount", "([BII)Ltb/e;", "Ltb/z;", "", "H", "(Ltb/z;)J", "", TypedValues.Custom.S_STRING, ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ltb/e;", "b", "writeByte", "(I)Ltb/e;", "s", "writeShort", "i", "writeInt", "v", "f0", "(J)Ltb/e;", ExifInterface.LONGITUDE_WEST, "Lr8/z;", "flush", "()V", "Ltb/d;", "e", "()Ltb/d;", "buffer", "Ltb/s;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface e extends x, WritableByteChannel {
    long H(z source);

    e Q(g byteString);

    e T(String string);

    e W(long v10);

    d e();

    e f0(long v10);

    @Override // tb.x, java.io.Flushable
    void flush();

    e write(byte[] source);

    e write(byte[] source, int offset, int byteCount);

    e writeByte(int b10);

    e writeInt(int i10);

    e writeShort(int s10);
}
