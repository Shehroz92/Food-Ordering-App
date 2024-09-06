plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "eu.practice.foodorderingapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "eu.practice.foodorderingapp"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation ("androidx.viewpager2:viewpager2:1.0.0")

    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.0")
    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.8.0")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:2.8.0")

}