package com.foxivid.baselib.model.user

import com.foxivid.baselib.model.common.BaseModel

/*
 * Modelos do protocolo antigo de usuário/heartbeat (token + checksum em query, como em
 * StreamMetaApi.getMetaChannelList). Pacote original: z1/b1/lb/m/user.
 */

/** Original: BaseRequest.java. */
open class BaseRequest : BaseModel() {
    var appId: String? = null
    var appVer: Int = 0
    var did: String? = null
    var requestTime: Long = 0
}

/** Original: HeartbeatRequest.java. */
class HeartbeatRequest : BaseRequest() {
    var checksum: String? = null
    var token: String? = null
    var uid: String? = null
}

/** Original: HeartbeatResponse.java. */
class HeartbeatResponse : BaseModel() {
    var checksum: String? = null
    var metaServers: List<ServerResponse>? = null
    var streamServers: List<ServerResponse>? = null
    var token: String? = null
    var uid: String? = null
    var updateServers: List<ServerResponse>? = null
}

/** Original: LoginRequest.java (user). */
class LoginRequest : BaseRequest() {
    var password: String? = null
    var username: String? = null
}

/** Original: LoginResponse.java. */
class LoginResponse : BaseModel() {
    var checksum: String? = null
    var metaServers: List<ServerResponse>? = null
    var streamServers: List<ServerResponse>? = null
    var token: String? = null
    var uid: String? = null
    var updateServers: List<ServerResponse>? = null
}

/** Servidor (id + endereço); equals/hashCode pelos dois campos. Original: ServerResponse.java. */
data class ServerResponse(
    var serverId: String? = null,
    var serverAddress: String? = null,
) : BaseModel()
