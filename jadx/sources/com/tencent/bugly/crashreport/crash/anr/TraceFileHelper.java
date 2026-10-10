package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class TraceFileHelper {

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8628b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f8629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f8630d;
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    public interface b {
        boolean a(long j10);

        boolean a(long j10, long j11, String str);

        boolean a(String str, int i10, String str2, String str3);
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f8633c;

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i10, String str2, String str3) {
            al.c("new thread %s", str);
            a aVar = this.f8631a;
            if (aVar.f8627a > 0 && aVar.f8629c > 0 && aVar.f8628b != null) {
                if (aVar.f8630d == null) {
                    aVar.f8630d = new HashMap();
                }
                this.f8631a.f8630d.put(str, new String[]{str2, str3, String.valueOf(i10)});
            }
            return true;
        }

        c(a aVar, String str, boolean z10) {
            this.f8631a = aVar;
            this.f8632b = str;
            this.f8633c = z10;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j10, long j11, String str) {
            al.c("new process %s", str);
            if (!str.equals(this.f8632b)) {
                return true;
            }
            a aVar = this.f8631a;
            aVar.f8627a = j10;
            aVar.f8628b = str;
            aVar.f8629c = j11;
            return this.f8633c;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j10) {
            al.c("process end %d", Long.valueOf(j10));
            a aVar = this.f8631a;
            return aVar.f8627a <= 0 || aVar.f8629c <= 0 || aVar.f8628b == null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f8634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f8635b;

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(String str, int i10, String str2, String str3) {
            al.c("new thread %s", str);
            a aVar = this.f8634a;
            if (aVar.f8630d == null) {
                aVar.f8630d = new HashMap();
            }
            this.f8634a.f8630d.put(str, new String[]{str2, str3, String.valueOf(i10)});
            return true;
        }

        d(a aVar, boolean z10) {
            this.f8634a = aVar;
            this.f8635b = z10;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j10, long j11, String str) {
            al.c("new process %s", str);
            a aVar = this.f8634a;
            aVar.f8627a = j10;
            aVar.f8628b = str;
            aVar.f8629c = j11;
            return this.f8635b;
        }

        @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
        public final boolean a(long j10) {
            al.c("process end %d", Long.valueOf(j10));
            return false;
        }
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(line).matches()) {
                    return new Object[]{pattern, line};
                }
            }
        }
    }

    public static a readFirstDumpInfo(String str, boolean z10) throws Throwable {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        a aVar = new a();
        readTraceFile(str, new d(aVar, z10));
        if (aVar.f8627a > 0 && aVar.f8629c > 0 && aVar.f8628b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.f8627a + " " + aVar.f8629c + " " + aVar.f8628b);
        return null;
    }

    public static a readTargetDumpInfo(String str, String str2, boolean z10) throws Throwable {
        if (str != null && str2 != null) {
            a aVar = new a();
            readTraceFile(str2, new c(aVar, str, z10));
            if (aVar.f8627a > 0 && aVar.f8629c > 0 && aVar.f8628b != null) {
                return aVar;
            }
        }
        return null;
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null || line.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }

    public static void readTraceFile(String str, b bVar) throws Throwable {
        Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern patternCompile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern patternCompile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern patternCompile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern patternCompile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Object[] objArrA = a(bufferedReader2, patternCompile);
                        if (objArrA != null) {
                            Object[] objArrA2 = a(bufferedReader2, patternCompile3);
                            if (objArrA2 != null) {
                                String[] strArrSplit = objArrA[1].toString().split("\\s");
                                long j10 = Long.parseLong(strArrSplit[2]);
                                long time = simpleDateFormat.parse(strArrSplit[4] + " " + strArrSplit[5]).getTime();
                                Matcher matcher = patternCompile3.matcher(objArrA2[1].toString());
                                matcher.find();
                                matcher.group(1);
                                if (bVar.a(j10, time, matcher.group(1))) {
                                    while (true) {
                                        Object[] objArrA3 = a(bufferedReader2, patternCompile4, patternCompile2);
                                        if (objArrA3 != null) {
                                            if (objArrA3[0] != patternCompile4) {
                                                if (bVar.a(Long.parseLong(objArrA3[1].toString().split("\\s")[2]))) {
                                                    break;
                                                }
                                                try {
                                                    bufferedReader2.close();
                                                    return;
                                                } catch (IOException e10) {
                                                    e = e10;
                                                    if (al.a(e)) {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                String string = objArrA3[1].toString();
                                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(string);
                                                matcher2.find();
                                                String strGroup = matcher2.group();
                                                String strSubstring = strGroup.substring(1, strGroup.length() - 1);
                                                string.contains("NATIVE");
                                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(string);
                                                matcher3.find();
                                                String strGroup2 = matcher3.group();
                                                bVar.a(strSubstring, Integer.parseInt(strGroup2.substring(strGroup2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } else {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e11) {
                                        e = e11;
                                        if (al.a(e)) {
                                            return;
                                        }
                                    }
                                }
                            } else {
                                al.d("Failed to find process name.", new Object[0]);
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e12) {
                                    e = e12;
                                    if (al.a(e)) {
                                        return;
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e13) {
                                e = e13;
                                if (al.a(e)) {
                                    return;
                                }
                            }
                        }
                        e.printStackTrace();
                        return;
                    }
                } catch (Exception e14) {
                    e = e14;
                    bufferedReader = bufferedReader2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    al.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader == null) {
                        return;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e15) {
                        e = e15;
                        if (al.a(e)) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException e16) {
                        if (al.a(e16)) {
                            throw th;
                        }
                        e16.printStackTrace();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 3; i10++) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return null;
            }
            stringBuffer.append(line + "\n");
        }
        return stringBuffer.toString();
    }
}
