package org.stsd.uno

data class GameState(
    val teams: List<Team>,
    val selectedTeam: Team,
    val strikes: Int,
    val points: Int
)
