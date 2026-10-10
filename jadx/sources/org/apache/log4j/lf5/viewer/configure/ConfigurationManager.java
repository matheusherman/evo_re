package org.apache.log4j.lf5.viewer.configure;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.tree.TreePath;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogLevelFormatException;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.apache.log4j.lf5.viewer.LogTable;
import org.apache.log4j.lf5.viewer.LogTableColumn;
import org.apache.log4j.lf5.viewer.LogTableColumnFormatException;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerModel;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryExplorerTree;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryNode;
import org.apache.log4j.lf5.viewer.categoryexplorer.CategoryPath;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class ConfigurationManager {
    private static final String BLUE = "blue";
    private static final String CATEGORY = "category";
    private static final String COLORLEVEL = "colorlevel";
    private static final String COLUMN = "column";
    private static final String CONFIG_FILE_NAME = "lf5_configuration.xml";
    private static final String EXPANDED = "expanded";
    private static final String FIRST_CATEGORY_NAME = "Categories";
    private static final String GREEN = "green";
    private static final String LEVEL = "level";
    private static final String NAME = "name";
    private static final String NDCTEXTFILTER = "searchtext";
    private static final String PATH = "path";
    private static final String RED = "red";
    private static final String SELECTED = "selected";
    private LogBrokerMonitor _monitor;
    private LogTable _table;

    protected void processLogLevelColors(Document document) {
        Node nodeItem;
        NodeList elementsByTagName = document.getElementsByTagName(COLORLEVEL);
        LogLevel.getLogLevelColorMap();
        for (int i10 = 0; i10 < elementsByTagName.getLength() && (nodeItem = elementsByTagName.item(i10)) != null; i10++) {
            NamedNodeMap attributes = nodeItem.getAttributes();
            try {
                LogLevel logLevelValueOf = LogLevel.valueOf(getValue(attributes, NAME));
                Color color = new Color(Integer.parseInt(getValue(attributes, RED)), Integer.parseInt(getValue(attributes, GREEN)), Integer.parseInt(getValue(attributes, BLUE)));
                if (logLevelValueOf != null) {
                    logLevelValueOf.setLogLevelColorMap(logLevelValueOf, color);
                }
            } catch (LogLevelFormatException unused) {
            }
        }
    }

    protected void processLogLevels(Document document) {
        NodeList elementsByTagName = document.getElementsByTagName(LEVEL);
        Map logLevelMenuItems = this._monitor.getLogLevelMenuItems();
        for (int i10 = 0; i10 < elementsByTagName.getLength(); i10++) {
            NamedNodeMap attributes = elementsByTagName.item(i10).getAttributes();
            try {
                ((JCheckBoxMenuItem) logLevelMenuItems.get(LogLevel.valueOf(getValue(attributes, NAME)))).setSelected(getValue(attributes, "selected").equalsIgnoreCase("true"));
            } catch (LogLevelFormatException unused) {
            }
        }
    }

    protected void processLogTableColumns(Document document) {
        Node nodeItem;
        NodeList elementsByTagName = document.getElementsByTagName(COLUMN);
        Map logTableColumnMenuItems = this._monitor.getLogTableColumnMenuItems();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < elementsByTagName.getLength() && (nodeItem = elementsByTagName.item(i10)) != null; i10++) {
            NamedNodeMap attributes = nodeItem.getAttributes();
            try {
                LogTableColumn logTableColumnValueOf = LogTableColumn.valueOf(getValue(attributes, NAME));
                JCheckBoxMenuItem jCheckBoxMenuItem = (JCheckBoxMenuItem) logTableColumnMenuItems.get(logTableColumnValueOf);
                jCheckBoxMenuItem.setSelected(getValue(attributes, "selected").equalsIgnoreCase("true"));
                if (jCheckBoxMenuItem.isSelected()) {
                    arrayList.add(logTableColumnValueOf);
                }
            } catch (LogTableColumnFormatException unused) {
            }
            if (arrayList.isEmpty()) {
                this._table.setDetailedView();
            } else {
                this._table.setView(arrayList);
            }
        }
    }

    private void closeConfigurationXML(StringBuffer stringBuffer) {
        stringBuffer.append("</configuration>\r\n");
    }

    private void exportLogLevelColorXMLElement(String str, Color color, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append(COLORLEVEL);
        stringBuffer.append(" ");
        stringBuffer.append(NAME);
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append(RED);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getRed());
        stringBuffer.append("\" ");
        stringBuffer.append(GREEN);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getGreen());
        stringBuffer.append("\" ");
        stringBuffer.append(BLUE);
        stringBuffer.append("=\"");
        stringBuffer.append(color.getBlue());
        stringBuffer.append("\"/>\r\n");
    }

    private void exportLogLevelXMLElement(String str, boolean z10, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append(LEVEL);
        stringBuffer.append(" ");
        stringBuffer.append(NAME);
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append("selected");
        stringBuffer.append("=\"");
        stringBuffer.append(z10);
        stringBuffer.append("\"/>\r\n");
    }

    private void exportLogTableColumnXMLElement(String str, boolean z10, StringBuffer stringBuffer) {
        stringBuffer.append("\t\t<");
        stringBuffer.append(COLUMN);
        stringBuffer.append(" ");
        stringBuffer.append(NAME);
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\" ");
        stringBuffer.append("selected");
        stringBuffer.append("=\"");
        stringBuffer.append(z10);
        stringBuffer.append("\"/>\r\n");
    }

    private void exportXMLElement(CategoryNode categoryNode, TreePath treePath, StringBuffer stringBuffer) {
        CategoryExplorerTree categoryExplorerTree = this._monitor.getCategoryExplorerTree();
        stringBuffer.append("\t<");
        stringBuffer.append(CATEGORY);
        stringBuffer.append(" ");
        stringBuffer.append(NAME);
        stringBuffer.append("=\"");
        stringBuffer.append(categoryNode.getTitle());
        stringBuffer.append("\" ");
        stringBuffer.append(PATH);
        stringBuffer.append("=\"");
        stringBuffer.append(treePathToString(treePath));
        stringBuffer.append("\" ");
        stringBuffer.append(EXPANDED);
        stringBuffer.append("=\"");
        stringBuffer.append(categoryExplorerTree.isExpanded(treePath));
        stringBuffer.append("\" ");
        stringBuffer.append("selected");
        stringBuffer.append("=\"");
        stringBuffer.append(categoryNode.isSelected());
        stringBuffer.append("\"/>\r\n");
    }

    private void openConfigurationXML(StringBuffer stringBuffer) {
        stringBuffer.append("<configuration>\r\n");
    }

    private void openXMLDocument(StringBuffer stringBuffer) {
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\r\n");
    }

    private void processConfigurationNode(CategoryNode categoryNode, StringBuffer stringBuffer) {
        CategoryExplorerModel explorerModel = this._monitor.getCategoryExplorerTree().getExplorerModel();
        Enumeration enumerationBreadthFirstEnumeration = categoryNode.breadthFirstEnumeration();
        while (enumerationBreadthFirstEnumeration.hasMoreElements()) {
            CategoryNode categoryNode2 = (CategoryNode) enumerationBreadthFirstEnumeration.nextElement();
            exportXMLElement(categoryNode2, explorerModel.getTreePathToRoot(categoryNode2), stringBuffer);
        }
    }

    private void processLogRecordFilter(String str, StringBuffer stringBuffer) {
        stringBuffer.append("\t<");
        stringBuffer.append(NDCTEXTFILTER);
        stringBuffer.append(" ");
        stringBuffer.append(NAME);
        stringBuffer.append("=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"");
        stringBuffer.append("/>\r\n");
    }

    public static String treePathToString(TreePath treePath) {
        StringBuffer stringBuffer = new StringBuffer();
        Object[] path = treePath.getPath();
        for (int i10 = 1; i10 < path.length; i10++) {
            CategoryNode categoryNode = (CategoryNode) path[i10];
            if (i10 > 1) {
                stringBuffer.append(".");
            }
            stringBuffer.append(categoryNode.getTitle());
        }
        return stringBuffer.toString();
    }

    protected void collapseTree() {
        CategoryExplorerTree categoryExplorerTree = this._monitor.getCategoryExplorerTree();
        for (int rowCount = categoryExplorerTree.getRowCount() - 1; rowCount > 0; rowCount--) {
            categoryExplorerTree.collapseRow(rowCount);
        }
    }

    protected void deleteConfigurationFile() {
        try {
            File file = new File(getFilename());
            if (file.exists()) {
                file.delete();
            }
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Cannot delete ");
            stringBuffer.append(getFilename());
            stringBuffer.append(" because a security violation occured.");
            printStream.println(stringBuffer.toString());
        }
    }

    protected String getFilename() {
        String property = System.getProperty("user.home");
        String property2 = System.getProperty("file.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(property);
        stringBuffer.append(property2);
        stringBuffer.append("lf5");
        stringBuffer.append(property2);
        stringBuffer.append(CONFIG_FILE_NAME);
        return stringBuffer.toString();
    }

    protected void load() {
        File file = new File(getFilename());
        if (file.exists()) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
                processRecordFilter(document);
                processCategories(document);
                processLogLevels(document);
                processLogLevelColors(document);
                processLogTableColumns(document);
            } catch (Exception e10) {
                PrintStream printStream = System.err;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable process configuration file at ");
                stringBuffer.append(getFilename());
                stringBuffer.append(". Error Message=");
                stringBuffer.append(e10.getMessage());
                printStream.println(stringBuffer.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
    protected void processCategories(Document document) {
        CategoryExplorerTree categoryExplorerTree = this._monitor.getCategoryExplorerTree();
        CategoryExplorerModel explorerModel = categoryExplorerTree.getExplorerModel();
        NodeList elementsByTagName = document.getElementsByTagName(CATEGORY);
        ?? EqualsIgnoreCase = getValue(elementsByTagName.item(0).getAttributes(), NAME).equalsIgnoreCase(FIRST_CATEGORY_NAME);
        for (int length = elementsByTagName.getLength() - 1; length >= EqualsIgnoreCase; length--) {
            NamedNodeMap attributes = elementsByTagName.item(length).getAttributes();
            CategoryNode categoryNodeAddCategory = explorerModel.addCategory(new CategoryPath(getValue(attributes, PATH)));
            categoryNodeAddCategory.setSelected(getValue(attributes, "selected").equalsIgnoreCase("true"));
            getValue(attributes, EXPANDED).equalsIgnoreCase("true");
            categoryExplorerTree.expandPath(explorerModel.getTreePathToRoot(categoryNodeAddCategory));
        }
    }

    protected void processRecordFilter(Document document) {
        String value;
        Node nodeItem = document.getElementsByTagName(NDCTEXTFILTER).item(0);
        if (nodeItem == null || (value = getValue(nodeItem.getAttributes(), NAME)) == null || value.equals("")) {
            return;
        }
        this._monitor.setNDCLogRecordFilter(value);
    }

    public void save() {
        CategoryNode rootCategoryNode = this._monitor.getCategoryExplorerTree().getExplorerModel().getRootCategoryNode();
        StringBuffer stringBuffer = new StringBuffer(2048);
        openXMLDocument(stringBuffer);
        openConfigurationXML(stringBuffer);
        processLogRecordFilter(this._monitor.getNDCTextFilter(), stringBuffer);
        processLogLevels(this._monitor.getLogLevelMenuItems(), stringBuffer);
        processLogLevelColors(this._monitor.getLogLevelMenuItems(), LogLevel.getLogLevelColorMap(), stringBuffer);
        processLogTableColumns(LogTableColumn.getLogTableColumns(), stringBuffer);
        processConfigurationNode(rootCategoryNode, stringBuffer);
        closeConfigurationXML(stringBuffer);
        store(stringBuffer.toString());
    }

    protected void selectAllNodes() {
        Enumeration enumerationBreadthFirstEnumeration = this._monitor.getCategoryExplorerTree().getExplorerModel().getRootCategoryNode().breadthFirstEnumeration();
        while (enumerationBreadthFirstEnumeration.hasMoreElements()) {
            ((CategoryNode) enumerationBreadthFirstEnumeration.nextElement()).setSelected(true);
        }
    }

    protected void store(String str) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(getFilename()));
            printWriter.print(str);
            printWriter.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public ConfigurationManager(LogBrokerMonitor logBrokerMonitor, LogTable logTable) {
        this._monitor = logBrokerMonitor;
        this._table = logTable;
        load();
    }

    protected String getValue(NamedNodeMap namedNodeMap, String str) {
        return namedNodeMap.getNamedItem(str).getNodeValue();
    }

    public void reset() {
        deleteConfigurationFile();
        collapseTree();
        selectAllNodes();
    }

    private void processLogLevels(Map map, StringBuffer stringBuffer) {
        stringBuffer.append("\t<loglevels>\r\n");
        for (LogLevel logLevel : map.keySet()) {
            exportLogLevelXMLElement(logLevel.getLabel(), ((JCheckBoxMenuItem) map.get(logLevel)).isSelected(), stringBuffer);
        }
        stringBuffer.append("\t</loglevels>\r\n");
    }

    private void processLogLevelColors(Map map, Map map2, StringBuffer stringBuffer) {
        stringBuffer.append("\t<loglevelcolors>\r\n");
        for (LogLevel logLevel : map.keySet()) {
            exportLogLevelColorXMLElement(logLevel.getLabel(), (Color) map2.get(logLevel), stringBuffer);
        }
        stringBuffer.append("\t</loglevelcolors>\r\n");
    }

    private void processLogTableColumns(List list, StringBuffer stringBuffer) {
        stringBuffer.append("\t<logtablecolumns>\r\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LogTableColumn logTableColumn = (LogTableColumn) it.next();
            exportLogTableColumnXMLElement(logTableColumn.getLabel(), this._monitor.getTableColumnMenuItem(logTableColumn).isSelected(), stringBuffer);
        }
        stringBuffer.append("\t</logtablecolumns>\r\n");
    }
}
