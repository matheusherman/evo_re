package v6;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public enum b {
    INDEX(0, "m3u8"),
    BLOCK(1, "ts"),
    SUBTITLE(2, "srt");

    private String extension;
    private short mediaType;

    public short f() {
        return this.mediaType;
    }

    b(short s10, String str) {
        this.mediaType = s10;
        this.extension = str;
    }

    public static b i(short s10) {
        for (b bVar : values()) {
            if (s10 == bVar.mediaType) {
                return bVar;
            }
        }
        return null;
    }

    public static b j(String str) {
        for (b bVar : values()) {
            if (str.equals(bVar.extension)) {
                return bVar;
            }
        }
        return null;
    }
}
