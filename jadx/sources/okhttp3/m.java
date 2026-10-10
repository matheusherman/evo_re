package okhttp3;

import androidx.core.location.LocationRequestCompat;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001a\u0018\u0000 !2\u00020\u0001:\u0002\u001f\"BQ\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\tH\u0000¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\u001bR\u0017\u0010\n\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b&\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b/\u0010-R\u0017\u0010\f\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R\u0017\u0010\r\u001a\u00020\t8\u0007¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b.\u0010-¨\u00061"}, d2 = {"Lokhttp3/m;", "", "", "name", "value", "", "expiresAt", "domain", "path", "", "secure", "httpOnly", "persistent", "hostOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "i", "(Lokhttp3/v;)Z", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "forObsoleteRfc2965", "n", "(Z)Ljava/lang/String;", "a", "Ljava/lang/String;", "j", "b", "o", "c", "J", "f", "()J", "d", "e", "k", "Z", "m", "()Z", "g", "h", "l", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Pattern f16909k = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Pattern f16910l = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Pattern f16911m = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Pattern f16912n = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String name;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String value;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long expiresAt;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String domain;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String path;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean secure;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean httpOnly;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final boolean persistent;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean hostOnly;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\fJ\u0015\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\fJ\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\fJ\r\u0010\u0017\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001dR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001dR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001f¨\u0006#"}, d2 = {"Lokhttp3/m$a;", "", "<init>", "()V", "", "domain", "", "hostOnly", "c", "(Ljava/lang/String;Z)Lokhttp3/m$a;", "name", "g", "(Ljava/lang/String;)Lokhttp3/m$a;", "value", "j", "", "expiresAt", "d", "(J)Lokhttp3/m$a;", "b", "e", "path", "h", "i", "()Lokhttp3/m$a;", "f", "Lokhttp3/m;", "a", "()Lokhttp3/m;", "Ljava/lang/String;", "J", "Z", "secure", "httpOnly", "persistent", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String name;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String value;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String domain;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean secure;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean httpOnly;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean persistent;

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        private boolean hostOnly;

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long expiresAt = 253402300799999L;

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private String path = "/";

        public final a f() {
            this.httpOnly = true;
            return this;
        }

        public final a i() {
            this.secure = true;
            return this;
        }

        public final m a() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j10 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new m(str, str2, j10, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final a b(String domain) {
            kotlin.jvm.internal.m.f(domain, "domain");
            return c(domain, false);
        }

        public final a d(long expiresAt) {
            if (expiresAt <= 0) {
                expiresAt = Long.MIN_VALUE;
            }
            if (expiresAt > 253402300799999L) {
                expiresAt = 253402300799999L;
            }
            this.expiresAt = expiresAt;
            this.persistent = true;
            return this;
        }

        public final a e(String domain) {
            kotlin.jvm.internal.m.f(domain, "domain");
            return c(domain, true);
        }

        public final a g(String name) {
            kotlin.jvm.internal.m.f(name, "name");
            if (!kotlin.jvm.internal.m.a(ua.n.Q0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = name;
            return this;
        }

        public final a h(String path) {
            kotlin.jvm.internal.m.f(path, "path");
            if (!ua.n.I(path, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = path;
            return this;
        }

        public final a j(String value) {
            kotlin.jvm.internal.m.f(value, "value");
            if (!kotlin.jvm.internal.m.a(ua.n.Q0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = value;
            return this;
        }

        private final a c(String domain, boolean hostOnly) {
            String strE = hb.a.e(domain);
            if (strE != null) {
                this.domain = strE;
                this.hostOnly = hostOnly;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + domain);
        }
    }

    /* JADX INFO: renamed from: okhttp3.m$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007¢\u0006\u0004\b \u0010!J)\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u0004H\u0000¢\u0006\u0004\b#\u0010$J%\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0'2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0007¢\u0006\u0004\b(\u0010)R\u001c\u0010,\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001c\u0010.\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010-R\u001c\u0010/\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010-R\u001c\u00100\u001a\n +*\u0004\u0018\u00010*0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010-¨\u00061"}, d2 = {"Lokhttp3/m$b;", "", "<init>", "()V", "", "urlHost", "domain", "", "d", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lokhttp3/v;", IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "path", "k", "(Lokhttp3/v;Ljava/lang/String;)Z", "s", "", "pos", "limit", "", "i", "(Ljava/lang/String;II)J", "input", "invert", "c", "(Ljava/lang/String;IIZ)I", "j", "(Ljava/lang/String;)J", "h", "(Ljava/lang/String;)Ljava/lang/String;", "setCookie", "Lokhttp3/m;", "e", "(Lokhttp3/v;Ljava/lang/String;)Lokhttp3/m;", "currentTimeMillis", "f", "(JLokhttp3/v;Ljava/lang/String;)Lokhttp3/m;", "Lokhttp3/u;", "headers", "", "g", "(Lokhttp3/v;Lokhttp3/u;)Ljava/util/List;", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final String h(String s10) {
            if (ua.n.v(s10, ".", false, 2, null)) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            String strE = hb.a.e(ua.n.s0(s10, "."));
            if (strE != null) {
                return strE;
            }
            throw new IllegalArgumentException();
        }

        private Companion() {
        }

        private final int c(String input, int pos, int limit, boolean invert) {
            while (pos < limit) {
                char cCharAt = input.charAt(pos);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!invert)) {
                    return pos;
                }
                pos++;
            }
            return limit;
        }

        private final long i(String s10, int pos, int limit) {
            int iC = c(s10, pos, limit, false);
            Matcher matcher = m.f16912n.matcher(s10);
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int iB0 = -1;
            int i13 = -1;
            int i14 = -1;
            while (iC < limit) {
                int iC2 = c(s10, iC + 1, limit, true);
                matcher.region(iC, iC2);
                if (i11 == -1 && matcher.usePattern(m.f16912n).matches()) {
                    String strGroup = matcher.group(1);
                    kotlin.jvm.internal.m.e(strGroup, "matcher.group(1)");
                    i11 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    kotlin.jvm.internal.m.e(strGroup2, "matcher.group(2)");
                    i13 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    kotlin.jvm.internal.m.e(strGroup3, "matcher.group(3)");
                    i14 = Integer.parseInt(strGroup3);
                } else if (i12 == -1 && matcher.usePattern(m.f16911m).matches()) {
                    String strGroup4 = matcher.group(1);
                    kotlin.jvm.internal.m.e(strGroup4, "matcher.group(1)");
                    i12 = Integer.parseInt(strGroup4);
                } else if (iB0 == -1 && matcher.usePattern(m.f16910l).matches()) {
                    String strGroup5 = matcher.group(1);
                    kotlin.jvm.internal.m.e(strGroup5, "matcher.group(1)");
                    Locale US = Locale.US;
                    kotlin.jvm.internal.m.e(US, "US");
                    String lowerCase = strGroup5.toLowerCase(US);
                    kotlin.jvm.internal.m.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = m.f16910l.pattern();
                    kotlin.jvm.internal.m.e(strPattern, "MONTH_PATTERN.pattern()");
                    iB0 = ua.n.b0(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i10 == -1 && matcher.usePattern(m.f16909k).matches()) {
                    String strGroup6 = matcher.group(1);
                    kotlin.jvm.internal.m.e(strGroup6, "matcher.group(1)");
                    i10 = Integer.parseInt(strGroup6);
                }
                iC = c(s10, iC2 + 1, limit, false);
            }
            if (70 <= i10 && i10 < 100) {
                i10 += 1900;
            }
            if (i10 >= 0 && i10 < 70) {
                i10 += 2000;
            }
            if (i10 < 1601) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (iB0 == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (1 > i12 || i12 >= 32) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i11 < 0 || i11 >= 24) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i13 < 0 || i13 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (i14 < 0 || i14 >= 60) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(hb.d.f10918f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i10);
            gregorianCalendar.set(2, iB0 - 1);
            gregorianCalendar.set(5, i12);
            gregorianCalendar.set(11, i11);
            gregorianCalendar.set(12, i13);
            gregorianCalendar.set(13, i14);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long j(String s10) {
            try {
                long j10 = Long.parseLong(s10);
                if (j10 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j10;
            } catch (NumberFormatException e10) {
                if (!new ua.l("-?\\d+").d(s10)) {
                    throw e10;
                }
                if (ua.n.I(s10, "-", false, 2, null)) {
                    return Long.MIN_VALUE;
                }
                return LocationRequestCompat.PASSIVE_INTERVAL;
            }
        }

        public final m e(v url, String setCookie) {
            kotlin.jvm.internal.m.f(url, "url");
            kotlin.jvm.internal.m.f(setCookie, "setCookie");
            return f(System.currentTimeMillis(), url, setCookie);
        }

        public final m f(long currentTimeMillis, v url, String setCookie) {
            long j10;
            kotlin.jvm.internal.m.f(url, "url");
            kotlin.jvm.internal.m.f(setCookie, "setCookie");
            int iR = hb.d.r(setCookie, ';', 0, 0, 6, null);
            int iR2 = hb.d.r(setCookie, '=', 0, iR, 2, null);
            m mVar = null;
            if (iR2 == iR) {
                return null;
            }
            String strX = hb.d.X(setCookie, 0, iR2, 1, null);
            if (strX.length() == 0 || hb.d.y(strX) != -1) {
                return null;
            }
            String strW = hb.d.W(setCookie, iR2 + 1, iR);
            if (hb.d.y(strW) != -1) {
                return null;
            }
            int i10 = iR + 1;
            int length = setCookie.length();
            String strH = null;
            String str = null;
            long j11 = -1;
            boolean z10 = false;
            boolean z11 = true;
            boolean z12 = false;
            long jI = 253402300799999L;
            boolean z13 = false;
            while (i10 < length) {
                int iP = hb.d.p(setCookie, ';', i10, length);
                int iP2 = hb.d.p(setCookie, '=', i10, iP);
                String strW2 = hb.d.W(setCookie, i10, iP2);
                String strW3 = iP2 < iP ? hb.d.W(setCookie, iP2 + 1, iP) : "";
                m mVar2 = mVar;
                if (ua.n.w(strW2, "expires", true)) {
                    try {
                        jI = i(strW3, 0, strW3.length());
                        z12 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (ua.n.w(strW2, "max-age", true)) {
                    j11 = j(strW3);
                    z12 = true;
                } else if (ua.n.w(strW2, "domain", true)) {
                    strH = h(strW3);
                    z11 = false;
                } else if (ua.n.w(strW2, "path", true)) {
                    str = strW3;
                } else if (ua.n.w(strW2, "secure", true)) {
                    z13 = true;
                } else if (ua.n.w(strW2, "httponly", true)) {
                    z10 = true;
                }
                i10 = iP + 1;
                mVar = mVar2;
            }
            m mVar3 = mVar;
            if (j11 == Long.MIN_VALUE) {
                j10 = Long.MIN_VALUE;
            } else if (j11 != -1) {
                long j12 = currentTimeMillis + (j11 <= 9223372036854775L ? j11 * ((long) 1000) : LocationRequestCompat.PASSIVE_INTERVAL);
                j10 = (j12 < currentTimeMillis || j12 > 253402300799999L) ? 253402300799999L : j12;
            } else {
                j10 = jI;
            }
            String strI = url.getHost();
            if (strH == null) {
                strH = strI;
            } else if (!d(strI, strH)) {
                return mVar3;
            }
            if (strI.length() != strH.length() && PublicSuffixDatabase.INSTANCE.c().c(strH) == null) {
                return mVar3;
            }
            String strSubstring = "/";
            if (str == null || !ua.n.I(str, "/", false, 2, mVar3)) {
                String strD = url.d();
                int iG0 = ua.n.g0(strD, '/', 0, false, 6, null);
                if (iG0 != 0) {
                    strSubstring = strD.substring(0, iG0);
                    kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                }
                str = strSubstring;
            }
            return new m(strX, strW, j10, strH, str, z13, z10, z12, z11, null);
        }

        public final List<m> g(v url, u headers) {
            kotlin.jvm.internal.m.f(url, "url");
            kotlin.jvm.internal.m.f(headers, "headers");
            List<String> listM = headers.m("Set-Cookie");
            int size = listM.size();
            ArrayList arrayList = null;
            for (int i10 = 0; i10 < size; i10++) {
                m mVarE = e(url, listM.get(i10));
                if (mVarE != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(mVarE);
                }
            }
            if (arrayList == null) {
                return kotlin.collections.r.l();
            }
            List<m> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            kotlin.jvm.internal.m.e(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(String urlHost, String domain) {
            if (kotlin.jvm.internal.m.a(urlHost, domain)) {
                return true;
            }
            if (ua.n.v(urlHost, domain, false, 2, null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !hb.d.i(urlHost)) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean k(v url, String path) {
            String strD = url.d();
            if (kotlin.jvm.internal.m.a(strD, path)) {
                return true;
            }
            if (ua.n.I(strD, path, false, 2, null) && (ua.n.v(path, "/", false, 2, null) || strD.charAt(path.length()) == '/')) {
                return true;
            }
            return false;
        }
    }

    public /* synthetic */ m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13, kotlin.jvm.internal.g gVar) {
        this(str, str2, j10, str3, str4, z10, z11, z12, z13);
    }

    public String toString() {
        return n(false);
    }

    private m(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.persistent = z12;
        this.hostOnly = z13;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getDomain() {
        return this.domain;
    }

    public boolean equals(Object other) {
        if (!(other instanceof m)) {
            return false;
        }
        m mVar = (m) other;
        return kotlin.jvm.internal.m.a(mVar.name, this.name) && kotlin.jvm.internal.m.a(mVar.value, this.value) && mVar.expiresAt == this.expiresAt && kotlin.jvm.internal.m.a(mVar.domain, this.domain) && kotlin.jvm.internal.m.a(mVar.path, this.path) && mVar.secure == this.secure && mVar.httpOnly == this.httpOnly && mVar.persistent == this.persistent && mVar.hostOnly == this.hostOnly;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getExpiresAt() {
        return this.expiresAt;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getHostOnly() {
        return this.hostOnly;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + androidx.collection.a.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + androidx.paging.a.a(this.secure)) * 31) + androidx.paging.a.a(this.httpOnly)) * 31) + androidx.paging.a.a(this.persistent)) * 31) + androidx.paging.a.a(this.hostOnly);
    }

    public final boolean i(v url) {
        kotlin.jvm.internal.m.f(url, "url");
        if ((this.hostOnly ? kotlin.jvm.internal.m.a(url.getHost(), this.domain) : INSTANCE.d(url.getHost(), this.domain)) && INSTANCE.k(url, this.path)) {
            return !this.secure || url.getIsHttps();
        }
        return false;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final boolean getPersistent() {
        return this.persistent;
    }

    /* JADX INFO: renamed from: m, reason: from getter */
    public final boolean getSecure() {
        return this.secure;
    }

    public final String n(boolean forObsoleteRfc2965) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(lb.c.b(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (forObsoleteRfc2965) {
                sb2.append(".");
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "toString()");
        return string;
    }

    /* JADX INFO: renamed from: o, reason: from getter */
    public final String getValue() {
        return this.value;
    }
}
