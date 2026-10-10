package x1.f1.lb.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.stub.StubApp;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kotlin.Metadata;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import x.l1.b2.R$string;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\nJ%\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u000e¢\u0006\u0004\b\u001e\u0010\u001bJ\u001d\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J%\u0010$\u001a\u0012\u0012\u0004\u0012\u00020#\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\"2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%R\u001c\u0010)\u001a\n '*\u0004\u0018\u00010&0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010(¨\u0006*"}, d2 = {"Lx1/f1/lb/util/m0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Ljava/io/File;", "file", "Landroid/content/Intent;", "c", "(Landroid/content/Context;Ljava/io/File;)Landroid/content/Intent;", "f", "e", "d", "", "manifestFile", "key", "h", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "k", "(Landroid/content/Context;)Z", "apkPath", "g", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;", "filePath", "i", "(Landroid/content/Context;Ljava/lang/String;)Z", "a", "packageName", "j", "Lr8/z;", "b", "(Landroid/content/Context;Ljava/io/File;)V", "Lr8/p;", "", "l", "(Ljava/io/File;)Lr8/p;", "Lq6/b;", "kotlin.jvm.PlatformType", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f21410a = new m0();

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger = q6.c.d(m0.class);

    public final r8.p<Integer, String> l(File file) {
        kotlin.jvm.internal.m.f(file, "file");
        try {
            ya.b bVar = new ya.b(file);
            try {
                String strB = bVar.b();
                if (x1.f1.lb.config.b.f20643a.x()) {
                    String strH = f21410a.h(strB, "DISTRIBUTION_CHANNEL");
                    of.a aVar = of.a.f16585a;
                    if (!kotlin.jvm.internal.m.a(strH, aVar.f())) {
                        logger.warn("apk distribution channel mismatch [{} vs {}]", strH, aVar.f());
                        r8.p<Integer, String> pVar = new r8.p<>(4, strH);
                        a9.a.a(bVar, null);
                        return pVar;
                    }
                }
                String strC = of.a.f16585a.c();
                String strH2 = f21410a.h(strB, "APP_TYPE");
                if (kotlin.jvm.internal.m.a(strC, "mobile")) {
                    if (!kotlin.jvm.internal.m.a(strH2, "mobile")) {
                        logger.warn("apk type mismatch [{} vs {}]", strH2, strC);
                        r8.p<Integer, String> pVar2 = new r8.p<>(5, strH2);
                        a9.a.a(bVar, null);
                        return pVar2;
                    }
                } else if (kotlin.jvm.internal.m.a(strH2, "mobile")) {
                    logger.warn("apk type mismatch [{} vs {}]", strH2, strC);
                    r8.p<Integer, String> pVar3 = new r8.p<>(5, strH2);
                    a9.a.a(bVar, null);
                    return pVar3;
                }
                a9.a.a(bVar, null);
                return null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    a9.a.a(bVar, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            logger.error("verify app failure", th3);
            return null;
        }
    }

    private final Intent c(Context context, File file) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return f(context, file);
        }
        return i10 >= 24 ? e(context, file) : d(context, file);
    }

    private final Intent d(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        return intent;
    }

    private final String h(String manifestFile, String key) throws ParserConfigurationException, SAXException, IOException {
        Node namedItem;
        if (manifestFile == null) {
            return "";
        }
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setIgnoringElementContentWhitespace(false);
        DocumentBuilder documentBuilderNewDocumentBuilder = documentBuilderFactoryNewInstance.newDocumentBuilder();
        Charset UTF_8 = StandardCharsets.UTF_8;
        kotlin.jvm.internal.m.e(UTF_8, "UTF_8");
        byte[] bytes = manifestFile.getBytes(UTF_8);
        kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
        Document document = documentBuilderNewDocumentBuilder.parse(new ByteArrayInputStream(bytes));
        kotlin.jvm.internal.m.e(document, "parse(...)");
        NodeList elementsByTagName = document.getElementsByTagName("meta-data");
        kotlin.jvm.internal.m.e(elementsByTagName, "getElementsByTagName(...)");
        int length = elementsByTagName.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            NamedNodeMap attributes = elementsByTagName.item(i10).getAttributes();
            Node namedItem2 = attributes.getNamedItem("android:name");
            if (namedItem2 != null && TextUtils.equals(key, namedItem2.getNodeValue()) && (namedItem = attributes.getNamedItem("android:value")) != null) {
                return namedItem.getNodeValue();
            }
        }
        return "";
    }

    public final boolean a(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        String packageName = context.getPackageName();
        kotlin.jvm.internal.m.e(packageName, "getPackageName(...)");
        return j(context, packageName);
    }

    public final void b(Context context, File file) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(file, "file");
        try {
            b1 b1Var = b1.f21324a;
            long j10 = b1Var.j();
            long length = file.length() * ((long) 3);
            if (j10 < length) {
                logger.warn("Storage space is running low! apk size[{}] * 3 > available[{}] of total[{}]", Long.valueOf(length), Long.valueOf(j10), Long.valueOf(b1Var.l()));
                g1 g1Var = g1.f21390a;
                String string = context.getString(R$string.not_enough_space_to_upgrade);
                kotlin.jvm.internal.m.e(string, "getString(...)");
                g1Var.c(string);
            }
        } catch (Throwable th) {
            logger.error("check upgrade space failure", th);
        }
    }

    public final String g(Context context, String apkPath) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(apkPath, "apkPath");
        if (Build.VERSION.SDK_INT == 24) {
            return "pm install -r -i " + context.getPackageName() + " --user 0 " + apkPath;
        }
        return "pm install -r -i " + context.getPackageName() + " " + apkPath;
    }

    public final boolean i(Context context, String filePath) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(filePath, "filePath");
        File file = new File(filePath);
        if (l(file) != null) {
            g1 g1Var = g1.f21390a;
            String string = context.getString(R$string.upgrade_file_mismatch);
            kotlin.jvm.internal.m.e(string, "getString(...)");
            g1Var.c(string);
            return false;
        }
        b(context, file);
        if (!k(context)) {
            p.b(p.f21436a, "chmod 777 " + filePath, false, false, 6, null);
            try {
                Intent intentC = c(context, new File(filePath));
                intentC.addFlags(268435456);
                context.startActivity(intentC);
                return true;
            } catch (Exception e10) {
                logger.warn("install failure", e10);
                return false;
            }
        }
        if (Build.VERSION.SDK_INT < 26) {
            boolean zB = p.b(p.f21436a, g(context, filePath), false, false, 4, null);
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("install " + filePath + " by command ret " + zB, new Object[0]);
            }
            return zB;
        }
        PackageInstallManager packageInstallManager = new PackageInstallManager(context);
        boolean zJ = packageInstallManager.j(filePath, "");
        packageInstallManager.c();
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("install " + filePath + " by install session ret " + zJ, new Object[0]);
        }
        return zJ;
    }

    public final boolean j(Context context, String packageName) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(packageName, "packageName");
        try {
            ApplicationInfo applicationInfo = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(packageName, 0).applicationInfo;
            return ((applicationInfo != null ? applicationInfo.flags : 0) & 1) != 0;
        } catch (PackageManager.NameNotFoundException e10) {
            logger.error("can't find package " + packageName, e10);
            return false;
        }
    }

    public final boolean k(Context context) {
        kotlin.jvm.internal.m.f(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(x1.f1.lb.config.b.f20643a.d(), 0);
            kotlin.jvm.internal.m.e(applicationInfo, "getApplicationInfo(...)");
            return 1000 == applicationInfo.uid;
        } catch (Exception unused) {
        }
    }

    private m0() {
    }

    private final Intent e(Context context, File file) {
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        return intent;
    }

    @RequiresApi(api = 26)
    private final Intent f(Context context, File file) {
        return e(context, file);
    }
}
