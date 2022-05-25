package com.onirutla.business_card_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.onirutla.business_card_app.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard("Full Name", "Title")
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {

        IdentityCard(name = name, title = title)
        ContactColumn()
    }
}

@Composable
fun ContactColumn() {
    Column {
        ContactRow(text = "+00 (00) 000 000", icon = R.drawable.ic_person_24)
        ContactRow(text = "@socialmediahandle", icon = R.drawable.ic_person_24)
        ContactRow(text = "email@domain.com", icon = R.drawable.ic_person_24)
    }
}

@Composable
fun IdentityCard(name: String, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_person_24),
            contentDescription = null
        )
        Text(
            text = name,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
        )
        Text(
            text = title,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun ContactRow(modifier: Modifier = Modifier, text: String, icon: Int) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        Icon(
            modifier = Modifier
                .weight(0.25f)
                .padding(horizontal = 16.dp),
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp),
            text = text,
            textAlign = TextAlign.Left
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        BusinessCard("Full Name", "Title")
    }
}