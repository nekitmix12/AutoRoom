package v.company

import org.koin.core.module.Module
import v.company.core.database.databaseModule
import v.company.core.network.networkModule

private val coreModules
    get() = listOf(
        networkModule,
        databaseModule,
    )

private val componentsModules
    get() = listOf<Module>(
    )

private val featureModules
    get() = listOf<Module>(
    )

val appModules
    get() = listOf(
        coreModules,
        componentsModules,
        featureModules,
    ).flatten()