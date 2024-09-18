import java.util.Properties

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
            val properties = Properties()
            properties.load(File(rootProject.projectDir, "local.properties").inputStream())
            credentials.username = "mapbox"
            credentials.password = properties.getProperty("mapbox.downloads.token", "")
            authentication.create<BasicAuthentication>("basic")
        }
    }
}

rootProject.name = "KotlinEnjoyersTemplate"
include(":app")
 