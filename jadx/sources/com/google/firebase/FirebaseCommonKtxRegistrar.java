package com.google.firebase;

import androidx.annotation.Keep;
import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.m1;
import m2.e;
import m2.e0;
import m2.h;
import m2.r;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Keep
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "<init>", "()V", "", "Lm2/c;", "getComponents", "()Ljava/util/List;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lm2/e;", "kotlin.jvm.PlatformType", "c", "Lkotlinx/coroutines/i0;", "b", "(Lm2/e;)Lkotlinx/coroutines/i0;"}, k = 3, mv = {1, 8, 0})
    public static final class a<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f4694a = new a<>();

        @Override // m2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(e eVar) {
            Object objE = eVar.e(e0.a(l2.a.class, Executor.class));
            m.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return m1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lm2/e;", "kotlin.jvm.PlatformType", "c", "Lkotlinx/coroutines/i0;", "b", "(Lm2/e;)Lkotlinx/coroutines/i0;"}, k = 3, mv = {1, 8, 0})
    public static final class b<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f4695a = new b<>();

        @Override // m2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(e eVar) {
            Object objE = eVar.e(e0.a(l2.c.class, Executor.class));
            m.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return m1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lm2/e;", "kotlin.jvm.PlatformType", "c", "Lkotlinx/coroutines/i0;", "b", "(Lm2/e;)Lkotlinx/coroutines/i0;"}, k = 3, mv = {1, 8, 0})
    public static final class c<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f4696a = new c<>();

        @Override // m2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(e eVar) {
            Object objE = eVar.e(e0.a(l2.b.class, Executor.class));
            m.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return m1.a((Executor) objE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lm2/e;", "kotlin.jvm.PlatformType", "c", "Lkotlinx/coroutines/i0;", "b", "(Lm2/e;)Lkotlinx/coroutines/i0;"}, k = 3, mv = {1, 8, 0})
    public static final class d<T> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<T> f4697a = new d<>();

        @Override // m2.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i0 a(e eVar) {
            Object objE = eVar.e(e0.a(l2.d.class, Executor.class));
            m.e(objE, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return m1.a((Executor) objE);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<m2.c<?>> getComponents() {
        m2.c cVarC = m2.c.e(e0.a(l2.a.class, i0.class)).b(r.i(e0.a(l2.a.class, Executor.class))).e(a.f4694a).c();
        m.e(cVarC, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        m2.c cVarC2 = m2.c.e(e0.a(l2.c.class, i0.class)).b(r.i(e0.a(l2.c.class, Executor.class))).e(b.f4695a).c();
        m.e(cVarC2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        m2.c cVarC3 = m2.c.e(e0.a(l2.b.class, i0.class)).b(r.i(e0.a(l2.b.class, Executor.class))).e(c.f4696a).c();
        m.e(cVarC3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        m2.c cVarC4 = m2.c.e(e0.a(l2.d.class, i0.class)).b(r.i(e0.a(l2.d.class, Executor.class))).e(d.f4697a).c();
        m.e(cVarC4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return kotlin.collections.r.o(cVarC, cVarC2, cVarC3, cVarC4);
    }
}
