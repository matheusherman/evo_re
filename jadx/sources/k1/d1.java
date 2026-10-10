package k1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f12001a = Collections.synchronizedMap(new ArrayMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12002b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Bundle f12003c;

    final void g(@Nullable Bundle bundle) {
        this.f12002b = 1;
        this.f12003c = bundle;
        for (Map.Entry entry : this.f12001a.entrySet()) {
            ((g) entry.getValue()).f(bundle != null ? bundle.getBundle((String) entry.getKey()) : null);
        }
    }

    final void h() {
        this.f12002b = 5;
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).g();
        }
    }

    final void i() {
        this.f12002b = 3;
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).h();
        }
    }

    final void k() {
        this.f12002b = 2;
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).j();
        }
    }

    final void l() {
        this.f12002b = 4;
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).k();
        }
    }

    @Nullable
    final g c(String str, Class cls) {
        return (g) cls.cast(this.f12001a.get(str));
    }

    final void d(String str, g gVar) {
        if (this.f12001a.containsKey(str)) {
            throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
        }
        this.f12001a.put(str, gVar);
        if (this.f12002b > 0) {
            new y1.f(Looper.getMainLooper()).post(new c1(this, gVar, str));
        }
    }

    final void e(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(str, fileDescriptor, printWriter, strArr);
        }
    }

    final void f(int i10, int i11, @Nullable Intent intent) {
        Iterator it = this.f12001a.values().iterator();
        while (it.hasNext()) {
            ((g) it.next()).e(i10, i11, intent);
        }
    }

    final void j(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (Map.Entry entry : this.f12001a.entrySet()) {
            Bundle bundle2 = new Bundle();
            ((g) entry.getValue()).i(bundle2);
            bundle.putBundle((String) entry.getKey(), bundle2);
        }
    }

    d1() {
    }
}
