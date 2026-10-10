package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import l.t;
import l.v;
import p.o;
import p.p;
import p.q;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f1325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z.a f1326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z.e f1327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final z.f f1328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.data.f f1329e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x.f f1330f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final z.b f1331g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final z.d f1332h = new z.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final z.c f1333i = new z.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f1334j;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(@NonNull M m10, @NonNull List<o<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    @NonNull
    private <Data, TResource, Transcode> List<l.i<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f1327c.d(cls, cls2)) {
            for (Class cls5 : this.f1330f.b(cls4, cls3)) {
                arrayList.add(new l.i(cls, cls4, cls5, this.f1327c.b(cls, cls4), this.f1330f.a(cls4, cls5), this.f1334j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data> i a(@NonNull Class<Data> cls, @NonNull j.d<Data> dVar) {
        this.f1326b.a(cls, dVar);
        return this;
    }

    @NonNull
    public <TResource> i b(@NonNull Class<TResource> cls, @NonNull j.l<TResource> lVar) {
        this.f1328d.a(cls, lVar);
        return this;
    }

    @NonNull
    public <Data, TResource> i c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull j.k<Data, TResource> kVar) {
        e("legacy_append", cls, cls2, kVar);
        return this;
    }

    @NonNull
    public <Model, Data> i d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<Model, Data> pVar) {
        this.f1325a.a(cls, cls2, pVar);
        return this;
    }

    @NonNull
    public <Data, TResource> i e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull j.k<Data, TResource> kVar) {
        this.f1327c.a(str, kVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.f1331g.b();
        if (listB.isEmpty()) {
            throw new b();
        }
        return listB;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        Class<Data> cls4;
        Class<TResource> cls5;
        Class<Transcode> cls6;
        t<Data, TResource, Transcode> tVarA = this.f1333i.a(cls, cls2, cls3);
        t<Data, TResource, Transcode> tVar = null;
        if (this.f1333i.c(tVarA)) {
            return null;
        }
        if (tVarA != null) {
            return tVarA;
        }
        List<l.i<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
        if (listF.isEmpty()) {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
        } else {
            cls4 = cls;
            cls5 = cls2;
            cls6 = cls3;
            tVar = new t<>(cls4, cls5, cls6, listF, this.f1334j);
        }
        this.f1333i.d(cls4, cls5, cls6, tVar);
        return tVar;
    }

    @NonNull
    public <Model> List<o<Model, ?>> i(@NonNull Model model) {
        return this.f1325a.d(model);
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.f1332h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f1325a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f1327c.d(it.next(), cls2)) {
                    if (!this.f1330f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f1332h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <X> j.l<X> k(@NonNull v<X> vVar) {
        j.l<X> lVarB = this.f1328d.b(vVar.b());
        if (lVarB != null) {
            return lVarB;
        }
        throw new d(vVar.b());
    }

    @NonNull
    public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X x10) {
        return this.f1329e.a(x10);
    }

    @NonNull
    public <X> j.d<X> m(@NonNull X x10) {
        j.d<X> dVarB = this.f1326b.b(x10.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new e(x10.getClass());
    }

    public boolean n(@NonNull v<?> vVar) {
        return this.f1328d.b(vVar.b()) != null;
    }

    @NonNull
    public i o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f1331g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public i p(@NonNull com.bumptech.glide.load.data.e.a<?> aVar) {
        this.f1329e.b(aVar);
        return this;
    }

    @NonNull
    public <TResource, Transcode> i q(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull x.e<TResource, Transcode> eVar) {
        this.f1330f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public <Model, Data> i r(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        this.f1325a.f(cls, cls2, pVar);
        return this;
    }

    @NonNull
    public final i s(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.f1327c.e(arrayList);
        return this;
    }

    public i() {
        Pools.Pool<List<Throwable>> poolE = f0.a.e();
        this.f1334j = poolE;
        this.f1325a = new q(poolE);
        this.f1326b = new z.a();
        this.f1327c = new z.e();
        this.f1328d = new z.f();
        this.f1329e = new com.bumptech.glide.load.data.f();
        this.f1330f = new x.f();
        this.f1331g = new z.b();
        s(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }
}
