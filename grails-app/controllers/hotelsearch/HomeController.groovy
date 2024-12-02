package hotelsearch

class HomeController {

    CountryService countryService
    HotelService hotelService

    Country emptyCountryField = new Country(countryName: "Все страны", capitalName: "empty")


    def index(Integer max) {
        params.max =  10
        List<Country> countryListWithEmptyField = countryService.list()
        countryListWithEmptyField.add(0, emptyCountryField);
        respond countryListWithEmptyField,  model : [ 'showResults':null, 'results': hotelService.list(params), 'resultsNum': hotelService.list().size()]
    }

    def searchResults = {
        params.max =  10
        List<Country> countryListWithEmptyField = countryService.list()
        countryListWithEmptyField.add(0, emptyCountryField);
        def entryCriteria = Hotel.createCriteria()
        def results = entryCriteria.list (max: params.max, offset: params.offset) {
            if (params?.hotelName) {
                ilike("hotelName", "%${params.hotelName}%")
            }
            if (!params?.countryName.equals("Все страны"))
            {
                createAlias("country", "c")
                eq("c.countryName", params.countryName)
            }
        order("hotelRating", "desc")
            order("hotelName", "asc")
    }

    render(view : 'index',  model : [ 'results': results, 'resultsNum': results.getTotalCount(), 'showResults':1,
           'hotelName': params?.hotelName, 'countryList':countryListWithEmptyField, 'countryName': params?.countryName
           ])
    }

}



