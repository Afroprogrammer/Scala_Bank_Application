import main.scala.com.h2.entities._

import java.time.LocalDate

object BankOfScala {
  def main(args: Array[String]): Unit = {
    println("Opening Bank")
   val  bank = new Bank(name = "Bank of Ajax", "Toronto", "Canada",email = Email("Kojo", "gmail.com"))
    val coreChecking = new CoreChecking(Dollars(1000), 0.025)
    val studentChecking = new StudentCheckings(Dollars(0), 0.010)
    val rewardsSavings = new RewardsSavings(Dollars(10000), 0.10, 1)
    val creditCard = new CreditCard(99.00, 14.23, 20.00)
    val products = Set(coreChecking, studentChecking, rewardsSavings, creditCard)

    val bobMartin = new Customer("Bob", "Martin", email = Email("bank", "Toronto"), LocalDate.of(1983, 8, 22))
    val bobCheckingAccount = new DepositsAccount(bobMartin , coreChecking,Dollars(1000))
    val bobSavingsAccount = new DepositsAccount(bobMartin, rewardsSavings,Dollars(20000))
    val bobCreditAccount = new LendingAccount(bobMartin, creditCard, Dollars(4500))
    val accounts = Set(bobCheckingAccount, bobSavingsAccount, bobCreditAccount)

    /* ------------------- Data ------------------- */
    def getCustomers: Seq[(String, String, String, String)] = {
      Seq(
        ("Bob", "Martin", "bob@martin.com", "1976/11/25"),
        ("Amy", "Jones", "amy.jones@google.com", "1983/4/12"),
        ("Taylor", "Jackson", "taylor33@jackson.com", "1985/4/5")
      )
    }

    def getDepositProducts: Seq[(String, Int, Double)] = {
      Seq(
        ("CoreChecking", 1000, 0.025),
        ("StudentCheckings", 0, 0.010),
        ("RewardsSavings", 10000, 0.10),
      )
    }

    def getLendingProducts: Seq[(String, Double, Double, Double)] = {
      Seq(("CreditCard", 99.00, 14.23, 20.00))
    }

  }
}
