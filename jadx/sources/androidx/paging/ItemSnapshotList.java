package androidx.paging;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.d;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002B)\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u0010\u0010\u000fR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/paging/ItemSnapshotList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/d;", "", "placeholdersBefore", "placeholdersAfter", "", "items", "<init>", "(IILjava/util/List;)V", "index", "get", "(I)Ljava/lang/Object;", "I", "getPlaceholdersBefore", "()I", "getPlaceholdersAfter", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "getSize", "size", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class ItemSnapshotList<T> extends d<T> {
    private final List<T> items;
    private final int placeholdersAfter;
    private final int placeholdersBefore;

    /* JADX WARN: Multi-variable type inference failed */
    public ItemSnapshotList(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, List<? extends T> items) {
        m.f(items, "items");
        this.placeholdersBefore = i10;
        this.placeholdersAfter = i11;
        this.items = items;
    }

    @Override // kotlin.collections.d, java.util.List
    public T get(int index) {
        int i10 = this.placeholdersBefore;
        if (index >= 0 && i10 > index) {
            return null;
        }
        int size = this.items.size() + i10;
        if (i10 <= index && size > index) {
            return this.items.get(index - this.placeholdersBefore);
        }
        int size2 = this.placeholdersBefore + this.items.size();
        int size3 = size();
        if (size2 <= index && size3 > index) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + index + " in ItemSnapshotList of size " + size());
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    @Override // kotlin.collections.d, kotlin.collections.b
    /* JADX INFO: renamed from: getSize */
    public int get_size() {
        return this.placeholdersBefore + this.items.size() + this.placeholdersAfter;
    }
}
