package td;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.pengrad.telegrambot.passport.decrypt.RsaOaep;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.net.SyslogAppender;

/* JADX INFO: loaded from: /private/tmp/claude-501/-Users-matheus/942202b5-d135-4d00-b01f-0435e3517f7d/scratchpad/dex/classes4.dex */
class f extends b {
    f(boolean z10) {
        this.F = z10;
        this.f19138d = 524;
        this.f19132a = 462;
        this.f19136c = 24;
        this.f19134b = 486;
        if (z10) {
            this.f19138d = 491;
            this.f19132a = 274;
            this.f19134b = 336;
        }
        this.f19140e = 10;
        this.f19142f = 4;
        this.f19144g = TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS;
        this.f19146h = 640;
        this.f19148i = ((640 + 64) - 1) / 64;
        this.f19150j = (TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS + 63) / 64;
        this.f19152k = 320;
        this.f19154l = ((320 + 64) - 1) / 64;
        this.f19156m = (320 + 63) / 64;
        this.f19158n = 320;
        this.f19160o = 0;
        this.f19162p = 1;
        this.f19164q = 305;
        this.f19166r = 305;
        this.f19168s = RsaOaep.DerParser.PRIVATE;
        this.f19170t = 1;
        this.f19172u = 255;
        this.f19174v = 6;
        this.f19176w = 1;
        this.f19178x = 8;
        this.f19180y = 10;
        this.f19182z = SyslogAppender.LOG_LOCAL3;
        this.A = RsaOaep.DerParser.PRIVATE;
        this.B = 24;
        int i10 = (305 + 7) / 8;
        this.C = i10;
        int i11 = ((305 - 1) + 7) / 8;
        this.D = i11;
        int i12 = ((TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS + 7) / 8) * 2;
        this.E = i12;
        this.f19133a0 = new long[]{-1, -1, -1, -1, 7926898294125494271L, -5658687270105206738L, -7284643569098294869L, -5596370174845115094L, -9110763619386664820L, 10669696872L};
        this.f19135b0 = new long[]{-2, -1, -1, -1, -2592947485458563073L, 7129369533499138140L, 3877456935512961879L, 7254003724019321429L, 225216834936221977L, 21339393745L};
        this.f19137c0 = new long[]{-4, -1, -1, -1, -5185894970917126145L, -4188005006711275335L, 7754913871025923758L, -3938736625670908758L, 450433669872443954L, 42678787490L};
        this.f19139d0 = new long[]{0, 0, 0, 0, 7926898294125494272L, -5658687270105206738L, -7284643569098294869L, -5596370174845115094L, -9110763619386664820L, 10669696872L};
        this.f19141e0 = new long[]{16, 0, 0, 0, 4593671619917905920L, -3389448093728900558L, -6699078747078735223L, -5383595142051833172L, -3603469358979551639L, 9213098133652443887L, -2262032789190864537L, -3293888798786007681L, -3106877548450936536L, -7529360825512198962L, 423414579105418765L, -8091321387562703604L, -476084532282358204L, 4932507286707963453L, -4748761678580843653L, 98};
        this.f19145g0 = new long[]{0, 0, 0, 0, 562949953421312L};
        this.f19147h0 = new long[]{2806962120998467329L, -2332158411328333636L, -2775052578078765709L, 603808853150554410L, 349624627118280L};
        this.f19149i0 = new long[]{5771904529248994682L, -8436915071433390351L, 270330086766583390L, 6481898407746275289L, 7865854910092666580L, -2826674533944143030L, -7553167192889215565L, -9032646596491157233L, 5194719131280954495L, 1729770898, -1965085922052779020L, -4812970318505102637L, 1977403254395278860L, 2726390535525409621L, -248047565090072982L, -5454070453411567460L, -2860923682387992558L, 4095961562244124488L, -4917308312211097814L, 5102423139L, 2124736252400681868L, -7322998048931732039L, 2202127831239085027L, -3257580811259719115L, 4313963896834226850L, -5076443579667205976L, 4921946642166740880L, -3805954528561435943L, -2637702132890644254L, 7907518294L, 2200917311302176889L, 2939498022256786432L, -2284167071920397343L, -8889311404158421409L, -3057031954716630490L, -4860527247048815703L, -7932579696214058839L, 334500554730375393L, 6399318707077975086L, 8976719684L, 2746580562334225805L, -4441891846683360495L, -6980094913201629698L, -6647113845825354661L, 6714415832701611114L, -8334607330680099106L, 7010145936394111770L, -403948467988784721L, -7139691166611819809L, 3478841981L, -5079986323839184192L, 3119472779256121459L, 4709779656408495164L, -1878325030037470211L, -3755564803635956908L, 5893360609436446022L, 6635037533545129430L, 5031143778661013925L, 2711723078310815363L, 10114015515L};
        this.f19151j0 = new long[]{-4122797515158813510L, 2405435625630280597L, -3749193287274905454L, -2935559660200231368L, 7035179512456608727L, -1088186176647096380L, 2237320506219039519L, -4139295546001939262L, -2033832934895166963L, 5379123413L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -754674776282359680L, 8155755975969367465L, -7108179690244256889L, 5678382275401384545L, -5945512278495342032L, 4726463275275376934L, -1362977618025674515L, 4479281637794437063L, -906589179791040647L, 9074793307L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8829176751768485847L, 4330345099806588278L, 6439066249656508832L, -774629675044450053L, -5503580640218556678L, -9083173236816041803L, -1462621330690897264L, -8763703354377076720L, -2191538623876663267L, 9017845420L, 6790521807624498538L, -2290772438416721629L, 4283588130542979409L, 514645655039295889L, 8912678322428419353L, 6038404330050892853L, -1270586841300829686L, -8530139311933844284L, 910728456329037494L, 5513273805L};
        this.f19153k0 = new long[]{-1774597335702472921L, -2253953328706275026L, 7764610893679053117L, -2558253936849870651L, 8311396451547473226L, -8866252043420476836L, 9136860735727631175L, -4198676031223070541L, 8077651299688882586L, 2385055731L};
        this.f19155l0 = new long[]{1728891110, 0, 0, 0, -7335237893079695360L, 5591714530040314431L, 741431724485104668L, -3263383402897026590L, 1398651832995983165L, 4438944100L};
        this.f19157m0 = new int[]{67, 37, 21, 12, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 16, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 33, 16, 8, 5, 2, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 16, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1};
        this.f19159n0 = new int[]{86, 48, 27, 15, 8, 4, 2, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 12, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 21, 12, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 38, 21, 12, 7, 4, 2, 1, 1, 2, 1, 1, 3, 2, 1, 1, 1, 1, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 17, 9, 5, 3, 2, 1, 1, 1, 1, 2, 1, 1, 1, 4, 2, 1, 1, 1, 2, 1, 1, 8, 4, 2, 1, 1, 1, 2, 1, 1, 4, 2, 1, 1, 2, 1, 1};
        if (z10) {
            this.G = 7;
            this.H = 255;
            this.I = i10;
            this.J = i11 + 1;
            this.K = (i10 * 4) + i12 + 2;
            this.L = (i10 * 3) + i12 + 2;
            this.M = 480;
            this.N = 17;
            this.O = 34;
            this.P = 20;
            this.Q = 5;
            this.R = 3;
            this.S = 1 << 5;
            this.T = 27;
            this.U = 1 << (305 % 5);
            this.V = 1;
            this.W = ((305 + 5) - 1) / 5;
            this.X = ((RsaOaep.DerParser.PRIVATE + 3) - 1) / 3;
            this.Y = 62;
            this.Z = 65;
            InputStream resourceAsStream = f.class.getResourceAsStream("p610.properties");
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
                this.f19153k0 = b.a(properties, "Montgomery_R2", this.f19150j);
                this.f19177w0 = b.a(properties, "Montgomery_RB1", this.f19150j);
                this.f19179x0 = b.a(properties, "Montgomery_RB2", this.f19150j);
                this.f19155l0 = b.a(properties, "Montgomery_one", this.f19150j);
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
                this.Q0 = b.a(properties, "ph3_T", this.X * (this.T >>> 1) * 2 * this.f19150j);
                int i13 = this.f19150j;
                this.f19175v0 = new long[i13];
                int i14 = this.X;
                int i15 = this.T;
                this.R0 = new long[(i15 >>> 1) * i14 * 2 * i13];
                this.S0 = new long[i14 * (i15 >>> 1) * 2 * i13];
                int i16 = this.W;
                int i17 = this.S;
                int[] iArr = this.f19183z0;
                int i18 = this.Y;
                this.O0 = new long[(((i16 - 1) * (i17 / 2)) + (iArr[i18 - 1] - 1)) * 2];
                this.P0 = new long[(((i16 - 1) * (i17 / 2)) + (iArr[i18 - 1] - 1)) * 2];
            } catch (IOException e10) {
                throw new IllegalStateException("unable to load Picnic properties: " + e10.getMessage(), e10);
            }
        }
    }
}
