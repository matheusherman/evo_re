package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class d extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected HashMap<String, byte[]> f9066e = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HashMap<String, Object> f9068g = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    k f9067f = new k();

    @Override // com.tencent.bugly.proguard.c
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void b() {
        this.f9066e = new HashMap<>();
    }

    private void c(String str, Object obj) {
        this.f9068g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.c
    public <T> void a(String str, T t10) {
        if (this.f9066e == null) {
            super.a(str, t10);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t10 == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t10 instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        l lVar = new l();
        lVar.a(this.f9063c);
        lVar.a(t10, 0);
        this.f9066e.put(str, n.a(lVar.f9094a));
    }

    public final <T> T b(String str, T t10) {
        HashMap<String, byte[]> map = this.f9066e;
        if (map != null) {
            if (!map.containsKey(str)) {
                return null;
            }
            if (this.f9068g.containsKey(str)) {
                return (T) this.f9068g.get(str);
            }
            try {
                this.f9067f.a(this.f9066e.get(str));
                this.f9067f.a(this.f9063c);
                T t11 = (T) this.f9067f.a((Object) t10, 0, true);
                if (t11 == null) {
                    return t11;
                }
                c(str, t11);
                return t11;
            } catch (Exception e10) {
                throw new b(e10);
            }
        }
        if (!this.f9061a.containsKey(str)) {
            return null;
        }
        if (this.f9068g.containsKey(str)) {
            return (T) this.f9068g.get(str);
        }
        byte[] value = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f9061a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            value = next.getValue();
        }
        try {
            this.f9067f.a(value);
            this.f9067f.a(this.f9063c);
            T t12 = (T) this.f9067f.a((Object) t10, 0, true);
            c(str, t12);
            return t12;
        } catch (Exception e11) {
            throw new b(e11);
        }
    }

    @Override // com.tencent.bugly.proguard.c
    public byte[] a() {
        if (this.f9066e != null) {
            l lVar = new l(0);
            lVar.a(this.f9063c);
            lVar.a((Map) this.f9066e, 0);
            return n.a(lVar.f9094a);
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.c
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f9067f.a(bArr);
            this.f9067f.a(this.f9063c);
            HashMap map = new HashMap(1);
            map.put("", new byte[0]);
            this.f9066e = this.f9067f.a((Map) map, 0, false);
        }
    }
}
