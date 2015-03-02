package com.theconnman

class HomeController {
	
	def grailsApplication

    def index() { }

    def book() { }

    def about() { }

    def events() {
		[events: Event.findAllByEndDateGreaterThan(new Date(), [max: 10, sort: 'startDate'])]
	}

    def contact() { }
	
	def submitContact() {
		Message message = new Message(
			name: params.name,
			email: params.email,
			date: new Date(),
			comment: params.comment
		).save();
		sendMail {
			to grailsApplication.config.contact.email
			from grailsApplication.config.contact.email
			cc params.email
			subject 'Contact - ' + params.name
			text params.comment
		}
		flash.message = "Your message has been sent, thank you for your comment."
		redirect(action: 'contact')
	}
}
