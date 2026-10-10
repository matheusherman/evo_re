package fa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.g;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<f> f10083b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends f> inner) {
        m.f(inner, "inner");
        this.f10083b = inner;
    }

    @Override // fa.f
    public void a(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor, List<kotlin.reflect.jvm.internal.impl.descriptors.d> result) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        m.f(result, "result");
        Iterator<T> it = this.f10083b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).a(_context_receiver_0, thisDescriptor, result);
        }
    }

    @Override // fa.f
    public List<ba.f> b(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        List<f> list = this.f10083b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            r.C(arrayList, ((f) it.next()).b(_context_receiver_0, thisDescriptor));
        }
        return arrayList;
    }

    @Override // fa.f
    public void c(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor, ba.f name, List<kotlin.reflect.jvm.internal.impl.descriptors.e> result) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        m.f(name, "name");
        m.f(result, "result");
        Iterator<T> it = this.f10083b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c(_context_receiver_0, thisDescriptor, name, result);
        }
    }

    @Override // fa.f
    public void d(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor, ba.f name, Collection<z0> result) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        m.f(name, "name");
        m.f(result, "result");
        Iterator<T> it = this.f10083b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).d(_context_receiver_0, thisDescriptor, name, result);
        }
    }

    @Override // fa.f
    public void e(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor, ba.f name, Collection<z0> result) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        m.f(name, "name");
        m.f(result, "result");
        Iterator<T> it = this.f10083b.iterator();
        while (it.hasNext()) {
            ((f) it.next()).e(_context_receiver_0, thisDescriptor, name, result);
        }
    }

    @Override // fa.f
    public List<ba.f> f(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        List<f> list = this.f10083b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            r.C(arrayList, ((f) it.next()).f(_context_receiver_0, thisDescriptor));
        }
        return arrayList;
    }

    @Override // fa.f
    public List<ba.f> g(g _context_receiver_0, kotlin.reflect.jvm.internal.impl.descriptors.e thisDescriptor) {
        m.f(_context_receiver_0, "_context_receiver_0");
        m.f(thisDescriptor, "thisDescriptor");
        List<f> list = this.f10083b;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            r.C(arrayList, ((f) it.next()).g(_context_receiver_0, thisDescriptor));
        }
        return arrayList;
    }
}
