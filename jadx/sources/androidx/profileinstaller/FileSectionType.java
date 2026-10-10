package androidx.profileinstaller;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);

    private final long mValue;

    public long getValue() {
        return this.mValue;
    }

    FileSectionType(long j10) {
        this.mValue = j10;
    }

    static FileSectionType fromValue(long j10) {
        FileSectionType[] fileSectionTypeArrValues = values();
        for (int i10 = 0; i10 < fileSectionTypeArrValues.length; i10++) {
            if (fileSectionTypeArrValues[i10].getValue() == j10) {
                return fileSectionTypeArrValues[i10];
            }
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + j10);
    }
}
