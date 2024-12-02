package hotelsearch

//import grails.rest.Resource
//
//@Resource(uri='/Hotel')
class Hotel {

    String hotelName
    Country country
    static belongsTo =  Country
    Integer hotelRating
    String webSite

    static constraints = {
        hotelName size: 1..255, blank: false, unique: 'country'
        country blank: false
        hotelRating min: 1, max: 5, blank: false
        webSite blank:true, nullable:true, validator: { site -> (site==null)||site.startsWith("http")}

    }

    String toString()
{
    hotelName
}
}
