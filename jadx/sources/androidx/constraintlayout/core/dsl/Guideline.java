package androidx.constraintlayout.core.dsl;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public abstract class Guideline extends Helper {
    private int mEnd;
    private float mPercent;
    private int mStart;

    Guideline(String str) {
        super(str, new Helper.HelperType(""));
        this.mStart = Integer.MIN_VALUE;
        this.mEnd = Integer.MIN_VALUE;
        this.mPercent = Float.NaN;
    }

    public int getEnd() {
        return this.mEnd;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStart() {
        return this.mStart;
    }

    public void setEnd(int i10) {
        this.mEnd = i10;
        this.configMap.put("end", String.valueOf(i10));
    }

    public void setPercent(float f10) {
        this.mPercent = f10;
        this.configMap.put("percent", String.valueOf(f10));
    }

    public void setStart(int i10) {
        this.mStart = i10;
        this.configMap.put("start", String.valueOf(i10));
    }
}
