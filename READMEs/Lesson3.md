# Lesson 3

## Hibernate - Relationship mapping

As we have learned, there are 3 different types of relationships between tables:
* One to many (student -|-----0|< student_grades)
* One to one (student -|-----|- student_pictures)
* Many to many (courses >0|--------0|< grades)

We have also learned that over 99% of the time, we use one to many mapping, 
and the others are basically exceptions to rules and you should use them with caution.

### This is the place where you'll also understand why creating an ERD schema was good

#### One-to-many relationship
Lets start off with the most common relationship, one-to-many. This relationship describes when
"something" or "someone" has a lot of "something". Here are some examples:
* Teacher has a lot of courses
* Student has a lot of grades
* Car has a lot of parts
* Customer has a lot of bookings

Lets take the last example, and explain it a bit further:

A customer can have 0, 1 or many bookings. But a booking always has to belong to a customer.
We can not have a booking that does not belong to any customer.

When you look it at the booking side, that's called a *many-to-one* relationship.
These actually mean the same thing, one-to-many or many-to-one, the only difference
is from which side you look at it. (Many bookins can belong to one customer) vs (One customer can
have many bookings).

Lets create our two entities:

```
@Entity
public class Customer {
    @Id
    private Long id;
}

@Entity
public class Booking {
    @Id
    private Long id;
    
    private Long customerId;
}
```

Notice how we don't give the Customer class the field `booking_ids`. This is because
now we can tell Hibernate that our Customer objects will have many bookings.

So we want our Customer objects to have a List of bookings.

```
@OneToMany
private List<Booking> bookings;
```

Only using `@OneToMany` is sadly not enough, because we also have to tell Hibernate
where to find those bookings. This is where the `@JoinColumn` annotation comes in.

```
@OneToMany
@JoinColumn(name = "booking_id", referencedColumnName = "id")
private List<Booking> bookings;
```

This will now give us access to all Customer bookings which have the same customerId
for which we are searching the bookings for.

More technically, this will tell Hibernate to search for all rows in the database
which have the foreign key customer_id set to our customer id.

Now, we added the `@OneToMany` annotation to the Customer class, but Hibernate also wants us to
add the opposite annotation to the other class.

```
public class Booking {
    @Id
    private Long id;

    @ManyToOne
    private Customer customer;
}
```
Notice how we replaced the `Long customerId` with the actual Customer object.

Hibernate only allows us to do it when we are using the annotations correctly.
If we had not written `@ManyToOne` on this object, then Hibernate would fail.


#### TASK

Look at your ERD schema, then open your Entity classes and define all the
`@OneToMany`, `@JoinTable` and `@ManyToOne` relations like I have specified before.