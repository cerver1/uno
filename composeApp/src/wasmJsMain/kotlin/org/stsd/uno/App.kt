package org.stsd.uno

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import uno.composeapp.generated.resources.Res
import uno.composeapp.generated.resources.compose_multiplatform

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun App() {
    MaterialTheme {
        val teams = List(2) { Team("Team $it", "${13 * it}")}
        val gameState = GameState(
            teams = teams,
            selectedTeam = teams[1],
            points = 100,
            strikes = 2
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(64.dp)
            ) {

                Card(
                    modifier = Modifier.size(200.dp)
                ) {
                    Text(
                        modifier = Modifier.wrapContentSize(),
                        text = gameState.points.toString(),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h2
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(64.dp)
                ) {
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Text(
                            modifier = Modifier.wrapContentSize(),
                            text = teams[0].points,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h3
                        )
                    }
                    FlowColumn(
                        maxItemsInEachColumn = 4,
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        val answers = List(6) { Answer(it.toString(), "Test", it * 2) }

                        answers.forEach { answer ->
                            Card {
                                Row(
                                    modifier = Modifier
                                        .padding(15.dp)
                                        .fillMaxWidth(0.3f)
                                ) {
                                    Text(
                                        modifier = Modifier.weight(1f),
                                        text = answer.value
                                    )
                                    Text(answer.points.toString())
                                }
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.size(150.dp)
                    ) {
                        Text(
                            modifier = Modifier.wrapContentSize(),
                            text = teams[1].points,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h3
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(64.dp)
                ) {
                    repeat(gameState.strikes) {
                        Card(
                            modifier = Modifier.size(200.dp)
                        ) {
                            Text(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .padding(20.dp),
                                text = "X",
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h3
                            )
                        }
                    }
                }
            }
        }
    }
}