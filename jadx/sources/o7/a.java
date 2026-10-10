package o7;

import android.content.Context;
import android.content.SharedPreferences;
import m7.f;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f16500a;

    public int a() {
        SharedPreferences sharedPreferences = this.f16500a;
        int i10 = sharedPreferences != null ? sharedPreferences.getInt(IjkMediaMeta.IJKM_KEY_TYPE, 0) : 0;
        f.e("PersistentConfiguration", "getTypeFromSp type", Integer.valueOf(i10));
        return i10;
    }

    public void b(String str, int i10) {
        if (this.f16500a != null) {
            f.e("PersistentConfiguration", "writeUtdidToSp utdid", str);
            SharedPreferences.Editor editorEdit = this.f16500a.edit();
            editorEdit.putString("UTDID2", str);
            editorEdit.putInt(IjkMediaMeta.IJKM_KEY_TYPE, i10);
            if (this.f16500a.getLong("t2", 0L) == 0) {
                editorEdit.putLong("t2", System.currentTimeMillis());
            }
            try {
                editorEdit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public String c() {
        SharedPreferences sharedPreferences = this.f16500a;
        String string = sharedPreferences != null ? sharedPreferences.getString("UTDID2", "") : "";
        f.e("PersistentConfiguration", "getUtdidFromSp utdid", string);
        return string;
    }

    public a(Context context, String str, String str2) {
        this.f16500a = null;
        if (context == null) {
            return;
        }
        this.f16500a = context.getSharedPreferences(str2, 0);
    }
}
