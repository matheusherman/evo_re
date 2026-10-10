package com.taobao.sophix;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class n implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HttpURLConnection f8479a;

    @Override // com.taobao.sophix.q
    public void a(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.f8479a = httpURLConnection;
        httpURLConnection.setConnectTimeout(5000);
        this.f8479a.setReadTimeout(5000);
        this.f8479a.setUseCaches(false);
        this.f8479a.setDoInput(true);
        this.f8479a.setInstanceFollowRedirects(false);
    }

    @Override // com.taobao.sophix.q
    public int b() {
        return this.f8479a.getResponseCode();
    }

    @Override // com.taobao.sophix.q
    public void c() {
        HttpURLConnection httpURLConnection = this.f8479a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // com.taobao.sophix.q
    public void d() throws IOException {
        this.f8479a.connect();
    }

    @Override // com.taobao.sophix.q
    public Map<String, List<String>> e() {
        return this.f8479a.getHeaderFields();
    }

    @Override // com.taobao.sophix.q
    public void a(String str, String str2) {
        HttpURLConnection httpURLConnection = this.f8479a;
        if (httpURLConnection != null) {
            httpURLConnection.addRequestProperty(str, str2);
        }
    }

    @Override // com.taobao.sophix.q
    public InputStream a() {
        return this.f8479a.getInputStream();
    }
}
