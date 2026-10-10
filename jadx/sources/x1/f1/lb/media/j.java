package x1.f1.lb.media;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import c9.q;
import java.io.File;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.n0;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.net.SyslogAppender;
import r8.r;
import r8.u;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.v0;
import x1.f1.lb.util.w0;
import z1.b1.lb.m.sports.DataVersion;
import z1.b1.lb.m.sports.Match;
import z1.b1.lb.m.sports.Matches;
import z1.b1.lb.m.sports.Sport;
import z1.b1.lb.m.sports.Sports;
import z1.b1.lb.m.sports.Tournament;
import z1.b1.lb.m.sports.Tournaments;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ&\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0082@¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0012\u0010\bJ\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J*\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0082@¢\u0006\u0004\b\u001c\u0010\u001dJ'\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\n¢\u0006\u0004\b \u0010\u0003J\u001d\u0010$\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u0013\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040(¢\u0006\u0004\b)\u0010*J\r\u0010+\u001a\u00020\n¢\u0006\u0004\b+\u0010\u0003J\u0012\u0010,\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0004\b,\u0010-J*\u0010.\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b.\u0010\u001aJ\u001a\u0010/\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b/\u0010\bJG\u00104\u001a\u00020\n\"\u0004\b\u0000\u001002\u0006\u00101\u001a\u00020\u00042*\u00103\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000(02¢\u0006\u0004\b4\u00105Js\u0010:\u001a&\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010(02\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u001002\u000e\u00106\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010(2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010(2\u0014\u00109\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u000008¢\u0006\u0004\b:\u0010;R\u001c\u0010@\u001a\n =*\u0004\u0018\u00010<0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010E\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010\u0007R\u0016\u0010G\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010\u0007R\u001e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u001e\u0010O\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010JR<\u0010S\u001a(\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040Q0P0P\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010JR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R4\u0010a\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040Q0P0P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010d¨\u0006f"}, d2 = {"Lx1/f1/lb/media/j;", "", "<init>", "()V", "", "version", "Lz1/b1/lb/m/sports/Sports;", "J", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "sports", "Lr8/z;", "s", "(Ljava/lang/String;Lz1/b1/lb/m/sports/Sports;Lv8/f;)Ljava/lang/Object;", "", ExifInterface.LONGITUDE_EAST, "()J", "sportId", "Lz1/b1/lb/m/sports/Tournaments;", "K", "tournaments", "u", "(Ljava/lang/String;Lz1/b1/lb/m/sports/Tournaments;Lv8/f;)Ljava/lang/Object;", "tournamentId", "date", "Lz1/b1/lb/m/sports/Matches;", "I", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "matches", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lz1/b1/lb/m/sports/Matches;Lv8/f;)Ljava/lang/Object;", "D", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "z", "cacheDirectory", "", "appVersion", "C", "(Ljava/lang/String;I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Ljava/lang/String;", "", "B", "()Ljava/util/List;", "w", "G", "(Lv8/f;)Ljava/lang/Object;", "F", "H", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "title", "Lr8/u;", "triple", "y", "(Ljava/lang/String;Lr8/u;)V", "old", "new", "Lkotlin/Function1;", "key", "x", "(Ljava/util/List;Ljava/util/List;Lc9/l;)Lr8/u;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "lastVersion", "d", "nextCheckDataUpdateTime", "e", "queryDataVersionInterval", "Lx1/f1/lb/cache/a;", "f", "Lx1/f1/lb/cache/a;", "lastSports", "g", "lastTournaments", "h", "lastMatches", "", "", "i", "lastSportIdMap", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInUpdating", "k", "Ljava/lang/Long;", "today", "Ljava/text/SimpleDateFormat;", "l", "Ljava/text/SimpleDateFormat;", "utcSdf", "m", "Ljava/util/Map;", "matchIdsMap", "", "n", "Z", "enableSports", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f20845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String lastVersion;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static long nextCheckDataUpdateTime;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long queryDataVersionInterval;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<Sports> lastSports;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<Tournaments> lastTournaments;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<Matches> lastMatches;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.cache.a<Map<String, Map<String, Set<String>>>> lastSportIdMap;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean isInUpdating;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static Long today;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final SimpleDateFormat utcSdf;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static Map<String, ? extends Map<String, ? extends Set<String>>> matchIdsMap;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static boolean enableSports;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {444, 447}, m = "cacheMatches")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        a(v8.f<? super a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.q(null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {352, 356, 362, 370, 371}, m = "cacheSports")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        b(v8.f<? super b> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.s(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {412, 415}, m = "cacheTournaments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.u(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager$checkAndUpdateSports$1", f = "SportsManager.kt", l = {124, 144}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        int label;

        d(v8.f<? super d> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new d(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((d) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0160, code lost:
        
            if (r11.J(r1, r10) == r0) goto L51;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v23, types: [T, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            b0 b0Var;
            String string;
            z zVar;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                try {
                    if (i10 != 0) {
                        if (i10 != 1) {
                            if (i10 == 2) {
                                r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            b0Var = (b0) this.L$0;
                            r.b(obj);
                        }
                        return z.f17874a;
                    }
                    r.b(obj);
                    b0Var = new b0();
                    x1.f1.lb.api.k kVar = x1.f1.lb.api.k.f20579a;
                    String str = j.lastVersion;
                    this.L$0 = b0Var;
                    this.label = 1;
                    obj = kVar.c(str, this);
                    if (obj == objC) {
                    }
                    return objC;
                    com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) obj;
                    if (aVar instanceof com.skydoves.sandwich.a.c) {
                        b0Var.element = ((com.skydoves.sandwich.a.c) aVar).a();
                    }
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
                        j.logger.error("query data version error:" + v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar), new Object[0]);
                    }
                    if (aVar instanceof com.skydoves.sandwich.a.b) {
                        j.logger.error("query data version failure:" + v0.f21450a.c((com.skydoves.sandwich.a.b) aVar), new Object[0]);
                    }
                    if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
                        j.logger.error("query data version exception:" + v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar), new Object[0]);
                    }
                    if (((DataVersion) b0Var.element) == null) {
                        zVar = z.f17874a;
                    } else {
                        if (x1.f1.lb.config.b.f20643a.t()) {
                            j.logger.debug("update_cache_check_data_version[v" + j.lastVersion + " -> v" + ((DataVersion) b0Var.element).getVersion() + "] changed[" + ((DataVersion) b0Var.element).getChanged() + "]", new Object[0]);
                        }
                        if (!kotlin.jvm.internal.m.a(((DataVersion) b0Var.element).getChanged(), kotlin.coroutines.jvm.internal.b.a(true))) {
                            zVar = z.f17874a;
                        } else {
                            j jVar = j.f20845a;
                            Integer version = ((DataVersion) b0Var.element).getVersion();
                            if (version != null) {
                                string = version.toString();
                            } else {
                                string = null;
                            }
                            this.L$0 = null;
                            this.label = 2;
                        }
                    }
                    j.nextCheckDataUpdateTime += j.f20845a.E();
                    j.isInUpdating.set(false);
                    return zVar;
                } catch (Throwable th) {
                    j.logger.error("update sports failure", th);
                    z zVar2 = z.f17874a;
                }
            } catch (Throwable th2) {
                try {
                    j.logger.error("query data version failure", th2);
                } finally {
                    j.nextCheckDataUpdateTime += j.f20845a.E();
                    j.isInUpdating.set(false);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager$init$5", f = "SportsManager.kt", l = {80}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager$init$5$1", f = "SportsManager.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class a extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super String>, Throwable, v8.f<? super z>, Object> {
            int label;

            a(v8.f<? super a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super String> gVar, Throwable th, v8.f<? super z> fVar) {
                return new a(fVar).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r.b(obj);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        i(v8.f<? super i> fVar) {
            super(2, fVar);
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f20859a = new b<>();

            b() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                j.lastVersion = str;
                return z.f17874a;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new i(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((i) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(w0.f21452a.g("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), j.lastVersion), new a(null));
                kotlinx.coroutines.flow.g gVar = b.f20859a;
                this.label = 1;
                if (fVarF.collect(gVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: x1.f1.lb.media.j$j, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {195, 195}, m = "queryMatches")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0427j extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C0427j(v8.f<? super C0427j> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.F(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {158, SyslogAppender.LOG_LOCAL4, 167, 179, 182, 186}, m = "querySports")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class k extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        k(v8.f<? super k> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.G(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {210, 210}, m = "queryTournaments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class l extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        l(v8.f<? super l> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.H(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {TypedValues.CycleType.TYPE_EASING, 433}, m = "updateMatches")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class m extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        m(v8.f<? super m> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.I(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {269, 282}, m = "updateSports")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class n extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        n(v8.f<? super n> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.J(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.SportsManager", f = "SportsManager.kt", l = {390, TypedValues.CycleType.TYPE_ALPHA}, m = "updateTournaments")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class o extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        o(v8.f<? super o> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return j.this.K(null, this);
        }
    }

    public final void z() {
        enableSports = true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/j$e", "Lf3/a;", "Lz1/b1/lb/m/sports/Sports;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends f3.a<Sports> {
        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/j$f", "Lf3/a;", "Lz1/b1/lb/m/sports/Tournaments;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends f3.a<Tournaments> {
        f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"x1/f1/lb/media/j$g", "Lf3/a;", "Lz1/b1/lb/m/sports/Matches;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g extends f3.a<Matches> {
        g() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\"\n\u0000*\u0001\u0000\b\n\u0018\u00002&\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0003\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00040\u00020\u00020\u0001¨\u0006\u0005"}, d2 = {"x1/f1/lb/media/j$h", "Lf3/a;", "", "", "", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h extends f3.a<Map<String, ? extends Map<String, ? extends Set<? extends String>>>> {
        h() {
        }
    }

    static {
        j jVar = new j();
        f20845a = jVar;
        logger = q6.c.d(jVar.getClass());
        lastVersion = "1";
        queryDataVersionInterval = 600000L;
        isInUpdating = new AtomicBoolean(false);
        utcSdf = new SimpleDateFormat("yyyy-MM-dd", Locale.UK);
        matchIdsMap = n0.i();
    }

    private final String D(String sportId, String tournamentId, String date) {
        return sportId + "." + tournamentId + "." + date;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long E() {
        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
        long jM = bVar.m();
        long j10 = queryDataVersionInterval;
        return jM > j10 ? bVar.m() : j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v19, types: [T, java.lang.Object] */
    public final Object I(String str, String str2, String str3, v8.f<? super Matches> fVar) {
        m mVar;
        j jVar;
        b0 b0Var;
        if (fVar instanceof m) {
            mVar = (m) fVar;
            int i10 = mVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                mVar.label = i10 - Integer.MIN_VALUE;
            } else {
                mVar = new m(fVar);
            }
        } else {
            mVar = new m(fVar);
        }
        m mVar2 = mVar;
        Object objD = mVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = mVar2.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str3 = (String) mVar2.L$3;
                str2 = (String) mVar2.L$2;
                str = (String) mVar2.L$1;
                jVar = (j) mVar2.L$0;
                r.b(objD);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) mVar2.L$0;
                r.b(objD);
            }
            return b0Var.element;
        }
        r.b(objD);
        x1.f1.lb.api.k kVar = x1.f1.lb.api.k.f20579a;
        mVar2.L$0 = this;
        mVar2.L$1 = str;
        mVar2.L$2 = str2;
        mVar2.L$3 = str3;
        mVar2.label = 1;
        objD = kVar.d(str2, str3, mVar2);
        if (objD != objC) {
            jVar = this;
        }
        return objC;
        String str4 = str2;
        String str5 = str3;
        com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objD;
        b0 b0Var2 = new b0();
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            b0Var2.element = ((com.skydoves.sandwich.a.c) aVar).a();
        }
        if (aVar instanceof com.skydoves.sandwich.a.b) {
            logger.error("get matches failure:" + v0.f21450a.c((com.skydoves.sandwich.a.b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            logger.error("get matches exception: " + v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            logger.error("get matches error: " + v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar), new Object[0]);
        }
        Matches matches = (Matches) b0Var2.element;
        mVar2.L$0 = b0Var2;
        mVar2.L$1 = null;
        mVar2.L$2 = null;
        mVar2.L$3 = null;
        mVar2.label = 2;
        if (jVar.q(str, str4, str5, matches, mVar2) != objC) {
            b0Var = b0Var2;
            return b0Var.element;
        }
        return objC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v16, types: [T, java.lang.Object] */
    public final Object J(String str, v8.f<? super Sports> fVar) {
        n nVar;
        j jVar;
        b0 b0Var;
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
        Object objE = nVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = nVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str = (String) nVar.L$1;
                jVar = (j) nVar.L$0;
                r.b(objE);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) nVar.L$0;
                r.b(objE);
            }
            return b0Var.element;
        }
        r.b(objE);
        x1.f1.lb.api.k kVar = x1.f1.lb.api.k.f20579a;
        nVar.L$0 = this;
        nVar.L$1 = str;
        nVar.label = 1;
        objE = kVar.e(nVar);
        if (objE != objC) {
            jVar = this;
        }
        return objC;
        com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objE;
        b0 b0Var2 = new b0();
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            b0Var2.element = ((com.skydoves.sandwich.a.c) aVar).a();
        }
        if (aVar instanceof com.skydoves.sandwich.a.b) {
            logger.error("get sports failure:" + v0.f21450a.c((com.skydoves.sandwich.a.b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            logger.error("get sports exception: " + v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            logger.error("get sports error: " + v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar), new Object[0]);
        }
        Sports sports = (Sports) b0Var2.element;
        nVar.L$0 = b0Var2;
        nVar.L$1 = null;
        nVar.label = 2;
        if (jVar.s(str, sports, nVar) != objC) {
            b0Var = b0Var2;
            return b0Var.element;
        }
        return objC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v16, types: [T, java.lang.Object] */
    public final Object K(String str, v8.f<? super Tournaments> fVar) {
        o oVar;
        j jVar;
        b0 b0Var;
        if (fVar instanceof o) {
            oVar = (o) fVar;
            int i10 = oVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                oVar.label = i10 - Integer.MIN_VALUE;
            } else {
                oVar = new o(fVar);
            }
        } else {
            oVar = new o(fVar);
        }
        Object objF = oVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = oVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str = (String) oVar.L$1;
                jVar = (j) oVar.L$0;
                r.b(objF);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b0Var = (b0) oVar.L$0;
                r.b(objF);
            }
            return b0Var.element;
        }
        r.b(objF);
        x1.f1.lb.api.k kVar = x1.f1.lb.api.k.f20579a;
        oVar.L$0 = this;
        oVar.L$1 = str;
        oVar.label = 1;
        objF = kVar.f(str, oVar);
        if (objF != objC) {
            jVar = this;
        }
        return objC;
        com.skydoves.sandwich.a aVar = (com.skydoves.sandwich.a) objF;
        b0 b0Var2 = new b0();
        if (aVar instanceof com.skydoves.sandwich.a.c) {
            b0Var2.element = ((com.skydoves.sandwich.a.c) aVar).a();
        }
        if (aVar instanceof com.skydoves.sandwich.a.b) {
            logger.error("get tournaments failure:" + v0.f21450a.c((com.skydoves.sandwich.a.b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0152b) {
            logger.error("get tournaments exception: " + v0.f21450a.b((com.skydoves.sandwich.a.b.C0152b) aVar), new Object[0]);
        }
        if (aVar instanceof com.skydoves.sandwich.a.b.C0151a) {
            logger.error("get tournaments error: " + v0.f21450a.a((com.skydoves.sandwich.a.b.C0151a) aVar), new Object[0]);
        }
        Tournaments tournaments = (Tournaments) b0Var2.element;
        oVar.L$0 = b0Var2;
        oVar.L$1 = null;
        oVar.label = 2;
        if (jVar.u(str, tournaments, oVar) != objC) {
            b0Var = b0Var2;
            return b0Var.element;
        }
        return objC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00df, code lost:
    
        if (r13 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(String str, String str2, String str3, Matches matches, v8.f<? super z> fVar) {
        a aVar;
        j jVar;
        String strD;
        String str4;
        j jVar2;
        Object obj;
        j jVar3;
        String str5;
        j jVar4;
        List<Match> listB;
        x1.f1.lb.cache.a<Matches> aVar2;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object objF = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                jVar4 = (j) aVar.L$4;
                str4 = (String) aVar.L$3;
                jVar3 = (j) aVar.L$2;
                String str6 = (String) aVar.L$1;
                Matches matches2 = (Matches) aVar.L$0;
                r.b(objF);
                str5 = str6;
                matches = matches2;
                obj = objF;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(objF);
            }
            return z.f17874a;
        }
        r.b(objF);
        if (matches != null) {
            jVar = f20845a;
            strD = jVar.D(str, str2, str3);
            if (x1.f1.lb.config.b.f20643a.t()) {
                str4 = "update_cache_matches[" + matches.getTournamentId() + "][" + matches.getDate() + "]";
                x1.f1.lb.cache.a<Matches> aVar3 = lastMatches;
                if (aVar3 != null) {
                    aVar.L$0 = matches;
                    aVar.L$1 = strD;
                    aVar.L$2 = jVar;
                    aVar.L$3 = str4;
                    aVar.L$4 = jVar;
                    aVar.label = 1;
                    Object objC2 = aVar3.c(strD, aVar);
                    if (objC2 != objC) {
                        obj = objC2;
                        jVar3 = jVar;
                        str5 = strD;
                        jVar4 = jVar3;
                    }
                } else {
                    jVar2 = jVar;
                    j jVar5 = jVar;
                    str5 = strD;
                    jVar4 = jVar2;
                    jVar3 = jVar5;
                    listB = null;
                    jVar4.y(str4, jVar3.x(listB, matches.b(), new c9.l() { // from class: x1.f1.lb.media.i
                        @Override // c9.l
                        public final Object invoke(Object obj2) {
                            return j.r((Match) obj2);
                        }
                    }));
                    strD = str5;
                    aVar2 = lastMatches;
                    if (aVar2 != null) {
                        aVar.L$0 = null;
                        aVar.L$1 = null;
                        aVar.L$2 = null;
                        aVar.L$3 = null;
                        aVar.L$4 = null;
                        aVar.label = 2;
                        objF = aVar2.f(strD, matches, aVar);
                    }
                }
            } else {
                aVar2 = lastMatches;
                if (aVar2 != null) {
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.L$2 = null;
                    aVar.L$3 = null;
                    aVar.L$4 = null;
                    aVar.label = 2;
                    objF = aVar2.f(strD, matches, aVar);
                }
            }
            return objC;
        }
        return z.f17874a;
        Matches matches3 = (Matches) obj;
        if (matches3 != null) {
            listB = matches3.b();
        } else {
            j jVar6 = jVar3;
            jVar2 = jVar4;
            strD = str5;
            jVar = jVar6;
            j jVar7 = jVar;
            str5 = strD;
            jVar4 = jVar2;
            jVar3 = jVar7;
            listB = null;
        }
        jVar4.y(str4, jVar3.x(listB, matches.b(), new c9.l() { // from class: x1.f1.lb.media.i
            @Override // c9.l
            public final Object invoke(Object obj2) {
                return j.r((Match) obj2);
            }
        }));
        strD = str5;
        aVar2 = lastMatches;
        if (aVar2 != null) {
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.L$2 = null;
            aVar.L$3 = null;
            aVar.L$4 = null;
            aVar.label = 2;
            objF = aVar2.f(strD, matches, aVar);
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer r(Match v10) {
        kotlin.jvm.internal.m.f(v10, "v");
        return v10.getMatchId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:101:0x031b  */
    /* JADX WARN: Code duplicated, block: B:106:0x032f A[Catch: all -> 0x033c, TRY_LEAVE, TryCatch #7 {all -> 0x033c, blocks: (B:104:0x0325, B:106:0x032f), top: B:201:0x0325 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0341  */
    /* JADX WARN: Code duplicated, block: B:132:0x046e  */
    /* JADX WARN: Code duplicated, block: B:135:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:178:0x065f  */
    /* JADX WARN: Code duplicated, block: B:181:0x067c  */
    /* JADX WARN: Code duplicated, block: B:184:0x0684  */
    /* JADX WARN: Code duplicated, block: B:210:0x04d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:44:0x021b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0226  */
    /* JADX WARN: Code duplicated, block: B:51:0x0230  */
    /* JADX WARN: Code duplicated, block: B:56:0x023d  */
    /* JADX WARN: Code duplicated, block: B:59:0x024d  */
    /* JADX WARN: Code duplicated, block: B:63:0x025b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0288 A[Catch: all -> 0x0291, TryCatch #2 {all -> 0x0291, blocks: (B:68:0x027c, B:70:0x0288, B:76:0x02a2, B:78:0x02aa, B:79:0x02b2, B:81:0x02bd, B:82:0x02c5, B:84:0x02ce, B:85:0x02d2, B:86:0x02d6, B:88:0x02dc), top: B:191:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:78:0x02aa A[Catch: all -> 0x0291, TryCatch #2 {all -> 0x0291, blocks: (B:68:0x027c, B:70:0x0288, B:76:0x02a2, B:78:0x02aa, B:79:0x02b2, B:81:0x02bd, B:82:0x02c5, B:84:0x02ce, B:85:0x02d2, B:86:0x02d6, B:88:0x02dc), top: B:191:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:81:0x02bd A[Catch: all -> 0x0291, TryCatch #2 {all -> 0x0291, blocks: (B:68:0x027c, B:70:0x0288, B:76:0x02a2, B:78:0x02aa, B:79:0x02b2, B:81:0x02bd, B:82:0x02c5, B:84:0x02ce, B:85:0x02d2, B:86:0x02d6, B:88:0x02dc), top: B:191:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:84:0x02ce A[Catch: all -> 0x0291, TryCatch #2 {all -> 0x0291, blocks: (B:68:0x027c, B:70:0x0288, B:76:0x02a2, B:78:0x02aa, B:79:0x02b2, B:81:0x02bd, B:82:0x02c5, B:84:0x02ce, B:85:0x02d2, B:86:0x02d6, B:88:0x02dc), top: B:191:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:88:0x02dc A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #2 {all -> 0x0291, blocks: (B:68:0x027c, B:70:0x0288, B:76:0x02a2, B:78:0x02aa, B:79:0x02b2, B:81:0x02bd, B:82:0x02c5, B:84:0x02ce, B:85:0x02d2, B:86:0x02d6, B:88:0x02dc), top: B:191:0x027c }] */
    /* JADX WARN: Code duplicated, block: B:92:0x02f6 A[Catch: all -> 0x0301, TryCatch #1 {all -> 0x0301, blocks: (B:90:0x02e6, B:92:0x02f6, B:96:0x0308, B:98:0x030e), top: B:189:0x02e6 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0305  */
    /* JADX WARN: Code duplicated, block: B:98:0x030e A[Catch: all -> 0x0301, TRY_LEAVE, TryCatch #1 {all -> 0x0301, blocks: (B:90:0x02e6, B:92:0x02f6, B:96:0x0308, B:98:0x030e), top: B:189:0x02e6 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:137:0x04e7 -> B:40:0x01e7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:148:0x056c -> B:149:0x0573). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:42:0x01ef
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object s(java.lang.String r37, z1.b1.lb.m.sports.Sports r38, v8.f<? super r8.z> r39) {
        /*
            Method dump skipped, instruction units count: 1714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.media.j.s(java.lang.String, z1.b1.lb.m.sports.Sports, v8.f):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer t(Sport v10) {
        kotlin.jvm.internal.m.f(v10, "v");
        return v10.getSportId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x00be  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ce, code lost:
    
        if (r13 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(String str, Tournaments tournaments, v8.f<? super z> fVar) {
        c cVar;
        j jVar;
        String str2;
        j jVar2;
        String str3;
        j jVar3;
        Tournaments tournaments2;
        String str4;
        j jVar4;
        List<Tournament> listA;
        x1.f1.lb.cache.a<Tournaments> aVar;
        if (fVar instanceof c) {
            cVar = (c) fVar;
            int i10 = cVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                cVar.label = i10 - Integer.MIN_VALUE;
            } else {
                cVar = new c(fVar);
            }
        } else {
            cVar = new c(fVar);
        }
        Object objF = cVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = cVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                jVar3 = (j) cVar.L$4;
                str4 = (String) cVar.L$3;
                jVar4 = (j) cVar.L$2;
                tournaments2 = (Tournaments) cVar.L$1;
                str3 = (String) cVar.L$0;
                r.b(objF);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(objF);
            }
            return z.f17874a;
        }
        r.b(objF);
        if (tournaments != null) {
            if (x1.f1.lb.config.b.f20643a.t()) {
                jVar = f20845a;
                String str5 = "update_cache_tournaments[" + str + "]";
                x1.f1.lb.cache.a<Tournaments> aVar2 = lastTournaments;
                if (aVar2 != null) {
                    cVar.L$0 = str;
                    cVar.L$1 = tournaments;
                    cVar.L$2 = jVar;
                    cVar.L$3 = str5;
                    cVar.L$4 = jVar;
                    cVar.label = 1;
                    Object objC2 = aVar2.c(str, cVar);
                    if (objC2 != objC) {
                        str3 = str;
                        jVar3 = jVar;
                        objF = objC2;
                        tournaments2 = tournaments;
                        str4 = str5;
                        jVar4 = jVar3;
                    }
                } else {
                    str2 = str5;
                    jVar2 = jVar;
                    str3 = str;
                    jVar3 = jVar2;
                    jVar4 = jVar;
                    listA = null;
                    jVar3.y(str2, jVar4.x(listA, tournaments.a(), new c9.l() { // from class: x1.f1.lb.media.h
                        @Override // c9.l
                        public final Object invoke(Object obj) {
                            return j.v((Tournament) obj);
                        }
                    }));
                    str = str3;
                    aVar = lastTournaments;
                    if (aVar != null) {
                        cVar.L$0 = null;
                        cVar.L$1 = null;
                        cVar.L$2 = null;
                        cVar.L$3 = null;
                        cVar.L$4 = null;
                        cVar.label = 2;
                        objF = aVar.f(str, tournaments, cVar);
                    }
                }
            } else {
                aVar = lastTournaments;
                if (aVar != null) {
                    cVar.L$0 = null;
                    cVar.L$1 = null;
                    cVar.L$2 = null;
                    cVar.L$3 = null;
                    cVar.L$4 = null;
                    cVar.label = 2;
                    objF = aVar.f(str, tournaments, cVar);
                }
            }
            return objC;
        }
        return z.f17874a;
        Tournaments tournaments3 = (Tournaments) objF;
        if (tournaments3 != null) {
            listA = tournaments3.a();
            Tournaments tournaments4 = tournaments2;
            str2 = str4;
            tournaments = tournaments4;
        } else {
            Tournaments tournaments5 = tournaments2;
            str2 = str4;
            tournaments = tournaments5;
            jVar = jVar4;
            jVar2 = jVar3;
            str = str3;
            str3 = str;
            jVar3 = jVar2;
            jVar4 = jVar;
            listA = null;
        }
        jVar3.y(str2, jVar4.x(listA, tournaments.a(), new c9.l() { // from class: x1.f1.lb.media.h
            @Override // c9.l
            public final Object invoke(Object obj) {
                return j.v((Tournament) obj);
            }
        }));
        str = str3;
        aVar = lastTournaments;
        if (aVar != null) {
            cVar.L$0 = null;
            cVar.L$1 = null;
            cVar.L$2 = null;
            cVar.L$3 = null;
            cVar.L$4 = null;
            cVar.label = 2;
            objF = aVar.f(str, tournaments, cVar);
        }
        return z.f17874a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer v(Tournament v10) {
        kotlin.jvm.internal.m.f(v10, "v");
        return v10.getTournamentId();
    }

    public final String A() {
        return lastVersion;
    }

    public final List<String> B() {
        if (!matchIdsMap.isEmpty()) {
            return kotlin.collections.r.I0(kotlin.collections.r.O0(matchIdsMap.keySet()));
        }
        ArrayList arrayList = new ArrayList();
        try {
            Long l10 = today;
            long jLongValue = l10 != null ? l10.longValue() : d1.d();
            for (int i10 = -7; i10 < 8; i10++) {
                arrayList.add(x1.f1.lb.util.n.n().h(3, (((long) (i10 * 24)) * 3600000) + jLongValue));
            }
            return arrayList;
        } catch (Throwable th) {
            logger.error("get subject date list failure", th);
            return arrayList;
        }
    }

    public final void C(String cacheDirectory, int appVersion) {
        kotlin.jvm.internal.m.f(cacheDirectory, "cacheDirectory");
        String str = File.separator;
        Type typeD = new e().d();
        kotlin.jvm.internal.m.e(typeD, "getType(...)");
        lastSports = new x1.f1.lb.cache.a<>(cacheDirectory + str + "s", typeD, appVersion, 10240L, 0, 16, null);
        Type typeD2 = new f().d();
        kotlin.jvm.internal.m.e(typeD2, "getType(...)");
        lastTournaments = new x1.f1.lb.cache.a<>(cacheDirectory + str + "t", typeD2, appVersion, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 0, 16, null);
        Type typeD3 = new g().d();
        kotlin.jvm.internal.m.e(typeD3, "getType(...)");
        lastMatches = new x1.f1.lb.cache.a<>(cacheDirectory + str + "m", typeD3, appVersion, 10485760L, 0, 16, null);
        String str2 = cacheDirectory + str + IjkMediaMeta.IJKM_KEY_TRACK_ID;
        Type typeD4 = new h().d();
        kotlin.jvm.internal.m.e(typeD4, "getType(...)");
        lastSportIdMap = new x1.f1.lb.cache.a<>(str2, typeD4, appVersion, 40960L, 0, 16, null);
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new i(null), 3, null);
        if (x1.f1.lb.config.b.f20643a.t()) {
            queryDataVersionInterval = 30000L;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009e, code lost:
    
        if (r10 == r1) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object F(String str, String str2, String str3, v8.f<? super Matches> fVar) {
        C0427j c0427j;
        Set<String> set;
        j jVar;
        if (fVar instanceof C0427j) {
            c0427j = (C0427j) fVar;
            int i10 = c0427j.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c0427j.label = i10 - Integer.MIN_VALUE;
            } else {
                c0427j = new C0427j(fVar);
            }
        } else {
            c0427j = new C0427j(fVar);
        }
        Object objC = c0427j.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        int i11 = c0427j.label;
        if (i11 != 0) {
            if (i11 == 1) {
                str3 = (String) c0427j.L$3;
                str2 = (String) c0427j.L$2;
                str = (String) c0427j.L$1;
                jVar = (j) c0427j.L$0;
                r.b(objC);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(objC);
            }
            return (Matches) objC;
        }
        r.b(objC);
        if (matchIdsMap.isEmpty()) {
            logger.error("query matches null, matchIds empty [v" + lastVersion + "][" + str + "][" + str2 + "]$[" + str3 + "]", new Object[0]);
        } else {
            Map<String, ? extends Set<String>> map = matchIdsMap.get(str3);
            if (map != null && (set = map.get(str2)) != null && set.contains(str)) {
                x1.f1.lb.cache.a<Matches> aVar = lastMatches;
                if (aVar != null) {
                    String strD = D(str, str2, str3);
                    c0427j.L$0 = this;
                    c0427j.L$1 = str;
                    c0427j.L$2 = str2;
                    c0427j.L$3 = str3;
                    c0427j.label = 1;
                    objC = aVar.c(strD, c0427j);
                    if (objC != objC2) {
                        jVar = this;
                    }
                } else {
                    jVar = this;
                    c0427j.L$0 = null;
                    c0427j.L$1 = null;
                    c0427j.L$2 = null;
                    c0427j.L$3 = null;
                    c0427j.label = 2;
                    objC = jVar.I(str, str2, str3, c0427j);
                }
                return objC2;
            }
        }
        return null;
        Matches matches = (Matches) objC;
        if (matches != null) {
            return matches;
        }
        c0427j.L$0 = null;
        c0427j.L$1 = null;
        c0427j.L$2 = null;
        c0427j.L$3 = null;
        c0427j.label = 2;
        objC = jVar.I(str, str2, str3, c0427j);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0088  */
    /* JADX WARN: Code duplicated, block: B:30:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x009e  */
    /* JADX WARN: Code duplicated, block: B:36:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a3 A[DONT_INVERT, PHI: r2 r6
      0x00a3: PHI (r2v9 z1.b1.lb.m.sports.Sports) = (r2v4 z1.b1.lb.m.sports.Sports), (r2v13 z1.b1.lb.m.sports.Sports), (r2v13 z1.b1.lb.m.sports.Sports) binds: [B:27:0x0086, B:35:0x009f, B:36:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x00a3: PHI (r6v3 x1.f1.lb.media.j) = (r6v1 x1.f1.lb.media.j), (r6v4 x1.f1.lb.media.j), (r6v4 x1.f1.lb.media.j) binds: [B:27:0x0086, B:35:0x009f, B:36:0x00a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:60:0x0111  */
    /* JADX WARN: Code duplicated, block: B:64:0x0122  */
    /* JADX WARN: Code duplicated, block: B:66:0x0125  */
    /* JADX WARN: Code duplicated, block: B:69:0x012b  */
    /* JADX WARN: Code duplicated, block: B:74:0x013c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:75:0x013d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:77:0x0138 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:79:? A[LOOP:0: B:53:0x00f5->B:79:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r11 == r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x011c, code lost:
    
        if (r11 == r1) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0136, code lost:
    
        if (r11 == r1) goto L71;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x00d3, please report this as an issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object G(v8.f<? super Sports> fVar) {
        k kVar;
        j jVar;
        Sports sports;
        j jVar2;
        x1.f1.lb.cache.a<Map<String, Map<String, Set<String>>>> aVar;
        Map<String, ? extends Map<String, ? extends Set<String>>> map;
        x1.f1.lb.cache.a<Sports> aVar2;
        j jVar3;
        j jVar4;
        x1.f1.lb.cache.a<Map<String, Map<String, Set<String>>>> aVar3;
        Map<String, ? extends Map<String, ? extends Set<String>>> map2;
        x1.f1.lb.cache.a<Sports> aVar4;
        if (fVar instanceof k) {
            kVar = (k) fVar;
            int i10 = kVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                kVar.label = i10 - Integer.MIN_VALUE;
            } else {
                kVar = new k(fVar);
            }
        } else {
            kVar = new k(fVar);
        }
        Object objC = kVar.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        switch (kVar.label) {
            case 0:
                r.b(objC);
                x1.f1.lb.cache.a<Sports> aVar5 = lastSports;
                if (aVar5 == null) {
                    jVar = this;
                    sports = null;
                    if (!matchIdsMap.isEmpty()) {
                        aVar = lastSportIdMap;
                        if (aVar != null) {
                            kVar.L$0 = jVar;
                            kVar.L$1 = sports;
                            kVar.label = 2;
                            objC = aVar.c("sports_id_map", kVar);
                        } else {
                            map = null;
                            if (map != null) {
                                matchIdsMap = map;
                            }
                            if (sports == null) {
                                aVar2 = lastSports;
                                if (aVar2 != null) {
                                    kVar.L$0 = jVar;
                                    kVar.L$1 = null;
                                    kVar.label = 3;
                                    objC = aVar2.c("sports", kVar);
                                    if (objC != objC2) {
                                        jVar3 = jVar;
                                        jVar = jVar3;
                                        sports = (Sports) objC;
                                        if (sports == null) {
                                            return sports;
                                        }
                                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                            lastVersion = "1";
                                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                        }
                                        jVar.w();
                                        jVar4 = jVar;
                                        while (isInUpdating.get()) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 4;
                                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                            }
                                        }
                                        aVar3 = lastSportIdMap;
                                        if (aVar3 != null) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 5;
                                            objC = aVar3.c("sports_id_map", kVar);
                                        } else {
                                            map2 = null;
                                            if (map2 != null) {
                                                matchIdsMap = map2;
                                            }
                                            aVar4 = lastSports;
                                            if (aVar4 != null) {
                                                return null;
                                            }
                                            kVar.L$0 = null;
                                            kVar.L$1 = null;
                                            kVar.label = 6;
                                            objC = aVar4.c("sports", kVar);
                                        }
                                    }
                                } else {
                                    sports = null;
                                    if (sports == null) {
                                        return sports;
                                    }
                                    if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                        lastVersion = "1";
                                        w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                    }
                                    jVar.w();
                                    jVar4 = jVar;
                                    while (isInUpdating.get()) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 4;
                                        if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                        }
                                    }
                                    aVar3 = lastSportIdMap;
                                    if (aVar3 != null) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 5;
                                        objC = aVar3.c("sports_id_map", kVar);
                                    } else {
                                        map2 = null;
                                        if (map2 != null) {
                                            matchIdsMap = map2;
                                        }
                                        aVar4 = lastSports;
                                        if (aVar4 != null) {
                                            return null;
                                        }
                                        kVar.L$0 = null;
                                        kVar.L$1 = null;
                                        kVar.label = 6;
                                        objC = aVar4.c("sports", kVar);
                                    }
                                }
                            } else {
                                aVar2 = lastSports;
                                if (aVar2 != null) {
                                    kVar.L$0 = jVar;
                                    kVar.L$1 = null;
                                    kVar.label = 3;
                                    objC = aVar2.c("sports", kVar);
                                    if (objC != objC2) {
                                        jVar3 = jVar;
                                        jVar = jVar3;
                                        sports = (Sports) objC;
                                        if (sports == null) {
                                            return sports;
                                        }
                                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                            lastVersion = "1";
                                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                        }
                                        jVar.w();
                                        jVar4 = jVar;
                                        while (isInUpdating.get()) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 4;
                                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                            }
                                        }
                                        aVar3 = lastSportIdMap;
                                        if (aVar3 != null) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 5;
                                            objC = aVar3.c("sports_id_map", kVar);
                                        } else {
                                            map2 = null;
                                            if (map2 != null) {
                                                matchIdsMap = map2;
                                            }
                                            aVar4 = lastSports;
                                            if (aVar4 != null) {
                                                return null;
                                            }
                                            kVar.L$0 = null;
                                            kVar.L$1 = null;
                                            kVar.label = 6;
                                            objC = aVar4.c("sports", kVar);
                                        }
                                    }
                                } else {
                                    sports = null;
                                    if (sports == null) {
                                        return sports;
                                    }
                                    if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                        lastVersion = "1";
                                        w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                    }
                                    jVar.w();
                                    jVar4 = jVar;
                                    while (isInUpdating.get()) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 4;
                                        if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                        }
                                    }
                                    aVar3 = lastSportIdMap;
                                    if (aVar3 != null) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 5;
                                        objC = aVar3.c("sports_id_map", kVar);
                                    } else {
                                        map2 = null;
                                        if (map2 != null) {
                                            matchIdsMap = map2;
                                        }
                                        aVar4 = lastSports;
                                        if (aVar4 != null) {
                                            return null;
                                        }
                                        kVar.L$0 = null;
                                        kVar.L$1 = null;
                                        kVar.label = 6;
                                        objC = aVar4.c("sports", kVar);
                                    }
                                }
                            }
                        }
                    } else if (sports == null) {
                        aVar2 = lastSports;
                        if (aVar2 != null) {
                            kVar.L$0 = jVar;
                            kVar.L$1 = null;
                            kVar.label = 3;
                            objC = aVar2.c("sports", kVar);
                            if (objC != objC2) {
                                jVar3 = jVar;
                                jVar = jVar3;
                                sports = (Sports) objC;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        } else {
                            sports = null;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    } else {
                        aVar2 = lastSports;
                        if (aVar2 != null) {
                            kVar.L$0 = jVar;
                            kVar.L$1 = null;
                            kVar.label = 3;
                            objC = aVar2.c("sports", kVar);
                            if (objC != objC2) {
                                jVar3 = jVar;
                                jVar = jVar3;
                                sports = (Sports) objC;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        } else {
                            sports = null;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    }
                    break;
                } else {
                    kVar.L$0 = this;
                    kVar.label = 1;
                    objC = aVar5.c("sports", kVar);
                    if (objC != objC2) {
                        jVar2 = this;
                        jVar = jVar2;
                        sports = (Sports) objC;
                        if (!matchIdsMap.isEmpty()) {
                            aVar = lastSportIdMap;
                            if (aVar != null) {
                                kVar.L$0 = jVar;
                                kVar.L$1 = sports;
                                kVar.label = 2;
                                objC = aVar.c("sports_id_map", kVar);
                            } else {
                                map = null;
                                if (map != null) {
                                    matchIdsMap = map;
                                }
                                if (sports == null) {
                                    aVar2 = lastSports;
                                    if (aVar2 != null) {
                                        kVar.L$0 = jVar;
                                        kVar.L$1 = null;
                                        kVar.label = 3;
                                        objC = aVar2.c("sports", kVar);
                                        if (objC != objC2) {
                                            jVar3 = jVar;
                                            jVar = jVar3;
                                            sports = (Sports) objC;
                                            if (sports == null) {
                                                return sports;
                                            }
                                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                                lastVersion = "1";
                                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                            }
                                            jVar.w();
                                            jVar4 = jVar;
                                            while (isInUpdating.get()) {
                                                kVar.L$0 = jVar4;
                                                kVar.L$1 = null;
                                                kVar.label = 4;
                                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                                }
                                            }
                                            aVar3 = lastSportIdMap;
                                            if (aVar3 != null) {
                                                kVar.L$0 = jVar4;
                                                kVar.L$1 = null;
                                                kVar.label = 5;
                                                objC = aVar3.c("sports_id_map", kVar);
                                            } else {
                                                map2 = null;
                                                if (map2 != null) {
                                                    matchIdsMap = map2;
                                                }
                                                aVar4 = lastSports;
                                                if (aVar4 != null) {
                                                    return null;
                                                }
                                                kVar.L$0 = null;
                                                kVar.L$1 = null;
                                                kVar.label = 6;
                                                objC = aVar4.c("sports", kVar);
                                            }
                                        }
                                    } else {
                                        sports = null;
                                        if (sports == null) {
                                            return sports;
                                        }
                                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                            lastVersion = "1";
                                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                        }
                                        jVar.w();
                                        jVar4 = jVar;
                                        while (isInUpdating.get()) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 4;
                                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                            }
                                        }
                                        aVar3 = lastSportIdMap;
                                        if (aVar3 != null) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 5;
                                            objC = aVar3.c("sports_id_map", kVar);
                                        } else {
                                            map2 = null;
                                            if (map2 != null) {
                                                matchIdsMap = map2;
                                            }
                                            aVar4 = lastSports;
                                            if (aVar4 != null) {
                                                return null;
                                            }
                                            kVar.L$0 = null;
                                            kVar.L$1 = null;
                                            kVar.label = 6;
                                            objC = aVar4.c("sports", kVar);
                                        }
                                    }
                                } else {
                                    aVar2 = lastSports;
                                    if (aVar2 != null) {
                                        kVar.L$0 = jVar;
                                        kVar.L$1 = null;
                                        kVar.label = 3;
                                        objC = aVar2.c("sports", kVar);
                                        if (objC != objC2) {
                                            jVar3 = jVar;
                                            jVar = jVar3;
                                            sports = (Sports) objC;
                                            if (sports == null) {
                                                return sports;
                                            }
                                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                                lastVersion = "1";
                                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                            }
                                            jVar.w();
                                            jVar4 = jVar;
                                            while (isInUpdating.get()) {
                                                kVar.L$0 = jVar4;
                                                kVar.L$1 = null;
                                                kVar.label = 4;
                                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                                }
                                            }
                                            aVar3 = lastSportIdMap;
                                            if (aVar3 != null) {
                                                kVar.L$0 = jVar4;
                                                kVar.L$1 = null;
                                                kVar.label = 5;
                                                objC = aVar3.c("sports_id_map", kVar);
                                            } else {
                                                map2 = null;
                                                if (map2 != null) {
                                                    matchIdsMap = map2;
                                                }
                                                aVar4 = lastSports;
                                                if (aVar4 != null) {
                                                    return null;
                                                }
                                                kVar.L$0 = null;
                                                kVar.L$1 = null;
                                                kVar.label = 6;
                                                objC = aVar4.c("sports", kVar);
                                            }
                                        }
                                    } else {
                                        sports = null;
                                        if (sports == null) {
                                            return sports;
                                        }
                                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                            lastVersion = "1";
                                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                        }
                                        jVar.w();
                                        jVar4 = jVar;
                                        while (isInUpdating.get()) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 4;
                                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                            }
                                        }
                                        aVar3 = lastSportIdMap;
                                        if (aVar3 != null) {
                                            kVar.L$0 = jVar4;
                                            kVar.L$1 = null;
                                            kVar.label = 5;
                                            objC = aVar3.c("sports_id_map", kVar);
                                        } else {
                                            map2 = null;
                                            if (map2 != null) {
                                                matchIdsMap = map2;
                                            }
                                            aVar4 = lastSports;
                                            if (aVar4 != null) {
                                                return null;
                                            }
                                            kVar.L$0 = null;
                                            kVar.L$1 = null;
                                            kVar.label = 6;
                                            objC = aVar4.c("sports", kVar);
                                        }
                                    }
                                }
                            }
                        } else {
                            if (sports == null || matchIdsMap.isEmpty()) {
                                aVar2 = lastSports;
                                if (aVar2 != null) {
                                    kVar.L$0 = jVar;
                                    kVar.L$1 = null;
                                    kVar.label = 3;
                                    objC = aVar2.c("sports", kVar);
                                    if (objC != objC2) {
                                        jVar3 = jVar;
                                        jVar = jVar3;
                                        sports = (Sports) objC;
                                    }
                                } else {
                                    sports = null;
                                }
                            }
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    }
                    break;
                }
                return objC2;
            case 1:
                jVar2 = (j) kVar.L$0;
                r.b(objC);
                jVar = jVar2;
                sports = (Sports) objC;
                if (!matchIdsMap.isEmpty()) {
                    if (sports == null) {
                        aVar2 = lastSports;
                        if (aVar2 != null) {
                            kVar.L$0 = jVar;
                            kVar.L$1 = null;
                            kVar.label = 3;
                            objC = aVar2.c("sports", kVar);
                            if (objC != objC2) {
                                jVar3 = jVar;
                                jVar = jVar3;
                                sports = (Sports) objC;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        } else {
                            sports = null;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    } else {
                        aVar2 = lastSports;
                        if (aVar2 != null) {
                            kVar.L$0 = jVar;
                            kVar.L$1 = null;
                            kVar.label = 3;
                            objC = aVar2.c("sports", kVar);
                            if (objC != objC2) {
                                jVar3 = jVar;
                                jVar = jVar3;
                                sports = (Sports) objC;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        } else {
                            sports = null;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    }
                    break;
                } else {
                    aVar = lastSportIdMap;
                    if (aVar != null) {
                        kVar.L$0 = jVar;
                        kVar.L$1 = sports;
                        kVar.label = 2;
                        objC = aVar.c("sports_id_map", kVar);
                    } else {
                        map = null;
                        if (map != null) {
                            matchIdsMap = map;
                        }
                        if (sports == null) {
                            aVar2 = lastSports;
                            if (aVar2 != null) {
                                kVar.L$0 = jVar;
                                kVar.L$1 = null;
                                kVar.label = 3;
                                objC = aVar2.c("sports", kVar);
                                if (objC != objC2) {
                                    jVar3 = jVar;
                                    jVar = jVar3;
                                    sports = (Sports) objC;
                                    if (sports == null) {
                                        return sports;
                                    }
                                    if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                        lastVersion = "1";
                                        w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                    }
                                    jVar.w();
                                    jVar4 = jVar;
                                    while (isInUpdating.get()) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 4;
                                        if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                        }
                                    }
                                    aVar3 = lastSportIdMap;
                                    if (aVar3 != null) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 5;
                                        objC = aVar3.c("sports_id_map", kVar);
                                    } else {
                                        map2 = null;
                                        if (map2 != null) {
                                            matchIdsMap = map2;
                                        }
                                        aVar4 = lastSports;
                                        if (aVar4 != null) {
                                            return null;
                                        }
                                        kVar.L$0 = null;
                                        kVar.L$1 = null;
                                        kVar.label = 6;
                                        objC = aVar4.c("sports", kVar);
                                    }
                                }
                            } else {
                                sports = null;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        } else {
                            aVar2 = lastSports;
                            if (aVar2 != null) {
                                kVar.L$0 = jVar;
                                kVar.L$1 = null;
                                kVar.label = 3;
                                objC = aVar2.c("sports", kVar);
                                if (objC != objC2) {
                                    jVar3 = jVar;
                                    jVar = jVar3;
                                    sports = (Sports) objC;
                                    if (sports == null) {
                                        return sports;
                                    }
                                    if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                        lastVersion = "1";
                                        w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                    }
                                    jVar.w();
                                    jVar4 = jVar;
                                    while (isInUpdating.get()) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 4;
                                        if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                        }
                                    }
                                    aVar3 = lastSportIdMap;
                                    if (aVar3 != null) {
                                        kVar.L$0 = jVar4;
                                        kVar.L$1 = null;
                                        kVar.label = 5;
                                        objC = aVar3.c("sports_id_map", kVar);
                                    } else {
                                        map2 = null;
                                        if (map2 != null) {
                                            matchIdsMap = map2;
                                        }
                                        aVar4 = lastSports;
                                        if (aVar4 != null) {
                                            return null;
                                        }
                                        kVar.L$0 = null;
                                        kVar.L$1 = null;
                                        kVar.label = 6;
                                        objC = aVar4.c("sports", kVar);
                                    }
                                }
                            } else {
                                sports = null;
                                if (sports == null) {
                                    return sports;
                                }
                                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                    lastVersion = "1";
                                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                                }
                                jVar.w();
                                jVar4 = jVar;
                                while (isInUpdating.get()) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 4;
                                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                    }
                                }
                                aVar3 = lastSportIdMap;
                                if (aVar3 != null) {
                                    kVar.L$0 = jVar4;
                                    kVar.L$1 = null;
                                    kVar.label = 5;
                                    objC = aVar3.c("sports_id_map", kVar);
                                } else {
                                    map2 = null;
                                    if (map2 != null) {
                                        matchIdsMap = map2;
                                    }
                                    aVar4 = lastSports;
                                    if (aVar4 != null) {
                                        return null;
                                    }
                                    kVar.L$0 = null;
                                    kVar.L$1 = null;
                                    kVar.label = 6;
                                    objC = aVar4.c("sports", kVar);
                                }
                            }
                        }
                    }
                    break;
                }
                return objC2;
            case 2:
                sports = (Sports) kVar.L$1;
                jVar = (j) kVar.L$0;
                r.b(objC);
                map = (Map) objC;
                if (map != null) {
                    matchIdsMap = map;
                }
                if (sports == null) {
                    aVar2 = lastSports;
                    if (aVar2 != null) {
                        kVar.L$0 = jVar;
                        kVar.L$1 = null;
                        kVar.label = 3;
                        objC = aVar2.c("sports", kVar);
                        if (objC != objC2) {
                            jVar3 = jVar;
                            jVar = jVar3;
                            sports = (Sports) objC;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    } else {
                        sports = null;
                        if (sports == null) {
                            return sports;
                        }
                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                            lastVersion = "1";
                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                        }
                        jVar.w();
                        jVar4 = jVar;
                        while (isInUpdating.get()) {
                            kVar.L$0 = jVar4;
                            kVar.L$1 = null;
                            kVar.label = 4;
                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                            }
                        }
                        aVar3 = lastSportIdMap;
                        if (aVar3 != null) {
                            kVar.L$0 = jVar4;
                            kVar.L$1 = null;
                            kVar.label = 5;
                            objC = aVar3.c("sports_id_map", kVar);
                        } else {
                            map2 = null;
                            if (map2 != null) {
                                matchIdsMap = map2;
                            }
                            aVar4 = lastSports;
                            if (aVar4 != null) {
                                return null;
                            }
                            kVar.L$0 = null;
                            kVar.L$1 = null;
                            kVar.label = 6;
                            objC = aVar4.c("sports", kVar);
                        }
                    }
                    break;
                } else {
                    aVar2 = lastSports;
                    if (aVar2 != null) {
                        kVar.L$0 = jVar;
                        kVar.L$1 = null;
                        kVar.label = 3;
                        objC = aVar2.c("sports", kVar);
                        if (objC != objC2) {
                            jVar3 = jVar;
                            jVar = jVar3;
                            sports = (Sports) objC;
                            if (sports == null) {
                                return sports;
                            }
                            if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                                lastVersion = "1";
                                w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                            }
                            jVar.w();
                            jVar4 = jVar;
                            while (isInUpdating.get()) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 4;
                                if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                                }
                            }
                            aVar3 = lastSportIdMap;
                            if (aVar3 != null) {
                                kVar.L$0 = jVar4;
                                kVar.L$1 = null;
                                kVar.label = 5;
                                objC = aVar3.c("sports_id_map", kVar);
                            } else {
                                map2 = null;
                                if (map2 != null) {
                                    matchIdsMap = map2;
                                }
                                aVar4 = lastSports;
                                if (aVar4 != null) {
                                    return null;
                                }
                                kVar.L$0 = null;
                                kVar.L$1 = null;
                                kVar.label = 6;
                                objC = aVar4.c("sports", kVar);
                            }
                        }
                    } else {
                        sports = null;
                        if (sports == null) {
                            return sports;
                        }
                        if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                            lastVersion = "1";
                            w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                        }
                        jVar.w();
                        jVar4 = jVar;
                        while (isInUpdating.get()) {
                            kVar.L$0 = jVar4;
                            kVar.L$1 = null;
                            kVar.label = 4;
                            if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                            }
                        }
                        aVar3 = lastSportIdMap;
                        if (aVar3 != null) {
                            kVar.L$0 = jVar4;
                            kVar.L$1 = null;
                            kVar.label = 5;
                            objC = aVar3.c("sports_id_map", kVar);
                        } else {
                            map2 = null;
                            if (map2 != null) {
                                matchIdsMap = map2;
                            }
                            aVar4 = lastSports;
                            if (aVar4 != null) {
                                return null;
                            }
                            kVar.L$0 = null;
                            kVar.L$1 = null;
                            kVar.label = 6;
                            objC = aVar4.c("sports", kVar);
                        }
                    }
                    break;
                }
                return objC2;
            case 3:
                jVar3 = (j) kVar.L$0;
                r.b(objC);
                jVar = jVar3;
                sports = (Sports) objC;
                if (sports == null) {
                    return sports;
                }
                if (!kotlin.jvm.internal.m.a(lastVersion, "1")) {
                    lastVersion = "1";
                    w0.f21452a.t("sports_data_version_" + x1.f1.lb.config.b.f20643a.g(), "1");
                }
                jVar.w();
                jVar4 = jVar;
                while (isInUpdating.get()) {
                    kVar.L$0 = jVar4;
                    kVar.L$1 = null;
                    kVar.label = 4;
                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                        return objC2;
                    }
                }
                aVar3 = lastSportIdMap;
                if (aVar3 != null) {
                    map2 = null;
                    if (map2 != null) {
                        matchIdsMap = map2;
                    }
                    aVar4 = lastSports;
                    if (aVar4 != null) {
                        return null;
                    }
                    kVar.L$0 = null;
                    kVar.L$1 = null;
                    kVar.label = 6;
                    objC = aVar4.c("sports", kVar);
                    break;
                } else {
                    kVar.L$0 = jVar4;
                    kVar.L$1 = null;
                    kVar.label = 5;
                    objC = aVar3.c("sports_id_map", kVar);
                    break;
                }
                return objC2;
            case 4:
                jVar4 = (j) kVar.L$0;
                r.b(objC);
                while (isInUpdating.get()) {
                    kVar.L$0 = jVar4;
                    kVar.L$1 = null;
                    kVar.label = 4;
                    if (kotlinx.coroutines.v0.a(500L, kVar) == objC2) {
                        return objC2;
                    }
                }
                aVar3 = lastSportIdMap;
                if (aVar3 != null) {
                    map2 = null;
                    if (map2 != null) {
                        matchIdsMap = map2;
                    }
                    aVar4 = lastSports;
                    if (aVar4 != null) {
                        return null;
                    }
                    kVar.L$0 = null;
                    kVar.L$1 = null;
                    kVar.label = 6;
                    objC = aVar4.c("sports", kVar);
                    break;
                } else {
                    kVar.L$0 = jVar4;
                    kVar.L$1 = null;
                    kVar.label = 5;
                    objC = aVar3.c("sports_id_map", kVar);
                    break;
                }
                return objC2;
            case 5:
                r.b(objC);
                map2 = (Map) objC;
                if (map2 != null) {
                    matchIdsMap = map2;
                }
                aVar4 = lastSports;
                if (aVar4 != null) {
                    return null;
                }
                kVar.L$0 = null;
                kVar.L$1 = null;
                kVar.label = 6;
                objC = aVar4.c("sports", kVar);
                break;
                break;
            case 6:
                r.b(objC);
                return (Sports) objC;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006a A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object H(String str, v8.f<? super Tournaments> fVar) {
        l lVar;
        j jVar;
        Object objK;
        if (fVar instanceof l) {
            lVar = (l) fVar;
            int i10 = lVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                lVar.label = i10 - Integer.MIN_VALUE;
            } else {
                lVar = new l(fVar);
            }
        } else {
            lVar = new l(fVar);
        }
        Object objC = lVar.result;
        Object objC2 = kotlin.coroutines.intrinsics.b.c();
        int i11 = lVar.label;
        if (i11 == 0) {
            r.b(objC);
            x1.f1.lb.cache.a<Tournaments> aVar = lastTournaments;
            if (aVar != null) {
                lVar.L$0 = this;
                lVar.L$1 = str;
                lVar.label = 1;
                objC = aVar.c(str, lVar);
                if (objC != objC2) {
                    jVar = this;
                }
            } else {
                jVar = this;
                lVar.L$0 = null;
                lVar.L$1 = null;
                lVar.label = 2;
                objK = jVar.K(str, lVar);
                if (objK != objC2) {
                    return objK;
                }
            }
            return objC2;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(objC);
            return objC;
        }
        str = (String) lVar.L$1;
        jVar = (j) lVar.L$0;
        r.b(objC);
        Tournaments tournaments = (Tournaments) objC;
        if (tournaments != null) {
            return tournaments;
        }
        lVar.L$0 = null;
        lVar.L$1 = null;
        lVar.label = 2;
        objK = jVar.K(str, lVar);
        if (objK != objC2) {
            return objC2;
        }
        return objK;
    }

    public final void w() {
        if (enableSports) {
            AtomicBoolean atomicBoolean = isInUpdating;
            if (atomicBoolean.get() || d1.d() < nextCheckDataUpdateTime || !atomicBoolean.compareAndSet(false, true)) {
                return;
            }
            kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new d(null), 3, null);
        }
    }

    public final <K, V> u<List<V>, List<V>, List<V>> x(List<? extends V> old, List<? extends V> list, c9.l<? super V, ? extends K> key) {
        kotlin.jvm.internal.m.f(key, "key");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (V v10 : old == null ? kotlin.collections.r.l() : old) {
            linkedHashMap.put(key.invoke(v10), v10);
        }
        if (list == null) {
            list = kotlin.collections.r.l();
        }
        for (V v11 : list) {
            K kInvoke = key.invoke(v11);
            linkedHashMap2.put(kInvoke, v11);
            Object obj = linkedHashMap.get(kInvoke);
            if (obj == null) {
                arrayList.add(v11);
            } else if (!kotlin.jvm.internal.m.a(obj, v11)) {
                arrayList3.add(v11);
            }
        }
        if (old == null) {
            old = kotlin.collections.r.l();
        }
        for (V v12 : old) {
            if (linkedHashMap2.get(key.invoke(v12)) == null) {
                arrayList2.add(v12);
            }
        }
        return new u<>(arrayList, arrayList2, arrayList3);
    }

    public final <V> void y(String title, u<? extends List<? extends V>, ? extends List<? extends V>, ? extends List<? extends V>> triple) {
        kotlin.jvm.internal.m.f(title, "title");
        kotlin.jvm.internal.m.f(triple, "triple");
        List<? extends V> listD = triple.d();
        List<? extends V> listE = triple.e();
        List<? extends V> listF = triple.f();
        if (listD.size() == 0 && listE.size() == 0 && listF.size() == 0) {
            return;
        }
        com.google.gson.e eVar = new com.google.gson.e();
        logger.debug(title + ": add[" + listD.size() + "] remove[" + listE.size() + "] update[" + listF.size() + "]", new Object[0]);
        for (V v10 : listD) {
            logger.debug(title + " add: " + eVar.w(v10), new Object[0]);
        }
        for (V v11 : listE) {
            logger.debug(title + " remove: " + eVar.w(v11), new Object[0]);
        }
        for (V v12 : listF) {
            logger.debug(title + " update: " + eVar.w(v12), new Object[0]);
        }
    }

    private j() {
    }
}
