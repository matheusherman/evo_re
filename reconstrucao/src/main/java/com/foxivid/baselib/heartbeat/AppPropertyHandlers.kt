package com.foxivid.baselib.heartbeat

import com.foxivid.baselib.ad.AdManager
import com.foxivid.baselib.bot.TelegramBot
import com.foxivid.baselib.config.BaseLibConfig
import com.foxivid.baselib.feedback.LogCatHelper
import com.foxivid.baselib.log.RemoteLogger
import com.foxivid.baselib.marquee.MarqueeManager
import com.foxivid.baselib.media.EpgRepository
import com.foxivid.baselib.metric.MetricReporter
import com.foxivid.baselib.user.UserManager
import com.foxivid.baselib.util.AppAttrUtils
import com.foxivid.baselib.util.EcoModeManager
import com.foxivid.baselib.util.MainThreadMonitor
import com.foxivid.baselib.util.Preferences
import java.util.Locale

/**
 * Interface de callback usada pelos handlers de propriedade remota.
 *
 * Original: x1/f1/lb/util/m.java (interface genérica `a(T)`)
 */
fun interface ValueCallback<T> {
    /** Original: m.a(T) */
    fun onValue(v: T)
}

/**
 * Tabela de handlers das "propriedades remotas" (parâmetros de configuração devolvidos pelo
 * servidor, aplicados por [HeartbeatManager.applyProperties]).
 *
 * Original: x1/f1/lb/heartbeat/f.java — bloco `static {}` (linhas ~2160-2240 do arquivo jadx)
 * e as classes internas `f$a` … `f$m1` (cada uma implementa `x1.f1.lb.util.m<String>`).
 *
 * Para cada chave `K` o servidor pode enviar `K` ou `<appType>_K` (ex.: `mobile_HEART_BEAT_INTERVAL`);
 * a versão prefixada pelo tipo de app (of.a.c()) tem prioridade.
 *
 * | Chave | Classe original | Efeito |
 * |---|---|---|
 * | IS_DEVICE_FREE | f$k | `isFree = toBoolean(v)` |
 * | AUTO_LOGIN_BEFORE_TOKEN_EXPIRED | f$v | ms; aplica se `>= 300000` |
 * | AUTO_REFRESH_ACCESS_TOKEN_INTERVAL | f$g0 | ms; aplica se `>= 3600000` |
 * | HEART_BEAT_INTERVAL | f$r0 | segundos; aplica se `> 30` (×1000) |
 * | UPGRADE_CHECK_INTERVAL | f$c1 | segundos; aplica se `> 30` (×1000) — default de parse = heartbeatInterval |
 * | METRIC_HEART_BEAT_INTERVAL | f$n1 | segundos; aplica se `> 30` (×1000) |
 * | ECO_MODE_TIME_MINUTES | f$p1 | minutos; aplica se `> 1` (×60000) |
 * | customer_service_qrcode | f$q1 | URL da imagem QR do suporte |
 * | customer_service_email | f$r1 | e-mail de suporte |
 * | customer_whatsapp_link | f$a | link do grupo WhatsApp |
 * | customer_service_whatsapp | f$b | WhatsApp do suporte |
 * | customer_service_telegram | f$c | Telegram do suporte |
 * | customer_service_facebook | f$d | Facebook do suporte |
 * | expire_remind_seconds | f$e | int → expireRemindSeconds |
 * | daily_remind_times | f$f | int → dailyRemindTimes |
 * | re_login_max_cnt_after_expired | f$g | int → reLoginMaxCntAfterExpired |
 * | how2order | f$h | texto "como comprar" |
 * | udp_log_servers | f$i | lista "host:porta" separada por vírgula → RemoteLogger.setUdpLoggerServer() |
 * | promotion_trial_days | f$j **e** f$m | registrada duas vezes no mesmo map: f$m sobrescreve f$j, então o valor vai para `limitContinuingRenewDays` (e `promotionTrialDays` nunca é atualizado) |
 * | prompt_renew_plan_left_hours | f$l | horas ×3600000 → promptRenewMillis |
 * | membership_qrcode_refresh_interval | f$n | `<=0` desativa auto-refresh de renovação; `>10` vira qrcodeRefreshIntervalSeconds |
 * | eco_mode_pics | f$o | lista separada por vírgula → imagens do modo eco (util/d0.s) |
 * | marquee_display_interval | f$p | int; aplica se `>1000` → MarqueeManager |
 * | login_retry_interval_seconds | f$q | seg; aplica se `>15` (×1000) |
 * | marquee_display_times | f$r | int `>0` → MarqueeManager |
 * | marquee_display_contents | f$s | textos separados por `$$` → MarqueeManager.setContents |
 * | marquee_update_interval_minutes | f$t | `0 < v < 14400` min → MarqueeManager.setUpdateInterval |
 * | marquee_alternately_display | f$u | boolean → MarqueeManager |
 * | ad_list | f$w | salvo em prefs "startup_ad_list" |
 * | email_be_blocked_host_list | f$x | hosts de e-mail bloqueados (vírgula, trim) |
 * | is_epg_enable | f$y | boolean → EPG (media/c.s) |
 * | email_host_block_tip | f$z | texto de aviso de host bloqueado |
 * | start_up_ad_count_num | f$a0 | int `>0` |
 * | meta_update_min_interval_sec | f$b0 | seg `>0` (×1000) |
 * | guest_trial_end_player_tip_text | f$c0 | texto (ignora vazio) |
 * | member_trial_end_player_tip_text | f$d0 | texto (ignora vazio) |
 * | guest_trial_end_player_tip_img_url | f$e0 | URL (ignora vazio) |
 * | member_trial_end_player_tip_img_url | f$f0 | URL (ignora vazio) |
 * | is_show_register_first_for_new_user | f$h0 | boolean |
 * | subtitle_dft_lang | f$i0 | idioma padrão de legenda (default "PT") |
 * | subtitle_lang_list | f$j0 | lista separada por vírgula (default [EN, PT]) |
 * | is_report_client_detail_log | f$k0 | boolean → isReportClientDetail (métricas logadas em nível info) |
 * | is_telegram_bot_enable | f$l0 | boolean → TelegramBot.setEnable |
 * | is_remind_after_plan_expired | f$m0 | int → UserManager (user/f.B1) |
 * | is_remind_plan_not_bind_username | f$n0 | int → UserManager (user/f.C1) |
 * | plan_will_expire_remind | f$o0 | int → UserManager (user/f.z1) |
 * | zapping_time_bot_when_gt_seconds | f$p0 | int `>3` → MetricReporter.setZappingTimeBotWhenGT |
 * | log_main_thread_block_gt_millis | f$q0 | int `>300` → util/c.s |
 * | log_dropped_frames_gt | f$s0 | int `>1` → util/c.r |
 * | plan_html | f$t0 | HTML dos planos |
 * | player_proxy_type | f$u0 | "ts" (case-insensitive) → "TS", qualquer outro → "HLS" (BaseLibConfig.proxyType) |
 * | max_downloading_block_cnt | f$v0 | int `>0` → BaseLibConfig.maxDownloadingBlockCnt |
 * | ts_push_mode | f$w0 | int → enum v6.d (0=UDP, 1=GOP, 2=TS; desconhecido → null) |
 * | display_member_site | f$x0 | boolean |
 * | verify_channel_when_upgrade | f$y0 | boolean → valida meta-data DISTRIBUTION_CHANNEL do APK antes de instalar |
 * | is_report_metric | f$z0 | boolean → liga/desliga envio de métricas |
 * | has_subject | f$a1 | boolean |
 * | share_app_tip | f$b1 | texto |
 * | share_app_info | f$d1 | texto |
 * | has_referral_summary | f$e1 | boolean |
 * | refresh_sports_minutes | f$f1 | minutos ×60000 |
 * | catchup_dvr_days | f$g1 | int |
 * | has_catchup | f$h1 | boolean |
 * | mobile_app_qrcode | f$i1 | URL QR do app mobile |
 * | ad_list_ext | f$j1 | salvo em prefs "ad_list_ext" e passado a AdManager |
 * | feedback_logcat_exe_duration | f$k1 | int (mín. 0) segundos de captura do logcat |
 * | feedback_exe_did | f$l1 | se o valor **contém** o did deste aparelho, dispara captura+upload silencioso de logcat |
 * | mb_tb_flt_mils | f$m1 | long → BaseLibConfig.mobileTabSwitchFilterMills |
 *
 * Classe `f$c1` (UPGRADE_CHECK_INTERVAL) usa `heartbeatInterval` (ms!) como default do parse, o que é
 * inofensivo porque só se aplica quando o parse funciona.
 */
internal object AppPropertyHandlers {

    /** Original: f.java static {} — `propertiesHandlers.put(...)` */
    fun register(map: MutableMap<String, ValueCallback<String>>) {
        val hb = HeartbeatManager
        val log = HeartbeatManager.logger

        map["IS_DEVICE_FREE"] = ValueCallback { hb.isFree = it.toBoolean() }                         // f$k
        map["AUTO_LOGIN_BEFORE_TOKEN_EXPIRED"] = ValueCallback {                                     // f$v
            try { val v = it.toLong(); if (v >= 300000) hb.autoLoginBeforeTokenExpired = v }
            catch (t: Throwable) { log.error("set auto login before token expired failure", t) }
        }
        map["AUTO_REFRESH_ACCESS_TOKEN_INTERVAL"] = ValueCallback {                                  // f$g0
            try { val v = it.toLong(); if (v >= 3600000) hb.autoRefreshAccessTokenInterval = v }
            catch (t: Throwable) { log.error("set auto login before token expired failure", t) }
        }
        map["HEART_BEAT_INTERVAL"] = ValueCallback {                                                 // f$r0
            val v = parseLong(it, hb.heartbeatInterval); if (v > 30) hb.heartbeatInterval = v * 1000
        }
        map["UPGRADE_CHECK_INTERVAL"] = ValueCallback {                                              // f$c1
            val v = parseLong(it, hb.heartbeatInterval); if (v > 30) hb.upgradeCheckingInterval = v * 1000
        }
        map["METRIC_HEART_BEAT_INTERVAL"] = ValueCallback {                                          // f$n1
            val v = parseLong(it, hb.heartbeatInterval); if (v > 30) hb.metricHeartbeatInterval = v * 1000
        }
        map["ECO_MODE_TIME_MINUTES"] = ValueCallback {                                               // f$p1
            val v = parseLong(it, hb.echoModeTime / 60000); if (v > 1) hb.echoModeTime = v * 60000
        }
        map["customer_service_qrcode"] = ValueCallback { hb.customerServiceQrCodeImg = it }          // f$q1
        map["customer_service_email"] = ValueCallback { hb.customerServiceEmail = it }               // f$r1
        map["customer_whatsapp_link"] = ValueCallback { hb.customerServiceGroupWhatsappLink = it }   // f$a
        map["customer_service_whatsapp"] = ValueCallback { hb.customerServiceWhatsapp = it }         // f$b
        map["customer_service_telegram"] = ValueCallback { hb.customerServiceTelegram = it }         // f$c
        map["customer_service_facebook"] = ValueCallback { hb.customerServiceFacebook = it }         // f$d
        map["expire_remind_seconds"] = ValueCallback {                                               // f$e
            try { hb.expireRemindSeconds = it.toInt() } catch (t: Throwable) { log.error("set expire_remind_seconds failure", t) }
        }
        map["daily_remind_times"] = ValueCallback {                                                  // f$f
            try { hb.dailyRemindTimes = it.toInt() } catch (t: Throwable) { log.error("set daily_remind_times failure", t) }
        }
        map["re_login_max_cnt_after_expired"] = ValueCallback {                                      // f$g
            try { hb.reLoginMaxCntAfterExpired = it.toInt() } catch (t: Throwable) { log.error("set re_login_max_cnt_after_expired failure", t) }
        }
        map["how2order"] = ValueCallback { hb.how2order = it }                                       // f$h
        map["udp_log_servers"] = ValueCallback {                                                     // f$i
            try {
                // split(",") removendo vazios do fim (comportamento de Regex.split + dropLastWhile)
                val servers = it.split(",").dropLastWhile { s -> s.isEmpty() }
                RemoteLogger.setUdpLoggerServer(servers.toTypedArray())
            } catch (t: Throwable) { log.error("update log server failure", t) }
        }
        map["promotion_trial_days"] = ValueCallback {                                                // f$j
            try { hb.promotionTrialDays = it.toInt() } catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["prompt_renew_plan_left_hours"] = ValueCallback {                                        // f$l
            try { hb.promptRenewMillis = it.toInt().toLong() * 3600000 } catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        // ATENÇÃO (fiel ao original): mesma chave registrada de novo → substitui f$j acima.
        map["promotion_trial_days"] = ValueCallback {                                                // f$m
            try { hb.limitContinuingRenewDays = it.toInt() } catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["membership_qrcode_refresh_interval"] = ValueCallback {                                  // f$n
            try {
                val v = it.toInt()
                val autoRefresh = if (v <= 0) false else { if (v > 10) hb.qrcodeRefreshIntervalSeconds = v; true }
                BaseLibConfig.isRenewAutoRefresh = autoRefresh
            } catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["eco_mode_pics"] = ValueCallback {                                                       // f$o
            try { val l = it.split(","); if (l.isNotEmpty()) EcoModeManager.setPics(l) }
            catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["marquee_display_interval"] = ValueCallback {                                            // f$p
            try { val v = it.toInt(); if (v > 1000) MarqueeManager.setDisplayInterval(v) }
            catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["login_retry_interval_seconds"] = ValueCallback {                                        // f$q
            try { val v = it.toInt().toLong(); if (v > 15) hb.loginRetryIntervalMs = v * 1000 }
            catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["marquee_display_times"] = ValueCallback {                                               // f$r
            try { val v = it.toInt(); if (v > 0) MarqueeManager.setDisplayTimes(v) }
            catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["marquee_display_contents"] = ValueCallback {                                            // f$s
            try { val l = it.split("$$"); if (l.isNotEmpty()) MarqueeManager.setContents(l) }
            catch (t: Throwable) { log.error("set promotion_trial_days failure", t) }
        }
        map["marquee_update_interval_minutes"] = ValueCallback {                                     // f$t
            try { val v = it.toLong(); if (v in 1 until 14400) MarqueeManager.setUpdateInterval(v * 60000) }
            catch (t: Throwable) { log.error("set marquee_update_interval_minutes failure", t) }
        }
        map["marquee_alternately_display"] = ValueCallback {                                         // f$u
            try { MarqueeManager.setAlternatelyDisplay(it.toBoolean()) }
            catch (t: Throwable) { log.error("set marquee_alternately_display failure", t) }
        }
        map["ad_list"] = ValueCallback { Preferences.putString("startup_ad_list", it) }              // f$w
        map["email_be_blocked_host_list"] = ValueCallback {                                          // f$x
            hb.emailBeBlockedHosts = if (it.isEmpty()) HashSet() else it.split(",").mapTo(HashSet()) { s -> s.trim() }
        }
        map["is_epg_enable"] = ValueCallback { if (it.isNotEmpty()) EpgRepository.setEpgEnable(it.toBoolean()) } // f$y
        map["email_host_block_tip"] = ValueCallback { hb.blockEmailHostTip = it }                    // f$z
        map["start_up_ad_count_num"] = ValueCallback {                                               // f$a0
            if (it.isEmpty()) return@ValueCallback
            try { val v = it.toInt(); if (v > 0) hb.startUpCountNum = v } catch (t: Throwable) { log.error("set start_up_ad_count_num failure", t) }
        }
        map["meta_update_min_interval_sec"] = ValueCallback {                                        // f$b0
            if (it.isEmpty()) return@ValueCallback
            try { val v = it.toInt(); if (v > 0) hb.metaUpdateMinIntervalMs = v.toLong() * 1000 }
            catch (t: Throwable) { log.error("set start_up_ad_count_num failure", t) } // mensagem copiada no original
        }
        map["guest_trial_end_player_tip_text"] = ValueCallback { if (it.isNotEmpty()) hb.guestTrialEndTipText = it }     // f$c0
        map["member_trial_end_player_tip_text"] = ValueCallback { if (it.isNotEmpty()) hb.memberTrialEndTipText = it }   // f$d0
        map["guest_trial_end_player_tip_img_url"] = ValueCallback { if (it.isNotEmpty()) hb.guestTrialEndImgUrl = it }   // f$e0
        map["member_trial_end_player_tip_img_url"] = ValueCallback { if (it.isNotEmpty()) hb.memberTrialEndImgUrl = it } // f$f0
        map["is_show_register_first_for_new_user"] = ValueCallback { if (it.isNotEmpty()) hb.isShowRegisterFistForNewUser = it.toBoolean() } // f$h0
        map["subtitle_dft_lang"] = ValueCallback { if (it.isNotEmpty()) hb.subtitleDftLang = it }    // f$i0
        map["subtitle_lang_list"] = ValueCallback {                                                  // f$j0
            if (it.isEmpty()) return@ValueCallback
            val list = it.split(",").map { s -> s.trim() }.filter { s -> s.isNotEmpty() }
            if (list.isNotEmpty()) hb.subtitleLanguageList = list
        }
        map["is_report_client_detail_log"] = ValueCallback { if (it.isNotEmpty()) hb.isReportClientDetail = it.toBoolean() } // f$k0
        map["is_telegram_bot_enable"] = ValueCallback { if (it.isNotEmpty()) TelegramBot.setEnable(it.toBoolean()) }         // f$l0
        map["is_remind_after_plan_expired"] = ValueCallback {                                        // f$m0
            try { UserManager.setRemindAfterPlanExpired(it.toInt()) } catch (t: Throwable) { log.error("set remind flag for expired plan failure", t) }
        }
        map["is_remind_plan_not_bind_username"] = ValueCallback {                                    // f$n0
            try { UserManager.setRemindPlanNotBindUsername(it.toInt()) } catch (t: Throwable) { log.error("set remind flag for plan not bind username failure", t) }
        }
        map["plan_will_expire_remind"] = ValueCallback {                                             // f$o0
            try { UserManager.setPlanWillExpireRemind(it.toInt()) } catch (t: Throwable) { log.error("set remind flag for plan will expire failure", t) }
        }
        map["zapping_time_bot_when_gt_seconds"] = ValueCallback {                                    // f$p0
            try { val v = it.toInt(); if (v > 3) MetricReporter.setZappingTimeBotWhenGT(v) }
            catch (t: Throwable) { log.error("set remind flag for plan will expire failure", t) }
        }
        map["log_main_thread_block_gt_millis"] = ValueCallback {                                     // f$q0
            try { val v = it.toInt(); if (v > 300) MainThreadMonitor.setBlockThresholdMillis(v) }
            catch (t: Throwable) { log.error("set log main thread block millis failure", t) }
        }
        map["log_dropped_frames_gt"] = ValueCallback {                                               // f$s0
            try { val v = it.toInt(); if (v > 1) MainThreadMonitor.setDroppedFramesThreshold(v) }
            catch (t: Throwable) { log.error("set log dropped frames failure", t) }
        }
        map["plan_html"] = ValueCallback { hb.planHtml = it }                                        // f$t0
        map["player_proxy_type"] = ValueCallback {                                                   // f$u0
            try { BaseLibConfig.proxyType = if (it.lowercase(Locale.ROOT) == "ts") "TS" else "HLS" }
            catch (t: Throwable) { log.error("set log dropped frames failure", t) }
        }
        map["max_downloading_block_cnt"] = ValueCallback {                                           // f$v0
            try { val v = it.toInt(); if (v > 0) BaseLibConfig.maxDownloadingBlockCnt = v }
            catch (t: Throwable) { log.error("set log dropped frames failure[$it]", t) }
        }
        map["ts_push_mode"] = ValueCallback {                                                        // f$w0
            try { BaseLibConfig.tsPushMode = TsPushMode.fromValue(it.toInt()) }
            catch (t: Throwable) { log.error("set log ts push mode failure[$it]", t) }
        }
        map["display_member_site"] = ValueCallback {                                                 // f$x0
            try { BaseLibConfig.displayMemberSite = it.toBoolean() } catch (t: Throwable) { log.error("set display member site failure[$it]", t) }
        }
        map["verify_channel_when_upgrade"] = ValueCallback {                                         // f$y0
            try { BaseLibConfig.isVerifyDistributionChannelBeforeUpgradeInstall = it.toBoolean() }
            catch (t: Throwable) { log.error("set display member site failure[$it]", t) }
        }
        map["is_report_metric"] = ValueCallback {                                                    // f$z0
            try { BaseLibConfig.isReportMetric = it.toBoolean() } catch (t: Throwable) { log.error("set is report metric failure[$it]", t) }
        }
        map["has_subject"] = ValueCallback {                                                         // f$a1
            try {
                val old = BaseLibConfig.hasSubject
                BaseLibConfig.hasSubject = it.toBoolean()
                log.info("set_param has_subject[$it][$old -> ${BaseLibConfig.hasSubject}]")
            } catch (t: Throwable) { log.error("set_param has subject failure[$it]", t) }
        }
        map["share_app_tip"] = ValueCallback {                                                       // f$b1
            try { BaseLibConfig.shareAppTip = it } catch (t: Throwable) { log.error("set has subject failure[$it]", t) }
        }
        map["share_app_info"] = ValueCallback {                                                      // f$d1
            try { BaseLibConfig.shareAppInfo = it } catch (t: Throwable) { log.error("set has subject failure[$it]", t) }
        }
        map["has_referral_summary"] = ValueCallback {                                                // f$e1
            try { BaseLibConfig.hasReferralSummary = it.toBoolean() } catch (t: Throwable) { log.error("set has referral summary failure[$it]", t) }
        }
        map["refresh_sports_minutes"] = ValueCallback {                                              // f$f1
            try { BaseLibConfig.refreshSportsEventInterval = it.toLong() * 60000 } catch (t: Throwable) { log.error("set has referral summary failure[$it]", t) }
        }
        map["catchup_dvr_days"] = ValueCallback {                                                    // f$g1
            try { BaseLibConfig.catchupDvrDays = it.toInt() } catch (t: Throwable) { log.error("set has referral summary failure[$it]", t) }
        }
        map["has_catchup"] = ValueCallback {                                                         // f$h1
            try { BaseLibConfig.hasCatchup = it.toBoolean() } catch (t: Throwable) { log.error("set has catchup failure[$it]", t) }
        }
        map["mobile_app_qrcode"] = ValueCallback { hb.mobileAppQrCodeImg = it }                      // f$i1
        map["ad_list_ext"] = ValueCallback {                                                         // f$j1
            Preferences.putString("ad_list_ext", it)
            AdManager.updateAdListExt(it)
        }
        map["feedback_logcat_exe_duration"] = ValueCallback {                                        // f$k1
            try { hb.feedbackLogcatExecuteDuration = it.toInt().coerceAtLeast(0) } catch (_: Exception) {}
        }
        map["feedback_exe_did"] = ValueCallback {                                                    // f$l1
            // Gatilho remoto: o servidor lista dids; se o deste aparelho estiver no texto, captura logcat e envia.
            if (it.isNotEmpty() && it.contains(AppAttrUtils.did())) {
                LogCatHelper.startLogAndUpload(hb.feedbackLogcatExecuteDuration) { ok, code ->
                    log.info("feedback silent call $ok with $code")
                }
            }
        }
        map["mb_tb_flt_mils"] = ValueCallback {                                                      // f$m1
            try { BaseLibConfig.mobileTabSwitchFilterMills = it.toLong() } catch (_: Exception) {}
        }
    }

    /** Original: dc/a.d(String, long) — parse com default. */
    private fun parseLong(s: String?, dft: Long): Long = s?.toLongOrNull() ?: dft
}

/**
 * Modo de push do TS proxy.
 *
 * Original: v6/d.java (enum UDP(0), GOP(1), TS(2); `f(int)` devolve null se desconhecido)
 */
enum class TsPushMode(val value: Int) {
    UDP(0), GOP(1), TS(2);

    companion object {
        /** Original: v6.d.f(int) */
        fun fromValue(v: Int): TsPushMode? = values().firstOrNull { it.value == v }
    }
}
