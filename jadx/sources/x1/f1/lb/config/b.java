package x1.f1.lb.config;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.IntegerRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.net.SyslogAppender;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import x.l1.b2.R$string;
import x1.f1.lb.media.j;
import x1.f1.lb.streaming.server.i;
import x1.f1.lb.streaming.server.q;
import x1.f1.lb.streaming.server.s;
import x1.f1.lb.util.a1;
import x1.f1.lb.util.b1;
import x1.f1.lb.util.d0;
import x1.f1.lb.util.d1;
import x1.f1.lb.util.k;
import x1.f1.lb.util.k0;
import x1.f1.lb.util.n;
import x1.f1.lb.util.n0;
import x1.f1.lb.util.o0;
import x1.f1.lb.util.q0;
import x1.f1.lb.util.w0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J¾\u0001\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\bH\u0086@¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b&\u0010'J!\u0010+\u001a\u00020\b2\b\b\u0001\u0010)\u001a\u00020(2\b\b\u0002\u0010*\u001a\u00020\b¢\u0006\u0004\b+\u0010,R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010-\u001a\u0004\b.\u0010\"\"\u0004\b/\u00100R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010 \"\u0004\b4\u00105R\"\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010-\u001a\u0004\b6\u0010\"\"\u0004\b7\u00100R\"\u0010;\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010-\u001a\u0004\b9\u0010\"\"\u0004\b:\u00100R$\u0010C\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010I\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010L\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u00102\u001a\u0004\b=\u0010 \"\u0004\bK\u00105R\"\u0010P\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u00102\u001a\u0004\bN\u0010 \"\u0004\bO\u00105R\"\u0010T\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u00102\u001a\u0004\bR\u0010 \"\u0004\bS\u00105R\"\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00102\u001a\u0004\bU\u0010 \"\u0004\bV\u00105R\"\u0010Y\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\bQ\u0010 \"\u0004\bX\u00105R\"\u0010]\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010-\u001a\u0004\b[\u0010\"\"\u0004\b\\\u00100R\"\u0010a\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010-\u001a\u0004\b_\u0010\"\"\u0004\b`\u00100R\"\u0010c\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b[\u00102\u001a\u0004\bM\u0010 \"\u0004\bb\u00105R\"\u0010h\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\\\u001a\u0004\b^\u0010e\"\u0004\bf\u0010gR\"\u0010j\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010\\\u001a\u0004\bZ\u0010e\"\u0004\bi\u0010gR\"\u0010n\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010O\u001a\u0004\b8\u0010k\"\u0004\bl\u0010mR\"\u0010p\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u00102\u001a\u0004\bJ\u0010 \"\u0004\bo\u00105R\"\u0010s\u001a\u00020d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\\\u001a\u0004\bq\u0010e\"\u0004\br\u0010gR\"\u0010t\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\bt\u0010 \"\u0004\bu\u00105R\u0016\u0010v\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010-R\u0016\u0010w\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010-R\u001e\u0010z\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010x8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010y¨\u0006{"}, d2 = {"Lx1/f1/lb/config/b;", "", "<init>", "()V", "Lr8/z;", "s", "Landroid/content/Context;", "appContext", "", "env", "applicationId", "", "isDebug", "authEndPoint", "adEndPoint", "channelEndPoint", "feedbackEndPoint", "upgradeEndPoint", "messageEndPoint", "metricEndPoint", "streamMediaEndPoint", "loggerEndPoint", "imgEndPoint", "clientSecret", "serverPublicKeyPem", "sportsEndPoint", "historyName", "favoritesName", "allName", "r", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "u", "()Z", "N", "()Ljava/lang/String;", "context", "b", "(Landroid/content/Context;)Ljava/lang/String;", "a", "()Landroid/content/Context;", "", "resId", "dft", "p", "(ILjava/lang/String;)Ljava/lang/String;", "Ljava/lang/String;", "g", "setEnv", "(Ljava/lang/String;)V", "c", "Z", "t", "setDebug", "(Z)V", "d", "setApplicationId", "e", "l", "F", "proxyType", "Lv6/d;", "f", "Lv6/d;", "q", "()Lv6/d;", "L", "(Lv6/d;)V", "tsPushMode", "Ljava/lang/Integer;", "k", "()Ljava/lang/Integer;", "D", "(Ljava/lang/Integer;)V", "maxDownloadingBlockCnt", "h", "z", "displayMemberSite", "i", "v", "I", "isReportMetric", "j", "x", "M", "isVerifyDistributionChannelBeforeUpgradeInstall", "w", "setSetCustomDensity", "isSetCustomDensity", "C", "hasSubject", "m", "o", "J", "shareAppInfo", "n", "getShareAppTip", "K", "shareAppTip", "B", "hasReferralSummary", "", "()J", "setRemindMillisSecondsBeforeTheProgrammeStart", "(J)V", "remindMillisSecondsBeforeTheProgrammeStart", "G", "refreshSportsEventInterval", "()I", "y", "(I)V", "catchupDvrDays", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "hasCatchup", "getMobileTabSwitchFilterMills", ExifInterface.LONGITUDE_EAST, "mobileTabSwitchFilterMills", "isRenewAutoRefresh", "H", "sysLang", "appLang", "Ljava/lang/ref/SoftReference;", "Ljava/lang/ref/SoftReference;", "appContextRef", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isDebug;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static Integer maxDownloadingBlockCnt;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private static boolean isReportMetric;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static boolean isVerifyDistributionChannelBeforeUpgradeInstall;

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isSetCustomDensity;

    /* JADX INFO: renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean hasSubject;

    /* JADX INFO: renamed from: o, reason: collision with root package name and from kotlin metadata */
    private static boolean hasReferralSummary;

    /* JADX INFO: renamed from: q, reason: collision with root package name and from kotlin metadata */
    private static long refreshSportsEventInterval;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    private static SoftReference<Context> appContextRef;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f20643a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static String env = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static String applicationId = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static String proxyType = "TS";

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static v6.d tsPushMode = v6.d.UDP;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean displayMemberSite = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static String shareAppInfo = "";

    /* JADX INFO: renamed from: n, reason: collision with root package name and from kotlin metadata */
    private static String shareAppTip = "";

    /* JADX INFO: renamed from: p, reason: collision with root package name and from kotlin metadata */
    private static long remindMillisSecondsBeforeTheProgrammeStart = FileWatchdog.DEFAULT_DELAY;

    /* JADX INFO: renamed from: r, reason: collision with root package name and from kotlin metadata */
    private static int catchupDvrDays = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    private static boolean hasCatchup = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    private static long mobileTabSwitchFilterMills = 3500;

    /* JADX INFO: renamed from: u, reason: collision with root package name and from kotlin metadata */
    private static boolean isRenewAutoRefresh = true;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    private static String sysLang = "en";

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    private static String appLang = "";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "x1.f1.lb.config.Config", f = "Config.kt", l = {SyslogAppender.LOG_LOCAL7, 284}, m = "init")
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
            return b.this.r(null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"x1/f1/lb/config/b$c", "Lx1/f1/lb/util/o0$a;", "", "byteArray", "", "a", "([B)Ljava/lang/String;", TypedValues.Custom.S_STRING, "b", "(Ljava/lang/String;)[B", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c implements o0.a {
        @Override // x1.f1.lb.util.o0.a
        public String a(byte[] byteArray) {
            String strEncodeToString = Base64.encodeToString(byteArray, 11);
            m.e(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        @Override // x1.f1.lb.util.o0.a
        public byte[] b(String string) {
            return Base64.decode(string, 11);
        }

        c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ \u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0096@¢\u0006\u0004\b\n\u0010\bJ \u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000f\u0010\u000eJ \u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0096@¢\u0006\u0004\b\u0013\u0010\u0012R\u001f\u0010\u0019\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"x1/f1/lb/config/b$d", "Lx1/f1/lb/util/w0$b;", "", "key", "", "int", "Lr8/z;", "a", "(Ljava/lang/String;ILv8/f;)Ljava/lang/Object;", "dft", "e", "", "long", "c", "(Ljava/lang/String;JLv8/f;)Ljava/lang/Object;", "b", TypedValues.Custom.S_STRING, "d", "(Ljava/lang/String;Ljava/lang/String;Lv8/f;)Ljava/lang/Object;", "f", "Lx1/f1/lb/util/n;", "kotlin.jvm.PlatformType", "Lx1/f1/lb/util/n;", "getHelper", "()Lx1/f1/lb/util/n;", "helper", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d implements w0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final n helper = n.n();

        @Override // x1.f1.lb.util.w0.b
        public Object a(String str, int i10, v8.f<? super z> fVar) {
            this.helper.q(str, i10);
            return z.f17874a;
        }

        @Override // x1.f1.lb.util.w0.b
        public Object b(String str, long j10, v8.f<? super Long> fVar) {
            return kotlin.coroutines.jvm.internal.b.c(this.helper.j(str, j10));
        }

        @Override // x1.f1.lb.util.w0.b
        public Object c(String str, long j10, v8.f<? super z> fVar) {
            this.helper.r(str, j10);
            return z.f17874a;
        }

        @Override // x1.f1.lb.util.w0.b
        public Object d(String str, String str2, v8.f<? super z> fVar) {
            this.helper.s(str, str2);
            return z.f17874a;
        }

        @Override // x1.f1.lb.util.w0.b
        public Object e(String str, int i10, v8.f<? super Integer> fVar) {
            return kotlin.coroutines.jvm.internal.b.b(this.helper.i(str, i10));
        }

        @Override // x1.f1.lb.util.w0.b
        public Object f(String str, String str2, v8.f<? super String> fVar) {
            String strM = this.helper.m(str, str2);
            m.e(strM, "getString(...)");
            return strM;
        }

        d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004¨\u0006\u0017"}, d2 = {"x1/f1/lb/config/b$e", "Lof/b;", "", "b", "()Ljava/lang/String;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "m", "(Ljava/lang/String;)Ljava/lang/String;", "", "a", "()I", "", "i", "()J", "d", "l", "e", "k", "j", "h", "f", "g", "c", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e implements of.b {
        @Override // of.b
        public int a() {
            return k.f21398a.q();
        }

        @Override // of.b
        public String b() {
            return x1.f1.lb.user.f.f21202a.B0();
        }

        @Override // of.b
        public String c() {
            return k.f21398a.r();
        }

        @Override // of.b
        public int d() {
            return k.f21398a.u();
        }

        @Override // of.b
        public String e() {
            return x1.f1.lb.util.z.f21470a.o();
        }

        @Override // of.b
        public String f() {
            return k.f21398a.v();
        }

        @Override // of.b
        public String g() {
            return x1.f1.lb.user.f.f21202a.A0();
        }

        @Override // of.b
        public int h() {
            return k.f21398a.y();
        }

        @Override // of.b
        public long i() {
            return k.f21398a.s();
        }

        @Override // of.b
        public String j() {
            return x1.f1.lb.util.z.f21470a.s();
        }

        @Override // of.b
        public String k() {
            return x1.f1.lb.user.f.f21202a.j0();
        }

        @Override // of.b
        public String l() {
            return b.c(b.f20643a, null, 1, null);
        }

        @Override // of.b
        public String m(String url) {
            m.f(url, "url");
            return x1.f1.lb.user.f.f21202a.g0(url);
        }

        e() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"x1/f1/lb/config/b$f", "Lx1/f1/lb/streaming/server/i$a;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f implements i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f20668a;

        f(Context context) {
            this.f20668a = context;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0007J'\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ!\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"x1/f1/lb/config/b$g", "Lq6/a;", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "Lr8/z;", "debug", "(Ljava/lang/String;Ljava/lang/String;)V", "", "throwable", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "g", "e", "c", "a", "b", "d", "stackTrace", "h", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "j", "(Ljava/lang/Throwable;)Ljava/lang/String;", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g implements q6.a {
        public static /* synthetic */ String i(g gVar, String str, String str2, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            return gVar.h(str, str2);
        }

        @Override // q6.a
        public void a(String tag, String msg, Throwable throwable) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            m.f(throwable, "throwable");
            String strJ = j(throwable);
            if (b.f20643a.t()) {
                Log.w(tag, h(msg, strJ));
            }
            x1.f1.lb.log.a.f20729a.h(ExifInterface.LONGITUDE_WEST, tag, msg, strJ);
        }

        @Override // q6.a
        public void b(String tag, String msg) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            if (b.f20643a.t()) {
                Log.e(tag, i(this, msg, null, 2, null));
            }
            x1.f1.lb.log.a.i(x1.f1.lb.log.a.f20729a, ExifInterface.LONGITUDE_EAST, tag, msg, null, 8, null);
        }

        @Override // q6.a
        public void c(String tag, String msg) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            if (b.f20643a.t()) {
                Log.w(tag, i(this, msg, null, 2, null));
            }
            x1.f1.lb.log.a.i(x1.f1.lb.log.a.f20729a, ExifInterface.LONGITUDE_WEST, tag, msg, null, 8, null);
        }

        @Override // q6.a
        public void d(String tag, String msg, Throwable throwable) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            m.f(throwable, "throwable");
            String strJ = j(throwable);
            if (b.f20643a.t()) {
                Log.e(tag, h(msg, strJ));
            }
            x1.f1.lb.log.a.f20729a.h(ExifInterface.LONGITUDE_EAST, tag, msg, strJ);
        }

        @Override // q6.a
        public void debug(String tag, String msg) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            if (b.f20643a.t()) {
                Log.d(tag, msg);
            }
        }

        @Override // q6.a
        public void e(String tag, String msg, Throwable throwable) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            m.f(throwable, "throwable");
            if (b.f20643a.t()) {
                Log.i(tag, h(msg, j(throwable)));
            }
            x1.f1.lb.log.a.f20729a.h("I", tag, msg, j(throwable));
        }

        @Override // q6.a
        public void f(String tag, String msg, Throwable throwable) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            m.f(throwable, "throwable");
            if (b.f20643a.t()) {
                Log.d(tag, msg, throwable);
            }
        }

        @Override // q6.a
        public void g(String tag, String msg) {
            m.f(tag, "tag");
            m.f(msg, "msg");
            if (b.f20643a.t()) {
                Log.i(tag, i(this, msg, null, 2, null));
            }
            x1.f1.lb.log.a.i(x1.f1.lb.log.a.f20729a, "I", tag, msg, null, 8, null);
        }

        public final String h(String msg, String stackTrace) {
            m.f(msg, "msg");
            if (stackTrace != null && stackTrace.length() != 0) {
                msg = msg + "\n" + stackTrace;
            }
            return b.f20643a.t() ? msg : x1.f1.lb.util.a.f21291a.c(msg, false);
        }

        public final String j(Throwable throwable) {
            if (throwable == null) {
                return null;
            }
            return cc.a.a(throwable);
        }

        g() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x024b  */
    /* JADX WARN: Code duplicated, block: B:44:0x025c  */
    /* JADX WARN: Code duplicated, block: B:47:0x026d  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object r(Context context, String str, String str2, boolean z10, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, v8.f<? super z> fVar) {
        a aVar;
        Object obj;
        Object obj2;
        a aVar2;
        String str19;
        String str20;
        String str21;
        Context context2;
        String str22;
        String string;
        String string2;
        String string3;
        Context context3;
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
        Object obj3 = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        if (i11 != 0) {
            if (i11 == 1) {
                String str23 = (String) aVar.L$4;
                String str24 = (String) aVar.L$3;
                str20 = (String) aVar.L$2;
                str19 = (String) aVar.L$1;
                context2 = (Context) aVar.L$0;
                r.b(obj3);
                obj = objC;
                str21 = str23;
                str22 = str24;
                aVar2 = aVar;
                obj2 = null;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                string2 = (String) aVar.L$3;
                string = (String) aVar.L$2;
                string3 = (String) aVar.L$1;
                context3 = (Context) aVar.L$0;
                r.b(obj3);
            }
            a1 a1Var = a1.f21305a;
            a1Var.f("0.3.App onCreate init App Attr");
            x1.f1.lb.streaming.client.a aVar3 = x1.f1.lb.streaming.client.a.f21004a;
            i iVar = i.f21095a;
            aVar3.s(iVar);
            iVar.n(new f(context3));
            x1.f1.lb.streaming.server.m.f21123a.c();
            a1Var.f("0.4.App onCreate start NIO Server");
            x1.f1.lb.streaming.client.d.f21015a.d(context3);
            a1Var.f("0.5.App onCreate init ssl client");
            x1.f1.lb.metric.monitor.f.f20907a.t();
            a1Var.f("0.6.App onCreate init play stat");
            x1.f1.lb.user.f fVar2 = x1.f1.lb.user.f.f21202a;
            File filesDir = context3.getFilesDir();
            m.e(filesDir, "getFilesDir(...)");
            fVar2.a1(filesDir);
            a1Var.f("0.7.App onCreate launch user");
            x1.f1.lb.media.a aVar4 = x1.f1.lb.media.a.f20755a;
            if (string2.length() == 0) {
                string2 = context3.getString(R$string.channel_column_all);
                m.e(string2, "getString(...)");
            }
            if (string3.length() == 0) {
                string3 = context3.getString(R$string.channel_column_history);
                m.e(string3, "getString(...)");
            }
            if (string.length() == 0) {
                string = context3.getString(R$string.channel_column_favorites);
                m.e(string, "getString(...)");
            }
            aVar4.F(string2, string3, string, "");
            a1Var.f("0.8.App onCreate launch channel");
            a1Var.f("0.9.App onCreate init eco mode");
            x1.f1.lb.heartbeat.f.f20678a.L0();
            return z.f17874a;
        }
        r.b(obj3);
        synchronized (this) {
            try {
                SoftReference<Context> softReference = appContextRef;
                if (m.a(context, softReference != null ? softReference.get() : null)) {
                    return z.f17874a;
                }
                appContextRef = new SoftReference<>(context);
                z zVar = z.f17874a;
                isDebug = z10;
                env = str;
                sysLang = N();
                appLang = b(context);
                applicationId = str2;
                lf.b.f15415a.f(str13, str14);
                d1.e(new C0412b());
                o0.f21433a.f(new c());
                a1 a1Var2 = a1.f21305a;
                a1Var2.f("0.App onCreate Begin@" + x1.f1.lb.user.f.f21202a.q0());
                a1Var2.f("0.1.App onCreate initLogger");
                s();
                Thread.setDefaultUncaughtExceptionHandler(new q0());
                b1 b1Var = b1.f21324a;
                File filesDir2 = context.getFilesDir();
                m.e(filesDir2, "getFilesDir(...)");
                b1Var.m(filesDir2);
                w0.f21452a.q(new d());
                x1.f1.lb.metric.monitor.a.f20887a.h();
                d0.f21360a.m();
                x1.f1.lb.media.d.f20812a.t(context);
                zf.f.m(context);
                x1.f1.lb.host.b bVar = x1.f1.lb.host.b.f20720a;
                String strK = b1Var.k();
                aVar.L$0 = context;
                aVar.L$1 = str11;
                aVar.L$2 = str16;
                aVar.L$3 = str17;
                aVar.L$4 = str18;
                aVar.label = 1;
                obj = objC;
                a aVar5 = aVar;
                obj2 = null;
                aVar2 = aVar5;
                if (bVar.g(strK, PointerIconCompat.TYPE_CONTEXT_MENU, str3, str4, str5, str6, str7, str8, str9, str10, str12, str15, aVar5) != obj) {
                    str19 = str11;
                    str20 = str16;
                    str21 = str18;
                    context2 = context;
                    str22 = str17;
                }
                return obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        of.a.f16585a.o(new e());
        x1.f1.lb.log.a.f20729a.m(new String[]{str19});
        x1.f1.lb.media.c.f20788a.E(new rf.a());
        s sVar = s.f21156a;
        b1 b1Var2 = b1.f21324a;
        sVar.i(b1Var2.s(), b1Var2.t(), PointerIconCompat.TYPE_CONTEXT_MENU, 524288000L, 1048576000L);
        x1.f1.lb.widget.videoview.g.f21577a.e(b1Var2.n(), PointerIconCompat.TYPE_CONTEXT_MENU, 163840L);
        x1.f1.lb.media.f.f20840a.a(b1Var2.u(), PointerIconCompat.TYPE_CONTEXT_MENU, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        q.f21130a.d(b1Var2.o(), PointerIconCompat.TYPE_CONTEXT_MENU, 102400L);
        x1.f1.lb.media.k.f20860a.b(b1Var2.r(), PointerIconCompat.TYPE_CONTEXT_MENU, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        j.f20845a.C(b1Var2.p(), PointerIconCompat.TYPE_CONTEXT_MENU);
        a1.f21305a.f("0.2.App onCreate init Buggly");
        k kVar = k.f21398a;
        aVar2.L$0 = context2;
        aVar2.L$1 = str20;
        aVar2.L$2 = str22;
        aVar2.L$3 = str21;
        aVar2.L$4 = obj2;
        aVar2.label = 2;
        if (kVar.w(context2, aVar2) != obj) {
            String str25 = str21;
            string = str22;
            string2 = str25;
            string3 = str20;
            context3 = context2;
            a1 a1Var3 = a1.f21305a;
            a1Var3.f("0.3.App onCreate init App Attr");
            x1.f1.lb.streaming.client.a aVar6 = x1.f1.lb.streaming.client.a.f21004a;
            i iVar2 = i.f21095a;
            aVar6.s(iVar2);
            iVar2.n(new f(context3));
            x1.f1.lb.streaming.server.m.f21123a.c();
            a1Var3.f("0.4.App onCreate start NIO Server");
            x1.f1.lb.streaming.client.d.f21015a.d(context3);
            a1Var3.f("0.5.App onCreate init ssl client");
            x1.f1.lb.metric.monitor.f.f20907a.t();
            a1Var3.f("0.6.App onCreate init play stat");
            x1.f1.lb.user.f fVar3 = x1.f1.lb.user.f.f21202a;
            File filesDir3 = context3.getFilesDir();
            m.e(filesDir3, "getFilesDir(...)");
            fVar3.a1(filesDir3);
            a1Var3.f("0.7.App onCreate launch user");
            x1.f1.lb.media.a aVar7 = x1.f1.lb.media.a.f20755a;
            if (string2.length() == 0) {
                string2 = context3.getString(R$string.channel_column_all);
                m.e(string2, "getString(...)");
            }
            if (string3.length() == 0) {
                string3 = context3.getString(R$string.channel_column_history);
                m.e(string3, "getString(...)");
            }
            if (string.length() == 0) {
                string = context3.getString(R$string.channel_column_favorites);
                m.e(string, "getString(...)");
            }
            aVar7.F(string2, string3, string, "");
            a1Var3.f("0.8.App onCreate launch channel");
            a1Var3.f("0.9.App onCreate init eco mode");
            x1.f1.lb.heartbeat.f.f20678a.L0();
            return z.f17874a;
        }
        return obj;
    }

    /* JADX INFO: renamed from: x1.f1.lb.config.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"x1/f1/lb/config/b$b", "Lx1/f1/lb/util/k0;", "", "b", "()J", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0412b implements k0 {
        C0412b() {
        }

        @Override // x1.f1.lb.util.k0
        public long b() {
            return SystemClock.elapsedRealtime();
        }
    }

    public static /* synthetic */ String c(b bVar, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = null;
        }
        return bVar.b(context);
    }

    private final void s() {
        q6.c.e(new g());
    }

    public final void A(boolean z10) {
        hasCatchup = z10;
    }

    public final void B(boolean z10) {
        hasReferralSummary = z10;
    }

    public final void C(boolean z10) {
        hasSubject = z10;
    }

    public final void D(Integer num) {
        maxDownloadingBlockCnt = num;
    }

    public final void E(long j10) {
        mobileTabSwitchFilterMills = j10;
    }

    public final void F(String str) {
        m.f(str, "<set-?>");
        proxyType = str;
    }

    public final void G(long j10) {
        refreshSportsEventInterval = j10;
    }

    public final void H(boolean z10) {
        isRenewAutoRefresh = z10;
    }

    public final void I(boolean z10) {
        isReportMetric = z10;
    }

    public final void J(String str) {
        m.f(str, "<set-?>");
        shareAppInfo = str;
    }

    public final void K(String str) {
        m.f(str, "<set-?>");
        shareAppTip = str;
    }

    public final void L(v6.d dVar) {
        tsPushMode = dVar;
    }

    public final void M(boolean z10) {
        isVerifyDistributionChannelBeforeUpgradeInstall = z10;
    }

    public final String N() {
        String language = (Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault()).getLanguage();
        sysLang = language;
        return language;
    }

    public final Context a() {
        SoftReference<Context> softReference = appContextRef;
        if (softReference != null) {
            return softReference.get();
        }
        return null;
    }

    public final String b(Context context) {
        if (context == null) {
            context = a();
        }
        if (context == null) {
            if (appLang.length() == 0) {
                appLang = N();
            }
            return appLang;
        }
        String strD = n0.f21425a.d(context);
        appLang = strD;
        return strD;
    }

    public final String d() {
        return applicationId;
    }

    public final int e() {
        return catchupDvrDays;
    }

    public final boolean f() {
        return displayMemberSite;
    }

    public final String g() {
        return env;
    }

    public final boolean h() {
        return hasCatchup;
    }

    public final boolean i() {
        return hasReferralSummary;
    }

    public final boolean j() {
        return hasSubject;
    }

    public final Integer k() {
        return maxDownloadingBlockCnt;
    }

    public final String l() {
        return proxyType;
    }

    public final long m() {
        return refreshSportsEventInterval;
    }

    public final long n() {
        return remindMillisSecondsBeforeTheProgrammeStart;
    }

    public final String o() {
        return shareAppInfo;
    }

    public final String p(@IntegerRes int resId, String dft) {
        Context context;
        String string;
        m.f(dft, "dft");
        SoftReference<Context> softReference = appContextRef;
        return (softReference == null || (context = softReference.get()) == null || (string = context.getString(resId)) == null) ? dft : string;
    }

    public final v6.d q() {
        return tsPushMode;
    }

    public final boolean t() {
        return isDebug;
    }

    public final boolean u() {
        String lowerCase = env.toLowerCase(Locale.ROOT);
        m.e(lowerCase, "toLowerCase(...)");
        return ua.n.I(lowerCase, "dev", false, 2, null);
    }

    public final boolean v() {
        return isReportMetric;
    }

    public final boolean w() {
        return isSetCustomDensity;
    }

    public final boolean x() {
        return isVerifyDistributionChannelBeforeUpgradeInstall;
    }

    public final void y(int i10) {
        catchupDvrDays = i10;
    }

    public final void z(boolean z10) {
        displayMemberSite = z10;
    }

    private b() {
    }
}
