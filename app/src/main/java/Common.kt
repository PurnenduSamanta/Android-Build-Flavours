import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.purnendu.flavour.BuildConfig


@Composable
fun Common() {

    var text by remember {
        mutableStateOf("")
    }
    if ((BuildConfig.FLAVOR == "free")) {
        text = "This is a Nth even no Calculation"
    } else if ((BuildConfig.FLAVOR == "paid")) {
        text = "This is a Nth odd no Calculation"
    }
    Text(text = text)
}