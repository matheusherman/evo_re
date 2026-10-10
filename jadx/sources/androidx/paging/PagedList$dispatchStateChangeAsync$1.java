package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.PagedList$dispatchStateChangeAsync$1", f = "PagedList.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class PagedList$dispatchStateChangeAsync$1 extends l implements p<l0, v8.f<? super z>, Object> {
    final /* synthetic */ LoadState $state;
    final /* synthetic */ LoadType $type;
    int label;
    final /* synthetic */ PagedList this$0;

    /* JADX INFO: renamed from: androidx.paging.PagedList$dispatchStateChangeAsync$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001e\u0010\u0007\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00030\u0002H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ref/WeakReference;", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "Lr8/z;", "it", "", "invoke", "(Ljava/lang/ref/WeakReference;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends o implements c9.l<WeakReference<p<? super LoadType, ? super LoadState, ? extends z>>, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // c9.l
        public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<p<? super LoadType, ? super LoadState, ? extends z>> weakReference) {
            return Boolean.valueOf(invoke2((WeakReference<p<LoadType, LoadState, z>>) weakReference));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(WeakReference<p<LoadType, LoadState, z>> it) {
            m.f(it, "it");
            return it.get() == null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedList$dispatchStateChangeAsync$1(PagedList pagedList, LoadType loadType, LoadState loadState, v8.f fVar) {
        super(2, fVar);
        this.this$0 = pagedList;
        this.$type = loadType;
        this.$state = loadState;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        return new PagedList$dispatchStateChangeAsync$1(this.this$0, this.$type, this.$state, completion);
    }

    @Override // c9.p
    public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
        return ((PagedList$dispatchStateChangeAsync$1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        b.c();
        if (this.label == 0) {
            r.b(obj);
            kotlin.collections.r.I(this.this$0.loadStateListeners, AnonymousClass1.INSTANCE);
            Iterator it = this.this$0.loadStateListeners.iterator();
            while (it.hasNext()) {
                p pVar = (p) ((WeakReference) it.next()).get();
                if (pVar != null) {
                }
            }
            return z.f17874a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
