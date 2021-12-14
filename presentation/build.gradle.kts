plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
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
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    implementation(project(":utils"))

    implementation(AndroidxSupportDependencies.appCoreKtx)
    implementation(AndroidxSupportDependencies.appCompat)
    implementation(AndroidxSupportDependencies.materialDesign)
    implementation(AndroidxSupportDependencies.constraintLayout)
    implementation(AndroidxSupportDependencies.recyclerView)

    // hilt
    implementation(HiltDependencies.hiltCore)
    kapt(HiltDependencies.hiltCompiler)
    kapt(HiltDependencies.androidXHiltCompiler)

    // Glide
    implementation(GlideDependencies.glide)
    implementation(GlideDependencies.glidePalette)

    // architecture
    implementation(ArchitectureComponentDependencies.viewModelKtx)
    implementation(ArchitectureComponentDependencies.activityKtx)
    implementation(ArchitectureComponentDependencies.fragmentKtx)
    implementation(ArchitectureComponentDependencies.lifecycleKtx)
}