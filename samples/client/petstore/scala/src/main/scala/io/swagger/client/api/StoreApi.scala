/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package io.swagger.client.api

import java.text.SimpleDateFormat

import io.swagger.client.model.Order
import io.swagger.client.{ApiInvoker, ApiException}

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date
import java.util.TimeZone

import scala.collection.mutable.HashMap

import com.wordnik.swagger.client._
import scala.concurrent.Future
import collection.mutable

import java.net.URI

import com.wordnik.swagger.client.ClientResponseReaders.Json4sFormatsReader._
import com.wordnik.swagger.client.RequestWriters.Json4sFormatsWriter._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration._
import scala.util.{Failure, Success, Try}

import org.json4s._

class StoreApi(
  val defBasePath: String = "http://petstore.swagger.io/v2",
  defApiInvoker: ApiInvoker = ApiInvoker
) {
  private lazy val dateTimeFormatter = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter
  }
  private val dateFormatter = {
    val formatter = new SimpleDateFormat("yyyy-MM-dd")
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"))
    formatter
  }
  implicit val formats = new org.json4s.DefaultFormats {
    override def dateFormatter = dateTimeFormatter
  }
  implicit val stringReader: ClientResponseReader[String] = ClientResponseReaders.StringReader
  implicit val unitReader: ClientResponseReader[Unit] = ClientResponseReaders.UnitReader
  implicit val jvalueReader: ClientResponseReader[JValue] = ClientResponseReaders.JValueReader
  implicit val jsonReader: ClientResponseReader[Nothing] = JsonFormatsReader
  implicit val stringWriter: RequestWriter[String] = RequestWriters.StringWriter
  implicit val jsonWriter: RequestWriter[Nothing] = JsonFormatsWriter

  var basePath: String = defBasePath
  var apiInvoker: ApiInvoker = defApiInvoker

  def addHeader(key: String, value: String): mutable.HashMap[String, String] = {
    apiInvoker.defaultHeaders += key -> value
  }

  val config: SwaggerConfig = SwaggerConfig.forUrl(new URI(defBasePath))
  val client = new RestClient(config)
  val helper = new StoreApiAsyncHelper(client, config)

  /**
   * Delete purchase order by ID
   * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
   *
   * @param orderId ID of the order that needs to be deleted 
   * @return void
   */
  def deleteOrder(orderId: String) = {
    val await = Try(Await.result(deleteOrderAsync(orderId), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Delete purchase order by ID asynchronously
   * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
   *
   * @param orderId ID of the order that needs to be deleted 
   * @return Future(void)
   */
  def deleteOrderAsync(orderId: String) = {
      helper.deleteOrder(orderId)
  }

  /**
   * Returns pet inventories by status
   * Returns a map of status codes to quantities
   *
   * @return Map[String, Integer]
   */
  def getInventory(): Option[Map[String, Integer]] = {
    val await = Try(Await.result(getInventoryAsync(), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Returns pet inventories by status asynchronously
   * Returns a map of status codes to quantities
   *
   * @return Future(Map[String, Integer])
   */
  def getInventoryAsync(): Future[Map[String, Integer]] = {
      helper.getInventory()
  }

  /**
   * Find purchase order by ID
   * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
   *
   * @param orderId ID of pet that needs to be fetched 
   * @return Order
   */
  def getOrderById(orderId: Long): Option[Order] = {
    val await = Try(Await.result(getOrderByIdAsync(orderId), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Find purchase order by ID asynchronously
   * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generated exceptions
   *
   * @param orderId ID of pet that needs to be fetched 
   * @return Future(Order)
   */
  def getOrderByIdAsync(orderId: Long): Future[Order] = {
      helper.getOrderById(orderId)
  }

  /**
   * Place an order for a pet
   * 
   *
   * @param order order placed for purchasing the pet 
   * @return Order
   */
  def placeOrder(order: Order): Option[Order] = {
    val await = Try(Await.result(placeOrderAsync(order), Duration.Inf))
    await match {
      case Success(i) => Some(await.get)
      case Failure(t) => None
    }
  }

  /**
   * Place an order for a pet asynchronously
   * 
   *
   * @param order order placed for purchasing the pet 
   * @return Future(Order)
   */
  def placeOrderAsync(order: Order): Future[Order] = {
      helper.placeOrder(order)
  }

}

class StoreApiAsyncHelper(client: TransportClient, config: SwaggerConfig) extends ApiClient(client, config) {

  def deleteOrder(orderId: String)(implicit reader: ClientResponseReader[Unit]): Future[Unit] = {
    // create path and map variables
    val path = (addFmt("/store/order/{orderId}")
      replaceAll("\\{" + "orderId" + "\\}", orderId.toString))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    if (orderId == null) throw new Exception("Missing required parameter 'orderId' when calling StoreApi->deleteOrder")


    val resFuture = client.submit("DELETE", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  def getInventory()(implicit reader: ClientResponseReader[Map[String, Integer]]): Future[Map[String, Integer]] = {
    // create path and map variables
    val path = (addFmt("/store/inventory"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]


    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  def getOrderById(orderId: Long)(implicit reader: ClientResponseReader[Order]): Future[Order] = {
    // create path and map variables
    val path = (addFmt("/store/order/{orderId}")
      replaceAll("\\{" + "orderId" + "\\}", orderId.toString))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]


    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  def placeOrder(order: Order)(implicit reader: ClientResponseReader[Order], writer: RequestWriter[Order]): Future[Order] = {
    // create path and map variables
    val path = (addFmt("/store/order"))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    if (order == null) throw new Exception("Missing required parameter 'order' when calling StoreApi->placeOrder")

    val resFuture = client.submit("POST", path, queryParams.toMap, headerParams.toMap, writer.write(order))
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }


}
