package androidx.navigation;

import androidx.annotation.IdRes;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\n¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\n¢\u0006\u0004\b\u0004\u0010\b\u001a\u001e\u0010\n\u001a\u00020\t*\u00020\u00002\b\b\u0001\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0086\u0002¢\u0006\u0004\b\n\u0010\f\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001c\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\n¢\u0006\u0004\b\u000f\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\r\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\b\u0013\u0010\u0010¨\u0006\u0014"}, d2 = {"Landroidx/navigation/NavGraph;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "Landroidx/navigation/NavDestination;", "get", "(Landroidx/navigation/NavGraph;I)Landroidx/navigation/NavDestination;", "", "route", "(Landroidx/navigation/NavGraph;Ljava/lang/String;)Landroidx/navigation/NavDestination;", "", "contains", "(Landroidx/navigation/NavGraph;I)Z", "(Landroidx/navigation/NavGraph;Ljava/lang/String;)Z", "node", "Lr8/z;", "plusAssign", "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavDestination;)V", TransactionPartnerType.OTHER, "(Landroidx/navigation/NavGraph;Landroidx/navigation/NavGraph;)V", "minusAssign", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavGraphKt {
    public static final boolean contains(NavGraph navGraph, @IdRes int i10) {
        m.f(navGraph, "<this>");
        return navGraph.findNode(i10) != null;
    }

    public static final NavDestination get(NavGraph navGraph, @IdRes int i10) {
        m.f(navGraph, "<this>");
        NavDestination navDestinationFindNode = navGraph.findNode(i10);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + i10 + " was found in " + navGraph);
    }

    public static final void plusAssign(NavGraph navGraph, NavDestination node) {
        m.f(navGraph, "<this>");
        m.f(node, "node");
        navGraph.addDestination(node);
    }

    public static final boolean contains(NavGraph navGraph, String route) {
        m.f(navGraph, "<this>");
        m.f(route, "route");
        return navGraph.findNode(route) != null;
    }

    public static final NavDestination get(NavGraph navGraph, String route) {
        m.f(navGraph, "<this>");
        m.f(route, "route");
        NavDestination navDestinationFindNode = navGraph.findNode(route);
        if (navDestinationFindNode != null) {
            return navDestinationFindNode;
        }
        throw new IllegalArgumentException("No destination for " + route + " was found in " + navGraph);
    }

    public static final void minusAssign(NavGraph navGraph, NavDestination node) {
        m.f(navGraph, "<this>");
        m.f(node, "node");
        navGraph.remove(node);
    }

    public static final void plusAssign(NavGraph navGraph, NavGraph other) {
        m.f(navGraph, "<this>");
        m.f(other, "other");
        navGraph.addAll(other);
    }
}
