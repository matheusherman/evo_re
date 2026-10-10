package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\u000e\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a1\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/f;", "Lr8/z;", "a", "(Lkotlinx/coroutines/flow/f;Lv8/f;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "scope", "Lkotlinx/coroutines/u1;", "d", "(Lkotlinx/coroutines/flow/f;Lkotlinx/coroutines/l0;)Lkotlinx/coroutines/u1;", "Lkotlin/Function2;", "Lv8/f;", "", "action", "b", "(Lkotlinx/coroutines/flow/f;Lc9/p;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/g;", "flow", "c", "(Lkotlinx/coroutines/flow/g;Lkotlinx/coroutines/flow/f;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class k {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__CollectKt$launchIn$1", f = "Collect.kt", l = {50}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ f<T> $this_launchIn;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(f<? extends T> fVar, v8.f<? super a> fVar2) {
            super(2, fVar2);
            this.$this_launchIn = fVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$this_launchIn, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r8.r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r8.r.b(obj);
                f<T> fVar = this.$this_launchIn;
                this.label = 1;
                if (h.i(fVar, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    public static final Object a(f<?> fVar, v8.f<? super r8.z> fVar2) {
        Object objCollect = fVar.collect(kotlinx.coroutines.flow.internal.o.f14740a, fVar2);
        return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
    }

    public static final <T> u1 d(f<? extends T> fVar, l0 l0Var) {
        return kotlinx.coroutines.j.d(l0Var, null, null, new a(fVar, null), 3, null);
    }

    public static final <T> Object b(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super r8.z>, ? extends Object> pVar, v8.f<? super r8.z> fVar2) {
        Object objI = h.i(l.b(h.A(fVar, pVar), 0, null, 2, null), fVar2);
        if (objI == kotlin.coroutines.intrinsics.b.c()) {
            return objI;
        }
        return r8.z.f17874a;
    }

    public static final <T> Object c(g<? super T> gVar, f<? extends T> fVar, v8.f<? super r8.z> fVar2) {
        h.q(gVar);
        Object objCollect = fVar.collect(gVar, fVar2);
        if (objCollect == kotlin.coroutines.intrinsics.b.c()) {
            return objCollect;
        }
        return r8.z.f17874a;
    }
}
