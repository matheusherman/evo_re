package androidx.paging.multicast;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.flow.g;
import kotlinx.coroutines.flow.h;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.multicast.Multicaster$flow$1", f = "Multicaster.kt", l = {100}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class Multicaster$flow$1<T> extends l implements p<g<? super T>, v8.f<? super z>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Multicaster this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Multicaster$flow$1(Multicaster multicaster, v8.f fVar) {
        super(2, fVar);
        this.this$0 = multicaster;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        Multicaster$flow$1 multicaster$flow$1 = new Multicaster$flow$1(this.this$0, completion);
        multicaster$flow$1.L$0 = obj;
        return multicaster$flow$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((Multicaster$flow$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
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
            g<? super T> gVar = (g) this.L$0;
            d dVarB = kotlinx.coroutines.channels.g.b(Integer.MAX_VALUE, null, null, 6, null);
            kotlinx.coroutines.flow.f fVarB = h.B(h.v(new Multicaster$flow$1$invokeSuspend$$inlined$transform$1(h.D(h.l(dVarB), new Multicaster$flow$1$subFlow$1(this, dVarB, null)), null)), new Multicaster$flow$1$subFlow$3(this, dVarB, null));
            this.label = 1;
            if (fVarB.collect(gVar, this) == objC) {
                return objC;
            }
        }
        return z.f17874a;
    }
}
