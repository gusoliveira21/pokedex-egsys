package egsys.data.api

import egsys.data.model.pokemon.PokemonList
import egsys.data.model.type.TypeList
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("api/v2/pokemon?offset=0&limit=1126")
    fun getListPokemons(): Call<PokemonList>

    @GET("api/v2/type")
    fun getListTypes(): Call<TypeList>
}