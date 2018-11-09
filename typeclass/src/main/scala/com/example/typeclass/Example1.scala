package com.example.typeclass

object Example1 {

  def add[A](x: A, y: A)(implicit adder: Adder[A]): A =
    adder.addImpl(x, y)

  def addThree[A: Adder](l: A, m: A, r: A) =
    add(l, add(m, r))

  def zipAdd[A: Adder](l: List[A], r: List[A]): List[A] =
    l zip r map { case (x, y) => add(x, y) }


  // typeclasses are often defined with trait, but this is not required
  final case class Adder[A](addImpl: (A, A) => A)


  // easier if all implicits are in this block
  object Adder {
    implicit val addInts: Adder[Int] = Adder((x, y) => x + y)

    implicit val addStrings: Adder[String] = Adder((x, y) => s"$x$y")

    implicit def addVects[A]: Adder[Vector[A]] = Adder((l, r) => l ++ r)
  }
}
