class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/"(controller:'home')
		"/book"(controller:'home', action: 'book')
		"/about"(controller:'home', action: 'about')
		"/events"(controller:'home', action: 'events')
		"/contact"(controller:'home', action: 'contact')
		"/reviews"(controller:'home', action: 'reviews')
        "/controllers"(view:'/index')
        "500"(view:'/error')
		"404"(view:'/404')
	}
}
