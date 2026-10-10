package org.apache.log4j.chainsaw;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class LoggingReceiver extends Thread {
    private static final Logger LOG;
    static /* synthetic */ Class class$org$apache$log4j$chainsaw$LoggingReceiver;
    private MyTableModel mModel;
    private ServerSocket mSvrSock;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private class Slurper implements Runnable {
        private final Socket mClient;

        Slurper(Socket socket) {
            this.mClient = socket;
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggingReceiver.LOG.debug("Starting to get data");
            try {
                while (true) {
                    LoggingReceiver.this.mModel.addEvent(new EventDetails((LoggingEvent) new ObjectInputStream(this.mClient.getInputStream()).readObject()));
                }
            } catch (EOFException unused) {
                LoggingReceiver.LOG.info("Reached EOF, closing connection");
                try {
                    this.mClient.close();
                } catch (IOException e10) {
                    LoggingReceiver.LOG.warn("Error closing connection", e10);
                }
            } catch (IOException e11) {
                LoggingReceiver.LOG.warn("Got IOException, closing connection", e11);
                this.mClient.close();
            } catch (ClassNotFoundException e12) {
                LoggingReceiver.LOG.warn("Got ClassNotFoundException, closing connection", e12);
                this.mClient.close();
            } catch (SocketException unused2) {
                LoggingReceiver.LOG.info("Caught SocketException, closing connection");
                this.mClient.close();
            }
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$chainsaw$LoggingReceiver;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.chainsaw.LoggingReceiver");
            class$org$apache$log4j$chainsaw$LoggingReceiver = clsClass$;
        }
        LOG = Logger.getLogger(clsClass$);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        LOG.info("Thread started");
        while (true) {
            try {
                Logger logger = LOG;
                logger.debug("Waiting for a connection");
                Socket socketAccept = this.mSvrSock.accept();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Got a connection from ");
                stringBuffer.append(socketAccept.getInetAddress().getHostName());
                logger.debug(stringBuffer.toString());
                Thread thread = new Thread(new Slurper(socketAccept));
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e10) {
                LOG.error("Error in accepting connections, stopping.", e10);
                return;
            }
        }
    }

    LoggingReceiver(MyTableModel myTableModel, int i10) {
        setDaemon(true);
        this.mModel = myTableModel;
        this.mSvrSock = new ServerSocket(i10);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
