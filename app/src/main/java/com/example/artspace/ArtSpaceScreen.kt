import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R


val imageResources = listOf(
    R.drawable.willem_koning,
    R.drawable.francisco_goya,
    R.drawable.gustav_klimt
)

val titles = listOf(
    "Interchange",
    "El aquelarre",
    "Klimt"
)

val authors = listOf(
    "Willem de Kooning(1955)",
    "Francisco de Goya(1797-1798)",
    "Gustav Klimt Austria(1862-1918)"
)

@Composable
fun ArtSpaceContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        ArtSpace()
    }
}

@Composable
fun ArtSpace() {
    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .width(300.dp)
                    .padding(top = 50.dp)
                    .shadow(10.dp)
                    .background(Color(0xFF8B4513))
                    .border(2.dp, Color(0xFF8B4513), shape = RoundedCornerShape(8.dp))
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = imageResources[currentIndex]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(350.dp)
                        .align(Alignment.Center)
                )
            }
        }
        Box(
            modifier = Modifier
                .width(400.dp)
                .padding(16.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFFFFD700), Color(0xFFFFD700), Color(0xFFDAA520)),
                        start = Offset(0f, 0f),
                        end = Offset(100f, 100f)
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = titles[currentIndex],
                    fontSize = 20.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = authors[currentIndex],
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                currentIndex = (currentIndex - 1 + imageResources.size) % imageResources.size
            }) {
                Text(text = "Previous")
            }
            Button(onClick = {
                currentIndex = (currentIndex + 1) % imageResources.size
            }) {
                Text(text = "Next")
            }
        }
    }
}
