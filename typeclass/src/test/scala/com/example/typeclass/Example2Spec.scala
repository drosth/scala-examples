package com.example.typeclass

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}
import org.scalatest.mockito.MockitoSugar
import com.example.typeclass.Example2._

class Example2Spec extends FlatSpec
    with BeforeAndAfter
    with Matchers
    with MockitoSugar {


  behavior of "adding integers with ISAdder"

  it should "be able add 2 int values" in {
    isAdd(1,2) shouldBe 3
  }

  behavior of "adding strings with ISAdder"

  it should "be able add 2 string values" in {
    isAdd("Hello", "World") shouldBe "HelloWorld"
  }

  behavior of "adding vectors with ISAdder"

  it should "be able add 2 vectors" in {
    isAdd(Vector(1), Vector(2, 3)) shouldBe Vector(1, 2, 3)
  }
}
