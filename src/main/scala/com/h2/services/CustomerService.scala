package main.scala.com.h2.services

import main.scala.com.h2.entities.{Customer, Email}

import java.time.LocalDate
import java.util.UUID

trait CustomerService extends CustomerDb{

  def createNewCustomer(first: String, last:String, email: String,dateOfBirth:String): UUID = {
    def getEmail: Email = {
      val Array(value, domain) = email.split("@")
      Email(value,domain)
    }
    def getDateOfBirth: LocalDate = {
      val Array(year, month, day) = dateOfBirth.split("/")
      LocalDate.of(year.toInt, month.toInt, day.toInt)
    }

    val customer = new Customer(first, last, getEmail, getDateOfBirth)
    saveCustomer(customer)
    customer.id
  }

}
