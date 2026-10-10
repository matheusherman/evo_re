package com.tencent.bugly.crashreport.crash.h5;

import android.webkit.JavascriptInterface;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.inner.InnerApi;
import com.tencent.bugly.proguard.al;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.bb;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.spi.Configurator;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class H5JavaScriptInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<Integer> f8636a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8637b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f8638c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8639d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f8640e = null;

    private static bb a(String str) {
        String string;
        if (str != null && str.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                bb bbVar = new bb();
                String string2 = jSONObject.getString("projectRoot");
                bbVar.f8918a = string2;
                if (string2 == null) {
                    return null;
                }
                String string3 = jSONObject.getString("context");
                bbVar.f8919b = string3;
                if (string3 == null) {
                    return null;
                }
                String string4 = jSONObject.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
                bbVar.f8920c = string4;
                if (string4 == null) {
                    return null;
                }
                String string5 = jSONObject.getString("userAgent");
                bbVar.f8921d = string5;
                if (string5 == null) {
                    return null;
                }
                String string6 = jSONObject.getString(IjkMediaMeta.IJKM_KEY_LANGUAGE);
                bbVar.f8922e = string6;
                if (string6 == null) {
                    return null;
                }
                String string7 = jSONObject.getString("name");
                bbVar.f8923f = string7;
                if (string7 == null || string7.equals(Configurator.NULL) || (string = jSONObject.getString("stacktrace")) == null) {
                    return null;
                }
                int iIndexOf = string.indexOf("\n");
                if (iIndexOf < 0) {
                    al.d("H5 crash stack's format is wrong!", new Object[0]);
                    return null;
                }
                bbVar.f8925h = string.substring(iIndexOf + 1);
                String strSubstring = string.substring(0, iIndexOf);
                bbVar.f8924g = strSubstring;
                int iIndexOf2 = strSubstring.indexOf(":");
                if (iIndexOf2 > 0) {
                    bbVar.f8924g = bbVar.f8924g.substring(iIndexOf2 + 1);
                }
                bbVar.f8926i = jSONObject.getString("file");
                if (bbVar.f8923f == null) {
                    return null;
                }
                long j10 = jSONObject.getLong("lineNumber");
                bbVar.f8927j = j10;
                if (j10 < 0) {
                    return null;
                }
                long j11 = jSONObject.getLong("columnNumber");
                bbVar.f8928k = j11;
                if (j11 < 0) {
                    return null;
                }
                al.a("H5 crash information is following: ", new Object[0]);
                al.a("[projectRoot]: " + bbVar.f8918a, new Object[0]);
                al.a("[context]: " + bbVar.f8919b, new Object[0]);
                al.a("[url]: " + bbVar.f8920c, new Object[0]);
                al.a("[userAgent]: " + bbVar.f8921d, new Object[0]);
                al.a("[language]: " + bbVar.f8922e, new Object[0]);
                al.a("[name]: " + bbVar.f8923f, new Object[0]);
                al.a("[message]: " + bbVar.f8924g, new Object[0]);
                al.a("[stacktrace]: \n" + bbVar.f8925h, new Object[0]);
                al.a("[file]: " + bbVar.f8926i, new Object[0]);
                al.a("[lineNumber]: " + bbVar.f8927j, new Object[0]);
                al.a("[columnNumber]: " + bbVar.f8928k, new Object[0]);
                return bbVar;
            } catch (Throwable th) {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static H5JavaScriptInterface getInstance(CrashReport.a aVar) {
        String string = null;
        if (aVar == null || f8636a.contains(Integer.valueOf(aVar.hashCode()))) {
            return null;
        }
        H5JavaScriptInterface h5JavaScriptInterface = new H5JavaScriptInterface();
        f8636a.add(Integer.valueOf(aVar.hashCode()));
        Thread threadCurrentThread = Thread.currentThread();
        h5JavaScriptInterface.f8638c = threadCurrentThread;
        if (threadCurrentThread != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n");
            for (int i10 = 2; i10 < threadCurrentThread.getStackTrace().length; i10++) {
                StackTraceElement stackTraceElement = threadCurrentThread.getStackTrace()[i10];
                if (!stackTraceElement.toString().contains("crashreport")) {
                    sb2.append(stackTraceElement.toString());
                    sb2.append("\n");
                }
            }
            string = sb2.toString();
        }
        h5JavaScriptInterface.f8639d = string;
        HashMap map = new HashMap();
        StringBuilder sb3 = new StringBuilder();
        sb3.append((Object) aVar.c());
        map.put("[WebView] ContentDescription", sb3.toString());
        h5JavaScriptInterface.f8640e = map;
        return h5JavaScriptInterface;
    }

    @JavascriptInterface
    public void printLog(String str) {
        al.d("Log from js: %s", str);
    }

    @JavascriptInterface
    public void reportJSException(String str) {
        if (str == null) {
            al.d("Payload from JS is null.", new Object[0]);
            return;
        }
        String strC = ap.c(str.getBytes());
        String str2 = this.f8637b;
        if (str2 != null && str2.equals(strC)) {
            al.d("Same payload from js. Please check whether you've injected bugly.js more than one times.", new Object[0]);
            return;
        }
        this.f8637b = strC;
        al.d("Handling JS exception ...", new Object[0]);
        bb bbVarA = a(str);
        if (bbVarA == null) {
            al.d("Failed to parse payload.", new Object[0]);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        String str3 = bbVarA.f8918a;
        if (str3 != null) {
            linkedHashMap2.put("[JS] projectRoot", str3);
        }
        String str4 = bbVarA.f8919b;
        if (str4 != null) {
            linkedHashMap2.put("[JS] context", str4);
        }
        String str5 = bbVarA.f8920c;
        if (str5 != null) {
            linkedHashMap2.put("[JS] url", str5);
        }
        String str6 = bbVarA.f8921d;
        if (str6 != null) {
            linkedHashMap2.put("[JS] userAgent", str6);
        }
        String str7 = bbVarA.f8926i;
        if (str7 != null) {
            linkedHashMap2.put("[JS] file", str7);
        }
        long j10 = bbVarA.f8927j;
        if (j10 != 0) {
            linkedHashMap2.put("[JS] lineNumber", Long.toString(j10));
        }
        linkedHashMap.putAll(linkedHashMap2);
        linkedHashMap.putAll(this.f8640e);
        linkedHashMap.put("Java Stack", this.f8639d);
        InnerApi.postH5CrashAsync(this.f8638c, bbVarA.f8923f, bbVarA.f8924g, bbVarA.f8925h, linkedHashMap);
    }

    private H5JavaScriptInterface() {
    }
}
