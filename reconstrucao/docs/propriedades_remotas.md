# Propriedades remotas (heartbeat)

Fonte: `x1/f1/lb/heartbeat/f.java` (nome Kotlin original `HeartbeatUpgradeManager.kt`), bloco `static {}` e as classes internas `f$a` … `f$m1`.
Reconstrução: `com.foxivid.baselib.heartbeat.HeartbeatManager` e `AppPropertyHandlers`.

## Como são aplicadas

`HeartbeatManager.applyProperties(map)` (original `f.K0(Map)`):

1. Espera a inicialização (`CountDownLatch`).
2. Para cada chave `K` registrada, procura primeiro `"<appType>_K"` (appType = `of.a.c()`, por exemplo `mobile`) e depois `K`.
3. Chama o handler com `value.toString()`. As chaves recebidas sem handler aparecem no log como `set_param ignoredProperties[...]`.

Os intervalos em segundos só são aplicados quando passam do limite mínimo indicado. Quando o parse falha, o valor anterior é mantido.

## Tabela

| Chave | Handler | Tipo/unidade | Efeito (destino) | Default |
|---|---|---|---|---|
| `IS_DEVICE_FREE` | f$k | bool | `isFree`; se ausente, `isFreeDevice()` usa a heurística `util/z.z()` | null |
| `AUTO_LOGIN_BEFORE_TOKEN_EXPIRED` | f$v | ms, ≥ 300000 | antecedência do auto-login antes de o token expirar | 300000 |
| `AUTO_REFRESH_ACCESS_TOKEN_INTERVAL` | f$g0 | ms, ≥ 3600000 | intervalo de refresh do access token | 43200000 (12 h) |
| `HEART_BEAT_INTERVAL` | f$r0 | s, > 30 | intervalo do auto-login/refresh no tick | 120000 ms |
| `UPGRADE_CHECK_INTERVAL` | f$c1 | s, > 30 | intervalo de checagem de upgrade | 7200000 ms (2 h) |
| `METRIC_HEART_BEAT_INTERVAL` | f$n1 | s, > 30 | intervalo do envio "liveHeartbeat" | 120000 ms |
| `ECO_MODE_TIME_MINUTES` | f$p1 | min, > 1 | tempo para entrar no modo eco (`echoModeTime`) | 120 min |
| `customer_service_qrcode` | f$q1 | URL | QR code do suporte | "" |
| `customer_service_email` | f$r1 | texto | e-mail do suporte | "" |
| `customer_whatsapp_link` | f$a | URL | grupo de WhatsApp | "" |
| `customer_service_whatsapp` | f$b | texto | WhatsApp do suporte | "" |
| `customer_service_telegram` | f$c | texto | Telegram do suporte | "" |
| `customer_service_facebook` | f$d | texto | Facebook do suporte | "" |
| `expire_remind_seconds` | f$e | int (s) | aviso de expiração | 259200 |
| `daily_remind_times` | f$f | int | quantidade de lembretes por dia | 10 |
| `re_login_max_cnt_after_expired` | f$g | int | máximo de relogins depois de expirar | -1 |
| `how2order` | f$h | texto | instruções de compra | "" |
| `udp_log_servers` | f$i | "host:porta,..." | `RemoteLogger.setUdpLoggerServer` (resolve DNS → ip:porta) | — |
| `promotion_trial_days` | f$j / **f$m** | int | **Registrada duas vezes.** f$m sobrescreve f$j, então o valor vai para `limitContinuingRenewDays` e `promotionTrialDays` fica sempre em 7 | 7 / null |
| `prompt_renew_plan_left_hours` | f$l | h | `promptRenewMillis` = h × 3600000 | 72 h |
| `membership_qrcode_refresh_interval` | f$n | int (s) | `<= 0` desliga `isRenewAutoRefresh`; `> 10` define `qrcodeRefreshIntervalSeconds` | 15 |
| `eco_mode_pics` | f$o | lista "," | imagens do modo eco (`util/d0.s`) | — |
| `marquee_display_interval` | f$p | int, > 1000 | intervalo de exibição do letreiro | — |
| `login_retry_interval_seconds` | f$q | s, > 15 | `loginRetryIntervalMs` | 60000 ms |
| `marquee_display_times` | f$r | int > 0 | número de repetições do letreiro | — |
| `marquee_display_contents` | f$s | textos separados por `$$` | conteúdos do letreiro | — |
| `marquee_update_interval_minutes` | f$t | min, 0 < v < 14400 | intervalo de atualização do letreiro | — |
| `marquee_alternately_display` | f$u | bool | exibição alternada | — |
| `ad_list` | f$w | JSON | gravado em prefs `startup_ad_list` | — |
| `email_be_blocked_host_list` | f$x | lista "," | hosts de e-mail recusados no cadastro | {} |
| `is_epg_enable` | f$y | bool | habilita EPG (`media/c.s`) | — |
| `email_host_block_tip` | f$z | texto | mensagem para host de e-mail bloqueado | "" |
| `start_up_ad_count_num` | f$a0 | int > 0 | contagem do anúncio de abertura | 6 |
| `meta_update_min_interval_sec` | f$b0 | s > 0 | intervalo mínimo de atualização de metadados | 1800 s |
| `guest_trial_end_player_tip_text` | f$c0 | texto (vazio é ignorado) | aviso de fim de trial (convidado) | "" |
| `member_trial_end_player_tip_text` | f$d0 | texto | aviso de fim de trial (membro) | "" |
| `guest_trial_end_player_tip_img_url` | f$e0 | URL | imagem do aviso (convidado) | "" |
| `member_trial_end_player_tip_img_url` | f$f0 | URL | imagem do aviso (membro) | "" |
| `is_show_register_first_for_new_user` | f$h0 | bool | mostra o cadastro primeiro para usuário novo | false |
| `subtitle_dft_lang` | f$i0 | texto | idioma padrão da legenda | "PT" |
| `subtitle_lang_list` | f$j0 | lista "," | idiomas de legenda | [EN, PT] |
| `is_report_client_detail_log` | f$k0 | bool | loga cada métrica em info, que segue para o log remoto | false |
| `is_telegram_bot_enable` | f$l0 | bool | `TelegramBot.setEnable` | true |
| `is_remind_after_plan_expired` | f$m0 | int | `user/f.B1` | — |
| `is_remind_plan_not_bind_username` | f$n0 | int | `user/f.C1` | — |
| `plan_will_expire_remind` | f$o0 | int | `user/f.z1` | — |
| `zapping_time_bot_when_gt_seconds` | f$p0 | s > 3 | limiar para a mensagem `[zapping time]` | 8 s |
| `log_main_thread_block_gt_millis` | f$q0 | ms > 300 | limiar de bloqueio da main thread (`util/c.s`) | — |
| `log_dropped_frames_gt` | f$s0 | int > 1 | limiar de frames perdidos (`util/c.r`) | — |
| `plan_html` | f$t0 | HTML | página de planos | "" |
| `player_proxy_type` | f$u0 | "ts"/outro | `BaseLibConfig.proxyType` = "TS" ou "HLS" | "TS" |
| `max_downloading_block_cnt` | f$v0 | int > 0 | blocos baixados em paralelo no proxy | null |
| `ts_push_mode` | f$w0 | 0/1/2 | `v6.d` UDP/GOP/TS (outro valor → null) | UDP |
| `display_member_site` | f$x0 | bool | exibe o site de membros | true |
| `verify_channel_when_upgrade` | f$y0 | bool | confere o meta-data `DISTRIBUTION_CHANNEL` do APK antes de instalar | false |
| `is_report_metric` | f$z0 | bool | liga o `MetricAgent` (sem isso nenhuma métrica é enfileirada) | false |
| `has_subject` | f$a1 | bool | `BaseLibConfig.hasSubject` | false |
| `share_app_tip` | f$b1 | texto | texto de compartilhamento | "" |
| `share_app_info` | f$d1 | texto | informação de compartilhamento | "" |
| `has_referral_summary` | f$e1 | bool | resumo de indicações | false |
| `refresh_sports_minutes` | f$f1 | min | intervalo de atualização de esportes | 0 |
| `catchup_dvr_days` | f$g1 | int | dias de catch-up | 3 |
| `has_catchup` | f$h1 | bool | habilita catch-up | true |
| `mobile_app_qrcode` | f$i1 | URL | QR code do app mobile | "" |
| `ad_list_ext` | f$j1 | JSON | prefs `ad_list_ext` + `AdManager` (`ad/b.f`) | — |
| `feedback_logcat_exe_duration` | f$k1 | s ≥ 0 | duração da captura de logcat no feedback silencioso | 3 |
| `feedback_exe_did` | f$l1 | texto | **gatilho remoto**: se o texto contém o did do aparelho, captura o logcat (com ANR traces) e envia para `/api/feedback/upload/v1` sem interação do usuário | — |
| `mb_tb_flt_mils` | f$m1 | ms | `mobileTabSwitchFilterMills` | 3500 |

## O que o tick de 5 s faz (`f.s0`)

Só roda depois de `start()` (`f.L0`):

1. `MarqueeManager.checkAndUpdate(now)`.
2. Se a métrica de startup ainda não foi enviada e já se passaram mais de 60 s desde o início, envia `liveUserStartup`.
3. Assina os canais (`media/a.q(10000)`) sem reentrância.
4. Se logado, recarrega a lista de canais.
5. Verifica e atualiza o EPG e os esportes.
6. Quando vence `UPGRADE_CHECK_INTERVAL`, consulta `/api/v1/upgrade/config`.
7. Quando vence `METRIC_HEART_BEAT_INTERVAL`, envia `liveHeartbeat`.
8. Atualiza as amostras de RSSI do Wi-Fi.
9. Quando vence `HEART_BEAT_INTERVAL`, faz auto-login e refresh de token.
