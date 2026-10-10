package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
final class x1 implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Set<String> f3195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f3196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ u1 f3197d;

    /* synthetic */ x1(u1 u1Var, w1 w1Var) {
        this(u1Var);
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.f3194a = true;
        return this;
    }

    private x1(u1 u1Var) {
        this.f3197d = u1Var;
        this.f3194a = false;
        this.f3195b = new HashSet();
        this.f3196c = new HashMap();
    }

    private final void a(String str, Object obj) {
        if (obj != null) {
            this.f3196c.put(str, obj);
        } else {
            remove(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        if (this.f3194a) {
            this.f3197d.f3093a.clear();
        }
        this.f3197d.f3093a.keySet().removeAll(this.f3195b);
        for (Map.Entry<String, Object> entry : this.f3196c.entrySet()) {
            this.f3197d.f3093a.put(entry.getKey(), entry.getValue());
        }
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f3197d.f3094b) {
            com.google.common.collect.s0 s0VarE = com.google.common.collect.n0.c(this.f3195b, this.f3196c.keySet()).iterator();
            while (s0VarE.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f3197d, (String) s0VarE.next());
            }
        }
        return (!this.f3194a && this.f3195b.isEmpty() && this.f3196c.isEmpty()) ? false : true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.f3195b.add(str);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
        a(str, Boolean.valueOf(z10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f10) {
        a(str, Float.valueOf(f10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i10) {
        a(str, Integer.valueOf(i10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j10) {
        a(str, Long.valueOf(j10));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        a(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        a(str, set);
        return this;
    }
}
