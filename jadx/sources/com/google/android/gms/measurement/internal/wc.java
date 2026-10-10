package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.BroadcastOptions;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.log4j.helpers.FileWatchdog;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public final class wc extends u7 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f4158i = {"firebase_", "google_", "ga_"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f4159j = {"_err"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SecureRandom f4160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicLong f4161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MeasurementManagerFutures f4163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f4164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Integer f4165h;

    private final Object J(int i10, Object obj, boolean z10, boolean z11, String str) {
        Bundle bundleF;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return K(String.valueOf(obj), i10, z10);
        }
        if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (bundleF = F((Bundle) parcelable, null)) != null && !bundleF.isEmpty()) {
                arrayList.add(bundleF);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static String K(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (!z10) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i10)) + "...";
    }

    static MessageDigest U0() {
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                if (messageDigest != null) {
                    return messageDigest;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static void Z(vc vcVar, int i10, String str, String str2, int i11) {
        a0(vcVar, null, i10, str, str2, i11);
    }

    static boolean v0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static boolean w0(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    @SuppressLint({"ApplySharedPref"})
    private final boolean x0(String str, double d10) {
        try {
            SharedPreferences.Editor editorEdit = b().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return editorEdit.commit();
        } catch (RuntimeException e10) {
            l().H().b("Failed to persist Deferred Deep Link. exception", e10);
            return false;
        }
    }

    final boolean E0(String str, String str2) {
        if (str2 == null) {
            l().I().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            l().I().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            l().I().c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                l().I().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final boolean k0(String str, int i10, String str2) {
        if (str2 == null) {
            l().I().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        l().I().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    final boolean m0(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i10) {
                l().N().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    final boolean p0(String str, String[] strArr, String str2) {
        return q0(str, strArr, null, str2);
    }

    final boolean q0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            l().I().b("Name is required and can't be null. Type", str);
            return false;
        }
        m1.g.k(str2);
        for (String str3 : f4158i) {
            if (str2.startsWith(str3)) {
                l().I().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !o0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && o0(str2, strArr2)) {
            return true;
        }
        l().I().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.u7
    protected final boolean u() {
        return true;
    }

    final boolean y0(String str, String str2) {
        if (str2 == null) {
            l().I().b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            l().I().b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            l().I().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                l().I().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    static int A0() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public static long B(zzbi zzbiVar) {
        long length = 0;
        if (zzbiVar == null) {
            return 0L;
        }
        Iterator<String> it = zzbiVar.iterator();
        while (it.hasNext()) {
            Object objI0 = zzbiVar.i0(it.next());
            if (objI0 instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objI0).length;
            }
        }
        return length;
    }

    @VisibleForTesting
    private final boolean D0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoD = t1.e.a(context).d(str, 64);
            if (packageInfoD == null || (signatureArr = packageInfoD.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            l().H().b("Package name not found", e10);
            return true;
        } catch (CertificateException e11) {
            l().H().b("Error obtaining certificate", e11);
            return true;
        }
    }

    public static Bundle E(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        if (parcelableArr[i10] instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        return bundle2;
    }

    static boolean F0(String str) {
        String strA = g0.f3596q0.a(null);
        return strA.equals("*") || Arrays.asList(strA.split(",")).contains(str);
    }

    public static Bundle H(List<zzpy> list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            for (zzpy zzpyVar : list) {
                String str = zzpyVar.f4319e;
                if (str != null) {
                    bundle.putString(zzpyVar.f4316b, str);
                } else {
                    Long l10 = zzpyVar.f4318d;
                    if (l10 != null) {
                        bundle.putLong(zzpyVar.f4316b, l10.longValue());
                    } else {
                        Double d10 = zzpyVar.f4321g;
                        if (d10 != null) {
                            bundle.putDouble(zzpyVar.f4316b, d10.doubleValue());
                        }
                    }
                }
            }
        }
        return bundle;
    }

    public static boolean L0(String str) {
        for (String str2 : f4159j) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private final int M0(String str) {
        if (!y0("event param", str)) {
            return 3;
        }
        if (p0("event param", null, str)) {
            return !k0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private final int N0(String str) {
        if (!E0("event param", str)) {
            return 3;
        }
        if (p0("event param", null, str)) {
            return !k0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private static int O0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    @WorkerThread
    public static void Y(q9 q9Var, Bundle bundle, boolean z10) {
        if (bundle == null || q9Var == null || (bundle.containsKey("_sc") && !z10)) {
            if (bundle != null && q9Var == null && z10) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = q9Var.f3942a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = q9Var.f3943b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", q9Var.f3944c);
    }

    @TargetApi(30)
    @WorkerThread
    private final boolean Y0() {
        Integer num;
        if (this.f4164g == null) {
            MeasurementManagerFutures measurementManagerFuturesS0 = S0();
            boolean z10 = false;
            if (measurementManagerFuturesS0 == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = measurementManagerFuturesS0.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z10 = true;
                        }
                    } catch (InterruptedException e10) {
                        e = e10;
                        num2 = num;
                        l().M().b("Measurement manager api exception", e);
                        this.f4164g = Boolean.FALSE;
                        num = num2;
                    } catch (CancellationException e11) {
                        e = e11;
                        num2 = num;
                        l().M().b("Measurement manager api exception", e);
                        this.f4164g = Boolean.FALSE;
                        num = num2;
                    } catch (ExecutionException e12) {
                        e = e12;
                        num2 = num;
                        l().M().b("Measurement manager api exception", e);
                        this.f4164g = Boolean.FALSE;
                        num = num2;
                    } catch (TimeoutException e13) {
                        e = e13;
                        num2 = num;
                        l().M().b("Measurement manager api exception", e);
                        this.f4164g = Boolean.FALSE;
                        num = num2;
                    }
                }
                this.f4164g = Boolean.valueOf(z10);
            } catch (InterruptedException e14) {
                e = e14;
            } catch (CancellationException e15) {
                e = e15;
            } catch (ExecutionException e16) {
                e = e16;
            } catch (TimeoutException e17) {
                e = e17;
            }
            l().L().b("Measurement manager api status result", num);
        }
        return this.f4164g.booleanValue();
    }

    static void a0(vc vcVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        w0(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        vcVar.o(str, "_err", bundle);
    }

    private final void c0(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z10) {
        int iN0;
        int iY;
        if (bundle == null) {
            return;
        }
        int i10 = d().j().e0(231100000, true) ? 35 : 0;
        int i11 = 0;
        for (String str4 : new TreeSet(bundle.keySet())) {
            if (list == 0 || !list.contains(str4)) {
                iN0 = !z10 ? N0(str4) : 0;
                if (iN0 == 0) {
                    iN0 = M0(str4);
                }
            } else {
                iN0 = 0;
            }
            if (iN0 != 0) {
                M(bundle, iN0, str4, iN0 == 3 ? str4 : null);
                bundle.remove(str4);
            } else {
                if (j0(bundle.get(str4))) {
                    l().N().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str4);
                    iY = 22;
                } else {
                    iY = y(str, str2, str4, bundle.get(str4), bundle, list, z10, false);
                }
                if (iY != 0 && !"_ev".equals(str4)) {
                    M(bundle, iY, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (K0(str4) && !o0(str4, b2.i0.f692d)) {
                    i11++;
                    if (!e0(231100000, true)) {
                        l().I().c("Item array not supported on client's version of Google Play Services (Android Only)", g().c(str2), g().a(bundle));
                        w0(bundle, 23);
                        bundle.remove(str4);
                    } else if (i11 > i10) {
                        l().I().c("Item can't contain more than " + i10 + " item-scoped custom params", g().c(str2), g().a(bundle));
                        w0(bundle, 28);
                        bundle.remove(str4);
                    }
                }
            }
        }
    }

    static boolean h0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static boolean j0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    static byte[] r0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList<Bundle> u0(List<zzai> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzai zzaiVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzaiVar.f4286a);
            bundle.putString("origin", zzaiVar.f4287b);
            bundle.putLong("creation_timestamp", zzaiVar.f4289d);
            bundle.putString("name", zzaiVar.f4288c.f4316b);
            b2.f0.b(bundle, m1.g.k(zzaiVar.f4288c.J()));
            bundle.putBoolean("active", zzaiVar.f4290e);
            String str = zzaiVar.f4291f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbj zzbjVar = zzaiVar.f4292g;
            if (zzbjVar != null) {
                bundle.putString("timed_out_event_name", zzbjVar.f4299a);
                zzbi zzbiVar = zzbjVar.f4300b;
                if (zzbiVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbiVar.S());
                }
            }
            bundle.putLong("trigger_timeout", zzaiVar.f4293h);
            zzbj zzbjVar2 = zzaiVar.f4294i;
            if (zzbjVar2 != null) {
                bundle.putString("triggered_event_name", zzbjVar2.f4299a);
                zzbi zzbiVar2 = zzbjVar2.f4300b;
                if (zzbiVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbiVar2.S());
                }
            }
            bundle.putLong("triggered_timestamp", zzaiVar.f4288c.f4317c);
            bundle.putLong("time_to_live", zzaiVar.f4295j);
            zzbj zzbjVar3 = zzaiVar.f4296k;
            if (zzbjVar3 != null) {
                bundle.putString("expired_event_name", zzbjVar3.f4299a);
                zzbi zzbiVar3 = zzbjVar3.f4300b;
                if (zzbiVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbiVar3.S());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0084  */
    @WorkerThread
    private final int y(String str, String str2, String str3, Object obj, Bundle bundle, List<String> list, boolean z10, boolean z11) {
        int i10;
        int size;
        n();
        int i11 = 0;
        if (!j0(obj)) {
            i10 = 0;
        } else {
            if (!z11) {
                return 21;
            }
            if (!o0(str3, b2.i0.f691c)) {
                return 20;
            }
            if (!this.f3965a.N().m0()) {
                return 25;
            }
            boolean z12 = obj instanceof Parcelable[];
            if (z12) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            } else {
                i10 = 0;
            }
            if (size > 200) {
                l().N().d("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                if (z12) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i10 = 17;
            } else {
                i10 = 0;
            }
        }
        if (m0("param", str3, (I0(str2) || I0(str3)) ? d().A(null, false) : d().s(null, false), obj)) {
            return i10;
        }
        if (!z11) {
            return 4;
        }
        if (obj instanceof Bundle) {
            c0(str, str2, str3, (Bundle) obj, list, z10);
            return i10;
        }
        if (obj instanceof Parcelable[]) {
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (!(parcelable instanceof Bundle)) {
                    l().N().c("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                    return 4;
                }
                c0(str, str2, str3, (Bundle) parcelable, list, z10);
            }
            return i10;
        }
        if (!(obj instanceof ArrayList)) {
            return 4;
        }
        ArrayList arrayList2 = (ArrayList) obj;
        int size2 = arrayList2.size();
        while (i11 < size2) {
            Object obj2 = arrayList2.get(i11);
            int i12 = i11 + 1;
            if (!(obj2 instanceof Bundle)) {
                l().N().c("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : Configurator.NULL, str3);
                return 4;
            }
            c0(str, str2, str3, (Bundle) obj2, list, z10);
            i11 = i12;
        }
        return i10;
    }

    static Bundle[] z0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    final Object C0(String str, Object obj) {
        return "_ldl".equals(str) ? J(O0(str), obj, true, false, null) : J(O0(str), obj, false, false, null);
    }

    final Bundle D(Uri uri) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = uri.getQueryParameter("gbraid");
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && TextUtils.isEmpty(queryParameter5) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("sfmc_id", queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            l().M().b("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    final Bundle F(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objT0 = t0(str2, bundle.get(str2));
                if (objT0 == null) {
                    l().N().b("Param value can't be null", g().f(str2));
                } else {
                    P(bundle2, str2, objT0);
                }
            }
        }
        return bundle2;
    }

    final Bundle G(String str, String str2, Bundle bundle, List<String> list, boolean z10) {
        int iN0;
        boolean zO0 = o0(str2, b2.j0.f699d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iB = d().B();
        int i10 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == 0 || !list.contains(str3)) {
                iN0 = !z10 ? N0(str3) : 0;
                if (iN0 == 0) {
                    iN0 = M0(str3);
                }
            } else {
                iN0 = 0;
            }
            if (iN0 != 0) {
                M(bundle2, iN0, str3, iN0 == 3 ? str3 : null);
                bundle2.remove(str3);
            } else {
                int iY = y(str, str2, str3, bundle.get(str3), bundle2, list, z10, zO0);
                if (iY == 17) {
                    M(bundle2, iY, str3, Boolean.FALSE);
                } else if (iY != 0 && !"_ev".equals(str3)) {
                    M(bundle2, iY, iY == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (K0(str3) && (i10 = i10 + 1) > iB) {
                    l().I().c("Event can't contain more than " + iB + " params", g().c(str2), g().a(bundle));
                    w0(bundle2, 5);
                    bundle2.remove(str3);
                }
            }
        }
        return bundle2;
    }

    public final int J0() {
        if (this.f4165h == null) {
            this.f4165h = Integer.valueOf(com.google.android.gms.common.b.f().a(b()) / 1000);
        }
        return this.f4165h.intValue();
    }

    @WorkerThread
    final void N(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            l().M().b("Params already contained engagement", Long.valueOf(j11));
        }
        bundle.putLong("_et", j10 + j11);
    }

    final void O(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                j().P(bundle, str, bundle2.get(str));
            }
        }
    }

    final void P(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            l().N().c("Not putting event parameter. Invalid value type. name, type", g().f(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void Q(com.google.android.gms.internal.measurement.u2 u2Var, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i10);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning int value to wrapper", e10);
        }
    }

    public final void R(com.google.android.gms.internal.measurement.u2 u2Var, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j10);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning long value to wrapper", e10);
        }
    }

    public final long R0() {
        long andIncrement;
        long j10;
        if (this.f4161d.get() != 0) {
            synchronized (this.f4161d) {
                this.f4161d.compareAndSet(-1L, 1L);
                andIncrement = this.f4161d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f4161d) {
            long jNextLong = new Random(System.nanoTime() ^ c().a()).nextLong();
            int i10 = this.f4162e + 1;
            this.f4162e = i10;
            j10 = jNextLong + ((long) i10);
        }
        return j10;
    }

    final MeasurementManagerFutures S0() {
        if (this.f4163f == null) {
            this.f4163f = MeasurementManagerFutures.from(b());
        }
        return this.f4163f;
    }

    public final void T(com.google.android.gms.internal.measurement.u2 u2Var, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning string value to wrapper", e10);
        }
    }

    final String T0() {
        byte[] bArr = new byte[16];
        V0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void U(com.google.android.gms.internal.measurement.u2 u2Var, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning bundle list to wrapper", e10);
        }
    }

    public final void V(com.google.android.gms.internal.measurement.u2 u2Var, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z10);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning boolean value to wrapper", e10);
        }
    }

    public final void W(com.google.android.gms.internal.measurement.u2 u2Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning byte array to wrapper", e10);
        }
    }

    final void X(t5 t5Var, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(t5Var.f4056d.keySet())) {
            if (K0(str) && (i11 = i11 + 1) > i10) {
                l().I().c("Event can't contain more than " + i10 + " params", g().c(t5Var.f4053a), g().a(t5Var.f4056d));
                w0(t5Var.f4056d, 5);
                t5Var.f4056d.remove(str);
            }
        }
    }

    public final boolean e0(int i10, boolean z10) {
        Boolean boolD0 = this.f3965a.N().d0();
        if (J0() < i10 / 1000) {
            return (boolD0 == null || boolD0.booleanValue()) ? false : true;
        }
        return true;
    }

    final int s0(String str) {
        if (!y0("user property", str)) {
            return 6;
        }
        if (p0("user property", b2.l0.f706a, str)) {
            return !k0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    final Object t0(String str, Object obj) {
        if ("_ev".equals(str)) {
            return J(d().A(null, false), obj, true, true, null);
        }
        return J(I0(str) ? d().A(null, false) : d().s(null, false), obj, false, true, null);
    }

    final int w(String str) {
        if (!y0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (q0(NotificationCompat.CATEGORY_EVENT, b2.j0.f696a, b2.j0.f697b, str)) {
            return !k0(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
        }
        return 13;
    }

    final int x(String str, Object obj) {
        return "_ldl".equals(str) ? m0("user property referrer", str, O0(str), obj) : m0("user property", str, O0(str), obj) ? 0 : 7;
    }

    wc(s6 s6Var) {
        super(s6Var);
        this.f4165h = null;
        this.f4161d = new AtomicLong(0L);
    }

    @VisibleForTesting
    static long C(byte[] bArr) {
        boolean z10;
        m1.g.k(bArr);
        int i10 = 0;
        if (bArr.length > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        m1.g.o(z10);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (((long) bArr[length]) & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    static boolean I0(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("_")) {
            return true;
        }
        return false;
    }

    static boolean K0(String str) {
        m1.g.e(str);
        if (str.charAt(0) == '_' && !str.equals("_ep")) {
            return false;
        }
        return true;
    }

    private static void M(Bundle bundle, int i10, String str, Object obj) {
        if (w0(bundle, i10)) {
            bundle.putString("_ev", K(str, 40, true));
            if (obj != null) {
                m1.g.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    @VisibleForTesting
    private static boolean P0(String str) {
        m1.g.k(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    static boolean f0(Context context) {
        ActivityInfo receiverInfo;
        m1.g.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean g0(Context context, boolean z10) {
        m1.g.k(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return v0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return v0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean i0(Bundle bundle, int i10) {
        int i11 = 0;
        if (bundle.size() <= i10) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i11++;
            if (i11 > i10) {
                bundle.remove(str);
            }
        }
        return true;
    }

    static boolean n0(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            m1.g.k(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        }
        if (zIsEmpty && zIsEmpty2) {
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                if (!str3.equals(str4)) {
                    return true;
                }
                return false;
            }
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        }
        if (!zIsEmpty && zIsEmpty2) {
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                return true;
            }
            return false;
        }
        if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
            return true;
        }
        return false;
    }

    private static boolean o0(String str, String[] strArr) {
        m1.g.k(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static long z(long j10, long j11) {
        return (j10 + (j11 * FileWatchdog.DEFAULT_DELAY)) / 86400000;
    }

    @WorkerThread
    final long A(Context context, String str) {
        n();
        m1.g.k(context);
        m1.g.e(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigestU0 = U0();
        if (messageDigestU0 == null) {
            l().H().a("Could not get MD5 instance");
            return -1L;
        }
        if (packageManager != null) {
            try {
                if (!D0(context, str)) {
                    Signature[] signatureArr = t1.e.a(context).d(b().getPackageName(), 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        return C(messageDigestU0.digest(signatureArr[0].toByteArray()));
                    }
                    l().M().a("Could not get signatures");
                    return -1L;
                }
                return 0L;
            } catch (PackageManager.NameNotFoundException e10) {
                l().H().b("Package name not found", e10);
                return 0L;
            }
        }
        return 0L;
    }

    @WorkerThread
    final long B0(String str) {
        if (b().getPackageManager() == null) {
            return 0L;
        }
        int i10 = 0;
        try {
            ApplicationInfo applicationInfoB = t1.e.a(b()).b(str, 0);
            if (applicationInfoB != null) {
                i10 = applicationInfoB.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            l().K().b("PackageManager failed to find running app: app_id", str);
        }
        return i10;
    }

    final boolean G0(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return d().U().equals(str);
    }

    @WorkerThread
    final boolean H0(String str) {
        n();
        if (t1.e.a(b()).a(str) == 0) {
            return true;
        }
        l().G().b("Permission not granted", str);
        return false;
    }

    final zzbj I(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (w(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putString("_o", str3);
            Bundle bundleG = G(str, str2, bundle2, com.google.android.gms.common.util.e.a("_o"), true);
            if (z10) {
                bundleG = F(bundleG, str);
            }
            m1.g.k(bundleG);
            return new zzbj(str2, new zzbi(bundleG), str3, j10);
        }
        l().H().b("Invalid conditional property event name", g().g(str2));
        throw new IllegalArgumentException();
    }

    public final URL L(long j10, String str, String str2, long j11, String str3) {
        try {
            m1.g.e(str2);
            m1.g.e(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j10), Integer.valueOf(J0())), str2, str, Long.valueOf(j11));
            if (str.equals(d().V())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e10) {
            e = e10;
            l().H().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e11) {
            e = e11;
            l().H().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    @WorkerThread
    final long Q0() {
        long j10;
        n();
        if (!F0(this.f3965a.D().H())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j10 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j10 = 8;
        } else if (A0() < g0.f3578k0.a(null).intValue()) {
            j10 = 16;
        } else {
            j10 = 0;
        }
        if (!H0("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j10 |= 2;
        }
        if (j10 == 0 && !Y0()) {
            j10 |= 64;
        }
        if (j10 == 0) {
            return 1L;
        }
        return j10;
    }

    public final void S(com.google.android.gms.internal.measurement.u2 u2Var, Bundle bundle) {
        try {
            u2Var.m(bundle);
        } catch (RemoteException e10) {
            this.f3965a.l().M().b("Error returning bundle value to wrapper", e10);
        }
    }

    @WorkerThread
    final SecureRandom V0() {
        n();
        if (this.f4160c == null) {
            this.f4160c = new SecureRandom();
        }
        return this.f4160c;
    }

    @WorkerThread
    final boolean W0() {
        n();
        if (Q0() == 1) {
            return true;
        }
        return false;
    }

    public final boolean X0() {
        try {
            b().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p6 a() {
        return super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ Context b() {
        return super.b();
    }

    public final void b0(String str, double d10) {
        if (!TextUtils.isEmpty(str) && x0(str, d10)) {
            Intent intent = new Intent("android.google.analytics.action.DEEPLINK_ACTION");
            Context contextB = b();
            if (Build.VERSION.SDK_INT >= 34) {
                contextB.sendBroadcast(intent, null, BroadcastOptions.makeBasic().setShareIdentityEnabled(true).toBundle());
            } else {
                contextB.sendBroadcast(intent);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.d c() {
        return super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ i d() {
        return super.d();
    }

    final void d0(Parcelable[] parcelableArr, int i10) {
        m1.g.k(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i11 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (K0(str) && !o0(str, b2.i0.f692d) && (i11 = i11 + 1) > i10) {
                    l().I().c("Param can't contain more than " + i10 + " item-scoped custom parameters", g().f(str), g().a(bundle));
                    w0(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ e e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a0 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ k5 g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ a6 h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ l9 i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ wc j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r7, com.google.android.gms.measurement.internal.t7
    public final /* bridge */ /* synthetic */ p5 l() {
        return super.l();
    }

    final boolean l0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!P0(str)) {
                if (this.f3965a.u()) {
                    l().I().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", p5.w(str));
                }
                return false;
            }
            return true;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!P0(str2)) {
                l().I().b("Invalid admob_app_id. Analytics disabled.", p5.w(str2));
                return false;
            }
            return true;
        }
        if (this.f3965a.u()) {
            l().I().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r7
    public final /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    @Override // com.google.android.gms.measurement.internal.u7
    @WorkerThread
    protected final void o() {
        n();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                l().M().a("Utils falling back to Random for random id");
            }
        }
        this.f4161d.set(jNextLong);
    }

    public final int v(int i10) {
        return com.google.android.gms.common.b.f().h(b(), 12451000);
    }
}
