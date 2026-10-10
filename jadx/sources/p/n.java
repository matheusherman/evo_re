package p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class n<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0.h<b<A>, B> f17195a;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a extends e0.h<b<A>, B> {
        a(long j10) {
            super(j10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // e0.h
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void j(@NonNull b<A> bVar, @Nullable B b10) {
            bVar.c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    @VisibleForTesting
    static final class b<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue<b<?>> f17197d = e0.l.f(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f17198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f17199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private A f17200c;

        static <A> b<A> a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f17197d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a10, i10, i11);
            return bVar;
        }

        private void b(A a10, int i10, int i11) {
            this.f17200c = a10;
            this.f17199b = i10;
            this.f17198a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f17197d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.f17199b == bVar.f17199b && this.f17198a == bVar.f17198a && this.f17200c.equals(bVar.f17200c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f17198a * 31) + this.f17199b) * 31) + this.f17200c.hashCode();
        }

        private b() {
        }
    }

    public n(long j10) {
        this.f17195a = new a(j10);
    }

    @Nullable
    public B a(A a10, int i10, int i11) {
        b<A> bVarA = b.a(a10, i10, i11);
        B bG = this.f17195a.g(bVarA);
        bVarA.c();
        return bG;
    }

    public void b(A a10, int i10, int i11, B b10) {
        this.f17195a.k(b.a(a10, i10, i11), b10);
    }
}
