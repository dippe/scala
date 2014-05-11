package recfun

import common._
import scala.annotation.tailrec
import java.util.Date

object Main {
  def main(args: Array[String]) {
    val start = new Date().getTime()
    println("Pascal's Triangle")
    for (row <- 0 to 140) {
      for (col <- 0 to row)
      //print(pascal(col, row) + " ")
        pascal(col, row)
      //println()
    }
    val end = new Date().getTime()
    println(end - start)
    print("kesz")
  }

  /**
   * Exercise 1
   */


  def pascal2(col: Int, row: Int): Int = {
    if (row > 1) pascal2(col - 1, row - 1) + pascal2(col, row - 1)
    else if (col <= 0 || col > row) 0
    else 1
  }


  def pascal(col: Int, row: Int): Int = {
    val initList = List(1)
    val lastRow = getPascalRow(initList, row)
    lastRow(col)
  }

  @tailrec
  def getPascalRow(l: List[Int], depth: Int): List[Int] = {
    val zipped = l.zip(l.tail)
    val ret = List(1) ::: zipped.map(x => x._1 + x._2) ::: List(1)
    if (depth > 1) getPascalRow(ret, depth - 1)
    else ret
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = Balance.balance(chars)

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def getAllCoins(money: Int, coins: List[Int]): List[Int] = {
      coins
        .map(coin => genCoins(coin, Math.floor(money / coin).toInt, List()))
        .reduce((l: List[Int], all: List[Int]) => all ::: l)
    }

    @tailrec
    def genCoins(num: Int, count: Int, cl: List[Int]): List[Int] = {
      if (count > 0) {
        genCoins(num, count - 1, num :: cl)
      } else {
        cl
      }
    }

    def gc(money: Int, coins: List[Int], len: Int): Int = {
      if (len > 0) {
        coins.combinations(len)
          .filter(l => l.sum == money)
          .length + gc(money, coins, len - 1)
      }
      else
        len
    }

    val allCoins = getAllCoins(money, coins)
    gc(money, allCoins, allCoins.length)
  }
}
