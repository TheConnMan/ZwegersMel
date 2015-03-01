package com.theconnman

class HomeController {

    def index() { }

    def book() { }

    def about() { }

    def events() {
		[events: Event.findAllByEndDateGreaterThan(new Date(), [max: 10, sort: 'startDate'])]
	}
}
