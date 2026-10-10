package l7;

import android.text.TextUtils;
import com.pengrad.telegrambot.request.ContentTypes;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static f f15223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f15224b;

    static {
        System.setProperty("http.keepAlive", "true");
        f15223a = null;
        f15224b = null;
    }

    /* JADX WARN: Code duplicated, block: B:165:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:? A[SYNTHETIC] */
    public static a a(String str, String str2, boolean z10) {
        DataOutputStream dataOutputStream;
        Throwable th;
        a aVar = new a();
        if (!TextUtils.isEmpty(str)) {
            try {
                URL url = new URL(str);
                if (!TextUtils.isEmpty(url.getHost())) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (f15223a == null) {
                            f15223a = new f(url.getHost());
                        }
                        if (f15224b == null) {
                            f15224b = new d(url.getHost());
                        }
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(f15223a);
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f15224b);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.setDoInput(true);
                        if (z10) {
                            httpURLConnection.setDoOutput(true);
                            try {
                                httpURLConnection.setRequestMethod(IMediaPlayer.DRM_REQ_POST);
                            } catch (ProtocolException e10) {
                                m7.f.d("", e10, new Object[0]);
                                return aVar;
                            }
                        } else {
                            try {
                                httpURLConnection.setRequestMethod(IMediaPlayer.DRM_REQ_GET);
                            } catch (ProtocolException e11) {
                                m7.f.d("", e11, new Object[0]);
                            }
                        }
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        httpURLConnection.setRequestProperty("Content-Type", ContentTypes.GENERAL_MIME_TYPE);
                        httpURLConnection.setRequestProperty("Charset", "UTF-8");
                        StringBuilder sb2 = new StringBuilder();
                        httpURLConnection.setRequestProperty("x-audid-appkey", "");
                        String packageName = j7.a.b().f().getPackageName();
                        if (!TextUtils.isEmpty(packageName)) {
                            try {
                                httpURLConnection.setRequestProperty("x-audid-appname", URLEncoder.encode(packageName, "UTF-8"));
                                sb2.append(packageName);
                            } catch (Exception unused) {
                            }
                        }
                        httpURLConnection.setRequestProperty("x-audid-sdk", "2.5.3-mini");
                        sb2.append("2.5.3-mini");
                        String strC = j7.a.b().c();
                        httpURLConnection.setRequestProperty("x-audid-timestamp", strC);
                        m7.f.e("", "timestamp:" + strC);
                        sb2.append(strC);
                        sb2.append(str2);
                        httpURLConnection.setRequestProperty("signature", n7.a.c(m7.b.e(sb2.toString()).getBytes(), 2));
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        DataOutputStream dataOutputStream2 = null;
                        DataInputStream dataInputStream = null;
                        DataInputStream dataInputStream2 = null;
                        try {
                            httpURLConnection.connect();
                            if (str2 == null || str2.length() <= 0) {
                                dataOutputStream = null;
                            } else {
                                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                try {
                                    dataOutputStream.writeBytes(str2);
                                    dataOutputStream.flush();
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataOutputStream2 = dataOutputStream;
                                    try {
                                        m7.f.e("", th);
                                        aVar.f15222e = System.currentTimeMillis() - jCurrentTimeMillis;
                                        if (dataOutputStream2 != null) {
                                            try {
                                            } catch (IOException e12) {
                                                m7.f.e("", e12);
                                            }
                                        }
                                    } finally {
                                        if (dataOutputStream2 != null) {
                                            try {
                                                dataOutputStream2.close();
                                            } catch (IOException e13) {
                                                m7.f.e("", e13);
                                            }
                                        }
                                    }
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (IOException e14) {
                                    m7.f.e("", e14);
                                }
                            }
                            try {
                                aVar.f15218a = httpURLConnection.getResponseCode();
                                aVar.f15220c = httpURLConnection.getHeaderField("signature");
                            } catch (Exception e15) {
                                m7.f.e("", e15);
                            }
                            try {
                                aVar.f15219b = Long.parseLong(httpURLConnection.getHeaderField("x-audid-timestamp"));
                                m7.f.e("", "repsonse.timestamp:" + aVar.f15219b);
                                long jA = j7.a.b().a();
                                long j10 = aVar.f15219b;
                                if (j10 > 0 && (j10 > jA + 1800000 || j10 < jA - 1800000)) {
                                    j7.a.b().d(aVar.f15219b);
                                }
                            } catch (Exception unused2) {
                            }
                            aVar.f15222e = System.currentTimeMillis() - jCurrentTimeMillis;
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                try {
                                    DataInputStream dataInputStream3 = new DataInputStream(httpURLConnection.getInputStream());
                                    try {
                                        try {
                                            byte[] bArr = new byte[2048];
                                            while (true) {
                                                int i10 = dataInputStream3.read(bArr, 0, 2048);
                                                if (i10 != -1) {
                                                    byteArrayOutputStream.write(bArr, 0, i10);
                                                } else {
                                                    try {
                                                        break;
                                                    } catch (Exception e16) {
                                                        m7.f.e("", e16);
                                                    }
                                                }
                                            }
                                            dataInputStream3.close();
                                        } catch (IOException e17) {
                                            e = e17;
                                            dataInputStream2 = dataInputStream3;
                                            m7.f.e("", e);
                                            try {
                                                dataInputStream3 = new DataInputStream(httpURLConnection.getErrorStream());
                                                try {
                                                    byte[] bArr2 = new byte[2048];
                                                    while (true) {
                                                        int i11 = dataInputStream3.read(bArr2, 0, 2048);
                                                        if (i11 != -1) {
                                                            byteArrayOutputStream.write(bArr2, 0, i11);
                                                        } else {
                                                            try {
                                                                break;
                                                            } catch (Exception e18) {
                                                                m7.f.e("", e18);
                                                            }
                                                        }
                                                    }
                                                    dataInputStream3.close();
                                                } catch (Exception e19) {
                                                    e = e19;
                                                    dataInputStream2 = dataInputStream3;
                                                    m7.f.e("", e);
                                                    if (dataInputStream2 != null) {
                                                        try {
                                                            dataInputStream2.close();
                                                        } catch (Exception e20) {
                                                            m7.f.e("", e20);
                                                        }
                                                    }
                                                }
                                            } catch (Exception e21) {
                                                e = e21;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        dataInputStream = dataInputStream3;
                                        if (dataInputStream != null) {
                                            throw th;
                                        }
                                        try {
                                            dataInputStream.close();
                                            throw th;
                                        } catch (Exception e22) {
                                            m7.f.e("", e22);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    if (dataInputStream != null) {
                                        throw th;
                                    }
                                    dataInputStream.close();
                                    throw th;
                                }
                            } catch (IOException e23) {
                                e = e23;
                            }
                            if (byteArrayOutputStream.size() > 0) {
                                aVar.f15221d = byteArrayOutputStream.toByteArray();
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                }
            } catch (MalformedURLException e24) {
                m7.f.d("", e24, new Object[0]);
                return aVar;
            } catch (IOException e25) {
                m7.f.d("", e25, new Object[0]);
                return aVar;
            } catch (Throwable th6) {
                m7.f.d("", th6, new Object[0]);
                return aVar;
            }
        }
        return aVar;
    }
}
