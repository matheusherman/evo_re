package androidx.room;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Metadata;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.s2;
import kotlinx.coroutines.u1;
import r8.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\b*\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"R", "Landroidx/room/RoomDatabase;", "Lkotlin/Function1;", "Lv8/f;", "", "block", "withTransaction", "(Landroidx/room/RoomDatabase;Lc9/l;Lv8/f;)Ljava/lang/Object;", "Lv8/j;", "createTransactionContext", "(Landroidx/room/RoomDatabase;Lv8/f;)Ljava/lang/Object;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/u1;", "controlJob", "Lv8/g;", "acquireTransactionThread", "(Ljava/util/concurrent/Executor;Lkotlinx/coroutines/u1;Lv8/f;)Ljava/lang/Object;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RoomDatabaseKt {

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", l = {100}, m = "createTransactionContext")
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.createTransactionContext(null, this);
        }

        AnonymousClass1(v8.f<? super AnonymousClass1> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$createTransactionContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lr8/z;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    static final class AnonymousClass2 extends kotlin.jvm.internal.o implements c9.l<Throwable, r8.z> {
        final /* synthetic */ kotlinx.coroutines.z $controlJob;

        @Override // c9.l
        public /* bridge */ /* synthetic */ r8.z invoke(Throwable th) {
            invoke2(th);
            return r8.z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(kotlinx.coroutines.z zVar) {
            super(1);
            this.$controlJob = zVar;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            u1.a.a(this.$controlJob, null, 1, null);
        }
    }

    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabaseExt.kt", l = {51, 52}, m = "withTransaction")
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C05741<R> extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoomDatabaseKt.withTransaction(null, null, this);
        }

        C05741(v8.f<? super C05741> fVar) {
            super(fVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$withTransaction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt$withTransaction$2", f = "RoomDatabaseExt.kt", l = {59}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"R", "Lkotlinx/coroutines/l0;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    static final class C05752<R> extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super R>, Object> {
        final /* synthetic */ c9.l<v8.f<? super R>, Object> $block;
        final /* synthetic */ RoomDatabase $this_withTransaction;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C05752(RoomDatabase roomDatabase, c9.l<? super v8.f<? super R>, ? extends Object> lVar, v8.f<? super C05752> fVar) {
            super(2, fVar);
            this.$this_withTransaction = roomDatabase;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
            C05752 c05752 = new C05752(this.$this_withTransaction, this.$block, fVar);
            c05752.L$0 = obj;
            return c05752;
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super R> fVar) {
            return ((C05752) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            TransactionElement transactionElement;
            TransactionElement transactionElementC = kotlin.coroutines.intrinsics.b.c();
            int i10 = this.label;
            try {
                if (i10 != 0) {
                    if (i10 == 1) {
                        transactionElement = (TransactionElement) this.L$0;
                        try {
                            r.b(obj);
                        } catch (Throwable th2) {
                            th = th2;
                            this.$this_withTransaction.endTransaction();
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    r.b(obj);
                    v8.j.b bVar = ((l0) this.L$0).getCoroutineContext().get(TransactionElement.INSTANCE);
                    kotlin.jvm.internal.m.c(bVar);
                    TransactionElement transactionElement2 = (TransactionElement) bVar;
                    transactionElement2.acquire();
                    try {
                        this.$this_withTransaction.beginTransaction();
                        try {
                            c9.l<v8.f<? super R>, Object> lVar = this.$block;
                            this.L$0 = transactionElement2;
                            this.label = 1;
                            Object objInvoke = lVar.invoke(this);
                            if (objInvoke == transactionElementC) {
                                return transactionElementC;
                            }
                            transactionElement = transactionElement2;
                            obj = objInvoke;
                        } catch (Throwable th3) {
                            th = th3;
                            this.$this_withTransaction.endTransaction();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        transactionElementC = transactionElement2;
                        th = th4;
                        transactionElementC.release();
                        throw th;
                    }
                }
                this.$this_withTransaction.setTransactionSuccessful();
                this.$this_withTransaction.endTransaction();
                transactionElement.release();
                return obj;
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object acquireTransactionThread(Executor executor, final u1 u1Var, v8.f<? super v8.g> fVar) {
        final kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
        oVar.D();
        oVar.h(new RoomDatabaseKt$acquireTransactionThread$2$1(u1Var));
        try {
            executor.execute(new Runnable() { // from class: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2

                /* JADX INFO: renamed from: androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
                @kotlin.coroutines.jvm.internal.f(c = "androidx.room.RoomDatabaseKt$acquireTransactionThread$2$2$1", f = "RoomDatabaseExt.kt", l = {125}, m = "invokeSuspend")
                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/l0;", "Lr8/z;", "<anonymous>", "(Lkotlinx/coroutines/l0;)V"}, k = 3, mv = {1, 7, 1})
                static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements c9.p<l0, v8.f<? super r8.z>, Object> {
                    final /* synthetic */ kotlinx.coroutines.n<v8.g> $continuation;
                    final /* synthetic */ u1 $controlJob;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    AnonymousClass1(kotlinx.coroutines.n<? super v8.g> nVar, u1 u1Var, v8.f<? super AnonymousClass1> fVar) {
                        super(2, fVar);
                        this.$continuation = nVar;
                        this.$controlJob = u1Var;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    public final v8.f<r8.z> create(Object obj, v8.f<?> fVar) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$continuation, this.$controlJob, fVar);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // c9.p
                    public final Object invoke(l0 l0Var, v8.f<? super r8.z> fVar) {
                        return ((AnonymousClass1) create(l0Var, fVar)).invokeSuspend(r8.z.f17874a);
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
                            l0 l0Var = (l0) this.L$0;
                            kotlinx.coroutines.n<v8.g> nVar = this.$continuation;
                            r8.q.Companion companion = r8.q.INSTANCE;
                            v8.j.b bVar = l0Var.getCoroutineContext().get(v8.g.INSTANCE);
                            kotlin.jvm.internal.m.c(bVar);
                            nVar.resumeWith(r8.q.a(bVar));
                            u1 u1Var = this.$controlJob;
                            this.label = 1;
                            if (u1Var.s(this) == objC) {
                                return objC;
                            }
                        }
                        return r8.z.f17874a;
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    kotlinx.coroutines.i.b(null, new AnonymousClass1(oVar, u1Var, null), 1, null);
                }
            });
        } catch (RejectedExecutionException e10) {
            oVar.u(new IllegalStateException("Unable to acquire a thread to perform the database transaction.", e10));
        }
        Object objZ = oVar.z();
        if (objZ == kotlin.coroutines.intrinsics.b.c()) {
            kotlin.coroutines.jvm.internal.h.c(fVar);
        }
        return objZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object createTransactionContext(RoomDatabase roomDatabase, v8.f<? super v8.j> fVar) {
        AnonymousClass1 anonymousClass1;
        RoomDatabase roomDatabase2;
        kotlinx.coroutines.z zVar;
        if (fVar instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) fVar;
            int i10 = anonymousClass1.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i10 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(fVar);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(fVar);
        }
        Object obj = anonymousClass1.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            r.b(obj);
            kotlinx.coroutines.z zVarB = a2.b(null, 1, null);
            u1 u1Var = (u1) anonymousClass1.getContext().get(u1.INSTANCE);
            if (u1Var != null) {
                u1Var.x(new AnonymousClass2(zVarB));
            }
            Executor transactionExecutor = roomDatabase.getTransactionExecutor();
            anonymousClass1.L$0 = roomDatabase;
            anonymousClass1.L$1 = zVarB;
            anonymousClass1.label = 1;
            Object objAcquireTransactionThread = acquireTransactionThread(transactionExecutor, zVarB, anonymousClass1);
            if (objAcquireTransactionThread == objC) {
                return objC;
            }
            roomDatabase2 = roomDatabase;
            zVar = zVarB;
            obj = objAcquireTransactionThread;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            zVar = (kotlinx.coroutines.z) anonymousClass1.L$1;
            roomDatabase2 = (RoomDatabase) anonymousClass1.L$0;
            r.b(obj);
        }
        v8.g gVar = (v8.g) obj;
        TransactionElement transactionElement = new TransactionElement(zVar, gVar);
        return gVar.plus(transactionElement).plus(s2.a(roomDatabase2.getSuspendingTransactionId(), kotlin.coroutines.jvm.internal.b.b(System.identityHashCode(zVar))));
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0063, code lost:
    
        if (r7 == r1) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <R> Object withTransaction(RoomDatabase roomDatabase, c9.l<? super v8.f<? super R>, ? extends Object> lVar, v8.f<? super R> fVar) {
        C05741 c05741;
        Object objG;
        if (fVar instanceof C05741) {
            c05741 = (C05741) fVar;
            int i10 = c05741.label;
            if ((i10 & Integer.MIN_VALUE) != 0) {
                c05741.label = i10 - Integer.MIN_VALUE;
            } else {
                c05741 = new C05741(fVar);
            }
        } else {
            c05741 = new C05741(fVar);
        }
        Object objCreateTransactionContext = c05741.result;
        Object objC = kotlin.coroutines.intrinsics.b.c();
        int i11 = c05741.label;
        if (i11 == 0) {
            r.b(objCreateTransactionContext);
            TransactionElement transactionElement = (TransactionElement) c05741.getContext().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                c05741.L$0 = roomDatabase;
                c05741.L$1 = lVar;
                c05741.label = 1;
                objCreateTransactionContext = createTransactionContext(roomDatabase, c05741);
            } else {
                C05752 c05752 = new C05752(roomDatabase, lVar, null);
                c05741.L$0 = null;
                c05741.L$1 = null;
                c05741.label = 2;
                objG = kotlinx.coroutines.h.g(transactionDispatcher, c05752, c05741);
                if (objG != objC) {
                    return objG;
                }
            }
            return objC;
        }
        if (i11 != 1) {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            r.b(objCreateTransactionContext);
            return objCreateTransactionContext;
        }
        lVar = (c9.l) c05741.L$1;
        roomDatabase = (RoomDatabase) c05741.L$0;
        r.b(objCreateTransactionContext);
        v8.j transactionDispatcher = (v8.j) objCreateTransactionContext;
        C05752 c05753 = new C05752(roomDatabase, lVar, null);
        c05741.L$0 = null;
        c05741.L$1 = null;
        c05741.label = 2;
        objG = kotlinx.coroutines.h.g(transactionDispatcher, c05753, c05741);
        if (objG != objC) {
            return objC;
        }
        return objG;
    }
}
