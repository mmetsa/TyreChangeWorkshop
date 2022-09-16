# Lesson 4

## Spring Boot application structure

As you have learned, Spring Boot tries to follow the next pattern:

* Presentation Layer
* Business Layer
* Persistence Layer
* Database Layer

Let's start from the top and try to explain them:

1. <b>Presentation layer</b>

We are using Spring Boot to create REST API's. That means we are creating a backend service
which allows other Front-end applications to access and use data through HTTP requests.
If we want to grant access to some kind of data with Spring Boot, we need to create Controller classes
where we expose some kind of data. 

This data is visible to everyone who has access to that controller, that's why the Controller layer 
is also called the Presentation Layer. We are <b>presenting</b> data to someone else in some form.

2. <b>Business layer</b>

Usually, applications do more than just present data. Think about it, how boring would it be to
have a Facebook where you can't write any posts, an Instagram where you can't like any pictures
or a Spotify where you can't add any songs to your playlist.

This is why our applications have a business logic layer. This layer is where the magic happens.
Everything that needs to be calculated, fetched from some external service, changed or whatever else,
is done in this layer. For example, if we had a web store, this is where we would sort out the most
relevant products for a customer.

The business logic layer for new applications tends to be mostly empty. That's because they don't have
a lot of functionality built in yet. But don't worry, over time, this layer will become the largest
layer of them all.

In Spring Boot, we define Business Layer classes with the annotation @Service.

3. <b>Persistence Layer</b>

Most large projects need some sort of database. When using the systems, clients / customers usually
want their data to be saved, so they don't have to re-enter all their data again.

The role of the Persistence Layer is simple - save, fetch, update data! You wouldn't want to hire 
someone to create SQL queries every time some user uses your application, would you?

In Spring Boot, we are using Hibernate for the Persistence Layer. There are many other options, but
since Hibernate works very well with Spring Boot, and is used widely, we opted for that choice.

In Spring Boot, the Persistence Layer classes are annotated with @Repository

4. <b>Database Layer</b>

Of course, the Persistence Layer does not work without an actual database. For that we are using
PostgreSQL.

This does not actually have anything to do with Spring Boot directly, but since we need a database,
we can also say we are using the database layer.


#### But why do we need all those 'Layers'?

Good question! Let's think about it. What if we just put all our code inside one big Java class?

First thing's first - That Java class would be massive! How would you find anything?

Secondly, lets think about some layers. If we didn't have the Persistence Layer, we would have to 
write SQL manually inside the code. By now we have learned, that different databases have different
syntax's. What if in the middle of the project we had to replace our PostgreSQL with MySQL?
That would mean we would have to look through all SQL queries and update them... Doesn't sound fun

Third - Separating all the layers allows us to easily change parts of our code.
Let's say we have a new customer, but they don't like REST API's, they want SOAP.
If we have separated the Presentation Layer, we can just swap that out with a new one,
which instead of REST API's gives out SOAP API's, then it's all done. Little to 
no work on other layers.

#### Spring Boot application packages

Now, since we are dividing our application in different layers, we should probably also divide those
Java classes into separate packages.

The simplest way to do that is just like we did with our layers:

* Controller package - holds our Presentation Layer
* Service package - holds our Business Logic Layer
* Repository package - holds our Persistence Layer

#### Spring Boot Controllers

As I mentioned before, we need to map the Presentation Layer with the @Controller annotation.
If we are dealing with just REST API's (which are the de facto standard in 2022), this annotation
should actually be @RestController. This tells Spring Boot that our Presentation Layer
is only returning data that conforms with the REST API specification. Here's an example:

```
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello";
    }
}
```

#### Spring Boot Services

Services are easy - we just give them the @Service annotation!

```
@Service
public class DemoService() {

    public String getHello() {
        return "Hello";
    }
}
```

#### Spring Boot Repositories

Now with Hibernate, repositories get a bit trickier. In Spring Boot, we give the repositories the
@Repository annotation, but if we want to use the full power of Hibernate, we should also extend
the JpaRepository class. The class is type-safe, but we need to specify, what type of Entities
this Repository deals with, so Hibernate can do its magic.

```
@Repository
public class DemoRepository extends JpaRepository<DemoEntity, Long> {
}
```

Here, the `DemoEntity` tells JpaRepository what kind of Entity objects this Repository deals with.
The `Long` tells JpaRepository what is the type of the Primary key in that DemoEntity object.
If `DemoEntity` had a Primary Key with type `Integer` then it should be

```
... extends JpaRepository<DemoEntity, Integer>
```

### TASK

1. Create your Persistence Layer
2. Create your Business Layer
3. Create your Presentation Layer

<b>NB!</b> Make sure your layers are separated into packages!