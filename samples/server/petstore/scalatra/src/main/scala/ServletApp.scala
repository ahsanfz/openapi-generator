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


package io.swagger.app

import org.scalatra.swagger.{ ApiInfo, SwaggerWithAuth, Swagger }
import org.scalatra.swagger.{ JacksonSwaggerBase, Swagger }
import org.scalatra.ScalatraServlet
import org.json4s.{ DefaultFormats, Formats }

class ResourcesApp(implicit protected val swagger: SwaggerApp)
  extends ScalatraServlet with JacksonSwaggerBase {
  before() {
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
}

class SwaggerApp extends Swagger(apiInfo = ApiSwagger.apiInfo, apiVersion = "1.0", swaggerVersion = Swagger.SpecVersion)

object ApiSwagger {
  val apiInfo = ApiInfo(
    """OpenAPI Petstore""",
    """This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.""",
    """http://org.openapitools""",
    """team@openapitools.org""",
    """Apache-2.0""",
    """http://www.apache.org/licenses/LICENSE-2.0.html""")
}
