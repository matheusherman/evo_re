package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class ConstraintSet {
    ArrayList<Constraint> mConstraints = new ArrayList<>();
    ArrayList<Helper> mHelpers = new ArrayList<>();
    private final String mName;

    public void add(Constraint constraint) {
        this.mConstraints.add(constraint);
    }

    public void add(Helper helper) {
        this.mHelpers.add(helper);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.mName + ":{\n");
        if (!this.mConstraints.isEmpty()) {
            Iterator<Constraint> it = this.mConstraints.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
            }
        }
        if (!this.mHelpers.isEmpty()) {
            Iterator<Helper> it2 = this.mHelpers.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next().toString());
            }
        }
        sb2.append("},\n");
        return sb2.toString();
    }

    public ConstraintSet(String str) {
        this.mName = str;
    }
}
