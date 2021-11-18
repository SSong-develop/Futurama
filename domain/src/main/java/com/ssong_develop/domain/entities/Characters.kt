package com.ssong_develop.domain.entities

data class Characters(
    val species: String?,
    val age: String,
    val planet: String,
    val profession: String,
    val status : String,
    val firstAppearance : String,
    val avatarUrl : String,
    val relatives : String,
    val characterVoice : String?,
    val characterName : String
)