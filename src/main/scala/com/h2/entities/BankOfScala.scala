package main.scala.com.h2.entities

import java.time.LocalDate

object BankOfScala {
  def main(args: Array[String]): Unit = {
    println("Instantiating Bank")

    val coreChecking = new CoreChecking(Dollars(1000), 0.025)
    val studentChecking = new StudentCheckings(Dollars(0), 0.010)
    val rewardsSavings = new RewardsSavings(Dollars(10000), 0.10, 1)
    val creditCard = new CreditCard(99.00, 14.23, 20.00)
    val products = Set(coreChecking, studentChecking, rewardsSavings, creditCard)

    val bobMartin = new Customer("Bob", "Martin", "bob@martin.com", LocalDate.of(1983, 8, 22))
    val bobCheckingAccount = new DepositsAccount(bobMartin , coreChecking,Dollars(1000))
    val bobSavingsAccount = new DepositsAccount(bobMartin, rewardsSavings,Dollars(20000))
    val bobCreditAccount = new LendingAccount(bobMartin, creditCard, Dollars(4500))
    val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)

    val bank = new Bank("Bank of Pickering", "Toronto", "New Zealand",
    Email("Bank", "pickering.com"), products, Set(bobMartin), accounts)

    println(bobCheckingAccount)

    bobCheckingAccount deposit 100
    println(bobCheckingAccount)

    bobCheckingAccount withdraw 200
    println(bobCheckingAccount)
  }
}