package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class u extends kotlin.reflect.jvm.internal.impl.protobuf.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f13702h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f13703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f13704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f13705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13706e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f13707f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13708g;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class c implements Iterator<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<u> f13710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p f13711b;

        private c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f13710a = new Stack<>();
            this.f13711b = c(dVar);
        }

        private p c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            while (dVar instanceof u) {
                u uVar = (u) dVar;
                this.f13710a.push(uVar);
                dVar = uVar.f13704c;
            }
            return (p) dVar;
        }

        private p d() {
            while (!this.f13710a.isEmpty()) {
                p pVarC = c(this.f13710a.pop().f13705d);
                if (!pVarC.isEmpty()) {
                    return pVarC;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public p next() {
            p pVar = this.f13711b;
            if (pVar == null) {
                throw new NoSuchElementException();
            }
            this.f13711b = d();
            return pVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13711b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class d implements kotlin.reflect.jvm.internal.impl.protobuf.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f13712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d.a f13713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13714c;

        private d() {
            c cVar = new c(u.this);
            this.f13712a = cVar;
            this.f13713b = cVar.next().iterator();
            this.f13714c = u.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte a() {
            if (!this.f13713b.hasNext()) {
                this.f13713b = this.f13712a.next().iterator();
            }
            this.f13714c--;
            return this.f13713b.a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13714c > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class e extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c f13716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private p f13717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13718c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f13719d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f13720e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f13721f;

        private int c(byte[] bArr, int i10, int i11) {
            int i12 = i11;
            while (i12 > 0) {
                a();
                if (this.f13717b == null) {
                    if (i12 != i11) {
                        break;
                    }
                    return -1;
                }
                int iMin = Math.min(this.f13718c - this.f13719d, i12);
                if (bArr != null) {
                    this.f13717b.m(bArr, this.f13719d, i10, iMin);
                    i10 += iMin;
                }
                this.f13719d += iMin;
                i12 -= iMin;
            }
            return i11 - i12;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            bArr.getClass();
            if (i10 < 0 || i11 < 0 || i11 > bArr.length - i10) {
                throw new IndexOutOfBoundsException();
            }
            return c(bArr, i10, i11);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            b();
            c(null, 0, this.f13721f);
        }

        public e() {
            b();
        }

        private void a() {
            if (this.f13717b != null) {
                int i10 = this.f13719d;
                int i11 = this.f13718c;
                if (i10 == i11) {
                    this.f13720e += i11;
                    this.f13719d = 0;
                    if (!this.f13716a.hasNext()) {
                        this.f13717b = null;
                        this.f13718c = 0;
                    } else {
                        p next = this.f13716a.next();
                        this.f13717b = next;
                        this.f13718c = next.size();
                    }
                }
            }
        }

        private void b() {
            c cVar = new c(u.this);
            this.f13716a = cVar;
            p next = cVar.next();
            this.f13717b = next;
            this.f13718c = next.size();
            this.f13719d = 0;
            this.f13720e = 0;
        }

        @Override // java.io.InputStream
        public int available() {
            return u.this.size() - (this.f13720e + this.f13719d);
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f13721f = this.f13720e + this.f13719d;
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (j10 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j10 > 2147483647L) {
                j10 = 2147483647L;
            }
            return c(null, 0, (int) j10);
        }

        @Override // java.io.InputStream
        public int read() {
            a();
            p pVar = this.f13717b;
            if (pVar == null) {
                return -1;
            }
            int i10 = this.f13719d;
            this.f13719d = i10 + 1;
            return pVar.D(i10) & 255;
        }
    }

    public boolean equals(Object obj) {
        int iX;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kotlin.reflect.jvm.internal.impl.protobuf.d)) {
            return false;
        }
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
        if (this.f13703b != dVar.size()) {
            return false;
        }
        if (this.f13703b == 0) {
            return true;
        }
        if (this.f13708g == 0 || (iX = dVar.x()) == 0 || this.f13708g == iX) {
            return K(dVar);
        }
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Stack<kotlin.reflect.jvm.internal.impl.protobuf.d> f13709a;

        private b() {
            this.f13709a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public kotlin.reflect.jvm.internal.impl.protobuf.d b(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
            c(dVar);
            c(dVar2);
            kotlin.reflect.jvm.internal.impl.protobuf.d dVarPop = this.f13709a.pop();
            while (!this.f13709a.isEmpty()) {
                dVarPop = new u(this.f13709a.pop(), dVarPop);
            }
            return dVarPop;
        }

        private void c(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            if (dVar.q()) {
                e(dVar);
                return;
            }
            if (dVar instanceof u) {
                u uVar = (u) dVar;
                c(uVar.f13704c);
                c(uVar.f13705d);
            } else {
                String strValueOf = String.valueOf(dVar.getClass());
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
                sb2.append("Has a new type of ByteString been created? Found ");
                sb2.append(strValueOf);
                throw new IllegalArgumentException(sb2.toString());
            }
        }

        private int d(int i10) {
            int iBinarySearch = Arrays.binarySearch(u.f13702h, i10);
            if (iBinarySearch < 0) {
                return (-(iBinarySearch + 1)) - 1;
            }
            return iBinarySearch;
        }

        private void e(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            int iD = d(dVar.size());
            int i10 = u.f13702h[iD + 1];
            if (!this.f13709a.isEmpty() && this.f13709a.peek().size() < i10) {
                int i11 = u.f13702h[iD];
                kotlin.reflect.jvm.internal.impl.protobuf.d dVarPop = this.f13709a.pop();
                while (true) {
                    if (this.f13709a.isEmpty() || this.f13709a.peek().size() >= i11) {
                        break;
                    } else {
                        dVarPop = new u(this.f13709a.pop(), dVarPop);
                    }
                }
                u uVar = new u(dVarPop, dVar);
                while (!this.f13709a.isEmpty()) {
                    if (this.f13709a.peek().size() >= u.f13702h[d(uVar.size()) + 1]) {
                        break;
                    } else {
                        uVar = new u(this.f13709a.pop(), uVar);
                    }
                }
                this.f13709a.push(uVar);
                return;
            }
            this.f13709a.push(dVar);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            int i12 = i11 + i10;
            i11 = i10;
            i10 = i12;
        }
        arrayList.add(Integer.MAX_VALUE);
        f13702h = new int[arrayList.size()];
        int i13 = 0;
        while (true) {
            int[] iArr = f13702h;
            if (i13 >= iArr.length) {
                return;
            }
            iArr[i13] = ((Integer) arrayList.get(i13)).intValue();
            i13++;
        }
    }

    private u(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        this.f13708g = 0;
        this.f13704c = dVar;
        this.f13705d = dVar2;
        int size = dVar.size();
        this.f13706e = size;
        this.f13703b = size + dVar2.size();
        this.f13707f = Math.max(dVar.o(), dVar2.o()) + 1;
    }

    static kotlin.reflect.jvm.internal.impl.protobuf.d I(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        u uVar = dVar instanceof u ? (u) dVar : null;
        if (dVar2.size() == 0) {
            return dVar;
        }
        if (dVar.size() == 0) {
            return dVar2;
        }
        int size = dVar.size() + dVar2.size();
        if (size < 128) {
            return J(dVar, dVar2);
        }
        if (uVar != null && uVar.f13705d.size() + dVar2.size() < 128) {
            return new u(uVar.f13704c, J(uVar.f13705d, dVar2));
        }
        if (uVar == null || uVar.f13704c.o() <= uVar.f13705d.o() || uVar.o() <= dVar2.o()) {
            return size >= f13702h[Math.max(dVar.o(), dVar2.o()) + 1] ? new u(dVar, dVar2) : new b().b(dVar, dVar2);
        }
        return new u(uVar.f13704c, new u(uVar.f13705d, dVar2));
    }

    private boolean K(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
        c cVar = new c(this);
        p next = cVar.next();
        c cVar2 = new c(dVar);
        p next2 = cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = next.size() - i10;
            int size2 = next2.size() - i11;
            int iMin = Math.min(size, size2);
            if (!(i10 == 0 ? next.E(next2, i11, iMin) : next2.E(next, i10, iMin))) {
                return false;
            }
            i12 += iMin;
            int i13 = this.f13703b;
            if (i12 >= i13) {
                if (i12 == i13) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = cVar.next();
                i10 = 0;
            } else {
                i10 += iMin;
            }
            if (iMin == size2) {
                next2 = cVar2.next();
                i11 = 0;
            } else {
                i11 += iMin;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    void C(OutputStream outputStream, int i10, int i11) {
        int i12 = i10 + i11;
        int i13 = this.f13706e;
        if (i12 <= i13) {
            this.f13704c.C(outputStream, i10, i11);
        } else {
            if (i10 >= i13) {
                this.f13705d.C(outputStream, i10 - i13, i11);
                return;
            }
            int i14 = i13 - i10;
            this.f13704c.C(outputStream, i10, i14);
            this.f13705d.C(outputStream, 0, i11 - i14);
        }
    }

    public int hashCode() {
        int iV = this.f13708g;
        if (iV == 0) {
            int i10 = this.f13703b;
            iV = v(i10, 0, i10);
            if (iV == 0) {
                iV = 1;
            }
            this.f13708g = iV;
        }
        return iV;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.f13706e;
        if (i13 <= i14) {
            this.f13704c.n(bArr, i10, i11, i12);
        } else {
            if (i10 >= i14) {
                this.f13705d.n(bArr, i10 - i14, i11, i12);
                return;
            }
            int i15 = i14 - i10;
            this.f13704c.n(bArr, i10, i11, i15);
            this.f13705d.n(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int o() {
        return this.f13707f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected boolean q() {
        return this.f13703b >= f13702h[this.f13707f];
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public boolean r() {
        int iW = this.f13704c.w(0, 0, this.f13706e);
        kotlin.reflect.jvm.internal.impl.protobuf.d dVar = this.f13705d;
        return dVar.w(iW, 0, dVar.size()) == 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* JADX INFO: renamed from: s */
    public kotlin.reflect.jvm.internal.impl.protobuf.d.a iterator() {
        return new d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f13703b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public kotlin.reflect.jvm.internal.impl.protobuf.e t() {
        return kotlin.reflect.jvm.internal.impl.protobuf.e.g(new e());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int v(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f13706e;
        if (i13 <= i14) {
            return this.f13704c.v(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f13705d.v(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f13705d.v(this.f13704c.v(i10, i11, i15), 0, i12 - i15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int w(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.f13706e;
        if (i13 <= i14) {
            return this.f13704c.w(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.f13705d.w(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.f13705d.w(this.f13704c.w(i10, i11, i15), 0, i12 - i15);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    protected int x() {
        return this.f13708g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.d
    public String z(String str) {
        return new String(y(), str);
    }

    private static p J(kotlin.reflect.jvm.internal.impl.protobuf.d dVar, kotlin.reflect.jvm.internal.impl.protobuf.d dVar2) {
        int size = dVar.size();
        int size2 = dVar2.size();
        byte[] bArr = new byte[size + size2];
        dVar.m(bArr, 0, 0, size);
        dVar2.m(bArr, 0, size, size2);
        return new p(bArr);
    }
}
