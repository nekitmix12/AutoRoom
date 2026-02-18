package v.company

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.window.ComposeUIViewController
import cafe.adriel.voyager.navigator.Navigator
import org.koin.compose.koinInject
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController { App() }

@Suppress("unused")
fun initApp(
    iosUtils: IosUtils
) {
    initKoin()
    Logger.init()
    ThreadUtils.init(iosUtils::getThreadName)
}

private fun initKoin() {
    startKoin {
        modules(
            appModules
        )
    }
}