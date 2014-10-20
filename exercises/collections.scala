object Functions {

    // convert a string to upper case, e.g. John => JOHN
    def upper(s:String) = ???

    // convert a list of strings to list of upper case strings
    def listToUpper(list:List[String]) = ???


    // return the length of a string
    def length(str: String):Int = ???

    // filter names that are less than four characters long
    def filterShortNames(names:List[String]) = ???

    // filter names that are less than four characters long
    // and turn remaining names to uppercase
    def filterShortAndTurnToUppercase(names:List[String]) = ???


    // turn a string to a list of characters
    def characters(str: String):List[Char] = ???

    // turn a list of strings to a list of list of characters
    def toCharacterLists(list:List[String]):List[List[Char]] = ???

    // turn a list of strings to a list of characters
    def listOfAllCharacters(list:List[String]):List[Char] = ???


    // return the first string in a list, or if list is empty, return "nada"
    def firstElementInListOrNada(list:List[String]) = ???

    // find the longest string in given list of strings, or "nada" if empty
    // and reverse the result before returning it
    def longestNameInList(names:List[String]) = ???

    // Join list `xs` of string with separator string `sep` into a string
    def joinWithSep(xs: List[String], sep: String): String = ???

    // Take sums of lists and return those with sum greater than 20
    //
    // sumOfLists20(List(List(1,2,3), List(2,10,9))) == List(21)
    def sumOfLists20(xs: List[List[Int]]): List[Int] = ???

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
                case e:Error => {
                    println(Console.RED + e.getMessage)
                }
            }

        }
    }

    def verify(expected: Any, actual: Any) =
        assert(expected == actual, s"Expected: $expected, actual: $actual")

    val tests = List[(String, Function0[Unit])](
        ("upper", () => {
            verify("FOO", upper("foo"))
            verify("BAR", upper("bar"))
            verify("BAZ", upper("baz"))
            verify("12", upper("12"))
        }),
        ("list to uppercase", () => {
            verify(List("FOO", "BAR"), listToUpper(List("foo", "bar")))
        }),
        ("length", () => {
            verify(3, length("foo"))
            verify(9, length("foobarbaz"))
        }),
        ("filter short names", () => {
            verify(List("John", "Suzy"), filterShortNames(List("Joe", "John", "Fae", "Suzy")))
        }),
        ("filter short names and convert to uppercase", () => {
            verify(List("JACK", "SUZY"), filterShortAndTurnToUppercase(List("Joe", "Jack", "Fae", "Suzy")))
        }),
        ("turn string to a list of characters", () => {
            verify(List('a', 'b', 'c'), characters("abc"))
        }),
        ("list of strings to a list of list of characters", () => {
            verify(List(List('f', 'o', 'o'), List('b', 'a', 'r'), List('b', 'a', 'z')), toCharacterLists(List("foo", "bar", "baz")))
        }),
        ("list of strings to a list of characters", () => {
            verify(List('f', 'o', 'o', 'b', 'a', 'r', 'b', 'a', 'z'), listOfAllCharacters(List("foo", "bar", "baz")))
        }),
        ("get first element in list or 'nada'", () => {
            verify("foo", firstElementInListOrNada(List("foo", "bar")))
            verify("bar", firstElementInListOrNada(List("bar")))
            verify("nada", firstElementInListOrNada(List()))
        }),
        ("find the longest name in the list", () => {
            verify("drahciR", longestNameInList(List("Jack", "John", "Jill", "Richard", "Jim")))
            verify("adan", longestNameInList(List()))
        }),

        ("join with separator", () => {
            verify("hello, world!", joinWithSep(List("hello", "world!"), ", "))
            verify("This, that, and the other", joinWithSep(List("This", "that", "and the other"), ", "))
        }),

        ("sum of lists greater than 20", () => {
            verify(List(30, 40), sumOfLists20(List(List(1,10), List(5,15), List(5, 20, 5), List(10,10,5,5,3,7))))
        })
    )

}
