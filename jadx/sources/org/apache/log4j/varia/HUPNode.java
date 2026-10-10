package org.apache.log4j.varia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class HUPNode implements Runnable {
    DataInputStream dis;
    DataOutputStream dos;
    ExternallyRolledFileAppender er;
    Socket socket;

    @Override // java.lang.Runnable
    public void run() {
        try {
            String utf = this.dis.readUTF();
            LogLog.debug("Got external roll over signal.");
            if (ExternallyRolledFileAppender.ROLL_OVER.equals(utf)) {
                synchronized (this.er) {
                    this.er.rollOver();
                }
                this.dos.writeUTF(ExternallyRolledFileAppender.OK);
            } else {
                this.dos.writeUTF("Expecting [RollOver] string.");
            }
            this.dos.close();
        } catch (InterruptedIOException e10) {
            Thread.currentThread().interrupt();
            LogLog.error("Unexpected exception. Exiting HUPNode.", e10);
        } catch (IOException e11) {
            LogLog.error("Unexpected exception. Exiting HUPNode.", e11);
        } catch (RuntimeException e12) {
            LogLog.error("Unexpected exception. Exiting HUPNode.", e12);
        }
    }

    public HUPNode(Socket socket, ExternallyRolledFileAppender externallyRolledFileAppender) {
        this.socket = socket;
        this.er = externallyRolledFileAppender;
        try {
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
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
