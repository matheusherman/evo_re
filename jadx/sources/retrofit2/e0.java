package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Method f17964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final okhttp3.v f17965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f17966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f17967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final okhttp3.u f17968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final okhttp3.x f17969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f17970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f17971h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f17972i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final u<?>[] f17973j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f17974k;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class a {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final Pattern f17975x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final Pattern f17976y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g0 f17977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f17978b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f17979c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f17980d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f17981e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f17982f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f17983g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f17984h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f17985i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f17986j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f17987k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f17988l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f17989m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f17990n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f17991o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f17992p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f17993q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        String f17994r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        okhttp3.u f17995s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        okhttp3.x f17996t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Set<String> f17997u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        u<?>[] f17998v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f17999w;

        private u<?> f(int i10, Type type, Annotation[] annotationArr, boolean z10) {
            u<?> uVar;
            if (annotationArr != null) {
                uVar = null;
                for (Annotation annotation : annotationArr) {
                    u<?> uVarG = g(i10, type, annotationArr, annotation);
                    if (uVarG != null) {
                        if (uVar != null) {
                            throw k0.o(this.f17978b, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        uVar = uVarG;
                    }
                }
            } else {
                uVar = null;
            }
            if (uVar != null) {
                return uVar;
            }
            if (z10) {
                try {
                    if (k0.h(type) == v8.f.class) {
                        this.f17999w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw k0.o(this.f17978b, i10, "No Retrofit annotation found.", new Object[0]);
        }

        private u<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof gf.y) {
                j(i10, type);
                if (this.f17989m) {
                    throw k0.o(this.f17978b, i10, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f17985i) {
                    throw k0.o(this.f17978b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f17986j) {
                    throw k0.o(this.f17978b, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f17987k) {
                    throw k0.o(this.f17978b, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f17988l) {
                    throw k0.o(this.f17978b, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f17994r != null) {
                    throw k0.o(this.f17978b, i10, "@Url cannot be used with @%s URL", this.f17990n);
                }
                this.f17989m = true;
                if (type == okhttp3.v.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new u.p(this.f17978b, i10);
                }
                throw k0.o(this.f17978b, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof gf.s) {
                j(i10, type);
                if (this.f17986j) {
                    throw k0.o(this.f17978b, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f17987k) {
                    throw k0.o(this.f17978b, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f17988l) {
                    throw k0.o(this.f17978b, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f17989m) {
                    throw k0.o(this.f17978b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f17994r == null) {
                    throw k0.o(this.f17978b, i10, "@Path can only be used with relative url on @%s", this.f17990n);
                }
                this.f17985i = true;
                gf.s sVar = (gf.s) annotation;
                String strValue = sVar.value();
                i(i10, strValue);
                return new u.k(this.f17978b, i10, strValue, this.f17977a.i(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof gf.t) {
                j(i10, type);
                gf.t tVar = (gf.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = k0.h(type);
                this.f17986j = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    return clsH.isArray() ? new u.l(strValue2, this.f17977a.i(a(clsH.getComponentType()), annotationArr), zEncoded).b() : new u.l(strValue2, this.f17977a.i(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new u.l(strValue2, this.f17977a.i(k0.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw k0.o(this.f17978b, i10, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof gf.v) {
                j(i10, type);
                boolean zEncoded2 = ((gf.v) annotation).encoded();
                Class<?> clsH2 = k0.h(type);
                this.f17987k = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    return clsH2.isArray() ? new u.n(this.f17977a.i(a(clsH2.getComponentType()), annotationArr), zEncoded2).b() : new u.n(this.f17977a.i(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new u.n(this.f17977a.i(k0.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw k0.o(this.f17978b, i10, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof gf.u) {
                j(i10, type);
                Class<?> clsH3 = k0.h(type);
                this.f17988l = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw k0.o(this.f17978b, i10, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = k0.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw k0.o(this.f17978b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = k0.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new u.m(this.f17978b, i10, this.f17977a.i(k0.g(1, parameterizedType), annotationArr), ((gf.u) annotation).encoded());
                }
                throw k0.o(this.f17978b, i10, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof gf.i) {
                j(i10, type);
                String strValue3 = ((gf.i) annotation).value();
                Class<?> clsH4 = k0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    return clsH4.isArray() ? new u.f(strValue3, this.f17977a.i(a(clsH4.getComponentType()), annotationArr)).b() : new u.f(strValue3, this.f17977a.i(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new u.f(strValue3, this.f17977a.i(k0.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw k0.o(this.f17978b, i10, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof gf.j) {
                if (type == okhttp3.u.class) {
                    return new u.h(this.f17978b, i10);
                }
                j(i10, type);
                Class<?> clsH5 = k0.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw k0.o(this.f17978b, i10, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeI2 = k0.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw k0.o(this.f17978b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = k0.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new u.g(this.f17978b, i10, this.f17977a.i(k0.g(1, parameterizedType2), annotationArr));
                }
                throw k0.o(this.f17978b, i10, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof gf.c) {
                j(i10, type);
                if (!this.f17992p) {
                    throw k0.o(this.f17978b, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                gf.c cVar = (gf.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f17982f = true;
                Class<?> clsH6 = k0.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    return clsH6.isArray() ? new u.d(strValue4, this.f17977a.i(a(clsH6.getComponentType()), annotationArr), zEncoded3).b() : new u.d(strValue4, this.f17977a.i(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new u.d(strValue4, this.f17977a.i(k0.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw k0.o(this.f17978b, i10, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof gf.d) {
                j(i10, type);
                if (!this.f17992p) {
                    throw k0.o(this.f17978b, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = k0.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw k0.o(this.f17978b, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = k0.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw k0.o(this.f17978b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = k0.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    i iVarI = this.f17977a.i(k0.g(1, parameterizedType3), annotationArr);
                    this.f17982f = true;
                    return new u.e(this.f17978b, i10, iVarI, ((gf.d) annotation).encoded());
                }
                throw k0.o(this.f17978b, i10, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (annotation instanceof gf.q) {
                j(i10, type);
                if (!this.f17993q) {
                    throw k0.o(this.f17978b, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                gf.q qVar = (gf.q) annotation;
                this.f17983g = true;
                String strValue5 = qVar.value();
                Class<?> clsH8 = k0.h(type);
                if (strValue5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(clsH8)) {
                        if (clsH8.isArray()) {
                            if (okhttp3.y.c.class.isAssignableFrom(clsH8.getComponentType())) {
                                return u.o.f18125a.b();
                            }
                            throw k0.o(this.f17978b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (okhttp3.y.c.class.isAssignableFrom(clsH8)) {
                            return u.o.f18125a;
                        }
                        throw k0.o(this.f17978b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (okhttp3.y.c.class.isAssignableFrom(k0.h(k0.g(0, (ParameterizedType) type)))) {
                            return u.o.f18125a.c();
                        }
                        throw k0.o(this.f17978b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw k0.o(this.f17978b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                }
                okhttp3.u uVarI = okhttp3.u.i("Content-Disposition", "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                if (!Iterable.class.isAssignableFrom(clsH8)) {
                    if (!clsH8.isArray()) {
                        if (okhttp3.y.c.class.isAssignableFrom(clsH8)) {
                            throw k0.o(this.f17978b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new u.i(this.f17978b, i10, uVarI, this.f17977a.g(type, annotationArr, this.f17979c));
                    }
                    Class<?> clsA = a(clsH8.getComponentType());
                    if (okhttp3.y.c.class.isAssignableFrom(clsA)) {
                        throw k0.o(this.f17978b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new u.i(this.f17978b, i10, uVarI, this.f17977a.g(clsA, annotationArr, this.f17979c)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type typeG4 = k0.g(0, (ParameterizedType) type);
                    if (okhttp3.y.c.class.isAssignableFrom(k0.h(typeG4))) {
                        throw k0.o(this.f17978b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new u.i(this.f17978b, i10, uVarI, this.f17977a.g(typeG4, annotationArr, this.f17979c)).c();
                }
                throw k0.o(this.f17978b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof gf.r) {
                j(i10, type);
                if (!this.f17993q) {
                    throw k0.o(this.f17978b, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f17983g = true;
                Class<?> clsH9 = k0.h(type);
                if (!Map.class.isAssignableFrom(clsH9)) {
                    throw k0.o(this.f17978b, i10, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeI4 = k0.i(type, clsH9, Map.class);
                if (!(typeI4 instanceof ParameterizedType)) {
                    throw k0.o(this.f17978b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                Type typeG5 = k0.g(0, parameterizedType4);
                if (String.class == typeG5) {
                    Type typeG6 = k0.g(1, parameterizedType4);
                    if (okhttp3.y.c.class.isAssignableFrom(k0.h(typeG6))) {
                        throw k0.o(this.f17978b, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new u.j(this.f17978b, i10, this.f17977a.g(typeG6, annotationArr, this.f17979c), ((gf.r) annotation).encoding());
                }
                throw k0.o(this.f17978b, i10, "@PartMap keys must be of type String: " + typeG5, new Object[0]);
            }
            if (annotation instanceof gf.a) {
                j(i10, type);
                if (this.f17992p || this.f17993q) {
                    throw k0.o(this.f17978b, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f17984h) {
                    throw k0.o(this.f17978b, i10, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    i iVarG = this.f17977a.g(type, annotationArr, this.f17979c);
                    this.f17984h = true;
                    return new u.c(this.f17978b, i10, iVarG);
                } catch (RuntimeException e10) {
                    throw k0.p(this.f17978b, e10, i10, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof gf.x)) {
                return null;
            }
            j(i10, type);
            Class<?> clsH10 = k0.h(type);
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                u<?> uVar = this.f17998v[i11];
                if ((uVar instanceof u.q) && ((u.q) uVar).f18128a.equals(clsH10)) {
                    throw k0.o(this.f17978b, i10, "@Tag type " + clsH10.getName() + " is duplicate of parameter #" + (i11 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new u.q(clsH10);
        }

        private static Class<?> a(Class<?> cls) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            return Short.TYPE == cls ? Short.class : cls;
        }

        private okhttp3.u c(String[] strArr) {
            okhttp3.u.a aVar = new okhttp3.u.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw k0.m(this.f17978b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f17996t = okhttp3.x.e(strTrim);
                    } catch (IllegalArgumentException e10) {
                        throw k0.n(this.f17978b, e10, "Malformed content type: %s", strTrim);
                    }
                } else {
                    aVar.a(strSubstring, strTrim);
                }
            }
            return aVar.f();
        }

        private void d(String str, String str2, boolean z10) {
            String str3 = this.f17990n;
            if (str3 != null) {
                throw k0.m(this.f17978b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f17990n = str;
            this.f17991o = z10;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f17975x.matcher(strSubstring).find()) {
                    throw k0.m(this.f17978b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f17994r = str2;
            this.f17997u = h(str2);
        }

        private void e(Annotation annotation) {
            if (annotation instanceof gf.b) {
                d("DELETE", ((gf.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof gf.f) {
                d(IMediaPlayer.DRM_REQ_GET, ((gf.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof gf.g) {
                d("HEAD", ((gf.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof gf.n) {
                d("PATCH", ((gf.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof gf.o) {
                d(IMediaPlayer.DRM_REQ_POST, ((gf.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof gf.p) {
                d("PUT", ((gf.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof gf.m) {
                d("OPTIONS", ((gf.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof gf.h) {
                gf.h hVar = (gf.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof gf.k) {
                String[] strArrValue = ((gf.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw k0.m(this.f17978b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f17995s = c(strArrValue);
                return;
            }
            if (annotation instanceof gf.l) {
                if (this.f17992p) {
                    throw k0.m(this.f17978b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f17993q = true;
            } else if (annotation instanceof gf.e) {
                if (this.f17993q) {
                    throw k0.m(this.f17978b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f17992p = true;
            }
        }

        static Set<String> h(String str) {
            Matcher matcher = f17975x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void i(int i10, String str) {
            if (!f17976y.matcher(str).matches()) {
                throw k0.o(this.f17978b, i10, "@Path parameter name must match %s. Found: %s", f17975x.pattern(), str);
            }
            if (!this.f17997u.contains(str)) {
                throw k0.o(this.f17978b, i10, "URL \"%s\" does not contain \"{%s}\".", this.f17994r, str);
            }
        }

        e0 b() {
            for (Annotation annotation : this.f17979c) {
                e(annotation);
            }
            if (this.f17990n == null) {
                throw k0.m(this.f17978b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f17991o) {
                if (this.f17993q) {
                    throw k0.m(this.f17978b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f17992p) {
                    throw k0.m(this.f17978b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f17980d.length;
            this.f17998v = new u[length];
            int i10 = length - 1;
            int i11 = 0;
            while (true) {
                boolean z10 = true;
                if (i11 >= length) {
                    break;
                }
                u<?>[] uVarArr = this.f17998v;
                Type type = this.f17981e[i11];
                Annotation[] annotationArr = this.f17980d[i11];
                if (i11 != i10) {
                    z10 = false;
                }
                uVarArr[i11] = f(i11, type, annotationArr, z10);
                i11++;
            }
            if (this.f17994r == null && !this.f17989m) {
                throw k0.m(this.f17978b, "Missing either @%s URL or @Url parameter.", this.f17990n);
            }
            boolean z11 = this.f17992p;
            if (!z11 && !this.f17993q && !this.f17991o && this.f17984h) {
                throw k0.m(this.f17978b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z11 && !this.f17982f) {
                throw k0.m(this.f17978b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f17993q || this.f17983g) {
                return new e0(this);
            }
            throw k0.m(this.f17978b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        a(g0 g0Var, Method method) {
            this.f17977a = g0Var;
            this.f17978b = method;
            this.f17979c = method.getAnnotations();
            this.f17981e = method.getGenericParameterTypes();
            this.f17980d = method.getParameterAnnotations();
        }

        private void j(int i10, Type type) {
            if (!k0.j(type)) {
            } else {
                throw k0.o(this.f17978b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    static e0 b(g0 g0Var, Method method) {
        return new a(g0Var, method).b();
    }

    okhttp3.b0 a(Object[] objArr) {
        u<?>[] uVarArr = this.f17973j;
        int length = objArr.length;
        if (length != uVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + uVarArr.length + ")");
        }
        d0 d0Var = new d0(this.f17966c, this.f17965b, this.f17967d, this.f17968e, this.f17969f, this.f17970g, this.f17971h, this.f17972i);
        if (this.f17974k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(objArr[i10]);
            uVarArr[i10].a(d0Var, objArr[i10]);
        }
        return d0Var.k().j(o.class, new o(this.f17964a, arrayList)).b();
    }

    e0(a aVar) {
        this.f17964a = aVar.f17978b;
        this.f17965b = aVar.f17977a.f18005c;
        this.f17966c = aVar.f17990n;
        this.f17967d = aVar.f17994r;
        this.f17968e = aVar.f17995s;
        this.f17969f = aVar.f17996t;
        this.f17970g = aVar.f17991o;
        this.f17971h = aVar.f17992p;
        this.f17972i = aVar.f17993q;
        this.f17973j = aVar.f17998v;
        this.f17974k = aVar.f17999w;
    }
}
