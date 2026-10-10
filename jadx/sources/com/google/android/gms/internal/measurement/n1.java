package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class n1 extends SQLiteOpenHelper {
    public n1(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(context, str, null, 1, r1.f2976a);
    }

    private n1(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10, r1 r1Var) {
        super(context, (str == null || j1.a().d(str, r1Var, p1.SQLITE_OPEN_HELPER_TYPE).equals("")) ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
    }
}
