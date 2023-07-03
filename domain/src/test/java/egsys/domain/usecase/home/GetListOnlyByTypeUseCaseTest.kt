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

class GetListOnlyByTypeUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getListPokemons by type returns a pokemon list with`() = runBlocking {
        coEvery { repository.getListOnlyByType(listPokemons[0].id.toString()) } returns listPokemons

        val result = GetListOnlyByTypeUseCase(repository).execute(listPokemons[0].id.toString())

        assertk.assertThat(result.success.data)
            .isEqualTo(listPokemons)
    }
}