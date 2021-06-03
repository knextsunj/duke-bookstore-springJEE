# duke-bookstore-springJEE

This is a repository containing a modified version of the Java EE 8 Duke's Book Store application. This has been modified to run in MariaDB and use Spring as an overlay on top of the Java EE backend layer.

Specifically, there is an spring bean called BookService which serves as a facade to the BookRequestBean stateful session bean. The JSF version used is 2.2 and the managed beans are CDI beans.

To inject the spring facade into JSF managed beans, which are essentially CDI beans, producer methods are used and the spring bean is retrieved through application context dependency lookup. To satisfy the injection point from a CDI perspective, a custom annotation @BookServiceBean is used.

