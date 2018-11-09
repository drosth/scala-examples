package com.example.typeclass

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import com.example.typeclass.Example1._

class Example1Spec extends FlatSpec
    with BeforeAndAfter
    with Matchers
    with MockitoSugar {

  behavior of "adding integers"

  it should "be able add 2 int values" in {
    add(1, 2) shouldBe 3
  }

  it should "be able add 3 int values" in {
    addThree(1, 2, 3) shouldBe 6
  }

  behavior of "adding strings"

  it should "be able add 2 string values" in {
    add("Hello", "World") shouldBe "HelloWorld"
  }

  it should "be able add 3 string values" in {
    addThree("Hello", " ", "World") shouldBe "Hello World"
  }

  behavior of "adding vectors"

  it should "be able add 2 vectors" in {
    add(Vector(1), Vector(2, 3)) shouldBe Vector(1, 2, 3)
  }

  it should "be able add 3 vectors" in {
    addThree(Vector(1), Vector(2), Vector(3)) shouldBe Vector(1, 2, 3)
  }

  behavior of "zipping"

  it should "be able add 2 Lists" in {
    zipAdd(List(1, 2, 3), List(4, 5, 6)) shouldBe List(5, 7, 9)
  }
}
