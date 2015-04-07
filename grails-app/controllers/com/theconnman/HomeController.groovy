package com.theconnman

import grails.converters.JSON

class HomeController {
	
	def grailsApplication

    def index() { }

    def book() {
		[images: ['Fairy_Doors.jpg', 'Tree.jpg', 'Tea_Time.jpg']]
	}

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
		);
		message.save();
		if (!message.hasErrors()) {
			sendMail {
				to grailsApplication.config.contact.email
				from grailsApplication.config.contact.email
				subject 'Contact - ' + params.name + ', ' + params.email
				text params.comment
			}
			flash.message = "Your message has been sent, thank you for your comment."
		} else {
			flash.message = "Your comment was not submitted, please enter a title, an email address, and a message."
			flash.params = params;
			flash.error = true;
		}
		redirect(action: 'contact')
	}
	
	def reviews() {
		[reviews: Review.findAllByApproved(true, [max: 10, sort: 'createdDate', order: 'desc'])]
	}
	
	def submitReview() {
		Review review = new Review(
			title: params.title,
			content: params.content,
			createdDate: new Date()
		)
		if (params.author) {
			review.author = params.author;
		}
		review.save();
		if (!review.hasErrors()) {
			sendMail {
				to grailsApplication.config.contact.email
				from grailsApplication.config.contact.email
				subject 'Review - ' + params.title
				html "There is a new review to approve located " + g.link(controller: 'review', action: 'show', id: review.id, absolute: true, 'here') + "."
			}
			flash.message = "Your review has been submitted for approval, thank you for your comment."
		} else {
			flash.message = "Your review was not submitted, please enter a title and a comment body."
			flash.params = params;
			flash.error = true;
		}
		redirect(action: 'reviews')
	}
}
