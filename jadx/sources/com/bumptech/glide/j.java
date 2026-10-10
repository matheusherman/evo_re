package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.stub.StubApp;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.List;
import p.p;
import p.u;
import p.v;
import p.x;
import p.y;
import p.z;
import s.a0;
import s.c0;
import s.e0;
import s.g0;
import s.i0;
import s.k0;
import s.t;
import s.w;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class j {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements e0.f.b<i> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f1338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f1339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f1340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppGlideModule f1341d;

        a(c cVar, List list, AppGlideModule appGlideModule) {
            this.f1339b = cVar;
            this.f1340c = list;
            this.f1341d = appGlideModule;
        }

        @Override // e0.f.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i get() {
            if (this.f1338a) {
                throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
            }
            Trace.beginSection("Glide registry");
            this.f1338a = true;
            try {
                return j.a(this.f1339b, this.f1340c, this.f1341d);
            } finally {
                this.f1338a = false;
                Trace.endSection();
            }
        }
    }

    private static void b(Context context, i iVar, m.d dVar, m.b bVar, f fVar) {
        j.k hVar;
        j.k g0Var;
        i iVar2;
        iVar.o(new s.m());
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 27) {
            iVar.o(new w());
        }
        Resources resources = context.getResources();
        List<ImageHeaderParser> listG = iVar.g();
        w.a aVar = new w.a(context, listG, dVar, bVar);
        j.k<ParcelFileDescriptor, Bitmap> kVarM = k0.m(dVar);
        t tVar = new t(iVar.g(), resources.getDisplayMetrics(), dVar, bVar);
        if (i10 < 28 || !fVar.a(d.b.class)) {
            hVar = new s.h(tVar);
            g0Var = new g0(tVar, bVar);
        } else {
            g0Var = new a0();
            hVar = new s.j();
        }
        if (i10 >= 28) {
            iVar.e("Animation", InputStream.class, Drawable.class, u.g.f(listG, bVar));
            iVar.e("Animation", ByteBuffer.class, Drawable.class, u.g.a(listG, bVar));
        }
        u.k kVar = new u.k(context);
        s.c cVar = new s.c(bVar);
        x.a aVar2 = new x.a();
        x.d dVar2 = new x.d();
        ContentResolver contentResolver = context.getContentResolver();
        iVar.a(ByteBuffer.class, new p.c()).a(InputStream.class, new v(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, hVar).e("Bitmap", InputStream.class, Bitmap.class, g0Var);
        if (ParcelFileDescriptorRewinder.c()) {
            iVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new c0(tVar));
        }
        iVar.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, kVarM).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, k0.c(dVar)).d(Bitmap.class, Bitmap.class, x.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new i0()).b(Bitmap.class, cVar).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new s.a(resources, hVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new s.a(resources, g0Var)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new s.a(resources, kVarM)).b(BitmapDrawable.class, new s.b(dVar, cVar)).e("Animation", InputStream.class, w.c.class, new w.j(listG, aVar, bVar)).e("Animation", ByteBuffer.class, w.c.class, aVar).b(w.c.class, new w.d()).d(h.a.class, h.a.class, x.a.a()).e("Bitmap", h.a.class, Bitmap.class, new w.h(dVar)).c(Uri.class, Drawable.class, kVar).c(Uri.class, Bitmap.class, new e0(kVar, dVar)).p(new t.a.C0363a()).d(File.class, ByteBuffer.class, new p.d.b()).d(File.class, InputStream.class, new p.g.e()).c(File.class, File.class, new v.a()).d(File.class, ParcelFileDescriptor.class, new p.g.b()).d(File.class, File.class, x.a.a()).p(new com.bumptech.glide.load.data.k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            iVar2 = iVar;
            iVar2.p(new ParcelFileDescriptorRewinder.a());
        } else {
            iVar2 = iVar;
        }
        p<Integer, InputStream> pVarG = p.f.g(context);
        p<Integer, AssetFileDescriptor> pVarC = p.f.c(context);
        p<Integer, Drawable> pVarE = p.f.e(context);
        Class cls = Integer.TYPE;
        iVar2.d(cls, InputStream.class, pVarG).d(Integer.class, InputStream.class, pVarG).d(cls, AssetFileDescriptor.class, pVarC).d(Integer.class, AssetFileDescriptor.class, pVarC).d(cls, Drawable.class, pVarE).d(Integer.class, Drawable.class, pVarE).d(Uri.class, InputStream.class, u.f(context)).d(Uri.class, AssetFileDescriptor.class, u.e(context));
        p.t.c cVar2 = new p.t.c(resources);
        p.t.a aVar3 = new p.t.a(resources);
        p.t.b bVar2 = new p.t.b(resources);
        iVar2.d(Integer.class, Uri.class, cVar2).d(cls, Uri.class, cVar2).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, InputStream.class, bVar2).d(cls, InputStream.class, bVar2);
        iVar2.d(String.class, InputStream.class, new p.e.c()).d(Uri.class, InputStream.class, new p.e.c()).d(String.class, InputStream.class, new p.w.c()).d(String.class, ParcelFileDescriptor.class, new p.w.b()).d(String.class, AssetFileDescriptor.class, new p.w.a()).d(Uri.class, InputStream.class, new p.a.c(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new p.a.b(context.getAssets())).d(Uri.class, InputStream.class, new q.b.a(context)).d(Uri.class, InputStream.class, new q.c.a(context));
        if (i10 >= 29) {
            iVar2.d(Uri.class, InputStream.class, new q.d.c(context));
            iVar2.d(Uri.class, ParcelFileDescriptor.class, new q.d.b(context));
        }
        iVar2.d(Uri.class, InputStream.class, new y.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new y.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new y.a(contentResolver)).d(Uri.class, InputStream.class, new z.a()).d(URL.class, InputStream.class, new q.g.a()).d(Uri.class, File.class, new p.l.a(context)).d(p.h.class, InputStream.class, new q.a.C0336a()).d(byte[].class, ByteBuffer.class, new p.b.a()).d(byte[].class, InputStream.class, new p.b.d()).d(Uri.class, Uri.class, x.a.a()).d(Drawable.class, Drawable.class, x.a.a()).c(Drawable.class, Drawable.class, new u.l()).q(Bitmap.class, BitmapDrawable.class, new x.b(resources)).q(Bitmap.class, byte[].class, aVar2).q(Drawable.class, byte[].class, new x.c(dVar, aVar2, dVar2)).q(w.c.class, byte[].class, dVar2);
        if (i10 >= 23) {
            j.k<ByteBuffer, Bitmap> kVarD = k0.d(dVar);
            iVar2.c(ByteBuffer.class, Bitmap.class, kVarD);
            iVar2.c(ByteBuffer.class, BitmapDrawable.class, new s.a(resources, kVarD));
        }
    }

    static e0.f.b<i> d(c cVar, List<GlideModule> list, @Nullable AppGlideModule appGlideModule) {
        return new a(cVar, list, appGlideModule);
    }

    static i a(c cVar, List<GlideModule> list, @Nullable AppGlideModule appGlideModule) {
        m.d dVarF = cVar.f();
        m.b bVarE = cVar.e();
        Context origApplicationContext = StubApp.getOrigApplicationContext(cVar.i().getApplicationContext());
        f fVarG = cVar.i().g();
        i iVar = new i();
        b(origApplicationContext, iVar, dVarF, bVarE, fVarG);
        c(origApplicationContext, cVar, iVar, list, appGlideModule);
        return iVar;
    }

    private static void c(Context context, c cVar, i iVar, List<GlideModule> list, @Nullable AppGlideModule appGlideModule) {
        for (GlideModule glideModule : list) {
            try {
                glideModule.b(context, cVar, iVar);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e10);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.a(context, cVar, iVar);
        }
    }
}
