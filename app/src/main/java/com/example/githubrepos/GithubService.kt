package com.example.githubrepos

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories")
    suspend fun getRepos(@Query(value = "q")query: String = "trending",
                         @Query(value = "sort")sort: String = "stars",
                         @Query(value = "order")order : String = "desc") : Response<Repos>
}