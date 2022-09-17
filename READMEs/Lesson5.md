# Lesson 5

## Mapstruct Mappings

Previously we talked about having different layers in our Spring Boot application. We know there's the Presentation Layer
and the Persistence Layer.

Very often we have very similar, or even exactly the same Java objects for the Persistence Layer and the Presentation Layer.
Let's look at an example:

```
@Entity
public class CustomerEntity {
    private Long id;
    private String name;
}
```

This model would be a part of our Persistence Layer. But we also need to give Customer information to our front-end 
applications. This is what that would look like:

```
public class Customer {
    private Long id;
    private String name;
}
```

So, they're exactly the same...? If they are the same, would it not make sense to just use one Java class instead of
two?

Actually, no. It does not make sense. It's because right now the example is simple, but what if we had a password field
in our CustomerEntity class? We would not want to send the Customer password to our front-end applications. Why?
Well, someone could see it, or there's also the problem with hackers, who can listen to all network activity and scan it.
All they would have to do is scan all network requests and filter them by "password" field.

So, now that we know that the Presentation Layer and Persistence Layer need to have different Java classes, lets look
at how to Map one of them to the other using the Mapstruct library (https://mapstruct.org/):

First of all, we need to add Gradle dependencies to start using the library:
<b>build.gradle</b> file
```
dependencies {
    ...
    ...
    // Mapper
    implementation 'org.mapstruct:mapstruct:1.5.2.Final'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.5.2.Final'
}
```

Now that we have the dependencies resolved, we can start creating new Mappers. As with other layers, the Mappers should
reside in a separate "mapper" package.

Here's an example of a Mapper, and an explanation of what all of it means:
```
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    WorkshopResponse toResponse(Workshop workshop);
}
```

Lets start off with the `@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)`

The `@Mapper` annotation tells Mapstruct that this Java class will be a Mapstruct Mapper. 
The `componentModel = "spring"` allows Spring Boot to find this Mapper class and automatically inject it in to other 
Spring components.
The `unmappedTargetPolicy = ReportingPolicy.IGNORE` tells the Mapper that if the target object does not have some fields
that the source object has, just ignore them.

And lastly, the `WorkshopResponse toResponse(Workshop workshop);` allows the Mapstruct library to create a new Mapping.
This means that now you are able to automatically convert `Workshop` objects into `WorkshopResponse` objects.

<b>NB!</b> This will only map all the fields that have the exact same name. If `Workshop` has the field `address` and
`WorkshopResponse` has the field `address`, this will be automatically mapped. But if the `Workshop` has the field `address`
and the `WorkshopResponse` has the field `workshopAddress`, then Mapstruct <b>does not</b> understand that they mean the
same thing and they will not be mapped!

To convert one field name to another one, like in the last example, we need one additional line:
```
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    @Mapping(source = "address", target = "workshopAddress")
    WorkshopResponse toResponse(Workshop workshop);
}
```

Here, the `@Mapping(source = "address", target = "workshopAddress")` line tells Mapstruct that `Workshop` has the field
`address` and it should be mapped to the field `workshopAddress` field of the `WorkshopResponse` object.

#### Mapping lists
Mapping lists is actually just as simple as mapping single objects. Mapstruct has this functionality built-in:

```
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    @Mapping(source = "address", target = "workshopAddress")
    List<WorkshopResponse> toListResponse(List<Workshop> workshops);
}
```

### When to use mappers

Usually mappers are used to map Entities into Response objects and also Request objects into Entities. Response objects
are the objects you are returning in your Presentation Layer. Request objects are the objects that you are taking as
input in your Presentation Layer. An example would be `WorkshopRequest`

### Using Mapstruct mappers in the Business Layer (Services)
All you have to do to use your Mapper in a service is to Inject it:
```
@RequiredArgsConstructor
public class WorkshopService {
    private final WorkshopMapper workshopMapper;
```
Then you can use this `workshopMapper` everywhere in your Service to map from Entity objects to Response objects and vice versa.
Example:
```
public WorkshopResponse getFirstWorkshop() {
    return workshopMapper.toResponse(repository.findById(1L));
}
```
### TASK

Create a mapper package and at least one Mapper class inside that package.
Create an Entity and a Response object like I did, for example `Workshop` and `WorkshopResponse`. Use the mapper to convert
the Entity to the Response object. Verify that the Mapper works and converts the objects.

Also try to use different field names (like `address` in Entity and `workshopAddress` in Response) and add the custom
`@Mapping(....)` to the mapper to see if it works if the field names are different.

<b>NB!</b> You can have multiple `@Mapping(....)` lines in front of the mapping method! Example:

```
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkshopMapper {
    @Mapping(source = "address", target = "workshopAddress")
    @Mapping(source = "name", target = "fullName")
    WorkshopResponse toResponse(Workshop workshop);
}
```