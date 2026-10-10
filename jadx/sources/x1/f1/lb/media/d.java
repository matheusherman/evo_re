package x1.f1.lb.media;

import android.content.Context;
import c9.p;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import x.l1.b2.R$string;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0086@¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001bJ\r\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\t¢\u0006\u0004\b#\u0010\u001bJ\u0015\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b%\u0010\"J\u0019\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b(\u0010)R\u001c\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00100R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00103R\u0016\u0010 \u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00100R\u0016\u0010;\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0016\u0010=\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00100R\u0016\u0010?\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00100R\u0016\u0010A\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00103R\u0016\u0010C\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00103R\"\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010G\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00100R\u0016\u0010H\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00100R#\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0&8\u0006¢\u0006\f\n\u0004\b(\u0010E\u001a\u0004\bI\u0010)¨\u0006K"}, d2 = {"Lx1/f1/lb/media/d;", "", "<init>", "()V", "Landroid/content/Context;", "appContext", "Lr8/z;", "t", "(Landroid/content/Context;)V", "", "uid", "u", "(Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "Lv6/c;", IjkMediaMeta.IJKM_KEY_TYPE, "", "q", "(Lv6/c;)I", "aspectType", "y", "(Lv6/c;I)V", "r", "()I", "fontSize", "z", "(I)V", "s", "()Ljava/lang/String;", "o", "", "v", "()Z", "adultPin", "x", "(Ljava/lang/String;)V", "n", "password", "w", "", "Ljava/util/concurrent/atomic/AtomicInteger;", "p", "()Ljava/util/Map;", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "c", "Ljava/lang/String;", "sourceAudioLang", "d", "I", "subtitleFontSizeInSP", "e", "subtitleLang", "f", "subtitleSwitch", "g", "h", "oldAdultPin", "i", "lastAdultPinUid", "j", "personalAdultPinKey", "k", "liveScreenAspectType", "l", "vodScreenAspectType", "m", "Ljava/util/Map;", "userClickCountMap", "adultColumnPassword", "personalAdultColumnPasswordKey", "getPlayCfgTitle", "playCfgTitle", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f20812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static String sourceAudioLang;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int subtitleFontSizeInSP;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String subtitleLang;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int subtitleSwitch;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String adultPin;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String oldAdultPin;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static String lastAdultPinUid;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static String personalAdultPinKey;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static int liveScreenAspectType;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static int vodScreenAspectType;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static Map<String, AtomicInteger> userClickCountMap;

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static String adultColumnPassword;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static String personalAdultColumnPasswordKey;

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> playCfgTitle;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.MediaConfigUtils$initData$1", f = "MediaConfigUtils.kt", l = {67, 71, 75, 79, 83, 87, 91}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {2, 1, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class b<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b<T> f20829a = new b<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            b() {
            }

            public final Object b(int i10, v8.f<? super z> fVar) {
                d.subtitleFontSizeInSP = i10;
                return z.f17874a;
            }
        }

        /* JADX INFO: renamed from: x1.f1.lb.media.d$a$d, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0425d<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0425d<T> f20831a = new C0425d<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            C0425d() {
            }

            public final Object b(int i10, v8.f<? super z> fVar) {
                d.subtitleSwitch = i10;
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class f<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final f<T> f20833a = new f<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            f() {
            }

            public final Object b(int i10, v8.f<? super z> fVar) {
                d.liveScreenAspectType = i10;
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class g<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final g<T> f20834a = new g<>();

            @Override // kotlinx.coroutines.flow.g
            public /* bridge */ /* synthetic */ Object emit(Object obj, v8.f fVar) {
                return b(((Number) obj).intValue(), fVar);
            }

            g() {
            }

            public final Object b(int i10, v8.f<? super z> fVar) {
                d.vodScreenAspectType = i10;
                return z.f17874a;
            }
        }

        a(v8.f<? super a> fVar) {
            super(2, fVar);
        }

        /* JADX INFO: renamed from: x1.f1.lb.media.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C0424a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0424a<T> f20828a = new C0424a<>();

            C0424a() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                d.sourceAudioLang = str;
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class c<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c<T> f20830a = new c<>();

            c() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                d.subtitleLang = str;
                return z.f17874a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class e<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e<T> f20832a = new e<>();

            e() {
            }

            @Override // kotlinx.coroutines.flow.g
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(String str, v8.f<? super z> fVar) {
                d.oldAdultPin = str;
                return z.f17874a;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x006a  */
        /* JADX WARN: Code duplicated, block: B:22:0x0084  */
        /* JADX WARN: Code duplicated, block: B:25:0x00a0  */
        /* JADX WARN: Code duplicated, block: B:28:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:31:0x00d4  */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00ed, code lost:
        
            if (r4.collect(r1, r3) == r0) goto L33;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            kotlinx.coroutines.flow.f fVarG;
            kotlinx.coroutines.flow.g gVar;
            kotlinx.coroutines.flow.f fVarG2;
            kotlinx.coroutines.flow.g gVar2;
            kotlinx.coroutines.flow.f fVarG3;
            kotlinx.coroutines.flow.g gVar3;
            kotlinx.coroutines.flow.f fVarG4;
            kotlinx.coroutines.flow.g gVar4;
            kotlinx.coroutines.flow.f fVarG5;
            kotlinx.coroutines.flow.g gVar5;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            switch (this.label) {
                case 0:
                    r.b(obj);
                    kotlinx.coroutines.flow.f fVarG6 = w0.f21452a.g("MediaCfgVoDSourceAudioLang", d.sourceAudioLang);
                    kotlinx.coroutines.flow.g gVar6 = C0424a.f20828a;
                    this.label = 1;
                    if (fVarG6.collect(gVar6, this) != objC) {
                        fVarG = w0.f21452a.g("MediaCfgVoDSubtitleFontSize", kotlin.coroutines.jvm.internal.b.b(d.subtitleFontSizeInSP));
                        gVar = b.f20829a;
                        this.label = 2;
                        if (fVarG.collect(gVar, this) != objC) {
                            fVarG2 = w0.f21452a.g("MediaCfgVoDSubtitleLang", x1.f1.lb.heartbeat.f.f20678a.M0());
                            gVar2 = c.f20830a;
                            this.label = 3;
                            if (fVarG2.collect(gVar2, this) != objC) {
                                fVarG3 = w0.f21452a.g("MediaCfgVoDSubtitleSwitch", kotlin.coroutines.jvm.internal.b.b(d.subtitleSwitch));
                                gVar3 = C0425d.f20831a;
                                this.label = 4;
                                if (fVarG3.collect(gVar3, this) != objC) {
                                    fVarG4 = w0.f21452a.g("adult_pin", d.oldAdultPin);
                                    gVar4 = e.f20832a;
                                    this.label = 5;
                                    if (fVarG4.collect(gVar4, this) != objC) {
                                        fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                                        gVar5 = f.f20833a;
                                        this.label = 6;
                                        if (fVarG5.collect(gVar5, this) != objC) {
                                            kotlinx.coroutines.flow.f fVarG7 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                                            kotlinx.coroutines.flow.g gVar7 = g.f20834a;
                                            this.label = 7;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 1:
                    r.b(obj);
                    fVarG = w0.f21452a.g("MediaCfgVoDSubtitleFontSize", kotlin.coroutines.jvm.internal.b.b(d.subtitleFontSizeInSP));
                    gVar = b.f20829a;
                    this.label = 2;
                    if (fVarG.collect(gVar, this) != objC) {
                        fVarG2 = w0.f21452a.g("MediaCfgVoDSubtitleLang", x1.f1.lb.heartbeat.f.f20678a.M0());
                        gVar2 = c.f20830a;
                        this.label = 3;
                        if (fVarG2.collect(gVar2, this) != objC) {
                            fVarG3 = w0.f21452a.g("MediaCfgVoDSubtitleSwitch", kotlin.coroutines.jvm.internal.b.b(d.subtitleSwitch));
                            gVar3 = C0425d.f20831a;
                            this.label = 4;
                            if (fVarG3.collect(gVar3, this) != objC) {
                                fVarG4 = w0.f21452a.g("adult_pin", d.oldAdultPin);
                                gVar4 = e.f20832a;
                                this.label = 5;
                                if (fVarG4.collect(gVar4, this) != objC) {
                                    fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                                    gVar5 = f.f20833a;
                                    this.label = 6;
                                    if (fVarG5.collect(gVar5, this) != objC) {
                                        kotlinx.coroutines.flow.f fVarG8 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                                        kotlinx.coroutines.flow.g gVar8 = g.f20834a;
                                        this.label = 7;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 2:
                    r.b(obj);
                    fVarG2 = w0.f21452a.g("MediaCfgVoDSubtitleLang", x1.f1.lb.heartbeat.f.f20678a.M0());
                    gVar2 = c.f20830a;
                    this.label = 3;
                    if (fVarG2.collect(gVar2, this) != objC) {
                        fVarG3 = w0.f21452a.g("MediaCfgVoDSubtitleSwitch", kotlin.coroutines.jvm.internal.b.b(d.subtitleSwitch));
                        gVar3 = C0425d.f20831a;
                        this.label = 4;
                        if (fVarG3.collect(gVar3, this) != objC) {
                            fVarG4 = w0.f21452a.g("adult_pin", d.oldAdultPin);
                            gVar4 = e.f20832a;
                            this.label = 5;
                            if (fVarG4.collect(gVar4, this) != objC) {
                                fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                                gVar5 = f.f20833a;
                                this.label = 6;
                                if (fVarG5.collect(gVar5, this) != objC) {
                                    kotlinx.coroutines.flow.f fVarG9 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                                    kotlinx.coroutines.flow.g gVar9 = g.f20834a;
                                    this.label = 7;
                                }
                            }
                        }
                        break;
                    }
                    return objC;
                case 3:
                    r.b(obj);
                    fVarG3 = w0.f21452a.g("MediaCfgVoDSubtitleSwitch", kotlin.coroutines.jvm.internal.b.b(d.subtitleSwitch));
                    gVar3 = C0425d.f20831a;
                    this.label = 4;
                    if (fVarG3.collect(gVar3, this) != objC) {
                        fVarG4 = w0.f21452a.g("adult_pin", d.oldAdultPin);
                        gVar4 = e.f20832a;
                        this.label = 5;
                        if (fVarG4.collect(gVar4, this) != objC) {
                            fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                            gVar5 = f.f20833a;
                            this.label = 6;
                            if (fVarG5.collect(gVar5, this) != objC) {
                                kotlinx.coroutines.flow.f fVarG10 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                                kotlinx.coroutines.flow.g gVar10 = g.f20834a;
                                this.label = 7;
                            }
                        }
                        break;
                    }
                    return objC;
                case 4:
                    r.b(obj);
                    fVarG4 = w0.f21452a.g("adult_pin", d.oldAdultPin);
                    gVar4 = e.f20832a;
                    this.label = 5;
                    if (fVarG4.collect(gVar4, this) != objC) {
                        fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                        gVar5 = f.f20833a;
                        this.label = 6;
                        if (fVarG5.collect(gVar5, this) != objC) {
                            kotlinx.coroutines.flow.f fVarG11 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                            kotlinx.coroutines.flow.g gVar11 = g.f20834a;
                            this.label = 7;
                        }
                        break;
                    }
                    return objC;
                case 5:
                    r.b(obj);
                    fVarG5 = w0.f21452a.g("MediaCfgLivePlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.liveScreenAspectType));
                    gVar5 = f.f20833a;
                    this.label = 6;
                    if (fVarG5.collect(gVar5, this) != objC) {
                        kotlinx.coroutines.flow.f fVarG12 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                        kotlinx.coroutines.flow.g gVar12 = g.f20834a;
                        this.label = 7;
                        break;
                    }
                    return objC;
                case 6:
                    r.b(obj);
                    kotlinx.coroutines.flow.f fVarG13 = w0.f21452a.g("MediaCfgVoDPlayerScreenKey", kotlin.coroutines.jvm.internal.b.b(d.vodScreenAspectType));
                    kotlinx.coroutines.flow.g gVar13 = g.f20834a;
                    this.label = 7;
                    break;
                case 7:
                    r.b(obj);
                    return z.f17874a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.media.MediaConfigUtils", f = "MediaConfigUtils.kt", l = {110, 121}, m = "initUserData")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class b extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(v8.f<? super b> fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return d.this.u(null, this);
        }
    }

    public final synchronized Map<String, AtomicInteger> p() {
        Map<String, AtomicInteger> map;
        map = userClickCountMap;
        userClickCountMap = new LinkedHashMap();
        return map;
    }

    static {
        d dVar = new d();
        f20812a = dVar;
        logger = q6.c.d(dVar.getClass());
        sourceAudioLang = "";
        subtitleFontSizeInSP = 20;
        subtitleLang = "";
        subtitleSwitch = 1;
        adultPin = "";
        oldAdultPin = "";
        lastAdultPinUid = "";
        personalAdultPinKey = "";
        userClickCountMap = new LinkedHashMap();
        adultColumnPassword = "";
        personalAdultColumnPasswordKey = "";
        playCfgTitle = new HashMap();
    }

    public final String n() {
        return adultColumnPassword;
    }

    public final String o() {
        return adultPin;
    }

    public final int q(v6.c type) {
        kotlin.jvm.internal.m.f(type, "type");
        return type == v6.c.VOD ? vodScreenAspectType : liveScreenAspectType;
    }

    public final int r() {
        return subtitleFontSizeInSP;
    }

    public final String s() {
        return subtitleLang;
    }

    public final void t(Context appContext) {
        kotlin.jvm.internal.m.f(appContext, "appContext");
        kotlinx.coroutines.j.d(m0.a(a1.b()), null, null, new a(null), 3, null);
        Map<String, String> map = playCfgTitle;
        map.put("MediaCfgNameResolution", appContext.getString(R$string.full_screen_menu_resolution));
        map.put("MediaCfgNameAudio", appContext.getString(R$string.full_screen_menu_audio));
        map.put("MediaCfgNameScreen", appContext.getString(R$string.full_screen_menu_screen));
        map.put("MediaCfgNameSubtitle", appContext.getString(R$string.full_screen_menu_subtitle));
        map.put("MediaCfgNamePlayer", appContext.getString(R$string.full_screen_menu_player));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b5, code lost:
    
        if (r10 == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(String str, v8.f<? super z> fVar) {
        b bVar;
        d dVar;
        if (fVar instanceof b) {
            bVar = (b) fVar;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(fVar);
            }
        } else {
            bVar = new b(fVar);
        }
        Object objM = bVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = bVar.label;
        if (i11 == 0) {
            r.b(objM);
            personalAdultPinKey = "adult_pin" + str;
            w0 w0Var = w0.f21452a;
            String str2 = personalAdultPinKey;
            bVar.L$0 = this;
            bVar.L$1 = str;
            bVar.label = 1;
            objM = w0Var.m(str2, "", bVar);
            if (objM != objC) {
                dVar = this;
            }
            return objC;
        }
        if (i11 == 1) {
            str = (String) bVar.L$1;
            dVar = (d) bVar.L$0;
            r.b(objM);
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) bVar.L$1;
            r.b(objM);
        }
        adultColumnPassword = (String) objM;
        if (lastAdultPinUid.length() > 0 && !kotlin.jvm.internal.m.a(lastAdultPinUid, str)) {
            x1.f1.lb.media.a.f20755a.e0();
            xe.c.c().o(new nf.c());
        }
        lastAdultPinUid = str;
        return z.f17874a;
        String str3 = (String) objM;
        if (str3.length() != 0 || oldAdultPin.length() <= 0) {
            adultPin = str3;
        } else {
            w0 w0Var2 = w0.f21452a;
            w0Var2.t(personalAdultPinKey, oldAdultPin);
            w0Var2.t("adult_pin", "");
            oldAdultPin = "";
        }
        personalAdultColumnPasswordKey = "adult_column_lock_password_key" + str;
        w0 w0Var3 = w0.f21452a;
        String str4 = personalAdultColumnPasswordKey;
        bVar.L$0 = dVar;
        bVar.L$1 = str;
        bVar.label = 2;
        objM = w0Var3.m(str4, "", bVar);
    }

    public final boolean v() {
        return adultPin.length() > 0;
    }

    public final void w(String password) {
        kotlin.jvm.internal.m.f(password, "password");
        adultColumnPassword = password;
        w0.f21452a.t(personalAdultColumnPasswordKey, password);
    }

    public final void x(String adultPin2) {
        kotlin.jvm.internal.m.f(adultPin2, "adultPin");
        adultPin = adultPin2;
        w0.f21452a.t(personalAdultPinKey, adultPin2);
    }

    public final void y(v6.c type, int aspectType) {
        kotlin.jvm.internal.m.f(type, "type");
        if (type == v6.c.VOD) {
            vodScreenAspectType = aspectType;
        } else {
            liveScreenAspectType = aspectType;
        }
    }

    public final void z(int fontSize) {
        subtitleFontSizeInSP = fontSize;
        w0.f21452a.r("MediaCfgVoDSubtitleFontSize", fontSize);
    }

    private d() {
    }
}
