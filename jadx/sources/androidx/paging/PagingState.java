package androidx.paging;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import com.pengrad.telegrambot.model.stars.partner.TransactionPartnerType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B=\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00018\u0001¢\u0006\u0004\b\u001c\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010%\u001a\u00028\u0002\"\u0004\b\u0002\u0010 2\u0006\u0010\b\u001a\u00020\u00072\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00020!H\u0080\bø\u0001\u0000¢\u0006\u0004\b#\u0010$R)\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010/\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00060"}, d2 = {"Landroidx/paging/PagingState;", "", "Key", "Value", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "pages", "", "anchorPosition", "Landroidx/paging/PagingConfig;", "config", "leadingPlaceholderCount", "<init>", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", TransactionPartnerType.OTHER, "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "closestItemToPosition", "(I)Ljava/lang/Object;", "closestPageToPosition", "(I)Landroidx/paging/PagingSource$LoadResult$Page;", "isEmpty", "()Z", "firstItemOrNull", "()Ljava/lang/Object;", "lastItemOrNull", "", "toString", "()Ljava/lang/String;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "block", "anchorPositionToPagedIndices$paging_common", "(ILc9/p;)Ljava/lang/Object;", "anchorPositionToPagedIndices", "Ljava/util/List;", "getPages", "()Ljava/util/List;", "Ljava/lang/Integer;", "getAnchorPosition", "()Ljava/lang/Integer;", "Landroidx/paging/PagingConfig;", "getConfig", "()Landroidx/paging/PagingConfig;", "I", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class PagingState<Key, Value> {
    private final Integer anchorPosition;
    private final PagingConfig config;
    private final int leadingPlaceholderCount;
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;

    public PagingState(List<PagingSource.LoadResult.Page<Key, Value>> pages, Integer num, PagingConfig config, @IntRange(from = 0) int i10) {
        m.f(pages, "pages");
        m.f(config, "config");
        this.pages = pages;
        this.anchorPosition = num;
        this.config = config;
        this.leadingPlaceholderCount = i10;
    }

    public final <T> T anchorPositionToPagedIndices$paging_common(int anchorPosition, p<? super Integer, ? super Integer, ? extends T> block) {
        m.f(block, "block");
        int size = anchorPosition - this.leadingPlaceholderCount;
        int i10 = 0;
        while (i10 < r.n(getPages()) && size > r.n(getPages().get(i10).getData())) {
            size -= getPages().get(i10).getData().size();
            i10++;
        }
        return block.invoke(Integer.valueOf(i10), Integer.valueOf(size));
    }

    public final Value closestItemToPosition(int anchorPosition) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int size = anchorPosition - this.leadingPlaceholderCount;
                int i10 = 0;
                while (i10 < r.n(getPages()) && size > r.n(getPages().get(i10).getData())) {
                    size -= getPages().get(i10).getData().size();
                    i10++;
                }
                Iterator<T> it2 = this.pages.iterator();
                while (it2.hasNext()) {
                    PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) it2.next();
                    if (!page.getData().isEmpty()) {
                        List<PagingSource.LoadResult.Page<Key, Value>> list2 = this.pages;
                        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list2.listIterator(list2.size());
                        while (listIterator.hasPrevious()) {
                            PagingSource.LoadResult.Page<Key, Value> pagePrevious = listIterator.previous();
                            if (!pagePrevious.getData().isEmpty()) {
                                if (size < 0) {
                                    return (Value) r.g0(page.getData());
                                }
                                return (i10 != r.n(this.pages) || size <= r.n(((PagingSource.LoadResult.Page) r.s0(this.pages)).getData())) ? this.pages.get(i10).getData().get(size) : (Value) r.s0(pagePrevious.getData());
                            }
                        }
                        throw new NoSuchElementException("List contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return null;
    }

    public final PagingSource.LoadResult.Page<Key, Value> closestPageToPosition(int anchorPosition) {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                int size = anchorPosition - this.leadingPlaceholderCount;
                int i10 = 0;
                while (i10 < r.n(getPages()) && size > r.n(getPages().get(i10).getData())) {
                    size -= getPages().get(i10).getData().size();
                    i10++;
                }
                return size < 0 ? (PagingSource.LoadResult.Page) r.g0(this.pages) : this.pages.get(i10);
            }
        }
        return null;
    }

    public boolean equals(Object other) {
        if (!(other instanceof PagingState)) {
            return false;
        }
        PagingState pagingState = (PagingState) other;
        return m.a(this.pages, pagingState.pages) && m.a(this.anchorPosition, pagingState.anchorPosition) && m.a(this.config, pagingState.config) && this.leadingPlaceholderCount == pagingState.leadingPlaceholderCount;
    }

    public final Value firstItemOrNull() {
        Object next;
        List<Value> data;
        Iterator<T> it = this.pages.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((PagingSource.LoadResult.Page) next).getData().isEmpty());
        PagingSource.LoadResult.Page page = (PagingSource.LoadResult.Page) next;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return (Value) r.i0(data);
    }

    public final Integer getAnchorPosition() {
        return this.anchorPosition;
    }

    public final PagingConfig getConfig() {
        return this.config;
    }

    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages() {
        return this.pages;
    }

    public int hashCode() {
        int iHashCode = this.pages.hashCode();
        Integer num = this.anchorPosition;
        return iHashCode + (num != null ? num.hashCode() : 0) + this.config.hashCode() + this.leadingPlaceholderCount;
    }

    public final boolean isEmpty() {
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((PagingSource.LoadResult.Page) it.next()).getData().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public final Value lastItemOrNull() {
        PagingSource.LoadResult.Page<Key, Value> pagePrevious;
        List<Value> data;
        List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
        ListIterator<PagingSource.LoadResult.Page<Key, Value>> listIterator = list.listIterator(list.size());
        do {
            if (!listIterator.hasPrevious()) {
                pagePrevious = null;
                break;
            }
            pagePrevious = listIterator.previous();
        } while (pagePrevious.getData().isEmpty());
        PagingSource.LoadResult.Page<Key, Value> page = pagePrevious;
        if (page == null || (data = page.getData()) == null) {
            return null;
        }
        return (Value) r.u0(data);
    }

    public String toString() {
        return "PagingState(pages=" + this.pages + ", anchorPosition=" + this.anchorPosition + ", config=" + this.config + ", leadingPlaceholderCount=" + this.leadingPlaceholderCount + ')';
    }
}
