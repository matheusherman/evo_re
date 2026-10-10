package com.google.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.google.gson.internal.d f4833a = com.google.gson.internal.d.f4877g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f4834b = t.f4925a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f4835c = c.f4794a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Type, g<?>> f4836d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<y> f4837e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<y> f4838f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4839g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f4840h = e.f4802z;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f4841i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f4842j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f4843k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f4844l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f4845m = true;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f4846n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f4847o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f4848p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f4849q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private w f4850r = e.B;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private w f4851s = e.C;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LinkedList<u> f4852t = new LinkedList<>();

    public f d() {
        this.f4839g = true;
        return this;
    }

    private void a(String str, int i10, int i11, List<y> list) {
        y yVarB;
        y yVarB2;
        boolean z10 = e3.d.f9872a;
        y yVarA = null;
        if (str != null && !str.trim().isEmpty()) {
            yVarB = b3.d.b.f755b.b(str);
            if (z10) {
                yVarA = e3.d.f9874c.b(str);
                yVarB2 = e3.d.f9873b.b(str);
            } else {
                yVarB2 = null;
            }
        } else {
            if (i10 == 2 || i11 == 2) {
                return;
            }
            y yVarA2 = b3.d.b.f755b.a(i10, i11);
            if (z10) {
                yVarA = e3.d.f9874c.a(i10, i11);
                y yVarA3 = e3.d.f9873b.a(i10, i11);
                yVarB = yVarA2;
                yVarB2 = yVarA3;
            } else {
                yVarB = yVarA2;
                yVarB2 = null;
            }
        }
        list.add(yVarB);
        if (z10) {
            list.add(yVarA);
            list.add(yVarB2);
        }
    }

    public e b() {
        List<y> arrayList = new ArrayList<>(this.f4837e.size() + this.f4838f.size() + 3);
        arrayList.addAll(this.f4837e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f4838f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f4840h, this.f4841i, this.f4842j, arrayList);
        return new e(this.f4833a, this.f4835c, new HashMap(this.f4836d), this.f4839g, this.f4843k, this.f4847o, this.f4845m, this.f4846n, this.f4848p, this.f4844l, this.f4849q, this.f4834b, this.f4840h, this.f4841i, this.f4842j, new ArrayList(this.f4837e), new ArrayList(this.f4838f), arrayList, this.f4850r, this.f4851s, new ArrayList(this.f4852t));
    }

    public f e(String str) {
        this.f4840h = str;
        return this;
    }

    public f c(Type type, Object obj) {
        boolean z10;
        Objects.requireNonNull(type);
        boolean z11 = obj instanceof r;
        if (!z11 && !(obj instanceof j) && !(obj instanceof g) && !(obj instanceof x)) {
            z10 = false;
        } else {
            z10 = true;
        }
        com.google.gson.internal.a.a(z10);
        if (obj instanceof g) {
            this.f4836d.put(type, (g) obj);
        }
        if (z11 || (obj instanceof j)) {
            this.f4837e.add(b3.m.g(f3.a.b(type), obj));
        }
        if (obj instanceof x) {
            this.f4837e.add(b3.o.a(f3.a.b(type), (x) obj));
        }
        return this;
    }

    public f f(c cVar) {
        return g(cVar);
    }

    public f g(d dVar) {
        Objects.requireNonNull(dVar);
        this.f4835c = dVar;
        return this;
    }

    public f h(w wVar) {
        Objects.requireNonNull(wVar);
        this.f4850r = wVar;
        return this;
    }
}
