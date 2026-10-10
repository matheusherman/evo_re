package i;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.d;
import e0.c;
import e0.k;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import okhttp3.f;
import p.h;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class a implements d<InputStream>, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a f10995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f10996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f10997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private e0 f10998d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d.a<? super InputStream> f10999e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile e f11000f;

    @Override // okhttp3.f
    public void onFailure(@NonNull e eVar, @NonNull IOException iOException) {
        if (Log.isLoggable("OkHttpFetcher", 3)) {
            Log.d("OkHttpFetcher", "OkHttp failed to obtain result", iOException);
        }
        this.f10999e.c(iOException);
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        try {
            InputStream inputStream = this.f10997c;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException unused) {
        }
        e0 e0Var = this.f10998d;
        if (e0Var != null) {
            e0Var.close();
        }
        this.f10999e = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        e eVar = this.f11000f;
        if (eVar != null) {
            eVar.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super InputStream> aVar) {
        b0.a aVarK = new b0.a().k(this.f10996b.h());
        for (Map.Entry<String, String> entry : this.f10996b.e().entrySet()) {
            aVarK.a(entry.getKey(), entry.getValue());
        }
        b0 b0VarB = aVarK.b();
        this.f10999e = aVar;
        this.f11000f = this.f10995a.a(b0VarB);
        this.f11000f.J(this);
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public j.a getDataSource() {
        return j.a.REMOTE;
    }

    public a(e.a aVar, h hVar) {
        this.f10995a = aVar;
        this.f10996b = hVar;
    }

    @Override // okhttp3.f
    public void onResponse(@NonNull e eVar, @NonNull d0 d0Var) {
        this.f10998d = d0Var.getBody();
        if (d0Var.n()) {
            InputStream inputStreamB = c.b(this.f10998d.a(), ((e0) k.d(this.f10998d)).getContentLength());
            this.f10997c = inputStreamB;
            this.f10999e.e(inputStreamB);
            return;
        }
        this.f10999e.c(new j.e(d0Var.getMessage(), d0Var.getCode()));
    }
}
