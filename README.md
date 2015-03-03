# web-app
Is a default spring 4 webapp with a test contoller wich maps to a view jsp
Jackson is added for json processing.
using spring-hateoas for resource binding

To start: mvn tomcat:run to run webapp
Controller located at: /rest/blog-entries/{blogEntryId}
Language is json. 

TODO:
Replace jsp view for angularJS using REST
https://www.youtube.com/watch?v=hTQ8w1ohWoU

For this app I installed:
	- node-js http://nodejs.org/
	- gruntjs http://gruntjs.com/getting-started
	- bower http://bower.io/
	
Uses NG boilerplate: https://github.com/ngbp/ngbp (and placed in the webapp/app directory)

use the command: grunt watch throug commandline in webapp/app directory of the project. it recompiles changes in javascript to the /build directory. (which is mapped as static resource in the mvc spring config. <mvc:resource ....)