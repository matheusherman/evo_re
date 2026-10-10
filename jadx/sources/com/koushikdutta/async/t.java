package com.koushikdutta.async;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class t implements o4.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static Hashtable<Class, Method> f5134n = new Hashtable<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    n f5143i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f5135a = new a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l f5136b = new b(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private l f5137c = new c(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l f5138d = new d(4);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l f5139e = new e(8);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private j<byte[]> f5140f = new f();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j<com.koushikdutta.async.l> f5141g = new g();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j<byte[]> f5142h = new h();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinkedList<l> f5144j = new LinkedList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<Object> f5145k = new ArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    ByteOrder f5146l = ByteOrder.BIG_ENDIAN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    com.koushikdutta.async.l f5147m = new com.koushikdutta.async.l();

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends l {
        a(int i10) {
            super(i10);
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(null);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b extends l {
        b(int i10) {
            super(i10);
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(Byte.valueOf(lVar.e()));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class c extends l {
        c(int i10) {
            super(i10);
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(Short.valueOf(lVar.o()));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class d extends l {
        d(int i10) {
            super(i10);
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(Integer.valueOf(lVar.l()));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class e extends l {
        e(int i10) {
            super(i10);
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(Long.valueOf(lVar.m()));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class f implements j<byte[]> {
        f() {
        }

        @Override // com.koushikdutta.async.t.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            t.this.f5145k.add(bArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class g implements j<com.koushikdutta.async.l> {
        g() {
        }

        @Override // com.koushikdutta.async.t.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.koushikdutta.async.l lVar) {
            t.this.f5145k.add(lVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class h implements j<byte[]> {
        h() {
        }

        @Override // com.koushikdutta.async.t.j
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr) {
            t.this.f5145k.add(new String(bArr));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class i extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        j<byte[]> f5156b;

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            byte[] bArr = new byte[this.f5159a];
            lVar.h(bArr);
            this.f5156b.a(bArr);
            return null;
        }

        public i(int i10, j<byte[]> jVar) {
            super(i10);
            if (i10 > 0) {
                this.f5156b = jVar;
                return;
            }
            throw new IllegalArgumentException("length should be > 0");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface j<T> {
        void a(T t10);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class k extends l {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        byte f5157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        o4.b f5158c;

        public k(byte b10, o4.b bVar) {
            super(1);
            this.f5157b = b10;
            this.f5158c = bVar;
        }

        @Override // com.koushikdutta.async.t.l
        public l a(n nVar, com.koushikdutta.async.l lVar) {
            com.koushikdutta.async.l lVar2 = new com.koushikdutta.async.l();
            boolean z10 = true;
            while (lVar.C() > 0) {
                ByteBuffer byteBufferB = lVar.B();
                byteBufferB.mark();
                int i10 = 0;
                while (byteBufferB.remaining() > 0) {
                    z10 = byteBufferB.get() == this.f5157b;
                    if (z10) {
                        break;
                    }
                    i10++;
                }
                byteBufferB.reset();
                if (z10) {
                    lVar.c(byteBufferB);
                    lVar.g(lVar2, i10);
                    lVar.e();
                    break;
                }
                lVar2.a(byteBufferB);
            }
            this.f5158c.i(nVar, lVar2);
            if (z10) {
                return null;
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f5159a;

        public abstract l a(n nVar, com.koushikdutta.async.l lVar);

        public l(int i10) {
            this.f5159a = i10;
        }
    }

    public t b(int i10, j<byte[]> jVar) {
        this.f5144j.add(new i(i10, jVar));
        return this;
    }

    public t c(byte b10, o4.b bVar) {
        this.f5144j.add(new k(b10, bVar));
        return this;
    }

    @Override // o4.b
    public void i(n nVar, com.koushikdutta.async.l lVar) {
        lVar.f(this.f5147m);
        while (this.f5144j.size() > 0 && this.f5147m.A() >= this.f5144j.peek().f5159a) {
            this.f5147m.s(this.f5146l);
            l lVarA = this.f5144j.poll().a(nVar, this.f5147m);
            if (lVarA != null) {
                this.f5144j.addFirst(lVarA);
            }
        }
        if (this.f5144j.size() == 0) {
            this.f5147m.f(lVar);
        }
    }

    public t(n nVar) {
        this.f5143i = nVar;
        nVar.e(this);
    }
}
