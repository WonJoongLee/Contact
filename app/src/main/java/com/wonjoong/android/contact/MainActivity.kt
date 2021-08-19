package com.wonjoong.android.contact

import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.wonjoong.android.contact.ui.DetailsScreen
import com.wonjoong.android.contact.ui.person.AddPerson
import com.wonjoong.android.contact.ui.theme.ContactTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            Scaffold(
                backgroundColor = colorResource(id = R.color.white)
            ) {
                Navigation()
            }
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        // Main Screen
        composable("main") {
            MainScreen(navController = navController)
        }
        // User detail view
        composable(
            "details/{name}",
            arguments = listOf(navArgument("name") { type = NavType.StringType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("name")?.let { name ->
                DetailsScreen(name = name)
            }
        }
        composable(
            "addperson"
        ){
            AddPerson()
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    Column {
        SearchView(navController, textState)
        PersonList(navController = navController, state = textState)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val navController = rememberNavController()
    MainScreen(navController = navController)
}

@Composable
fun SearchView(navController: NavController, state: MutableState<TextFieldValue>) {
    TextField(
        value = state.value, onValueChange = { value ->
            state.value = value
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
            )
        },
        trailingIcon = {
            IconButton(onClick = {
                navController.navigate("addperson") {
                    Log.e("moveTo", "Add Person View")
                    popUpTo("main"){
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
//        trailingIcon = {
//            if (state.value != TextFieldValue("")) {
//                IconButton(onClick = { state.value = TextFieldValue("") }) {
//                    Icon(
//                        Icons.Default.Close,
//                        contentDescription = "",
//                        modifier = Modifier
//                            .padding(15.dp)
//                            .size(24.dp)
//                    )
//                }
//            }
//        },
        singleLine = true,
        shape = RectangleShape,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            leadingIconColor = Color.White,
            trailingIconColor = Color.White,
            backgroundColor = Color.Gray,
            //backgroundColor = colorResource(id = R.color.design_default_color_primary),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )

    )
}

@Composable
fun PersonListItem(name: String, onItemClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = { onItemClick(name) })
            .background(colorResource(id = R.color.white))
            .height(64.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(8.dp, 4.dp, 8.dp, 4.dp)
        )
        Text(
            text = "25/Friend/Facebook/Single",
            modifier = Modifier.padding(8.dp, 4.dp, 4.dp, 8.dp),
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
    Divider(color = Color.DarkGray)
}

@Composable
fun PersonList(
    navController: NavController,
    state: MutableState<TextFieldValue>
) {
    val people = getListOfPerson()
    var filteredPeople: ArrayList<String>
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        val searchedText = state.value.text
        filteredPeople = if (searchedText.isEmpty()) {
            people
        } else {
            val resultList = ArrayList<String>()
            for (person in people) {
                if (person.contains(searchedText)) {
                    resultList.add(person)
                }
            }
            resultList
        }
        items(filteredPeople) { filteredPerson ->
            PersonListItem(
                name = filteredPerson,
                onItemClick = { selectedPerson ->
                    navController.navigate("details/$selectedPerson") {
                        Log.e("selectedPerson", selectedPerson)
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo("main") {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                })
        }
    }
}

fun getListOfPerson(): ArrayList<String> {
    return arrayListOf(
        "홍길동",
        "손흥민",
        "차범근",
        "박지성",
        "이원중",
        "김태희",
        "정지훈",
        "하정우",
        "김기범",
        "김민재",
        "이길동",
        "김길동",
        "이나영",
        "허훈",
        "백차장",
        "이재용",
        "김범수",
        "마동석",
        "김진희",
        "박수영",
        "박수민",
        "박상진",
        "이민영"
    )
}

@Preview
@Composable
fun PersonListPreview() {
    val navController = rememberNavController()
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    PersonList(navController = navController, state = textState)
}

@Preview(showBackground = true)
@Composable
fun PersonListItemPreview() {
    PersonListItem(name = "홍길동", onItemClick = { })
}

@Preview(showBackground = true)
@Composable
fun SearchViewPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    //SearchView(textState)
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ContactTheme {
        Greeting("Android")
    }
}

@Composable
fun SystemUi(windows: Window) =
    MaterialTheme {
        windows.statusBarColor = MaterialTheme.colors.surface.toArgb()
        windows.navigationBarColor = MaterialTheme.colors.surface.toArgb()
    }