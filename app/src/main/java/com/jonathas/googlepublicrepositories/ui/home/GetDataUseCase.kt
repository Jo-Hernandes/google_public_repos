package com.jonathas.googlepublicrepositories.ui.home

import com.jonathas.googlepublicrepositories.repository.GitReposRepository
import com.jonathas.googlepublicrepositories.repository.models.RepoResponse

class GetDataUseCase(private val service: GitReposRepository) {

    operator fun invoke(page: Int) =
        service.fetchRepos(page)
            .map(::mapToModel)


    private fun mapToModel(repos: RepoResponse): List<HomeRepoModel> =
        repos.map {
            HomeRepoModel(
                it.name,
                it.owner.avatar_url
            )
        }

}