package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
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
@f(c = "androidx.paging.ContiguousPagedList$deferBoundaryCallbacks$1", f = "ContiguousPagedList.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class ContiguousPagedList$deferBoundaryCallbacks$1 extends l implements p<l0, v8.f<? super z>, Object> {
    final /* synthetic */ boolean $deferBegin;
    final /* synthetic */ boolean $deferEmpty;
    final /* synthetic */ boolean $deferEnd;
    int label;
    final /* synthetic */ ContiguousPagedList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContiguousPagedList$deferBoundaryCallbacks$1(ContiguousPagedList contiguousPagedList, boolean z10, boolean z11, boolean z12, v8.f fVar) {
        super(2, fVar);
        this.this$0 = contiguousPagedList;
        this.$deferEmpty = z10;
        this.$deferBegin = z11;
        this.$deferEnd = z12;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new ContiguousPagedList$deferBoundaryCallbacks$1(this.this$0, this.$deferEmpty, this.$deferBegin, this.$deferEnd, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((ContiguousPagedList$deferBoundaryCallbacks$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            r.b(obj);
            if (this.$deferEmpty) {
                this.this$0.getBoundaryCallback$paging_common().onZeroItemsLoaded();
            }
            if (this.$deferBegin) {
                this.this$0.boundaryCallbackBeginDeferred = true;
            }
            if (this.$deferEnd) {
                this.this$0.boundaryCallbackEndDeferred = true;
            }
            this.this$0.tryDispatchBoundaryCallbacks(false);
            return z.f17874a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
