package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m1;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003¨\u0006\u0006"}, d2 = {"Landroidx/room/RoomDatabase;", "Lkotlinx/coroutines/i0;", "getQueryDispatcher", "(Landroidx/room/RoomDatabase;)Lkotlinx/coroutines/i0;", "getTransactionDispatcher", "transactionDispatcher", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final i0 getQueryDispatcher(RoomDatabase roomDatabase) {
        kotlin.jvm.internal.m.f(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objA = backingFieldMap.get("QueryDispatcher");
        if (objA == null) {
            objA = m1.a(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", objA);
        }
        kotlin.jvm.internal.m.d(objA, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (i0) objA;
    }

    public static final i0 getTransactionDispatcher(RoomDatabase roomDatabase) {
        kotlin.jvm.internal.m.f(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objA = backingFieldMap.get("TransactionDispatcher");
        if (objA == null) {
            objA = m1.a(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", objA);
        }
        kotlin.jvm.internal.m.d(objA, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (i0) objA;
    }
}
