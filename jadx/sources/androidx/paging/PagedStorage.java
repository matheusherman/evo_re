package androidx.paging;

import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import h9.f;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\"\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001cB\t\b\u0016¢\u0006\u0004\b\u0006\u0010\u0007B+\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\rB\u0017\b\u0012\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u0006\u0010\u000fJA\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0015JD\u0010\u001a\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00162\u0006\u0010\u0017\u001a\u00020\b2$\b\u0004\u0010\u0019\u001a\u001e\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00010\u0018H\u0082\b¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b!\u0010\"JK\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010%J\u0017\u0010&\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J!\u0010+\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u0000\u0018\u00010*2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u0004\u0018\u00018\u00002\u0006\u0010-\u001a\u00020\bH\u0096\u0002¢\u0006\u0004\b.\u0010'J\u001d\u0010/\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b/\u00100J\u001d\u00101\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b¢\u0006\u0004\b1\u00100J%\u00103\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u00102\u001a\u00020\b¢\u0006\u0004\b3\u0010 J/\u00107\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b5\u00106J/\u00109\u001a\u00020\u00112\u0006\u00104\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b8\u00106J-\u0010<\u001a\u00020\u00132\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0004\b:\u0010;J-\u0010>\u001a\u00020\u00132\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0004\b=\u0010;J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AR$\u0010C\u001a\u0012\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\n0B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR$\u0010F\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR$\u0010J\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bJ\u0010G\u001a\u0004\bK\u0010IR$\u0010\u0010\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0010\u0010G\u001a\u0004\bL\u0010IR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010MR$\u0010N\u001a\u00020\b2\u0006\u0010E\u001a\u00020\b8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bN\u0010G\u001a\u0004\bO\u0010IR\u0016\u0010P\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010GR\u0014\u0010S\u001a\u00028\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00028\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bT\u0010RR$\u0010Z\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010I\"\u0004\bX\u0010YR\u0011\u0010\\\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b[\u0010IR\u0016\u0010^\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010RR\u0016\u0010`\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b_\u0010RR\u0014\u0010b\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\ba\u0010I¨\u0006d"}, d2 = {"Landroidx/paging/PagedStorage;", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "<init>", "()V", "", "leadingNulls", "Landroidx/paging/PagingSource$LoadResult$Page;", "page", "trailingNulls", "(ILandroidx/paging/PagingSource$LoadResult$Page;I)V", TransactionPartnerType.OTHER, "(Landroidx/paging/PagedStorage;)V", "positionOffset", "", "counted", "Lr8/z;", "init", "(ILandroidx/paging/PagingSource$LoadResult$Page;IIZ)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "localIndex", "Lkotlin/Function2;", "onLastPage", "traversePages", "(ILc9/p;)Ljava/lang/Object;", "maxSize", "requiredRemaining", "localPageIndex", "needsTrim", "(III)Z", "snapshot", "()Landroidx/paging/PagedStorage;", "Landroidx/paging/PagedStorage$Callback;", "callback", "(ILandroidx/paging/PagingSource$LoadResult$Page;IILandroidx/paging/PagedStorage$Callback;Z)V", "getFromStorage", "(I)Ljava/lang/Object;", "Landroidx/paging/PagedList$Config;", "config", "Landroidx/paging/PagingState;", "getRefreshKeyInfo", "(Landroidx/paging/PagedList$Config;)Landroidx/paging/PagingState;", "index", "get", "needsTrimFromFront", "(II)Z", "needsTrimFromEnd", "countToBeAdded", "shouldPreTrimNewPage", "insertNulls", "trimFromFront$paging_common", "(ZIILandroidx/paging/PagedStorage$Callback;)Z", "trimFromFront", "trimFromEnd$paging_common", "trimFromEnd", "prependPage$paging_common", "(Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedStorage$Callback;)V", "prependPage", "appendPage$paging_common", "appendPage", "", "toString", "()Ljava/lang/String;", "", "pages", "Ljava/util/List;", "<set-?>", "placeholdersBefore", "I", "getPlaceholdersBefore", "()I", "placeholdersAfter", "getPlaceholdersAfter", "getPositionOffset", "Z", "storageCount", "getStorageCount", "lastLoadAroundLocalIndex", "getFirstLoadedItem$paging_common", "()Ljava/lang/Object;", "firstLoadedItem", "getLastLoadedItem$paging_common", "lastLoadedItem", "value", "getLastLoadAroundIndex", "setLastLoadAroundIndex", "(I)V", "lastLoadAroundIndex", "getMiddleOfLoadedRange", "middleOfLoadedRange", "getPrevKey", "prevKey", "getNextKey", "nextKey", "getSize", "size", "Callback", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PagedStorage<T> extends AbstractList<T> implements LegacyPageFetcher.KeyProvider<Object>, NullPaddedList<T> {
    private boolean counted;
    private int lastLoadAroundLocalIndex;
    private final List<PagingSource.LoadResult.Page<?, T>> pages;
    private int placeholdersAfter;
    private int placeholdersBefore;
    private int positionOffset;
    private int storageCount;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagedStorage$Callback;", "", "", "count", "Lr8/z;", "onInitialized", "(I)V", "leadingNulls", "changed", "added", "onPagePrepended", "(III)V", "endPosition", "onPageAppended", "startOfDrops", "onPagesRemoved", "(II)V", "onPagesSwappedToPlaceholder", "paging-common"}, k = 1, mv = {1, 4, 1})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public interface Callback {
        void onInitialized(int count);

        void onPageAppended(int endPosition, int changed, int added);

        void onPagePrepended(int leadingNulls, int changed, int added);

        void onPagesRemoved(int startOfDrops, int count);

        void onPagesSwappedToPlaceholder(int startOfDrops, int count);
    }

    public PagedStorage() {
        this.pages = new ArrayList();
        this.counted = true;
    }

    private final void init(int leadingNulls, PagingSource.LoadResult.Page<?, T> page, int trailingNulls, int positionOffset, boolean counted) {
        this.placeholdersBefore = leadingNulls;
        this.pages.clear();
        this.pages.add(page);
        this.placeholdersAfter = trailingNulls;
        this.positionOffset = positionOffset;
        this.storageCount = page.getData().size();
        this.counted = counted;
        this.lastLoadAroundLocalIndex = page.getData().size() / 2;
    }

    public final boolean needsTrimFromFront(int maxSize, int requiredRemaining) {
        return needsTrim(maxSize, requiredRemaining, 0);
    }

    public static /* synthetic */ void appendPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            callback = null;
        }
        pagedStorage.appendPage$paging_common(page, callback);
    }

    private final boolean needsTrim(int maxSize, int requiredRemaining, int localPageIndex) {
        return getStorageCount() > maxSize && this.pages.size() > 2 && getStorageCount() - this.pages.get(localPageIndex).getData().size() >= requiredRemaining;
    }

    public static /* synthetic */ void prependPage$paging_common$default(PagedStorage pagedStorage, PagingSource.LoadResult.Page page, Callback callback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            callback = null;
        }
        pagedStorage.prependPage$paging_common(page, callback);
    }

    public final void appendPage$paging_common(PagingSource.LoadResult.Page<?, T> page, Callback callback) {
        m.f(page, "page");
        int size = page.getData().size();
        if (size == 0) {
            return;
        }
        this.pages.add(page);
        this.storageCount = getStorageCount() + size;
        int iMin = Math.min(getPlaceholdersAfter(), size);
        int i10 = size - iMin;
        if (iMin != 0) {
            this.placeholdersAfter = getPlaceholdersAfter() - iMin;
        }
        if (callback != null) {
            callback.onPageAppended((getPlaceholdersBefore() + getStorageCount()) - size, iMin, i10);
        }
    }

    public final T getFirstLoadedItem$paging_common() {
        return (T) r.g0(((PagingSource.LoadResult.Page) r.g0(this.pages)).getData());
    }

    public final T getLastLoadedItem$paging_common() {
        return (T) r.s0(((PagingSource.LoadResult.Page) r.s0(this.pages)).getData());
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getNextKey() {
        if (!this.counted || getPlaceholdersAfter() > 0) {
            return ((PagingSource.LoadResult.Page) r.s0(this.pages)).getNextKey();
        }
        return null;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    @Override // androidx.paging.NullPaddedList
    public int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final int getPositionOffset() {
        return this.positionOffset;
    }

    @Override // androidx.paging.LegacyPageFetcher.KeyProvider
    public Object getPrevKey() {
        if (!this.counted || getPlaceholdersBefore() + this.positionOffset > 0) {
            return ((PagingSource.LoadResult.Page) r.g0(this.pages)).getPrevKey();
        }
        return null;
    }

    public final PagingState<?, T> getRefreshKeyInfo(PagedList.Config config) {
        m.f(config, "config");
        if (this.pages.isEmpty()) {
            return null;
        }
        List listO0 = r.O0(this.pages);
        if (listO0 != null) {
            return new PagingState<>(listO0, Integer.valueOf(getLastLoadAroundIndex()), new PagingConfig(config.pageSize, config.prefetchDistance, config.enablePlaceholders, config.initialLoadSizeHint, config.maxSize, 0, 32, null), getPlaceholdersBefore());
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T>>");
    }

    @Override // androidx.paging.NullPaddedList
    public int getStorageCount() {
        return this.storageCount;
    }

    public final boolean needsTrimFromEnd(int maxSize, int requiredRemaining) {
        return needsTrim(maxSize, requiredRemaining, this.pages.size() - 1);
    }

    public final void prependPage$paging_common(PagingSource.LoadResult.Page<?, T> page, Callback callback) {
        m.f(page, "page");
        int size = page.getData().size();
        if (size == 0) {
            return;
        }
        this.pages.add(0, page);
        this.storageCount = getStorageCount() + size;
        int iMin = Math.min(getPlaceholdersBefore(), size);
        int i10 = size - iMin;
        if (iMin != 0) {
            this.placeholdersBefore = getPlaceholdersBefore() - iMin;
        }
        this.positionOffset -= i10;
        if (callback != null) {
            callback.onPagePrepended(getPlaceholdersBefore(), iMin, i10);
        }
    }

    public final PagedStorage<T> snapshot() {
        return new PagedStorage<>(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "leading " + getPlaceholdersBefore() + ", storage " + getStorageCount() + ", trailing " + getPlaceholdersAfter() + ' ' + r.q0(this.pages, " ", null, null, 0, null, null, 62, null);
    }

    public final boolean trimFromEnd$paging_common(boolean insertNulls, int maxSize, int requiredRemaining, Callback callback) {
        m.f(callback, "callback");
        int i10 = 0;
        while (needsTrimFromEnd(maxSize, requiredRemaining)) {
            List<PagingSource.LoadResult.Page<?, T>> list = this.pages;
            int size = list.remove(list.size() - 1).getData().size();
            i10 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = f.e(this.lastLoadAroundLocalIndex, getStorageCount() - 1);
        if (i10 > 0) {
            int placeholdersBefore = getPlaceholdersBefore() + getStorageCount();
            if (insertNulls) {
                this.placeholdersAfter = getPlaceholdersAfter() + i10;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore, i10);
            } else {
                callback.onPagesRemoved(placeholdersBefore, i10);
            }
        }
        return i10 > 0;
    }

    public final boolean trimFromFront$paging_common(boolean insertNulls, int maxSize, int requiredRemaining, Callback callback) {
        m.f(callback, "callback");
        int i10 = 0;
        while (needsTrimFromFront(maxSize, requiredRemaining)) {
            int size = this.pages.remove(0).getData().size();
            i10 += size;
            this.storageCount = getStorageCount() - size;
        }
        this.lastLoadAroundLocalIndex = f.c(this.lastLoadAroundLocalIndex - i10, 0);
        if (i10 > 0) {
            if (insertNulls) {
                int placeholdersBefore = getPlaceholdersBefore();
                this.placeholdersBefore = getPlaceholdersBefore() + i10;
                callback.onPagesSwappedToPlaceholder(placeholdersBefore, i10);
            } else {
                this.positionOffset += i10;
                callback.onPagesRemoved(getPlaceholdersBefore(), i10);
            }
        }
        return i10 > 0;
    }

    private final <V> V traversePages(int localIndex, p<? super PagingSource.LoadResult.Page<?, T>, ? super Integer, ? extends V> onLastPage) {
        int size = this.pages.size();
        int i10 = 0;
        while (i10 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.pages.get(i10)).getData().size();
            if (size2 > localIndex) {
                break;
            }
            localIndex -= size2;
            i10++;
        }
        return onLastPage.invoke((Object) this.pages.get(i10), Integer.valueOf(localIndex));
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int index) {
        int placeholdersBefore = index - getPlaceholdersBefore();
        if (index >= 0 && index < size()) {
            if (placeholdersBefore >= 0 && placeholdersBefore < getStorageCount()) {
                return getFromStorage(placeholdersBefore);
            }
            return null;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
    }

    @Override // androidx.paging.NullPaddedList
    public T getFromStorage(int localIndex) {
        int size = this.pages.size();
        int i10 = 0;
        while (i10 < size) {
            int size2 = ((PagingSource.LoadResult.Page) this.pages.get(i10)).getData().size();
            if (size2 > localIndex) {
                break;
            }
            localIndex -= size2;
            i10++;
        }
        return (T) ((PagingSource.LoadResult.Page) this.pages.get(i10)).getData().get(localIndex);
    }

    public final int getLastLoadAroundIndex() {
        return getPlaceholdersBefore() + this.lastLoadAroundLocalIndex;
    }

    public final int getMiddleOfLoadedRange() {
        return getPlaceholdersBefore() + (getStorageCount() / 2);
    }

    @Override // androidx.paging.NullPaddedList
    public int getSize() {
        return getPlaceholdersBefore() + getStorageCount() + getPlaceholdersAfter();
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ T remove(int i10) {
        return (T) removeAt(i10);
    }

    public /* bridge */ Object removeAt(int i10) {
        return super.remove(i10);
    }

    public final void setLastLoadAroundIndex(int i10) {
        this.lastLoadAroundLocalIndex = f.h(i10 - getPlaceholdersBefore(), 0, getStorageCount() - 1);
    }

    public final boolean shouldPreTrimNewPage(int maxSize, int requiredRemaining, int countToBeAdded) {
        if (getStorageCount() + countToBeAdded > maxSize && this.pages.size() > 1 && getStorageCount() >= requiredRemaining) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PagedStorage(int i10, PagingSource.LoadResult.Page<?, T> page, int i11) {
        this();
        m.f(page, "page");
        init(i10, page, i11, 0, true);
    }

    private PagedStorage(PagedStorage<T> pagedStorage) {
        ArrayList arrayList = new ArrayList();
        this.pages = arrayList;
        this.counted = true;
        arrayList.addAll(pagedStorage.pages);
        this.placeholdersBefore = pagedStorage.getPlaceholdersBefore();
        this.placeholdersAfter = pagedStorage.getPlaceholdersAfter();
        this.positionOffset = pagedStorage.positionOffset;
        this.counted = pagedStorage.counted;
        this.storageCount = pagedStorage.getStorageCount();
        this.lastLoadAroundLocalIndex = pagedStorage.lastLoadAroundLocalIndex;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void init(int leadingNulls, PagingSource.LoadResult.Page<?, T> page, int trailingNulls, int positionOffset, Callback callback, boolean counted) {
        m.f(page, "page");
        m.f(callback, "callback");
        init(leadingNulls, page, trailingNulls, positionOffset, counted);
        callback.onInitialized(size());
    }
}
