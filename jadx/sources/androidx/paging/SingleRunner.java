package androidx.paging;

import c9.p;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.sync.c;
import kotlinx.coroutines.u1;
import r8.r;
import r8.z;
import v8.f;
import v8.j;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0003\u0012\u0011\u0013B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J;\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u000b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Landroidx/paging/SingleRunner;", "", "", "cancelPreviousInEqualPriority", "<init>", "(Z)V", "", "priority", "Lkotlin/Function1;", "Lv8/f;", "Lr8/z;", "block", "runInIsolation", "(ILc9/l;Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/SingleRunner$Holder;", "holder", "Landroidx/paging/SingleRunner$Holder;", "Companion", "CancelIsolatedRunnerException", "Holder", "paging-common"}, k = 1, mv = {1, 4, 1})
public final class SingleRunner {
    public static final int DEFAULT_PRIORITY = 0;
    private final Holder holder;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/paging/SingleRunner$CancelIsolatedRunnerException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "runner", "Landroidx/paging/SingleRunner;", "(Landroidx/paging/SingleRunner;)V", "getRunner", "()Landroidx/paging/SingleRunner;", "paging-common"}, k = 1, mv = {1, 4, 1})
    private static final class CancelIsolatedRunnerException extends CancellationException {
        private final SingleRunner runner;

        public CancelIsolatedRunnerException(SingleRunner runner) {
            m.f(runner, "runner");
            this.runner = runner;
        }

        public final SingleRunner getRunner() {
            return this.runner;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/paging/SingleRunner$Holder;", "", "Landroidx/paging/SingleRunner;", "singleRunner", "", "cancelPreviousInEqualPriority", "<init>", "(Landroidx/paging/SingleRunner;Z)V", "", "priority", "Lkotlinx/coroutines/u1;", "job", "tryEnqueue", "(ILkotlinx/coroutines/u1;Lv8/f;)Ljava/lang/Object;", "Lr8/z;", "onFinish", "(Lkotlinx/coroutines/u1;Lv8/f;)Ljava/lang/Object;", "Lkotlinx/coroutines/sync/a;", "mutex", "Lkotlinx/coroutines/sync/a;", "previous", "Lkotlinx/coroutines/u1;", "previousPriority", "I", "Landroidx/paging/SingleRunner;", "Z", "paging-common"}, k = 1, mv = {1, 4, 1})
    static final class Holder {
        private final boolean cancelPreviousInEqualPriority;
        private final kotlinx.coroutines.sync.a mutex;
        private u1 previous;
        private int previousPriority;
        private final SingleRunner singleRunner;

        public Holder(SingleRunner singleRunner, boolean z10) {
            m.f(singleRunner, "singleRunner");
            this.singleRunner = singleRunner;
            this.cancelPreviousInEqualPriority = z10;
            this.mutex = c.b(false, 1, null);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        public final Object onFinish(u1 u1Var, f<? super z> fVar) {
            SingleRunner$Holder$onFinish$1 singleRunner$Holder$onFinish$1;
            kotlinx.coroutines.sync.a aVar;
            Holder holder;
            if (fVar instanceof SingleRunner$Holder$onFinish$1) {
                singleRunner$Holder$onFinish$1 = (SingleRunner$Holder$onFinish$1) fVar;
                int i10 = singleRunner$Holder$onFinish$1.label;
                if ((i10 & Integer.MIN_VALUE) != 0) {
                    singleRunner$Holder$onFinish$1.label = i10 - Integer.MIN_VALUE;
                } else {
                    singleRunner$Holder$onFinish$1 = new SingleRunner$Holder$onFinish$1(this, fVar);
                }
            } else {
                singleRunner$Holder$onFinish$1 = new SingleRunner$Holder$onFinish$1(this, fVar);
            }
            Object obj = singleRunner$Holder$onFinish$1.result;
            Object objC = b.c();
            int i11 = singleRunner$Holder$onFinish$1.label;
            if (i11 == 0) {
                r.b(obj);
                aVar = this.mutex;
                singleRunner$Holder$onFinish$1.L$0 = this;
                singleRunner$Holder$onFinish$1.L$1 = u1Var;
                singleRunner$Holder$onFinish$1.L$2 = aVar;
                singleRunner$Holder$onFinish$1.label = 1;
                if (aVar.a(null, singleRunner$Holder$onFinish$1) == objC) {
                    return objC;
                }
                holder = this;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlinx.coroutines.sync.a aVar2 = (kotlinx.coroutines.sync.a) singleRunner$Holder$onFinish$1.L$2;
                u1 u1Var2 = (u1) singleRunner$Holder$onFinish$1.L$1;
                holder = (Holder) singleRunner$Holder$onFinish$1.L$0;
                r.b(obj);
                aVar = aVar2;
                u1Var = u1Var2;
            }
            try {
                if (u1Var == holder.previous) {
                    holder.previous = null;
                }
                z zVar = z.f17874a;
                return z.f17874a;
            } finally {
                aVar.b(null);
            }
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, kotlinx.coroutines.u1] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.u1] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public final Object tryEnqueue(int i10, u1 u1Var, f<? super Boolean> fVar) {
            SingleRunner$Holder$tryEnqueue$1 singleRunner$Holder$tryEnqueue$1;
            Holder holder;
            ?? r10;
            kotlinx.coroutines.sync.a aVar;
            ?? r11;
            Holder holder2;
            int i11;
            if (fVar instanceof SingleRunner$Holder$tryEnqueue$1) {
                singleRunner$Holder$tryEnqueue$1 = (SingleRunner$Holder$tryEnqueue$1) fVar;
                int i12 = singleRunner$Holder$tryEnqueue$1.label;
                if ((i12 & Integer.MIN_VALUE) != 0) {
                    singleRunner$Holder$tryEnqueue$1.label = i12 - Integer.MIN_VALUE;
                } else {
                    singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue$1(this, fVar);
                }
            } else {
                singleRunner$Holder$tryEnqueue$1 = new SingleRunner$Holder$tryEnqueue$1(this, fVar);
            }
            Object obj = singleRunner$Holder$tryEnqueue$1.result;
            Object objC = b.c();
            int i13 = singleRunner$Holder$tryEnqueue$1.label;
            boolean z10 = true;
            try {
                if (i13 == 0) {
                    r.b(obj);
                    kotlinx.coroutines.sync.a aVar2 = this.mutex;
                    singleRunner$Holder$tryEnqueue$1.L$0 = this;
                    singleRunner$Holder$tryEnqueue$1.L$1 = u1Var;
                    singleRunner$Holder$tryEnqueue$1.L$2 = aVar2;
                    singleRunner$Holder$tryEnqueue$1.I$0 = i10;
                    singleRunner$Holder$tryEnqueue$1.label = 1;
                    if (aVar2.a(null, singleRunner$Holder$tryEnqueue$1) != objC) {
                        holder = this;
                        r10 = u1Var;
                        aVar = aVar2;
                    }
                    return objC;
                }
                if (i13 == 1) {
                    i10 = singleRunner$Holder$tryEnqueue$1.I$0;
                    kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) singleRunner$Holder$tryEnqueue$1.L$2;
                    u1 u1Var2 = (u1) singleRunner$Holder$tryEnqueue$1.L$1;
                    holder = (Holder) singleRunner$Holder$tryEnqueue$1.L$0;
                    r.b(obj);
                    r10 = u1Var2;
                    aVar = aVar3;
                } else {
                    if (i13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i10 = singleRunner$Holder$tryEnqueue$1.I$0;
                    kotlinx.coroutines.sync.a aVar4 = (kotlinx.coroutines.sync.a) singleRunner$Holder$tryEnqueue$1.L$2;
                    u1 u1Var3 = (u1) singleRunner$Holder$tryEnqueue$1.L$1;
                    holder2 = (Holder) singleRunner$Holder$tryEnqueue$1.L$0;
                    r.b(obj);
                    r11 = u1Var3;
                    aVar = aVar4;
                }
                holder = holder2;
                r10 = r11;
                holder.previous = r10;
                holder.previousPriority = i10;
                u1Var = aVar;
                Boolean boolA = kotlin.coroutines.jvm.internal.b.a(z10);
                u1Var.b(null);
                return boolA;
                u1 u1Var4 = holder.previous;
                if (u1Var4 == null || !u1Var4.isActive() || (i11 = holder.previousPriority) < i10 || (i11 == i10 && holder.cancelPreviousInEqualPriority)) {
                    if (u1Var4 != null) {
                        u1Var4.a(new CancelIsolatedRunnerException(holder.singleRunner));
                    }
                    if (u1Var4 != null) {
                        singleRunner$Holder$tryEnqueue$1.L$0 = holder;
                        singleRunner$Holder$tryEnqueue$1.L$1 = r10;
                        singleRunner$Holder$tryEnqueue$1.L$2 = aVar;
                        singleRunner$Holder$tryEnqueue$1.I$0 = i10;
                        singleRunner$Holder$tryEnqueue$1.label = 2;
                        if (u1Var4.s(singleRunner$Holder$tryEnqueue$1) != objC) {
                            r11 = r10;
                            holder2 = holder;
                            aVar = aVar;
                            holder = holder2;
                            r10 = r11;
                        }
                        return objC;
                    }
                    holder.previous = r10;
                    holder.previousPriority = i10;
                    u1Var = aVar;
                } else {
                    z10 = false;
                    u1Var = aVar;
                }
                Boolean boolA2 = kotlin.coroutines.jvm.internal.b.a(z10);
                u1Var.b(null);
                return boolA2;
            } catch (Throwable th) {
                u1Var.b(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.SingleRunner", f = "SingleRunner.kt", l = {49}, m = "runInIsolation")
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "priority", "Lkotlin/Function1;", "Lv8/f;", "Lr8/z;", "", "block", "continuation", "runInIsolation", "(ILc9/l;Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SingleRunner.this.runInIsolation(0, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.SingleRunner$runInIsolation$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", l = {55, 59, 61, 61}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass2 extends l implements p<l0, f<? super z>, Object> {
        final /* synthetic */ c9.l $block;
        final /* synthetic */ int $priority;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i10, c9.l lVar, f fVar) {
            super(2, fVar);
            this.$priority = i10;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final f<z> create(Object obj, f<?> completion) {
            m.f(completion, "completion");
            AnonymousClass2 anonymousClass2 = SingleRunner.this.new AnonymousClass2(this.$priority, this.$block, completion);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, f<? super z> fVar) {
            return ((AnonymousClass2) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
        
            if (r9.onFinish(r1, r8) == r0) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.u1] */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.u1] */
        /* JADX WARN: Type inference failed for: r3v2, types: [androidx.paging.SingleRunner$Holder] */
        /* JADX WARN: Type inference failed for: r9v15, types: [androidx.paging.SingleRunner$Holder] */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            u1 u1Var;
            Object objC = b.c();
            ?? r10 = this.label;
            int i10 = 4;
            try {
                if (r10 != 0) {
                    if (r10 != 1) {
                        if (r10 != 2) {
                            if (r10 != 3) {
                                if (r10 != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                Throwable th = (Throwable) this.L$0;
                                r.b(obj);
                                throw th;
                            }
                            r.b(obj);
                        } else {
                            u1 u1Var2 = (u1) this.L$0;
                            r.b(obj);
                            r10 = u1Var2;
                            r10 = u1Var;
                            ?? r11 = SingleRunner.this.holder;
                            i10 = 0;
                            this.L$0 = null;
                            this.label = 3;
                        }
                    } else {
                        u1 u1Var3 = (u1) this.L$0;
                        r.b(obj);
                        u1Var = u1Var3;
                    }
                    return z.f17874a;
                }
                r.b(obj);
                j.b bVar = ((l0) this.L$0).getCoroutineContext().get(u1.INSTANCE);
                if (bVar != null) {
                    u1 u1Var4 = (u1) bVar;
                    Holder holder = SingleRunner.this.holder;
                    int i11 = this.$priority;
                    this.L$0 = u1Var4;
                    this.label = 1;
                    Object objTryEnqueue = holder.tryEnqueue(i11, u1Var4, this);
                    if (objTryEnqueue != objC) {
                        u1Var = u1Var4;
                        obj = objTryEnqueue;
                    }
                    r10 = u1Var;
                    return objC;
                }
                throw new IllegalStateException("Internal error. coroutineScope should've created a job.");
                if (((Boolean) obj).booleanValue()) {
                    c9.l lVar = this.$block;
                    this.L$0 = u1Var;
                    this.label = 2;
                    if (lVar.invoke(this) != objC) {
                        r10 = u1Var;
                        ?? r12 = SingleRunner.this.holder;
                        i10 = 0;
                        this.L$0 = null;
                        this.label = 3;
                    }
                    r10 = u1Var;
                    return objC;
                }
                return z.f17874a;
            } catch (Throwable th2) {
                ?? r13 = SingleRunner.this.holder;
                this.L$0 = th2;
                this.label = i10;
                if (r13.onFinish(r10, this) != objC) {
                    throw th2;
                }
            }
        }
    }

    public SingleRunner() {
        this(false, 1, null);
    }

    public SingleRunner(boolean z10) {
        this.holder = new Holder(this, z10);
    }

    public static /* synthetic */ Object runInIsolation$default(SingleRunner singleRunner, int i10, c9.l lVar, f fVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return singleRunner.runInIsolation(i10, lVar, fVar);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object runInIsolation(int i10, c9.l<? super f<? super z>, ? extends Object> lVar, f<? super z> fVar) {
        AnonymousClass1 anonymousClass1;
        SingleRunner singleRunner;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object obj = anonymousClass1.result;
        Object objC = b.c();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            r.b(obj);
            try {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(i10, lVar, null);
                anonymousClass1.L$0 = this;
                anonymousClass1.label = 1;
                if (m0.c(anonymousClass2, anonymousClass1) == objC) {
                    return objC;
                }
            } catch (CancelIsolatedRunnerException e10) {
                e = e10;
                singleRunner = this;
                if (e.getRunner() != singleRunner) {
                    throw e;
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            singleRunner = (SingleRunner) anonymousClass1.L$0;
            try {
                r.b(obj);
            } catch (CancelIsolatedRunnerException e11) {
                e = e11;
                if (e.getRunner() != singleRunner) {
                    throw e;
                }
            }
        }
        return z.f17874a;
    }

    public /* synthetic */ SingleRunner(boolean z10, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
