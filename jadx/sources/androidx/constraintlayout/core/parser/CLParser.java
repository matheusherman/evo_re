package androidx.constraintlayout.core.parser;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class CLParser {
    static boolean sDebug;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public static CLObject parse(String str) {
        return new CLParser(str).parse();
    }

    private CLElement createElement(CLElement cLElement, int i10, TYPE type, boolean z10, char[] cArr) {
        CLElement cLElementAllocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i10]);
        }
        switch (type.ordinal()) {
            case 1:
                cLElementAllocate = CLObject.allocate(cArr);
                i10++;
                break;
            case 2:
                cLElementAllocate = CLArray.allocate(cArr);
                i10++;
                break;
            case 3:
                cLElementAllocate = CLNumber.allocate(cArr);
                break;
            case 4:
                cLElementAllocate = CLString.allocate(cArr);
                break;
            case 5:
                cLElementAllocate = CLKey.allocate(cArr);
                break;
            case 6:
                cLElementAllocate = CLToken.allocate(cArr);
                break;
            default:
                cLElementAllocate = null;
                break;
        }
        if (cLElementAllocate == null) {
            return null;
        }
        cLElementAllocate.setLine(this.mLineNumber);
        if (z10) {
            cLElementAllocate.setStart(i10);
        }
        if (cLElement instanceof CLContainer) {
            cLElementAllocate.setContainer((CLContainer) cLElement);
        }
        return cLElementAllocate;
    }

    private CLElement getNextJsonElement(int i10, char c10, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c10 != '\t' && c10 != '\n' && c10 != '\r' && c10 != ' ') {
            if (c10 == '\"' || c10 == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i10, TYPE.KEY, true, cArr) : createElement(cLElement, i10, TYPE.STRING, true, cArr);
            }
            if (c10 == '[') {
                return createElement(cLElement, i10, TYPE.ARRAY, true, cArr);
            }
            if (c10 != ']') {
                if (c10 == '{') {
                    return createElement(cLElement, i10, TYPE.OBJECT, true, cArr);
                }
                if (c10 != '}') {
                    switch (c10) {
                        case '+':
                        case '-':
                        case '.':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                            return createElement(cLElement, i10, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i11 = i10 + 1;
                            if (i11 >= cArr.length || cArr[i11] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i10, TYPE.KEY, true, cArr);
                            }
                            CLElement cLElementCreateElement = createElement(cLElement, i10, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) cLElementCreateElement;
                            if (cLToken.validate(c10, i10)) {
                                return cLElementCreateElement;
                            }
                            throw new CLParsingException("incorrect token <" + c10 + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i10 - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i10);
            return container;
        }
        return cLElement;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0050 A[EDGE_INSN: B:108:0x0050->B:24:0x0050 BREAK  A[LOOP:1: B:14:0x0036->B:89:0x014e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:109:0x00b3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x014e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:27:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:33:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0076  */
    /* JADX WARN: Code duplicated, block: B:36:0x007c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x007e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008a  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0097  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:79:0x0123  */
    /* JADX WARN: Code duplicated, block: B:81:0x012e  */
    /* JADX WARN: Code duplicated, block: B:84:0x013b  */
    public CLObject parse() throws CLParsingException {
        boolean z10;
        long j10;
        char c10;
        long j11;
        CLToken cLToken;
        long j12;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i10 = 1;
        this.mLineNumber = 1;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            char c11 = charArray[i11];
            if (c11 == '{') {
                break;
            }
            if (c11 == '\n') {
                this.mLineNumber++;
            }
            i11++;
        }
        if (i11 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject cLObjectAllocate = CLObject.allocate(charArray);
        cLObjectAllocate.setLine(this.mLineNumber);
        cLObjectAllocate.setStart(i11);
        int i12 = i11 + 1;
        CLElement container = cLObjectAllocate;
        while (i12 < length) {
            char c12 = charArray[i12];
            if (c12 == '\n') {
                this.mLineNumber += i10;
            }
            if (this.mHasComment) {
                if (c12 == '\n') {
                    this.mHasComment = z11;
                    if (container == null) {
                        break;
                        break;
                    }
                    if (container.isDone()) {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    } else if (container instanceof CLObject) {
                        if (c12 == '}') {
                            container.setEnd(i12 - 1);
                        } else {
                            container = getNextJsonElement(i12, c12, container, charArray);
                        }
                    } else if (container instanceof CLArray) {
                        z10 = container instanceof CLString;
                        if (z10) {
                            j12 = container.mStart;
                            if (charArray[(int) j12] == c12) {
                                container.setStart(j12 + 1);
                                container.setEnd(i12 - 1);
                            }
                        } else {
                            if (container instanceof CLToken) {
                                cLToken = (CLToken) container;
                                if (!cLToken.validate(c12, i12)) {
                                    throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                                }
                            }
                            if (container instanceof CLKey) {
                                j10 = container.mStart;
                                c10 = charArray[(int) j10];
                                if (c10 != '\'') {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                } else {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                }
                            } else {
                                j10 = container.mStart;
                                c10 = charArray[(int) j10];
                                if (c10 != '\'') {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                } else {
                                    container.setStart(j10 + 1);
                                    container.setEnd(i12 - 1);
                                }
                            }
                            if (!container.isDone()) {
                                j11 = i12 - 1;
                                container.setEnd(j11);
                                if (c12 != '}') {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j11);
                                    }
                                } else {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                    if (container instanceof CLKey) {
                                        container = container.getContainer();
                                        container.setEnd(j11);
                                    }
                                }
                            }
                        }
                        if (!container.isDone()) {
                        }
                    } else if (c12 == ']') {
                        container.setEnd(i12 - 1);
                    } else {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    }
                    if (!container.isDone()) {
                    }
                }
            } else {
                if (container == null) {
                    break;
                }
                if (container.isDone()) {
                    container = getNextJsonElement(i12, c12, container, charArray);
                } else if (container instanceof CLObject) {
                    if (c12 == '}') {
                        container.setEnd(i12 - 1);
                    } else {
                        container = getNextJsonElement(i12, c12, container, charArray);
                    }
                } else if (container instanceof CLArray) {
                    z10 = container instanceof CLString;
                    if (z10) {
                        j12 = container.mStart;
                        if (charArray[(int) j12] == c12) {
                            container.setStart(j12 + 1);
                            container.setEnd(i12 - 1);
                        }
                    } else {
                        if (container instanceof CLToken) {
                            cLToken = (CLToken) container;
                            if (!cLToken.validate(c12, i12)) {
                                throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                            }
                        }
                        if ((container instanceof CLKey) || z10) {
                            j10 = container.mStart;
                            c10 = charArray[(int) j10];
                            if ((c10 != '\'' || c10 == '\"') && c10 == c12) {
                                container.setStart(j10 + 1);
                                container.setEnd(i12 - 1);
                            }
                        }
                        if (!container.isDone() && (c12 == '}' || c12 == ']' || c12 == ',' || c12 == ' ' || c12 == '\t' || c12 == '\r' || c12 == '\n' || c12 == ':')) {
                            j11 = i12 - 1;
                            container.setEnd(j11);
                            if (c12 != '}' || c12 == ']') {
                                container = container.getContainer();
                                container.setEnd(j11);
                                if (container instanceof CLKey) {
                                    container = container.getContainer();
                                    container.setEnd(j11);
                                }
                            }
                        }
                    }
                    if (!container.isDone() && (!(container instanceof CLKey) || ((CLKey) container).mElements.size() > 0)) {
                        container = container.getContainer();
                    }
                } else if (c12 == ']') {
                    container.setEnd(i12 - 1);
                } else {
                    container = getNextJsonElement(i12, c12, container, charArray);
                }
                if (!container.isDone()) {
                }
            }
            i12++;
            i10 = 1;
            z11 = false;
        }
        while (container != null && !container.isDone()) {
            if (container instanceof CLString) {
                container.setStart(((int) container.mStart) + 1);
            }
            container.setEnd(length - 1);
            container = container.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + cLObjectAllocate.toJSON());
        }
        return cLObjectAllocate;
    }

    public CLParser(String str) {
        this.mContent = str;
    }
}
