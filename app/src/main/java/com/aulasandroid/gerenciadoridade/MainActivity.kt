package com.aulasandroid.gerenciadoridade

import android.R
import android.R.attr.contentDescription
import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aulasandroid.gerenciadoridade.ui.theme.GerenciadorIdadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GerenciadorIdadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GerenciadorIdadesMainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GerenciadorIdadesMainScreen(modifier: Modifier = Modifier) {
    var espacamentoPadrao = 16.dp
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        var idade by remember {
            mutableStateOf(17)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement =Arrangement.Center
        ) {
            Text(
                text = "Qual é a sua idade ?",
                color = Color.Blue,
                fontSize = 24.sp
            )
            Text(
                text = "Aperte os botões para informar a sua idade",
                color = Color.Black,
                fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(espacamentoPadrao))
        Text(
            text = "${idade}",
            color = Color.Black,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(espacamentoPadrao))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                modifier = Modifier.size(50.dp),
                onClick = {
                    idade++
                },
                shape = RoundedCornerShape(10.dp)
            ) {
              Text(
                  text = "+",
                  fontSize = 24.sp,
                  textAlign = TextAlign.Center
              )
            }
            Button(
                modifier = Modifier.size(50.dp),
                onClick = {
                    idade--
                },
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(
                    text = "-",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(espacamentoPadrao))
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when {
                idade > 180 -> {
                    idade--
                    Text(
                        text = "IDADE INVÁLIDA",
                        color = Color.Blue,
                        fontSize = 24.sp
                    )
                }
                idade in 18 .. 180 -> {
                    Text(
                        text = "Você é MAIOR de idade",
                        color = Color.Blue,
                        fontSize = 24.sp
                    )
                }
                idade in 1..18 -> {
                    Text(
                        text = "Você é MENOR de idade",
                        color = Color.Blue,
                        fontSize = 24.sp
                    )
                }
                idade <= 0-> {
                    idade++
                    Text(
                        text = "IDADE INVÁLIDA",
                        color = Color.Blue,
                        fontSize = 24.sp
                    )
                }
            }
        }

    }
    
}