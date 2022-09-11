# Lesson 1

## Changing your development profile
Profiles are a core feature of the framework — allowing us to map our beans to different profiles — for example, dev, test, and prod.

Profiles allow us to modify how our application works in different environments.

For example, you might have a development database, a testing database and a production database. When you want to run
your application against the development database, you can run your Spring Boot application with the dev profile
activated so that the connection is done to the development database. When you want to test something out with the
testing environment database, you can just switch your profile to test, and the application will connect to the testing
database.

As you know, Spring has a file named "application.properties" where you can configure a lot of things, like for example
the database connection.

If you want different configuration values for different environments / profiles, you need to create multiple property
files.

The way you can create multiple configurations is as follows:

```
application-{profile name}.properties
```

So if you have dev, test and prod profiles, you will have the following files:

```
application-dev.properties // for development profile
application-test.properties // for testing profile
application.properties // The default one, for production profile
```

One more thing to note is that you do not have to duplicate the configuration of dev / test profiles with the default
profile. Any configuration that is in the default profile and is not in dev / test profile will still be used.

### Task

Create property files for dev and test profiles. For the development profile, add your database connection details.
Run your Spring Boot project with the dev profile active, and verify that the database connection is not failing.
Then change the dev profile to test or production, and verify that the database connection is now failing.