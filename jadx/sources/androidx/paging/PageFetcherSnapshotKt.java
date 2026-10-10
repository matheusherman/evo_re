package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¨\u0006\u0006"}, d2 = {"shouldPrioritizeOver", "", "Landroidx/paging/GenerationalViewportHint;", "previous", "loadType", "Landroidx/paging/LoadType;", "paging-common"}, k = 2, mv = {1, 4, 1})
public final class PageFetcherSnapshotKt {
    public static final boolean shouldPrioritizeOver(GenerationalViewportHint shouldPrioritizeOver, GenerationalViewportHint previous, LoadType loadType) {
        m.f(shouldPrioritizeOver, "$this$shouldPrioritizeOver");
        m.f(previous, "previous");
        m.f(loadType, "loadType");
        if (shouldPrioritizeOver.getGenerationId() > previous.getGenerationId()) {
            return true;
        }
        if ((previous.getHint() instanceof ViewportHint.Initial) && (shouldPrioritizeOver.getHint() instanceof ViewportHint.Access)) {
            return true;
        }
        if ((shouldPrioritizeOver.getHint() instanceof ViewportHint.Initial) && (previous.getHint() instanceof ViewportHint.Access)) {
            return false;
        }
        if (shouldPrioritizeOver.getHint().getOriginalPageOffsetFirst() != previous.getHint().getOriginalPageOffsetFirst() || shouldPrioritizeOver.getHint().getOriginalPageOffsetLast() != previous.getHint().getOriginalPageOffsetLast()) {
            return true;
        }
        if (loadType != LoadType.PREPEND || previous.getHint().getPresentedItemsBefore() >= shouldPrioritizeOver.getHint().getPresentedItemsBefore()) {
            return loadType != LoadType.APPEND || previous.getHint().getPresentedItemsAfter() >= shouldPrioritizeOver.getHint().getPresentedItemsAfter();
        }
        return false;
    }
}
