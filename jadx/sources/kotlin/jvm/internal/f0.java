package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Object> f12339a;

    public void a(Object obj) {
        this.f12339a.add(obj);
    }

    public void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f12339a;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f12339a, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f12339a.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f12339a.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f12339a.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    public int c() {
        return this.f12339a.size();
    }

    public Object[] d(Object[] objArr) {
        return this.f12339a.toArray(objArr);
    }

    public f0(int i10) {
        this.f12339a = new ArrayList<>(i10);
    }
}
