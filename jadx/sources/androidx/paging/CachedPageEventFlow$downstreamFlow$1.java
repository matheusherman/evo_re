package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.j;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.CachedPageEventFlow$downstreamFlow$1", f = "CachedPageEventFlow.kt", l = {86, 120}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/s;", "Landroidx/paging/PageEvent;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
final class CachedPageEventFlow$downstreamFlow$1<T> extends l implements p<s<? super PageEvent<T>>, v8.f<? super z>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CachedPageEventFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CachedPageEventFlow$downstreamFlow$1(CachedPageEventFlow cachedPageEventFlow, v8.f fVar) {
        super(2, fVar);
        this.this$0 = cachedPageEventFlow;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<z> create(Object obj, v8.f<?> completion) {
        m.f(completion, "completion");
        CachedPageEventFlow$downstreamFlow$1 cachedPageEventFlow$downstreamFlow$1 = new CachedPageEventFlow$downstreamFlow$1(this.this$0, completion);
        cachedPageEventFlow$downstreamFlow$1.L$0 = obj;
        return cachedPageEventFlow$downstreamFlow$1;
    }

    @Override // c9.p
    public final Object invoke(Object obj, v8.f<? super z> fVar) {
        return ((CachedPageEventFlow$downstreamFlow$1) create(obj, fVar)).invokeSuspend(z.f17874a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x007e, code lost:
    
        if (kotlinx.coroutines.e.a(r5, r12) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        s sVar;
        Object objC = b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                sVar = (s) this.L$0;
                r.b(obj);
            }
            return z.f17874a;
        }
        r.b(obj);
        sVar = (s) this.L$0;
        FlattenedPageController flattenedPageController = this.this$0.pageController;
        this.L$0 = sVar;
        this.label = 1;
        obj = flattenedPageController.createTemporaryDownstream(this);
        if (obj == objC) {
        }
        return objC;
        s sVar2 = sVar;
        TemporaryDownstream temporaryDownstream = (TemporaryDownstream) obj;
        kotlin.jvm.internal.z zVar = new kotlin.jvm.internal.z();
        zVar.element = Integer.MIN_VALUE;
        u1 u1VarD = j.d(sVar2, null, null, new CachedPageEventFlow$downstreamFlow$1$historyCollection$1(sVar2, temporaryDownstream, zVar, null), 3, null);
        u1[] u1VarArr = {j.d(sVar2, null, null, new CachedPageEventFlow$downstreamFlow$1$activeStreamCollection$1(this, sVar2, temporaryDownstream, u1VarD, zVar, null), 3, null), u1VarD};
        this.L$0 = null;
        this.label = 2;
    }
}
