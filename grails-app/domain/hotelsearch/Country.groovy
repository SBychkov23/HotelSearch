package hotelsearch

//import grails.rest.Resource
//
//@Resource(uri='/Country')
class Country {
    String countryName
    String capitalName
    static hasMany = [hotels: Hotel]

    static constraints = {
        countryName size:1..255, blank:false, unique: true
        capitalName size:1..128, blank:false, unique: true
    }
    String toString()
    {
        countryName
    }
}
