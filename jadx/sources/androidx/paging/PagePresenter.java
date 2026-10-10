package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.q;
import h9.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.j;
import kotlin.collections.r;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0014\b\u0000\u0018\u0000 D*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0002DEB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0014\u001a\u00020\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00018\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J\u0013\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000#¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\bH\u0016¢\u0006\u0004\b'\u0010\"J#\u0010*\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b*\u0010+J\r\u0010-\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u0015\u00100\u001a\u00020/2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b0\u00101R \u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R$\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R$\u0010:\u001a\u00020\b2\u0006\u00105\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b:\u00107\u001a\u0004\b;\u00109R$\u0010<\u001a\u00020\b2\u0006\u00105\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b<\u00107\u001a\u0004\b=\u00109R\u0014\u0010?\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u00109R\u0014\u0010A\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b@\u00109R\u0014\u0010C\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u00109¨\u0006F"}, d2 = {"Landroidx/paging/PagePresenter;", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/NullPaddedList;", "Landroidx/paging/PageEvent$Insert;", "insertEvent", "<init>", "(Landroidx/paging/PageEvent$Insert;)V", "", "index", "Lr8/z;", "checkIndex", "(I)V", "", "Landroidx/paging/TransformablePage;", "fullCount", "(Ljava/util/List;)I", "insert", "Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "callback", "insertPage", "(Landroidx/paging/PageEvent$Insert;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "Lh9/e;", "pageOffsetsToDrop", "dropPagesWithOffsets", "(Lh9/e;)I", "Landroidx/paging/PageEvent$Drop;", "drop", "dropPages", "(Landroidx/paging/PageEvent$Drop;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "", "toString", "()Ljava/lang/String;", "get", "(I)Ljava/lang/Object;", "Landroidx/paging/ItemSnapshotList;", "snapshot", "()Landroidx/paging/ItemSnapshotList;", "localIndex", "getFromStorage", "Landroidx/paging/PageEvent;", "pageEvent", "processEvent", "(Landroidx/paging/PageEvent;Landroidx/paging/PagePresenter$ProcessPageEventCallback;)V", "Landroidx/paging/ViewportHint$Initial;", "initializeHint", "()Landroidx/paging/ViewportHint$Initial;", "Landroidx/paging/ViewportHint$Access;", "accessHintForPresenterIndex", "(I)Landroidx/paging/ViewportHint$Access;", "", "pages", "Ljava/util/List;", "<set-?>", "storageCount", "I", "getStorageCount", "()I", "placeholdersBefore", "getPlaceholdersBefore", "placeholdersAfter", "getPlaceholdersAfter", "getOriginalPageOffsetFirst", "originalPageOffsetFirst", "getOriginalPageOffsetLast", "originalPageOffsetLast", "getSize", "size", "Companion", "ProcessPageEventCallback", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PagePresenter<T> implements NullPaddedList<T> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PagePresenter<Object> INITIAL = new PagePresenter<>(PageEvent.Insert.INSTANCE.getEMPTY_REFRESH_LOCAL());
    private final List<TransformablePage<T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int storageCount;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004\"\b\b\u0001\u0010\u0006*\u00020\u0001H\u0000¢\u0006\u0002\b\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/paging/PagePresenter$Companion;", "", "()V", "INITIAL", "Landroidx/paging/PagePresenter;", "initial", ExifInterface.GPS_DIRECTION_TRUE, "initial$paging_common", "paging-common"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final <T> PagePresenter<T> initial$paging_common() {
            PagePresenter<T> pagePresenter = PagePresenter.INITIAL;
            if (pagePresenter != null) {
                return pagePresenter;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PagePresenter<T>");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0007J\u001f\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0007J'\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagePresenter$ProcessPageEventCallback;", "", "", "position", "count", "Lr8/z;", "onChanged", "(II)V", "onInserted", "onRemoved", "Landroidx/paging/LoadType;", "loadType", "", "fromMediator", "Landroidx/paging/LoadState;", "loadState", "onStateUpdate", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "paging-common"}, k = 1, mv = {1, 4, 1})
    public interface ProcessPageEventCallback {
        void onChanged(int position, int count);

        void onInserted(int position, int count);

        void onRemoved(int position, int count);

        void onStateUpdate(LoadType loadType, boolean fromMediator, LoadState loadState);
    }

    /* JADX INFO: renamed from: androidx.paging.PagePresenter$insertPage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/LoadType;", IjkMediaMeta.IJKM_KEY_TYPE, "", "fromMediator", "Landroidx/paging/LoadState;", "state", "Lr8/z;", "invoke", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements q<LoadType, Boolean, LoadState, z> {
        final /* synthetic */ ProcessPageEventCallback $callback;

        @Override // c9.q
        public /* bridge */ /* synthetic */ z invoke(LoadType loadType, Boolean bool, LoadState loadState) {
            invoke(loadType, bool.booleanValue(), loadState);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ProcessPageEventCallback processPageEventCallback) {
            super(3);
            this.$callback = processPageEventCallback;
        }

        public final void invoke(LoadType type, boolean z10, LoadState state) {
            m.f(type, "type");
            m.f(state, "state");
            this.$callback.onStateUpdate(type, z10, state);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.REFRESH.ordinal()] = 1;
            iArr[LoadType.PREPEND.ordinal()] = 2;
            iArr[LoadType.APPEND.ordinal()] = 3;
        }
    }

    public PagePresenter(PageEvent.Insert<T> insertEvent) {
        m.f(insertEvent, "insertEvent");
        this.pages = r.Q0(insertEvent.getPages());
        this.storageCount = fullCount(insertEvent.getPages());
        this.placeholdersBefore = insertEvent.getPlaceholdersBefore();
        this.placeholdersAfter = insertEvent.getPlaceholdersAfter();
    }

    private final void checkIndex(int index) {
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + getSize());
        }
    }

    private final int dropPagesWithOffsets(e pageOffsetsToDrop) {
        Iterator<TransformablePage<T>> it = this.pages.iterator();
        int size = 0;
        while (it.hasNext()) {
            TransformablePage<T> next = it.next();
            for (int i10 : next.getOriginalPageOffsets()) {
                if (pageOffsetsToDrop.n(i10)) {
                    size += next.getData().size();
                    it.remove();
                    break;
                }
            }
        }
        return size;
    }

    private final int fullCount(List<TransformablePage<T>> list) {
        Iterator<T> it = list.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((TransformablePage) it.next()).getData().size();
        }
        return size;
    }

    private final int getOriginalPageOffsetFirst() {
        Integer numI0 = j.i0(((TransformablePage) r.g0(this.pages)).getOriginalPageOffsets());
        m.c(numI0);
        return numI0.intValue();
    }

    private final int getOriginalPageOffsetLast() {
        Integer numH0 = j.h0(((TransformablePage) r.s0(this.pages)).getOriginalPageOffsets());
        m.c(numH0);
        return numH0.intValue();
    }

    @Override // androidx.paging.NullPaddedList
    public T getFromStorage(int localIndex) {
        int size = this.pages.size();
        int i10 = 0;
        while (i10 < size) {
            int size2 = this.pages.get(i10).getData().size();
            if (size2 > localIndex) {
                break;
            }
            localIndex -= size2;
            i10++;
        }
        return this.pages.get(i10).getData().get(localIndex);
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final void processEvent(PageEvent<T> pageEvent, ProcessPageEventCallback callback) {
        m.f(pageEvent, "pageEvent");
        m.f(callback, "callback");
        if (pageEvent instanceof PageEvent.Insert) {
            insertPage((PageEvent.Insert) pageEvent, callback);
            return;
        }
        if (pageEvent instanceof PageEvent.Drop) {
            dropPages((PageEvent.Drop) pageEvent, callback);
        } else if (pageEvent instanceof PageEvent.LoadStateUpdate) {
            PageEvent.LoadStateUpdate loadStateUpdate = (PageEvent.LoadStateUpdate) pageEvent;
            callback.onStateUpdate(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
        }
    }

    private final void dropPages(PageEvent.Drop<T> drop, ProcessPageEventCallback callback) {
        int iMin;
        int size = getSize();
        LoadType loadType = drop.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            int placeholdersBefore = getPlaceholdersBefore();
            this.storageCount = getStorageCount() - dropPagesWithOffsets(new e(drop.getMinPageOffset(), drop.getMaxPageOffset()));
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            int size2 = getSize() - size;
            if (size2 > 0) {
                callback.onInserted(0, size2);
            } else if (size2 < 0) {
                callback.onRemoved(0, -size2);
            }
            int iMax = Math.max(0, placeholdersBefore + size2);
            int placeholdersRemaining = drop.getPlaceholdersRemaining() - iMax;
            if (placeholdersRemaining > 0) {
                callback.onChanged(iMax, placeholdersRemaining);
            }
            callback.onStateUpdate(loadType2, false, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
            return;
        }
        int placeholdersAfter = getPlaceholdersAfter();
        this.storageCount = getStorageCount() - dropPagesWithOffsets(new e(drop.getMinPageOffset(), drop.getMaxPageOffset()));
        this.placeholdersAfter = drop.getPlaceholdersRemaining();
        int size3 = getSize() - size;
        if (size3 > 0) {
            callback.onInserted(size, size3);
        } else if (size3 < 0) {
            callback.onRemoved(size + size3, -size3);
        }
        if (size3 < 0) {
            iMin = Math.min(placeholdersAfter, -size3);
        } else {
            iMin = 0;
        }
        int placeholdersRemaining2 = drop.getPlaceholdersRemaining() - (placeholdersAfter - iMin);
        if (placeholdersRemaining2 > 0) {
            callback.onChanged(getSize() - drop.getPlaceholdersRemaining(), placeholdersRemaining2);
        }
        callback.onStateUpdate(LoadType.APPEND, false, LoadState.NotLoading.INSTANCE.getIncomplete$paging_common());
    }

    private final void insertPage(PageEvent.Insert<T> insert, ProcessPageEventCallback callback) {
        int iFullCount = fullCount(insert.getPages());
        int size = getSize();
        int i10 = WhenMappings.$EnumSwitchMapping$0[insert.getLoadType().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    int iMin = Math.min(getPlaceholdersAfter(), iFullCount);
                    int placeholdersBefore = getPlaceholdersBefore() + getStorageCount();
                    int i11 = iFullCount - iMin;
                    List<TransformablePage<T>> list = this.pages;
                    list.addAll(list.size(), insert.getPages());
                    this.storageCount = getStorageCount() + iFullCount;
                    this.placeholdersAfter = insert.getPlaceholdersAfter();
                    callback.onChanged(placeholdersBefore, iMin);
                    callback.onInserted(placeholdersBefore + iMin, i11);
                    int size2 = (getSize() - size) - i11;
                    if (size2 > 0) {
                        callback.onInserted(getSize() - size2, size2);
                    } else if (size2 < 0) {
                        callback.onRemoved(getSize(), -size2);
                    }
                }
            } else {
                int iMin2 = Math.min(getPlaceholdersBefore(), iFullCount);
                int placeholdersBefore2 = getPlaceholdersBefore() - iMin2;
                int i12 = iFullCount - iMin2;
                this.pages.addAll(0, insert.getPages());
                this.storageCount = getStorageCount() + iFullCount;
                this.placeholdersBefore = insert.getPlaceholdersBefore();
                callback.onChanged(placeholdersBefore2, iMin2);
                callback.onInserted(0, i12);
                int size3 = (getSize() - size) - i12;
                if (size3 > 0) {
                    callback.onInserted(0, size3);
                } else if (size3 < 0) {
                    callback.onRemoved(0, -size3);
                }
            }
            insert.getCombinedLoadStates().forEach$paging_common(new AnonymousClass1(callback));
            return;
        }
        throw new IllegalArgumentException();
    }

    public final ViewportHint.Access accessHintForPresenterIndex(int index) {
        int i10 = 0;
        int placeholdersBefore = index - getPlaceholdersBefore();
        while (placeholdersBefore >= this.pages.get(i10).getData().size() && i10 < r.n(this.pages)) {
            placeholdersBefore -= this.pages.get(i10).getData().size();
            i10++;
        }
        return this.pages.get(i10).viewportHintFor(placeholdersBefore, index - getPlaceholdersBefore(), ((getSize() - index) - getPlaceholdersAfter()) - 1, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final T get(int index) {
        checkIndex(index);
        int placeholdersBefore = index - getPlaceholdersBefore();
        if (placeholdersBefore >= 0 && placeholdersBefore < getStorageCount()) {
            return getFromStorage(placeholdersBefore);
        }
        return null;
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    public final ViewportHint.Initial initializeHint() {
        int storageCount = getStorageCount() / 2;
        return new ViewportHint.Initial(storageCount, storageCount, getOriginalPageOffsetFirst(), getOriginalPageOffsetLast());
    }

    public final ItemSnapshotList<T> snapshot() {
        int placeholdersBefore = getPlaceholdersBefore();
        int placeholdersAfter = getPlaceholdersAfter();
        List<TransformablePage<T>> list = this.pages;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            r.C(arrayList, ((TransformablePage) it.next()).getData());
        }
        return new ItemSnapshotList<>(placeholdersBefore, placeholdersAfter, arrayList);
    }

    public String toString() {
        int storageCount = getStorageCount();
        ArrayList arrayList = new ArrayList(storageCount);
        for (int i10 = 0; i10 < storageCount; i10++) {
            arrayList.add(getFromStorage(i10));
        }
        return "[(" + getPlaceholdersBefore() + " placeholders), " + r.q0(arrayList, null, null, null, 0, null, null, 63, null) + ", (" + getPlaceholdersAfter() + " placeholders)]";
    }
}
