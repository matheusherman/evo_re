package org.eclipse.paho.android.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.UUID;
import ve.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SQLiteDatabase f17092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private C0328a f17093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ue.a f17094c;

    /* JADX INFO: renamed from: org.eclipse.paho.android.service.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class C0328a extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ue.a f17095a;

        public C0328a(ue.a aVar, Context context) {
            super(context, "mqttAndroidService.db", (SQLiteDatabase.CursorFactory) null, 1);
            this.f17095a = aVar;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.f17095a.b("MQTTDatabaseHelper", "onCreate {CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);}");
            try {
                sQLiteDatabase.execSQL("CREATE TABLE MqttArrivedMessageTable(messageId TEXT PRIMARY KEY, clientHandle TEXT, destinationName TEXT, payload BLOB, qos INTEGER, retained TEXT, duplicate TEXT, mtimestamp INTEGER);");
                this.f17095a.b("MQTTDatabaseHelper", "created the table");
            } catch (SQLException e10) {
                this.f17095a.c("MQTTDatabaseHelper", "onCreate", e10);
                throw e10;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
            this.f17095a.b("MQTTDatabaseHelper", "onUpgrade");
            try {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS MqttArrivedMessageTable");
                onCreate(sQLiteDatabase);
                this.f17095a.b("MQTTDatabaseHelper", "onUpgrade complete");
            } catch (SQLException e10) {
                this.f17095a.c("MQTTDatabaseHelper", "onUpgrade", e10);
                throw e10;
            }
        }
    }

    private int c(String str) {
        Cursor cursorQuery = this.f17092a.query("MqttArrivedMessageTable", new String[]{"messageId"}, "clientHandle=?", new String[]{str}, null, null, null);
        int i10 = cursorQuery.moveToFirst() ? cursorQuery.getInt(0) : 0;
        cursorQuery.close();
        return i10;
    }

    @Override // org.eclipse.paho.android.service.b
    public String a(String str, String str2, g gVar) {
        this.f17092a = this.f17093b.getWritableDatabase();
        this.f17094c.b("DatabaseMessageStore", "storeArrived{" + str + "}, {" + gVar.toString() + "}");
        byte[] bArrB = gVar.b();
        int iC = gVar.c();
        boolean zE = gVar.e();
        boolean zD = gVar.d();
        ContentValues contentValues = new ContentValues();
        String string = UUID.randomUUID().toString();
        contentValues.put("messageId", string);
        contentValues.put("clientHandle", str);
        contentValues.put("destinationName", str2);
        contentValues.put("payload", bArrB);
        contentValues.put("qos", Integer.valueOf(iC));
        contentValues.put("retained", Boolean.valueOf(zE));
        contentValues.put("duplicate", Boolean.valueOf(zD));
        contentValues.put("mtimestamp", Long.valueOf(System.currentTimeMillis()));
        try {
            this.f17092a.insertOrThrow("MqttArrivedMessageTable", null, contentValues);
            int iC2 = c(str);
            this.f17094c.b("DatabaseMessageStore", "storeArrived: inserted message with id of {" + string + "} - Number of messages in database for this clientHandle = " + iC2);
            return string;
        } catch (SQLException e10) {
            this.f17094c.c("DatabaseMessageStore", "onUpgrade", e10);
            throw e10;
        }
    }

    @Override // org.eclipse.paho.android.service.b
    public boolean b(String str, String str2) {
        this.f17092a = this.f17093b.getWritableDatabase();
        this.f17094c.b("DatabaseMessageStore", "discardArrived{" + str + "}, {" + str2 + "}");
        try {
            int iDelete = this.f17092a.delete("MqttArrivedMessageTable", "messageId=? AND clientHandle=?", new String[]{str2, str});
            if (iDelete == 1) {
                int iC = c(str);
                this.f17094c.b("DatabaseMessageStore", "discardArrived - Message deleted successfully. - messages in db for this clientHandle " + iC);
                return true;
            }
            this.f17094c.a("DatabaseMessageStore", "discardArrived - Error deleting message {" + str2 + "} from database: Rows affected = " + iDelete);
            return false;
        } catch (SQLException e10) {
            this.f17094c.c("DatabaseMessageStore", "discardArrived", e10);
            throw e10;
        }
    }

    @Override // org.eclipse.paho.android.service.b
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.f17092a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    public a(MqttService mqttService, Context context) {
        this.f17093b = null;
        this.f17094c = mqttService;
        this.f17093b = new C0328a(this.f17094c, context);
        this.f17094c.b("DatabaseMessageStore", "DatabaseMessageStore<init> complete");
    }
}
