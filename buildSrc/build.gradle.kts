plugins{
    `kotlin-dsl`
}

repositories{
    mavenCentral()
    mavenLocal()
    google()
}

dependencies{

}

kotlin{
    sourceSets.getByName("main").kotlin.srcDir("buildSrc/src/main/kotlin")
}