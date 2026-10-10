package x1.f1.lb.streaming;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import c9.q;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import com.taobao.sophix.PatchStatus;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import nf.r;
import org.apache.log4j.net.SyslogAppender;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.a1;
import x1.f1.lb.util.d1;
import z1.b1.lb.m.meta.ChannelStreamResponse;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011JF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0082@¢\u0006\u0004\b\u0016\u0010\u0017JE\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\r\u001a\u00020\u001fH\u0086@¢\u0006\u0004\b \u0010!JH\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u001fH\u0086@¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020&2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b'\u0010(J\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0004\b-\u0010.J\u0015\u0010/\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0004\b/\u0010.R\u001c\u00104\u001a\n 1*\u0004\u0018\u000100008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010B\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010?R\u0018\u0010E\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010?R\u0018\u0010J\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010Q¨\u0006S"}, d2 = {"Lx1/f1/lb/streaming/a;", "", "<init>", "()V", "Lv6/c;", "playType", "", "name", "mediaId", "routeId", "", "mediaMode", "", "isForce", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "q", "(Lv6/c;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLv8/f;)Ljava/lang/Object;", "", "session", "Ltf/d;", "zappingStat", "y", "(JLtf/d;Lv6/c;Ljava/lang/String;Ljava/lang/String;ILv8/f;)Ljava/lang/Object;", "playerZappingStat", "u", "(JLjava/lang/String;Ljava/lang/String;ILv6/c;Ltf/d;)Lkotlinx/coroutines/flow/f;", "x", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;", "Lz1/b1/lb/m/meta/ChannelStreamResponse;", "response", "Ljava/util/concurrent/atomic/AtomicBoolean;", "t", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Ljava/util/concurrent/atomic/AtomicBoolean;Lv8/f;)Ljava/lang/Object;", "startTimestamp", "stopTimestamp", "s", "(Lz1/b1/lb/m/meta/ChannelStreamResponse;Ljava/lang/String;JJILjava/util/concurrent/atomic/AtomicBoolean;Lv8/f;)Ljava/lang/Object;", "Lr8/z;", "r", "(J)V", IjkMediaMeta.IJKM_KEY_TYPE, "z", "(Lv6/c;Lv8/f;)Ljava/lang/Object;", "params", "w", "(Ljava/lang/String;)Ljava/lang/String;", "v", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/Long;", "lastPlaySession", "d", "Lv6/c;", "lastPlayType", "e", "I", "engineRestartCnt", "f", "Ljava/lang/String;", "lastMetaId", "g", "lastRouteId", "h", "Ljava/lang/Integer;", "lastMediaMode", "i", "lastUid", "j", "Lnf/r;", "lastUrlReadyEvent", "Lkotlinx/coroutines/sync/a;", "k", "Lkotlinx/coroutines/sync/a;", "mutex", "Ljava/util/concurrent/atomic/AtomicInteger;", "l", "Ljava/util/concurrent/atomic/AtomicInteger;", "count", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Long lastPlaySession;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int engineRestartCnt;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static String lastMetaId;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String lastRouteId;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static Integer lastMediaMode;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String lastUid;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static r lastUrlReadyEvent;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20960a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(a.class);

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static v6.c lastPlayType = v6.c.LIVE;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static final kotlinx.coroutines.sync.a mutex = kotlinx.coroutines.sync.c.b(false, 1, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger count = new AtomicInteger(0);

    /* JADX INFO: renamed from: x1.f1.lb.streaming.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper", f = "StreamHelper.kt", l = {373, PatchStatus.CODE_LOAD_LIB_UNZIP, SyslogAppender.LOG_LOCAL4, 173, SyslogAppender.LOG_LOCAL7}, m = "checkAndStartPlayFlow")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class C0432a extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C0432a(v8.f<? super C0432a> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.q(null, null, null, null, 0, false, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$checkAndStartPlayFlow$2$1", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lnf/r;", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super r>, Throwable, v8.f<? super z>, Object> {
        final /* synthetic */ ArrayList<Throwable> $retThrowable;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ArrayList<Throwable> arrayList, v8.f<? super b> fVar) {
            super(3, fVar);
            this.$retThrowable = arrayList;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super r> gVar, Throwable th, v8.f<? super z> fVar) {
            b bVar = new b(this.$retThrowable, fVar);
            bVar.L$0 = th;
            return bVar.invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                this.$retThrowable.add((Throwable) this.L$0);
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f20972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f20975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f20976e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f20977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ArrayList<r> f20978g;

        c(boolean z10, String str, String str2, int i10, int i11, String str3, ArrayList<r> arrayList) {
            this.f20972a = z10;
            this.f20973b = str;
            this.f20974c = str2;
            this.f20975d = i10;
            this.f20976e = i11;
            this.f20977f = str3;
            this.f20978g = arrayList;
        }

        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(r rVar, v8.f<? super z> fVar) {
            a.logger.a("create_session[" + rVar.g() + "] " + this.f20972a + ", " + this.f20973b + ", " + this.f20974c + ", " + this.f20975d + " -> " + this.f20976e, new Object[0]);
            a.lastUid = this.f20977f;
            this.f20978g.add(rVar);
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$checkAndStartPlayFlow$2$3", f = "StreamHelper.kt", l = {RsaOaep.DerParser.PRIVATE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lnf/r;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<? super r>, v8.f<? super z>, Object> {
        final /* synthetic */ ArrayList<r> $retEvent;
        final /* synthetic */ ArrayList<Throwable> $retThrowable;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ArrayList<r> arrayList, ArrayList<Throwable> arrayList2, v8.f<? super d> fVar) {
            super(2, fVar);
            this.$retEvent = arrayList;
            this.$retThrowable = arrayList2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            d dVar = new d(this.$retEvent, this.$retThrowable, fVar);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super r> gVar, v8.f<? super z> fVar) {
            return ((d) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Exception {
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
                kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                if (!this.$retEvent.isEmpty()) {
                    r rVar = this.$retEvent.get(0);
                    kotlin.jvm.internal.m.e(rVar, "get(...)");
                    this.label = 1;
                    if (gVar.emit(rVar, this) == objC) {
                        return objC;
                    }
                } else {
                    if (!this.$retThrowable.isEmpty()) {
                        throw this.$retThrowable.get(0);
                    }
                    throw new Exception("unknown error");
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$checkAndStartPlayFlow$2$flow$1", f = "StreamHelper.kt", l = {SyslogAppender.LOG_LOCAL5}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
    static final class e extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ int $mediaMode;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ tf.d $playerZappingStat;
        final /* synthetic */ String $routeId;
        final /* synthetic */ long $session;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$checkAndStartPlayFlow$2$flow$1$1", f = "StreamHelper.kt", l = {169}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
        static final class C0433a extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
            final /* synthetic */ String $mediaId;
            final /* synthetic */ int $mediaMode;
            final /* synthetic */ v6.c $playType;
            final /* synthetic */ tf.d $playerZappingStat;
            final /* synthetic */ String $routeId;
            final /* synthetic */ long $session;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0433a(long j10, tf.d dVar, v6.c cVar, String str, String str2, int i10, v8.f<? super C0433a> fVar) {
                super(2, fVar);
                this.$session = j10;
                this.$playerZappingStat = dVar;
                this.$playType = cVar;
                this.$mediaId = str;
                this.$routeId = str2;
                this.$mediaMode = i10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new C0433a(this.$session, this.$playerZappingStat, this.$playType, this.$mediaId, this.$routeId, this.$mediaMode, fVar);
            }

            @Override // c9.p
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
                return b(bool.booleanValue(), fVar);
            }

            public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
                return ((C0433a) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        r8.r.b(obj);
                        return obj;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
                a aVar = a.f20960a;
                long j10 = this.$session;
                tf.d dVar = this.$playerZappingStat;
                v6.c cVar = this.$playType;
                String str = this.$mediaId;
                String str2 = this.$routeId;
                int i11 = this.$mediaMode;
                this.label = 1;
                Object objY = aVar.y(j10, dVar, cVar, str, str2, i11, this);
                if (objY == objC) {
                    return objC;
                }
                return objY;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(v6.c cVar, long j10, tf.d dVar, String str, String str2, int i10, v8.f<? super e> fVar) {
            super(2, fVar);
            this.$playType = cVar;
            this.$session = j10;
            this.$playerZappingStat = dVar;
            this.$mediaId = str;
            this.$routeId = str2;
            this.$mediaMode = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new e(this.$playType, this.$session, this.$playerZappingStat, this.$mediaId, this.$routeId, this.$mediaMode, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return b(bool.booleanValue(), fVar);
        }

        public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return ((e) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
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
                a.lastPlaySession = null;
                a aVar = a.f20960a;
                v6.c cVar = this.$playType;
                this.label = 1;
                obj = aVar.z(cVar, this);
                if (obj == objC) {
                    return objC;
                }
            }
            return kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new C0433a(this.$session, this.$playerZappingStat, this.$playType, this.$mediaId, this.$routeId, this.$mediaMode, null));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$checkAndStartPlayFlow$2$flow$2", f = "StreamHelper.kt", l = {174}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ int $mediaMode;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ tf.d $playerZappingStat;
        final /* synthetic */ String $routeId;
        final /* synthetic */ long $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(long j10, tf.d dVar, v6.c cVar, String str, String str2, int i10, v8.f<? super f> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$playerZappingStat = dVar;
            this.$playType = cVar;
            this.$mediaId = str;
            this.$routeId = str2;
            this.$mediaMode = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new f(this.$session, this.$playerZappingStat, this.$playType, this.$mediaId, this.$routeId, this.$mediaMode, fVar);
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return b(bool.booleanValue(), fVar);
        }

        public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return ((f) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            a aVar = a.f20960a;
            long j10 = this.$session;
            tf.d dVar = this.$playerZappingStat;
            v6.c cVar = this.$playType;
            String str = this.$mediaId;
            String str2 = this.$routeId;
            int i11 = this.$mediaMode;
            this.label = 1;
            Object objY = aVar.y(j10, dVar, cVar, str, str2, i11, this);
            if (objY == objC) {
                return objC;
            }
            return objY;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$clearPlaySession$1", f = "StreamHelper.kt", l = {373, 282}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ long $session;
        long J$0;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$g$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$clearPlaySession$1$1$2", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
        static final class C0434a extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super Boolean>, Throwable, v8.f<? super z>, Object> {
            int label;

            C0434a(v8.f<? super C0434a> fVar) {
                super(3, fVar);
            }

            @Override // c9.q
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, Throwable th, v8.f<? super z> fVar) {
                return new C0434a(fVar).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    return z.f17874a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f20979a = new b<>();

            public final Object b(boolean z10, v8.f<? super z> fVar) {
                return z.f17874a;
            }

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Boolean) obj).booleanValue(), fVar);
            }

            b() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(long j10, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$session = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new g(this.$session, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.sync.a aVar;
            long j10;
            kotlinx.coroutines.sync.a aVar2;
            Throwable th;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 == 2) {
                            aVar2 = (kotlinx.coroutines.sync.a) this.L$0;
                            try {
                                r8.r.b(obj);
                                z zVar = z.f17874a;
                                aVar2.b(null);
                                return z.f17874a;
                            } catch (Throwable th2) {
                                th = th2;
                                aVar2.b(null);
                                throw th;
                            }
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j10 = this.J$0;
                    kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) this.L$0;
                    r8.r.b(obj);
                    aVar = aVar3;
                } else {
                    r8.r.b(obj);
                    aVar = a.mutex;
                    j10 = this.$session;
                    this.L$0 = aVar;
                    this.J$0 = j10;
                    this.label = 1;
                    if (aVar.a(null, this) != objC) {
                    }
                    return objC;
                }
                Long l10 = a.lastPlaySession;
                if (l10 != null && l10.longValue() == j10) {
                    a.lastPlaySession = null;
                }
                r rVar = a.lastUrlReadyEvent;
                if (rVar != null && rVar.g() == j10) {
                    a.lastUrlReadyEvent = null;
                }
                kotlinx.coroutines.flow.f fVarF = kotlinx.coroutines.flow.h.f(x1.f1.lb.streaming.client.a.f21004a.v(j10, "clean session"), new C0434a(null));
                kotlinx.coroutines.flow.g gVar = b.f20979a;
                this.L$0 = aVar;
                this.label = 2;
                if (fVarF.collect(gVar, this) != objC) {
                    aVar2 = aVar;
                    z zVar2 = z.f17874a;
                    aVar2.b(null);
                    return z.f17874a;
                }
                return objC;
            } catch (Throwable th3) {
                aVar2 = aVar;
                th = th3;
                aVar2.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h implements kotlinx.coroutines.flow.f<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f20980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f20983d;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$h$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class C0435a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f20984a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f20985b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20986c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f20987d;

            /* JADX INFO: renamed from: x1.f1.lb.streaming.a$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$createPlayFlow$$inlined$map$1$2", f = "StreamHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0436a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0436a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0435a.this.emit(null, this);
                }
            }

            public C0435a(kotlinx.coroutines.flow.g gVar, String str, String str2, int i10) {
                this.f20984a = gVar;
                this.f20985b = str;
                this.f20986c = str2;
                this.f20987d = i10;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0436a c0436a;
                if (fVar instanceof C0436a) {
                    c0436a = (C0436a) fVar;
                    int i10 = c0436a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0436a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0436a = new C0436a(fVar);
                    }
                } else {
                    c0436a = new C0436a(fVar);
                }
                Object obj2 = c0436a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0436a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f20984a;
                    r8.p pVar = (r8.p) obj;
                    a aVar = a.f20960a;
                    a.lastPlaySession = (Long) pVar.d();
                    String str = this.f20985b;
                    String str2 = this.f20986c;
                    int i12 = this.f20987d;
                    v6.c cVar = v6.c.CATCHUP;
                    r rVar = new r(str, str2, i12, cVar, (String) pVar.c(), ((Number) pVar.d()).longValue());
                    a.lastMetaId = this.f20985b;
                    a.lastMediaMode = kotlin.coroutines.jvm.internal.b.b(this.f20987d);
                    a.lastRouteId = this.f20986c;
                    a.lastUrlReadyEvent = rVar;
                    a.lastPlayType = cVar;
                    c0436a.label = 1;
                    if (gVar.emit(rVar, c0436a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj2);
                }
                return z.f17874a;
            }
        }

        public h(kotlinx.coroutines.flow.f fVar, String str, String str2, int i10) {
            this.f20980a = fVar;
            this.f20981b = str;
            this.f20982c = str2;
            this.f20983d = i10;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super r> gVar, v8.f fVar) {
            Object objCollect = this.f20980a.collect(new C0435a(gVar, this.f20981b, this.f20982c, this.f20983d), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i implements kotlinx.coroutines.flow.f<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f20988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ tf.d f20989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f20991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f20992e;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$i$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class C0437a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f20993a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ tf.d f20994b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20995c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f20996d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f20997e;

            /* JADX INFO: renamed from: x1.f1.lb.streaming.a$i$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$createPlayFlow$$inlined$map$2$2", f = "StreamHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0438a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0438a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0437a.this.emit(null, this);
                }
            }

            public C0437a(kotlinx.coroutines.flow.g gVar, tf.d dVar, String str, String str2, int i10) {
                this.f20993a = gVar;
                this.f20994b = dVar;
                this.f20995c = str;
                this.f20996d = str2;
                this.f20997e = i10;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0438a c0438a;
                if (fVar instanceof C0438a) {
                    c0438a = (C0438a) fVar;
                    int i10 = c0438a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0438a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0438a = new C0438a(fVar);
                    }
                } else {
                    c0438a = new C0438a(fVar);
                }
                Object obj2 = c0438a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0438a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f20993a;
                    r8.p pVar = (r8.p) obj;
                    a aVar = a.f20960a;
                    a.lastPlaySession = (Long) pVar.d();
                    this.f20994b.X(d1.c());
                    x1.f1.lb.media.c.f20788a.P();
                    r rVar = new r(this.f20995c, this.f20996d, this.f20997e, a.lastPlayType, (String) pVar.c(), ((Number) pVar.d()).longValue());
                    a.lastMetaId = this.f20995c;
                    a.lastMediaMode = kotlin.coroutines.jvm.internal.b.b(this.f20997e);
                    a.lastRouteId = this.f20996d;
                    a.lastUrlReadyEvent = rVar;
                    c0438a.label = 1;
                    if (gVar.emit(rVar, c0438a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj2);
                }
                return z.f17874a;
            }
        }

        public i(kotlinx.coroutines.flow.f fVar, tf.d dVar, String str, String str2, int i10) {
            this.f20988a = fVar;
            this.f20989b = dVar;
            this.f20990c = str;
            this.f20991d = str2;
            this.f20992e = i10;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super r> gVar, v8.f fVar) {
            Object objCollect = this.f20988a.collect(new C0437a(gVar, this.f20989b, this.f20990c, this.f20991d, this.f20992e), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$createPlayFlow$4", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/p;", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>>, Throwable, v8.f<? super z>, Object> {
        final /* synthetic */ String $catchupStreamId;
        final /* synthetic */ long $session;
        final /* synthetic */ String $streamId;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j10, String str, String str2, v8.f<? super j> fVar) {
            super(3, fVar);
            this.$session = j10;
            this.$streamId = str;
            this.$catchupStreamId = str2;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super r8.p<String, Long>> gVar, Throwable th, v8.f<? super z> fVar) {
            j jVar = new j(this.$session, this.$streamId, this.$catchupStreamId, fVar);
            jVar.L$0 = th;
            return jVar.invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r8.r.b(obj);
            Throwable th = (Throwable) this.L$0;
            a.logger.error("start play failure[" + this.$session + "][" + v6.c.CATCHUP + "][" + this.$streamId + "][" + this.$catchupStreamId + "]", th);
            throw th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$createPlayFlow$6", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/p;", "", "", "", "it", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;Ljava/lang/Throwable;)V"}, k = 3, mv = {2, 1, 0})
    static final class k extends kotlin.coroutines.jvm.internal.l implements q<kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>>, Throwable, v8.f<? super z>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ tf.d $playerZappingStat;
        final /* synthetic */ long $session;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(tf.d dVar, long j10, v6.c cVar, String str, v8.f<? super k> fVar) {
            super(3, fVar);
            this.$playerZappingStat = dVar;
            this.$session = j10;
            this.$playType = cVar;
            this.$mediaId = str;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(kotlinx.coroutines.flow.g<? super r8.p<String, Long>> gVar, Throwable th, v8.f<? super z> fVar) {
            k kVar = new k(this.$playerZappingStat, this.$session, this.$playType, this.$mediaId, fVar);
            kVar.L$0 = th;
            return kVar.invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                Throwable th = (Throwable) this.L$0;
                String message = th.getMessage();
                if (ac.g.f(message)) {
                    message = th.getClass().getSimpleName();
                }
                this.$playerZappingStat.G(1);
                this.$playerZappingStat.F(-1);
                this.$playerZappingStat.E(message);
                a.logger.error("start play failure[" + this.$session + "][" + this.$playType + "][" + this.$mediaId + "]", th);
                throw th;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper", f = "StreamHelper.kt", l = {256, 259}, m = "prepareFlow")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class l extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        l(v8.f<? super l> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.y(0L, null, null, null, null, 0, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$prepareFlow$2", f = "StreamHelper.kt", l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 247}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
    static final class m extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ int $mediaMode;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ String $routeId;
        final /* synthetic */ long $session;
        final /* synthetic */ tf.d $zappingStat;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$m$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$prepareFlow$2$1", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
        static final class C0439a extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
            final /* synthetic */ String $mediaId;
            final /* synthetic */ int $mediaMode;
            final /* synthetic */ v6.c $playType;
            final /* synthetic */ String $routeId;
            final /* synthetic */ long $session;
            final /* synthetic */ tf.d $zappingStat;
            /* synthetic */ boolean Z$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0439a(long j10, String str, String str2, int i10, v6.c cVar, tf.d dVar, v8.f<? super C0439a> fVar) {
                super(2, fVar);
                this.$session = j10;
                this.$mediaId = str;
                this.$routeId = str2;
                this.$mediaMode = i10;
                this.$playType = cVar;
                this.$zappingStat = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                C0439a c0439a = new C0439a(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat, fVar);
                c0439a.Z$0 = ((Boolean) obj).booleanValue();
                return c0439a;
            }

            @Override // c9.p
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
                return b(bool.booleanValue(), fVar);
            }

            public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
                return ((C0439a) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) throws Exception {
                kotlin.coroutines.intrinsics.b.c();
                if (this.label == 0) {
                    r8.r.b(obj);
                    if (this.Z$0) {
                        return a.f20960a.u(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat);
                    }
                    throw new Exception("restart engine failure");
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(v6.c cVar, long j10, String str, String str2, int i10, tf.d dVar, v8.f<? super m> fVar) {
            super(2, fVar);
            this.$playType = cVar;
            this.$session = j10;
            this.$mediaId = str;
            this.$routeId = str2;
            this.$mediaMode = i10;
            this.$zappingStat = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            m mVar = new m(this.$playType, this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$zappingStat, fVar);
            mVar.Z$0 = ((Boolean) obj).booleanValue();
            return mVar;
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return b(bool.booleanValue(), fVar);
        }

        public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return ((m) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        
            if (r12 == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        
            if (r12 == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        r8.r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r8.r.b(obj);
                }
                return kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new C0439a(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat, null));
            }
            r8.r.b(obj);
            boolean z10 = this.Z$0;
            a.lastPlaySession = null;
            if (z10) {
                x1.f1.lb.streaming.client.a aVar = x1.f1.lb.streaming.client.a.f21004a;
                v6.c cVar = this.$playType;
                this.label = 1;
                obj = aVar.n(cVar, this);
            } else {
                a aVar2 = a.f20960a;
                v6.c cVar2 = this.$playType;
                this.label = 2;
                obj = aVar2.z(cVar2, this);
            }
            return objC;
            if (((Boolean) obj).booleanValue()) {
                return a.f20960a.u(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat);
            }
            a aVar3 = a.f20960a;
            v6.c cVar3 = this.$playType;
            this.label = 2;
            obj = aVar3.z(cVar3, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$prepareFlow$3", f = "StreamHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "it", "Lkotlinx/coroutines/flow/f;", "Lnf/r;", "<anonymous>", "(Z)Lkotlinx/coroutines/flow/f;"}, k = 3, mv = {2, 1, 0})
    static final class n extends kotlin.coroutines.jvm.internal.l implements c9.p<Boolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ int $mediaMode;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ String $routeId;
        final /* synthetic */ long $session;
        final /* synthetic */ tf.d $zappingStat;
        /* synthetic */ boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(long j10, String str, String str2, int i10, v6.c cVar, tf.d dVar, v8.f<? super n> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$mediaId = str;
            this.$routeId = str2;
            this.$mediaMode = i10;
            this.$playType = cVar;
            this.$zappingStat = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            n nVar = new n(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat, fVar);
            nVar.Z$0 = ((Boolean) obj).booleanValue();
            return nVar;
        }

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(Boolean bool, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return b(bool.booleanValue(), fVar);
        }

        public final Object b(boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
            return ((n) create(Boolean.valueOf(z10), fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Exception {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r8.r.b(obj);
                if (this.Z$0) {
                    return a.f20960a.u(this.$session, this.$mediaId, this.$routeId, this.$mediaMode, this.$playType, this.$zappingStat);
                }
                throw new Exception("restart engine failure");
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o implements kotlinx.coroutines.flow.f<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f20998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ v6.c f20999b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ v6.c f21000c;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.a$o$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class C0440a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f21001a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ v6.c f21002b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ v6.c f21003c;

            /* JADX INFO: renamed from: x1.f1.lb.streaming.a$o$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper$restartEngine$$inlined$map$1$2", f = "StreamHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0441a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0441a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0440a.this.emit(null, this);
                }
            }

            public C0440a(kotlinx.coroutines.flow.g gVar, v6.c cVar, v6.c cVar2) {
                this.f21001a = gVar;
                this.f21002b = cVar;
                this.f21003c = cVar2;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0441a c0441a;
                if (fVar instanceof C0441a) {
                    c0441a = (C0441a) fVar;
                    int i10 = c0441a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0441a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0441a = new C0441a(fVar);
                    }
                } else {
                    c0441a = new C0441a(fVar);
                }
                Object obj2 = c0441a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0441a.label;
                if (i11 == 0) {
                    r8.r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f21001a;
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    if (zBooleanValue) {
                        a.engineRestartCnt = 0;
                        a.lastUid = x1.f1.lb.user.f.f21202a.B0();
                        if (this.f21002b != null) {
                            a.lastPlayType = this.f21003c;
                        }
                    }
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(zBooleanValue);
                    c0441a.label = 1;
                    if (gVar.emit(boolA, c0441a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj2);
                }
                return z.f17874a;
            }
        }

        public o(kotlinx.coroutines.flow.f fVar, v6.c cVar, v6.c cVar2) {
            this.f20998a = fVar;
            this.f20999b = cVar;
            this.f21000c = cVar2;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f fVar) {
            Object objCollect = this.f20998a.collect(new C0440a(gVar, this.f20999b, this.f21000c), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.StreamHelper", f = "StreamHelper.kt", l = {291}, m = "restartEngine")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class p extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        p(v8.f<? super p> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.z(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object y(long j10, tf.d dVar, v6.c cVar, String str, String str2, int i10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
        l lVar;
        int i11;
        tf.d dVar2;
        long j11;
        String str3;
        v6.c cVar2;
        String str4;
        a aVar;
        String str5;
        v6.c cVar3;
        tf.d dVar3;
        String str6;
        int i12;
        long j12;
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
        Object obj = lVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i14 = lVar.label;
        if (i14 != 0) {
            if (i14 == 1) {
                int i15 = lVar.I$0;
                j11 = lVar.J$0;
                str3 = (String) lVar.L$4;
                str4 = (String) lVar.L$3;
                cVar2 = (v6.c) lVar.L$2;
                dVar2 = (tf.d) lVar.L$1;
                a aVar2 = (a) lVar.L$0;
                r8.r.b(obj);
                i11 = i15;
                aVar = aVar2;
            } else {
                if (i14 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i16 = lVar.I$0;
                long j13 = lVar.J$0;
                str5 = (String) lVar.L$3;
                String str7 = (String) lVar.L$2;
                cVar3 = (v6.c) lVar.L$1;
                tf.d dVar4 = (tf.d) lVar.L$0;
                r8.r.b(obj);
                i12 = i16;
                j12 = j13;
                str6 = str7;
                dVar3 = dVar4;
            }
            return kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new n(j12, str6, str5, i12, cVar3, dVar3, null));
        }
        r8.r.b(obj);
        Long l10 = lastPlaySession;
        if (l10 != null) {
            return kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "prepare " + j10), new m(cVar, j10, str, str2, i10, dVar, null));
        }
        x1.f1.lb.streaming.client.a aVar3 = x1.f1.lb.streaming.client.a.f21004a;
        lVar.L$0 = this;
        lVar.L$1 = dVar;
        lVar.L$2 = cVar;
        lVar.L$3 = str;
        lVar.L$4 = str2;
        lVar.J$0 = j10;
        i11 = i10;
        lVar.I$0 = i11;
        lVar.label = 1;
        Object objN = aVar3.n(cVar, lVar);
        if (objN != objC) {
            dVar2 = dVar;
            j11 = j10;
            str3 = str2;
            cVar2 = cVar;
            obj = objN;
            str4 = str;
            aVar = this;
        }
        return objC;
        if (((Boolean) obj).booleanValue()) {
            return aVar.u(j11, str4, str3, i11, cVar2, dVar2);
        }
        int i17 = i11;
        String str8 = str4;
        str5 = str3;
        long j14 = j11;
        cVar3 = cVar2;
        dVar3 = dVar2;
        lVar.L$0 = dVar3;
        lVar.L$1 = cVar3;
        lVar.L$2 = str8;
        lVar.L$3 = str5;
        lVar.L$4 = null;
        lVar.J$0 = j14;
        lVar.I$0 = i17;
        lVar.label = 2;
        Object objZ = aVar.z(cVar3, lVar);
        if (objZ != objC) {
            str6 = str8;
            obj = objZ;
            i12 = i17;
            j12 = j14;
            return kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new n(j12, str6, str5, i12, cVar3, dVar3, null));
        }
        return objC;
    }

    public static /* synthetic */ Object A(a aVar, v6.c cVar, v8.f fVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            cVar = null;
        }
        return aVar.z(cVar, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:65:0x0194 A[Catch: all -> 0x01d2, TRY_LEAVE, TryCatch #1 {all -> 0x01d2, blocks: (B:63:0x018c, B:65:0x0194, B:43:0x0139, B:45:0x013d, B:47:0x0145, B:49:0x0149, B:51:0x0151, B:54:0x0157, B:56:0x015d, B:59:0x0167), top: B:103:0x0139 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:75:0x0245 A[Catch: all -> 0x027f, TryCatch #5 {all -> 0x027f, blocks: (B:91:0x031c, B:92:0x032e, B:81:0x0275, B:73:0x01f2, B:75:0x0245, B:77:0x0249, B:84:0x0283, B:86:0x02bd, B:87:0x02e9), top: B:111:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x0283 A[Catch: all -> 0x027f, TryCatch #5 {all -> 0x027f, blocks: (B:91:0x031c, B:92:0x032e, B:81:0x0275, B:73:0x01f2, B:75:0x0245, B:77:0x0249, B:84:0x0283, B:86:0x02bd, B:87:0x02e9), top: B:111:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x02bd A[Catch: all -> 0x027f, TryCatch #5 {all -> 0x027f, blocks: (B:91:0x031c, B:92:0x032e, B:81:0x0275, B:73:0x01f2, B:75:0x0245, B:77:0x0249, B:84:0x0283, B:86:0x02bd, B:87:0x02e9), top: B:111:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x02e9 A[Catch: all -> 0x027f, TryCatch #5 {all -> 0x027f, blocks: (B:91:0x031c, B:92:0x032e, B:81:0x0275, B:73:0x01f2, B:75:0x0245, B:77:0x0249, B:84:0x0283, B:86:0x02bd, B:87:0x02e9), top: B:111:0x01f2 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0310  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Code duplicated, block: B:90:0x0311  */
    /* JADX WARN: Code duplicated, block: B:95:0x0366  */
    /* JADX WARN: Instruction removed from duplicated block: B:65:0x0194, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:84:0x0283, please report this as an issue */
    public final Object q(v6.c cVar, String str, String str2, String str3, int i10, boolean z10, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) throws Throwable {
        C0432a c0432a;
        String strB0;
        String str4;
        String str5;
        String str6;
        int i11;
        kotlinx.coroutines.sync.a aVar;
        boolean z11;
        v6.c cVar2;
        kotlinx.coroutines.sync.a aVar2;
        String str7;
        String str8;
        String str9;
        int i12;
        v6.c cVar3;
        String str10;
        Integer num;
        int i13;
        String str11;
        String str12;
        r rVar;
        v6.c cVar4;
        String str13;
        boolean z12;
        int iIncrementAndGet;
        long jC;
        String str14;
        String str15;
        tf.d dVarA;
        v6.c cVar5;
        String str16;
        Long l10;
        int i14;
        Object objZ;
        long j10;
        tf.d dVar;
        v6.c cVar6;
        String str17;
        String str18;
        int i15;
        String str19;
        String str20;
        boolean z13;
        boolean z14;
        kotlinx.coroutines.flow.f fVarT;
        String str21;
        String str22;
        int i16;
        String str23;
        boolean z15;
        String str24;
        String str25;
        int i17;
        String str26;
        kotlinx.coroutines.sync.a aVar3;
        ArrayList arrayList;
        ArrayList arrayList2;
        kotlinx.coroutines.flow.f fVarF;
        c cVar7;
        ArrayList arrayList3;
        ArrayList arrayList4;
        if (fVar instanceof C0432a) {
            c0432a = (C0432a) fVar;
            int i18 = c0432a.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                c0432a.label = i18 - Integer.MIN_VALUE;
            } else {
                c0432a = new C0432a(fVar);
            }
        } else {
            c0432a = new C0432a(fVar);
        }
        C0432a c0432a2 = c0432a;
        Object obj = c0432a2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i19 = c0432a2.label;
        try {
            if (i19 == 0) {
                r8.r.b(obj);
                strB0 = x1.f1.lb.user.f.f21202a.B0();
                kotlinx.coroutines.sync.a aVar4 = mutex;
                c0432a2.L$0 = cVar;
                str4 = str;
                c0432a2.L$1 = str4;
                str5 = str2;
                c0432a2.L$2 = str5;
                str6 = str3;
                c0432a2.L$3 = str6;
                c0432a2.L$4 = strB0;
                c0432a2.L$5 = aVar4;
                i11 = i10;
                c0432a2.I$0 = i11;
                c0432a2.Z$0 = z10;
                c0432a2.label = 1;
                if (aVar4.a(null, c0432a2) != objC) {
                    aVar = aVar4;
                    z11 = z10;
                    cVar2 = cVar;
                }
                return objC;
            }
            if (i19 != 1) {
                if (i19 == 2) {
                    z11 = c0432a2.Z$0;
                    i13 = c0432a2.I$0;
                    r rVar2 = (r) c0432a2.L$6;
                    kotlinx.coroutines.sync.a aVar5 = (kotlinx.coroutines.sync.a) c0432a2.L$5;
                    str12 = (String) c0432a2.L$4;
                    str6 = (String) c0432a2.L$3;
                    str11 = (String) c0432a2.L$2;
                    str13 = (String) c0432a2.L$1;
                    cVar4 = (v6.c) c0432a2.L$0;
                    try {
                        r8.r.b(obj);
                        rVar = rVar2;
                        aVar = aVar5;
                        if (((Boolean) obj).booleanValue()) {
                            logger.a("create_session[" + rVar.g() + "] " + z11 + ", " + str13 + ", " + str11 + ", in lock", new Object[0]);
                            kotlinx.coroutines.flow.f fVarW = kotlinx.coroutines.flow.h.w(rVar);
                            aVar.b(null);
                            return fVarW;
                        }
                        cVar3 = cVar4;
                        i12 = i13;
                        str9 = str6;
                        str8 = str13;
                        str10 = str12;
                        aVar2 = aVar;
                        str7 = str11;
                        z12 = z11;
                        try {
                            iIncrementAndGet = count.incrementAndGet();
                            lastUrlReadyEvent = null;
                            lastMetaId = null;
                            lastMediaMode = null;
                            lastRouteId = null;
                            jC = d1.c();
                            str14 = str7;
                            str15 = str9;
                            dVarA = x1.f1.lb.metric.monitor.h.f20952a.a(cVar3, str8, str14, str15, jC, i12);
                            cVar5 = cVar3;
                            str16 = str8;
                            dVarA.setStart(d1.c());
                            a1.h(a1.f21305a, jC, str14 + ".create_session", false, 4, null);
                            if (kotlin.jvm.internal.m.a(lastUid, str10) || cVar5 != lastPlayType) {
                                logger.a("will restart engine to change from [" + lastUid + ", " + lastPlayType + "] to [" + str10 + ", " + cVar5 + "]", new Object[0]);
                                l10 = lastPlaySession;
                                if (l10 != null) {
                                    lastPlaySession = null;
                                    z14 = z12;
                                    fVarT = kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "check and start"), new e(cVar5, jC, dVarA, str14, str15, i12, null));
                                    str21 = str14;
                                    str22 = str10;
                                    i16 = iIncrementAndGet;
                                    str23 = str16;
                                    arrayList = new ArrayList();
                                    arrayList2 = new ArrayList();
                                    int iDecrementAndGet = count.decrementAndGet();
                                    fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                                    cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet, str22, arrayList2);
                                    c0432a2.L$0 = aVar2;
                                    c0432a2.L$1 = arrayList;
                                    c0432a2.L$2 = arrayList2;
                                    c0432a2.L$3 = null;
                                    c0432a2.L$4 = null;
                                    c0432a2.L$5 = null;
                                    c0432a2.L$6 = null;
                                    c0432a2.label = 5;
                                    if (fVarF.collect(cVar7, c0432a2) != objC) {
                                        arrayList3 = arrayList2;
                                        arrayList4 = arrayList;
                                        aVar3 = aVar2;
                                        kotlinx.coroutines.flow.f fVarV = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                        aVar3.b(null);
                                        return fVarV;
                                    }
                                } else {
                                    i14 = i12;
                                    a aVar6 = f20960a;
                                    c0432a2.L$0 = cVar5;
                                    c0432a2.L$1 = str16;
                                    c0432a2.L$2 = str14;
                                    c0432a2.L$3 = str15;
                                    c0432a2.L$4 = str10;
                                    c0432a2.L$5 = aVar2;
                                    c0432a2.L$6 = dVarA;
                                    c0432a2.I$0 = i14;
                                    c0432a2.Z$0 = z12;
                                    c0432a2.I$1 = iIncrementAndGet;
                                    c0432a2.J$0 = jC;
                                    c0432a2.label = 4;
                                    objZ = aVar6.z(cVar5, c0432a2);
                                    if (objZ != objC) {
                                        j10 = jC;
                                        dVar = dVarA;
                                        cVar6 = cVar5;
                                        str17 = str14;
                                        str18 = str15;
                                        i15 = i14;
                                        str19 = str16;
                                        str20 = str10;
                                        z13 = z12;
                                        obj = objZ;
                                        fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                                        str21 = str17;
                                        z14 = z13;
                                        i16 = iIncrementAndGet;
                                        str22 = str20;
                                        str23 = str19;
                                        arrayList = new ArrayList();
                                        arrayList2 = new ArrayList();
                                        int iDecrementAndGet2 = count.decrementAndGet();
                                        fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                                        cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet2, str22, arrayList2);
                                        c0432a2.L$0 = aVar2;
                                        c0432a2.L$1 = arrayList;
                                        c0432a2.L$2 = arrayList2;
                                        c0432a2.L$3 = null;
                                        c0432a2.L$4 = null;
                                        c0432a2.L$5 = null;
                                        c0432a2.L$6 = null;
                                        c0432a2.label = 5;
                                        if (fVarF.collect(cVar7, c0432a2) != objC) {
                                            arrayList3 = arrayList2;
                                            arrayList4 = arrayList;
                                            aVar3 = aVar2;
                                            kotlinx.coroutines.flow.f fVarV2 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                            aVar3.b(null);
                                            return fVarV2;
                                        }
                                    }
                                }
                            } else {
                                a aVar7 = f20960a;
                                c0432a2.L$0 = str16;
                                c0432a2.L$1 = str14;
                                c0432a2.L$2 = str10;
                                c0432a2.L$3 = aVar2;
                                c0432a2.L$4 = null;
                                c0432a2.L$5 = null;
                                c0432a2.L$6 = null;
                                c0432a2.Z$0 = z12;
                                c0432a2.I$0 = iIncrementAndGet;
                                c0432a2.label = 3;
                                Object objY = aVar7.y(jC, dVarA, cVar5, str14, str15, i12, c0432a2);
                                if (objY != objC) {
                                    z15 = z12;
                                    obj = objY;
                                    str24 = str14;
                                    str25 = str10;
                                    i17 = iIncrementAndGet;
                                    str26 = str16;
                                    fVarT = (kotlinx.coroutines.flow.f) obj;
                                    String str27 = str25;
                                    i16 = i17;
                                    z14 = z15;
                                    str23 = str26;
                                    str22 = str27;
                                    str21 = str24;
                                    arrayList = new ArrayList();
                                    arrayList2 = new ArrayList();
                                    int iDecrementAndGet3 = count.decrementAndGet();
                                    fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                                    cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet3, str22, arrayList2);
                                    c0432a2.L$0 = aVar2;
                                    c0432a2.L$1 = arrayList;
                                    c0432a2.L$2 = arrayList2;
                                    c0432a2.L$3 = null;
                                    c0432a2.L$4 = null;
                                    c0432a2.L$5 = null;
                                    c0432a2.L$6 = null;
                                    c0432a2.label = 5;
                                    if (fVarF.collect(cVar7, c0432a2) != objC) {
                                        arrayList3 = arrayList2;
                                        arrayList4 = arrayList;
                                        aVar3 = aVar2;
                                        kotlinx.coroutines.flow.f fVarV3 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                        aVar3.b(null);
                                        return fVarV3;
                                    }
                                }
                            }
                            return objC;
                        } catch (Throwable th) {
                            th = th;
                            aVar3 = aVar2;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        aVar3 = aVar5;
                    }
                } else if (i19 == 3) {
                    i17 = c0432a2.I$0;
                    z15 = c0432a2.Z$0;
                    kotlinx.coroutines.sync.a aVar8 = (kotlinx.coroutines.sync.a) c0432a2.L$3;
                    str25 = (String) c0432a2.L$2;
                    str24 = (String) c0432a2.L$1;
                    str26 = (String) c0432a2.L$0;
                    try {
                        r8.r.b(obj);
                        aVar2 = aVar8;
                        fVarT = (kotlinx.coroutines.flow.f) obj;
                        String str28 = str25;
                        i16 = i17;
                        z14 = z15;
                        str23 = str26;
                        str22 = str28;
                        str21 = str24;
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        int iDecrementAndGet4 = count.decrementAndGet();
                        fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                        cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet4, str22, arrayList2);
                        c0432a2.L$0 = aVar2;
                        c0432a2.L$1 = arrayList;
                        c0432a2.L$2 = arrayList2;
                        c0432a2.L$3 = null;
                        c0432a2.L$4 = null;
                        c0432a2.L$5 = null;
                        c0432a2.L$6 = null;
                        c0432a2.label = 5;
                        if (fVarF.collect(cVar7, c0432a2) != objC) {
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            aVar3 = aVar2;
                            kotlinx.coroutines.flow.f fVarV4 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                            aVar3.b(null);
                            return fVarV4;
                        }
                        return objC;
                    } catch (Throwable th3) {
                        th = th3;
                        aVar3 = aVar8;
                    }
                } else if (i19 == 4) {
                    j10 = c0432a2.J$0;
                    int i20 = c0432a2.I$1;
                    boolean z16 = c0432a2.Z$0;
                    int i21 = c0432a2.I$0;
                    tf.d dVar2 = (tf.d) c0432a2.L$6;
                    kotlinx.coroutines.sync.a aVar9 = (kotlinx.coroutines.sync.a) c0432a2.L$5;
                    String str29 = (String) c0432a2.L$4;
                    String str30 = (String) c0432a2.L$3;
                    String str31 = (String) c0432a2.L$2;
                    String str32 = (String) c0432a2.L$1;
                    v6.c cVar8 = (v6.c) c0432a2.L$0;
                    try {
                        r8.r.b(obj);
                        iIncrementAndGet = i20;
                        dVar = dVar2;
                        str18 = str30;
                        z13 = z16;
                        cVar6 = cVar8;
                        str19 = str32;
                        aVar2 = aVar9;
                        i15 = i21;
                        str17 = str31;
                        str20 = str29;
                        fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                        str21 = str17;
                        z14 = z13;
                        i16 = iIncrementAndGet;
                        str22 = str20;
                        str23 = str19;
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        int iDecrementAndGet5 = count.decrementAndGet();
                        fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                        cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet5, str22, arrayList2);
                        c0432a2.L$0 = aVar2;
                        c0432a2.L$1 = arrayList;
                        c0432a2.L$2 = arrayList2;
                        c0432a2.L$3 = null;
                        c0432a2.L$4 = null;
                        c0432a2.L$5 = null;
                        c0432a2.L$6 = null;
                        c0432a2.label = 5;
                        if (fVarF.collect(cVar7, c0432a2) != objC) {
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            aVar3 = aVar2;
                            kotlinx.coroutines.flow.f fVarV5 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                            aVar3.b(null);
                            return fVarV5;
                        }
                        return objC;
                    } catch (Throwable th4) {
                        th = th4;
                        aVar3 = aVar9;
                    }
                } else {
                    if (i19 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    arrayList3 = (ArrayList) c0432a2.L$2;
                    arrayList4 = (ArrayList) c0432a2.L$1;
                    aVar3 = (kotlinx.coroutines.sync.a) c0432a2.L$0;
                    try {
                        r8.r.b(obj);
                        kotlinx.coroutines.flow.f fVarV6 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                        aVar3.b(null);
                        return fVarV6;
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                aVar3.b(null);
                throw th;
            }
            z11 = c0432a2.Z$0;
            int i22 = c0432a2.I$0;
            aVar = (kotlinx.coroutines.sync.a) c0432a2.L$5;
            String str33 = (String) c0432a2.L$4;
            String str34 = (String) c0432a2.L$3;
            String str35 = (String) c0432a2.L$2;
            String str36 = (String) c0432a2.L$1;
            cVar2 = (v6.c) c0432a2.L$0;
            r8.r.b(obj);
            str6 = str34;
            str5 = str35;
            strB0 = str33;
            str4 = str36;
            i11 = i22;
            r rVar3 = lastUrlReadyEvent;
            if (!z11 && kotlin.jvm.internal.m.a(lastUid, strB0) && cVar2 == lastPlayType && kotlin.jvm.internal.m.a(str5, lastMetaId) && (num = lastMediaMode) != null && i11 == num.intValue() && kotlin.jvm.internal.m.a(str6, lastRouteId) && rVar3 != null) {
                x1.f1.lb.streaming.client.a aVar10 = x1.f1.lb.streaming.client.a.f21004a;
                c0432a2.L$0 = cVar2;
                c0432a2.L$1 = str4;
                c0432a2.L$2 = str5;
                c0432a2.L$3 = str6;
                c0432a2.L$4 = strB0;
                c0432a2.L$5 = aVar;
                c0432a2.L$6 = rVar3;
                c0432a2.I$0 = i11;
                c0432a2.Z$0 = z11;
                c0432a2.label = 2;
                Object objN = aVar10.n(cVar2, c0432a2);
                if (objN != objC) {
                    i13 = i11;
                    str11 = str5;
                    str12 = strB0;
                    obj = objN;
                    rVar = rVar3;
                    cVar4 = cVar2;
                    str13 = str4;
                    if (((Boolean) obj).booleanValue()) {
                        logger.a("create_session[" + rVar.g() + "] " + z11 + ", " + str13 + ", " + str11 + ", in lock", new Object[0]);
                        kotlinx.coroutines.flow.f fVarW2 = kotlinx.coroutines.flow.h.w(rVar);
                        aVar.b(null);
                        return fVarW2;
                    }
                    cVar3 = cVar4;
                    i12 = i13;
                    str9 = str6;
                    str8 = str13;
                    str10 = str12;
                    aVar2 = aVar;
                    str7 = str11;
                    z12 = z11;
                    iIncrementAndGet = count.incrementAndGet();
                    lastUrlReadyEvent = null;
                    lastMetaId = null;
                    lastMediaMode = null;
                    lastRouteId = null;
                    jC = d1.c();
                    str14 = str7;
                    str15 = str9;
                    dVarA = x1.f1.lb.metric.monitor.h.f20952a.a(cVar3, str8, str14, str15, jC, i12);
                    cVar5 = cVar3;
                    str16 = str8;
                    dVarA.setStart(d1.c());
                    a1.h(a1.f21305a, jC, str14 + ".create_session", false, 4, null);
                    if (kotlin.jvm.internal.m.a(lastUid, str10)) {
                        logger.a("will restart engine to change from [" + lastUid + ", " + lastPlayType + "] to [" + str10 + ", " + cVar5 + "]", new Object[0]);
                        l10 = lastPlaySession;
                        if (l10 != null) {
                            lastPlaySession = null;
                            z14 = z12;
                            fVarT = kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "check and start"), new e(cVar5, jC, dVarA, str14, str15, i12, null));
                            str21 = str14;
                            str22 = str10;
                            i16 = iIncrementAndGet;
                            str23 = str16;
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            int iDecrementAndGet6 = count.decrementAndGet();
                            fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                            cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet6, str22, arrayList2);
                            c0432a2.L$0 = aVar2;
                            c0432a2.L$1 = arrayList;
                            c0432a2.L$2 = arrayList2;
                            c0432a2.L$3 = null;
                            c0432a2.L$4 = null;
                            c0432a2.L$5 = null;
                            c0432a2.L$6 = null;
                            c0432a2.label = 5;
                            if (fVarF.collect(cVar7, c0432a2) != objC) {
                                arrayList3 = arrayList2;
                                arrayList4 = arrayList;
                                aVar3 = aVar2;
                                kotlinx.coroutines.flow.f fVarV7 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                aVar3.b(null);
                                return fVarV7;
                            }
                        } else {
                            i14 = i12;
                            a aVar11 = f20960a;
                            c0432a2.L$0 = cVar5;
                            c0432a2.L$1 = str16;
                            c0432a2.L$2 = str14;
                            c0432a2.L$3 = str15;
                            c0432a2.L$4 = str10;
                            c0432a2.L$5 = aVar2;
                            c0432a2.L$6 = dVarA;
                            c0432a2.I$0 = i14;
                            c0432a2.Z$0 = z12;
                            c0432a2.I$1 = iIncrementAndGet;
                            c0432a2.J$0 = jC;
                            c0432a2.label = 4;
                            objZ = aVar11.z(cVar5, c0432a2);
                            if (objZ != objC) {
                                j10 = jC;
                                dVar = dVarA;
                                cVar6 = cVar5;
                                str17 = str14;
                                str18 = str15;
                                i15 = i14;
                                str19 = str16;
                                str20 = str10;
                                z13 = z12;
                                obj = objZ;
                                fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                                str21 = str17;
                                z14 = z13;
                                i16 = iIncrementAndGet;
                                str22 = str20;
                                str23 = str19;
                                arrayList = new ArrayList();
                                arrayList2 = new ArrayList();
                                int iDecrementAndGet7 = count.decrementAndGet();
                                fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                                cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet7, str22, arrayList2);
                                c0432a2.L$0 = aVar2;
                                c0432a2.L$1 = arrayList;
                                c0432a2.L$2 = arrayList2;
                                c0432a2.L$3 = null;
                                c0432a2.L$4 = null;
                                c0432a2.L$5 = null;
                                c0432a2.L$6 = null;
                                c0432a2.label = 5;
                                if (fVarF.collect(cVar7, c0432a2) != objC) {
                                    arrayList3 = arrayList2;
                                    arrayList4 = arrayList;
                                    aVar3 = aVar2;
                                    kotlinx.coroutines.flow.f fVarV8 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                    aVar3.b(null);
                                    return fVarV8;
                                }
                            }
                        }
                    } else {
                        logger.a("will restart engine to change from [" + lastUid + ", " + lastPlayType + "] to [" + str10 + ", " + cVar5 + "]", new Object[0]);
                        l10 = lastPlaySession;
                        if (l10 != null) {
                            lastPlaySession = null;
                            z14 = z12;
                            fVarT = kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "check and start"), new e(cVar5, jC, dVarA, str14, str15, i12, null));
                            str21 = str14;
                            str22 = str10;
                            i16 = iIncrementAndGet;
                            str23 = str16;
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            int iDecrementAndGet8 = count.decrementAndGet();
                            fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                            cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet8, str22, arrayList2);
                            c0432a2.L$0 = aVar2;
                            c0432a2.L$1 = arrayList;
                            c0432a2.L$2 = arrayList2;
                            c0432a2.L$3 = null;
                            c0432a2.L$4 = null;
                            c0432a2.L$5 = null;
                            c0432a2.L$6 = null;
                            c0432a2.label = 5;
                            if (fVarF.collect(cVar7, c0432a2) != objC) {
                                arrayList3 = arrayList2;
                                arrayList4 = arrayList;
                                aVar3 = aVar2;
                                kotlinx.coroutines.flow.f fVarV9 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                aVar3.b(null);
                                return fVarV9;
                            }
                        } else {
                            i14 = i12;
                            a aVar12 = f20960a;
                            c0432a2.L$0 = cVar5;
                            c0432a2.L$1 = str16;
                            c0432a2.L$2 = str14;
                            c0432a2.L$3 = str15;
                            c0432a2.L$4 = str10;
                            c0432a2.L$5 = aVar2;
                            c0432a2.L$6 = dVarA;
                            c0432a2.I$0 = i14;
                            c0432a2.Z$0 = z12;
                            c0432a2.I$1 = iIncrementAndGet;
                            c0432a2.J$0 = jC;
                            c0432a2.label = 4;
                            objZ = aVar12.z(cVar5, c0432a2);
                            if (objZ != objC) {
                                j10 = jC;
                                dVar = dVarA;
                                cVar6 = cVar5;
                                str17 = str14;
                                str18 = str15;
                                i15 = i14;
                                str19 = str16;
                                str20 = str10;
                                z13 = z12;
                                obj = objZ;
                                fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                                str21 = str17;
                                z14 = z13;
                                i16 = iIncrementAndGet;
                                str22 = str20;
                                str23 = str19;
                                arrayList = new ArrayList();
                                arrayList2 = new ArrayList();
                                int iDecrementAndGet9 = count.decrementAndGet();
                                fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                                cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet9, str22, arrayList2);
                                c0432a2.L$0 = aVar2;
                                c0432a2.L$1 = arrayList;
                                c0432a2.L$2 = arrayList2;
                                c0432a2.L$3 = null;
                                c0432a2.L$4 = null;
                                c0432a2.L$5 = null;
                                c0432a2.L$6 = null;
                                c0432a2.label = 5;
                                if (fVarF.collect(cVar7, c0432a2) != objC) {
                                    arrayList3 = arrayList2;
                                    arrayList4 = arrayList;
                                    aVar3 = aVar2;
                                    kotlinx.coroutines.flow.f fVarV10 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                    aVar3.b(null);
                                    return fVarV10;
                                }
                            }
                        }
                    }
                }
            } else {
                String str37 = str5;
                aVar2 = aVar;
                str7 = str37;
                str8 = str4;
                str9 = str6;
                i12 = i11;
                cVar3 = cVar2;
                str10 = strB0;
                z12 = z11;
                iIncrementAndGet = count.incrementAndGet();
                lastUrlReadyEvent = null;
                lastMetaId = null;
                lastMediaMode = null;
                lastRouteId = null;
                jC = d1.c();
                str14 = str7;
                str15 = str9;
                dVarA = x1.f1.lb.metric.monitor.h.f20952a.a(cVar3, str8, str14, str15, jC, i12);
                cVar5 = cVar3;
                str16 = str8;
                dVarA.setStart(d1.c());
                a1.h(a1.f21305a, jC, str14 + ".create_session", false, 4, null);
                if (kotlin.jvm.internal.m.a(lastUid, str10)) {
                    logger.a("will restart engine to change from [" + lastUid + ", " + lastPlayType + "] to [" + str10 + ", " + cVar5 + "]", new Object[0]);
                    l10 = lastPlaySession;
                    if (l10 != null) {
                        lastPlaySession = null;
                        z14 = z12;
                        fVarT = kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "check and start"), new e(cVar5, jC, dVarA, str14, str15, i12, null));
                        str21 = str14;
                        str22 = str10;
                        i16 = iIncrementAndGet;
                        str23 = str16;
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        int iDecrementAndGet10 = count.decrementAndGet();
                        fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                        cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet10, str22, arrayList2);
                        c0432a2.L$0 = aVar2;
                        c0432a2.L$1 = arrayList;
                        c0432a2.L$2 = arrayList2;
                        c0432a2.L$3 = null;
                        c0432a2.L$4 = null;
                        c0432a2.L$5 = null;
                        c0432a2.L$6 = null;
                        c0432a2.label = 5;
                        if (fVarF.collect(cVar7, c0432a2) != objC) {
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            aVar3 = aVar2;
                            kotlinx.coroutines.flow.f fVarV11 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                            aVar3.b(null);
                            return fVarV11;
                        }
                    } else {
                        i14 = i12;
                        a aVar13 = f20960a;
                        c0432a2.L$0 = cVar5;
                        c0432a2.L$1 = str16;
                        c0432a2.L$2 = str14;
                        c0432a2.L$3 = str15;
                        c0432a2.L$4 = str10;
                        c0432a2.L$5 = aVar2;
                        c0432a2.L$6 = dVarA;
                        c0432a2.I$0 = i14;
                        c0432a2.Z$0 = z12;
                        c0432a2.I$1 = iIncrementAndGet;
                        c0432a2.J$0 = jC;
                        c0432a2.label = 4;
                        objZ = aVar13.z(cVar5, c0432a2);
                        if (objZ != objC) {
                            j10 = jC;
                            dVar = dVarA;
                            cVar6 = cVar5;
                            str17 = str14;
                            str18 = str15;
                            i15 = i14;
                            str19 = str16;
                            str20 = str10;
                            z13 = z12;
                            obj = objZ;
                            fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                            str21 = str17;
                            z14 = z13;
                            i16 = iIncrementAndGet;
                            str22 = str20;
                            str23 = str19;
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            int iDecrementAndGet11 = count.decrementAndGet();
                            fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                            cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet11, str22, arrayList2);
                            c0432a2.L$0 = aVar2;
                            c0432a2.L$1 = arrayList;
                            c0432a2.L$2 = arrayList2;
                            c0432a2.L$3 = null;
                            c0432a2.L$4 = null;
                            c0432a2.L$5 = null;
                            c0432a2.L$6 = null;
                            c0432a2.label = 5;
                            if (fVarF.collect(cVar7, c0432a2) != objC) {
                                arrayList3 = arrayList2;
                                arrayList4 = arrayList;
                                aVar3 = aVar2;
                                kotlinx.coroutines.flow.f fVarV12 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                aVar3.b(null);
                                return fVarV12;
                            }
                        }
                    }
                } else {
                    logger.a("will restart engine to change from [" + lastUid + ", " + lastPlayType + "] to [" + str10 + ", " + cVar5 + "]", new Object[0]);
                    l10 = lastPlaySession;
                    if (l10 != null) {
                        lastPlaySession = null;
                        z14 = z12;
                        fVarT = kotlinx.coroutines.flow.h.t(x1.f1.lb.streaming.client.a.f21004a.v(l10.longValue(), "check and start"), new e(cVar5, jC, dVarA, str14, str15, i12, null));
                        str21 = str14;
                        str22 = str10;
                        i16 = iIncrementAndGet;
                        str23 = str16;
                        arrayList = new ArrayList();
                        arrayList2 = new ArrayList();
                        int iDecrementAndGet12 = count.decrementAndGet();
                        fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                        cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet12, str22, arrayList2);
                        c0432a2.L$0 = aVar2;
                        c0432a2.L$1 = arrayList;
                        c0432a2.L$2 = arrayList2;
                        c0432a2.L$3 = null;
                        c0432a2.L$4 = null;
                        c0432a2.L$5 = null;
                        c0432a2.L$6 = null;
                        c0432a2.label = 5;
                        if (fVarF.collect(cVar7, c0432a2) != objC) {
                            arrayList3 = arrayList2;
                            arrayList4 = arrayList;
                            aVar3 = aVar2;
                            kotlinx.coroutines.flow.f fVarV13 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                            aVar3.b(null);
                            return fVarV13;
                        }
                    } else {
                        i14 = i12;
                        a aVar14 = f20960a;
                        c0432a2.L$0 = cVar5;
                        c0432a2.L$1 = str16;
                        c0432a2.L$2 = str14;
                        c0432a2.L$3 = str15;
                        c0432a2.L$4 = str10;
                        c0432a2.L$5 = aVar2;
                        c0432a2.L$6 = dVarA;
                        c0432a2.I$0 = i14;
                        c0432a2.Z$0 = z12;
                        c0432a2.I$1 = iIncrementAndGet;
                        c0432a2.J$0 = jC;
                        c0432a2.label = 4;
                        objZ = aVar14.z(cVar5, c0432a2);
                        if (objZ != objC) {
                            j10 = jC;
                            dVar = dVarA;
                            cVar6 = cVar5;
                            str17 = str14;
                            str18 = str15;
                            i15 = i14;
                            str19 = str16;
                            str20 = str10;
                            z13 = z12;
                            obj = objZ;
                            fVarT = kotlinx.coroutines.flow.h.t((kotlinx.coroutines.flow.f) obj, new f(j10, dVar, cVar6, str17, str18, i15, null));
                            str21 = str17;
                            z14 = z13;
                            i16 = iIncrementAndGet;
                            str22 = str20;
                            str23 = str19;
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            int iDecrementAndGet13 = count.decrementAndGet();
                            fVarF = kotlinx.coroutines.flow.h.f(fVarT, new b(arrayList, null));
                            cVar7 = new c(z14, str23, str21, i16, iDecrementAndGet13, str22, arrayList2);
                            c0432a2.L$0 = aVar2;
                            c0432a2.L$1 = arrayList;
                            c0432a2.L$2 = arrayList2;
                            c0432a2.L$3 = null;
                            c0432a2.L$4 = null;
                            c0432a2.L$5 = null;
                            c0432a2.L$6 = null;
                            c0432a2.label = 5;
                            if (fVarF.collect(cVar7, c0432a2) != objC) {
                                arrayList3 = arrayList2;
                                arrayList4 = arrayList;
                                aVar3 = aVar2;
                                kotlinx.coroutines.flow.f fVarV14 = kotlinx.coroutines.flow.h.v(new d(arrayList3, arrayList4, null));
                                aVar3.b(null);
                                return fVarV14;
                            }
                        }
                    }
                }
            }
            return objC;
        } catch (Throwable th6) {
            th = th6;
            aVar3 = aVar;
        }
    }

    private final String x(String mediaId, String routeId, int mediaMode) {
        String strW = w("mediaId=" + mediaId + "&routeId=" + routeId + "&mediaMode=" + mediaMode);
        return x1.f1.lb.streaming.server.r.f21132a.j() + "=" + strW;
    }

    public final Object t(ChannelStreamResponse channelStreamResponse, AtomicBoolean atomicBoolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) {
        v6.c cVar = v6.c.LIVE;
        String streamName = channelStreamResponse.getStreamName();
        kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
        String streamId = channelStreamResponse.getStreamId();
        kotlin.jvm.internal.m.e(streamId, "getStreamId(...)");
        String route = channelStreamResponse.getRoute();
        kotlin.jvm.internal.m.e(route, "getRoute(...)");
        return q(cVar, streamName, streamId, route, channelStreamResponse.getType(), atomicBoolean.get(), fVar);
    }

    public final String v(String params) {
        kotlin.jvm.internal.m.f(params, "params");
        x1.f1.lb.util.a aVar = x1.f1.lb.util.a.f21291a;
        byte[] bArrDecode = Base64.decode(params, 10);
        kotlin.jvm.internal.m.e(bArrDecode, "decode(...)");
        return x1.f1.lb.util.a.b(aVar, new String(bArrDecode, ua.d.UTF_8), false, 2, null);
    }

    public final String w(String params) {
        kotlin.jvm.internal.m.f(params, "params");
        byte[] bytes = x1.f1.lb.util.a.d(x1.f1.lb.util.a.f21291a, params, false, 2, null).getBytes(ua.d.UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        String strEncodeToString = Base64.encodeToString(bytes, 10);
        kotlin.jvm.internal.m.e(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object z(v6.c cVar, v8.f<? super kotlinx.coroutines.flow.f<Boolean>> fVar) {
        p pVar;
        v6.c cVar2;
        Object objJ1;
        if (fVar instanceof p) {
            pVar = (p) fVar;
            int i10 = pVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                pVar.label = i10 - Integer.MIN_VALUE;
            } else {
                pVar = new p(fVar);
            }
        } else {
            pVar = new p(fVar);
        }
        Object obj = pVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = pVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            engineRestartCnt++;
            cVar2 = cVar == null ? lastPlayType : cVar;
            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
            pVar.L$0 = cVar;
            pVar.L$1 = cVar2;
            pVar.label = 1;
            objJ1 = fVar2.J1(cVar2, pVar);
            if (objJ1 == objC) {
                return objC;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v6.c cVar3 = (v6.c) pVar.L$1;
            v6.c cVar4 = (v6.c) pVar.L$0;
            r8.r.b(obj);
            cVar2 = cVar3;
            cVar = cVar4;
            objJ1 = obj;
        }
        return new o((kotlinx.coroutines.flow.f) objJ1, cVar, cVar2);
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlinx.coroutines.flow.f<r> u(long session, String mediaId, String routeId, int mediaMode, v6.c playType, tf.d playerZappingStat) {
        playerZappingStat.e0(d1.c());
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("engine start play", new Object[0]);
        }
        return new i(kotlinx.coroutines.flow.h.f(x1.f1.lb.streaming.client.a.f21004a.u(mediaId, session, playType, x1.f1.lb.streaming.server.r.f21132a.n() + "=" + session + "&" + x(mediaId, routeId, mediaMode)), new k(playerZappingStat, session, playType, mediaId, null)), playerZappingStat, mediaId, routeId, mediaMode);
    }

    public final void r(long session) {
        kotlinx.coroutines.j.d(m0.a(kotlinx.coroutines.a1.b()), null, null, new g(session, null), 3, null);
    }

    public final Object s(ChannelStreamResponse channelStreamResponse, String str, long j10, long j11, int i10, AtomicBoolean atomicBoolean, v8.f<? super kotlinx.coroutines.flow.f<? extends r>> fVar) throws Exception {
        if (channelStreamResponse.isCatchup()) {
            String streamId = channelStreamResponse.getStreamId();
            String catchupStreamId = channelStreamResponse.getCatchupStreamId();
            String catchupRoute = channelStreamResponse.getCatchupRoute();
            long jC = d1.c();
            String strW = w("streamId=" + streamId + "&catchupStreamId=" + catchupStreamId + "&route=" + catchupRoute + "&start=" + j10 + "&stop=" + j11);
            x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
            String str2 = rVar.n() + "=" + jC + "&" + rVar.j() + "=" + strW;
            x1.f1.lb.metric.monitor.h hVar = x1.f1.lb.metric.monitor.h.f20952a;
            v6.c cVar = v6.c.CATCHUP;
            String streamName = channelStreamResponse.getStreamName();
            kotlin.jvm.internal.m.e(streamName, "getStreamName(...)");
            kotlin.jvm.internal.m.c(catchupStreamId);
            kotlin.jvm.internal.m.c(catchupRoute);
            hVar.a(cVar, streamName, catchupStreamId, catchupRoute, jC, i10).setStart(d1.c());
            a1.h(a1.f21305a, jC, catchupStreamId + ".create_session", false, 4, null);
            return new h(kotlinx.coroutines.flow.h.f(x1.f1.lb.streaming.client.a.f21004a.t(jC, str2), new j(jC, streamId, catchupStreamId, null)), str, catchupRoute, i10);
        }
        throw new Exception("catchup unavailable");
    }
}
