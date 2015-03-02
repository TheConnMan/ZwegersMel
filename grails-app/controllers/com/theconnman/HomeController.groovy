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
	
	def reviews() {
		[reviews: Review.findAllByApproved(true, [mae: 5, sort: 'createdDate'])]
	}
	
	def submitReview() {
		Review review = new Review(
			title: params.title,
			content: params.content,
			createdDate: new Date(),
			stars: params.stars
		)
		if (params.author) {
			review.author = params.author;
		}
		review.save();
		sendMail {
			to grailsApplication.config.contact.email
			from grailsApplication.config.contact.email
			subject 'Review - ' + params.title
			html "There is a new review to approve located " + g.link(controller: 'review', action: 'show', id: review.id, absolute: true, 'here') + "."
		}
		flash.message = "Your review has been submitted for approval, thank you for your comment."
		redirect(action: 'reviews')
	}
}
