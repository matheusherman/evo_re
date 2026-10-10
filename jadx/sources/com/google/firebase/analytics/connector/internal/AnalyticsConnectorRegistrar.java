package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.google.firebase.components.ComponentRegistrar;
import j2.e;
import java.util.Arrays;
import java.util.List;
import k2.b;
import m2.c;
import m2.h;
import m2.r;
import p2.d;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@Keep
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NonNull
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<c<?>> getComponents() {
        return Arrays.asList(c.c(k2.a.class).b(r.h(e.class)).b(r.h(Context.class)).b(r.h(d.class)).e(new h() { // from class: com.google.firebase.analytics.connector.internal.a
            @Override // m2.h
            public final Object a(m2.e eVar) {
                return b.a((e) eVar.a(e.class), (Context) eVar.a(Context.class), (d) eVar.a(d.class));
            }
        }).d().c(), y2.h.b("fire-analytics", "22.3.0"));
    }
}
