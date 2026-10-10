package i1;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.stub.StubApp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import m1.g;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lock f11005c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private static b f11006d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Lock f11007a = new ReentrantLock();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SharedPreferences f11008b;

    private static final String d(String str, String str2) {
        return str + ":" + str2;
    }

    @Nullable
    public GoogleSignInAccount b() {
        String strC;
        String strC2 = c("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(strC2) && (strC = c(d("googleSignInAccount", strC2))) != null) {
            try {
                return GoogleSignInAccount.n0(strC);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    protected final String c(@NonNull String str) {
        this.f11007a.lock();
        try {
            return this.f11008b.getString(str, null);
        } finally {
            this.f11007a.unlock();
        }
    }

    @VisibleForTesting
    b(Context context) {
        this.f11008b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @NonNull
    public static b a(@NonNull Context context) {
        g.k(context);
        f11005c.lock();
        try {
            if (f11006d == null) {
                f11006d = new b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return f11006d;
        } finally {
            f11005c.unlock();
        }
    }
}
