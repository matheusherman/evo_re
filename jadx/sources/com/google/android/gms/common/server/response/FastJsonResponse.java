package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.k;
import com.google.android.gms.common.util.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import m1.f;
import m1.g;
import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes3.dex */
public abstract class FastJsonResponse {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.a CREATOR = new com.google.android.gms.common.server.response.a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f2423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f2424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final boolean f2425c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final int f2426d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final boolean f2427e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        protected final String f2428f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected final int f2429g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        protected final Class f2430h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        protected final String f2431i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private zan f2432j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @Nullable
        private final a f2433k;

        public int J() {
            return this.f2429g;
        }

        @Nullable
        final zaa M() {
            a aVar = this.f2433k;
            if (aVar == null) {
                return null;
            }
            return zaa.J(aVar);
        }

        @NonNull
        public final Object S(@NonNull Object obj) {
            g.k(this.f2433k);
            return this.f2433k.f(obj);
        }

        @Nullable
        final String V() {
            String str = this.f2431i;
            if (str == null) {
                return null;
            }
            return str;
        }

        @NonNull
        public final Map i0() {
            g.k(this.f2431i);
            g.k(this.f2432j);
            return (Map) g.k(this.f2432j.M(this.f2431i));
        }

        public final void j0(zan zanVar) {
            this.f2432j = zanVar;
        }

        public final boolean k0() {
            return this.f2433k != null;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NonNull Parcel parcel, int i10) {
            int i11 = this.f2423a;
            int iA = n1.b.a(parcel);
            n1.b.k(parcel, 1, i11);
            n1.b.k(parcel, 2, this.f2424b);
            n1.b.c(parcel, 3, this.f2425c);
            n1.b.k(parcel, 4, this.f2426d);
            n1.b.c(parcel, 5, this.f2427e);
            n1.b.r(parcel, 6, this.f2428f, false);
            n1.b.k(parcel, 7, J());
            n1.b.r(parcel, 8, V(), false);
            n1.b.q(parcel, 9, M(), i10, false);
            n1.b.b(parcel, iA);
        }

        Field(int i10, int i11, boolean z10, int i12, boolean z11, String str, int i13, @Nullable String str2, @Nullable zaa zaaVar) {
            this.f2423a = i10;
            this.f2424b = i11;
            this.f2425c = z10;
            this.f2426d = i12;
            this.f2427e = z11;
            this.f2428f = str;
            this.f2429g = i13;
            if (str2 == null) {
                this.f2430h = null;
                this.f2431i = null;
            } else {
                this.f2430h = SafeParcelResponse.class;
                this.f2431i = str2;
            }
            if (zaaVar == null) {
                this.f2433k = null;
            } else {
                this.f2433k = zaaVar.M();
            }
        }

        @NonNull
        public final String toString() {
            f.a aVarA = f.c(this).a("versionCode", Integer.valueOf(this.f2423a)).a("typeIn", Integer.valueOf(this.f2424b)).a("typeInArray", Boolean.valueOf(this.f2425c)).a("typeOut", Integer.valueOf(this.f2426d)).a("typeOutArray", Boolean.valueOf(this.f2427e)).a("outputFieldName", this.f2428f).a("safeParcelFieldId", Integer.valueOf(this.f2429g)).a("concreteTypeName", V());
            Class cls = this.f2430h;
            if (cls != null) {
                aVarA.a("concreteType.class", cls.getCanonicalName());
            }
            a aVar = this.f2433k;
            if (aVar != null) {
                aVarA.a("converterName", aVar.getClass().getCanonicalName());
            }
            return aVarA.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface a<I, O> {
        @NonNull
        Object f(@NonNull Object obj);
    }

    @NonNull
    public abstract Map<String, Field<?, ?>> a();

    @Nullable
    protected abstract Object c(@NonNull String str);

    protected abstract boolean e(@NonNull String str);

    private static final void g(StringBuilder sb2, Field field, Object obj) {
        int i10 = field.f2424b;
        if (i10 == 11) {
            Class cls = field.f2430h;
            g.k(cls);
            sb2.append(((FastJsonResponse) cls.cast(obj)).toString());
        } else {
            if (i10 != 7) {
                sb2.append(obj);
                return;
            }
            sb2.append("\"");
            sb2.append(k.a((String) obj));
            sb2.append("\"");
        }
    }

    @Nullable
    protected Object b(@NonNull Field field) {
        String str = field.f2428f;
        if (field.f2430h == null) {
            return c(str);
        }
        g.q(c(str) == null, "Concrete field shouldn't be value object: %s", field.f2428f);
        try {
            return getClass().getMethod("get" + Character.toUpperCase(str.charAt(0)) + str.substring(1), null).invoke(this, null);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    protected boolean d(@NonNull Field field) {
        if (field.f2426d != 11) {
            return e(field.f2428f);
        }
        if (field.f2427e) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    @NonNull
    protected static final Object f(@NonNull Field field, @Nullable Object obj) {
        if (field.f2433k != null) {
            return field.S(obj);
        }
        return obj;
    }

    @NonNull
    public String toString() {
        Map<String, Field<?, ?>> mapA = a();
        StringBuilder sb2 = new StringBuilder(100);
        for (String str : mapA.keySet()) {
            Field<?, ?> field = mapA.get(str);
            if (d(field)) {
                Object objF = f(field, b(field));
                if (sb2.length() == 0) {
                    sb2.append("{");
                } else {
                    sb2.append(",");
                }
                sb2.append("\"");
                sb2.append(str);
                sb2.append("\":");
                if (objF == null) {
                    sb2.append(Configurator.NULL);
                } else {
                    switch (field.f2426d) {
                        case 8:
                            sb2.append("\"");
                            sb2.append(com.google.android.gms.common.util.c.a((byte[]) objF));
                            sb2.append("\"");
                            break;
                        case 9:
                            sb2.append("\"");
                            sb2.append(com.google.android.gms.common.util.c.b((byte[]) objF));
                            sb2.append("\"");
                            break;
                        case 10:
                            l.a(sb2, (HashMap) objF);
                            break;
                        default:
                            if (field.f2425c) {
                                ArrayList arrayList = (ArrayList) objF;
                                sb2.append("[");
                                int size = arrayList.size();
                                for (int i10 = 0; i10 < size; i10++) {
                                    if (i10 > 0) {
                                        sb2.append(",");
                                    }
                                    Object obj = arrayList.get(i10);
                                    if (obj != null) {
                                        g(sb2, field, obj);
                                    }
                                }
                                sb2.append("]");
                            } else {
                                g(sb2, field, objF);
                            }
                            break;
                    }
                }
            }
        }
        if (sb2.length() > 0) {
            sb2.append("}");
        } else {
            sb2.append("{}");
        }
        return sb2.toString();
    }
}
