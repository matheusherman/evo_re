package androidx.room;

import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import r8.r;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1", f = "CoroutinesRoom.kt", l = {110}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/flow/g;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/flow/g;)V"}, k = 3, mv = {1, 7, 1})
final class CoroutinesRoom$Companion$createFlow$1<R> extends kotlin.coroutines.jvm.internal.l implements c9.p<kotlinx.coroutines.flow.g<R>, v8.f<? super r8.z>, Object> {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ RoomDatabase $db;
    final /* synthetic */ boolean $inTransaction;
    final /* synthetic */ String[] $tableNames;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1", f = "CoroutinesRoom.kt", l = {136}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 7, 1})
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.g<R> $$this$flow;
        final /* synthetic */ Callable<R> $callable;
        final /* synthetic */ RoomDatabase $db;
        final /* synthetic */ boolean $inTransaction;
        final /* synthetic */ String[] $tableNames;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.room.CoroutinesRoom$Companion$createFlow$1$1$1", f = "CoroutinesRoom.kt", l = {127, 129}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"R", "Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 7, 1})
        static final class C00271 extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
            final /* synthetic */ Callable<R> $callable;
            final /* synthetic */ RoomDatabase $db;
            final /* synthetic */ CoroutinesRoom$Companion$createFlow$1$1$observer$1 $observer;
            final /* synthetic */ kotlinx.coroutines.channels.d<r8.z> $observerChannel;
            final /* synthetic */ kotlinx.coroutines.channels.d<R> $resultChannel;
            Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00271(RoomDatabase roomDatabase, CoroutinesRoom$Companion$createFlow$1$1$observer$1 coroutinesRoom$Companion$createFlow$1$1$observer$1, kotlinx.coroutines.channels.d<r8.z> dVar, Callable<R> callable, kotlinx.coroutines.channels.d<R> dVar2, v8.f<? super C00271> fVar) {
                super(2, fVar);
                this.$db = roomDatabase;
                this.$observer = coroutinesRoom$Companion$createFlow$1$1$observer$1;
                this.$observerChannel = dVar;
                this.$callable = callable;
                this.$resultChannel = dVar2;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                return new C00271(this.$db, this.$observer, this.$observerChannel, this.$callable, this.$resultChannel, fVar);
            }

            @Override // c9.p
            public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
                return ((C00271) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:20:0x0047  */
            /* JADX WARN: Code duplicated, block: B:21:0x0048  */
            /* JADX WARN: Code duplicated, block: B:24:0x0053 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:7:0x0012, B:18:0x003d, B:22:0x004b, B:24:0x0053, B:14:0x0025, B:17:0x0037), top: B:31:0x0008 }] */
            /* JADX WARN: Code duplicated, block: B:27:0x0069  */
            /* JADX WARN: Code restructure failed: missing block: B:25:0x0066, code lost:
            
                if (r4.b(r7, r6) == r0) goto L26;
             */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:8:0x0015). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                kotlinx.coroutines.channels.f<r8.z> it;
                kotlinx.coroutines.channels.f<r8.z> fVar;
                Object objA;
                Object objC = kotlin.coroutines.intrinsics.b.c();
                int i10 = this.label;
                try {
                    if (i10 != 0) {
                        if (i10 != 1) {
                            if (i10 == 2) {
                                fVar = (kotlinx.coroutines.channels.f) this.L$0;
                                r.b(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            fVar = (kotlinx.coroutines.channels.f) this.L$0;
                            r.b(obj);
                            if (((Boolean) obj).booleanValue()) {
                                fVar.next();
                                R rCall = this.$callable.call();
                                kotlinx.coroutines.channels.d<R> dVar = this.$resultChannel;
                                this.L$0 = fVar;
                                this.label = 2;
                            } else {
                                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                                return r8.z.f17874a;
                            }
                        }
                    } else {
                        r.b(obj);
                        this.$db.getInvalidationTracker().addObserver(this.$observer);
                        it = this.$observerChannel.iterator();
                        this.L$0 = it;
                        this.label = 1;
                        objA = it.a(this);
                        if (objA == objC) {
                            fVar = it;
                            obj = objA;
                            if (((Boolean) obj).booleanValue()) {
                                fVar.next();
                                R rCall2 = this.$callable.call();
                                kotlinx.coroutines.channels.d<R> dVar2 = this.$resultChannel;
                                this.L$0 = fVar;
                                this.label = 2;
                            } else {
                                this.$db.getInvalidationTracker().removeObserver(this.$observer);
                                return r8.z.f17874a;
                            }
                        }
                        return objC;
                    }
                    it = fVar;
                    this.L$0 = it;
                    this.label = 1;
                    objA = it.a(this);
                    if (objA == objC) {
                        fVar = it;
                        obj = objA;
                        if (((Boolean) obj).booleanValue()) {
                            fVar.next();
                            R rCall3 = this.$callable.call();
                            kotlinx.coroutines.channels.d<R> dVar3 = this.$resultChannel;
                            this.L$0 = fVar;
                            this.label = 2;
                        } else {
                            this.$db.getInvalidationTracker().removeObserver(this.$observer);
                            return r8.z.f17874a;
                        }
                    }
                    return objC;
                } catch (Throwable th) {
                    this.$db.getInvalidationTracker().removeObserver(this.$observer);
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, RoomDatabase roomDatabase, kotlinx.coroutines.flow.g<R> gVar, String[] strArr, Callable<R> callable, v8.f<? super AnonymousClass1> fVar) {
            super(2, fVar);
            this.$inTransaction = z10;
            this.$db = roomDatabase;
            this.$$this$flow = gVar;
            this.$tableNames = strArr;
            this.$callable = callable;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, this.$$this$flow, this.$tableNames, this.$callable, fVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
            return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Type inference failed for: r7v0, types: [androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1] */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            v8.g queryDispatcher;
            Object objC = kotlin.coroutines.intrinsics.b.c();
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
                final kotlinx.coroutines.channels.d dVarB = kotlinx.coroutines.channels.g.b(-1, null, null, 6, null);
                final String[] strArr = this.$tableNames;
                ?? r10 = new InvalidationTracker.Observer(strArr) { // from class: androidx.room.CoroutinesRoom$Companion$createFlow$1$1$observer$1
                    @Override // androidx.room.InvalidationTracker.Observer
                    public void onInvalidated(Set<String> tables) {
                        kotlin.jvm.internal.m.f(tables, "tables");
                        dVarB.i(r8.z.f17874a);
                    }
                };
                dVarB.i(r8.z.f17874a);
                TransactionElement transactionElement = (TransactionElement) l0Var.getCoroutineContext().get(TransactionElement.INSTANCE);
                if (transactionElement == null || (queryDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                    if (this.$inTransaction) {
                        queryDispatcher = CoroutinesRoomKt.getTransactionDispatcher(this.$db);
                    } else {
                        queryDispatcher = CoroutinesRoomKt.getQueryDispatcher(this.$db);
                    }
                }
                kotlinx.coroutines.channels.d dVarB2 = kotlinx.coroutines.channels.g.b(0, null, null, 7, null);
                kotlinx.coroutines.j.d(l0Var, queryDispatcher, null, new C00271(this.$db, r10, dVarB, this.$callable, dVarB2, null), 2, null);
                kotlinx.coroutines.flow.g<R> gVar = this.$$this$flow;
                this.label = 1;
                if (kotlinx.coroutines.flow.h.o(gVar, dVarB2, this) == objC) {
                    return objC;
                }
            }
            return r8.z.f17874a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesRoom$Companion$createFlow$1(boolean z10, RoomDatabase roomDatabase, String[] strArr, Callable<R> callable, v8.f<? super CoroutinesRoom$Companion$createFlow$1> fVar) {
        super(2, fVar);
        this.$inTransaction = z10;
        this.$db = roomDatabase;
        this.$tableNames = strArr;
        this.$callable = callable;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
        CoroutinesRoom$Companion$createFlow$1 coroutinesRoom$Companion$createFlow$1 = new CoroutinesRoom$Companion$createFlow$1(this.$inTransaction, this.$db, this.$tableNames, this.$callable, fVar);
        coroutinesRoom$Companion$createFlow$1.L$0 = obj;
        return coroutinesRoom$Companion$createFlow$1;
    }

    @Override // c9.p
    public final Object invoke(kotlinx.coroutines.flow.g<R> gVar, v8.f<? super r8.z> fVar) {
        return ((CoroutinesRoom$Companion$createFlow$1) create(gVar, fVar)).invokeSuspend(r8.z.f17874a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                r.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            r.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$inTransaction, this.$db, (kotlinx.coroutines.flow.g) this.L$0, this.$tableNames, this.$callable, null);
            this.label = 1;
            if (m0.c(anonymousClass1, this) == objC) {
                return objC;
            }
        }
        return r8.z.f17874a;
    }
}
