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

#include "StoreApi.h"

namespace io {
namespace swagger {
namespace server {
namespace api {

using namespace io::swagger::server::model;

StoreApi::StoreApi(Pistache::Address addr)
    : httpEndpoint(std::make_shared<Pistache::Http::Endpoint>(addr))
{ };

void StoreApi::init(size_t thr = 2) {
    auto opts = Pistache::Http::Endpoint::options()
        .threads(thr)
        .flags(Pistache::Tcp::Options::InstallSignalHandler);
    httpEndpoint->init(opts);
    setupRoutes();
}

void StoreApi::start() {
    httpEndpoint->setHandler(router.handler());
    httpEndpoint->serve();
}

void StoreApi::shutdown() {
    httpEndpoint->shutdown();
}

void StoreApi::setupRoutes() {
    using namespace Pistache::Rest;

    Routes::Delete(router, base + "/store/order/:orderId", Routes::bind(&StoreApi::delete_order_handler, this));
    Routes::Get(router, base + "/store/inventory", Routes::bind(&StoreApi::get_inventory_handler, this));
    Routes::Get(router, base + "/store/order/:orderId", Routes::bind(&StoreApi::get_order_by_id_handler, this));
    Routes::Post(router, base + "/store/order", Routes::bind(&StoreApi::place_order_handler, this));

    // Default handler, called when a route is not found
    router.addCustomHandler(Routes::bind(&StoreApi::store_api_default_handler, this));
}

void StoreApi::delete_order_handler(const Pistache::Rest::Request &request, Pistache::Http::ResponseWriter response) {
    // Getting the path params
    auto orderId = request.param(":orderId").as<std::string>();
    
    try {
      this->delete_order(orderId, response);
    } catch (std::runtime_error & e) {
      //send a 400 error
      response.send(Pistache::Http::Code::Bad_Request, e.what());
      return;
    }

}
void StoreApi::get_inventory_handler(const Pistache::Rest::Request &request, Pistache::Http::ResponseWriter response) {

    try {
      this->get_inventory(response);
    } catch (std::runtime_error & e) {
      //send a 400 error
      response.send(Pistache::Http::Code::Bad_Request, e.what());
      return;
    }

}
void StoreApi::get_order_by_id_handler(const Pistache::Rest::Request &request, Pistache::Http::ResponseWriter response) {
    // Getting the path params
    auto orderId = request.param(":orderId").as<int64_t>();
    
    try {
      this->get_order_by_id(orderId, response);
    } catch (std::runtime_error & e) {
      //send a 400 error
      response.send(Pistache::Http::Code::Bad_Request, e.what());
      return;
    }

}
void StoreApi::place_order_handler(const Pistache::Rest::Request &request, Pistache::Http::ResponseWriter response) {

    // Getting the body param
    Order order;
    
    try {
      nlohmann::json request_body = nlohmann::json::parse(request.body());
      order.fromJson(request_body);
      this->place_order(order, response);
    } catch (std::runtime_error & e) {
      //send a 400 error
      response.send(Pistache::Http::Code::Bad_Request, e.what());
      return;
    }

}

void StoreApi::store_api_default_handler(const Pistache::Rest::Request &request, Pistache::Http::ResponseWriter response) {
    response.send(Pistache::Http::Code::Not_Found, "The requested method does not exist");
}

}
}
}
}

