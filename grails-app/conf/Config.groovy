// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination

def loc = ['../UserConfig.groovy', 'webapps/ROOT/Jenkins.groovy'].grep { new File(it).exists() }.first();
def localConfig = new ConfigSlurper(grailsSettings.grailsEnv).parse(new File(loc).toURI().toURL())

// The ACCEPT header will not be used for content negotiation for user agents containing the following strings (defaults to the 4 major rendering engines)
grails.mime.disable.accept.header.userAgents = ['Gecko', 'WebKit', 'Presto', 'Trident']
grails.mime.types = [ // the first one is the default format
    all:           '*/*', // 'all' maps to '*' or the first available format in withFormat
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    hal:           ['application/hal+json','application/hal+xml'],
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.resources.adhoc.excludes = ['/WEB-INF/**']

// Legacy setting for codec used to encode data with ${}
grails.views.default.codec = "html"

// The default scope for controllers. May be prototype, session or singleton.
// If unspecified, controllers are prototype scoped.
grails.controllers.defaultScope = 'singleton'

// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside ${}
                scriptlet = 'html' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        // filteringCodecForContentType.'text/html' = 'html'
    }
}

 
grails.converters.encoding = "UTF-8"
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

grails {
	plugin {
		databasebackups {
			bucket = localConfig.zwegersmel.databasebackups.bucket
		}
	}
}

environments {
    development {
        grails.logging.jul.usebridge = true
		contact.email = 'brian@theconnman.com'
        grails.serverURL = "http://localhost:8080"
		grails.plugin.databasebackups.on = false
    }
    devdeploy {
        grails.logging.jul.usebridge = false
		contact.email = 'contact@melaniemzwegers.com'
        grails.serverURL = "http://dev.melaniemzwegers.com"
		grails.plugin.databasebackups.filename = '-zwegersmel-dev'
    }
    production {
        grails.logging.jul.usebridge = false
		contact.email = 'contact@melaniemzwegers.com'
        grails.serverURL = "http://melaniemzwegers.com"
		grails.plugin.databasebackups.filename = '-zwegersmel'
    }
}

grails {
	mail {
		host = "email-smtp.us-east-1.amazonaws.com"
		port = 465
		username=localConfig.theconnman.aws.ses.username
		password=localConfig.theconnman.aws.ses.password
		props = [
			"mail.smtp.auth": "true",
			"mail.smtp.socketFactory.port": "465",
			"mail.smtp.socketFactory.class":  "javax.net.ssl.SSLSocketFactory",
			"mail.smtp.socketFactory.fallback": "false"
		]
	}
}
grails.mail.default.from = "brian@theconnman.com"

// log4j configuration
log4j = {
    // Example of changing the log pattern for the default console appender:
    //
    //appenders {
    //    console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
    //}

    error  'org.codehaus.groovy.grails.web.servlet',        // controllers
           'org.codehaus.groovy.grails.web.pages',          // GSP
           'org.codehaus.groovy.grails.web.sitemesh',       // layouts
           'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
           'org.codehaus.groovy.grails.web.mapping',        // URL mapping
           'org.codehaus.groovy.grails.commons',            // core / classloading
           'org.codehaus.groovy.grails.plugins',            // plugins
           'org.codehaus.groovy.grails.orm.hibernate',      // hibernate integration
           'org.springframework',
           'org.hibernate',
           'net.sf.ehcache.hibernate'
}

grails.app.context = '/'

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.theconnman.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.theconnman.UserRole'
grails.plugin.springsecurity.authority.className = 'com.theconnman.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	'/**':								['permitAll']
]

grails.plugin.springsecurity.logout.postOnly = false