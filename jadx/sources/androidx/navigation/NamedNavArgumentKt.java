package androidx.navigation;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "name", "Lkotlin/Function1;", "Landroidx/navigation/NavArgumentBuilder;", "Lr8/z;", "builder", "Landroidx/navigation/NamedNavArgument;", "navArgument", "(Ljava/lang/String;Lc9/l;)Landroidx/navigation/NamedNavArgument;", "navigation-common_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NamedNavArgumentKt {
    public static final NamedNavArgument navArgument(String name, l<? super NavArgumentBuilder, z> builder) {
        m.f(name, "name");
        m.f(builder, "builder");
        NavArgumentBuilder navArgumentBuilder = new NavArgumentBuilder();
        builder.invoke(navArgumentBuilder);
        return new NamedNavArgument(name, navArgumentBuilder.build());
    }
}
