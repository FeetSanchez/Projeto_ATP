plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.projetoatp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.projetoatp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    packaging {
        resources {
            excludes.add("META-INF/DEPENDENCIES")
            excludes.add("META-INF/DEPENDENCIES.md")
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    dependencies {
        implementation(libs.appcompat)
        implementation(libs.material)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
        implementation(libs.recyclerview)
        implementation(libs.recyclerview)
        implementation(libs.retrofit)
        implementation(libs.converter.gson)
        implementation(libs.google.api.services.youtube)
        implementation(libs.glide)
        annotationProcessor(libs.glide.compiler)
        implementation(libs.google.api.client.android)
        implementation(libs.google.api.client.gson)
        implementation(libs.core.ktx)
        implementation(libs.constraintlayout)
    }
    dependencies {
        implementation(libs.recyclerview)
        implementation("androidx.recyclerview:recyclerview:1.2.1")
        implementation(libs.lifecycle.runtime.ktx)
        implementation(libs.activity.compose)
        implementation(platform(libs.compose.bom))
        implementation(libs.ui)
        implementation(libs.ui.graphics)
        implementation(libs.ui.tooling.preview)
        implementation(libs.material3)
        androidTestImplementation(platform(libs.compose.bom))
        androidTestImplementation(libs.ui.test.junit4)
        debugImplementation(libs.ui.tooling)
        debugImplementation(libs.ui.test.manifest)
        implementation(libs.core.ktx)
        implementation(libs.constraintlayout)
        implementation(libs.gson)
    }

}

