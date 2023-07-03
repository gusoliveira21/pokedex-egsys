package egsys.domain.usecase.home

import assertk.assertions.isEqualTo
import egsys.domain.repository.Repository
import egsys.domain.usecase.MockDataManager.listPokemons
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class GetListPokemonsUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getList returns a pokemon list`() = runBlocking {
        coEvery { repository.getListPokemons() } returns listPokemons

        val result = GetListPokemonsUseCase(repository).execute(null)

        assertk.assertThat(result.success.data).isEqualTo(listPokemons)
    }
}