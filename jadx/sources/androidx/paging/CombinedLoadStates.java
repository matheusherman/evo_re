package androidx.paging;

import c9.q;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 %2\u00020\u0001:\u0001%B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001b\u001a\u00020\u00172\u001e\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00170\u0015H\u0000¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b$\u0010#¨\u0006&"}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "Landroidx/paging/LoadState;", "refresh", "prepend", "append", "Landroidx/paging/LoadStates;", "source", "mediator", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "Lr8/z;", "op", "forEach$paging_common", "(Lc9/q;)V", "forEach", "Landroidx/paging/LoadState;", "getRefresh", "()Landroidx/paging/LoadState;", "getPrepend", "getAppend", "Landroidx/paging/LoadStates;", "getSource", "()Landroidx/paging/LoadStates;", "getMediator", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class CombinedLoadStates {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CombinedLoadStates IDLE_SOURCE;
    private final LoadState append;
    private final LoadStates mediator;
    private final LoadState prepend;
    private final LoadState refresh;
    private final LoadStates source;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/CombinedLoadStates$Companion;", "", "()V", "IDLE_SOURCE", "Landroidx/paging/CombinedLoadStates;", "getIDLE_SOURCE", "()Landroidx/paging/CombinedLoadStates;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CombinedLoadStates getIDLE_SOURCE() {
            return CombinedLoadStates.IDLE_SOURCE;
        }
    }

    public CombinedLoadStates(LoadState refresh, LoadState prepend, LoadState append, LoadStates source, LoadStates loadStates) {
        m.f(refresh, "refresh");
        m.f(prepend, "prepend");
        m.f(append, "append");
        m.f(source, "source");
        this.refresh = refresh;
        this.prepend = prepend;
        this.append = append;
        this.source = source;
        this.mediator = loadStates;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!m.a(CombinedLoadStates.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.CombinedLoadStates");
        }
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) other;
        return m.a(this.refresh, combinedLoadStates.refresh) && m.a(this.prepend, combinedLoadStates.prepend) && m.a(this.append, combinedLoadStates.append) && m.a(this.source, combinedLoadStates.source) && m.a(this.mediator, combinedLoadStates.mediator);
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        IDLE_SOURCE = new CombinedLoadStates(companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common(), LoadStates.INSTANCE.getIDLE(), null, 16, null);
    }

    public /* synthetic */ CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2, int i10, g gVar) {
        this(loadState, loadState2, loadState3, loadStates, (i10 & 16) != 0 ? null : loadStates2);
    }

    public final void forEach$paging_common(q<? super LoadType, ? super Boolean, ? super LoadState, z> op) {
        m.f(op, "op");
        LoadStates loadStates = this.source;
        LoadType loadType = LoadType.REFRESH;
        LoadState refresh = loadStates.getRefresh();
        Boolean bool = Boolean.FALSE;
        op.invoke(loadType, bool, refresh);
        LoadType loadType2 = LoadType.PREPEND;
        op.invoke(loadType2, bool, loadStates.getPrepend());
        LoadType loadType3 = LoadType.APPEND;
        op.invoke(loadType3, bool, loadStates.getAppend());
        LoadStates loadStates2 = this.mediator;
        if (loadStates2 != null) {
            LoadState refresh2 = loadStates2.getRefresh();
            Boolean bool2 = Boolean.TRUE;
            op.invoke(loadType, bool2, refresh2);
            op.invoke(loadType2, bool2, loadStates2.getPrepend());
            op.invoke(loadType3, bool2, loadStates2.getAppend());
        }
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates getMediator() {
        return this.mediator;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final LoadStates getSource() {
        return this.source;
    }

    public int hashCode() {
        int iHashCode = ((((((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode()) * 31) + this.source.hashCode()) * 31;
        LoadStates loadStates = this.mediator;
        return iHashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ", source=" + this.source + ", mediator=" + this.mediator + ')';
    }
}
