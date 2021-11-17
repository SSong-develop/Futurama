plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = BuildConfigVersions.compileSdk

    defaultConfig {
        applicationId = BuildConfigVersions.appPackageName
        minSdk = BuildConfigVersions.minSdk
        targetSdk = BuildConfigVersions.targetSdk
        versionCode = BuildConfigVersions.versionCode
        versionName = BuildConfigVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
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
    implementation(AndroidxSupportDependencies.appCoreKtx)
    implementation(AndroidxSupportDependencies.appCompat)
    implementation(AndroidxSupportDependencies.materialDesign)
    implementation(AndroidxSupportDependencies.constraintLayout)
    implementation(AndroidxSupportDependencies.recyclerView)

    implementation(ArchitectureComponentDependencies.viewModelKtx)
    implementation(ArchitectureComponentDependencies.activityKtx)
    implementation(ArchitectureComponentDependencies.fragmentKtx)
    implementation(ArchitectureComponentDependencies.roomRuntime)
    implementation(ArchitectureComponentDependencies.roomKtx)
    kapt(ArchitectureComponentDependencies.roomCompiler)

    implementation(NetworkDependencies.retrofit)
    implementation(NetworkDependencies.okHttp)
    implementation(NetworkDependencies.okHttpInterceptor)
    implementation(NetworkDependencies.okHttpLoggingInterceptor)

    implementation(KotlinDependencies.coroutine)

    implementation(GlideDependencies.glide)
    implementation(GlideDependencies.glidePalette)
}

dependencies {
    testImplementation(TestDependencies.Junit)
    androidTestImplementation(TestDependencies.androidXJUnit)
    androidTestImplementation(TestDependencies.androidxEspresso)
}