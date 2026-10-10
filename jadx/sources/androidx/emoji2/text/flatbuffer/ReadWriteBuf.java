package androidx.emoji2.text.flatbuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b10);

    void put(byte[] bArr, int i10, int i11);

    void putBoolean(boolean z10);

    void putDouble(double d10);

    void putFloat(float f10);

    void putInt(int i10);

    void putLong(long j10);

    void putShort(short s10);

    boolean requestCapacity(int i10);

    void set(int i10, byte b10);

    void set(int i10, byte[] bArr, int i11, int i12);

    void setBoolean(int i10, boolean z10);

    void setDouble(int i10, double d10);

    void setFloat(int i10, float f10);

    void setInt(int i10, int i11);

    void setLong(int i10, long j10);

    void setShort(int i10, short s10);

    int writePosition();
}
