package main.scala.com.h2.services

import main.scala.com.h2.{Deposits, Lending}
import main.scala.com.h2.entities.Customer

import java.util.UUID

trait CustomerDb {
  private var customers: Map[UUID, Customer] = Map.empty
  def saveCustomer(customer: Customer):Unit = customers += (customer.id -> customer)
  def getCustomer(id: UUID): Option[Customer] = customers.get(id)
  def numCustomers: Int = customers.size
}

trait ProductsDb {
  private var depositProducts: Map[UUID, Deposits] = Map.empty
  private var lendingProducts: Map[UUID, Lending] = Map.empty

  def saveDepositProduct(product: Deposits): Unit = depositProducts += (product.id -> product)
  def saveLendingProduct(product: Lending) : Unit = lendingProducts += (product.id -> product)
  def getDepositProduct(id: UUID): Option[Deposits] = depositProducts.get(id)
  def getLendingProduct(id: UUID): Option[Lending] = lendingProducts.get(id)
  def numDepositsProducts: Int = depositProducts.size
  def numLendingProducts: Int = lendingProducts.size





}