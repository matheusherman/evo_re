package p;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stub.StubApp;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class u<DataT> implements o<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o<Integer, DataT> f17232b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class a implements p<Uri, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17233a;

        @Override // p.p
        @NonNull
        public o<Uri, AssetFileDescriptor> c(@NonNull s sVar) {
            return new u(this.f17233a, sVar.d(Integer.class, AssetFileDescriptor.class));
        }

        a(Context context) {
            this.f17233a = context;
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class b implements p<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17234a;

        @Override // p.p
        @NonNull
        public o<Uri, InputStream> c(@NonNull s sVar) {
            return new u(this.f17234a, sVar.d(Integer.class, InputStream.class));
        }

        b(Context context) {
            this.f17234a = context;
        }

        @Override // p.p
        public void d() {
        }
    }

    public static p<Uri, AssetFileDescriptor> e(Context context) {
        return new a(context);
    }

    public static p<Uri, InputStream> f(Context context) {
        return new b(context);
    }

    @Nullable
    private o.a<DataT> g(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        try {
            int i12 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i12 != 0) {
                return this.f17232b.b(Integer.valueOf(i12), i10, i11, iVar);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e10) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e10);
            }
            return null;
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f17231a.getPackageName().equals(uri.getAuthority());
    }

    u(Context context, o<Integer, DataT> oVar) {
        this.f17231a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f17232b = oVar;
    }

    @Nullable
    private o.a<DataT> h(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f17231a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f17231a.getPackageName());
        if (identifier == 0) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
                return null;
            }
            return null;
        }
        return this.f17232b.b(Integer.valueOf(identifier), i10, i11, iVar);
    }

    @Override // p.o
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i10, i11, iVar);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i10, i11, iVar);
        }
        if (Log.isLoggable("ResourceUriLoader", 5)) {
            Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
            return null;
        }
        return null;
    }
}
