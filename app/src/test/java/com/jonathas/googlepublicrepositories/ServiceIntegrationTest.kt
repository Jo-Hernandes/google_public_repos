package com.jonathas.googlepublicrepositories

import com.jonathas.googlepublicrepositories.repository.RestServiceImpl
import com.jonathas.googlepublicrepositories.repository.WebClient
import com.jonathas.googlepublicrepositories.repository.WebService
import org.junit.Test

import org.junit.Before

class ServiceIntegrationTest : DefaultSynchronousTest() {

    private lateinit var service: WebService

    @Before
    fun `init webService object`() {
        service = RestServiceImpl(WebClient()).provideWebService()
    }

    @Test
    fun `returns success if there is internet connection available`() {
        service.getPublicRepos(1, 1)
            .test()
            .assertNoTimeout()
            .assertValue { it.isNotEmpty() }
    }

    @Test
    fun `returns the amount of data expected by quantity`() {
        val EXPECTED_QUANTITY = 1

        service.getPublicRepos(1, EXPECTED_QUANTITY)
            .test()
            .assertNoTimeout()
            .assertValueCount(EXPECTED_QUANTITY)
    }



}