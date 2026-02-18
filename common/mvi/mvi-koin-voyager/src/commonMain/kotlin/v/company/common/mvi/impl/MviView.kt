import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinScreenModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.qualifier.named
import v.companu.common.utils.simpleNameOrThrow

interface MviView<Action : MviAction, Event : MviEvent, State : MviState> : Screen {

    @Composable
    override fun Content() {
        val model = getMviModel<MviModel<Action, *, Event, State>>()
        val state by model.stateFlow.collectAsState()
        Content(
            state = state,
            eventFlow = model.eventFlow,
            pushAction = model::push
        )
    }

    @Composable
    fun Content(
        state: State,
        eventFlow: Flow<Event>,
        pushAction: (Action) -> Unit,
    )
}

@Composable
private inline fun <reified T : MviModel<*, *, *, *>> MviView<*, *, *>.getMviModel(): T =
    koinScreenModel<T>(qualifier = named(this::class.simpleNameOrThrow))

@Composable
inline fun <reified Event : MviEvent> Flow<Event>.CollectEvent(
    crossinline onEvent: suspend (Event) -> Unit,
) = LaunchedEffect(Unit) { collect { onEvent(it) } }