package egsys.domain.usecase.home

import assertk.assertThat
import assertk.assertions.isEqualTo
import egsys.domain.repository.Repository
import egsys.domain.usecase.MockDataManager.listType
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test

class GetListTypeUseCaseTest {
    private val repository = mockk<Repository>(relaxed = true)

    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun `getListType returns a List with Types`() = runBlocking {
        coEvery { repository.getListType() } returns listType

        val result = GetListTypeUseCase(repository).execute(null)

        assertThat(result.success.data)
            .isEqualTo(listType)
    }
}