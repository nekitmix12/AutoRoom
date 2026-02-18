package v.company.core.database

val databaseModule
    get() = platformDatabaseModule(fileName = "database.db")
        .apply {
        }