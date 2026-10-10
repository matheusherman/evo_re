package ye;

import android.util.Log;
import java.util.logging.Level;
import xe.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22582a;

    @Override // xe.g
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(c(level), this.f22582a, str);
        }
    }

    @Override // xe.g
    public void b(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Log.println(c(level), this.f22582a, str + "\n" + Log.getStackTraceString(th));
        }
    }

    public c(String str) {
        this.f22582a = str;
    }

    private int c(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            if (iIntValue < 500) {
                return 2;
            }
            return 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        if (iIntValue < 1000) {
            return 5;
        }
        return 6;
    }
}
