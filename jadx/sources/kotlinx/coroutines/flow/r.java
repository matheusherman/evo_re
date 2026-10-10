package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "a", "(Lkotlinx/coroutines/flow/f;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/r$a", "Lkotlinx/coroutines/flow/g;", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> implements g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0 f14777a;

        public a(kotlin.jvm.internal.b0 b0Var) {
            this.f14777a = b0Var;
        }

        @Override // kotlinx.coroutines.flow.g
        public Object emit(T t10, v8.f<? super r8.z> fVar) {
            this.f14777a.element = t10;
            throw new kotlinx.coroutines.flow.internal.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return h.s(null, this);
        }

        b(v8.f<? super b> fVar) {
            super(fVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object a(f<? extends T> fVar, v8.f<? super T> fVar2) {
        b bVar;
        kotlin.jvm.internal.b0 b0Var;
        kotlinx.coroutines.flow.internal.a e10;
        g<? super Object> gVar;
        if (fVar2 instanceof b) {
            bVar = (b) fVar2;
            int i10 = bVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                bVar.label = i10 - Integer.MIN_VALUE;
            } else {
                bVar = new b(fVar2);
            }
        } else {
            bVar = new b(fVar2);
        }
        Object obj = bVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = bVar.label;
        if (i11 == 0) {
            r8.r.b(obj);
            kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
            b0Var2.element = (T) kotlinx.coroutines.flow.internal.p.f14741a;
            g<? super Object> aVar = new a<>(b0Var2);
            try {
                bVar.L$0 = b0Var2;
                bVar.L$1 = aVar;
                bVar.label = 1;
                if (fVar.collect(aVar, bVar) == objC) {
                    return objC;
                }
                b0Var = b0Var2;
            } catch (kotlinx.coroutines.flow.internal.a e11) {
                b0Var = b0Var2;
                e10 = e11;
                gVar = aVar;
                kotlinx.coroutines.flow.internal.l.a(e10, gVar);
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            gVar = (a) bVar.L$1;
            b0Var = (kotlin.jvm.internal.b0) bVar.L$0;
            try {
                r8.r.b(obj);
            } catch (kotlinx.coroutines.flow.internal.a e12) {
                e10 = e12;
                kotlinx.coroutines.flow.internal.l.a(e10, gVar);
            }
        }
        T t10 = b0Var.element;
        if (t10 != kotlinx.coroutines.flow.internal.p.f14741a) {
            return t10;
        }
        throw new NoSuchElementException("Expected at least one element");
    }
}
