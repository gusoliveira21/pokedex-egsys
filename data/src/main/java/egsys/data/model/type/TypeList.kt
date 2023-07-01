package egsys.data.model.type

import com.squareup.moshi.Json

data class TypeList (
    @field:Json(name = "count"    ) val count    : Long,
    @field:Json(name = "next"     ) val next     : String?,
    @field:Json(name = "previous" ) val previous : Any?,
    @field:Json(name = "results"  ) val results  : List<Type>
)