package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u001aP\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012(\u0010\u0007\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001aX\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000120\u0010\u0007\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0003H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a_\u0010\u0011\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000320\u0010\u0007\u001a,\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/g;", "Lv8/f;", "Lr8/z;", "", "action", "e", "(Lkotlinx/coroutines/flow/f;Lc9/p;)Lkotlinx/coroutines/flow/f;", "Lkotlin/Function3;", "", "d", "(Lkotlinx/coroutines/flow/f;Lc9/q;)Lkotlinx/coroutines/flow/f;", "b", "(Lkotlinx/coroutines/flow/g;)V", "cause", "c", "(Lkotlinx/coroutines/flow/g;Lc9/q;Ljava/lang/Throwable;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class n {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", l = {216}, m = "invokeSafely$FlowKt__EmittersKt")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return n.c(null, null, null, this);
        }

        a(v8.f<? super a> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/n$b", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.q f14758b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {115, 122, 129}, m = "collect")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;

            public a(v8.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(f fVar, c9.q qVar) {
            this.f14757a = fVar;
            this.f14758b = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:35:0x0088  */
        /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.f
        public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) throws Throwable {
            a aVar;
            b<T> bVar;
            i0 i0Var;
            c9.q qVar;
            kotlinx.coroutines.flow.internal.q qVar2;
            Throwable th;
            kotlinx.coroutines.flow.internal.q qVar3;
            Object objInvoke;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(fVar);
                }
            } else {
                aVar = new a(fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 == 0) {
                r8.r.b(obj);
                try {
                    f fVar2 = this.f14757a;
                    aVar.L$0 = this;
                    aVar.L$1 = gVar;
                    aVar.label = 1;
                    if (fVar2.collect(gVar, aVar) != objC) {
                        bVar = this;
                        qVar2 = new kotlinx.coroutines.flow.internal.q(gVar, aVar.getContext());
                        c9.q qVar4 = bVar.f14758b;
                        aVar.L$0 = qVar2;
                        aVar.L$1 = null;
                        aVar.label = 3;
                        kotlin.jvm.internal.l.c(6);
                        objInvoke = qVar4.invoke(qVar2, null, aVar);
                        kotlin.jvm.internal.l.c(7);
                        if (objInvoke != objC) {
                            qVar3 = qVar2;
                            qVar3.releaseIntercepted();
                            return r8.z.f17874a;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bVar = this;
                    i0Var = new i0(th);
                    qVar = bVar.f14758b;
                    aVar.L$0 = th;
                    aVar.L$1 = null;
                    aVar.label = 2;
                    if (n.c(i0Var, qVar, th, aVar) == objC) {
                        throw th;
                    }
                }
                return objC;
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    Throwable th3 = (Throwable) aVar.L$0;
                    r8.r.b(obj);
                    throw th3;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                qVar3 = (kotlinx.coroutines.flow.internal.q) aVar.L$0;
                try {
                    r8.r.b(obj);
                    qVar3.releaseIntercepted();
                    return r8.z.f17874a;
                } catch (Throwable th4) {
                    th = th4;
                    qVar3.releaseIntercepted();
                    throw th;
                }
            }
            gVar = (g) aVar.L$1;
            bVar = (b) aVar.L$0;
            try {
                r8.r.b(obj);
                qVar2 = new kotlinx.coroutines.flow.internal.q(gVar, aVar.getContext());
                try {
                    c9.q qVar5 = bVar.f14758b;
                    aVar.L$0 = qVar2;
                    aVar.L$1 = null;
                    aVar.label = 3;
                    kotlin.jvm.internal.l.c(6);
                    objInvoke = qVar5.invoke(qVar2, null, aVar);
                    kotlin.jvm.internal.l.c(7);
                    if (objInvoke != objC) {
                        qVar3 = qVar2;
                        qVar3.releaseIntercepted();
                        return r8.z.f17874a;
                    }
                    return objC;
                } catch (Throwable th5) {
                    th = th5;
                    qVar3 = qVar2;
                    qVar3.releaseIntercepted();
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                i0Var = new i0(th);
                qVar = bVar.f14758b;
                aVar.L$0 = th;
                aVar.L$1 = null;
                aVar.label = 2;
                if (n.c(i0Var, qVar, th, aVar) == objC) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/n$c", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c9.p f14759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f14760b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {117, 121}, m = "collect")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            /* synthetic */ Object result;

            public a(v8.f fVar) {
                super(fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(c9.p pVar, f fVar) {
            this.f14759a = pVar;
            this.f14760b = fVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            if (r7.collect(r2, r0) == r1) goto L27;
         */
        @Override // kotlinx.coroutines.flow.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) throws Throwable {
            a aVar;
            Throwable th;
            kotlinx.coroutines.flow.internal.q qVar;
            c<T> cVar;
            g<? super T> gVar2;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(fVar);
                }
            } else {
                aVar = new a(fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    qVar = (kotlinx.coroutines.flow.internal.q) aVar.L$2;
                    gVar2 = (g) aVar.L$1;
                    cVar = (c) aVar.L$0;
                    try {
                        r8.r.b(obj);
                        qVar.releaseIntercepted();
                        f fVar2 = cVar.f14760b;
                        aVar.L$0 = null;
                        aVar.L$1 = null;
                        aVar.L$2 = null;
                        aVar.label = 2;
                    } catch (Throwable th2) {
                        th = th2;
                        qVar.releaseIntercepted();
                        throw th;
                    }
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlinx.coroutines.flow.internal.q qVar2 = new kotlinx.coroutines.flow.internal.q(gVar, aVar.getContext());
            try {
                c9.p pVar = this.f14759a;
                aVar.L$0 = this;
                aVar.L$1 = gVar;
                aVar.L$2 = qVar2;
                aVar.label = 1;
                kotlin.jvm.internal.l.c(6);
                Object objInvoke = pVar.invoke(qVar2, aVar);
                kotlin.jvm.internal.l.c(7);
                if (objInvoke != objC) {
                    cVar = this;
                    gVar2 = gVar;
                    qVar = qVar2;
                    qVar.releaseIntercepted();
                    f fVar3 = cVar.f14760b;
                    aVar.L$0 = null;
                    aVar.L$1 = null;
                    aVar.L$2 = null;
                    aVar.label = 2;
                }
                return objC;
            } catch (Throwable th3) {
                th = th3;
                qVar = qVar2;
                qVar.releaseIntercepted();
                throw th;
            }
        }
    }

    public static final void b(g<?> gVar) {
        if (gVar instanceof i0) {
            throw ((i0) gVar).e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final <T> Object c(g<? super T> gVar, c9.q<? super g<? super T>, ? super Throwable, ? super v8.f<? super r8.z>, ? extends Object> qVar, Throwable th, v8.f<? super r8.z> fVar) {
        a aVar;
        if (fVar instanceof a) {
            aVar = (a) fVar;
            int i10 = aVar.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                aVar.label = i10 - Integer.MIN_VALUE;
            } else {
                aVar = new a(fVar);
            }
        } else {
            aVar = new a(fVar);
        }
        Object obj = aVar.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = aVar.label;
        try {
            if (i11 == 0) {
                r8.r.b(obj);
                aVar.L$0 = th;
                aVar.label = 1;
                if (qVar.invoke(gVar, th, aVar) == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) aVar.L$0;
                r8.r.b(obj);
            }
            return r8.z.f17874a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                r8.a.a(th2, th);
            }
            throw th2;
        }
    }

    public static final <T> f<T> d(f<? extends T> fVar, c9.q<? super g<? super T>, ? super Throwable, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
        return new b(fVar, qVar);
    }

    public static final <T> f<T> e(f<? extends T> fVar, c9.p<? super g<? super T>, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return new c(pVar, fVar);
    }
}
