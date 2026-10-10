package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1", f = "AsyncPagingDataDiffer.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1 extends l implements p<l0, v8.f<? super DiffUtil.DiffResult>, Object> {
    final /* synthetic */ NullPaddedList $newList;
    final /* synthetic */ NullPaddedList $previousList;
    int label;
    final /* synthetic */ AsyncPagingDataDiffer$differBase$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(AsyncPagingDataDiffer$differBase$1 asyncPagingDataDiffer$differBase$1, NullPaddedList nullPaddedList, NullPaddedList nullPaddedList2, v8.f fVar) {
        super(2, fVar);
        this.this$0 = asyncPagingDataDiffer$differBase$1;
        this.$previousList = nullPaddedList;
        this.$newList = nullPaddedList2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1(this.this$0, this.$previousList, this.$newList, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super DiffUtil.DiffResult> fVar) {
        return ((AsyncPagingDataDiffer$differBase$1$presentNewList$diffResult$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            r.b(obj);
            return NullPaddedListDiffHelperKt.computeDiff(this.$previousList, this.$newList, this.this$0.this$0.diffCallback);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
