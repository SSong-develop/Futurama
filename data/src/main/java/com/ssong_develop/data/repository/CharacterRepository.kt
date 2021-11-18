package com.ssong_develop.data.repository

import com.ssong_develop.data.ApiResponse
import com.ssong_develop.data.NetworkResource
import com.ssong_develop.data.dto.CharactersDTO
import com.ssong_develop.data.dto.asCharactersList
import com.ssong_develop.data.module.IoDispatcher
import com.ssong_develop.data.source.DataSource
import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.domain.repository.Repository
import com.ssong_develop.domain.vo.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val dataSource: DataSource,
    @IoDispatcher private val ioDispatcher : CoroutineDispatcher
) : Repository {
    override fun load(): Flow<Resource<List<Characters>>> {
        val networkResource = object : NetworkResource<List<CharactersDTO>>() {
            override suspend fun fetchFromNetwork(): Flow<ApiResponse<List<CharactersDTO>>> =
                dataSource.fetch()

            override suspend fun onFetchFailed(errorBody: String?, statusCode: Int) {
                super.onFetchFailed(errorBody, statusCode)
            }
        }.asFlow()
            .map {
                when (it.status) {
                    Resource.Status.LOADING -> {
                        Resource.loading(null)
                    }
                    Resource.Status.SUCCESS -> {
                        val characters = it.data?.asCharactersList()
                        Resource.success(characters)
                    }
                    Resource.Status.ERROR -> {
                        Resource.error(it.message!!, null)
                    }
                }
            }
        return networkResource.flowOn(ioDispatcher)
    }
}