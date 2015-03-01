import com.theconnman.Role
import com.theconnman.User
import com.theconnman.UserRole

class BootStrap {
	
	def createUser(name, password, role) {
		def me = new User(username: name, password: password, enabled: true).save()
		UserRole.create(me, role, true)
	}

    def init = { servletContext ->
		def loc = ['../UserConfig.groovy', 'webapps/ROOT/Jenkins.groovy'].grep { new File(it).exists() }.first();
		def localConfig = new ConfigSlurper().parse(new File(loc).toURI().toURL());
		
		println 'Bootstrapping'
		new Role(authority: "ROLE_ADMIN").save();
		new Role(authority: "ROLE_USER").save();
		
		localConfig.zwegersmel.users.each {
			createUser(it.username, it.password, Role.findByAuthority(it.role));
		}
    }
	
    def destroy = {
		
    }
}
