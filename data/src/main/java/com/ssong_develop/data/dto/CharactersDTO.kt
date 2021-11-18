package com.ssong_develop.data.dto

import com.google.gson.annotations.SerializedName
import com.ssong_develop.domain.entities.Characters

data class CharactersDTO(
    @SerializedName("species")
    val species: String?,
    @SerializedName("Age")
    val age: String,
    @SerializedName("Planet")
    val planet: String,
    @SerializedName("Profession")
    val profession: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("FirstAppearance")
    val firstAppearance: String,
    @SerializedName("PicUrl")
    val avatarUrl: String,
    @SerializedName("Relatives")
    val relatives: String,
    @SerializedName("VoiceBy")
    val characterVoice: String?,
    @SerializedName("Name")
    val characterName: String
)

fun CharactersDTO.asCharacters() =
    Characters(
        species = species,
        age = age,
        planet = planet,
        profession = profession,
        status = status,
        firstAppearance = firstAppearance,
        avatarUrl = avatarUrl,
        relatives = relatives,
        characterVoice = characterVoice,
        characterName = characterName
    )

fun List<CharactersDTO>.asCharactersList() = map {
    it.asCharacters()
}