package p;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class t<Data> implements o<Integer, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<Uri, Data> f17226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f17227b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements p<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f17228a;

        @Override // p.p
        public o<Integer, AssetFileDescriptor> c(s sVar) {
            return new t(this.f17228a, sVar.d(Uri.class, AssetFileDescriptor.class));
        }

        public a(Resources resources) {
            this.f17228a = resources;
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class b implements p<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f17229a;

        @Override // p.p
        @NonNull
        public o<Integer, InputStream> c(s sVar) {
            return new t(this.f17229a, sVar.d(Uri.class, InputStream.class));
        }

        public b(Resources resources) {
            this.f17229a = resources;
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c implements p<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f17230a;

        @Override // p.p
        @NonNull
        public o<Integer, Uri> c(s sVar) {
            return new t(this.f17230a, x.c());
        }

        public c(Resources resources) {
            this.f17230a = resources;
        }

        @Override // p.p
        public void d() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Integer num) {
        return true;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f17227b.getResourcePackageName(num.intValue()) + '/' + this.f17227b.getResourceTypeName(num.intValue()) + '/' + this.f17227b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
            return null;
        }
    }

    public t(Resources resources, o<Uri, Data> oVar) {
        this.f17227b = resources;
        this.f17226a = oVar;
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<Data> b(@NonNull Integer num, int i10, int i11, @NonNull j.i iVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f17226a.b(uriD, i10, i11, iVar);
    }
}
