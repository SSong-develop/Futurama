plugins {
    id ("com.android.library")
    id ("kotlin-android")
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
}

dependencies {
    implementation(AndroidxSupportDependencies.appCoreKtx)
    implementation(AndroidxSupportDependencies.appCompat)
    implementation(AndroidxSupportDependencies.materialDesign)
    implementation(AndroidxSupportDependencies.constraintLayout)
    implementation(AndroidxSupportDependencies.recyclerView)
}