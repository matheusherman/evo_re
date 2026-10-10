package tb;

import androidx.exifinterface.media.ExifInterface;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\nJ\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020)2\u0006\u0010,\u001a\u00020\u0006H&¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020)2\u0006\u00100\u001a\u00020/H&¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H&¢\u0006\u0004\b4\u00105R\u0014\u00109\u001a\u0002068&X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u00108\u0082\u0001\u00026:ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006;À\u0006\u0001"}, d2 = {"Ltb/f;", "Ltb/z;", "Ljava/nio/channels/ReadableByteChannel;", "", "L", "()Z", "", "byteCount", "Lr8/z;", "d0", "(J)V", "h", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "", "readInt", "()I", "g0", "()J", "skip", "Ltb/g;", ExifInterface.LONGITUDE_EAST, "(J)Ltb/g;", "Ltb/q;", "options", "X", "(Ltb/q;)I", "", "K", "()[B", "a0", "(J)[B", "Ltb/x;", "sink", "I", "(Ltb/x;)J", "", "Y", "()Ljava/lang/String;", "limit", "O", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "U", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/io/InputStream;", "h0", "()Ljava/io/InputStream;", "Ltb/d;", "e", "()Ltb/d;", "buffer", "Ltb/t;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface f extends z, ReadableByteChannel {
    g E(long byteCount);

    long I(x sink);

    byte[] K();

    boolean L();

    String O(long limit);

    String U(Charset charset);

    int X(q options);

    String Y();

    byte[] a0(long byteCount);

    void d0(long byteCount);

    d e();

    long g0();

    boolean h(long byteCount);

    InputStream h0();

    byte readByte();

    int readInt();

    short readShort();

    void skip(long byteCount);
}
