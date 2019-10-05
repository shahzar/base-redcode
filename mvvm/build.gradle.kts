plugins {
    id(Plugins.androidLib)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinAndroidExtensions)
    kotlin(Plugins.kapt)
    id(Plugins.sonarqube)
    id(Plugins.androidMaven)
}

group = "com.github.pedrofsn"

androidExtensions {
    isExperimental = true
}

android {
    compileSdkVersion(Config.androidCompileSdk)

    defaultConfig {
        minSdkVersion(Config.androidMinSdk)
        targetSdkVersion(Config.androidTargetSdk)
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {
    implementation(Libs.kotlinStdLib)

    implementation(Libs.lifecycleRuntime)
    kapt(Libs.lifecycleCompiler)
    api(Libs.lifecycleExtensions)

    api(Libs.easyRecyclerview)

    api(project(":base"))
}

sonarqube {
    properties {
        property("sonar.projectName", "base-code-mvvm")
        property("sonar.projectKey", "aaa")
        property("sonar.host.url", "aaa")
        property("sonar.language", "kotlin")
        property("sonar.sources", "src/main/")
        property("sonar.login", "aaa")
        property("sonar.password", "aaa")
    }
}
