package androidx.constraintlayout.core.parser;

import org.apache.log4j.spi.Configurator;

/* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes1.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* JADX INFO: compiled from: r8-map-id-c402c7f74d39c8a1e2808651f4d07179532f6ebc80deecfc6fba495f787d903c */
    enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toFormattedJSON(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        addIndent(sb2, i10);
        sb2.append(content());
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    protected String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c10, long j10) {
        int iOrdinal = this.mType.ordinal();
        boolean z10 = false;
        if (iOrdinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i10 = this.mIndex;
            if (cArr[i10] == c10) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i10] == c10) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i10] == c10) {
                this.mType = Type.NULL;
            }
            z10 = true;
        } else if (iOrdinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i11 = this.mIndex;
            z10 = cArr2[i11] == c10;
            if (z10 && i11 + 1 == cArr2.length) {
                setEnd(j10);
            }
        } else if (iOrdinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i12 = this.mIndex;
            z10 = cArr3[i12] == c10;
            if (z10 && i12 + 1 == cArr3.length) {
                setEnd(j10);
            }
        } else if (iOrdinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i13 = this.mIndex;
            z10 = cArr4[i13] == c10;
            if (z10 && i13 + 1 == cArr4.length) {
                setEnd(j10);
            }
        }
        this.mIndex++;
        return z10;
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = Configurator.NULL.toCharArray();
    }
}
