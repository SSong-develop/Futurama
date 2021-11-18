package com.ssong_develop.data.service

import com.ssong_develop.data.ApiResponse
import com.ssong_develop.data.dto.CharactersDTO
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface CharacterService {

    @GET("v2/characters")
    fun fetchAllCharacters() : Flow<ApiResponse<List<CharactersDTO>>>
}