Grails Base
==========

A base Grails project to bootstrap rapid development projects. The project includes my favorite Grails plugins, JavaScript libraries, and default configurations.

# Includes

## Grails Plugins

- [Quartz](http://grails.org/plugin/quartz) - Job scheduling
- [Executor](http://www.grails.org/plugin/executor) - Background threading
- [Spring Security](http://grails.org/plugin/spring-security-core) - Basic Grails security

## Libraries

- [AWS Java SDK](http://aws.amazon.com/sdk-for-java/) -  AWS SDK

## JavaScript Libraries

- [Semantic UI](http://semantic-ui.com/) - Frontend styling framework
- [jQuery](http://jquery.com/) - JavaScript utility library
- [Sweet Alert](http://tristanedwards.me/sweetalert) - Beautiful JavaScript alert replacement

## Bootstrap

- Creates two default users **admin** and **user** with their respective roles

# Setup

## To Do

- Change package names
- Change default users and passwords

## UserConfig

Grails Base uses an external config file to load secrets into the application. By default the application looks in the folder above the project folder for a file named **UserConfig.groovy**