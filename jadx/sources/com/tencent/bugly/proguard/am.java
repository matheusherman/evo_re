package com.tencent.bugly.proguard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class am {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class a implements FilenameFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8765b;

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str != null && str.startsWith(this.f8764a) && str.endsWith(this.f8765b);
        }

        a(String str, String str2) {
            this.f8764a = str;
            this.f8765b = str2;
        }
    }

    public static boolean a(File file, String str, long j10, boolean z10) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, z10));
            boolean zA = a(bufferedWriter, str.toCharArray(), str.length(), file.length(), j10);
            bufferedWriter.close();
            return zA;
        } catch (Throwable th) {
            al.a(th);
            return false;
        }
    }

    private static List<File> b(String str, String str2, String str3, long j10) {
        ArrayList arrayList = new ArrayList();
        if (str2 == null || str3 == null) {
            al.d("prefix %s and/or postfix %s is null.", str2, str3);
            return arrayList;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] fileArrListFiles = file.listFiles(new a(str2, str3));
                if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                    return a(fileArrListFiles, str2, str3, jCurrentTimeMillis - j10);
                }
            } catch (Throwable th) {
                al.a(th);
            }
        }
        return arrayList;
    }

    private static boolean a(Writer writer, char[] cArr, int i10, long j10, long j11) {
        if (j10 >= j11) {
            return false;
        }
        try {
            if (((long) (i10 * 2)) + j10 <= j11) {
                writer.write(cArr, 0, i10);
            } else {
                writer.write(cArr, 0, (int) ((j11 - j10) / 2));
            }
            writer.flush();
            return true;
        } catch (IOException e10) {
            al.a(e10);
            return false;
        }
    }

    public static void a(String str, String str2, String str3, long j10) {
        try {
            int i10 = 0;
            for (File file : b(str, str2, str3, j10)) {
                al.c("File %s is to be deleted.", file.getName());
                if (file.delete()) {
                    i10++;
                }
            }
            al.c("Number of overdue trace files that has deleted: ".concat(String.valueOf(i10)), new Object[0]);
        } catch (Throwable th) {
            al.a(th);
        }
    }

    private static List<File> a(File[] fileArr, String str, String str2, long j10) {
        ArrayList arrayList = new ArrayList();
        for (File file : fileArr) {
            long jA = a(file.getName(), str, str2);
            if (jA >= 0 && 0 <= jA && jA <= j10) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public static long a(String str, String str2, String str3) {
        if (str == null) {
            al.d("File name is null.", new Object[0]);
            return -1L;
        }
        try {
            if (str.startsWith(str2) && str.endsWith(str3)) {
                return Long.parseLong(str.substring(str2.length(), str.indexOf(str3)));
            }
        } catch (Throwable th) {
            al.a(th);
        }
        return -1L;
    }

    public static boolean a(String str, String str2, int i10) {
        boolean z10 = true;
        al.c("rqdp{  sv sd start} %s", str);
        if (str2 != null && str2.trim().length() > 0) {
            File file = new File(str);
            try {
                if (!file.exists()) {
                    if (file.getParentFile() != null) {
                        file.getParentFile().mkdirs();
                    }
                    file.createNewFile();
                }
                long j10 = i10;
                if (file.length() >= j10) {
                    z10 = false;
                }
                return a(file, str2, j10, z10);
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return false;
    }
}
