package p;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class l implements o<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17190a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class a implements p<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17191a;

        @Override // p.p
        @NonNull
        public o<Uri, File> c(s sVar) {
            return new l(this.f17191a);
        }

        public a(Context context) {
            this.f17191a = context;
        }

        @Override // p.p
        public void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b implements com.bumptech.glide.load.data.d<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f17192c = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f17194b;

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull com.bumptech.glide.h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super File> aVar) {
            Cursor cursorQuery = this.f17193a.getContentResolver().query(this.f17194b, f17192c, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.e(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f17194b));
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        b(Context context, Uri uri) {
            this.f17193a = context;
            this.f17194b = uri;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<File> b(@NonNull Uri uri, int i10, int i11, @NonNull j.i iVar) {
        return new o.a<>(new d0.d(uri), new b(this.f17190a, uri));
    }

    public l(Context context) {
        this.f17190a = context;
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return k.b.b(uri);
    }
}
