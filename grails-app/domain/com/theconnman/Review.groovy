package com.theconnman

class Review {
	
	String title
	String content
	Date createdDate
	int stars
	String author = 'Anonymous'
	boolean approved = false

    static constraints = {
		title()
		content maxSize: 500
		createdDate()
		stars min: 1, max: 5
		author()
		approved()
    }
}
