package main.scala.com.h2.services

import main.scala.com.h2.{CoreChecking, CreditCard, RewardsSavings, StudentCheckings}
import main.scala.com.h2.entities.Dollars

import java.util.UUID

trait ProductService extends ProductsDb {
  def addNewDepositProduct(name: String, minBalance: Int, ratePerYear: Double,
                           transactionsAllowedPerMonth: Int = 2): UUID = {
    val product = name match {
      case "CoreChecking" => new CoreChecking(Dollars(minBalance), ratePerYear)
      case "StudentCheckings" => new StudentCheckings(Dollars(minBalance), ratePerYear)
      case "RewardsSavings" => new RewardsSavings(Dollars(minBalance), ratePerYear, transactionsAllowedPerMonth)
    }

    saveDepositProduct(product)
    product.id
  }

  def addNewLendingProduct(annualFee: Double, apr: Double, rewardsPercent: Double): UUID = {
    val product = new CreditCard(annualFee, apr, rewardsPercent)
    saveLendingProduct(product)
    product.id
  }
}
