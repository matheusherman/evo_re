package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class e extends d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static HashMap<String, byte[]> f9069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static HashMap<String, HashMap<String, byte[]>> f9070i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected g f9071g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f9072j;

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final <T> void a(String str, T t10) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is ".concat(str));
        }
        super.a(str, t10);
    }

    @Override // com.tencent.bugly.proguard.d
    public final void b() {
        super.b();
        this.f9071g.f9078a = (short) 3;
    }

    public final void c(String str) {
        this.f9071g.f9083f = str;
    }

    public final void c() {
        this.f9071g.f9081d = 1;
    }

    public e() {
        g gVar = new g();
        this.f9071g = gVar;
        this.f9072j = 0;
        gVar.f9078a = (short) 2;
    }

    public final void b(String str) {
        this.f9071g.f9082e = str;
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final byte[] a() {
        g gVar = this.f9071g;
        if (gVar.f9078a == 2) {
            if (!gVar.f9082e.equals("")) {
                if (this.f9071g.f9083f.equals("")) {
                    throw new IllegalArgumentException("funcName can not is null");
                }
            } else {
                throw new IllegalArgumentException("servantName can not is null");
            }
        } else {
            if (gVar.f9082e == null) {
                gVar.f9082e = "";
            }
            if (gVar.f9083f == null) {
                gVar.f9083f = "";
            }
        }
        l lVar = new l(0);
        lVar.a(this.f9063c);
        if (this.f9071g.f9078a == 2) {
            lVar.a((Map) this.f9061a, 0);
        } else {
            lVar.a((Map) ((d) this).f9066e, 0);
        }
        this.f9071g.f9084g = n.a(lVar.f9094a);
        l lVar2 = new l(0);
        lVar2.a(this.f9063c);
        this.f9071g.a(lVar2);
        byte[] bArrA = n.a(lVar2.f9094a);
        int length = bArrA.length + 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    @Override // com.tencent.bugly.proguard.d, com.tencent.bugly.proguard.c
    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                k kVar = new k(bArr, (byte) 0);
                kVar.a(this.f9063c);
                this.f9071g.a(kVar);
                g gVar = this.f9071g;
                if (gVar.f9078a == 3) {
                    k kVar2 = new k(gVar.f9084g);
                    kVar2.a(this.f9063c);
                    if (f9069h == null) {
                        HashMap<String, byte[]> map = new HashMap<>();
                        f9069h = map;
                        map.put("", new byte[0]);
                    }
                    ((d) this).f9066e = kVar2.a((Map) f9069h, 0, false);
                    return;
                }
                k kVar3 = new k(gVar.f9084g);
                kVar3.a(this.f9063c);
                if (f9070i == null) {
                    f9070i = new HashMap<>();
                    HashMap<String, byte[]> map2 = new HashMap<>();
                    map2.put("", new byte[0]);
                    f9070i.put("", map2);
                }
                this.f9061a = kVar3.a((Map) f9070i, 0, false);
                this.f9062b = new HashMap<>();
                return;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }
}
