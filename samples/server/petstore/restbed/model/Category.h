/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator 3.0.0-SNAPSHOT.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/*
 * Category.h
 *
 * A category for a pet
 */

#ifndef Category_H_
#define Category_H_



#include <string>
#include <memory>

namespace io {
namespace swagger {
namespace server {
namespace model {

/// <summary>
/// A category for a pet
/// </summary>
class  Category
{
public:
    Category();
    virtual ~Category();
    
    std::string toJsonString();
    void fromJsonString(std::string const& jsonString);

    /////////////////////////////////////////////
    /// Category members
    
    /// <summary>
    /// 
    /// </summary>
    int64_t getId() const;
    void setId(int64_t value);
    /// <summary>
    /// 
    /// </summary>
    std::string getName() const;
    void setName(std::string value);

protected:
    int64_t m_Id;
    std::string m_Name;
};

}
}
}
}

#endif /* Category_H_ */
