package hotelsearch

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

       // "/"(controller: "Home", view:"/index" )
        "/"(controller: "Home", action: "index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
