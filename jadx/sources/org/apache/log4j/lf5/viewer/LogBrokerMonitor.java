package org.apache.log4j.lf5.viewer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.LogRecordFilter;
import org.apache.log4j.lf5.util.DateFormatManager;
import org.apache.log4j.lf5.util.LogFileParser;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerTree;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryPath;
import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.apache.log4j.lf5.viewer.configure.MRUFileManager;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class LogBrokerMonitor {
    public static final String DETAILED_VIEW = "Detailed";
    protected boolean _callSystemExitOnClose;
    protected CategoryExplorerTree _categoryExplorerTree;
    protected List _columns;
    protected JComboBox _fontSizeCombo;
    protected Dimension _lastTableViewportSize;
    protected List _levels;
    protected JFrame _logMonitorFrame;
    protected JScrollPane _logTableScrollPane;
    protected String _searchText;
    protected JLabel _statusLabel;
    protected LogTable _table;
    protected int _logMonitorFrameWidth = 550;
    protected int _logMonitorFrameHeight = 500;
    protected String _NDCTextFilter = "";
    protected LogLevel _leastSevereDisplayedLogLevel = LogLevel.DEBUG;
    protected Object _lock = new Object();
    protected int _fontSize = 10;
    protected String _fontName = "Dialog";
    protected String _currentView = DETAILED_VIEW;
    protected boolean _loadSystemFonts = false;
    protected boolean _trackTableScrollPane = true;
    protected List _displayedLogBrokerProperties = new Vector();
    protected Map _logLevelMenuItems = new HashMap();
    protected Map _logTableColumnMenuItems = new HashMap();
    protected boolean _isDisposed = false;
    protected ConfigurationManager _configurationManager = null;
    protected MRUFileManager _mruFileManager = null;
    protected File _fileLocation = null;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    class LogBrokerMonitorWindowAdaptor extends WindowAdapter {
        protected LogBrokerMonitor _monitor;

        public LogBrokerMonitorWindowAdaptor(LogBrokerMonitor logBrokerMonitor) {
            this._monitor = logBrokerMonitor;
        }

        public void windowClosing(WindowEvent windowEvent) {
            this._monitor.requestClose();
        }
    }

    protected int findRecord(int i10, String str, List list) {
        int i11 = i10 < 0 ? 0 : i10 + 1;
        int size = list.size();
        for (int i12 = i11; i12 < size; i12++) {
            if (matches((LogRecord) list.get(i12), str)) {
                return i12;
            }
        }
        for (int i13 = 0; i13 < i11; i13++) {
            if (matches((LogRecord) list.get(i13), str)) {
                return i13;
            }
        }
        return -1;
    }

    protected boolean loadLogFile(File file) {
        try {
            new LogFileParser(file).parse(this);
            return true;
        } catch (IOException unused) {
            JFrame baseFrame = getBaseFrame();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error reading ");
            stringBuffer.append(file.getName());
            new LogFactor5ErrorDialog(baseFrame, stringBuffer.toString());
            return false;
        }
    }

    protected void pause(int i10) {
        try {
            Thread.sleep(i10);
        } catch (InterruptedException unused) {
        }
    }

    protected void requestClose() {
        setCallSystemExitOnClose(false);
        closeAfterConfirm();
    }

    protected void selectRow(int i10) {
        if (i10 != -1) {
            LF5SwingUtils.selectRow(i10, this._table, this._logTableScrollPane);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this._searchText);
        stringBuffer.append(" not found.");
        JOptionPane.showMessageDialog(this._logMonitorFrame, stringBuffer.toString(), "Text not found", 1);
    }

    public void setFontSize(int i10) {
        changeFontSizeCombo(this._fontSizeCombo, i10);
    }

    public void show(final int i10) {
        if (this._logMonitorFrame.isVisible()) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                Thread.yield();
                LogBrokerMonitor.this.pause(i10);
                LogBrokerMonitor.this._logMonitorFrame.setVisible(true);
            }
        });
    }

    public void addDisplayedProperty(Object obj) {
        this._displayedLogBrokerProperties.add(obj);
    }

    public void addMessage(final LogRecord logRecord) {
        if (this._isDisposed) {
            return;
        }
        SwingUtilities.invokeLater(new Runnable() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                LogBrokerMonitor.this._categoryExplorerTree.getExplorerModel().addLogRecord(logRecord);
                LogBrokerMonitor.this._table.getFilteredLogTableModel().addLogRecord(logRecord);
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
    }

    protected void addTableModelProperties() {
        final FilteredLogTableModel filteredLogTableModel = this._table.getFilteredLogTableModel();
        addDisplayedProperty(new Object() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.5
            public String toString() {
                return LogBrokerMonitor.this.getRecordsDisplayedMessage();
            }
        });
        addDisplayedProperty(new Object() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.6
            public String toString() {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Maximum number of displayed LogRecords: ");
                stringBuffer.append(filteredLogTableModel._maxNumberOfLogRecords);
                return stringBuffer.toString();
            }
        });
    }

    protected void clearDetailTextArea() {
        this._table._detailTextArea.setText("");
    }

    protected void closeAfterConfirm() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this._callSystemExitOnClose) {
            stringBuffer.append("Are you sure you want to exit?\n");
            stringBuffer.append("This will shut down the Virtual Machine.\n");
        } else {
            stringBuffer.append("Are you sure you want to close the logging ");
            stringBuffer.append("console?\n");
            stringBuffer.append("(Note: This will not shut down the Virtual Machine,\n");
            stringBuffer.append("or the Swing event thread.)");
        }
        if (JOptionPane.showConfirmDialog(this._logMonitorFrame, stringBuffer.toString(), this._callSystemExitOnClose ? "Are you sure you want to exit?" : "Are you sure you want to dispose of the Logging Console?", 2, 3, (Icon) null) == 0) {
            dispose();
        }
    }

    protected JMenuItem createAllLogLevelsMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Show all LogLevels");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.8
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.selectAllLogLevels(true);
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createAllLogTableColumnsMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Show all Columns");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.14
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.selectAllLogTableColumns(true);
                LogBrokerMonitor.this._table.setView(LogBrokerMonitor.this.updateView());
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createCloseMI() {
        JMenuItem jMenuItem = new JMenuItem("Close");
        jMenuItem.setMnemonic('c');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("control Q"));
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.18
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.requestClose();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createConfigureMaxRecords() {
        JMenuItem jMenuItem = new JMenuItem("Set Max Number of Records");
        jMenuItem.setMnemonic('m');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.23
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.setMaxRecordConfiguration();
            }
        });
        return jMenuItem;
    }

    protected JMenu createConfigureMenu() {
        JMenu jMenu = new JMenu("Configure");
        jMenu.setMnemonic('c');
        jMenu.add(createConfigureSave());
        jMenu.add(createConfigureReset());
        jMenu.add(createConfigureMaxRecords());
        return jMenu;
    }

    protected JMenuItem createConfigureReset() {
        JMenuItem jMenuItem = new JMenuItem("Reset");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.22
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.resetConfiguration();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createConfigureSave() {
        JMenuItem jMenuItem = new JMenuItem("Save");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.21
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.saveConfiguration();
            }
        });
        return jMenuItem;
    }

    protected JTextArea createDetailTextArea() {
        JTextArea jTextArea = new JTextArea();
        jTextArea.setFont(new Font("Monospaced", 0, 14));
        jTextArea.setTabSize(3);
        jTextArea.setLineWrap(true);
        jTextArea.setWrapStyleWord(false);
        return jTextArea;
    }

    protected JMenuItem createEditFindMI() {
        JMenuItem jMenuItem = new JMenuItem("Find");
        jMenuItem.setMnemonic('f');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("control F"));
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.26
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.setSearchText(JOptionPane.showInputDialog(LogBrokerMonitor.this._logMonitorFrame, "Find text: ", "Search Record Messages", 3));
                LogBrokerMonitor.this.findSearchText();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createEditFindNextMI() {
        JMenuItem jMenuItem = new JMenuItem("Find Next");
        jMenuItem.setMnemonic('n');
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke("F3"));
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.25
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.findSearchText();
            }
        });
        return jMenuItem;
    }

    protected JMenu createEditMenu() {
        JMenu jMenu = new JMenu("Edit");
        jMenu.setMnemonic('e');
        jMenu.add(createEditFindMI());
        jMenu.add(createEditFindNextMI());
        jMenu.addSeparator();
        jMenu.add(createEditSortNDCMI());
        jMenu.add(createEditRestoreAllNDCMI());
        return jMenu;
    }

    protected JMenuItem createEditRestoreAllNDCMI() {
        JMenuItem jMenuItem = new JMenuItem("Restore all NDCs");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.28
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this._table.getFilteredLogTableModel().setLogRecordFilter(LogBrokerMonitor.this.createLogRecordFilter());
                LogBrokerMonitor.this.setNDCTextFilter("");
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createEditSortNDCMI() {
        JMenuItem jMenuItem = new JMenuItem("Sort by NDC");
        jMenuItem.setMnemonic('s');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.27
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.setNDCTextFilter(JOptionPane.showInputDialog(LogBrokerMonitor.this._logMonitorFrame, "Sort by this NDC: ", "Sort Log Records by NDC", 3));
                LogBrokerMonitor.this.sortByNDC();
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createExitMI() {
        JMenuItem jMenuItem = new JMenuItem("Exit");
        jMenuItem.setMnemonic('x');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.20
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.requestExit();
            }
        });
        return jMenuItem;
    }

    protected JMenu createFileMenu() {
        JMenu jMenu = new JMenu("File");
        jMenu.setMnemonic('f');
        jMenu.add(createOpenMI());
        jMenu.add(createOpenURLMI());
        jMenu.addSeparator();
        jMenu.add(createCloseMI());
        createMRUFileListMI(jMenu);
        jMenu.addSeparator();
        jMenu.add(createExitMI());
        return jMenu;
    }

    protected JMenu createHelpMenu() {
        JMenu jMenu = new JMenu("Help");
        jMenu.setMnemonic('h');
        jMenu.add(createHelpProperties());
        return jMenu;
    }

    protected JMenuItem createHelpProperties() {
        JMenuItem jMenuItem = new JMenuItem("LogFactor5 Properties");
        jMenuItem.setMnemonic('l');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.24
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.showPropertiesDialog("LogFactor5 Properties");
            }
        });
        return jMenuItem;
    }

    protected JMenu createLogLevelColorMenu() {
        JMenu jMenu = new JMenu("Configure LogLevel Colors");
        jMenu.setMnemonic('c');
        Iterator logLevels = getLogLevels();
        while (logLevels.hasNext()) {
            jMenu.add(createSubMenuItem((LogLevel) logLevels.next()));
        }
        return jMenu;
    }

    protected JComboBox createLogLevelCombo() {
        JComboBox jComboBox = new JComboBox();
        Iterator logLevels = getLogLevels();
        while (logLevels.hasNext()) {
            jComboBox.addItem(logLevels.next());
        }
        jComboBox.setSelectedItem(this._leastSevereDisplayedLogLevel);
        jComboBox.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.32
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.setLeastSevereDisplayedLogLevel((LogLevel) ((JComboBox) actionEvent.getSource()).getSelectedItem());
            }
        });
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        return jComboBox;
    }

    protected JMenu createLogLevelMenu() {
        JMenu jMenu = new JMenu("Log Level");
        jMenu.setMnemonic('l');
        Iterator logLevels = getLogLevels();
        while (logLevels.hasNext()) {
            jMenu.add(getMenuItem((LogLevel) logLevels.next()));
        }
        jMenu.addSeparator();
        jMenu.add(createAllLogLevelsMenuItem());
        jMenu.add(createNoLogLevelsMenuItem());
        jMenu.addSeparator();
        jMenu.add(createLogLevelColorMenu());
        jMenu.add(createResetLogLevelColorMenuItem());
        return jMenu;
    }

    protected LogRecordFilter createLogRecordFilter() {
        return new LogRecordFilter() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.3
            @Override // org.apache.log4j.lf5.LogRecordFilter
            public boolean passes(LogRecord logRecord) {
                return LogBrokerMonitor.this.getMenuItem(logRecord.getLevel()).isSelected() && LogBrokerMonitor.this._categoryExplorerTree.getExplorerModel().isCategoryPathActive(new CategoryPath(logRecord.getCategory()));
            }
        };
    }

    protected JCheckBoxMenuItem createLogTableColumnMenuItem(LogTableColumn logTableColumn) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(logTableColumn.toString());
        jCheckBoxMenuItem.setSelected(true);
        jCheckBoxMenuItem.setMnemonic(logTableColumn.toString().charAt(0));
        jCheckBoxMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.13
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this._table.setView(LogBrokerMonitor.this.updateView());
            }
        });
        return jCheckBoxMenuItem;
    }

    protected void createMRUFileListMI(JMenu jMenu) {
        String[] mRUFileList = this._mruFileManager.getMRUFileList();
        if (mRUFileList != null) {
            jMenu.addSeparator();
            int i10 = 0;
            while (i10 < mRUFileList.length) {
                StringBuffer stringBuffer = new StringBuffer();
                int i11 = i10 + 1;
                stringBuffer.append(i11);
                stringBuffer.append(" ");
                stringBuffer.append(mRUFileList[i10]);
                JMenuItem jMenuItem = new JMenuItem(stringBuffer.toString());
                jMenuItem.setMnemonic(i11);
                jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.19
                    public void actionPerformed(ActionEvent actionEvent) {
                        LogBrokerMonitor.this.requestOpenMRU(actionEvent);
                    }
                });
                jMenu.add(jMenuItem);
                i10 = i11;
            }
        }
    }

    protected JMenuBar createMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(createFileMenu());
        jMenuBar.add(createEditMenu());
        jMenuBar.add(createLogLevelMenu());
        jMenuBar.add(createViewMenu());
        jMenuBar.add(createConfigureMenu());
        jMenuBar.add(createHelpMenu());
        return jMenuBar;
    }

    protected JCheckBoxMenuItem createMenuItem(LogLevel logLevel) {
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem(logLevel.toString());
        jCheckBoxMenuItem.setSelected(true);
        jCheckBoxMenuItem.setMnemonic(logLevel.toString().charAt(0));
        jCheckBoxMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.12
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
        return jCheckBoxMenuItem;
    }

    protected LogRecordFilter createNDCLogRecordFilter(String str) {
        this._NDCTextFilter = str;
        return new LogRecordFilter() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.4
            @Override // org.apache.log4j.lf5.LogRecordFilter
            public boolean passes(LogRecord logRecord) {
                String ndc = logRecord.getNDC();
                CategoryPath categoryPath = new CategoryPath(logRecord.getCategory());
                if (ndc == null || LogBrokerMonitor.this._NDCTextFilter == null || ndc.toLowerCase().indexOf(LogBrokerMonitor.this._NDCTextFilter.toLowerCase()) == -1 || !LogBrokerMonitor.this.getMenuItem(logRecord.getLevel()).isSelected() || !LogBrokerMonitor.this._categoryExplorerTree.getExplorerModel().isCategoryPathActive(categoryPath)) {
                    return false;
                }
                return true;
            }
        };
    }

    protected JMenuItem createNoLogLevelsMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Hide all LogLevels");
        jMenuItem.setMnemonic('h');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.9
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.selectAllLogLevels(false);
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createNoLogTableColumnsMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Hide all Columns");
        jMenuItem.setMnemonic('h');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.15
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.selectAllLogTableColumns(false);
                LogBrokerMonitor.this._table.setView(LogBrokerMonitor.this.updateView());
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createOpenMI() {
        JMenuItem jMenuItem = new JMenuItem("Open...");
        jMenuItem.setMnemonic('o');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.16
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.requestOpen();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createOpenURLMI() {
        JMenuItem jMenuItem = new JMenuItem("Open URL...");
        jMenuItem.setMnemonic('u');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.17
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.requestOpenURL();
            }
        });
        return jMenuItem;
    }

    protected JMenuItem createResetLogLevelColorMenuItem() {
        JMenuItem jMenuItem = new JMenuItem("Reset LogLevel Colors");
        jMenuItem.setMnemonic('r');
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.10
            public void actionPerformed(ActionEvent actionEvent) {
                LogLevel.resetLogLevelColorMap();
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
            }
        });
        return jMenuItem;
    }

    protected JPanel createStatusArea() {
        JPanel jPanel = new JPanel();
        JLabel jLabel = new JLabel("No log records to display.");
        this._statusLabel = jLabel;
        jLabel.setHorizontalAlignment(2);
        jPanel.setBorder(BorderFactory.createEtchedBorder());
        jPanel.setLayout(new FlowLayout(0, 0, 0));
        jPanel.add(jLabel);
        return jPanel;
    }

    protected JMenuItem createSubMenuItem(final LogLevel logLevel) {
        final JMenuItem jMenuItem = new JMenuItem(logLevel.toString());
        jMenuItem.setMnemonic(logLevel.toString().charAt(0));
        jMenuItem.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.11
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this.showLogLevelColorChangeDialog(jMenuItem, logLevel);
            }
        });
        return jMenuItem;
    }

    protected JToolBar createToolBar() {
        JToolBar jToolBar = new JToolBar();
        jToolBar.putClientProperty("JToolBar.isRollover", Boolean.TRUE);
        JComboBox jComboBox = new JComboBox();
        JComboBox jComboBox2 = new JComboBox();
        this._fontSizeCombo = jComboBox2;
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        URL resource = classLoader.getResource("org/apache/log4j/lf5/viewer/images/channelexplorer_new.gif");
        ImageIcon imageIcon = resource != null ? new ImageIcon(resource) : null;
        JButton jButton = new JButton("Clear Log Table");
        if (imageIcon != null) {
            jButton.setIcon(imageIcon);
        }
        jButton.setToolTipText("Clear Log Table.");
        jButton.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.29
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this._table.clearLogRecords();
                LogBrokerMonitor.this._categoryExplorerTree.getExplorerModel().resetAllNodeCounts();
                LogBrokerMonitor.this.updateStatusLabel();
                LogBrokerMonitor.this.clearDetailTextArea();
                LogRecord.resetSequenceNumber();
            }
        });
        for (String str : this._loadSystemFonts ? GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames() : Toolkit.getDefaultToolkit().getFontList()) {
            jComboBox.addItem(str);
        }
        jComboBox.setSelectedItem(this._fontName);
        jComboBox.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.30
            public void actionPerformed(ActionEvent actionEvent) {
                String str2 = (String) ((JComboBox) actionEvent.getSource()).getSelectedItem();
                LogBrokerMonitor.this._table.setFont(new Font(str2, 0, LogBrokerMonitor.this._fontSize));
                LogBrokerMonitor.this._fontName = str2;
            }
        });
        jComboBox2.addItem("8");
        jComboBox2.addItem("9");
        jComboBox2.addItem("10");
        jComboBox2.addItem("12");
        jComboBox2.addItem("14");
        jComboBox2.addItem("16");
        jComboBox2.addItem("18");
        jComboBox2.addItem("24");
        jComboBox2.setSelectedItem(String.valueOf(this._fontSize));
        jComboBox2.addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.31
            public void actionPerformed(ActionEvent actionEvent) {
                int iIntValue = Integer.valueOf((String) ((JComboBox) actionEvent.getSource()).getSelectedItem()).intValue();
                LogBrokerMonitor.this.setFontSizeSilently(iIntValue);
                LogBrokerMonitor.this.refreshDetailTextArea();
                LogBrokerMonitor.this._fontSize = iIntValue;
            }
        });
        jToolBar.add(new JLabel(" Font: "));
        jToolBar.add(jComboBox);
        jToolBar.add(jComboBox2);
        jToolBar.addSeparator();
        jToolBar.addSeparator();
        jToolBar.add(jButton);
        jButton.setAlignmentY(0.5f);
        jButton.setAlignmentX(0.5f);
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        jComboBox2.setMaximumSize(jComboBox2.getPreferredSize());
        return jToolBar;
    }

    protected JMenu createViewMenu() {
        JMenu jMenu = new JMenu("View");
        jMenu.setMnemonic('v');
        Iterator logTableColumns = getLogTableColumns();
        while (logTableColumns.hasNext()) {
            jMenu.add(getLogTableColumnMenuItem((LogTableColumn) logTableColumns.next()));
        }
        jMenu.addSeparator();
        jMenu.add(createAllLogTableColumnsMenuItem());
        jMenu.add(createNoLogTableColumnsMenuItem());
        return jMenu;
    }

    public void dispose() {
        this._logMonitorFrame.dispose();
        this._isDisposed = true;
        if (this._callSystemExitOnClose) {
            System.exit(0);
        }
    }

    protected void findSearchText() {
        String str = this._searchText;
        if (str == null || str.length() == 0) {
            return;
        }
        selectRow(findRecord(getFirstSelectedRow(), str, this._table.getFilteredLogTableModel().getFilteredRecords()));
    }

    public JFrame getBaseFrame() {
        return this._logMonitorFrame;
    }

    public boolean getCallSystemExitOnClose() {
        return this._callSystemExitOnClose;
    }

    public CategoryExplorerTree getCategoryExplorerTree() {
        return this._categoryExplorerTree;
    }

    public DateFormatManager getDateFormatManager() {
        return this._table.getDateFormatManager();
    }

    protected int getFirstSelectedRow() {
        return this._table.getSelectionModel().getMinSelectionIndex();
    }

    public Map getLogLevelMenuItems() {
        return this._logLevelMenuItems;
    }

    protected Iterator getLogLevels() {
        return this._levels.iterator();
    }

    protected JCheckBoxMenuItem getLogTableColumnMenuItem(LogTableColumn logTableColumn) {
        JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) this._logTableColumnMenuItems.get(logTableColumn);
        if (jCheckBoxMenuItem != null) {
            return jCheckBoxMenuItem;
        }
        JCheckBoxMenuItem jCheckBoxMenuItemCreateLogTableColumnMenuItem = createLogTableColumnMenuItem(logTableColumn);
        this._logTableColumnMenuItems.put(logTableColumn, jCheckBoxMenuItemCreateLogTableColumnMenuItem);
        return jCheckBoxMenuItemCreateLogTableColumnMenuItem;
    }

    public Map getLogTableColumnMenuItems() {
        return this._logTableColumnMenuItems;
    }

    protected Iterator getLogTableColumns() {
        return this._columns.iterator();
    }

    protected JCheckBoxMenuItem getMenuItem(LogLevel logLevel) {
        JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) this._logLevelMenuItems.get(logLevel);
        if (jCheckBoxMenuItem != null) {
            return jCheckBoxMenuItem;
        }
        JCheckBoxMenuItem jCheckBoxMenuItemCreateMenuItem = createMenuItem(logLevel);
        this._logLevelMenuItems.put(logLevel, jCheckBoxMenuItemCreateMenuItem);
        return jCheckBoxMenuItemCreateMenuItem;
    }

    public String getNDCTextFilter() {
        return this._NDCTextFilter;
    }

    protected String getRecordsDisplayedMessage() {
        FilteredLogTableModel filteredLogTableModel = this._table.getFilteredLogTableModel();
        return getStatusText(filteredLogTableModel.getRowCount(), filteredLogTableModel.getTotalRowCount());
    }

    protected String getStatusText(int i10, int i11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Displaying: ");
        stringBuffer.append(i10);
        stringBuffer.append(" records out of a total of: ");
        stringBuffer.append(i11);
        stringBuffer.append(" records.");
        return stringBuffer.toString();
    }

    public void hide() {
        this._logMonitorFrame.setVisible(false);
    }

    protected void initComponents() {
        JFrame jFrame = new JFrame("LogFactor5");
        this._logMonitorFrame = jFrame;
        jFrame.setDefaultCloseOperation(0);
        URL resource = getClass().getResource("/org/apache/log4j/lf5/viewer/images/lf5_small_icon.gif");
        if (resource != null) {
            this._logMonitorFrame.setIconImage(new ImageIcon(resource).getImage());
        }
        updateFrameSize();
        JTextArea jTextAreaCreateDetailTextArea = createDetailTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextAreaCreateDetailTextArea);
        LogTable logTable = new LogTable(jTextAreaCreateDetailTextArea);
        this._table = logTable;
        setView(this._currentView, logTable);
        this._table.setFont(new Font(this._fontName, 0, this._fontSize));
        JScrollPane jScrollPane2 = new JScrollPane(this._table);
        this._logTableScrollPane = jScrollPane2;
        if (this._trackTableScrollPane) {
            jScrollPane2.getVerticalScrollBar().addAdjustmentListener(new TrackingAdjustmentListener());
        }
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setOneTouchExpandable(true);
        jSplitPane.setOrientation(0);
        jSplitPane.setLeftComponent(this._logTableScrollPane);
        jSplitPane.setRightComponent(jScrollPane);
        jSplitPane.setDividerLocation(350);
        this._categoryExplorerTree = new CategoryExplorerTree();
        this._table.getFilteredLogTableModel().setLogRecordFilter(createLogRecordFilter());
        JScrollPane jScrollPane3 = new JScrollPane(this._categoryExplorerTree);
        jScrollPane3.setPreferredSize(new Dimension(130, 400));
        this._mruFileManager = new MRUFileManager();
        JSplitPane jSplitPane2 = new JSplitPane();
        jSplitPane2.setOneTouchExpandable(true);
        jSplitPane2.setRightComponent(jSplitPane);
        jSplitPane2.setLeftComponent(jScrollPane3);
        jSplitPane2.setDividerLocation(130);
        this._logMonitorFrame.getRootPane().setJMenuBar(createMenuBar());
        this._logMonitorFrame.getContentPane().add(jSplitPane2, "Center");
        this._logMonitorFrame.getContentPane().add(createToolBar(), "North");
        this._logMonitorFrame.getContentPane().add(createStatusArea(), "South");
        makeLogTableListenToCategoryExplorer();
        addTableModelProperties();
        this._configurationManager = new ConfigurationManager(this, this._table);
    }

    protected void makeLogTableListenToCategoryExplorer() {
        this._categoryExplorerTree.getExplorerModel().addActionListener(new ActionListener() { // from class: org.apache.log4j.lf5.viewer.LogBrokerMonitor.7
            public void actionPerformed(ActionEvent actionEvent) {
                LogBrokerMonitor.this._table.getFilteredLogTableModel().refresh();
                LogBrokerMonitor.this.updateStatusLabel();
            }
        });
    }

    protected void refreshDetailTextArea() {
        refresh(this._table._detailTextArea);
    }

    protected void requestExit() {
        this._mruFileManager.save();
        setCallSystemExitOnClose(true);
        closeAfterConfirm();
    }

    protected void requestOpen() {
        JFileChooser jFileChooser = this._fileLocation == null ? new JFileChooser() : new JFileChooser(this._fileLocation);
        if (jFileChooser.showOpenDialog(this._logMonitorFrame) == 0) {
            File selectedFile = jFileChooser.getSelectedFile();
            if (loadLogFile(selectedFile)) {
                this._fileLocation = jFileChooser.getSelectedFile();
                this._mruFileManager.set(selectedFile);
                updateMRUList();
            }
        }
    }

    protected void requestOpenURL() {
        String text = new LogFactor5InputDialog(getBaseFrame(), "Open URL", "URL:").getText();
        if (text != null) {
            if (text.indexOf("://") == -1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("http://");
                stringBuffer.append(text);
                text = stringBuffer.toString();
            }
            try {
                URL url = new URL(text);
                if (loadLogFile(url)) {
                    this._mruFileManager.set(url);
                    updateMRUList();
                }
            } catch (MalformedURLException unused) {
                new LogFactor5ErrorDialog(getBaseFrame(), "Error reading URL.");
            }
        }
    }

    protected void resetConfiguration() {
        this._configurationManager.reset();
    }

    protected void saveConfiguration() {
        this._configurationManager.save();
    }

    public void setCallSystemExitOnClose(boolean z10) {
        this._callSystemExitOnClose = z10;
    }

    public void setDateFormatManager(DateFormatManager dateFormatManager) {
        this._table.setDateFormatManager(dateFormatManager);
    }

    protected void setFontSize(Component component, int i10) {
        Font font = component.getFont();
        component.setFont(new Font(font.getFontName(), font.getStyle(), i10));
    }

    protected void setFontSizeSilently(int i10) {
        this._fontSize = i10;
        setFontSize(this._table._detailTextArea, i10);
        selectRow(0);
        setFontSize(this._table, i10);
    }

    protected void setLeastSevereDisplayedLogLevel(LogLevel logLevel) {
        if (logLevel == null || this._leastSevereDisplayedLogLevel == logLevel) {
            return;
        }
        this._leastSevereDisplayedLogLevel = logLevel;
        this._table.getFilteredLogTableModel().refresh();
        updateStatusLabel();
    }

    public void setMaxNumberOfLogRecords(int i10) {
        this._table.getFilteredLogTableModel().setMaxNumberOfLogRecords(i10);
    }

    protected void setMaxRecordConfiguration() {
        String text = new LogFactor5InputDialog(getBaseFrame(), "Set Max Number of Records", "", 10).getText();
        if (text != null) {
            try {
                setMaxNumberOfLogRecords(Integer.parseInt(text));
            } catch (NumberFormatException unused) {
                JFrame baseFrame = getBaseFrame();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("'");
                stringBuffer.append(text);
                stringBuffer.append("' is an invalid parameter.\nPlease try again.");
                new LogFactor5ErrorDialog(baseFrame, stringBuffer.toString());
                setMaxRecordConfiguration();
            }
        }
    }

    public void setNDCLogRecordFilter(String str) {
        this._table.getFilteredLogTableModel().setLogRecordFilter(createNDCLogRecordFilter(str));
    }

    protected void setNDCTextFilter(String str) {
        if (str == null) {
            this._NDCTextFilter = "";
        } else {
            this._NDCTextFilter = str;
        }
    }

    protected void setSearchText(String str) {
        this._searchText = str;
    }

    public void setTitle(String str) {
        JFrame jFrame = this._logMonitorFrame;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(" - LogFactor5");
        jFrame.setTitle(stringBuffer.toString());
    }

    protected void setView(String str, LogTable logTable) {
        if (DETAILED_VIEW.equals(str)) {
            logTable.setDetailedView();
            this._currentView = str;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("does not match a supported view.");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
    }

    protected void showLogLevelColorChangeDialog(JMenuItem jMenuItem, LogLevel logLevel) {
        Color colorShowDialog = JColorChooser.showDialog(this._logMonitorFrame, "Choose LogLevel Color", jMenuItem.getForeground());
        if (colorShowDialog != null) {
            logLevel.setLogLevelColorMap(logLevel, colorShowDialog);
            this._table.getFilteredLogTableModel().refresh();
        }
    }

    protected void showPropertiesDialog(String str) {
        JOptionPane.showMessageDialog(this._logMonitorFrame, this._displayedLogBrokerProperties.toArray(), str, -1);
    }

    protected void sortByNDC() {
        String str = this._NDCTextFilter;
        if (str == null || str.length() == 0) {
            return;
        }
        this._table.getFilteredLogTableModel().setLogRecordFilter(createNDCLogRecordFilter(str));
    }

    protected void updateFrameSize() {
        this._logMonitorFrame.setSize(this._logMonitorFrameWidth, this._logMonitorFrameHeight);
        centerFrame(this._logMonitorFrame);
    }

    protected void updateMRUList() {
        JMenu menu = this._logMonitorFrame.getJMenuBar().getMenu(0);
        menu.removeAll();
        menu.add(createOpenMI());
        menu.add(createOpenURLMI());
        menu.addSeparator();
        menu.add(createCloseMI());
        createMRUFileListMI(menu);
        menu.addSeparator();
        menu.add(createExitMI());
    }

    protected void updateStatusLabel() {
        this._statusLabel.setText(getRecordsDisplayedMessage());
    }

    protected List updateView() {
        ArrayList arrayList = new ArrayList();
        for (LogTableColumn logTableColumn : this._columns) {
            if (getLogTableColumnMenuItem(logTableColumn).isSelected()) {
                arrayList.add(logTableColumn);
            }
        }
        return arrayList;
    }

    public LogBrokerMonitor(List list) {
        this._callSystemExitOnClose = false;
        this._columns = null;
        this._levels = list;
        this._columns = LogTableColumn.getLogTableColumns();
        String property = System.getProperty("monitor.exit");
        if ((property == null ? "false" : property).trim().toLowerCase().equals("true")) {
            this._callSystemExitOnClose = true;
        }
        initComponents();
        this._logMonitorFrame.addWindowListener(new LogBrokerMonitorWindowAdaptor(this));
    }

    protected void centerFrame(JFrame jFrame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = jFrame.getSize();
        jFrame.setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
    }

    protected int changeFontSizeCombo(JComboBox jComboBox, int i10) {
        int itemCount = jComboBox.getItemCount();
        Object itemAt = jComboBox.getItemAt(0);
        int i11 = Integer.parseInt(String.valueOf(itemAt));
        for (int i12 = 0; i12 < itemCount; i12++) {
            Object itemAt2 = jComboBox.getItemAt(i12);
            int i13 = Integer.parseInt(String.valueOf(itemAt2));
            if (i11 < i13 && i13 <= i10) {
                itemAt = itemAt2;
                i11 = i13;
            }
        }
        jComboBox.setSelectedItem(itemAt);
        return i11;
    }

    public JCheckBoxMenuItem getTableColumnMenuItem(LogTableColumn logTableColumn) {
        return getLogTableColumnMenuItem(logTableColumn);
    }

    protected boolean matches(LogRecord logRecord, String str) {
        String message = logRecord.getMessage();
        String ndc = logRecord.getNDC();
        if ((message == null && ndc == null) || str == null) {
            return false;
        }
        if (message.toLowerCase().indexOf(str.toLowerCase()) == -1 && ndc.toLowerCase().indexOf(str.toLowerCase()) == -1) {
            return false;
        }
        return true;
    }

    protected void refresh(JTextArea jTextArea) {
        String text = jTextArea.getText();
        jTextArea.setText("");
        jTextArea.setText(text);
    }

    protected void requestOpenMRU(ActionEvent actionEvent) {
        StringTokenizer stringTokenizer = new StringTokenizer(actionEvent.getActionCommand());
        String strTrim = stringTokenizer.nextToken().trim();
        String strNextToken = stringTokenizer.nextToken("\n");
        try {
            int i10 = Integer.parseInt(strTrim) - 1;
            new LogFileParser(this._mruFileManager.getInputStream(i10)).parse(this);
            this._mruFileManager.moveToTop(i10);
            updateMRUList();
        } catch (Exception unused) {
            JFrame baseFrame = getBaseFrame();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unable to load file ");
            stringBuffer.append(strNextToken);
            new LogFactor5ErrorDialog(baseFrame, stringBuffer.toString());
        }
    }

    protected void selectAllLogLevels(boolean z10) {
        Iterator logLevels = getLogLevels();
        while (logLevels.hasNext()) {
            getMenuItem((LogLevel) logLevels.next()).setSelected(z10);
        }
    }

    protected void selectAllLogTableColumns(boolean z10) {
        Iterator logTableColumns = getLogTableColumns();
        while (logTableColumns.hasNext()) {
            getLogTableColumnMenuItem((LogTableColumn) logTableColumns.next()).setSelected(z10);
        }
    }

    public void setFrameSize(int i10, int i11) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (i10 > 0 && i10 < screenSize.width) {
            this._logMonitorFrameWidth = i10;
        }
        if (i11 > 0 && i11 < screenSize.height) {
            this._logMonitorFrameHeight = i11;
        }
        updateFrameSize();
    }

    public void show() {
        show(0);
    }

    protected boolean loadLogFile(URL url) {
        try {
            new LogFileParser(url.openStream()).parse(this);
            return true;
        } catch (IOException unused) {
            JFrame baseFrame = getBaseFrame();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Error reading URL:");
            stringBuffer.append(url.getFile());
            new LogFactor5ErrorDialog(baseFrame, stringBuffer.toString());
            return false;
        }
    }

    protected void trackTableScrollPane() {
    }
}
