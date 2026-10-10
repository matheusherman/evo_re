package tc;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class f extends Permission {
    private final Set<String> actions;

    public boolean equals(Object obj) {
        return (obj instanceof f) && this.actions.equals(((f) obj).actions);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.actions.toString();
    }

    public int hashCode() {
        return this.actions.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof f)) {
            return false;
        }
        f fVar = (f) permission;
        return getName().equals(fVar.getName()) || this.actions.containsAll(fVar.actions);
    }

    public f(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.actions = hashSet;
        hashSet.add(str);
    }
}
