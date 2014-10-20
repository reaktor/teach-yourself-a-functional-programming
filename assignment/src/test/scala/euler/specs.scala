package euler

import org.scalatest._


class ProjectEulerSpecs extends FlatSpec with Matchers {
  "Problem 2" should "find the sum of the even valued fib terms below 4M" in {
    ProjectEuler.problem2() should be(4613732)
  }

  "Problem 4" should "find the largest palindrome made from the product of two 3-digit numbers" in {
     ProjectEuler.problem4() should be(906609)
  }

  "Problem 9" should "find the product abc for the pythagorean triplet for which a + b + c = 1000" in {
      ProjectEuler.problem9() should be(31875000)
  }

  "Problem 18" should "Find the maximum total from top to bottom of the given triangle" in {
    ProjectEuler.problem18(triangle("/problem18_triangle.txt")) should be(1074)
  }

  "Problem 67" should "find the maximum total from top to bottom in the given huge triangle" in {
    ProjectEuler.problem67(triangle("/problem67_triangle.txt")) should be(7273)
  }

  def triangle(resource: String): List[List[Int]] = scala.io.Source
    .fromURL(getClass.getResource(resource))
    .getLines
    .toList
    .map(toListOfInts)

  def toListOfInts(s: String) = s.split(' ').map(_.toInt).toList
}
