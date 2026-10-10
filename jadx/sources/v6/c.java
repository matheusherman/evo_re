package v6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum c {
    VOD((byte) 0),
    LIVE((byte) 1),
    CATCHUP((byte) 2);

    private byte value;

    public byte f() {
        return this.value;
    }

    c(byte b10) {
        this.value = b10;
    }

    public static c i(byte b10) {
        for (c cVar : values()) {
            if (b10 == cVar.value) {
                return cVar;
            }
        }
        return null;
    }
}
