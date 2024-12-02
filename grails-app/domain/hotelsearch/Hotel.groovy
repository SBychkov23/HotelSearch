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
    String uniqueCheck

    static constraints = {
        hotelName size: 1..255, blank: false
        country blank: false
        hotelRating min: 1, max: 5, blank: false
        webSite blank:true//, validator: { site -> (site.startsWith("http")||site.isNull())}
    }

    Hotel(LinkedHashMap<String, Object> stringObjectLinkedHashMap) {
        for (String property: stringObjectLinkedHashMap.keySet())
        {
            switch (property)
            {
                case "hotelName":
                    this.hotelName = stringObjectLinkedHashMap.get(property)
                case "country":
                    this.country = stringObjectLinkedHashMap.get(property)
                case "hotelRating":
                    this.hotelRating = stringObjectLinkedHashMap.get(property)
                case "webSite":
                this.webSite = stringObjectLinkedHashMap.get(property)
            }
            uniqueCheck = new String(hotelName+country.toString())
        }
    }

    String toString()
{
    hotelName
}
}
