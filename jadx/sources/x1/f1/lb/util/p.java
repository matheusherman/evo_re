package x1.f1.lb.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lx1/f1/lb/util/p;", "", "<init>", "()V", "", "", "cmds", "", "withSu", "waitProcess", "c", "(Ljava/util/List;ZZ)Z", "cmd", "a", "(Ljava/lang/String;ZZ)Z", "Lq6/b;", "kotlin.jvm.PlatformType", "b", "Lq6/b;", "logger", "baselib_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f21436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final q6.b logger;

    /* JADX WARN: Code duplicated, block: B:61:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:80:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x00c9, please report this as an issue */
    public final boolean c(List<String> cmds, boolean withSu, boolean waitProcess) throws Throwable {
        BufferedReader bufferedReader;
        if (cmds == null || cmds.size() == 0) {
            return false;
        }
        if (x1.f1.lb.config.b.f20643a.t()) {
            logger.debug("start", new Object[0]);
        }
        boolean z10 = true;
        DataOutputStream dataOutputStream = null;
        try {
            try {
                Process processExec = Runtime.getRuntime().exec(withSu ? "su" : "sh");
                if (processExec == null) {
                    return false;
                }
                DataOutputStream dataOutputStream2 = new DataOutputStream(processExec.getOutputStream());
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
                    try {
                        Iterator<String> it = cmds.iterator();
                        while (it.hasNext()) {
                            byte[] bytes = it.next().getBytes(ua.d.UTF_8);
                            kotlin.jvm.internal.m.e(bytes, "getBytes(...)");
                            dataOutputStream2.write(bytes);
                            dataOutputStream2.writeBytes("\n");
                        }
                        dataOutputStream2.writeBytes("exit\n");
                        dataOutputStream2.flush();
                        if (waitProcess) {
                            processExec.waitFor();
                            processExec.destroy();
                        }
                        try {
                            dataOutputStream2.close();
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                        try {
                            bufferedReader.close();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    } catch (Exception e12) {
                        e = e12;
                        dataOutputStream = dataOutputStream2;
                        logger.error("exec cmd failure", e);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e13) {
                                e13.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e14) {
                                e14.printStackTrace();
                            }
                        }
                        z10 = false;
                    } catch (Throwable th) {
                        th = th;
                        dataOutputStream = dataOutputStream2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (Exception e15) {
                                e15.printStackTrace();
                            }
                        }
                        if (bufferedReader != null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (Exception e16) {
                            e16.printStackTrace();
                            throw th;
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                if (x1.f1.lb.config.b.f20643a.t()) {
                    logger.debug("end normal ret =" + z10, new Object[0]);
                }
                return z10;
            } catch (Exception e18) {
                e = e18;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            logger.error("exec cmd failure", e);
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            z10 = false;
            if (x1.f1.lb.config.b.f20643a.t()) {
                logger.debug("end normal ret =" + z10, new Object[0]);
            }
            return z10;
        } catch (Throwable th4) {
            th = th4;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (bufferedReader != null) {
                throw th;
            }
            bufferedReader.close();
            throw th;
        }
    }

    static {
        p pVar = new p();
        f21436a = pVar;
        logger = q6.c.d(pVar.getClass());
    }

    public static /* synthetic */ boolean b(p pVar, String str, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        return pVar.a(str, z10, z11);
    }

    public final boolean a(String cmd, boolean withSu, boolean waitProcess) {
        kotlin.jvm.internal.m.f(cmd, "cmd");
        ArrayList arrayList = new ArrayList();
        arrayList.add(cmd);
        return c(arrayList, withSu, waitProcess);
    }

    private p() {
    }
}
