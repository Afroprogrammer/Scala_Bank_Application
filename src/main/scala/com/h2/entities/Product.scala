package main.scala.com.h2.entities

import java.util.UUID

sealed trait ProductCategory
case object DepositsP extends ProductCategory
case object LendingP extends ProductCategory

abstract class Product {
  val name:String
  val id: UUID = UUID.randomUUID()
  val category: ProductCategory

  override def toString: String = "product" + name
}
/*********** Deposit Products ********************/

abstract class Deposits extends Product {
  override val category: ProductCategory = DepositsP
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Dollars
}

abstract class Checkings extends Deposits

abstract class Savings extends Deposits {
  val transactionsAllowedPerMonth: Int
}

/*------------- Checking Products ------------ */
class CoreChecking(val minimumBalancePerMonth: Dollars, val interestRatePerYear: Double) extends Checkings {
  println("Created Core Checking Product")
  override val name: String = "Core Checking"
}

class StudentCheckings(val minimumBalancePerMonth: Dollars,   val interestRatePerYear: Double) extends Checkings {
  println("Created Core Checking Product")
  override val name: String = "Student Checking"
}

/*----------------------Savings Products-----------------------*/
class RewardsSavings (val minimumBalancePerMonth: Dollars, val interestRatePerYear: Double, val transactionsAllowedPerMonth: Int) extends Savings {
  println("Created Rewards Savings Product")
  override val name: String = "Reward Savings"
}

/*--------------------Lending Products ---------------------*/
abstract class Lending extends Product {
  override val category: ProductCategory = LendingP
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(val annualFee:Double, val apr:Double, val rewardsPercent: Double) extends Lending {
  println("Created Credit Card Product")
  override val name: String = "Credit Card"
}