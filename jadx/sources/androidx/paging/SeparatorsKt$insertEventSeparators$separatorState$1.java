package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import c9.q;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import r8.r;
import r8.z;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@f(c = "androidx.paging.SeparatorsKt$insertEventSeparators$separatorState$1", f = "Separators.kt", l = {516}, m = "invokeSuspend")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0002*\u0002H\u0001\"\b\b\u0001\u0010\u0001*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u0001H\u0002H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "R", ExifInterface.GPS_DIRECTION_TRUE, "", "before", "after", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
final class SeparatorsKt$insertEventSeparators$separatorState$1<R, T> extends l implements q<T, T, v8.f<? super R>, Object> {
    final /* synthetic */ q $generator;
    private /* synthetic */ Object L$0;
    private /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SeparatorsKt$insertEventSeparators$separatorState$1(q qVar, v8.f fVar) {
        super(3, fVar);
        this.$generator = qVar;
    }

    public final v8.f<z> create(T t10, T t11, v8.f<? super R> continuation) {
        m.f(continuation, "continuation");
        SeparatorsKt$insertEventSeparators$separatorState$1 separatorsKt$insertEventSeparators$separatorState$1 = new SeparatorsKt$insertEventSeparators$separatorState$1(this.$generator, continuation);
        separatorsKt$insertEventSeparators$separatorState$1.L$0 = t10;
        separatorsKt$insertEventSeparators$separatorState$1.L$1 = t11;
        return separatorsKt$insertEventSeparators$separatorState$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c9.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((SeparatorsKt$insertEventSeparators$separatorState$1) create(obj, obj2, (v8.f) obj3)).invokeSuspend(z.f17874a);
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
        Object obj2 = this.L$0;
        Object obj3 = this.L$1;
        q qVar = this.$generator;
        this.L$0 = null;
        this.label = 1;
        Object objInvoke = qVar.invoke(obj2, obj3, this);
        if (objInvoke == objC) {
            return objC;
        }
        return objInvoke;
    }
}
