package com.ssong_develop.data.source

import com.ssong_develop.data.ApiResponse
import com.ssong_develop.data.dto.CharactersDTO
import com.ssong_develop.data.service.CharacterService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterDataSource @Inject constructor(
    private val service : CharacterService
) : DataSource {
    override fun fetch(): Flow<ApiResponse<List<CharactersDTO>>> = service.fetchAllCharacters()
}