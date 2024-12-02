package hotelsearch

class HomeController {

    CountryService countryService

    Country emptyCountryField = new Country(countryName: "Все страны", capitalName: "empty")


    def index(Integer max) {
        List<Country> countryListWithEmptyField = countryService.list()
        countryListWithEmptyField.add(0, emptyCountryField);
        respond countryListWithEmptyField
    }

    def searchResults = {
        List<Country> countryListWithEmptyField = countryService.list()
        countryListWithEmptyField.add(0, emptyCountryField);
        def entryCriteria = Hotel.createCriteria()
        def results = entryCriteria.list {
            if (params?.hotelName) {
                ilike("hotelName", "%${params.hotelName}%")
            }
            if (!params?.countryName.equals("Все страны"))
            {
                createAlias("country", "c")
                eq("c.countryName", params.countryName)
            }

        order("hotelRating", "desc")
    }


    render(view : 'index',  model : [ 'results': results,
           'hotelName': params?.hotelName, 'countryList':countryListWithEmptyField, 'countryName': params?.countryName
           ])


 }
}


