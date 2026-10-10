package w;

import android.util.Log;
import androidx.annotation.NonNull;
import j.l;
import java.io.File;
import java.io.IOException;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d implements l<c> {
    @Override // j.l
    @NonNull
    public j.c b(@NonNull j.i iVar) {
        return j.c.SOURCE;
    }

    @Override // j.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull v<c> vVar, @NonNull File file, @NonNull j.i iVar) throws Throwable {
        try {
            e0.a.f(vVar.get().c(), file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
                return false;
            }
            return false;
        }
    }
}
