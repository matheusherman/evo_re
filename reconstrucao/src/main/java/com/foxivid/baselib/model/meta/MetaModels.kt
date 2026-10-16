package com.foxivid.baselib.model.meta

import com.foxivid.baselib.config.TimeUtilsRef
import com.foxivid.baselib.model.common.ApiResult
import com.foxivid.baselib.model.common.BaseModel
import com.google.gson.annotations.SerializedName

/* Modelos de metadados (canais, EPG, VOD, catch-up). Pacote original: z1/b1/lb/m/meta. */

/** Original: ApiPageableResponse.java (estende n6.b). */
open class ApiPageableResponse<T> : ApiResult<T>() {
    var pageId: Int = 0
    var pageNo: Int = 0
    var pageSize: Int = 0
    var totalCount: Long = 0
}

/** Original: BasePageableResponse.java. */
open class BasePageableResponse : BaseModel() {
    var pageSize: Int = -1
    var pageId: Int = 1
    var pageNo: Int = 1
    var totalCount: Long = 0
}

/**
 * Parâmetros de catch-up (não é enviado como JSON: os campos viram query em StreamMetaApi).
 * Original: CatchupPlayRequest.java (campos ofuscados).
 */
class CatchupPlayRequest {
    @SerializedName("a") var streamId: String? = null
    @SerializedName("b") var catchupRoute: String? = null
    @SerializedName("c") var catchupStreamId: String? = null
    @SerializedName("d") var startTimestamp: Long = 0
    @SerializedName("e") var endTimestamp: Long = 0
}

/** Original: CatchupPlayResponse.java. */
class CatchupPlayResponse : BaseModel() {
    var playUrl: String? = null
    var token: String? = null
    var validTime: Long = 0
}

/** Original: ChannelEPGIndexResponse.java. */
class ChannelEPGIndexResponse : BaseModel() {
    var checksum: String? = null
    var indexAddress: String? = null
}

/** Original: ChannelListResponse.java. */
class ChannelListResponse : BasePageableResponse() {
    var channelEPGIndexResponse: ChannelEPGIndexResponse? = null
    var playerArgs: String? = null
    var tenantId: String? = null
    var channelStreams: List<ChannelStreamResponse> = ArrayList()
    var categorySorts: List<String> = ArrayList()
}

/**
 * Canal ao vivo. equals/hashCode apenas por [key].
 * Original: ChannelStreamResponse.java.
 */
class ChannelStreamResponse : BaseModel() {
    var catchup: Boolean = false
    var catchupCdnAddress: String? = null
    var catchupRoute: String? = null
    var catchupStreamId: String? = null
    var categories: String? = null
    var displaySeq: Int = 0
    var epgId: String? = null
    var iconUrl: String? = null
    var key: Int = 0
    var liveCdnAddress: String? = null
    var playerArgs: String? = null
    var route: String? = null
    var streamId: String? = null
    var streamName: String? = null
    var type: Int = 0

    /** `true` para type 1 ou 3. Original: c() (significado do tipo não identificado). */
    fun isTypeOneOrThree(): Boolean = type == 1 || type == 3

    override fun equals(other: Any?): Boolean =
        this === other || (other != null && javaClass == other.javaClass && key == (other as ChannelStreamResponse).key)

    override fun hashCode(): Int = java.util.Objects.hash(key)
}

/** Original: EPGProgramme.java. */
class EPGProgramme : BaseModel() {
    var category: String? = null
    var channel: String? = null
    var desc: String? = null
    var end: Long = 0
    var iconSrc: String? = null
    var start: Long = 0
    var title: String? = null
}

/** Original: EpgIndex.java. */
class EpgIndex : BaseModel() {
    var channelId: String? = null
    var checksum: String? = null
    var date: String? = null
    var file: String? = null
}

/**
 * Item de playlist/VOD. Os getters de poster/backdrop passam a URL por util/l0.a()
 * (prefixa com IMG_SERVERS quando relativa — outro módulo).
 * Original: PlaylistMetaResponse.java (equals/hashCode sobre todos os campos).
 */
open class PlaylistMetaResponse : BaseModel() {
    var popularity: Double? = 0.0
    var voteAverage: Double? = 0.0
    var metaId: String = ""
    var language: String = "en"
    var videoType: Int = 0
    var title: String = ""
    var poster: String = ""
        get() = ImageUrlRef.resolve(field)
    var backdrop: String = ""
        get() = ImageUrlRef.resolve(field)
    var releaseDate: String = ""
}

/** Original: MetaDetailResponse.java. */
class MetaDetailResponse : PlaylistMetaResponse() {
    var casts: List<String>? = null
    var directors: List<String>? = null
    var genres: List<String>? = null
    var overview: String? = null
    var recommendations: List<PlaylistMetaResponse>? = null
    var runtime: Int = 0
    var seasons: List<Int> = ArrayList()
    var type: Int = 0
}

/** Original: MetaPlaySourceResponse.java. */
class MetaPlaySourceResponse : BaseModel() {
    var episode: Int = 0
    var language: String? = null
    var metaId: String? = null
    var pageId: Int = 0
    var pageNo: Int = 0
    var pageSize: Int = 0
    var playerArgs: String? = null
    var resolution: String? = null
    var routeId: String? = null
    var season: Int = 0
    var sourceId: String? = null
    var totalCount: Int = 0
    var videoType: Int = 0
}

/** Original: PlaySourcesResponse.java. */
class PlaySourcesResponse : BasePageableResponse() {
    var metaId: String? = null
    var playSources: List<MetaPlaySourceResponse> = ArrayList()
}

/** Original: PlaylistResponse.java (equals/hashCode sobre todos os campos exceto createTime). */
class PlaylistResponse : BasePageableResponse() {
    var playlistId: String = ""
    var playlistName: String = ""
    var playlistType: Int = 0
    var metaQueryExpression: String = ""
    var showType: Int = 0
    var desc: String = ""
    var language: String = "en"
    var subPlaylist: List<PlaylistResponse> = ArrayList()
    var metaList: List<PlaylistMetaResponse> = ArrayList()
    var createTime: Long = TimeUtilsRef.now()
    var iconUrl: String = ""
    var showTypeCfg: ShowTypeCfg? = null
}

/** Original: ShowTypeCfg.java. */
class ShowTypeCfg : BaseModel() {
    var category: String? = null
    var streamId: String? = null
    var videoType: String? = null
    var filter: Boolean = false
    var genres: String = ""
    var showListOnly: Boolean = false
    var hideTitle: Boolean = false
}

/** Ponte para util/l0.a(url). */
internal object ImageUrlRef {
    fun resolve(url: String): String = com.foxivid.baselib.util.ImageUrlBuilder.build(url)
}
