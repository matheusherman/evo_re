package x1.f1.lb.streaming.client;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import org.apache.log4j.spi.LocationInfo;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x1.f1.lb.util.d0;
import x1.f1.lb.util.d1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011JK\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0 0\u00192\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J/\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0 0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b#\u0010$J\u001d\u0010&\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b(\u0010)J\u001d\u0010+\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0017¢\u0006\u0004\b+\u0010,J\u001d\u0010-\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u0017¢\u0006\u0004\b-\u0010,J#\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0004¢\u0006\u0004\b/\u0010$J\r\u00100\u001a\u00020\u000f¢\u0006\u0004\b0\u0010\u0003J\u0018\u00102\u001a\u00020\u001a2\u0006\u00101\u001a\u00020\tH\u0086@¢\u0006\u0004\b2\u00103J\r\u00104\u001a\u00020\u001a¢\u0006\u0004\b4\u00105J\u0016\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0086@¢\u0006\u0004\b6\u00107R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lx1/f1/lb/streaming/client/a;", "", "<init>", "()V", "", "l", "()Ljava/lang/String;", "j", "mediaId", "Lv6/c;", "playType", "k", "(Ljava/lang/String;Lv6/c;)Ljava/lang/String;", "Lx1/f1/lb/streaming/server/f;", "httpServer", "Lr8/z;", "s", "(Lx1/f1/lb/streaming/server/f;)V", "addressList", "token", "uid", "did", "tenantId", "", "deviceType", "Lkotlinx/coroutines/flow/f;", "", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILv6/c;)Lkotlinx/coroutines/flow/f;", "", "session", "params", "Lr8/p;", "u", "(Ljava/lang/String;JLv6/c;Ljava/lang/String;)Lkotlinx/coroutines/flow/f;", "t", "(JLjava/lang/String;)Lkotlinx/coroutines/flow/f;", "lang", "m", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "player", "g", "(JI)V", "q", TypedValues.TransitionType.S_FROM, "v", "r", IjkMediaMeta.IJKM_KEY_TYPE, "n", "(Lv6/c;Lv8/f;)Ljava/lang/Object;", "o", "()Z", "i", "(Lv8/f;)Ljava/lang/Object;", "Lq6/b;", "b", "Lq6/b;", "logger", "c", "Z", "isEngineStart", "Ljava/util/concurrent/atomic/AtomicBoolean;", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "stopEngineLock", "e", "Lx1/f1/lb/streaming/server/f;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21004a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isEngineStart;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean stopEngineLock;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static x1.f1.lb.streaming.server.f httpServer;

    /* JADX INFO: renamed from: x1.f1.lb.streaming.client.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$addPlayer$1", f = "EngineHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0442a extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $player;
        final /* synthetic */ long $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0442a(long j10, int i10, v8.f<? super C0442a> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$player = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0442a(this.$session, this.$player, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0442a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            try {
                if (!a.isEngineStart) {
                    throw new Exception("addPlayer(): engine not start");
                }
                String strL = a.f21004a.l();
                x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
                String str = strL + "/" + rVar.b() + LocationInfo.NA + rVar.n() + "=" + this.$session + "&" + rVar.k() + "=" + this.$player;
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                if (bVar.t()) {
                    a.logger.debug("streamingUrl[{}]", str);
                }
                byte[] bArrA = x1.f1.lb.streaming.client.b.a(str);
                m.e(bArrA, "get(...)");
                String str2 = new String(bArrA, ua.d.UTF_8);
                if (bVar.t()) {
                    a.logger.debug("streamingEngine[{}] complete: result[{}]", str, str2);
                }
                return z.f17874a;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$create$1", f = "EngineHelper.kt", l = {67}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class b extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super z>, Object> {
        final /* synthetic */ String $addressList;
        final /* synthetic */ int $deviceType;
        final /* synthetic */ String $did;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ String $tenantId;
        final /* synthetic */ String $token;
        final /* synthetic */ String $uid;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, String str3, String str4, String str5, v6.c cVar, int i10, v8.f<? super b> fVar) {
            super(2, fVar);
            this.$addressList = str;
            this.$token = str2;
            this.$uid = str3;
            this.$did = str4;
            this.$tenantId = str5;
            this.$playType = cVar;
            this.$deviceType = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            b bVar = new b(this.$addressList, this.$token, this.$uid, this.$did, this.$tenantId, this.$playType, this.$deviceType, fVar);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super z> fVar) {
            return ((b) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws IOException {
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
                kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                String str = this.$addressList;
                String str2 = this.$token;
                String str3 = this.$uid;
                String str4 = this.$did;
                String str5 = this.$tenantId;
                byte bF = this.$playType.f();
                String strW = x1.f1.lb.streaming.a.f20960a.w("addressList=" + str + "&token=" + str2 + "&uid=" + str3 + "&did=" + str4 + "&tenantId=" + str5 + "&type=" + ((int) bF) + "&deviceType=" + this.$deviceType);
                String strL = a.f21004a.l();
                x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
                String strP = rVar.p();
                String strJ = rVar.j();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(strL);
                sb2.append("/");
                sb2.append(strP);
                sb2.append(LocationInfo.NA);
                sb2.append(strJ);
                sb2.append("=");
                sb2.append(strW);
                String string = sb2.toString();
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                if (bVar.t()) {
                    a.logger.debug("streamingUrl[{}]", string);
                }
                byte[] bArrA = x1.f1.lb.streaming.client.b.a(string);
                m.e(bArrA, "get(...)");
                String str6 = new String(bArrA, ua.d.UTF_8);
                if (bVar.t()) {
                    a.logger.debug("streamingEngine[{}] complete: result[{}]", string, str6);
                }
                boolean z10 = Boolean.parseBoolean(str6);
                if (z10) {
                    a.logger.a("engine is started on create", new Object[0]);
                } else {
                    a.logger.warn("engine is not started on create", new Object[0]);
                }
                a.isEngineStart = z10;
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z10);
                this.label = 1;
                if (gVar.emit(boolA, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper", f = "EngineHelper.kt", l = {302}, m = "destroy")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class c extends kotlin.coroutines.jvm.internal.d {
        int label;
        /* synthetic */ Object result;

        c(v8.f<? super c> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return a.this.i(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$destroy$2", f = "EngineHelper.kt", l = {311}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class d extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super z>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        d(v8.f<? super d> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            d dVar = new d(fVar);
            dVar.L$0 = obj;
            return dVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super z> fVar) {
            return ((d) create(gVar, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                try {
                    String str = a.f21004a.l() + "/" + x1.f1.lb.streaming.server.r.f21132a.r();
                    x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                    if (bVar.t()) {
                        a.logger.debug("streamingUrl[{}]", str);
                    }
                    byte[] bArrA = x1.f1.lb.streaming.client.b.a(str);
                    m.e(bArrA, "get(...)");
                    String str2 = new String(bArrA, ua.d.UTF_8);
                    if (bVar.t()) {
                        a.logger.debug("streamingEngine[{}] complete: result[{}]", str, str2);
                    }
                    boolean z10 = Boolean.parseBoolean(str2);
                    if (z10) {
                        a.logger.a("engine is stopped on destroy", new Object[0]);
                        a.isEngineStart = false;
                    }
                    a.stopEngineLock.set(false);
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z10);
                    this.label = 1;
                    if (gVar.emit(boolA, this) == objC) {
                        return objC;
                    }
                } catch (Throwable th) {
                    a.stopEngineLock.set(false);
                    throw th;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$isConnected$2", f = "EngineHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "", "<anonymous>", "(Lkotlinx/coroutines/l0;)Z"}, k = 3, mv = {2, 1, 0})
    static final class f extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super Boolean>, Object> {
        final /* synthetic */ v6.c $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(v6.c cVar, v8.f<? super f> fVar) {
            super(2, fVar);
            this.$type = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new f(this.$type, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super Boolean> fVar) {
            return ((f) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                try {
                    if (!a.isEngineStart) {
                        a.logger.a("engine is not started in isConnected", new Object[0]);
                        return kotlin.coroutines.jvm.internal.b.a(false);
                    }
                    String strW = x1.f1.lb.streaming.a.f20960a.w(this.$type.name());
                    String strL = a.f21004a.l();
                    x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
                    String str = strL + "/" + rVar.v() + LocationInfo.NA + rVar.u() + "=" + strW;
                    x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                    if (bVar.t()) {
                        a.logger.debug("streamingUrl[{}]", str);
                    }
                    byte[] bArrA = x1.f1.lb.streaming.client.b.a(str);
                    m.e(bArrA, "get(...)");
                    String str2 = new String(bArrA, ua.d.UTF_8);
                    if (bVar.t()) {
                        a.logger.debug("streamingEngine[{}] complete: result[{}]", str, str2);
                    }
                    return kotlin.coroutines.jvm.internal.b.a(Boolean.parseBoolean(str2));
                } catch (Throwable unused) {
                    return kotlin.coroutines.jvm.internal.b.a(false);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$refreshToken$1", f = "EngineHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class g extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ String $refreshUri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, v8.f<? super g> fVar) {
            super(2, fVar);
            this.$refreshUri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new g(this.$refreshUri, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((g) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                r.b(obj);
                try {
                    byte[] bArrA = x1.f1.lb.streaming.client.b.a(this.$refreshUri);
                    m.e(bArrA, "get(...)");
                    String str = new String(bArrA, ua.d.UTF_8);
                    if (x1.f1.lb.config.b.f20643a.t()) {
                        a.logger.debug("streamingEngine[{}] complete: result[{}]", this.$refreshUri, str);
                    }
                } catch (Throwable unused) {
                    a.logger.error("refresh token failure[" + this.$refreshUri + "]", new Object[0]);
                }
                return z.f17874a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$removePlayer$1", f = "EngineHelper.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class h extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ int $player;
        final /* synthetic */ long $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j10, int i10, v8.f<? super h> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$player = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new h(this.$session, this.$player, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((h) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            try {
                if (!a.isEngineStart) {
                    throw new Exception("removePlayer(): engine not start");
                }
                String strL = a.f21004a.l();
                x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
                String str = strL + "/" + rVar.m() + LocationInfo.NA + rVar.n() + "=" + this.$session + "&" + rVar.k() + "=" + this.$player;
                x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                if (bVar.t()) {
                    a.logger.debug("streamingUrl[{}]", str);
                }
                byte[] bArrA = x1.f1.lb.streaming.client.b.a(str);
                m.e(bArrA, "get(...)");
                String str2 = new String(bArrA, ua.d.UTF_8);
                if (bVar.t()) {
                    a.logger.debug("streamingEngine[{}] complete: result[{}]", str, str2);
                }
                return z.f17874a;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$startCatchup$1", f = "EngineHelper.kt", l = {139}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/p;", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class i extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>>, v8.f<? super z>, Object> {
        final /* synthetic */ long $session;
        final /* synthetic */ String $startUri;
        private /* synthetic */ Object L$0;
        int label;

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.p<String, Long>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(String str, long j10, v8.f<? super i> fVar) {
            super(2, fVar);
            this.$startUri = str;
            this.$session = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            i iVar = new i(this.$startUri, this.$session, fVar);
            iVar.L$0 = obj;
            return iVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.p<String, Long>> gVar, v8.f<? super z> fVar) {
            return ((i) create(gVar, fVar)).invokeSuspend(z.f17874a);
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
                kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                r8.p pVar = new r8.p(this.$startUri, kotlin.coroutines.jvm.internal.b.c(this.$session));
                this.label = 1;
                if (gVar.emit(pVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$startPlay$1", f = "EngineHelper.kt", l = {96}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/flow/g;", "Lr8/p;", "", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class j extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>>, v8.f<? super z>, Object> {
        final /* synthetic */ String $mediaId;
        final /* synthetic */ String $params;
        final /* synthetic */ v6.c $playType;
        final /* synthetic */ long $session;
        final /* synthetic */ String $startUri;
        private /* synthetic */ Object L$0;
        int label;

        @Override // c9.p
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.g<? super r8.p<? extends String, ? extends Long>> gVar, v8.f<? super z> fVar) {
            return invoke2((kotlinx.coroutines.flow.g<? super r8.p<String, Long>>) gVar, fVar);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long j10, String str, String str2, v6.c cVar, String str3, v8.f<? super j> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$mediaId = str;
            this.$startUri = str2;
            this.$playType = cVar;
            this.$params = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            j jVar = new j(this.$session, this.$mediaId, this.$startUri, this.$playType, this.$params, fVar);
            jVar.L$0 = obj;
            return jVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.g<? super r8.p<String, Long>> gVar, v8.f<? super z> fVar) {
            return ((j) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Exception {
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
                kotlinx.coroutines.flow.g gVar = (kotlinx.coroutines.flow.g) this.L$0;
                a.logger.a("start play begin, session[" + this.$session + "] [" + this.$mediaId + "]", new Object[0]);
                byte[] bArrA = x1.f1.lb.streaming.client.b.a(this.$startUri);
                m.e(bArrA, "get(...)");
                String str = new String(bArrA, ua.d.UTF_8);
                if (x1.f1.lb.config.b.f20643a.t()) {
                    a.logger.debug("streamingEngine[{}] complete: result[{}]", this.$startUri, str);
                }
                if (Boolean.parseBoolean(str)) {
                    if (!a.isEngineStart) {
                        a.logger.a("engine is started on start play [ " + this.$session + " ]", new Object[0]);
                        a.isEngineStart = true;
                    }
                    g0 g0Var = g0.f12340a;
                    String str2 = String.format("%s?%s", Arrays.copyOf(new Object[]{a.f21004a.k(this.$mediaId, this.$playType), this.$params}, 2));
                    m.e(str2, "format(...)");
                    a.logger.a("start play complete, session[" + this.$session + "][" + str2 + "]", new Object[0]);
                    r8.p pVar = new r8.p(str2, kotlin.coroutines.jvm.internal.b.c(this.$session));
                    this.label = 1;
                    if (gVar.emit(pVar, this) == objC) {
                        return objC;
                    }
                } else {
                    throw new Exception("start play failure, session[" + this.$session + "][" + this.$playType + "][" + this.$params + "]");
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k implements kotlinx.coroutines.flow.f<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f21009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f21010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f21011c;

        /* JADX INFO: renamed from: x1.f1.lb.streaming.client.a$k$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
        public static final class C0443a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f21012a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f21013b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f21014c;

            /* JADX INFO: renamed from: x1.f1.lb.streaming.client.a$k$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$stopPlay$$inlined$map$1$2", f = "EngineHelper.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public static final class C0444a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0444a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0443a.this.emit(null, this);
                }
            }

            public C0443a(kotlinx.coroutines.flow.g gVar, long j10, String str) {
                this.f21012a = gVar;
                this.f21013b = j10;
                this.f21014c = str;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(Object obj, v8.f fVar) {
                C0444a c0444a;
                if (fVar instanceof C0444a) {
                    c0444a = (C0444a) fVar;
                    int i10 = c0444a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0444a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0444a = new C0444a(fVar);
                    }
                } else {
                    c0444a = new C0444a(fVar);
                }
                Object obj2 = c0444a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0444a.label;
                if (i11 == 0) {
                    r.b(obj2);
                    kotlinx.coroutines.flow.g gVar = this.f21012a;
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    a.logger.a("stop play complete[" + zBooleanValue + "], session[" + this.f21013b + "] from[" + this.f21014c + "]", new Object[0]);
                    Boolean boolA = kotlin.coroutines.jvm.internal.b.a(zBooleanValue);
                    c0444a.label = 1;
                    if (gVar.emit(boolA, c0444a) == objC) {
                        return objC;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r.b(obj2);
                }
                return z.f17874a;
            }
        }

        public k(kotlinx.coroutines.flow.f fVar, long j10, String str) {
            this.f21009a = fVar;
            this.f21010b = j10;
            this.f21011c = str;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f fVar) {
            Object objCollect = this.f21009a.collect(new C0443a(gVar, this.f21010b, this.f21011c), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.streaming.client.EngineHelper$stopPlay$1", f = "EngineHelper.kt", l = {223, 245, 252}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/flow/g;", "", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {2, 1, 0})
    static final class l extends kotlin.coroutines.jvm.internal.l implements p<kotlinx.coroutines.flow.g<? super Boolean>, v8.f<? super z>, Object> {
        final /* synthetic */ String $from;
        final /* synthetic */ long $session;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l(long j10, String str, v8.f<? super l> fVar) {
            super(2, fVar);
            this.$session = j10;
            this.$from = str;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            l lVar = new l(this.$session, this.$from, fVar);
            lVar.L$0 = obj;
            return lVar;
        }

        @Override // c9.p
        public final Object invoke(kotlinx.coroutines.flow.g<? super Boolean> gVar, v8.f<? super z> fVar) {
            return ((l) create(gVar, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0074, code lost:
        
            if (r1.emit(r15, r14) == r0) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x017f, code lost:
        
            if (r1.emit(r15, r14) == r0) goto L43;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.g gVar;
            long j10;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            r.b(obj);
                            return z.f17874a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j10 = this.J$0;
                    gVar = (kotlinx.coroutines.flow.g) this.L$0;
                    try {
                        r.b(obj);
                        return z.f17874a;
                    } catch (Throwable th) {
                        th = th;
                        long jD = d1.d();
                        a.logger.error("stop engine play error[" + this.$session + "][" + this.$from + "][" + (jD - j10) + " ms]", th);
                        Boolean boolA = kotlin.coroutines.jvm.internal.b.a(false);
                        this.L$0 = null;
                        this.label = 3;
                    }
                } else {
                    r.b(obj);
                    return z.f17874a;
                }
            } else {
                r.b(obj);
                gVar = (kotlinx.coroutines.flow.g) this.L$0;
                a.logger.a("stop play begin, session[" + this.$session + "] from[" + this.$from + "]", new Object[0]);
                if (!a.isEngineStart) {
                    Boolean boolA2 = kotlin.coroutines.jvm.internal.b.a(false);
                    this.label = 1;
                } else {
                    long jD2 = d1.d();
                    try {
                        String strL = a.f21004a.l();
                        x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
                        String str = strL + "/" + rVar.s() + LocationInfo.NA + rVar.n() + "=" + this.$session;
                        x1.f1.lb.config.b bVar = x1.f1.lb.config.b.f20643a;
                        if (bVar.t()) {
                            a.logger.debug("streamingUrl[{}]", str);
                        }
                        byte[] bArrA = x1.f1.lb.streaming.client.b.a(str);
                        m.e(bArrA, "get(...)");
                        String str2 = new String(bArrA, ua.d.UTF_8);
                        if (bVar.t()) {
                            a.logger.debug("streamingEngine[{}] complete: result[{}]", str, str2);
                        }
                        if (!a.isEngineStart) {
                            a.logger.a("engine is started on stop play [ " + this.$session + " ][" + this.$from + "]", new Object[0]);
                            a.isEngineStart = true;
                        }
                        Boolean boolA3 = kotlin.coroutines.jvm.internal.b.a(true);
                        this.L$0 = gVar;
                        this.J$0 = jD2;
                        this.label = 2;
                        if (gVar.emit(boolA3, this) != objC) {
                            j10 = jD2;
                            return z.f17874a;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        j10 = jD2;
                        long jD3 = d1.d();
                        a.logger.error("stop engine play error[" + this.$session + "][" + this.$from + "][" + (jD3 - j10) + " ms]", th);
                        Boolean boolA4 = kotlin.coroutines.jvm.internal.b.a(false);
                        this.L$0 = null;
                        this.label = 3;
                    }
                }
                return objC;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"x1/f1/lb/streaming/client/a$e", "Lx1/f1/lb/streaming/server/f;", "", "b", "()I", "Lr8/z;", "c", "()V", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements x1.f1.lb.streaming.server.f {
        @Override // x1.f1.lb.streaming.server.f
        public int b() {
            return 0;
        }

        e() {
        }

        @Override // x1.f1.lb.streaming.server.f
        public void c() {
        }
    }

    static {
        q6.b bVarD = q6.c.d(a.class);
        m.e(bVarD, "getLogger(...)");
        logger = bVarD;
        stopEngineLock = new AtomicBoolean(false);
        httpServer = new e();
    }

    private final String j() {
        return "http://127.0.0.1:" + x1.f1.lb.streaming.server.m.f21123a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(String mediaId, v6.c playType) {
        if (playType != v6.c.LIVE) {
            return l() + "/" + x1.f1.lb.streaming.server.r.f21132a.g() + ".m3u8";
        }
        if (m.a(x1.f1.lb.config.b.f20643a.l(), "HLS")) {
            return l() + "/" + x1.f1.lb.streaming.server.r.f21132a.g() + ".m3u8";
        }
        return j() + "/" + x1.f1.lb.streaming.server.r.f21132a.h() + "/" + mediaId + ".ts";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        return "http://127.0.0.1:" + httpServer.b();
    }

    public final kotlinx.coroutines.flow.f<Boolean> h(String addressList, String token, String uid, String did, String tenantId, int deviceType, v6.c playType) {
        m.f(addressList, "addressList");
        m.f(token, "token");
        m.f(uid, "uid");
        m.f(did, "did");
        m.f(tenantId, "tenantId");
        m.f(playType, "playType");
        return kotlinx.coroutines.flow.h.v(new b(addressList, token, uid, did, tenantId, playType, deviceType, null));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:22:0x005d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:25:0x0062  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x005b -> B:23:0x005e). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object i(v8.f<? super kotlinx.coroutines.flow.f<java.lang.Boolean>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof x1.f1.lb.streaming.client.a.c
            if (r0 == 0) goto L13
            r0 = r8
            x1.f1.lb.streaming.client.a$c r0 = (x1.f1.lb.streaming.client.a.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            x1.f1.lb.streaming.client.a$c r0 = new x1.f1.lb.streaming.client.a$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            r8.r.b(r8)
            goto L5e
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L32:
            r8.r.b(r8)
            boolean r8 = x1.f1.lb.streaming.client.a.isEngineStart
            if (r8 != 0) goto L4b
            q6.b r8 = x1.f1.lb.streaming.client.a.logger
            java.lang.String r0 = "engine is not started in destroy"
            java.lang.Object[] r1 = new java.lang.Object[r3]
            r8.a(r0, r1)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.b.a(r4)
            kotlinx.coroutines.flow.f r8 = kotlinx.coroutines.flow.h.w(r8)
            return r8
        L4b:
            java.util.concurrent.atomic.AtomicBoolean r8 = x1.f1.lb.streaming.client.a.stopEngineLock
            boolean r8 = r8.compareAndSet(r3, r4)
            if (r8 != 0) goto L70
            r0.label = r4
            r5 = 100
            java.lang.Object r8 = kotlinx.coroutines.v0.a(r5, r0)
            if (r8 != r1) goto L5e
            return r1
        L5e:
            boolean r8 = x1.f1.lb.streaming.client.a.isEngineStart
            if (r8 != 0) goto L4b
            java.util.concurrent.atomic.AtomicBoolean r8 = x1.f1.lb.streaming.client.a.stopEngineLock
            r8.set(r3)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.b.a(r4)
            kotlinx.coroutines.flow.f r8 = kotlinx.coroutines.flow.h.w(r8)
            return r8
        L70:
            x1.f1.lb.streaming.client.a$d r8 = new x1.f1.lb.streaming.client.a$d
            r0 = 0
            r8.<init>(r0)
            kotlinx.coroutines.flow.f r8 = kotlinx.coroutines.flow.h.v(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: x1.f1.lb.streaming.client.a.i(v8.f):java.lang.Object");
    }

    public final String m(String mediaId, String lang) {
        m.f(mediaId, "mediaId");
        m.f(lang, "lang");
        String strL = l();
        x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
        return strL + "/" + rVar.e() + LocationInfo.NA + rVar.i() + "=" + mediaId + "&" + rVar.f() + "=" + lang;
    }

    public final boolean o() {
        return isEngineStart;
    }

    public final void p(String token) throws Exception {
        m.f(token, "token");
        if (!isEngineStart) {
            throw new Exception("refreshToken(): engine not start");
        }
        String strW = x1.f1.lb.streaming.a.f20960a.w(token);
        String strL = l();
        x1.f1.lb.streaming.server.r rVar = x1.f1.lb.streaming.server.r.f21132a;
        String str = strL + "/" + rVar.l() + LocationInfo.NA + rVar.t() + "=" + strW;
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("streamingUrl[{}]", str);
        }
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new g(str, null), 3, null);
    }

    public final void r() {
        httpServer.c();
    }

    public final void s(x1.f1.lb.streaming.server.f httpServer2) {
        m.f(httpServer2, "httpServer");
        httpServer = httpServer2;
    }

    public final kotlinx.coroutines.flow.f<r8.p<String, Long>> t(long session, String params) throws Exception {
        m.f(params, "params");
        if (d0.f21360a.j()) {
            throw new Exception("startCatchup(): in eco mode");
        }
        String str = l() + "/" + x1.f1.lb.streaming.server.r.f21132a.o() + ".m3u8?" + params;
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("streamingUrl[{}]", str);
        }
        return kotlinx.coroutines.flow.h.v(new i(str, session, null));
    }

    public final kotlinx.coroutines.flow.f<r8.p<String, Long>> u(String mediaId, long session, v6.c playType, String params) throws Exception {
        m.f(mediaId, "mediaId");
        m.f(playType, "playType");
        m.f(params, "params");
        if (d0.f21360a.j()) {
            throw new Exception("startPlayer(): in eco mode");
        }
        if (!isEngineStart) {
            throw new Exception("startPlay(): engine not start");
        }
        String str = l() + "/" + x1.f1.lb.streaming.server.r.f21132a.q() + LocationInfo.NA + params;
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("streamingUrl[{}]", str);
        }
        return kotlinx.coroutines.flow.h.v(new j(session, mediaId, str, playType, params, null));
    }

    public final kotlinx.coroutines.flow.f<Boolean> v(long session, String from) {
        m.f(from, "from");
        x1.f1.lb.util.a1.f21305a.j(session);
        return new k(kotlinx.coroutines.flow.h.v(new l(session, from, null)), session, from);
    }

    private a() {
    }

    public final void g(long session, int player) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new C0442a(session, player, null), 3, null);
    }

    public final Object n(v6.c cVar, v8.f<? super Boolean> fVar) {
        return kotlinx.coroutines.h.g(a1.b(), new f(cVar, null), fVar);
    }

    public final void q(long session, int player) {
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new h(session, player, null), 3, null);
    }
}
