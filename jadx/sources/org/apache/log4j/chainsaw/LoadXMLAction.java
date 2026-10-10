package org.apache.log4j.chainsaw;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.StringReader;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class LoadXMLAction extends AbstractAction {
    private static final Logger LOG;
    static /* synthetic */ Class class$org$apache$log4j$chainsaw$LoadXMLAction;
    private final JFileChooser mChooser;
    private final XMLFileHandler mHandler;
    private final JFrame mParent;
    private final XMLReader mParser;

    static {
        Class clsClass$ = class$org$apache$log4j$chainsaw$LoadXMLAction;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.log4j.chainsaw.LoadXMLAction");
            class$org$apache$log4j$chainsaw$LoadXMLAction = clsClass$;
        }
        LOG = Logger.getLogger(clsClass$);
    }

    private int loadFile(String str) {
        int numEvents;
        synchronized (this.mParser) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<?xml version=\"1.0\" standalone=\"yes\"?>\n");
            stringBuffer.append("<!DOCTYPE log4j:eventSet ");
            stringBuffer.append("[<!ENTITY data SYSTEM \"file:///");
            stringBuffer.append(str);
            stringBuffer.append("\">]>\n");
            stringBuffer.append("<log4j:eventSet xmlns:log4j=\"Claira\">\n");
            stringBuffer.append("&data;\n");
            stringBuffer.append("</log4j:eventSet>\n");
            this.mParser.parse(new InputSource(new StringReader(stringBuffer.toString())));
            numEvents = this.mHandler.getNumEvents();
        }
        return numEvents;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        Logger logger = LOG;
        logger.info("load file called");
        if (this.mChooser.showOpenDialog(this.mParent) == 0) {
            logger.info("Need to load a file");
            File selectedFile = this.mChooser.getSelectedFile();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("loading the contents of ");
            stringBuffer.append(selectedFile.getAbsolutePath());
            logger.info(stringBuffer.toString());
            try {
                int iLoadFile = loadFile(selectedFile.getAbsolutePath());
                JFrame jFrame = this.mParent;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Loaded ");
                stringBuffer2.append(iLoadFile);
                stringBuffer2.append(" events.");
                JOptionPane.showMessageDialog(jFrame, stringBuffer2.toString(), "CHAINSAW", 1);
            } catch (Exception e10) {
                LOG.warn("caught an exception loading the file", e10);
                JFrame jFrame2 = this.mParent;
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Error parsing file - ");
                stringBuffer3.append(e10.getMessage());
                JOptionPane.showMessageDialog(jFrame2, stringBuffer3.toString(), "CHAINSAW", 0);
            }
        }
    }

    LoadXMLAction(JFrame jFrame, MyTableModel myTableModel) throws SAXException {
        JFileChooser jFileChooser = new JFileChooser();
        this.mChooser = jFileChooser;
        jFileChooser.setMultiSelectionEnabled(false);
        jFileChooser.setFileSelectionMode(0);
        this.mParent = jFrame;
        XMLFileHandler xMLFileHandler = new XMLFileHandler(myTableModel);
        this.mHandler = xMLFileHandler;
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        this.mParser = xMLReader;
        xMLReader.setContentHandler(xMLFileHandler);
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e10) {
            throw new NoClassDefFoundError().initCause(e10);
        }
    }
}
