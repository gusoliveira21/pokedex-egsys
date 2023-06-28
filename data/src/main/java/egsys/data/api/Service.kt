package egsys.data.api

import egsys.data.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET

interface Service {
    @GET("api/v2/pokemon?offset=0&limit=1126")
    fun getListPokemons(): Call<PokemonList>
}