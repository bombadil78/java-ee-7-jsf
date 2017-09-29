# java-ee-7-jsf
Java EE 7 JSF 2.2 Sample Application to demonstrate the following concepts and technologies
* *gradle* as build-tool
* Deployment as WAR
* JSF 2.2 / Facelets with PrimeFaces
* Java CDI for Dependency Injection
* Authentication & Authorization
* JNDI for external data sources
* Test-driven development

Target deployment is on WildFly 11.0 application server.

This project uses Java CDI together with javax.enterprise.context scope annotations. 

## JavaServer Faces (JSF)
JavaServer Faces builds directly upon Java Servlet technology. A typical JSF application consists of the following components:
* Static web pages (XHMTL) with a set of tags
* A managed bean as a container-managed object providing data for the web page in form of properties and functions
* A web deployment descriptor (*web.xml*)
* Optional
  + Application configuration (*faces-config.xml*) to define page navigation and configure container-managed objects
  + Custom components like converters, validators, ...
  + Custom tags
   
### Passing form data
The static web page must contain a EL reference to a backing bean. Example: 
```
// <input type="text"> data
<h:form>
    <h:inputText value="#{backingBean.someProperty}" />
    <h:commandButton value="someButtonText" action="#{backingBean.someMethod}" />
</h:form>
```

The backing bean must be annotated with *@javax.inject.Named* and any of the *javax.enterprise.context* annotations:
- *@RequestScoped*: Scoped during a single HTTP request
- *@SessionScoped*: Scoped during the user's session
- *@ApplicationScoped*: Shared across all users's interactions, scoped by the application server deployment
- *@Dependent*
- *@ConversationScoped*

### Data Tables
A *<h:dataTable>*-Tag is used to represent tables. The tag offers the following attributes:
- value: EL-expression of the data, e.g. *#{someBackingBean.someList}*
- var: Name of variable for iterating over the table content
- CSS styling attributes: styleClass, headerClass or rowClasses

Nested inside the tag is *<h:column>* as the table data content

