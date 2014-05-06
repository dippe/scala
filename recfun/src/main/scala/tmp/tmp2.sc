import scala.annotation.tailrec

val coins = List(1, 2, 5, 8, 10)
coins.sum
//val len = l.length
//val iter = l.combinations(2)
//iter.mkString("\n")
def countChange(money: Int, coins: List[Int]): Int = {
  val allCoins = getAllCoins(coins)
  gc2(money, allCoins, allCoins.length)
  gc(money, allCoins, allCoins.length)
}


//@tailrec
def genCoins(num: Int, count: Int, cl: List[Int]): List[Int] = {
  if (count > 0) {
    genCoins(num, count - 1, num :: cl)
  } else {
    cl
  }
}

def getAllCoins(coins: List[Int]): List[Int] = {
  coins
    .map(coin => genCoins(coin, Math.floor(5 / coin).toInt, List()))
    .reduce((l: List[Int], all: List[Int]) => all ::: l)
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

def gc2(money: Int, coins: List[Int], len: Int): Int = {
  if (len > 0) gc2(money, coins, len - 1)
  coins.combinations(len - 1)
    .filter(l => l.sum == money)
    .foreach(l => println(l))
  return 9
}

//gc2(5, l, l.length)


countChange(5, coins)




countChange(300, List(5, 10, 20, 50, 100, 200, 500))



//iter.foreach(test)
//def test(l:List[Int]) : Int= {
//  val sum = l(1) + l(2)
// println(sum)
//  return sum
//}