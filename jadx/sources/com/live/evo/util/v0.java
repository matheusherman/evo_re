package com.live.evo.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.core.app.NotificationCompat;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f7369a = {"phone", "secondary_phone", "tertiary_phone"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f7370b = {"phone_type", "secondary_phone_type", "tertiary_phone_type"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f7371c = {NotificationCompat.CATEGORY_EMAIL, "secondary_email", "tertiary_email"};

    public Bundle b(Context context, Uri uri) {
        String string;
        if (context != null && uri != null) {
            ContentResolver contentResolver = context.getContentResolver();
            try {
                Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
                if (cursorQuery == null) {
                    return null;
                }
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("_id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("display_name"));
                    int i10 = 0;
                    boolean z10 = cursorQuery.getInt(cursorQuery.getColumnIndex("has_phone_number")) > 0;
                    cursorQuery.close();
                    Bundle bundle = new Bundle();
                    if (string3 != null && !string3.isEmpty()) {
                        bundle.putString("name", a(string3));
                    }
                    if (z10) {
                        Cursor cursorQuery2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id=" + string2, null, null);
                        if (cursorQuery2 != null) {
                            try {
                                int columnIndex = cursorQuery2.getColumnIndex("data1");
                                int columnIndex2 = cursorQuery2.getColumnIndex("data2");
                                int i11 = 0;
                                while (cursorQuery2.moveToNext()) {
                                    String[] strArr = f7369a;
                                    if (i11 < strArr.length) {
                                        String string4 = cursorQuery2.getString(columnIndex);
                                        if (string4 != null && !string4.isEmpty()) {
                                            bundle.putString(strArr[i11], a(string4));
                                        }
                                        bundle.putInt(f7370b[i11], cursorQuery2.getInt(columnIndex2));
                                        i11++;
                                    }
                                }
                            } finally {
                                cursorQuery2.close();
                            }
                        }
                    }
                    Cursor cursorQuery3 = contentResolver.query(ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_URI, null, "contact_id=" + string2, null, null);
                    if (cursorQuery3 != null) {
                        try {
                            if (cursorQuery3.moveToNext() && (string = cursorQuery3.getString(cursorQuery3.getColumnIndex("data1"))) != null && !string.isEmpty()) {
                                bundle.putString("postal", a(string));
                            }
                            cursorQuery3.close();
                        } catch (Throwable th) {
                            cursorQuery3.close();
                            throw th;
                        }
                    }
                    Cursor cursorQuery4 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id=" + string2, null, null);
                    if (cursorQuery4 != null) {
                        try {
                            int columnIndex3 = cursorQuery4.getColumnIndex("data1");
                            while (cursorQuery4.moveToNext()) {
                                String[] strArr2 = f7371c;
                                if (i10 >= strArr2.length) {
                                    break;
                                }
                                String string5 = cursorQuery4.getString(columnIndex3);
                                if (string5 != null && !string5.isEmpty()) {
                                    bundle.putString(strArr2[i10], a(string5));
                                }
                                i10++;
                            }
                            cursorQuery4.close();
                        } catch (Throwable th2) {
                            cursorQuery4.close();
                            throw th2;
                        }
                    }
                    if (bundle.isEmpty()) {
                        return null;
                    }
                    return bundle;
                } catch (Throwable th3) {
                    cursorQuery.close();
                    throw th3;
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    private static String a(String str) {
        if (str.indexOf(10) >= 0) {
            str = str.replace("\n", " ");
        }
        return str.indexOf(13) >= 0 ? str.replace("\r", " ") : str;
    }
}
