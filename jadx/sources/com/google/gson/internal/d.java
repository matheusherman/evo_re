package com.google.gson.internal;

import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class d implements y, Cloneable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f4877g = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f4878a = -1.0d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4879b = 136;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4880c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<com.google.gson.a> f4882e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<com.google.gson.a> f4883f;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a<T> extends x<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private x<T> f4884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f4885b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f4886c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.google.gson.e f4887d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f3.a f4888e;

        a(boolean z10, boolean z11, com.google.gson.e eVar, f3.a aVar) {
            this.f4885b = z10;
            this.f4886c = z11;
            this.f4887d = eVar;
            this.f4888e = aVar;
        }

        private x<T> e() {
            x<T> xVar = this.f4884a;
            if (xVar != null) {
                return xVar;
            }
            x<T> xVarR = this.f4887d.r(d.this, this.f4888e);
            this.f4884a = xVarR;
            return xVarR;
        }

        @Override // com.google.gson.x
        public T b(g3.a aVar) throws IOException {
            if (!this.f4885b) {
                return e().b(aVar);
            }
            aVar.Z();
            return null;
        }

        @Override // com.google.gson.x
        public void d(g3.c cVar, T t10) throws IOException {
            if (this.f4886c) {
                cVar.q();
            } else {
                e().d(cVar, t10);
            }
        }
    }

    private boolean l(a3.d dVar) {
        if (dVar != null) {
            return this.f4878a >= dVar.value();
        }
        return true;
    }

    private boolean m(a3.e eVar) {
        if (eVar != null) {
            return this.f4878a < eVar.value();
        }
        return true;
    }

    private boolean e(Class<?> cls) {
        if (this.f4878a != -1.0d && !n((a3.d) cls.getAnnotation(a3.d.class), (a3.e) cls.getAnnotation(a3.e.class))) {
            return true;
        }
        if (this.f4880c || !j(cls)) {
            return i(cls);
        }
        return true;
    }

    private boolean g(Class<?> cls, boolean z10) {
        Iterator<com.google.gson.a> it = (z10 ? this.f4882e : this.f4883f).iterator();
        while (it.hasNext()) {
            if (it.next().b(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean i(Class<?> cls) {
        if (Enum.class.isAssignableFrom(cls) || k(cls)) {
            return false;
        }
        return cls.isAnonymousClass() || cls.isLocalClass();
    }

    public boolean h(Field field, boolean z10) {
        a3.a aVar;
        if ((this.f4879b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f4878a != -1.0d && !n((a3.d) field.getAnnotation(a3.d.class), (a3.e) field.getAnnotation(a3.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f4881d && ((aVar = (a3.a) field.getAnnotation(a3.a.class)) == null || (!z10 ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f4880c && j(field.getType())) || i(field.getType())) {
            return true;
        }
        List<com.google.gson.a> list = z10 ? this.f4882e : this.f4883f;
        if (list.isEmpty()) {
            return false;
        }
        com.google.gson.b bVar = new com.google.gson.b(field);
        Iterator<com.google.gson.a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(bVar)) {
                return true;
            }
        }
        return false;
    }

    public d() {
        List<com.google.gson.a> list = Collections.EMPTY_LIST;
        this.f4882e = list;
        this.f4883f = list;
    }

    private boolean j(Class<?> cls) {
        if (cls.isMemberClass() && !k(cls)) {
            return true;
        }
        return false;
    }

    private boolean k(Class<?> cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean n(a3.d dVar, a3.e eVar) {
        if (l(dVar) && m(eVar)) {
            return true;
        }
        return false;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, f3.a<T> aVar) {
        boolean z10;
        boolean z11;
        Class<? super T> clsC = aVar.c();
        boolean zE = e(clsC);
        if (!zE && !g(clsC, true)) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (!zE && !g(clsC, false)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z10 && !z11) {
            return null;
        }
        return new a(z11, z10, eVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(Class<?> cls, boolean z10) {
        if (!e(cls) && !g(cls, z10)) {
            return false;
        }
        return true;
    }
}
