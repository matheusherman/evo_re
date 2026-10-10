package androidx.navigation;

import androidx.annotation.IdRes;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a?\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0001\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"Landroidx/navigation/NavHost;", "", IjkMediaMeta.IJKM_KEY_TRACK_ID, "startDestination", "Lkotlin/Function1;", "Landroidx/navigation/NavGraphBuilder;", "Lr8/z;", "builder", "Landroidx/navigation/NavGraph;", "createGraph", "(Landroidx/navigation/NavHost;IILc9/l;)Landroidx/navigation/NavGraph;", "", "route", "(Landroidx/navigation/NavHost;Ljava/lang/String;Ljava/lang/String;Lc9/l;)Landroidx/navigation/NavGraph;", "navigation-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavHostKt {
    public static final NavGraph createGraph(NavHost navHost, @IdRes int i10, @IdRes int i11, l<? super NavGraphBuilder, z> builder) {
        m.f(navHost, "<this>");
        m.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().get_navigatorProvider(), i10, i11);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, int i10, int i11, l builder, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        m.f(navHost, "<this>");
        m.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().get_navigatorProvider(), i10, i11);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static final NavGraph createGraph(NavHost navHost, String startDestination, String str, l<? super NavGraphBuilder, z> builder) {
        m.f(navHost, "<this>");
        m.f(startDestination, "startDestination");
        m.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().get_navigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }

    public static /* synthetic */ NavGraph createGraph$default(NavHost navHost, String startDestination, String str, l builder, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        m.f(navHost, "<this>");
        m.f(startDestination, "startDestination");
        m.f(builder, "builder");
        NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHost.getNavController().get_navigatorProvider(), startDestination, str);
        builder.invoke(navGraphBuilder);
        return navGraphBuilder.build();
    }
}
