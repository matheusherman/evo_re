package org.apache.log4j.net;

import java.io.File;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import org.apache.log4j.Hierarchy;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RootLogger;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class SocketServer {
    static String CONFIG_FILE_EXT = ".lcf";
    static String GENERIC = "generic";
    static Logger cat;
    static /* synthetic */ Class class$org$apache$log4j$net$SocketServer;
    static int port;
    static SocketServer server;
    File dir;
    LoggerRepository genericHierarchy;
    Hashtable hierarchyMap = new Hashtable(11);

    public static void main(String[] strArr) throws Throwable {
        if (strArr.length == 3) {
            init(strArr[0], strArr[1], strArr[2]);
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
                InetAddress inetAddress = socketAccept.getInetAddress();
                Logger logger2 = cat;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Connected to client at ");
                stringBuffer2.append(inetAddress);
                logger2.info(stringBuffer2.toString());
                LoggerRepository loggerRepositoryConfigureHierarchy = (LoggerRepository) server.hierarchyMap.get(inetAddress);
                if (loggerRepositoryConfigureHierarchy == null) {
                    loggerRepositoryConfigureHierarchy = server.configureHierarchy(inetAddress);
                }
                cat.info("Starting new socket node.");
                new Thread(new SocketNode(socketAccept, loggerRepositoryConfigureHierarchy)).start();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    static {
        Class clsClass$ = class$org$apache$log4j$net$SocketServer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.SocketServer");
            class$org$apache$log4j$net$SocketServer = clsClass$;
        }
        cat = Logger.getLogger(clsClass$);
    }

    static void usage(String str) throws Throwable {
        System.err.println(str);
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Usage: java ");
        Class clsClass$ = class$org$apache$log4j$net$SocketServer;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.net.SocketServer");
            class$org$apache$log4j$net$SocketServer = clsClass$;
        }
        stringBuffer.append(clsClass$.getName());
        stringBuffer.append(" port configFile directory");
        printStream.println(stringBuffer.toString());
        System.exit(1);
    }

    LoggerRepository configureHierarchy(InetAddress inetAddress) throws Throwable {
        Logger logger = cat;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Locating configuration file for ");
        stringBuffer.append(inetAddress);
        logger.info(stringBuffer.toString());
        String string = inetAddress.toString();
        int iIndexOf = string.indexOf("/");
        if (iIndexOf == -1) {
            Logger logger2 = cat;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not parse the inetAddress [");
            stringBuffer2.append(inetAddress);
            stringBuffer2.append("]. Using default hierarchy.");
            logger2.warn(stringBuffer2.toString());
            return genericHierarchy();
        }
        String strSubstring = string.substring(0, iIndexOf);
        File file = this.dir;
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(strSubstring);
        stringBuffer3.append(CONFIG_FILE_EXT);
        File file2 = new File(file, stringBuffer3.toString());
        if (file2.exists()) {
            Hierarchy hierarchy = new Hierarchy(new RootLogger(Level.DEBUG));
            this.hierarchyMap.put(inetAddress, hierarchy);
            new PropertyConfigurator().doConfigure(file2.getAbsolutePath(), hierarchy);
            return hierarchy;
        }
        Logger logger3 = cat;
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append("Could not find config file [");
        stringBuffer4.append(file2);
        stringBuffer4.append("].");
        logger3.warn(stringBuffer4.toString());
        return genericHierarchy();
    }

    LoggerRepository genericHierarchy() throws Throwable {
        if (this.genericHierarchy == null) {
            File file = this.dir;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(GENERIC);
            stringBuffer.append(CONFIG_FILE_EXT);
            File file2 = new File(file, stringBuffer.toString());
            if (file2.exists()) {
                this.genericHierarchy = new Hierarchy(new RootLogger(Level.DEBUG));
                new PropertyConfigurator().doConfigure(file2.getAbsolutePath(), this.genericHierarchy);
            } else {
                Logger logger = cat;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not find config file [");
                stringBuffer2.append(file2);
                stringBuffer2.append("]. Will use the default hierarchy.");
                logger.warn(stringBuffer2.toString());
                this.genericHierarchy = LogManager.getLoggerRepository();
            }
        }
        return this.genericHierarchy;
    }

    public SocketServer(File file) {
        this.dir = file;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }

    static void init(String str, String str2, String str3) throws Throwable {
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
        PropertyConfigurator.configure(str2);
        File file = new File(str3);
        if (!file.isDirectory()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("[");
            stringBuffer2.append(str3);
            stringBuffer2.append("] is not a directory.");
            usage(stringBuffer2.toString());
        }
        server = new SocketServer(file);
    }
}
