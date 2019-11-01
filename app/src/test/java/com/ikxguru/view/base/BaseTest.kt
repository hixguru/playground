package com.ikxguru.view.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ikxguru.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.rules.TestRule

abstract class BaseTest {

    @get:Rule val rule: TestRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule val coroutineRule: TestRule = MainCoroutineRule()
}