# opaque-connector

A connector between Moodle (Opaque plugin) and the etutor-plus-plus, for the exam mode.
This connector helps to import questions from the etutor++ (platform) into moodle and forwards submissions to etutor++ for grading.

This application is realized as a Spring Boot project with REST endpoints.

# Development
There are only some configurations in the [properties-file](./src/main/resources/application.properties) required:


```properties
# The connection details to the etutor++ (platform)
# Authentication is conducted with the given user
ETPPUSER=
ETPPPASSWORD=

# Flag indicating if quotation marks in submissions should be replaced, and replacement.
# Might be required because the Safe Exam Browser in combination with MAC limits the student to weird quotation marks, that may not be compatible with the task-type.
REPLACE_QUOTATION_MARK=true
REPLACEMENT_FOR_QUOTATION_MARK='
```


# Building

```
mvn clean install -DskipTests
```

# Usage
Configuration in Moodle, given the Opaque plugin, can be achieved like this:
![image](https://user-images.githubusercontent.com/52571862/215507018-1abbc247-c3a2-45af-9bc1-48657e2f8587.png)

**Note: question engine refers to the url of this application, whereas question bank refers to the url of the etutor++ (platform), 
from the view of this application, when running and deployed.**




*Contact brandl@dke.uni-linz-ac.at to receive the bachelor thesis and the user-guide supporting this project




