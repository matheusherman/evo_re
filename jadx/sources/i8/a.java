package i8;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintStream f11238a;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // i8.a.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(Object obj) {
            this.f11238a.print(obj);
            return this;
        }

        c(PrintStream printStream) {
            this.f11238a = printStream;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PrintWriter f11239a;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // i8.a.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Object obj) {
            this.f11239a.print(obj);
            return this;
        }

        d(PrintWriter printWriter) {
            this.f11239a = printWriter;
        }
    }

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        int i10;
        try {
            if (this.cause == null) {
                String property = System.getProperty("line.separator");
                if (this.exceptions.size() > 1) {
                    IdentityHashMap identityHashMap = new IdentityHashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Multiple exceptions (");
                    sb2.append(this.exceptions.size());
                    sb2.append(")");
                    sb2.append(property);
                    for (Throwable cause : this.exceptions) {
                        int i11 = 0;
                        while (cause != null) {
                            for (int i12 = 0; i12 < i11; i12++) {
                                sb2.append("  ");
                            }
                            sb2.append("|-- ");
                            sb2.append(cause.getClass().getCanonicalName());
                            sb2.append(": ");
                            String message = cause.getMessage();
                            if (message == null || !message.contains(property)) {
                                sb2.append(message);
                                sb2.append(property);
                            } else {
                                sb2.append(property);
                                for (String str : message.split(property)) {
                                    for (int i13 = 0; i13 < i11 + 2; i13++) {
                                        sb2.append("  ");
                                    }
                                    sb2.append(str);
                                    sb2.append(property);
                                }
                            }
                            int i14 = 0;
                            while (true) {
                                i10 = i11 + 2;
                                if (i14 >= i10) {
                                    break;
                                }
                                sb2.append("  ");
                                i14++;
                            }
                            StackTraceElement[] stackTrace = cause.getStackTrace();
                            if (stackTrace.length > 0) {
                                sb2.append("at ");
                                sb2.append(stackTrace[0]);
                                sb2.append(property);
                            }
                            if (identityHashMap.containsKey(cause)) {
                                Throwable cause2 = cause.getCause();
                                if (cause2 == null) {
                                    break;
                                }
                                for (int i15 = 0; i15 < i10; i15++) {
                                    sb2.append("  ");
                                }
                                sb2.append("|-- ");
                                sb2.append("(cause not expanded again) ");
                                sb2.append(cause2.getClass().getCanonicalName());
                                sb2.append(": ");
                                sb2.append(cause2.getMessage());
                                sb2.append(property);
                                break;
                            }
                            identityHashMap.put(cause, Boolean.TRUE);
                            cause = cause.getCause();
                            i11++;
                        }
                    }
                    this.cause = new C0190a(sb2.toString().trim());
                } else {
                    this.cause = this.exceptions.get(0);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.cause;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /* JADX INFO: renamed from: i8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static final class C0190a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }

        C0190a(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static abstract class b {
        abstract b a(Object obj);

        b() {
        }
    }

    public List<Throwable> b() {
        return this.exceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        c(new c(printStream));
    }

    private void a(b bVar, Throwable th, String str) {
        bVar.a(str).a(th).a('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            bVar.a("\t\tat ").a(stackTraceElement).a('\n');
        }
        if (th.getCause() != null) {
            bVar.a("\tCaused by: ");
            a(bVar, th.getCause(), "");
        }
    }

    private void c(b bVar) {
        bVar.a(this).a("\n");
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            bVar.a("\tat ").a(stackTraceElement).a("\n");
        }
        int i10 = 1;
        for (Throwable th : this.exceptions) {
            bVar.a("  ComposedException ").a(Integer.valueOf(i10)).a(" :\n");
            a(bVar, th, "\t");
            i10++;
        }
        bVar.a("\n");
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        c(new d(printWriter));
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            List<Throwable> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.exceptions = listUnmodifiableList;
            this.message = listUnmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
