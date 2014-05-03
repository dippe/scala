val l2 = List(1, 1)

pascal(1,8)








def pascal(col:Int, row:Int) : Int = {
  val initList = List(1)
  val lastRow=getPascalRow (initList, row)
  return lastRow(col)
}

def getPascalRow(l: List[Int], depth: Int): List[Int] = {
  val zipped = l.zip (l.tail)
  val ret = List (1) ::: zipped.map (x => x._1 + x._2) ::: List (1)
  //  tmp.map{case (x, y) => x + y}
  println(ret)
  if (depth > 1) getPascalRow (ret, depth - 1)
  else ret
}
