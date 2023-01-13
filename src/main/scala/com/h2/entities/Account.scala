package main.scala.com.h2.entities

class Account(p: Product,c: Customer, b:Int) {
  val product: Product = p
  val customer : Customer =  c
  var balance : Int = b

  def deposit (amount:Double):Unit = {
    balance += amount
    println(s"Depositing $amount to $customer account")
  }

  def withdrawal (amount:Double): Unit ={
    println(s"Withdrawing $amount to $customer account")
    balance -= amount
  }
}
