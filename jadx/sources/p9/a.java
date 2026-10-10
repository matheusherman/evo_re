package p9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.jvm.internal.impl.load.kotlin.r;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.kotlin.i f17434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f17435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<ba.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.h> f17436c;

    public a(kotlin.reflect.jvm.internal.impl.load.kotlin.i resolver, g kotlinClassFinder) {
        kotlin.jvm.internal.m.f(resolver, "resolver");
        kotlin.jvm.internal.m.f(kotlinClassFinder, "kotlinClassFinder");
        this.f17434a = resolver;
        this.f17435b = kotlinClassFinder;
        this.f17436c = new ConcurrentHashMap<>();
    }

    public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(f fileClass) {
        Collection collectionE;
        kotlin.jvm.internal.m.f(fileClass, "fileClass");
        ConcurrentHashMap<ba.b, kotlin.reflect.jvm.internal.impl.resolve.scopes.h> concurrentHashMap = this.f17436c;
        ba.b bVarE = fileClass.e();
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = concurrentHashMap.get(bVarE);
        if (hVar == null) {
            ba.c cVarH = fileClass.e().h();
            kotlin.jvm.internal.m.e(cVarH, "fileClass.classId.packageFqName");
            if (fileClass.g().c() == v9.a.EnumC0377a.MULTIFILE_CLASS) {
                List<String> listF = fileClass.g().f();
                collectionE = new ArrayList();
                Iterator<T> it = listF.iterator();
                while (it.hasNext()) {
                    ba.b bVarM = ba.b.m(fa.d.d((String) it.next()).e());
                    kotlin.jvm.internal.m.e(bVarM, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    s sVarA = r.a(this.f17435b, bVarM, sa.c.a(this.f17434a.d().g()));
                    if (sVarA != null) {
                        collectionE.add(sVarA);
                    }
                }
            } else {
                collectionE = kotlin.collections.r.e(fileClass);
            }
            kotlin.reflect.jvm.internal.impl.descriptors.impl.m mVar = new kotlin.reflect.jvm.internal.impl.descriptors.impl.m(this.f17434a.d().p(), cVarH);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = collectionE.iterator();
            while (it2.hasNext()) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarB = this.f17434a.b(mVar, (s) it2.next());
                if (hVarB != null) {
                    arrayList.add(hVarB);
                }
            }
            List listO0 = kotlin.collections.r.O0(arrayList);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarA = kotlin.reflect.jvm.internal.impl.resolve.scopes.b.f13960d.a("package " + cVarH + " (" + fileClass + ')', listO0);
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVarPutIfAbsent = concurrentHashMap.putIfAbsent(bVarE, hVarA);
            hVar = hVarPutIfAbsent == null ? hVarA : hVarPutIfAbsent;
        }
        kotlin.jvm.internal.m.e(hVar, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return hVar;
    }
}
