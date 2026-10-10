package androidx.graphics.shapes;

import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.o;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "i", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class FeatureMappingKt$featureMapper$2$1$2 extends o implements l<Integer, CharSequence> {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    @Override // c9.l
    public /* bridge */ /* synthetic */ CharSequence invoke(Integer num) {
        return invoke(num.intValue());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeatureMappingKt$featureMapper$2$1$2(DoubleMapper doubleMapper, int i10) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i10;
    }

    public final CharSequence invoke(int i10) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.mapBack(i10 / this.$N));
    }
}
