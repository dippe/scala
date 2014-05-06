//def countChange(money: Int, coins: List[Int]): Int = ???


def countChange(money: Int, coins: List[Int]): Int = {

  return cc(money, coins, 0)

  def cc(money: Int, coins: List[Int], prevSum: Int): Int = {
    val sum = prevSum + coins.head
    if (sum == money) {
      return 1
    } else if (sum > money) {
      return 0
    } else {
      //  getAllVariation(coins, List(), coins.length)
      return cc(money, coins.tail, sum)
    }
  }

  /*  def getAllVariation(coins: List[Int], variations: List[List[Int]], len: Int): List[List[Int]] = {
      if(len>0){
        return variations ::: getAllVariation(coins.tail :: coins.head, variations, len-1)
      }else{
        return variations
      }
    }
  */
  //getAllVariation(List(500,5,50,100,20,200,10), List(), List(500,5,50,100,20,200,10).length)
}