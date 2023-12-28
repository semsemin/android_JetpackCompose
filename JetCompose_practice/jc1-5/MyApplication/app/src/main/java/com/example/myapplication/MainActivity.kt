package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            MyApplicationTheme {

                //3. BOX

                Box(modifier = Modifier
                    .background(color = Color.Green)
                    .fillMaxSize()
                    .height(200.dp),
                ){
                    Text("안녕")

                    Box( //텍스트 하나당 박스 적용
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp), //패딩으로 띄움 ',' 주의

                        contentAlignment = Alignment.BottomEnd, //오른쪽 아래 위치
                    ){
                        Text("12345645")
                    }

                }

                //1. column, row, text

                Surface( color = MaterialTheme.colorScheme.background)
                 {
                    Column ( //column 은 세로 row는 가로로 배치
                        modifier = Modifier //modifier로 속성 배치
                            .fillMaxSize()
                            .background(color = Color.Blue) //전체 배경 색
                            .padding(16.dp), //패딩 16dp
                        horizontalAlignment = Alignment.CenterHorizontally, //가운데 정렬
                        verticalArrangement = Arrangement.SpaceBetween, //수직 정렬
                    ){
                        Text("hello")
                        Text("World")
                    }
                }

                //4. List, LazyColumn

               /* val scrollState = rememberScrollState() //jc는 setcontent 안에서만 가능, scroll상태를 기억해줌*/
                LazyColumn( //LazyColumn이 더 자주쓰임
                    modifier = Modifier
                        .background(color = Color.Green)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(16.dp),
                        /*.verticalScroll(scrollState)*/ //scroll 작성 scrollview와 비슷 linearlayout으로 데이터 넣은것 -> 성능 안좋을 수도 -> Lazycolumn
                    verticalArrangement = Arrangement.spacedBy(8.dp) //행간 간격 (아이템 간 간격)
                ){
                    item{
                        Text("Header")
                    }
                    items(50){ index ->
                        Text("글시 $index")
                    }
                    item{
                        Text("footer")
                    }
                    /*for(i in 1..50){ -> 그냥 column일 경우
                        Text("글씨 $i")
                    }*/
                }
            }
        }
    }
}


//2.composable, preview


@Composable
fun Greeting(name: String){
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable //임의로 미리보기 생성 - 여러개 만들 수 있음
fun DefaultPreview(){
    MyApplicationTheme {
        Greeting("홍세민")
    }
}

