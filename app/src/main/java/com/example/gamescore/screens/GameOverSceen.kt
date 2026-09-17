package com.example.gamescore.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamescore.R

@Composable
fun GameOver(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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

        Button(
            onClick = { navController.navigate("home") },
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Game Over",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red
            )
        }

        Image(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            painter = painterResource(
                id = R.drawable.nav_explosion
            ),
            contentDescription = null
        )
    }
}