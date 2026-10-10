package org.apache.log4j.helpers;

import java.io.IOException;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SyslogWriter extends Writer {
    static String syslogHost;
    final int SYSLOG_PORT = 514;
    private InetAddress address;
    private DatagramSocket ds;
    private final int port;

    @Override // java.io.Writer
    public void write(char[] cArr, int i10, int i11) throws IOException {
        write(new String(cArr, i10, i11));
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0023 A[PHI: r8
      0x0023: PHI (r8v8 java.lang.String) = (r8v2 java.lang.String), (r8v0 java.lang.String), (r8v0 java.lang.String) binds: [B:21:0x006a, B:11:0x003f, B:7:0x0020] A[DONT_GENERATE, DONT_INLINE]] */
    public SyslogWriter(String str) {
        int port;
        syslogHost = str;
        if (str == null) {
            throw new NullPointerException("syslogHost");
        }
        if (str.indexOf("[") != -1 || str.indexOf(58) == str.lastIndexOf(58)) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("http://");
                stringBuffer.append(str);
                URL url = new URL(stringBuffer.toString());
                if (url.getHost() != null) {
                    str = url.getHost();
                    if (str.startsWith("[") && str.charAt(str.length() - 1) == ']') {
                        str = str.substring(1, str.length() - 1);
                    }
                    port = url.getPort();
                } else {
                    port = -1;
                }
            } catch (MalformedURLException e10) {
                LogLog.error("Malformed URL: will attempt to interpret as InetAddress.", e10);
            }
        } else {
            port = -1;
        }
        this.port = port != -1 ? port : 514;
        try {
            this.address = InetAddress.getByName(str);
        } catch (UnknownHostException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not find ");
            stringBuffer2.append(str);
            stringBuffer2.append(". All logging will FAIL.");
            LogLog.error(stringBuffer2.toString(), e11);
        }
        try {
            this.ds = new DatagramSocket();
        } catch (SocketException e12) {
            e12.printStackTrace();
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not instantiate DatagramSocket to ");
            stringBuffer3.append(str);
            stringBuffer3.append(". All logging will FAIL.");
            LogLog.error(stringBuffer3.toString(), e12);
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DatagramSocket datagramSocket = this.ds;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        if (this.ds == null || this.address == null) {
            return;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length >= 1024) {
            length = 1024;
        }
        this.ds.send(new DatagramPacket(bytes, length, this.address, this.port));
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
