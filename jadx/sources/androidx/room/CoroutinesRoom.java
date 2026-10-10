package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlinx.coroutines.n1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u000fJG\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "", "<init>", "()V", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "Ljava/util/concurrent/Callable;", "callable", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lv8/f;)Ljava/lang/Object;", "Landroid/os/CancellationSignal;", "cancellationSignal", "(Landroidx/room/RoomDatabase;ZLandroid/os/CancellationSignal;Ljava/util/concurrent/Callable;Lv8/f;)Ljava/lang/Object;", "", "", "tableNames", "Lkotlinx/coroutines/flow/f;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/f;", "room-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z10, Callable<R> callable, v8.f<? super R> fVar) {
            v8.g transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) fVar.getContext().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = z10 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return kotlinx.coroutines.h.g(transactionDispatcher, new CoroutinesRoom$Companion$execute$2(callable, null), fVar);
        }

        private Companion() {
        }

        public final <R> kotlinx.coroutines.flow.f<R> createFlow(RoomDatabase db2, boolean inTransaction, String[] tableNames, Callable<R> callable) {
            kotlin.jvm.internal.m.f(db2, "db");
            kotlin.jvm.internal.m.f(tableNames, "tableNames");
            kotlin.jvm.internal.m.f(callable, "callable");
            return kotlinx.coroutines.flow.h.v(new CoroutinesRoom$Companion$createFlow$1(inTransaction, db2, tableNames, callable, null));
        }

        public final <R> Object execute(RoomDatabase roomDatabase, boolean z10, CancellationSignal cancellationSignal, Callable<R> callable, v8.f<? super R> fVar) {
            v8.g transactionDispatcher;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) fVar.getContext().get(TransactionElement.INSTANCE);
            if (transactionElement == null || (transactionDispatcher = transactionElement.getTransactionDispatcher()) == null) {
                transactionDispatcher = z10 ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            v8.g gVar = transactionDispatcher;
            kotlinx.coroutines.o oVar = new kotlinx.coroutines.o(kotlin.coroutines.intrinsics.b.b(fVar), 1);
            oVar.D();
            oVar.h(new CoroutinesRoom$Companion$execute$4$1(cancellationSignal, kotlinx.coroutines.j.d(n1.f14892a, gVar, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, oVar, null), 2, null)));
            Object objZ = oVar.z();
            if (objZ == kotlin.coroutines.intrinsics.b.c()) {
                kotlin.coroutines.jvm.internal.h.c(fVar);
            }
            return objZ;
        }
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z10, CancellationSignal cancellationSignal, Callable<R> callable, v8.f<? super R> fVar) {
        return INSTANCE.execute(roomDatabase, z10, cancellationSignal, callable, fVar);
    }

    public static final <R> kotlinx.coroutines.flow.f<R> createFlow(RoomDatabase roomDatabase, boolean z10, String[] strArr, Callable<R> callable) {
        return INSTANCE.createFlow(roomDatabase, z10, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z10, Callable<R> callable, v8.f<? super R> fVar) {
        return INSTANCE.execute(roomDatabase, z10, callable, fVar);
    }

    private CoroutinesRoom() {
    }
}
