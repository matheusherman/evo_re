package nb;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0003\u0018\u0000 \u0095\u00012\u00020\u0001:\u0004V[agB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J-\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0019\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001fJ-\u0010\"\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0004\b\"\u0010#J/\u0010'\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u001a¢\u0006\u0004\b'\u0010(J\u001f\u0010+\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0000¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010-\u001a\u00020)H\u0000¢\u0006\u0004\b.\u0010,J\u001f\u00100\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u001aH\u0000¢\u0006\u0004\b0\u00101J%\u00105\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u0006¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0012¢\u0006\u0004\b7\u00108J\u0015\u00109\u001a\u00020\u00122\u0006\u0010-\u001a\u00020)¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0012H\u0016¢\u0006\u0004\b;\u00108J)\u0010?\u001a\u00020\u00122\u0006\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020)2\b\u0010>\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b?\u0010@J#\u0010D\u001a\u00020\u00122\b\b\u0002\u0010A\u001a\u00020\u000b2\b\b\u0002\u0010C\u001a\u00020BH\u0007¢\u0006\u0004\bD\u0010EJ\u0015\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u001a¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0012H\u0000¢\u0006\u0004\bI\u00108J\u0017\u0010J\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0006H\u0000¢\u0006\u0004\bJ\u0010KJ%\u0010L\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0004\bL\u0010MJ-\u0010O\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010N\u001a\u00020\u000bH\u0000¢\u0006\u0004\bO\u0010PJ/\u0010S\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010R\u001a\u00020Q2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u000bH\u0000¢\u0006\u0004\bS\u0010TJ\u001f\u0010U\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0000¢\u0006\u0004\bU\u0010,R\u001a\u0010Y\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bV\u0010S\u001a\u0004\bW\u0010XR\u001a\u0010_\u001a\u00020Z8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R&\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0`8\u0000X\u0080\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010dR\u001a\u0010k\u001a\u00020f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bg\u0010h\u001a\u0004\bi\u0010jR\"\u0010q\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010l\u001a\u0004\bm\u0010n\"\u0004\bo\u0010pR\"\u0010u\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\br\u0010l\u001a\u0004\bs\u0010n\"\u0004\bt\u0010pR\u0016\u0010w\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010SR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bx\u0010yR\u0014\u0010}\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u0014\u0010\u007f\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010|R\u0016\u0010\u0081\u0001\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010|R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0086\u0001\u0010cR\u0018\u0010\u0089\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010cR\u0018\u0010\u008b\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008a\u0001\u0010cR\u0018\u0010\u008d\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010cR\u0018\u0010\u008f\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010cR\u0018\u0010\u0091\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010cR\u001d\u0010\u0097\u0001\u001a\u00030\u0092\u00018\u0006¢\u0006\u0010\n\u0006\b\u0093\u0001\u0010\u0094\u0001\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u009c\u0001\u001a\u00030\u0092\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0094\u0001\u001a\u0006\b\u0099\u0001\u0010\u0096\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R)\u0010¡\u0001\u001a\u00020\u001a2\u0007\u0010\u009d\u0001\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\b\u009e\u0001\u0010c\u001a\u0006\b\u009f\u0001\u0010 \u0001R(\u0010£\u0001\u001a\u00020\u001a2\u0007\u0010\u009d\u0001\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0004\b?\u0010c\u001a\u0006\b¢\u0001\u0010 \u0001R(\u0010¥\u0001\u001a\u00020\u001a2\u0007\u0010\u009d\u0001\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0004\b\u0013\u0010c\u001a\u0006\b¤\u0001\u0010 \u0001R(\u0010§\u0001\u001a\u00020\u001a2\u0007\u0010\u009d\u0001\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\u000e\n\u0004\bW\u0010c\u001a\u0006\b¦\u0001\u0010 \u0001R\u001f\u0010¬\u0001\u001a\u00030¨\u00018\u0000X\u0080\u0004¢\u0006\u000f\n\u0005\bi\u0010©\u0001\u001a\u0006\bª\u0001\u0010«\u0001R\u001c\u0010±\u0001\u001a\u00030\u00ad\u00018\u0006¢\u0006\u000f\n\u0005\bm\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001R \u0010¶\u0001\u001a\u00070²\u0001R\u00020\u00008\u0006¢\u0006\u000f\n\u0005\b]\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u001d\u0010¹\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060·\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bs\u0010¸\u0001¨\u0006º\u0001"}, d2 = {"Lnb/f;", "Ljava/io/Closeable;", "Lnb/f$a;", "builder", "<init>", "(Lnb/f$a;)V", "", "associatedStreamId", "", "Lnb/c;", "requestHeaders", "", "out", "Lnb/i;", ExifInterface.LATITUDE_SOUTH, "(ILjava/util/List;Z)Lnb/i;", "Ljava/io/IOException;", "e", "Lr8/z;", "w", "(Ljava/io/IOException;)V", IjkMediaMeta.IJKM_KEY_TRACK_ID, "G", "(I)Lnb/i;", "streamId", "j0", "", "read", "q0", "(J)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/List;Z)Lnb/i;", "outFinished", "alternating", "s0", "(IZLjava/util/List;)V", "Ltb/d;", "buffer", "byteCount", "r0", "(IZLtb/d;J)V", "Lnb/b;", "errorCode", "v0", "(ILnb/b;)V", "statusCode", "u0", "unacknowledgedBytesRead", "w0", "(IJ)V", "reply", "payload1", "payload2", "t0", "(ZII)V", "flush", "()V", "n0", "(Lnb/b;)V", "close", "connectionCode", "streamCode", "cause", "v", "(Lnb/b;Lnb/b;Ljava/io/IOException;)V", "sendConnectionPreface", "Lkb/e;", "taskRunner", "o0", "(ZLkb/e;)V", "nowNs", "R", "(J)Z", "k0", "i0", "(I)Z", "c0", "(ILjava/util/List;)V", "inFinished", "b0", "(ILjava/util/List;Z)V", "Ltb/f;", "source", "Z", "(ILtb/f;IZ)V", "e0", "a", "x", "()Z", "client", "Lnb/f$c;", "b", "Lnb/f$c;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lnb/f$c;", "listener", "", "c", "Ljava/util/Map;", "J", "()Ljava/util/Map;", IjkMediaMeta.IJKM_KEY_STREAMS, "", "d", "Ljava/lang/String;", "y", "()Ljava/lang/String;", "connectionName", "I", "z", "()I", "l0", "(I)V", "lastGoodStreamId", "f", "B", "setNextStreamId$okhttp", "nextStreamId", "g", "isShutdown", "h", "Lkb/e;", "Lkb/d;", "i", "Lkb/d;", "writerQueue", "j", "pushQueue", "k", "settingsListenerQueue", "Lnb/l;", "l", "Lnb/l;", "pushObserver", "m", "intervalPingsSent", "n", "intervalPongsReceived", "o", "degradedPingsSent", "p", "degradedPongsReceived", "q", "awaitPongsReceived", "r", "degradedPongDeadlineNs", "Lnb/m;", "s", "Lnb/m;", "C", "()Lnb/m;", "okHttpSettings", "t", "F", "m0", "(Lnb/m;)V", "peerSettings", "<set-?>", "u", "getReadBytesTotal", "()J", "readBytesTotal", "getReadBytesAcknowledged", "readBytesAcknowledged", "getWriteBytesTotal", "writeBytesTotal", "M", "writeBytesMaximum", "Ljava/net/Socket;", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "socket", "Lnb/j;", "Lnb/j;", "P", "()Lnb/j;", "writer", "Lnb/f$d;", "Lnb/f$d;", "getReaderRunnable", "()Lnb/f$d;", "readerRunnable", "", "Ljava/util/Set;", "currentPushRequests", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class f implements Closeable {

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final m D;

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    private final d readerRunnable;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    private final Set<Integer> currentPushRequests;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean client;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final c listener;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<Integer, nb.i> streams;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String connectionName;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastGoodStreamId;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int nextStreamId;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isShutdown;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final kb.e taskRunner;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final kb.d writerQueue;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final kb.d pushQueue;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final kb.d settingsListenerQueue;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final nb.l pushObserver;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private long intervalPingsSent;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long intervalPongsReceived;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long degradedPingsSent;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private long degradedPongsReceived;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private long awaitPongsReceived;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private long degradedPongDeadlineNs;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final m okHttpSettings;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private m peerSettings;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long readBytesTotal;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private long readBytesAcknowledged;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private long writeBytesTotal;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private long writeBytesMaximum;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    private final Socket socket;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final nb.j writer;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\t\u001a\u00020\b8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00100\u001a\u00020\n8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b%\u0010-\"\u0004\b.\u0010/R\"\u0010\r\u001a\u00020\f8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b9\u0010=\u001a\u0004\b+\u0010>\"\u0004\b?\u0010@R\"\u0010F\u001a\u00020A8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010B\u001a\u0004\b7\u0010C\"\u0004\bD\u0010ER\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b3\u0010G\u001a\u0004\b1\u0010H\"\u0004\bI\u0010J¨\u0006K"}, d2 = {"Lnb/f$a;", "", "", "client", "Lkb/e;", "taskRunner", "<init>", "(ZLkb/e;)V", "Ljava/net/Socket;", "socket", "", "peerName", "Ltb/f;", "source", "Ltb/e;", "sink", "q", "(Ljava/net/Socket;Ljava/lang/String;Ltb/f;Ltb/e;)Lnb/f$a;", "Lnb/f$c;", "listener", "k", "(Lnb/f$c;)Lnb/f$a;", "", "pingIntervalMillis", "l", "(I)Lnb/f$a;", "Lnb/f;", "a", "()Lnb/f;", "Z", "b", "()Z", "setClient$okhttp", "(Z)V", "Lkb/e;", "j", "()Lkb/e;", "c", "Ljava/net/Socket;", "h", "()Ljava/net/Socket;", "o", "(Ljava/net/Socket;)V", "d", "Ljava/lang/String;", "()Ljava/lang/String;", "m", "(Ljava/lang/String;)V", "connectionName", "e", "Ltb/f;", "i", "()Ltb/f;", "p", "(Ltb/f;)V", "f", "Ltb/e;", "g", "()Ltb/e;", "n", "(Ltb/e;)V", "Lnb/f$c;", "()Lnb/f$c;", "setListener$okhttp", "(Lnb/f$c;)V", "Lnb/l;", "Lnb/l;", "()Lnb/l;", "setPushObserver$okhttp", "(Lnb/l;)V", "pushObserver", "I", "()I", "setPingIntervalMillis$okhttp", "(I)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean client;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final kb.e taskRunner;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        public Socket socket;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String connectionName;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        public tb.f source;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        public tb.e sink;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private c listener;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private nb.l pushObserver;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int pingIntervalMillis;

        public a(boolean z10, kb.e taskRunner) {
            kotlin.jvm.internal.m.f(taskRunner, "taskRunner");
            this.client = z10;
            this.taskRunner = taskRunner;
            this.listener = c.f16197b;
            this.pushObserver = nb.l.f16299b;
        }

        public final f a() {
            return new f(this);
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final boolean getClient() {
            return this.client;
        }

        public final String c() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            kotlin.jvm.internal.m.v("connectionName");
            return null;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final c getListener() {
            return this.listener;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final int getPingIntervalMillis() {
            return this.pingIntervalMillis;
        }

        /* JADX INFO: renamed from: f, reason: from getter */
        public final nb.l getPushObserver() {
            return this.pushObserver;
        }

        public final tb.e g() {
            tb.e eVar = this.sink;
            if (eVar != null) {
                return eVar;
            }
            kotlin.jvm.internal.m.v("sink");
            return null;
        }

        public final Socket h() {
            Socket socket = this.socket;
            if (socket != null) {
                return socket;
            }
            kotlin.jvm.internal.m.v("socket");
            return null;
        }

        public final tb.f i() {
            tb.f fVar = this.source;
            if (fVar != null) {
                return fVar;
            }
            kotlin.jvm.internal.m.v("source");
            return null;
        }

        /* JADX INFO: renamed from: j, reason: from getter */
        public final kb.e getTaskRunner() {
            return this.taskRunner;
        }

        public final a k(c listener) {
            kotlin.jvm.internal.m.f(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final a l(int pingIntervalMillis) {
            this.pingIntervalMillis = pingIntervalMillis;
            return this;
        }

        public final void m(String str) {
            kotlin.jvm.internal.m.f(str, "<set-?>");
            this.connectionName = str;
        }

        public final void n(tb.e eVar) {
            kotlin.jvm.internal.m.f(eVar, "<set-?>");
            this.sink = eVar;
        }

        public final void o(Socket socket) {
            kotlin.jvm.internal.m.f(socket, "<set-?>");
            this.socket = socket;
        }

        public final void p(tb.f fVar) {
            kotlin.jvm.internal.m.f(fVar, "<set-?>");
            this.source = fVar;
        }

        public final a q(Socket socket, String peerName, tb.f source, tb.e sink) {
            String str;
            kotlin.jvm.internal.m.f(socket, "socket");
            kotlin.jvm.internal.m.f(peerName, "peerName");
            kotlin.jvm.internal.m.f(source, "source");
            kotlin.jvm.internal.m.f(sink, "sink");
            o(socket);
            if (this.client) {
                str = hb.d.f10921i + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            m(str);
            p(source);
            n(sink);
            return this;
        }
    }

    /* JADX INFO: renamed from: nb.f$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lnb/f$b;", "", "<init>", "()V", "Lnb/m;", "DEFAULT_SETTINGS", "Lnb/m;", "a", "()Lnb/m;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public final m a() {
            return f.D;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u000f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lnb/f$c;", "", "<init>", "()V", "Lnb/i;", "stream", "Lr8/z;", "c", "(Lnb/i;)V", "Lnb/f;", "connection", "Lnb/m;", "settings", "b", "(Lnb/f;Lnb/m;)V", "a", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f16197b = new a();

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"nb/f$c$a", "Lnb/f$c;", "Lnb/i;", "stream", "Lr8/z;", "c", "(Lnb/i;)V", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class a extends c {
            @Override // nb.f.c
            public void c(nb.i stream) {
                kotlin.jvm.internal.m.f(stream, "stream");
                stream.d(b.REFUSED_STREAM, null);
            }

            a() {
            }
        }

        public abstract void c(nb.i stream);

        public void b(f connection, m settings) {
            kotlin.jvm.internal.m.f(connection, "connection");
            kotlin.jvm.internal.m.f(settings, "settings");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010\"\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010!J\u000f\u0010#\u001a\u00020\u0003H\u0016¢\u0006\u0004\b#\u0010\tJ'\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b'\u0010(J'\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b0\u00101J/\u00105\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\nH\u0016¢\u0006\u0004\b5\u00106J-\u00109\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u00107\u001a\u00020\f2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b9\u0010:R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010;\u001a\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lnb/f$d;", "Lnb/h$c;", "Lkotlin/Function0;", "Lr8/z;", "Lnb/h;", "reader", "<init>", "(Lnb/f;Lnb/h;)V", "n", "()V", "", "inFinished", "", "streamId", "Ltb/f;", "source", "length", "j", "(ZILtb/f;I)V", "associatedStreamId", "", "Lnb/c;", "headerBlock", "c", "(ZIILjava/util/List;)V", "Lnb/b;", "errorCode", "f", "(ILnb/b;)V", "clearPrevious", "Lnb/m;", "settings", "a", "(ZLnb/m;)V", "m", "b", "ack", "payload1", "payload2", "g", "(ZII)V", "lastGoodStreamId", "Ltb/g;", "debugData", "k", "(ILnb/b;Ltb/g;)V", "", "windowSizeIncrement", "e", "(IJ)V", "streamDependency", "weight", "exclusive", "h", "(IIIZ)V", "promisedStreamId", "requestHeaders", "l", "(IILjava/util/List;)V", "Lnb/h;", "getReader$okhttp", "()Lnb/h;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class d implements nb.h.c, c9.a<z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final nb.h reader;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f16199b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class a extends kb.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ f f16200e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b0 f16201f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z10, f fVar, b0 b0Var) {
                super(str, z10);
                this.f16200e = fVar;
                this.f16201f = b0Var;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kb.a
            public long f() {
                this.f16200e.getListener().b(this.f16200e, (m) this.f16201f.element);
                return -1L;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class b extends kb.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ f f16202e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ nb.i f16203f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, boolean z10, f fVar, nb.i iVar) {
                super(str, z10);
                this.f16202e = fVar;
                this.f16203f = iVar;
            }

            @Override // kb.a
            public long f() {
                try {
                    this.f16202e.getListener().c(this.f16203f);
                    return -1L;
                } catch (IOException e10) {
                    ob.m.INSTANCE.g().j("Http2Connection.Listener failure for " + this.f16202e.getConnectionName(), 4, e10);
                    try {
                        this.f16203f.d(nb.b.PROTOCOL_ERROR, e10);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class c extends kb.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ f f16204e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f16205f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f16206g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z10, f fVar, int i10, int i11) {
                super(str, z10);
                this.f16204e = fVar;
                this.f16205f = i10;
                this.f16206g = i11;
            }

            @Override // kb.a
            public long f() {
                this.f16204e.t0(true, this.f16205f, this.f16206g);
                return -1L;
            }
        }

        /* JADX INFO: renamed from: nb.f$d$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class C0312d extends kb.a {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f16207e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f16208f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ m f16209g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0312d(String str, boolean z10, d dVar, boolean z11, m mVar) {
                super(str, z10);
                this.f16207e = dVar;
                this.f16208f = z11;
                this.f16209g = mVar;
            }

            @Override // kb.a
            public long f() {
                this.f16207e.m(this.f16208f, this.f16209g);
                return -1L;
            }
        }

        public d(f fVar, nb.h reader) {
            kotlin.jvm.internal.m.f(reader, "reader");
            this.f16199b = fVar;
            this.reader = reader;
        }

        @Override // nb.h.c
        public void a(boolean clearPrevious, m settings) {
            kotlin.jvm.internal.m.f(settings, "settings");
            this.f16199b.writerQueue.i(new C0312d(this.f16199b.getConnectionName() + " applyAndAckSettings", true, this, clearPrevious, settings), 0L);
        }

        @Override // nb.h.c
        public void c(boolean inFinished, int streamId, int associatedStreamId, List<nb.c> headerBlock) {
            kotlin.jvm.internal.m.f(headerBlock, "headerBlock");
            if (this.f16199b.i0(streamId)) {
                this.f16199b.b0(streamId, headerBlock, inFinished);
                return;
            }
            f fVar = this.f16199b;
            synchronized (fVar) {
                nb.i iVarG = fVar.G(streamId);
                if (iVarG != null) {
                    z zVar = z.f17874a;
                    iVarG.x(hb.d.P(headerBlock), inFinished);
                    return;
                }
                if (fVar.isShutdown) {
                    return;
                }
                if (streamId <= fVar.getLastGoodStreamId()) {
                    return;
                }
                if (streamId % 2 == fVar.getNextStreamId() % 2) {
                    return;
                }
                nb.i iVar = new nb.i(streamId, fVar, false, inFinished, hb.d.P(headerBlock));
                fVar.l0(streamId);
                fVar.J().put(Integer.valueOf(streamId), iVar);
                fVar.taskRunner.i().i(new b(fVar.getConnectionName() + '[' + streamId + "] onStream", true, fVar, iVar), 0L);
            }
        }

        @Override // nb.h.c
        public void e(int streamId, long windowSizeIncrement) {
            if (streamId == 0) {
                f fVar = this.f16199b;
                synchronized (fVar) {
                    fVar.writeBytesMaximum = fVar.getWriteBytesMaximum() + windowSizeIncrement;
                    kotlin.jvm.internal.m.d(fVar, "null cannot be cast to non-null type java.lang.Object");
                    fVar.notifyAll();
                    z zVar = z.f17874a;
                }
                return;
            }
            nb.i iVarG = this.f16199b.G(streamId);
            if (iVarG != null) {
                synchronized (iVarG) {
                    iVarG.a(windowSizeIncrement);
                    z zVar2 = z.f17874a;
                }
            }
        }

        @Override // nb.h.c
        public void f(int streamId, nb.b errorCode) {
            kotlin.jvm.internal.m.f(errorCode, "errorCode");
            if (this.f16199b.i0(streamId)) {
                this.f16199b.e0(streamId, errorCode);
                return;
            }
            nb.i iVarJ0 = this.f16199b.j0(streamId);
            if (iVarJ0 != null) {
                iVarJ0.y(errorCode);
            }
        }

        @Override // nb.h.c
        public void g(boolean ack, int payload1, int payload2) {
            if (!ack) {
                this.f16199b.writerQueue.i(new c(this.f16199b.getConnectionName() + " ping", true, this.f16199b, payload1, payload2), 0L);
                return;
            }
            f fVar = this.f16199b;
            synchronized (fVar) {
                try {
                    if (payload1 == 1) {
                        fVar.intervalPongsReceived++;
                    } else if (payload1 != 2) {
                        if (payload1 == 3) {
                            fVar.awaitPongsReceived++;
                            kotlin.jvm.internal.m.d(fVar, "null cannot be cast to non-null type java.lang.Object");
                            fVar.notifyAll();
                        }
                        z zVar = z.f17874a;
                    } else {
                        fVar.degradedPongsReceived++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // nb.h.c
        public void j(boolean inFinished, int streamId, tb.f source, int length) {
            kotlin.jvm.internal.m.f(source, "source");
            if (this.f16199b.i0(streamId)) {
                this.f16199b.Z(streamId, source, length, inFinished);
                return;
            }
            nb.i iVarG = this.f16199b.G(streamId);
            if (iVarG == null) {
                this.f16199b.v0(streamId, nb.b.PROTOCOL_ERROR);
                long j10 = length;
                this.f16199b.q0(j10);
                source.skip(j10);
                return;
            }
            iVarG.w(source, length);
            if (inFinished) {
                iVarG.x(hb.d.f10914b, true);
            }
        }

        @Override // nb.h.c
        public void k(int lastGoodStreamId, nb.b errorCode, tb.g debugData) {
            int i10;
            Object[] array;
            kotlin.jvm.internal.m.f(errorCode, "errorCode");
            kotlin.jvm.internal.m.f(debugData, "debugData");
            debugData.x();
            f fVar = this.f16199b;
            synchronized (fVar) {
                array = fVar.J().values().toArray(new nb.i[0]);
                fVar.isShutdown = true;
                z zVar = z.f17874a;
            }
            for (nb.i iVar : (nb.i[]) array) {
                if (iVar.getId() > lastGoodStreamId && iVar.t()) {
                    iVar.y(nb.b.REFUSED_STREAM);
                    this.f16199b.j0(iVar.getId());
                }
            }
        }

        @Override // nb.h.c
        public void l(int streamId, int promisedStreamId, List<nb.c> requestHeaders) throws Throwable {
            kotlin.jvm.internal.m.f(requestHeaders, "requestHeaders");
            this.f16199b.c0(promisedStreamId, requestHeaders);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v2, types: [T, nb.m] */
        /* JADX WARN: Type inference failed for: r13v3 */
        public final void m(boolean clearPrevious, m settings) {
            ?? r13;
            long jC;
            int i10;
            nb.i[] iVarArr;
            kotlin.jvm.internal.m.f(settings, "settings");
            b0 b0Var = new b0();
            nb.j writer = this.f16199b.getWriter();
            f fVar = this.f16199b;
            synchronized (writer) {
                synchronized (fVar) {
                    try {
                        m peerSettings = fVar.getPeerSettings();
                        if (clearPrevious) {
                            r13 = settings;
                        } else {
                            m mVar = new m();
                            mVar.g(peerSettings);
                            mVar.g(settings);
                            r13 = mVar;
                        }
                        b0Var.element = r13;
                        jC = ((long) r13.c()) - ((long) peerSettings.c());
                        iVarArr = (jC == 0 || fVar.J().isEmpty()) ? null : (nb.i[]) fVar.J().values().toArray(new nb.i[0]);
                        fVar.m0((m) b0Var.element);
                        fVar.settingsListenerQueue.i(new a(fVar.getConnectionName() + " onSettings", true, fVar, b0Var), 0L);
                        z zVar = z.f17874a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                try {
                    fVar.getWriter().a((m) b0Var.element);
                } catch (IOException e10) {
                    fVar.w(e10);
                }
                z zVar2 = z.f17874a;
            }
            if (iVarArr != null) {
                for (nb.i iVar : iVarArr) {
                    synchronized (iVar) {
                        iVar.a(jC);
                        z zVar3 = z.f17874a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [nb.b] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable, nb.h] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public void n() throws Throwable {
            nb.b bVar;
            nb.b bVar2 = nb.b.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.reader.c(this);
                    while (this.reader.b(false, this)) {
                    }
                    nb.b bVar3 = nb.b.NO_ERROR;
                    try {
                        this.f16199b.v(bVar3, nb.b.CANCEL, null);
                        bVar = bVar3;
                    } catch (IOException e11) {
                        e10 = e11;
                        nb.b bVar4 = nb.b.PROTOCOL_ERROR;
                        f fVar = this.f16199b;
                        fVar.v(bVar4, bVar4, e10);
                        bVar = fVar;
                    }
                } catch (Throwable th) {
                    th = th;
                    this.f16199b.v(bVar, bVar2, e10);
                    hb.d.m(this.reader);
                    throw th;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                bVar = bVar2;
                this.f16199b.v(bVar, bVar2, e10);
                hb.d.m(this.reader);
                throw th;
            }
            bVar2 = this.reader;
            hb.d.m(bVar2);
        }

        @Override // c9.a
        public /* bridge */ /* synthetic */ z invoke() throws Throwable {
            n();
            return z.f17874a;
        }

        @Override // nb.h.c
        public void b() {
        }

        @Override // nb.h.c
        public void h(int streamId, int streamDependency, int weight, boolean exclusive) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class e extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16210e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16211f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ tb.d f16212g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f16213h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f16214i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, boolean z10, f fVar, int i10, tb.d dVar, int i11, boolean z11) {
            super(str, z10);
            this.f16210e = fVar;
            this.f16211f = i10;
            this.f16212g = dVar;
            this.f16213h = i11;
            this.f16214i = z11;
        }

        @Override // kb.a
        public long f() {
            try {
                boolean zA = this.f16210e.pushObserver.a(this.f16211f, this.f16212g, this.f16213h, this.f16214i);
                if (zA) {
                    this.f16210e.getWriter().n(this.f16211f, b.CANCEL);
                }
                if (!zA && !this.f16214i) {
                    return -1L;
                }
                synchronized (this.f16210e) {
                    this.f16210e.currentPushRequests.remove(Integer.valueOf(this.f16211f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: renamed from: nb.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C0313f extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f16217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f16218h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0313f(String str, boolean z10, f fVar, int i10, List list, boolean z11) {
            super(str, z10);
            this.f16215e = fVar;
            this.f16216f = i10;
            this.f16217g = list;
            this.f16218h = z11;
        }

        @Override // kb.a
        public long f() {
            boolean zD = this.f16215e.pushObserver.d(this.f16216f, this.f16217g, this.f16218h);
            if (zD) {
                try {
                    this.f16215e.getWriter().n(this.f16216f, b.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!zD && !this.f16218h) {
                return -1L;
            }
            synchronized (this.f16215e) {
                this.f16215e.currentPushRequests.remove(Integer.valueOf(this.f16216f));
            }
            return -1L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class g extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List f16221g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z10, f fVar, int i10, List list) {
            super(str, z10);
            this.f16219e = fVar;
            this.f16220f = i10;
            this.f16221g = list;
        }

        @Override // kb.a
        public long f() {
            if (!this.f16219e.pushObserver.c(this.f16220f, this.f16221g)) {
                return -1L;
            }
            try {
                this.f16219e.getWriter().n(this.f16220f, b.CANCEL);
                synchronized (this.f16219e) {
                    this.f16219e.currentPushRequests.remove(Integer.valueOf(this.f16220f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class h extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16222e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16223f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f16224g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, f fVar, int i10, b bVar) {
            super(str, z10);
            this.f16222e = fVar;
            this.f16223f = i10;
            this.f16224g = bVar;
        }

        @Override // kb.a
        public long f() {
            this.f16222e.pushObserver.b(this.f16223f, this.f16224g);
            synchronized (this.f16222e) {
                this.f16222e.currentPushRequests.remove(Integer.valueOf(this.f16223f));
                z zVar = z.f17874a;
            }
            return -1L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class i extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16225e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z10, f fVar) {
            super(str, z10);
            this.f16225e = fVar;
        }

        @Override // kb.a
        public long f() {
            this.f16225e.t0(false, 2, 0);
            return -1L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"nb/f$j", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class j extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16226e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f16227f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, f fVar, long j10) {
            super(str, false, 2, null);
            this.f16226e = fVar;
            this.f16227f = j10;
        }

        @Override // kb.a
        public long f() {
            boolean z10;
            synchronized (this.f16226e) {
                if (this.f16226e.intervalPongsReceived < this.f16226e.intervalPingsSent) {
                    z10 = true;
                } else {
                    this.f16226e.intervalPingsSent++;
                    z10 = false;
                }
            }
            if (z10) {
                this.f16226e.w(null);
                return -1L;
            }
            this.f16226e.t0(false, 1, 0);
            return this.f16227f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class k extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f16230g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z10, f fVar, int i10, b bVar) {
            super(str, z10);
            this.f16228e = fVar;
            this.f16229f = i10;
            this.f16230g = bVar;
        }

        @Override // kb.a
        public long f() {
            try {
                this.f16228e.u0(this.f16229f, this.f16230g);
                return -1L;
            } catch (IOException e10) {
                this.f16228e.w(e10);
                return -1L;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005¸\u0006\u0000"}, d2 = {"kb/c", "Lkb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class l extends kb.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f16231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f16232f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ long f16233g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z10, f fVar, int i10, long j10) {
            super(str, z10);
            this.f16231e = fVar;
            this.f16232f = i10;
            this.f16233g = j10;
        }

        @Override // kb.a
        public long f() {
            try {
                this.f16231e.getWriter().p(this.f16232f, this.f16233g);
                return -1L;
            } catch (IOException e10) {
                this.f16231e.w(e10);
                return -1L;
            }
        }
    }

    public final synchronized nb.i G(int id2) {
        return this.streams.get(Integer.valueOf(id2));
    }

    public final synchronized boolean R(long nowNs) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || nowNs < this.degradedPongDeadlineNs;
    }

    public final synchronized nb.i j0(int streamId) {
        nb.i iVarRemove;
        iVarRemove = this.streams.remove(Integer.valueOf(streamId));
        kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return iVarRemove;
    }

    public final void k0() {
        synchronized (this) {
            long j10 = this.degradedPongsReceived;
            long j11 = this.degradedPingsSent;
            if (j10 < j11) {
                return;
            }
            this.degradedPingsSent = j11 + 1;
            this.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
            z zVar = z.f17874a;
            this.writerQueue.i(new i(this.connectionName + " ping", true, this), 0L);
        }
    }

    public final synchronized void q0(long read) {
        long j10 = this.readBytesTotal + read;
        this.readBytesTotal = j10;
        long j11 = j10 - this.readBytesAcknowledged;
        if (j11 >= this.okHttpSettings.c() / 2) {
            w0(0, j11);
            this.readBytesAcknowledged += j11;
        }
    }

    public final void r0(int streamId, boolean outFinished, tb.d buffer, long byteCount) {
        long j10;
        long j11;
        int iMin;
        long j12;
        if (byteCount == 0) {
            this.writer.c(outFinished, streamId, buffer, 0);
            return;
        }
        while (byteCount > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j10 = this.writeBytesTotal;
                            j11 = this.writeBytesMaximum;
                            if (j10 >= j11) {
                                if (!this.streams.containsKey(Integer.valueOf(streamId))) {
                                    throw new IOException("stream closed");
                                }
                                kotlin.jvm.internal.m.d(this, "null cannot be cast to non-null type java.lang.Object");
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    throw th;
                }
                iMin = Math.min((int) Math.min(byteCount, j11 - j10), this.writer.getMaxFrameSize());
                j12 = iMin;
                this.writeBytesTotal += j12;
                z zVar = z.f17874a;
            }
            byteCount -= j12;
            this.writer.c(outFinished && byteCount == 0, streamId, buffer, iMin);
        }
    }

    static {
        m mVar = new m();
        mVar.h(7, 65535);
        mVar.h(5, 16384);
        D = mVar;
    }

    public f(a builder) {
        kotlin.jvm.internal.m.f(builder, "builder");
        boolean client = builder.getClient();
        this.client = client;
        this.listener = builder.getListener();
        this.streams = new LinkedHashMap();
        String strC = builder.c();
        this.connectionName = strC;
        this.nextStreamId = builder.getClient() ? 3 : 2;
        kb.e taskRunner = builder.getTaskRunner();
        this.taskRunner = taskRunner;
        kb.d dVarI = taskRunner.i();
        this.writerQueue = dVarI;
        this.pushQueue = taskRunner.i();
        this.settingsListenerQueue = taskRunner.i();
        this.pushObserver = builder.getPushObserver();
        m mVar = new m();
        if (builder.getClient()) {
            mVar.h(7, 16777216);
        }
        this.okHttpSettings = mVar;
        m mVar2 = D;
        this.peerSettings = mVar2;
        this.writeBytesMaximum = mVar2.c();
        this.socket = builder.h();
        this.writer = new nb.j(builder.g(), client);
        this.readerRunnable = new d(this, new nb.h(builder.i(), client));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.getPingIntervalMillis());
            dVarI.i(new j(strC + " ping", this, nanos), nanos);
        }
    }

    private final nb.i S(int associatedStreamId, List<nb.c> requestHeaders, boolean out) throws Throwable {
        Throwable th;
        boolean z10 = !out;
        synchronized (this.writer) {
            try {
                try {
                    synchronized (this) {
                        try {
                            if (this.nextStreamId > 1073741823) {
                                try {
                                    n0(b.REFUSED_STREAM);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                            try {
                                if (this.isShutdown) {
                                    throw new nb.a();
                                }
                                int i10 = this.nextStreamId;
                                this.nextStreamId = i10 + 2;
                                nb.i iVar = new nb.i(i10, this, z10, false, null);
                                boolean z11 = !out || this.writeBytesTotal >= this.writeBytesMaximum || iVar.getWriteBytesTotal() >= iVar.getWriteBytesMaximum();
                                if (iVar.u()) {
                                    this.streams.put(Integer.valueOf(i10), iVar);
                                }
                                z zVar = z.f17874a;
                                if (associatedStreamId == 0) {
                                    this.writer.j(z10, i10, requestHeaders);
                                } else {
                                    if (this.client) {
                                        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
                                    }
                                    this.writer.m(associatedStreamId, i10, requestHeaders);
                                }
                                if (z11) {
                                    this.writer.flush();
                                }
                                return iVar;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                        th = th;
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    public static /* synthetic */ void p0(f fVar, boolean z10, kb.e eVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            eVar = kb.e.f12223i;
        }
        fVar.o0(z10, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(IOException e10) {
        b bVar = b.PROTOCOL_ERROR;
        v(bVar, bVar, e10);
    }

    /* JADX INFO: renamed from: A, reason: from getter */
    public final c getListener() {
        return this.listener;
    }

    /* JADX INFO: renamed from: B, reason: from getter */
    public final int getNextStreamId() {
        return this.nextStreamId;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final m getOkHttpSettings() {
        return this.okHttpSettings;
    }

    /* JADX INFO: renamed from: F, reason: from getter */
    public final m getPeerSettings() {
        return this.peerSettings;
    }

    public final Map<Integer, nb.i> J() {
        return this.streams;
    }

    /* JADX INFO: renamed from: M, reason: from getter */
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    /* JADX INFO: renamed from: P, reason: from getter */
    public final nb.j getWriter() {
        return this.writer;
    }

    public final nb.i V(List<nb.c> requestHeaders, boolean out) {
        kotlin.jvm.internal.m.f(requestHeaders, "requestHeaders");
        return S(0, requestHeaders, out);
    }

    public final void Z(int streamId, tb.f source, int byteCount, boolean inFinished) {
        kotlin.jvm.internal.m.f(source, "source");
        tb.d dVar = new tb.d();
        long j10 = byteCount;
        source.d0(j10);
        source.D(dVar, j10);
        this.pushQueue.i(new e(this.connectionName + '[' + streamId + "] onData", true, this, streamId, dVar, byteCount, inFinished), 0L);
    }

    public final void b0(int streamId, List<nb.c> requestHeaders, boolean inFinished) {
        kotlin.jvm.internal.m.f(requestHeaders, "requestHeaders");
        this.pushQueue.i(new C0313f(this.connectionName + '[' + streamId + "] onHeaders", true, this, streamId, requestHeaders, inFinished), 0L);
    }

    public final void c0(int streamId, List<nb.c> requestHeaders) throws Throwable {
        Throwable th;
        kotlin.jvm.internal.m.f(requestHeaders, "requestHeaders");
        synchronized (this) {
            try {
                if (!this.currentPushRequests.contains(Integer.valueOf(streamId))) {
                    this.currentPushRequests.add(Integer.valueOf(streamId));
                    this.pushQueue.i(new g(this.connectionName + '[' + streamId + "] onRequest", true, this, streamId, requestHeaders), 0L);
                    return;
                }
                try {
                    v0(streamId, b.PROTOCOL_ERROR);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        v(b.NO_ERROR, b.CANCEL, null);
    }

    public final void e0(int streamId, b errorCode) {
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        this.pushQueue.i(new h(this.connectionName + '[' + streamId + "] onReset", true, this, streamId, errorCode), 0L);
    }

    public final void flush() {
        this.writer.flush();
    }

    public final boolean i0(int streamId) {
        return streamId != 0 && (streamId & 1) == 0;
    }

    public final void l0(int i10) {
        this.lastGoodStreamId = i10;
    }

    public final void m0(m mVar) {
        kotlin.jvm.internal.m.f(mVar, "<set-?>");
        this.peerSettings = mVar;
    }

    public final void n0(b statusCode) {
        kotlin.jvm.internal.m.f(statusCode, "statusCode");
        synchronized (this.writer) {
            kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i10 = this.lastGoodStreamId;
                zVar.element = i10;
                z zVar2 = z.f17874a;
                this.writer.i(i10, statusCode, hb.d.f10913a);
            }
        }
    }

    public final void o0(boolean sendConnectionPreface, kb.e taskRunner) {
        kotlin.jvm.internal.m.f(taskRunner, "taskRunner");
        if (sendConnectionPreface) {
            this.writer.b();
            this.writer.o(this.okHttpSettings);
            int iC = this.okHttpSettings.c();
            if (iC != 65535) {
                this.writer.p(0, iC - 65535);
            }
        }
        taskRunner.i().i(new kb.c(this.connectionName, true, this.readerRunnable), 0L);
    }

    public final void s0(int streamId, boolean outFinished, List<nb.c> alternating) {
        kotlin.jvm.internal.m.f(alternating, "alternating");
        this.writer.j(outFinished, streamId, alternating);
    }

    public final void t0(boolean reply, int payload1, int payload2) {
        try {
            this.writer.l(reply, payload1, payload2);
        } catch (IOException e10) {
            w(e10);
        }
    }

    public final void u0(int streamId, b statusCode) {
        kotlin.jvm.internal.m.f(statusCode, "statusCode");
        this.writer.n(streamId, statusCode);
    }

    public final void v(b connectionCode, b streamCode, IOException cause) {
        int i10;
        Object[] array;
        kotlin.jvm.internal.m.f(connectionCode, "connectionCode");
        kotlin.jvm.internal.m.f(streamCode, "streamCode");
        if (hb.d.f10920h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        try {
            n0(connectionCode);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    array = null;
                } else {
                    array = this.streams.values().toArray(new nb.i[0]);
                    this.streams.clear();
                }
                z zVar = z.f17874a;
            } catch (Throwable th) {
                throw th;
            }
        }
        nb.i[] iVarArr = (nb.i[]) array;
        if (iVarArr != null) {
            for (nb.i iVar : iVarArr) {
                try {
                    iVar.d(streamCode, cause);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.n();
        this.pushQueue.n();
        this.settingsListenerQueue.n();
    }

    public final void v0(int streamId, b errorCode) {
        kotlin.jvm.internal.m.f(errorCode, "errorCode");
        this.writerQueue.i(new k(this.connectionName + '[' + streamId + "] writeSynReset", true, this, streamId, errorCode), 0L);
    }

    public final void w0(int streamId, long unacknowledgedBytesRead) {
        this.writerQueue.i(new l(this.connectionName + '[' + streamId + "] windowUpdate", true, this, streamId, unacknowledgedBytesRead), 0L);
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final boolean getClient() {
        return this.client;
    }

    /* JADX INFO: renamed from: y, reason: from getter */
    public final String getConnectionName() {
        return this.connectionName;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final int getLastGoodStreamId() {
        return this.lastGoodStreamId;
    }
}
