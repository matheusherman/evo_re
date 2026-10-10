package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class Ref {
    private String mId;
    private float mPostMargin;
    private float mPreMargin;
    private float mWeight;

    Ref(String str) {
        this.mWeight = Float.NaN;
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
    }

    public static void addStringToReferences(String str, ArrayList<Ref> arrayList) {
        Object obj;
        if (str == null || str.length() == 0) {
            return;
        }
        Object[] objArr = new Object[4];
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < str.length(); i12++) {
            char cCharAt = str.charAt(i12);
            if (cCharAt != ' ' && cCharAt != '\'') {
                if (cCharAt == ',') {
                    if (i10 < 3) {
                        objArr[i10] = sb2.toString();
                        sb2.setLength(0);
                        i10++;
                    }
                    if (i11 == 1 && (obj = objArr[0]) != null) {
                        arrayList.add(new Ref(obj.toString()));
                        objArr[0] = null;
                        i10 = 0;
                    }
                } else if (cCharAt == '[') {
                    i11++;
                } else if (cCharAt != ']') {
                    sb2.append(cCharAt);
                } else if (i11 > 0) {
                    i11--;
                    objArr[i10] = sb2.toString();
                    sb2.setLength(0);
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        arrayList.add(new Ref(obj2.toString(), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3])));
                        Arrays.fill(objArr, (Object) null);
                        i10 = 0;
                    }
                }
            }
        }
    }

    public static Ref parseStringToRef(String str) {
        String[] strArrSplit = str.replaceAll("[\\[\\]\\']", "").split(",");
        if (strArrSplit.length == 0) {
            return null;
        }
        Object[] objArr = new Object[4];
        for (int i10 = 0; i10 < strArrSplit.length && i10 < 4; i10++) {
            objArr[i10] = strArrSplit[i10];
        }
        return new Ref(objArr[0].toString().replace("'", ""), parseFloat(objArr[1]), parseFloat(objArr[2]), parseFloat(objArr[3]));
    }

    public String getId() {
        return this.mId;
    }

    public float getPostMargin() {
        return this.mPostMargin;
    }

    public float getPreMargin() {
        return this.mPreMargin;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setPostMargin(float f10) {
        this.mPostMargin = f10;
    }

    public void setPreMargin(float f10) {
        this.mPreMargin = f10;
    }

    public void setWeight(float f10) {
        this.mWeight = f10;
    }

    public String toString() {
        String str = this.mId;
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = (Float.isNaN(this.mWeight) && Float.isNaN(this.mPreMargin) && Float.isNaN(this.mPostMargin)) ? false : true;
        if (z10) {
            sb2.append("[");
        }
        sb2.append("'");
        sb2.append(this.mId);
        sb2.append("'");
        if (!Float.isNaN(this.mPostMargin)) {
            sb2.append(",");
            sb2.append(!Float.isNaN(this.mWeight) ? this.mWeight : 0.0f);
            sb2.append(",");
            sb2.append(Float.isNaN(this.mPreMargin) ? 0.0f : this.mPreMargin);
            sb2.append(",");
            sb2.append(this.mPostMargin);
        } else if (!Float.isNaN(this.mPreMargin)) {
            sb2.append(",");
            sb2.append(Float.isNaN(this.mWeight) ? 0.0f : this.mWeight);
            sb2.append(",");
            sb2.append(this.mPreMargin);
        } else if (!Float.isNaN(this.mWeight)) {
            sb2.append(",");
            sb2.append(this.mWeight);
        }
        if (z10) {
            sb2.append("]");
        }
        sb2.append(",");
        return sb2.toString();
    }

    public static float parseFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (Exception unused) {
            return Float.NaN;
        }
    }

    Ref(String str, float f10) {
        this.mPreMargin = Float.NaN;
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f10;
    }

    Ref(String str, float f10, float f11) {
        this.mPostMargin = Float.NaN;
        this.mId = str;
        this.mWeight = f10;
        this.mPreMargin = f11;
    }

    Ref(String str, float f10, float f11, float f12) {
        this.mId = str;
        this.mWeight = f10;
        this.mPreMargin = f11;
        this.mPostMargin = f12;
    }
}
