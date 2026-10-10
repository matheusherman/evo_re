package androidx.paging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.flow.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u0010*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0001\u0010B%\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/paging/PagingData;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Landroidx/paging/PageEvent;", "flow", "Landroidx/paging/UiReceiver;", "receiver", "<init>", "(Lkotlinx/coroutines/flow/f;Landroidx/paging/UiReceiver;)V", "Lkotlinx/coroutines/flow/f;", "getFlow$paging_common", "()Lkotlinx/coroutines/flow/f;", "Landroidx/paging/UiReceiver;", "getReceiver$paging_common", "()Landroidx/paging/UiReceiver;", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PagingData<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PagingData<Object> EMPTY;
    private static final UiReceiver NOOP_RECEIVER;
    private final f<PageEvent<T>> flow;
    private final UiReceiver receiver;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\b\b\u0001\u0010\r*\u00020\u0001H\u0007J&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\b\b\u0001\u0010\r*\u00020\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0010H\u0007R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/paging/PagingData$Companion;", "", "()V", "EMPTY", "Landroidx/paging/PagingData;", "getEMPTY$paging_common$annotations", "getEMPTY$paging_common", "()Landroidx/paging/PagingData;", "NOOP_RECEIVER", "Landroidx/paging/UiReceiver;", "getNOOP_RECEIVER$paging_common", "()Landroidx/paging/UiReceiver;", "empty", ExifInterface.GPS_DIRECTION_TRUE, TypedValues.TransitionType.S_FROM, "data", "", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final <T> PagingData<T> from(List<? extends T> data) {
            m.f(data, "data");
            PageEvent.Insert.Companion companion = PageEvent.Insert.INSTANCE;
            List<TransformablePage<T>> listE = r.e(new TransformablePage(0, data));
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.INSTANCE;
            return new PagingData<>(h.w(companion.Refresh(listE, 0, 0, new CombinedLoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common(), new LoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common()), null, 16, null))), getNOOP_RECEIVER$paging_common());
        }

        public final <T> PagingData<T> empty() {
            PagingData<T> pagingData = (PagingData<T>) getEMPTY$paging_common();
            if (pagingData != null) {
                return pagingData;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PagingData<T>");
        }

        public final PagingData<Object> getEMPTY$paging_common() {
            return PagingData.EMPTY;
        }

        public final UiReceiver getNOOP_RECEIVER$paging_common() {
            return PagingData.NOOP_RECEIVER;
        }

        public static /* synthetic */ void getEMPTY$paging_common$annotations() {
        }
    }

    static {
        UiReceiver uiReceiver = new UiReceiver() { // from class: androidx.paging.PagingData$Companion$NOOP_RECEIVER$1
            @Override // androidx.paging.UiReceiver
            public void accessHint(ViewportHint viewportHint) {
                m.f(viewportHint, "viewportHint");
            }

            @Override // androidx.paging.UiReceiver
            public void refresh() {
            }

            @Override // androidx.paging.UiReceiver
            public void retry() {
            }
        };
        NOOP_RECEIVER = uiReceiver;
        EMPTY = new PagingData<>(h.w(PageEvent.Insert.INSTANCE.getEMPTY_REFRESH_LOCAL()), uiReceiver);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PagingData(f<? extends PageEvent<T>> flow, UiReceiver receiver) {
        m.f(flow, "flow");
        m.f(receiver, "receiver");
        this.flow = flow;
        this.receiver = receiver;
    }

    public static final <T> PagingData<T> empty() {
        return INSTANCE.empty();
    }

    public static final <T> PagingData<T> from(List<? extends T> list) {
        return INSTANCE.from(list);
    }

    public final f<PageEvent<T>> getFlow$paging_common() {
        return this.flow;
    }

    /* JADX INFO: renamed from: getReceiver$paging_common, reason: from getter */
    public final UiReceiver getReceiver() {
        return this.receiver;
    }
}
