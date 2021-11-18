plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = BuildConfigVersions.compileSdk

    defaultConfig {
        minSdk = BuildConfigVersions.minSdk
        targetSdk = BuildConfigVersions.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = BuildConfigVersions.versionJava
        targetCompatibility = BuildConfigVersions.versionJava
    }
    kotlinOptions {
        jvmTarget = BuildConfigVersions.versionJvm
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":domain"))

    implementation(AndroidxSupportDependencies.appCoreKtx)
    implementation(AndroidxSupportDependencies.appCompat)
    implementation(AndroidxSupportDependencies.materialDesign)
    implementation(AndroidxSupportDependencies.constraintLayout)
    implementation(AndroidxSupportDependencies.recyclerView)

    // network
    implementation(NetworkDependencies.retrofit)
    implementation(NetworkDependencies.okHttp)
    implementation(NetworkDependencies.okHttpInterceptor)
    implementation(NetworkDependencies.okHttpLoggingInterceptor)
    implementation(NetworkDependencies.gsonConverter)

    // coroutine
    implementation(KotlinDependencies.coroutine)

    // hilt
    implementation(HiltDependencies.hiltCore)
    kapt(HiltDependencies.hiltCompiler)
    kapt(HiltDependencies.androidXHiltCompiler)
}