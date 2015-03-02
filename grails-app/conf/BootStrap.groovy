import com.theconnman.Event
import com.theconnman.Role
import com.theconnman.User
import com.theconnman.UserRole
import grails.converters.JSON

class BootStrap {
	
	def grailsApplication
	
	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}

	def init = { servletContext ->
		def loc = ['../UserConfig.groovy', 'webapps/ROOT/Jenkins.groovy'].grep { new File(it).exists() }.first();
		def localConfig = new ConfigSlurper().parse(new File(loc).toURI().toURL());
		
		println 'Bootstrapping'
		if (Role.count() == 0) {
			new Role(authority: "ROLE_ADMIN").save();
			new Role(authority: "ROLE_USER").save();
			
			localConfig.zwegersmel.users.each {
				createUser(it.username, it.password, Role.findByAuthority(it.role));
			}
			
			JSON.parse(grailsApplication.mainContext.getResource('data/Events.json').file.text).each { event ->
				new Event(
					name: event.name,
					date: event.date,
					startDate: Date.parse('MM/dd/yyyy HH:mm', event.start),
					endDate: Date.parse('MM/dd/yyyy HH:mm', event.end),
					venue: event.venue,
					location: event.location
				).save();
			}
		}
    }
	
    def destroy = {
		
    }
}
