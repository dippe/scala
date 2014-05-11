package recfun

/**
 * Created by bip on 5/6/14.
 */
object Balance {
  val p1 = "(".charAt(0)
  val p2 = ")".charAt(0)

  def removeAllPair(chars: List[Char]): List[Char] = {
    if (chars.isEmpty || chars.length == 1) {
      chars
    } else {
      val tmp = removeFirstPair(chars)
      if (tmp == chars) {
        tmp
      } else {
        removeAllPair(tmp)
      }
    }
  }

  def removeFirstPair(chars: List[Char]): List[Char] = {

    if (chars.length < 2) {
      chars
    }
    else if (chars(0) == p1 && chars(1) == p2) {
      chars.tail.tail
    } else {
      chars(0) :: removeFirstPair(chars.tail)
    }

  }

  def onlyParentheses(chars: List[Char]): List[Char] = {
    if (chars.isEmpty) {
      List()
    }
    else {
      if (chars(0) == p1 || chars(0) == p2) {
        chars(0) :: onlyParentheses(chars.tail)
      } else {
        onlyParentheses(chars.tail)
      }
    }
  }

  def balance(chars: List[Char]): Boolean = {
    val op = onlyParentheses(chars)
    removeAllPair(op).isEmpty
  }
}
