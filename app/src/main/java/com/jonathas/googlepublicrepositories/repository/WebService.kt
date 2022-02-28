package com.jonathas.googlepublicrepositories.repository

import com.jonathas.googlepublicrepositories.repository.models.RepoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("users/google/repos")
    fun getPublicRepos(
        @Query("page") page: Int,
        @Query("per_page") quantity: Int
    ): Single<RepoResponse>

}