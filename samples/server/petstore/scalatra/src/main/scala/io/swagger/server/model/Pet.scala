/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: team@openapitools.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 */

package io.swagger.server.model

case class Pet(
  id: Option[Long],

  category: Option[Category],

  name: String,

  photoUrls: List[String],

  tags: Option[List[Tag]],

  /* pet status in the store */
  status: Option[String]

 )
