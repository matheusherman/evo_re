package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import c9.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import r8.z;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "startVersion", "endVersion", "Lkotlin/Function1;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "Lr8/z;", "migrate", "Landroidx/room/migration/Migration;", "Migration", "(IILc9/l;)Landroidx/room/migration/Migration;", "room-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MigrationKt {
    public static final Migration Migration(int i10, int i11, l<? super SupportSQLiteDatabase, z> migrate) {
        m.f(migrate, "migrate");
        return new MigrationImpl(i10, i11, migrate);
    }
}
