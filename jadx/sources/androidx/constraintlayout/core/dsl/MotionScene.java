package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class MotionScene {
    ArrayList<Transition> mTransitions = new ArrayList<>();
    ArrayList<ConstraintSet> mConstraintSets = new ArrayList<>();

    public void addConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSets.add(constraintSet);
    }

    public void addTransition(Transition transition) {
        this.mTransitions.add(transition);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("{\n");
        if (!this.mTransitions.isEmpty()) {
            sb2.append("Transitions:{\n");
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                sb2.append(it.next().toString());
            }
            sb2.append("},\n");
        }
        if (!this.mConstraintSets.isEmpty()) {
            sb2.append("ConstraintSets:{\n");
            Iterator<ConstraintSet> it2 = this.mConstraintSets.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next().toString());
            }
            sb2.append("},\n");
        }
        sb2.append("}\n");
        return sb2.toString();
    }
}
