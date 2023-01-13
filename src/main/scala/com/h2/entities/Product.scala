package main.scala.com.h2.entities

abstract class Product {
  val name:String
  override def toString: String = "product" + name
}
/*********** Deposit Products ********************/

abstract class Deposits extends Product {
  val interestRatePerYear: Double
  val minimumBalancePerMonth: Int
}
abstract class Checkings extends Deposits

abstract class Savings extends Deposits {
  val transactionsAllowedPerMonth: Int
}

/*------------- Checking Products ------------ */
class CoreChecking(bal: Int, rate: Double) extends Checkings {
  println("Created Core Checking Product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Core Checking"
}

class StudentCheckings(bal: Int, rate: Double) extends Checkings {
  println("Created Core Checking Product")
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Core Checking"
}

/*----------------------Savings Products-----------------------*/
class RewardsSavings (bal: Int, rate: Double, trans: Int) extends Savings {
  override val transactionsAllowedPerMonth: Int = trans
  override val interestRatePerYear: Double = rate
  override val minimumBalancePerMonth: Int = bal
  override val name: String = "Reward Savings"
}

/*--------------------Lending Products ---------------------*/
abstract class Lending extends Product {
  val annualFee: Double
  val apr: Double
  val rewardsPercent: Double
}

class CreditCard(fee: Double, rate: Double, pct: Double) extends Lending {
  override val annualFee: Double = fee
  override val apr: Double = rate
  override val rewardsPercent: Double = pct
  override val name: String = "Credit Card"
}