package m7;

import android.text.TextUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class a {
    public static void a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.exists()) {
                f.h("FileUtils", "path exists", str);
            } else {
                f.h("FileUtils", "mkdirs path", str, "created", Boolean.valueOf(file.mkdirs()));
            }
        } catch (Exception e10) {
            f.g("FileUtils", e10, new Object[0]);
        }
    }

    public static boolean b(String str, String str2) throws Throwable {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                fileWriter = new FileWriter(new File(str));
                try {
                    BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter);
                    try {
                        bufferedWriter2.write(str2);
                        bufferedWriter2.flush();
                        try {
                            bufferedWriter2.close();
                        } catch (Exception e10) {
                            f.g("FileUtils", e10, new Object[0]);
                        }
                        try {
                            fileWriter.close();
                            return true;
                        } catch (Exception e11) {
                            f.g("FileUtils", e11, new Object[0]);
                            return true;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        bufferedWriter = bufferedWriter2;
                        f.g("FileUtils", e, new Object[0]);
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e13) {
                                f.g("FileUtils", e13, new Object[0]);
                            }
                        }
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (Exception e14) {
                                f.g("FileUtils", e14, new Object[0]);
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        bufferedWriter = bufferedWriter2;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (Exception e15) {
                                f.g("FileUtils", e15, new Object[0]);
                            }
                        }
                        if (fileWriter == null) {
                            throw th;
                        }
                        try {
                            fileWriter.close();
                            throw th;
                        } catch (Exception e16) {
                            f.g("FileUtils", e16, new Object[0]);
                            throw th;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e18) {
            e = e18;
            fileWriter = null;
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
        }
    }

    public static String c(String str) throws Throwable {
        InputStreamReader inputStreamReader = null;
        try {
            try {
                InputStreamReader inputStreamReader2 = new InputStreamReader(new FileInputStream(str));
                try {
                    char[] cArr = new char[100];
                    StringBuilder sb2 = new StringBuilder("");
                    while (true) {
                        int i10 = inputStreamReader2.read(cArr);
                        if (i10 == -1) {
                            String string = sb2.toString();
                            try {
                                inputStreamReader2.close();
                                return string;
                            } catch (Exception e10) {
                                f.g("FileUtils", e10, new Object[0]);
                                return string;
                            }
                        }
                        sb2.append(cArr, 0, i10);
                    }
                } catch (Exception e11) {
                    e = e11;
                    inputStreamReader = inputStreamReader2;
                    f.g("FileUtils", e, new Object[0]);
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e12) {
                            f.g("FileUtils", e12, new Object[0]);
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader = inputStreamReader2;
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (Exception e13) {
                            f.g("FileUtils", e13, new Object[0]);
                        }
                    }
                    throw th;
                }
            } catch (Exception e14) {
                e = e14;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
