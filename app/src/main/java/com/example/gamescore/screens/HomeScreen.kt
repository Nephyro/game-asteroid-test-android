package com.example.gamescore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamescore.R

@Composable
fun Home(navController: NavController, modifier: Modifier = Modifier) {

//    1. Variável de estado para guardar a posição horizontal (X) da nave
//    var offsetX by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(Color.Black)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Score: 0050",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = "Lives:",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                repeat(3) {
                    Image(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(
                            id = R.drawable.nav_removebg_preview
                        ),
                        colorFilter = ColorFilter.tint(Color.Green),
                        contentDescription = null
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(5) { index ->
                Image(
                    modifier = Modifier.size(70.dp),
                    painter = painterResource(
                        id = R.drawable.nav_removebg_preview
                    ),
                    contentDescription = null,
                    colorFilter = when (index) {
                        1 -> ColorFilter.tint(Color.Red)
                        2 -> ColorFilter.tint(Color.Blue)
                        3 -> ColorFilter.tint(Color.Yellow)
                        else -> ColorFilter.tint(Color.Green)
                    }
                )
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Image(
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
//                // Aplica o deslocamento baseado no gesto do dedo
//                .offset { IntOffset(offsetX.toInt(), 0) }
//                // Detecta o arrasto horizontal na tela
//                .pointerInput(Unit) {
//                    detectDragGestures { change, dragAmount ->
//                        // Atualiza a posição X somando o deslocamento do dedo
//                        change.consume()
//                        offsetX += dragAmount.x
//                    }
//                }
    ,
            painter = painterResource(
                id = R.drawable.nav_asteroid
            ),
            contentDescription = null
        )

        Button(
            onClick = { navController.navigate("game") },
            colors = ButtonDefaults.buttonColors(Color.Gray),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "START",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}