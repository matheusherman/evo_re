package ye;

import android.os.Looper;
import xe.f;
import xe.h;
import xe.l;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class d implements h {
    @Override // xe.h
    public l a(xe.c cVar) {
        return new f(cVar, Looper.getMainLooper(), 10);
    }

    @Override // xe.h
    public boolean b() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
