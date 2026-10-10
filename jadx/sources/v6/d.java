package v6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum d {
    UDP(0),
    GOP(1),
    TS(2);

    private int value;

    d(int i10) {
        this.value = i10;
    }

    public static d f(int i10) {
        for (d dVar : values()) {
            if (i10 == dVar.value) {
                return dVar;
            }
        }
        return null;
    }
}
