package com.franmontiel.persistentcookiejar.persistence;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.m;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class SerializableCookie implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f1482b = "SerializableCookie";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f1483c = -1;
    private static final long serialVersionUID = -8594045714036645534L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient m f1484a;

    private static String a(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (i10 < 16) {
                sb2.append('0');
            }
            sb2.append(Integer.toHexString(i10));
        }
        return sb2.toString();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        m.a aVar = new m.a();
        aVar.g((String) objectInputStream.readObject());
        aVar.j((String) objectInputStream.readObject());
        long j10 = objectInputStream.readLong();
        if (j10 != f1483c) {
            aVar.d(j10);
        }
        String str = (String) objectInputStream.readObject();
        aVar.b(str);
        aVar.h((String) objectInputStream.readObject());
        if (objectInputStream.readBoolean()) {
            aVar.i();
        }
        if (objectInputStream.readBoolean()) {
            aVar.f();
        }
        if (objectInputStream.readBoolean()) {
            aVar.e(str);
        }
        this.f1484a = aVar.a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f1484a.getName());
        objectOutputStream.writeObject(this.f1484a.getValue());
        objectOutputStream.writeLong(this.f1484a.getPersistent() ? this.f1484a.getExpiresAt() : f1483c);
        objectOutputStream.writeObject(this.f1484a.getDomain());
        objectOutputStream.writeObject(this.f1484a.getPath());
        objectOutputStream.writeBoolean(this.f1484a.getSecure());
        objectOutputStream.writeBoolean(this.f1484a.getHttpOnly());
        objectOutputStream.writeBoolean(this.f1484a.getHostOnly());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public m b(String str) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(d(str));
        m mVar = null;
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    mVar = ((SerializableCookie) objectInputStream.readObject()).f1484a;
                } catch (IOException e10) {
                    e = e10;
                    Log.d(f1482b, "IOException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    return mVar;
                } catch (ClassNotFoundException e11) {
                    e = e11;
                    Log.d(f1482b, "ClassNotFoundException in decodeCookie", e);
                    if (objectInputStream != null) {
                    }
                    return mVar;
                }
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e12) {
                        Log.d(f1482b, "Stream not closed in decodeCookie", e12);
                    }
                }
                throw th;
            }
        } catch (IOException e13) {
            e = e13;
            objectInputStream = null;
        } catch (ClassNotFoundException e14) {
            e = e14;
            objectInputStream = null;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
        try {
            objectInputStream.close();
        } catch (IOException e15) {
            Log.d(f1482b, "Stream not closed in decodeCookie", e15);
        }
        return mVar;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public String c(m mVar) throws Throwable {
        ObjectOutputStream objectOutputStream;
        this.f1484a = mVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                try {
                    objectOutputStream.writeObject(this);
                    try {
                        objectOutputStream.close();
                    } catch (IOException e10) {
                        Log.d(f1482b, "Stream not closed in encodeCookie", e10);
                    }
                    return a(byteArrayOutputStream.toByteArray());
                } catch (IOException e11) {
                    e = e11;
                    Log.d(f1482b, "IOException in encodeCookie", e);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e12) {
                            Log.d(f1482b, "Stream not closed in encodeCookie", e12);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                objectOutputStream2 = objectOutputStream;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e13) {
                        Log.d(f1482b, "Stream not closed in encodeCookie", e13);
                    }
                }
                throw th;
            }
        } catch (IOException e14) {
            e = e14;
            objectOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (objectOutputStream2 != null) {
                objectOutputStream2.close();
            }
            throw th;
        }
    }

    private static byte[] d(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i10 = 0; i10 < length; i10 += 2) {
            bArr[i10 / 2] = (byte) ((Character.digit(str.charAt(i10), 16) << 4) + Character.digit(str.charAt(i10 + 1), 16));
        }
        return bArr;
    }
}
