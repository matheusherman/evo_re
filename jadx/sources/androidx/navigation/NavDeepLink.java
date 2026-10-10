package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.i;
import r8.j;
import r8.p;
import r8.v;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ua.l;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b)\u0018\u0000 \u007f2\u00020\u0001:\u0007\u0080\u0001\u007f\u0081\u0001\u0082\u0001B'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\tJ1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J7\u0010\u001f\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J5\u0010#\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002¢\u0006\u0004\b#\u0010$J5\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002¢\u0006\u0004\b&\u0010'JE\u0010,\u001a\u00020\u00132\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010(2\u0006\u0010+\u001a\u00020*2\u0006\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0002¢\u0006\u0004\b,\u0010-J1\u00101\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b1\u00102J3\u00103\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010\u00022\b\u00100\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0004\b3\u00102J\u000f\u00104\u001a\u00020\u000fH\u0002¢\u0006\u0004\b4\u00105J\u001b\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*06H\u0002¢\u0006\u0004\b7\u00108J#\u0010:\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u000109H\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u000fH\u0002¢\u0006\u0004\b<\u00105J\u0017\u0010>\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u0012H\u0000¢\u0006\u0004\b=\u0010\u0015J\u0017\u0010>\u001a\u00020\u00132\u0006\u0010@\u001a\u00020?H\u0000¢\u0006\u0004\b=\u0010AJ\u0017\u0010C\u001a\u00020B2\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\bC\u0010DJ/\u0010E\u001a\u0004\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020\u00122\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0007¢\u0006\u0004\bE\u0010FJ/\u0010H\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010\u00122\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cH\u0000¢\u0006\u0004\bG\u0010FJ\u0019\u0010L\u001a\u00020B2\b\u0010I\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\bJ\u0010KJ\u001a\u0010N\u001a\u00020\u00132\b\u0010M\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020BH\u0016¢\u0006\u0004\bP\u0010QR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010R\u001a\u0004\bS\u0010TR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010R\u001a\u0004\bU\u0010TR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010R\u001a\u0004\bV\u0010TR\u001a\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Y\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010RR\u001d\u0010_\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001b\u0010a\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b`\u0010\\\u001a\u0004\ba\u0010bR'\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020*068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010\\\u001a\u0004\bd\u00108R\u0016\u0010f\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR/\u0010j\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001098BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\\\u001a\u0004\bi\u0010;R!\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\\\u001a\u0004\bl\u0010mR\u001d\u0010q\u001a\u0004\u0018\u00010\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bo\u0010\\\u001a\u0004\bp\u0010TR\u001d\u0010t\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\br\u0010\\\u001a\u0004\bs\u0010^R\u0018\u0010u\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010RR\u001d\u0010x\u001a\u0004\u0018\u00010Z8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bv\u0010\\\u001a\u0004\bw\u0010^R*\u0010z\u001a\u00020\u00132\u0006\u0010y\u001a\u00020\u00138G@@X\u0086\u000e¢\u0006\u0012\n\u0004\bz\u0010g\u001a\u0004\bz\u0010b\"\u0004\b{\u0010|R\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b}\u0010m¨\u0006\u0083\u0001"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "", "uriPattern", "action", "mimeType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uri", "(Ljava/lang/String;)V", "", "args", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "uriRegex", "Lr8/z;", "buildRegex", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/StringBuilder;)V", "Landroid/net/Uri;", "", "matchUri", "(Landroid/net/Uri;)Z", "matchAction", "(Ljava/lang/String;)Z", "matchMimeType", TransactionPartnerType.FRAGMENT, "Landroid/os/Bundle;", "bundle", "", "Landroidx/navigation/NavArgument;", "arguments", "getMatchingUriFragment", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", "Ljava/util/regex/Matcher;", "matcher", "getMatchingPathArguments", "(Ljava/util/regex/Matcher;Landroid/os/Bundle;Ljava/util/Map;)Z", "deepLink", "getMatchingQueryArguments", "(Landroid/net/Uri;Landroid/os/Bundle;Ljava/util/Map;)Z", "", "inputParams", "Landroidx/navigation/NavDeepLink$ParamQuery;", "storedParam", "parseInputParams", "(Ljava/util/List;Landroidx/navigation/NavDeepLink$ParamQuery;Landroid/os/Bundle;Ljava/util/Map;)Z", "name", "value", "argument", "parseArgument", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "parseArgumentForRepeatedParam", "parsePath", "()V", "", "parseQuery", "()Ljava/util/Map;", "Lr8/p;", "parseFragment", "()Lr8/p;", "parseMime", "matches$navigation_common_release", "matches", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "", "getMimeTypeMatchRating", "(Ljava/lang/String;)I", "getMatchingArguments", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "getMatchingPathAndQueryArgs$navigation_common_release", "getMatchingPathAndQueryArgs", "requestedLink", "calculateMatchingPathSegments$navigation_common_release", "(Landroid/net/Uri;)I", "calculateMatchingPathSegments", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getUriPattern", "()Ljava/lang/String;", "getAction", "getMimeType", "pathArgs", "Ljava/util/List;", "pathRegex", "Ljava/util/regex/Pattern;", "pathPattern$delegate", "Lr8/i;", "getPathPattern", "()Ljava/util/regex/Pattern;", "pathPattern", "isParameterizedQuery$delegate", "isParameterizedQuery", "()Z", "queryArgsMap$delegate", "getQueryArgsMap", "queryArgsMap", "isSingleQueryParamValueOnly", "Z", "fragArgsAndRegex$delegate", "getFragArgsAndRegex", "fragArgsAndRegex", "fragArgs$delegate", "getFragArgs", "()Ljava/util/List;", "fragArgs", "fragRegex$delegate", "getFragRegex", "fragRegex", "fragPattern$delegate", "getFragPattern", "fragPattern", "mimeTypeRegex", "mimeTypePattern$delegate", "getMimeTypePattern", "mimeTypePattern", "<set-?>", "isExactDeepLink", "setExactDeepLink$navigation_common_release", "(Z)V", "getArgumentsNames$navigation_common_release", "argumentsNames", "Companion", "Builder", "MimeType", "ParamQuery", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NavDeepLink {
    private final String action;

    /* JADX INFO: renamed from: fragArgs$delegate, reason: from kotlin metadata */
    private final i fragArgs;

    /* JADX INFO: renamed from: fragArgsAndRegex$delegate, reason: from kotlin metadata */
    private final i fragArgsAndRegex;

    /* JADX INFO: renamed from: fragPattern$delegate, reason: from kotlin metadata */
    private final i fragPattern;

    /* JADX INFO: renamed from: fragRegex$delegate, reason: from kotlin metadata */
    private final i fragRegex;
    private boolean isExactDeepLink;

    /* JADX INFO: renamed from: isParameterizedQuery$delegate, reason: from kotlin metadata */
    private final i isParameterizedQuery;
    private boolean isSingleQueryParamValueOnly;
    private final String mimeType;

    /* JADX INFO: renamed from: mimeTypePattern$delegate, reason: from kotlin metadata */
    private final i mimeTypePattern;
    private String mimeTypeRegex;
    private final List<String> pathArgs;

    /* JADX INFO: renamed from: pathPattern$delegate, reason: from kotlin metadata */
    private final i pathPattern;
    private String pathRegex;

    /* JADX INFO: renamed from: queryArgsMap$delegate, reason: from kotlin metadata */
    private final i queryArgsMap;
    private final String uriPattern;
    private static final Companion Companion = new Companion(null);
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0017¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "()V", "action", "", "mimeType", "uriPattern", "build", "Landroidx/navigation/NavDeepLink;", "setAction", "setMimeType", "setUriPattern", "Companion", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private String action;
        private String mimeType;
        private String uriPattern;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0007J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder$Companion;", "", "()V", "fromAction", "Landroidx/navigation/NavDeepLink$Builder;", "action", "", "fromMimeType", "mimeType", "fromUriPattern", "uriPattern", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private Companion() {
            }

            public final Builder fromAction(String action) {
                m.f(action, "action");
                if (action.length() <= 0) {
                    throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
                }
                Builder builder = new Builder();
                builder.setAction(action);
                return builder;
            }

            public final Builder fromMimeType(String mimeType) {
                m.f(mimeType, "mimeType");
                Builder builder = new Builder();
                builder.setMimeType(mimeType);
                return builder;
            }

            public final Builder fromUriPattern(String uriPattern) {
                m.f(uriPattern, "uriPattern");
                Builder builder = new Builder();
                builder.setUriPattern(uriPattern);
                return builder;
            }
        }

        public static final Builder fromAction(String str) {
            return INSTANCE.fromAction(str);
        }

        public static final Builder fromMimeType(String str) {
            return INSTANCE.fromMimeType(str);
        }

        public static final Builder fromUriPattern(String str) {
            return INSTANCE.fromUriPattern(str);
        }

        public final NavDeepLink build() {
            return new NavDeepLink(this.uriPattern, this.action, this.mimeType);
        }

        public final Builder setAction(String action) {
            m.f(action, "action");
            if (action.length() <= 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
            this.action = action;
            return this;
        }

        public final Builder setMimeType(String mimeType) {
            m.f(mimeType, "mimeType");
            this.mimeType = mimeType;
            return this;
        }

        public final Builder setUriPattern(String uriPattern) {
            m.f(uriPattern, "uriPattern");
            this.uriPattern = uriPattern;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public Builder() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "()V", "FILL_IN_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "SCHEME_PATTERN", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0004¨\u0006\u000f"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "mimeType", "", "(Ljava/lang/String;)V", "subType", "getSubType", "()Ljava/lang/String;", "setSubType", IjkMediaMeta.IJKM_KEY_TYPE, "getType", "setType", "compareTo", "", TransactionPartnerType.OTHER, "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class MimeType implements Comparable<MimeType> {
        private String subType;
        private String type;

        public MimeType(String mimeType) {
            List listL;
            m.f(mimeType, "mimeType");
            List<String> listG = new l("/").g(mimeType, 0);
            if (listG.isEmpty()) {
                listL = r.l();
            } else {
                ListIterator<String> listIterator = listG.listIterator(listG.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        listL = r.K0(listG, listIterator.nextIndex() + 1);
                    }
                }
                listL = r.l();
            }
            this.type = (String) listL.get(0);
            this.subType = (String) listL.get(1);
        }

        @Override // java.lang.Comparable
        public int compareTo(MimeType other) {
            m.f(other, "other");
            int i10 = m.a(this.type, other.type) ? 2 : 0;
            return m.a(this.subType, other.subType) ? i10 + 1 : i10;
        }

        public final String getSubType() {
            return this.subType;
        }

        public final String getType() {
            return this.type;
        }

        public final void setSubType(String str) {
            m.f(str, "<set-?>");
            this.subType = str;
        }

        public final void setType(String str) {
            m.f(str, "<set-?>");
            this.type = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\bR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "<init>", "()V", "", "name", "Lr8/z;", "addArgumentName", "(Ljava/lang/String;)V", "", "index", "getArgumentName", "(I)Ljava/lang/String;", "size", "()I", "paramRegex", "Ljava/lang/String;", "getParamRegex", "()Ljava/lang/String;", "setParamRegex", "", "arguments", "Ljava/util/List;", "getArguments", "()Ljava/util/List;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    static final class ParamQuery {
        private final List<String> arguments = new ArrayList();
        private String paramRegex;

        public final void addArgumentName(String name) {
            m.f(name, "name");
            this.arguments.add(name);
        }

        public final String getArgumentName(int index) {
            return this.arguments.get(index);
        }

        public final List<String> getArguments() {
            return this.arguments;
        }

        public final String getParamRegex() {
            return this.paramRegex;
        }

        public final void setParamRegex(String str) {
            this.paramRegex = str;
        }

        public final int size() {
            return this.arguments.size();
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavDeepLink$isParameterizedQuery$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2 extends o implements c9.a<Boolean> {
        AnonymousClass2() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c9.a
        public final Boolean invoke() {
            return Boolean.valueOf((NavDeepLink.this.getUriPattern() == null || Uri.parse(NavDeepLink.this.getUriPattern()).getQuery() == null) ? false : true);
        }
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.uriPattern = str;
        this.action = str2;
        this.mimeType = str3;
        this.pathArgs = new ArrayList();
        this.pathPattern = j.a(new NavDeepLink$pathPattern$2(this));
        this.isParameterizedQuery = j.a(new AnonymousClass2());
        r8.m mVar = r8.m.NONE;
        this.queryArgsMap = j.b(mVar, new NavDeepLink$queryArgsMap$2(this));
        this.fragArgsAndRegex = j.b(mVar, new NavDeepLink$fragArgsAndRegex$2(this));
        this.fragArgs = j.b(mVar, new NavDeepLink$fragArgs$2(this));
        this.fragRegex = j.b(mVar, new NavDeepLink$fragRegex$2(this));
        this.fragPattern = j.a(new NavDeepLink$fragPattern$2(this));
        this.mimeTypePattern = j.a(new NavDeepLink$mimeTypePattern$2(this));
        parsePath();
        parseMime();
    }

    private final boolean matchAction(String action) {
        boolean z10 = action == null;
        String str = this.action;
        if (z10 == (str != null)) {
            return false;
        }
        return action == null || m.a(str, action);
    }

    private final boolean matchMimeType(String mimeType) {
        if ((mimeType == null) == (this.mimeType != null)) {
            return false;
        }
        if (mimeType != null) {
            Pattern mimeTypePattern = getMimeTypePattern();
            m.c(mimeTypePattern);
            if (!mimeTypePattern.matcher(mimeType).matches()) {
                return false;
            }
        }
        return true;
    }

    private final boolean matchUri(Uri uri) {
        if ((uri == null) == (getPathPattern() != null)) {
            return false;
        }
        if (uri != null) {
            Pattern pathPattern = getPathPattern();
            m.c(pathPattern);
            if (!pathPattern.matcher(uri.toString()).matches()) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object other) {
        if (other != null && (other instanceof NavDeepLink)) {
            NavDeepLink navDeepLink = (NavDeepLink) other;
            if (m.a(this.uriPattern, navDeepLink.uriPattern) && m.a(this.action, navDeepLink.action) && m.a(this.mimeType, navDeepLink.mimeType)) {
                return true;
            }
        }
        return false;
    }

    public final boolean matches$navigation_common_release(Uri uri) {
        m.f(uri, "uri");
        return matches$navigation_common_release(new NavDeepLinkRequest(uri, null, null));
    }

    private final void buildRegex(String uri, List<String> args, StringBuilder uriRegex) {
        Matcher matcher = FILL_IN_PATTERN.matcher(uri);
        int iEnd = 0;
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            m.d(strGroup, "null cannot be cast to non-null type kotlin.String");
            args.add(strGroup);
            if (matcher.start() > iEnd) {
                String strSubstring = uri.substring(iEnd, matcher.start());
                m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                uriRegex.append(Pattern.quote(strSubstring));
            }
            uriRegex.append("([^/]+?)");
            iEnd = matcher.end();
        }
        if (iEnd < uri.length()) {
            String strSubstring2 = uri.substring(iEnd);
            m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            uriRegex.append(Pattern.quote(strSubstring2));
        }
    }

    private final List<String> getFragArgs() {
        return (List) this.fragArgs.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p<List<String>, String> getFragArgsAndRegex() {
        return (p) this.fragArgsAndRegex.getValue();
    }

    private final Pattern getFragPattern() {
        return (Pattern) this.fragPattern.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getFragRegex() {
        return (String) this.fragRegex.getValue();
    }

    private final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map<String, NavArgument> arguments) {
        List<String> list = this.pathArgs;
        ArrayList arrayList = new ArrayList(r.w(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                r.v();
            }
            String str = (String) obj;
            String value = Uri.decode(matcher.group(i11));
            NavArgument navArgument = arguments.get(str);
            try {
                m.e(value, "value");
                if (parseArgument(bundle, str, value, navArgument)) {
                    return false;
                }
                arrayList.add(z.f17874a);
                i10 = i11;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    private final Pattern getMimeTypePattern() {
        return (Pattern) this.mimeTypePattern.getValue();
    }

    private final Pattern getPathPattern() {
        return (Pattern) this.pathPattern.getValue();
    }

    private final Map<String, ParamQuery> getQueryArgsMap() {
        return (Map) this.queryArgsMap.getValue();
    }

    private final boolean isParameterizedQuery() {
        return ((Boolean) this.isParameterizedQuery.getValue()).booleanValue();
    }

    private final boolean parseArgument(Bundle bundle, String name, String value, NavArgument argument) {
        if (argument != null) {
            argument.getType().parseAndPut(bundle, name, value);
            return false;
        }
        bundle.putString(name, value);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p<List<String>, String> parseFragment() {
        String str = this.uriPattern;
        if (str == null || Uri.parse(str).getFragment() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String fragment = Uri.parse(this.uriPattern).getFragment();
        StringBuilder sb2 = new StringBuilder();
        m.c(fragment);
        buildRegex(fragment, arrayList, sb2);
        String string = sb2.toString();
        m.e(string, "fragRegex.toString()");
        return v.a(arrayList, string);
    }

    private final boolean parseInputParams(List<String> inputParams, ParamQuery storedParam, Bundle bundle, Map<String, NavArgument> arguments) {
        if (inputParams == null) {
            return true;
        }
        for (String str : inputParams) {
            String paramRegex = storedParam.getParamRegex();
            Matcher matcher = paramRegex != null ? Pattern.compile(paramRegex, 32).matcher(str) : null;
            if (matcher == null || !matcher.matches()) {
                return false;
            }
            Bundle bundle2 = new Bundle();
            try {
                List<String> arguments2 = storedParam.getArguments();
                ArrayList arrayList = new ArrayList(r.w(arguments2, 10));
                int i10 = 0;
                for (Object obj : arguments2) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        r.v();
                    }
                    String str2 = (String) obj;
                    String strGroup = matcher.group(i11);
                    if (strGroup == null) {
                        strGroup = "";
                    } else {
                        m.e(strGroup, "argMatcher.group(index + 1) ?: \"\"");
                    }
                    NavArgument navArgument = arguments.get(str2);
                    if (parseArgumentForRepeatedParam(bundle, str2, strGroup, navArgument)) {
                        if (!m.a(strGroup, '{' + str2 + '}') && parseArgument(bundle2, str2, strGroup, navArgument)) {
                            return false;
                        }
                    }
                    arrayList.add(z.f17874a);
                    i10 = i11;
                }
                bundle.putAll(bundle2);
            } catch (IllegalArgumentException unused) {
            }
        }
        return true;
    }

    private final void parseMime() {
        if (this.mimeType == null) {
            return;
        }
        if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.mimeType).matches()) {
            throw new IllegalArgumentException(("The given mimeType " + this.mimeType + " does not match to required \"type/subtype\" format").toString());
        }
        MimeType mimeType = new MimeType(this.mimeType);
        this.mimeTypeRegex = n.E("^(" + mimeType.getType() + "|[*]+)/(" + mimeType.getSubType() + "|[*]+)$", "*|[*]", "[\\s\\S]", false, 4, null);
    }

    private final void parsePath() {
        if (this.uriPattern == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(this.uriPattern).find()) {
            sb2.append("http[s]?://");
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(this.uriPattern);
        matcher.find();
        boolean z10 = false;
        String strSubstring = this.uriPattern.substring(0, matcher.start());
        m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        buildRegex(strSubstring, this.pathArgs, sb2);
        if (!n.O(sb2, ".*", false, 2, null) && !n.O(sb2, "([^/]+?)", false, 2, null)) {
            z10 = true;
        }
        this.isExactDeepLink = z10;
        sb2.append("($|(\\?(.)*)|(\\#(.)*))");
        String string = sb2.toString();
        m.e(string, "uriRegex.toString()");
        this.pathRegex = n.E(string, ".*", "\\E.*\\Q", false, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, ParamQuery> parseQuery() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (isParameterizedQuery()) {
            Uri uri = Uri.parse(this.uriPattern);
            for (String paramName : uri.getQueryParameterNames()) {
                StringBuilder sb2 = new StringBuilder();
                List<String> queryParams = uri.getQueryParameters(paramName);
                if (queryParams.size() > 1) {
                    throw new IllegalArgumentException(("Query parameter " + paramName + " must only be present once in " + this.uriPattern + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                }
                m.e(queryParams, "queryParams");
                String queryParam = (String) r.i0(queryParams);
                if (queryParam == null) {
                    this.isSingleQueryParamValueOnly = true;
                    queryParam = paramName;
                }
                Matcher matcher = FILL_IN_PATTERN.matcher(queryParam);
                ParamQuery paramQuery = new ParamQuery();
                int iEnd = 0;
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    m.d(strGroup, "null cannot be cast to non-null type kotlin.String");
                    paramQuery.addArgumentName(strGroup);
                    m.e(queryParam, "queryParam");
                    String strSubstring = queryParam.substring(iEnd, matcher.start());
                    m.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    sb2.append(Pattern.quote(strSubstring));
                    sb2.append("(.+?)?");
                    iEnd = matcher.end();
                }
                if (iEnd < queryParam.length()) {
                    m.e(queryParam, "queryParam");
                    String strSubstring2 = queryParam.substring(iEnd);
                    m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    sb2.append(Pattern.quote(strSubstring2));
                }
                String string = sb2.toString();
                m.e(string, "argRegex.toString()");
                paramQuery.setParamRegex(n.E(string, ".*", "\\E.*\\Q", false, 4, null));
                m.e(paramName, "paramName");
                linkedHashMap.put(paramName, paramQuery);
            }
        }
        return linkedHashMap;
    }

    public final int calculateMatchingPathSegments$navigation_common_release(Uri requestedLink) {
        if (requestedLink == null || this.uriPattern == null) {
            return 0;
        }
        List<String> requestedPathSegments = requestedLink.getPathSegments();
        List<String> uriPathSegments = Uri.parse(this.uriPattern).getPathSegments();
        m.e(requestedPathSegments, "requestedPathSegments");
        m.e(uriPathSegments, "uriPathSegments");
        return r.m0(requestedPathSegments, uriPathSegments).size();
    }

    public final String getAction() {
        return this.action;
    }

    public final List<String> getArgumentsNames$navigation_common_release() {
        List<String> list = this.pathArgs;
        Collection<ParamQuery> collectionValues = getQueryArgsMap().values();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionValues.iterator();
        while (it.hasNext()) {
            r.C(arrayList, ((ParamQuery) it.next()).getArguments());
        }
        return r.B0(r.B0(list, arrayList), getFragArgs());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle getMatchingArguments(Uri deepLink, Map<String, NavArgument> arguments) {
        m.f(deepLink, "deepLink");
        m.f(arguments, "arguments");
        Pattern pathPattern = getPathPattern();
        Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
        if (matcher == null || !matcher.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (!getMatchingPathArguments(matcher, bundle, arguments)) {
            return null;
        }
        if (isParameterizedQuery() && !getMatchingQueryArguments(deepLink, bundle, arguments)) {
            return null;
        }
        getMatchingUriFragment(deepLink.getFragment(), bundle, arguments);
        if (NavArgumentKt.missingRequiredArguments(arguments, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle)).isEmpty()) {
            return bundle;
        }
        return null;
    }

    public final Bundle getMatchingPathAndQueryArgs$navigation_common_release(Uri deepLink, Map<String, NavArgument> arguments) {
        m.f(arguments, "arguments");
        Bundle bundle = new Bundle();
        if (deepLink != null) {
            Pattern pathPattern = getPathPattern();
            Matcher matcher = pathPattern != null ? pathPattern.matcher(deepLink.toString()) : null;
            if (matcher != null && matcher.matches()) {
                getMatchingPathArguments(matcher, bundle, arguments);
                if (isParameterizedQuery()) {
                    getMatchingQueryArguments(deepLink, bundle, arguments);
                }
            }
        }
        return bundle;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int getMimeTypeMatchRating(String mimeType) {
        m.f(mimeType, "mimeType");
        if (this.mimeType == null) {
            return -1;
        }
        Pattern mimeTypePattern = getMimeTypePattern();
        m.c(mimeTypePattern);
        if (mimeTypePattern.matcher(mimeType).matches()) {
            return new MimeType(this.mimeType).compareTo(new MimeType(mimeType));
        }
        return -1;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public int hashCode() {
        String str = this.uriPattern;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.action;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mimeType;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* JADX INFO: renamed from: isExactDeepLink, reason: from getter */
    public final boolean getIsExactDeepLink() {
        return this.isExactDeepLink;
    }

    public final boolean matches$navigation_common_release(NavDeepLinkRequest deepLinkRequest) {
        m.f(deepLinkRequest, "deepLinkRequest");
        if (matchUri(deepLinkRequest.getUri()) && matchAction(deepLinkRequest.getAction())) {
            return matchMimeType(deepLinkRequest.getMimeType());
        }
        return false;
    }

    public final void setExactDeepLink$navigation_common_release(boolean z10) {
        this.isExactDeepLink = z10;
    }

    private final boolean getMatchingQueryArguments(Uri deepLink, Bundle bundle, Map<String, NavArgument> arguments) {
        String query;
        for (Map.Entry<String, ParamQuery> entry : getQueryArgsMap().entrySet()) {
            String key = entry.getKey();
            ParamQuery value = entry.getValue();
            List<String> queryParameters = deepLink.getQueryParameters(key);
            if (this.isSingleQueryParamValueOnly && (query = deepLink.getQuery()) != null && !m.a(query, deepLink.toString())) {
                queryParameters = r.e(query);
            }
            if (!parseInputParams(queryParameters, value, bundle, arguments)) {
                return false;
            }
        }
        return true;
    }

    private final void getMatchingUriFragment(String fragment, Bundle bundle, Map<String, NavArgument> arguments) {
        Matcher matcher;
        Pattern fragPattern = getFragPattern();
        if (fragPattern != null) {
            matcher = fragPattern.matcher(String.valueOf(fragment));
        } else {
            matcher = null;
        }
        if (matcher != null && matcher.matches()) {
            List<String> fragArgs = getFragArgs();
            ArrayList arrayList = new ArrayList(r.w(fragArgs, 10));
            int i10 = 0;
            for (Object obj : fragArgs) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    r.v();
                }
                String str = (String) obj;
                String value = Uri.decode(matcher.group(i11));
                NavArgument navArgument = arguments.get(str);
                try {
                    m.e(value, "value");
                    if (!parseArgument(bundle, str, value, navArgument)) {
                        arrayList.add(z.f17874a);
                        i10 = i11;
                    } else {
                        return;
                    }
                } catch (IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    private final boolean parseArgumentForRepeatedParam(Bundle bundle, String name, String value, NavArgument argument) {
        if (!bundle.containsKey(name)) {
            return true;
        }
        if (argument != null) {
            NavType<Object> type = argument.getType();
            type.parseAndPut(bundle, name, value, type.get(bundle, name));
            return false;
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavDeepLink(String uri) {
        this(uri, null, null);
        m.f(uri, "uri");
    }
}
