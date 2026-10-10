package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u001aX\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a+\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\n\u001a`\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000220\b\u0001\u0010\u0006\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aT\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022$\b\u0001\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\b\" \u0010\u0017\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/f;", "Lkotlin/Function2;", "Lv8/f;", "", "transform", "a", "(Lkotlinx/coroutines/flow/f;Lc9/p;)Lkotlinx/coroutines/flow/f;", "b", "(Lkotlinx/coroutines/flow/f;)Lkotlinx/coroutines/flow/f;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "d", "(Lkotlinx/coroutines/flow/f;Lc9/q;)Lkotlinx/coroutines/flow/f;", "c", "", "I", "getDEFAULT_CONCURRENCY", "()I", "getDEFAULT_CONCURRENCY$annotations", "()V", "DEFAULT_CONCURRENCY", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f14770a = kotlinx.coroutines.internal.g0.b("kotlinx.coroutines.flow.defaultConcurrency", 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class a<R> implements f<f<? extends R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c9.p f14772b;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C0286a<T> implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f14773a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c9.p f14774b;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.q$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", f = "Merge.kt", l = {223, 223}, m = "emit")
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public static final class C0287a extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                int label;
                /* synthetic */ Object result;

                public C0287a(v8.f fVar) {
                    super(fVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return C0286a.this.emit(null, this);
                }
            }

            public C0286a(g gVar, c9.p pVar) {
                this.f14773a = gVar;
                this.f14774b = pVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
            
                if (r7.emit(r8, r0) == r1) goto L22;
             */
            @Override // kotlinx.coroutines.flow.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(Object obj, v8.f fVar) {
                C0287a c0287a;
                g gVar;
                if (fVar instanceof C0287a) {
                    c0287a = (C0287a) fVar;
                    int i10 = c0287a.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        c0287a.label = i10 - Integer.MIN_VALUE;
                    } else {
                        c0287a = new C0287a(fVar);
                    }
                } else {
                    c0287a = new C0287a(fVar);
                }
                Object obj2 = c0287a.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = c0287a.label;
                if (i11 != 0) {
                    if (i11 == 1) {
                        g gVar2 = (g) c0287a.L$0;
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
                g gVar3 = this.f14773a;
                c9.p pVar = this.f14774b;
                c0287a.L$0 = gVar3;
                c0287a.label = 1;
                Object objInvoke = pVar.invoke(obj, c0287a);
                if (objInvoke != objC) {
                    obj2 = objInvoke;
                    gVar = gVar3;
                }
                return objC;
                c0287a.L$0 = null;
                c0287a.label = 2;
            }
        }

        public a(f fVar, c9.p pVar) {
            this.f14771a = fVar;
            this.f14772b = pVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(g gVar, v8.f fVar) {
            Object objCollect = this.f14771a.collect(new C0286a(gVar, this.f14772b), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/q$b", "Lkotlinx/coroutines/flow/f;", "Lkotlinx/coroutines/flow/g;", "collector", "Lr8/z;", "collect", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class b<T> implements f<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f14775a;

        public b(f fVar) {
            this.f14775a = fVar;
        }

        @Override // kotlinx.coroutines.flow.f
        public Object collect(g<? super T> gVar, v8.f<? super r8.z> fVar) {
            Object objCollect = this.f14775a.collect(new c(gVar), fVar);
            return objCollect == kotlin.coroutines.intrinsics.b.c() ? objCollect : r8.z.f17874a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/f;", "value", "Lr8/z;", "b", "(Lkotlinx/coroutines/flow/f;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0})
    static final class c<T> implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f14776a;

        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$1$1", f = "Merge.kt", l = {83}, m = "emit")
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        static final class a extends kotlin.coroutines.jvm.internal.d {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ c<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, v8.f<? super a> fVar) {
                super(fVar);
                this.this$0 = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(g<? super T> gVar) {
            this.f14776a = gVar;
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object emit(f<? extends T> fVar, v8.f<? super r8.z> fVar2) {
            a aVar;
            if (fVar2 instanceof a) {
                aVar = (a) fVar2;
                int i10 = aVar.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    aVar.label = i10 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(this, fVar2);
                }
            } else {
                aVar = new a(this, fVar2);
            }
            Object obj = aVar.result;
            Object objC = kotlin.coroutines.intrinsics.b.c();
            int i11 = aVar.label;
            if (i11 == 0) {
                r8.r.b(obj);
                g<T> gVar = this.f14776a;
                aVar.label = 1;
                if (h.p(gVar, fVar, aVar) == objC) {
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

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", l = {217, 217}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/g;", "it", "Lr8/z;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class d<R, T> extends kotlin.coroutines.jvm.internal.l implements c9.q<g<? super R>, T, v8.f<? super r8.z>, Object> {
        final /* synthetic */ c9.p<T, v8.f<? super R>, Object> $transform;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(c9.p<? super T, ? super v8.f<? super R>, ? extends Object> pVar, v8.f<? super d> fVar) {
            super(3, fVar);
            this.$transform = pVar;
        }

        @Override // c9.q
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(g<? super R> gVar, T t10, v8.f<? super r8.z> fVar) {
            d dVar = new d(this.$transform, fVar);
            dVar.L$0 = gVar;
            dVar.L$1 = t10;
            return dVar.invokeSuspend(r8.z.f17874a);
        }

        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.q$d<R, T> for r5v1 'this'  java.lang.Object
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                int r1 = r5.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                r8.r.b(r6)
                goto L45
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.L$0
                kotlinx.coroutines.flow.g r1 = (kotlinx.coroutines.flow.g) r1
                r8.r.b(r6)
                goto L39
            L22:
                r8.r.b(r6)
                java.lang.Object r6 = r5.L$0
                r1 = r6
                kotlinx.coroutines.flow.g r1 = (kotlinx.coroutines.flow.g) r1
                java.lang.Object r6 = r5.L$1
                c9.p<T, v8.f<? super R>, java.lang.Object> r4 = r5.$transform
                r5.L$0 = r1
                r5.label = r3
                java.lang.Object r6 = r4.invoke(r6, r5)
                if (r6 != r0) goto L39
                goto L44
            L39:
                r3 = 0
                r5.L$0 = r3
                r5.label = r2
                java.lang.Object r6 = r1.emit(r6, r5)
                if (r6 != r0) goto L45
            L44:
                return r0
            L45:
                r8.z r6 = r8.z.f17874a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.q.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final <T, R> f<R> a(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super f<? extends R>>, ? extends Object> pVar) {
        return h.u(new a(fVar, pVar));
    }

    public static final <T> f<T> b(f<? extends f<? extends T>> fVar) {
        return new b(fVar);
    }

    public static final <T, R> f<R> c(f<? extends T> fVar, c9.p<? super T, ? super v8.f<? super R>, ? extends Object> pVar) {
        return h.H(fVar, new d(pVar, null));
    }

    public static final <T, R> f<R> d(f<? extends T> fVar, c9.q<? super g<? super R>, ? super T, ? super v8.f<? super r8.z>, ? extends Object> qVar) {
        return new kotlinx.coroutines.flow.internal.i(qVar, fVar, null, 0, null, 28, null);
    }
}
