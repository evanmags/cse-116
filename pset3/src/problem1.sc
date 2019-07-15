//
// Create a complete program that uses a class named “Score”. 
// The class contains a field (member variable) named team, of type String.
// The class contains a field (member variable) named Score, of type integer.
// The class contains a constructor that takes a name-string  and stores it in the field named team.
// The class contains a method named scoreGoal that takes no parameters but increments (adds 1 to) the member variable Score.
// The class contains a method called isWinner that accepts a Score object as input and returns True  if the parameter object has a score lower than this one. It will return False if the parameter object has a larger score than this one.
// To test you will create two teams, calculate a randomly-generated integer for each which is the number of times the scoreGoal method is called for that team. Then isWinner is called for each team and the result published to the user.
//

import scala.io.StdIn._ // import all standard inputs
import scala.util.Random

class Score(teamName: String){
  val team: String = teamName
  private var score: Int = 0

  def isWinner(s: Score): Boolean = {
    score > s.getScore()
  }

  def scoreGoal(): Unit = {
    score += 1
  }

  def getScore(): Int = {
    score
  }
}

object Test {
  def main(args: Array[String]): Unit = {
    val s1: Score = new Score("team-A");
    val s2: Score = new Score("team-B");

    val rndm: Random = new Random()

    for(n <- 0 to rndm.nextInt(10)) s1.scoreGoal()
    for(n <- 0 to rndm.nextInt(10)) s2.scoreGoal()

    println(s1.isWinner(s2))
    println(s2.isWinner(s1))
  }
}