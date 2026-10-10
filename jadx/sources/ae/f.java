package ae;

import fc.z;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public class f extends KeyFactorySpi implements bd.b {
    @Override // java.security.KeyFactorySpi
    protected KeySpec engineGetKeySpec(Key key, Class cls) {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    protected Key engineTranslateKey(Key key) {
        return null;
    }

    @Override // java.security.KeyFactorySpi
    protected PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            pc.b bVarN = pc.b.n(z.u(((PKCS8EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!fd.g.f10289m.t(bVarN.o().m())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece private key");
                }
                fd.e eVarO = fd.e.o(bVarN.s());
                return new c(new ke.f(eVarO.r(), eVarO.q(), eVarO.m(), eVarO.n(), eVarO.s(), eVarO.t(), eVarO.u()));
            } catch (IOException unused) {
                throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec.");
            }
        } catch (IOException e10) {
            throw new InvalidKeySpecException("Unable to decode PKCS8EncodedKeySpec: " + e10);
        }
    }

    @Override // java.security.KeyFactorySpi
    protected PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (!(keySpec instanceof X509EncodedKeySpec)) {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
        try {
            rc.b bVarN = rc.b.n(z.u(((X509EncodedKeySpec) keySpec).getEncoded()));
            try {
                if (!fd.g.f10289m.t(bVarN.m().m())) {
                    throw new InvalidKeySpecException("Unable to recognise OID in McEliece public key");
                }
                fd.f fVarN = fd.f.n(bVarN.q());
                return new d(new ke.g(fVarN.o(), fVarN.q(), fVarN.m()));
            } catch (IOException e10) {
                throw new InvalidKeySpecException("Unable to decode X509EncodedKeySpec: " + e10.getMessage());
            }
        } catch (IOException e11) {
            throw new InvalidKeySpecException(e11.toString());
        }
    }
}
