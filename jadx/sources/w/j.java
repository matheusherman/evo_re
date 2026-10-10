package w;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import j.k;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import l.v;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class j implements k<InputStream, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f20046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k<ByteBuffer, c> f20047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final m.b f20048c;

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            return null;
        }
    }

    @Override // j.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull j.i iVar) {
        return !((Boolean) iVar.c(i.f20045b)).booleanValue() && com.bumptech.glide.load.a.f(this.f20046a, inputStream, this.f20048c) == ImageHeaderParser.ImageType.GIF;
    }

    public j(List<ImageHeaderParser> list, k<ByteBuffer, c> kVar, m.b bVar) {
        this.f20046a = list;
        this.f20047b = kVar;
        this.f20048c = bVar;
    }

    @Override // j.k
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<c> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull j.i iVar) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f20047b.b(ByteBuffer.wrap(bArrE), i10, i11, iVar);
    }
}
