package com.ikxguru.view.posts

import com.ikxguru.data.Post
import com.ikxguru.repo.Repo
import com.ikxguru.view.base.BaseTest
import com.ikxguru.view.posts.PostsViewModel.State
import com.ikxguru.view.util.getOrAwaitValues
import com.ikxguru.view.util.toSuccessResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.When
import org.amshove.kluent.calling
import org.amshove.kluent.itReturns
import org.amshove.kluent.mock
import org.amshove.kluent.shouldEqual
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class PostsViewModelTest : BaseTest() {

    private val repo: Repo = mock(Repo::class)
    private lateinit var vm: PostsViewModel
    private val userId = 1

    @ExperimentalCoroutinesApi
    @Test
    fun `초기 데이터 로딩`() {
        val loading = State.Success(loading = true)
        val initialPosts = (0..10).map { index ->
            Post(userId, index, "${index}title", "${index}body")
        }
        val success = State.Success(posts = initialPosts)
        val expected = listOf(loading, success)

        runBlockingTest {
            When calling repo.fetchPosts(0, 10) itReturns initialPosts.toSuccessResponse()
        }
        vm = PostsViewModel(repo)
        vm.loadInitialPosts()

        val actual = vm.success.getOrAwaitValues()

        actual shouldEqual expected
    }
}