package org.apache.log4j.spi;

import java.io.PrintWriter;
import java.util.Vector;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class VectorWriter extends PrintWriter {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Vector f17071v;

    @Override // java.io.PrintWriter
    public void print(Object obj) {
        this.f17071v.addElement(String.valueOf(obj));
    }

    @Override // java.io.PrintWriter
    public void println(Object obj) {
        this.f17071v.addElement(String.valueOf(obj));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr) {
        this.f17071v.addElement(new String(cArr));
    }

    VectorWriter() {
        super(new NullWriter());
        this.f17071v = new Vector();
    }

    @Override // java.io.PrintWriter
    public void print(char[] cArr) {
        this.f17071v.addElement(new String(cArr));
    }

    @Override // java.io.PrintWriter
    public void println(char[] cArr) {
        this.f17071v.addElement(new String(cArr));
    }

    public String[] toStringArray() {
        int size = this.f17071v.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = (String) this.f17071v.elementAt(i10);
        }
        return strArr;
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(char[] cArr, int i10, int i11) {
        this.f17071v.addElement(new String(cArr, i10, i11));
    }

    @Override // java.io.PrintWriter
    public void print(String str) {
        this.f17071v.addElement(str);
    }

    @Override // java.io.PrintWriter
    public void println(String str) {
        this.f17071v.addElement(str);
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str, int i10, int i11) {
        this.f17071v.addElement(str.substring(i10, i11 + i10));
    }

    @Override // java.io.PrintWriter, java.io.Writer
    public void write(String str) {
        this.f17071v.addElement(str);
    }
}
