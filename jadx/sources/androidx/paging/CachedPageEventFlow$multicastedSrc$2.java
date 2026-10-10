package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.k;
import r8.z;
import v8.f;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/h0;", "Landroidx/paging/PageEvent;", "p1", "Lr8/z;", "invoke", "(Lkotlin/collections/h0;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final /* synthetic */ class CachedPageEventFlow$multicastedSrc$2<T> extends k implements p<IndexedValue<? extends PageEvent<T>>, f<? super z>, Object> {
    CachedPageEventFlow$multicastedSrc$2(FlattenedPageController flattenedPageController) {
        super(2, flattenedPageController, FlattenedPageController.class, "record", "record(Lkotlin/collections/IndexedValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // c9.p
    public final Object invoke(IndexedValue<? extends PageEvent<T>> indexedValue, f<? super z> fVar) {
        return ((FlattenedPageController) this.receiver).record(indexedValue, fVar);
    }
}
