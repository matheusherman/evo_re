package td;

import com.taobao.sophix.PatchStatus;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class d extends b {
    d(boolean z10) {
        this.F = z10;
        this.f19138d = 374;
        this.f19132a = 330;
        this.f19136c = 16;
        this.f19134b = 346;
        if (z10) {
            this.f19138d = 350;
            this.f19132a = 197;
            this.f19134b = 236;
        }
        this.f19140e = 7;
        this.f19142f = 3;
        this.f19144g = 434;
        this.f19146h = 448;
        this.f19148i = ((448 + 64) - 1) / 64;
        this.f19150j = (434 + 63) / 64;
        this.f19152k = 256;
        this.f19154l = ((256 + 64) - 1) / 64;
        this.f19156m = (256 + 63) / 64;
        this.f19158n = 256;
        this.f19160o = 0;
        this.f19162p = 1;
        this.f19164q = 216;
        this.f19166r = 218;
        this.f19168s = PatchStatus.CODE_LOAD_LIB_NS;
        this.f19170t = 255;
        this.f19172u = 1;
        this.f19174v = 6;
        this.f19176w = 1;
        this.f19178x = 7;
        this.f19180y = 8;
        this.f19182z = 108;
        this.A = PatchStatus.CODE_LOAD_LIB_NS;
        this.B = 16;
        int i10 = (216 + 7) / 8;
        this.C = i10;
        int i11 = ((218 - 1) + 7) / 8;
        this.D = i11;
        int i12 = ((434 + 7) / 8) * 2;
        this.E = i12;
        this.f19133a0 = new long[]{-1, -1, -1, -161717841442111489L, 8918917783347572387L, 7853257225132122198L, 620258357900100L};
        this.f19135b0 = new long[]{-2, -1, -1, -323435682884222977L, -608908507014406841L, -2740229623445307220L, 1240516715800200L};
        this.f19137c0 = new long[]{-4, -1, -1, -646871365768445953L, -1217817014028813681L, -5480459246890614439L, 2481033431600401L};
        this.f19139d0 = new long[]{0, 0, 0, -161717841442111488L, 8918917783347572387L, 7853257225132122198L, 620258357900100L};
        this.f19141e0 = new long[]{16, 0, 0, 5174970926147567616L, -8704207961479042176L, 6950185827705812272L, 6073522028379477874L, -4224597189565045742L, 8299186480726035350L, 7225369840861796773L, 2456441653404885428L, -5891485665658122495L, 1781491355331495958L, 333691781277L};
        this.f19145g0 = new long[]{0, 0, 0, 16777216};
        this.f19147h0 = new long[]{6390225231553133283L, -4242295759374092239L, 1689769520075363969L, 36970279};
        this.f19149i0 = new long[]{409251790387889599L, -7956914563081327573L, -5772233213491609001L, 8135632727773423537L, -605746078158370611L, 2414452085739184671L, 11115521240260L, 8395851790856910728L, 2986355008512957707L, -3794508369610992171L, -8297630390065234006L, -6344405898491969121L, -2994353266636644724L, 281073067659850L, -88129956366309573L, -3267881773463506490L, -507342119971546937L, -2145611229349799165L, 1973682341831588061L, 8312799048378913301L, 497853136119926L, -5930968907585159722L, 7710088909771808848L, 7498146198864584751L, 2174778336782639988L, -2099344739079935595L, -6420807801124297464L, 438485524985150L, 124497379906645117L, 3220114552465917457L, 2709773247140401691L, 6980995868580086445L, 4225536559282510125L, 4701685901084574963L, 609687130428995L, -5139244406301072054L, -1180825250703942163L, 6350294504100107936L, 8618087912213766372L, 308885086986017528L, -2653863745610111006L, 202858940514502L};
        this.f19151j0 = new long[]{7950145635403778211L, 3053921039650069509L, -1472232571310339971L, 6369396808518798415L, -5151006957371847381L, 2507423554624419257L, 491294718579999L, 0, 0, 0, 0, 0, 0, 0, -368551928616227954L, 5280595860558773788L, -1217497873284611460L, 5300724274592529762L, -5761561158429016438L, -850473803693194369L, 57208989669550L, 0, 0, 0, 0, 0, 0, 0, 2898969037767559396L, -7923814947979270585L, 9073321008578907802L, 7539793830764276893L, -9117835332022963109L, 148738643701593348L, 139132528504375L, -5514455700498887503L, 7856701733796155952L, -1449781872342195351L, 3113577795642755667L, 4926779461749210259L, -4685648887271738037L, 408994988652499L};
        this.f19153k0 = new long[]{2946862024238734128L, -5986282916474808126L, -6113751670094468979L, 1683438818023996427L, -6067031773192244098L, 7629496211932212634L, 41406098690346L};
        this.f19155l0 = new long[]{29740, 0, 0, -5111598749797318656L, -2881840887160132396L, -1643158192681172724L, 260509760564954L};
        this.f19157m0 = new int[]{48, 28, 16, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 13, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 4, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 21, 12, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1};
        this.f19159n0 = new int[]{66, 33, 17, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 16, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 32, 16, 8, 4, 3, 1, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 16, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1};
        if (z10) {
            this.G = 0;
            this.H = 127;
            this.I = i10;
            this.J = i11;
            this.K = (i10 * 4) + i12 + 2;
            this.L = (i10 * 3) + i12 + 2;
            this.M = 330;
            this.N = 17;
            this.O = 34;
            this.P = 20;
            this.Q = 4;
            this.R = 3;
            this.S = 1 << 4;
            this.T = 27;
            this.U = 1 << (216 % 4);
            this.V = 9;
            this.W = ((216 + 4) - 1) / 4;
            this.X = ((PatchStatus.CODE_LOAD_LIB_NS + 3) - 1) / 3;
            this.Y = 55;
            this.Z = 47;
            InputStream resourceAsStream = d.class.getResourceAsStream("p434.properties");
            Properties properties = new Properties();
            try {
                properties.load(resourceAsStream);
                this.f19183z0 = b.d(properties, "ph2_path", this.Y);
                this.A0 = b.d(properties, "ph3_path", this.Z);
                this.f19149i0 = b.a(properties, "A_gen", this.f19150j * 6);
                this.f19151j0 = b.a(properties, "B_gen", this.f19150j * 6);
                this.f19161o0 = b.a(properties, "XQB3", this.f19150j * 2);
                this.f19163p0 = b.a(properties, "A_basis_zero", this.f19150j * 8);
                this.f19165q0 = b.a(properties, "B_basis_zero", this.f19150j * 8);
                this.f19167r0 = b.a(properties, "B_gen_3_tors", this.f19150j * 16);
                this.f19169s0 = b.a(properties, "g_R_S_im", this.f19150j);
                this.f19171t0 = b.a(properties, "g_phiR_phiS_re", this.f19150j);
                this.f19173u0 = b.a(properties, "g_phiR_phiS_im", this.f19150j);
                this.f19177w0 = b.a(properties, "Montgomery_RB1", this.f19150j);
                this.f19179x0 = b.a(properties, "Montgomery_RB2", this.f19150j);
                this.f19181y0 = b.a(properties, "threeinv", this.f19150j);
                this.B0 = b.a(properties, "u_entang", this.f19150j * 2);
                this.C0 = b.a(properties, "u0_entang", this.f19150j * 2);
                this.D0 = b.b(properties, "table_r_qr", this.N, this.f19150j);
                this.E0 = b.b(properties, "table_r_qnr", this.N, this.f19150j);
                this.F0 = b.b(properties, "table_v_qr", this.O, this.f19150j);
                this.G0 = b.b(properties, "table_v_qnr", this.O, this.f19150j);
                this.H0 = b.c(properties, "v_3_torsion", this.P, 2, this.f19150j);
                this.I0 = b.a(properties, "T_tate3", (((this.f19168s - 1) * 6) + 4) * this.f19150j);
                this.J0 = b.a(properties, "T_tate2_firststep_P", this.f19150j * 4);
                this.K0 = b.a(properties, "T_tate2_P", (this.f19164q - 2) * 3 * this.f19150j);
                this.L0 = b.a(properties, "T_tate2_firststep_Q", this.f19150j * 4);
                this.M0 = b.a(properties, "T_tate2_Q", (this.f19164q - 2) * 3 * this.f19150j);
                this.N0 = b.a(properties, "ph2_T", this.W * (this.S >>> 1) * 2 * this.f19150j);
                this.R0 = b.a(properties, "ph3_T1", this.X * (this.T >>> 1) * 2 * this.f19150j);
                this.S0 = b.a(properties, "ph3_T2", this.X * (this.T >>> 1) * 2 * this.f19150j);
                int i13 = this.W;
                int i14 = this.S;
                int[] iArr = this.f19183z0;
                int i15 = this.Y;
                this.O0 = new long[(((i13 - 1) * (i14 / 2)) + (iArr[i15 - 1] - 1)) * 2];
                this.P0 = new long[(((i13 - 1) * (i14 / 2)) + (iArr[i15 - 1] - 1)) * 2];
                this.Q0 = new long[(((this.X - 1) * (this.T / 2)) + (this.A0[this.Z - 1] - 1)) * 2];
            } catch (IOException e10) {
                throw new IllegalStateException("unable to load Picnic properties: " + e10.getMessage(), e10);
            }
        }
    }
}
