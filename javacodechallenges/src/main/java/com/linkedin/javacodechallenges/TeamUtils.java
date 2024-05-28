package com.linkedin.javacodechallenges;

import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    // TODO: IMPLEMENT THE SOLUCION HERE
    if (teams.size() == 0 || teams.stream().allMatch(team -> team.getScores().isEmpty())) {
      System.out.println("The game has not started yet");
      return;
    }

    // Agrupa los teams por puntaje, de esa forma es mas facil saber quien está
    // primero y ver si hay un empate
    TreeMap<Integer, List<Team>> scoreTeamMap = teams.stream()
        .collect(Collectors.groupingBy(Team::sumTotalScore,
            TreeMap::new, Collectors.toList()));

    // Despues hay que ordenarlos
    NavigableSet<Integer> descendingScores = scoreTeamMap.descendingKeySet();
    Iterator<Integer> teamsResultsIterator = descendingScores.iterator();

    System.out.println("The winner is: ");
    announceResult(teamsResultsIterator.next(), scoreTeamMap);

    while (teamsResultsIterator.hasNext()) {
      System.out.println("then we have...");
      announceResult(teamsResultsIterator.next(), scoreTeamMap);
    }
  }

  private static void announceResult(int score, TreeMap<Integer, List<Team>> scoreTeamMap) {
    List<Team> playersWithScore = scoreTeamMap.get(score);

    if (playersWithScore.size() > 1) {
      System.out.println("It is a tie!");
    }
    playersWithScore.forEach(team -> System.out.println("With " + score +
        " points, it is team " + team.getPlayer1() + " and " + team.getPlayer2() + "!"));

    System.out.println();
  }
}