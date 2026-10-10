package x1.f1.lb.bot;

import androidx.core.app.NotificationCompat;
import c9.p;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import q6.b;
import q6.c;
import r8.r;
import r8.z;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.k;
import x1.f1.lb.util.n;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0003J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0018R\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010*\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010,\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010#R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010-R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010-R\u0016\u00100\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010/¨\u00061"}, d2 = {"Lx1/f1/lb/bot/a;", "", "<init>", "()V", "", NotificationCompat.CATEGORY_MESSAGE, "tag", "msgSeqKey", "Ljava/util/concurrent/atomic/AtomicLong;", "seq", "Lr8/z;", "i", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicLong;)V", "lastSentTimeKey", "", "lastSentTime", "h", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicLong;Ljava/lang/String;J)J", "j", "", "isEnable", "p", "(Z)V", "m", "(Ljava/lang/String;)V", "n", "l", "o", "k", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/util/concurrent/atomic/AtomicLong;", "msgSeq", "d", "errSeq", "e", "feedbackSeq", "f", "warnSeq", "g", "infoSeq", "J", "lastFeedbackTime", "Z", "botEnable", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong msgSeq;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong errSeq;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong feedbackSeq;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong warnSeq;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static AtomicLong infoSeq;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long lastSentTime;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static long lastFeedbackTime;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean botEnable;

    /* JADX INFO: renamed from: x1.f1.lb.bot.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "x1.f1.lb.bot.TelegramBot$init$1", f = "TelegramBot.kt", l = {38, 39, 40, 41, 42, 43}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class C0409a extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        int label;

        C0409a(v8.f<? super C0409a> fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new C0409a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C0409a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x0087 A[PHI: r1 r6
          0x0087: PHI (r1v6 java.util.concurrent.atomic.AtomicLong) = (r1v3 java.util.concurrent.atomic.AtomicLong), (r1v9 java.util.concurrent.atomic.AtomicLong) binds: [B:16:0x0083, B:10:0x0031] A[DONT_GENERATE, DONT_INLINE]
          0x0087: PHI (r6v7 java.lang.Object) = (r6v6 java.lang.Object), (r6v0 java.lang.Object) binds: [B:16:0x0083, B:10:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:21:0x00ac A[PHI: r1 r6
          0x00ac: PHI (r1v10 java.util.concurrent.atomic.AtomicLong) = (r1v7 java.util.concurrent.atomic.AtomicLong), (r1v13 java.util.concurrent.atomic.AtomicLong) binds: [B:19:0x00a9, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]
          0x00ac: PHI (r6v11 java.lang.Object) = (r6v10 java.lang.Object), (r6v0 java.lang.Object) binds: [B:19:0x00a9, B:9:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:24:0x00d1 A[PHI: r1 r6
          0x00d1: PHI (r1v14 java.util.concurrent.atomic.AtomicLong) = (r1v11 java.util.concurrent.atomic.AtomicLong), (r1v17 java.util.concurrent.atomic.AtomicLong) binds: [B:22:0x00ce, B:8:0x001f] A[DONT_GENERATE, DONT_INLINE]
          0x00d1: PHI (r6v15 java.lang.Object) = (r6v14 java.lang.Object), (r6v0 java.lang.Object) binds: [B:22:0x00ce, B:8:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:27:0x00f6 A[PHI: r1 r6
          0x00f6: PHI (r1v18 java.util.concurrent.atomic.AtomicLong) = (r1v15 java.util.concurrent.atomic.AtomicLong), (r1v21 java.util.concurrent.atomic.AtomicLong) binds: [B:25:0x00f3, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]
          0x00f6: PHI (r6v19 java.lang.Object) = (r6v18 java.lang.Object), (r6v0 java.lang.Object) binds: [B:25:0x00f3, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0113, code lost:
        
            if (r6 == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            AtomicLong atomicLong;
            AtomicLong atomicLong2;
            AtomicLong atomicLong3;
            AtomicLong atomicLong4;
            AtomicLong atomicLong5;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            switch (this.label) {
                case 0:
                    r.b(obj);
                    atomicLong = a.feedbackSeq;
                    w0 w0Var = w0.f21452a;
                    long j10 = a.feedbackSeq.get();
                    this.L$0 = atomicLong;
                    this.label = 1;
                    obj = w0Var.j("t_bot_usr_feedback_seq_key", j10, this);
                    if (obj != objC) {
                        atomicLong.set(((Number) obj).longValue());
                        atomicLong2 = a.msgSeq;
                        w0 w0Var2 = w0.f21452a;
                        long j11 = a.msgSeq.get();
                        this.L$0 = atomicLong2;
                        this.label = 2;
                        obj = w0Var2.j("t_bot_msg_seq_key", j11, this);
                        if (obj != objC) {
                            atomicLong2.set(((Number) obj).longValue());
                            atomicLong3 = a.errSeq;
                            w0 w0Var3 = w0.f21452a;
                            long j12 = a.errSeq.get();
                            this.L$0 = atomicLong3;
                            this.label = 3;
                            obj = w0Var3.j("t_bot_sys_err_seq_key", j12, this);
                            if (obj != objC) {
                                atomicLong3.set(((Number) obj).longValue());
                                atomicLong4 = a.warnSeq;
                                w0 w0Var4 = w0.f21452a;
                                long j13 = a.warnSeq.get();
                                this.L$0 = atomicLong4;
                                this.label = 4;
                                obj = w0Var4.j("t_bot_sys_warn_seq_key", j13, this);
                                if (obj != objC) {
                                    atomicLong4.set(((Number) obj).longValue());
                                    atomicLong5 = a.infoSeq;
                                    w0 w0Var5 = w0.f21452a;
                                    long j14 = a.infoSeq.get();
                                    this.L$0 = atomicLong5;
                                    this.label = 5;
                                    obj = w0Var5.j("t_bot_sys_info_seq_key", j14, this);
                                    if (obj != objC) {
                                        atomicLong5.set(((Number) obj).longValue());
                                        a aVar = a.f20583a;
                                        w0 w0Var6 = w0.f21452a;
                                        long j15 = a.lastSentTime;
                                        this.L$0 = null;
                                        this.label = 6;
                                        obj = w0Var6.j("t_bot_msg_last_sent_time_key", j15, this);
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 1:
                    atomicLong = (AtomicLong) this.L$0;
                    r.b(obj);
                    atomicLong.set(((Number) obj).longValue());
                    atomicLong2 = a.msgSeq;
                    w0 w0Var7 = w0.f21452a;
                    long j16 = a.msgSeq.get();
                    this.L$0 = atomicLong2;
                    this.label = 2;
                    obj = w0Var7.j("t_bot_msg_seq_key", j16, this);
                    if (obj != objC) {
                        atomicLong2.set(((Number) obj).longValue());
                        atomicLong3 = a.errSeq;
                        w0 w0Var8 = w0.f21452a;
                        long j17 = a.errSeq.get();
                        this.L$0 = atomicLong3;
                        this.label = 3;
                        obj = w0Var8.j("t_bot_sys_err_seq_key", j17, this);
                        if (obj != objC) {
                            atomicLong3.set(((Number) obj).longValue());
                            atomicLong4 = a.warnSeq;
                            w0 w0Var9 = w0.f21452a;
                            long j18 = a.warnSeq.get();
                            this.L$0 = atomicLong4;
                            this.label = 4;
                            obj = w0Var9.j("t_bot_sys_warn_seq_key", j18, this);
                            if (obj != objC) {
                                atomicLong4.set(((Number) obj).longValue());
                                atomicLong5 = a.infoSeq;
                                w0 w0Var10 = w0.f21452a;
                                long j19 = a.infoSeq.get();
                                this.L$0 = atomicLong5;
                                this.label = 5;
                                obj = w0Var10.j("t_bot_sys_info_seq_key", j19, this);
                                if (obj != objC) {
                                    atomicLong5.set(((Number) obj).longValue());
                                    a aVar2 = a.f20583a;
                                    w0 w0Var11 = w0.f21452a;
                                    long j110 = a.lastSentTime;
                                    this.L$0 = null;
                                    this.label = 6;
                                    obj = w0Var11.j("t_bot_msg_last_sent_time_key", j110, this);
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 2:
                    atomicLong2 = (AtomicLong) this.L$0;
                    r.b(obj);
                    atomicLong2.set(((Number) obj).longValue());
                    atomicLong3 = a.errSeq;
                    w0 w0Var12 = w0.f21452a;
                    long j111 = a.errSeq.get();
                    this.L$0 = atomicLong3;
                    this.label = 3;
                    obj = w0Var12.j("t_bot_sys_err_seq_key", j111, this);
                    if (obj != objC) {
                        atomicLong3.set(((Number) obj).longValue());
                        atomicLong4 = a.warnSeq;
                        w0 w0Var13 = w0.f21452a;
                        long j112 = a.warnSeq.get();
                        this.L$0 = atomicLong4;
                        this.label = 4;
                        obj = w0Var13.j("t_bot_sys_warn_seq_key", j112, this);
                        if (obj != objC) {
                            atomicLong4.set(((Number) obj).longValue());
                            atomicLong5 = a.infoSeq;
                            w0 w0Var14 = w0.f21452a;
                            long j113 = a.infoSeq.get();
                            this.L$0 = atomicLong5;
                            this.label = 5;
                            obj = w0Var14.j("t_bot_sys_info_seq_key", j113, this);
                            if (obj != objC) {
                                atomicLong5.set(((Number) obj).longValue());
                                a aVar3 = a.f20583a;
                                w0 w0Var15 = w0.f21452a;
                                long j114 = a.lastSentTime;
                                this.L$0 = null;
                                this.label = 6;
                                obj = w0Var15.j("t_bot_msg_last_sent_time_key", j114, this);
                            }
                        }
                        break;
                    }
                    return objC;
                case 3:
                    atomicLong3 = (AtomicLong) this.L$0;
                    r.b(obj);
                    atomicLong3.set(((Number) obj).longValue());
                    atomicLong4 = a.warnSeq;
                    w0 w0Var16 = w0.f21452a;
                    long j115 = a.warnSeq.get();
                    this.L$0 = atomicLong4;
                    this.label = 4;
                    obj = w0Var16.j("t_bot_sys_warn_seq_key", j115, this);
                    if (obj != objC) {
                        atomicLong4.set(((Number) obj).longValue());
                        atomicLong5 = a.infoSeq;
                        w0 w0Var17 = w0.f21452a;
                        long j116 = a.infoSeq.get();
                        this.L$0 = atomicLong5;
                        this.label = 5;
                        obj = w0Var17.j("t_bot_sys_info_seq_key", j116, this);
                        if (obj != objC) {
                            atomicLong5.set(((Number) obj).longValue());
                            a aVar4 = a.f20583a;
                            w0 w0Var18 = w0.f21452a;
                            long j117 = a.lastSentTime;
                            this.L$0 = null;
                            this.label = 6;
                            obj = w0Var18.j("t_bot_msg_last_sent_time_key", j117, this);
                        }
                        break;
                    }
                    return objC;
                case 4:
                    atomicLong4 = (AtomicLong) this.L$0;
                    r.b(obj);
                    atomicLong4.set(((Number) obj).longValue());
                    atomicLong5 = a.infoSeq;
                    w0 w0Var19 = w0.f21452a;
                    long j118 = a.infoSeq.get();
                    this.L$0 = atomicLong5;
                    this.label = 5;
                    obj = w0Var19.j("t_bot_sys_info_seq_key", j118, this);
                    if (obj != objC) {
                        atomicLong5.set(((Number) obj).longValue());
                        a aVar5 = a.f20583a;
                        w0 w0Var110 = w0.f21452a;
                        long j119 = a.lastSentTime;
                        this.L$0 = null;
                        this.label = 6;
                        obj = w0Var110.j("t_bot_msg_last_sent_time_key", j119, this);
                        break;
                    }
                    return objC;
                case 5:
                    atomicLong5 = (AtomicLong) this.L$0;
                    r.b(obj);
                    atomicLong5.set(((Number) obj).longValue());
                    a aVar6 = a.f20583a;
                    w0 w0Var111 = w0.f21452a;
                    long j1110 = a.lastSentTime;
                    this.L$0 = null;
                    this.label = 6;
                    obj = w0Var111.j("t_bot_msg_last_sent_time_key", j1110, this);
                    break;
                case 6:
                    r.b(obj);
                    a.lastSentTime = ((Number) obj).longValue();
                    return z.f17874a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    static {
        a aVar = new a();
        f20583a = aVar;
        logger = c.d(aVar.getClass());
        msgSeq = new AtomicLong(0L);
        errSeq = new AtomicLong(0L);
        feedbackSeq = new AtomicLong(0L);
        warnSeq = new AtomicLong(0L);
        infoSeq = new AtomicLong(0L);
        botEnable = true;
    }

    private final long h(String msg, String tag, String msgSeqKey, AtomicLong seq, String lastSentTimeKey, long lastSentTime2) {
        if (!botEnable) {
            return lastSentTime2;
        }
        long jD = d1.d();
        String strH = n.n().h(16, jD);
        long j10 = jD - lastSentTime2;
        if (1 <= j10 && j10 < jD) {
            strH = strH + "    last msg: " + n.n().h(16, lastSentTime2) + "(" + d1.b(j10, null) + " ago)";
        }
        x1.f1.lb.log.a.f20729a.g("\n" + tag + "\n#" + seq.incrementAndGet() + ": [v" + k.f21398a.t() + "] " + strH + "\n" + msg);
        w0 w0Var = w0.f21452a;
        w0Var.s(msgSeqKey, seq.get());
        w0Var.s(lastSentTimeKey, jD);
        return jD;
    }

    private final void i(String msg, String tag, String msgSeqKey, AtomicLong seq) {
        if (botEnable) {
            String strH = n.n().h(16, d1.d());
            x1.f1.lb.log.a.f20729a.g("\n" + tag + "\n#" + seq.incrementAndGet() + ": [v" + k.f21398a.t() + "] " + strH + "\n" + msg);
            w0.f21452a.s(msgSeqKey, seq.get());
        }
    }

    public final void k(String msg) {
        m.f(msg, "msg");
        lastSentTime = h(msg, "[biz]", "t_bot_msg_seq_key", msgSeq, "t_bot_msg_last_sent_time_key", lastSentTime);
    }

    public final void l(String msg) {
        m.f(msg, "msg");
        i(msg, "[sys][E]", "t_bot_sys_err_seq_key", errSeq);
    }

    public final void m(String msg) {
        m.f(msg, "msg");
        i(msg, "[sys][I]", "t_bot_sys_info_seq_key", infoSeq);
    }

    public final void n(String msg) {
        m.f(msg, "msg");
        i(msg, "[sys][W]", "t_bot_sys_warn_seq_key", warnSeq);
    }

    public final void o(String msg) {
        m.f(msg, "msg");
        lastFeedbackTime = h(msg, "[feedback]", "t_bot_usr_feedback_seq_key", feedbackSeq, "t_bot_msg_last_feedback_sent_time_key", lastFeedbackTime);
    }

    public final void p(boolean isEnable) {
        botEnable = isEnable;
    }

    private a() {
    }

    public final void j() {
        try {
            j.d(m0.a(a1.b()), null, null, new C0409a(null), 3, null);
        } catch (Throwable th) {
            logger.error("init telegram bot failure", th);
        }
    }
}
