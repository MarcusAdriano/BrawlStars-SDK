package io.github.marcusadriano.brawlstars.model

import com.google.gson.annotations.SerializedName

open class Item(
    @SerializedName("id") open val id: Int?,
    @SerializedName("name") open val name: String?
)