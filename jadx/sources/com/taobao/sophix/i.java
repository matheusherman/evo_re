package com.taobao.sophix;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class i {
    public static File a(File file, String str) {
        File file2 = new File(file, str);
        if (!file2.exists() && !file2.mkdirs()) {
            s.e("FileUtils", "ensureDirCreated", "fail to mkdirs", file2.getAbsolutePath());
        }
        return file2;
    }

    public static void a(File file, File file2) throws Throwable {
        Throwable th;
        FileChannel channel;
        IOException iOException;
        FileChannel channel2;
        FileChannel fileChannel = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            channel = new FileInputStream(file).getChannel();
            try {
                channel2 = new FileOutputStream(file2).getChannel();
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    a(channel);
                    a(channel2);
                } catch (IOException e10) {
                    iOException = e10;
                    fileChannel = channel;
                    try {
                        throw iOException;
                    } catch (Throwable th2) {
                        th = th2;
                        channel = fileChannel;
                        fileChannel = channel2;
                        a(channel);
                        a(fileChannel);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = channel2;
                    a(channel);
                    a(fileChannel);
                    throw th;
                }
            } catch (IOException e11) {
                iOException = e11;
                channel2 = null;
            } catch (Throwable th4) {
                th = th4;
                a(channel);
                a(fileChannel);
                throw th;
            }
        } catch (IOException e12) {
            iOException = e12;
            channel2 = null;
        } catch (Throwable th5) {
            th = th5;
            channel = null;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4092];
        while (true) {
            int i10 = inputStream.read(bArr);
            if (i10 == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i10);
            }
        }
    }

    public static void a(File file) {
        a(file, (File[]) null);
    }

    public static void a(File file, File[] fileArr) {
        File[] fileArrListFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (fileArr == null || !Arrays.asList(fileArr).contains(file2)) {
                if (file2.isDirectory()) {
                    a(file2, fileArr);
                }
                file2.delete();
            }
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }
}
