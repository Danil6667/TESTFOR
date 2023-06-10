import Plugins.kapt

plugins {
    Plugins.apply {
        id(androidLibrary)
        id(kotlinJetbrains)
        id(hilt)
        kotlin(kapt)
        id(safeArgs)
    }
}

android {
    namespace = "com.example.presentation"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    // View Binding Property Delegate
    Dependencies.ViewBinding.apply {
        // ViewBindingPropertyDelegate
        implementation(viewBinding)
    }

    // Navigation
    Dependencies.Navigation.apply {
        // Navigation
        implementation(navigationFragment)
        implementation(navigation)
    }

    //Lifecycle
    Dependencies.Lifecycles.apply {
        implementation(legasySupport)
        implementation(lifecycles)
        implementation(lifecycleViewModel)
    }

    // RecyclerView
    Dependencies.RecyclerView.apply {
        implementation(recyclerView)
    }

    // Ui Components
    Dependencies.UiComponents.apply {
        implementation(core)
        // AppCompat
        implementation(appCompat)
        // Material Design
        implementation(material)
        // UI Components
        implementation(constraint)
    }

    Dependencies.Hilt.apply {
        //Hilt
        implementation(hilt)
        Plugins.kapt(hiltCompiler)
    }

    //Glide
    Dependencies.Glide.apply {
        implementation(glide)
        annotationProcessor(glideCompiler)
    }

    implementation(project(":domain"))
}
