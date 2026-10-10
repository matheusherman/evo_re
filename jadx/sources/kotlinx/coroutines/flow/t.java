package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.taobao.sophix.PatchStatus;
import kotlin.Metadata;
import kotlin.collections.IndexedValue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a)\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a)\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0006\u0010\u0004\u001aJ\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a`\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012*\b\u0001\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000fø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a`\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u00012*\b\u0001\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000fø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001aP\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022(\u0010\u0010\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u000fø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "a", "(Lkotlinx/coroutines/flow/f;)Lkotlinx/coroutines/flow/f;", "Lkotlin/collections/h0;", "f", "Lkotlin/Function2;", "Lv8/f;", "Lr8/z;", "action", "b", "(Lkotlinx/coroutines/flow/f;Lc9/p;)Lkotlinx/coroutines/flow/f;", "R", "initial", "Lkotlin/Function3;", "operation", "e", "(Lkotlinx/coroutines/flow/f;Ljava/lang/Object;Lc9/q;)Lkotlinx/coroutines/flow/f;", "c", "d", "(Lkotlinx/coroutines/flow/f;Lc9/q;)Lkotlinx/coroutines/flow/f;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<T> implements kotlinx.coroutines.flow.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f14778a;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C0288a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f14779a;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.t$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223}, m = "emit")
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class C0289a extends kotlin.coroutines.jvm.internal.d {
                int label;
                /* synthetic */ Object result;

                public C0289a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0288a.this.emit(null, this);
                }
            }

            public C0288a(kotlinx.coroutines.flow.g gVar) {
                this.f14779a = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(T t10, v8.f<? super r8.z> fVar) {
                C0289a c0289a;
                if (fVar instanceof C0289a) {
                    c0289a = (C0289a) fVar;
                    int i10 = c0289a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0289a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0289a = new C0289a(fVar);
                    }
                } else {
                    c0289a = new C0289a(fVar);
                }
                Object obj = c0289a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0289a.label;
                if (i11 == 0) {
                    r8.r.b(obj);
                    kotlinx.coroutines.flow.g gVar = this.f14779a;
                    if (t10 != null) {
                        c0289a.label = 1;
                        if (gVar.emit(t10, c0289a) == objC) {
                            return objC;
                        }
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
        }

        public a(kotlinx.coroutines.flow.f fVar) {
            this.f14778a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g gVar, v8.f fVar) {
            Object objCollect = this.f14778a.collect(new C0288a(gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b<T> implements kotlinx.coroutines.flow.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f14780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.p f14781b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g f14782a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c9.p f14783b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.t$b$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", l = {223, 224}, m = "emit")
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class C0290a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                int label;
                /* synthetic */ Object result;

                public C0290a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(kotlinx.coroutines.flow.g gVar, c9.p pVar) {
                this.f14782a = gVar;
                this.f14783b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x0067, code lost:
            
                if (r6.emit(r2, r0) == r1) goto L22;
             */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlinx.coroutines.flow.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(T t10, v8.f<? super r8.z> fVar) {
                C0290a c0290a;
                Object obj;
                kotlinx.coroutines.flow.g gVar;
                if (fVar instanceof C0290a) {
                    c0290a = (C0290a) fVar;
                    int i10 = c0290a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0290a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0290a = new C0290a(fVar);
                    }
                } else {
                    c0290a = new C0290a(fVar);
                }
                Object obj2 = c0290a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0290a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        kotlinx.coroutines.flow.g gVar2 = (kotlinx.coroutines.flow.g) c0290a.L$1;
                        obj = c0290a.L$0;
                        r8.r.b(obj2);
                        gVar = gVar2;
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        r8.r.b(obj2);
                    }
                    return r8.z.f17874a;
                }
                r8.r.b(obj2);
                kotlinx.coroutines.flow.g gVar3 = this.f14782a;
                c9.p pVar = this.f14783b;
                c0290a.L$0 = t10;
                c0290a.L$1 = gVar3;
                c0290a.label = 1;
                kotlin.jvm.internal.l.c(6);
                Object objInvoke = pVar.invoke(t10, c0290a);
                kotlin.jvm.internal.l.c(7);
                if (objInvoke != objC) {
                    obj = t10;
                    gVar = gVar3;
                }
                return objC;
                c0290a.L$0 = null;
                c0290a.L$1 = null;
                c0290a.label = 2;
            }
        }

        public b(kotlinx.coroutines.flow.f fVar, c9.p pVar) {
            this.f14780a = fVar;
            this.f14781b = pVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g gVar, v8.f fVar) {
            Object objCollect = this.f14780a.collect(new a(gVar, this.f14781b), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/t$c", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class c<R> implements kotlinx.coroutines.flow.f<R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f14784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f14785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c9.q f14786c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1", f = "Transform.kt", l = {115, 116}, m = "collect")
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

        public c(Object obj, kotlinx.coroutines.flow.f fVar, c9.q qVar) {
            this.f14784a = obj;
            this.f14785b = fVar;
            this.f14786c = qVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
        
            if (r8.collect(r5, r0) == r1) goto L22;
         */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // kotlinx.coroutines.flow.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object collect(kotlinx.coroutines.flow.g<? super R> gVar, v8.f<? super r8.z> fVar) {
            a aVar;
            c<R> cVar;
            kotlinx.coroutines.flow.g gVar2;
            kotlin.jvm.internal.b0 b0Var;
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
                    b0Var = (kotlin.jvm.internal.b0) aVar.L$2;
                    kotlinx.coroutines.flow.g gVar3 = (kotlinx.coroutines.flow.g) aVar.L$1;
                    cVar = (c) aVar.L$0;
                    r8.r.b(obj);
                    gVar2 = gVar3;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlin.jvm.internal.b0 b0Var2 = new kotlin.jvm.internal.b0();
            ?? r10 = this.f14784a;
            b0Var2.element = r10;
            aVar.L$0 = this;
            aVar.L$1 = gVar;
            aVar.L$2 = b0Var2;
            aVar.label = 1;
            if (gVar.emit(r10, aVar) != objC) {
                cVar = this;
                gVar2 = gVar;
                b0Var = b0Var2;
            }
            return objC;
            kotlinx.coroutines.flow.f fVar2 = cVar.f14785b;
            d dVar = new d(b0Var, cVar.f14786c, gVar2);
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.L$2 = null;
            aVar.label = 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class d<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<R> f14787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.q<R, T, v8.f<? super R>, Object> f14788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.g<R> f14789c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1", f = "Transform.kt", l = {109, 110}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ d<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(d<? super T> dVar, v8.f<? super a> fVar) {
                super(fVar);
                this.this$0 = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(kotlin.jvm.internal.b0<R> b0Var, c9.q<? super R, ? super T, ? super v8.f<? super R>, ? extends Object> qVar, kotlinx.coroutines.flow.g<? super R> gVar) {
            this.f14787a = b0Var;
            this.f14788b = qVar;
            this.f14789c = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
        
            if (r7.emit((R) r8, r0) == r1) goto L22;
         */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t10, v8.f<? super r8.z> fVar) {
            a aVar;
            kotlin.jvm.internal.b0 b0Var;
            d<T> dVar;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, fVar);
                }
            } else {
                aVar = new a(this, fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    b0Var = (kotlin.jvm.internal.b0) aVar.L$1;
                    dVar = (d) aVar.L$0;
                    r8.r.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            kotlin.jvm.internal.b0 b0Var2 = this.f14787a;
            c9.q<R, T, v8.f<? super R>, Object> qVar = this.f14788b;
            T t11 = b0Var2.element;
            aVar.L$0 = this;
            aVar.L$1 = b0Var2;
            aVar.label = 1;
            Object objInvoke = qVar.invoke((R) t11, t10, aVar);
            if (objInvoke != objC) {
                obj = (T) objInvoke;
                b0Var = b0Var2;
                dVar = this;
            }
            return objC;
            b0Var.element = (T) obj;
            kotlinx.coroutines.flow.g<R> gVar = dVar.f14789c;
            T t12 = dVar.f14787a.element;
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/t$e", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class e<T> implements kotlinx.coroutines.flow.f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f14790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.q f14791b;

        public e(kotlinx.coroutines.flow.f fVar, c9.q qVar) {
            this.f14790a = fVar;
            this.f14791b = qVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super T> gVar, v8.f<? super r8.z> fVar) {
            kotlin.jvm.internal.b0 b0Var = new kotlin.jvm.internal.b0();
            b0Var.element = (T) kotlinx.coroutines.flow.internal.p.f14741a;
            Object objCollect = this.f14790a.collect(new f(b0Var, this.f14791b, gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class f<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.b0<Object> f14792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.q<T, T, v8.f<? super T>, Object> f14793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.g<T> f14794c;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1", f = "Transform.kt", l = {PatchStatus.CODE_LOAD_LIB_UNDEFINED, PatchStatus.CODE_LOAD_LIB_JSON}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ f<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(f<? super T> fVar, v8.f<? super a> fVar2) {
                super(fVar2);
                this.this$0 = fVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        f(kotlin.jvm.internal.b0<Object> b0Var, c9.q<? super T, ? super T, ? super v8.f<? super T>, ? extends Object> qVar, kotlinx.coroutines.flow.g<? super T> gVar) {
            this.f14792a = b0Var;
            this.f14793b = qVar;
            this.f14794c = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        
            if (r8.emit(r9, r0) == r1) goto L26;
         */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.flow.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(T t10, v8.f<? super r8.z> fVar) {
            a aVar;
            kotlin.jvm.internal.b0<Object> b0Var;
            kotlin.jvm.internal.b0<Object> b0Var2;
            f<T> fVar2;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, fVar);
                }
            } else {
                aVar = new a(this, fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    b0Var2 = (kotlin.jvm.internal.b0) aVar.L$1;
                    fVar2 = (f) aVar.L$0;
                    r8.r.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r8.r.b(obj);
                }
                return r8.z.f17874a;
            }
            r8.r.b(obj);
            b0Var = this.f14792a;
            Object obj2 = b0Var.element;
            if (obj2 == kotlinx.coroutines.flow.internal.p.f14741a) {
                fVar2 = this;
                b0Var.element = t10;
                kotlinx.coroutines.flow.g<T> gVar = fVar2.f14794c;
                T t11 = fVar2.f14792a.element;
                aVar.L$0 = null;
                aVar.L$1 = null;
                aVar.label = 2;
            } else {
                c9.q<T, T, v8.f<? super T>, Object> qVar = this.f14793b;
                aVar.L$0 = this;
                aVar.L$1 = b0Var;
                aVar.label = 1;
                Object objInvoke = qVar.invoke((T) obj2, t10, aVar);
                if (objInvoke != objC) {
                    obj = objInvoke;
                    b0Var2 = b0Var;
                    fVar2 = this;
                }
            }
            return objC;
            Object obj3 = obj;
            b0Var = b0Var2;
            t10 = (T) obj3;
            b0Var.element = t10;
            kotlinx.coroutines.flow.g<T> gVar2 = fVar2.f14794c;
            T t12 = fVar2.f14792a.element;
            aVar.L$0 = null;
            aVar.L$1 = null;
            aVar.label = 2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/t$g", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class g<T> implements kotlinx.coroutines.flow.f<IndexedValue<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.f f14795a;

        public g(kotlinx.coroutines.flow.f fVar) {
            this.f14795a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(kotlinx.coroutines.flow.g<? super IndexedValue<? extends T>> gVar, v8.f<? super r8.z> fVar) {
            Object objCollect = this.f14795a.collect(new h(gVar, new kotlin.jvm.internal.z()), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class h<T> implements kotlinx.coroutines.flow.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.g<IndexedValue<? extends T>> f14796a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.z f14797b;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$1$1", f = "Transform.kt", l = {71}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ h<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(h<? super T> hVar, v8.f<? super a> fVar) {
                super(fVar);
                this.this$0 = hVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        h(kotlinx.coroutines.flow.g<? super IndexedValue<? extends T>> gVar, kotlin.jvm.internal.z zVar) {
            this.f14796a = gVar;
            this.f14797b = zVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.g
        public final Object emit(T t10, v8.f<? super r8.z> fVar) {
            a aVar;
            if (fVar instanceof a) {
                aVar = (a) fVar;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, fVar);
                }
            } else {
                aVar = new a(this, fVar);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 == 0) {
                r8.r.b(obj);
                kotlinx.coroutines.flow.g<IndexedValue<? extends T>> gVar = this.f14796a;
                kotlin.jvm.internal.z zVar = this.f14797b;
                int i12 = zVar.element;
                zVar.element = i12 + 1;
                if (i12 < 0) {
                    throw new ArithmeticException("Index overflow has happened");
                }
                IndexedValue<? extends T> indexedValue = new IndexedValue<>(i12, t10);
                aVar.label = 1;
                if (gVar.emit(indexedValue, aVar) == objC) {
                    return objC;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r8.r.b(obj);
            }
            return r8.z.f17874a;
        }
    }

    public static final <T> kotlinx.coroutines.flow.f<T> a(kotlinx.coroutines.flow.f<? extends T> fVar) {
        return new a(fVar);
    }

    public static final <T> kotlinx.coroutines.flow.f<T> b(kotlinx.coroutines.flow.f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super r8.z>, ? extends Object> pVar) {
        return new b(fVar, pVar);
    }

    public static final <T, R> kotlinx.coroutines.flow.f<R> c(kotlinx.coroutines.flow.f<? extends T> fVar, R r10, c9.q<? super R, ? super T, ? super v8.f<? super R>, ? extends Object> qVar) {
        return new c(r10, fVar, qVar);
    }

    public static final <T> kotlinx.coroutines.flow.f<T> d(kotlinx.coroutines.flow.f<? extends T> fVar, c9.q<? super T, ? super T, ? super v8.f<? super T>, ? extends Object> qVar) {
        return new e(fVar, qVar);
    }

    public static final <T> kotlinx.coroutines.flow.f<IndexedValue<T>> f(kotlinx.coroutines.flow.f<? extends T> fVar) {
        return new g(fVar);
    }

    public static final <T, R> kotlinx.coroutines.flow.f<R> e(kotlinx.coroutines.flow.f<? extends T> fVar, R r10, c9.q<? super R, ? super T, ? super v8.f<? super R>, ? extends Object> qVar) {
        return kotlinx.coroutines.flow.h.E(fVar, r10, qVar);
    }
}
