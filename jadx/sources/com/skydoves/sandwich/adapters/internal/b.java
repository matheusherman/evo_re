package com.skydoves.sandwich.adapters.internal;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import h9.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.r;
import r8.z;
import retrofit2.f0;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001d\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\f2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00018\u00008\u00000\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/skydoves/sandwich/adapters/internal/b;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/skydoves/sandwich/adapters/internal/d;", "Lcom/skydoves/sandwich/a;", "Lretrofit2/b;", "proxy", "Lkotlinx/coroutines/l0;", "coroutineScope", "<init>", "(Lretrofit2/b;Lkotlinx/coroutines/l0;)V", "Lretrofit2/d;", "callback", "Lr8/z;", "c", "(Lretrofit2/d;)V", "kotlin.jvm.PlatformType", "e", "()Lcom/skydoves/sandwich/adapters/internal/b;", "b", "Lkotlinx/coroutines/l0;", "sandwich"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class b<T> extends d<T, com.skydoves.sandwich.a<? extends T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final l0 coroutineScope;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "com.skydoves.sandwich.adapters.internal.ApiResponseCallDelegate$enqueueImpl$1", f = "ApiResponseCallDelegate.kt", l = {42}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ retrofit2.d<com.skydoves.sandwich.a<T>> $callback;
        int label;
        final /* synthetic */ b<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<T> bVar, retrofit2.d<com.skydoves.sandwich.a<T>> dVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.this$0 = bVar;
            this.$callback = dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return new a(this.this$0, this.$callback, fVar);
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
                    retrofit2.b<T> bVarD = this.this$0.d();
                    this.label = 1;
                    obj = retrofit2.p.c(bVarD, this);
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
                this.$callback.b(this.this$0, f0.i(companion.c(c0152b)));
            } catch (Exception e11) {
                this.$callback.b(this.this$0, f0.i(com.skydoves.sandwich.a.INSTANCE.a(e11)));
            }
            return z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(retrofit2.b<T> proxy, l0 coroutineScope) {
        super(proxy);
        m.f(proxy, "proxy");
        m.f(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
    }

    @Override // com.skydoves.sandwich.adapters.internal.d
    public void c(retrofit2.d<com.skydoves.sandwich.a<T>> callback) {
        m.f(callback, "callback");
        j.d(this.coroutineScope, null, null, new a(this, callback, null), 3, null);
    }

    @Override // com.skydoves.sandwich.adapters.internal.d
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b<T> a() {
        retrofit2.b<T> bVarClone = d().clone();
        m.e(bVarClone, "proxy.clone()");
        return new b<>(bVarClone, this.coroutineScope);
    }
}
