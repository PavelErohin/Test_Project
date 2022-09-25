package com.example.test_project.screens.main.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.W400
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.test_project.screens.main.models.MainViewState
import com.example.test_project.util.ImageView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainViewDisplay(
  viewState: MainViewState.Display, navController: NavController
) {
  Toolbar()
  Box {
    MainLazyVerticalGrid(viewState, navController)
  }
}

@Composable
fun Toolbar() {
  Row(Modifier.padding(16.dp)) {
    Text(
      text = "Главная", style = TextStyle(
        fontWeight = FontWeight.W500, fontSize = 20.sp
      )
    )
  }
}

@Composable
fun NavButtons() {
  LazyRow(modifier = Modifier.padding(end = 16.dp)) {
    for (i in 1..10) item {
      Button(
        onClick = { /*TODO*/ },
        Modifier
          .padding(end = 8.dp)
          .background(
            color = (Color.Blue), shape = RoundedCornerShape(8.dp)//todo remove blue
          )
          .height(40.dp)
      ) {
        Text(
          "$i  +29", style = TextStyle(
            color = Color.White, fontWeight = FontWeight.W400, fontSize = 14.sp
          )
        )
        Text(
          "°C", style = TextStyle(
            color = Color.White, fontWeight = FontWeight.W400, fontSize = 12.sp
          )
        )
      }
    }
  }
}

@ExperimentalFoundationApi
@Composable
fun MainLazyVerticalGrid(blogsContent: MainViewState.Display, navController:NavController) {
  Column(modifier = Modifier.padding(top = 60.dp, bottom = 60.dp)) {
    LazyVerticalGrid(
      cells = GridCells.Adaptive(minSize = 160.dp),
      contentPadding = PaddingValues(start = 12.dp, end = 12.dp, top = 16.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
      item(span = { GridItemSpan(2) }) { NavButtons() }
      item(span = { GridItemSpan(2) }) {
        Box() {
          Text(
            text = blogsContent.title,
            fontSize = 24.sp,
            fontWeight = W400,
            modifier = Modifier.padding(top = 24.dp)
          )
        }
      }
      for (blog in blogsContent.items) item {
        Box(
          modifier = Modifier
            .padding(4.dp)
            .defaultMinSize(minHeight = 160.dp, minWidth = 160.dp)
            .clickable {
                       navController.navigate("details")
            },
        ) {
          Column {
            ImageView(
              imageUri = blog.image,
              modifier = Modifier
                .height(104.dp)
                .defaultMinSize(160.dp, 104.dp)
                .clip(RoundedCornerShape(8.dp))

            )
            Text(
              text = blog.title,
              fontSize = 12.sp,
              fontWeight = W500,
              maxLines = 1,
              overflow = TextOverflow.Ellipsis
            )
            Text(
              text = blog.subtitle,
              fontSize = 12.sp,
              fontWeight = W400,
              maxLines = 2,
              overflow = TextOverflow.Ellipsis
            )
          }
        }
      }
    }
  }
}
