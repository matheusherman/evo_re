package tb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0004¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\"\u001c\u0010\u0011\u001a\n \u000e*\u0004\u0018\u00010\r0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0017\u001a\u00020\u0014*\u00060\u0012j\u0002`\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Ljava/io/InputStream;", "Ltb/z;", "e", "(Ljava/io/InputStream;)Ltb/z;", "Ljava/net/Socket;", "Ltb/x;", "c", "(Ljava/net/Socket;)Ltb/x;", "f", "(Ljava/net/Socket;)Ltb/z;", "Ljava/io/File;", "d", "(Ljava/io/File;)Ltb/z;", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "a", "Ljava/util/logging/Logger;", "logger", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "", "b", "(Ljava/lang/AssertionError;)Z", "isAndroidGetsocknameError", "okio"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "okio/Okio")
final /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f19068a = Logger.getLogger("okio.Okio");

    public static final boolean b(AssertionError assertionError) {
        kotlin.jvm.internal.m.f(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null ? ua.n.O(message, "getsockname failed", false, 2, null) : false) {
                return true;
            }
        }
        return false;
    }

    public static final x c(Socket socket) throws IOException {
        kotlin.jvm.internal.m.f(socket, "<this>");
        y yVar = new y(socket);
        OutputStream outputStream = socket.getOutputStream();
        kotlin.jvm.internal.m.e(outputStream, "getOutputStream(...)");
        return yVar.z(new sink(outputStream, yVar));
    }

    public static final z d(File file) {
        kotlin.jvm.internal.m.f(file, "<this>");
        return new source(new FileInputStream(file), a0.f19021e);
    }

    public static final z e(InputStream inputStream) {
        kotlin.jvm.internal.m.f(inputStream, "<this>");
        return new source(inputStream, new a0());
    }

    public static final z f(Socket socket) throws IOException {
        kotlin.jvm.internal.m.f(socket, "<this>");
        y yVar = new y(socket);
        InputStream inputStream = socket.getInputStream();
        kotlin.jvm.internal.m.e(inputStream, "getInputStream(...)");
        return yVar.A(new source(inputStream, yVar));
    }
}
