package androidx.graphics.shapes;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.p;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lr8/p;", "", "it", "", "invoke", "(Lr8/p;)Ljava/lang/CharSequence;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
final class FeatureMappingKt$featureMapper$1$1 extends o implements l<p<? extends Float, ? extends Float>, CharSequence> {
    public static final FeatureMappingKt$featureMapper$1$1 INSTANCE = new FeatureMappingKt$featureMapper$1$1();

    FeatureMappingKt$featureMapper$1$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(p<Float, Float> it) {
        m.f(it, "it");
        return it.c().floatValue() + " -> " + it.d().floatValue();
    }

    @Override // c9.l
    public /* bridge */ /* synthetic */ CharSequence invoke(p<? extends Float, ? extends Float> pVar) {
        return invoke2((p<Float, Float>) pVar);
    }
}
