package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@WorkerThread
final class w5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f4137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f4138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v5 f4139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f4140d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f4141e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ s5 f4142f;

    public w5(s5 s5Var, String str, URL url, byte[] bArr, Map<String, String> map, v5 v5Var) {
        this.f4142f = s5Var;
        m1.g.e(str);
        m1.g.k(url);
        m1.g.k(v5Var);
        this.f4137a = url;
        this.f4138b = bArr;
        this.f4139c = v5Var;
        this.f4140d = str;
        this.f4141e = map;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0118  */
    /* JADX WARN: Code duplicated, block: B:64:0x014d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0133 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x00fe A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v6 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        IOException iOException;
        Map<String, List<String>> map;
        OutputStream outputStream2;
        ?? r13;
        int i10;
        int responseCode;
        this.f4142f.k();
        OutputStream outputStream3 = null;
        try {
            URLConnection uRLConnectionB = com.google.android.gms.internal.measurement.e2.a().b(this.f4137a, "client-measurement");
            if (!(uRLConnectionB instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionB;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                Map<String, String> map2 = this.f4141e;
                if (map2 != null) {
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (this.f4138b != null) {
                    byte[] bArrI0 = this.f4142f.o().i0(this.f4138b);
                    this.f4142f.l().L().b("Uploading data. size", Integer.valueOf(bArrI0.length));
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnection.setFixedLengthStreamingMode(bArrI0.length);
                    httpURLConnection.connect();
                    outputStream = httpURLConnection.getOutputStream();
                    try {
                        outputStream.write(bArrI0);
                        outputStream.close();
                    } catch (IOException e10) {
                        iOException = e10;
                        map = null;
                        outputStream3 = outputStream;
                        responseCode = 0;
                        if (outputStream3 != null) {
                            try {
                                outputStream3.close();
                            } catch (IOException e11) {
                                this.f4142f.l().H().c("Error closing HTTP compressed POST connection output stream. appId", p5.w(this.f4140d), e11);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4142f.a().E(new u5(this.f4140d, this.f4139c, responseCode, iOException, null, map, null));
                    } catch (Throwable th) {
                        th = th;
                        outputStream2 = null;
                        i10 = 0;
                        r13 = outputStream2;
                        Throwable th2 = th;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e12) {
                                this.f4142f.l().H().c("Error closing HTTP compressed POST connection output stream. appId", p5.w(this.f4140d), e12);
                            }
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4142f.a().E(new u5(this.f4140d, this.f4139c, i10, null, null, r13, null));
                        throw th2;
                    }
                }
                responseCode = httpURLConnection.getResponseCode();
                try {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        s5 s5Var = this.f4142f;
                        byte[] bArrB = s5.B(httpURLConnection);
                        httpURLConnection.disconnect();
                        this.f4142f.a().E(new u5(this.f4140d, this.f4139c, responseCode, null, bArrB, headerFields, null));
                    } catch (IOException e13) {
                        e = e13;
                        map = headerFields;
                        iOException = e;
                        if (outputStream3 != null) {
                            outputStream3.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4142f.a().E(new u5(this.f4140d, this.f4139c, responseCode, iOException, null, map, null));
                    } catch (Throwable th3) {
                        th = th3;
                        outputStream = null;
                        i10 = responseCode;
                        r13 = headerFields;
                        Throwable th4 = th;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        this.f4142f.a().E(new u5(this.f4140d, this.f4139c, i10, null, null, r13, null));
                        throw th4;
                    }
                } catch (IOException e14) {
                    e = e14;
                    map = null;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream = null;
                    r13 = 0;
                    i10 = responseCode;
                }
            } catch (IOException e15) {
                iOException = e15;
                map = null;
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                outputStream2 = outputStream;
                i10 = 0;
                r13 = outputStream2;
                Throwable th7 = th;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                this.f4142f.a().E(new u5(this.f4140d, this.f4139c, i10, null, null, r13, null));
                throw th7;
            }
        } catch (IOException e16) {
            iOException = e16;
            httpURLConnection = null;
            map = null;
        } catch (Throwable th8) {
            th = th8;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
