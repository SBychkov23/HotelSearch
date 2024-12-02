package hotelsearch

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {
    CountryService  countryService
    HotelService hotelService

    def init = { servletContext ->
        countryService.save(new Country(countryName:"Russia",capitalName: "Moscow"))
        countryService.save(new Country(countryName:"UK",capitalName: "London"))
        countryService.save(new Country(countryName:"USA",capitalName: "Washington DC"))
        countryService.save(new Country(countryName:"Brazil",capitalName: "Brazilia"))
        countryService.save(new Country(countryName:"China",capitalName: "Beijing"))
        countryService.save(new Country(countryName:"India",capitalName: "New Delhi"))
        countryService.save(new Country(countryName:"Germany",capitalName: "Berlin"))
        countryService.save(new Country(countryName:"Spain",capitalName: "Madrid"))
        countryService.save(new Country(countryName:"RSA",capitalName: "Pretoria"))
        countryService.save(new Country(countryName:"Egypt",capitalName: "Cairo"))
        countryService.save(new Country(countryName:"Australia",capitalName: "Canberra") )
        hotelService.save(new Hotel(hotelName: "Radisson Collection Hotel",country: countryService.get(1L), hotelRating: 3, webSite: "https://www.radissonhotels.com/"))
        hotelService.save(new Hotel(hotelName: "Hilton",country: countryService.get(2L), hotelRating: 4, webSite: "https://hilton.com"))
        hotelService.save(new Hotel(hotelName: "Hilton",country: countryService.get(3L), hotelRating: 5, webSite: "https://hilton.com"))
        hotelService.save(new Hotel(hotelName: "A-Hotel",country: countryService.get(3L), hotelRating: 1))
        hotelService.save(new Hotel(hotelName: "B-Hotel",country: countryService.get(3L), hotelRating: 2))
        hotelService.save(new Hotel(hotelName: "C-Hotel",country: countryService.get(3L), hotelRating: 3))
        hotelService.save(new Hotel(hotelName: "A-Hotel",country: countryService.get(4L), hotelRating: 3))
        hotelService.save(new Hotel(hotelName: "D-Hotel",country: countryService.get(3L), hotelRating: 4))
        hotelService.save(new Hotel(hotelName: "E-Hotel",country: countryService.get(3L), hotelRating: 5))
        hotelService.save(new Hotel(hotelName: "F-Hotel",country: countryService.get(3L), hotelRating: 1))
        hotelService.save(new Hotel(hotelName: "G-Hotel",country: countryService.get(3L), hotelRating: 2))
        hotelService.save(new Hotel(hotelName: "H-Hotel",country: countryService.get(3L), hotelRating: 2))
        hotelService.save(new Hotel(hotelName: "I-Hotel",country: countryService.get(3L), hotelRating: 2))
        hotelService.save(new Hotel(hotelName: "J-Hotel",country: countryService.get(3L), hotelRating: 2))
    }
    def destroy = {
    }
}
