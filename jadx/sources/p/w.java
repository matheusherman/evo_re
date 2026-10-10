package p;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class w<Data> implements o<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<Uri, Data> f17236a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements p<String, AssetFileDescriptor> {
        @Override // p.p
        public o<String, AssetFileDescriptor> c(@NonNull s sVar) {
            return new w(sVar.d(Uri.class, AssetFileDescriptor.class));
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b implements p<String, ParcelFileDescriptor> {
        @Override // p.p
        @NonNull
        public o<String, ParcelFileDescriptor> c(@NonNull s sVar) {
            return new w(sVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c implements p<String, InputStream> {
        @Override // p.p
        @NonNull
        public o<String, InputStream> c(@NonNull s sVar) {
            return new w(sVar.d(Uri.class, InputStream.class));
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull String str) {
        return true;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    public w(o<Uri, Data> oVar) {
        this.f17236a = oVar;
    }

    @Nullable
    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        if (uri.getScheme() == null) {
            return f(str);
        }
        return uri;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(@NonNull String str, int i10, int i11, @NonNull j.i iVar) {
        Uri uriE = e(str);
        if (uriE != null && this.f17236a.a(uriE)) {
            return this.f17236a.b(uriE, i10, i11, iVar);
        }
        return null;
    }
}
