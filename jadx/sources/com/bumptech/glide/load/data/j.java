package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    static final b f1389g = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p.h f1390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f1391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f1392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HttpURLConnection f1393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InputStream f1394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f1395f;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    interface b {
        HttpURLConnection a(URL url);
    }

    public j(p.h hVar, int i10) {
        this(hVar, i10, f1389g);
    }

    private HttpURLConnection c(URL url, Map<String, String> map) throws j.e {
        try {
            HttpURLConnection httpURLConnectionA = this.f1392c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f1391b);
            httpURLConnectionA.setReadTimeout(this.f1391b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e10) {
            throw new j.e("URL.openConnection threw", 0, e10);
        }
    }

    private InputStream i(URL url, int i10, URL url2, Map<String, String> map) throws j.e {
        if (i10 >= 5) {
            throw new j.e("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new j.e("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.f1393d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.f1394e = this.f1393d.getInputStream();
            if (this.f1395f) {
                return null;
            }
            int iE = e(this.f1393d);
            if (g(iE)) {
                return f(this.f1393d);
            }
            if (!h(iE)) {
                if (iE == -1) {
                    throw new j.e(iE);
                }
                try {
                    throw new j.e(this.f1393d.getResponseMessage(), iE);
                } catch (IOException e10) {
                    throw new j.e("Failed to get a response message", iE, e10);
                }
            }
            String headerField = this.f1393d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new j.e("Received empty or null redirect url", iE);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return i(url3, i10 + 1, url, map);
            } catch (MalformedURLException e11) {
                throw new j.e("Bad redirect url: " + headerField, iE, e11);
            }
        } catch (IOException e12) {
            throw new j.e("Failed to connect or obtain data", e(this.f1393d), e12);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f1395f = true;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    @VisibleForTesting
    j(p.h hVar, int i10, b bVar) {
        this.f1390a = hVar;
        this.f1391b = i10;
        this.f1392c = bVar;
    }

    private InputStream f(HttpURLConnection httpURLConnection) throws j.e {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f1394e = e0.c.b(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
                }
                this.f1394e = httpURLConnection.getInputStream();
            }
            return this.f1394e;
        } catch (IOException e10) {
            throw new j.e("Failed to obtain InputStream", e(httpURLConnection), e10);
        }
    }

    private static boolean g(int i10) {
        return i10 / 100 == 2;
    }

    private static boolean h(int i10) {
        return i10 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f1394e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f1393d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f1393d = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public void d(@NonNull com.bumptech.glide.h hVar, @NonNull d.a<? super InputStream> aVar) {
        long jB = e0.g.b();
        try {
            aVar.e(i(this.f1390a.i(), 0, null, this.f1390a.e()));
        } catch (IOException e10) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
            }
            aVar.c(e10);
        } finally {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + e0.g.a(jB));
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public j.a getDataSource() {
        return j.a.REMOTE;
    }

    private static int e(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
                return -1;
            }
            return -1;
        }
    }
}
