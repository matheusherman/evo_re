package dd;

import ae.e;
import fc.u;
import ie.f;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import tc.c;
import tc.g;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes2.dex */
public final class a extends Provider implements zc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f9744a = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f9745b = "BouncyCastle Security Provider v1.72";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zc.b f9746c = new dd.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f9747d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class f9748e = ad.a.a(a.class, "java.security.cert.PKIXRevocationChecker");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f9749f = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f9750g = {"SipHash", "SipHash128", "Poly1305"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c[] f9751h = {j("AES", 256), j("ARC4", 20), j("ARIA", 256), j("Blowfish", 128), j("Camellia", 256), j("CAST5", 128), j("CAST6", 256), j("ChaCha", 128), j("DES", 56), j("DESede", 112), j("GOST28147", 128), j("Grainv1", 128), j("Grain128", 128), j("HC128", 128), j("HC256", 256), j("IDEA", 128), j("Noekeon", 128), j("RC2", 128), j("RC5", 128), j("RC6", 256), j("Rijndael", 256), j("Salsa20", 128), j("SEED", 128), j("Serpent", 256), j("Shacal2", 128), j("Skipjack", 80), j("SM4", 128), j("TEA", 128), j("Twofish", 256), j("Threefish", 128), j("VMPC", 128), j("VMPCKSA3", 128), j("XTEA", 128), j("XSalsa20", 128), j("OpenSSLPBKDF", 128), j("DSTU7624", 256), j("GOST3412_2015", 256), j("Zuc", 128)};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f9752i = {"X509", "IES", "COMPOSITE", "EXTERNAL"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f9753j = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC", "LMS", "SPHINCSPlus"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f9754k = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka", "Blake3"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f9755l = {"BC", "BCFKS", "PKCS12"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f9756m = {"DRBG"};

    /* JADX INFO: renamed from: dd.a$a, reason: collision with other inner class name */
    class C0172a implements PrivilegedAction {
        C0172a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            a.this.k();
            return null;
        }
    }

    private static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f9758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9759b;

        @Override // tc.c
        public String a() {
            return this.f9758a;
        }

        b(String str, int i10) {
            this.f9758a = str;
            this.f9759b = i10;
        }
    }

    private void d(String str, String[] strArr) {
        for (int i10 = 0; i10 != strArr.length; i10++) {
            i(str, strArr[i10]);
        }
    }

    private void e(String str, c[] cVarArr) {
        for (int i10 = 0; i10 != cVarArr.length; i10++) {
            c cVar = cVarArr[i10];
            g.a(cVar);
            i(str, cVar.a());
        }
    }

    private void h() {
        c(gc.a.f10586e0, new ge.c());
        c(gc.a.f10590f0, new ge.c());
        c(gc.a.f10594g0, new ge.c());
        c(gc.a.f10598h0, new ge.c());
        c(gc.a.f10602i0, new ge.c());
        c(fd.g.f10294r, new fe.c());
        c(fd.g.f10298v, new be.c());
        c(fd.g.f10299w, new f());
        c(kc.a.f12234a, new f());
        c(fd.g.F, new ie.g());
        c(kc.a.f12235b, new ie.g());
        c(fd.g.f10289m, new ae.f());
        c(fd.g.f10290n, new e());
        c(fd.g.f10277a, new ee.c());
        c(fd.g.X, new de.c());
        c(fd.g.Y, new de.c());
        c(pc.a.J0, new zd.c());
        c(gc.a.f10610k0, new ce.c());
        c(gc.a.C0, new yd.c());
        c(gc.a.D0, new yd.c());
    }

    private void i(String str, String str2) {
        Class clsA = ad.a.a(a.class, str + str2 + "$Mappings");
        if (clsA != null) {
            try {
                ((bd.a) clsA.newInstance()).a(this);
            } catch (Exception e10) {
                throw new InternalError("cannot create instance of " + str + str2 + "$Mappings : " + e10);
            }
        }
    }

    private static c j(String str, int i10) {
        return new b(str, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String str;
        String str2;
        d("org.bouncycastle.jcajce.provider.digest.", f9754k);
        d("org.bouncycastle.jcajce.provider.symmetric.", f9749f);
        d("org.bouncycastle.jcajce.provider.symmetric.", f9750g);
        e("org.bouncycastle.jcajce.provider.symmetric.", f9751h);
        d("org.bouncycastle.jcajce.provider.asymmetric.", f9752i);
        d("org.bouncycastle.jcajce.provider.asymmetric.", f9753j);
        d("org.bouncycastle.jcajce.provider.keystore.", f9755l);
        d("org.bouncycastle.jcajce.provider.drbg.", f9756m);
        h();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class cls = f9748e;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (cls != null) {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
        } else {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        }
        put("CertPathBuilder.RFC3280", str2);
        put("CertPathValidator.PKIX", str);
        put("CertPathBuilder.PKIX", str2);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    public void c(u uVar, bd.b bVar) {
        Map map = f9747d;
        synchronized (map) {
            map.put(uVar, bVar);
        }
    }

    public a() {
        super("BC", 1.72d, f9745b);
        AccessController.doPrivileged(new C0172a());
    }
}
