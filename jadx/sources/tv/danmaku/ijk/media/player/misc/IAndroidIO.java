package tv.danmaku.ijk.media.player.misc;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public interface IAndroidIO {
    int close();

    int open(String str);

    int read(byte[] bArr, int i10);

    long seek(long j10, int i10);
}
