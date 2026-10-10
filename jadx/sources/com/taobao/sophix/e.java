package com.taobao.sophix;

import android.os.Build;
import android.util.Base64;
import android.util.Pair;
import dalvik.system.ZipPathValidator;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class e {
    public static boolean a(String str, String str2, String str3, String str4) throws Throwable {
        File fileA;
        File file = new File(str);
        File file2 = new File(str2);
        Pair<String, String> pairB = b(str3, str4);
        if (pairB == null) {
            return false;
        }
        String str5 = (String) pairB.first;
        String str6 = (String) pairB.second;
        File fileC = c(file.getAbsolutePath(), file.getParent());
        if (fileC == null || (fileA = a(fileC, str5, str6)) == null) {
            return false;
        }
        return fileA.renameTo(file2);
    }

    private static Pair<String, String> b(String str, String str2) {
        byte[] bArrDoFinal;
        try {
            byte[] bArrDecode = Base64.decode(str, 0);
            PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str2, 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, privateKeyGeneratePrivate);
            bArrDoFinal = cipher.doFinal(bArrDecode);
        } catch (Exception e10) {
            s.a("DecryptUtils", "decryptFileToken", e10, new Object[0]);
            bArrDoFinal = null;
        }
        if (bArrDoFinal != null) {
            try {
                String[] strArrSplit = new String(bArrDoFinal, "utf-8").split("\\|");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    return new Pair<>(strArrSplit[0], strArrSplit[1]);
                }
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    private static File c(String str, String str2) throws Throwable {
        ZipInputStream zipInputStream;
        File file;
        FileOutputStream fileOutputStream;
        File file2 = null;
        ZipInputStream zipInputStream2 = null;
        try {
            file = new File(str);
            try {
                if (!file.exists()) {
                    s.b("DecryptUtils", "unZipSingleFile file don't exist", new Object[0]);
                    i.a((Closeable) null);
                    file.delete();
                    return null;
                }
                String str3 = str2 + File.separator + "unzip";
                File file3 = new File(str3);
                i.a(file3);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                if (Build.VERSION.SDK_INT >= 34) {
                    ZipPathValidator.clearCallback();
                }
                zipInputStream = new ZipInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            i.a(zipInputStream);
                            file.delete();
                            break;
                        }
                        String name = nextEntry.getName();
                        if (name.contains("../")) {
                            throw new w(11, "entry contains unsafe chars");
                        }
                        if (nextEntry.isDirectory()) {
                            new File(str3 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                        } else {
                            File file4 = new File(str3 + File.separator + name);
                            file4.createNewFile();
                            try {
                                fileOutputStream = new FileOutputStream(file4);
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i10 = zipInputStream.read(bArr);
                                        if (i10 == -1) {
                                            i.a(fileOutputStream);
                                            i.a(zipInputStream);
                                            file.delete();
                                            return file4;
                                        }
                                        fileOutputStream.write(bArr, 0, i10);
                                        fileOutputStream.flush();
                                        th = th;
                                        i.a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    try {
                                        s.b("DecryptUtils", "unZipSingleFile unZip hotfix patch file error", e, new Object[0]);
                                        i.a(fileOutputStream);
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        }
                    } catch (Exception e12) {
                        e = e12;
                        try {
                            s.b("DecryptUtils", "unZipSingleFile unZip hotfix patch file error", e, new Object[0]);
                            i.a(zipInputStream);
                            file.delete();
                        } catch (Throwable th3) {
                            th = th3;
                            file2 = file;
                            file = file2;
                            zipInputStream2 = zipInputStream;
                            i.a(zipInputStream2);
                            file.delete();
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream2 = zipInputStream;
                        i.a(zipInputStream2);
                        file.delete();
                        throw th;
                    }
                }
                return null;
            } catch (Exception e13) {
                e = e13;
                zipInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                i.a(zipInputStream2);
                file.delete();
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            zipInputStream = null;
            file = null;
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
            file = file2;
            zipInputStream2 = zipInputStream;
            i.a(zipInputStream2);
            file.delete();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0089 A[Catch: all -> 0x004e, TRY_LEAVE, TryCatch #4 {all -> 0x004e, blocks: (B:8:0x0041, B:9:0x0043, B:11:0x004a, B:37:0x007e, B:39:0x0089), top: B:47:0x0041 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x009b A[RETURN] */
    private static File a(File file, String str, String str2) throws Throwable {
        FileInputStream fileInputStream;
        CipherInputStream cipherInputStream;
        Exception e10;
        File fileCreateTempFile;
        FileOutputStream fileOutputStream;
        boolean z10 = false;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileCreateTempFile = File.createTempFile(file.getName(), ".decrypt", file.getParentFile());
                try {
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(str2.getBytes("UTF-8"));
                    SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes("UTF-8"), "AES");
                    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7PADDING");
                    cipher.init(2, secretKeySpec, ivParameterSpec);
                    fileInputStream = new FileInputStream(file);
                    try {
                        cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                        try {
                            fileOutputStream = new FileOutputStream(fileCreateTempFile);
                            try {
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i10 = cipherInputStream.read(bArr);
                                        if (i10 == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, i10);
                                    }
                                    i.a(fileInputStream);
                                    i.a(cipherInputStream);
                                    i.a(fileOutputStream);
                                    z10 = true;
                                } catch (Exception e11) {
                                    e10 = e11;
                                    s.b("DecryptUtils", "decryptByPair decrypt hotfix patch file error", e10, new Object[0]);
                                    if (fileCreateTempFile != null) {
                                        fileCreateTempFile.delete();
                                    }
                                    i.a(fileInputStream);
                                    i.a(cipherInputStream);
                                    i.a(fileOutputStream);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream2 = fileOutputStream;
                                i.a(fileInputStream);
                                i.a(cipherInputStream);
                                i.a(fileOutputStream2);
                                throw th;
                            }
                        } catch (Exception e12) {
                            e10 = e12;
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            i.a(fileInputStream);
                            i.a(cipherInputStream);
                            i.a(fileOutputStream2);
                            throw th;
                        }
                    } catch (Exception e13) {
                        e10 = e13;
                        fileOutputStream = null;
                        cipherInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        cipherInputStream = null;
                    }
                } catch (Exception e14) {
                    e10 = e14;
                    fileOutputStream = null;
                    fileInputStream = null;
                    cipherInputStream = null;
                    s.b("DecryptUtils", "decryptByPair decrypt hotfix patch file error", e10, new Object[0]);
                    if (fileCreateTempFile != null) {
                        fileCreateTempFile.delete();
                    }
                    i.a(fileInputStream);
                    i.a(cipherInputStream);
                    i.a(fileOutputStream);
                    if (z10) {
                        return null;
                    }
                    file.delete();
                    return fileCreateTempFile;
                }
            } catch (Exception e15) {
                e10 = e15;
                fileCreateTempFile = null;
            }
            if (z10) {
                return null;
            }
            file.delete();
            return fileCreateTempFile;
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            cipherInputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static boolean a(String str, String str2) throws Throwable {
        Exception e10;
        File fileCreateTempFile;
        FileOutputStream fileOutputStream;
        CipherInputStream cipherInputStream;
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        fileOutputStream = null;
        FileOutputStream fileOutputStream2 = null;
        fileInputStream2 = null;
        try {
            try {
                fileCreateTempFile = File.createTempFile(file.getName(), ".ldecrypt", file.getParentFile());
                try {
                    Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                    cipher.init(2, new SecretKeySpec(str2.getBytes("UTF-8"), "AES"), new SecureRandom());
                    fileInputStream = new FileInputStream(file);
                    try {
                        cipherInputStream = new CipherInputStream(fileInputStream, cipher);
                        try {
                            fileOutputStream = new FileOutputStream(fileCreateTempFile);
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i10 = cipherInputStream.read(bArr);
                                    if (i10 != -1) {
                                        fileOutputStream.write(bArr, 0, i10);
                                    } else {
                                        boolean zRenameTo = fileCreateTempFile.renameTo(file);
                                        i.a(fileInputStream);
                                        i.a(cipherInputStream);
                                        i.a(fileOutputStream);
                                        return zRenameTo;
                                    }
                                }
                            } catch (Exception e11) {
                                e10 = e11;
                                fileInputStream2 = fileInputStream;
                                if (fileCreateTempFile != null) {
                                    try {
                                        fileCreateTempFile.delete();
                                    } catch (Throwable th) {
                                        th = th;
                                        fileInputStream = fileInputStream2;
                                        fileOutputStream2 = fileOutputStream;
                                        i.a(fileInputStream);
                                        i.a(cipherInputStream);
                                        i.a(fileOutputStream2);
                                        throw th;
                                    }
                                }
                                s.a("DecryptUtils", "aesDecrypt", e10, new Object[0]);
                                i.a(fileInputStream2);
                                i.a(cipherInputStream);
                                i.a(fileOutputStream);
                                return false;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream2 = fileOutputStream;
                                i.a(fileInputStream);
                                i.a(cipherInputStream);
                                i.a(fileOutputStream2);
                                throw th;
                            }
                        } catch (Exception e12) {
                            e10 = e12;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            i.a(fileInputStream);
                            i.a(cipherInputStream);
                            i.a(fileOutputStream2);
                            throw th;
                        }
                    } catch (Exception e13) {
                        e10 = e13;
                        fileOutputStream = null;
                        cipherInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        cipherInputStream = null;
                    }
                } catch (Exception e14) {
                    e10 = e14;
                    fileOutputStream = null;
                    cipherInputStream = null;
                    if (fileCreateTempFile != null) {
                        fileCreateTempFile.delete();
                    }
                    s.a("DecryptUtils", "aesDecrypt", e10, new Object[0]);
                    i.a(fileInputStream2);
                    i.a(cipherInputStream);
                    i.a(fileOutputStream);
                    return false;
                }
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = null;
                cipherInputStream = null;
                fileInputStream = fileInputStream2;
                fileOutputStream2 = fileOutputStream;
                i.a(fileInputStream);
                i.a(cipherInputStream);
                i.a(fileOutputStream2);
                throw th;
            }
        } catch (Exception e15) {
            e10 = e15;
            fileCreateTempFile = null;
        }
    }
}
