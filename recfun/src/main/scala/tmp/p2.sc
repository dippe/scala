
def pascal2(col: Int, row: Int): Int = {
  if (row > 1) pascal2(col - 1, row - 1) + pascal2(col, row - 1)
  else if (col <= 0 || col > row) 0
  else 1
}
for (row <- 0 to 10) {
  for (col <- 0 to row)
    print(pascal2(col, row) + " ")
  println()
}


}
def sum(f: Int => Int)(a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (???) ???
    else loop(???, ???)
  }
  loop(???, ???)
}