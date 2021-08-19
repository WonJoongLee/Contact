package com.wonjoong.android.contact.ui.person

import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.wonjoong.android.contact.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.RelocationRequester
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddPerson() {
    val personInputList = getPersonInputList()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.blank_profile_pictrue),
            contentDescription = "Person Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(percent = 10))
        )

        //var inputName: String by remember { mutableStateOf("") }
        var inputName by remember { mutableStateOf("") }
        var relationship by remember { mutableStateOf("") }
        var inputAge by remember { mutableStateOf("") }
        var inputCompany by remember { mutableStateOf("") }
        var inputHobby by remember { mutableStateOf("") }
        var inputPersonality by remember { mutableStateOf("") }
        var inputMarriage by remember { mutableStateOf("") }
        var inputChildren by remember { mutableStateOf("") }
        var inputLike by remember { mutableStateOf("") }
        var inputDontLike by remember { mutableStateOf("") }
        var inputETC by remember { mutableStateOf("") }

        // name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.name),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputName,
                label = {
                    Text("Name")
                },
                onValueChange = { inputName = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // relationship
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.relationship),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = relationship,
                label = {
                    Text("Relationship")
                },
                onValueChange = { relationship = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // age
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.age),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputAge,
                label = {
                    Text("Age")
                },
                onValueChange = { inputAge = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // company
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.company),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputCompany,
                label = {
                    Text("Company")
                },
                onValueChange = { inputCompany = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // hobby
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.hobby),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputHobby,
                label = {
                    Text("Hobby")
                },
                onValueChange = { inputHobby = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // personality
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.personality),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputPersonality,
                label = {
                    Text("Personality")
                },
                onValueChange = { inputPersonality = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // marriage
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.marriage),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputMarriage,
                label = {
                    Text("Marriage")
                },
                onValueChange = { inputMarriage = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // children
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.children),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputChildren,
                label = {
                    Text("Children")
                },
                onValueChange = { inputChildren = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // like
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.like),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputLike,
                label = {
                    Text("likes")
                },
                onValueChange = { inputLike = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // dontlike
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.dont_like),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputDontLike,
                label = {
                    Text("Doesn't like")
                },
                onValueChange = { inputDontLike = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

        // etc
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(0.dp, 8.dp)
        ) {
            //var inputName by remember { mutableStateOf("") }
            Text(
                text = stringResource(id = R.string.etc),
                modifier = Modifier
                    .width(104.dp)
                    .padding(12.dp, 0.dp),
            )
            TextField(
                value = inputETC,
                label = {
                    Text("ETC")
                },
                onValueChange = { inputETC = it },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp, 0.dp),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Gray,
                    focusedLabelColor = Color.Black,
                    cursorColor = Color.Black
                )
            )
        }

//        personInputList.values.forEachIndexed { index, inputPersonData ->
//            InputItem(content = inputPersonData)
//        }

        // Button
        Button(
            onClick = {
                Log.e("name", "$inputName, $inputAge")
            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.LightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 6.dp,
                pressedElevation = 8.dp,
                disabledElevation = 0.dp
            )
        ) {
            Text(
                "Complete",
                color = Color.Black,
            )
        }
    }
}

private fun getPersonInputList(): LinkedHashMap<String, InputPersonData> {
    val personInputList = LinkedHashMap<String, InputPersonData>()
    personInputList["name"] = InputPersonData(R.string.name, "Enter his/her name")
    personInputList["age"] = InputPersonData(R.string.age, "Enter his/her age")
    personInputList["company"] = InputPersonData(R.string.company, "Enter his/her name")
    personInputList["hobby"] = InputPersonData(R.string.hobby, "Enter his/her name")
    personInputList["personality"] = InputPersonData(R.string.personality, "Enter his/her name")
    personInputList["marriage"] = InputPersonData(R.string.marriage, "Enter his/her name")
    personInputList["children"] = InputPersonData(R.string.children, "Enter the name")
    personInputList["like"] = InputPersonData(R.string.like, "Enter the name")
    personInputList["dont_like"] = InputPersonData(R.string.dont_like, "Enter the name")
    personInputList["etc"] = InputPersonData(R.string.etc, "Enter the name")
    return personInputList
}

@Composable
fun InputItem(
    content: InputPersonData,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
    ) {
        var inputName by remember { mutableStateOf("") }
        Text(
            text = stringResource(id = content.stringId),
            modifier = Modifier
                .width(96.dp)
                .padding(12.dp, 0.dp),
        )
        TextField(
            value = inputName,
            label = {
                Text(content.label)
            },
            onValueChange = { inputName = it },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
        )
    }
}

//@Preview
//@Composable
//private fun AddPersonPreview() {
//    AddPerson()
//}