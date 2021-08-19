package com.wonjoong.android.contact.ui.person

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.wonjoong.android.contact.R
import com.wonjoong.android.contact.data.Person
import com.wonjoong.android.contact.data.PersonViewModel
import com.wonjoong.android.contact.data.PersonViewModelFactory

@Composable
fun AddPerson(navController: NavController) {
    val context = LocalContext.current
    val mPersonViewModel: PersonViewModel =
        viewModel(factory = PersonViewModelFactory(context.applicationContext as Application))
    mPersonViewModel.readAllData.observeAsState(listOf()).value.forEach {
        println(it)
    }
    val personInputList = getPersonInputList()
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        val eachInputText = remember {
            mutableStateListOf(
                "", // name
                "", // relationship
                "", // age
                "", // company
                "", // hobby
                "", // personality
                "", // marriage
                "", // children
                "", // like
                "", // dontlike
                "", // etc
            )
        }

        Image(
            painter = painterResource(id = R.drawable.blank_profile_pictrue),
            contentDescription = "Person Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(128.dp)
                .padding(16.dp)
                .clip(RoundedCornerShape(percent = 10))
        )

        personInputList.values.forEachIndexed { index, data ->
            InputItem(data, eachInputText, index)
        }

        // Button
        Button(
            onClick = {
                val newPerson = Person(
                    id = 0, // Will be auto generated, so it doesn't matter
                    name = eachInputText[PersonCategory.NAME.num],
                    relationship = eachInputText[PersonCategory.RELATIONSHIP.num],
                    age = eachInputText[PersonCategory.AGE.ordinal].toInt(),
                    company = eachInputText[PersonCategory.COMPANY.num],
                    hobby = eachInputText[PersonCategory.HOBBY.num],
                    personality = eachInputText[PersonCategory.PERSONALITY.num],
                    marriage = eachInputText[PersonCategory.MARRIAGE.num],
                    children = eachInputText[PersonCategory.CHILDREN.num],
                    like = eachInputText[PersonCategory.LIKE.num],
                    dont_like = eachInputText[PersonCategory.DONTLIKE.num],
                    etc = eachInputText[PersonCategory.ETC.num]
                )
                mPersonViewModel.addPerson(newPerson)
                navController.popBackStack()
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

@Composable
fun InputItem(
    content: InputPersonData,
    inputTextCategory: SnapshotStateList<String>,
    index: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp)
    ) {
        Text(
            text = stringResource(id = content.stringId),
            modifier = Modifier
                .width(104.dp)
                .padding(12.dp, 0.dp),
        )
        TextField(
            value = inputTextCategory[index],
            label = {
                Text(stringResource(id = content.stringId))
            },
            onValueChange = { inputTextCategory[index] = it },
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
}

private fun getPersonInputList(): LinkedHashMap<String, InputPersonData> {
    val personInputList = LinkedHashMap<String, InputPersonData>()
    personInputList["name"] = InputPersonData(R.string.name, "Enter his/her name")
    personInputList["relationship"] = InputPersonData(R.string.relationship, "Enter his/her age")
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

enum class PersonCategory(val num: Int) {
    NAME(0),
    RELATIONSHIP(1),
    AGE(2),
    COMPANY(3),
    HOBBY(4),
    PERSONALITY(5),
    MARRIAGE(6),
    CHILDREN(7),
    LIKE(8),
    DONTLIKE(9),
    ETC(10),
    ID(11);
}
