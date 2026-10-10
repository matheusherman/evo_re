package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import org.apache.log4j.helpers.LogLog;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class NDC {
    static final int REAP_THRESHOLD = 5;
    static Hashtable ht = new Hashtable();
    static int pushCounter = 0;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    private static class DiagnosticContext {
        String fullMessage;
        String message;

        DiagnosticContext(String str, DiagnosticContext diagnosticContext) {
            this.message = str;
            if (diagnosticContext != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(diagnosticContext.fullMessage);
                stringBuffer.append(' ');
                stringBuffer.append(str);
                this.fullMessage = stringBuffer.toString();
                return;
            }
            this.fullMessage = str;
        }
    }

    private static Stack getCurrentStack() {
        Hashtable hashtable = ht;
        if (hashtable != null) {
            return (Stack) hashtable.get(Thread.currentThread());
        }
        return null;
    }

    public static void inherit(Stack stack) {
        if (stack != null) {
            ht.put(Thread.currentThread(), stack);
        }
    }

    private static void lazyRemove() {
        int i10;
        Thread thread;
        Hashtable hashtable = ht;
        if (hashtable == null) {
            return;
        }
        synchronized (hashtable) {
            try {
                int i11 = pushCounter + 1;
                pushCounter = i11;
                if (i11 <= 5) {
                    return;
                }
                pushCounter = 0;
                Vector vector = new Vector();
                Enumeration enumerationKeys = ht.keys();
                loop0: while (true) {
                    while (true) {
                        if (!enumerationKeys.hasMoreElements() || i10 > 4) {
                            break loop0;
                        }
                        thread = (Thread) enumerationKeys.nextElement();
                        i10 = thread.isAlive() ? i10 + 1 : 0;
                    }
                    vector.addElement(thread);
                }
                int size = vector.size();
                for (int i12 = 0; i12 < size; i12++) {
                    Thread thread2 = (Thread) vector.elementAt(i12);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Lazy NDC removal for thread [");
                    stringBuffer.append(thread2.getName());
                    stringBuffer.append("] (");
                    stringBuffer.append(ht.size());
                    stringBuffer.append(").");
                    LogLog.debug(stringBuffer.toString());
                    ht.remove(thread2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void remove() {
        Hashtable hashtable = ht;
        if (hashtable != null) {
            hashtable.remove(Thread.currentThread());
            lazyRemove();
        }
    }

    private NDC() {
    }

    public static void clear() {
        Stack currentStack = getCurrentStack();
        if (currentStack != null) {
            currentStack.setSize(0);
        }
    }

    public static Stack cloneStack() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            return null;
        }
        return (Stack) currentStack.clone();
    }

    public static String get() {
        Stack currentStack = getCurrentStack();
        if (currentStack != null && !currentStack.isEmpty()) {
            return ((DiagnosticContext) currentStack.peek()).fullMessage;
        }
        return null;
    }

    public static int getDepth() {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            return 0;
        }
        return currentStack.size();
    }

    public static String peek() {
        Stack currentStack = getCurrentStack();
        if (currentStack != null && !currentStack.isEmpty()) {
            return ((DiagnosticContext) currentStack.peek()).message;
        }
        return "";
    }

    public static String pop() {
        Stack currentStack = getCurrentStack();
        if (currentStack != null && !currentStack.isEmpty()) {
            return ((DiagnosticContext) currentStack.pop()).message;
        }
        return "";
    }

    public static void push(String str) {
        Stack currentStack = getCurrentStack();
        if (currentStack == null) {
            DiagnosticContext diagnosticContext = new DiagnosticContext(str, null);
            Stack stack = new Stack();
            ht.put(Thread.currentThread(), stack);
            stack.push(diagnosticContext);
            return;
        }
        if (currentStack.isEmpty()) {
            currentStack.push(new DiagnosticContext(str, null));
        } else {
            currentStack.push(new DiagnosticContext(str, (DiagnosticContext) currentStack.peek()));
        }
    }

    public static void setMaxDepth(int i10) {
        Stack currentStack = getCurrentStack();
        if (currentStack != null && i10 < currentStack.size()) {
            currentStack.setSize(i10);
        }
    }
}
