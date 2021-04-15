plugins {
    id("com.android.application")
    id("kotlin-android")
}

val faucetUrl: String by project
val faucetUsername: String by project
val faucetPassword: String by project

android {
    compileSdkVersion(30)
    buildToolsVersion = "30.0.2"

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.goldenraven.padawanwallet"
        minSdkVersion(26)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "0.1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "FAUCET_URL", faucetUrl)
        buildConfigField("String", "FAUCET_USERNAME", faucetUsername)
        buildConfigField("String", "FAUCET_PASSWORD", faucetPassword)
    }

    sourceSets {
        getByName("main").res.setSrcDirs(setOf(
            file("src/main/res/layouts/intro"),
            file("src/main/res/layouts/home"),
            file("src/main/res/layouts/wallet"),
            file("src/main/res/layouts/tutorials"),
            file("src/main/res/layouts/drawer"),
            file("src/main/res")
        ))
    }

    buildTypes {
        getByName("debug") {
            // applicationIdSuffix ".debug"
            debuggable(true)
        }
        getByName("release") {
            // isMinifyEnabled = true
            minifyEnabled(true)
            // shrinkResources(true)
            debuggable(true)
            proguardFiles = mutableListOf(getDefaultProguardFile("proguard-android-optimize.txt"), file("proguard-rules.pro"))
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    ndkVersion = "21.3.6528147"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.2.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.2.2")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.viewpager:viewpager:1.0.0")

    // bitcoin
    implementation("org.bitcoindevkit.bdkjni:bdk-jni:0.1.0-beta.1")

    // Ktor
    implementation("io.ktor:ktor-client-cio:${Versions.ktor}")
    implementation("io.ktor:ktor-client-auth:${Versions.ktor}")

    // logging
    implementation("com.jakewharton.timber:timber:4.7.1")

    // QR codes
    implementation("androidmads.library.qrgenearator:QRGenearator:1.0.4")
    implementation("com.google.zxing:core:3.4.1")

    // testing
    testImplementation("junit:junit:4.+")
}