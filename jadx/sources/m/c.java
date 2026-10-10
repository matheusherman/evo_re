package m;

import java.util.Queue;
import m.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
abstract class c<T extends m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue<T> f15426a = e0.l.f(20);

    abstract T a();

    T b() {
        T tPoll = this.f15426a.poll();
        return tPoll == null ? (T) a() : tPoll;
    }

    public void c(T t10) {
        if (this.f15426a.size() < 20) {
            this.f15426a.offer(t10);
        }
    }

    c() {
    }
}
