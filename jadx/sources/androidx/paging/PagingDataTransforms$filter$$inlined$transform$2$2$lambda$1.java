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

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PagingDataTransforms$filter$2$1", f = "PagingDataTransforms.kt", l = {107}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$filter$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1<T> extends l implements p<l0, v8.f<? super PageEvent<T>>, Object> {
    final /* synthetic */ PageEvent $event;
    int label;
    final /* synthetic */ PagingDataTransforms$filter$$inlined$transform$2.AnonymousClass2 this$0;

    /* JADX INFO: renamed from: androidx.paging.PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.PagingDataTransforms$filter$2$1$1", f = "PagingDataTransforms.kt", l = {}, m = "invokeSuspend")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/PagingDataTransforms$filter$2$1$1"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends l implements p<T, v8.f<? super Boolean>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(completion);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(Object obj, v8.f<? super Boolean> fVar) {
            return ((AnonymousClass1) create(obj, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.label == 0) {
                r.b(obj);
                return PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1.this.this$0.this$0.$predicate$inlined.invoke(this.L$0);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1(PageEvent pageEvent, v8.f fVar, PagingDataTransforms$filter$$inlined$transform$2.AnonymousClass2 anonymousClass2) {
        super(2, fVar);
        this.$event = pageEvent;
        this.this$0 = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1(this.$event, completion, this.this$0);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, Object obj) {
        return ((PagingDataTransforms$filter$$inlined$transform$2$2$lambda$1) create(l0Var, (v8.f) obj)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
                return obj;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        r.b(obj);
        PageEvent pageEvent = this.$event;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
        this.label = 1;
        Object objFilter = pageEvent.filter(anonymousClass1, this);
        if (objFilter == objC) {
            return objC;
        }
        return objFilter;
    }
}
