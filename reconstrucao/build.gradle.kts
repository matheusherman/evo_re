plugins {
    id("com.android.library") version "8.9.2"
    id("org.jetbrains.kotlin.android") version "2.0.21"
}

android {
    namespace = "com.live.evo"
    compileSdk = 35
    defaultConfig { minSdk = 21 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions { jvmTarget = "17" }

    sourceSets["main"].java.srcDirs("src/main/java")
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.fragment:fragment-ktx:1.8.5")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.leanback:leanback:1.0.0")
    implementation("androidx.viewpager2:viewpager2:1.1.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-process:2.8.7")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation("com.github.skydoves:sandwich:1.3.9")
    implementation("org.greenrobot:eventbus:3.3.1")
    implementation("org.slf4j:slf4j-api:2.0.13")
    implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation("io.netty:netty-all:4.1.112.Final")
    implementation("com.koushikdutta.async:androidasync:3.1.0")
    implementation("io.github.youth5201314:banner:2.2.3")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation("org.bouncycastle:bcprov-jdk18on:1.78.1")
    implementation("com.google.zxing:core:3.5.3")
    implementation("com.google.android.flexbox:flexbox:3.0.0")
    implementation("com.github.JessYanCoding:AndroidAutoSize:v1.2.1")
    implementation("com.github.getActivity:ToastUtils:11.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.databinding:databinding-runtime:8.9.2")
    implementation("com.github.CarGuo.GSYVideoPlayer:gsyVideoPlayer-java:v8.6.0-release-jitpack")
    implementation("com.google.firebase:firebase-analytics:22.1.2")
}

androidComponents {
    beforeVariants { variant ->
        variant.androidTest?.enable = false
        variant.enableUnitTest = false
    }
}
