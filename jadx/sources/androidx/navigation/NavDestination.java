package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.RestrictTo;
import androidx.collection.SparseArrayCompat;
import androidx.collection.SparseArrayKt;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.i;
import kotlin.collections.n0;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;
import r8.z;
import ta.h;
import ta.k;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import ua.n;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000f\b\u0016\u0018\u0000 u2\u00020\u0001:\u0003vuwB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0004\u0010\bJ5\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001a\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010\u0005J\u0015\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\t¢\u0006\u0004\b \u0010\"J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010#\u001a\u00020\u0002H\u0007¢\u0006\u0004\b%\u0010&J\u0019\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010'\u001a\u00020\u001cH\u0017¢\u0006\u0004\b%\u0010(J\u001b\u0010+\u001a\u00020*2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0000H\u0007¢\u0006\u0004\b+\u0010,J!\u0010.\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0010H\u0017¢\u0006\u0004\b0\u00101J\u0019\u00105\u001a\u0004\u0018\u0001042\b\b\u0001\u00103\u001a\u000202¢\u0006\u0004\b5\u00106J!\u00109\u001a\u00020\u00172\b\b\u0001\u00107\u001a\u0002022\b\b\u0001\u00108\u001a\u000202¢\u0006\u0004\b9\u0010:J\u001f\u00109\u001a\u00020\u00172\b\b\u0001\u00107\u001a\u0002022\u0006\u0010;\u001a\u000204¢\u0006\u0004\b9\u0010<J\u0017\u0010=\u001a\u00020\u00172\b\b\u0001\u00107\u001a\u000202¢\u0006\u0004\b=\u0010>J\u001d\u0010A\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u00022\u0006\u0010@\u001a\u00020\u000e¢\u0006\u0004\bA\u0010BJ\u0015\u0010C\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0002¢\u0006\u0004\bC\u0010\u0005J\u001b\u0010E\u001a\u0004\u0018\u00010-2\b\u0010D\u001a\u0004\u0018\u00010-H\u0007¢\u0006\u0004\bE\u0010FJ!\u0010H\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010G\u001a\u0004\u0018\u00010-¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0002H\u0016¢\u0006\u0004\bJ\u0010KJ\u001a\u0010M\u001a\u00020\u00102\b\u0010L\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u000202H\u0016¢\u0006\u0004\bO\u0010PR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010Q\u001a\u0004\bR\u0010KR.\u0010U\u001a\u0004\u0018\u00010S2\b\u0010T\u001a\u0004\u0018\u00010S8\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010QR$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\t0c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u0002040f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR\"\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR,\u00103\u001a\u0002022\b\b\u0001\u00103\u001a\u0002028G@FX\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010l\u001a\u0004\bm\u0010P\"\u0004\bn\u0010>R.\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010Q\u001a\u0004\bo\u0010K\"\u0004\bp\u0010\u0005R\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0014\u0010t\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\bs\u0010K¨\u0006x"}, d2 = {"Landroidx/navigation/NavDestination;", "", "", "navigatorName", "<init>", "(Ljava/lang/String;)V", "Landroidx/navigation/Navigator;", "navigator", "(Landroidx/navigation/Navigator;)V", "Landroidx/navigation/NavDeepLink;", "deepLink", "Landroid/net/Uri;", "uri", "", "Landroidx/navigation/NavArgument;", "arguments", "", "hasRequiredArguments", "(Landroidx/navigation/NavDeepLink;Landroid/net/Uri;Ljava/util/Map;)Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lr8/z;", "onInflate", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasDeepLink", "(Landroid/net/Uri;)Z", "Landroidx/navigation/NavDeepLinkRequest;", "deepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Z", "uriPattern", "addDeepLink", "navDeepLink", "(Landroidx/navigation/NavDeepLink;)V", "route", "Landroidx/navigation/NavDestination$DeepLinkMatch;", "matchDeepLink", "(Ljava/lang/String;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "navDeepLinkRequest", "(Landroidx/navigation/NavDeepLinkRequest;)Landroidx/navigation/NavDestination$DeepLinkMatch;", "previousDestination", "", "buildDeepLinkIds", "(Landroidx/navigation/NavDestination;)[I", "Landroid/os/Bundle;", "hasRoute", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "supportsActions", "()Z", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Landroidx/navigation/NavAction;", "getAction", "(I)Landroidx/navigation/NavAction;", "actionId", "destId", "putAction", "(II)V", "action", "(ILandroidx/navigation/NavAction;)V", "removeAction", "(I)V", "argumentName", "argument", "addArgument", "(Ljava/lang/String;Landroidx/navigation/NavArgument;)V", "removeArgument", "args", "addInDefaultArgs", "(Landroid/os/Bundle;)Landroid/os/Bundle;", "bundle", "fillInLabel", "(Landroid/content/Context;Landroid/os/Bundle;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", TransactionPartnerType.OTHER, "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getNavigatorName", "Landroidx/navigation/NavGraph;", "<set-?>", "parent", "Landroidx/navigation/NavGraph;", "getParent", "()Landroidx/navigation/NavGraph;", "setParent", "(Landroidx/navigation/NavGraph;)V", "idName", "", "label", "Ljava/lang/CharSequence;", "getLabel", "()Ljava/lang/CharSequence;", "setLabel", "(Ljava/lang/CharSequence;)V", "", "deepLinks", "Ljava/util/List;", "Landroidx/collection/SparseArrayCompat;", "actions", "Landroidx/collection/SparseArrayCompat;", "", "_arguments", "Ljava/util/Map;", "I", "getId", "setId", "getRoute", "setRoute", "getArguments", "()Ljava/util/Map;", "getDisplayName", "displayName", "Companion", "ClassType", "DeepLinkMatch", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class NavDestination {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<?>> classes = new LinkedHashMap();
    private Map<String, NavArgument> _arguments;
    private final SparseArrayCompat<NavAction> actions;
    private final List<NavDeepLink> deepLinks;
    private int id;
    private String idName;
    private CharSequence label;
    private final String navigatorName;
    private NavGraph parent;
    private String route;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/navigation/NavDestination$ClassType;", "", "Li9/d;", "value", "<init>", "(Li9/d;)V", "()Ljava/lang/Class;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @Retention(RetentionPolicy.CLASS)
    public @interface ClassType {
        Class<?> value();
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\tH\u0005¢\u0006\u0004\b\u000b\u0010\fJA\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\t\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0010\u0010\n\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00018\u00000\tH\u0007¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u0016*\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/navigation/NavDestination$Companion;", "", "<init>", "()V", "C", "Landroid/content/Context;", "context", "", "name", "Ljava/lang/Class;", "expectedClassType", "parseClassFromName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Class;", "parseClassFromNameInternal", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "getDisplayName", "(Landroid/content/Context;I)Ljava/lang/String;", "route", "createRoute", "(Ljava/lang/String;)Ljava/lang/String;", "Landroidx/navigation/NavDestination;", "Lta/h;", "getHierarchy", "(Landroidx/navigation/NavDestination;)Lta/h;", "getHierarchy$annotations", "(Landroidx/navigation/NavDestination;)V", "hierarchy", "", "classes", "Ljava/util/Map;", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String createRoute(String route) {
            if (route == null) {
                return "";
            }
            return "android-app://androidx.navigation/" + route;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final String getDisplayName(Context context, int id2) {
            String strValueOf;
            m.f(context, "context");
            if (id2 <= 16777215) {
                return String.valueOf(id2);
            }
            try {
                strValueOf = context.getResources().getResourceName(id2);
            } catch (Resources.NotFoundException unused) {
                strValueOf = String.valueOf(id2);
            }
            m.e(strValueOf, "try {\n                co….toString()\n            }");
            return strValueOf;
        }

        public final h<NavDestination> getHierarchy(NavDestination navDestination) {
            m.f(navDestination, "<this>");
            return k.o(navDestination, NavDestination$Companion$hierarchy$1.INSTANCE);
        }

        protected final <C> Class<? extends C> parseClassFromName(Context context, String name, Class<? extends C> expectedClassType) {
            String str;
            m.f(context, "context");
            m.f(name, "name");
            m.f(expectedClassType, "expectedClassType");
            if (name.charAt(0) == '.') {
                str = context.getPackageName() + name;
            } else {
                str = name;
            }
            Class<? extends C> cls = (Class) NavDestination.classes.get(str);
            if (cls == null) {
                try {
                    cls = (Class<? extends C>) Class.forName(str, true, context.getClassLoader());
                    NavDestination.classes.put(name, cls);
                } catch (ClassNotFoundException e10) {
                    throw new IllegalArgumentException(e10);
                }
            }
            m.c(cls);
            if (expectedClassType.isAssignableFrom(cls)) {
                return cls;
            }
            throw new IllegalArgumentException((str + " must be a subclass of " + expectedClassType).toString());
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final <C> Class<? extends C> parseClassFromNameInternal(Context context, String name, Class<? extends C> expectedClassType) {
            m.f(context, "context");
            m.f(name, "name");
            m.f(expectedClassType, "expectedClassType");
            return NavDestination.parseClassFromName(context, name, expectedClassType);
        }

        public static /* synthetic */ void getHierarchy$annotations(NavDestination navDestination) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/navigation/NavDestination$DeepLinkMatch;", "", "destination", "Landroidx/navigation/NavDestination;", "matchingArgs", "Landroid/os/Bundle;", "isExactDeepLink", "", "matchingPathSegments", "", "hasMatchingAction", "mimeTypeMatchLevel", "(Landroidx/navigation/NavDestination;Landroid/os/Bundle;ZIZI)V", "getDestination", "()Landroidx/navigation/NavDestination;", "getMatchingArgs", "()Landroid/os/Bundle;", "compareTo", TransactionPartnerType.OTHER, "hasMatchingArgs", "arguments", "navigation-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class DeepLinkMatch implements Comparable<DeepLinkMatch> {
        private final NavDestination destination;
        private final boolean hasMatchingAction;
        private final boolean isExactDeepLink;
        private final Bundle matchingArgs;
        private final int matchingPathSegments;
        private final int mimeTypeMatchLevel;

        public final boolean hasMatchingArgs(Bundle arguments) {
            Bundle bundle;
            Object obj;
            if (arguments == null || (bundle = this.matchingArgs) == null) {
                return false;
            }
            Set<String> setKeySet = bundle.keySet();
            m.e(setKeySet, "matchingArgs.keySet()");
            for (String key : setKeySet) {
                if (!arguments.containsKey(key)) {
                    return false;
                }
                NavArgument navArgument = this.destination.getArguments().get(key);
                Object obj2 = null;
                NavType<Object> type = navArgument != null ? navArgument.getType() : null;
                if (type != null) {
                    Bundle bundle2 = this.matchingArgs;
                    m.e(key, "key");
                    obj = type.get(bundle2, key);
                } else {
                    obj = null;
                }
                if (type != null) {
                    m.e(key, "key");
                    obj2 = type.get(arguments, key);
                }
                if (!m.a(obj, obj2)) {
                    return false;
                }
            }
            return true;
        }

        public DeepLinkMatch(NavDestination destination, Bundle bundle, boolean z10, int i10, boolean z11, int i11) {
            m.f(destination, "destination");
            this.destination = destination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z10;
            this.matchingPathSegments = i10;
            this.hasMatchingAction = z11;
            this.mimeTypeMatchLevel = i11;
        }

        @Override // java.lang.Comparable
        public int compareTo(DeepLinkMatch other) {
            m.f(other, "other");
            boolean z10 = this.isExactDeepLink;
            if (z10 && !other.isExactDeepLink) {
                return 1;
            }
            if (!z10 && other.isExactDeepLink) {
                return -1;
            }
            int i10 = this.matchingPathSegments - other.matchingPathSegments;
            if (i10 > 0) {
                return 1;
            }
            if (i10 < 0) {
                return -1;
            }
            Bundle bundle = this.matchingArgs;
            if (bundle != null && other.matchingArgs == null) {
                return 1;
            }
            if (bundle == null && other.matchingArgs != null) {
                return -1;
            }
            if (bundle != null) {
                int size = bundle.size();
                Bundle bundle2 = other.matchingArgs;
                m.c(bundle2);
                int size2 = size - bundle2.size();
                if (size2 > 0) {
                    return 1;
                }
                if (size2 < 0) {
                    return -1;
                }
            }
            boolean z11 = this.hasMatchingAction;
            if (z11 && !other.hasMatchingAction) {
                return 1;
            }
            if (z11 || !other.hasMatchingAction) {
                return this.mimeTypeMatchLevel - other.mimeTypeMatchLevel;
            }
            return -1;
        }

        public final NavDestination getDestination() {
            return this.destination;
        }

        public final Bundle getMatchingArgs() {
            return this.matchingArgs;
        }
    }

    public NavDestination(String navigatorName) {
        m.f(navigatorName, "navigatorName");
        this.navigatorName = navigatorName;
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat<>();
        this._arguments = new LinkedHashMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String getDisplayName(Context context, int i10) {
        return INSTANCE.getDisplayName(context, i10);
    }

    public final void addDeepLink(String uriPattern) {
        m.f(uriPattern, "uriPattern");
        addDeepLink(new NavDeepLink.Builder().setUriPattern(uriPattern).build());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds() {
        return buildDeepLinkIds$default(this, null, 1, null);
    }

    public boolean equals(Object other) {
        boolean z10;
        boolean z11;
        if (other != null && (other instanceof NavDestination)) {
            NavDestination navDestination = (NavDestination) other;
            boolean z12 = r.m0(this.deepLinks, navDestination.deepLinks).size() == this.deepLinks.size();
            if (this.actions.size() != navDestination.actions.size()) {
                z10 = false;
                break;
            }
            Iterator it = k.g(SparseArrayKt.valueIterator(this.actions)).iterator();
            while (true) {
                if (!it.hasNext()) {
                    Iterator it2 = k.g(SparseArrayKt.valueIterator(navDestination.actions)).iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z10 = true;
                            break;
                        }
                        if (!this.actions.containsValue((NavAction) it2.next())) {
                        }
                    }
                } else {
                    if (!navDestination.actions.containsValue((NavAction) it.next())) {
                    }
                }
                z10 = false;
                break;
            }
            if (getArguments().size() != navDestination.getArguments().size()) {
                z11 = false;
                break;
            }
            Iterator it3 = n0.v(getArguments()).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    Iterator it4 = n0.v(navDestination.getArguments()).iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z11 = true;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it4.next();
                        if (!getArguments().containsKey(entry.getKey()) || !m.a(getArguments().get(entry.getKey()), entry.getValue())) {
                        }
                    }
                } else {
                    Map.Entry entry2 = (Map.Entry) it3.next();
                    if (!navDestination.getArguments().containsKey(entry2.getKey()) || !m.a(navDestination.getArguments().get(entry2.getKey()), entry2.getValue())) {
                    }
                }
                z11 = false;
                break;
            }
            if (this.id == navDestination.id && m.a(this.route, navDestination.route) && z12 && z10 && z11) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDeepLink(Uri deepLink) {
        m.f(deepLink, "deepLink");
        return hasDeepLink(new NavDeepLinkRequest(deepLink, null, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final DeepLinkMatch matchDeepLink(String route) {
        m.f(route, "route");
        NavDeepLinkRequest.Builder.Companion companion = NavDeepLinkRequest.Builder.INSTANCE;
        Uri uri = Uri.parse(INSTANCE.createRoute(route));
        m.b(uri, "Uri.parse(this)");
        NavDeepLinkRequest navDeepLinkRequestBuild = companion.fromUri(uri).build();
        return this instanceof NavGraph ? ((NavGraph) this).matchDeepLinkExcludingChildren(navDeepLinkRequestBuild) : matchDeepLink(navDeepLinkRequestBuild);
    }

    public final void putAction(@IdRes int actionId, @IdRes int destId) {
        putAction(actionId, new NavAction(destId, null, null, 6, null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean supportsActions() {
        return true;
    }

    public static /* synthetic */ int[] buildDeepLinkIds$default(NavDestination navDestination, NavDestination navDestination2, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildDeepLinkIds");
        }
        if ((i10 & 1) != 0) {
            navDestination2 = null;
        }
        return navDestination.buildDeepLinkIds(navDestination2);
    }

    public static final h<NavDestination> getHierarchy(NavDestination navDestination) {
        return INSTANCE.getHierarchy(navDestination);
    }

    protected static final <C> Class<? extends C> parseClassFromName(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromName(context, str, cls);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <C> Class<? extends C> parseClassFromNameInternal(Context context, String str, Class<? extends C> cls) {
        return INSTANCE.parseClassFromNameInternal(context, str, cls);
    }

    public final void addArgument(String argumentName, NavArgument argument) {
        m.f(argumentName, "argumentName");
        m.f(argument, "argument");
        this._arguments.put(argumentName, argument);
    }

    public final void addDeepLink(NavDeepLink navDeepLink) {
        m.f(navDeepLink, "navDeepLink");
        List<String> listMissingRequiredArguments = NavArgumentKt.missingRequiredArguments(getArguments(), new NavDestination$addDeepLink$missingRequiredArguments$1(navDeepLink));
        if (listMissingRequiredArguments.isEmpty()) {
            this.deepLinks.add(navDeepLink);
            return;
        }
        throw new IllegalArgumentException(("Deep link " + navDeepLink.getUriPattern() + " can't be used to open destination " + this + ".\nFollowing required arguments are missing: " + listMissingRequiredArguments).toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final Bundle addInDefaultArgs(Bundle args) {
        Map<String, NavArgument> map;
        if (args == null && ((map = this._arguments) == null || map.isEmpty())) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (Map.Entry<String, NavArgument> entry : this._arguments.entrySet()) {
            entry.getValue().putDefaultValue(entry.getKey(), bundle);
        }
        if (args != null) {
            bundle.putAll(args);
            for (Map.Entry<String, NavArgument> entry2 : this._arguments.entrySet()) {
                String key = entry2.getKey();
                NavArgument value = entry2.getValue();
                if (!value.verify(key, bundle)) {
                    throw new IllegalArgumentException(("Wrong argument type for '" + key + "' in argument bundle. " + value.getType().getName() + " expected.").toString());
                }
            }
        }
        return bundle;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final int[] buildDeepLinkIds(NavDestination previousDestination) {
        i iVar = new i();
        NavDestination navDestination = this;
        while (true) {
            m.c(navDestination);
            NavGraph navGraph = navDestination.parent;
            if ((previousDestination != null ? previousDestination.parent : null) != null) {
                NavGraph navGraph2 = previousDestination.parent;
                m.c(navGraph2);
                if (navGraph2.findNode(navDestination.id) != navDestination) {
                    if (navGraph != null || navGraph.getStartDestId() != navDestination.id) {
                        iVar.addFirst(navDestination);
                    }
                    if (!m.a(navGraph, previousDestination) || navGraph == null) {
                        break;
                    }
                    navDestination = navGraph;
                } else {
                    iVar.addFirst(navDestination);
                    break;
                }
            } else {
                if (navGraph != null) {
                    iVar.addFirst(navDestination);
                } else {
                    iVar.addFirst(navDestination);
                }
                if (!m.a(navGraph, previousDestination)) {
                    break;
                }
                navDestination = navGraph;
            }
        }
        List listO0 = r.O0(iVar);
        ArrayList arrayList = new ArrayList(r.w(listO0, 10));
        Iterator it = listO0.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((NavDestination) it.next()).id));
        }
        return r.N0(arrayList);
    }

    public final String fillInLabel(Context context, Bundle bundle) {
        NavArgument navArgument;
        m.f(context, "context");
        CharSequence charSequence = this.label;
        if (charSequence == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(charSequence);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String strGroup = matcher.group(1);
            if (bundle == null || !bundle.containsKey(strGroup)) {
                throw new IllegalArgumentException("Could not find \"" + strGroup + "\" in " + bundle + " to fill label \"" + ((Object) charSequence) + '\"');
            }
            matcher.appendReplacement(stringBuffer, "");
            if (m.a((strGroup == null || (navArgument = getArguments().get(strGroup)) == null) ? null : navArgument.getType(), NavType.ReferenceType)) {
                String string = context.getString(bundle.getInt(strGroup));
                m.e(string, "context.getString(bundle.getInt(argName))");
                stringBuffer.append(string);
            } else {
                stringBuffer.append(bundle.getString(strGroup));
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public final NavAction getAction(@IdRes int id2) {
        NavAction navAction = this.actions.isEmpty() ? null : this.actions.get(id2);
        if (navAction != null) {
            return navAction;
        }
        NavGraph navGraph = this.parent;
        if (navGraph != null) {
            return navGraph.getAction(id2);
        }
        return null;
    }

    public final Map<String, NavArgument> getArguments() {
        return n0.s(this._arguments);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public String getDisplayName() {
        String str = this.idName;
        return str == null ? String.valueOf(this.id) : str;
    }

    @IdRes
    public final int getId() {
        return this.id;
    }

    public final CharSequence getLabel() {
        return this.label;
    }

    public final String getNavigatorName() {
        return this.navigatorName;
    }

    public final NavGraph getParent() {
        return this.parent;
    }

    public final String getRoute() {
        return this.route;
    }

    public boolean hasDeepLink(NavDeepLinkRequest deepLinkRequest) {
        m.f(deepLinkRequest, "deepLinkRequest");
        return matchDeepLink(deepLinkRequest) != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final boolean hasRoute(String route, Bundle arguments) {
        m.f(route, "route");
        if (m.a(this.route, route)) {
            return true;
        }
        DeepLinkMatch deepLinkMatchMatchDeepLink = matchDeepLink(route);
        if (m.a(this, deepLinkMatchMatchDeepLink != null ? deepLinkMatchMatchDeepLink.getDestination() : null)) {
            return deepLinkMatchMatchDeepLink.hasMatchingArgs(arguments);
        }
        return false;
    }

    public int hashCode() {
        Set<String> setKeySet;
        int i10 = this.id * 31;
        String str = this.route;
        int iHashCode = i10 + (str != null ? str.hashCode() : 0);
        for (NavDeepLink navDeepLink : this.deepLinks) {
            int i11 = iHashCode * 31;
            String uriPattern = navDeepLink.getUriPattern();
            int iHashCode2 = (i11 + (uriPattern != null ? uriPattern.hashCode() : 0)) * 31;
            String action = navDeepLink.getAction();
            int iHashCode3 = (iHashCode2 + (action != null ? action.hashCode() : 0)) * 31;
            String mimeType = navDeepLink.getMimeType();
            iHashCode = iHashCode3 + (mimeType != null ? mimeType.hashCode() : 0);
        }
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.actions);
        while (itValueIterator.hasNext()) {
            NavAction navAction = (NavAction) itValueIterator.next();
            int destinationId = ((iHashCode * 31) + navAction.getDestinationId()) * 31;
            NavOptions navOptions = navAction.getNavOptions();
            iHashCode = destinationId + (navOptions != null ? navOptions.hashCode() : 0);
            Bundle defaultArguments = navAction.getDefaultArguments();
            if (defaultArguments != null && (setKeySet = defaultArguments.keySet()) != null) {
                m.e(setKeySet, "keySet()");
                for (String str2 : setKeySet) {
                    int i12 = iHashCode * 31;
                    Bundle defaultArguments2 = navAction.getDefaultArguments();
                    m.c(defaultArguments2);
                    Object obj = defaultArguments2.get(str2);
                    iHashCode = i12 + (obj != null ? obj.hashCode() : 0);
                }
            }
        }
        for (String str3 : getArguments().keySet()) {
            int iHashCode4 = ((iHashCode * 31) + str3.hashCode()) * 31;
            NavArgument navArgument = getArguments().get(str3);
            iHashCode = iHashCode4 + (navArgument != null ? navArgument.hashCode() : 0);
        }
        return iHashCode;
    }

    @CallSuper
    public void onInflate(Context context, AttributeSet attrs) {
        m.f(context, "context");
        m.f(attrs, "attrs");
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, androidx.navigation.common.R.styleable.Navigator);
        m.e(typedArrayObtainAttributes, "context.resources.obtain…s, R.styleable.Navigator)");
        setRoute(typedArrayObtainAttributes.getString(androidx.navigation.common.R.styleable.Navigator_route));
        int i10 = androidx.navigation.common.R.styleable.Navigator_android_id;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            setId(typedArrayObtainAttributes.getResourceId(i10, 0));
            this.idName = INSTANCE.getDisplayName(context, this.id);
        }
        this.label = typedArrayObtainAttributes.getText(androidx.navigation.common.R.styleable.Navigator_android_label);
        z zVar = z.f17874a;
        typedArrayObtainAttributes.recycle();
    }

    public final void putAction(@IdRes int actionId, NavAction action) {
        m.f(action, "action");
        if (supportsActions()) {
            if (actionId == 0) {
                throw new IllegalArgumentException("Cannot have an action with actionId 0");
            }
            this.actions.put(actionId, action);
        } else {
            throw new UnsupportedOperationException("Cannot add action " + actionId + " to " + this + " as it does not support actions, indicating that it is a terminal destination in your navigation graph and will never trigger actions.");
        }
    }

    public final void removeAction(@IdRes int actionId) {
        this.actions.remove(actionId);
    }

    public final void removeArgument(String argumentName) {
        m.f(argumentName, "argumentName");
        this._arguments.remove(argumentName);
    }

    public final void setId(@IdRes int i10) {
        this.id = i10;
        this.idName = null;
    }

    public final void setLabel(CharSequence charSequence) {
        this.label = charSequence;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void setParent(NavGraph navGraph) {
        this.parent = navGraph;
    }

    public final void setRoute(String str) {
        if (str == null) {
            setId(0);
        } else {
            if (n.d0(str)) {
                throw new IllegalArgumentException("Cannot have an empty route");
            }
            String strCreateRoute = INSTANCE.createRoute(str);
            setId(strCreateRoute.hashCode());
            addDeepLink(strCreateRoute);
        }
        List<NavDeepLink> list = this.deepLinks;
        List<NavDeepLink> list2 = list;
        for (Object obj : list) {
            if (m.a(((NavDeepLink) obj).getUriPattern(), INSTANCE.createRoute(this.route))) {
                h0.a(list2).remove(obj);
                this.route = str;
            }
        }
        obj = null;
        h0.a(list2).remove(obj);
        this.route = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("(");
        String str = this.idName;
        if (str == null) {
            sb2.append("0x");
            sb2.append(Integer.toHexString(this.id));
        } else {
            sb2.append(str);
        }
        sb2.append(")");
        String str2 = this.route;
        if (str2 != null && !n.d0(str2)) {
            sb2.append(" route=");
            sb2.append(this.route);
        }
        if (this.label != null) {
            sb2.append(" label=");
            sb2.append(this.label);
        }
        String string = sb2.toString();
        m.e(string, "sb.toString()");
        return string;
    }

    private final boolean hasRequiredArguments(NavDeepLink deepLink, Uri uri, Map<String, NavArgument> arguments) {
        return NavArgumentKt.missingRequiredArguments(arguments, new NavDestination$hasRequiredArguments$missingRequiredArguments$1(deepLink.getMatchingPathAndQueryArgs$navigation_common_release(uri, arguments))).isEmpty();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavDestination(Navigator<? extends NavDestination> navigator) {
        this(NavigatorProvider.INSTANCE.getNameForNavigator$navigation_common_release(navigator.getClass()));
        m.f(navigator, "navigator");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        m.f(navDeepLinkRequest, "navDeepLinkRequest");
        if (this.deepLinks.isEmpty()) {
            return null;
        }
        DeepLinkMatch deepLinkMatch = null;
        for (NavDeepLink navDeepLink : this.deepLinks) {
            Uri uri = navDeepLinkRequest.getUri();
            Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, getArguments()) : null;
            int iCalculateMatchingPathSegments$navigation_common_release = navDeepLink.calculateMatchingPathSegments$navigation_common_release(uri);
            String action = navDeepLinkRequest.getAction();
            boolean z10 = action != null && m.a(action, navDeepLink.getAction());
            String mimeType = navDeepLinkRequest.getMimeType();
            int mimeTypeMatchRating = mimeType != null ? navDeepLink.getMimeTypeMatchRating(mimeType) : -1;
            if (matchingArguments == null) {
                if (z10 || mimeTypeMatchRating > -1) {
                    if (hasRequiredArguments(navDeepLink, uri, getArguments())) {
                    }
                }
            }
            DeepLinkMatch deepLinkMatch2 = new DeepLinkMatch(this, matchingArguments, navDeepLink.getIsExactDeepLink(), iCalculateMatchingPathSegments$navigation_common_release, z10, mimeTypeMatchRating);
            if (deepLinkMatch == null || deepLinkMatch2.compareTo(deepLinkMatch) > 0) {
                deepLinkMatch = deepLinkMatch2;
            }
        }
        return deepLinkMatch;
    }
}
