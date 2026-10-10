package org.apache.log4j.lf5.viewer.configure;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class MRUFileManager {
    private static final String CONFIG_FILE_NAME = "mru_file_manager";
    private static final int DEFAULT_MAX_SIZE = 3;
    private int _maxSize = 0;
    private LinkedList _mruFileList;

    public MRUFileManager() {
        load();
        setMaxSize(3);
    }

    public InputStream getInputStream(int i10) {
        if (i10 >= size()) {
            return null;
        }
        Object file = getFile(i10);
        return file instanceof File ? getInputStream((File) file) : getInputStream((URL) file);
    }

    public void set(File file) {
        setMRU(file);
    }

    public static void createConfigurationDirectory() {
        String property = System.getProperty("user.home");
        String property2 = System.getProperty("file.separator");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(property);
        stringBuffer.append(property2);
        stringBuffer.append("lf5");
        File file = new File(stringBuffer.toString());
        if (file.exists()) {
            return;
        }
        try {
            file.mkdir();
        } catch (SecurityException e10) {
            e10.printStackTrace();
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

    public void moveToTop(int i10) {
        LinkedList linkedList = this._mruFileList;
        linkedList.add(0, linkedList.remove(i10));
    }

    public void save() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(getFilename())));
            objectOutputStream.writeObject(this._mruFileList);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void set(URL url) {
        setMRU(url);
    }

    protected void setMRU(Object obj) {
        int iIndexOf = this._mruFileList.indexOf(obj);
        if (iIndexOf != -1) {
            moveToTop(iIndexOf);
        } else {
            this._mruFileList.add(0, obj);
            setMaxSize(this._maxSize);
        }
    }

    protected void setMaxSize(int i10) {
        if (i10 < this._mruFileList.size()) {
            for (int i11 = 0; i11 < this._mruFileList.size() - i10; i11++) {
                this._mruFileList.removeLast();
            }
        }
        this._maxSize = i10;
    }

    public int size() {
        return this._mruFileList.size();
    }

    public Object getFile(int i10) {
        if (i10 < size()) {
            return this._mruFileList.get(i10);
        }
        return null;
    }

    public String[] getMRUFileList() {
        if (size() == 0) {
            return null;
        }
        String[] strArr = new String[size()];
        for (int i10 = 0; i10 < size(); i10++) {
            Object file = getFile(i10);
            if (file instanceof File) {
                strArr[i10] = ((File) file).getAbsolutePath();
            } else {
                strArr[i10] = file.toString();
            }
        }
        return strArr;
    }

    protected void load() {
        createConfigurationDirectory();
        File file = new File(getFilename());
        if (file.exists()) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
                this._mruFileList = (LinkedList) objectInputStream.readObject();
                objectInputStream.close();
                Iterator it = this._mruFileList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (!(next instanceof File) && !(next instanceof URL)) {
                        it.remove();
                    }
                }
                return;
            } catch (Exception unused) {
                this._mruFileList = new LinkedList();
                return;
            }
        }
        this._mruFileList = new LinkedList();
    }

    public MRUFileManager(int i10) {
        load();
        setMaxSize(i10);
    }

    protected InputStream getInputStream(File file) {
        return new BufferedInputStream(new FileInputStream(file));
    }

    protected InputStream getInputStream(URL url) {
        return url.openStream();
    }
}
