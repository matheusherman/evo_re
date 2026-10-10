package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class kc implements Comparable, Map.Entry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Comparable f2807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object f2808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ gc f2809c;

    kc(gc gcVar, Map.Entry entry) {
        this(gcVar, (Comparable) entry.getKey(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return a(this.f2807a, entry.getKey()) && a(this.f2808b, entry.getValue());
    }

    kc(gc gcVar, Comparable comparable, Object obj) {
        this.f2809c = gcVar;
        this.f2807a = comparable;
        this.f2808b = obj;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((kc) obj).getKey());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f2807a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2808b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2807a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f2808b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2809c.r();
        Object obj2 = this.f2808b;
        this.f2808b = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f2807a) + "=" + String.valueOf(this.f2808b);
    }
}
