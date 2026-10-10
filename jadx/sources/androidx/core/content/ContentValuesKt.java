package androidx.core.content;

import android.content.ContentValues;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0006\u001a\u00020\u00052.\u0010\u0004\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000\"\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"", "Lr8/p;", "", "", "pairs", "Landroid/content/ContentValues;", "contentValuesOf", "([Lr8/p;)Landroid/content/ContentValues;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ContentValuesKt {
    public static final ContentValues contentValuesOf(r8.p<String, ? extends Object>... pVarArr) {
        ContentValues contentValues = new ContentValues(pVarArr.length);
        for (r8.p<String, ? extends Object> pVar : pVarArr) {
            String strA = pVar.a();
            Object objB = pVar.b();
            if (objB == null) {
                contentValues.putNull(strA);
            } else if (objB instanceof String) {
                contentValues.put(strA, (String) objB);
            } else if (objB instanceof Integer) {
                contentValues.put(strA, (Integer) objB);
            } else if (objB instanceof Long) {
                contentValues.put(strA, (Long) objB);
            } else if (objB instanceof Boolean) {
                contentValues.put(strA, (Boolean) objB);
            } else if (objB instanceof Float) {
                contentValues.put(strA, (Float) objB);
            } else if (objB instanceof Double) {
                contentValues.put(strA, (Double) objB);
            } else if (objB instanceof byte[]) {
                contentValues.put(strA, (byte[]) objB);
            } else if (objB instanceof Byte) {
                contentValues.put(strA, (Byte) objB);
            } else {
                if (!(objB instanceof Short)) {
                    throw new IllegalArgumentException("Illegal value type " + objB.getClass().getCanonicalName() + " for key \"" + strA + '\"');
                }
                contentValues.put(strA, (Short) objB);
            }
        }
        return contentValues;
    }
}
