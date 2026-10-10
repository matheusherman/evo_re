package org.apache.log4j.lf5.viewer.categoryexplorer;

import java.util.LinkedList;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class CategoryPath {
    protected LinkedList _categoryElements = new LinkedList();

    public CategoryPath() {
    }

    public void addCategoryElement(CategoryElement categoryElement) {
        this._categoryElements.addLast(categoryElement);
    }

    public CategoryElement categoryElementAt(int i10) {
        return (CategoryElement) this._categoryElements.get(i10);
    }

    public boolean isEmpty() {
        return this._categoryElements.size() == 0;
    }

    public void removeAllCategoryElements() {
        this._categoryElements.clear();
    }

    public int size() {
        return this._categoryElements.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("\n");
        stringBuffer.append("===========================\n");
        stringBuffer.append("CategoryPath:                   \n");
        stringBuffer.append("---------------------------\n");
        stringBuffer.append("\nCategoryPath:\n\t");
        if (size() > 0) {
            for (int i10 = 0; i10 < size(); i10++) {
                stringBuffer.append(categoryElementAt(i10).toString());
                stringBuffer.append("\n\t");
            }
        } else {
            stringBuffer.append("<<NONE>>");
        }
        stringBuffer.append("\n");
        stringBuffer.append("===========================\n");
        return stringBuffer.toString();
    }

    public CategoryPath(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer((str == null ? "Debug" : str).replace('/', '.').replace('\\', '.'), ".");
        while (stringTokenizer.hasMoreTokens()) {
            addCategoryElement(new CategoryElement(stringTokenizer.nextToken()));
        }
    }
}
