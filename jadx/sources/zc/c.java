package zc;

import java.security.BasicPermission;
import java.security.Permission;
import java.util.StringTokenizer;
import re.h;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
public class c extends BasicPermission {
    private final String actions;
    private final int permissionMask;

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.permissionMask == cVar.permissionMask && getName().equals(cVar.getName())) {
                return true;
            }
        }
        return false;
    }

    private int a(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(h.e(str), " ,");
        int i10 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strNextToken = stringTokenizer.nextToken();
            if (strNextToken.equals("threadlocalecimplicitlyca")) {
                i10 |= 1;
            } else if (strNextToken.equals("ecimplicitlyca")) {
                i10 |= 2;
            } else if (strNextToken.equals("threadlocaldhdefaultparams")) {
                i10 |= 4;
            } else if (strNextToken.equals("dhdefaultparams")) {
                i10 |= 8;
            } else if (strNextToken.equals("acceptableeccurves")) {
                i10 |= 16;
            } else if (strNextToken.equals("additionalecparameters")) {
                i10 |= 32;
            } else if (strNextToken.equals("all")) {
                i10 = 63;
            }
        }
        if (i10 != 0) {
            return i10;
        }
        throw new IllegalArgumentException("unknown permissions passed to mask");
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public String getActions() {
        return this.actions;
    }

    @Override // java.security.BasicPermission, java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof c) || !getName().equals(permission.getName())) {
            return false;
        }
        int i10 = this.permissionMask;
        int i11 = ((c) permission).permissionMask;
        return (i10 & i11) == i11;
    }

    public c(String str, String str2) {
        super(str, str2);
        this.actions = str2;
        this.permissionMask = a(str2);
    }

    public int hashCode() {
        return getName().hashCode() + this.permissionMask;
    }
}
