package org.slf4j.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class h implements bf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f17131a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Map<String, g> f17132b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final LinkedBlockingQueue<cf.d> f17133c = new LinkedBlockingQueue<>();

    public void d() {
        this.f17131a = true;
    }

    @Override // bf.a
    public synchronized bf.b getLogger(String str) {
        g gVar;
        gVar = this.f17132b.get(str);
        if (gVar == null) {
            gVar = new g(str, this.f17133c, this.f17131a);
            this.f17132b.put(str, gVar);
        }
        return gVar;
    }

    public void a() {
        this.f17132b.clear();
        this.f17133c.clear();
    }

    public LinkedBlockingQueue<cf.d> b() {
        return this.f17133c;
    }

    public List<g> c() {
        return new ArrayList(this.f17132b.values());
    }
}
