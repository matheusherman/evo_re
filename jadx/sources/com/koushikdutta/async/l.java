package com.koushikdutta.async;

import android.annotation.TargetApi;
import android.os.Looper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@TargetApi(9)
public class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static PriorityQueue<ByteBuffer> f5113d = new PriorityQueue<>(8, new a());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f5114e = 1048576;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f5115f = 262144;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f5116g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static int f5117h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f5118i = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ByteBuffer f5119j = ByteBuffer.allocate(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    u4.b<ByteBuffer> f5120a = new u4.b<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ByteOrder f5121b = ByteOrder.BIG_ENDIAN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5122c = 0;

    public l() {
    }

    public void D() {
        v(0);
    }

    public l b(ByteBuffer... byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            a(byteBuffer);
        }
        return this;
    }

    public byte e() {
        byte b10 = v(1).get();
        this.f5122c--;
        return b10;
    }

    public void h(byte[] bArr) {
        i(bArr, 0, bArr.length);
    }

    public char k() {
        char c10 = (char) v(1).get();
        this.f5122c--;
        return c10;
    }

    public int l() {
        int i10 = v(4).getInt();
        this.f5122c -= 4;
        return i10;
    }

    public short o() {
        short s10 = v(2).getShort();
        this.f5122c -= 2;
        return s10;
    }

    public String t() {
        return u(null);
    }

    public String w() {
        return x(null);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements Comparator<ByteBuffer> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
            if (byteBuffer.capacity() == byteBuffer2.capacity()) {
                return 0;
            }
            if (byteBuffer.capacity() > byteBuffer2.capacity()) {
                return 1;
            }
            return -1;
        }
    }

    public static ByteBuffer r(int i10) {
        PriorityQueue<ByteBuffer> priorityQueueN;
        ByteBuffer byteBufferRemove;
        if (i10 <= f5117h && (priorityQueueN = n()) != null) {
            synchronized (f5118i) {
                do {
                    try {
                        if (priorityQueueN.size() > 0) {
                            byteBufferRemove = priorityQueueN.remove();
                            if (priorityQueueN.size() == 0) {
                                f5117h = 0;
                            }
                            f5116g -= byteBufferRemove.capacity();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } while (byteBufferRemove.capacity() < i10);
                return byteBufferRemove;
            }
        }
        return ByteBuffer.allocate(Math.max(8192, i10));
    }

    public static void y(ByteBuffer byteBuffer) {
        PriorityQueue<ByteBuffer> priorityQueueN;
        if (byteBuffer == null || byteBuffer.isDirect() || byteBuffer.arrayOffset() != 0 || byteBuffer.array().length != byteBuffer.capacity() || byteBuffer.capacity() < 8192 || byteBuffer.capacity() > f5115f || (priorityQueueN = n()) == null) {
            return;
        }
        synchronized (f5118i) {
            while (f5116g > f5114e && priorityQueueN.size() > 0 && priorityQueueN.peek().capacity() < byteBuffer.capacity()) {
                try {
                    f5116g -= priorityQueueN.remove().capacity();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (f5116g > f5114e) {
                return;
            }
            byteBuffer.position(0);
            byteBuffer.limit(byteBuffer.capacity());
            f5116g += byteBuffer.capacity();
            priorityQueueN.add(byteBuffer);
            f5117h = Math.max(f5117h, byteBuffer.capacity());
        }
    }

    public int A() {
        return this.f5122c;
    }

    public ByteBuffer B() {
        ByteBuffer byteBufferRemove = this.f5120a.remove();
        this.f5122c -= byteBufferRemove.remaining();
        return byteBufferRemove;
    }

    public int C() {
        return this.f5120a.size();
    }

    public ByteBuffer[] j() {
        ByteBuffer[] byteBufferArr = (ByteBuffer[]) this.f5120a.toArray(new ByteBuffer[this.f5120a.size()]);
        this.f5120a.clear();
        this.f5122c = 0;
        return byteBufferArr;
    }

    public long m() {
        long j10 = v(8).getLong();
        this.f5122c -= 8;
        return j10;
    }

    public boolean q() {
        return this.f5122c == 0;
    }

    public l s(ByteOrder byteOrder) {
        this.f5121b = byteOrder;
        return this;
    }

    public String u(Charset charset) {
        byte[] bArrArray;
        int iRemaining;
        int i10;
        if (charset == null) {
            charset = u4.c.f19354b;
        }
        StringBuilder sb2 = new StringBuilder();
        for (ByteBuffer byteBuffer : this.f5120a) {
            if (byteBuffer.isDirect()) {
                bArrArray = new byte[byteBuffer.remaining()];
                iRemaining = byteBuffer.remaining();
                byteBuffer.get(bArrArray);
                i10 = 0;
            } else {
                bArrArray = byteBuffer.array();
                int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                iRemaining = byteBuffer.remaining();
                i10 = iArrayOffset;
            }
            sb2.append(new String(bArrArray, i10, iRemaining, charset));
        }
        return sb2.toString();
    }

    public void z() {
        while (this.f5120a.size() > 0) {
            y(this.f5120a.remove());
        }
        this.f5122c = 0;
    }

    private void d(int i10) {
        if (A() >= 0) {
            this.f5122c += i10;
        }
    }

    private static PriorityQueue<ByteBuffer> n() {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null && Thread.currentThread() == mainLooper.getThread()) {
            return null;
        }
        return f5113d;
    }

    private ByteBuffer v(int i10) {
        ByteBuffer byteBufferRemove;
        if (A() >= i10) {
            ByteBuffer byteBufferPeek = this.f5120a.peek();
            while (byteBufferPeek != null && !byteBufferPeek.hasRemaining()) {
                y(this.f5120a.remove());
                byteBufferPeek = this.f5120a.peek();
            }
            if (byteBufferPeek == null) {
                return f5119j;
            }
            if (byteBufferPeek.remaining() >= i10) {
                return byteBufferPeek.order(this.f5121b);
            }
            ByteBuffer byteBufferR = r(i10);
            byteBufferR.limit(i10);
            byte[] bArrArray = byteBufferR.array();
            int i11 = 0;
            loop1: while (true) {
                byteBufferRemove = null;
                do {
                    if (i11 >= i10) {
                        break loop1;
                    }
                    byteBufferRemove = this.f5120a.remove();
                    int iMin = Math.min(i10 - i11, byteBufferRemove.remaining());
                    byteBufferRemove.get(bArrArray, i11, iMin);
                    i11 += iMin;
                } while (byteBufferRemove.remaining() != 0);
                y(byteBufferRemove);
            }
            if (byteBufferRemove != null && byteBufferRemove.remaining() > 0) {
                this.f5120a.addFirst(byteBufferRemove);
            }
            this.f5120a.addFirst(byteBufferR);
            return byteBufferR.order(this.f5121b);
        }
        throw new IllegalArgumentException("count : " + A() + "/" + i10);
    }

    public l a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            y(byteBuffer);
            return this;
        }
        d(byteBuffer.remaining());
        if (this.f5120a.size() > 0) {
            ByteBuffer last = this.f5120a.getLast();
            if (last.capacity() - last.limit() >= byteBuffer.remaining()) {
                last.mark();
                last.position(last.limit());
                last.limit(last.capacity());
                last.put(byteBuffer);
                last.limit(last.position());
                last.reset();
                y(byteBuffer);
                D();
                return this;
            }
        }
        this.f5120a.add(byteBuffer);
        D();
        return this;
    }

    public void c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() <= 0) {
            y(byteBuffer);
            return;
        }
        d(byteBuffer.remaining());
        if (this.f5120a.size() > 0) {
            ByteBuffer first = this.f5120a.getFirst();
            if (first.position() >= byteBuffer.remaining()) {
                first.position(first.position() - byteBuffer.remaining());
                first.mark();
                first.put(byteBuffer);
                first.reset();
                y(byteBuffer);
                return;
            }
        }
        this.f5120a.addFirst(byteBuffer);
    }

    public void f(l lVar) {
        g(lVar, A());
    }

    public void g(l lVar, int i10) {
        if (A() >= i10) {
            int i11 = 0;
            while (i11 < i10) {
                ByteBuffer byteBufferRemove = this.f5120a.remove();
                int iRemaining = byteBufferRemove.remaining();
                if (iRemaining == 0) {
                    y(byteBufferRemove);
                } else {
                    int i12 = iRemaining + i11;
                    if (i12 > i10) {
                        int i13 = i10 - i11;
                        ByteBuffer byteBufferR = r(i13);
                        byteBufferR.limit(i13);
                        byteBufferRemove.get(byteBufferR.array(), 0, i13);
                        lVar.a(byteBufferR);
                        this.f5120a.addFirst(byteBufferRemove);
                        break;
                    }
                    lVar.a(byteBufferRemove);
                    i11 = i12;
                }
            }
            this.f5122c -= i10;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public void i(byte[] bArr, int i10, int i11) {
        if (A() >= i11) {
            int i12 = i11;
            while (i12 > 0) {
                ByteBuffer byteBufferPeek = this.f5120a.peek();
                int iMin = Math.min(byteBufferPeek.remaining(), i12);
                if (bArr != null) {
                    byteBufferPeek.get(bArr, i10, iMin);
                } else {
                    byteBufferPeek.position(byteBufferPeek.position() + iMin);
                }
                i12 -= iMin;
                i10 += iMin;
                if (byteBufferPeek.remaining() == 0) {
                    this.f5120a.remove();
                    y(byteBufferPeek);
                }
            }
            this.f5122c -= i11;
            return;
        }
        throw new IllegalArgumentException("length");
    }

    public boolean p() {
        if (A() > 0) {
            return true;
        }
        return false;
    }

    public String x(Charset charset) {
        String strU = u(charset);
        z();
        return strU;
    }

    public l(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
    }
}
