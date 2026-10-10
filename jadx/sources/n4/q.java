package n4;

import android.graphics.Rect;
import android.util.Log;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public abstract class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15946a = "q";

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements Comparator<m4.p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m4.p f15947a;

        a(m4.p pVar) {
            this.f15947a = pVar;
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(m4.p pVar, m4.p pVar2) {
            return Float.compare(q.this.c(pVar2, this.f15947a), q.this.c(pVar, this.f15947a));
        }
    }

    protected abstract float c(m4.p pVar, m4.p pVar2);

    public abstract Rect d(m4.p pVar, m4.p pVar2);

    public List<m4.p> a(List<m4.p> list, m4.p pVar) {
        if (pVar == null) {
            return list;
        }
        Collections.sort(list, new a(pVar));
        return list;
    }

    public m4.p b(List<m4.p> list, m4.p pVar) {
        List<m4.p> listA = a(list, pVar);
        String str = f15946a;
        Log.i(str, "Viewfinder size: " + pVar);
        Log.i(str, "Preview in order of preference: " + listA);
        return listA.get(0);
    }
}
