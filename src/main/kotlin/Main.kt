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
        drawWeekSquares(55f, 10f)
    }
}


/** Рисует вертикальный ряд из 7 квадратов, представляющих неделю.
 *
 *  Квадраты рисуются сверху вниз, начиная с заданной стартовой позиции.
 *  Каждый последующий квадрат смещается на сумму его высоты [sizeRect] и расстояния [space].
 *
 *  @param sizeRect Размер стороны одного квадрата в пикселях.
 *  @param space Расстояние по вертикали между квадратами в пикселях.
 *  @param startX Координата начальной точки по оси x
 *  @param startY Координата начальной точки по оси y
 */
@Composable
fun drawWeekSquares(
    sizeRect: Float,
    space: Float,
    startX : Float = 5f,
    startY : Float = 5f
){
    Canvas(modifier = Modifier.fillMaxSize()) {

        var posX = startX
        var posY = startY


        for (i in 1..7){
            drawRect(
                color = Color.Gray,
                topLeft = Offset(posX, posY),
                size = Size(sizeRect, sizeRect)
            )

            posY += space + sizeRect
        }

    }
}