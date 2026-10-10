package io.netty.util;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class NetUtil {
    private static final boolean IPV4_PREFERRED;
    private static final boolean IPV6_ADDRESSES_PREFERRED;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final InternalLogger logger;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        /* synthetic */ SoMaxConnAction(a aVar) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Code duplicated, block: B:52:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.security.PrivilegedAction
        public Integer run() throws Throwable {
            BufferedReader bufferedReader;
            Exception e10;
            Integer numSysctlGetInt;
            int iIntValue = PlatformDependent.isWindows() ? 200 : 128;
            File file = new File("/proc/sys/net/core/somaxconn");
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    if (file.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        try {
                            try {
                                iIntValue = Integer.parseInt(bufferedReader.readLine());
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("{}: {}", file, Integer.valueOf(iIntValue));
                                }
                                bufferedReader2 = bufferedReader;
                            } catch (Exception e11) {
                                e10 = e11;
                                if (NetUtil.logger.isDebugEnabled()) {
                                    NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue), e10);
                                }
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                return Integer.valueOf(iIntValue);
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } else {
                        if (SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                            numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                            if (numSysctlGetInt == null) {
                                numSysctlGetInt = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                                if (numSysctlGetInt != null) {
                                    iIntValue = numSysctlGetInt.intValue();
                                }
                            } else {
                                iIntValue = numSysctlGetInt.intValue();
                            }
                        } else {
                            numSysctlGetInt = null;
                        }
                        if (numSysctlGetInt == null) {
                            NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(iIntValue));
                        }
                    }
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception e12) {
                bufferedReader = null;
                e10 = e12;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                throw th;
            }
            return Integer.valueOf(iIntValue);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    static /* synthetic */ class a {
    }

    public static String bytesToIpAddress(byte[] bArr) {
        return bytesToIpAddress(bArr, 0, bArr.length);
    }

    static {
        boolean z10 = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
        IPV4_PREFERRED = z10;
        boolean z11 = SystemPropertyUtil.getBoolean("java.net.preferIPv6Addresses", false);
        IPV6_ADDRESSES_PREFERRED = z11;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);
        logger = internalLoggerFactory;
        internalLoggerFactory.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(z10));
        internalLoggerFactory.debug("-Djava.net.preferIPv6Addresses: {}", Boolean.valueOf(z11));
        Inet4Address inet4AddressCreateLocalhost4 = NetUtilInitializations.createLocalhost4();
        LOCALHOST4 = inet4AddressCreateLocalhost4;
        Inet6Address inet6AddressCreateLocalhost6 = NetUtilInitializations.createLocalhost6();
        LOCALHOST6 = inet6AddressCreateLocalhost6;
        NetUtilInitializations.NetworkIfaceAndInetAddress networkIfaceAndInetAddressDetermineLoopback = NetUtilInitializations.determineLoopback(inet4AddressCreateLocalhost4, inet6AddressCreateLocalhost6);
        LOOPBACK_IF = networkIfaceAndInetAddressDetermineLoopback.iface();
        LOCALHOST = networkIfaceAndInetAddressDetermineLoopback.address();
        SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction(null))).intValue();
    }

    public static String bytesToIpAddress(byte[] bArr, int i10, int i11) {
        if (i11 != 4) {
            if (i11 == 16) {
                return toAddressString(bArr, i10, false);
            }
            throw new IllegalArgumentException("length: " + i11 + " (expected: 4 or 16)");
        }
        StringBuilder sb2 = new StringBuilder(15);
        sb2.append(bArr[i10] & 255);
        sb2.append('.');
        sb2.append(bArr[i10 + 1] & 255);
        sb2.append('.');
        sb2.append(bArr[i10 + 2] & 255);
        sb2.append('.');
        sb2.append(bArr[i10 + 3] & 255);
        return sb2.toString();
    }

    private static boolean inRangeEndExclusive(int i10, int i11, int i12) {
        return i10 >= i11 && i10 < i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Integer sysctlGetInt(String str) throws IOException {
        Process processStart = new ProcessBuilder("sysctl", str).start();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream()));
            try {
                String line = bufferedReader.readLine();
                if (line != null && line.startsWith(str)) {
                    int length = line.length();
                    while (true) {
                        length--;
                        if (length <= str.length()) {
                            break;
                        }
                        if (!Character.isDigit(line.charAt(length))) {
                            Integer numValueOf = Integer.valueOf(line.substring(length + 1));
                            bufferedReader.close();
                            processStart.destroy();
                            return numValueOf;
                        }
                    }
                }
                bufferedReader.close();
                processStart.destroy();
                return null;
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
        } catch (Throwable th2) {
            processStart.destroy();
            throw th2;
        }
    }

    private static String toAddressString(byte[] bArr, int i10, boolean z10) {
        int i11;
        int i12;
        int[] iArr = new int[8];
        int i13 = i10 + 8;
        while (true) {
            i11 = 1;
            if (i10 >= i13) {
                break;
            }
            int i14 = i10 << 1;
            iArr[i10] = (bArr[i14 + 1] & 255) | ((bArr[i14] & 255) << 8);
            i10++;
        }
        int i15 = -1;
        boolean z11 = false;
        int i16 = 0;
        int i17 = -1;
        int i18 = 0;
        int i19 = -1;
        while (i16 < 8) {
            if (iArr[i16] == 0) {
                if (i17 < 0) {
                    i17 = i16;
                }
            } else if (i17 >= 0) {
                int i20 = i16 - i17;
                if (i20 > i18) {
                    i18 = i20;
                } else {
                    i17 = i19;
                }
                i19 = i17;
                i17 = -1;
            }
            i16++;
        }
        if (i17 < 0 || (i12 = i16 - i17) <= i18) {
            i17 = i19;
        } else {
            i18 = i12;
        }
        if (i18 == 1) {
            i18 = 0;
        } else {
            i15 = i17;
        }
        int i21 = i18 + i15;
        StringBuilder sb2 = new StringBuilder(39);
        if (i21 < 0) {
            sb2.append(Integer.toHexString(iArr[0]));
            while (i11 < 8) {
                sb2.append(':');
                sb2.append(Integer.toHexString(iArr[i11]));
                i11++;
            }
        } else {
            if (inRangeEndExclusive(0, i15, i21)) {
                sb2.append("::");
                if (z10 && i21 == 5 && iArr[5] == 65535) {
                    z11 = true;
                }
            } else {
                sb2.append(Integer.toHexString(iArr[0]));
            }
            while (i11 < 8) {
                if (!inRangeEndExclusive(i11, i15, i21)) {
                    if (!inRangeEndExclusive(i11 - 1, i15, i21)) {
                        if (!z11 || i11 == 6) {
                            sb2.append(':');
                        } else {
                            sb2.append('.');
                        }
                    }
                    if (!z11 || i11 <= 5) {
                        sb2.append(Integer.toHexString(iArr[i11]));
                    } else {
                        sb2.append(iArr[i11] >> 8);
                        sb2.append('.');
                        sb2.append(iArr[i11] & 255);
                    }
                } else if (!inRangeEndExclusive(i11 - 1, i15, i21)) {
                    sb2.append("::");
                }
                i11++;
            }
        }
        return sb2.toString();
    }

    private NetUtil() {
    }
}
