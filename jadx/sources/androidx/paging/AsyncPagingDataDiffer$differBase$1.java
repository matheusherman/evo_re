package androidx.paging;

import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlinx.coroutines.h;
import kotlinx.coroutines.i0;
import r8.r;
import r8.z;
import v8.f;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001JO\u0010\f\u001a\u0004\u0018\u00010\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$differBase$1", "Landroidx/paging/PagingDataDiffer;", "Landroidx/paging/NullPaddedList;", "previousList", "newList", "Landroidx/paging/CombinedLoadStates;", "newCombinedLoadStates", "", "lastAccessedIndex", "Lkotlin/Function0;", "Lr8/z;", "onListPresentable", "presentNewList", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/paging/CombinedLoadStates;ILc9/a;Lv8/f;)Ljava/lang/Object;", "", "postEvents", "()Z", "paging-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class AsyncPagingDataDiffer$differBase$1<T> extends PagingDataDiffer<T> {
    final /* synthetic */ AsyncPagingDataDiffer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$differBase$1(AsyncPagingDataDiffer asyncPagingDataDiffer, DifferCallback differCallback, i0 i0Var) {
        super(differCallback, i0Var);
        this.this$0 = asyncPagingDataDiffer;
    }

    @Override // androidx.paging.PagingDataDiffer
    public boolean postEvents() {
        return this.this$0.getInGetItem();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.PagingDataDiffer
    public Object presentNewList(NullPaddedList<T> nullPaddedList, NullPaddedList<T> nullPaddedList2, CombinedLoadStates combinedLoadStates, int i10, c9.a<z> aVar, f<? super Integer> fVar) {
        AsyncPagingDataDiffer$differBase$1$presentNewList$1 asyncPagingDataDiffer$differBase$1$presentNewList$1;
        AsyncPagingDataDiffer$differBase$1<T> asyncPagingDataDiffer$differBase$1;
        if (fVar instanceof AsyncPagingDataDiffer$differBase$1$presentNewList$1) {
            asyncPagingDataDiffer$differBase$1$presentNewList$1 = (AsyncPagingDataDiffer$differBase$1$presentNewList$1) fVar;
            int i11 = asyncPagingDataDiffer$differBase$1$presentNewList$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                asyncPagingDataDiffer$differBase$1$presentNewList$1.label = i11 - Integer.MIN_VALUE;
            } else {
                asyncPagingDataDiffer$differBase$1$presentNewList$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, fVar);
            }
        } else {
            asyncPagingDataDiffer$differBase$1$presentNewList$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$1(this, fVar);
        }
        Object objG = asyncPagingDataDiffer$differBase$1$presentNewList$1.result;
        Object objC = b.c();
        int i12 = asyncPagingDataDiffer$differBase$1$presentNewList$1.label;
        if (i12 == 0) {
            r.b(objG);
            if (nullPaddedList.getSize() == 0) {
                aVar.invoke();
                this.this$0.getDifferCallback().onInserted(0, nullPaddedList2.getSize());
                return null;
            }
            if (nullPaddedList2.getSize() == 0) {
                aVar.invoke();
                this.this$0.getDifferCallback().onRemoved(0, nullPaddedList.getSize());
                return null;
            }
            i0 i0Var = this.this$0.workerDispatcher;
            AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 asyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 = new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(this, nullPaddedList, nullPaddedList2, null);
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$0 = this;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$1 = nullPaddedList;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$2 = nullPaddedList2;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.L$3 = aVar;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.I$0 = i10;
            asyncPagingDataDiffer$differBase$1$presentNewList$1.label = 1;
            objG = h.g(i0Var, asyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1, asyncPagingDataDiffer$differBase$1$presentNewList$1);
            if (objG == objC) {
                return objC;
            }
            asyncPagingDataDiffer$differBase$1 = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = asyncPagingDataDiffer$differBase$1$presentNewList$1.I$0;
            aVar = (c9.a) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$3;
            nullPaddedList2 = (NullPaddedList) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$2;
            nullPaddedList = (NullPaddedList) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$1;
            asyncPagingDataDiffer$differBase$1 = (AsyncPagingDataDiffer$differBase$1) asyncPagingDataDiffer$differBase$1$presentNewList$1.L$0;
            r.b(objG);
        }
        DiffUtil.DiffResult diffResult = (DiffUtil.DiffResult) objG;
        aVar.invoke();
        NullPaddedListDiffHelperKt.dispatchDiff(nullPaddedList, asyncPagingDataDiffer$differBase$1.this$0.updateCallback, nullPaddedList2, diffResult);
        return kotlin.coroutines.jvm.internal.b.b(NullPaddedListDiffHelperKt.transformAnchorIndex(nullPaddedList, diffResult, nullPaddedList2, i10));
    }
}
