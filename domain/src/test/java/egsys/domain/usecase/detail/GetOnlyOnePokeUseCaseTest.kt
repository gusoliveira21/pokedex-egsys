package egsys.domain.usecase.detail

import assertk.assertThat
import assertk.assertions.isEqualTo
import egsys.domain.repository.Repository
import egsys.domain.usecase.MockDataManager
import egsys.domain.usecase.MockDataManager.listPokemons
import egsys.domain.usecase.MockDataManager.pokemonA
import egsys.domain.usecase.MockDataManager.pokemonDetEntity
import egsys.domain.usecase.home.GetListOnlyByTypeUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class GetOnlyOnePokeUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getListPokemons by type returns a pokemon list with`() = runBlocking {
        coEvery { repository.getOnlyOnePoke("7") } returns pokemonDetEntity

        val result = GetOnlyOnePokeUseCase(repository).execute("7")

        assertThat(result.success.data).isEqualTo(pokemonDetEntity)
    }
}