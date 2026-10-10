package org.apache.log4j.varia;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class HUP extends Thread {
    ExternallyRolledFileAppender er;
    int port;

    HUP(ExternallyRolledFileAppender externallyRolledFileAppender, int i10) {
        this.er = externallyRolledFileAppender;
        this.port = i10;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!isInterrupted()) {
            try {
                while (true) {
                    Socket socketAccept = new ServerSocket(this.port).accept();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Connected to client at ");
                    stringBuffer.append(socketAccept.getInetAddress());
                    LogLog.debug(stringBuffer.toString());
                    new Thread(new HUPNode(socketAccept, this.er), "ExternallyRolledFileAppender-HUP").start();
                }
            } catch (InterruptedIOException e10) {
                Thread.currentThread().interrupt();
                e10.printStackTrace();
            } catch (IOException e11) {
                e11.printStackTrace();
            } catch (RuntimeException e12) {
                e12.printStackTrace();
            }
        }
    }
}
