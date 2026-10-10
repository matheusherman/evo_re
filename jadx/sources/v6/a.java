package v6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum a {
    TV(0),
    MOBILE(1);

    private int value;

    public int f() {
        return this.value;
    }

    a(int i10) {
        this.value = i10;
    }

    public static a i(int i10) {
        for (a aVar : values()) {
            if (i10 == aVar.value) {
                return aVar;
            }
        }
        return null;
    }
}
