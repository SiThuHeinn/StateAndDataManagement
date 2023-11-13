package com.sithuheinn.mm.statedatamanagement.feature.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sithuheinn.mm.statedatamanagement.R

@Composable
fun GettingStartedScreen(
    onGetStarted: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(alpha = 0.1f))
    ) {
        Column {
            Text(
                modifier = Modifier.padding(20.dp),
                text = "Welcome to DailyVita",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "Hello, we are here to make your life healthier and happier.",
                style = MaterialTheme.typography.bodyLarge
            )


            Image(
                modifier = Modifier.padding(30.dp),
                painter = painterResource(id = R.drawable.img_health_care),
                contentDescription = "Health care"
            )

            Text(
                modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                text = "We will ask a couple of questions to better understand your vitamin need.",
                style = MaterialTheme.typography.bodyLarge
            )


        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(20.dp)
            ,
            onClick = onGetStarted
        ) {
            Text(text = "Get Started")
        }

    }
}