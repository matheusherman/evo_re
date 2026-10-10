package q6;

import androidx.exifinterface.media.ExifInterface;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final q6.a f17670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static q6.a f17671b;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class a implements q6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SimpleDateFormat f17672a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        private void h(String str, String str2, String str3, Throwable th) {
            String string;
            try {
                String str4 = this.f17672a.format(Calendar.getInstance().getTime());
                if (th != null) {
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    string = stringWriter.toString();
                } else {
                    string = "";
                }
                if ("".equals(string)) {
                    System.out.printf(Locale.ENGLISH, "%s [ %s ] %s %s%n", str4, str, str2, str3);
                } else {
                    System.out.printf(Locale.ENGLISH, "%s [ %s ] %s %s: %s%n", str4, str, str2, str3, string);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // q6.a
        public void a(String str, String str2, Throwable th) {
            h(ExifInterface.LONGITUDE_WEST, str, str2, th);
        }

        @Override // q6.a
        public void b(String str, String str2) {
            h(ExifInterface.LONGITUDE_EAST, str, str2, null);
        }

        @Override // q6.a
        public void c(String str, String str2) {
            h(ExifInterface.LONGITUDE_WEST, str, str2, null);
        }

        @Override // q6.a
        public void d(String str, String str2, Throwable th) {
            h(ExifInterface.LONGITUDE_EAST, str, str2, th);
        }

        @Override // q6.a
        public void debug(String str, String str2) {
            h("D", str, str2, null);
        }

        @Override // q6.a
        public void e(String str, String str2, Throwable th) {
            h("I", str, str2, th);
        }

        @Override // q6.a
        public void f(String str, String str2, Throwable th) {
            h("D", str, str2, th);
        }

        @Override // q6.a
        public void g(String str, String str2) {
            h("I", str, str2, null);
        }

        a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class b implements q6.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f17673a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f17674b;

        @Override // q6.b
        public void a(String str, Object... objArr) {
            c.b(1, this.f17673a, str, objArr);
        }

        @Override // q6.b
        public void debug(String str, Object... objArr) {
            c.b(0, this.f17673a, str, objArr);
        }

        @Override // q6.b
        public void error(String str, Object... objArr) {
            c.b(3, this.f17673a, str, objArr);
        }

        @Override // q6.b
        public void warn(String str, Object... objArr) {
            c.b(2, this.f17673a, str, objArr);
        }

        b(Class cls) {
            this.f17674b = cls;
            this.f17673a = cls.getName();
        }
    }

    static {
        a aVar = new a();
        f17670a = aVar;
        f17671b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i10, String str, String str2, Object... objArr) {
        q6.a aVar = f17671b;
        if (aVar == null) {
            aVar = f17670a;
        }
        c(aVar, i10, str, str2, objArr);
    }

    private static void c(q6.a aVar, int i10, String str, String str2, Object... objArr) {
        try {
            Matcher matcher = Pattern.compile("\\{\\}").matcher(str2);
            int i11 = 0;
            while (matcher.find() && i11 < objArr.length) {
                str2 = str2.replaceFirst("\\{\\}", String.valueOf(objArr[i11]));
                i11++;
            }
            if (i11 < objArr.length) {
                Object obj = objArr[i11];
                if (obj instanceof Throwable) {
                    Throwable th = (Throwable) obj;
                    if (i10 == 0) {
                        aVar.f(str, str2, th);
                        return;
                    }
                    if (i10 == 1) {
                        aVar.e(str, str2, th);
                        return;
                    } else if (i10 == 2) {
                        aVar.a(str, str2, th);
                        return;
                    } else {
                        if (i10 != 3) {
                            return;
                        }
                        aVar.d(str, str2, th);
                        return;
                    }
                }
            }
            if (i10 == 0) {
                aVar.debug(str, str2);
                return;
            }
            if (i10 == 1) {
                aVar.g(str, str2);
            } else if (i10 == 2) {
                aVar.c(str, str2);
            } else {
                if (i10 != 3) {
                    return;
                }
                aVar.b(str, str2);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static q6.b d(Class<?> cls) {
        return new b(cls);
    }

    public static void e(q6.a aVar) {
        f17671b = aVar;
    }
}
