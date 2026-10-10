package org.apache.log4j.net;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SimpleSocketServer {
    static Logger cat;
    static /* synthetic */ Class class$org$apache$log4j$net$SimpleSocketServer;
    static int port;

    public static void main(String[] strArr) throws Throwable {
        if (strArr.length == 2) {
            init(strArr[0], strArr[1]);
        } else {
            usage("Wrong number of arguments.");
        }
        try {
            Logger logger = cat;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Listening on port ");
            stringBuffer.append(port);
            logger.info(stringBuffer.toString());
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                cat.info("Waiting to accept a new client.");
                Socket socketAccept = serverSocket.accept();
                Logger logger2 = cat;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Connected to client at ");
                stringBuffer2.append(socketAccept.getInetAddress());
                logger2.info(stringBuffer2.toString());
                cat.info("Starting new socket node.");
                SocketNode socketNode = new SocketNode(socketAccept, LogManager.getLoggerRepository());
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("SimpleSocketServer-");
                stringBuffer3.append(port);
                new Thread(socketNode, stringBuffer3.toString()).start();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$net$SimpleSocketServer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.SimpleSocketServer");
            class$org$apache$log4j$net$SimpleSocketServer = clsClass$;
        }
        cat = Logger.getLogger(clsClass$);
    }

    static void usage(String str) throws Throwable {
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class clsClass$ = class$org$apache$log4j$net$SimpleSocketServer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.SimpleSocketServer");
            class$org$apache$log4j$net$SimpleSocketServer = clsClass$;
        }
        stringBuffer.append(clsClass$.getName());
        stringBuffer.append(" port configFile");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    static void init(String str, String str2) throws Throwable {
        try {
            port = Integer.parseInt(str);
        } catch (NumberFormatException e10) {
            e10.printStackTrace();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not interpret port number [");
            stringBuffer.append(str);
            stringBuffer.append("].");
            usage(stringBuffer.toString());
        }
        if (str2.endsWith(".xml")) {
            DOMConfigurator.configure(str2);
        } else {
            PropertyConfigurator.configure(str2);
        }
    }
}
