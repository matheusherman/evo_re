package androidx.p000lifecycle;

import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.g2;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;
import kotlinx.coroutines.sync.a;
import kotlinx.coroutines.sync.c;
import kotlinx.coroutines.u1;
import r8.q;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001aC\u0010\t\u001a\u00020\u0006*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "state", "Lkotlin/Function2;", "Lkotlinx/coroutines/l0;", "Lv8/f;", "Lr8/z;", "", "block", "repeatOnLifecycle", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lc9/p;Lv8/f;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lc9/p;Lv8/f;)Ljava/lang/Object;", "lifecycle-runtime-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RepeatOnLifecycleKt {

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass3 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
        static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
            final /* synthetic */ l0 $$this$coroutineScope;
            final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
            final /* synthetic */ Lifecycle.State $state;
            final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, l0 l0Var, p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super AnonymousClass1> fVar) {
                super(2, fVar);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = l0Var;
                this.$block = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:28:0x00af  */
            /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
            /* JADX WARN: Code duplicated, block: B:36:0x00c6  */
            /* JADX WARN: Code duplicated, block: B:39:0x00cf  */
            /* JADX WARN: Code duplicated, block: B:45:? A[SYNTHETIC] */
            /* JADX WARN: Type inference failed for: r4v3, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                b0 b0Var;
                Throwable th;
                b0 b0Var2;
                u1 u1Var;
                LifecycleEventObserver lifecycleEventObserver;
                u1 u1Var2;
                LifecycleEventObserver lifecycleEventObserver2;
                Object objC = b.c();
                int i10 = this.label;
                if (i10 != 0) {
                    if (i10 == 1) {
                        b0Var = (b0) this.L$1;
                        b0Var2 = (b0) this.L$0;
                        try {
                            r.b(obj);
                            u1Var2 = (u1) b0Var2.element;
                            if (u1Var2 != null) {
                                u1.a.a(u1Var2, null, 1, null);
                            }
                            lifecycleEventObserver2 = (LifecycleEventObserver) b0Var.element;
                            if (lifecycleEventObserver2 != null) {
                                this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                            }
                            return z.f17874a;
                        } catch (Throwable th2) {
                            th = th2;
                            u1Var = (u1) b0Var2.element;
                            if (u1Var != null) {
                                u1.a.a(u1Var, null, 1, null);
                            }
                            lifecycleEventObserver = (LifecycleEventObserver) b0Var.element;
                            if (lifecycleEventObserver != null) {
                                this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                                throw th;
                            }
                            throw th;
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                r.b(obj);
                if (this.$this_repeatOnLifecycle.getState() == Lifecycle.State.DESTROYED) {
                    return z.f17874a;
                }
                final b0 b0Var3 = new b0();
                b0Var = new b0();
                try {
                    Lifecycle.State state = this.$state;
                    Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                    final l0 l0Var = this.$$this$coroutineScope;
                    final p<l0, v8.f<? super z>, Object> pVar = this.$block;
                    this.L$0 = b0Var3;
                    this.L$1 = b0Var;
                    this.L$2 = state;
                    this.L$3 = lifecycle;
                    this.L$4 = l0Var;
                    this.L$5 = pVar;
                    this.label = 1;
                    final o oVar = new o(b.b(this), 1);
                    oVar.D();
                    Lifecycle.Event.Companion companion = Lifecycle.Event.INSTANCE;
                    final Lifecycle.Event eventUpTo = companion.upTo(state);
                    final Lifecycle.Event eventDownFrom = companion.downFrom(state);
                    final a aVarB = c.b(false, 1, null);
                    ?? r10 = new LifecycleEventObserver() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                        /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                        @f(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, 110}, m = "invokeSuspend")
                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
                        static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
                            final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
                            final /* synthetic */ a $mutex;
                            Object L$0;
                            Object L$1;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            AnonymousClass1(a aVar, p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super AnonymousClass1> fVar) {
                                super(2, fVar);
                                this.$mutex = aVar;
                                this.$block = pVar;
                            }

                            @Override // kotlin.coroutines.jvm.internal.a
                            public final v8.f<z> create(Object obj, v8.f<?> fVar) {
                                return new AnonymousClass1(this.$mutex, this.$block, fVar);
                            }

                            @Override // c9.p
                            public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
                                return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
                            }

                            @Override // kotlin.coroutines.jvm.internal.a
                            public final Object invokeSuspend(Object obj) throws Throwable {
                                a aVar;
                                p<l0, v8.f<? super z>, Object> pVar;
                                a aVar2;
                                Throwable th;
                                Object objC = b.c();
                                int i10 = this.label;
                                try {
                                    if (i10 != 0) {
                                        if (i10 != 1) {
                                            if (i10 == 2) {
                                                aVar2 = (a) this.L$0;
                                                try {
                                                    r.b(obj);
                                                    z zVar = z.f17874a;
                                                    aVar2.b(null);
                                                    return z.f17874a;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    aVar2.b(null);
                                                    throw th;
                                                }
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        pVar = (p) this.L$1;
                                        a aVar3 = (a) this.L$0;
                                        r.b(obj);
                                        aVar = aVar3;
                                    } else {
                                        r.b(obj);
                                        aVar = this.$mutex;
                                        pVar = this.$block;
                                        this.L$0 = aVar;
                                        this.L$1 = pVar;
                                        this.label = 1;
                                        if (aVar.a(null, this) != objC) {
                                        }
                                        return objC;
                                    }
                                    RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(pVar, null);
                                    this.L$0 = aVar;
                                    this.L$1 = null;
                                    this.label = 2;
                                    if (m0.c(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) != objC) {
                                        aVar2 = aVar;
                                        z zVar2 = z.f17874a;
                                        aVar2.b(null);
                                        return z.f17874a;
                                    }
                                    return objC;
                                } catch (Throwable th3) {
                                    aVar2 = aVar;
                                    th = th3;
                                    aVar2.b(null);
                                    throw th;
                                }
                            }
                        }

                        /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.u1] */
                        @Override // androidx.p000lifecycle.LifecycleEventObserver
                        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                            m.f(lifecycleOwner, "<anonymous parameter 0>");
                            m.f(event, "event");
                            if (event == eventUpTo) {
                                b0Var3.element = j.d(l0Var, null, null, new AnonymousClass1(aVarB, pVar, null), 3, null);
                                return;
                            }
                            if (event == eventDownFrom) {
                                u1 u1Var3 = b0Var3.element;
                                if (u1Var3 != null) {
                                    u1.a.a(u1Var3, null, 1, null);
                                }
                                b0Var3.element = null;
                            }
                            if (event == Lifecycle.Event.ON_DESTROY) {
                                n<z> nVar = oVar;
                                q.Companion companion2 = q.INSTANCE;
                                nVar.resumeWith(q.a(z.f17874a));
                            }
                        }
                    };
                    b0Var.element = r10;
                    m.d(r10, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                    lifecycle.addObserver((LifecycleEventObserver) r10);
                    Object objZ = oVar.z();
                    if (objZ == b.c()) {
                        h.c(this);
                    }
                    if (objZ == objC) {
                        return objC;
                    }
                    b0Var2 = b0Var3;
                    u1Var2 = (u1) b0Var2.element;
                    if (u1Var2 != null) {
                        u1.a.a(u1Var2, null, 1, null);
                    }
                    lifecycleEventObserver2 = (LifecycleEventObserver) b0Var.element;
                    if (lifecycleEventObserver2 != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver2);
                    }
                    return z.f17874a;
                } catch (Throwable th3) {
                    th = th3;
                    b0Var2 = b0Var3;
                    u1Var = (u1) b0Var2.element;
                    if (u1Var != null) {
                        u1.a.a(u1Var, null, 1, null);
                    }
                    lifecycleEventObserver = (LifecycleEventObserver) b0Var.element;
                    if (lifecycleEventObserver != null) {
                        this.$this_repeatOnLifecycle.removeObserver(lifecycleEventObserver);
                        throw th;
                    }
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super AnonymousClass3> fVar) {
            super(2, fVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, fVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass3) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                l0 l0Var = (l0) this.L$0;
                g2 immediate = a1.c().getImmediate();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, l0Var, this.$block, null);
                this.label = 1;
                if (kotlinx.coroutines.h.g(immediate, anonymousClass1, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super z> fVar) {
        if (state == Lifecycle.State.INITIALIZED) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
        }
        if (lifecycle.getState() == Lifecycle.State.DESTROYED) {
            return z.f17874a;
        }
        Object objC = m0.c(new AnonymousClass3(lifecycle, state, pVar, null), fVar);
        return objC == b.c() ? objC : z.f17874a;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super z> fVar) {
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycleOwner.getLifecycle(), state, pVar, fVar);
        return objRepeatOnLifecycle == b.c() ? objRepeatOnLifecycle : z.f17874a;
    }
}
