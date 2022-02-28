package com.jonathas.googlepublicrepositories.repository

class GitReposRepository{

    private val restService = RestServiceImpl(WebClient()).provideWebService()

    fun fetchRepos(page: Int) =
        restService.getPublicRepos(page, 10)
}