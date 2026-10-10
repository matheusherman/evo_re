package com.live.evo.util;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class r {
    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile() ? c(str) : b(str);
        }
        return false;
    }

    public static boolean b(String str) {
        String str2 = File.separator;
        if (!str.endsWith(str2)) {
            str = str + str2;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] fileArrListFiles = file.listFiles();
            boolean zB = true;
            for (int i10 = 0; i10 < fileArrListFiles.length; i10++) {
                if (!fileArrListFiles[i10].isFile()) {
                    if (fileArrListFiles[i10].isDirectory() && !(zB = b(fileArrListFiles[i10].getAbsolutePath()))) {
                        break;
                    }
                } else {
                    zB = c(fileArrListFiles[i10].getAbsolutePath());
                    if (!zB) {
                        break;
                    }
                }
            }
            if (zB && file.delete()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile() || !file.delete()) {
            return false;
        }
        return true;
    }
}
