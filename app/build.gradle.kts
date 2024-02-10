plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.eshopsample"
    compileSdk = 34



    defaultConfig {
        applicationId = "com.example.eshopsample"
        minSdk = 28

        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8


    }
    buildFeatures {
        viewBinding = true

    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.android.volley:volley:1.2.1")
    implementation("androidx.navigation:navigation-fragment:2.5.3")
    implementation("androidx.navigation:navigation-ui:2.5.3")
    implementation("cn.cocook:httpclient:0.0.5")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("com.google.android.gms:play-services-measurement-api:21.5.0")
    implementation("junit:junit:4.12")
    implementation("com.google.firebase:firebase-analytics:21.5.0")
    implementation("androidx.test:runner:1.5.2")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation("com.squareup.picasso:picasso:2.5.2")
    implementation("com.github.bumptech.glide:glide:3.7.0")


    implementation("junit:junit:4.13.2")
    implementation("org.mockito:mockito-core:3.11.2")
    implementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("androidx.test.ext:junit-ktx:1.1.0")



    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-intents:3.4.0")
    androidTestImplementation("androidx.test.espresso:espresso-accessibility:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-web:3.4.0")
    androidTestImplementation ("androidx.test.espresso.idling:idling-concurrent:3.4.0")
    androidTestImplementation ("androidx.test.espresso:espresso-idling-resource:3.4.0")
    androidTestImplementation ("androidx.test:core-ktx:1.1.0")
    androidTestImplementation ("org.mockito:mockito-core:3.11.2")





    /* For Slider - Start */
    // Material Components for Android. Replace the version with the latest version of Material Components library.
    implementation ("com.google.android.material:material:1.5.0")
    // Circle Indicator (To fix the xml preview "Missing classes" error)
    implementation ("me.relex:circleindicator:2.1.6")
    implementation ("org.imaginativeworld.whynotimagecarousel:whynotimagecarousel:2.1.0")
    /* For Slider - End */


}