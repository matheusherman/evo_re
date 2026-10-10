package com.google.firebase.installations;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import m2.e0;
import m2.h;
import m2.r;
import n2.k;
import q2.i;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Keep
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-installations";

    public static /* synthetic */ s2.d a(m2.e eVar) {
        return new b((j2.e) eVar.a(j2.e.class), eVar.c(i.class), (ExecutorService) eVar.e(e0.a(l2.a.class, ExecutorService.class)), k.a((Executor) eVar.e(e0.a(l2.b.class, Executor.class))));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<m2.c<?>> getComponents() {
        return Arrays.asList(m2.c.c(s2.d.class).g(LIBRARY_NAME).b(r.h(j2.e.class)).b(r.g(i.class)).b(r.i(e0.a(l2.a.class, ExecutorService.class))).b(r.i(e0.a(l2.b.class, Executor.class))).e(new h() { // from class: s2.e
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return FirebaseInstallationsRegistrar.a(eVar);
            }
        }).c(), q2.h.a(), y2.h.b(LIBRARY_NAME, "18.0.0"));
    }
}
