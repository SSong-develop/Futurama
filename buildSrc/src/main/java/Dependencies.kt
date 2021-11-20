import org.gradle.api.JavaVersion

object BuildConfigVersions {
    const val minSdk = 21
    const val targetSdk = 31
    const val compileSdk = 31
    const val versionCode = 1
    const val versionName = "1.0.0"
    val versionJava = JavaVersion.VERSION_11
    const val versionJvm = "11"
    const val appPackageName = "com.ssong_develop.futurama"
}

object Versions {
    // Androidx
    const val versionConstraint = "2.1.1"
    const val versionCoreKtx = "1.7.0"
    const val versionAppCompat = "1.3.1"
    const val versionMaterial = "1.4.0"
    const val versionRecyclerview = "1.2.1"

    // ArchitectureComponent
    const val versionLifecycle = "2.4.0"
    const val versionFragmentKtx = "1.3.6"
    const val versionActivityKtx = "1.3.0"
    const val versionRoom = "2.3.0"

    // Network
    const val versionGson = "2.9.0"
    const val versionOkHttp = "4.9.1"
    const val versionRetrofit = "2.9.0"

    // Glide
    const val versionGlide = "4.12.0"
    const val versionGlidePalette = "2.1.2"

    // Coroutine
    const val versionCoroutine = "1.5.0"

    // test
    const val versionEspressoCore = "3.1.1"
    const val versionJUnit = "4.13.1"
    const val versionAndroidxTestJUnit = "1.1.2"

    // Hilt
    const val versionHilt = "1.0.0"
    const val versionHiltCore = "2.38.1"
}

object AndroidxSupportDependencies {
    const val appCoreKtx = "androidx.core:core-ktx:${Versions.versionCoreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.versionAppCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.versionMaterial}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.versionConstraint}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.versionRecyclerview}"
}

object ArchitectureComponentDependencies {
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.versionActivityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.versionFragmentKtx}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.versionLifecycle}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.versionRoom}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.versionRoom}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.versionRoom}"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.versionLifecycle}"
}

object NetworkDependencies {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.versionRetrofit}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.versionOkHttp}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.versionOkHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.versionOkHttp}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.versionGson}"
}

object GlideDependencies {
    const val glide = "com.github.bumptech.glide:glide:${Versions.versionGlide}"
    const val glidePalette = "com.github.florent37:glidepalette:${Versions.versionGlidePalette}"
}

object KotlinDependencies {
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.versionCoroutine}"
}

object TestDependencies {
    const val androidXJUnit = "androidx.test.ext:junit:${Versions.versionAndroidxTestJUnit}"
    const val Junit = "junit:junit:${Versions.versionJUnit}"
    const val androidxEspresso = "androidx.test.espresso:espresso-core:${Versions.versionEspressoCore}"
}

object HiltDependencies {
    const val hiltCore = "com.google.dagger:hilt-android:${Versions.versionHiltCore}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.versionHiltCore}"
    const val androidXHiltCompiler = "androidx.hilt:hilt-compiler:${Versions.versionHilt}"
}