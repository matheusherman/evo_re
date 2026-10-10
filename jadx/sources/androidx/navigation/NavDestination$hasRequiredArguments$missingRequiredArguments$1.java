package androidx.navigation;

import android.os.Bundle;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "key", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class NavDestination$hasRequiredArguments$missingRequiredArguments$1 extends o implements l<String, Boolean> {
    final /* synthetic */ Bundle $matchingArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavDestination$hasRequiredArguments$missingRequiredArguments$1(Bundle bundle) {
        super(1);
        this.$matchingArgs = bundle;
    }

    @Override // c9.l
    public final Boolean invoke(String key) {
        m.f(key, "key");
        return Boolean.valueOf(!this.$matchingArgs.containsKey(key));
    }
}
