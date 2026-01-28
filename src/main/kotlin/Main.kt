import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState



fun main() = application {
    val windowState = rememberWindowState(width = 800.dp, height = 600.dp)

    Window(
        onCloseRequest = ::exitApplication,
        title = "Три квадрата",
        state = windowState
    ) {
        MaterialTheme {
            AppContent()
        }
    }


}

@Composable
fun AppContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        draw7rect(55f, 10f)
    }
}


/** Функция которая рисует 7 квадратов, отображающих неделю */
@Composable
fun draw7rect(sizeRect: Float, space: Float){
    Canvas(modifier = Modifier.fillMaxSize()) {

        var posX = 5f
        var posY = 5f


        for (i in 1..7){
            drawRect(
                color = Color.Red,
                topLeft = Offset(posX, posY),
                size = Size(sizeRect, sizeRect)
            )

            posY = posY + space + sizeRect
        }

    }
}