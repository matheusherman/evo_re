package androidx.privacysandbox.ads.adservices.measurement;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/privacysandbox/ads/adservices/measurement/MeasurementManagerApi31Ext9Impl;", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class MeasurementManager$Companion$obtain$1 extends kotlin.jvm.internal.o implements c9.l<Context, MeasurementManagerApi31Ext9Impl> {
    final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MeasurementManager$Companion$obtain$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // c9.l
    public final MeasurementManagerApi31Ext9Impl invoke(Context it) {
        kotlin.jvm.internal.m.f(it, "it");
        return new MeasurementManagerApi31Ext9Impl(this.$context);
    }
}
