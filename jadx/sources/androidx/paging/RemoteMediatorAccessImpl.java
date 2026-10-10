package androidx.paging;

import c9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.b;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.flow.d0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import r8.n;
import r8.r;
import r8.z;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 '*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u0001'B#\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0018\u001a\u00020\u0017H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010 R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010!R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl;", "", "Key", "Value", "Landroidx/paging/RemoteMediatorAccessor;", "Lkotlinx/coroutines/l0;", "scope", "Landroidx/paging/RemoteMediator;", "remoteMediator", "<init>", "(Lkotlinx/coroutines/l0;Landroidx/paging/RemoteMediator;)V", "Lr8/z;", "launchRefresh", "()V", "launchBoundary", "Landroidx/paging/LoadType;", "loadType", "Landroidx/paging/PagingState;", "pagingState", "requestLoad", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "retryFailed", "(Landroidx/paging/PagingState;)V", "Landroidx/paging/RemoteMediator$InitializeAction;", "initialize", "(Lv8/f;)Ljava/lang/Object;", "Landroidx/paging/AccessorStateHolder;", "accessorState", "Landroidx/paging/AccessorStateHolder;", "Landroidx/paging/SingleRunner;", "isolationRunner", "Landroidx/paging/SingleRunner;", "Lkotlinx/coroutines/l0;", "Landroidx/paging/RemoteMediator;", "Lkotlinx/coroutines/flow/d0;", "Landroidx/paging/LoadStates;", "getState", "()Lkotlinx/coroutines/flow/d0;", "state", "Companion", "paging-common"}, k = 1, mv = {1, 4, 1})
final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {
    private static final int PRIORITY_APPEND_PREPEND = 1;
    private static final int PRIORITY_REFRESH = 2;
    private final AccessorStateHolder<Key, Value> accessorState;
    private final SingleRunner isolationRunner;
    private final RemoteMediator<Key, Value> remoteMediator;
    private final l0 scope;

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.RemoteMediatorAccessImpl", f = "RemoteMediatorAccessor.kt", l = {358}, m = "initialize")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Lv8/f;", "Landroidx/paging/RemoteMediator$InitializeAction;", "continuation", "initialize", "(Lv8/f;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(v8.f fVar) {
            super(fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteMediatorAccessImpl.this.initialize(this);
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1", f = "RemoteMediatorAccessor.kt", l = {301}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05621 extends l implements p<l0, v8.f<? super z>, Object> {
        int label;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1", f = "RemoteMediatorAccessor.kt", l = {306}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00201 extends l implements c9.l<v8.f<? super z>, Object> {
            Object L$0;
            int label;

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0018\u00010\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState;", "it", "Lr8/p;", "Landroidx/paging/LoadType;", "Landroidx/paging/PagingState;", "invoke", "(Landroidx/paging/AccessorState;)Lr8/p;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
            static final class C00211 extends o implements c9.l<AccessorState<Key, Value>, r8.p<? extends LoadType, ? extends PagingState<Key, Value>>> {
                public static final C00211 INSTANCE = new C00211();

                C00211() {
                    super(1);
                }

                @Override // c9.l
                public final r8.p<LoadType, PagingState<Key, Value>> invoke(AccessorState<Key, Value> it) {
                    m.f(it, "it");
                    return it.getPendingBoundary();
                }
            }

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState;", "it", "Lr8/z;", "invoke", "(Landroidx/paging/AccessorState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
            static final class AnonymousClass2 extends o implements c9.l<AccessorState<Key, Value>, z> {
                final /* synthetic */ RemoteMediator.MediatorResult $loadResult;
                final /* synthetic */ LoadType $loadType;

                @Override // c9.l
                public /* bridge */ /* synthetic */ z invoke(Object obj) {
                    invoke((AccessorState) obj);
                    return z.f17874a;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(LoadType loadType, RemoteMediator.MediatorResult mediatorResult) {
                    super(1);
                    this.$loadType = loadType;
                    this.$loadResult = mediatorResult;
                }

                public final void invoke(AccessorState<Key, Value> it) {
                    m.f(it, "it");
                    it.clearPendingRequest(this.$loadType);
                    if (((RemoteMediator.MediatorResult.Success) this.$loadResult).getEndOfPaginationReached()) {
                        it.setBlockState(this.$loadType, AccessorState.BlockState.COMPLETED);
                    }
                }
            }

            /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState;", "it", "Lr8/z;", "invoke", "(Landroidx/paging/AccessorState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
            static final class AnonymousClass3 extends o implements c9.l<AccessorState<Key, Value>, z> {
                final /* synthetic */ RemoteMediator.MediatorResult $loadResult;
                final /* synthetic */ LoadType $loadType;

                @Override // c9.l
                public /* bridge */ /* synthetic */ z invoke(Object obj) {
                    invoke((AccessorState) obj);
                    return z.f17874a;
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass3(LoadType loadType, RemoteMediator.MediatorResult mediatorResult) {
                    super(1);
                    this.$loadType = loadType;
                    this.$loadResult = mediatorResult;
                }

                public final void invoke(AccessorState<Key, Value> it) {
                    m.f(it, "it");
                    it.clearPendingRequest(this.$loadType);
                    it.setError(this.$loadType, new LoadState.Error(((RemoteMediator.MediatorResult.Error) this.$loadResult).getThrowable()));
                }
            }

            C00201(v8.f fVar) {
                super(1, fVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(v8.f<?> completion) {
                m.f(completion, "completion");
                return C05621.this.new C00201(completion);
            }

            @Override // c9.l
            public final Object invoke(v8.f<? super z> fVar) {
                return ((C00201) create(fVar)).invokeSuspend(z.f17874a);
            }

            /* JADX WARN: Code duplicated, block: B:11:0x0030  */
            /* JADX WARN: Code duplicated, block: B:13:0x004e A[RETURN] */
            /* JADX WARN: Code duplicated, block: B:16:0x0055  */
            /* JADX WARN: Code duplicated, block: B:17:0x0066  */
            /* JADX WARN: Code duplicated, block: B:19:0x006a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x004c -> B:14:0x004f). Please report as a decompilation issue!!! */
            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:16:0x0055
                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                */
            @Override // kotlin.coroutines.jvm.internal.a
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.b.c()
                    int r1 = r5.label
                    r2 = 1
                    if (r1 == 0) goto L1b
                    if (r1 != r2) goto L13
                    java.lang.Object r1 = r5.L$0
                    androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                    r8.r.b(r6)
                    goto L4f
                L13:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1b:
                    r8.r.b(r6)
                L1e:
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r6 = androidx.paging.RemoteMediatorAccessImpl.C05621.this
                    androidx.paging.RemoteMediatorAccessImpl r6 = androidx.paging.RemoteMediatorAccessImpl.this
                    androidx.paging.AccessorStateHolder r6 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r6)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$1 r1 = androidx.paging.RemoteMediatorAccessImpl.C05621.C00201.C00211.INSTANCE
                    java.lang.Object r6 = r6.use(r1)
                    r8.p r6 = (r8.p) r6
                    if (r6 == 0) goto L7b
                    java.lang.Object r1 = r6.a()
                    androidx.paging.LoadType r1 = (androidx.paging.LoadType) r1
                    java.lang.Object r6 = r6.b()
                    androidx.paging.PagingState r6 = (androidx.paging.PagingState) r6
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r3 = androidx.paging.RemoteMediatorAccessImpl.C05621.this
                    androidx.paging.RemoteMediatorAccessImpl r3 = androidx.paging.RemoteMediatorAccessImpl.this
                    androidx.paging.RemoteMediator r3 = androidx.paging.RemoteMediatorAccessImpl.access$getRemoteMediator$p(r3)
                    r5.L$0 = r1
                    r5.label = r2
                    java.lang.Object r6 = r3.load(r1, r6, r5)
                    if (r6 != r0) goto L4f
                    return r0
                L4f:
                    androidx.paging.RemoteMediator$MediatorResult r6 = (androidx.paging.RemoteMediator.MediatorResult) r6
                    boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Success
                    if (r3 == 0) goto L66
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r3 = androidx.paging.RemoteMediatorAccessImpl.C05621.this
                    androidx.paging.RemoteMediatorAccessImpl r3 = androidx.paging.RemoteMediatorAccessImpl.this
                    androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r3)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$2
                    r4.<init>(r1, r6)
                    r3.use(r4)
                    goto L1e
                L66:
                    boolean r3 = r6 instanceof androidx.paging.RemoteMediator.MediatorResult.Error
                    if (r3 == 0) goto L1e
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1 r3 = androidx.paging.RemoteMediatorAccessImpl.C05621.this
                    androidx.paging.RemoteMediatorAccessImpl r3 = androidx.paging.RemoteMediatorAccessImpl.this
                    androidx.paging.AccessorStateHolder r3 = androidx.paging.RemoteMediatorAccessImpl.access$getAccessorState$p(r3)
                    androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3 r4 = new androidx.paging.RemoteMediatorAccessImpl$launchBoundary$1$1$3
                    r4.<init>(r1, r6)
                    r3.use(r4)
                    goto L1e
                L7b:
                    r8.z r6 = r8.z.f17874a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.paging.RemoteMediatorAccessImpl.C05621.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        C05621(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new C05621(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05621) create(l0Var, fVar)).invokeSuspend(z.f17874a);
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
                SingleRunner singleRunner = RemoteMediatorAccessImpl.this.isolationRunner;
                C00201 c00201 = new C00201(null);
                this.label = 1;
                if (singleRunner.runInIsolation(1, c00201, this) == objC) {
                    return objC;
                }
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @f(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1", f = "RemoteMediatorAccessor.kt", l = {IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Key", "Value", "Lkotlinx/coroutines/l0;", "Lr8/z;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05631 extends l implements p<l0, v8.f<? super z>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
        @f(c = "androidx.paging.RemoteMediatorAccessImpl$launchRefresh$1$1", f = "RemoteMediatorAccessor.kt", l = {249}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Key", "Value", "Lr8/z;", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
        static final class C00221 extends l implements c9.l<v8.f<? super z>, Object> {
            final /* synthetic */ y $launchAppendPrepend;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00221(y yVar, v8.f fVar) {
                super(1, fVar);
                this.$launchAppendPrepend = yVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final v8.f<z> create(v8.f<?> completion) {
                m.f(completion, "completion");
                return C05631.this.new C00221(this.$launchAppendPrepend, completion);
            }

            @Override // c9.l
            public final Object invoke(v8.f<? super z> fVar) {
                return ((C00221) create(fVar)).invokeSuspend(z.f17874a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            public final Object invokeSuspend(Object obj) {
                boolean zBooleanValue;
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
                    PagingState<Key, Value> pagingState = (PagingState) RemoteMediatorAccessImpl.this.accessorState.use(RemoteMediatorAccessImpl$launchRefresh$1$1$pendingPagingState$1.INSTANCE);
                    if (pagingState != null) {
                        RemoteMediator remoteMediator = RemoteMediatorAccessImpl.this.remoteMediator;
                        LoadType loadType = LoadType.REFRESH;
                        this.label = 1;
                        obj = remoteMediator.load(loadType, pagingState, this);
                        if (obj == objC) {
                            return objC;
                        }
                    }
                    return z.f17874a;
                }
                RemoteMediator.MediatorResult mediatorResult = (RemoteMediator.MediatorResult) obj;
                y yVar = this.$launchAppendPrepend;
                if (mediatorResult instanceof RemoteMediator.MediatorResult.Success) {
                    RemoteMediatorAccessImpl.this.accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$1(mediatorResult));
                    zBooleanValue = false;
                } else if (mediatorResult instanceof RemoteMediator.MediatorResult.Error) {
                    zBooleanValue = ((Boolean) RemoteMediatorAccessImpl.this.accessorState.use(new RemoteMediatorAccessImpl$launchRefresh$1$1$1$2(mediatorResult))).booleanValue();
                } else {
                    throw new n();
                }
                yVar.element = zBooleanValue;
                return z.f17874a;
            }
        }

        C05631(v8.f fVar) {
            super(2, fVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final v8.f<z> create(Object obj, v8.f<?> completion) {
            m.f(completion, "completion");
            return new C05631(completion);
        }

        @Override // c9.p
        public final Object invoke(l0 l0Var, v8.f<? super z> fVar) {
            return ((C05631) create(l0Var, fVar)).invokeSuspend(z.f17874a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            y yVar;
            Object objC = b.c();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 == 1) {
                    yVar = (y) this.L$0;
                    r.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                r.b(obj);
                y yVar2 = new y();
                yVar2.element = false;
                SingleRunner singleRunner = RemoteMediatorAccessImpl.this.isolationRunner;
                C00221 c00221 = new C00221(yVar2, null);
                this.L$0 = yVar2;
                this.label = 1;
                if (singleRunner.runInIsolation(2, c00221, this) == objC) {
                    return objC;
                }
                yVar = yVar2;
            }
            if (yVar.element) {
                RemoteMediatorAccessImpl.this.launchBoundary();
            }
            return z.f17874a;
        }
    }

    /* JADX INFO: renamed from: androidx.paging.RemoteMediatorAccessImpl$retryFailed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Key", "Value", "Landroidx/paging/AccessorState;", "accessorState", "Lr8/z;", "invoke", "(Landroidx/paging/AccessorState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 1})
    static final class C05641 extends o implements c9.l<AccessorState<Key, Value>, z> {
        final /* synthetic */ List $toBeStarted;

        @Override // c9.l
        public /* bridge */ /* synthetic */ z invoke(Object obj) {
            invoke((AccessorState) obj);
            return z.f17874a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05641(List list) {
            super(1);
            this.$toBeStarted = list;
        }

        public final void invoke(AccessorState<Key, Value> accessorState) {
            m.f(accessorState, "accessorState");
            LoadStates loadStatesComputeLoadStates = accessorState.computeLoadStates();
            boolean z10 = loadStatesComputeLoadStates.getRefresh() instanceof LoadState.Error;
            accessorState.clearErrors();
            if (z10) {
                List list = this.$toBeStarted;
                LoadType loadType = LoadType.REFRESH;
                list.add(loadType);
                accessorState.setBlockState(loadType, AccessorState.BlockState.UNBLOCKED);
            }
            if (loadStatesComputeLoadStates.getAppend() instanceof LoadState.Error) {
                if (!z10) {
                    this.$toBeStarted.add(LoadType.APPEND);
                }
                accessorState.clearPendingRequest(LoadType.APPEND);
            }
            if (loadStatesComputeLoadStates.getPrepend() instanceof LoadState.Error) {
                if (!z10) {
                    this.$toBeStarted.add(LoadType.PREPEND);
                }
                accessorState.clearPendingRequest(LoadType.PREPEND);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[LoadType.REFRESH.ordinal()] = 1;
        }
    }

    public RemoteMediatorAccessImpl(l0 scope, RemoteMediator<Key, Value> remoteMediator) {
        m.f(scope, "scope");
        m.f(remoteMediator, "remoteMediator");
        this.scope = scope;
        this.remoteMediator = remoteMediator;
        this.accessorState = new AccessorStateHolder<>();
        this.isolationRunner = new SingleRunner(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBoundary() {
        j.d(this.scope, null, null, new C05621(null), 3, null);
    }

    private final void launchRefresh() {
        j.d(this.scope, null, null, new C05631(null), 3, null);
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public d0<LoadStates> getState() {
        return this.accessorState.getLoadStates();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // androidx.paging.RemoteMediatorAccessor
    public Object initialize(v8.f<? super RemoteMediator.InitializeAction> fVar) {
        AnonymousClass1 anonymousClass1;
        RemoteMediatorAccessImpl<Key, Value> remoteMediatorAccessImpl;
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
        Object objInitialize = anonymousClass1.result;
        Object objC = b.c();
        int i11 = anonymousClass1.label;
        if (i11 == 0) {
            r.b(objInitialize);
            RemoteMediator<Key, Value> remoteMediator = this.remoteMediator;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objInitialize = remoteMediator.initialize(anonymousClass1);
            if (objInitialize == objC) {
                return objC;
            }
            remoteMediatorAccessImpl = this;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            remoteMediatorAccessImpl = (RemoteMediatorAccessImpl) anonymousClass1.L$0;
            r.b(objInitialize);
        }
        if (((RemoteMediator.InitializeAction) objInitialize) == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
            remoteMediatorAccessImpl.accessorState.use(RemoteMediatorAccessImpl$initialize$2$1.INSTANCE);
        }
        return objInitialize;
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestLoad(LoadType loadType, PagingState<Key, Value> pagingState) {
        m.f(loadType, "loadType");
        m.f(pagingState, "pagingState");
        if (((Boolean) this.accessorState.use(new RemoteMediatorAccessImpl$requestLoad$newRequest$1(loadType, pagingState))).booleanValue()) {
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] != 1) {
                launchBoundary();
            } else {
                launchRefresh();
            }
        }
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void retryFailed(PagingState<Key, Value> pagingState) {
        m.f(pagingState, "pagingState");
        ArrayList arrayList = new ArrayList();
        this.accessorState.use(new C05641(arrayList));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            requestLoad((LoadType) it.next(), pagingState);
        }
    }
}
