package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.b0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.u1;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bf\u0012.\u0010\t\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0018\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R?\u0010\t\u001a*\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00048\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/flow/internal/i;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/internal/g;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/g;", "Lv8/f;", "Lr8/z;", "", "transform", "Lkotlinx/coroutines/flow/f;", "flow", "Lv8/j;", "context", "", "capacity", "Lkotlinx/coroutines/channels/a;", "onBufferOverflow", "<init>", "(Lc9/q;Lkotlinx/coroutines/flow/f;Lv8/j;ILkotlinx/coroutines/channels/a;)V", "Lkotlinx/coroutines/flow/internal/e;", "f", "(Lv8/j;ILkotlinx/coroutines/channels/a;)Lkotlinx/coroutines/flow/internal/e;", "collector", "m", "(Lkotlinx/coroutines/flow/g;Lv8/f;)Ljava/lang/Object;", "e", "Lc9/q;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class i<T, R> extends g<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c9.q<kotlinx.coroutines.flow.g<? super R>, T, v8.f<? super z>, Object> transform;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.g<R> $collector;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ i<T, R> this$0;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "Lr8/z;", "emit", "(Ljava/lang/Object;Lv8/f;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        static final class C0283a<T> implements kotlinx.coroutines.flow.g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b0<u1> f14732a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ l0 f14733b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T, R> f14734c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.g<R> f14735d;

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.i$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
            static final class C0284a extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super z>, Object> {
                final /* synthetic */ kotlinx.coroutines.flow.g<R> $collector;
                final /* synthetic */ T $value;
                int label;
                final /* synthetic */ i<T, R> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0284a(i<T, R> iVar, kotlinx.coroutines.flow.g<? super R> gVar, T t10, v8.f<? super C0284a> fVar) {
                    super(2, fVar);
                    this.this$0 = iVar;
                    this.$collector = gVar;
                    this.$value = t10;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                    return new C0284a(this.this$0, this.$collector, this.$value, fVar);
                }

                @Override // c9.p
                public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                    return ((C0284a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                        c9.q qVar = ((i) this.this$0).transform;
                        kotlinx.coroutines.flow.g<R> gVar = this.$collector;
                        T t10 = this.$value;
                        this.label = 1;
                        if (qVar.invoke(gVar, t10, this) == objC) {
                            return objC;
                        }
                    }
                    return z.f17874a;
                }
            }

            /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.i$a$a$b */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {30}, m = "emit")
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            static final class b extends kotlin.coroutines.jvm.internal.d {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                /* synthetic */ Object result;
                final /* synthetic */ C0283a<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(C0283a<? super T> c0283a, v8.f<? super b> fVar) {
                    super(fVar);
                    this.this$0 = c0283a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                public final Object invokeSuspend(Object obj) {
                    this.result = obj;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0283a(b0<u1> b0Var, l0 l0Var, i<T, R> iVar, kotlinx.coroutines.flow.g<? super R> gVar) {
                this.f14732a = b0Var;
                this.f14733b = l0Var;
                this.f14734c = iVar;
                this.f14735d = gVar;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.g
            public final Object emit(T t10, v8.f<? super z> fVar) {
                b bVar;
                C0283a<T> c0283a;
                if (fVar instanceof b) {
                    bVar = (b) fVar;
                    int i10 = bVar.label;
                    if ((i10 & Integer.MIN_VALUE) != 0) {
                        bVar.label = i10 - Integer.MIN_VALUE;
                    } else {
                        bVar = new b(this, fVar);
                    }
                } else {
                    bVar = new b(this, fVar);
                }
                Object obj = bVar.result;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i11 = bVar.label;
                if (i11 == 0) {
                    r8.r.b(obj);
                    u1 u1Var = this.f14732a.element;
                    if (u1Var != null) {
                        u1Var.a(new j());
                        bVar.L$0 = this;
                        bVar.L$1 = t10;
                        bVar.L$2 = u1Var;
                        bVar.label = 1;
                        if (u1Var.s(bVar) == objC) {
                            return objC;
                        }
                    }
                    c0283a = this;
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    t10 = (T) bVar.L$1;
                    c0283a = (C0283a) bVar.L$0;
                    r8.r.b(obj);
                }
                c0283a.f14732a.element = (T) kotlinx.coroutines.j.d(c0283a.f14733b, null, n0.UNDISPATCHED, new C0284a(c0283a.f14734c, c0283a.f14735d, t10, null), 1, null);
                return z.f17874a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i<T, R> iVar, kotlinx.coroutines.flow.g<? super R> gVar, v8.f<? super a> fVar) {
            super(2, fVar);
            this.this$0 = iVar;
            this.$collector = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            a aVar = new a(this.this$0, this.$collector, fVar);
            aVar.L$0 = obj;
            return aVar;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((a) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type v8.f to kotlinx.coroutines.flow.internal.i$a for r7v1 'this'  v8.f
            	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
            	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
            	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
            	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
            	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
            */
        @Override // kotlin.coroutines.jvm.internal.a
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                int r1 = r7.label
                r2 = 1
                if (r1 == 0) goto L17
                if (r1 != r2) goto Lf
                r8.r.b(r8)
                goto L37
            Lf:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L17:
                r8.r.b(r8)
                java.lang.Object r8 = r7.L$0
                kotlinx.coroutines.l0 r8 = (kotlinx.coroutines.l0) r8
                kotlin.jvm.internal.b0 r1 = new kotlin.jvm.internal.b0
                r1.<init>()
                kotlinx.coroutines.flow.internal.i<T, R> r3 = r7.this$0
                kotlinx.coroutines.flow.f<S> r4 = r3.flow
                kotlinx.coroutines.flow.internal.i$a$a r5 = new kotlinx.coroutines.flow.internal.i$a$a
                kotlinx.coroutines.flow.g<R> r6 = r7.$collector
                r5.<init>(r1, r8, r3, r6)
                r7.label = r2
                java.lang.Object r8 = r4.collect(r5, r7)
                if (r8 != r0) goto L37
                return r0
            L37:
                r8.z r8 = r8.z.f17874a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public /* synthetic */ i(c9.q qVar, kotlinx.coroutines.flow.f fVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar, int i11, kotlin.jvm.internal.g gVar) {
        this(qVar, fVar, (i11 & 4) != 0 ? v8.k.f19724a : jVar, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? kotlinx.coroutines.channels.a.SUSPEND : aVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    protected e<R> f(v8.j context, int capacity, kotlinx.coroutines.channels.a onBufferOverflow) {
        return new i(this.transform, this.flow, context, capacity, onBufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.g
    protected Object m(kotlinx.coroutines.flow.g<? super R> gVar, v8.f<? super z> fVar) {
        Object objC = m0.c(new a(this, gVar, null), fVar);
        return objC == kotlin.coroutines.intrinsics.b.c() ? objC : z.f17874a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(c9.q<? super kotlinx.coroutines.flow.g<? super R>, ? super T, ? super v8.f<? super z>, ? extends Object> qVar, kotlinx.coroutines.flow.f<? extends T> fVar, v8.j jVar, int i10, kotlinx.coroutines.channels.a aVar) {
        super(fVar, jVar, i10, aVar);
        this.transform = qVar;
    }
}
