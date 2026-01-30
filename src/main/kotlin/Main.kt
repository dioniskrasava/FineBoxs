import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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



/** Д Л Я    Т Е С Т И Р О В А Н И Я     П О З И Ц И О Н И Р О В А Н И Я*/
@Composable
fun AppContent() {
    Row(Modifier.fillMaxWidth().background(color = Color(0f,0f,0f, 0.75f))) {

        Column(Modifier.weight(5f)){
            drawWeekSquares(35f, 10f, 10f, 20f)
        }

        Divider(Modifier.width(10.dp).fillMaxHeight())

        Column(Modifier.weight(2f)){
            // Кнопка в правом верхнем углу
            Button(
                onClick = { /* обработка клика */ },
                modifier = Modifier
                    .padding(16.dp) // отступ от краев
            ) {
                Text("Кнопка")
            }
        }


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


        val week = makeDaysObjects() // создаем объект недели

        // пробегаемся по массиву дней и рисуем квадратики
        for (i in week){
            drawRect(
                color = i.color,
                topLeft = Offset(posX, posY),
                size = Size(sizeRect, sizeRect)
            )

            posY += space + sizeRect
        }

    }
}


// создаем объект недели для тестирования
fun makeDaysObjects() : Array<Day>{

    // ПЕРЕПИШИ ОБЪЕКТЫ В ТАКОМ ФОРМАТЕ. ЦВЕТ БУДЕТ СЧИТАТЬСЯ АВТОМАТИЧЕСКИ
    val day1 = createDay(1,  DateValue(2026,1, 29), -1)
    val day2 = createDay(1,  DateValue(2026,1, 29), 0)
    val day3 = createDay(1,  DateValue(2026,1, 29), 10)
    val day4 = createDay(1,  DateValue(2026,1, 29), 20)
    val day5 = createDay(1,  DateValue(2026,1, 29), 30)
    val day6 = createDay(1,  DateValue(2026,1, 29), 40)
    val day7 = createDay(1,  DateValue(2026,1, 29), 50)

    return arrayOf(day1, day2, day3, day4, day5, day6, day7)
}