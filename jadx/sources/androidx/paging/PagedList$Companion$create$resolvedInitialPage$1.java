package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import r8.n;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T, K] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PagedList$Companion$create$resolvedInitialPage$1", f = "PagedList.kt", l = {183}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Landroidx/paging/PagingSource$LoadResult$Page;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PagedList$Companion$create$resolvedInitialPage$1<K, T> extends l implements p<l0, v8.f<? super PagingSource.LoadResult.Page<K, T>>, Object> {
    final /* synthetic */ PagingSource $pagingSource;
    final /* synthetic */ b0 $params;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedList$Companion$create$resolvedInitialPage$1(PagingSource pagingSource, b0 b0Var, v8.f fVar) {
        super(2, fVar);
        this.$pagingSource = pagingSource;
        this.$params = b0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new PagedList$Companion$create$resolvedInitialPage$1(this.$pagingSource, this.$params, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, Object obj) {
        return ((PagedList$Companion$create$resolvedInitialPage$1) create(l0Var, (v8.f) obj)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            r.b(obj);
            PagingSource pagingSource = this.$pagingSource;
            PagingSource.LoadParams.Refresh refresh = (PagingSource.LoadParams.Refresh) this.$params.element;
            this.label = 1;
            obj = pagingSource.load(refresh, this);
            if (obj == objC) {
                return objC;
            }
        }
        PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
        if (loadResult instanceof PagingSource.LoadResult.Page) {
            return (PagingSource.LoadResult.Page) loadResult;
        }
        if (loadResult instanceof PagingSource.LoadResult.Error) {
            throw ((PagingSource.LoadResult.Error) loadResult).getThrowable();
        }
        throw new n();
    }
}
