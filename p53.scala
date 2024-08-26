object p53 {

  // Recursive function to compute Fibonacci numbers
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // Function to print the first n Fibonacci numbers
  def printFibonacciNumbers(n: Int): Unit = {
    for (i <- 0 until n) {
      print(s"${fibonacci(i)} ")
    }
    println() // for a new line after printing the sequence
  }

  def main(args: Array[String]): Unit = {
    println("Enter the value of n:")
    val n = scala.io.StdIn.readInt()

    println(s"First $n Fibonacci numbers:")
    printFibonacciNumbers(n)
  }
}
