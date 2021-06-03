# duke-bookstore-springJEE

This is a repository containing a modified version of the Java EE 8 Duke's Book Store application. This has been modified to run in MariaDB and use Spring as an overlay on top of the Java EE backend layer.

Specifically, there is an spring bean called BookService which serves as a facade to the BookRequestBean stateful session bean. The JSF version used is 2.2 and the managed beans are CDI beans.

To inject the spring facade into JSF managed beans, which are essentially CDI beans, producer methods are used and the spring bean is retrieved through application context dependency lookup. To satisfy the injection point from a CDI perspective, a custom annotation @BookServiceBean is used.

This application has been tested on the following environment:

Payara 5.193
<br>
MariaDB 10.3
<br>
Debian OpenJDK 8

From the admin console of Payara Server create a new JDBC connection pool called bookstore-pool with the following properties:

Resource Type: javax.sql.DataSource
Datasource Classname: org.mariadb.jdbc.MariaDbDataSource
Initial and Minimum Pool Size:8
Maximum Pool Size: 32
Pool Resize Quantity: 2
Idle Timeout: 300
Max Wait Time: :60000

Then create a JDBC resource called jdbc/bookstore with the following:
Pool Name: bookstore-pool
Description: BookStore DataSource DB Resource

Once the JDBC connection pool and resource are created checkout the code and explore. The persistence.xml is already setup for the above resource.
	
You can use any IDE, I have used Eclipse.

