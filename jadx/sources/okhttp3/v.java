package okhttp3;

import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.v0;
import org.apache.log4j.net.SyslogAppender;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\"\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0002*-Bc\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0007H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b)\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b-\u0010+\u001a\u0004\b\u0004\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b.\u0010+\u001a\u0004\b\u0005\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u0010(R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001e\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00105R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b9\u0010+\u001a\u0004\b\f\u0010\u001aR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010+R\u0017\u0010=\u001a\u00020$8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b:\u0010<R\u0011\u0010>\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b8\u0010\u001aR\u0011\u0010?\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b.\u0010\u001aR\u0011\u0010@\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b/\u0010\u001aR\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020\t8G¢\u0006\u0006\u001a\u0004\b1\u00107R\u0013\u0010B\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b4\u0010\u001aR\u0013\u0010D\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\bC\u0010\u001aR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020E8G¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0013\u0010I\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b-\u0010\u001a¨\u0006J"}, d2 = {"Lokhttp3/v;", "", "", "scheme", "username", "password", "host", "", IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, "", "pathSegments", "queryNamesAndValues", TransactionPartnerType.FRAGMENT, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "v", "()Ljava/net/URL;", "Ljava/net/URI;", "u", "()Ljava/net/URI;", "name", "p", "(Ljava/lang/String;)Ljava/lang/String;", "r", "()Ljava/lang/String;", "link", "s", "(Ljava/lang/String;)Lokhttp3/v;", "Lokhttp3/v$a;", "k", "()Lokhttp3/v$a;", "l", "(Ljava/lang/String;)Lokhttp3/v$a;", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "a", "Ljava/lang/String;", "t", "b", "c", "d", "i", "e", "I", "n", "f", "Ljava/util/List;", "m", "()Ljava/util/List;", "g", "h", "j", "Z", "()Z", "isHttps", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", "o", "query", "", "q", "()Ljava/util/Set;", "queryParameterNames", "encodedFragment", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: k, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final char[] f16963l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String scheme;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String username;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String password;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String host;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int port;

    /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<String> pathSegments;

    /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final List<String> queryNamesAndValues;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final String fragment;

    /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String url;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final boolean isHttps;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010!\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0007¢\u0006\u0004\b\u001e\u0010\u001aJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0007¢\u0006\u0004\b \u0010\u001aJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010\u001aJ\u001f\u0010(\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b,\u0010)J\u000f\u0010-\u001a\u00020\u0000H\u0000¢\u0006\u0004\b-\u0010.J\r\u00100\u001a\u00020/¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\u0007H\u0016¢\u0006\u0004\b2\u00103J!\u00105\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010/2\u0006\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b5\u00106R$\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u00107\u001a\u0004\b8\u00103\"\u0004\b9\u0010:R\"\u0010=\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u00107\u001a\u0004\b;\u00103\"\u0004\b<\u0010:R\"\u0010@\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u00107\u001a\u0004\b>\u00103\"\u0004\b?\u0010:R$\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u00107\u001a\u0004\bA\u00103\"\u0004\bB\u0010:R\"\u0010!\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010C\u001a\u0004\bD\u0010\u0006\"\u0004\bE\u0010FR \u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070G8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\bH\u0010JR,\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010G8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010I\u001a\u0004\bL\u0010J\"\u0004\bM\u0010NR$\u0010R\u001a\u0004\u0018\u00010\u00078\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0014\u00107\u001a\u0004\bP\u00103\"\u0004\bQ\u0010:¨\u0006S"}, d2 = {"Lokhttp3/v$a;", "", "<init>", "()V", "", "d", "()I", "", "input", "startPos", "limit", "Lr8/z;", "p", "(Ljava/lang/String;II)V", "pos", "", "addTrailingSlash", "alreadyEncoded", "n", "(Ljava/lang/String;IIZZ)V", "h", "(Ljava/lang/String;)Z", "i", "l", "scheme", "q", "(Ljava/lang/String;)Lokhttp3/v$a;", "username", "x", "password", "k", "host", "g", IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT, "m", "(I)Lokhttp3/v$a;", "encodedQuery", "e", "name", "value", "b", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/v$a;", "encodedName", "encodedValue", "a", "o", "()Lokhttp3/v$a;", "Lokhttp3/v;", "c", "()Lokhttp3/v;", "toString", "()Ljava/lang/String;", "base", "j", "(Lokhttp3/v;Ljava/lang/String;)Lokhttp3/v$a;", "Ljava/lang/String;", "getScheme$okhttp", "w", "(Ljava/lang/String;)V", "getEncodedUsername$okhttp", "t", "encodedUsername", "getEncodedPassword$okhttp", "s", "encodedPassword", "getHost$okhttp", "u", "I", "getPort$okhttp", "v", "(I)V", "", "f", "Ljava/util/List;", "()Ljava/util/List;", "encodedPathSegments", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "getEncodedFragment$okhttp", "r", "encodedFragment", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        private String scheme;

        /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
        private String host;

        /* JADX INFO: renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final List<String> encodedPathSegments;

        /* JADX INFO: renamed from: g, reason: collision with root package name and from kotlin metadata */
        private List<String> encodedQueryNamesAndValues;

        /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
        private String encodedFragment;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        private String encodedUsername = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
        private String encodedPassword = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int port = -1;

        /* JADX INFO: renamed from: okhttp3.v$a$a, reason: collision with other inner class name and from kotlin metadata */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00048\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/v$a$a;", "", "<init>", "()V", "", "input", "", "pos", "limit", "g", "(Ljava/lang/String;II)I", "h", "f", "e", "INVALID_HOST", "Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int e(String input, int pos, int limit) {
                try {
                    int i10 = Integer.parseInt(Companion.b(v.INSTANCE, input, pos, limit, "", false, false, false, false, null, 248, null));
                    if (1 > i10 || i10 >= 65536) {
                        return -1;
                    }
                    return i10;
                } catch (NumberFormatException unused) {
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int h(String str, int i10, int i11) {
                int i12 = 0;
                while (i10 < i11) {
                    char cCharAt = str.charAt(i10);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i12++;
                    i10++;
                }
                return i12;
            }

            private Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int f(String input, int pos, int limit) {
                while (pos < limit) {
                    char cCharAt = input.charAt(pos);
                    if (cCharAt == '[') {
                        do {
                            pos++;
                            if (pos >= limit) {
                                break;
                            }
                        } while (input.charAt(pos) != ']');
                    } else if (cCharAt == ':') {
                        return pos;
                    }
                    pos++;
                }
                return limit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int g(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char cCharAt = input.charAt(pos);
                if ((kotlin.jvm.internal.m.h(cCharAt, 97) >= 0 && kotlin.jvm.internal.m.h(cCharAt, 122) <= 0) || (kotlin.jvm.internal.m.h(cCharAt, 65) >= 0 && kotlin.jvm.internal.m.h(cCharAt, 90) <= 0)) {
                    while (true) {
                        pos++;
                        if (pos >= limit) {
                            break;
                        }
                        char cCharAt2 = input.charAt(pos);
                        if ('a' > cCharAt2 || cCharAt2 >= '{') {
                            if ('A' > cCharAt2 || cCharAt2 >= '[') {
                                if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                    if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                        if (cCharAt2 == ':') {
                                            return pos;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return -1;
            }
        }

        public final a m(int port) {
            if (1 <= port && port < 65536) {
                this.port = port;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + port).toString());
        }

        private final int d() {
            int i10 = this.port;
            if (i10 != -1) {
                return i10;
            }
            Companion companion = v.INSTANCE;
            String str = this.scheme;
            kotlin.jvm.internal.m.c(str);
            return companion.c(str);
        }

        private final boolean h(String input) {
            return kotlin.jvm.internal.m.a(input, ".") || ua.n.w(input, "%2e", true);
        }

        private final boolean i(String input) {
            return kotlin.jvm.internal.m.a(input, "..") || ua.n.w(input, "%2e.", true) || ua.n.w(input, ".%2e", true) || ua.n.w(input, "%2e%2e", true);
        }

        private final void l() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void n(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String strB = Companion.b(v.INSTANCE, input, pos, limit, " \"<>^`{}|/\\?#", alreadyEncoded, false, false, false, null, 240, null);
            if (h(strB)) {
                return;
            }
            if (i(strB)) {
                l();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strB);
            } else {
                this.encodedPathSegments.add(strB);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add("");
            }
        }

        private final void p(String input, int startPos, int limit) {
            if (startPos == limit) {
                return;
            }
            char cCharAt = input.charAt(startPos);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                startPos++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i10 = startPos;
            while (i10 < limit) {
                int iQ = hb.d.q(input, "/\\", i10, limit);
                boolean z10 = iQ < limit;
                input = input;
                n(input, i10, iQ, z10, true);
                i10 = z10 ? iQ + 1 : iQ;
            }
        }

        public final a a(String encodedName, String encodedValue) {
            kotlin.jvm.internal.m.f(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.m.c(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.b(companion, encodedName, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.m.c(list2);
            list2.add(encodedValue != null ? Companion.b(companion, encodedValue, 0, 0, " \"'<>#&=", true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final a b(String name, String value) {
            kotlin.jvm.internal.m.f(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.m.c(list);
            Companion companion = v.INSTANCE;
            list.add(Companion.b(companion, name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.m.c(list2);
            list2.add(value != null ? Companion.b(companion, value, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final v c() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = v.INSTANCE;
            String strG = Companion.g(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strG2 = Companion.g(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iD = d();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(kotlin.collections.r.w(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.g(v.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                ArrayList arrayList3 = new ArrayList(kotlin.collections.r.w(list3, 10));
                for (String str3 : list3) {
                    arrayList3.add(str3 != null ? Companion.g(v.INSTANCE, str3, 0, 0, true, 3, null) : null);
                }
                arrayList = arrayList3;
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new v(str, strG, strG2, str2, iD, arrayList2, arrayList, str4 != null ? Companion.g(v.INSTANCE, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final a e(String encodedQuery) {
            Companion companion;
            String strB;
            this.encodedQueryNamesAndValues = (encodedQuery == null || (strB = Companion.b((companion = v.INSTANCE), encodedQuery, 0, 0, " \"'<>#", true, false, true, false, null, 211, null)) == null) ? null : companion.i(strB);
            return this;
        }

        public final List<String> f() {
            return this.encodedPathSegments;
        }

        public final a g(String host) {
            kotlin.jvm.internal.m.f(host, "host");
            String strE = hb.a.e(Companion.g(v.INSTANCE, host, 0, 0, false, 7, null));
            if (strE != null) {
                this.host = strE;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final a j(v base, String input) {
            String str;
            int iQ;
            int i10;
            int i11;
            int i12;
            char c10;
            int i13;
            String input2 = input;
            kotlin.jvm.internal.m.f(input2, "input");
            int iA = hb.d.A(input2, 0, 0, 3, null);
            int iC = hb.d.C(input2, iA, 0, 2, null);
            Companion companion = INSTANCE;
            int iG = companion.g(input2, iA, iC);
            String str2 = "this as java.lang.String…ing(startIndex, endIndex)";
            byte b10 = -1;
            if (iG != -1) {
                if (ua.n.F(input2, "https:", iA, true)) {
                    this.scheme = "https";
                    iA += 6;
                } else {
                    if (!ua.n.F(input2, "http:", iA, true)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input2.substring(0, iG);
                        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb2.append(strSubstring);
                        sb2.append('\'');
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = "http";
                    iA += 5;
                }
            } else {
                if (base == null) {
                    if (input2.length() > 6) {
                        str = ua.n.V0(input2, 6) + "...";
                    } else {
                        str = input2;
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str);
                }
                this.scheme = base.getScheme();
            }
            int iH = companion.h(input2, iA, iC);
            byte b11 = 63;
            byte b12 = 35;
            if (iH >= 2 || base == null || !kotlin.jvm.internal.m.a(base.getScheme(), this.scheme)) {
                int i14 = iA + iH;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    iQ = hb.d.q(input2, "@/\\?#", i14, iC);
                    byte bCharAt = iQ != iC ? input2.charAt(iQ) : (byte) -1;
                    if (bCharAt == b10 || bCharAt == b12 || bCharAt == 47 || bCharAt == 92 || bCharAt == b11) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z10) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            input2 = input;
                            i11 = iQ;
                            sb3.append(Companion.b(v.INSTANCE, input2, i14, iQ, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb3.toString();
                        } else {
                            int iP = hb.d.p(input2, ':', i14, iQ);
                            Companion companion2 = v.INSTANCE;
                            String strB = Companion.b(companion2, input2, i14, iP, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z11) {
                                strB = this.encodedUsername + "%40" + strB;
                            }
                            this.encodedUsername = strB;
                            if (iP != iQ) {
                                i12 = iQ;
                                this.encodedPassword = Companion.b(companion2, input, iP + 1, i12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z10 = true;
                            } else {
                                i12 = iQ;
                            }
                            input2 = input;
                            i11 = i12;
                            z11 = true;
                        }
                        i14 = i11 + 1;
                        iC = iC;
                        str2 = str2;
                        b11 = 63;
                        b10 = -1;
                        b12 = 35;
                    }
                }
                i10 = iC;
                String str3 = str2;
                Companion companion3 = INSTANCE;
                int iF = companion3.f(input2, i14, iQ);
                int i15 = iF + 1;
                if (i15 < iQ) {
                    this.host = hb.a.e(Companion.g(v.INSTANCE, input2, i14, iF, false, 4, null));
                    int iE = companion3.e(input2, i15, iQ);
                    this.port = iE;
                    if (iE == -1) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String strSubstring2 = input2.substring(i15, iQ);
                        kotlin.jvm.internal.m.e(strSubstring2, str3);
                        sb4.append(strSubstring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    Companion companion4 = v.INSTANCE;
                    this.host = hb.a.e(Companion.g(companion4, input2, i14, iF, false, 4, null));
                    String str4 = this.scheme;
                    kotlin.jvm.internal.m.c(str4);
                    this.port = companion4.c(str4);
                }
                if (this.host == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String strSubstring3 = input2.substring(i14, iF);
                    kotlin.jvm.internal.m.e(strSubstring3, str3);
                    sb5.append(strSubstring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                iA = iQ;
            } else {
                this.encodedUsername = base.g();
                this.encodedPassword = base.c();
                this.host = base.getHost();
                this.port = base.getPort();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.e());
                if (iA == iC || input2.charAt(iA) == '#') {
                    e(base.f());
                }
                i10 = iC;
            }
            int i16 = i10;
            int iQ2 = hb.d.q(input2, "?#", iA, i16);
            p(input2, iA, iQ2);
            if (iQ2 >= i16 || input2.charAt(iQ2) != '?') {
                c10 = '#';
                i13 = iQ2;
            } else {
                c10 = '#';
                int iP2 = hb.d.p(input2, '#', iQ2, i16);
                Companion companion5 = v.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.i(Companion.b(companion5, input2, iQ2 + 1, iP2, " \"'<>#", true, false, true, false, null, 208, null));
                i13 = iP2;
            }
            if (i13 < i16 && input2.charAt(i13) == c10) {
                this.encodedFragment = Companion.b(v.INSTANCE, input2, i13 + 1, i16, "", true, false, false, true, null, SyslogAppender.LOG_LOCAL6, null);
            }
            return this;
        }

        public final a k(String password) {
            kotlin.jvm.internal.m.f(password, "password");
            this.encodedPassword = Companion.b(v.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final a o() {
            String str = this.host;
            this.host = str != null ? new ua.l("[\"<>^`{|}]").f(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<String> list = this.encodedPathSegments;
                list.set(i10, Companion.b(v.INSTANCE, list.get(i10), 0, 0, "[]", true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str2 = list2.get(i11);
                    list2.set(i11, str2 != null ? Companion.b(v.INSTANCE, str2, 0, 0, "\\^`{|}", true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.b(v.INSTANCE, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final a q(String scheme) {
            kotlin.jvm.internal.m.f(scheme, "scheme");
            if (ua.n.w(scheme, "http", true)) {
                this.scheme = "http";
                return this;
            }
            if (ua.n.w(scheme, "https", true)) {
                this.scheme = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + scheme);
        }

        public final void r(String str) {
            this.encodedFragment = str;
        }

        public final void s(String str) {
            kotlin.jvm.internal.m.f(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final void t(String str) {
            kotlin.jvm.internal.m.f(str, "<set-?>");
            this.encodedUsername = str;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0085  */
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb2.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb2.append(':');
                    sb2.append(this.encodedPassword);
                }
                sb2.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                kotlin.jvm.internal.m.c(str2);
                if (ua.n.N(str2, ':', false, 2, null)) {
                    sb2.append('[');
                    sb2.append(this.host);
                    sb2.append(']');
                } else {
                    sb2.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iD = d();
                String str3 = this.scheme;
                if (str3 != null) {
                    Companion companion = v.INSTANCE;
                    kotlin.jvm.internal.m.c(str3);
                    if (iD != companion.c(str3)) {
                        sb2.append(':');
                        sb2.append(iD);
                    }
                } else {
                    sb2.append(':');
                    sb2.append(iD);
                }
            }
            Companion companion2 = v.INSTANCE;
            companion2.h(this.encodedPathSegments, sb2);
            if (this.encodedQueryNamesAndValues != null) {
                sb2.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                kotlin.jvm.internal.m.c(list);
                companion2.j(list, sb2);
            }
            if (this.encodedFragment != null) {
                sb2.append('#');
                sb2.append(this.encodedFragment);
            }
            String string = sb2.toString();
            kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final void u(String str) {
            this.host = str;
        }

        public final void v(int i10) {
            this.port = i10;
        }

        public final void w(String str) {
            this.scheme = str;
        }

        public final a x(String username) {
            kotlin.jvm.internal.m.f(username, "username");
            this.encodedUsername = Companion.b(v.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }
    }

    /* JADX INFO: renamed from: okhttp3.v$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0019\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u000f\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J]\u0010\u0018\u001a\u00020\f*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010!\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\u00050\u001d2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b!\u0010\"J'\u0010#\u001a\u00020\f*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001d2\n\u0010 \u001a\u00060\u001ej\u0002`\u001fH\u0000¢\u0006\u0004\b#\u0010\"J\u001b\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050$*\u00020\u0005H\u0000¢\u0006\u0004\b%\u0010&J\u0013\u0010(\u001a\u00020'*\u00020\u0005H\u0007¢\u0006\u0004\b(\u0010)J1\u0010*\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b*\u0010+Jc\u0010,\u001a\u00020\u0005*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b5\u0010/R\u0014\u00106\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b6\u0010/R\u0014\u00107\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b7\u0010/R\u0014\u00108\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u0010/R\u0014\u00109\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b9\u0010/R\u0014\u0010:\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u0010/R\u0014\u0010;\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u0010/R\u0014\u0010<\u001a\u00020\u00058\u0000X\u0080T¢\u0006\u0006\n\u0004\b<\u0010/¨\u0006="}, d2 = {"Lokhttp3/v$b;", "", "<init>", "()V", "Ltb/d;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lr8/z;", "l", "(Ltb/d;Ljava/lang/String;IIZ)V", "e", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "k", "(Ltb/d;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "c", "(Ljava/lang/String;)I", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "h", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "j", "", "i", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/v;", "d", "(Ljava/lang/String;)Lokhttp3/v;", "f", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "a", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String b(Companion companion, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 8) != 0) {
                z10 = false;
            }
            if ((i12 & 16) != 0) {
                z11 = false;
            }
            if ((i12 & 32) != 0) {
                z12 = false;
            }
            if ((i12 & 64) != 0) {
                z13 = false;
            }
            if ((i12 & 128) != 0) {
                charset = null;
            }
            return companion.a(str, i10, i11, str2, z10, z11, z12, z13, charset);
        }

        private final boolean e(String str, int i10, int i11) {
            int i12 = i10 + 2;
            return i12 < i11 && str.charAt(i10) == '%' && hb.d.H(str.charAt(i10 + 1)) != -1 && hb.d.H(str.charAt(i12)) != -1;
        }

        public static /* synthetic */ String g(Companion companion, String str, int i10, int i11, boolean z10, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = str.length();
            }
            if ((i12 & 4) != 0) {
                z10 = false;
            }
            return companion.f(str, i10, i11, z10);
        }

        private final void k(tb.d dVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            int iCharCount = i10;
            tb.d dVar2 = null;
            while (iCharCount < i11) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z10 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z12) {
                        dVar.T(z10 ? "+" : "%2B");
                    } else {
                        if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || z13)) {
                            if (!ua.n.N(str2, (char) iCodePointAt, false, 2, null) && (iCodePointAt != 37 || (z10 && (!z11 || e(str, iCharCount, i11))))) {
                                dVar.o0(iCodePointAt);
                            }
                        }
                        if (dVar2 == null) {
                            dVar2 = new tb.d();
                        }
                        if (charset == null || kotlin.jvm.internal.m.a(charset, StandardCharsets.UTF_8)) {
                            dVar2.o0(iCodePointAt);
                        } else {
                            dVar2.k0(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!dVar2.L()) {
                            byte b10 = dVar2.readByte();
                            dVar.writeByte(37);
                            dVar.writeByte(v.f16963l[((b10 & 255) >> 4) & 15]);
                            dVar.writeByte(v.f16963l[b10 & 15]);
                        }
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void l(tb.d dVar, String str, int i10, int i11, boolean z10) {
            int i12;
            while (i10 < i11) {
                int iCodePointAt = str.codePointAt(i10);
                if (iCodePointAt == 37 && (i12 = i10 + 2) < i11) {
                    int iH = hb.d.H(str.charAt(i10 + 1));
                    int iH2 = hb.d.H(str.charAt(i12));
                    if (iH == -1 || iH2 == -1) {
                        dVar.o0(iCodePointAt);
                        i10 += Character.charCount(iCodePointAt);
                    } else {
                        dVar.writeByte((iH << 4) + iH2);
                        i10 = Character.charCount(iCodePointAt) + i12;
                    }
                } else if (iCodePointAt == 43 && z10) {
                    dVar.writeByte(32);
                    i10++;
                } else {
                    dVar.o0(iCodePointAt);
                    i10 += Character.charCount(iCodePointAt);
                }
            }
        }

        public final String a(String str, int i10, int i11, String encodeSet, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
            kotlin.jvm.internal.m.f(str, "<this>");
            kotlin.jvm.internal.m.f(encodeSet, "encodeSet");
            int iCharCount = i10;
            while (iCharCount < i11) {
                int iCodePointAt = str.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z13) || ua.n.N(encodeSet, (char) iCodePointAt, false, 2, null) || ((iCodePointAt == 37 && (!z10 || (z11 && !e(str, iCharCount, i11)))) || (iCodePointAt == 43 && z12)))) {
                    tb.d dVar = new tb.d();
                    dVar.n0(str, i10, iCharCount);
                    k(dVar, str, iCharCount, i11, encodeSet, z10, z11, z12, z13, charset);
                    return dVar.v();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int c(String scheme) {
            kotlin.jvm.internal.m.f(scheme, "scheme");
            if (kotlin.jvm.internal.m.a(scheme, "http")) {
                return 80;
            }
            return kotlin.jvm.internal.m.a(scheme, "https") ? 443 : -1;
        }

        public final v d(String str) {
            kotlin.jvm.internal.m.f(str, "<this>");
            return new a().j(null, str).c();
        }

        public final String f(String str, int i10, int i11, boolean z10) {
            kotlin.jvm.internal.m.f(str, "<this>");
            for (int i12 = i10; i12 < i11; i12++) {
                char cCharAt = str.charAt(i12);
                if (cCharAt == '%' || (cCharAt == '+' && z10)) {
                    tb.d dVar = new tb.d();
                    dVar.n0(str, i10, i12);
                    l(dVar, str, i12, i11, z10);
                    return dVar.v();
                }
            }
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void h(List<String> list, StringBuilder out) {
            kotlin.jvm.internal.m.f(list, "<this>");
            kotlin.jvm.internal.m.f(out, "out");
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                out.append('/');
                out.append(list.get(i10));
            }
        }

        public final List<String> i(String str) {
            kotlin.jvm.internal.m.f(str, "<this>");
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                String str2 = str;
                int iA0 = ua.n.a0(str2, '&', i10, false, 4, null);
                if (iA0 == -1) {
                    iA0 = str2.length();
                }
                int iA1 = ua.n.a0(str2, '=', i10, false, 4, null);
                if (iA1 == -1 || iA1 > iA0) {
                    String strSubstring = str2.substring(i10, iA0);
                    kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str2.substring(i10, iA1);
                    kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str2.substring(iA1 + 1, iA0);
                    kotlin.jvm.internal.m.e(strSubstring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i10 = iA0 + 1;
                str = str2;
            }
            return arrayList;
        }

        public final void j(List<String> list, StringBuilder out) {
            kotlin.jvm.internal.m.f(list, "<this>");
            kotlin.jvm.internal.m.f(out, "out");
            h9.c cVarL = h9.f.l(h9.f.m(0, list.size()), 2);
            int first = cVarL.getFirst();
            int last = cVarL.getLast();
            int step = cVarL.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first += step;
                }
            }
        }
    }

    public v(String scheme, String username, String password, String host, int i10, List<String> pathSegments, List<String> list, String str, String url) {
        kotlin.jvm.internal.m.f(scheme, "scheme");
        kotlin.jvm.internal.m.f(username, "username");
        kotlin.jvm.internal.m.f(password, "password");
        kotlin.jvm.internal.m.f(host, "host");
        kotlin.jvm.internal.m.f(pathSegments, "pathSegments");
        kotlin.jvm.internal.m.f(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i10;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = kotlin.jvm.internal.m.a(scheme, "https");
    }

    public static final v h(String str) {
        return INSTANCE.d(str);
    }

    public final String b() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(ua.n.a0(this.url, '#', 0, false, 6, null) + 1);
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public final String c() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(ua.n.a0(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, ua.n.a0(this.url, '@', 0, false, 6, null));
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String d() {
        int iA0 = ua.n.a0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String strSubstring = this.url.substring(iA0, hb.d.q(str, "?#", iA0, str.length()));
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> e() {
        int iA0 = ua.n.a0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iQ = hb.d.q(str, "?#", iA0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iA0 < iQ) {
            int i10 = iA0 + 1;
            int iP = hb.d.p(this.url, '/', i10, iQ);
            String strSubstring = this.url.substring(i10, iP);
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iA0 = iP;
        }
        return arrayList;
    }

    public boolean equals(Object other) {
        return (other instanceof v) && kotlin.jvm.internal.m.a(((v) other).url, this.url);
    }

    public final String f() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iA0 = ua.n.a0(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iA0, hb.d.p(str, '#', iA0, str.length()));
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String g() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, hb.d.q(str, ":@", length, str.length()));
        kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    public final a k() {
        a aVar = new a();
        aVar.w(this.scheme);
        aVar.t(g());
        aVar.s(c());
        aVar.u(this.host);
        aVar.v(this.port != INSTANCE.c(this.scheme) ? this.port : -1);
        aVar.f().clear();
        aVar.f().addAll(e());
        aVar.e(f());
        aVar.r(b());
        return aVar;
    }

    public final a l(String link) {
        kotlin.jvm.internal.m.f(link, "link");
        try {
            return new a().j(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List<String> m() {
        return this.pathSegments;
    }

    /* JADX INFO: renamed from: n, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final String o() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        INSTANCE.j(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String p(String name) {
        kotlin.jvm.internal.m.f(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        h9.c cVarL = h9.f.l(h9.f.m(0, list.size()), 2);
        int first = cVarL.getFirst();
        int last = cVarL.getLast();
        int step = cVarL.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!kotlin.jvm.internal.m.a(name, this.queryNamesAndValues.get(first))) {
                if (first != last) {
                    first += step;
                }
            }
            return this.queryNamesAndValues.get(first + 1);
        }
        return null;
    }

    public final Set<String> q() {
        if (this.queryNamesAndValues == null) {
            return v0.e();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        h9.c cVarL = h9.f.l(h9.f.m(0, this.queryNamesAndValues.size()), 2);
        int first = cVarL.getFirst();
        int last = cVarL.getLast();
        int step = cVarL.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                String str = this.queryNamesAndValues.get(first);
                kotlin.jvm.internal.m.c(str);
                linkedHashSet.add(str);
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        kotlin.jvm.internal.m.e(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String r() {
        a aVarL = l("/...");
        kotlin.jvm.internal.m.c(aVarL);
        return aVarL.x("").k("").c().getUrl();
    }

    public final v s(String link) {
        kotlin.jvm.internal.m.f(link, "link");
        a aVarL = l(link);
        if (aVarL != null) {
            return aVarL.c();
        }
        return null;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    public final URL v() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    public final URI u() {
        String string = k().o().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new ua.l("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").f(string, ""));
                kotlin.jvm.internal.m.e(uriCreate, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }
}
