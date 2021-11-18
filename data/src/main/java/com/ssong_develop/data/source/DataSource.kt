package com.ssong_develop.data.source

import com.ssong_develop.data.ApiResponse
import com.ssong_develop.data.dto.CharactersDTO
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun fetch() : Flow<ApiResponse<List<CharactersDTO>>>
}