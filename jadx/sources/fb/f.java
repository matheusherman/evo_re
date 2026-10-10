package fb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f {
    public static Map<Integer, String> a() {
        try {
            BufferedReader bufferedReaderC = c("/r_values.ini");
            try {
                HashMap map = new HashMap();
                while (true) {
                    String line = bufferedReaderC.readLine();
                    if (line == null) {
                        bufferedReaderC.close();
                        return map;
                    }
                    String[] strArrSplit = line.trim().split("=");
                    if (strArrSplit.length == 2) {
                        map.put(Integer.valueOf(strArrSplit[1].trim()), strArrSplit[0].trim());
                    }
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (bufferedReaderC != null) {
                        try {
                            bufferedReaderC.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static Map<Integer, String> b() {
        HashMap map = new HashMap();
        try {
            BufferedReader bufferedReaderC = c("/r_styles.ini");
            while (true) {
                try {
                    String line = bufferedReaderC.readLine();
                    if (line == null) {
                        bufferedReaderC.close();
                        return map;
                    }
                    String[] strArrSplit = line.trim().split("=");
                    if (strArrSplit.length == 2) {
                        map.put(Integer.valueOf(strArrSplit[1].trim()), strArrSplit[0].trim());
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (bufferedReaderC != null) {
                            try {
                                bufferedReaderC.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                throw new RuntimeException(e);
            }
        } catch (IOException e10) {
            throw new RuntimeException(e10);
        }
    }

    private static BufferedReader c(String str) {
        return new BufferedReader(new InputStreamReader(f.class.getResourceAsStream(str)));
    }
}
