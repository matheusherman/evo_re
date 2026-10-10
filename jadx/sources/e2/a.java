package e2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends IllegalStateException {
    private a(String str, @Nullable Throwable th) {
        super(str, th);
    }

    @NonNull
    public static IllegalStateException a(@NonNull g<?> gVar) {
        String strConcat;
        if (!gVar.j()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excG = gVar.g();
        if (excG != null) {
            strConcat = "failure";
        } else if (gVar.k()) {
            strConcat = "result ".concat(String.valueOf(gVar.h()));
        } else if (gVar.i()) {
            strConcat = "cancellation";
        } else {
            strConcat = "unknown issue";
        }
        return new a("Complete with: ".concat(strConcat), excG);
    }
}
