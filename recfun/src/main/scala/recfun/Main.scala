package recfun

import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(col: Int, row: Int): Int = {
    val initList = List(1)
    val lastRow = getPascalRow(initList, row)
    return lastRow(col)
  }


  def getPascalRow(l: List[Int], depth: Int): List[Int] = {
    val zipped = l.zip(l.tail)
    val ret = List(1) ::: zipped.map(x => x._1 + x._2) ::: List(1)
    //  tmp.map{case (x, y) => x + y}
    if (depth > 1) getPascalRow(ret, depth - 1)
    else ret
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = ???

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def gc(money: Int, coins: List[Int], len: Int): Int = {
      if (len > 0) {
        coins.combinations(len)
          .filter(l => l.sum == money)
          .length + gc(money, coins, len - 1)
      }
      else
        len
    }
    gc(money, coins, coins.length)
  }
}
