package com.goldenraven.padawanwallet.ui.tutorials

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goldenraven.padawanwallet.theme.PadawanTypography
import com.goldenraven.padawanwallet.theme.md_theme_dark_background

@Composable
fun TutorialsScreen(tutorial: Tutorial) {
    TutorialPage(tutorial.data)
}

@Composable
internal fun TutorialPage(tutorialData: List<TutorialElement>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_dark_background)
            .padding(all = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        tutorialData.forEach {
            when (it.elementType) {
                ElementType.TITLE -> {
                    Text(
                        text = stringResource(it.resourceId),
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp,
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(bottom = 16.dp)
                    )
                }
                ElementType.SUBTITLE -> {
                    Text(
                        text = stringResource(it.resourceId),
                        style = PadawanTypography.headlineMedium,
                        modifier = Modifier
                            .align(alignment = Alignment.Start)
                            .padding(bottom = 16.dp, top = 16.dp)
                    )
                }
                ElementType.BODY -> {
                    Text(
                        text = stringResource(it.resourceId),
                        style = PadawanTypography.bodyMedium,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
                ElementType.RESOURCE -> {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Image(
                            painter = painterResource(it.resourceId),
                            contentDescription = "Tutorial image",
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

enum class Tutorial(val id: Int, val data: List<TutorialElement>) {
    T1(1, tutorial1),
    T2(2, tutorial2),
    T3(3, tutorial3),
    T4(4, tutorial4),
    T5(5, tutorial5),
    T6(6, tutorial6),
    T7(7, tutorial7),
    T8(8, tutorial8);

    // we can use this to reverse-lookup the tutorial based on an Int
    companion object {
        private val map: Map<Int, Tutorial> = values().associateBy(Tutorial::id)
        fun fromId(id: Int): Tutorial? = map[id]
    }
}