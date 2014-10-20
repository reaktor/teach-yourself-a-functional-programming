object Recursion {


    /** computes fibonacci value for a given number
      * 
      * fibonacci sequence for number x can be obtained
      * by calculating fib(x - 1) + fib(x - 2)
      */
    def fib(num:Int) = ???

    /** computes factorial of a number
      *
      * e.g.
      * 5! = 5 * 4 * 3 * 2 * 1
      * 3! = 3 * 2 * 1
      */
    def fact(num:Int) = ???


    /** returns true if 'list' contains 'needle'
      *
      * Tip: for maximum learning, implement list traversal via recursion
      */
    def contains[A](list: List[A], needle: A):Boolean = ???




    def main(args: Array[String]) {
        
        println(s"${Console.GREEN}Running ${tests.size} tests:")

        tests.foreach { (fixture) =>
            val name = fixture._1
            val test = fixture._2
            try {
                print(s"${Console.GREEN}\t- '$name': ")
                test()
                println("PASS!")
            } catch {
                case e:Throwable => {
                    println(Console.RED + e.getClass + ":" + e.getMessage)
                }
            }

        }
    }

    val tests = List[(String, Function0[Unit])](
        ("fib0", () => {
            verify(0, fib(0))
        }),
        ("fib1", () => {
            verify(1, fib(1))
        }),
        ("fib2", () => {
            verify(1, fib(2))
        }),
        ("fib3", () => {
            verify(2, fib(3))
        }),
        ("fib4", () => {
            verify(3, fib(4))
        }),
        ("fib5", () => {
            verify(5, fib(5))
        }),
        ("fib6", () => {
            verify(8, fib(6))
        }),
        ("fact0", () => {
            verify(1, fact(0))
        }),
        ("fact1", () => {
            verify(1, fact(1))
        }),
        ("fact2", () => {
            verify(2, fact(2))
        }),
        ("fact3", () => {
            verify(6, fact(3))
        }),
        ("fact10", () => {
            verify(3628800, fact(10))
        }),
        ("contains", () => {
            verify(false, contains(List(), "foo"))
            verify(true, contains(List("foo"), "foo"))
            verify(false, contains(List("faz"), "foo"))
            verify(true, contains(List("faz","baz","foo"), "foo"))
            verify(false, contains(List("faz","baz","bar"), "foo"))
        })
    )


    def verify(expected: Any, actual: Any) =
        assert(expected == actual, s"Expected: $expected, actual: $actual")
}