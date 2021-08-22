package com.wonjoong.android.contact.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wonjoong.android.contact.R
import com.wonjoong.android.contact.data.Person
import com.wonjoong.android.contact.data.PersonViewModel

@Composable
fun DetailsScreen(person: Person, mPersonViewModel: PersonViewModel) {
    // val getPerson = mPersonViewModel.getUserById(personId).observeAsState().value // Select Person with ID
    var thisPerson = person
    var isEditing by remember { mutableStateOf(false) }
    val inputTextList = remember {
        mutableStateListOf(
            thisPerson.name, // name
            thisPerson.relationship, // relationship
            thisPerson.age.toString(), // age
            thisPerson.company, // company
            thisPerson.hobby, // hobby
            thisPerson.personality, // personality
            thisPerson.marriage, // marriage
            thisPerson.children, // children
            thisPerson.like, // like
            thisPerson.dont_like, // dontlike
            thisPerson.etc, // etc
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = thisPerson.name,
                color = Color.Black,
                fontSize = 28.sp,
                modifier = Modifier
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)
            )
            if (isEditing) {
                IconButton(
                    onClick = {
                        isEditing = !isEditing
                        mPersonViewModel.updateUserById(
                            person.id, // maintain the origin id
                            inputTextList[0], // update to changed value
                            inputTextList[1],
                            inputTextList[2].toInt(),
                            inputTextList[3],
                            inputTextList[4],
                            inputTextList[5],
                            inputTextList[6],
                            inputTextList[7],
                            inputTextList[8],
                            inputTextList[9],
                            inputTextList[10]
                        )
                        thisPerson.apply {
                            name = inputTextList[0]
                            relationship = inputTextList[1]
                            age = inputTextList[2].toInt()
                            company = inputTextList[3]
                            hobby = inputTextList[4]
                            personality = inputTextList[5]
                            marriage = inputTextList[6]
                            children = inputTextList[7]
                            like = inputTextList[8]
                            dont_like = inputTextList[9]
                            etc = inputTextList[10]
                        }
                    },
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 8.dp, 8.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Check, contentDescription = "check",
                    )
                }
            } else {
                IconButton(
                    onClick = { isEditing = !isEditing },
                    modifier = Modifier
                        .padding(8.dp, 8.dp, 8.dp, 8.dp),
                ) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "edit")
                }
            }

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
        InputItem(person = thisPerson, content = "name", isEditing, inputTextList, 0)
        InputItem(person = thisPerson, content = "relationship", isEditing, inputTextList, 1)
        InputItem(person = thisPerson, content = "age", isEditing, inputTextList, 2)
        InputItem(person = thisPerson, content = "company", isEditing, inputTextList, 3)
        InputItem(person = thisPerson, content = "hobby", isEditing, inputTextList, 4)
        InputItem(person = thisPerson, content = "personality", isEditing, inputTextList, 5)
        InputItem(person = thisPerson, content = "marriage", isEditing, inputTextList, 6)
        InputItem(person = thisPerson, content = "children", isEditing, inputTextList, 7)
        InputItem(person = thisPerson, content = "like", isEditing, inputTextList, 8)
        InputItem(person = thisPerson, content = "dont_like", isEditing, inputTextList, 9)
        InputItem(person = thisPerson, content = "etc", isEditing, inputTextList, 10)

    }
}

@Composable
fun InputItem(
    person: Person,
    content: String,
    isEditing: Boolean,
    inputCategory: SnapshotStateList<String>,
    index: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(0.dp, 8.dp),
    ) {
        Text(
            text = stringResource(id = propertyToStringValue(content)),
            modifier = Modifier
                .width(132.dp)
                .padding(12.dp, 0.dp),
            fontSize = 18.sp
        )
        var isExpanded by remember { mutableStateOf(false) }
        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 6.dp, 0.dp)
        ) {
            Row(
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (isEditing) {
//                    var tempText by remember {
//                        mutableStateOf(
//                            contentToStringValue(
//                                person,
//                                content
//                            )
//                        )
//                    }
                    //Text(text = "isEditing")
                    TextField(
                        value = inputCategory[index],
                        onValueChange = { inputCategory[index] = it }
                    )
                } else {
                    Text(
                        modifier = Modifier
                            .animateContentSize()
                            .weight(1f)
                            .padding(8.dp, 0.dp),
                        text = contentToStringValue(person, content),
                        fontSize = 18.sp,
                        maxLines = if (isExpanded) {
                            Int.MAX_VALUE
                        } else {
                            1
                        },
                    )
                    Icon(
                        painter = if (isExpanded) {
                            painterResource(id = R.drawable.ic_baseline_arrow_drop_up_24)
                        } else {
                            painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24)
                        },
                        contentDescription = "down",
                        Modifier.width(24.dp)
                    )
                }
            }
        }

    }
}

fun contentToStringValue(person: Person, text: String) = when (text) {
    "name" -> person.name
    "relationship" -> person.relationship
    "age" -> person.age.toString()
    "company" -> person.company
    "hobby" -> person.hobby
    "personality" -> person.personality
    "marriage" -> person.marriage
    "children" -> person.children
    "like" -> person.like
    "dont_like" -> person.dont_like
    else -> person.etc
}

fun propertyToStringValue(text: String) = when (text) {
    "name" -> R.string.name
    "relationship" -> R.string.relationship
    "age" -> R.string.age
    "company" -> R.string.company
    "hobby" -> R.string.hobby
    "personality" -> R.string.personality
    "marriage" -> R.string.marriage
    "children" -> R.string.children
    "like" -> R.string.like
    "dont_like" -> R.string.dont_like
    else -> R.string.etc
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    //DetailsScreen(personId = 1)
}