val  x = List(1,2,3)


val prev = List(1)



def getRow(rows:List[], row:Int, col:Int):Int{
  val curRowMaxLen = prevRow.length+1
  val curRow = rows.head
  if(row==curRowLen && col==curRow.length){
    return curValue
  }else{
    if(col<curRowMaxLen){

    }
    return getRows(rows, row, col)
  }
}

def getNewRow(prevRow:List[Int]):List[Int] = {
  var ret = prevRow.reduce()
}

def pairsSumAt(row:List[Int], at: Int):Int = {
  val a = if (row.isDefinedAt(at)) row(at) else 0
  val b = if (row.isDefinedAt(at+1)) row(at) else 0
  return a+b
}

/**
 *  1
 * 1 1
 * 1 2 1
 * 1 3 3 1
 * 1 4 6 4 1
 * 1 5 10 10 5 1
 * 1 6 15 20 15 6 1
 *
  */