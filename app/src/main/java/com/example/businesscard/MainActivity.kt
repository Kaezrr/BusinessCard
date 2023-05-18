package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard()
{
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround
    ){
        CardInfo(
            name = "John Doe",
            title = "Junior Android Developer"
        )
        ContactInfo(
            phone = "+11 (123) 456 789",
            social = "@JohnDoe",
            email = "johndoe27@gmail.com"
        )
    }
}
@Composable
fun CardInfo(name: String, title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .width(160.dp)
                .background(Color(0xFF073042))
        )
        Text(
            text = name,
            fontSize = 40.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = title,
            color = Color(0xFF1F7E4F)
        )
    }

}

@Composable
fun ContactInfo(phone: String, social: String, email: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        ContactLine(
            icon = Icons.Outlined.Phone,
            message = phone
        )
        ContactLine(
            icon = Icons.Outlined.Share,
            message = social,

        )
        ContactLine(
            icon = Icons.Outlined.Email,
            message = email,
        )
    }
}

@Composable
fun ContactLine(icon: ImageVector,message: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF1F7E4F),
            modifier = Modifier.padding(start = 100.dp, end = 8.dp)

        )
        Text(
            text = message,
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Preview(showBackground = true, backgroundColor = 0xD2E8D4)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}