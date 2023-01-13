package main.scala.com.h2.entities

object Dollars {

}

class Dollars (val amount: Int) extends AnyVal{
  def +(value: Int): Dollars = new Dollars (amount + value)
  def -(value: Int): Dollars = new Dollars (amount - value)
  def >(value: Int): Boolean =  amount > value

  override def toString: String = "$" + amount

}
