package com.ssong_develop.domain.repository

import com.ssong_develop.domain.entities.Characters
import com.ssong_develop.domain.vo.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun load() : Flow<Resource<List<Characters>>>

}