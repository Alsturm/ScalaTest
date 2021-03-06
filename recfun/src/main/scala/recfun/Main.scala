package recfun

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
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < c) throw new IllegalArgumentException
    if (c == 0 || r == c) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def balance0(chars: List[Char], count: Int): Boolean = {
      if (count < 0) false
      else if (chars.isEmpty) count == 0
      else chars.head match {
        case '(' => balance0(chars.tail, count + 1)
        case ')' => balance0(chars.tail, count - 1)
        case _ => balance0(chars.tail, count)
      }
    }

    balance0(chars, 0)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def countChange0(money: Int, coins: List[Int], ways: Int): Int = {
      if (coins.isEmpty || money < 0) ways
      else if (money == 0) ways + 1
      else ways + countChange0(money - coins.head, coins, ways) + countChange0(money, coins.tail, ways)
    }

    countChange0(money, coins, 0)
  }
}
