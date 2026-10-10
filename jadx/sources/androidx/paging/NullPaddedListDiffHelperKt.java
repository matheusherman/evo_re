package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import h9.f;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a?\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a3\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/paging/NullPaddedList;", "newList", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "computeDiff", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "Landroidx/recyclerview/widget/ListUpdateCallback;", "callback", "diffResult", "Lr8/z;", "dispatchDiff", "(Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/DiffUtil$DiffResult;)V", "", "oldPosition", "transformAnchorIndex", "(Landroidx/paging/NullPaddedList;Landroidx/recyclerview/widget/DiffUtil$DiffResult;Landroidx/paging/NullPaddedList;I)I", "paging-runtime_release"}, k = 2, mv = {1, 4, 1})
public final class NullPaddedListDiffHelperKt {
    public static final <T> DiffUtil.DiffResult computeDiff(final NullPaddedList<T> computeDiff, final NullPaddedList<T> newList, final DiffUtil.ItemCallback<T> diffCallback) {
        m.f(computeDiff, "$this$computeDiff");
        m.f(newList, "newList");
        m.f(diffCallback, "diffCallback");
        final int storageCount = computeDiff.getStorageCount();
        final int storageCount2 = newList.getStorageCount();
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.paging.NullPaddedListDiffHelperKt.computeDiff.1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                Object fromStorage = computeDiff.getFromStorage(oldItemPosition);
                Object fromStorage2 = newList.getFromStorage(newItemPosition);
                if (fromStorage == fromStorage2) {
                    return true;
                }
                return diffCallback.areContentsTheSame(fromStorage, fromStorage2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                Object fromStorage = computeDiff.getFromStorage(oldItemPosition);
                Object fromStorage2 = newList.getFromStorage(newItemPosition);
                if (fromStorage == fromStorage2) {
                    return true;
                }
                return diffCallback.areItemsTheSame(fromStorage, fromStorage2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int oldItemPosition, int newItemPosition) {
                Object fromStorage = computeDiff.getFromStorage(oldItemPosition);
                Object fromStorage2 = newList.getFromStorage(newItemPosition);
                return fromStorage == fromStorage2 ? Boolean.TRUE : diffCallback.getChangePayload(fromStorage, fromStorage2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* JADX INFO: renamed from: getNewListSize, reason: from getter */
            public int get$newSize() {
                return storageCount2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            /* JADX INFO: renamed from: getOldListSize, reason: from getter */
            public int get$oldSize() {
                return storageCount;
            }
        }, true);
        m.e(diffResultCalculateDiff, "DiffUtil.calculateDiff(\n…    },\n        true\n    )");
        return diffResultCalculateDiff;
    }

    public static final <T> void dispatchDiff(NullPaddedList<T> dispatchDiff, ListUpdateCallback callback, NullPaddedList<T> newList, DiffUtil.DiffResult diffResult) {
        m.f(dispatchDiff, "$this$dispatchDiff");
        m.f(callback, "callback");
        m.f(newList, "newList");
        m.f(diffResult, "diffResult");
        int placeholdersAfter = dispatchDiff.getPlaceholdersAfter();
        int placeholdersAfter2 = newList.getPlaceholdersAfter();
        int placeholdersBefore = dispatchDiff.getPlaceholdersBefore();
        int placeholdersBefore2 = newList.getPlaceholdersBefore();
        if (placeholdersAfter == 0 && placeholdersAfter2 == 0 && placeholdersBefore == 0 && placeholdersBefore2 == 0) {
            diffResult.dispatchUpdatesTo(callback);
            return;
        }
        if (placeholdersAfter > placeholdersAfter2) {
            int i10 = placeholdersAfter - placeholdersAfter2;
            callback.onRemoved(dispatchDiff.getSize() - i10, i10);
        } else if (placeholdersAfter < placeholdersAfter2) {
            callback.onInserted(dispatchDiff.getSize(), placeholdersAfter2 - placeholdersAfter);
        }
        if (placeholdersBefore > placeholdersBefore2) {
            callback.onRemoved(0, placeholdersBefore - placeholdersBefore2);
        } else if (placeholdersBefore < placeholdersBefore2) {
            callback.onInserted(0, placeholdersBefore2 - placeholdersBefore);
        }
        if (placeholdersBefore2 != 0) {
            diffResult.dispatchUpdatesTo(new OffsettingListUpdateCallback(placeholdersBefore2, callback));
        } else {
            diffResult.dispatchUpdatesTo(callback);
        }
    }

    public static final int transformAnchorIndex(NullPaddedList<?> transformAnchorIndex, DiffUtil.DiffResult diffResult, NullPaddedList<?> newList, int i10) {
        int iConvertOldPositionToNew;
        m.f(transformAnchorIndex, "$this$transformAnchorIndex");
        m.f(diffResult, "diffResult");
        m.f(newList, "newList");
        int placeholdersBefore = i10 - transformAnchorIndex.getPlaceholdersBefore();
        int storageCount = transformAnchorIndex.getStorageCount();
        if (placeholdersBefore >= 0 && storageCount > placeholdersBefore) {
            for (int i11 = 0; i11 <= 29; i11++) {
                int i12 = ((i11 / 2) * (i11 % 2 == 1 ? -1 : 1)) + placeholdersBefore;
                if (i12 >= 0 && i12 < transformAnchorIndex.getStorageCount() && (iConvertOldPositionToNew = diffResult.convertOldPositionToNew(i12)) != -1) {
                    return iConvertOldPositionToNew + newList.getPlaceholdersBefore();
                }
            }
        }
        return f.i(i10, f.m(0, newList.getSize()));
    }
}
