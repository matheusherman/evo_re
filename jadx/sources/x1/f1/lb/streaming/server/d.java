package x1.f1.lb.streaming.server;

import android.text.TextUtils;
import androidx.collection.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import com.pengrad.telegrambot.request.ContentTypes;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.z;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import nf.v;
import org.apache.log4j.Priority;
import org.apache.log4j.spi.LocationInfo;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.meta.CatchupPlayRequest;
import z1.b1.lb.m.meta.CatchupPlayResponse;
import z1.b1.lb.m.user.ServerResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002NiB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ-\u0010\u000b\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ7\u0010\u000e\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJG\u0010\u001f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0019\u0012\u0004\u0012\u00020\u00170\u001e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0014H\u0002¢\u0006\u0004\b#\u0010$J#\u0010&\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b&\u0010'JH\u0010-\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b-\u0010.J/\u00105\u001a\u0002042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\f2\u0006\u00101\u001a\u0002002\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b5\u00106J2\u00108\u001a\u0004\u0018\u0001022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u00101\u001a\u0002002\u0006\u00107\u001a\u00020\fH\u0082@¢\u0006\u0004\b8\u00109JO\u0010>\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0019\u0012\b\u0012\u00060<j\u0002`=0\u001e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010/\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\f2\u0006\u0010;\u001a\u00020\fH\u0002¢\u0006\u0004\b>\u0010?J7\u0010@\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0002¢\u0006\u0004\b@\u0010\u000fJY\u0010A\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010/\u001a\u00020\f2\b\u0010:\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006H\u0002¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0C2\u0006\u0010\u0005\u001a\u00020\fH\u0002¢\u0006\u0004\bD\u0010EJ\u0017\u0010G\u001a\u00020\f2\u0006\u0010F\u001a\u00020\fH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010\"J\u001f\u0010J\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\bJ\u0010'J\u001f\u0010K\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\bK\u0010'J;\u0010L\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\bL\u0010MJ\u001d\u0010N\u001a\u00020\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u0019H\u0002¢\u0006\u0004\bN\u0010OJ!\u0010P\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0004\bP\u0010QJC\u0010R\u001a\u00020\u0012\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0002¢\u0006\u0004\bR\u0010SJ)\u0010U\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010T\u001a\u00020\fH\u0002¢\u0006\u0004\bU\u0010VJ)\u0010X\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010W\u001a\u00020\fH\u0002¢\u0006\u0004\bX\u0010VJ\u000f\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\r\u0010\\\u001a\u00020\u0010¢\u0006\u0004\b\\\u0010]J\u0015\u0010`\u001a\u00020\b2\u0006\u0010_\u001a\u00020^¢\u0006\u0004\b`\u0010aJ\r\u0010b\u001a\u00020\b¢\u0006\u0004\bb\u0010\u0003J5\u0010c\u001a\u00020\b\"\u0004\b\u0000\u0010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0004\bc\u0010\u000fR\u001c\u0010g\u001a\n e*\u0004\u0018\u00010d0d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010fR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0016\u0010o\u001a\u00020l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tRR\u0010{\u001a>\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120vj\b\u0012\u0004\u0012\u00020\u0012`w0uj\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120vj\b\u0012\u0004\u0012\u00020\u0012`w`x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010\u007f\u001a\u00020|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u0018\u0010\u0081\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010!R\u0018\u0010\u0083\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010!R7\u0010\u0084\u0001\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u00010uj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0014\u0018\u0001`x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010zR5\u0010\u0086\u0001\u001a \u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0085\u00010uj\u000f\u0012\u0004\u0012\u00020\f\u0012\u0005\u0012\u00030\u0085\u0001`x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010zR\u0017\u0010\u0087\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010&R%\u0010\u008a\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002040\u0088\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bA\u0010\u0089\u0001¨\u0006\u008b\u0001"}, d2 = {"Lx1/f1/lb/streaming/server/d;", "", "<init>", "()V", ExifInterface.GPS_DIRECTION_TRUE, "params", "Lx1/f1/lb/streaming/server/d$a;", "callback", "Lr8/z;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Object;Lx1/f1/lb/streaming/server/d$a;)V", "x", "", "uri", "y", "(Ljava/lang/String;Ljava/lang/Object;Lx1/f1/lb/streaming/server/d$a;)V", "", "session", "", "player", "", "u", "(JI)Z", "", "index", "", "v", "([B)Ljava/util/List;", "m3u8List", "mediaId", "Lr8/p;", "B", "(Ljava/util/List;JILjava/lang/String;)Lr8/p;", "I", "(Ljava/lang/String;)Z", "K", "()Z", "sessionStr", "J", "(Ljava/lang/String;Ljava/lang/String;)Z", "streamId", "catchupStreamId", "catchupRoute", "startTimestamp", "endTimestamp", "p", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLv8/f;)Ljava/lang/Object;", "urlPrefix", "Lz1/b1/lb/m/meta/CatchupPlayRequest;", "request", "Lz1/b1/lb/m/meta/CatchupPlayResponse;", "response", "Lx1/f1/lb/streaming/server/d$b;", ExifInterface.LONGITUDE_EAST, "(JLjava/lang/String;Lz1/b1/lb/m/meta/CatchupPlayRequest;Lz1/b1/lb/m/meta/CatchupPlayResponse;)Lx1/f1/lb/streaming/server/d$b;", "logTag", "o", "(JLjava/lang/String;Lz1/b1/lb/m/meta/CatchupPlayRequest;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "token", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "n", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lr8/p;", "w", "m", "(Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lx1/f1/lb/streaming/server/d$a;)V", "", "l", "(Ljava/lang/String;)Ljava/util/Map;", "encode", "F", "(Ljava/lang/String;)Ljava/lang/String;", "L", "j", "G", "D", "(Ljava/lang/Object;JILx1/f1/lb/streaming/server/d$a;)I", "a", "(Ljava/util/List;)Ljava/lang/String;", "s", "(JLjava/lang/String;)[B", "C", "(ILjava/lang/String;JLjava/lang/String;Lx1/f1/lb/streaming/server/d$a;)I", "blockName", "k", "(JLjava/lang/String;Ljava/lang/String;)[B", "lang", "M", "Lx6/c;", "q", "()Lx6/c;", "r", "()J", "Lx1/f1/lb/streaming/server/f;", "httpServer", "t", "(Lx1/f1/lb/streaming/server/f;)V", "H", "z", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "Lx1/f1/lb/streaming/server/b;", "b", "Lx1/f1/lb/streaming/server/b;", "clientEngineService", "Lv6/c;", "c", "Lv6/c;", "playType", "d", "[B", "lastIndex", "e", "Lx1/f1/lb/streaming/server/f;", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "f", "Ljava/util/HashMap;", "validPlayer", "Ljava/util/concurrent/atomic/AtomicLong;", "g", "Ljava/util/concurrent/atomic/AtomicLong;", "playSession", "h", "playListRequestCnt", "i", "playBlockResponseCnt", "blockCacheHitMap", "", "blockDurations", "lastPlaySession", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "catchupPlayResponseCache", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private b clientEngineService;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private byte[] lastIndex;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private x1.f1.lb.streaming.server.f httpServer;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int playListRequestCnt;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int playBlockResponseCnt;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Boolean> blockCacheHitMap;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long lastPlaySession;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q6.b logger = q6.c.d(d.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private v6.c playType = v6.c.LIVE;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private HashMap<Long, HashSet<Integer>> validPlayer = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private AtomicLong playSession = new AtomicLong(0);

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Double> blockDurations = new HashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LruCache<Long, CatchupCacheItem> catchupPlayResponseCache = new LruCache<>(10);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lx1/f1/lb/streaming/server/d$a;", ExifInterface.GPS_DIRECTION_TRUE, "", "params", "", "key", "b", "(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;", "", "statusCode", "", "content", "contentType", "Lr8/z;", "a", "(I[BLjava/lang/String;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a<T> {
        void a(int statusCode, byte[] content, String contentType);

        String b(T params, String key);
    }

    /* JADX INFO: renamed from: x1.f1.lb.streaming.server.d$b, reason: from toString */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\"\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lx1/f1/lb/streaming/server/d$b;", "", "", "urlPrefix", "Lz1/b1/lb/m/meta/CatchupPlayRequest;", "request", "Lz1/b1/lb/m/meta/CatchupPlayResponse;", "response", "", "tokenExpiredTime", "", "listSize", "<init>", "(Ljava/lang/String;Lz1/b1/lb/m/meta/CatchupPlayRequest;Lz1/b1/lb/m/meta/CatchupPlayResponse;JI)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "e", "b", "Lz1/b1/lb/m/meta/CatchupPlayRequest;", "()Lz1/b1/lb/m/meta/CatchupPlayRequest;", "c", "Lz1/b1/lb/m/meta/CatchupPlayResponse;", "()Lz1/b1/lb/m/meta/CatchupPlayResponse;", "d", "J", "()J", "I", "f", "(I)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class CatchupCacheItem {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final String urlPrefix;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final CatchupPlayRequest request;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final CatchupPlayResponse response;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long tokenExpiredTime;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private int listSize;

        public CatchupCacheItem(String urlPrefix, CatchupPlayRequest request, CatchupPlayResponse response, long j10, int i10) {
            kotlin.jvm.internal.m.f(urlPrefix, "urlPrefix");
            kotlin.jvm.internal.m.f(request, "request");
            kotlin.jvm.internal.m.f(response, "response");
            this.urlPrefix = urlPrefix;
            this.request = request;
            this.response = response;
            this.tokenExpiredTime = j10;
            this.listSize = i10;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CatchupCacheItem)) {
                return false;
            }
            CatchupCacheItem catchupCacheItem = (CatchupCacheItem) other;
            return kotlin.jvm.internal.m.a(this.urlPrefix, catchupCacheItem.urlPrefix) && kotlin.jvm.internal.m.a(this.request, catchupCacheItem.request) && kotlin.jvm.internal.m.a(this.response, catchupCacheItem.response) && this.tokenExpiredTime == catchupCacheItem.tokenExpiredTime && this.listSize == catchupCacheItem.listSize;
        }

        public /* synthetic */ CatchupCacheItem(String str, CatchupPlayRequest catchupPlayRequest, CatchupPlayResponse catchupPlayResponse, long j10, int i10, int i11, kotlin.jvm.internal.g gVar) {
            this(str, catchupPlayRequest, catchupPlayResponse, j10, (i11 & 16) != 0 ? 0 : i10);
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getListSize() {
            return this.listSize;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final CatchupPlayRequest getRequest() {
            return this.request;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final CatchupPlayResponse getResponse() {
            return this.response;
        }

        /* JADX INFO: renamed from: d, reason: from getter */
        public final long getTokenExpiredTime() {
            return this.tokenExpiredTime;
        }

        /* JADX INFO: renamed from: e, reason: from getter */
        public final String getUrlPrefix() {
            return this.urlPrefix;
        }

        public final void f(int i10) {
            this.listSize = i10;
        }

        public int hashCode() {
            return (((((((this.urlPrefix.hashCode() * 31) + this.request.hashCode()) * 31) + this.response.hashCode()) * 31) + androidx.collection.a.a(this.tokenExpiredTime)) * 31) + this.listSize;
        }

        public String toString() {
            return "CatchupCacheItem(urlPrefix=" + this.urlPrefix + ", request=" + this.request + ", response=" + this.response + ", tokenExpiredTime=" + this.tokenExpiredTime + ", listSize=" + this.listSize + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/d$c", "Lx1/f1/lb/util/m;", "Ljava/io/InputStream;", "v", "Lr8/z;", "c", "(Ljava/io/InputStream;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements x1.f1.lb.util.m<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f21064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a<T> f21065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f21066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f21067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21068e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ z f21069f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f21070g;

        c(long j10, a<T> aVar, d dVar, long j11, String str, z zVar, String str2) {
            this.f21064a = j10;
            this.f21065b = aVar;
            this.f21066c = dVar;
            this.f21067d = j11;
            this.f21068e = str;
            this.f21069f = zVar;
            this.f21070g = str2;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(InputStream v10) {
            String str;
            String str2;
            String str3;
            c cVar = this;
            long jD = d1.d();
            long j10 = jD - cVar.f21064a;
            if (v10 == null) {
                try {
                    a<T> aVar = cVar.f21065b;
                    byte[] bytes = "".getBytes(ua.d.UTF_8);
                    kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                    aVar.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
                    cVar.f21066c.logger.error("session[" + cVar.f21067d + "] download catchup[" + j10 + " ms][" + cVar.f21068e + "] got null", new Object[0]);
                    return;
                } catch (Throwable th) {
                    th = th;
                    str = ContentTypes.DOC_MIME_TYPE;
                    str2 = "getBytes(...)";
                    str3 = "";
                }
            } else {
                try {
                    byte[] bArrM = yb.e.m(v10);
                    int length = bArrM.length;
                    long jD2 = d1.d();
                    a<T> aVar2 = cVar.f21065b;
                    kotlin.jvm.internal.m.c(bArrM);
                    aVar2.a(200, bArrM, "video/m2ts");
                    long jD3 = d1.d();
                    long j11 = jD3 - jD2;
                    long j12 = jD2 - jD;
                    str2 = "getBytes(...)";
                    str3 = "";
                    try {
                        long j13 = ((long) (length * 8)) / (jD3 - cVar.f21064a);
                        cVar.f21069f.element = length;
                        q6.b bVar = cVar.f21066c.logger;
                        long j14 = cVar.f21067d;
                        str = ContentTypes.DOC_MIME_TYPE;
                        try {
                            bVar.a("session[" + j14 + "] download catchup block[" + cVar.f21070g + "] complete [" + j10 + " ms][" + j12 + " ms][" + j11 + " ms] [" + length + "] -> [" + j13 + " kbps]", new Object[0]);
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            cVar = this;
                            cVar.f21066c.logger.error("session[" + cVar.f21067d + "] download catchup block[" + cVar.f21070g + "] failure[" + j10 + " ms] [" + cVar.f21068e + "]", th);
                            a<T> aVar3 = cVar.f21065b;
                            byte[] bytes2 = str3.getBytes(ua.d.UTF_8);
                            kotlin.jvm.internal.m.e(bytes2, str2);
                            aVar3.a(404, bytes2, str);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        str = ContentTypes.DOC_MIME_TYPE;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = ContentTypes.DOC_MIME_TYPE;
                    str2 = "getBytes(...)";
                    str3 = "";
                }
            }
            cVar.f21066c.logger.error("session[" + cVar.f21067d + "] download catchup block[" + cVar.f21070g + "] failure[" + j10 + " ms] [" + cVar.f21068e + "]", th);
            a<T> aVar4 = cVar.f21065b;
            byte[] bytes3 = str3.getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes3, str2);
            aVar4.a(404, bytes3, str);
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.streaming.server.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/d$d", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0446d implements x1.f1.lb.util.m<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f21071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f21072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f21073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<T> f21076f;

        C0446d(long j10, d dVar, long j11, String str, String str2, a<T> aVar) {
            this.f21071a = j10;
            this.f21072b = dVar;
            this.f21073c = j11;
            this.f21074d = str;
            this.f21075e = str2;
            this.f21076f = aVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Throwable v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long jD = d1.d() - this.f21071a;
            this.f21072b.logger.error("session[" + this.f21073c + "] download catchup block[" + this.f21074d + "] failure[" + jD + " ms] [" + this.f21075e + "]", v10);
            a<T> aVar = this.f21076f;
            byte[] bytes = "".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            aVar.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/d$e", "Lx1/f1/lb/util/m;", "Ljava/io/InputStream;", "v", "Lr8/z;", "c", "(Ljava/io/InputStream;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements x1.f1.lb.util.m<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f21077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f21078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f21079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f21080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f21081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ b0<StringBuilder> f21082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ List<String> f21083g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ List<Double> f21084h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f21085i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f21086j;

        e(String str, String str2, d dVar, long j10, String str3, b0<StringBuilder> b0Var, List<String> list, List<Double> list2, String str4, CountDownLatch countDownLatch) {
            this.f21077a = str;
            this.f21078b = str2;
            this.f21079c = dVar;
            this.f21080d = j10;
            this.f21081e = str3;
            this.f21082f = b0Var;
            this.f21083g = list;
            this.f21084h = list2;
            this.f21085i = str4;
            this.f21086j = countDownLatch;
        }

        /* JADX WARN: Type inference failed for: r11v11, types: [T, java.lang.Object] */
        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(InputStream v10) {
            String str;
            if (v10 == null) {
                this.f21086j.countDown();
                return;
            }
            boolean z10 = false;
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(v10));
                int i10 = 0;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (ua.n.v(line, ".m3u8", z10, 2, null)) {
                        String str2 = this.f21077a;
                        if (str2 == null || str2.length() == 0) {
                            str = this.f21078b + "/" + line;
                        } else {
                            str = this.f21078b + "/" + line + LocationInfo.NA + this.f21077a;
                        }
                        r8.p pVarN = this.f21079c.n(this.f21080d, this.f21081e, this.f21078b, this.f21077a, str);
                        this.f21082f.element = pVarN.d();
                        this.f21083g.addAll((Collection) pVarN.c());
                    } else if (ua.n.v(line, ".ts", z10, 2, null)) {
                        try {
                            String strW = x1.f1.lb.streaming.a.f20960a.w(line);
                            r rVar = r.f21132a;
                            int i11 = i10 + 1;
                            String str3 = rVar.d() + "_" + i10 + ".ts";
                            StringBuilder sb2 = this.f21082f.element;
                            sb2.append(str3);
                            sb2.append(LocationInfo.NA);
                            sb2.append(rVar.n());
                            sb2.append("=");
                            sb2.append(String.valueOf(this.f21080d));
                            sb2.append("&");
                            sb2.append(rVar.k());
                            sb2.append("=");
                            sb2.append(this.f21081e);
                            sb2.append("&");
                            sb2.append(rVar.c());
                            sb2.append("=");
                            sb2.append(strW);
                            this.f21083g.add(str3);
                            if (this.f21084h.size() >= this.f21083g.size() && this.f21079c.blockDurations.size() < 3) {
                                this.f21079c.blockDurations.put(str3, Double.valueOf(this.f21084h.get(this.f21083g.size() - 1).doubleValue()));
                            }
                            i10 = i11;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } else {
                        if (ua.n.I(line, "#", false, 2, null) && ua.n.I(line, "#EXTINF:", false, 2, null) && this.f21079c.blockDurations.size() < 3) {
                            try {
                                this.f21084h.add(Double.valueOf(dc.a.a(ua.n.R0(line.subSequence(8, line.length()), ',').toString())));
                            } catch (Throwable th2) {
                                this.f21079c.logger.error("session[" + this.f21080d + "] parse ext-info failure", th2);
                            }
                        }
                        this.f21082f.element.append(line);
                    }
                    this.f21082f.element.append("\n");
                    z10 = false;
                    try {
                        this.f21079c.logger.error("session[" + this.f21080d + "] download catchup playlist failure[" + this.f21085i + "]", th);
                    } finally {
                        this.f21086j.countDown();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/streaming/server/d$f", "Lx1/f1/lb/util/m;", "", "v", "Lr8/z;", "c", "(Ljava/lang/Throwable;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements x1.f1.lb.util.m<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f21087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f21088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f21089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f21090d;

        f(long j10, d dVar, long j11, String str) {
            this.f21087a = j10;
            this.f21088b = dVar;
            this.f21089c = j11;
            this.f21090d = str;
        }

        @Override // x1.f1.lb.util.m
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(Throwable v10) {
            kotlin.jvm.internal.m.f(v10, "v");
            long jD = d1.d() - this.f21087a;
            this.f21088b.logger.error("session[" + this.f21089c + "] download catchup playlist failure[" + jD + " ms][" + this.f21090d + "]", v10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.HttpServiceWrapper", f = "HttpServiceWrapper.kt", l = {590}, m = "getCatchupPlayUrl")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class g extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        g(v8.f<? super g> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.o(0L, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.HttpServiceWrapper", f = "HttpServiceWrapper.kt", l = {538}, m = "getCatchupPlaylist")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class h extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        long J$1;
        long J$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        h(v8.f<? super h> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.p(0L, null, null, null, null, 0L, 0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.HttpServiceWrapper$onCatchupRequest$1", f = "HttpServiceWrapper.kt", l = {740}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ CatchupCacheItem $cacheItem;
        final /* synthetic */ a<T> $callback;
        final /* synthetic */ T $params;
        final /* synthetic */ String $player;
        final /* synthetic */ CatchupPlayRequest $request;
        final /* synthetic */ long $session;
        final /* synthetic */ String $uri;
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.HttpServiceWrapper$onCatchupRequest$1$1", f = "HttpServiceWrapper.kt", l = {754}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ CatchupCacheItem $cacheItem;
            final /* synthetic */ a<T> $callback;
            final /* synthetic */ T $params;
            final /* synthetic */ String $player;
            final /* synthetic */ CatchupPlayRequest $request;
            final /* synthetic */ long $session;
            final /* synthetic */ String $uri;
            int label;
            final /* synthetic */ d this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d dVar, long j10, String str, String str2, T t10, a<T> aVar, CatchupPlayRequest catchupPlayRequest, CatchupCacheItem catchupCacheItem, v8.f<? super a> fVar) {
                super(2, fVar);
                this.this$0 = dVar;
                this.$session = j10;
                this.$uri = str;
                this.$player = str2;
                this.$params = t10;
                this.$callback = aVar;
                this.$request = catchupPlayRequest;
                this.$cacheItem = catchupCacheItem;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new a(this.this$0, this.$session, this.$uri, this.$player, this.$params, this.$callback, this.$request, this.$cacheItem, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objO;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        r8.r.b(obj);
                        CatchupCacheItem catchupCacheItem = (CatchupCacheItem) this.this$0.catchupPlayResponseCache.get(kotlin.coroutines.jvm.internal.b.c(this.$session));
                        if (catchupCacheItem == null || catchupCacheItem.getTokenExpiredTime() <= d1.d()) {
                            d dVar = this.this$0;
                            long j10 = this.$session;
                            String str = this.$player;
                            CatchupPlayRequest catchupPlayRequest = this.$request;
                            this.label = 1;
                            objO = dVar.o(j10, str, catchupPlayRequest, "renew catchup token", this);
                            if (objO == objC) {
                                return objC;
                            }
                        } else {
                            this.this$0.m(this.$uri, this.$session, Integer.parseInt(this.$player), catchupCacheItem.getUrlPrefix(), catchupCacheItem.getResponse().getToken(), this.$params, this.$callback);
                        }
                        return r8.z.f17874a;
                    }
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                    objO = obj;
                    CatchupPlayResponse catchupPlayResponse = (CatchupPlayResponse) objO;
                    if (catchupPlayResponse != null) {
                        this.this$0.E(this.$session, this.$cacheItem.getUrlPrefix(), this.$request, catchupPlayResponse).f(this.$cacheItem.getListSize());
                        this.this$0.m(this.$uri, this.$session, Integer.parseInt(this.$player), this.$cacheItem.getUrlPrefix(), catchupPlayResponse.getToken(), this.$params, this.$callback);
                        return r8.z.f17874a;
                    }
                    a<T> aVar = this.$callback;
                    byte[] bytes = "renew catchup token failed".getBytes(ua.d.UTF_8);
                    kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                    aVar.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
                    return r8.z.f17874a;
                } catch (Throwable th) {
                    a<T> aVar2 = this.$callback;
                    byte[] bytes2 = "renew catchup token failed".getBytes(ua.d.UTF_8);
                    kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
                    aVar2.a(404, bytes2, ContentTypes.DOC_MIME_TYPE);
                    this.this$0.logger.error("renew catchup token failure[" + this.$session + "][" + this.$request.getStreamId() + "][" + this.$request.getCatchupStreamId() + "][" + this.$request.getStartTimestamp() + "][" + this.$request.getEndTimestamp() + "]", th);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long j10, String str, String str2, T t10, a<T> aVar, CatchupPlayRequest catchupPlayRequest, CatchupCacheItem catchupCacheItem, v8.f<? super i> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$uri = str;
            this.$player = str2;
            this.$params = t10;
            this.$callback = aVar;
            this.$request = catchupPlayRequest;
            this.$cacheItem = catchupCacheItem;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d.this.new i(this.$session, this.$uri, this.$player, this.$params, this.$callback, this.$request, this.$cacheItem, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((i) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                i0 i0VarB = a1.b();
                a aVar = new a(d.this, this.$session, this.$uri, this.$player, this.$params, this.$callback, this.$request, this.$cacheItem, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(i0VarB, aVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.server.HttpServiceWrapper$onCatchupStartPlayRequest$1", f = "HttpServiceWrapper.kt", l = {212}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ a<T> $callback;
        final /* synthetic */ String $catchupStreamId;
        final /* synthetic */ String $player;
        final /* synthetic */ String $route;
        final /* synthetic */ String $session;
        final /* synthetic */ long $sessionValue;
        final /* synthetic */ long $startTimestamp;
        final /* synthetic */ long $stopTimestamp;
        final /* synthetic */ String $streamId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j10, String str, String str2, String str3, String str4, long j11, long j12, String str5, a<T> aVar, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$sessionValue = j10;
            this.$player = str;
            this.$streamId = str2;
            this.$catchupStreamId = str3;
            this.$route = str4;
            this.$startTimestamp = j11;
            this.$stopTimestamp = j12;
            this.$session = str5;
            this.$callback = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return d.this.new j(this.$sessionValue, this.$player, this.$streamId, this.$catchupStreamId, this.$route, this.$startTimestamp, this.$stopTimestamp, this.$session, this.$callback, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((j) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            j jVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                    jVar = this;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                d dVar = d.this;
                long j10 = this.$sessionValue;
                String str = this.$player;
                String str2 = this.$streamId;
                String str3 = this.$catchupStreamId;
                String str4 = this.$route;
                long j11 = this.$startTimestamp;
                long j12 = this.$stopTimestamp;
                this.label = 1;
                jVar = this;
                obj = dVar.p(j10, str, str2, str3, str4, j11, j12, jVar);
                if (obj == objC) {
                    return objC;
                }
            }
            String str5 = (String) obj;
            if (str5.length() > 0) {
                d.this.logger.a("session[" + jVar.$session + "] catchup playlist response, streamId[" + jVar.$streamId + "] route[" + jVar.$route + "] content-length[" + str5.length() + "]", new Object[0]);
                a<T> aVar = jVar.$callback;
                byte[] bytes = str5.getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                aVar.a(200, bytes, ContentTypes.DOC_MIME_TYPE);
            } else {
                d.this.logger.error("session[" + jVar.$session + "] catchup playlist response empty, streamId[" + jVar.$streamId + "] route[" + jVar.$route + "] content-length[" + str5.length() + "]", new Object[0]);
                a<T> aVar2 = jVar.$callback;
                byte[] bytes2 = "Not found".getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
                aVar2.a(404, bytes2, ContentTypes.DOC_MIME_TYPE);
            }
            return r8.z.f17874a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01bb A[Catch: all -> 0x01c4, TryCatch #2 {all -> 0x01c4, blocks: (B:73:0x01b5, B:75:0x01bb), top: B:119:0x01b5 }] */
    private final <T> int D(T params, long session, int player, a<T> callback) throws Throwable {
        byte[] bArr;
        String str;
        int i10;
        String str2;
        byte b10;
        ArrayList arrayList;
        char c10;
        long j10;
        String str3;
        String str4;
        Throwable th;
        d dVar;
        long j11;
        String str5;
        String str6;
        List<String> listC;
        Throwable th2;
        int i11;
        byte[] bytes;
        long j12;
        String localizedMessage;
        int i12;
        byte[] bArrD;
        List<String> list;
        int i13;
        int length;
        long j13;
        Map<String, String> mapL = l(callback.b(params, r.f21132a.j()));
        String str7 = mapL.get("mediaId");
        if (str7 == null) {
            str7 = "";
        }
        String str8 = str7;
        String str9 = mapL.get("mediaMode");
        byte b11 = str9 != null ? Byte.parseByte(str9) : (byte) 2;
        long jC = d1.c();
        ArrayList arrayList2 = new ArrayList();
        byte[] bytes2 = "Page Not found".getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
        int i14 = this.playListRequestCnt;
        this.playListRequestCnt = i14 + 1;
        int i15 = 404;
        String str10 = ContentTypes.DOC_MIME_TYPE;
        if (i14 == 0) {
            try {
                x1.f1.lb.util.a1 a1Var = x1.f1.lb.util.a1.f21305a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str8);
                c10 = 2;
                sb2.append(".receive_player_request");
                str2 = ".server_response[";
                bArr = bytes2;
                str = "getBytes(...)";
                b10 = b11;
                arrayList = arrayList2;
                str4 = "](";
                i10 = i14;
                str3 = " ms)";
                j10 = session;
                try {
                    x1.f1.lb.util.a1.h(a1Var, j10, sb2.toString(), false, 4, null);
                } catch (Throwable th3) {
                    th = th3;
                    dVar = this;
                    j11 = j10;
                    str5 = str8;
                    str6 = ContentTypes.DOC_MIME_TYPE;
                    listC = arrayList;
                    try {
                        localizedMessage = th.getLocalizedMessage();
                        if (localizedMessage == null) {
                            localizedMessage = "playlist failure";
                        }
                        try {
                            bytes = "Server Interval Error".getBytes(ua.d.UTF_8);
                            kotlin.jvm.internal.m.e(bytes, str);
                            try {
                                try {
                                    throw new RuntimeException(localizedMessage + " inRequest[mediaId=" + str5 + ", mediaMode=" + ((int) b10) + ", session=" + j11 + "], playType[" + dVar.playType + "]", th);
                                } catch (Throwable th4) {
                                    th = th4;
                                    bytes = bytes;
                                    th2 = th;
                                    i11 = 500;
                                    long jC2 = d1.c();
                                    long j14 = jC2 - jC;
                                    try {
                                        o oVarX = x1.f1.lb.metric.monitor.g.f20917a.x(j11);
                                        if (oVarX != null) {
                                            oVarX.c(player, jC2, j14, bytes.length, listC);
                                            j12 = j14;
                                            try {
                                                r8.z zVar = r8.z.f17874a;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                Throwable th6 = th;
                                                callback.a(i11, bytes, str6);
                                                if (i10 != 0) {
                                                    throw th6;
                                                }
                                                x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, session, str5 + str2 + i11 + str4 + j12 + str3, false, 4, null);
                                                throw th6;
                                            }
                                        } else {
                                            j12 = j14;
                                        }
                                        callback.a(i11, bytes, str6);
                                        if (i10 != 0) {
                                            throw th2;
                                        }
                                        x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, j11, str5 + str2 + i11 + str4 + j12 + str3, false, 4, null);
                                        throw th2;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        j12 = j14;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th2 = th9;
                            bytes = bArr;
                        }
                    } catch (Throwable th10) {
                        th2 = th10;
                        i11 = i15;
                        bytes = bArr;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                str = "getBytes(...)";
                i10 = i14;
                str2 = ".server_response[";
                bArr = bytes2;
                b10 = b11;
                arrayList = arrayList2;
                j10 = session;
                str3 = " ms)";
                str4 = "](";
                dVar = this;
                j11 = j10;
                str5 = str8;
                str6 = ContentTypes.DOC_MIME_TYPE;
                listC = arrayList;
                localizedMessage = th.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "playlist failure";
                }
                bytes = "Server Interval Error".getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes, str);
                throw new RuntimeException(localizedMessage + " inRequest[mediaId=" + str5 + ", mediaMode=" + ((int) b10) + ", session=" + j11 + "], playType[" + dVar.playType + "]", th);
            }
        } else {
            bArr = bytes2;
            str = "getBytes(...)";
            i10 = i14;
            str2 = ".server_response[";
            b10 = b11;
            arrayList = arrayList2;
            c10 = 2;
            j10 = session;
            str3 = " ms)";
            str4 = "](";
        }
        x1.f1.lb.metric.monitor.g gVar = x1.f1.lb.metric.monitor.g.f20917a;
        o oVarX2 = gVar.x(j10);
        if (oVarX2 != null) {
            i12 = player;
            oVarX2.e(i12, jC);
        } else {
            i12 = player;
        }
        byte[] bArrS = s(j10, str8);
        List<String> listV = v(bArrS);
        if (x1.f1.lb.config.b.f20643a.t()) {
            try {
                q6.b bVar = this.logger;
                Long lValueOf = Long.valueOf(j10);
                String strA = a(listV);
                Object[] objArr = new Object[3];
                objArr[0] = lValueOf;
                objArr[1] = strA;
                objArr[c10] = arrayList;
                bVar.debug("play_list [{}]\n{}\n{}", objArr);
            } catch (Throwable th12) {
                th = th12;
                dVar = this;
                j11 = j10;
                str5 = str8;
                str6 = ContentTypes.DOC_MIME_TYPE;
                listC = arrayList;
                localizedMessage = th.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "playlist failure";
                }
                bytes = "Server Interval Error".getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes, str);
                throw new RuntimeException(localizedMessage + " inRequest[mediaId=" + str5 + ", mediaMode=" + ((int) b10) + ", session=" + j11 + "], playType[" + dVar.playType + "]", th);
            }
        }
        if (bArrS != null) {
            str5 = str8;
            try {
                r8.p<List<String>, byte[]> pVarB = B(listV, j10, i12, str5);
                dVar = this;
                try {
                    listC = pVarB.c();
                    try {
                        bArrD = pVarB.d();
                        i15 = 200;
                        try {
                            str10 = "application/vnd.apple.mpegurl";
                            list = listC;
                            length = bArrS.length;
                            i13 = 200;
                        } catch (Throwable th13) {
                            th = th13;
                            bArr = bArrD;
                            j11 = j10;
                            str6 = str10;
                            localizedMessage = th.getLocalizedMessage();
                            if (localizedMessage == null) {
                                localizedMessage = "playlist failure";
                            }
                            bytes = "Server Interval Error".getBytes(ua.d.UTF_8);
                            kotlin.jvm.internal.m.e(bytes, str);
                            throw new RuntimeException(localizedMessage + " inRequest[mediaId=" + str5 + ", mediaMode=" + ((int) b10) + ", session=" + j11 + "], playType[" + dVar.playType + "]", th);
                        }
                    } catch (Throwable th14) {
                        th = th14;
                    }
                } catch (Throwable th15) {
                    th = th15;
                    j11 = j10;
                    str6 = ContentTypes.DOC_MIME_TYPE;
                    listC = arrayList;
                    localizedMessage = th.getLocalizedMessage();
                    if (localizedMessage == null && (localizedMessage = th.getMessage()) == null) {
                        localizedMessage = "playlist failure";
                    }
                    bytes = "Server Interval Error".getBytes(ua.d.UTF_8);
                    kotlin.jvm.internal.m.e(bytes, str);
                    throw new RuntimeException(localizedMessage + " inRequest[mediaId=" + str5 + ", mediaMode=" + ((int) b10) + ", session=" + j11 + "], playType[" + dVar.playType + "]", th);
                }
            } catch (Throwable th16) {
                th = th16;
                dVar = this;
            }
        } else {
            str5 = str8;
            bArrD = bArr;
            list = arrayList;
            i13 = 404;
            length = 0;
        }
        String str11 = str10;
        long jC3 = d1.c();
        long j15 = jC3 - jC;
        try {
            o oVarX3 = gVar.x(j10);
            if (oVarX3 != null) {
                oVarX3.c(player, jC3, j15, bArrD.length, list);
                j13 = j15;
                try {
                    r8.z zVar2 = r8.z.f17874a;
                } catch (Throwable th17) {
                    th = th17;
                    Throwable th18 = th;
                    callback.a(i13, bArrD, str11);
                    if (i10 != 0) {
                        throw th18;
                    }
                    x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, session, str5 + str2 + i13 + str4 + j13 + str3, false, 4, null);
                    throw th18;
                }
            } else {
                j13 = j15;
            }
            callback.a(i13, bArrD, str11);
            if (i10 == 0) {
                x1.f1.lb.util.a1.h(x1.f1.lb.util.a1.f21305a, session, str5 + str2 + i13 + str4 + j13 + str3, false, 4, null);
            }
            return length;
        } catch (Throwable th19) {
            th = th19;
            j13 = j15;
        }
    }

    private final boolean J(String sessionStr, String params) {
        Boolean boolL;
        if (params == null || params.length() == 0) {
            this.logger.error("empty parameter to start play", new Object[0]);
            return false;
        }
        this.lastIndex = null;
        Map<String, String> mapL = l(params);
        String str = mapL.get("mediaId");
        String str2 = mapL.get("routeId");
        String str3 = mapL.get("mediaMode");
        int i10 = str3 != null ? Integer.parseInt(str3) : 0;
        long j10 = sessionStr != null ? Long.parseLong(sessionStr) : 0L;
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            this.logger.debug("start play [" + str + ", " + i10 + ", " + j10 + "]", new Object[0]);
        }
        try {
            b bVar2 = this.clientEngineService;
            boolean zBooleanValue = (bVar2 == null || (boolL = bVar2.L(str, str2, i10, j10)) == null) ? false : boolL.booleanValue();
            if (!zBooleanValue) {
                if (bVar.t()) {
                    this.logger.debug("start play failure, params{}", mapL);
                    return zBooleanValue;
                }
                this.logger.debug("start play failure, session{}", Long.valueOf(j10));
                return zBooleanValue;
            }
            if (bVar.t()) {
                this.logger.debug("set play_session[" + j10 + "]", new Object[0]);
            }
            this.playSession.set(j10);
            this.playListRequestCnt = 0;
            this.playBlockResponseCnt = 0;
            this.blockDurations = new HashMap<>();
            this.blockCacheHitMap = new HashMap<>();
            x1.f1.lb.metric.monitor.g.f20917a.y(j10);
            return zBooleanValue;
        } catch (Throwable th) {
            String localizedMessage = th.getLocalizedMessage();
            if (localizedMessage == null) {
                localizedMessage = th.getMessage();
            }
            throw new RuntimeException(localizedMessage + " [" + str + ", " + i10 + "]", th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"x1/f1/lb/streaming/server/d$k", "Lf3/a;", "", "Lz1/b1/lb/m/user/ServerResponse;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k extends f3.a<List<? extends ServerResponse>> {
        k() {
        }
    }

    private final <T> void A(T params, a<T> callback) {
        byte[] bArrM;
        try {
            long j10 = this.playSession.get();
            r rVar = r.f21132a;
            bArrM = M(j10, callback.b(params, rVar.i()), callback.b(params, rVar.f()));
        } catch (Exception e10) {
            this.logger.error("load failure", e10);
            bArrM = null;
        }
        if (bArrM != null) {
            callback.a(200, bArrM, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        byte[] bytes = "Not found".getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        callback.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
    }

    private final r8.p<List<String>, byte[]> B(List<String> m3u8List, long session, int player, String mediaId) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        String strW = x1.f1.lb.streaming.a.f20960a.w("play_session=" + session + "&player=" + player + "&media_id=" + mediaId);
        if (this.playType != v6.c.VOD) {
            x1.f1.lb.metric.monitor.f fVar = x1.f1.lb.metric.monitor.f.f20907a;
            if (fVar.f() > 0) {
                fVar.f();
            }
        }
        Iterator<String> it = m3u8List.iterator();
        while (it.hasNext()) {
            String string = ua.n.Q0(it.next()).toString();
            if (ua.n.I(string, "#", false, 2, null)) {
                sb2.append(string);
                sb2.append("\n");
                if (ua.n.I(string, "#EXTINF:", false, 2, null) && this.blockDurations.size() < 3) {
                    try {
                        arrayList2.add(Double.valueOf(dc.a.a(ua.n.R0(string.subSequence(8, string.length()), ',').toString())));
                    } catch (Throwable th) {
                        this.logger.error("parse ext-info failure", th);
                    }
                }
            } else {
                sb2.append(string);
                if (ua.n.O(string, LocationInfo.NA, false, 2, null)) {
                    sb2.append("&");
                } else {
                    sb2.append(LocationInfo.NA);
                }
                sb2.append(r.f21132a.j() + "=" + strW + "\n");
                arrayList.add(string);
                if (arrayList2.size() >= arrayList.size() && this.blockDurations.size() < 3) {
                    Object obj = arrayList2.get(arrayList.size() - 1);
                    kotlin.jvm.internal.m.e(obj, "get(...)");
                    this.blockDurations.put(string, Double.valueOf(((Number) obj).doubleValue()));
                }
            }
        }
        String string2 = sb2.toString();
        kotlin.jvm.internal.m.e(string2, "toString(...)");
        byte[] bytes = string2.getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        return new r8.p<>(arrayList, bytes);
    }

    private final <T> int C(int player, String uri, long session, String mediaId, a<T> callback) throws Throwable {
        String str;
        int i10;
        int i11;
        Boolean bool;
        int i12;
        int i13;
        int i14;
        Boolean bool2;
        if (ua.n.T0(uri) == '/') {
            String strSubstring = uri.substring(1, uri.length());
            kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
            str = strSubstring;
        } else {
            str = uri;
        }
        String strO0 = ua.n.O0(str, ".ts", null, 2, null);
        long jC = d1.c();
        byte[] bytes = "Page Not found".getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        String str2 = ContentTypes.DOC_MIME_TYPE;
        int i15 = 404;
        try {
            x1.f1.lb.metric.monitor.g gVar = x1.f1.lb.metric.monitor.g.f20917a;
            n nVarV = gVar.v(session);
            if (nVarV != null) {
                i12 = player;
                nVarV.i(i12, jC, strO0);
            } else {
                i12 = player;
            }
            byte[] bArrK = TextUtils.isEmpty(strO0) ? null : k(session, mediaId, strO0);
            if (bArrK != null) {
                i15 = 200;
                try {
                    int length = bArrK.length;
                    try {
                        str2 = "video/m2ts";
                        this.playBlockResponseCnt++;
                        i13 = length;
                        bytes = bArrK;
                    } catch (Throwable th) {
                        th = th;
                        i11 = length;
                        i10 = 200;
                        bytes = bArrK;
                        str2 = str2;
                        try {
                            byte[] bytes2 = "Server Internal Error".getBytes(ua.d.UTF_8);
                            kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                th = th2;
                                bytes = bytes2;
                                long jC2 = d1.c();
                                long j10 = jC2 - jC;
                                try {
                                    Double d10 = this.blockDurations.get(str);
                                    HashMap<String, Boolean> map = this.blockCacheHitMap;
                                    boolean zBooleanValue = (map == null || (bool = map.get(str)) == null) ? false : bool.booleanValue();
                                    n nVarV2 = x1.f1.lb.metric.monitor.g.f20917a.v(session);
                                    if (nVarV2 != null) {
                                        nVarV2.a(player, jC2, j10, strO0, i11, d10, Boolean.valueOf(zBooleanValue));
                                        r8.z zVar = r8.z.f17874a;
                                    }
                                    throw th;
                                } finally {
                                    callback.a(i10, bytes, str2);
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bytes = bArrK;
                    i10 = 200;
                    i11 = 0;
                    byte[] bytes3 = "Server Internal Error".getBytes(ua.d.UTF_8);
                    kotlin.jvm.internal.m.e(bytes3, "getBytes(...)");
                    throw th;
                }
            } else {
                i13 = 0;
            }
            String str3 = str2;
            long jC3 = d1.c();
            long j11 = jC3 - jC;
            try {
                Double d11 = this.blockDurations.get(str);
                HashMap<String, Boolean> map2 = this.blockCacheHitMap;
                boolean zBooleanValue2 = (map2 == null || (bool2 = map2.get(str)) == null) ? false : bool2.booleanValue();
                n nVarV3 = gVar.v(session);
                if (nVarV3 != null) {
                    i14 = i15;
                    try {
                        nVarV3.a(i12, jC3, j11, strO0, i13, d11, Boolean.valueOf(zBooleanValue2));
                        r8.z zVar2 = r8.z.f17874a;
                    } catch (Throwable th5) {
                        th = th5;
                        callback.a(i14, bytes, str3);
                        throw th;
                    }
                } else {
                    i14 = i15;
                }
                callback.a(i14, bytes, str3);
                return i13;
            } catch (Throwable th6) {
                th = th6;
                i14 = i15;
            }
        } catch (Throwable th7) {
            th = th7;
            i10 = 404;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CatchupCacheItem E(long session, String urlPrefix, CatchupPlayRequest request, CatchupPlayResponse response) {
        CatchupCacheItem catchupCacheItem = new CatchupCacheItem(urlPrefix, request, response, (response.getValidTime() * ((long) 1000)) + d1.d(), 0, 16, null);
        this.catchupPlayResponseCache.put(Long.valueOf(session), catchupCacheItem);
        return catchupCacheItem;
    }

    private final String F(String encode) {
        String strV = x1.f1.lb.streaming.a.f20960a.v(encode);
        b bVar = this.clientEngineService;
        if (bVar == null) {
            return "false";
        }
        bVar.F(strV);
        return "true";
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0101  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    private final boolean I(String params) {
        char c10;
        Boolean boolK;
        List listL;
        String[] strArr;
        String str;
        String str2;
        String str3;
        String str4;
        int iBooleanValue = 0;
        if (params == null || params.length() == 0) {
            this.logger.error("empty parameter to start engine", new Object[0]);
            return false;
        }
        Map<String, String> mapL = l(params);
        String str5 = mapL.get("addressList");
        String str6 = mapL.get("token");
        String str7 = mapL.get("uid");
        String str8 = mapL.get("did");
        String str9 = mapL.get("tenantId");
        String str10 = mapL.get("deviceType");
        int i10 = str10 != null ? Integer.parseInt(str10) : 0;
        String str11 = mapL.get(IjkMediaMeta.IJKM_KEY_TYPE);
        Byte bValueOf = str11 != null ? Byte.valueOf(Byte.parseByte(str11)) : null;
        if (bValueOf != null) {
            this.playType = v6.c.i(bValueOf.byteValue());
        }
        try {
            Object objO = new com.google.gson.e().o(str5, new k().d());
            kotlin.jvm.internal.m.e(objO, "fromJson(...)");
            ArrayList arrayList = new ArrayList();
            for (ServerResponse serverResponse : (List) objO) {
                e7.b bVar = new e7.b();
                bVar.f(serverResponse.getServerId());
                String serverAddress = serverResponse.getServerAddress();
                if (serverAddress != null) {
                    try {
                        List<String> listG = new ua.l(":").g(serverAddress, iBooleanValue);
                        if (listG == null) {
                            strArr = null;
                        } else {
                            if (listG.isEmpty()) {
                                listL = kotlin.collections.r.l();
                                break;
                            }
                            ListIterator<String> listIterator = listG.listIterator(listG.size());
                            while (true) {
                                if (!listIterator.hasPrevious()) {
                                    listL = kotlin.collections.r.l();
                                    break;
                                }
                                if (listIterator.previous().length() != 0) {
                                    listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                                    break;
                                }
                            }
                            if (listL != null) {
                                strArr = (String[]) listL.toArray(new String[iBooleanValue]);
                            } else {
                                strArr = null;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        c10 = 0;
                        q6.b bVar2 = this.logger;
                        Object[] objArr = new Object[1];
                        objArr[c10] = th;
                        bVar2.error("start engine failure in proxy", objArr);
                        return iBooleanValue;
                    }
                } else {
                    strArr = null;
                }
                String str12 = "";
                String str13 = (strArr == null || (str4 = strArr[iBooleanValue]) == null) ? "" : str4;
                if (strArr != null && (str3 = strArr[1]) != null) {
                    iBooleanValue = Integer.parseInt(str3);
                }
                c10 = 0;
                try {
                    bVar.e(new InetSocketAddress(str13, iBooleanValue));
                    if (strArr != null && (str2 = strArr[0]) != null) {
                        str12 = str2;
                    }
                    bVar.e(new InetSocketAddress(str12, (strArr == null || (str = strArr[1]) == null) ? 0 : Integer.parseInt(str)));
                    arrayList.add(bVar);
                    iBooleanValue = 0;
                } catch (Throwable th2) {
                    th = th2;
                    iBooleanValue = 0;
                    q6.b bVar3 = this.logger;
                    Object[] objArr2 = new Object[1];
                    objArr2[c10] = th;
                    bVar3.error("start engine failure in proxy", objArr2);
                    return iBooleanValue;
                }
            }
            c10 = 0;
            b bVar4 = this.clientEngineService;
            iBooleanValue = (bVar4 == null || (boolK = bVar4.K(str7, str8, str6, str9, i10, arrayList, this.playType)) == null) ? 0 : boolK.booleanValue();
            try {
                if (!x1.f1.lb.config.b.f20643a.t() || iBooleanValue != 0) {
                    return iBooleanValue;
                }
                this.logger.debug("start play failure, params{}", mapL);
                return iBooleanValue;
            } catch (Throwable th3) {
                th = th3;
                q6.b bVar5 = this.logger;
                Object[] objArr3 = new Object[1];
                objArr3[c10] = th;
                bVar5.error("start engine failure in proxy", objArr3);
                return iBooleanValue;
            }
        } catch (Throwable th4) {
            th = th4;
            c10 = 0;
        }
    }

    private final boolean K() {
        Boolean boolM;
        long andSet = this.playSession.getAndSet(0L);
        synchronized (this.validPlayer) {
            this.validPlayer.remove(Long.valueOf(andSet));
        }
        b bVar = this.clientEngineService;
        if (bVar == null || (boolM = bVar.M()) == null) {
            return false;
        }
        return boolM.booleanValue();
    }

    private final byte[] M(long session, String mediaId, String lang) {
        b bVar = this.clientEngineService;
        if (bVar == null) {
            return null;
        }
        String upperCase = lang.toUpperCase(Locale.ROOT);
        kotlin.jvm.internal.m.e(upperCase, "toUpperCase(...)");
        return bVar.A(session, mediaId, upperCase + ".srt", Priority.WARN_INT);
    }

    private final String a(List<String> m3u8List) {
        StringBuilder sb2 = new StringBuilder();
        if (m3u8List.size() < 20) {
            Iterator<String> it = m3u8List.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append("\n");
            }
        } else {
            int size = m3u8List.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (i10 <= 8 || i10 >= m3u8List.size() - 8) {
                    if (i10 == 8) {
                        sb2.append("...");
                        sb2.append("\n");
                    } else {
                        sb2.append(m3u8List.get(i10));
                        sb2.append("\n");
                    }
                }
            }
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString(...)");
        return string;
    }

    private final byte[] k(long session, String mediaId, String blockName) {
        b bVar = this.clientEngineService;
        if (bVar == null) {
            return null;
        }
        return bVar.z(session, mediaId, blockName + ".ts");
    }

    private final Map<String, String> l(String params) {
        return r.f21132a.a(params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void m(String uri, long session, int player, String urlPrefix, String token, T params, a<T> callback) {
        String str;
        String strSubstring;
        String strV = x1.f1.lb.streaming.a.f20960a.v(callback.b(params, r.f21132a.c()));
        if (token == null || token.length() == 0) {
            str = urlPrefix + "/" + strV;
        } else {
            str = urlPrefix + "/" + strV + LocationInfo.NA + token;
        }
        String str2 = str;
        long jD = d1.d();
        z zVar = new z();
        CatchupCacheItem catchupCacheItem = this.catchupPlayResponseCache.get(Long.valueOf(session));
        Integer numValueOf = catchupCacheItem != null ? Integer.valueOf(catchupCacheItem.getListSize()) : null;
        x1.f1.lb.metric.monitor.g gVar = x1.f1.lb.metric.monitor.g.f20917a;
        n nVarV = gVar.v(session);
        if (nVarV != null) {
            nVarV.i(player, jD, strV);
        }
        String str3 = strV + " -> " + ua.n.E(uri, "/", "", false, 4, null) + " | " + numValueOf;
        this.logger.a("session[" + session + "] downloading catchup block[" + str3 + "]", new Object[0]);
        x1.f1.lb.util.b0.f21310a.f(str2, new c(jD, callback, this, session, str2, zVar, str3), new C0446d(jD, this, session, str3, str2, callback));
        long jC = d1.c();
        long j10 = jC - jD;
        try {
            if (ua.n.T0(uri) == '/') {
                strSubstring = uri.substring(1, uri.length());
                kotlin.jvm.internal.m.e(strSubstring, "substring(...)");
            } else {
                strSubstring = uri;
            }
            String strO0 = ua.n.O0(strSubstring, ".ts", null, 2, null);
            Double d10 = this.blockDurations.get(strSubstring);
            n nVarV2 = gVar.v(session);
            if (nVarV2 != null) {
                nVarV2.a(player, jC, j10, strO0, zVar.element, d10, Boolean.FALSE);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.StringBuilder] */
    public final r8.p<List<String>, StringBuilder> n(long session, String player, String urlPrefix, String token, String url) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        b0 b0Var = new b0();
        b0Var.element = new StringBuilder();
        long jD = d1.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        o oVarX = x1.f1.lb.metric.monitor.g.f20917a.x(session);
        if (oVarX != null) {
            oVarX.e(Integer.parseInt(player), d1.d());
        }
        x1.f1.lb.util.b0.f21310a.f(url, new e(token, urlPrefix, this, session, player, b0Var, arrayList, arrayList2, url, countDownLatch), new f(jD, this, session, url));
        countDownLatch.await();
        return new r8.p<>(arrayList, b0Var.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object o(long j10, String str, CatchupPlayRequest catchupPlayRequest, String str2, v8.f<? super CatchupPlayResponse> fVar) {
        g gVar;
        int i10;
        d dVar;
        long j11;
        String str3;
        String str4;
        long j12;
        CatchupPlayRequest catchupPlayRequest2;
        int i11;
        String str5;
        if (fVar instanceof g) {
            gVar = (g) fVar;
            int i12 = gVar.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                gVar.label = i12 - Integer.MIN_VALUE;
            } else {
                gVar = new g(fVar);
            }
        } else {
            gVar = new g(fVar);
        }
        Object obj = gVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i13 = gVar.label;
        if (i13 == 0) {
            r8.r.b(obj);
            long jD = d1.d();
            x1.f1.lb.api.b bVar = x1.f1.lb.api.b.f20552a;
            of.a aVar = of.a.f16585a;
            String strValueOf = String.valueOf(aVar.h());
            String strValueOf2 = String.valueOf(aVar.a());
            long jI = aVar.i();
            String strK = aVar.k();
            String strL = aVar.l();
            long jD2 = d1.d();
            String strG = aVar.g();
            String strB = aVar.b();
            gVar.L$0 = this;
            gVar.L$1 = str;
            gVar.L$2 = catchupPlayRequest;
            gVar.L$3 = str2;
            gVar.J$0 = j10;
            gVar.J$1 = jD;
            i10 = 1;
            gVar.label = 1;
            Object objE = bVar.e(strValueOf, strValueOf2, jI, "", strK, strL, 1, 2000, jD2, strG, strB, catchupPlayRequest, gVar);
            if (objE == objC) {
                return objC;
            }
            dVar = this;
            j11 = j10;
            str3 = str;
            str4 = str2;
            obj = objE;
            j12 = jD;
            catchupPlayRequest2 = catchupPlayRequest;
        } else {
            if (i13 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j12 = gVar.J$1;
            long j13 = gVar.J$0;
            String str6 = (String) gVar.L$3;
            CatchupPlayRequest catchupPlayRequest3 = (CatchupPlayRequest) gVar.L$2;
            str3 = (String) gVar.L$1;
            d dVar2 = (d) gVar.L$0;
            r8.r.b(obj);
            dVar = dVar2;
            j11 = j13;
            str4 = str6;
            catchupPlayRequest2 = catchupPlayRequest3;
            i10 = 1;
        }
        n6.b bVar2 = (n6.b) com.skydoves.sandwich.b.b((com.skydoves.sandwich.a) obj);
        long jD3 = d1.d() - j12;
        CatchupPlayResponse catchupPlayResponse = (CatchupPlayResponse) bVar2.getData();
        if (catchupPlayResponse != null) {
            dVar.logger.a(str4 + " complete [" + j11 + "][" + catchupPlayRequest2.getStreamId() + "][" + catchupPlayRequest2.getCatchupStreamId() + "][" + catchupPlayRequest2.getStartTimestamp() + "][" + catchupPlayRequest2.getEndTimestamp() + "][" + jD3 + " ms]", new Object[0]);
            return catchupPlayResponse;
        }
        if (kotlin.jvm.internal.m.a(bVar2.getCode(), "200-3")) {
            try {
                i11 = Integer.parseInt(str3);
            } catch (Throwable th) {
                Object[] objArr = new Object[i10];
                objArr[0] = th;
                dVar.logger.error("invalid player id[" + str3 + "]", objArr);
                i11 = 0;
            }
            String catchupStreamId = catchupPlayRequest2.getCatchupStreamId();
            String strD = bVar2.d();
            if (strD == null) {
                strD = "not free";
            }
            str5 = "][";
            xe.c.c().o(new v(catchupStreamId, j11, i11, 1000, strD));
        } else {
            str5 = "][";
        }
        dVar.logger.error(str4 + " failure [" + j11 + str5 + catchupPlayRequest2.getStreamId() + str5 + catchupPlayRequest2.getCatchupStreamId() + str5 + catchupPlayRequest2.getStartTimestamp() + str5 + catchupPlayRequest2.getEndTimestamp() + str5 + jD3 + " ms]: [" + bVar2.getCode() + str5 + bVar2.d() + "]", new Object[0]);
        return catchupPlayResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:109:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00ef A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00f0 A[Catch: all -> 0x0284, TRY_LEAVE, TryCatch #2 {all -> 0x0284, blocks: (B:29:0x00eb, B:32:0x00f0), top: B:107:0x00eb }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0127  */
    /* JADX WARN: Code duplicated, block: B:39:0x012c  */
    /* JADX WARN: Code duplicated, block: B:42:0x013b A[Catch: all -> 0x014b, TryCatch #6 {all -> 0x014b, blocks: (B:40:0x0135, B:42:0x013b, B:46:0x0154), top: B:116:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x0154 A[Catch: all -> 0x014b, TRY_LEAVE, TryCatch #6 {all -> 0x014b, blocks: (B:40:0x0135, B:42:0x013b, B:46:0x0154), top: B:116:0x0135 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:70:0x01e2 A[Catch: all -> 0x021b, TRY_ENTER, TRY_LEAVE, TryCatch #12 {all -> 0x021b, blocks: (B:67:0x01d3, B:70:0x01e2), top: B:128:0x01d3 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0221 A[Catch: all -> 0x0215, TryCatch #10 {all -> 0x0215, blocks: (B:72:0x01f1, B:78:0x0257, B:77:0x0221), top: B:124:0x01e0 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x013b, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x0154, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x0221, please report this as an issue */
    public final Object p(long j10, String str, String str2, String str3, String str4, long j11, long j12, v8.f<? super String> fVar) {
        h hVar;
        String str5;
        String str6;
        d dVar;
        long j13;
        Object obj;
        long j14;
        long j15;
        String str7;
        String str8;
        String str9;
        d dVar2;
        long j16;
        String str10;
        Object obj2;
        long j17;
        CatchupPlayRequest catchupPlayRequest;
        long j18;
        CatchupPlayResponse catchupPlayResponse;
        String playUrl;
        String token;
        String str11;
        long j19;
        String str12;
        d dVar3;
        List<String> listC;
        StringBuilder sbD;
        long jD;
        long j20;
        o oVarX;
        if (fVar instanceof h) {
            hVar = (h) fVar;
            int i10 = hVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                hVar.label = i10 - Integer.MIN_VALUE;
            } else {
                hVar = new h(fVar);
            }
        } else {
            hVar = new h(fVar);
        }
        h hVar2 = hVar;
        Object obj3 = hVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = hVar2.label;
        if (i11 == 0) {
            r8.r.b(obj3);
            CatchupPlayRequest catchupPlayRequest2 = new CatchupPlayRequest();
            catchupPlayRequest2.setStreamId(str2);
            catchupPlayRequest2.setCatchupRoute(str4);
            long j21 = 1000;
            catchupPlayRequest2.setStartTimestamp(j11 / j21);
            catchupPlayRequest2.setEndTimestamp(j12 / j21);
            catchupPlayRequest2.setCatchupStreamId(str3);
            try {
                hVar2.L$0 = this;
                hVar2.L$1 = str;
                hVar2.L$2 = str2;
                hVar2.L$3 = str3;
                hVar2.L$4 = str4;
                hVar2.L$5 = catchupPlayRequest2;
                try {
                    hVar2.J$0 = j10;
                    hVar2.J$1 = j11;
                    hVar2.J$2 = j12;
                    hVar2.label = 1;
                    str5 = "session[";
                    str6 = "]";
                    try {
                        Object objO = o(j10, str, catchupPlayRequest2, "get catchup url", hVar2);
                        if (objO == objC) {
                            return objC;
                        }
                        dVar2 = this;
                        j16 = j10;
                        str10 = str;
                        obj2 = objO;
                        j17 = j11;
                        str9 = str4;
                        catchupPlayRequest = catchupPlayRequest2;
                        j15 = j12;
                        str7 = str2;
                        str8 = str3;
                        catchupPlayResponse = (CatchupPlayResponse) obj2;
                        if (catchupPlayResponse == null) {
                            return "";
                        }
                        playUrl = catchupPlayResponse.getPlayUrl();
                        token = catchupPlayResponse.getToken();
                        kotlin.jvm.internal.m.c(playUrl);
                        str11 = str10;
                        str9 = null;
                        j19 = j16;
                        String strV0 = ua.n.V0(playUrl, ua.n.h0(playUrl, "/", 0, false, 6, null));
                        if (token == null) {
                            j18 = j17;
                            str12 = playUrl;
                        } else if (token.length() == 0) {
                            j18 = j17;
                            str12 = playUrl;
                        } else {
                            j18 = j17;
                            if (ua.n.v(playUrl, LocationInfo.NA, false, 2, null)) {
                                str12 = playUrl + token;
                            } else {
                                str12 = playUrl + LocationInfo.NA + token;
                            }
                        }
                        long jD2 = d1.d();
                        kotlin.jvm.internal.m.c(str12);
                        dVar3 = dVar2;
                        r8.p<List<String>, StringBuilder> pVarN = dVar3.n(j19, str11, strV0, token, str12);
                        listC = pVarN.c();
                        sbD = pVarN.d();
                        dVar3 = dVar3;
                        j19 = j19;
                        CatchupCacheItem catchupCacheItemE = dVar3.E(j19, strV0, catchupPlayRequest, catchupPlayResponse);
                        dVar = dVar3;
                        j13 = j19;
                        jD = d1.d();
                        j20 = jD - jD2;
                        oVarX = x1.f1.lb.metric.monitor.g.f20917a.x(j13);
                        if (oVarX != null) {
                            oVarX.c(Integer.parseInt(str11), jD, j20, sbD.length(), listC);
                        }
                        catchupCacheItemE.f(listC.size());
                        if (listC.isEmpty()) {
                            q6.b bVar = dVar.logger;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str5);
                            sb2.append(j13);
                            sb2.append("] get catchup playlist complete size[0][");
                            sb2.append(j20);
                            sb2.append(" ms][");
                            sb2.append(playUrl);
                            sb2.append("][");
                            sb2.append((Object) sbD);
                            sb2.append(str6);
                            bVar.error(sb2.toString(), new Object[0]);
                        } else {
                            dVar.logger.a(str5 + j13 + "] get catchup playlist complete size[" + listC.size() + "][" + j20 + " ms][" + playUrl + str6, new Object[0]);
                        }
                        String string = sbD.toString();
                        kotlin.jvm.internal.m.e(string, "toString(...)");
                        return string;
                        obj = th;
                        j14 = j18;
                    } catch (Throwable th) {
                        th = th;
                        dVar = this;
                        j13 = j10;
                        obj = th;
                        j14 = j11;
                        j15 = j12;
                        str7 = str2;
                        str8 = str3;
                        str9 = str4;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str5 = "session[";
                    str6 = "]";
                    dVar = this;
                    j13 = j10;
                    obj = th;
                    j14 = j11;
                    j15 = j12;
                    str7 = str2;
                    str8 = str3;
                    str9 = str4;
                    dVar.logger.error(str5 + j13 + "] get catchup url failure [" + str7 + "][" + str8 + "][" + str9 + "][" + j14 + "][" + j15 + str6, obj);
                    return "";
                }
            } catch (Throwable th3) {
                th = th3;
                str5 = "session[";
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            long j22 = hVar2.J$2;
            long j23 = hVar2.J$1;
            long j24 = hVar2.J$0;
            CatchupPlayRequest catchupPlayRequest3 = (CatchupPlayRequest) hVar2.L$5;
            str9 = (String) hVar2.L$4;
            str8 = (String) hVar2.L$3;
            str7 = (String) hVar2.L$2;
            obj2 = obj3;
            str10 = (String) hVar2.L$1;
            dVar2 = (d) hVar2.L$0;
            try {
                r8.r.b(obj2);
                catchupPlayRequest = catchupPlayRequest3;
                str6 = "]";
                str5 = "session[";
                j15 = j22;
                j17 = j23;
                j16 = j24;
                try {
                    catchupPlayResponse = (CatchupPlayResponse) obj2;
                    if (catchupPlayResponse == null) {
                        return "";
                    }
                    playUrl = catchupPlayResponse.getPlayUrl();
                    token = catchupPlayResponse.getToken();
                    kotlin.jvm.internal.m.c(playUrl);
                    str11 = str10;
                    str9 = null;
                    j19 = j16;
                    try {
                        String strV1 = ua.n.V0(playUrl, ua.n.h0(playUrl, "/", 0, false, 6, null));
                        if (token == null) {
                            try {
                                if (token.length() == 0) {
                                    j18 = j17;
                                    str12 = playUrl;
                                } else {
                                    j18 = j17;
                                    try {
                                        if (ua.n.v(playUrl, LocationInfo.NA, false, 2, null)) {
                                            str12 = playUrl + token;
                                        } else {
                                            str12 = playUrl + LocationInfo.NA + token;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        j13 = j19;
                                        obj = th;
                                        dVar = dVar2;
                                        j14 = j18;
                                        dVar.logger.error(str5 + j13 + "] get catchup url failure [" + str7 + "][" + str8 + "][" + str9 + "][" + j14 + "][" + j15 + str6, obj);
                                        return "";
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                j18 = j17;
                            }
                        } else {
                            j18 = j17;
                            str12 = playUrl;
                        }
                        try {
                            long jD3 = d1.d();
                            kotlin.jvm.internal.m.c(str12);
                            dVar3 = dVar2;
                            try {
                                r8.p<List<String>, StringBuilder> pVarN2 = dVar3.n(j19, str11, strV1, token, str12);
                                try {
                                    listC = pVarN2.c();
                                    sbD = pVarN2.d();
                                    dVar3 = dVar3;
                                    j19 = j19;
                                    CatchupCacheItem catchupCacheItemE2 = dVar3.E(j19, strV1, catchupPlayRequest, catchupPlayResponse);
                                    dVar = dVar3;
                                    j13 = j19;
                                    try {
                                        jD = d1.d();
                                        j20 = jD - jD3;
                                        oVarX = x1.f1.lb.metric.monitor.g.f20917a.x(j13);
                                        if (oVarX != null) {
                                            try {
                                                oVarX.c(Integer.parseInt(str11), jD, j20, sbD.length(), listC);
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                        }
                                        try {
                                            catchupCacheItemE2.f(listC.size());
                                            try {
                                                if (listC.isEmpty()) {
                                                    q6.b bVar2 = dVar.logger;
                                                    StringBuilder sb3 = new StringBuilder();
                                                    sb3.append(str5);
                                                    sb3.append(j13);
                                                    sb3.append("] get catchup playlist complete size[0][");
                                                    sb3.append(j20);
                                                    sb3.append(" ms][");
                                                    sb3.append(playUrl);
                                                    sb3.append("][");
                                                    sb3.append((Object) sbD);
                                                    sb3.append(str6);
                                                    bVar2.error(sb3.toString(), new Object[0]);
                                                } else {
                                                    dVar.logger.a(str5 + j13 + "] get catchup playlist complete size[" + listC.size() + "][" + j20 + " ms][" + playUrl + str6, new Object[0]);
                                                }
                                                String string2 = sbD.toString();
                                                kotlin.jvm.internal.m.e(string2, "toString(...)");
                                                return string2;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                j15 = j15;
                                                str9 = str9;
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            j15 = j15;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                    }
                                } catch (Throwable th10) {
                                    th = th10;
                                    dVar = dVar3;
                                    j13 = j19;
                                }
                            } catch (Throwable th11) {
                                th = th11;
                                dVar = dVar3;
                                j13 = j19;
                                obj = th;
                                j14 = j18;
                                dVar.logger.error(str5 + j13 + "] get catchup url failure [" + str7 + "][" + str8 + "][" + str9 + "][" + j14 + "][" + j15 + str6, obj);
                                return "";
                            }
                        } catch (Throwable th12) {
                            th = th12;
                            j13 = j19;
                            dVar = dVar2;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        j18 = j17;
                        dVar = dVar2;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    j18 = j17;
                    dVar = dVar2;
                    j13 = j16;
                }
                obj = th;
                j14 = j18;
            } catch (Throwable th15) {
                obj = th15;
                j14 = j23;
                str6 = "]";
                str5 = "session[";
                j15 = j22;
                j13 = j24;
                dVar = dVar2;
            }
        }
        dVar.logger.error(str5 + j13 + "] get catchup url failure [" + str7 + "][" + str8 + "][" + str9 + "][" + j14 + "][" + j15 + str6, obj);
        return "";
    }

    private final byte[] s(long session, String mediaId) {
        b bVar = this.clientEngineService;
        if (bVar != null) {
            return bVar.z(session, mediaId, "playlist.m3u8");
        }
        return null;
    }

    private final List<String> v(byte[] index) {
        List listL;
        if (index == null) {
            return new ArrayList();
        }
        List<String> listG = new ua.l("\n").g(new String(index, ua.d.UTF_8), 0);
        if (listG.isEmpty()) {
            listL = kotlin.collections.r.l();
        } else {
            ListIterator<String> listIterator = listG.listIterator(listG.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    listL = kotlin.collections.r.K0(listG, listIterator.nextIndex() + 1);
                }
            }
            listL = kotlin.collections.r.l();
        }
        return kotlin.collections.r.O0(listL);
    }

    private final <T> void w(String uri, T params, a<T> callback) {
        try {
            r rVar = r.f21132a;
            long j10 = Long.parseLong(callback.b(params, rVar.n()));
            String strB = callback.b(params, rVar.k());
            if (j10 != this.lastPlaySession) {
                byte[] bytes = "session mismatch".getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                callback.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
                this.logger.error("session mismatch[" + j10 + " vs " + this.lastPlaySession + "] on catchup ts request", new Object[0]);
                return;
            }
            CatchupCacheItem catchupCacheItem = this.catchupPlayResponseCache.get(Long.valueOf(j10));
            if (catchupCacheItem != null) {
                CatchupPlayResponse response = catchupCacheItem.getResponse();
                if (catchupCacheItem.getTokenExpiredTime() < d1.d()) {
                    kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new i(j10, uri, strB, params, callback, catchupCacheItem.getRequest(), catchupCacheItem, null), 3, null);
                    return;
                } else {
                    m(uri, j10, Integer.parseInt(strB), catchupCacheItem.getUrlPrefix(), response.getToken(), params, callback);
                    return;
                }
            }
            byte[] bytes2 = "context lost".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
            callback.a(404, bytes2, ContentTypes.DOC_MIME_TYPE);
            this.logger.error("context lost[" + j10 + "] on catchup ts request", new Object[0]);
        } catch (Throwable th) {
            byte[] bytes3 = "invalid session".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes3, "getBytes(...)");
            callback.a(404, bytes3, ContentTypes.DOC_MIME_TYPE);
            this.logger.error("invalid session on catchup ts request", th);
        }
    }

    private final <T> void x(T params, a<T> callback) {
        char c10;
        r rVar = r.f21132a;
        String strB = callback.b(params, rVar.n());
        String strB2 = callback.b(params, rVar.k());
        Map<String, String> mapL = l(callback.b(params, rVar.j()));
        String str = mapL.get("streamId");
        String str2 = str == null ? "" : str;
        String str3 = mapL.get("catchupStreamId");
        String str4 = str3 == null ? "" : str3;
        String str5 = mapL.get("route");
        String str6 = str5 == null ? "" : str5;
        String str7 = mapL.get("start");
        long j10 = str7 != null ? Long.parseLong(str7) : 0L;
        String str8 = mapL.get("stop");
        long j11 = str8 != null ? Long.parseLong(str8) : 0L;
        long j12 = j10;
        try {
            long j13 = Long.parseLong(strB);
            this.logger.a("session[" + strB + "] catchup playlist request, streamId[" + str2 + "] route[" + str6 + "]", new Object[0]);
            c10 = 0;
            try {
                kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new j(j13, strB2, str2, str4, str6, j12, j11, strB, callback, null), 3, null);
                this.playSession.set(j13);
                this.playListRequestCnt = 0;
                this.playBlockResponseCnt = 0;
                this.blockDurations = new HashMap<>();
                x1.f1.lb.metric.monitor.g.f20917a.y(j13);
                this.lastPlaySession = j13;
            } catch (Throwable th) {
                th = th;
                byte[] bytes = "Invalid session".getBytes(ua.d.UTF_8);
                kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                callback.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
                Object[] objArr = new Object[1];
                objArr[c10] = th;
                this.logger.error("session[" + strB + "] is invalid", objArr);
            }
        } catch (Throwable th2) {
            th = th2;
            c10 = 0;
        }
    }

    private final <T> void y(String uri, T params, a<T> callback) throws Throwable {
        long j10;
        boolean z10;
        String str;
        int i10;
        String str2;
        String str3;
        String str4;
        r rVar = r.f21132a;
        boolean zI = ua.n.I(uri, "/" + rVar.g() + ".m3u8", false, 2, null);
        boolean zV = ua.n.v(uri, ".ts", false, 2, null);
        Map<String, String> mapL = zV ? l(callback.b(params, rVar.j())) : null;
        try {
            if (zI) {
                j10 = Long.parseLong(callback.b(params, rVar.n()));
            } else if (zV) {
                if (mapL == null || (str4 = mapL.get("play_session")) == null) {
                    str4 = "0";
                }
                j10 = Long.parseLong(str4);
            } else {
                j10 = 0;
            }
        } catch (Throwable unused) {
        }
        long jD = d1.d();
        long j11 = this.playSession.get();
        if (!zI) {
            z10 = zI;
            str = "0";
            if (zV && x1.f1.lb.config.b.f20643a.t()) {
                this.logger.debug("ts request play_session request[" + j10 + "] -> cur[" + j11 + "]", new Object[0]);
            }
        } else if (x1.f1.lb.config.b.f20643a.t()) {
            q6.b bVar = this.logger;
            z10 = zI;
            StringBuilder sb2 = new StringBuilder();
            str = "0";
            sb2.append("playlist request play_session request[");
            sb2.append(j10);
            sb2.append("] -> cur[");
            sb2.append(j11);
            sb2.append("]");
            bVar.debug(sb2.toString(), new Object[0]);
        } else {
            z10 = zI;
            str = "0";
        }
        if (j11 != j10) {
            if (j11 == 0) {
                this.logger.warn(uri + ", session in request[ " + j10 + " ], but no active session in server, last session[ " + this.lastPlaySession + " ]", new Object[0]);
            } else if (this.lastPlaySession == j10) {
                this.logger.warn(uri + ", session is closed in request[ " + j10 + " ], current session in server[ " + j11 + " ]", new Object[0]);
            } else {
                this.logger.warn(uri + ", invalid session in request[ " + j10 + " ], current session in server[ " + j11 + " ]", new Object[0]);
            }
            byte[] bytes = "request session is not available".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            callback.a(404, bytes, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        try {
            if (z10) {
                i10 = Integer.parseInt(callback.b(params, r.f21132a.k()));
            } else if (zV) {
                if (mapL == null || (str3 = mapL.get("player")) == null) {
                    str3 = str;
                }
                i10 = Integer.parseInt(str3);
            } else {
                i10 = 0;
            }
        } catch (Throwable unused2) {
        }
        if (!u(j10, i10)) {
            this.logger.warn("invalid player, inRequest[ " + j10 + " , " + i10 + " ], inServer[ " + this.validPlayer + " ]  " + uri, new Object[0]);
            byte[] bytes2 = "player is invalid".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
            callback.a(404, bytes2, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        long j12 = j10;
        if (z10) {
            int iD = D(params, j12, i10, callback);
            if (x1.f1.lb.config.b.f20643a.t()) {
                this.logger.debug("playlist response size[" + iD + "][" + d1.b(d1.d() - jD, null) + "] play_session[" + j12 + "]->[" + j11 + "]", new Object[0]);
                return;
            }
            return;
        }
        int i11 = i10;
        if (!zV) {
            byte[] bytes3 = "".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes3, "getBytes(...)");
            callback.a(404, bytes3, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (mapL == null || (str2 = mapL.get("media_id")) == null) {
            str2 = "";
        }
        int iC = C(i11, uri, j12, str2, callback);
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("ts response size[" + iC + "][" + d1.b(d1.d() - jD, null) + "] play_session[" + j12 + "]->[" + j11 + "]", new Object[0]);
        }
    }

    public final void H() {
        b bVar = this.clientEngineService;
        if (bVar != null) {
            bVar.x();
        }
    }

    public final x6.c q() {
        b bVar = this.clientEngineService;
        if (bVar != null) {
            return bVar.B();
        }
        return null;
    }

    public final long r() {
        return this.playSession.get();
    }

    public final void t(x1.f1.lb.streaming.server.f httpServer) {
        kotlin.jvm.internal.m.f(httpServer, "httpServer");
        this.httpServer = httpServer;
        if (this.clientEngineService == null) {
            this.clientEngineService = new b(x1.f1.lb.metric.monitor.g.f20917a);
        } else {
            this.logger.a("local client engine service already started", new Object[0]);
        }
        s.f21156a.j(new x1.f1.lb.streaming.server.e() { // from class: x1.f1.lb.streaming.server.c
        });
    }

    public final <T> void z(String uri, T params, a<T> callback) throws Throwable {
        kotlin.jvm.internal.m.f(uri, "uri");
        kotlin.jvm.internal.m.f(callback, "callback");
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("proxy_request handle[" + uri + "]", new Object[0]);
        }
        if (kotlin.jvm.internal.m.a(uri, "/") || kotlin.jvm.internal.m.a(uri, "/ping") || kotlin.jvm.internal.m.a(uri, "/test")) {
            byte[] bytes = "Http server is running".getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
            callback.a(200, bytes, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        r rVar = r.f21132a;
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.p())) {
            byte[] bytes2 = String.valueOf(I(callback.b(params, rVar.j()))).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes2, "getBytes(...)");
            callback.a(200, bytes2, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.w())) {
            b bVar = this.clientEngineService;
            byte[] bytes3 = String.valueOf(bVar != null ? kotlin.jvm.internal.m.a(bVar.D(), Boolean.TRUE) : false).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes3, "getBytes(...)");
            callback.a(200, bytes3, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.r())) {
            byte[] bytes4 = String.valueOf(K()).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes4, "getBytes(...)");
            callback.a(200, bytes4, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.q())) {
            byte[] bytes5 = String.valueOf(J(callback.b(params, rVar.n()), callback.b(params, rVar.j()))).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes5, "getBytes(...)");
            callback.a(200, bytes5, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.s())) {
            byte[] bytes6 = String.valueOf(L(callback.b(params, rVar.n()))).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes6, "getBytes(...)");
            callback.a(200, bytes6, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.b())) {
            byte[] bytes7 = String.valueOf(j(callback.b(params, rVar.n()), callback.b(params, rVar.k()))).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes7, "getBytes(...)");
            callback.a(200, bytes7, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.m())) {
            byte[] bytes8 = String.valueOf(G(callback.b(params, rVar.n()), callback.b(params, rVar.k()))).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes8, "getBytes(...)");
            callback.a(200, bytes8, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.l())) {
            byte[] bytes9 = F(callback.b(params, rVar.t())).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes9, "getBytes(...)");
            callback.a(200, bytes9, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.v())) {
            String strV = x1.f1.lb.streaming.a.f20960a.v(callback.b(params, rVar.u()));
            b bVar2 = this.clientEngineService;
            byte[] bytes10 = String.valueOf(bVar2 != null ? bVar2.C(strV) : false).getBytes(ua.d.UTF_8);
            kotlin.jvm.internal.m.e(bytes10, "getBytes(...)");
            callback.a(200, bytes10, ContentTypes.DOC_MIME_TYPE);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.e())) {
            A(params, callback);
            return;
        }
        if (kotlin.jvm.internal.m.a(uri, "/" + rVar.o() + ".m3u8")) {
            x(params, callback);
            return;
        }
        if (ua.n.I(uri, "/" + rVar.d(), false, 2, null)) {
            w(uri, params, callback);
        } else {
            y(uri, params, callback);
        }
    }

    private final boolean G(String session, String player) {
        boolean z10;
        long j10 = Long.parseLong(session);
        int i10 = Integer.parseInt(player);
        synchronized (this.validPlayer) {
            try {
                b bVar = this.clientEngineService;
                if (bVar != null) {
                    bVar.G(j10);
                }
                HashSet<Integer> hashSet = this.validPlayer.get(Long.valueOf(j10));
                z10 = false;
                if (hashSet != null && hashSet.remove(Integer.valueOf(i10))) {
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    private final boolean L(String session) {
        Boolean boolN;
        long j10 = Long.parseLong(session);
        long j11 = this.playSession.get();
        if (x1.f1.lb.config.b.f20643a.t()) {
            this.logger.debug("clean play_session request[" + j10 + "] -> current[" + j11 + "]", new Object[0]);
        }
        if (!this.playSession.compareAndSet(j10, 0L)) {
            if (j11 == 0) {
                return true;
            }
            this.logger.warn("stop play failure, request session[" + session + "] is not match current session[" + this.playSession.get() + "]", new Object[0]);
            return false;
        }
        x1.f1.lb.metric.monitor.g.f20917a.z(j10);
        this.lastIndex = null;
        synchronized (this.validPlayer) {
            this.validPlayer.remove(Long.valueOf(j10));
        }
        this.lastPlaySession = j10;
        b bVar = this.clientEngineService;
        if (bVar == null || (boolN = bVar.N(Long.valueOf(j10))) == null) {
            return false;
        }
        return boolN.booleanValue();
    }

    private final boolean j(String session, String player) {
        long j10 = Long.parseLong(session);
        int i10 = Integer.parseInt(player);
        synchronized (this.validPlayer) {
            try {
                HashSet<Integer> hashSet = this.validPlayer.get(Long.valueOf(j10));
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                    this.validPlayer.put(Long.valueOf(j10), hashSet);
                }
                hashSet.add(Integer.valueOf(i10));
                b bVar = this.clientEngineService;
                if (bVar != null) {
                    bVar.J(j10, i10);
                    r8.z zVar = r8.z.f17874a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    private final boolean u(long session, int player) {
        boolean z10;
        HashSet<Integer> hashSet;
        long jC = d1.c();
        synchronized (this.validPlayer) {
            while (true) {
                try {
                    HashSet<Integer> hashSet2 = this.validPlayer.get(Long.valueOf(session));
                    z10 = true;
                    if (hashSet2 != null && !hashSet2.isEmpty() && ((hashSet = this.validPlayer.get(Long.valueOf(session))) == null || !hashSet.contains(Integer.valueOf(player)))) {
                        z10 = false;
                    }
                    if (z10 || d1.c() - jC > 1000) {
                        break;
                    }
                    Thread.sleep(500L);
                } catch (Throwable th) {
                    throw th;
                }
            }
            r8.z zVar = r8.z.f17874a;
        }
        return z10;
    }
}
