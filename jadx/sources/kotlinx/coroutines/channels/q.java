package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0096\u0001\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u001e\b\u0002\u0010\u0013\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\u0004\u0018\u0001`\u00122*\b\u0001\u0010\u0003\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0014H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/channels/s;", "Lkotlin/Function0;", "Lr8/z;", "block", "a", "(Lkotlinx/coroutines/channels/s;Lc9/a;Lv8/f;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/l0;", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "Lkotlinx/coroutines/n0;", "start", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lv8/f;", "", "Lkotlinx/coroutines/channels/u;", "b", "(Lkotlinx/coroutines/l0;Lv8/j;ILkotlinx/coroutines/channels/a;Lkotlinx/coroutines/n0;Lc9/l;Lc9/p;)Lkotlinx/coroutines/channels/u;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class q {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", l = {153}, m = "awaitClose")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return q.a(null, null, this);
        }

        a(v8.f<? super a> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class b extends kotlin.jvm.internal.o implements c9.l<Throwable, z> {
        final /* synthetic */ kotlinx.coroutines.n<z> $cont;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Throwable th) {
            invoke2(th);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(kotlinx.coroutines.n<? super z> nVar) {
            super(1);
            this.$cont = nVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            kotlinx.coroutines.n<z> nVar = this.$cont;
            r8.q.Companion companion = r8.q.INSTANCE;
            nVar.resumeWith(r8.q.a(z.f17874a));
        }
    }

    public static final <E> u<E> b(l0 l0Var, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, n0 n0Var, c9.l<? super Throwable, z> lVar, c9.p<? super s<? super E>, ? super v8.f<? super z>, ? extends Object> pVar) {
        r rVar = new r(h0.d(l0Var, jVar), g.b(i10, aVar, null, 4, null));
        if (lVar != null) {
            rVar.x(lVar);
        }
        rVar.L0(n0Var, rVar, pVar);
        return rVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object a(s<?> sVar, c9.a<z> aVar, v8.f<? super z> fVar) {
        a aVar2;
        if (fVar instanceof a) {
            aVar2 = (a) fVar;
            int i10 = aVar2.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar2.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar2 = new a(fVar);
            }
        } else {
            aVar2 = new a(fVar);
        }
        Object obj = aVar2.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar2.label;
        try {
            if (i11 == 0) {
                r8.r.b(obj);
                if (aVar2.getContext().get(u1.INSTANCE) != sVar) {
                    throw new IllegalStateException("awaitClose() can only be invoked from the producer context");
                }
                aVar2.L$0 = sVar;
                aVar2.L$1 = aVar;
                aVar2.label = 1;
                kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(aVar2), 1);
                oVar.D();
                sVar.d(new b(oVar));
                Object objZ = oVar.z();
                if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                    kotlin.coroutines.jvm.internal.h.c(aVar2);
                }
                if (objZ == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (c9.a) aVar2.L$1;
                r8.r.b(obj);
            }
            aVar.invoke();
            return z.f17874a;
        } catch (Throwable th) {
            aVar.invoke();
            throw th;
        }
    }

    public static /* synthetic */ u c(l0 l0Var, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, n0 n0Var, c9.l lVar, c9.p pVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            jVar = v8.k.f19724a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            aVar = kotlinx.coroutines.channels.a.SUSPEND;
        }
        if ((i11 & 8) != 0) {
            n0Var = n0.DEFAULT;
        }
        if ((i11 & 16) != 0) {
            lVar = null;
        }
        c9.l lVar2 = lVar;
        return b(l0Var, jVar, i10, aVar, n0Var, lVar2, pVar);
    }
}
