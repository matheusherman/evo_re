package androidx.p000lifecycle;

import androidx.exifinterface.media.ExifInterface;
import c9.p;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.a1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\n\u001aA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\b\u001aA\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u001aA\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\b\u001aA\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001aI\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0002H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function2;", "Lkotlinx/coroutines/l0;", "Lv8/f;", "", "block", "whenCreated", "(Landroidx/lifecycle/LifecycleOwner;Lc9/p;Lv8/f;)Ljava/lang/Object;", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;Lc9/p;Lv8/f;)Ljava/lang/Object;", "whenStarted", "whenResumed", "Landroidx/lifecycle/Lifecycle$State;", "minState", "whenStateAtLeast", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lc9/p;Lv8/f;)Ljava/lang/Object;", "lifecycle-common"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {203}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/l0;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    static final class AnonymousClass2<T> extends l implements p<l0, v8.f<? super T>, Object> {
        final /* synthetic */ p<l0, v8.f<? super T>, Object> $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super AnonymousClass2> fVar) {
            super(2, fVar);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> fVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, fVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super T> fVar) {
            return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    lifecycleController = (LifecycleController) this.L$0;
                    try {
                        r.b(obj);
                        lifecycleController.finish();
                        return obj;
                    } catch (Throwable th) {
                        th = th;
                        lifecycleController.finish();
                        throw th;
                    }
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(obj);
            u1 u1Var = (u1) ((l0) this.L$0).getCoroutineContext().get(u1.INSTANCE);
            if (u1Var != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, u1Var);
                try {
                    p<l0, v8.f<? super T>, Object> pVar = this.$block;
                    this.L$0 = lifecycleController2;
                    this.label = 1;
                    obj = h.g(pausingDispatcher, pVar, this);
                    if (obj == objC) {
                        return objC;
                    }
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            }
            throw new IllegalStateException("when[State] methods should have a parent job");
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenCreated(lifecycleOwner.getLifecycle(), pVar, fVar);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenResumed(lifecycleOwner.getLifecycle(), pVar, fVar);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenStarted(lifecycleOwner.getLifecycle(), pVar, fVar);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, pVar, fVar);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, pVar, fVar);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, pVar, fVar);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, p<? super l0, ? super v8.f<? super T>, ? extends Object> pVar, v8.f<? super T> fVar) {
        return h.g(a1.c().getImmediate(), new AnonymousClass2(lifecycle, state, pVar, null), fVar);
    }
}
