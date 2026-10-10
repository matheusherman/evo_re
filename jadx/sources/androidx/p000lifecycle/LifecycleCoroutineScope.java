package androidx.p000lifecycle;

import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\n\u001a\u00020\t2\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ6\u0010\f\u001a\u00020\t2\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ6\u0010\r\u001a\u00020\t2\"\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8 X \u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScope;", "Lkotlinx/coroutines/l0;", "<init>", "()V", "Lkotlin/Function2;", "Lv8/f;", "Lr8/z;", "", "block", "Lkotlinx/coroutines/u1;", "launchWhenCreated", "(Lc9/p;)Lkotlinx/coroutines/u1;", "launchWhenStarted", "launchWhenResumed", "Landroidx/lifecycle/Lifecycle;", "getLifecycle$lifecycle_common", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class LifecycleCoroutineScope implements l0 {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", l = {337}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass1 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super AnonymousClass1> fVar) {
            super(2, fVar);
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle();
                p<l0, v8.f<? super z>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, pVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", l = {375}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class C05221 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05221(p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super C05221> fVar) {
            super(2, fVar);
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return LifecycleCoroutineScope.this.new C05221(this.$block, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05221) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle();
                p<l0, v8.f<? super z>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_common, pVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {356}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 8, 0})
    static final class C05231 extends l implements p<l0, v8.f<? super z>, Object> {
        final /* synthetic */ p<l0, v8.f<? super z>, Object> $block;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05231(p<? super l0, ? super v8.f<? super z>, ? extends Object> pVar, v8.f<? super C05231> fVar) {
            super(2, fVar);
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            return LifecycleCoroutineScope.this.new C05231(this.$block, fVar);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05231) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                Lifecycle lifecycle$lifecycle_common = LifecycleCoroutineScope.this.getLifecycle();
                p<l0, v8.f<? super z>, Object> pVar = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_common, pVar, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    @Override // kotlinx.coroutines.l0
    public abstract /* synthetic */ j getCoroutineContext();

    /* JADX INFO: renamed from: getLifecycle$lifecycle_common */
    public abstract Lifecycle getLifecycle();

    public final u1 launchWhenCreated(p<? super l0, ? super v8.f<? super z>, ? extends Object> block) {
        m.f(block, "block");
        return kotlinx.coroutines.j.d(this, null, null, new AnonymousClass1(block, null), 3, null);
    }

    public final u1 launchWhenResumed(p<? super l0, ? super v8.f<? super z>, ? extends Object> block) {
        m.f(block, "block");
        return kotlinx.coroutines.j.d(this, null, null, new C05221(block, null), 3, null);
    }

    public final u1 launchWhenStarted(p<? super l0, ? super v8.f<? super z>, ? extends Object> block) {
        m.f(block, "block");
        return kotlinx.coroutines.j.d(this, null, null, new C05231(block, null), 3, null);
    }
}
