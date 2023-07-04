package egsys.domain.usecase.home

import assertk.assertions.isEqualTo
import egsys.domain.entities.SearchEntity
import egsys.domain.repository.Repository
import egsys.domain.usecase.MockDataManager.listPokemonsReorganize
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class GetListWithNameAndTypeUseCaseTest {

    private val repository = mockk<Repository>(relaxed = true)

    lateinit var useCase: GetListWithNameAndTypeUseCase

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        useCase = GetListWithNameAndTypeUseCase(repository)
    }

    @Test
    fun `should return filtered and unfiltered list`() = runBlocking {
        val searchEntities = listOf(
            SearchEntity("1", "ivy"),
        )

        coEvery { repository.getListOnlyByType(searchEntities[0].id) } returns listPokemonsReorganize

        val result = useCase.execute(searchEntities)

        assertk.assertThat(result.success.data).isEqualTo(listPokemonsReorganize)
    }
}

