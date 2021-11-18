plugins {
    id("java-library")
    id("kotlin")
}
java {
    sourceCompatibility = BuildConfigVersions.versionJava
    targetCompatibility = BuildConfigVersions.versionJava
}

dependencies {
    // coroutine
    implementation(KotlinDependencies.coroutine)
}
