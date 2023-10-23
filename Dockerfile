# Use the Railway base image for your Java application
FROM railwayapp/openjdk:17.0.1 as build

WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN chmod -R 777 ./mvnw

RUN ./mvnw install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Use Railway's recommended volume setup
RUN mkdir -p /railway/persistent
COPY --from=build /workspace/app/target/dependency /railway/persistent

# Define your final image
FROM railwayapp/openjdk:17.0.1

ARG DEPENDENCY=/railway/persistent

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java", "-cp", "app:app/lib/*", "com.example.emart.EmartApplication"]
