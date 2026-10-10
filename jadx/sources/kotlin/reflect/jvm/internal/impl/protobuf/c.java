package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
class c extends p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f13628e;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class b implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f13630b;

        private b() {
            int iH = c.this.H();
            this.f13629a = iH;
            this.f13630b = iH + c.this.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.d.a
        public byte a() {
            int i10 = this.f13629a;
            if (i10 >= this.f13630b) {
                throw new NoSuchElementException();
            }
            byte[] bArr = c.this.f13697b;
            this.f13629a = i10 + 1;
            return bArr[i10];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13629a < this.f13630b;
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

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public byte D(int i10) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Index too small: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < size()) {
            return this.f13697b[this.f13627d + i10];
        }
        int size = size();
        StringBuilder sb3 = new StringBuilder(41);
        sb3.append("Index too large: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    protected int H() {
        return this.f13627d;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p, kotlin.reflect.jvm.internal.impl.protobuf.d
    protected void n(byte[] bArr, int i10, int i11, int i12) {
        System.arraycopy(this.f13697b, H() + i10, bArr, i11, i12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p, kotlin.reflect.jvm.internal.impl.protobuf.d, java.lang.Iterable
    /* JADX INFO: renamed from: s */
    public d.a iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p, kotlin.reflect.jvm.internal.impl.protobuf.d
    public int size() {
        return this.f13628e;
    }

    c(byte[] bArr, int i10, int i11) {
        super(bArr);
        if (i10 >= 0) {
            if (i11 >= 0) {
                if (((long) i10) + ((long) i11) <= bArr.length) {
                    this.f13627d = i10;
                    this.f13628e = i11;
                    return;
                }
                StringBuilder sb2 = new StringBuilder(48);
                sb2.append("Offset+Length too large: ");
                sb2.append(i10);
                sb2.append("+");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder(29);
            sb3.append("Length too small: ");
            sb3.append(i10);
            throw new IllegalArgumentException(sb3.toString());
        }
        StringBuilder sb4 = new StringBuilder(29);
        sb4.append("Offset too small: ");
        sb4.append(i10);
        throw new IllegalArgumentException(sb4.toString());
    }
}
