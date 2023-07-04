package egsys.data.api

import egsys.data.model.detailsType.DetailsType
import egsys.data.model.pokemon.PokemonList
import egsys.data.model.pokemonDetails.PokemonDetails
import egsys.data.model.type.TypeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {
    @GET("api/v2/pokemon?offset=0&limit=1126")
    fun getListPokemons(): Call<PokemonList>

    @GET("api/v2/type")
    fun getListTypes(): Call<TypeList>

    @GET("api/v2/type/{typeId}")
    fun getListOnlyByTypes(@Path("typeId") typeId: String): Call<DetailsType>

    @GET("api/v2/pokemon/{id}")
    fun getOnlyOnePokemon(@Path("id") id: String): Call<PokemonDetails>
}