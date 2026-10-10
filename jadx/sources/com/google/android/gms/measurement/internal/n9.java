package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
@WorkerThread
final class n9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final URL f3840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f3841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j9 f3842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f3843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, String> f3844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ l9 f3845f;

    public n9(l9 l9Var, String str, URL url, byte[] bArr, Map<String, String> map, j9 j9Var) {
        this.f3845f = l9Var;
        m1.g.e(str);
        m1.g.k(url);
        m1.g.k(j9Var);
        this.f3840a = url;
        this.f3841b = bArr;
        this.f3842c = j9Var;
        this.f3843d = str;
        this.f3844e = map;
    }

    private final void a(final int i10, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f3845f.a().E(new Runnable() { // from class: com.google.android.gms.measurement.internal.m9
            @Override // java.lang.Runnable
            public final void run() {
                n9 n9Var = this.f3811a;
                n9Var.f3842c.a(n9Var.f3843d, i10, exc, bArr, map);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:51:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x013c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        this.f3845f.k();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionB = com.google.android.gms.internal.measurement.e2.a().b(this.f3840a, "client-measurement");
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
                try {
                    Map<String, String> map3 = this.f3844e;
                    if (map3 != null) {
                        for (Map.Entry<String, String> entry : map3.entrySet()) {
                            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                        }
                    }
                    byte[] bArr = this.f3841b;
                    if (bArr != null) {
                        try {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                            gZIPOutputStream.write(bArr);
                            gZIPOutputStream.close();
                            byteArrayOutputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            this.f3845f.l().L().b("Uploading data. size", Integer.valueOf(byteArray.length));
                            httpURLConnection.setDoOutput(true);
                            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
                            httpURLConnection.setFixedLengthStreamingMode(byteArray.length);
                            httpURLConnection.connect();
                            OutputStream outputStream3 = httpURLConnection.getOutputStream();
                            try {
                                outputStream3.write(byteArray);
                                outputStream3.close();
                            } catch (IOException e10) {
                                outputStream2 = outputStream3;
                                e = e10;
                                map = null;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException e11) {
                                        this.f3845f.l().H().c("Error closing HTTP compressed POST connection output stream. appId", p5.w(this.f3843d), e11);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                a(responseCode, e, null, map);
                            } catch (Throwable th) {
                                outputStream = outputStream3;
                                th = th;
                                map2 = null;
                                if (outputStream != null) {
                                    try {
                                        outputStream.close();
                                    } catch (IOException e12) {
                                        this.f3845f.l().H().c("Error closing HTTP compressed POST connection output stream. appId", p5.w(this.f3843d), e12);
                                    }
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                a(responseCode, null, null, map2);
                                throw th;
                            }
                        } catch (IOException e13) {
                            this.f3845f.l().H().b("Failed to gzip post request content", e13);
                            throw e13;
                        }
                    }
                    responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    try {
                        l9 l9Var = this.f3845f;
                        byte[] bArrW = l9.w(httpURLConnection);
                        httpURLConnection.disconnect();
                        a(responseCode, null, bArrW, headerFields);
                    } catch (IOException e14) {
                        map = headerFields;
                        e = e14;
                        outputStream2 = null;
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        a(responseCode, e, null, map);
                    } catch (Throwable th2) {
                        map2 = headerFields;
                        th = th2;
                        outputStream = null;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        a(responseCode, null, null, map2);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = null;
                    map2 = outputStream;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    a(responseCode, null, null, map2);
                    throw th;
                }
            } catch (IOException e15) {
                e = e15;
                outputStream2 = null;
                map = outputStream2;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                a(responseCode, e, null, map);
            }
        } catch (IOException e16) {
            e = e16;
            httpURLConnection = null;
            outputStream2 = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
