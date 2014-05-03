// 1. remove unneccessary characters - filter
// 2. find the closest Parentheses and remove them -
// 3. until there are Parentheses pairs
object Balance {
  val p1 = "(".charAt(0)
  val p2 = ")".charAt(0)
//  val str = "(valami(buli)csoda)(s(f(rr)()))()"
//  str.replaceAll("[^\\(\\)]", "")


  def removeAllPair(chars: List[Char]): List[Char] = {
    if (chars.isEmpty || chars.length == 1) {
      chars
    } else {
      val tmp = removeFirstPair(chars)
      if (tmp == chars) {
        return tmp
      } else {
        return removeAllPair(tmp)
      }
    }
  }
  def removeFirstPair(chars: List[Char]): List[Char] = {

    if (chars.length < 2) {
      return chars
    }
    else if (chars(0) == p1 && chars(1) == p2) {
      return chars.tail.tail
    } else {
      return chars(0) :: removeFirstPair(chars.tail)
    }

  }

  def onlyParentheses(chars: List[Char]): List[Char] = {
    if (chars.isEmpty) {
      return List()
    }
    else {
      if (chars(0) == p1 || chars(0) == p2) {
        return chars(0) :: onlyParentheses(chars.tail)
      } else {
        return onlyParentheses(chars.tail)
      }
    }
  }

  def balance(chars: List[Char]): Boolean = {
    val op = onlyParentheses(chars)
    if (removeAllPair(op).isEmpty) true
    else false
  }
}

val str = "(valami(buli)csoda)(s(f(rr)()))()"
val c2 = "(valami(buli)csoda)(s(f(rr)()))())(".toList
val c3 = "(valami(buli)csoda)(s(f(rr)()))())".toList
val chars = str.toList

Balance.balance(chars)
Balance.balance(c2)
Balance.balance(c3)

