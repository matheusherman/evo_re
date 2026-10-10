package i7;

import ac.g;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import q6.b;
import q6.c;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f11237a = c.d(a.class);

    public static List<String> a(InputStream inputStream) {
        ArrayList arrayList = new ArrayList();
        Scanner scannerUseDelimiter = null;
        try {
            try {
                scannerUseDelimiter = new Scanner(inputStream, "UTF-8").useLocale(Locale.US).useDelimiter("\\r?\\n");
                while (scannerUseDelimiter.hasNext()) {
                    String next = scannerUseDelimiter.next();
                    if (!g.f(next) && next.startsWith("#EXTINF")) {
                        arrayList.add(scannerUseDelimiter.next().trim());
                    }
                }
                scannerUseDelimiter.close();
                return arrayList;
            } catch (Exception e10) {
                f11237a.error("Parse m3u8 error.[{}]", inputStream, e10);
                if (scannerUseDelimiter != null) {
                    scannerUseDelimiter.close();
                }
                return arrayList;
            }
        } catch (Throwable th) {
            if (scannerUseDelimiter != null) {
                scannerUseDelimiter.close();
            }
            throw th;
        }
    }
}
