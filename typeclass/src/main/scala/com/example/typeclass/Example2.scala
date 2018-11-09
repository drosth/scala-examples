package com.example.typeclass

object Example2 {

  sealed trait ISAdder[A]

  object ISAdder {
    implicit object AddInts extends ISAdder[Int]
    implicit object AddStrings extends ISAdder[String]
    final case class AddVects[E]() extends ISAdder[Vector[E]]

    implicit def addVects[E]: ISAdder[Vector[E]] = AddVects()
  }

  def isAdd[A](x: A, y: A)(implicit adder: ISAdder[A]): A =
    adder match {
      case ISAdder.AddInts => x + y
      case ISAdder.AddStrings => s"$x$y"
      case ISAdder.AddVects() => x ++ y
    }
}
