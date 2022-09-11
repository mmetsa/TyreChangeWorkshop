# Lesson 2

## Hibernate
Now that we have created our database schema, it is time to create our POJO-s and use Hibernate for our object-relational
mappings.

For our mappings to work, we need to have java classes that have fields which correspond to our database tables.

A good practise is to have these classes inside the "model" or "entity" package. The package naming is not important, but
it's just a convention.

### Task

* Create a "model" or "entity" package
* Create Java classes with the same names as your database tables
* Assign fields to your newly created classes, the same fields as your database tables have

_Some notes:_
* Use Lombok's @Data annotation for your constructors, getters and setters
* All fields should be private

## Hibernate's annotations
Hibernate does its magic through reading your annotations like @Entity. You can find most of these
from https://www.tutorialspoint.com/hibernate/hibernate_annotations.htm

#### @Entity
@Entity is the most important annotation, as this needs to be on top of every class that you are going
to use as a Hibernate entity. Without this, Hibernate will think this class is not for mapping the database table to
a Java object.

#### @Table
@Table is the next important annotation. Often your database table naming convention will differ from your Java class
naming convention, and that's where this annotation comes in handy. With this annotation, you can specify, what the name
of your database table is.
For example, your database table name might be "customer", but your Java class name is "Customer". Without the annotation

```
@Table(name="customer")
```

Hibernate will try to find the table "Customer" in your database, but because table names are Case-sensitive, it will
fail, therefore your program will also produce an error.

#### @Id
The next important annotation is @Id.

When you are defining some Java class as an @Entity, there needs to be a field in this class with the @Id annotation.
This annotation marks the field which will be the Primary Key in the database. So basically, you always give your id
field the @Id annotation.

ID field values are usually always generated automatically by the database (serial data type in Postgres), and for that
Hibernate has the option to mark ID fields with another annotation:

```
@GeneratedValue(strategy = GenerationType.IDENTITY)
```
Using this annotation on your ID fields means that Hibernate will validate that the ID field is given a value automatically
by the database engine.

#### @Column
The @Column annotation is good for when your database field names are not exactly the same as your Java class field names.

This is used almost everywhere, since the database naming convention usually suggests snake_case_naming for fields, whereas
the Java field naming convention suggests camelCaseNaming

So, for example, a database field `first_name`

would have the following Hibernate annotation:

```
@Column(name = "first_name")
private String firstName;
```

This way Hibernate will know that the field `first_name` is going to be mapped to the Java field `firstName`.

_NB!_

If the field names match exactly, for example for a field like `email`, then you do not need to add the `@Column`
annotation, but I suggest you still do it for every field in your Java classes!