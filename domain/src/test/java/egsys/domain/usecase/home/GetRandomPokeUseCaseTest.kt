package egsys.domain.usecase.home

import assertk.assertThat
import assertk.assertions.isNotEqualTo
import egsys.domain.repository.Repository
import egsys.domain.usecase.MockDataManager.listPokemons
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class GetRandomPokeUseCaseTest {
    private val repository = mockk<Repository>(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `receives a list of pokemons and selects one at random`() = runBlocking {
        coEvery { repository.getOneRandomPoke() } returns listPokemons

        val result1 = GetRandomPokeUseCase(repository).execute(null)
        val result2 = GetRandomPokeUseCase(repository).execute(null)

        assertThat { result1.success.data }.isNotEqualTo(result2.success.data)
    }

}