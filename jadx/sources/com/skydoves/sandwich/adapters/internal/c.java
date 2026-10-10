package com.skydoves.sandwich.adapters.internal;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import c9.p;
import h9.e;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import r8.r;
import r8.z;
import retrofit2.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00030\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/skydoves/sandwich/adapters/internal/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lretrofit2/c;", "Lkotlinx/coroutines/s0;", "Lcom/skydoves/sandwich/a;", "Ljava/lang/reflect/Type;", "resultType", "Lkotlinx/coroutines/l0;", "coroutineScope", "<init>", "(Ljava/lang/reflect/Type;Lkotlinx/coroutines/l0;)V", "a", "()Ljava/lang/reflect/Type;", "Lretrofit2/b;", NotificationCompat.CATEGORY_CALL, "c", "(Lretrofit2/b;)Lkotlinx/coroutines/s0;", "Ljava/lang/reflect/Type;", "b", "Lkotlinx/coroutines/l0;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class c<T> implements retrofit2.c<T, s0<? extends com.skydoves.sandwich.a<? extends T>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Type resultType;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l0 coroutineScope;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.skydoves.sandwich.adapters.internal.ApiResponseDeferredCallAdapter$adapt$1", f = "ApiResponseDeferredCallAdapter.kt", l = {57}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ retrofit2.b<T> $call;
        final /* synthetic */ w<com.skydoves.sandwich.a<T>> $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(retrofit2.b<T> bVar, w<com.skydoves.sandwich.a<T>> wVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.$call = bVar;
            this.$deferred = wVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.$call, this.$deferred, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            com.skydoves.sandwich.a<? extends T> c0152b;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        r.b(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    retrofit2.b<T> bVar = this.$call;
                    this.label = 1;
                    obj = retrofit2.p.c(bVar, this);
                    if (obj == objC) {
                        return objC;
                    }
                }
                f0 f0Var = (f0) obj;
                com.skydoves.sandwich.a.Companion companion = com.skydoves.sandwich.a.INSTANCE;
                e eVarC = com.skydoves.sandwich.d.c();
                try {
                    int first = eVarC.getFirst();
                    int last = eVarC.getLast();
                    int code = f0Var.h().getCode();
                    if (first <= code && code <= last) {
                        c0152b = new com.skydoves.sandwich.a.c<>(f0Var);
                    } else {
                        c0152b = new com.skydoves.sandwich.a.b.C0151a<>(f0Var);
                    }
                } catch (Exception e10) {
                    c0152b = new com.skydoves.sandwich.a.b.C0152b<>(e10);
                }
                this.$deferred.r(companion.c(c0152b));
            } catch (Exception e11) {
                this.$deferred.r(com.skydoves.sandwich.a.INSTANCE.a(e11));
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class b extends o implements c9.l<Throwable, z> {
        final /* synthetic */ retrofit2.b<T> $call;
        final /* synthetic */ w<com.skydoves.sandwich.a<T>> $this_apply;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Throwable th) {
            invoke2(th);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(w<com.skydoves.sandwich.a<T>> wVar, retrofit2.b<T> bVar) {
            super(1);
            this.$this_apply = wVar;
            this.$call = bVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (!this.$this_apply.isCancelled() || this.$call.r()) {
                return;
            }
            this.$call.cancel();
        }
    }

    public c(Type resultType, l0 coroutineScope) {
        m.f(resultType, "resultType");
        m.f(coroutineScope, "coroutineScope");
        this.resultType = resultType;
        this.coroutineScope = coroutineScope;
    }

    @Override // retrofit2.c
    /* JADX INFO: renamed from: a, reason: from getter */
    public Type getResultType() {
        return this.resultType;
    }

    @Override // retrofit2.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public s0<com.skydoves.sandwich.a<T>> b(retrofit2.b<T> call) {
        m.f(call, "call");
        w wVarB = y.b(null, 1, null);
        wVarB.x(new b(wVarB, call));
        j.d(this.coroutineScope, null, null, new a(call, wVarB, null), 3, null);
        return wVarB;
    }
}
