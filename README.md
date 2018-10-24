# To demonstrate the usage of spring @Transaction
There is a class `BookService`, with two methods, `transactionalMethod()` and `nonTransactionalMethod()`. `nonTransactionalMethod()` will call to `transactionalMethod()`, and you are surprised when called by `nonTransactionalMethod()`, `transactionalMethod()` also becomes non-transactional. You can run the two test cases in `BookServiceTest`.

Reason being, let's say this is `BookService`
![BookService](class.jpg)

When it is being `@Autowired` it to another class eg: `BookServiceTest`, what's being kept in `BookServiceTest` is a proxied `BookService` like below
![Proxied BookService](spring-proxy.jpg)

When `BookServiceTest` calls `BookService`, it will first go to spring proxy, spring proxy finds `@Transactional` annotation in the method, then spring proxy will create the transaction, and commit/rollback the transaction when method exits.
![Transactional](annotation-method.jpg)

Whereas when `transactionalMethod()` being called from `nonTransactionalMethod()`, because `transactionalMethod()` was not called within spring proxy, therefore `@Transactional` magic didn't happen. Like below:
![Internal method](without-annotation-method.jpg)
