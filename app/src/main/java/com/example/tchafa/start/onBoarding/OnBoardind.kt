package com.example.tchafa.ui.theme.onBoarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tchafa.ui.theme.Background
import com.example.tchafa.ui.theme.TextBlue
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch


@ExperimentalPagerApi
@Composable
@Preview
fun OnBoarding(navController: NavController){

    val scope = rememberCoroutineScope()

    Column(Modifier.fillMaxSize()) {
        TopSection()

        val items = OnBoardingItem.get()

        val state = rememberPagerState(pageCount = items.size)

        HorizontalPager(
            state= state,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f)
        ) {page ->

            OnBoardingItem(items[page])

        }
        BottomSection(size = items.size, index = state.currentPage) {
            if (state.currentPage+1 <items.size)
                scope.launch(){
                    state.scrollToPage( page = state.currentPage +1)
                }
        }
    }


}




@Composable
@Preview
fun TopSection(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        //Back button
        IconButton(
            onClick = { },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon( Icons.Outlined.KeyboardArrowLeft,contentDescription = null,)
        }

        // skip button
        TextButton(
            onClick = { },
            modifier =  Modifier
                .align(Alignment.CenterEnd),

            ) {
            Text("Skip",
                color = MaterialTheme.colors.onBackground)
        }

    }
}



@Composable
fun BottomSection(size: Int, index: Int, onNextClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Indicators(size = size, index = index)

        FloatingActionButton(
            onClick = onNextClicked,
            modifier = Modifier.align(Alignment.CenterEnd),
            backgroundColor = Background,

            contentColor = MaterialTheme.colors.onPrimary
        ) {
            Icon(Icons.Outlined.KeyboardArrowRight, null)
        }
    }
}


@Composable
fun BoxScope.Indicators( size : Int , index : Int){

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement =  Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)

    ) {
        repeat(size){
            Indicator(isSelected = it == index)

        }
    }
}


@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)
    )
    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width = width.value)
            .clip(shape = CircleShape)
            .background(
                if (isSelected) Background
                else MaterialTheme.colors.onBackground.copy(
                    alpha = 0.5f
                )
            )
    ) {

    }

}

@Composable

fun OnBoardingItem(
    item: OnBoardingItem,
){
    Column(
        horizontalAlignment =Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp)
    ) {
        Image(painter = painterResource( id= item.image), contentDescription = null )
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource( id= item.title),
                fontSize = 24.sp,
                color = TextBlue,
                fontWeight = FontWeight.Bold,
            )
        }

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource( id=item.text),
                fontSize = 14.sp,
                color = MaterialTheme.colors.onBackground.copy(alpha = 0.8f),
            )
        }

    }
}
