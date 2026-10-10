package x1.f1.lb.media;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.pengrad.telegrambot.model.message.origin.MessageOriginChannel;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.Metadata;
import kotlin.collections.n0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x1.f1.lb.util.b0;
import x1.f1.lb.util.b1;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.w0;
import z1.b1.lb.m.meta.ChannelEPGIndexResponse;
import z1.b1.lb.m.meta.EPGProgramme;
import z1.b1.lb.m.meta.EpgIndex;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0089\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J(\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\u001e\u0010\u0019J)\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\r0\u001f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"JD\u0010%\u001a\u00020\u00122\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\r0\u001f2\u0018\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\r0\u001fH\u0082@¢\u0006\u0004\b%\u0010&J \u0010(\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010'\u001a\u00020 H\u0082@¢\u0006\u0004\b(\u0010)J*\u0010+\u001a\u00020\u00122\u0006\u0010'\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010'\u001a\u00020 H\u0002¢\u0006\u0004\b-\u0010.J\u001f\u00100\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J8\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u00102\u001a\u00020\bH\u0082@¢\u0006\u0004\b3\u00104J=\u00106\u001a\u00020\u00122\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\u00122\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\r\u0010<\u001a\u00020\u0012¢\u0006\u0004\b<\u0010\u0003J\u0015\u0010>\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\b¢\u0006\u0004\b>\u0010?J\u0015\u0010B\u001a\u00020\u00122\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ\u0017\u0010F\u001a\u00020\u00122\b\u0010E\u001a\u0004\u0018\u00010D¢\u0006\u0004\bF\u0010GJ,\u0010J\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010H\u001a\u00020@2\b\b\u0002\u0010I\u001a\u00020\bH\u0086@¢\u0006\u0004\bJ\u0010KJ0\u0010M\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0L2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010H\u001a\u00020@H\u0086@¢\u0006\u0004\bM\u0010NJ1\u0010P\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010O\u001a\u00020@2\b\b\u0002\u0010I\u001a\u00020\b¢\u0006\u0004\bP\u0010QJ!\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0R2\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\bS\u0010TJ)\u0010U\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0R2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\bU\u0010VJ\"\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\bW\u0010XJ\r\u0010Y\u001a\u00020\b¢\u0006\u0004\bY\u0010ZJ\u0015\u0010\\\u001a\u00020@2\u0006\u0010[\u001a\u00020\u0006¢\u0006\u0004\b\\\u0010]R\u001e\u0010b\u001a\n _*\u0004\u0018\u00010^0^8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0016\u0010p\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010rR\u0018\u0010w\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010lR\u0018\u0010y\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010lR\u0016\u0010{\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010oR\u0018\u0010~\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0017\u0010\u0080\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u007f\u0010oR\u0017\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010oR\u0017\u0010\u0082\u0001\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010oR/\u0010\u0085\u0001\u001a\u001b\u0012\u0004\u0012\u00020@\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060L0\u0083\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b+\u0010\u0084\u0001R3\u0010\u0086\u0001\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0g0g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010iR\u001a\u0010\u0088\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b(\u0010\u0087\u0001¨\u0006\u008a\u0001"}, d2 = {"Lx1/f1/lb/media/c;", "", "<init>", "()V", "", "pos", "", "fileName", "", "N", "(ILjava/lang/String;)Z", "Ljava/io/File;", "file", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "v", "(ILjava/io/File;)Ljava/util/List;", "list", "Lr8/z;", "Q", "(ILjava/io/File;Ljava/util/List;)V", "o", "epgId", "yyyyMMdd", "x", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "checksum", "R", "(Ljava/lang/String;Ljava/lang/String;)V", "O", "", "Lz1/b1/lb/m/meta/EpgIndex;", "G", "(Ljava/io/File;)Ljava/util/Map;", "oldMap", "map", "K", "(Ljava/util/Map;Ljava/util/Map;Lv8/f;)Ljava/lang/Object;", "epgIndex", "r", "(ILz1/b1/lb/m/meta/EpgIndex;Lv8/f;)Ljava/lang/Object;", "lastPos", "p", "(Lz1/b1/lb/m/meta/EpgIndex;ILjava/lang/Integer;Lv8/f;)Ljava/lang/Object;", "u", "(Lz1/b1/lb/m/meta/EpgIndex;)Ljava/lang/String;", MessageOriginChannel.MESSAGE_ORIGIN_TYPE, "t", "(ILjava/lang/String;)Ljava/lang/String;", "isWrite", "I", "(Ljava/lang/String;ILjava/io/File;ZLv8/f;)Ljava/lang/Object;", "epgList", "M", "(ZILjava/io/File;Ljava/lang/String;Ljava/util/List;)V", "Lx1/f1/lb/media/c$a;", "parser", ExifInterface.LONGITUDE_EAST, "(Lx1/f1/lb/media/c$a;)V", "P", "isEnable", "s", "(Z)V", "", "now", "q", "(J)V", "Lz1/b1/lb/m/meta/ChannelEPGIndexResponse;", "response", ExifInterface.LATITUDE_SOUTH, "(Lz1/b1/lb/m/meta/ChannelEPGIndexResponse;)V", "startTime", "returnNextItemIfNotFound", "B", "(Ljava/lang/String;JZLv8/f;)Ljava/lang/Object;", "Lr8/p;", "D", "(Ljava/lang/String;JLv8/f;)Ljava/lang/Object;", "time", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/List;JZ)Ljava/lang/Integer;", "Lkotlinx/coroutines/flow/f;", "z", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "y", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "w", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "F", "()Z", "timestampStr", "L", "(Ljava/lang/String;)J", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "Lkotlinx/coroutines/l0;", "c", "Lkotlinx/coroutines/l0;", "puckScope", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "posMap", "e", "Ljava/lang/String;", "epgHost", "f", "Z", "isInUpdating", "g", "J", "epgUpdateInterval", "h", "nextUpdateTime", "i", "nextUpdateUrl", "j", "nextUpdateChecksum", "k", "isFirstRoundEPG", "l", "Lz1/b1/lb/m/meta/ChannelEPGIndexResponse;", "epgResponse", "m", "canStart", "n", "isEpgUpdateComplete", "Ljava/util/concurrent/ConcurrentSkipListMap;", "Ljava/util/concurrent/ConcurrentSkipListMap;", "epgCacheMap", "cacheItemMap", "Lx1/f1/lb/media/c$a;", "epgFileParser", "a", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isInUpdating;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String nextUpdateUrl;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String nextUpdateChecksum;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static ChannelEPGIndexResponse epgResponse;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean canStart;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean isEpgUpdateComplete;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static a epgFileParser;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f20788a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static q6.b logger = q6.c.d(c.class);

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final l0 puckScope = m0.a(a2.b(null, 1, null).plus(a1.b()));

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ConcurrentHashMap<String, Integer> posMap = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String epgHost = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static long epgUpdateInterval = 21600000;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long nextUpdateTime = d1.c();

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isFirstRoundEPG = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean isEnable = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentSkipListMap<Long, r8.p<Integer, String>> epgCacheMap = new ConcurrentSkipListMap<>();

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<Integer, ConcurrentHashMap<String, List<EPGProgramme>>> cacheItemMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H¦@¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lx1/f1/lb/media/c$a;", "", "", "epgId", "Ljava/io/File;", "file", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "a", "(Ljava/lang/String;Ljava/io/File;Lv8/f;)Ljava/lang/Object;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        Object a(String str, File file, v8.f<? super List<? extends EPGProgramme>> fVar);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {740, 770, 776}, m = "checkAndUpdateEpg")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        b(v8.f<? super b> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.p(null, 0, null, this);
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.media.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager$downloadEpg$2", f = "EpgManager.kt", l = {731}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0423c extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ EpgIndex $epgIndex;
        final /* synthetic */ int $pos;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.media.c$c$a */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"x1/f1/lb/media/c$c$a", "Lx1/f1/lb/util/b0$c;", "Ljava/io/File;", "file", "", "k", "(Ljava/io/File;)Z", "f", "g", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends b0.c {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f20806h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ EpgIndex f20807i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, String str2, String str3, EpgIndex epgIndex) {
                super(str, str2, str3, true, null, 16, null);
                this.f20806h = str;
                this.f20807i = epgIndex;
            }

            private final boolean k(File file) {
                return b0.n(b0.f21310a, file, this.f20807i.getChecksum(), 0L, 4, null);
            }

            @Override // x1.f1.lb.util.b0.d
            public boolean f(File file) {
                kotlin.jvm.internal.m.f(file, "file");
                boolean zK = k(file);
                if (!zK && x1.f1.lb.config.b.f20643a.t()) {
                    c.logger.debug("epg: downloadEpg checksum of exists file [{}] mismatch with checksum[{}] of url[{}]", getFile().getAbsolutePath(), this.f20807i.getChecksum(), this.f20806h);
                }
                return zK;
            }

            @Override // x1.f1.lb.util.b0.d
            public boolean g(File file) {
                kotlin.jvm.internal.m.f(file, "file");
                boolean zK = k(file);
                if (!zK) {
                    c.logger.warn("epg: downloadEpg checksum mismatch url[{}] -> file[{}] checksum[{}]", this.f20806h, getFile().getAbsolutePath(), this.f20807i.getChecksum());
                }
                return zK;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0423c(EpgIndex epgIndex, int i10, v8.f<? super C0423c> fVar) {
            super(2, fVar);
            this.$epgIndex = epgIndex;
            this.$pos = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0423c(this.$epgIndex, this.$pos, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0423c) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                c cVar = c.f20788a;
                String strU = cVar.u(this.$epgIndex);
                String strC = b1.f21324a.c();
                int i11 = this.$pos;
                String channelId = this.$epgIndex.getChannelId();
                kotlin.jvm.internal.m.e(channelId, "getChannelId(...)");
                a aVar = new a(strU, strC, cVar.t(i11, channelId), this.$epgIndex);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    c.logger.debug("epg: downloadEpg url[{}] -> file[{}]", strU, aVar.getFile().getAbsolutePath());
                }
                if (b0.h(b0.f21310a, aVar, false, null, 6, null)) {
                    String channelId2 = this.$epgIndex.getChannelId();
                    kotlin.jvm.internal.m.e(channelId2, "getChannelId(...)");
                    int i12 = this.$pos;
                    File file = aVar.getFile();
                    this.label = 1;
                    if (cVar.I(channelId2, i12, file, true, this) == objC) {
                        return objC;
                    }
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {TypedValues.CycleType.TYPE_WAVE_PHASE}, m = "getEPGDateList")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class d extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        d(v8.f<? super d> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.w(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager$getEPGDateList$2", f = "EpgManager.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $epgId;
        final /* synthetic */ List<String> $list;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, List<String> list, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$epgId = str;
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$epgId, this.$list, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((e) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                String strC = b1.f21324a.c();
                for (Object obj2 : c.posMap.entrySet()) {
                    kotlin.jvm.internal.m.e(obj2, "next(...)");
                    Map.Entry entry = (Map.Entry) obj2;
                    Object value = entry.getValue();
                    kotlin.jvm.internal.m.e(value, "<get-value>(...)");
                    if (new File(strC, c.f20788a.t(((Number) value).intValue(), this.$epgId)).exists()) {
                        this.$list.add((String) entry.getKey());
                    }
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {458}, m = "getEPGProgramme")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class f extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        f(v8.f<? super f> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.x(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager$getEPGProgrammeFlow$1", f = "EpgManager.kt", l = {394, 409}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $epgId;
        final /* synthetic */ String $yyyyMMdd;
        long J$0;
        long J$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, String str2, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$yyyyMMdd = str;
            this.$epgId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            g gVar = new g(this.$yyyyMMdd, this.$epgId, fVar);
            gVar.L$0 = obj;
            return gVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>> gVar, v8.f<? super z> fVar) {
            return ((g) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x00a9 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:6:0x0013, B:13:0x0035, B:20:0x00a3, B:22:0x00a9, B:24:0x00bb, B:16:0x004a, B:18:0x0052, B:19:0x0063), top: B:69:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:24:0x00bb A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:6:0x0013, B:13:0x0035, B:20:0x00a3, B:22:0x00a9, B:24:0x00bb, B:16:0x004a, B:18:0x0052, B:19:0x0063), top: B:69:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:28:0x00e0 A[Catch: all -> 0x010b, TRY_LEAVE, TryCatch #1 {all -> 0x010b, blocks: (B:42:0x0144, B:43:0x014a, B:45:0x0150, B:54:0x0171, B:50:0x0163, B:26:0x00c1, B:28:0x00e0, B:32:0x00ee, B:38:0x0115, B:57:0x0180, B:59:0x0190, B:62:0x01c0), top: B:70:0x0144 }] */
        /* JADX WARN: Code duplicated, block: B:37:0x0113  */
        /* JADX WARN: Code duplicated, block: B:40:0x013e  */
        /* JADX WARN: Code duplicated, block: B:41:0x0140  */
        /* JADX WARN: Code duplicated, block: B:45:0x0150 A[Catch: all -> 0x010b, TryCatch #1 {all -> 0x010b, blocks: (B:42:0x0144, B:43:0x014a, B:45:0x0150, B:54:0x0171, B:50:0x0163, B:26:0x00c1, B:28:0x00e0, B:32:0x00ee, B:38:0x0115, B:57:0x0180, B:59:0x0190, B:62:0x01c0), top: B:70:0x0144 }] */
        /* JADX WARN: Code duplicated, block: B:47:0x015e  */
        /* JADX WARN: Code duplicated, block: B:50:0x0163 A[Catch: all -> 0x010b, TryCatch #1 {all -> 0x010b, blocks: (B:42:0x0144, B:43:0x014a, B:45:0x0150, B:54:0x0171, B:50:0x0163, B:26:0x00c1, B:28:0x00e0, B:32:0x00ee, B:38:0x0115, B:57:0x0180, B:59:0x0190, B:62:0x01c0), top: B:70:0x0144 }] */
        /* JADX WARN: Code duplicated, block: B:57:0x0180 A[Catch: all -> 0x010b, TryCatch #1 {all -> 0x010b, blocks: (B:42:0x0144, B:43:0x014a, B:45:0x0150, B:54:0x0171, B:50:0x0163, B:26:0x00c1, B:28:0x00e0, B:32:0x00ee, B:38:0x0115, B:57:0x0180, B:59:0x0190, B:62:0x01c0), top: B:70:0x0144 }] */
        /* JADX WARN: Code duplicated, block: B:59:0x0190 A[Catch: all -> 0x010b, TryCatch #1 {all -> 0x010b, blocks: (B:42:0x0144, B:43:0x014a, B:45:0x0150, B:54:0x0171, B:50:0x0163, B:26:0x00c1, B:28:0x00e0, B:32:0x00ee, B:38:0x0115, B:57:0x0180, B:59:0x0190, B:62:0x01c0), top: B:70:0x0144 }] */
        /* JADX WARN: Code duplicated, block: B:72:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:76:0x016d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:80:0x014a A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0140 -> B:70:0x0144). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x01bb -> B:56:0x0179). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r27) {
            /*
                Method dump skipped, instruction units count: 489
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.c.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager$getEPGProgrammes$1", f = "EpgManager.kt", l = {357, 361}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lz1/b1/lb/m/meta/EPGProgramme;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $epgId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(String str, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$epgId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            h hVar = new h(this.$epgId, fVar);
            hVar.L$0 = obj;
            return hVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super List<? extends EPGProgramme>> gVar, v8.f<? super z> fVar) {
            return ((h) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x007e A[Catch: all -> 0x0014, TryCatch #0 {all -> 0x0014, blocks: (B:6:0x000f, B:13:0x002f, B:28:0x00c3, B:20:0x0078, B:22:0x007e, B:24:0x00a5, B:29:0x00ca, B:16:0x0040, B:18:0x0048, B:19:0x0059), top: B:36:0x0009 }] */
        /* JADX WARN: Code duplicated, block: B:26:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:37:0x00ca A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00c2 -> B:28:0x00c3). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r16) {
            /*
                Method dump skipped, instruction units count: 237
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.c.h.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {240, 264}, m = "getEpgItemByTime")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class i extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        i(v8.f<? super i> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.B(null, 0L, false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {276, 278}, m = "getTowEpgItemsByTime")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class j extends kotlin.coroutines.jvm.internal.d {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        j(v8.f<? super j> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.D(null, 0L, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {831}, m = "parseEpg")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class l extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        l(v8.f<? super l> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.I(null, 0, null, false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {680}, m = "parseEpgIndex")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class m extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        m(v8.f<? super m> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.K(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager", f = "EpgManager.kt", l = {519, 566, 586}, m = "saveAndUpdate")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class n extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        n(v8.f<? super n> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return c.this.O(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"x1/f1/lb/media/c$o", "Lx1/f1/lb/util/b0$c;", "Ljava/io/File;", "file", "", "k", "(Ljava/io/File;)Z", "f", "g", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o extends b0.c {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f20808h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f20809i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ String f20810j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(String str, String str2, String str3, String str4) {
            super(str, str4, "epg-index.json", false, null, 24, null);
            this.f20808h = str;
            this.f20809i = str2;
            this.f20810j = str3;
        }

        private final boolean k(File file) {
            return b0.n(b0.f21310a, file, "", 0L, 4, null);
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean f(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            boolean z10 = k(file) && kotlin.jvm.internal.m.a(this.f20809i, this.f20810j);
            if (!z10) {
                c.logger.debug("epg: saveAndUpdate, exists index file[{}] checksum mismatch with url[{}] checksum[{}]", file.getAbsolutePath(), this.f20808h, this.f20810j);
            }
            return z10;
        }

        @Override // x1.f1.lb.util.b0.d
        public boolean g(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            boolean zK = k(file);
            if (!zK) {
                c.logger.warn("epg: saveAndUpdate, download index file[{}] from url[{} checksum mismatch[{}]", file.getAbsolutePath(), this.f20808h, this.f20810j);
            }
            return zK;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"x1/f1/lb/media/c$p", "Lx1/f1/lb/util/b0$e;", "Ljava/io/File;", "file", "Lr8/z;", "a", "(Ljava/io/File;)V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p implements b0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Map<String, List<EpgIndex>>> f20811a;

        p(kotlin.jvm.internal.b0<Map<String, List<EpgIndex>>> b0Var) {
            this.f20811a = b0Var;
        }

        /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.Map] */
        @Override // x1.f1.lb.util.b0.e
        public void a(File file) {
            kotlin.jvm.internal.m.f(file, "file");
            this.f20811a.element = c.f20788a.G(file);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.EpgManager$updateEpg$2", f = "EpgManager.kt", l = {TypedValues.PositionType.TYPE_PERCENT_WIDTH}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class q extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $checksum;
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        q(String str, String str2, v8.f<? super q> fVar) {
            super(2, fVar);
            this.$url = str;
            this.$checksum = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new q(this.$url, this.$checksum, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((q) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    c cVar = c.f20788a;
                    String str = this.$url;
                    String str2 = this.$checksum;
                    this.label = 1;
                    obj = cVar.O(str, str2, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    c.isEpgUpdateComplete = true;
                    xe.c.c().o(new nf.e());
                }
                c.isFirstRoundEPG = false;
            } catch (Exception e10) {
                c.logger.error("epg: updateEpg failure", e10);
            } finally {
                c.isInUpdating = false;
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, List<EpgIndex>> G(File file) {
        try {
            com.google.gson.e eVar = new com.google.gson.e();
            FileReader fileReader = new FileReader(file);
            Object objL = eVar.l(fileReader, new k().d());
            kotlin.jvm.internal.m.e(objL, "fromJson(...)");
            Map map = (Map) objL;
            hb.d.m(fileReader);
            if (!map.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date(d1.d()));
                final String str = simpleDateFormat.format(calendar.getTime());
                calendar.add(6, 1);
                final String str2 = simpleDateFormat.format(calendar.getTime());
                calendar.add(6, -2);
                final String str3 = simpleDateFormat.format(calendar.getTime());
                return n0.h(map, new Comparator() { // from class: x1.f1.lb.media.b
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return c.H(str, str2, str3, (String) obj, (String) obj2);
                    }
                });
            }
        } catch (Exception e10) {
            logger.error("load epg index file failure", e10);
        }
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String t(int pos, String channel) {
        return ua.n.E(channel, " ", "", false, 4, null) + "." + pos;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:21:0x0035  */
    public final Integer A(List<? extends EPGProgramme> list, long time, boolean returnNextItemIfNotFound) {
        if (list == null) {
            return null;
        }
        int i10 = 0;
        for (EPGProgramme ePGProgramme : list) {
            if (ePGProgramme.getStart() <= time ? time < ePGProgramme.getStop() : returnNextItemIfNotFound) {
                if (i10 < 0) {
                    return null;
                }
                return Integer.valueOf(i10);
            }
            i10++;
        }
        i10 = -1;
        if (i10 < 0) {
            return null;
        }
        return Integer.valueOf(i10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00020\u0001¨\u0006\u0006"}, d2 = {"x1/f1/lb/media/c$k", "Lf3/a;", "", "", "", "Lz1/b1/lb/m/meta/EpgIndex;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k extends f3.a<Map<String, ? extends List<? extends EpgIndex>>> {
        k() {
        }
    }

    public static /* synthetic */ Object C(c cVar, String str, long j10, boolean z10, v8.f fVar, int i10, Object obj) {
        return cVar.B(str, j10, (i10 & 4) != 0 ? false : z10, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:7:0x001f  */
    public final Object I(String str, int i10, File file, boolean z10, v8.f<? super List<? extends EPGProgramme>> fVar) {
        l lVar;
        c cVar;
        List<? extends EPGProgramme> arrayList;
        String str2;
        int i11;
        List<? extends EPGProgramme> list;
        String str3 = str;
        int i12 = i10;
        File file2 = file;
        boolean z11 = z10;
        if (fVar instanceof l) {
            lVar = (l) fVar;
            int i13 = lVar.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                lVar.label = i13 - Integer.MIN_VALUE;
            } else {
                lVar = new l(fVar);
            }
        } else {
            lVar = new l(fVar);
        }
        Object objA = lVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i14 = lVar.label;
        if (i14 == 0) {
            r.b(objA);
            if (!z11) {
                List<EPGProgramme> listV = v(i12, file2);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("getCache epg[{}]", listV);
                }
                if (listV != null) {
                    return listV;
                }
            }
            a aVar = epgFileParser;
            if (aVar != null) {
                lVar.L$0 = this;
                lVar.L$1 = str3;
                lVar.L$2 = file2;
                lVar.I$0 = i12;
                lVar.Z$0 = z11;
                lVar.label = 1;
                objA = aVar.a(str3, file2, lVar);
                if (objA == objC) {
                    return objC;
                }
                cVar = this;
            } else {
                cVar = this;
            }
            arrayList = new ArrayList<>();
            str2 = str3;
            i11 = i12;
            File file3 = file2;
            boolean z12 = z11;
            list = arrayList;
            c cVar2 = cVar;
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("epg: parseEpg pos[{}], channel[{}], epg list.size[{}]", kotlin.coroutines.jvm.internal.b.b(i11), str2, kotlin.coroutines.jvm.internal.b.b(list.size()));
            }
            cVar2.M(z12, i11, file3, str2, list);
            return list;
        }
        if (i14 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z13 = lVar.Z$0;
        i12 = lVar.I$0;
        file2 = (File) lVar.L$2;
        String str4 = (String) lVar.L$1;
        cVar = (c) lVar.L$0;
        r.b(objA);
        z11 = z13;
        str3 = str4;
        arrayList = (List) objA;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        str2 = str3;
        i11 = i12;
        File file4 = file2;
        boolean z14 = z11;
        list = arrayList;
        c cVar3 = cVar;
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("epg: parseEpg pos[{}], channel[{}], epg list.size[{}]", kotlin.coroutines.jvm.internal.b.b(i11), str2, kotlin.coroutines.jvm.internal.b.b(list.size()));
        }
        cVar3.M(z14, i11, file4, str2, list);
        return list;
    }

    static /* synthetic */ Object J(c cVar, String str, int i10, File file, boolean z10, v8.f fVar, int i11, Object obj) {
        return cVar.I(str, i10, file, (i11 & 8) != 0 ? false : z10, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:38:0x0100  */
    /* JADX WARN: Code duplicated, block: B:41:0x0137  */
    /* JADX WARN: Code duplicated, block: B:56:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x0131 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0100 -> B:39:0x0131). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object K(java.util.Map<java.lang.String, ? extends java.util.List<? extends z1.b1.lb.m.meta.EpgIndex>> r18, java.util.Map<java.lang.String, ? extends java.util.List<? extends z1.b1.lb.m.meta.EpgIndex>> r19, v8.f<? super r8.z> r20) {
        /*
            Method dump skipped, instruction units count: 377
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.c.K(java.util.Map, java.util.Map, v8.f):java.lang.Object");
    }

    private final void M(boolean isWrite, int pos, File file, String channel, List<? extends EPGProgramme> epgList) {
        if (kotlin.jvm.internal.m.a(channel, "") || epgList.isEmpty()) {
            return;
        }
        if (isWrite) {
            Q(pos, file, epgList);
        } else {
            o(pos, file, epgList);
        }
    }

    private final boolean N(int pos, String fileName) {
        Long key;
        Iterator<Map.Entry<Long, r8.p<Integer, String>>> it = epgCacheMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                key = null;
                break;
            }
            Map.Entry<Long, r8.p<Integer, String>> next = it.next();
            kotlin.jvm.internal.m.e(next, "next(...)");
            Map.Entry<Long, r8.p<Integer, String>> entry = next;
            r8.p<Integer, String> value = entry.getValue();
            kotlin.jvm.internal.m.e(value, "<get-value>(...)");
            r8.p<Integer, String> pVar = value;
            if (pVar.c().intValue() == pos && kotlin.jvm.internal.m.a(pVar.d(), fileName)) {
                key = entry.getKey();
                break;
            }
        }
        if (key == null) {
            return false;
        }
        epgCacheMap.remove(key);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:58:0x017d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0186  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r13v3, types: [T, java.util.HashMap] */
    public final Object O(String str, String str2, v8.f<? super Boolean> fVar) {
        n nVar;
        String str3;
        String str4;
        c cVar;
        char c10;
        String str5;
        boolean z10;
        if (fVar instanceof n) {
            nVar = (n) fVar;
            int i10 = nVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                nVar.label = i10 - Integer.MIN_VALUE;
            } else {
                nVar = new n(fVar);
            }
        } else {
            nVar = new n(fVar);
        }
        Object objM = nVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = nVar.label;
        boolean z11 = false;
        if (i11 == 0) {
            r.b(objM);
            w0 w0Var = w0.f21452a;
            nVar.L$0 = this;
            str3 = str;
            nVar.L$1 = str3;
            str4 = str2;
            nVar.L$2 = str4;
            nVar.label = 1;
            objM = w0Var.m("epg_index_last_checksum", "", nVar);
            if (objM != objC) {
                cVar = this;
            }
            return objC;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str5 = (String) nVar.L$2;
                str3 = (String) nVar.L$1;
                r.b(objM);
                z10 = true;
                if (z10) {
                    nextUpdateUrl = str3;
                    nextUpdateChecksum = str5;
                    w0.f21452a.t("epg_index_last_checksum", str5 != null ? str5 : "");
                    nextUpdateTime = d1.c() + epgUpdateInterval;
                }
                return kotlin.coroutines.jvm.internal.b.a(z10);
            }
            str5 = (String) nVar.L$2;
            str3 = (String) nVar.L$1;
            try {
                r.b(objM);
                z11 = true;
            } catch (Exception e10) {
                e = e10;
                logger.error("epg: parse epg index failure", e);
            }
            z10 = z11;
            if (z10) {
                nextUpdateUrl = str3;
                nextUpdateChecksum = str5;
                w0.f21452a.t("epg_index_last_checksum", str5 != null ? str5 : "");
                nextUpdateTime = d1.c() + epgUpdateInterval;
            }
            return kotlin.coroutines.jvm.internal.b.a(z10);
        }
        String str6 = (String) nVar.L$2;
        String str7 = (String) nVar.L$1;
        cVar = (c) nVar.L$0;
        r.b(objM);
        str4 = str6;
        str3 = str7;
        o oVar = new o(str3, (String) objM, str4, b1.f21324a.c());
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        if (bVar.t()) {
            c10 = 1;
            logger.debug("epg: save and update [{}] -> [{}]", str3, oVar.getFile().getAbsolutePath());
        } else {
            c10 = 1;
        }
        kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
        b0Var.element = new HashMap();
        if (b0.f21310a.g(oVar, false, new p(b0Var))) {
            try {
                Map<String, List<EpgIndex>> mapG = cVar.G(oVar.getFile());
                if (bVar.t()) {
                    q6.b bVar2 = logger;
                    String absolutePath = oVar.getFile().getAbsolutePath();
                    Object[] objArr = new Object[3];
                    objArr[0] = str3;
                    objArr[c10] = absolutePath;
                    objArr[2] = mapG;
                    bVar2.debug("epg: download epg index complete url[{}] -> file[{}], index[{}]", objArr);
                }
                Map<String, ? extends List<? extends EpgIndex>> map = (Map) b0Var.element;
                nVar.L$0 = cVar;
                nVar.L$1 = str3;
                nVar.L$2 = str4;
                nVar.label = 2;
                if (cVar.K(map, mapG, nVar) != objC) {
                    str5 = str4;
                    z11 = true;
                    z10 = z11;
                    if (z10) {
                        nextUpdateUrl = str3;
                        nextUpdateChecksum = str5;
                        w0.f21452a.t("epg_index_last_checksum", str5 != null ? str5 : "");
                        nextUpdateTime = d1.c() + epgUpdateInterval;
                    }
                    return kotlin.coroutines.jvm.internal.b.a(z10);
                }
            } catch (Exception e11) {
                e = e11;
                str5 = str4;
                logger.error("epg: parse epg index failure", e);
            }
        } else {
            if (!oVar.getFile().exists()) {
                logger.error("epg index file not exists, not epg update", new Object[0]);
                return kotlin.coroutines.jvm.internal.b.a(false);
            }
            Map<String, List<EpgIndex>> mapG2 = cVar.G(oVar.getFile());
            if (bVar.t()) {
                logger.debug("epg: epg index no update url[{}] -> file[{}], index[{}]", str3, oVar.getFile().getAbsolutePath(), mapG2);
            }
            nVar.L$0 = cVar;
            nVar.L$1 = str3;
            nVar.L$2 = str4;
            nVar.label = 3;
            if (cVar.K(mapG2, mapG2, nVar) != objC) {
                str5 = str4;
                z10 = true;
                if (z10) {
                    nextUpdateUrl = str3;
                    nextUpdateChecksum = str5;
                    w0.f21452a.t("epg_index_last_checksum", str5 != null ? str5 : "");
                    nextUpdateTime = d1.c() + epgUpdateInterval;
                }
                return kotlin.coroutines.jvm.internal.b.a(z10);
            }
        }
        return objC;
    }

    private final void R(String url, String checksum) {
        if (!canStart && x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("epg: wait for player is ready first, then updateEpg url[{}], checksum[{}], host[{}]", url, checksum, epgHost);
            return;
        }
        epgHost = ac.g.q(url, 0, ac.g.e(url, "/", 8));
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("epg: updateEpg url[{}], checksum[{}], host[{}]", url, checksum, epgHost);
        }
        if (ac.g.f(url)) {
            logger.warn("epg: updateEpg index url is empty or checksum is empty", new Object[0]);
            return;
        }
        if (isInUpdating) {
            return;
        }
        synchronized (this) {
            if (isInUpdating) {
                return;
            }
            isInUpdating = true;
            z zVar = z.f17874a;
            kotlinx.coroutines.j.d(puckScope, null, null, new q(url, checksum, null), 3, null);
        }
    }

    private final void o(int pos, File file, List<? extends EPGProgramme> list) {
        ConcurrentSkipListMap<Long, r8.p<Integer, String>> concurrentSkipListMap = epgCacheMap;
        if (concurrentSkipListMap.size() > 30) {
            try {
                r8.p<Integer, String> pVarRemove = concurrentSkipListMap.remove(concurrentSkipListMap.firstKey());
                if (pVarRemove != null) {
                    ConcurrentHashMap<String, List<EPGProgramme>> concurrentHashMap = cacheItemMap.get(pVarRemove.c());
                    List<EPGProgramme> listRemove = concurrentHashMap != null ? concurrentHashMap.remove(pVarRemove.d()) : null;
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        logger.debug("addEPGCache remove epg from cache, pos[{}], file[{}], epg.size[{}]", pVarRemove.c(), pVarRemove.d(), listRemove != null ? Integer.valueOf(listRemove.size()) : null);
                    }
                }
            } catch (Throwable th) {
                logger.warn("remove epg cache failure", th);
            }
        }
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, List<EPGProgramme>>> concurrentHashMap2 = cacheItemMap;
        ConcurrentHashMap<String, List<EPGProgramme>> concurrentHashMap3 = concurrentHashMap2.get(Integer.valueOf(pos));
        if (concurrentHashMap3 == null) {
            concurrentHashMap3 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(Integer.valueOf(pos), concurrentHashMap3);
        }
        String absolutePath = file.getAbsolutePath();
        concurrentHashMap3.put(absolutePath, list);
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("addEPGCache pos[{}], file[{}], epg.size[{}]", Integer.valueOf(pos), absolutePath, Integer.valueOf(list.size()));
        }
        epgCacheMap.put(Long.valueOf(d1.c()), new r8.p<>(Integer.valueOf(pos), absolutePath));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r(r21, r20, r6) == r7) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00da, code lost:
    
        if (I(r2, r21, r5, true, r6) == r7) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
    
        if (r(r21, r20, r6) == r7) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(EpgIndex epgIndex, int i10, Integer num, v8.f<? super z> fVar) throws Throwable {
        b bVar;
        if (fVar instanceof b) {
            bVar = (b) fVar;
            int i11 = bVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                bVar.label = i11 - Integer.MIN_VALUE;
            } else {
                bVar = new b(fVar);
            }
        } else {
            bVar = new b(fVar);
        }
        b bVar2 = bVar;
        Object obj = bVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i12 = bVar2.label;
        try {
            if (i12 != 0) {
                if (i12 == 1) {
                    r.b(obj);
                    return z.f17874a;
                }
                if (i12 == 2) {
                    r.b(obj);
                    return z.f17874a;
                }
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
                return z.f17874a;
            }
            r.b(obj);
            if (num == null) {
                bVar2.label = 1;
            } else {
                int iIntValue = num.intValue();
                String channelId = epgIndex.getChannelId();
                kotlin.jvm.internal.m.e(channelId, "getChannelId(...)");
                String strT = t(iIntValue, channelId);
                String strC = b1.f21324a.c();
                File file = new File(strC, strT);
                if (!b0.n(b0.f21310a, file, epgIndex.getChecksum(), 0L, 4, null)) {
                    bVar2.label = 3;
                } else {
                    if (i10 == num.intValue()) {
                        return z.f17874a;
                    }
                    String channelId2 = epgIndex.getChannelId();
                    kotlin.jvm.internal.m.e(channelId2, "getChannelId(...)");
                    File file2 = new File(strC, t(i10, channelId2));
                    if (file2.exists()) {
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            logger.debug("checkAndUpdateEPG remove exits epg file [{}]", file2.getAbsolutePath());
                        }
                        file2.delete();
                    }
                    yb.c.n(file, file2);
                    String channelId3 = epgIndex.getChannelId();
                    kotlin.jvm.internal.m.e(channelId3, "getChannelId(...)");
                    bVar2.label = 2;
                }
            }
            return objC;
        } catch (Exception e10) {
            logger.error("checkAndUpdateEPG  failure", e10);
            z zVar = z.f17874a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object x(String str, String str2, v8.f<? super List<? extends EPGProgramme>> fVar) {
        f fVar2;
        if (fVar instanceof f) {
            fVar2 = (f) fVar;
            int i10 = fVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                fVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                fVar2 = new f(fVar);
            }
        } else {
            fVar2 = new f(fVar);
        }
        f fVar3 = fVar2;
        Object obj = fVar3.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = fVar3.label;
        try {
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
                return obj;
            }
            r.b(obj);
            x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
            if (bVar.t()) {
                logger.debug("epg: loadEpg posMap[{}]", posMap);
            }
            Integer num = posMap.get(str2);
            if (num == null) {
                return null;
            }
            int iIntValue = num.intValue();
            File file = new File(b1.f21324a.c(), t(iIntValue, str));
            if (!file.exists()) {
                if (bVar.t()) {
                    logger.debug("epg: loadEpg [{}] [{}] [{}] [{}], file not exits", str, str2, kotlin.coroutines.jvm.internal.b.b(iIntValue), file.getAbsolutePath());
                }
                return new ArrayList();
            }
            if (bVar.t()) {
                logger.debug("epg: loadEpg [{}] [{}] [{}] [{}], file exits", str, str2, kotlin.coroutines.jvm.internal.b.b(iIntValue), file.getAbsolutePath());
            }
            fVar3.label = 1;
            Object objJ = J(this, str, iIntValue, file, false, fVar3, 8, null);
            return objJ == objC ? objC : objJ;
        } catch (Throwable th) {
            logger.error("epg: loadEpg failure", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object B(String str, long j10, boolean z10, v8.f<? super EPGProgramme> fVar) {
        i iVar;
        Object obj;
        boolean z11;
        c cVar;
        boolean z12;
        List<? extends EPGProgramme> list;
        Integer numA;
        if (fVar instanceof i) {
            iVar = (i) fVar;
            int i10 = iVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                iVar.label = i10 - Integer.MIN_VALUE;
            } else {
                iVar = new i(fVar);
            }
        } else {
            iVar = new i(fVar);
        }
        Object obj2 = iVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = iVar.label;
        try {
            if (i11 == 0) {
                r.b(obj2);
                String strH = x1.f1.lb.util.n.n().h(2, j10);
                kotlin.jvm.internal.m.c(strH);
                iVar.L$0 = this;
                iVar.L$1 = str;
                iVar.J$0 = j10;
                iVar.Z$0 = z10;
                iVar.label = 1;
                Object objX = x(str, strH, iVar);
                if (objX != objC) {
                    obj = objX;
                    z11 = z10;
                    cVar = this;
                }
                return objC;
            }
            if (i11 == 1) {
                boolean z13 = iVar.Z$0;
                j10 = iVar.J$0;
                str = (String) iVar.L$1;
                c cVar2 = (c) iVar.L$0;
                r.b(obj2);
                z11 = z13;
                cVar = cVar2;
                obj = obj2;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z12 = iVar.Z$0;
                j10 = iVar.J$0;
                cVar = (c) iVar.L$0;
                r.b(obj2);
            }
            list = (List) obj2;
            numA = cVar.A(list, j10, z12);
            if (numA != null && list != null) {
                return list.get(numA.intValue());
            }
            return null;
            List<? extends EPGProgramme> list2 = (List) obj;
            Integer numA2 = cVar.A(list2, j10, z11);
            if (numA2 != null && list2 != null) {
                return list2.get(numA2.intValue());
            }
            String strH2 = x1.f1.lb.util.n.n().h(7, j10);
            kotlin.jvm.internal.m.e(strH2, "getDate(...)");
            int i12 = Integer.parseInt(strH2);
            String strH3 = x1.f1.lb.util.n.n().h(2, i12 > 12 ? ((long) ((25 - i12) * 3600000)) + j10 : j10 - ((long) ((i12 + 1) * 3600000)));
            kotlin.jvm.internal.m.c(strH3);
            iVar.L$0 = cVar;
            iVar.L$1 = null;
            iVar.J$0 = j10;
            iVar.Z$0 = z11;
            iVar.label = 2;
            Object objX2 = cVar.x(str, strH3, iVar);
            if (objX2 != objC) {
                boolean z14 = z11;
                obj2 = objX2;
                z12 = z14;
                list = (List) obj2;
                numA = cVar.A(list, j10, z12);
                if (numA != null) {
                    return list.get(numA.intValue());
                }
                return null;
            }
            return objC;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007c, code lost:
    
        if (r14 == r0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object D(String str, long j10, v8.f<? super r8.p<? extends EPGProgramme, ? extends EPGProgramme>> fVar) {
        j jVar;
        String str2;
        c cVar;
        long stop;
        EPGProgramme ePGProgramme;
        if (fVar instanceof j) {
            jVar = (j) fVar;
            int i10 = jVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                jVar.label = i10 - Integer.MIN_VALUE;
            } else {
                jVar = new j(fVar);
            }
        } else {
            jVar = new j(fVar);
        }
        j jVar2 = jVar;
        Object objC = jVar2.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        int i11 = jVar2.label;
        if (i11 != 0) {
            if (i11 == 1) {
                stop = jVar2.J$0;
                String str3 = (String) jVar2.L$1;
                cVar = (c) jVar2.L$0;
                r.b(objC);
                str2 = str3;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ePGProgramme = (EPGProgramme) jVar2.L$0;
                r.b(objC);
            }
            return new r8.p(ePGProgramme, (EPGProgramme) objC);
        }
        r.b(objC);
        jVar2.L$0 = this;
        jVar2.L$1 = str;
        jVar2.J$0 = j10;
        jVar2.label = 1;
        str2 = str;
        objC = C(this, str2, j10, false, jVar2, 4, null);
        if (objC != objC2) {
            cVar = this;
            stop = j10;
        }
        return objC2;
        ePGProgramme = (EPGProgramme) objC;
        if (ePGProgramme != null) {
            stop = ePGProgramme.getStop() + 1;
        }
        jVar2.L$0 = ePGProgramme;
        jVar2.L$1 = null;
        jVar2.label = 2;
        objC = cVar.B(str2, stop, true, jVar2);
    }

    public final void E(a parser) {
        kotlin.jvm.internal.m.f(parser, "parser");
        epgFileParser = parser;
    }

    public final boolean F() {
        return isEpgUpdateComplete;
    }

    public final long L(String timestampStr) {
        kotlin.jvm.internal.m.f(timestampStr, "timestampStr");
        String[] strArrL = ac.g.l(timestampStr, " ");
        if (strArrL.length > 1) {
            return dc.a.c(strArrL[0]) + dc.a.c(strArrL[1]);
        }
        if (strArrL.length == 1) {
            return dc.a.c(strArrL[0]);
        }
        return 0L;
    }

    public final void P() {
        if (canStart) {
            return;
        }
        canStart = true;
    }

    public final void S(ChannelEPGIndexResponse response) {
        if (!isEnable) {
            logger.a("epg: disable", new Object[0]);
            return;
        }
        String indexAddress = response != null ? response.getIndexAddress() : null;
        if (indexAddress == null) {
            logger.warn("epg: updateEpg response url is null", new Object[0]);
        } else {
            epgResponse = response;
            R(indexAddress, response.getChecksum());
        }
    }

    public final void q(long now) {
        if (isEnable && !isInUpdating) {
            String indexAddress = nextUpdateUrl;
            String checksum = null;
            if (indexAddress == null) {
                ChannelEPGIndexResponse channelEPGIndexResponse = epgResponse;
                indexAddress = channelEPGIndexResponse != null ? channelEPGIndexResponse.getIndexAddress() : null;
            }
            String str = nextUpdateChecksum;
            if (str == null) {
                ChannelEPGIndexResponse channelEPGIndexResponse2 = epgResponse;
                if (channelEPGIndexResponse2 != null) {
                    checksum = channelEPGIndexResponse2.getChecksum();
                }
            } else {
                checksum = str;
            }
            if (indexAddress == null) {
                return;
            }
            if (isFirstRoundEPG || now >= nextUpdateTime) {
                R(indexAddress, checksum);
            }
        }
    }

    public final void s(boolean isEnable2) {
        isEnable = isEnable2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object w(String str, v8.f<? super List<String>> fVar) {
        d dVar;
        if (fVar instanceof d) {
            dVar = (d) fVar;
            int i10 = dVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                dVar.label = i10 - Integer.MIN_VALUE;
            } else {
                dVar = new d(fVar);
            }
        } else {
            dVar = new d(fVar);
        }
        Object obj = dVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = dVar.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            List list = (List) dVar.L$0;
            r.b(obj);
            return list;
        }
        r.b(obj);
        if (str == null || str.length() == 0) {
            Set<String> setKeySet = posMap.keySet();
            kotlin.jvm.internal.m.e(setKeySet, "<get-keys>(...)");
            List listQ0 = kotlin.collections.r.Q0(setKeySet);
            kotlin.collections.r.A(listQ0);
            return listQ0;
        }
        ArrayList arrayList = new ArrayList();
        i0 i0VarB = a1.b();
        e eVar = new e(str, arrayList, null);
        dVar.L$0 = arrayList;
        dVar.label = 1;
        return kotlinx.coroutines.h.g(i0VarB, eVar, dVar) == objC ? objC : arrayList;
    }

    public final kotlinx.coroutines.flow.f<List<EPGProgramme>> y(String epgId, String yyyyMMdd) {
        kotlin.jvm.internal.m.f(epgId, "epgId");
        kotlin.jvm.internal.m.f(yyyyMMdd, "yyyyMMdd");
        return kotlinx.coroutines.flow.h.v(new g(yyyyMMdd, epgId, null));
    }

    public final kotlinx.coroutines.flow.f<List<EPGProgramme>> z(String epgId) {
        kotlin.jvm.internal.m.f(epgId, "epgId");
        return kotlinx.coroutines.flow.h.v(new h(epgId, null));
    }

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(String str, String str2, String str3, String str4, String str5) {
        if (kotlin.jvm.internal.m.a(str4, str) && !kotlin.jvm.internal.m.a(str5, str)) {
            return -1;
        }
        if (kotlin.jvm.internal.m.a(str4, str2) && !kotlin.jvm.internal.m.a(str5, str) && !kotlin.jvm.internal.m.a(str5, str2)) {
            return -1;
        }
        if (kotlin.jvm.internal.m.a(str4, str3) && !kotlin.jvm.internal.m.a(str5, str) && !kotlin.jvm.internal.m.a(str5, str2) && !kotlin.jvm.internal.m.a(str5, str3)) {
            return -1;
        }
        if (kotlin.jvm.internal.m.a(str5, str) && !kotlin.jvm.internal.m.a(str4, str)) {
            return 1;
        }
        if (kotlin.jvm.internal.m.a(str5, str2) && !kotlin.jvm.internal.m.a(str4, str) && !kotlin.jvm.internal.m.a(str4, str2)) {
            return 1;
        }
        if (kotlin.jvm.internal.m.a(str5, str3) && !kotlin.jvm.internal.m.a(str4, str) && !kotlin.jvm.internal.m.a(str4, str2) && !kotlin.jvm.internal.m.a(str4, str3)) {
            return 1;
        }
        kotlin.jvm.internal.m.c(str5);
        return str4.compareTo(str5);
    }

    private final void Q(int pos, File file, List<? extends EPGProgramme> list) {
        List<EPGProgramme> list2;
        String absolutePath = file.getAbsolutePath();
        ConcurrentHashMap<Integer, ConcurrentHashMap<String, List<EPGProgramme>>> concurrentHashMap = cacheItemMap;
        ConcurrentHashMap<String, List<EPGProgramme>> concurrentHashMap2 = concurrentHashMap.get(Integer.valueOf(pos));
        if (concurrentHashMap2 != null && (list2 = concurrentHashMap2.get(absolutePath)) != null) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("updateEPGCache epg, pos[{}], file[{}], oldList.size[{}], newList.size[{}]", Integer.valueOf(pos), absolutePath, Integer.valueOf(list2.size()), Integer.valueOf(list.size()));
            }
            ConcurrentHashMap<String, List<EPGProgramme>> concurrentHashMap3 = concurrentHashMap.get(Integer.valueOf(pos));
            if (concurrentHashMap3 != null) {
                concurrentHashMap3.put(absolutePath, list);
            }
            kotlin.jvm.internal.m.c(absolutePath);
            N(pos, absolutePath);
            epgCacheMap.put(Long.valueOf(d1.c()), new r8.p<>(Integer.valueOf(pos), absolutePath));
        }
    }

    private final Object r(int i10, EpgIndex epgIndex, v8.f<? super z> fVar) {
        Object objG = kotlinx.coroutines.h.g(a1.b(), new C0423c(epgIndex, i10, null), fVar);
        if (objG == kotlin.coroutines.intrinsics.b.c()) {
            return objG;
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String u(EpgIndex epgIndex) {
        String file = epgIndex.getFile();
        kotlin.jvm.internal.m.e(file, "getFile(...)");
        return file;
    }

    private final List<EPGProgramme> v(int pos, File file) {
        List<EPGProgramme> list;
        String absolutePath = file.getAbsolutePath();
        ConcurrentHashMap<String, List<EPGProgramme>> concurrentHashMap = cacheItemMap.get(Integer.valueOf(pos));
        if (concurrentHashMap != null) {
            list = concurrentHashMap.get(absolutePath);
        } else {
            list = null;
        }
        if (list != null) {
            kotlin.jvm.internal.m.c(absolutePath);
            N(pos, absolutePath);
            epgCacheMap.put(Long.valueOf(d1.c()), new r8.p<>(Integer.valueOf(pos), absolutePath));
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("getEPGCache pos[{}], file[{}], epg.size[{}]", Integer.valueOf(pos), absolutePath, Integer.valueOf(list.size()));
            }
        }
        return list;
    }
}
