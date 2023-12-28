package com.example.myapplication

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue   //setvalue, getvalue 수동으로 import
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


class FifthActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isFavorite by rememberSaveable{ //boolean 값을 기억하라 -> state 변경되면 ui다시 그려지게, value 생략위에선(줄 80) by 써야함
                mutableStateOf(false)
            }
            ImageCard(    //imagecard 여러개 재사용 위해 밖으로 뺌
                modifier=Modifier
                    .fillMaxWidth(0.5f) // 가로값 지정
                    .padding(16.dp),
                isFavorite=isFavorite,
            ){
                    favorite->
                isFavorite=favorite
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier:Modifier=Modifier,    //외부에 modifier설정하는게 더 좋음
    isFavorite:Boolean,
    onTabFavorite:(Boolean)->Unit,    //callback으로 돌려줄 값 (boolean) 리턴은 없음 -> 클릭이 발생하면 현 favorite의반대값 돌려줌  
) {

    Card(
        modifier= modifier,
        shape= RoundedCornerShape(8.dp),

    ){
        Box(
            modifier=Modifier.height(200.dp),
        ){
            Image(
                painter = painterResource(id=R.drawable.dog), //img 가져옴
                contentDescription = "dog", //필수!! img파일에 지정 - 설명
                contentScale= ContentScale.Crop, //이미지 표시되는 영역의 크기-뒤에 깔림
            )
            Box(
                modifier=Modifier.fillMaxSize(),
                contentAlignment=Alignment.TopEnd
            ){
                IconButton(onClick={ //눌렀을 때
                    onTabFavorite(!isFavorite)
                }){
                    Icon(
                        imageVector=if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, //favoriteBorder 는 외곽선만
                        contentDescription="favorite",
                        tint=Color.Red //border 색지정
                    )
                }
            }
        }
    }
}