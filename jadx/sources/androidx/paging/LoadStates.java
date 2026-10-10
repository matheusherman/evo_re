package androidx.paging;

import androidx.annotation.RestrictTo;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import r8.n;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001*B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\f\u001a\u00020\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\bH\u0087\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J.\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010&\u001a\u0004\b'\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b)\u0010\u0017\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+"}, d2 = {"Landroidx/paging/LoadStates;", "", "Landroidx/paging/LoadState;", "refresh", "prepend", "append", "<init>", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)V", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Lr8/z;", "op", "forEach", "(Lc9/p;)V", "loadType", "newState", "modifyState$paging_common", "(Landroidx/paging/LoadType;Landroidx/paging/LoadState;)Landroidx/paging/LoadStates;", "modifyState", "get$paging_common", "(Landroidx/paging/LoadType;)Landroidx/paging/LoadState;", "get", "component1", "()Landroidx/paging/LoadState;", "component2", "component3", "copy", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;)Landroidx/paging/LoadStates;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/paging/LoadState;", "getRefresh", "getPrepend", "getAppend", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
public final /* data */ class LoadStates {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LoadStates IDLE;
    private final LoadState append;
    private final LoadState prepend;
    private final LoadState refresh;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/LoadStates$Companion;", "", "()V", "IDLE", "Landroidx/paging/LoadStates;", "getIDLE", "()Landroidx/paging/LoadStates;", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final LoadStates getIDLE() {
            return LoadStates.IDLE;
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.APPEND;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.PREPEND;
            iArr[loadType2.ordinal()] = 2;
            LoadType loadType3 = LoadType.REFRESH;
            iArr[loadType3.ordinal()] = 3;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType3.ordinal()] = 1;
            iArr2[loadType.ordinal()] = 2;
            iArr2[loadType2.ordinal()] = 3;
        }
    }

    static {
        LoadState.NotLoading.Companion companion = LoadState.NotLoading.INSTANCE;
        IDLE = new LoadStates(companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common(), companion.getIncomplete$paging_common());
    }

    public LoadStates(LoadState refresh, LoadState prepend, LoadState append) {
        m.f(refresh, "refresh");
        m.f(prepend, "prepend");
        m.f(append, "append");
        this.refresh = refresh;
        this.prepend = prepend;
        this.append = append;
    }

    public static /* synthetic */ LoadStates copy$default(LoadStates loadStates, LoadState loadState, LoadState loadState2, LoadState loadState3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            loadState = loadStates.refresh;
        }
        if ((i10 & 2) != 0) {
            loadState2 = loadStates.prepend;
        }
        if ((i10 & 4) != 0) {
            loadState3 = loadStates.append;
        }
        return loadStates.copy(loadState, loadState2, loadState3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final LoadState getRefresh() {
        return this.refresh;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LoadState getPrepend() {
        return this.prepend;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates copy(LoadState refresh, LoadState prepend, LoadState append) {
        m.f(refresh, "refresh");
        m.f(prepend, "prepend");
        m.f(append, "append");
        return new LoadStates(refresh, prepend, append);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadStates)) {
            return false;
        }
        LoadStates loadStates = (LoadStates) other;
        return m.a(this.refresh, loadStates.refresh) && m.a(this.prepend, loadStates.prepend) && m.a(this.append, loadStates.append);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final void forEach(p<? super LoadType, ? super LoadState, z> op) {
        m.f(op, "op");
        op.invoke(LoadType.REFRESH, getRefresh());
        op.invoke(LoadType.PREPEND, getPrepend());
        op.invoke(LoadType.APPEND, getAppend());
    }

    public final LoadState get$paging_common(LoadType loadType) {
        m.f(loadType, "loadType");
        int i10 = WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()];
        if (i10 == 1) {
            return this.refresh;
        }
        if (i10 == 2) {
            return this.append;
        }
        if (i10 == 3) {
            return this.prepend;
        }
        throw new n();
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public int hashCode() {
        LoadState loadState = this.refresh;
        int iHashCode = (loadState != null ? loadState.hashCode() : 0) * 31;
        LoadState loadState2 = this.prepend;
        int iHashCode2 = (iHashCode + (loadState2 != null ? loadState2.hashCode() : 0)) * 31;
        LoadState loadState3 = this.append;
        return iHashCode2 + (loadState3 != null ? loadState3.hashCode() : 0);
    }

    public final LoadStates modifyState$paging_common(LoadType loadType, LoadState newState) {
        m.f(loadType, "loadType");
        m.f(newState, "newState");
        int i10 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i10 == 1) {
            return copy$default(this, null, null, newState, 3, null);
        }
        if (i10 == 2) {
            return copy$default(this, null, newState, null, 5, null);
        }
        if (i10 == 3) {
            return copy$default(this, newState, null, null, 6, null);
        }
        throw new n();
    }

    public String toString() {
        return "LoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ")";
    }
}
