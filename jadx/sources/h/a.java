package h;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public interface a {

    /* JADX INFO: renamed from: h.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface InterfaceC0185a {
        @NonNull
        Bitmap a(int i10, int i11, @NonNull Bitmap.Config config);

        @NonNull
        int[] b(int i10);

        void c(@NonNull Bitmap bitmap);

        void d(@NonNull byte[] bArr);

        @NonNull
        byte[] e(int i10);

        void f(@NonNull int[] iArr);
    }

    @Nullable
    Bitmap a();

    void b();

    int c();

    void clear();

    int d();

    void e(@NonNull Bitmap.Config config);

    void f();

    int g();

    @NonNull
    ByteBuffer getData();

    int h();
}
