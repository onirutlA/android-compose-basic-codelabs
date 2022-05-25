package com.onirutla.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.onirutla.compose_article.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen(
                        header = stringResource(id = R.string.header),
                        paragraph1 = stringResource(id = R.string.paragraph1),
                        paragraph2 = stringResource(id = R.string.paragraph2)
                    )
                }
            }
        }
    }
}


@Composable
fun MainScreen(header: String, paragraph1: String, paragraph2: String) {
    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = null,
        )
        Text(
            text = header,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = paragraph1,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = paragraph2,
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        MainScreen(
            header = stringResource(id = R.string.header),
            paragraph1 = stringResource(id = R.string.paragraph1),
            paragraph2 = stringResource(id = R.string.paragraph2)
        )
    }
}