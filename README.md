# Best Practices of a Microservice Architecture with Spring Cloud, Angular, CI, CD and IaC

This repository is Dealer Management Systems based on a microservices architecture.

The architecture supports the following technologies:

* Frameworks - Spring Boot, Spring Cloud, Feign, Eureka, Resilience4j.
* UI - Angular to build as a web app or hybrid app (web + mobile)
* Databases - H2, MySQL, MariaDB, PostgreSQL, MongoDB
* API Management : Spring REST Docs, Swagger
* Security: JWT (JSON Web Token) with OIDC, OpenID Connect, OAuth 2.0 keycloak.
* Client Side - HTML5, Bootstrap, TypeScript, Angular, Angular.
* CI / CD - Jenkins, Travis CI, Github Workflows, Docker, Docker Compose, Kubernetes, Minikube, Minishift, OpenShift, Jenkins X, KOTS, ECS (Elastic Container Service), EKS (Elastic Kubernetes Service)

# The Key Requirements

* Maximize team autonomy.
* Optimize for development speed.
* Focus on automation (Automate everything).
* Provide flexibility without compromising consistency.
* Built for resilience.
* Simplified maintenance.
* Application portability.
* Application auto-scaling.
* Centralized platform administration.
* Centralized logging.
* Dynamic routing.
* Application health management.
* Integration with external logging components like Elasticsearch and Logstash.
* Role-based access for deployed applications.
* Provision for vertical and horizontal scaling.
* Infrastructure security.
* Support for various IaaS providers.

# Architecture

The following diagram shows the targert platform architecture.:

![App architecture diagram.png](assert%2Fscreenshot%2FApp%20architecture%20diagram.png)

Since a reservation management application uses the Microservice architecture pattern for Reservation details, data is spread over multiple services. For example,

- Resource service 
- Reservation service

# Using patterns

- Service Discovery & Service Registry : Eureka
- Load balancing : Spring Cloud Loadbalancer
- Reliability Circuit-breaking  and Fault-tolerance  :  Resilience4j, Istio, Service Mesh.
- API Gateway 	: Spring Cloud Gateway
- Externalized configuration  : Spring Cloud Config
- Failure- and latency-aware, load balancing, Cluster failover and Retry
- Distributed tracing : Spring Cloud Sleuth.
- Hexagonal Architecture (Ports and Adapters Pattern)
- Consumer Driven Contract : Spring Cloud Contract.
- Security : Access Token with Okta, Spring Cloud Security
- Observability :
    - Log aggregation : AWS Cloud Watch
    - Application metrics - instrument a service’s code to gather statistics about operations
    - Audit logging - record user activity in a database
    - Distributed tracing - Zipkin, Sleuth and ELK Stack
    - Exception tracking - Sentry, TrackJS, Raygun and Airbrake.
    - Health check API : EurekaClient, Spring Boot Admin and Spring Boot Actuator
    - Log deployments and changes : GitHub, AWS CloudTrail and LogDNA.
- Deployment patterns :
    - Service instance per Container - Dockerfile and DockerComposite
    - Serverless deployment - deploy a service using serverless deployment platform
    - Service deployment platform - deploy services using a highly automated deployment platform that provides a service abstraction
- Transactional messaging:
- Data management :
    - Database per Service - each service has its own private database
    - Domain event - publish an event whenever data changes
    - Event sourcing - persist aggregates as a sequence of events


## Building and running the application

This is a Maven project. However, you  need to have installed :
- Java Development Kit >= 21
- Angular "^17"
- Docker
- Maven
- Ansible
- Jenkins

The details of how to build and run the services depend slightly on whether you are using
- SaaS (Software as a Service)
- IaaS (Infrastructure as a service)
- PaaS (Platform as a Service)
- Local

## Building and running using SaaS

First, must sign up to get your credentials in order to get free access to the SaaS version.

Next, build the application

```
  $ git clone https://github.com/abderrahimJK/Spring_Boot_Angular_Dockerized_Secured_App.git
  $ cd Spring_Boot_Angular_Dockerized_Secured_App
  $ mvn install
```

Next, you can launch the services using Docker Compose:

```
 $ docker-compose up -d
```

# Modules:

- [x] config-service
- [x] discovery-service
- [x] gateway-service
- [x] config-repo
- [x] Resource-service
- [x] Reservation-service
- [x] application-ui-web
- [ ] application-ui-mobile
- [ ] Shell Scripts  files (startRabbit, startDevVault, set-local-env-git, install-letsencrypt-cert, create-services, create-release-branch)
- [ ] RabbitMq
- [ ] Kafka
- [ ] UI Angular
- [x] UI AngularJS
- [ ] CI / CD - Jenkins
- [ ] CI / CD - Github Workflows
- [ ] CI / CD - Travis CI
- [ ] CI / CD - Kubernetes (config, configmap, deployment, service, support-bundle, replicated-app)
- [ ] CI / CD - Docker, Docker Compose
- [ ] CI / CD - Jenkins X
- [X] Auth-server Keycloak 23.0.0
- [ ] IaC

# Important endpoints

Run locally with Maven, Visual Studio Code, STS, Eclipse or IntelliJ:

🎯 : Gateway http://localhost:8080  
🎯 : Consul Server Dashboard http://localhost:8500 
🎯 : Config Server http://localhost:9999  
🎯 : Resource service http://localhost:8081  
🎯 : Reservation service http://localhost:8082


## Spring Cloud Config Server

Spring Cloud Config Server offers the following benefits:

- HTTP resource-based API for external configuration (name-value pairs or equivalent YAML content)

- Encrypt and decrypt property values (symmetric or asymmetric)

- Embeddable easily in a Spring Boot application using @EnableConfigServer

## Spring Cloud Config Client

Spring Cloud Config Client lets you:

- Bind to the Config Server and initialize Spring Environment with remote property sources.

- Encrypt and decrypt property values (symmetric or asymmetric).

- @RefreshScope for Spring @Beans that want to be re-initialized when configuration changes.

Use management endpoints:

- /env for updating Environment and rebinding @ConfigurationProperties and log levels.
- /refresh for refreshing the @RefreshScope beans.
- /restart for restarting the Spring context (disabled by default).
- /pause and /resume for calling the Lifecycle methods (stop() and start() on the ApplicationContext).

Bootstrap application context: It binds to the Config Server and decrypts property values.

## Using the Swagger UI

The services are Swagger "enabled".

Open the url http://${DOCKER_HOST_IP}:<SERVICE-PORT>/swagger-ui.html

All Swagger Resources(groups) : http://localhost:<SERVICE-PORT>/swagger-resources
Swagger UI endpoint: http://localhost:<SERVICE-PORT>/swagger-ui.html
Swagger docs endpoint: http://localhost:<SERVICE-PORT>/v2/api-docs

## Monitor services configuration

- Dealership-service   : curl -s http://localhost:<SERVICE-PORT>/monitor/dealership-service | jq '.'
- Discovery-service.   : curl -s http://localhost:<SERVICE-PORT>/monitor/discovery-service | jq '.'
- Gateway-service.     : curl -s http://localhost:<SERVICE-PORT>/monitor/gateway-service | jq '.'
- Resource-service. : curl -s http://localhost:<SERVICE-PORT>/monitor/transaction-service | jq '.'
- Reservation-service.yml. : curl -s http://localhost:<SERVICE-PORT>/monitor/vehicle-service | jq '.'


### Resource service

To run locally:
  ```shell
  $ cd resource-service
  $ java -jar target/resource-service-0.0.1.BUILD-SNAPSHOT.jar
  ```

### Reservation service

To run locally:
```shell
cd reservation-service
java -jar target/reservation-service-0.0.1.BUILD-SNAPSHOT.jar
```

### Gateway Server

To run locally:
```shell
cd gateway-service
java -jar target/gateway-service-0.0.1.BUILD-SNAPSHOT.jar
```

# Application UI

## Home Page

![img.png](assert%2Fscreenshot%2Fimg.png)

## Resource Page

![img_1.png](assert%2Fscreenshot%2Fimg_1.png)

## Reservation Page

![img_2.png](assert%2Fscreenshot%2Fimg_2.png)

# Guides

The following guides illustrate how to use some features concretely:
* [Pattern: API Gateway / Backends for Frontends](https://microservices.io/patterns/apigateway.html)
* [Pattern: Microservice Architecture](https://microservices.io/patterns/microservices.html/)
* [Centralized Configuration](https://spring.io/guides/gs/centralized-configuration/)
* [Event-Driven Data Management for Microservices](https://www.nginx.com/blog/event-driven-data-management-microservices/)
* [Asynchronous microservices](http://eventuate.io/whyeventdriven.html)

## Reference

1.  [Microservice Architecture](https://microservices.io/patterns/microservices.html)
2.  [Spring Cloud Gateway](https://cloud.spring.io/spring-cloud-gateway/reference/html/)
3.  [Minishift– Cherara Reddag blog](rcherara.ca/installing-minishift-on-macos/)
4.  [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
5.  [Dive into Eureka – nobodyiam's blog](http://nobodyiam.com/2016/06/25/dive-into-eureka/)
6.  [About Spring cloud security OAuth2](http://blog.spring-cloud.io/blog/oauth-authorize.html)
7.  [Synthesis-Based Software Architecture Design](https://slideplayer.com/slide/1672922/)
8.  [OAuth 2.0 Login](https://docs.spring.io/spring-security/site/docs/5.2.x/reference/htmlsingle/#oauth2login)
9.  [OAuth 2.0 Resource Server](https://docs.spring.io/spring-security/site/docs/5.2.x/reference/htmlsingle/#oauth2resourceserver)
10. [Spring Cloud Security](https://cloud.spring.io/spring-cloud-static/spring-cloud-security/2.2.0.M3/reference/html/)
11. [Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_server.html)
12. [Spring Cloud](https://spring.io/projects/spring-cloud)
13. [The Twelve Factors](https://12factor.net)
14. [Maximize Observability of your CI/CD Pipeline with LogDNA](https://logdna.com/maximize-observability-of-your-ci-cd-pipeline-with-logdna/)
15. [Set Up A CI/CD Pipeline With Kubernetes ](https://www.linux.com/tutorials/set-cicd-pipeline-kubernetes-part-1-overview/)
16. [Database Internationalization](https://medium.com/walkin/database-internationalization-i18n-localization-l10n-design-patterns-94ff372375c6)
17. [The Exagonal Architecture](https://beyondxscratch.com/2017/08/19/decoupling-your-technical-code-from-your-business-logic-with-the-hexagonal-architecture-hexarch/)
# Help me to get the app famous!

## Got questions?

### Author
ABDERRAHIM AIT BOUNA.
