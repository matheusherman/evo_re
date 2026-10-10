package com.koushikdutta.async.http;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public class d extends e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected SSLContext f5081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected TrustManager[] f5082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected HostnameVerifier f5083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected List<c> f5084j;

    public d(a aVar) {
        super(aVar, "https", 443);
        this.f5084j = new ArrayList();
    }

    public void a(c cVar) {
        this.f5084j.add(cVar);
    }

    public void b(HostnameVerifier hostnameVerifier) {
        this.f5083i = hostnameVerifier;
    }

    public void c(SSLContext sSLContext) {
        this.f5081g = sSLContext;
    }

    public void d(TrustManager[] trustManagerArr) {
        this.f5082h = trustManagerArr;
    }
}
