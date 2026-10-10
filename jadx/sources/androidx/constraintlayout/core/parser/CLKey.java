package androidx.constraintlayout.core.parser;

import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class CLKey extends CLContainer {
    private static ArrayList<String> sSections;

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sSections = arrayList;
        arrayList.add("ConstraintSets");
        sSections.add("Variables");
        sSections.add("Generate");
        sSections.add("Transitions");
        sSections.add("KeyFrames");
        sSections.add("KeyAttributes");
        sSections.add("KeyPositions");
        sSections.add("KeyCycles");
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0L);
        cLKey.setEnd(str.length() - 1);
        cLKey.set(cLElement);
        return cLKey;
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLKey) || Objects.equals(getName(), ((CLKey) obj).getName())) {
            return super.equals(obj);
        }
        return false;
    }

    public CLElement getValue() {
        if (this.mElements.size() > 0) {
            return this.mElements.get(0);
        }
        return null;
    }

    public void set(CLElement cLElement) {
        if (this.mElements.size() > 0) {
            this.mElements.set(0, cLElement);
        } else {
            this.mElements.add(cLElement);
        }
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder(getDebugName());
        addIndent(sb2, i10);
        String strContent = content();
        if (this.mElements.size() <= 0) {
            return strContent + ": <> ";
        }
        sb2.append(strContent);
        sb2.append(": ");
        if (sSections.contains(strContent)) {
            i11 = 3;
        }
        if (i11 > 0) {
            sb2.append(this.mElements.get(0).toFormattedJSON(i10, i11 - 1));
        } else {
            String json = this.mElements.get(0).toJSON();
            if (json.length() + i10 < CLElement.sMaxLine) {
                sb2.append(json);
            } else {
                sb2.append(this.mElements.get(0).toFormattedJSON(i10, i11 - 1));
            }
        }
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (this.mElements.size() <= 0) {
            return getDebugName() + content() + ": <> ";
        }
        return getDebugName() + content() + ": " + this.mElements.get(0).toJSON();
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public String getName() {
        return content();
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return super.hashCode();
    }
}
