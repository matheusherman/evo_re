package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;
import org.apache.log4j.spi.LocationInfo;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class n {
    public static final String a(ba.d dVar) {
        kotlin.jvm.internal.m.f(dVar, "<this>");
        List<ba.f> listH = dVar.h();
        kotlin.jvm.internal.m.e(listH, "pathSegments()");
        return c(listH);
    }

    public static final String b(ba.f fVar) {
        kotlin.jvm.internal.m.f(fVar, "<this>");
        if (!e(fVar)) {
            String strF = fVar.f();
            kotlin.jvm.internal.m.e(strF, "asString()");
            return strF;
        }
        StringBuilder sb2 = new StringBuilder();
        String strF2 = fVar.f();
        kotlin.jvm.internal.m.e(strF2, "asString()");
        sb2.append('`' + strF2);
        sb2.append('`');
        return sb2.toString();
    }

    public static final String c(List<ba.f> pathSegments) {
        kotlin.jvm.internal.m.f(pathSegments, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        for (ba.f fVar : pathSegments) {
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(b(fVar));
        }
        String string = sb2.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String d(String lowerRendered, String lowerPrefix, String upperRendered, String upperPrefix, String foldedPrefix) {
        kotlin.jvm.internal.m.f(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.m.f(lowerPrefix, "lowerPrefix");
        kotlin.jvm.internal.m.f(upperRendered, "upperRendered");
        kotlin.jvm.internal.m.f(upperPrefix, "upperPrefix");
        kotlin.jvm.internal.m.f(foldedPrefix, "foldedPrefix");
        if (ua.n.I(lowerRendered, lowerPrefix, false, 2, null) && ua.n.I(upperRendered, upperPrefix, false, 2, null)) {
            String strSubstring = lowerRendered.substring(lowerPrefix.length());
            kotlin.jvm.internal.m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            String strSubstring2 = upperRendered.substring(upperPrefix.length());
            kotlin.jvm.internal.m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String str = foldedPrefix + strSubstring;
            if (kotlin.jvm.internal.m.a(strSubstring, strSubstring2)) {
                return str;
            }
            if (f(strSubstring, strSubstring2)) {
                return str + '!';
            }
        }
        return null;
    }

    public static final boolean f(String lower, String upper) {
        kotlin.jvm.internal.m.f(lower, "lower");
        kotlin.jvm.internal.m.f(upper, "upper");
        if (kotlin.jvm.internal.m.a(lower, ua.n.E(upper, LocationInfo.NA, "", false, 4, null))) {
            return true;
        }
        if (ua.n.v(upper, LocationInfo.NA, false, 2, null)) {
            if (kotlin.jvm.internal.m.a(lower + '?', upper)) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(lower);
        sb2.append(")?");
        return kotlin.jvm.internal.m.a(sb2.toString(), upper);
    }

    private static final boolean e(ba.f fVar) {
        String strF = fVar.f();
        kotlin.jvm.internal.m.e(strF, "asString()");
        if (!i.f13865a.contains(strF)) {
            for (int i10 = 0; i10 < strF.length(); i10++) {
                char cCharAt = strF.charAt(i10);
                if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '_') {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
