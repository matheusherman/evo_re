package androidx.paging;

import c9.q;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J1\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0011\u0010\u0016J%\u0010\u0011\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u001cJ\u001f\u0010\u001d\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ3\u0010#\u001a\u00020\u00042\u001e\u0010 \u001a\u001a\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u001fH\u0080\bø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0017H\u0000¢\u0006\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "<init>", "()V", "Lr8/z;", "updateHelperStates", "Landroidx/paging/LoadState;", "previousState", "sourceRefreshState", "sourceState", "remoteState", "computeHelperState", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadState;", "Landroidx/paging/CombinedLoadStates;", "snapshot", "()Landroidx/paging/CombinedLoadStates;", "combinedLoadStates", "set", "(Landroidx/paging/CombinedLoadStates;)V", "Landroidx/paging/LoadStates;", "sourceLoadStates", "remoteLoadStates", "(Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "", "remote", "state", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)Z", "get", "(Landroidx/paging/LoadType;Z)Landroidx/paging/LoadState;", "Lkotlin/Function3;", "op", "forEach$paging_common", "(Lc9/q;)V", "forEach", "loadType", "terminates$paging_common", "(Landroidx/paging/LoadType;)Z", "terminates", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "source", "Landroidx/paging/LoadStates;", "mediator", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class MutableLoadStateCollection {
    private LoadState append;
    private LoadStates mediator;
    private LoadState prepend;
    private LoadState refresh;
    private LoadStates source;

    public final void set(CombinedLoadStates combinedLoadStates) {
        m.f(combinedLoadStates, "combinedLoadStates");
        this.refresh = combinedLoadStates.getRefresh();
        this.prepend = combinedLoadStates.getPrepend();
        this.append = combinedLoadStates.getAppend();
        this.source = combinedLoadStates.getSource();
        this.mediator = combinedLoadStates.getMediator();
    }

    private final LoadState computeHelperState(LoadState previousState, LoadState sourceRefreshState, LoadState sourceState, LoadState remoteState) {
        if (remoteState == null) {
            return sourceState;
        }
        if (previousState instanceof LoadState.Loading) {
            return (((sourceRefreshState instanceof LoadState.NotLoading) && (remoteState instanceof LoadState.NotLoading)) || (remoteState instanceof LoadState.Error)) ? remoteState : previousState;
        }
        return remoteState;
    }

    private final void updateHelperStates() {
        LoadState loadState = this.refresh;
        LoadState refresh = this.source.getRefresh();
        LoadState refresh2 = this.source.getRefresh();
        LoadStates loadStates = this.mediator;
        this.refresh = computeHelperState(loadState, refresh, refresh2, loadStates != null ? loadStates.getRefresh() : null);
        LoadState loadState2 = this.prepend;
        LoadState refresh3 = this.source.getRefresh();
        LoadState prepend = this.source.getPrepend();
        LoadStates loadStates2 = this.mediator;
        this.prepend = computeHelperState(loadState2, refresh3, prepend, loadStates2 != null ? loadStates2.getPrepend() : null);
        LoadState loadState3 = this.append;
        LoadState refresh4 = this.source.getRefresh();
        LoadState append = this.source.getAppend();
        LoadStates loadStates3 = this.mediator;
        this.append = computeHelperState(loadState3, refresh4, append, loadStates3 != null ? loadStates3.getAppend() : null);
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

    public final LoadState get(LoadType type, boolean remote) {
        m.f(type, "type");
        LoadStates loadStates = remote ? this.mediator : this.source;
        if (loadStates != null) {
            return loadStates.get$paging_common(type);
        }
        return null;
    }

    public final CombinedLoadStates snapshot() {
        return new CombinedLoadStates(this.refresh, this.prepend, this.append, this.source, this.mediator);
    }

    public final boolean terminates$paging_common(LoadType loadType) {
        LoadState loadState;
        m.f(loadType, "loadType");
        LoadState loadState2 = get(loadType, false);
        m.c(loadState2);
        return loadState2.getEndOfPaginationReached() && ((loadState = get(loadType, true)) == null || loadState.getEndOfPaginationReached());
    }

    public MutableLoadStateCollection() {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        this.refresh = companion.getIncomplete$paging_common();
        this.prepend = companion.getIncomplete$paging_common();
        this.append = companion.getIncomplete$paging_common();
        this.source = LoadStates.INSTANCE.getIDLE();
    }

    public final void set(LoadStates sourceLoadStates, LoadStates remoteLoadStates) {
        m.f(sourceLoadStates, "sourceLoadStates");
        this.source = sourceLoadStates;
        this.mediator = remoteLoadStates;
        updateHelperStates();
    }

    public final boolean set(LoadType type, boolean remote, LoadState state) {
        boolean zA;
        m.f(type, "type");
        m.f(state, "state");
        if (remote) {
            LoadStates loadStates = this.mediator;
            LoadStates loadStatesModifyState$paging_common = (loadStates != null ? loadStates : LoadStates.INSTANCE.getIDLE()).modifyState$paging_common(type, state);
            this.mediator = loadStatesModifyState$paging_common;
            zA = m.a(loadStatesModifyState$paging_common, loadStates);
        } else {
            LoadStates loadStates2 = this.source;
            LoadStates loadStatesModifyState$paging_common2 = loadStates2.modifyState$paging_common(type, state);
            this.source = loadStatesModifyState$paging_common2;
            zA = m.a(loadStatesModifyState$paging_common2, loadStates2);
        }
        boolean z10 = !zA;
        updateHelperStates();
        return z10;
    }
}
