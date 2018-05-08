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

package io.swagger.client.model


case class Pet (
  id: Option[Long] = None,
  category: Option[Category] = None,
  name: String,
  photoUrls: List[String],
  tags: Option[List[Tag]] = None,
  // pet status in the store
  status: Option[String] = None
)

