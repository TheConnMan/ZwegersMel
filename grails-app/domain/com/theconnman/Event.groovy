package com.theconnman

class Event {
	
	String name
	String date
	Date startDate
	Date endDate
	String venue
	String location

    static constraints = {
		name()
		date()
		startDate()
		endDate()
		venue()
		location nullable: true
    }
}
