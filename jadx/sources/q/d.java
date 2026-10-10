package q;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.h;
import com.stub.StubApp;
import j.i;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import p.o;
import p.p;
import p.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@RequiresApi(29)
public final class d<DataT> implements o<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f17597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o<File, DataT> f17598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o<Uri, DataT> f17599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<DataT> f17600d;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static abstract class a<DataT> implements p<Uri, DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<DataT> f17602b;

        @Override // p.p
        @NonNull
        public final o<Uri, DataT> c(@NonNull s sVar) {
            return new d(this.f17601a, sVar.d(File.class, this.f17602b), sVar.d(Uri.class, this.f17602b), this.f17602b);
        }

        a(Context context, Class<DataT> cls) {
            this.f17601a = context;
            this.f17602b = cls;
        }

        @Override // p.p
        public final void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(29)
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @RequiresApi(29)
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: renamed from: q.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class C0337d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final String[] f17603k = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f17604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o<File, DataT> f17605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final o<Uri, DataT> f17606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f17607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f17608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f17609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final i f17610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Class<DataT> f17611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private volatile boolean f17612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        private volatile com.bumptech.glide.load.data.d<DataT> f17613j;

        @NonNull
        private File g(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = this.f17604a.getContentResolver().query(uri, f17603k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursorQuery.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (0 == 0) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.f17612i = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f17613j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        private boolean f() {
            return this.f17604a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public Class<DataT> a() {
            return this.f17611h;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f17613j;
            if (dVar != null) {
                dVar.b();
            }
        }

        @Override // com.bumptech.glide.load.data.d
        @NonNull
        public j.a getDataSource() {
            return j.a.LOCAL;
        }

        C0337d(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Uri uri, int i10, int i11, i iVar, Class<DataT> cls) {
            this.f17604a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f17605b = oVar;
            this.f17606c = oVar2;
            this.f17607d = uri;
            this.f17608e = i10;
            this.f17609f = i11;
            this.f17610g = iVar;
            this.f17611h = cls;
        }

        @Nullable
        private o.a<DataT> c() {
            Uri requireOriginal;
            if (Environment.isExternalStorageLegacy()) {
                return this.f17605b.b(g(this.f17607d), this.f17608e, this.f17609f, this.f17610g);
            }
            if (f()) {
                requireOriginal = MediaStore.setRequireOriginal(this.f17607d);
            } else {
                requireOriginal = this.f17607d;
            }
            return this.f17606c.b(requireOriginal, this.f17608e, this.f17609f, this.f17610g);
        }

        @Nullable
        private com.bumptech.glide.load.data.d<DataT> e() {
            o.a<DataT> aVarC = c();
            if (aVarC != null) {
                return aVarC.f17203c;
            }
            return null;
        }

        @Override // com.bumptech.glide.load.data.d
        public void d(@NonNull h hVar, @NonNull com.bumptech.glide.load.data.d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> dVarE = e();
                if (dVarE == null) {
                    aVar.c(new IllegalArgumentException("Failed to build fetcher for: " + this.f17607d));
                    return;
                }
                this.f17613j = dVarE;
                if (this.f17612i) {
                    cancel();
                } else {
                    dVarE.d(hVar, aVar);
                }
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }
    }

    @Override // p.o
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o.a<DataT> b(@NonNull Uri uri, int i10, int i11, @NonNull i iVar) {
        return new o.a<>(new d0.d(uri), new C0337d(this.f17597a, this.f17598b, this.f17599c, uri, i10, i11, iVar, this.f17600d));
    }

    @Override // p.o
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && k.b.b(uri);
    }

    d(Context context, o<File, DataT> oVar, o<Uri, DataT> oVar2, Class<DataT> cls) {
        this.f17597a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f17598b = oVar;
        this.f17599c = oVar2;
        this.f17600d = cls;
    }
}
