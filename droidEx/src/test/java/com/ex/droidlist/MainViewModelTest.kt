package com.ex.droidlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verifyOrder
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()

    @RelaxedMockK
    lateinit var mockObserver: Observer<Boolean>

    lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        viewModel = MainViewModel()
    }

    @Test
    fun testValidation() {
        viewModel.isFormValid.observeForever(mockObserver)

        viewModel.username = "username1"
        viewModel.password = "password1"
        viewModel.username = "username"
        viewModel.password = "password1"
        viewModel.username = "username123"

        verifyOrder {
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
            mockObserver.onChanged(false)
            mockObserver.onChanged(false)
            mockObserver.onChanged(true)
        }
    }
}